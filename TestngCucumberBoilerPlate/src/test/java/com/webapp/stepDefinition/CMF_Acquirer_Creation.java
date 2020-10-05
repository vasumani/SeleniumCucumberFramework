package  com.webapp.stepDefinition;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.sun.jna.platform.win32.OaIdl.FUNCDESC;
import com.webapp.baseLibrary.FunctionsLibrary;
import com.webapp.executioner.ExecutionerClass;
import com.webapp.page.ReusableFunctions;
import com.webapp.utilities.GridReporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class CMF_Acquirer_Creation extends ExecutionerClass {

	public static String releaseName="";
	public String dataFileName=CommonStepDefinitions.dataFileName;
	public String tc_id=CommonStepDefinitions.tc_id;
	public String scenarioName=CommonStepDefinitions.scenarioName;
	GridReporter reporter = getReporter();
	public static String strReportFilename="";
	public long executionStartTime;
	private ReusableFunctions reusable;
	//public static Map<String,String> testData=new HashMap<String,String>();
	FunctionsLibrary functions=new FunctionsLibrary();
	public Map<String,String> testData=CommonStepDefinitions.testData;
	public boolean executeScenario = CommonStepDefinitions.executeScenario();
	Connection con= ReusableFunctions.con;
	Statement stmt = ReusableFunctions.stmt;

	@When("^User navigates to Acquirer Page$")
	public void user_Navigates_to_Acquirer() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		//Click on Customer tab
		functions.clickAnElement("Customer_Tab", "Customer_Tab");
		//Click Acquirer tab
		functions.clickAnElement("Acquirer_Acquirer_Tab", "Acquirer_Tab");
		}
		}
	@When("^User navigates to Add Acquirer Page$")
	public void user_Navigates_to_AddAcquirer() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		//Click on Customer tab
		functions.clickAnElement("Customer_Tab", "Customer_Tab");
		//Click Acquirer tab
		functions.clickAnElement("Acquirer_Acquirer_Tab", "Acquirer_Tab");
		//click Add Acquirer
		functions.clickAnElement("Acquirer_Add_Acquirer", "Add_Acquirer");
		functions.waitForElementUsingPresence("Acquirer_name");
		}
	}
	@And("^User Create Unique Acquirer name$")
	public void user_Create_AcquirerName() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		Random ran = new Random(System.currentTimeMillis());
		int x = (int)(Math.random() * 999) + Math.abs(ran.nextInt());
		String strAcqName = "AcquirerAccount";
		strAcqName = strAcqName.concat(Integer.toString(x));
		functions.setEnvironmentVariable("AcquirerAccount", strAcqName);
		//Enter Acquirer Name
		functions.enterText("Acquirer_name", strAcqName);
	}
	}
	@And("^User Fill Acquirer Details$")
	public void user_Fill_AcquirerDetails() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Enter VISABIN
		functions.enterText("Acquirer_VisaBin", testData.get("Acquirer_VisaBin"));
		//Enter MC ICA
		functions.enterText("Acquirer_MCICA", testData.get("Acquirer_MCICA"));
		//Enter Discover Acquirer ID
		functions.enterText("Acquirer_discoverAcquirerId", testData.get("Acquirer_discoverAcquirerId"));
		//Enter Country
		functions.enterText("Acquirer_numericCountryCode", testData.get("Acquirer_numericCountryCode"));
		FunctionsLibrary.driver.findElement(By.id("countryName")).click();
		functions.globalWait(5);
		//Enter Pin Gateway ID
		functions.enterText("Acquirer_pinGatewayId", testData.get("Acquirer_pinGatewayId"));
		
	}
	}
	@And("^User Fill AP Acquirer Details$")
	public void user_Fill_AP_AcquirerDetails() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Enter VISABIN
		functions.enterText("Acquirer_VisaBin", testData.get("Acquirer_VisaBin"));
		//Enter MC ICA
		functions.enterText("Acquirer_MCICA", testData.get("Acquirer_MCICA"));
		//Enter Discover Acquirer ID
		functions.enterText("Acquirer_discoverAcquirerId", testData.get("Acquirer_discoverAcquirerId"));
		//Enter Pin Gateway ID
		functions.enterText("Acquirer_jcbAcquirerId", testData.get("Acquirer_jcbAcquirerId"));
		//Enter VISA SMS
		functions.enterText("Acquirer_VISASMS", testData.get("Acquirer_VISASMS"));
		//Enter Country
		functions.enterText("Acquirer_numericCountryCode", testData.get("Acquirer_numericCountryCode"));
		FunctionsLibrary.driver.findElement(By.id("countryName")).click();
		functions.globalWait(5);
		//Enter MC MDS
		functions.enterText("Acquirer_MCMDS", testData.get("Acquirer_MCMDS"));
		//Enter CUP
		functions.enterText("Acquirer_cup", testData.get("Acquirer_cup"));
	}
	}
	@And("^User Save Acquirer Account$")
	public void user_Click_Save_Acquirer() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		// Click on Save Button
		functions.clickAnElement("Acquirer_Save", "Save");
		// Verify Confirm Message
		functions.verifyElementTextContains("Acquirer_Save_SuccessMsg", testData.get("Acquirer_Save_SuccessMsg"));
	}
	}
	@And("^User Search for Acquirer Account Dynamically$")
	public void user_Search_Acquirer_Dynamically(String EnvAcquirer) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Enter Acquirer Name to Search
		String Acquirer=functions.getEnvironmentVariable("AcquirerAccount");
		functions.enterText("Acquirer_Search_name", Acquirer);
		//Click on Search Button
		functions.clickAnElement("Acquirer_Search_Button", "Search");
		//Click Acquirer
		functions.waitForElementUsingPresence("Acquirer_Search_AcquirerLink");
		functions.clickAnElement("Acquirer_Search_AcquirerLink", "AcquirerLink");
	}
	}
	@And("^User Search for Acquirer Account$")
	public void user_Search_Acquirer(String EnvAcquirer) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Enter Acquirer Name to Search
		functions.enterText("Acquirer_Search_name", testData.get("Acquirer_Search_name"));
		//Click on Search Button
		functions.clickAnElement("Acquirer_Search_Button", "Search");
		//Click Acquirer
		functions.waitForElementUsingPresence("Acquirer_Search_AcquirerLink");
		functions.clickAnElement("Acquirer_Search_AcquirerLink", "AcquirerLink");
	}
	}
	@And("^User Updating Acquirer Account$")
	public void user_Update_Acquirer(String EnvAcquirer) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		// Click on Edit Button
		functions.clickAnElement("Acquirer_Edit_Button", "Edit");
		functions.waitForElementUsingPresence("Acquirer_Save");
		//Edit Details
		//Enter VISABIN
		functions.clearTextField("Acquirer_VisaBin");
		functions.enterText("Acquirer_VisaBin", testData.get("Acquirer_Update_VisaBin"));
		//Enter MC ICA
		functions.clearTextField("Acquirer_MCICA");
		functions.enterText("Acquirer_MCICA", testData.get("Acquirer_Update_MCICA"));
		//Enter Discover Acquirer ID
		functions.clearTextField("Acquirer_discoverAcquirerId");
		functions.enterText("Acquirer_discoverAcquirerId", testData.get("Acquirer_Update_discoverAcquirerId"));
		//Enter Pin Gateway ID
		functions.clearTextField("Acquirer_pinGatewayId");
		functions.enterText("Acquirer_pinGatewayId", testData.get("Acquirer_Update_pinGatewayId"));
		//Enter Country
		functions.clearTextField("Acquirer_numericCountryCode");
		functions.enterText("Acquirer_numericCountryCode", testData.get("Acquirer_Update_numericCountryCode"));
		FunctionsLibrary.driver.findElement(By.id("countryName")).click();
		functions.globalWait(5);
	}
	}
	@And("^User Updating AP Acquirer Details$")
	public void user_Update_AP_AcquirerDetails() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Enter VISABIN
		functions.clearTextField("Acquirer_VisaBin");
		functions.enterText("Acquirer_VisaBin", testData.get("Acquirer_Update_VisaBin"));
		//Enter MC ICA
		functions.clearTextField("Acquirer_MCICA");
		functions.enterText("Acquirer_MCICA", testData.get("Acquirer_Update_MCICA"));
		//Enter Discover Acquirer ID
		functions.clearTextField("Acquirer_discoverAcquirerId");
		functions.enterText("Acquirer_discoverAcquirerId", testData.get("Acquirer_Update_discoverAcquirerId"));
		//Enter Pin Gateway ID
		functions.clearTextField("Acquirer_jcbAcquirerId");
		functions.enterText("Acquirer_jcbAcquirerId", testData.get("Acquirer_Update_jcbAcquirerId"));
		//Enter VISA SMS
		functions.clearTextField("Acquirer_VISASMS");
		functions.enterText("Acquirer_VISASMS", testData.get("Acquirer_Update_VISASMS"));
		//Enter MC MDS
		functions.clearTextField("Acquirer_MCMDS");
		functions.enterText("Acquirer_MCMDS", testData.get("Acquirer_Update_MCMDS"));
		//Enter CUP
		functions.clearTextField("Acquirer_cup");
		functions.enterText("Acquirer_cup", testData.get("Acquirer_Update_cup"));
		//Enter Country
		functions.clearTextField("Acquirer_numericCountryCode");
		functions.enterText("Acquirer_numericCountryCode", testData.get("Acquirer_Update_numericCountryCode"));
		FunctionsLibrary.driver.findElement(By.id("countryName")).click();
		functions.globalWait(5);
	}
	}
	@And("^User fill Acquirer Details Region \"([^\"]*)\"$")
	public void user_Add_Acquirer(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			if(Region.equalsIgnoreCase("AP")){
				user_Fill_AP_AcquirerDetails();
			}
			if(Region.equalsIgnoreCase("US")){
				user_Fill_AcquirerDetails();
				
			}
		}
	}
	
	/*
	//cmf database validation	
		public String verifyCmfDatabaseValues(String strDataFileName,String strReportFilename,RemoteWebDriver webDriver, GridReporter reporter,String accName){
          String strQuery="";
          String strQuery1="";
          String extId="";
          strQuery="select VISA_BIN,MCICA,DISCOVERER_ACQUIRER_ID,PIN_GATEWAY_ID from ACQUIRER_ACCOUNT where NAME='"+accName+"'";
          strQuery1="select ACQUIRER_ACCOUNT_ID from ACQUIRER_ACCOUNT where NAME='"+accName+"'";
          verificationFunctions.verifyDatabaseValues("DBDetailsCMF", strQuery, strDataFileName,"DBValuesCmf", reporter, strReportFilename);
		  extId=verificationFunctions.returnExecuteSQLQuery("DBDetailsCMF", strQuery1, strDataFileName,"dbvalues", reporter, strReportFilename);
		  return extId;
		}
		
		//cmf database validation	
				public String verifyCmfDatabaseValuesAP(String strDataFileName,String strReportFilename,RemoteWebDriver webDriver, GridReporter reporter,String accName){
					  String strQuery01="";
					  String strQuery02="";
					  String strQuery03="";
			          String strQuery1="";
			          String extId="";
			          strQuery01="select VISA_BIN,MCICA,DISCOVERER_ACQUIRER_ID from ACQUIRER_ACCOUNT where NAME='"+accName+"'";
			          verificationFunctions.verifyDatabaseRowValues("DBDetailsCMF", strQuery01, strDataFileName,"DBValuesCmf01", reporter, strReportFilename);
			          
			          strQuery02="select MCICA from ACQUIRER_ACCOUNT where NAME='"+accName+"'";
			          verificationFunctions.verifyDatabaseRowValues("DBDetailsCMF", strQuery02, strDataFileName,"DBValuesCmf02", reporter, strReportFilename);
			          
			          strQuery03="select DISCOVERER_ACQUIRER_ID from ACQUIRER_ACCOUNT where NAME='"+accName+"'";
			          verificationFunctions.verifyDatabaseRowValues("DBDetailsCMF", strQuery03, strDataFileName,"DBValuesCmf03", reporter, strReportFilename);
			          
			          strQuery1="select ACQUIRER_ACCOUNT_ID from ACQUIRER_ACCOUNT where NAME='"+accName+"'";
			          			          //verificationFunctions.verifyDatabaseValues("DBDetailsCMF", strQuery, strDataFileName,"DBValuesCmf", reporter, strReportFilename);
					  extId=verificationFunctions.returnExecuteSQLQuery("DBDetailsCMF", strQuery1, strDataFileName,"dbvalues", reporter, strReportFilename);
					  return extId;
				}
		
		//g2 database validation	
			public void verifyG2DatabaseValues(String strDataFileName,String strReportFilename,RemoteWebDriver webDriver, GridReporter reporter,String extId){
	          String strQuery="";
	          strQuery="select VISA_BIN,MASTERCARD_ICA,DISCOVER_ACQ_ID from EB_ACQUIRER where EXT_ID='"+extId+"'";
	          verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName,"DBValuesG2", reporter, strReportFilename);
				
			}
			
			//g2 database validation AP	
			public void verifyG2DatabaseValuesAP(String strDataFileName,String strReportFilename,RemoteWebDriver webDriver, GridReporter reporter,String extId){
	          String strQuery="";
	          strQuery="select VISA_BIN,MASTERCARD_ICA,DISCOVER_ACQ_ID from EB_ACQUIRER where EXT_ID='"+extId+"'";
	          verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName,"DBValuesG2", reporter, strReportFilename);
				
			}
		
	*/

	
}
















