package com.webapp.page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webapp.baseLibrary.FunctionsLibrary;
import com.webapp.executioner.ExecutionerClass;
import com.webapp.stepDefinition.CommonStepDefinitions;
import com.webapp.utilities.GridReporter;

public class ReusableFunctions extends ExecutionerClass{

	public ReusableFunctions() 
	{
		PageFactory.initElements(FunctionsLibrary.driver, this);
	}

	public String tc_id=CommonStepDefinitions.tc_id;
	public String scenarioName=CommonStepDefinitions.scenarioName;
	public String dataFileName=CommonStepDefinitions.dataFileName;
	public String strReportFilename="";
	static GridReporter reporter = getReporter();
	public Map<String,String> testData=CommonStepDefinitions.testData;
	public static Connection con= null;
	public static Statement stmt = null;
	FunctionsLibrary functions=new FunctionsLibrary();
	RemoteWebDriver driver = null;
	
	
	public void loginToApplication(String username, String Region) throws Exception {
		String url;
		String ExecutionEnvironemnt=functions.getEnvironmentVariable("ExecutionEnvironment");
		Properties config=new ExecutionerClass().setEnv();
		if(Region.equalsIgnoreCase("AP")){
			url=config.getProperty("CMFAP_"+ExecutionEnvironemnt);
		}else if(Region.equalsIgnoreCase("US")){
			url=config.getProperty("CMFNA_"+ExecutionEnvironemnt);
		}else if(Region.equalsIgnoreCase("USAT")){
			url=config.getProperty("USAT_"+ExecutionEnvironemnt);
		}else{
			url=config.getProperty("URL");
		}
		String user = username.toLowerCase().trim();
		String Pass = config.getProperty(user);
		
		FunctionsLibrary.driver.get(url);
		FunctionsLibrary.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		functions.enterText("UserName", user);
		functions.enterText("Password", Pass);
		functions.clickAnElement("Login", "Login Buton");

	}
	public void loginToUSAT(String USATLoginuser, String Region) throws Exception {
		String url;
		Properties config=new ExecutionerClass().setEnv();
		String ExecutionEnvironemnt=functions.getEnvironmentVariable("ExecutionEnvironment");
		if(Region.equalsIgnoreCase("US")){
			url=config.getProperty("USATNA_"+ExecutionEnvironemnt);
		}else if(Region.equalsIgnoreCase("AP")){
			url=config.getProperty("USATAP_"+ExecutionEnvironemnt);
		}else{
			url=config.getProperty("USAT");
		}
		String user = USATLoginuser.toLowerCase().trim();
		String Pass = config.getProperty(user);
		
		FunctionsLibrary.driver.get(url);
		FunctionsLibrary.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		functions.enterText("USAT_Username", user);
		functions.enterText("USAT_Password", Pass);
		functions.clickAnElement("USAT_Login", "Login Button");

	}


	public String CMFDatabase(String Region) throws Exception {
		String CMFConnectionString=null;
		Properties config=new ExecutionerClass().setEnv();
		String ExecutionEnvironemnt=functions.getEnvironmentVariable("ExecutionEnvironment");
		if(Region.equalsIgnoreCase("AP")){
			CMFConnectionString=config.getProperty("CMFDBURLAP_"+ExecutionEnvironemnt);
		}else if(Region.equalsIgnoreCase("US")){
			CMFConnectionString=config.getProperty("CMFDBURLNA_"+ExecutionEnvironemnt);
		}
		return CMFConnectionString;
	}
	public String G2Database(String Region) throws Exception {
		String G2ConnectionString=null;
		Properties config=new ExecutionerClass().setEnv();
		String ExecutionEnvironemnt=functions.getEnvironmentVariable("ExecutionEnvironment");
		if(Region.equalsIgnoreCase("AP")){
			G2ConnectionString=config.getProperty("G2DBURLAP_"+ExecutionEnvironemnt);
		}else if(Region.equalsIgnoreCase("US")){
			G2ConnectionString=config.getProperty("G2DBURLNA_"+ExecutionEnvironemnt);
		}
		return G2ConnectionString;
	}

	


}
