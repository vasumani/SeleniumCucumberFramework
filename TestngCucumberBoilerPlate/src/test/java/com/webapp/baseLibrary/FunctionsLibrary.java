package com.webapp.baseLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import com.thoughtworks.selenium.SeleniumException;
import com.webapp.executioner.ExecutionerClass;
//import com.webapp.executioner.ExecutionerClass1;
import com.webapp.stepDefinition.CommonStepDefinitions;
import com.webapp.utilities.EncryptFileData;
import com.webapp.utilities.GridReporter;

public class FunctionsLibrary 
{
/*	public static String strAbsolutepath = new File("").getAbsolutePath();
	public static String strVBScriptsPath = strAbsolutepath + "/VBScripts/";
	
	public String tc_id = null;
	public String scenarioName = null;

	public GridReporter reporter = CommonStepDefinitions.getReporter();
	public String strReportFilename = CommonStepDefinitions.strReportFilename;
	public static WebDriver driver = LaunchLogin.driver;
	public static ApplicationPropertiesInitializer applicationProperties = null;
	public static Properties object, browserLoad = null;
	static WebDriverWait wait = LaunchLogin.wait;
	private static Map<String, String> envVariableMap = new HashMap();
	public static Map<String, String> handlesWithId = new HashMap<>();
	String sysPropFromFile = "Config/Sys.properties";
	int getWaitTime = 0;

	public FunctionsLibrary() {

		// driver.manage().window().maximize();
		tc_id = CommonStepDefinitions.tc_id;
		scenarioName = CommonStepDefinitions.scenarioName;

		applicationProperties = new ApplicationPropertiesInitializer();
		String objectFileName = "src/test/resources/config/object.properties";
		object = loadPropertiesFile(objectFileName);
		getWaitTime = getFluentWaitTime();
		wait = new WebDriverWait(driver, getWaitTime);

	}*/

	
	public static String strAbsolutepath = new File("").getAbsolutePath();
	public static String strVBScriptsPath = strAbsolutepath + "/VBScripts/";

	static Properties object, browserLoad = null;
	static WebDriverWait wait;
	private static Map<String, String> envVariableMap = new HashMap();
	public static WebDriver driver = null;
	
	public static Map<String, String> handlesWithId = new HashMap<>();
	String sysPropFromFile = "Config/Sys.properties";
	int getWaitTime = 20;
	private int maxAttempt = 3;
	
	public FunctionsLibrary() 
	{
		if (driver == null) {
			Properties config;
			try {
				config = new ExecutionerClass().setEnv();
				initializeBrowser(config.getProperty("browser"));
				getWaitTime = getFluentWaitTime();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String objectFileName = "src/test/resources/config/object.properties";
		object = loadPropertiesFile(objectFileName);
		
	}

	public String tc_id = CommonStepDefinitions.tc_id;
	public String scenarioName = CommonStepDefinitions.scenarioName;
	public String dataFileName = CommonStepDefinitions.dataFileName;
	public String strReportFilename = "";
	static GridReporter reporter = CommonStepDefinitions.getReporter();

	public String getReportFileName() 
	{
		return strReportFilename;
	}
	
	
	public static void initializeBrowser(String browser) {
		browser = browser.toLowerCase().trim();
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			break;
		case "ie":
//			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//			capabilities.setCapability(CapabilityType.BROWSER_NAME, "ie");
//			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//			capabilities.setCapability("requireWindowFocus", true);
//			System.setProperty("webdriver.ie.driver", "./src/test/resources/drivers/IEDriverServer.exe");
//			driver = new InternetExplorerDriver(capabilities);
//			driver.manage().deleteAllCookies();
//			driver.manage().window().maximize();
			
			System.setProperty("webdriver.ie.driver", "./src/test/resources/drivers/IEDriverServer.exe");
			driver =new InternetExplorerDriver();
			
			break;

		default:
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			break;
		}
		wait = new WebDriverWait(driver, 10);
	}

	
	
	/**
	 * To load properties from application.properties file
	 * 
	 * @param propFilePath
	 * @return
	 */
	public Properties loadPropertiesFile(String propFilePath) {
		Properties properties = null;
		try {
			properties = new Properties();
			InputStream fis = new FileInputStream(propFilePath);
			properties.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public String[] readProperties(String locatorKey) {
		String[] locatorMethodName = null;
		try {
			locatorKey = locatorKey.replace(" ", "").replace(":", "");
			String objectValue = object.getProperty(locatorKey);
			locatorMethodName = objectValue.split("#");
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Read Property File and Fetch Locator Key " + locatorKey,
					locatorKey, e.getMessage(), "Fail", strReportFilename);
		}
		return locatorMethodName;
	}

	public WebElement getWebElement(String locatorKey) {
		WebElement element = null;
		String locatorMethod = null;
		String locatorValue = null;
		try {
			String[] locatorMethodName = readProperties(locatorKey);
			locatorMethod = locatorMethodName[0];
			locatorValue = locatorMethodName[1];
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Fetch LocatorMethod and LocatorValue for " + locatorKey,
					"LocatorMethod: " + locatorMethod + ";" + "LocatorValue: " + locatorValue, e.getMessage(), "Fail",
					strReportFilename);
		}
		try {
			switch (locatorMethod.toLowerCase().trim()) {
			case "id":
				element = driver.findElement(By.id(locatorValue));
				break;
			case "name":
				element = driver.findElement(By.name(locatorValue));
				break;
			case "class":
				element = driver.findElement(By.className(locatorValue));
				break;
			case "linkText":
				element = driver.findElement(By.linkText(locatorValue));
				break;
			case "partiallinkText":
				element = driver.findElement(By.partialLinkText(locatorValue));
				break;
			case "tagname":
				element = driver.findElement(By.tagName(locatorValue));
				break;
			case "css":
				element = driver.findElement(By.cssSelector(locatorValue));
				break;
			case "xpath":
				element = driver.findElement(By.xpath(locatorValue));
				break;

			default:
				break;
			}
		} catch (Exception e) {
			System.out.println(java.time.LocalDateTime.now()+"-:: "+"Ensuring the "+locatorKey+" Element is not present on the webpage ....!!");
			
			reporter.writeStepResult(tc_id, scenarioName,
					"Find Element By " + locatorMethod + " with Value " + locatorValue + " in the webpage",
					"The Locator Method and Value should be available in the page", e.getMessage(), "Fail",
					strReportFilename);
		}
		return element;
	}

	public void waitForElementUsingPresence(String locatorKey) {
		WebElement element = null;
		String locatorMethod = null;
		String locatorValue = null;
		try {
			String[] locatorMethodName = readProperties(locatorKey);
			locatorMethod = locatorMethodName[0];
			locatorValue = locatorMethodName[1];
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Fetch LocatorMethod and LocatorValue for " + locatorKey,
					"LocatorMethod: " + locatorMethod + ";" + "LocatorValue: " + locatorValue, e.getMessage(), "Fail",
					strReportFilename);
		}
		try {
			switch (locatorMethod.toLowerCase().trim()) {
			case "id":
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
				break;
			case "name":
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locatorValue)));
				break;
			case "class":
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locatorValue)));
				break;
			case "linkText":
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locatorValue)));
				break;
			case "partiallinkText":
				wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(locatorValue)));
				break;
			case "tagname":
				wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locatorValue)));
				break;
			case "css":
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locatorValue)));
				break;
			case "xpath":
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
				break;

			default:
				break;
			}
		} catch (Exception e) {
			System.out.println(java.time.LocalDateTime.now()+"-:: "+"Ensuring the "+locatorKey+" Element is not present on the webpage ....!!");
			
			reporter.writeStepResult(tc_id, scenarioName,
					"Find Element By " + locatorMethod + " with Value " + locatorValue + " in the webpage",
					"The Locator Method and Value should be available in the page", e.getMessage(), "Fail",
					strReportFilename);
		}
	}

	public void waitForTextToBePresentInElement(String locatorKey, String strExpectedText) {
		try {
			WebElement element = getElementFluentWait(locatorKey);

			wait.until(ExpectedConditions.textToBePresentInElement(element, strExpectedText));
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Wait for the Text to be Present in the element",
					strExpectedText, e.getMessage(), "Fail", strReportFilename);
		}
	}

	public WebElement getWebElementWithWait(String locatorKey) throws InterruptedException {
		
		WebElement element = null;
		String locatorMethod = null;
		String locatorValue = null;

		try {
			String[] locatorMethodName = readProperties(locatorKey);
			locatorMethod = locatorMethodName[0];
			locatorValue = locatorMethodName[1];
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Fetch LocatorMethod and LocatorValue for " + locatorKey,
					"LocatorMethod: " + locatorMethod + ";" + "LocatorValue: " + locatorValue, e.getMessage(), "Fail",
					strReportFilename);
		}
		try {
			switch (locatorMethod.toLowerCase().trim()) {
			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
				element = driver.findElement(By.id((locatorValue)));
				break;
			case "name":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
				element = driver.findElement(By.name((locatorValue)));
				break;
			case "class":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
				element = driver.findElement(By.className((locatorValue)));
				break;
			case "linkText":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
				element = driver.findElement(By.linkText((locatorValue)));
				break;
			case "partiallinkText":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
				element = driver.findElement(By.partialLinkText((locatorValue)));
				break;
			case "tagname":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
				element = driver.findElement(By.tagName((locatorValue)));
				break;
			case "css":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
				element = driver.findElement(By.cssSelector((locatorValue)));
				break;
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
				element = driver.findElement(By.xpath((locatorValue)));
				break;

			default:
				break;
			}
		} catch (NoSuchWindowException e) {
			System.out.println("Window Already closed and elment is not visible further ...");
		} catch (Exception e) {
			System.out.println(java.time.LocalDateTime.now()+"-:: "+"====================== :: Handled Full Stack Trace Information :: ==========================");
			System.out.println(java.time.LocalDateTime.now()+"-:: "+ExceptionUtils.getFullStackTrace(e));
			System.out.println(java.time.LocalDateTime.now()+"-:: "+"====================== :: Handled Full Stack Trace Information :: ==========================");
			
			//System.out.println(java.time.LocalDateTime.now()+"-:: "+"Ensuring the "+locatorKey+" Element is not present on the webpage ....!!");
			
			reporter.writeStepResult(tc_id, scenarioName,
					"Find Element By " + locatorMethod + " with Value " + locatorValue + " in the webpage",
					"The Locator Method and Value should be available in the page", e.getMessage(), "Fail",
					strReportFilename);
		}
		return element;
	}

	public List<WebElement> getWebElements(String locatorKey) {
		List<WebElement> element = null;
		String locatorMethod = null;
		String locatorValue = null;
		try {
			String[] locatorMethodName = readProperties(locatorKey);
			locatorMethod = locatorMethodName[0];
			locatorValue = locatorMethodName[1];
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Fetch LocatorMethod and LocatorValue for " + locatorKey,
					"LocatorMethod: " + locatorMethod + ";" + "LocatorValue: " + locatorValue, e.getMessage(), "Fail",
					strReportFilename);
		}
		try {
			switch (locatorMethod) {
			case "id":
				element = driver.findElements(By.id((locatorValue)));
				break;
			case "name":
				element = driver.findElements(By.name((locatorValue)));
				break;
			case "class":
				element = driver.findElements(By.className((locatorValue)));
				break;
			case "linkText":
				element = driver.findElements(By.linkText((locatorValue)));
				break;
			case "partiallinkText":
				element = driver.findElements(By.partialLinkText((locatorValue)));
				break;
			case "tagname":
				element = driver.findElements(By.tagName((locatorValue)));
				break;
			case "css":
				element = driver.findElements(By.cssSelector((locatorValue)));
				break;
			case "xpath":
				element = driver.findElements(By.xpath((locatorValue)));
				break;

			default:
				break;
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName,
					"Find Element By " + locatorMethod + " with Value " + locatorValue + " in the webpage",
					"The Locator Method and Value should be available in the page", e.getMessage(), "Fail",
					strReportFilename);
		}
		return element;
	}

	public void waitForElementUsingVisibility(String locatorKey) {
		WebElement element = null;
		String locatorMethod = null;
		String locatorValue = null;
		try {
			String[] locatorMethodName = readProperties(locatorKey);
			locatorMethod = locatorMethodName[0];
			locatorValue = locatorMethodName[1];
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Fetch LocatorMethod and LocatorValue for " + locatorKey,
					"LocatorMethod: " + locatorMethod + ";" + "LocatorValue: " + locatorValue, e.getMessage(), "Fail",
					strReportFilename);
		}
		try {
			switch (locatorMethod) {
			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
				break;
			case "name":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
				break;
			case "class":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
				break;
			case "linkText":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
				break;
			case "partiallinkText":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
				break;
			case "tagname":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
				break;
			case "css":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
				break;
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
				break;

			default:
				break;
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName,
					"Find Element By " + locatorMethod + " with Value " + locatorValue + " in the webpage",
					"The Locator Method and Value should be available in the page", e.getMessage(), "Fail",
					strReportFilename);
		}
	}

	/**
	 * 
	 * @param locatorMethod
	 * @param locatorValue
	 */
	public WebElement getWebElementWithWait(String locatorMethod, String locatorValue) {
		WebElement element = null;

		try {
			switch (locatorMethod) {
			case "id":
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
				break;
			case "name":
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locatorValue)));
				break;
			case "class":
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locatorValue)));
				break;
			case "linkText":
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locatorValue)));
				break;
			case "partiallinkText":
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(locatorValue)));
				break;
			case "tagname":
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locatorValue)));
				break;
			case "css":
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locatorValue)));
				break;
			case "xpath":
				element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
				break;

			default:
				break;
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName,
					"Find Element By " + locatorMethod + " with Value " + locatorValue + " in the webpage",
					"The Locator Method and Value should be available in the page", e.getMessage(), "Fail",
					strReportFilename);
		}

		return element;
	}

	/**
	 * Enter the text
	 */
	public void clearText(String locatorKey) {
		try {
			WebElement element = getElementFluentWait(locatorKey);
			waitForElementUsingPresence(locatorKey);
			element.clear();
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Clear the text value in text field", "Clear the text value",
					e.getMessage(), "Fail", strReportFilename);
		}
	}
	public void clearText(WebElement locatorKey) {
		try {
			WebElement element = locatorKey;
			//waitForElementUsingPresence(locatorKey);
			element.clear();
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Clear the text value in text field", "Clear the text value",
					e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * Enter the text
	 */
	public void enterText(String locatorKey, String data) {
		try {
			WebElement element = getElementFluentWait(locatorKey);
			waitForElementUsingPresence(locatorKey);
			//element.clear();
			//element.sendKeys(data);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid red'",  element);
			//element.click();
			element.clear();
			element.sendKeys(data);
			
			reporter.writeStepResult(tc_id, scenarioName, "Enter Value in text field", data,
					"Value " + data + " entered successfully", "Pass", strReportFilename);
			js.executeScript("arguments[0].style.border='2px solid grey'", element);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Enter Value in text field", data,
					"Unable to enter value " + data, "Fail", strReportFilename);
		}
	}
	public void enterText(WebElement locatorKey, String data) {
		try {
			WebElement element = locatorKey;
			//element.clear();
			//element.sendKeys(data);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid red'",  element);
			//element.click();
			element.clear();
			element.sendKeys(data);
			
			reporter.writeStepResult(tc_id, scenarioName, "Enter Value in text field", data,
					"Value " + data + " entered successfully", "Pass", strReportFilename);
			js.executeScript("arguments[0].style.border='2px solid grey'", element);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Enter Value in text field", data,
					"Unable to enter value " + data, "Fail", strReportFilename);
		}
	}
	
	
	public void verifyElementAttribute(String locatorKey, String strExpectedText, String attribute) {
		String strActualText = null;
		WebElement element = null;
		try {
			element = getElementFluentWait(locatorKey);
			if (verifyElementPresent(locatorKey))
				strActualText = element.getAttribute("value");
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify element is present on the page", strExpectedText,
					e.getMessage(), "Fail", strReportFilename);
		}
		System.out.println("***" + strExpectedText + "***");
		System.out.println("***" + strActualText + "***");
		if (strActualText.equals(strExpectedText))
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Pass", strReportFilename);
		else
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Fail", strReportFilename);
	}
	public void enterTextForOUConfig(String locatorKey, String data) {
		try {
			WebElement element = getWebElementWithWait(locatorKey);
			waitForElementUsingPresence(locatorKey);
			//element.clear();
			//element.sendKeys(data);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			element.click();
			element.sendKeys(data);
			
			reporter.writeStepResult(tc_id, scenarioName, "Enter Value in text field", data,
					"Value " + data + " entered successfully", "Pass", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Enter Value in text field", data,
					"Unable to enter value " + data, "Fail", strReportFilename);
		}
	}
	/**
	 * Enter the text and Enter Tab
	 */
	public void enterTextwithTab(String locatorKey, String data) {
		try {
			WebElement element = getWebElement(locatorKey);
			waitForElementUsingPresence(locatorKey);
			element.sendKeys(data, Keys.TAB);
			reporter.writeStepResult(tc_id, scenarioName, "Enter Value in text field", data,
					"Value " + data + " entered successfully", "Pass", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Enter Value in text field", data,
					"Unable to enter value " + data, "Fail", strReportFilename);
		}
	}

	/**
	 * Click an element
	 * 
	 * @throws InterruptedException
	 */
	public void clickAnElement(String locatorKey, String strButtonLabel) {

		WebElement element = null;
		try {
			if (object.getProperty(locatorKey) != null && object.getProperty(locatorKey).contains("#")) {
				element = getElementFluentWait(locatorKey);
			} else {
				element = getElementFluentWait(locatorKey, strButtonLabel);
			}
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'",  element);
			element.click();
			
			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
					"Clicked " + strButtonLabel + " button successfully", "Pass", strReportFilename);
			
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='2px solid grey'", element);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
//			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
//					"Not able to click on  button " + strButtonLabel, "Fail", strReportFilename);
//			try {
//				JavascriptExecutor jse = (JavascriptExecutor) driver;
//				jse.executeScript("arguments[0].click();", element);
//
//			} catch (Exception e1) {
//				reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
//						"Not able to click on  button " + strButtonLabel, "Fail", strReportFilename);
//
//			}

		}
		
	}
	public void clickAnElement(WebElement WebElement, String strButtonLabel) {

		//WebElement element = null;
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(WebElement));
			
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'",  WebElement);
			WebElement.click();
			
			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
					"Clicked " + strButtonLabel + " button successfully", "Pass", strReportFilename);
			
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='2px solid grey'", WebElement);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
//			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
//					"Not able to click on  button " + strButtonLabel, "Fail", strReportFilename);
//			try {
//				JavascriptExecutor jse = (JavascriptExecutor) driver;
//				jse.executeScript("arguments[0].click();", element);
//
//			} catch (Exception e1) {
//				reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
//						"Not able to click on  button " + strButtonLabel, "Fail", strReportFilename);
//
//			}

		}
		
	}
	
	public void clickAnElementForOUConfig(String locatorKey, String strButtonLabel) {

		WebElement element = null;
		try {
			if (object.getProperty(locatorKey) != null && object.getProperty(locatorKey).contains("#")) {
				element = getElementFluentWait(locatorKey);
			} else {
				element = getElementFluentWait(locatorKey, strButtonLabel);
			}
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			//((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'",  element);
			element.click();
			
			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
					"Clicked " + strButtonLabel + " button successfully", "Pass", strReportFilename);
			
			//((JavascriptExecutor)driver).executeScript("arguments[0].style.border='2px solid grey'", element);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
//			try {
//				JavascriptExecutor jse = (JavascriptExecutor) driver;
//				jse.executeScript("arguments[0].click();", element);
//
//			} catch (Exception e1) {
//				reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
//						"Not able to click on  button " + strButtonLabel, "Fail", strReportFilename);
//
//			}

		}
		
	}
	/**
	 * Accept alert without Text
	 */
	public void acceptAlertWithoutText(String action) {
		
		Alert alert = null;
		String strActualText = null;
		try {
			alert = FunctionsLibrary.driver.switchTo().alert();
			strActualText = alert.getText();
			System.out.println(strActualText);
			if (action.equalsIgnoreCase("accept")) {
					System.out.println("Expected alert text is equal to actual text");
					alert.accept();
					reporter.writeStepResult(tc_id, scenarioName, "Verify alert pop up text",
							"Expected: Alert", "Alert present", "Pass",
							strReportFilename);
				} 
			if (action.equalsIgnoreCase("dismiss")) {
					alert.dismiss();
					reporter.writeStepResult(tc_id, scenarioName, "Verify alert pop up text",
							"Expected: Alert Dismiss", "Dismissed alert present", "Pass",
							strReportFilename);
				}
		
			}catch (Exception e1) {
				reporter.writeStepResult(tc_id, scenarioName, "Verify alert pop up text", "Expected: Alert" ,
						"Expected alert is not present ", "Fail", strReportFilename);
			}
		
	}
	/**
	 * Handle alert
	 */
	public void handleAlert(String action, String strExpectedText) {
		Alert alert = null;
		String strActualText = null;
		try {
			alert = FunctionsLibrary.driver.switchTo().alert();
			strActualText = alert.getText();
			System.out.println(strActualText);
			if (action.equalsIgnoreCase("accept")) {
				if (strActualText.equals(strExpectedText)) {
					System.out.println("Expected alert text is equal to actual text");
					alert.accept();
					reporter.writeStepResult(tc_id, scenarioName, "Verify alert pop up text",
							"Expected: " + strExpectedText, "the " + strExpectedText + " alert present", "Pass",
							strReportFilename);
				} else {
					alert.accept();
					reporter.writeStepResult(tc_id, scenarioName, "Verify alert pop up text",
							"Expected: " + strExpectedText,
							"Expected alert text is not present (Actual: " + strActualText + ")", "Fail",
							strReportFilename);
				}
			}
			if (action.equalsIgnoreCase("dismiss")) {
				if (strActualText.equals(strExpectedText)) {
					alert.dismiss();
					reporter.writeStepResult(tc_id, scenarioName, "Verify alert pop up text",
							"Expected: " + strExpectedText, "the " + strExpectedText + " alert present", "Pass",
							strReportFilename);
				} else {
					alert.dismiss();
					reporter.writeStepResult(tc_id, scenarioName, "Verify alert pop up text",
							"Expected: " + strExpectedText,
							"Expected alert text is not present (Actual: " + strActualText + ")", "Fail",
							strReportFilename);
				}
			}
		} catch (Exception e1) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify alert pop up text", "Expected: " + strExpectedText,
					"Expected alert text is not present (Actual: " + strActualText + ")", "Fail", strReportFilename);
			System.out.println("Exception occurred -- " + e1.getMessage());
			System.out.println();
		}
	}
	
	/**
	 * get the text
	 */
	public String getText(String locatorKey) 
	{
		WebElement element=getWebElement(locatorKey);
		try {
			element.getText();
			reporter.writeStepResult(tc_id, scenarioName, "Get the text from the web page",
					"User should be able to get text from web page",
					"The text got from webpage is " + element.getText(), "Pass", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Get the text from the web page",
					"User should be able to get text from web page",
					"Unable to get the text from the web page" + e.getMessage(), "Fail", strReportFilename);
		}
		return element.getText();
	}

	
	/**
	 * Click an element and Press Enter
	 */
	public void clickAndEnterAnElement(String locatorKey, String strButtonLabel) {
		try {
			WebElement element = getElementFluentWait(locatorKey);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			element.sendKeys(Keys.ENTER);
			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
					"Clicked " + strButtonLabel + " button successfully", "Pass", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
					"Not able to click on  button " + strButtonLabel, "Fail", strReportFilename);
		}
	}

	/**
	 * Click an element using JavascriptExector with Handling Alert
	 */
	public void clickAnElementAndHandleAlert(String condition, String locatorKey, String strButtonLabel) {
		try {
			WebElement element = getElementFluentWait(locatorKey);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();

			switchTOAlert(condition);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
					"Not able to click on  button " + strButtonLabel, "Fail", strReportFilename);
		}
	}

	/**
	 * Click an element using JavascriptExector
	 */
	public void clickAnElementUsingJavaScript(String locatorKey, String strButtonLabel) {
		try {
			WebElement element = getElementFluentWait(locatorKey);
			wait.until(ExpectedConditions.elementToBeClickable(element));

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", element);

			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
					"Clicked " + strButtonLabel + " button successfully", "Pass", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
					"Not able to click on  button " + strButtonLabel, "Fail", strReportFilename);
		}
	}

	/**
	 * Scroll to an Element using JavascriptExector
	 */
	public void scrollToAnElementUsingJavaScript(String locatorKey) {
		try {
			WebElement element = getElementFluentWait(locatorKey);
			waitForElementUsingPresence(locatorKey);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Scroll to an Element", locatorKey,
					"Not able to Scroll to an element" + e.getMessage(), "Fail", strReportFilename);
		}
	}

	public void scrollToAnElementUsingJavaScript(String locatorKey, String strExpectedText) {
		try {
			WebElement element = getWebElementWithWait(locatorKey);
			waitForTextToBePresentInElement(locatorKey, strExpectedText);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Scroll to an Element", locatorKey,
					"Not able to Scroll to an element" + e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * Switch to the frame
	 */
	public void switchToFrame(String locatorKey) {
		WebElement frame = getElementFluentWait(locatorKey);
		try {
			waitForElementUsingPresence(locatorKey);
			driver.switchTo().frame(frame);
			reporter.writeStepResult(tc_id, scenarioName, "Select Frame : " + locatorKey, locatorKey,
					"Frame " + locatorKey + " selected successfully", "Pass", strReportFilename);
		} catch (WebDriverException web1) {
			reporter.writeStepResult(tc_id, scenarioName, "Select Frame : " + locatorKey, "" + locatorKey,
					"Unable to select frame due to Webdriver exception", "Fail", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Select Frame : " + locatorKey, "" + locatorKey,
					"Not able to select frame " + locatorKey, "Fail", strReportFilename);
		}
	}
public void acceptAlertVerifyText(String action,String ExpectedText) {
		
		Alert alert = null;
		String strActualText = null;
		try {
			alert = FunctionsLibrary.driver.switchTo().alert();
			strActualText = alert.getText();
			System.out.println(strActualText);
			if (action.equalsIgnoreCase("accept")&&strActualText.contains(ExpectedText)) {
					System.out.println("Expected alert text contains actual text");
					alert.accept();
					reporter.writeStepResult(tc_id, scenarioName, "Verify alert pop up text",
							"Expected: Alert Text present", ExpectedText , "Pass",
							strReportFilename);
				} 
			if (action.equalsIgnoreCase("dismiss")) {
					alert.dismiss();
					reporter.writeStepResult(tc_id, scenarioName, "Verify alert pop up text",
							"Expected: Alert Dismiss", "Dismissed alert present", "Pass",
							strReportFilename);
				}
		
			}catch (Exception e1) {
				reporter.writeStepResult(tc_id, scenarioName, "Verify alert pop up text", "Expected: Alert" ,
						"Expected alert is not present ", "Fail", strReportFilename);
			}
		
	}
	/**
	 * Switch to default frame
	 */
	public void deSelectFrame() {
		try {
			driver.switchTo().defaultContent();
			reporter.writeStepResult(tc_id, scenarioName, "DeSelect Frame", "Frame should be deselected",
					"Frame deselected successfully", "Pass", strReportFilename);
		} catch (SeleniumException web1) {
			reporter.writeStepResult(tc_id, scenarioName, "Select Main page", "Frame should be deselected",
					web1.getMessage(), "Fail", strReportFilename);
		} catch (Exception e1) {
			reporter.writeStepResult(tc_id, scenarioName, "Select Main page", "Frame should be deselected",
					"Not able to select Main page", "Fail", strReportFilename);
		}
	}

	/**
	 * Verify element is present
	 * 
	 * @throws InterruptedException
	 */
	public boolean verifyElementPresent(String locatorKey) throws InterruptedException {
		WebElement element = getWebElementWithWait(locatorKey);

		if (element.isDisplayed())
			return true;
		else
			return false;
	}

	/**
	 * Verify element is present using element
	 */
	public boolean verifyElementPresent(WebElement element) {
		if (element.isDisplayed())
			return true;
		else
			return false;
	}

	/**
	 * Verify element is present
	 */
	public void verifyElementPresentWithReport(String locatorKey) {
		try {
			WebElement element = getWebElement(locatorKey);
			String text=element.getText().trim();
			boolean exists;
			if (element.isDisplayed())
				exists = true;
			
			else
				exists = false;

			if (exists)
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + locatorKey + " is present on the page",
						locatorKey, "The element " + text + " is present on the page", "Pass", strReportFilename);
			else
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + locatorKey + " is present on the page",
						locatorKey, "The element " + locatorKey + " is not present on the page", "Fail",
						strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify " + locatorKey + " is present on the page",
					locatorKey, e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * Verify element text is present
	 */
	public void verifyValuePresentInTheTextBox(String Label, String locatorKey, String strExpectedText) {
		String strActualText = null;
		WebElement element = null;
		try {
			element = getElementFluentWait(locatorKey);
			waitForElementUsingVisibility(locatorKey);

			if (verifyElementPresent(locatorKey))
				strActualText = element.getAttribute("value").trim();
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify " + Label + " value present in the TextBox",
					strExpectedText, e.getMessage(), "Fail", strReportFilename);
		}
		if (strActualText.equals(strExpectedText))
			reporter.writeStepResult(tc_id, scenarioName, "Verify " + Label + " value present in the TextBox",
					strExpectedText, strActualText, "Pass", strReportFilename);
		else
			reporter.writeStepResult(tc_id, scenarioName, "Verify " + Label + " value present in the TextBox",
					strExpectedText, strActualText, "Fail", strReportFilename);
	}

	/**
	 * Verify element is not present
	 */
	public void verifyElementNotPresent(String label,String locatorKey) {
		try {
			//WebElement element = getWebElementWithWait(locatorKey);
			
			WebElement element = null;
			String locatorMethod = null;
			String locatorValue = null;

				String[] locatorMethodName = readProperties(locatorKey);
				locatorMethod = locatorMethodName[0];
				locatorValue = locatorMethodName[1];
				boolean exists = false;
				switch (locatorMethod.toLowerCase().trim()) {
				case "id":
					if(driver.findElements(By.id(locatorValue)).size()!= 0) {
						exists = true;
					}
					break;
				case "name":
					if(driver.findElements(By.name(locatorValue)).size()!= 0) {
						exists = true;
					}
					break;
				case "class":
					if(driver.findElements(By.className(locatorValue)).size()!= 0) {
						exists = true;
					}
					break;
				case "linkText":
					if(driver.findElements(By.linkText(locatorValue)).size()!= 0) {
						exists = true;
					}
					break;
				case "partiallinkText":
					if(driver.findElements(By.partialLinkText(locatorValue)).size()!= 0) {
						exists = true;
					}
					break;
				case "tagname":
					if(driver.findElements(By.tagName(locatorValue)).size()!= 0) {
						exists = true;
					}
					break;
				case "css":
					if(driver.findElements(By.cssSelector(locatorValue)).size()!= 0) {
						exists = true;
					}
					break;
				case "xpath":
					if(driver.findElements(By.xpath(locatorValue)).size()!= 0) {
						exists = true;
					}
					break;

				}
				
			if (!exists)
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + label + " is not present on the page", locatorKey, "The element " + label + " is not present on the page", "Pass", strReportFilename);
			else
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + label + " is not present on the page", locatorKey, "The element " + label + " is present on the page", "Fail", strReportFilename);
		
			}catch (Exception e) {
				System.out.println(java.time.LocalDateTime.now()+"-:: "+"====================== :: Handled Full Stack Trace Information :: ==========================");
				System.out.println(java.time.LocalDateTime.now()+"-:: "+ExceptionUtils.getFullStackTrace(e));
				System.out.println(java.time.LocalDateTime.now()+"-:: "+"====================== :: Handled Full Stack Trace Information :: ==========================");
				
					reporter.writeStepResult(tc_id, scenarioName, "Verify " + label + " is not present on the page", locatorKey, e.getMessage(), "Fail", strReportFilename);
		
				}
	}
	
	public void verifyElementsNotPresent(String label, String locatorKey) {
		List<WebElement> element = null;
		try {
			element=getWebElements(locatorKey);
			boolean exists;
			if (!(element.size()==0))
				exists = true;
			else
				exists = false;

			if (!exists)
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + label + " is not present on the page", locatorKey, "The element " + label + " is not present on the page", "Pass", strReportFilename);
			else
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + label + " is not present on the page", locatorKey, "The element " + label + " is present on the page", "Fail", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify " + label + " is not present on the page", locatorKey, e.getMessage(), "Fail", strReportFilename);
		}
	}
	/**
	 * Verify element text is present
	 */
	public void verifyElementTextPresent(String locatorKey, String strExpectedText) {
		String strActualText = null;
		WebElement element = null;
		try {
			element = getElementFluentWait(locatorKey);
			if (verifyElementPresent(locatorKey))
				strActualText = element.getText().trim();
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify element is present on the page", strExpectedText,
					e.getMessage(), "Fail", strReportFilename);
		}
		System.out.println("***" + strExpectedText + "***");
		System.out.println("***" + strActualText + "***");
		if (strActualText.equals(strExpectedText))
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Pass", strReportFilename);
		else
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Fail", strReportFilename);
	}
	/**
	 * Verify column values
	 */
	public void assignId(WebElement element, String newId, WebDriver driver) {

		((JavascriptExecutor)driver).executeScript("arguments[0].id=arguments[1]",element, newId);
	}
	
	public void verifyColumnValues( String strData){

		String [] arrDataDetails = strData.split("@@");
		String strTableID = arrDataDetails[0];
		String strTableHeader = arrDataDetails[1];
		String strColumnValues = arrDataDetails[2];
		String strResult = null;
		boolean isTablePresent = true;
		WebElement webelement = null;
		String strActualText = null;

		String strTableIdFlag = "False";
		try {
			String strScript = null;

			if(strTableID.contains("//")) {
				if(FunctionsLibrary.driver.findElements(By.xpath(strTableID)).size()>0){
					isTablePresent = true;
					webelement =FunctionsLibrary.driver.findElement(By.xpath(strTableID));
					try{
						assignId(webelement, "AssignedTableId", FunctionsLibrary.driver);
					}catch(Exception e1){
						assignId(webelement, "AssignedTableId", FunctionsLibrary.driver);
					}
					strTableIdFlag = "True";
				}else{
					isTablePresent = false;
				}
			}
			String[] arrTableHeaders = strTableHeader.split(";");
			String[] arrColumnValues = strColumnValues.split(";");
			System.out.println("Column Value =" + arrColumnValues[0]);

			boolean isNumeric = false;
			String strNumericFlag = "False";
			for (int i = 0; i < arrTableHeaders.length; i++) {
				Pattern p = Pattern.compile("([0-99]*)");
				Matcher m = p.matcher(arrTableHeaders[i]);
				isNumeric = m.matches();
			}
			if (isNumeric) {
				strNumericFlag = "True";
			}

			strScript =   	 "var actualColumnData='';"
					+ "function Trim(s){return s.replace(/^\\s\\s*/, '').replace(/\\s\\s*$/, '');}"
					+ "var counter = 0;"
					+ "var tempResult = 'Fail';"
					+ "var Result = 'Fail';"
					+ "var isHeaderPresent = 'False';"
					+ "var isPresent = 'False';"
					+ "var tableHeaderName = '';"
					+ "var actualColumnNumber = 0;"
					+ "var columnNumericValue = 'True';"
					+ "var objTable;"
					+ "var numericFlag = \""+ strNumericFlag + "\";"
					+ "var tableFlag = \""+ strTableIdFlag + "\";"
					+ "var tableName = \""+ strTableID + "\";"
					+ "var expectedRowData = \""+ strColumnValues + "\";"
					+ "var arrExpectedRowData = expectedRowData.split(';');"
					+ "var columnNames = \""+ strTableHeader + "\";"
					+ "var arrColumnNames = columnNames.split(';');"
					+ "var expectedRow = 0;"
					+ "var isMatching = 'False';"	
					+ "try"
					+ "{" 

                                      + "if(tableFlag=='True')"
                                      + "{"
                                      +           "objTable = document.getElementById('AssignedTableId');"
                                      + "}"
                                      + "else"
                                      + "{"
                                      +           "objTable = document.getElementById(tableName);"
                                      + "}"
                                      + "if(objTable!=null)"
                                      + "{"
                                      //   +           "alert('Table--' + objTable);"
                                      +           "var objRows = objTable.rows;"
                                      +           "var totalRows = objRows.length;"
                                      //    +           "alert('Total rows --' + totalRows);"+
                                      +           "var tableHeaderRow = objRows[0];"
                                      //    +           "alert('Table header row object--' + tableHeaderRow);"+
                                      +           "var tableHeaderColumns = tableHeaderRow.cells;"
                                      // +           "alert('Header columns--' + tableHeaderColumns);"
                                      +           "for(var l=0; l<arrColumnNames.length; l++)"
                                      +           "{"
                                      +                 "if(\""+ strNumericFlag + "\"=='False')"
                                      +                 "{"
                                      +                       "for(var m=0; m<tableHeaderColumns.length; m++)"
                                      +                       "{"
                                      // +							"if(m==3){return tableHeaderColumns[m].textContent;}"
                                      //+                             "alert('Input Column name--' + arrColumnNames[l]);"
                                      //+                             "alert('Actual Column name--' + tableHeaderColumns[m].textContent);"
                                      //+                             "if(arrColumnNames[l]==(Trim(tableHeaderColumns[m].textContent)))"
                                      +								"tableHeaderName = tableHeaderColumns[m].textContent;"
                                      // 	  +								"alert('Actual Column name--' + tableHeaderName);"
                                      +								"if(tableHeaderName==null)"
                                      +								"{"
                                      //	  +									"alert('Table header is null');"
                                      +									"tableHeaderName = tableHeaderColumns[m].innerText;"
                                      //	  +									"alert('Actual Column name--' + tableHeaderName);"
                                      +								"}"
                                      //  +								"alert('Column Present --' + arrColumnNames[l] + '==' + tableHeaderColumns[m].textContent);"
                                      +                             "if(arrColumnNames[l]==(Trim(tableHeaderName)))"
                                      +                             "{"
                                      +                                   "isHeaderPresent = 'True';"
                                      //   +                                   "alert('Column Present --' + arrColumnNames[l] + '==' + tableHeaderColumns[m].textContent);"
                                      +                                   "actualColumnNumber = m;"
                                      //   +									  "alert('Actuatl Column number--' + actualColumnNumber);"	
                                      //    +									  "alert('Value of m--' + m);"
                                      +                                   "break;"
                                      +                             "}"
                                      +                             "else"
                                      +                             "{"
                                      //  +										"alert('In ELSE');"
                                      +                                   "isHeaderPresent='False';"
                                      +                             "}"
                                      +                       "}"
                                      +                 "}"
                                      +                 "else"
                                      +                 "{"
                                      +                       "isHeaderPresent = 'True';"
                                      //           +                       "alert('Column Present --' + arrColumnNames[l] + '==' + tableHeaderColumns[m].innerText);"
                                      +                       "actualColumnNumber = parseInt(arrColumnNames[l] - 1);"
                                      //  +                       "alert('Column Number --' + actualColumnNumber);"
                                      +                 "}"
                                      //    +                 "alert('Value of ISHEADERPRESENT--' +  isHeaderPresent);"+
                                      +                 "if(isHeaderPresent=='True')"
                                      +                 "{"

                                      +                       "for(var i = expectedRow; i<totalRows; i++)"
                                      +                       "{"
                                      // +								"alert('Cells--' + objRows[i].cells.length);"
                                      //  +								"if(m==1)"
                                      +								"if(isMatching=='False')"
                                      +								"{"
                                      +                             	"var objColumns = objRows[i].cells;"
                                      +								"}"
                                      +								"else"
                                      +								"{"
                                      //  +									"alert('Expected row --' + expectedRow);"
                                      +									"var objColumns = objRows[expectedRow].cells;"
                                      +								"}"
                                      +								"if(objColumns!=null)"
                                      +								"{"	
                                      //   +									"alert('Value of i--' + i + 'Column object--' + objColumns[actualColumnNumber]);"
                                      +                             	"if(objColumns[actualColumnNumber]!= null)"
                                      +                             	"{"
                                      +                               	    "columnNumericValue = 'True';"
                                      +                                   	"actualColumnData = objColumns[actualColumnNumber].textContent;"
                                      //     +										"alert('Columns obj- -' + objColumns[2] + '--Value of I-' + i + 'Actual column--' + actualColumnData );"
                                      +									  	"if(actualColumnData==null)"
                                      +									  	"{"
                                      +											"actualColumnData = objColumns[actualColumnNumber].innerText;"
                                      //   +											"alert('For IE Columns obj- -' + objColumns[2] + '--Value of I-' + i + 'Actual column--' + actualColumnData );"
                                      //   +											"actualColumnData = actualColumnData.replace('\\r\\n','');"
                                      +											"while(actualColumnData.indexOf('\\r\\n')!=-1)"
                                      +											"{"
                                      +												"actualColumnData = actualColumnData.replace('\\r\\n','');"
                                      +											"}"
                                      //+											"actualColumnData = actualColumnData.replace(/(\r\n|\n|\r),'');"
                                      //     +											"alert('Data after changes-'+ arrExpectedRowData[l] + '==' + actualColumnData);"
                                      +									  	"}"	
                                      +                                  	 "if(arrExpectedRowData[l]==(Trim(actualColumnData)))"
                                      +                                   	"{"
                                      //   +                                   		"alert(arrExpectedRowData[l] + '==' + actualColumnData);"
                                      +                                         "isPresent = 'True';"
                                      +                                         "Result = 'Pass: Expected Column Value(s) present';"
                                      +											"expectedRow = i;"	
                                      +											"isMatching = 'True';"
                                      //      +											"alert('In column matching, value of i--' + i);"
                                      //        +                                         "return Result;"
                                      +                                         "break;"
                                      +                                   	"}"
                                      +                                   	"else"
                                      +                                   	"{"
                                      +                                 	    "isPresent = 'False';"
                                      +                                   	"}"
                                      //      +										"alert('Value of m-' + m);"	
                                      +										"if(arrColumnNames.length>1)"
                                      +										"{"
                                      +											"if(m>1 && isPresent=='False')"
                                      +											"{"
                                      //    +												"alert('Column  ' + m + ' value is not present');"
                                      +												"break;"
                                      +											"}"
                                      +										"}"		
                                      +                           	 	"}"	
                                      +                             	"else"
                                      +                             	"{"
                                      +                               	    "columnNumericValue = 'False';"
                                      //  +                               	    "break;"
                                      +                             	"}"
                                      +								"}"
                                      +                       "}"
                                      +                       "if(columnNumericValue=='False')"
                                      +                       "{"
                                      +                             "Result = 'Fail: Expected Column number \"' + arrColumnNames[l] + '\" is not present';"
                                      +                             "return Result;"
                                      +                             "break;"
                                      +                       "}"
                                      +                       "if(isPresent=='False')"
                                      +                       "{"
                                      +                             "Result = 'Fail: Expected Column Value \"' + arrExpectedRowData[l] + '\" is not present';"
                                      //  +                             "Result = actualColumnData;"
                                      +                             "return Result;"
                                      +                             "break;"
                                      +                       "}"
                                      +                 "}"
                                      +                 "else"
                                      +                 "{"
                                      //    +                       "alert('Column Header not found');"+
                                      +                       "Result = 'Fail: Expected Column header \"' + arrColumnNames[l] + '\" is not found in the table';"
                                      //      +                       "return Result;"
                                      +                       "break;"
                                      +                 "}"
                                      +           "}"

                                      /*+         "if(isPresent=='False')"
                                      +           "{"
                                      +                 "Result = 'Fail: Expected Column Value \"' + arrExpectedRowData[l] + '\" is not present';"
                                      +                 "return Result;"
                                      +                 "break;"
                                      +           "}"*/
                                      +     "}"
                                      +     "else"
                                      +     "{"
                                      +           "Result = 'Fail: Expected table \"' + tableName + '\" is not found on the page';"
                                      +           "return Result;"
                                      +     "}"
                                      //+     "function Trim(s){return s.replace(/^\\s*/,\"\").replace(/\\s*$/, \"\");}"

                                      +		"return Result;"
                                      + "}"
                                      + "catch(ex1)"
                                      + "{"
                                      //+     "alert('Into Catch');"
                                      +     "Result = 'Fail: ';"
                                      +     "return Result;"
                                      + "}";

			//str.replace(/^\s\s*/, '').replace(/\s\s*$/, '');

			JavascriptExecutor js = (JavascriptExecutor)FunctionsLibrary.driver;
			if(isTablePresent){
				if (arrTableHeaders.length == arrColumnValues.length) {
					strResult = js.executeScript(strScript).toString();
					System.out.println(" "+strResult);
					if (strResult.contains("Pass")) {
						reporter.writeStepResult(tc_id, scenarioName, "Verify column values in the table", "Expected: "+ strTableHeader + "||" + strColumnValues, strActualText, "Pass", strReportFilename);
					} else {
						reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", "Expected: "+ strTableHeader + "||" + strColumnValues,strActualText, "Fail", strReportFilename);
					}
				} else {
					strResult = "Wrong Input - Number of table headers are not matching with number of column values to be verified";
					reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", "Expected: "+ strTableHeader + "||" + strColumnValues,strActualText, "Fail", strReportFilename);
					
				}
			}else{
				strResult = "Wrong Input - The xpath provided for table in data sheet is not correct";
				reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", "Expected: "+ strTableHeader + "||" + strColumnValues,strActualText, "Fail", strReportFilename);
				
			}

		} catch (Exception e1) {
			
			reporter.writeStepResult(tc_id, scenarioName, "Verify column values in the table", "Expected: "+ strTableHeader + "||" + strColumnValues, e1.getMessage(), "Fail", strReportFilename);
			System.out.println("Failed ");
		} finally{
			if(strTableIdFlag.equals("True")){
				assignId(webelement, "", FunctionsLibrary.driver);
			}
		}                
	}
	/**
	 * Verify element text is contains
	 */
	public void verifyElementTextContains(String locatorKey, String strExpectedText) {
		String strActualText = null;
		WebElement element = null;
		try {
			element = getElementFluentWait(locatorKey);
			if (verifyElementPresent(locatorKey))
				strActualText = element.getText().trim();
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify element is present on the page", strExpectedText,
					e.getMessage(), "Fail", strReportFilename);
		}
		System.out.println("***" + strExpectedText + "***");
		System.out.println("***" + strActualText + "***");
		if (strActualText.contains(strExpectedText))
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Pass", strReportFilename);
		else
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Fail", strReportFilename);
	}
	
	public void verifyElementTextContains(WebElement element, String strExpectedText) {
		String strActualText = null;
		try {
			if (verifyElementPresent(element))
				wait.until(ExpectedConditions.textToBePresentInElement(element, strExpectedText));
			strActualText = element.getText().trim();
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify element is present on the page", strExpectedText,
					e.getMessage(), "Fail", strReportFilename);
		}
		System.out.println("***" + strExpectedText + "***");
		System.out.println("***" + strActualText + "***");
		if (strActualText.contains(strExpectedText))
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Pass", strReportFilename);
		else
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Fail", strReportFilename);
	}
	
	/**
	 * Verify element text is present using element
	 */
	public void verifyElementTextPresent(WebElement element, String strExpectedText) {
		String strActualText = null;
		try {
			if (verifyElementPresent(element))
				wait.until(ExpectedConditions.textToBePresentInElement(element, strExpectedText));
			strActualText = element.getText().trim();
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify element is present on the page", "" + element,
					element + " is not present on the page", "Fail", strReportFilename);
		}
		if (strActualText.equals(strExpectedText))
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Pass", strReportFilename);
		else
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Fail", strReportFilename);
	}

	/**
	 * Verify element text is present using element for label
	 */
	public void verifyElementTextPresent(String Label, WebElement element, String strExpectedText) {
		String strActualText = null;
		try {
			if (verifyElementPresent(element))
				wait.until(ExpectedConditions.textToBePresentInElement(element, strExpectedText));
			strActualText = element.getText().trim();
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify element is present on the page", "" + element,
					element + " is not present on the page", "Fail", strReportFilename);
		}
		System.out.println("****" + strExpectedText);
		System.out.println("****" + strActualText);
		if (strActualText.equals(strExpectedText))
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element for " + Label,
					strExpectedText, strActualText, "Pass", strReportFilename);
		else
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element for" + Label,
					strExpectedText, strActualText, "Fail", strReportFilename);
	}

	/**
	 * Verify element text is present using contains
	 */
	public void verifyElementTextPresentContains(String locatorKey, String strExpectedText) {
		String strActualText = null;
		WebElement element = null;
		try {
			waitForElementUsingVisibility(locatorKey);
			element = getElementFluentWait(locatorKey);

			if (verifyElementPresent(locatorKey))
				wait.until(ExpectedConditions.textToBePresentInElement(element, strExpectedText));
			strActualText = element.getText().trim();
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify element is present on the page", "" + element,
					element + " is not present on the page", "Fail", strReportFilename);
		}

		if (strActualText.contains(strExpectedText))
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Pass", strReportFilename);
		else
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Fail", strReportFilename);
	}

	/**
	 * Verify element text is present for multiple lines
	 */
	public void verifyElementTextPresentMultipleLines(String locatorKey, String strExpectedText) {
		String strActualText = null;
		WebElement element = null;
		try {
			element = getWebElementWithWait(locatorKey);
			waitForElementUsingVisibility(locatorKey);

			if (verifyElementPresent(locatorKey))
				strActualText = element.getText().trim().replace("\n", " ");
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify element is present on the page", strExpectedText,
					e.getMessage(), "Fail", strReportFilename);
		}
		System.out.println("***" + strExpectedText);
		System.out.println("***" + strActualText);
		if (strActualText.equals(strExpectedText))
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Pass", strReportFilename);
		else
			reporter.writeStepResult(tc_id, scenarioName, "Verify text is present in the element", strExpectedText,
					strActualText, "Fail", strReportFilename);
	}

	/**
	 * Verify color of an element
	 */
	public void verifyColorOfAnElement(String Label, String ExpectedColor, String locatorKey) {
		try {
			WebElement element = getWebElement(locatorKey);
			String ActualColor = element.getCssValue("color");
			String hex = Color.fromString(ActualColor).asHex();

			switch (hex) {
			case "#ff0000":
				ActualColor = "RED";
				break;
			case "#008000":
				ActualColor = "GREEN";
				break;
			case "#0000FF":
				ActualColor = "BLUE";
				break;

			default:
				break;
			}
			if (ExpectedColor.equalsIgnoreCase(ActualColor))
				reporter.writeStepResult(tc_id, scenarioName, "Verify the color of the element for " + Label,
						ExpectedColor, ActualColor, "Pass", strReportFilename);
			else
				reporter.writeStepResult(tc_id, scenarioName, "Verify the color of the element for " + Label,
						ExpectedColor, ActualColor, "Fail", strReportFilename);

		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify the color of the element for" + Label, ExpectedColor,
					e.getMessage(), "Pass", strReportFilename);
		}
	}

	/**
	 * Click RadioButton or CheckBox
	 */
	public void changeRadioButtonOrCheckBoxStatus(String locatorKey, String data) {
		WebElement element = getElementFluentWait(locatorKey);
		try {
			
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",  element);
			waitForElementUsingPresence(locatorKey);
			if ((data.equalsIgnoreCase("deselect")||data.equalsIgnoreCase("uncheck"))  && element.isSelected()) {
				
				element.click();
			}
			if ((data.equalsIgnoreCase("select")||data.equalsIgnoreCase("check")) && !element.isSelected()) {
				element.click();
			}
			reporter.writeStepResult(tc_id, scenarioName, "change radio button/Checkbox status",
					"Radio button/Checkbox should be : " + data + "ed", "Radio button/checkbox is : " + data + "ed", "Pass",
					strReportFilename);
			
		} catch (WebDriverException w1) {
			reporter.writeStepResult(tc_id, scenarioName, "change radio button status", data,
					"Not able to perform expected action", "Fail", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "change radio button status", data,
					"Not able to perform expected action", "Fail", strReportFilename);
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='1px solid grey'",  element);
	}
	/**
	 * Click RadioButton or CheckBox
	 */
	public void changeRadioButtonOrCheckBoxStatus(WebElement Webelement, String data) {
		WebElement element = Webelement;
		try {
			
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",  element);
			if ((data.equalsIgnoreCase("deselect")||data.equalsIgnoreCase("uncheck"))  && element.isSelected()) {
				
				element.click();
			}
			if ((data.equalsIgnoreCase("select")||data.equalsIgnoreCase("check")) && !element.isSelected()) {
				element.click();
			}
			reporter.writeStepResult(tc_id, scenarioName, "change radio button/Checkbox status",
					"Radio button/Checkbox should be : " + data + "ed", "Radio button/checkbox is : " + data + "ed", "Pass",
					strReportFilename);
			
		} catch (WebDriverException w1) {
			reporter.writeStepResult(tc_id, scenarioName, "change radio button status", data,
					"Not able to perform expected action", "Fail", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "change radio button status", data,
					"Not able to perform expected action", "Fail", strReportFilename);
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='1px solid grey'",  element);
	}
	
	
	public void changeRadioButtonOrCheckBoxStatusForOUConfig(String locatorKey, String data) {
		WebElement element = getWebElement(locatorKey);
		try {
			
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",  element);
			waitForElementUsingPresence(locatorKey);
			if ((data.equalsIgnoreCase("deselect")||data.equalsIgnoreCase("uncheck"))  && element.isSelected()) {
				
				element.click();
			}
			if ((data.equalsIgnoreCase("select")||data.equalsIgnoreCase("check")) && !element.isSelected()) {
				element.click();
			}
			reporter.writeStepResult(tc_id, scenarioName, "change radio button/Checkbox status",
					"Radio button/Checkbox should be : " + data + "ed", "Radio button/checkbox is : " + data + "ed", "Pass",
					strReportFilename);
			
		} catch (WebDriverException w1) {
			reporter.writeStepResult(tc_id, scenarioName, "change radio button status", data,
					"Not able to perform expected action", "Fail", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "change radio button status", data,
					"Not able to perform expected action", "Fail", strReportFilename);
		}
		//((JavascriptExecutor) driver).executeScript("arguments[0].style.border='1px solid grey'",  element);
	}
	
	/**
	 * Click RadioButton or CheckBox
	 */
	public void clickRadioButtonOrCheckBox(String locatorKey, String strButtonLabel) {
		try {
			WebElement element = getWebElement(locatorKey);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			if (!element.isSelected()) {
				element.click();
				reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
						"Clicked " + strButtonLabel + " successfully", "Pass", strReportFilename);
			} else
				reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
						"The " + strButtonLabel + " is already selected", "Fail", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel, e.getMessage(),
					"Fail", strReportFilename);
		}
	}

	/**
	 * Verify RadioButton or CheckBox is selected
	 */
	public void verifyRadioButtonOrCheckBoxIsSelected(String locatorKey, String strButtonLabel) {
		try {
			WebElement element = getElementFluentWait(locatorKey);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			if (element.isSelected()) {
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + strButtonLabel + " is Selected",
						strButtonLabel, "The " + strButtonLabel + " is selected on the page", "Pass",
						strReportFilename);
			} else
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + strButtonLabel + " is Selected",
						strButtonLabel, "Not able to select the " + strButtonLabel, "Fail", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify " + strButtonLabel + " is Selected", strButtonLabel,
					e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * Select drop down value
	 */
	public void selectDropdown(String locatorKey, String Option, String data) {
		WebElement element = getElementFluentWait(locatorKey);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '#ccf9bd'",  element);
		Select sel = new Select(element);
		
		try {
			if (Option.equalsIgnoreCase("VisibleText")) {
				//element.click();
				sel.selectByVisibleText(data.trim());
			} else if (Option.equalsIgnoreCase("Value")) {
				//element.click();
				sel.selectByValue(data.trim());
			} else if (Option.equalsIgnoreCase("Index")) {
				int index = Integer.parseInt(data.trim());
				//element.click();
				sel.selectByIndex(index);
			}
			
			reporter.writeStepResult(tc_id, scenarioName, "Select value from " + locatorKey + " Listbox", data,
					"Expected value " + data + " is selected in the listbox", "Pass", strReportFilename);
			
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Select value from " + locatorKey + " Listbox", data,
					"Expected value " + data + " is not present in the listbox", "Fail", strReportFilename);
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '#e6f2ff'",  element);
	}

	public void selectDropdownForOUConfig(String locatorKey, String Option, String data) {
		WebElement element = getElementFluentWait(locatorKey);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '#ccf9bd'",  element);
		Select sel = new Select(element);
		
		try {
			if (Option.equalsIgnoreCase("VisibleText")) {
				//element.click();
				sel.selectByVisibleText(data.trim());
			} else if (Option.equalsIgnoreCase("Value")) {
				//element.click();
				sel.selectByValue(data.trim());
			} else if (Option.equalsIgnoreCase("Index")) {
				int index = Integer.parseInt(data.trim());
				//element.click();
				sel.selectByIndex(index);
			}
			
			reporter.writeStepResult(tc_id, scenarioName, "Select value from " + locatorKey + " Listbox", data,
					"Expected value " + data + " is selected in the listbox", "Pass", strReportFilename);
			
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Select value from " + locatorKey + " Listbox", data,
					"Expected value " + data + " is not present in the listbox", "Fail", strReportFilename);
		}
		//((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '#e6f2ff'",  element);
	}
	
	/**
	 * To Clear the text field
	 */
	public void clearTextField(String locatorKey) {
		WebElement element=getWebElement(locatorKey);
		element.clear();
	}
	
	/**
	 * fetch Selected Drop Down Value
	 */
	public String fetchSelectedDropDownValue(String locatorKey) {
		String defaultValue = null;
		try {
			WebElement element = getWebElement(locatorKey);
			Select sel = new Select(element);
			defaultValue = sel.getFirstSelectedOption().getText();
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName,
					"fetch default DropDown value from " + locatorKey + " Listbox", defaultValue, e.getMessage(),
					"Fail", strReportFilename);
		}
		return defaultValue;
	}

	/**
	 * Verify Selected Drop Down Value
	 */
	public void verifySelectedDropDownValue(String locatorKey, String ExpectedValue) {
		try {
			WebElement element = getElementFluentWait(locatorKey);
			Select sel = new Select(element);
			String ActualValue = sel.getFirstSelectedOption().getText().trim();
			if (ExpectedValue.equals(ActualValue)) {
				reporter.writeStepResult(tc_id, scenarioName, "Verify DropDown value from " + locatorKey + " Listbox",
						ExpectedValue, ActualValue, "Pass", strReportFilename);
			} else {
				reporter.writeStepResult(tc_id, scenarioName, "Verify DropDown value from " + locatorKey + " Listbox",
						ExpectedValue, ActualValue, "Fail", strReportFilename);
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify DropDown value from " + locatorKey + " Listbox",
					ExpectedValue, e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * fetch Drop Down Values
	 */
	public List<String> fetchDropDownValues(String locatorKey) {
		WebElement element = getWebElement(locatorKey);
		Select sel = new Select(element);
		List<String> ActualValues = new ArrayList<String>();
		try {
			List<WebElement> options = sel.getOptions();
			for (WebElement option : options) {
				ActualValues.add(option.getText());
			}
		} catch (Exception e) {
		}
		return ActualValues;
	}

	/**
	 * Verify Drop Down Values
	 */
	public void VerifyDropDownValues(String Label, List<String> ExpectedValues, List<String> ActualValues) {
		try {
			if (ExpectedValues.size() == ActualValues.size()) {
				for (int i = 0; i < ExpectedValues.size(); i++) {
					if (ExpectedValues.get(i).equals(ActualValues.get(i)))
						reporter.writeStepResult(tc_id, scenarioName,
								"Verify DropDown value from " + Label + " Listbox", ExpectedValues.get(i),
								ActualValues.get(i), "Pass", strReportFilename);
					else
						reporter.writeStepResult(tc_id, scenarioName,
								"Verify DropDown value from " + Label + " Listbox", ExpectedValues.get(i),
								ActualValues.get(i), "Fail", strReportFilename);
				}
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify DropDown value from " + Label + " Listbox",
					"" + ExpectedValues, e.getMessage(), "Fail", strReportFilename);
		}
	}

	public void VerifyDropDownListValues(String locatorKey,String ExpectedValues) {
		
		String[] arrListValues;
		try {
			arrListValues = ExpectedValues.split(";");
			WebElement element = getElementFluentWait(locatorKey);
			Select sel = new Select(element);
			String ActualValues;
			List<WebElement> options = sel.getOptions();
			
			for(int i=0; i<arrListValues.length;i++){
			for (WebElement option : options) {
				ActualValues = option.getText().trim();
				String ListValues = arrListValues[i];
				if(ActualValues.equals(ListValues)){
					reporter.writeStepResult(tc_id, scenarioName, "Verify DropDown value from " + locatorKey + " Listbox", "List Box Values :"+ListValues, ActualValues, "Pass", strReportFilename);
				//System.out.println("Pass");
				break;
				}
			}
		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			reporter.writeStepResult(tc_id, scenarioName, "Verify DropDown value from " + locatorKey + " Listbox", "Verifying Dropdown Values", "Actual Values were not matched", "Fail", strReportFilename);
		}
		
	}
	
	/**
	 * Verify Row Label for Column Label with Value
	 */
	public void verifyRowLabelforColumnLabelWithValue(String RowLabel, String ColumnLabel, String ExpectedValue,
			String ActualValue) {
		try {
			if (ExpectedValue.equals(ActualValue)) {
				reporter.writeStepResult(tc_id, scenarioName,
						"Verify " + RowLabel + " for " + ColumnLabel + " with Expected Value", ExpectedValue,
						ActualValue, "Pass", strReportFilename);
			} else {
				reporter.writeStepResult(tc_id, scenarioName,
						"Verify " + RowLabel + " for " + ColumnLabel + " with Expected Value", ExpectedValue,
						ActualValue, "Fail", strReportFilename);
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName,
					"Verify " + RowLabel + " for " + ColumnLabel + " with Expected Value", ExpectedValue,
					e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * Verify Table Header Values
	 */
	public void verifyTableHeaderValues(String TableName, String ExpectedValue, String ActualValue) {
		try {
			if (ExpectedValue.equals(ActualValue)) {
				reporter.writeStepResult(tc_id, scenarioName,
						"Verify Header " + ExpectedValue + " is present in the Table " + TableName, ExpectedValue,
						ActualValue, "Pass", strReportFilename);
			} else {
				reporter.writeStepResult(tc_id, scenarioName,
						"Verify Header " + ExpectedValue + " is present in the Table " + TableName, ExpectedValue,
						ActualValue, "Fail", strReportFilename);
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName,
					"Verify Header " + ExpectedValue + " is present in the Table " + TableName, ExpectedValue,
					e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * Verify Number of Rows
	 */
	public void verifyNumberOfRows(String locatorKey, int ExpectedNumberofRows) {
		try {
			List<WebElement> element = getWebElements(locatorKey);
			int ActualNumberOfRows = element.size();
			if (ExpectedNumberofRows == ActualNumberOfRows) {
				reporter.writeStepResult(tc_id, scenarioName, "Verify Number of Rows Present in the Table",
						"" + ExpectedNumberofRows, "" + ActualNumberOfRows, "Pass", strReportFilename);
			} else {
				reporter.writeStepResult(tc_id, scenarioName, "Verify Number of Rows Present in the Table",
						"" + ExpectedNumberofRows, "" + ActualNumberOfRows, "Fail", strReportFilename);
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify Number of Rows Present in the Table",
					"" + ExpectedNumberofRows, e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * Verify Number of Rows
	 */
	public void verifyNumberOfRowsGreaterThan(String locatorKey, int ExpectedNumberofRows) {
		try {
			List<WebElement> element = getWebElements(locatorKey);
			int ActualNumberOfRows = element.size();
			if (ActualNumberOfRows >= ExpectedNumberofRows) {
				reporter.writeStepResult(tc_id, scenarioName,
						"Verify Number of Rows greater than " + ExpectedNumberofRows + " in the Table",
						"The Number of Rows in the Table should be greater than " + ExpectedNumberofRows,
						"Total " + ActualNumberOfRows + " number of rows are present in the Table", "Pass",
						strReportFilename);
			} else {
				reporter.writeStepResult(tc_id, scenarioName,
						"Verify Number of Rows greater than " + ExpectedNumberofRows + " in the Table",
						"The Number of Rows in the Table should be greater than " + ExpectedNumberofRows,
						"Total " + ActualNumberOfRows + " number of rows are present in the Table", "Fail",
						strReportFilename);
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify Number of Rows Present in the Table",
					"" + ExpectedNumberofRows, e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * Switch to Alert
	 */
	public void switchTOAlert(String condition) {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			if (condition.equalsIgnoreCase("Accept"))
				alert.accept();
			else
				alert.dismiss();
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Handle the Alert Present on the page", condition,
					e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * fetch column names from DB query
	 */
	public String[] fetchColumnNamesFromDBQuery(String query) {
		String[] ColumnNames = null;
		int selectIndex = query.toUpperCase().lastIndexOf("SELECT");
		int fromIndex = query.toUpperCase().lastIndexOf("FROM");
		String columnNameValue = query.toUpperCase().substring(selectIndex + 6, fromIndex - 1)
				.replaceAll("(\\r|\\n|\\r\\n|\\s+)+", "").trim();
		ColumnNames = columnNameValue.split(",");
		for (int j = 0; j < ColumnNames.length; j++) {
			if (ColumnNames[j].contains("SUBSTRING ")) {
				if (ColumnNames[j].contains("AS ")) {
					int rawColName = ColumnNames[j].indexOf("AS");
					String rawColNameVal = ColumnNames[j].substring(rawColName + 2);
				}
			}
			if (ColumnNames[j].contains(".")) {
				ColumnNames[j] = ColumnNames[j].replaceAll("^[a-zA-Z0-9]+[.]", "").trim();
			}
		}
		return ColumnNames;
	}

	/**
	 * fetch DataBase Values
	 */
	public List<Map<String, String>> fetchDatabaseValuesInMap(String query) {
		Properties config = null;
		try {
			config = new ExecutionerClass().setEnv();
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		try {
			final String Driver = config.getProperty("DB_DriverClass");
			Class.forName(Driver);
		} catch (ClassNotFoundException e1) {
			System.out.println("Unable to load the driver class! " + e1);
			reporter.writeStepResult(tc_id, scenarioName, "Fetch the Values from Database", query, e1.getMessage(),
					"Fail", strReportFilename);
			e1.printStackTrace();
		}
		Connection dbConnection = null;
		try {
			final String DBUrl = config.getProperty("DB_Url");
			final String DBName = config.getProperty("DB_DBName");
			/*
			 * "databaseName=HCSdb;integratedSecurity=true;";
			 */
			String connectionUrl = DBUrl + DBName;

			dbConnection = DriverManager.getConnection(connectionUrl);
			System.out.println("Database Connection Successfully established");
		} catch (SQLException e) {
			System.out.println("Couldn’t get connection! " + e);
			reporter.writeStepResult(tc_id, scenarioName, "Fetch the Values from Database", query, e.getMessage(),
					"Fail", strReportFilename);
		}
		int selectIndex = query.toUpperCase().lastIndexOf("SELECT");
		int fromIndex = query.toUpperCase().lastIndexOf("FROM");
		String columnNames = query.toUpperCase().substring(selectIndex + 6, fromIndex - 1)
				.replaceAll("(\\r|\\n|\\r\\n|\\s+)+", "").trim();

		String[] rawColumnNames = null;
		rawColumnNames = columnNames.split(",");
		for (int j = 0; j < rawColumnNames.length; j++) {
			if (rawColumnNames[j].contains("SUBSTRING ")) {
				if (rawColumnNames[j].contains("AS ")) {
					int rawColName = rawColumnNames[j].indexOf("AS");
					String rawColNameVal = rawColumnNames[j].substring(rawColName + 2);
				}
			}
			if (rawColumnNames[j].contains(".")) {
				rawColumnNames[j] = rawColumnNames[j].replaceAll("^[a-zA-Z0-9]+[.]", "").trim();
			}
		}
		String strActualValue = null;
		List<Map<String, String>> dbResultSet = new ArrayList<>();
		if (dbConnection != null) {
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = dbConnection.createStatement();
				rs = stmt.executeQuery(query);

				while (rs.next()) {
					Map<String, String> tableData = new HashMap<String, String>();
					for (int p = 0; p < rawColumnNames.length; p++) {
						try {
							if (rs.getString(rawColumnNames[p]).equals(null))
								System.out.println("The DB Value for " + rawColumnNames[p] + " is null");
							else
								strActualValue = rs.getString(rawColumnNames[p]).trim();

						} catch (NullPointerException e) {
							strActualValue = "";
						}
						System.out.println(rawColumnNames[p] + "===> " + strActualValue);
						tableData.put(rawColumnNames[p], strActualValue);
					}
					dbResultSet.add(tableData);
				}
				return dbResultSet;
			} catch (Exception e) {
				reporter.writeStepResult(tc_id, scenarioName, "Fetch the Values from Database", query, e.getMessage(),
						"Fail", strReportFilename);
			} finally {
				try {
					rs.close();
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			reporter.writeStepResult(tc_id, scenarioName, "Fetch the Values from Database", query, "" + dbConnection,
					"Fail", strReportFilename);
		}
		return dbResultSet;
	}

	/**
	 * fetch DataBase Values
	 */
	public void VerifyDatabaseValues(String Label, String Field, String ExpectedValue, String ActualValue) {
		try {
			if (ExpectedValue.equals(ActualValue)) {
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + Field + " Database Value for " + Label,
						ExpectedValue, ActualValue, "Pass", strReportFilename);
			} else {
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + Field + " Database Value for" + Label,
						ExpectedValue, ActualValue, "Fail", strReportFilename);
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify " + Field + " Database Value for " + Label,
					ExpectedValue, e.getMessage(), "Fail", strReportFilename);
		}
	}

	public static String getEnvironmentVariable(String strVariableName) {
		return envVariableMap.get(strVariableName);
	}

	public static void setEnvironmentVariable(String strVariableName, String strValue) {
		envVariableMap.put(strVariableName, strValue);
	}

	/**
	 * Verify Checkbox using symbols
	 */
	public void VerifyCheckBoxUsingSymbols(String locatorKey, String ExpectedValue) {
		try {
			WebElement element = getWebElement(locatorKey);
			String symbol = element.getText();
			char[] a = symbol.toCharArray();
			String actualHex = "";
			for (int i = 0; i < a.length; i++) {
				String hexSymbol = Integer.toHexString((int) a[i]);
				actualHex = actualHex + hexSymbol;
			}
			String ActualValue = null;

			switch (actualHex) {
			case "2610":
				ActualValue = "UnChecked";
				break;
			case "2611":
				ActualValue = "Checked";
				break;
			case "2612":
				ActualValue = "Crossed";
				break;
			default:
				break;
			}

			if (ExpectedValue.equals(ActualValue)) {
				reporter.writeStepResult(tc_id, scenarioName, "Verify CheckBox Using Symbols", ExpectedValue,
						ActualValue, "Pass", strReportFilename);
			} else {
				reporter.writeStepResult(tc_id, scenarioName, "Verify CheckBox Using Symbols", ExpectedValue,
						ActualValue, "Fail", strReportFilename);
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify CheckBox Using Symbols", ExpectedValue,
					e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * Verify Page Title
	 */
	public void verifyPageTitle(String ClosedPage, String ExpectedTitle) {
		try {
			String ActualTitle = driver.getTitle();
			if (driver.getWindowHandles().size() == 1) {
				if (ExpectedTitle.equals(ActualTitle)) {
					reporter.writeStepResult(tc_id, scenarioName,
							"Verify page Title after " + ClosedPage + " is closed", ExpectedTitle, ActualTitle, "Pass",
							strReportFilename);
				} else {
					reporter.writeStepResult(tc_id, scenarioName,
							"Verify page Title after " + ClosedPage + " is closed", ExpectedTitle, ActualTitle, "Fail",
							strReportFilename);
				}
			} else {
				reporter.writeStepResult(tc_id, scenarioName, "Verify page Title after " + ClosedPage + " is closed",
						ExpectedTitle, "Not able to close the " + ClosedPage, "Fail", strReportFilename);
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify page Title after " + ClosedPage + " is closed",
					ExpectedTitle, e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * Verify Page Url
	 */
	public void verifyPageURL(String PageName, String ExpectedURL) {
		try {
			String ActualURL = driver.getCurrentUrl();
			if (ExpectedURL.equals(ActualURL)) {
				reporter.writeStepResult(tc_id, scenarioName, "Verify the URL for the page " + PageName, ExpectedURL,
						ActualURL, "Pass", strReportFilename);
			} else {
				reporter.writeStepResult(tc_id, scenarioName, "Verify the URL for the page " + PageName, ExpectedURL,
						ActualURL, "Fail", strReportFilename);
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify the URL for the page " + PageName, ExpectedURL,
					e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * Close the Window
	 */
	public void closeTheWindow() {
		try {
			driver.close();
			reporter.writeStepResult(tc_id, scenarioName, "Close the Curent Window",
					"The Current Window should be closed", "The Current Window is closed", "Pass", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Close the Curent Window",
					"The Current Window should be closed", e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * Switch to New window
	 */
	public void switchToNewWindow() {
		try {
			Thread.sleep(1000);
			Set<String> allHandles = driver.getWindowHandles();
			String parentWindowHandle = allHandles.iterator().next();
			System.out.println("***********" + allHandles.size());
			for (String currHandle : allHandles) {
				if (currHandle != parentWindowHandle) {
					driver.switchTo().window(currHandle);
				}
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Switch To New Window",
					"The driver should be switched to New Window", e.getMessage(), "Fail", strReportFilename);
		}
	}

	/**
	 * Switch to parent window
	 */
	public void switchToParentWindow() {
		try {
			Set<String> allHandles = driver.getWindowHandles();
			String parentWindowHandle = allHandles.iterator().next();

			for (String currHandle : allHandles) {
				if (currHandle == parentWindowHandle) {
					driver.switchTo().window(currHandle);
				}
			}
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Switch To Parent Window",
					"The driver should be switched to Parent Window", e.getMessage(), "Fail", strReportFilename);
		}
	}

	public void switchBetweenWindows() {
		Set<String> handles = driver.getWindowHandles();
		String firstWinHandle = driver.getWindowHandle();

		handles.remove(firstWinHandle);
		String winHandle = handles.iterator().next();
		if (winHandle != firstWinHandle) {
			String secondWinHandle = winHandle;

			driver.switchTo().window(secondWinHandle);
		}
	}

	public void switchToTheParentWindow() {
		Set<String> handles = driver.getWindowHandles();

		String firstWinHandle = driver.getWindowHandle();
		handles.remove(firstWinHandle);
		driver.close();
		String winHandle = handles.iterator().next();

		if (winHandle != firstWinHandle) {
			String secondWinHandle = winHandle;

			driver.switchTo().window(secondWinHandle);
		}
	}

	/**
	 * To Save PDF
	 */

	public void savePDF() {
		Robot robot;
		try {
			robot = new Robot();
			Thread.sleep(4000);

			robot.mouseMove(936, 208);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);

			// Shortcut to save the PDF
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			String ProjectPath = new File("").getAbsolutePath();
			String PDFFolder = ProjectPath + "\\Files\\PDF\\";
			int x = (int) (Math.random() * 999999) + 1126;
			String PDFName = "hpstExhibitE" + x + ".pdf";
			String PDFPath = PDFFolder + PDFName;
			setEnvironmentVariable("PDFURL", PDFPath);

			// Store the path of PDF to clipboard
			StringSelection selection = new StringSelection(PDFPath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);

			Thread.sleep(1000);
			// Paste the path of PDF from clipboard and save the PDF
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Press tab
	 */
	public void pressTab() {
		try {
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_SHIFT);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_SHIFT);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Select drop down by visible text
	 */
	public void selectDropdownByVisibleText(String LocatorKey,String data) {
		try {
			WebElement element = getElementFluentWait(LocatorKey);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid green'",  element);
			
			Select sel = new Select(element);
			sel.selectByVisibleText(data);
			reporter.writeStepResult(tc_id, scenarioName,
					"Select the " + LocatorKey + "Menu with Visible Text " + data + " in the webpage",
					"The Locator and data Option available in the page", "List value selected", "Pass",
					strReportFilename);
			js.executeScript("arguments[0].style.border='2px solid grey'", element);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName,
					"Select the " + LocatorKey + "Menu with Visible Text Value " + data + " in the webpage",
					"The Locator and data Option not available in the page", e.getMessage(), "Fail",
					strReportFilename);
		}
	}
	public void verifyRadioButtonOrCheckBoxIsSelected(WebElement locatorKey, String strButtonLabel) {
		try {
			WebElement element = locatorKey;
			wait.until(ExpectedConditions.elementToBeClickable(element));
			if (element.isSelected()) {
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + strButtonLabel + " is Selected",
						strButtonLabel, "The " + strButtonLabel + " is selected on the page", "Pass",
						strReportFilename);
			} else
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + strButtonLabel + " is Selected",
						strButtonLabel, "Not able to select the " + strButtonLabel, "Fail", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify " + strButtonLabel + " is Selected", strButtonLabel,
					e.getMessage(), "Fail", strReportFilename);
		}
	}
	public void selectDropdownByVisibleText(WebElement LocatorKey,String data) {
		try {
			WebElement element = LocatorKey;
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid green'",  element);
			
			Select sel = new Select(element);
			sel.selectByVisibleText(data);
			reporter.writeStepResult(tc_id, scenarioName,
					"Select the " + LocatorKey + "Menu with Visible Text " + data + " in the webpage",
					"The Locator and data Option available in the page", "List value selected", "Pass",
					strReportFilename);
			js.executeScript("arguments[0].style.border='2px solid grey'", element);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName,
					"Select the " + LocatorKey + "Menu with Visible Text Value " + data + " in the webpage",
					"The Locator and data Option not available in the page", e.getMessage(), "Fail",
					strReportFilename);
		}
	}
	public void verifyElementisDisabled(String locatorKey) {
		try {
			WebElement element = getWebElement(locatorKey);
			boolean exists;
			if (element.isEnabled() != true)
				exists = true;
			else
				exists = false;

			if (exists)
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + locatorKey + " is Disabled on the page",
						locatorKey, "The element " + locatorKey + " is Disabled on the page", "Pass", strReportFilename);
			else
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + locatorKey + " is Disabled on the page",
						locatorKey, "The element " + locatorKey + " is not Disabled on the page", "Fail",
						strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify " + locatorKey + " is Disabled on the page",
					locatorKey, e.getMessage(), "Fail", strReportFilename);
		}
	}
	public void clickAnDisableElement(String locatorKey, String strButtonLabel) {

		WebElement element = null;
		try {
			if (object.getProperty(locatorKey) != null && object.getProperty(locatorKey).contains("#")) {
				element = getElementFluentWait(locatorKey);
			} else {
				element = getElementFluentWait(locatorKey, strButtonLabel);
			}
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'",  element);
			element.click();
			
			reporter.writeStepResult(tc_id, scenarioName, "Click on Disable button " + strButtonLabel, strButtonLabel,
					"Clicked " + strButtonLabel + " button disable", "Pass", strReportFilename);
			
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='2px solid grey'", element);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
//			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
//					"Not able to click on  button " + strButtonLabel, "Fail", strReportFilename);
//			try {
//				JavascriptExecutor jse = (JavascriptExecutor) driver;
//				jse.executeScript("arguments[0].click();", element);
//
//			} catch (Exception e1) {
//				reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel,
//						"Not able to click on  button " + strButtonLabel, "Fail", strReportFilename);
//
//			}

		}
	}
	public void selectDropdowndisable(String locatorKey, String Option, String data) {
		WebElement element = getElementFluentWait(locatorKey);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '#ccf9bd'",  element);
		Select sel = new Select(element);
		
		try {
			if (Option.equalsIgnoreCase("VisibleText")) {
				//element.click();
				sel.selectByVisibleText(data.trim());
			} else if (Option.equalsIgnoreCase("Value")) {
				//element.click();
				sel.selectByValue(data.trim());
			} else if (Option.equalsIgnoreCase("Index")) {
				int index = Integer.parseInt(data.trim());
				//element.click();
				sel.selectByIndex(index);
			}
			
			reporter.writeStepResult(tc_id, scenarioName, "Select value from disable  " + locatorKey + " Listbox", data,
					"Expected value " + data + " is not selected in the listbox", "Pass", strReportFilename);
			
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Select value from disable " + locatorKey + " Listbox", data,
					"Expected value " + data + " is selelected  in the listbox", "Fail", strReportFilename);
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '#e6f2ff'",  element);
	}
	/**
	 * Select drop down by index
	 */
	public void selectDropdownByIndex(String LocatorKey, int index) {
		try {
			WebElement element = getElementFluentWait(LocatorKey);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid green'",  element);
			Select sel = new Select(element);
			sel.selectByIndex(index);
			
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName,
					"Select the " + LocatorKey + "Menu with Inde Value " + index + " in the webpage",
					"The Locator and index not available in the page", e.getMessage(), "Fail",
					strReportFilename);
		}
	}

	/**
	 * Select drop down by index
	 */
	public void selectDropdownByIndex(WebElement element, int index) {
		try {
			Select sel = new Select(element);
			sel.selectByIndex(index);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName,
					"Select the " + element + "Menu with Inde Value " + index + " in the webpage",
					"The Locator and index not available in the page", e.getMessage(), "Fail",
					strReportFilename);
		}
	}

	

	/**
	 * Select drop down by value
	 */
	public void selectDropdownByValue(WebElement element, String data) {
		try {
			Select sel = new Select(element);
			sel.selectByValue(data);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName,
					"Select the " + element + "Menu with Dropdown Value " + data + " in the webpage",
					"The Locator and DropDown Option not available in the page", e.getMessage(), "Fail",
					strReportFilename);
		}
	}

	/**
	 * Verify drop down
	 */
	public boolean verifyDropdownvalues(WebElement element, String expectedvalue) {
		// WebElement
		// ele=driver.findElement(By.id("ddl_salesChannel"));//div[@id='div_SalesChannel']/div/select[@id='ddl_salesChannel']
		// wait.until(ExpectedConditions.elementToBeSelected(element));
		boolean exists = false;
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
			if (we.getText().equals(expectedvalue)) {
				we.click();
				exists = true;
			}
		}
		if (exists) {
			// reporter.writeStepResult(testCaseName, scenarioName, "Verify
			// DropDown Values with actual value", expectedvalue, "Value",
			// "Pass", reportFileName);
			System.out.println("Pass");
			return true;
		} else {
			// reporter.writeStepResult(testCaseName, scenarioName, "Verify
			// DropDown Values with actual value", expectedvalue, "Value",
			// "Fail", reportFileName);
			System.out.println("Fail");
			return false;
		}
	}

	/**
	 * Verify drop down values which are not present
	 */
/*	public boolean verifyDropDownValNotPresent(WebElement element, String expectedvalue) {
		boolean notExist = false;
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
			if (!we.getText().equals(expectedvalue)) {
				notExist = true;
			}
		}
		if (notExist) {
			// reporter.writeStepResult("testCaseName", "strScenarioName",
			// "Verify DropDown Values with actual value", expectedvalue,
			// "we.getText()", "Pass", "strReportFile");
			System.out.println("Pass");
			return true;
		} else {
			// reporter.writeStepResult("testCaseName", "strScenarioName",
			// "Verify DropDown Values with actual value", expectedvalue,
			// "we.getText()", "Fail", "strReportFile");
			System.out.println("Fail");
			return false;
		}
	}*/

	/**
	 * parse the json input
	 */
	/*public ArrayList<String> parseJson(String data, String testCaseID, String filename) {
		ArrayList<String> value = new ArrayList<String>();
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("Data/" + filename + ".json"));

			JSONObject lev1 = (JSONObject) obj;
			Object jObj = lev1.get(testCaseID);
			if (jObj instanceof Map) {
				HashMap<String, ArrayList<String>> map = (HashMap<String, ArrayList<String>>) jObj;
				Object in = map.get("Input");
				HashMap<String, ArrayList<String>> map1 = (HashMap<String, ArrayList<String>>) in;
				// Object input=map1.get(data);
				// HashMap<String, ArrayList<String>> parseData=
				// (HashMap<String, ArrayList<String>>) input;
				for (Entry<String, ArrayList<String>> entry : map1.entrySet()) {
					for (int i = 0; i < entry.getValue().size(); i++) {
						String val = entry.getValue().get(i);
						value.add(val);
					}
				}
				System.out.println(" " + value);
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
	 */
	/**
	 * Verify Element in sales channel summary report in Reporting page
	 */
	public boolean verifyAlertPresent() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		if (wait.until(ExpectedConditions.alertIsPresent()) == null)
			return false;
		else {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			return true;
		}
	}

	/**
	 * To wait for a page to load until it gets in ready state
	 */
	public void waitForPageLoad() {
		new WebDriverWait(driver, 100).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver input) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});
	}

	/**
	 * To wait for specific element on the page for defined period[explicit
	 * wait]
	 * 
	 * @param element
	 * @param seconds
	 * @return
	 */
	public boolean waitForElement(WebElement element, int seconds) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS)
				.pollingEvery((seconds / 5), TimeUnit.SECONDS);
		return wait.until(ExpectedConditions.visibilityOf(element)) != null;
	}

	/**
	 * parse the json input
	 */
	public void getReleaseName(String filename) {
		/*
		 * String value =""; JSONParser parser = new JSONParser(); try { Object
		 * obj = parser.parse(new FileReader("Data/"+filename+".json"));
		 * 
		 * JSONObject lev1 = (JSONObject) obj; Object jObj =
		 * lev1.get("ReleaseDetails");
		 * 
		 * if (jObj instanceof Map) { //HashMap<String, ArrayList<String>> map =
		 * (HashMap<String, ArrayList<String>>) jObj; //Object
		 * in=map.get("Input"); HashMap<String, ArrayList<String>> map1=
		 * (HashMap<String, ArrayList<String>>) jObj; //Object
		 * input=map1.get(data); //HashMap<String, ArrayList<String>> parseData=
		 * (HashMap<String, ArrayList<String>>) input; for (Entry<String,
		 * ArrayList<String>> entry : map1.entrySet()) { for (int i = 0; i <
		 * entry.getValue().size(); i++) { value=entry.getValue().get(i);
		 * //value.add(val); } } System.out.println(" "+value); }
		 * 
		 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch
		 * (IOException e) { e.printStackTrace(); } catch (ParseException e) {
		 * e.printStackTrace(); } return value;
		 */}

	// WebTops windows handles

	public void switchToWindows(String windowTitle) throws InterruptedException {
		Thread.sleep(7000);		
		int currentWindowSize = handlesWithId.size() + 1;
		int iteration = 0;
		while (!handlesWithId.containsKey(windowTitle) && iteration < 5) {
			if (currentWindowSize == driver.getWindowHandles().size())
				break;
			else
				globalWait();
			iteration++;
		}


		try {
			driver.switchTo().window(getWindowHandleMap(windowTitle).get(windowTitle));

			System.out.println(driver.getTitle() + "==>" + driver.getCurrentUrl());
		} catch (Exception e) {
			System.out.println("Window not siwtched to : " + windowTitle);
			//CommonStepDefinitions.executeScenario="No";
			reporter.writeStepResult(tc_id, scenarioName,
					"Switch to window "+windowTitle,
					"Unable to switch to window "+windowTitle, e.getMessage(), "Fail",
					strReportFilename);

			e.printStackTrace();
		}

	}

	public Map<String, String> getWindowHandleMap(String windowTitle) {

		// String [] windowNames ={"Merchant Servicing","Order
		// Management","Terminal Options"};
		Set<String> handles = driver.getWindowHandles();
		/*
		 * System.out.println(handles); System.out.println(handles.size());
		 */
		List<String> handlesList = new ArrayList<String>(handles);
		for (int i = 0; i < handles.size(); i++) {

			if (!handlesWithId.containsValue(handlesList.get(i)))
				handlesWithId.put(windowTitle, handlesList.get(i));

		}

		// List<String> handlesList = new ArrayList<String>(handles);
		/*
		 * for (int i=0; i<handles.size();i++) {
		 * //System.out.println(driver.switchTo().window(windows).getTitle());
		 * if(!(windowNames[i].equals("Merchant Servicing") ||
		 * handlesList.get(i).equals(handlesWithId.get("Merchant Servicing")))){
		 * if(!(handlesWithId.containsKey(windowNames[i]) &&
		 * handlesWithId.containsValue(handlesList.get(i))))
		 * handlesWithId.put(windowNames[i], handlesList.get(i)); else
		 * System.out.println("Window id not recorded for"+windowNames[i]
		 * +": ==>"+handlesList.get(i));
		 * 
		 * } else System.out.println("Window id not recorded for"+windowNames[i]
		 * +": ==>"+handlesList.get(i));
		 * 
		 * 
		 * 
		 * }
		 */

		System.out.println("All Windows" + handlesWithId);
		return handlesWithId;
	}

	public void elementWaituntilinvisible(String strButtonLabel) {

		try {

			WebElement element = getWebElementWithWait(strButtonLabel);
			boolean result = false;
			do {
				try {
					globalWait();
					result = element.isDisplayed();
				} catch (StaleElementReferenceException e) {
					System.out.println("Please Wait Dialog disappeared");
				}

			} while (result);

			return;

		} catch (Exception e) {
			System.out.println("Element is not present in DOM!!");
			reporter.writeStepResult(tc_id, scenarioName,
					"Wait for Element " + strButtonLabel + " to be visible on the webpage",
					"WebElement " + strButtonLabel + " is not visible on Webpage", e.getMessage(), "Fail",
					strReportFilename);
		}

	}

	/*public WebElement getElementFluentWait(String elementAddress) {

		String locatorMethod = null;
		String locatorValue = null;
		try {
			String[] locatorMethodName = readProperties(elementAddress);
			locatorMethod = locatorMethodName[0];
			locatorValue = locatorMethodName[1];
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Fetch LocatorMethod and LocatorValue for " + elementAddress,
					"LocatorMethod: " + locatorMethod + ";" + "LocatorValue: " + locatorValue, e.getMessage(), "Fail",
					strReportFilename);
		}

		final String eleAddress = locatorValue;
		final WebDriver driver = this.driver;
		final String locator = locatorMethod.toLowerCase().trim();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		WebElement returnEle = null;
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.withTimeout(getWaitTime, TimeUnit.SECONDS);
		WebElement element = null;
		int elementCheckCount = 0;

		while (element == null && elementCheckCount < 2) {
			try {
				element = wait.until(new Function<WebDriver, WebElement>() {

					public WebElement apply(WebDriver driver) {

						WebElement ele = null;

						switch (locator) {
						case "id":
							ele = driver.findElement(By.id(eleAddress));

							break;
						case "name":
							ele = driver.findElement(By.name(eleAddress));
							break;
						case "class":
							ele = driver.findElement(By.className(eleAddress));
							break;
						case "linkText":
							ele = driver.findElement(By.linkText(eleAddress));
							break;
						case "partiallinkText":
							ele = driver.findElement(By.partialLinkText(eleAddress));
							break;
						case "tagname":
							ele = driver.findElement(By.tagName(eleAddress));
							break;
						case "css":
							ele = driver.findElement(By.cssSelector(eleAddress));
							break;
						case "xpath":
							ele = driver.findElement(By.xpath(eleAddress));
							break;

						default:
							break;
						}

						if (ele != null) {

							System.out.println("Element located in DOM successfully.. with FluentWait");

							return ele;

						} else {
							System.out.println("Element not located in DOM for " + eleAddress
									+ " with FluentWait, Returning null value");

							return null;

						}

					}

				});
				System.out.println("returning " + element + " for " + eleAddress);

			} 
			catch (Exception e) {
				System.out.println("Element not found " + element + " for " + eleAddress);
				reporter.writeStepResult(tc_id, scenarioName,
						"Find Element By " + locatorMethod + " with Value " + eleAddress + " in the webpage",
						"The Locator Method and Value should be available in the page", e.getMessage(), "Fail",
						strReportFilename);
				globalWait();
				// e.printStackTrace();
				// TODO: handle exception
			}
			elementCheckCount++;
		}
		return element;

	}*/
	public WebElement getElementFluentWait(String elementAddress) {
		String locatorMethod = null;
		String locatorValue = null;
		try {
			String[] locatorMethodName = readProperties(elementAddress);
			locatorMethod = locatorMethodName[0];
			locatorValue = locatorMethodName[1];
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Fetch LocatorMethod and LocatorValue for " + elementAddress,
					"LocatorMethod: " + locatorMethod + ";" + "LocatorValue: " + locatorValue, e.getMessage(), "Fail",
					strReportFilename);
		}
		final String eleAddress = locatorValue;
		//final String locator =
		final WebDriver driver = this.driver;
		final String locator =  locatorMethod.toLowerCase().trim();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		WebElement returnEle = null;

		wait.withTimeout(getWaitTime, TimeUnit.SECONDS)
		.pollingEvery(5, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
		WebElement element = null;
		int elementCheckCount = 1;

		while (element == null && elementCheckCount <= maxAttempt) {
			try {
				element = wait.until(new Function<WebDriver, WebElement>() {

					public WebElement apply(WebDriver driver) {

						WebElement ele = null;

						switch (locator) {
						case "id":
							ele = driver.findElement(By.id((eleAddress)));
							break;
						case "name":
							ele = driver.findElement(By.name((eleAddress)));
							break;
						case "class":
							ele = driver.findElement(By.className((eleAddress)));
							break;
						case "linkText":
							ele = driver.findElement(By.linkText((eleAddress)));
							break;
						case "partiallinkText":
							ele = driver.findElement(By.partialLinkText((eleAddress)));
							break;
						case "tagname":
							ele = driver.findElement(By.tagName((eleAddress)));
							break;
						case "css":
							ele = driver.findElement(By.cssSelector((eleAddress)));
							break;
						case "xpath":
							ele = driver.findElement(By.xpath((eleAddress)));
							break;

						default:
							break;
						}
						CommonStepDefinitions.exceptioncounter=0;
						//highlightElement(ele);
						if (ele != null) {
							//System.out.println("Element located in DOM successfully.. with FluentWait");
							return ele;

						} else {
							/*System.out.println("Element not located in DOM for " + eleAddress
									+ " with FluentWait, Returning null value");*/

							return null;
						}
					}
				});
				//System.out.println("returning " + element + " for " + eleAddress);

			} catch (TimeoutException te) {
				if (elementCheckCount == maxAttempt) {
					te.printStackTrace();
					System.out.println(java.time.LocalDateTime.now()+"-:: "+"====================== :: Handled Full Stack Trace Information :: ==========================");
					System.out.println(java.time.LocalDateTime.now()+"-:: "+ExceptionUtils.getFullStackTrace(te));
					System.out.println(java.time.LocalDateTime.now()+"-:: "+"====================== :: Handled Full Stack Trace Information :: ==========================");
					
					CommonStepDefinitions.exceptioncounter++;
					reporter.writeStepResult(tc_id, scenarioName,
							"Find Element By " + locatorMethod + " with Value " + eleAddress + " in the webpage",
							"The Locator Method and Value should be available in the page", te.getMessage(), "Fail",
							strReportFilename);
				}
				if (CommonStepDefinitions.exceptioncounter==3) {
					reporter.writeStepResult(tc_id, scenarioName,
							"Find Element By " + locatorMethod + " with Value " + eleAddress + " in the webpage",
							"The Locator Method and Value should be available in the page", "The Element is not available and Execution is Not Completed for this TestCase", "Fail",
							strReportFilename);
					CommonStepDefinitions.exescenario = false;
				}
			} catch (Exception e) {
				//System.out.println("Element not found " + element + " for " + eleAddress);
				if (elementCheckCount == maxAttempt) {
					//e.printStackTrace();
					System.out.println(java.time.LocalDateTime.now()+"-:: "+"====================== :: Handled Full Stack Trace Information :: ==========================");
					
					ExceptionUtils.getFullStackTrace(e);
					System.out.println(java.time.LocalDateTime.now()+"-:: "+"====================== :: ============================================ :: ==========================");
					System.out.println(java.time.LocalDateTime.now()+"-:: "+e.getStackTrace());
					
					reporter.writeStepResult(tc_id, scenarioName,
							"Find Element By " + locatorMethod + " with Value " + eleAddress + " in the webpage",
							"The Locator Method and Value should be available in the page", e.getMessage(), "Fail",
							strReportFilename);
				}

				globalWait();
				// e.printStackTrace();
				// TODO: handle exception
			}
			elementCheckCount++;
		}
		return element;
	}

	public static void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='2px solid blue'", element);	    
	}
	public WebElement getElementFluentWait(String locatorMethod, String elementAddress) {

		final String eleAddress = elementAddress;
		final WebDriver driver = this.driver;
		final String locator = locatorMethod;
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(getWaitTime, TimeUnit.SECONDS)
		.pollingEvery(5, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
		WebElement element = null;
		int elementCheckCount = 1;

		while (element == null && elementCheckCount <= maxAttempt) {
			try {
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						WebElement ele = null;
						switch (locator) {
						case "id":
							ele = driver.findElement(By.id((eleAddress)));
							break;
						case "name":
							ele = driver.findElement(By.name((eleAddress)));
							break;
						case "class":
							ele = driver.findElement(By.className((eleAddress)));
							break;
						case "linkText":
							ele = driver.findElement(By.linkText((eleAddress)));
							break;
						case "partiallinkText":
							ele = driver.findElement(By.partialLinkText((eleAddress)));
							break;
						case "tagname":
							ele = driver.findElement(By.tagName((eleAddress)));
							break;
						case "css":
							ele = driver.findElement(By.cssSelector((eleAddress)));
							break;
						case "xpath":
							ele = driver.findElement(By.xpath((eleAddress)));
							break;

						default:
							break;
						}
						CommonStepDefinitions.exceptioncounter=0;
						
						if (ele != null) {
							//System.out.println("Element located in DOM successfully.. with FluentWait");
							return ele;

						} else {
							/*System.out.println("Element not located in DOM for " + eleAddress
									+ " with FluentWait, Returning null value");*/
							return null;
						}
					}
				});
				//System.out.println("returning " + element + " for " + eleAddress);
			} catch (TimeoutException te) {
				if (elementCheckCount == maxAttempt) {
					te.printStackTrace();
					CommonStepDefinitions.exceptioncounter++;
					reporter.writeStepResult(tc_id, scenarioName,
							"Find Element By " + locatorMethod + " with Value " + eleAddress + " in the webpage",
							"The Locator Method and Value should be available in the page", te.getMessage(), "Fail",
							strReportFilename);
				}
				if (CommonStepDefinitions.exceptioncounter==3) {
					reporter.writeStepResult(tc_id, scenarioName,
							"Find Element By " + locatorMethod + " with Value " + eleAddress + " in the webpage",
							"The Locator Method and Value should be available in the page", "The Element is not available and Execution is Not Completed for this TestCase", "Fail",
							strReportFilename);
					CommonStepDefinitions.exescenario = false;
				} 
			} catch (Exception e) {
				//System.out.println("Element not found " + element + " for " + eleAddress);
				if (elementCheckCount == maxAttempt) {
					//e.printStackTrace();
					System.out.println(java.time.LocalDateTime.now()+"-:: "+"====================== :: Handled Full Stack Trace Information :: ==========================");
					System.out.println(java.time.LocalDateTime.now()+"-:: "+ExceptionUtils.getFullStackTrace(e));
					System.out.println(java.time.LocalDateTime.now()+"-:: "+"====================== :: Handled Full Stack Trace Information :: ==========================");
					
					reporter.writeStepResult(tc_id, scenarioName,
							"Find Element By " + locatorMethod + " with Value " + eleAddress + " in the webpage",
							"The Locator Method and Value should be available in the page", e.getMessage(), "Fail",
							strReportFilename);

					globalWait();
					// e.printStackTrace();
					// TODO: handle exception
				}
			}
			elementCheckCount++;
		}
		return element;
	}

	public int getFluentWaitTime() {
		String selectedEnvironment = loadPropertiesFile(sysPropFromFile).getProperty("Execution_Environment");
		String fluentWaitTime="120";
		switch (selectedEnvironment) {
		case "SandBox":
			fluentWaitTime = loadPropertiesFile(sysPropFromFile).getProperty("SandBoxEnvWaitTime");
			break;
		case "QA":
			fluentWaitTime = loadPropertiesFile(sysPropFromFile).getProperty("QAEnvWaitTime");
			break;
		case "Dev":
			fluentWaitTime = loadPropertiesFile(sysPropFromFile).getProperty("DevEnvWaitTime");
			break;
		case "Production":
			fluentWaitTime = loadPropertiesFile(sysPropFromFile).getProperty("ProductionEnvWaitTime");
			break;
		default:
			break;
		}
		System.out.println("Selected Env is : "+selectedEnvironment +" and wait time is: "+fluentWaitTime);
		//String fluentWaitTime = loadPropertiesFile(sysPropFromFile).getProperty("FluentWaitTime");
		// System.out.println("Global Fluent Wait.......................");
		return Integer.parseInt(fluentWaitTime);
	}

	public void globalWait(String... waitTime) {

		String globalWaitTime = "1";
		if (waitTime.length > 0) {
			globalWaitTime = waitTime[0];
		}
		globalWaitTime = loadPropertiesFile(sysPropFromFile).getProperty("GlobalWaitTime");
		int inputTime = Integer.parseInt(globalWaitTime) * 1000;
		try {
			Thread.sleep(inputTime);
			// System.out.println("Global Wait.......................");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return inputTime;

	}

	public void refreshPage() {
		driver.navigate().refresh();
		waitForPageLoad();
	}

	/**
	 * Verify Unchecked Checkbox
	 */
	public void VerifyUncheckedCheckBox(String locatorKey) {
		try {
			WebElement element = getWebElement(locatorKey);
			wait.until(ExpectedConditions.visibilityOf(element));
			if (!element.isSelected()) {
				reporter.writeStepResult(tc_id, scenarioName, "Verify CheckBox is Checked or UnChecked", locatorKey,
						"UnChecked", "Pass", strReportFilename);
				System.out.println(locatorKey + " Checkbox is Unchecked");
			} else {
				reporter.writeStepResult(tc_id, scenarioName, "Verify CheckBox is Checked or UnChecked", locatorKey,
						"Checked", "Fail", strReportFilename);
				System.out.println(locatorKey + " Checkbox is Checked");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void closeAllChildWindow(String homeWindow){

		Set<String> allWindows = driver.getWindowHandles();

		//Use Iterator to iterate over windows
		Iterator<String> windowIterator =  allWindows.iterator();

		//Verify next window is available
		while(windowIterator.hasNext())
		{
			//Store the Recruiter window id
			String childWindow = windowIterator.next();


			//Here we will compare if parent window is not equal to child window 
			if (!homeWindow.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
				driver.close();
			}

		}
		driver.switchTo().window(homeWindow);
	}

	public void enterFromDate(String locatorKey) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss");
		Date currentDate = new Date();

		System.out.println(dateFormat.format(currentDate));

		// convert date to calendar
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);

		// manipulate date

		c.add(Calendar.DATE, -1); // same with c.add(Calendar.DAY_OF_MONTH, 1);

		// convert calendar to date
		Date currentDateMinus = c.getTime();

		System.out.println(dateFormat.format(currentDateMinus));

		String monthBackDate = dateFormat.format(currentDateMinus);
		System.out.println(monthBackDate);
		String[] splitFullDate = monthBackDate.split(" ");
		String[] splitDate = splitFullDate[0].split("-");
		String[] splitTime = splitFullDate[1].split(":");
		for (int j = 0; j < splitDate.length; j++) {
			System.out.println("splitDate =" + splitDate[j]);

		}
		for (int i = 0; i < splitTime.length; i++) {
			System.out.println("splitTime =" + splitTime[i]);
		}

		String mon = splitDate[1];
		String yy = splitDate[0];
		String dd = splitDate[2];
		String hour = splitTime[0];
		String minute = splitTime[1];
		String sec = splitTime[2];
		if (dd.substring(0, 1).contains("0"))
			dd = dd.replace("0", "");
		if (minute.substring(0, 1).contains("0"))
			minute = minute.replace("0", "");
		if (sec.substring(0, 1).contains("0"))
			sec = sec.replace("0", "");
		String[] locatorMethodName = readProperties(locatorKey);
		String locatorMethod = locatorMethodName[0];
		String locatorValue = null;
		if (locatorKey.equals("selectMon")) {
			locatorValue = locatorMethodName[1].replace("<>", mon);
			clickAnElement("selectMon", locatorValue, "Month");
		}
		if (locatorKey.equals("selectYear")) {
			locatorValue = locatorMethodName[1].replace("<>", yy);
			clickAnElement("selectYear", locatorValue, "Year");
		}
		if (locatorKey.equals("selectDay")) {
			locatorValue = locatorMethodName[1].replace("<>", dd);
			clickAnElement("selectDay", locatorValue, "Day");
		}
		if (locatorKey.equals("selectHour")) {
			locatorValue = locatorMethodName[1].replace("<>", hour);
			clickAnElement("selectHour", locatorValue, "Hour");
		}
		if (locatorKey.equals("selectMin")) {
			locatorValue = locatorMethodName[1].replace("<>", minute);
			clickAnElement("selectMin", locatorValue, "Min");
		}
		if (locatorKey.equals("selectSec")) {
			locatorValue = locatorMethodName[1].replace("<>", sec);
			clickAnElement("selectSec", locatorValue, "Sec");
		}

	}

	public void enterFromDateAndTodateInternalTracing(String locatorKey,String date) throws java.text.ParseException {

		/*DateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss");
	Date currentDate = new Date();

	System.out.println(dateFormat.format(currentDate));

	// convert date to calendar
	Calendar c = Calendar.getInstance();
	c.setTime(currentDate);

	// manipulate date

	c.add(Calendar.DATE, -5); // same with c.add(Calendar.DAY_OF_MONTH, 1);

	// convert calendar to date
	Date currentDateMinus = c.getTime();

	System.out.println(dateFormat.format(currentDateMinus));

	String monthBackDate = dateFormat.format(currentDateMinus);
	System.out.println(monthBackDate);*/
		Date date123 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        String returndate = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss").format(date123);

		String monthBackDate=returndate;
		String[] splitFullDate = monthBackDate.split(" ");
		String[] splitDate = splitFullDate[0].split("-");
		String[] splitTime = splitFullDate[1].split(":");
		for (int j = 0; j < splitDate.length; j++) {
			System.out.println("splitDate =" + splitDate[j]);

		}
		for (int i = 0; i < splitTime.length; i++) {
			System.out.println("splitTime =" + splitTime[i]);
		}

		String mon = splitDate[1];
		String yy = splitDate[0];
		String dd = splitDate[2];
		String hour = splitTime[0];
		String minute = splitTime[1];
		String sec = splitTime[2];
		if (dd.substring(0, 1).contains("0"))
			dd = dd.replace("0", "");
		if (minute.substring(0, 1).contains("0"))
			minute = minute.replace("0", "");
		if (sec.substring(0, 1).contains("0"))
			sec = sec.replace("0", "");
		String[] locatorMethodName = readProperties(locatorKey);
		String locatorMethod = locatorMethodName[0];
		String locatorValue = null;
		if (locatorKey.equals("selectMon")) {
			locatorValue = locatorMethodName[1].replace("<>", mon);
			clickAnElement("selectMon", locatorValue, "Month");
		}
		if (locatorKey.equals("selectYear")) {
			locatorValue = locatorMethodName[1].replace("<>", yy);
			clickAnElement("selectYear", locatorValue, "Year");
		}
		if (locatorKey.equals("selectDay")) {
			locatorValue = locatorMethodName[1].replace("<>", dd);
			clickAnElement("selectDay", locatorValue, "Day");
		}
		if (locatorKey.equals("selectHour")) {
			locatorValue = locatorMethodName[1].replace("<>", hour);
			clickAnElement("selectHour", locatorValue, "Hour");
		}
		if (locatorKey.equals("selectMin")) {
			locatorValue = locatorMethodName[1].replace("<>", minute);
			clickAnElement("selectMin", locatorValue, "Min");
		}
		if (locatorKey.equals("selectSec")) {
			locatorValue = locatorMethodName[1].replace("<>", sec);
			clickAnElement("selectSec", locatorValue, "Sec");
		}

	}
	public void clickAnElement(String locatorKey, String locatorValue, String strButtonLabel) {
		try {
			WebElement element = driver.findElement(By.xpath(locatorValue));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel, "Clicked " + strButtonLabel + " button successfully", "Pass", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Click on " + strButtonLabel, strButtonLabel, "Not able to click on  button " + strButtonLabel, "Fail", strReportFilename);
		}
	}

	public void clickAnElementWithOutReport(String locatorKey, String strButtonLabel) {
		try {
			WebElement element = getWebElement(locatorKey);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clearTextWithOutReport(String locatorKey) {
		try {
			WebElement element = getWebElement(locatorKey);
			waitForElementUsingPresence(locatorKey);
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void enterTextWithOutReport(String locatorKey, String data) {
		try {
			WebElement element = getWebElement(locatorKey);
			waitForElementUsingPresence(locatorKey);
			element.sendKeys(data);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public void verifyElementPresent(String label, String locatorKey) {
		try {
			WebElement element = getWebElement(locatorKey);
			boolean exists;
			if (element.isDisplayed())
				exists = true;
			else
				exists = false;

			if (exists)
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + label + " is present on the page", locatorKey, "The element " + label + " is present on the page", "Pass", strReportFilename);
			else
				reporter.writeStepResult(tc_id, scenarioName, "Verify " + label + " is present on the page", locatorKey, "The element " + label + " is not present on the page", "Fail", strReportFilename);
		} catch (Exception e) {
			reporter.writeStepResult(tc_id, scenarioName, "Verify " + label + " is present on the page", locatorKey, e.getMessage(), "Fail", strReportFilename);
		}
	}
	
	public void maskingAndUnMasking(String rowData){

		String username=getElementText("Footer_username");

		if (username.equalsIgnoreCase("qatest10")) {
			//List<List<String>> data= arg1.raw();

			if (rowData.startsWith("I1")) {
				String  strfileVal1= rowData.substring(4, 23);
				strfileVal1=strfileVal1.replaceAll("\\s+","");
				String maskingPart=strfileVal1.substring(5,strfileVal1.length()-4);


				if (!(strfileVal1.contains("*"))) {
					reporter.writeStepResult("I1", scenarioName, "Verify pan is not maskesd", "Pan Number : " + strfileVal1, "Pan " + strfileVal1 + " is not masked", "Pass", strReportFilename);
				} else {
					reporter.writeStepResult("I1", scenarioName, "Verify pan is not maskesd", "Pan Number : " + strfileVal1, "Pan " + strfileVal1 + " is masked", "Fail", strReportFilename);
				}

			}
			if (rowData.startsWith("30")) {
				String strfileVal1 = rowData.substring(3,22);
				strfileVal1=strfileVal1.replaceAll("\\s+","");
				String maskingPart=strfileVal1.substring(6,strfileVal1.length()-4);
				String strfileVal2 = rowData.substring(22,26);
				strfileVal2=strfileVal2.replaceAll("\\s+","");

				if (!(strfileVal1.contains("*") && strfileVal2.contains("*"))) {
					reporter.writeStepResult("30", scenarioName, "Verify pan is not maskesd", "Pan Number : "+strfileVal1+" Expire date :"+strfileVal2, "Pan "+strfileVal1+" Expire date :"+strfileVal2+" are not masked", "Pass", strReportFilename);
				} else {
					reporter.writeStepResult("30", scenarioName, "Verify pan is not maskesd", "Pan Number : "+strfileVal1+" Expire date :"+strfileVal2, "Pan "+strfileVal1+" Expire date :"+strfileVal2+" are masked", "Fail", strReportFilename);
				}

			}
			if (rowData.startsWith("TAB")) {
				String strfileVal1 = rowData.substring(48,67);
				strfileVal1=strfileVal1.replaceAll("\\s+","");
				String maskingPart=strfileVal1.substring(6,strfileVal1.length()-4);
				String strfileVal2 = rowData.substring(67,71);
				strfileVal2=strfileVal2.replaceAll("\\s+","");
				if (!(strfileVal1.contains("*") && strfileVal2.contains("*"))) {
					reporter.writeStepResult("TAB", scenarioName, "Verify pan is not maskesd", "Pan Number : "+strfileVal1+" Expire date :"+strfileVal2, "Pan "+strfileVal1+" Expire date :"+strfileVal2+" are not masked", "Pass", strReportFilename);
				} else {
					reporter.writeStepResult("TAB", scenarioName, "Verify pan is not maskesd", "Pan Number : "+strfileVal1+" Expire date :"+strfileVal2, "Pan "+strfileVal1+" Expire date :"+strfileVal2+" are masked", "Fail", strReportFilename);
				}

			}
			if (rowData.startsWith("05")) {
				String  strfileVal1= rowData.substring(2, 21);
				strfileVal1=strfileVal1.replaceAll("\\s+","");
				String maskingPart=strfileVal1.substring(6,strfileVal1.length()-4);
				if (!(strfileVal1.contains("*"))) {
					reporter.writeStepResult("05", scenarioName, "Verify pan is not maskesd", "Pan Number : " + strfileVal1, "Pan " + strfileVal1 + " is not masked", "Pass", strReportFilename);
				} else {
					reporter.writeStepResult("05", scenarioName, "Verify pan is not maskesd", "Pan Number : " + strfileVal1, "Pan " + strfileVal1 + " is masked", "Fail", strReportFilename);
				}

			}

			if (rowData.startsWith("Finance record")) {
				String strfileVal1 = rowData.substring(11,27);
				String maskingPart=strfileVal1.substring(6,strfileVal1.length()-4);

				String strfileVal2 = rowData.substring(39,43);
				if (!(strfileVal1.contains("*") && strfileVal2.contains("*"))) {
					reporter.writeStepResult("Finance record", scenarioName, "Verify pan is not maskesd", "Pan Number : "+strfileVal1+" Expire date :"+strfileVal2, "Pan "+strfileVal1+" Expire date :"+strfileVal2+" are not masked", "Pass", strReportFilename);
				} else {
					reporter.writeStepResult("Finance record", scenarioName, "Verify pan is not maskesd", "Pan Number : "+strfileVal1+" Expire date :"+strfileVal2, "Pan "+strfileVal1+" Expire date :"+strfileVal2+" are masked", "Fail", strReportFilename);
				}

			}

			//<AcctNum>
			if (rowData.contains("<AcctNum>")) {
				String[] strfileVal1 = rowData.split("<AcctNum>");
				String[] cardNum = strfileVal1[1].split("</AcctNum>");
				String maskingPart=cardNum[0].substring(6,cardNum[0].length()-4);
				String[] strfileVal2 = rowData.split("<CardExp>");
				String[] expire = strfileVal2[1].split("</CardExp>");

				if (!(cardNum[0].contains("*") && expire[0].contains("*"))) {
					reporter.writeStepResult("AcctNum & CardExp", scenarioName, "Verify pan is not maskesd", "Pan Number : "+cardNum[0]+" Expire date :"+expire[0], "Pan "+cardNum[0]+" Expire date :"+expire[0]+" are not masked", "Pass", strReportFilename);
				} else {
					reporter.writeStepResult("AcctNum & CardExp", scenarioName, "Verify pan is not maskesd", "Pan Number : "+cardNum[0]+" Expire date :"+expire[0], "Pan "+cardNum[0]+" Expire date :"+expire[0]+" are masked", "Fail", strReportFilename);
				}


			}

		}



		if (username.equalsIgnoreCase("qatest9")) {
			//List<List<String>> data= arg1.raw();

			if (rowData.startsWith("I1")) {
				String  strfileVal1= rowData.substring(4, 23);
				strfileVal1=strfileVal1.replaceAll("\\s+","");
				String maskingPart=strfileVal1.substring(6,strfileVal1.length()-4);
				String unMaskingFront=strfileVal1.substring(0, 6);
				String unMaskingLast=strfileVal1.substring(strfileVal1.length()-4, strfileVal1.length());
				String concat=unMaskingFront+unMaskingLast;
				boolean flag=true;
				for (int i = 0; i < maskingPart.length()-1; i++) {
					if ((!(maskingPart.charAt(i)=='*')) || (concat.contains("*")))
						{
							flag=false;
							break;
						}
				}
					if(flag){	
						reporter.writeStepResult("I1", scenarioName, "Verify pan is masked", "Pan Number : " + strfileVal1, "Pan " + strfileVal1 + " is masked", "Pass", strReportFilename);
					}
					else {
						reporter.writeStepResult("I1", scenarioName, "Verify pan is masked", "Pan Number : " + strfileVal1, "Pan " + strfileVal1 + " is not masked", "Fail", strReportFilename);
					}
				}
			
				if (rowData.startsWith("30")) {
					String strfileVal1 = rowData.substring(3,22);
					strfileVal1=strfileVal1.replaceAll("\\s+","");
					String maskingPart=strfileVal1.substring(6,strfileVal1.length()-4);
					String strfileVal2 = rowData.substring(22,26);
					strfileVal2=strfileVal2.replaceAll("\\s+","");
					String unMaskingFront=strfileVal1.substring(0, 6);
					String unMaskingLast=strfileVal1.substring(strfileVal1.length()-4, strfileVal1.length());
					String concat=unMaskingFront+unMaskingLast;
				boolean flag = true;
				for (int i = 0; i < maskingPart.length() - 1; i++) {
					if ((!(maskingPart.charAt(i)=='*')) || concat.contains("*") || !strfileVal2.equals("****")) {
						flag = false;
						break;
					}

				}
				if (flag) {
					reporter.writeStepResult("30", scenarioName, "Verify pan is masked", "Pan Number : " + strfileVal1 + " Expire date :" + strfileVal2, "Pan " + strfileVal1 + " Expire date :" + strfileVal2 + " are masked", "Pass", strReportFilename);
				} else {
					reporter.writeStepResult("30", scenarioName, "Verify pan is masked", "Pan Number : " + strfileVal1 + " Expire date :" + strfileVal2, "Pan " + strfileVal1 + " Expire date :" + strfileVal2 + " are not masked", "Fail", strReportFilename);
				}

				}
				if (rowData.startsWith("TAB")) {
					String strfileVal1 = rowData.substring(48,67);
					strfileVal1=strfileVal1.replaceAll("\\s+","");
					String maskingPart=strfileVal1.substring(6,strfileVal1.length()-4);
					String strfileVal2 = rowData.substring(67,71);
					strfileVal2=strfileVal2.replaceAll("\\s+","");
					String unMaskingFront=strfileVal1.substring(0, 6);
					String unMaskingLast=strfileVal1.substring(strfileVal1.length()-4, strfileVal1.length());
					String concat=unMaskingFront+unMaskingLast;
					boolean flag = true;
					for (int i = 0; i < maskingPart.length() - 1; i++) {
						if ((!(maskingPart.charAt(i)=='*')) || concat.contains("*") || !strfileVal2.equals("****"))
						{
							flag = false;
							break;
						}

					}
					if (flag) {
						reporter.writeStepResult("TAB", scenarioName, "Verify pan is masked", "Pan Number : "+strfileVal1+" Expire date :"+strfileVal2, "Pan "+strfileVal1+" Expire date :"+strfileVal2+" are masked", "Pass", strReportFilename);
					} else {
						reporter.writeStepResult("TAB", scenarioName, "Verify pan is masked", "Pan Number : "+strfileVal1+" Expire date :"+strfileVal2, "Pan "+strfileVal1+" Expire date :"+strfileVal2+" are not masked", "Fail", strReportFilename);
					}

				}
				if (rowData.startsWith("05")) {
					String  strfileVal1= rowData.substring(2, 21);
					strfileVal1=strfileVal1.replaceAll("\\s+","");
					String maskingPart=strfileVal1.substring(6,strfileVal1.length()-4);
					String unMaskingFront=strfileVal1.substring(0, 6);
					String unMaskingLast=strfileVal1.substring(strfileVal1.length()-4, strfileVal1.length());
					String concat=unMaskingFront+unMaskingLast;
					boolean flag=true;
					for (int i = 0; i < maskingPart.length()-1; i++) {
						if ((!(maskingPart.charAt(i)=='*')) || (concat.contains("*")))
							{
								flag=false;
								break;
							}

					}	
						if(flag){	
					reporter.writeStepResult("05", scenarioName, "Verify pan is masked", "Pan Number : " + strfileVal1, "Pan " + strfileVal1 + " is masked", "Pass", strReportFilename);
					} else {
						reporter.writeStepResult("05", scenarioName, "Verify pan is masked", "Pan Number : " + strfileVal1, "Pan " + strfileVal1 + " is not masked", "Fail", strReportFilename);
					}

				}

				if (rowData.startsWith("Finance record")) {
					String strfileVal1 = rowData.substring(11,27);
					String maskingPart=strfileVal1.substring(6,strfileVal1.length()-4);

					String strfileVal2 = rowData.substring(39,43);
					String unMaskingFront=strfileVal1.substring(0, 6);
					String unMaskingLast=strfileVal1.substring(strfileVal1.length()-4, strfileVal1.length());
					String concat=unMaskingFront+unMaskingLast;
					boolean flag = true;
					for (int i = 0; i < maskingPart.length() - 1; i++) {
						if ((!(maskingPart.charAt(i)=='*')) || concat.contains("*") || !strfileVal2.equals("****"))
						{
							flag = false;
							break;
						}

					}
					if (flag) {
						reporter.writeStepResult("Finance record", scenarioName, "Verify pan is masked", "Pan Number : "+strfileVal1+" Expire date :"+strfileVal2, "Pan "+strfileVal1+" Expire date :"+strfileVal2+" are masked", "Pass", strReportFilename);
					} else {
						reporter.writeStepResult("Finance record", scenarioName, "Verify pan is masked", "Pan Number : "+strfileVal1+" Expire date :"+strfileVal2, "Pan "+strfileVal1+" Expire date :"+strfileVal2+" are not masked", "Fail", strReportFilename);
					}

				}

				//<AcctNum>
				if (rowData.contains("<AcctNum>")) {
					String[] strfileVal1 = rowData.split("<AcctNum>");
					String[] cardNum = strfileVal1[1].split("</AcctNum>");
					String maskingPart=cardNum[0].substring(6,cardNum[0].length()-4);
					String[] strfileVal2 = rowData.split("<CardExp>");
					String[] expire = strfileVal2[1].split("</CardExp>");
					String unMaskingFront=cardNum[0].substring(0, 6);
					String unMaskingLast=cardNum[0].substring(cardNum[0].length()-4, cardNum[0].length());
					String concat=unMaskingFront+unMaskingLast;
					boolean flag = true;
					for (int i = 0; i < maskingPart.length() - 1; i++) {
						if ((!(maskingPart.charAt(i)=='*')) || concat.contains("*") || !expire[0].equals("****"))
						{
							flag = false;
							break;
						}

					}
					if (flag) {
						reporter.writeStepResult("AcctNum & CardExp", scenarioName, "Verify pan is masked", "Pan Number : "+cardNum[0]+" Expire date :"+expire[0], "Pan "+cardNum[0]+" Expire date :"+expire[0]+" are masked", "Pass", strReportFilename);
					} else {
						reporter.writeStepResult("AcctNum & CardExp", scenarioName, "Verify pan is masked", "Pan Number : "+cardNum[0]+" Expire date :"+expire[0], "Pan "+cardNum[0]+" Expire date :"+expire[0]+" are not masked", "Fail", strReportFilename);
					}


				}

			}
		}
		public String getElementText(String locatorKey) {
			WebElement element = getWebElement(locatorKey);
			waitForElementUsingPresence(locatorKey);
			String actualText = element.getText().trim();
			//System.out.println(actualText);
			return actualText;
		}
		public String getElementTextValue(String locatorKey) {
			WebElement element = getElementFluentWait(locatorKey);
			waitForElementUsingPresence(locatorKey);
			String actualText = element.getAttribute("value");
			System.out.println(actualText);
			/*if(actualText==null){
				actualText="";
			}*/
			return actualText;
		}

		public void enterLoginText(String locatorKey, String data) {
			try {
				WebElement element = getWebElement(locatorKey);
				waitForElementUsingPresence(locatorKey);
				element.sendKeys(data);
				// reporter.writeStepResult(tc_id, scenarioName, "Enter Value in
				// text field", data, "Value " + data + " entered successfully",
				// "Pass", strReportFilename);
			} catch (Exception e) {
				// reporter.writeStepResult(tc_id, scenarioName, "Enter Value in
				// text field", data, "Unable to enter value " + data, "Fail",
				// strReportFilename);
			}
		}
		public void clickLoginElement(String locatorKey, String strButtonLabel) {
			try {
				WebElement element = getWebElement(locatorKey);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				// reporter.writeStepResult(tc_id, scenarioName, "Click on " +
				// strButtonLabel, strButtonLabel, "Clicked " + strButtonLabel + "
				// button successfully", "Pass", strReportFilename);
			} catch (Exception e) {
				// reporter.writeStepResult(tc_id, scenarioName, "Click on " +
				// strButtonLabel, strButtonLabel, "Not able to click on button " +
				// strButtonLabel, "Fail", strReportFilename);
			}
		}
		public void enterToDate(String locatorKey) {

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss");
			Date currentDate = new Date();

			System.out.println(dateFormat.format(currentDate));

			// convert date to calendar
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);

			// manipulate date

			c.add(Calendar.DATE, 0); // same with c.add(Calendar.DAY_OF_MONTH, 1);

			// convert calendar to date
			Date currentDateMinus = c.getTime();

			System.out.println(dateFormat.format(currentDateMinus));

			String monthBackDate = dateFormat.format(currentDateMinus);
			System.out.println(monthBackDate);
			String[] splitFullDate = monthBackDate.split(" ");
			String[] splitDate = splitFullDate[0].split("-");
			String[] splitTime = splitFullDate[1].split(":");
			for (int j = 0; j < splitDate.length; j++) {
				System.out.println("splitDate =" + splitDate[j]);

			}
			for (int i = 0; i < splitTime.length; i++) {
				System.out.println("splitTime =" + splitTime[i]);
			}
			String Tomon = splitDate[1];
			String Toyy = splitDate[0];
			String Todd = splitDate[2];
			int tohour = Integer.parseInt(splitTime[0]) - 1;
			String Tohour = String.valueOf(tohour);
			String Tominute = splitTime[1];
			String Tosec = splitTime[2];
			if (Todd.substring(0, 1).contains("0"))
				Todd = Todd.replace("0", "");
			if (Tominute.substring(0, 1).contains("0"))
				Tominute = Tominute.replace("0", "");
			if (Tosec.substring(0, 1).contains("0"))
				Tosec = Tosec.replace("0", "");
			String[] locatorMethodName = readProperties(locatorKey);
			String locatorMethod = locatorMethodName[0];
			String locatorValue = null;
			if (locatorKey.equals("selectMon")) {
				locatorValue = locatorMethodName[1].replace("<>", Tomon);
				clickAnElement("selectMon", locatorValue, "Month");
			}
			if (locatorKey.equals("selectYear")) {
				locatorValue = locatorMethodName[1].replace("<>", Toyy);
				clickAnElement("selectYear", locatorValue, "Year");
			}
			if (locatorKey.equals("selectDay")) {
				locatorValue = locatorMethodName[1].replace("<>", Todd);
				clickAnElement("selectDay", locatorValue, "Day");
			}
			if (locatorKey.equals("selectHour")) {
				locatorValue = locatorMethodName[1].replace("<>", Tohour);
				clickAnElement("selectHour", locatorValue, "Hour");
			}
			if (locatorKey.equals("selectMin")) {
				locatorValue = locatorMethodName[1].replace("<>", Tominute);
				clickAnElement("selectMin", locatorValue, "Min");
			}
			if (locatorKey.equals("selectSec")) {
				locatorValue = locatorMethodName[1].replace("<>", Tosec);
				clickAnElement("selectSec", locatorValue, "Sec");
			}

		}
		public List<Map<String, String>> getCollectionFromTableForBigBatch(String xpathForTable, String[] columnName, RemoteWebDriver webDriver, String xpathForRowResult1, String xpathForRowResult2) {
			// StepExecutor stepExecutor = new StepExecutor(reporter);
			List<Map<String, String>> allTableDetails = new ArrayList();
			String[] Stringresult = xpathForRowResult1.split("#");
			xpathForRowResult1 = Stringresult[1];
			System.out.println();

			int totalNumOfRows = 0;
			if (xpathForTable.contains(".//*[@id='searchResult_BB']/thead/tr/th")) {
				String xpathForTableRows = "//*[@id='g2InboungF-ileRecordDetailsForm']/table[2]/tbody/tr/td[3]";
				String ele = webDriver.findElementByXPath(xpathForTableRows).getText().trim();
				ele = ele.substring(ele.indexOf("-") + 1, ele.length());
				System.out.println(ele);
				totalNumOfRows = Integer.parseInt(ele);
			} else if (xpathForTable.contains(".//*[@id='searchResult_INTERNAL_TRACE']/thead/tr/th")) {
				String xpathForTableRows = "//*[@id='RecorDetailsResultContainer']/table[2]/tbody/tr/td[3]";
				String ele = webDriver.findElementByXPath(xpathForTableRows).getText().trim();
				ele = ele.substring(ele.indexOf("-") + 1, ele.length());
				System.out.println(ele);
				totalNumOfRows = Integer.parseInt(ele);
			}

			totalNumOfRows = webDriver.findElementsByXPath(xpathForRowResult1).size();

			System.out.println();
			for (int j = 1; j <= totalNumOfRows; j++) {
				LinkedHashMap<String, String> tableFromUI = new LinkedHashMap<>();

				for (int i = 1; i <= columnName.length; i++) {

					String appendColName = "[contains(text(),'" + columnName[i - 1] + "')]";

					String xpathHeader = xpathForTable + appendColName;
					int colIndex = getColumnIndexFromTableForBigBatch(xpathForTable, columnName[i - 1], webDriver);
					if (xpathForTable.equalsIgnoreCase(".//*[@id='searchResult_BB']/thead/tr/th") || xpathForTable.equalsIgnoreCase("//table[@id='searchResult']/thead/tr/th") || xpathForTable.equalsIgnoreCase("//table[@id='searchResult3']/thead/tr/th") || xpathForTable.equalsIgnoreCase(".//*[@id='searchResult_INTERNAL_TRACE']/thead/tr/th"))
						colIndex = colIndex;
					else
						colIndex = colIndex + 1;
					// List<WebElement> listOfElement =
					// webDriver.findElementsByXPath(xpathHeader);
					String abc = xpathForRowResult1 + "[" + j + "]/td[" + colIndex + "]";
					WebElement e = getWebElementByXpath(abc.trim(), webDriver);
					String rowValueForHeader = e.getText();
					System.out.println(rowValueForHeader);

					tableFromUI.put(columnName[i - 1], rowValueForHeader);

				}

				allTableDetails.add(tableFromUI);
			}
			return allTableDetails;
		}
		public int getColumnIndexFromTableForBigBatch(String xpathForTable, String columnName, RemoteWebDriver webDriver) {
			String[] Stringresult = xpathForTable.split("#");
			xpathForTable = Stringresult[1];
			List<WebElement> tableHeaders = webDriver.findElementsByXPath(xpathForTable);
			String xpathForColName = xpathForTable;

			int count = 1;
			for (int i = 2; i <= tableHeaders.size(); i++) {
				String headerName = webDriver.findElementByXPath(("(" + xpathForColName + ")[" + i + "]")).getText();
				if (headerName.equals(columnName)) {
					return count;
				}
				count++;
			}
			return count;
		}

		public WebElement getWebElementByXpath(String xpath, RemoteWebDriver webDriver) {
			WebElement element = null;
			try {
				element = webDriver.findElementByXPath(xpath);

				return element;
			} catch (Exception e) {
				System.out.println("Element not found for " + xpath);
			}
			return element;
		}

	public List<Map<String, String>> getCollectionOfUIData(String xpathForTable, String[] columnName, RemoteWebDriver webDriver, String xpathForRowResult1) {
		List<Map<String, String>> allTableDetails = new ArrayList();
		String[] Stringresult = xpathForTable.split("#");
		xpathForTable = Stringresult[1];
		System.out.println();

		LinkedHashMap<String, String> tableFromUI = new LinkedHashMap<>();

		for (int i = 1; i <= columnName.length; i++) {

			String appendColName = "[contains(text(),'" + columnName[i - 1] + "')]/following-sibling::span";

			String xpathHeader = xpathForTable + appendColName;

			String xpath = xpathForTable + "[contains(text(),'" + columnName[i - 1] + "')]";

			String rowValueForHeader = "";

			if (FunctionsLibrary.driver.findElements(By.xpath(xpathHeader)).size()==0) {

				rowValueForHeader = "";

			} else {
				WebElement e = getWebElementByXpath(xpathHeader.trim(), webDriver);
				rowValueForHeader = e.getText();
				System.out.println(rowValueForHeader);
			}

			tableFromUI.put(columnName[i - 1], rowValueForHeader);
			allTableDetails.add(tableFromUI);
		}

		return allTableDetails;
	}

		public Map<String, String> jsonMapValues() throws Throwable {
			Map<String, String> inputExpMap = new HashMap<String, String>();
			String headerNamesSelectedTran =new ExecutionerClass().setEnv().getProperty("selectedTransactionNm");
			//String headerNamesSelectedTran = new ApplicationPropertiesInitializer().getApplicationDataObject().getProperty("selectedTransactionNm");
			String[] headerNamesSelectedTrnsaction = headerNamesSelectedTran.split("\\|");
			for (int i = 0; i < headerNamesSelectedTrnsaction.length; i++) {
				String arg2 = parseJson(headerNamesSelectedTrnsaction[i], tc_id, "Input");
				inputExpMap.put(headerNamesSelectedTrnsaction[i], arg2.replace("[/[/]\"]+", ""));
			}
			return inputExpMap;
		}
		public Map<String, String> jsonMapValues(String keyName) throws Throwable {
			Map<String, String> inputExpMap = new HashMap<String, String>();
            String headerNamesSelectedTran=new ExecutionerClass().setEnv().getProperty(keyName.replace(" ", "_"));		
			//String headerNamesSelectedTran = new ApplicationPropertiesInitializer().getApplicationDataObject().getProperty(keyName.replace(" ", "_"));
			String[] headerNamesSelectedTrnsaction = headerNamesSelectedTran.split("\\|");
			for (int i = 0; i < headerNamesSelectedTrnsaction.length; i++) {
				String arg2 = parseJson(headerNamesSelectedTrnsaction[i], tc_id, keyName);
				inputExpMap.put(headerNamesSelectedTrnsaction[i], arg2.replaceAll("[\\[\\]\"]+",""));
			}
			return inputExpMap;
		}
		/*Parse Json*/
		public String parseJson(String data, String testCaseID, String ipop) {

			String value = "";
			JSONParser parser = new JSONParser();
			try {
				Object obj = parser.parse(new FileReader("Data/NewContract.json"));
				System.out.println();
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
					}else{
						try{
							Object in = map.get(ipop);
							Map map1 = (Map) in;
							value = map1.get(data).toString();
						}catch(Exception e){
							System.out.println("Not foudn for :"+ipop+"  "+data);
						}
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
		
		
		public ArrayList<String> parseJsonData(String data, String testCaseID, String filename) {
			ArrayList<String> value = new ArrayList<String>();
			JSONParser parser = new JSONParser();
			try {
				Object obj = parser.parse(new FileReader("Data/" + filename + ".json"));

				JSONObject lev1 = (JSONObject) obj;
				Object jObj = lev1.get(testCaseID);
				if (jObj instanceof Map) {
					HashMap<String, ArrayList<String>> map = (HashMap<String, ArrayList<String>>) jObj;
					Object in = map.get("Input");
					HashMap<String, ArrayList<String>> map1 = (HashMap<String, ArrayList<String>>) in;
					// Object input=map1.get(data);
					// HashMap<String, ArrayList<String>> parseData=
					// (HashMap<String, ArrayList<String>>) input;
					for (Entry<String, ArrayList<String>> entry : map1.entrySet()) {
						for (int i = 0; i < entry.getValue().size(); i++) {
							String val = entry.getValue().get(i);
							value.add(val);
						}
					}
					System.out.println(" " + value);
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
		
		public void globalWait(int seconds) {
			try {
				for (int i = 0; i < seconds; i++) {
					Thread.sleep(1000);

				}
			} catch (Exception e1) {

			}
		}
		public Map<String, String> getDataMessagePayLoad(String msgPayload) throws Throwable {
			Map<String, String> mapUIacqresmsgPay = new HashMap<String, String>();
			String[] acqresmsgPay=msgPayload.split("\\n");
			for(String acqrespmsg : acqresmsgPay)
			{
				if(acqrespmsg.contains(":"))
				{
					String expacqrespmsg[]=acqrespmsg.split("\\:");
					mapUIacqresmsgPay.put(expacqrespmsg[0].trim(), expacqrespmsg[1].replaceAll("[\\[\\]]+","").trim());

				}
				else
				{
					String expacqrespmsg[]=acqrespmsg.split("\\s+");
					mapUIacqresmsgPay.put(expacqrespmsg[0].trim(), expacqrespmsg[2].replaceAll("[\\[\\]]+", "").trim());
				}
			}
			return mapUIacqresmsgPay;

		}
		
		/**
		 * Parse the test data
		 */
		public Map<String, String> parse(String testCaseID, String filename) {
			String Value = "";
			Map<String, String> keyVal = new HashMap<String, String>();
			try {
				ObjectMapper mapper = new ObjectMapper();
				Map<String, Map<String, String>> map = mapper.readValue(new File("Data/" + filename + ".json"),
						new TypeReference<Map<String, Map<String, String>>>() {
						});

						
				System.out.println("Map is " + map);

				String key = "";
				String val = "";
				for (int i = 1; i <= map.size(); i++) {
					Map<String, String> str = map.get(testCaseID);

					for (Entry<String, String> data : str.entrySet()) {
						System.out.println("Key is " + data.getKey() + "; Value is " + data.getValue());
						key = data.getKey();
						val = data.getValue();
						keyVal.put(key, val);
					}
				}
				// Value=keyVal.get(value);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println();
			}
			return keyVal;
		}
		
		/**
		 * Login to the application
		 * 
		 * @throws Exception
		 */
		public void loginApplication() throws Exception {
			EncryptFileData encryptFile = new EncryptFileData();
			Properties config = new ExecutionerClass().setEnv();
			if (!Boolean.valueOf(config.getProperty("isFileDataEncrypted"))) {
				try {
					encryptFile.encryptConfigFileData("Password");
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (InvalidKeySpecException e) {
					e.printStackTrace();
				}
				encryptFile.serializeKeys();
			}
			config = new ExecutionerClass().setEnv();
			final String userName = config.getProperty("Username");
			EncryptFileData.secretKey = encryptFile.deserializeKey();

			final String password = encryptFile.decrypt(config.getProperty("Password"), EncryptFileData.secretKey);
			System.out.println("Decrypted password : " + password);

			String browser=config.getProperty("browser");

			try {
				if ((browser.equalsIgnoreCase("IE")) || (browser.equalsIgnoreCase("InternetExplorer"))) {
					login(userName, password);

				} else if (browser.equalsIgnoreCase("Chrome")) {
					login(userName, password);
				} else if (browser.equalsIgnoreCase("FireFox")) {
					runScript("FireFoxAutoIt.exe");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	
		/**
		 * login
		 * 
		 * @throws AWTException
		 * @throws InterruptedException
		 */
		public void login(String userName, String password) throws AWTException, InterruptedException {
			Robot r = new Robot();
			StringSelection selection = new StringSelection(userName);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);
			System.out.println(clipboard);
			Thread.sleep(3000);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_C);
			Thread.sleep(500);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			Thread.sleep(500);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			selection = new StringSelection(password);
			Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard1.setContents(selection, selection);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_C);
			Thread.sleep(500);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
		}
		
		public void runScript(String strScriptName) {
			if (strScriptName.contains(".exe")) {
				try {
					Runtime.getRuntime().exec("\"" + strVBScriptsPath + "\\" + strScriptName + "\"");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (strScriptName.contains(".vbs")) {
				try {
					Runtime.getRuntime().exec("wscript.exe \"" + strVBScriptsPath + "\\" + strScriptName + "\"");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		/**
		 * Verify drop down
		 */
		public void verifyDropdownvalues(String locatorKey, String expectedvalue) {
			boolean exists = false;
			WebElement element=getWebElement(locatorKey);
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement we : options) {
				if (we.getText().equals(expectedvalue)) {
					we.click();
					exists = true;
				}
			}
			if (exists) {
				reporter.writeStepResult(tc_id, scenarioName, "User verifies dropdown values",
						"User verifies " + expectedvalue + " dropdown value is present",
						"the " + expectedvalue + " dropdown value is present", "Pass", strReportFilename);
			} else {
				reporter.writeStepResult(tc_id, scenarioName, "User verifies dropdown values",
						"User verifies " + expectedvalue + " dropdown value is present",
						"the " + expectedvalue + " dropdown value is not present", "Fail", strReportFilename);
			}
		}
		
		public void verifyDropDownValNotPresent(String locatorKey, String expectedvalue) {
			boolean notExist = false;
			WebElement element=getWebElement(locatorKey);
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement we : options) {
				if (!we.getText().equals(expectedvalue)) {
					notExist = true;
				}
			}
			if (notExist) {
				reporter.writeStepResult(tc_id, scenarioName, "User verifies dropdown values",
						"User verifies " + expectedvalue + " dropdown values present",
						"Expectedvalue : " + expectedvalue + " dropdown values are not present", "Pass", strReportFilename);
			} else {
				reporter.writeStepResult(tc_id, scenarioName, "User verifies dropdown values",
						"User verifies " + expectedvalue + " dropdown values present",
						"Expectedvalue : " + expectedvalue + " dropdown values are present", "Fail", strReportFilename);
			}
		}
		/**
		 * Verify drop down values which are not present
		 */
		public void verifyDropDownValuesNotPresent(String locatorKey, String expectedvalue) {
			boolean notExist = false;
			String[] arrListValues;
			arrListValues = expectedvalue.split(";");
			WebElement element=getWebElement(locatorKey);
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			
			for(int i=0; i<arrListValues.length;i++){
			for (WebElement we : options) {
				if (!we.getText().equals(arrListValues[i])) {
					notExist = true;
				}
			}
			if (notExist) {
				reporter.writeStepResult(tc_id, scenarioName, "User verifies dropdown values",
						"User verifies " + arrListValues[i] + " dropdown values present",
						"the " + arrListValues[i] + " dropdown values are not present", "Pass", strReportFilename);
			} else {
				reporter.writeStepResult(tc_id, scenarioName, "User verifies dropdown values",
						"User verifies " + arrListValues[i] + " dropdown values present",
						"the " + arrListValues[i] + " dropdown values are present", "Fail", strReportFilename);
			}
			}
		}
		
		/**
		 * Verify Element in sales channel summary report in Reporting page
		 */
		public boolean verifyElementinSalesChannelSummaryReport(List<WebElement> element, String data) {
			boolean elementPresent = false;
			for (int i = 3; i < element.size(); i++) {
				WebElement ele = driver
						.findElement(By.xpath("//tbody[tr[td[div[text()='Sales Office']]]]//tr["+i+"]//td//div"));
				String text = ele.getText();
				if (text.equalsIgnoreCase(data)) {
					System.out.println("ISO1 is present");
					elementPresent = true;
					break;
				}
			}
			return elementPresent;
		}
		
		/**
		 * Launch an application
		 */
		public void launchApplication(String URL) {
			driver.get(URL);
		}
		
		
		/**************************/
		public Connection connectDB(String strServerURL, String strDriver, String strUsername,String strPassword){
			try {
				Class.forName(strDriver); //Or any other driver
			}catch(Exception x){
				System.out.println("Unable to load the driver class!");
			}
			Connection dbConnection = null;
			try{

				dbConnection = DriverManager.getConnection(strServerURL,strUsername,strPassword);
				//dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@10.20.84.44:1523:TARLS03","cmf","cmfcmf");
			}
			catch(SQLException x){
				x.printStackTrace();			
				System.out.println("Couldn’t get connection!");
			}
			return dbConnection;
		}
		public void verifyElementPresent(String label, WebElement locatorKey) {
			
			try {
				
				WebElement element = locatorKey;
				boolean exists;
				if (element.isDisplayed())
					exists = true;
				else
					exists = false;

				if (exists)
					reporter.writeStepResult(tc_id, scenarioName, "merchnatcardsverify",
							"merchnatcardsverify : " + label + "ed", "merchnatcardsverify : " + label + "ed", "Pass",
							strReportFilename);
					
				else
					
					reporter.writeStepResult(tc_id, scenarioName, "merchnatcardsverify",
							"merchnatcardsverify : " + label+ "ed", "merchnatcardsverify : " + label + "ed", "fail",
							strReportFilename);
			} catch (Exception e) {
				reporter.writeStepResult(tc_id, scenarioName, "merchnatcardsverify",
						"merchnatcardsverify : " + label+ "ed", "merchnatcardsverify : " + label + "ed", "fail",
						strReportFilename);
			}
		}
		

		public void verifyDatabaseValues(String strDBInfo, String strQuery, String strExpectedValues){
			String strServerURL = null;
			String strUsername = null;
			String strPassword = null;
//			String strDetails = utils.getDataFileInfo();
//			String [] arrDetails = strDetails.split("_");
			String [] arrDBInfoDetails = null;
			//int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);
			List<String> lstColumnValues = new ArrayList<String>(0);
			List<String> lstWrongColumnValues = new ArrayList<String>(0);
			//strDataFileName = "D:\\Official\\Workspace\\Cafe 2.2\\data\\CTest\\Ctest_Data.xls";
			System.out.println("");
			//String strDBInfoValues = scriptExecutor.readDataFile(strDataFileName, rowNumber, strDBInfo);
			arrDBInfoDetails = strDBInfo.split("@@");
			strServerURL = arrDBInfoDetails[0];
			strUsername = arrDBInfoDetails[1];
			strPassword = arrDBInfoDetails[2];
			Connection dbConnection = null;
			dbConnection = connectDB(strServerURL, "oracle.jdbc.driver.OracleDriver", strUsername, strPassword);

			//String strExpectedValues = scriptExecutor.readDataFile(strDataFileName, rowNumber, strDataColumnName);
			String [] arrExpectedValues = strExpectedValues.split("@@");
			String strActualValue = null;
			strExpectedValues = strExpectedValues.replace("@@", " || ");
			System.out.println("strQuery "+strQuery);
			if(dbConnection != null){
				Statement stmt = null;
				ResultSet rs = null;
				try {
					stmt = dbConnection.createStatement();
					rs = stmt.executeQuery(strQuery);

					while(rs.next()){
						for(int i=1; i<=arrExpectedValues.length;i++){
							strActualValue =  rs.getObject(i).toString();
							System.out.println(strActualValue);
							lstColumnValues.add(strActualValue);
						}
					}

					int counter = 0;
					for(int i=0;i<lstColumnValues.size();i++){
						System.out.println("**************DB Value "+lstColumnValues.get(i)+" Expected "+arrExpectedValues[i]);
						if(lstColumnValues.get(i).equals(arrExpectedValues[i])){
							counter++;
						}else{
							lstWrongColumnValues.add(lstColumnValues.get(i));
						}
					}
					String strWrongValues = "";
					if(lstWrongColumnValues.size()>0){
						for(int x=0; x<lstWrongColumnValues.size(); x++){
							strWrongValues = strWrongValues.concat(" || ").concat(lstWrongColumnValues.get(x));
						}
					}
					if(counter==arrExpectedValues.length){
						// reporter.writeStepResult(tc_id, scenarioName, "Enter Value in
						// text field", data, "Unable to enter value " + data, "Fail",
						// strReportFilename);
						reporter.writeStepResult(tc_id, scenarioName, "Data Base validations", strExpectedValues, strActualValue, "Pass", "Expected value(s) present in the database");
					}else{
						reporter.writeStepResult(tc_id, scenarioName, "Data Base validations", strExpectedValues, strActualValue, "Fail", "Expected value(s) are not present in the database");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						rs.close();
						dbConnection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				reporter.writeStepResult(tc_id, scenarioName, "Data Base validations", strExpectedValues, strActualValue, "Fail", "Unable to connect to database");
			}
		}

		public void verifyDatabaseValuesExpectedDynamic(String strDBInfo, String strQuery, String strExpectedValues){
			String strServerURL = null;
			String strUsername = null;
			String strPassword = null;
			//String strDetails = utils.getDataFileInfo();
			//String [] arrDetails = strDetails.split("_");
			String [] arrDBInfoDetails = null;
			List<String> lstColumnValues = new ArrayList<String>(0);
			List<String> lstWrongColumnValues = new ArrayList<String>(0);
			//strDataFileName = "D:\\Official\\Workspace\\Cafe 2.2\\data\\CTest\\Ctest_Data.xls";
			System.out.println("strQuery:   "+strQuery);
			arrDBInfoDetails = strDBInfo.split("@@");
			strServerURL = arrDBInfoDetails[0];
			strUsername = arrDBInfoDetails[1];
			strPassword = arrDBInfoDetails[2];
			Connection dbConnection = null;
			dbConnection = connectDB(strServerURL, "oracle.jdbc.driver.OracleDriver", strUsername, strPassword);


			String [] arrExpectedValues = strExpectedValues.split("@@");
			String strActualValue = null;
			strExpectedValues = strExpectedValues.replace("@@", " || ");

			if(dbConnection != null){
				Statement stmt = null;
				ResultSet rs = null;
				try {
					stmt = dbConnection.createStatement();
					rs = stmt.executeQuery(strQuery);

					while(rs.next()){
						for(int i=1; i<=arrExpectedValues.length;i++){
							strActualValue =  rs.getObject(i).toString();
							System.out.println(strActualValue);
							lstColumnValues.add(strActualValue);
						}
					}

					int counter = 0;
					for(int i=0;i<lstColumnValues.size();i++){
						System.out.println("**************DB Value "+lstColumnValues.get(i)+" Expected"+arrExpectedValues[i]);
						if(lstColumnValues.get(i).equals(arrExpectedValues[i])){
							counter++;
						}else{
							lstWrongColumnValues.add(lstColumnValues.get(i));
						}
					}
					String strWrongValues = "";
					if(lstWrongColumnValues.size()>0){
						for(int x=0; x<lstWrongColumnValues.size(); x++){
							strWrongValues = strWrongValues.concat(" || ").concat(lstWrongColumnValues.get(x));
						}
					}
					if(counter==arrExpectedValues.length){
						reporter.writeStepResult(tc_id, scenarioName, "Data Base validations", strExpectedValues, strActualValue, "Pass", "Expected value(s) present in the database");
					}else{
						reporter.writeStepResult(tc_id, scenarioName, "Data Base validations", strExpectedValues, strActualValue, "Fail", "Expected value(s) are not present in the database");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						rs.close();
						dbConnection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				reporter.writeStepResult(tc_id, scenarioName, "Data Base validations", strExpectedValues, strActualValue, "Fail", "Unable to connect to database");
				}
		}

		public void verifyDatabaseRowValues(String strDBInfo, String strQuery, String strExpectedValues){
			String strServerURL = null;
			String strUsername = null;
			String strPassword = null;
			String [] arrDBInfoDetails = null;
			List<String> lstColumnValues = new ArrayList<String>(0);
			List<String> lstWrongColumnValues = new ArrayList<String>(0);
			//strDataFileName = "D:\\Official\\Workspace\\Cafe 2.2\\data\\CTest\\Ctest_Data.xls";

			arrDBInfoDetails = strDBInfo.split("@@");
			strServerURL = arrDBInfoDetails[0];
			strUsername = arrDBInfoDetails[1];
			strPassword = arrDBInfoDetails[2];
			Connection dbConnection = null;
			dbConnection = connectDB(strServerURL, "oracle.jdbc.driver.OracleDriver", strUsername, strPassword);

			String [] arrExpectedValues = strExpectedValues.split("@@");
			String strActualValue = null;
			strExpectedValues = strExpectedValues.replace("@@", " || ");
			//strQuery = "SELECT CUT_TIME_VALUE FROM customer_cut_time_view WHERE customer_name = (SELECT customer_name FROM customer_details WHERE customer_number = '91350303703')";

			if(dbConnection != null){
				Statement stmt = null;
				ResultSet rs = null;
				try {
					stmt = dbConnection.createStatement();
					rs = stmt.executeQuery(strQuery);

					while(rs.next()){
						strActualValue =  rs.getObject(1).toString();
						System.out.println(strActualValue);
						lstColumnValues.add(strActualValue);
					}

					int counter = 0;
					for(int i=0;i<lstColumnValues.size();i++){
						System.out.println("**************DB Value "+lstColumnValues.get(i)+" Expected "+arrExpectedValues[i]);
						if(lstColumnValues.get(i).equals(arrExpectedValues[i])){
							counter++;
						}else{
							lstWrongColumnValues.add(lstColumnValues.get(i));
						}
					}
					String strWrongValues = "";
					if(lstWrongColumnValues.size()>0){
						for(int x=0; x<lstWrongColumnValues.size(); x++){
							strWrongValues = strWrongValues.concat(" || ").concat(lstWrongColumnValues.get(x));
						}
					}
					if(counter==arrExpectedValues.length){
						reporter.writeStepResult(tc_id, scenarioName, "Data Base validations", strExpectedValues, strActualValue, "Pass", "Expected value(s) present in the database");
					}else{
						reporter.writeStepResult(tc_id, scenarioName, "Data Base validations", strExpectedValues, strActualValue, "Fail", "Expected value(s) are not present in the database");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						rs.close();
						dbConnection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				reporter.writeStepResult(tc_id, scenarioName, "Data Base validations", strExpectedValues, strActualValue, "Fail", "Unable to connect to database");
			}
		}
		
		public void verifyDatabaseRowValuesDynamically(String strDBInfo, String strQuery, String strExpectedValues){
			String strServerURL = null;
			String strUsername = null;
			String strPassword = null;
			String [] arrDBInfoDetails = null;
			List<String> lstColumnValues = new ArrayList<String>(0);
			List<String> lstWrongColumnValues = new ArrayList<String>(0);
			System.out.println("strQuery    :::::"+strQuery);
			arrDBInfoDetails = strDBInfo.split("@@");
			strServerURL = arrDBInfoDetails[0];
			strUsername = arrDBInfoDetails[1];
			strPassword = arrDBInfoDetails[2];
			Connection dbConnection = null;
			dbConnection = connectDB(strServerURL, "oracle.jdbc.driver.OracleDriver", strUsername, strPassword);

			String [] arrExpectedValues = strExpectedValues.split("@@");
			String strActualValue = null;
			strExpectedValues = strExpectedValues.replace("@@", " || ");
			//strQuery = "SELECT CUT_TIME_VALUE FROM customer_cut_time_view WHERE customer_name = (SELECT customer_name FROM customer_details WHERE customer_number = '91350303703')";

			if(dbConnection != null){
				Statement stmt = null;
				ResultSet rs = null;
				try {
					stmt = dbConnection.createStatement();
					rs = stmt.executeQuery(strQuery);

					while(rs.next()){
						strActualValue =  rs.getObject(1).toString();
						System.out.println(strActualValue);
						lstColumnValues.add(strActualValue);
					}

					int counter = 0;
					for(int i=0;i<lstColumnValues.size();i++){
						System.out.println("**************DB Value "+lstColumnValues.get(i)+" Expected "+arrExpectedValues[i]);
						if(lstColumnValues.get(i).equals(arrExpectedValues[i])){
							counter++;
						}else{
							lstWrongColumnValues.add(lstColumnValues.get(i));
						}
					}
					String strWrongValues = "";
					if(lstWrongColumnValues.size()>0){
						for(int x=0; x<lstWrongColumnValues.size(); x++){
							strWrongValues = strWrongValues.concat(" || ").concat(lstWrongColumnValues.get(x));
						}
					}
					if(counter==arrExpectedValues.length){
						reporter.writeStepResult(tc_id, scenarioName, "Data Base validations", strExpectedValues, strActualValue, "Pass", "Expected value(s) present in the database");
					}else{
						reporter.writeStepResult(tc_id, scenarioName, "Data Base validations", strExpectedValues, strActualValue, "Fail", "Expected value(s) are not present in the database");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						rs.close();
						dbConnection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				reporter.writeStepResult(tc_id, scenarioName, "Data Base validations", strExpectedValues, strActualValue, "Fail", "Unable to connect to database");
			}
		}
		public void selectDropdowndisable(WebElement locatorKey, String Option, String data) {
			WebElement element = locatorKey;
			
			((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '#ccf9bd'",  element);
			Select sel = new Select(element);
			
			try {
				if (Option.equalsIgnoreCase("VisibleText")) {
					//element.click();
					sel.selectByVisibleText(data.trim());
				} else if (Option.equalsIgnoreCase("Value")) {
					//element.click();
					sel.selectByValue(data.trim());
				} else if (Option.equalsIgnoreCase("Index")) {
					int index = Integer.parseInt(data.trim());
					//element.click();
					sel.selectByIndex(index);
				}
				
				reporter.writeStepResult(tc_id, scenarioName, "Select value from disable  " + locatorKey + " Listbox", data,
						"Expected value " + data + " is not selected in the listbox", "Pass", strReportFilename);
				
			} catch (Exception e) {
				reporter.writeStepResult(tc_id, scenarioName, "Select value from disable " + locatorKey + " Listbox", data,
						"Expected value " + data + " is selelected  in the listbox", "Fail", strReportFilename);
			}
			((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '#e6f2ff'",  element);
		}

		
		public String returnDatabaseValues(String strDBInfo, String strQuery, String strExpectedValues){
			String strServerURL = null;
			String strUsername = null;
			String strPassword = null;
			String [] arrDBInfoDetails = null;
			List<String> lstColumnValues = new ArrayList<String>(0);
			List<String> lstWrongColumnValues = new ArrayList<String>(0);
			//strDataFileName = "D:\\Official\\Workspace\\Cafe 2.2\\data\\CTest\\Ctest_Data.xls";
			System.out.println("");
			arrDBInfoDetails = strDBInfo.split("@@");
			strServerURL = arrDBInfoDetails[0];
			strUsername = arrDBInfoDetails[1];
			strPassword = arrDBInfoDetails[2];
			Connection dbConnection = null;
			dbConnection = connectDB(strServerURL, "oracle.jdbc.driver.OracleDriver", strUsername, strPassword);

			String [] arrExpectedValues = strExpectedValues.split("@@");
			String strActualValue = null;
			strExpectedValues = strExpectedValues.replace("@@", " || ");

			if(dbConnection != null){
				Statement stmt = null;
				ResultSet rs = null;
				try {
					stmt = dbConnection.createStatement();
					rs = stmt.executeQuery(strQuery);

					while(rs.next()){
						for(int i=1; i<=arrExpectedValues.length;i++){
							strActualValue =  rs.getObject(i).toString();
							System.out.println(strActualValue);
							lstColumnValues.add(strActualValue);
						}
					}

					int counter = 0;
					for(int i=0;i<lstColumnValues.size();i++){
						System.out.println("**************DB Value "+lstColumnValues.get(i)+" Expected"+arrExpectedValues[i]);
						if(lstColumnValues.get(i).equals(arrExpectedValues[i])){
							counter++;
						}else{
							lstWrongColumnValues.add(lstColumnValues.get(i));
						}
					}
					String strWrongValues = "";
					if(lstWrongColumnValues.size()>0){
						for(int x=0; x<lstWrongColumnValues.size(); x++){
							strWrongValues = strWrongValues.concat(" || ").concat(lstWrongColumnValues.get(x));
						}
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						rs.close();
						dbConnection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return lstColumnValues.get(0);
		}
		
}