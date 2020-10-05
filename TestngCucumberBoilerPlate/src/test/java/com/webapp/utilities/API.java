package com.webapp.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.webapp.executioner.ExecutionerClass;

/**
 * API.java
 * 
 * @Purpose API testing : API POST/GET Calls
 * 
 * @author Prabhuling Kalshetti
 * 
 */
public class API {
	EncryptFileData encryptFile = new EncryptFileData();

	@SuppressWarnings("resource")
	public String get(String endPointUrl) throws Exception
	{
		Properties config = buildAuthentication();
		String responseXml = callWebService(config, "GET", null,endPointUrl);
		return responseXml;
	}

	@SuppressWarnings("resource")
	public String postData(String data,String endPointUrl) throws Exception {
		Properties config = buildAuthentication();

		String responseXml = callWebService(config, "POST", data,endPointUrl);
		return responseXml;
	}

	private String callWebService(Properties config, String requestType,String data,String endPointUrl) {
		if (requestType == null || requestType.length() == 0) {
			requestType = "GET";
		}
		HttpsURLConnection connection = null;
		String responseXml = null;
		try {
			// Create connection
			URL url = new URL(endPointUrl);
			//URL url = new URL("https://heartland.qtestnet.com/api/v3/projects/43701/auto-test-logs?type=automation");
			System.out.println("url >>> " + url.toURI().toURL().toString());
			connection = (HttpsURLConnection) url.openConnection();

			connection.setHostnameVerifier(new HostnameVerifier() {
				public boolean verify(String host, SSLSession sess) {
					if (host.equals("localhost"))
						return true;
					else
						return false;
				}
			});

			connection.setConnectTimeout(10000); // Timeout 10 seconds
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setUseCaches(true);
			connection.setRequestMethod(requestType);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Content-Length", "1293");
			connection.setRequestProperty("Authorization",config.getProperty("Authorization"));
			connection.connect();

			if (data != null) {
				// Send request
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
						connection.getOutputStream());
				// **
				// Writing and flushing the data
				// *
				outputStreamWriter.write(data);
				outputStreamWriter.flush();
				outputStreamWriter.close();
			}
			// Get Response
			InputStream is = null;
			try {
				is = connection.getInputStream();
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("response code = "+ connection.getResponseCode());
				is = connection.getErrorStream();
			}
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader rd = new BufferedReader(isr);
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			// System.out.println("response toString "+response.toString());
			responseXml = response.toString();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		System.out.println(responseXml);
		return responseXml;
	}

	private Properties buildAuthentication() throws NoSuchAlgorithmException,
			Exception, InvalidKeySpecException, GeneralSecurityException,
			IOException, KeyManagementException {
		SSLContext ssl_ctx = SSLContext.getInstance("TLS");

		Properties config = new ExecutionerClass().setEnv();
		if (!Boolean.valueOf(config.getProperty("isFileDataEncrypted"))) {
			encryptFile.encryptConfigFileData("Password");
			encryptFile.serializeKeys();
		}
		config = new ExecutionerClass().setEnv();
		final String userName = config.getProperty("Username");
		EncryptFileData.secretKey = encryptFile.deserializeKey();

		final String password = encryptFile.decrypt(
				config.getProperty("Password"), EncryptFileData.secretKey);

		// Bypassing SSL Certification only for Demo at local environment, at GP
		// environment not needed
		TrustManager[] trust_mgr = get_trust_mgr();
		ssl_ctx.init(null, trust_mgr, new SecureRandom()); // random number
															// generator
		HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx
				.getSocketFactory());

		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password
						.toCharArray());
			}
		});
		return config;
	}

	public String parseJson(String data, String testCaseID, String ipop,
			String fileName) {

		String value = "";
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("Data/" + fileName));

			JSONObject lev1 = (JSONObject) obj;
			Object jObj = lev1.get(testCaseID);
			if (jObj instanceof Map) {
				Map map = (Map) jObj;

				if (ipop.equals("Input")) {
					Object in = map.get("Input");
					Map map1 = (Map) in;
					value = map1.get(data).toString();
				} else if (ipop.equals("Output")) {
					Object Out = map.get("Output");
					Map map1 = (Map) Out;
					value = map1.get(data).toString();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static TrustManager[] get_trust_mgr() {
		TrustManager[] certs = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String t) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String t) {
			}
		} };
		return certs;
	}

/*	public void encryptConfigFileData(String dataTOEncrypt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		EncryptFileData ecryptData = new EncryptFileData();
		String randomStringForKey = RandomStringUtils.randomAlphabetic(10)
				.toUpperCase();
		System.setProperty("password", randomStringForKey);
		String password = System.getProperty("password");
		if (password == null) {
			throw new IllegalArgumentException("Run with -Dpassword=<password>");
		}
		try {
			// The salt (probably) can be stored along with the encrypted data
			byte[] salt = new String(RandomStringUtils.randomNumeric(8))
					.getBytes();

			// Decreasing this speeds down startup time and can be useful during
			// testing, but it also makes it easier for brute force attackers
			int iterationCount = 40000;

			// Other values give me java.security.InvalidKeyException: Illegal
			// key size or default parameters
			int keyLength = 128;
			EncryptFileData.secretKey = ecryptData.createSecretKey(System
					.getProperty("password").toCharArray(), salt,
					iterationCount, keyLength);

			// File f = new File("src/test/resources/config/config.properties");
			FileInputStream in = new FileInputStream(
					"src/test/resources/config/config.properties");
			Properties props = new Properties();
			props.load(in);
			in.close();

			FileOutputStream out = new FileOutputStream(
					"src/test/resources/config/config.properties");

			// FileOutputStream outFile = new
			// FileOutputStream("src/test/resources/config/config.properties");
			// Properties prop = new runnerTest().setEnv();
			String originalPassword = props.getProperty("Password");
			System.out.println("Original password: " + originalPassword);
			String encryptedPassword = null;
			try {
				encryptedPassword = ecryptData.encrypt(originalPassword,
						EncryptFileData.secretKey);
			} catch (GeneralSecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			props.setProperty("Password", encryptedPassword);
			props.setProperty("isFileDataEncrypted", "true");
			System.out.println("Encrypted password: " + encryptedPassword);
			String decryptedPassword = null;
			try {
				decryptedPassword = ecryptData.decrypt(encryptedPassword,
						EncryptFileData.secretKey);
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Decrypted password: " + decryptedPassword);

			props.store(out, null);
			out.close();

		} catch (IOException io) {
			io.printStackTrace();
		}
	}
*/
}
