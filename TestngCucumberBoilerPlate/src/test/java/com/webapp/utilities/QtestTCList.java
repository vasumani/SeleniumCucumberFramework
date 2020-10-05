package com.webapp.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class QtestTCList {
	static Properties properties = new Properties();
	static String ProjectPath = new File("").getAbsolutePath();
	static String filePath = ProjectPath + "\\config\\TestCasesList.properties";
	static Properties config = null;

	public static void main(String[] args) throws IOException {
		config = loadConfigFile();

		PrintWriter writer = new PrintWriter(filePath);
		writer.print("");
		writer.close();
		try {
			recursiveModuleCall(config.getProperty("Test_Cases_RootFolder"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//saveProperties(properties);

	}


	public static String getNameOfTCId(String tc_id) {
		try {
			QTestIntegration.LoadTCIDsPropertyFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(tc_id.contains("TC-")) {
			tc_id = QTestIntegration.pidstoid.getProperty(tc_id);
		} else {
			tc_id=tc_id.split("_")[1];
		}
		API api = new API();
		config = loadConfigFile();
		String name="";
		try {
		 	 String tcResponse = api.get(config.getProperty("qTest_TestCaseURL")+"/"+tc_id.trim());
		 	 org.json.simple.JSONObject jo = (org.json.simple.JSONObject) new JSONParser().parse(tcResponse);
			 name = (String) jo.get("name");
		} catch(Exception e) {
			System.out.println(e.getMessage());

		}
		return name;
	}

	public static void recursiveModuleCall(String mId) throws Exception {
		API api = new API();

		String murl = addParamtersinURL("Modules", config.getProperty("qTest_getModulesURL"), mId);
		String modulesResponse = api.get(murl);
		JSONArray modules = new JSONArray(modulesResponse);
		int mSize = modules.length();
		System.out.println(mSize);
		if (mSize > 0) {
			for (int i = 0; i < modules.length(); i++) {
				JSONObject jsonobject = modules.getJSONObject(i);
				//System.out.println("Test Cases under Folder : " + jsonobject.getString("name"));
				getTCsWithinModule(mId);

				recursiveModuleCall(jsonobject.getInt("id") + "");
			}

		} else {
			getTCsWithinModule(mId);
		}

	}

	public static void getTCsWithinModule(String mId) throws Exception {
		API api = new API();
		String turl = addParamtersinURL("TestCases", config.getProperty("qTest_TestCaseURL"), mId);
		String testCasesResponse = api.get(turl);
		JSONArray jsonarray = new JSONArray(testCasesResponse);
		//System.out.println("Number of Test Cases : " + jsonarray.length());
		for (int i = 0; i < jsonarray.length(); i++) {
			JSONObject jsonobject = jsonarray.getJSONObject(i);
			//String name = jsonobject.getString("name");
			String pid = jsonobject.getString("pid");
			int id = jsonobject.getInt("id");
			properties.setProperty(pid, id+"");

			System.out.println(id+ " = "+ pid);
			saveProperties(properties);
		}
	}

	static void saveProperties(Properties p) throws IOException
    {
        FileOutputStream fr = new FileOutputStream(filePath);
        p.store(fr, "Properties");
        fr.close();
        //System.out.println("After saving properties: " + p);
    }


	public static String addParamtersinURL(String val, String endPointUrl, String mId) {
		Map<String, Object> params = new LinkedHashMap<>();
		if (val.equalsIgnoreCase("TestCases")) {
			params.put("?parentId", mId);
			params.put("&expandProps", "false");
			params.put("&size", "100000");
		} else if (val.equalsIgnoreCase("Modules")) {
			params.put("?parentId", mId);
			params.put("&expand", "descendants");
		}
		Iterator it = params.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			endPointUrl = endPointUrl + pair.getKey() + "=" + pair.getValue();
			it.remove();
		}
		return endPointUrl;
	}

	public static Properties loadConfigFile() {
		String file = "src/test/resources/config/config.properties";
		Properties properties = null;
		try {
			properties = new Properties();
			InputStream fis = new FileInputStream(file);
			properties.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
