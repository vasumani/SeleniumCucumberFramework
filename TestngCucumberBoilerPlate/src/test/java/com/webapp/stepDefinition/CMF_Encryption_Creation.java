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

import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;
import com.sun.jna.platform.win32.OaIdl.FUNCDESC;
import com.webapp.baseLibrary.FunctionsLibrary;
import com.webapp.executioner.ExecutionerClass;
import com.webapp.page.ReusableFunctions;
import com.webapp.utilities.GridReporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CMF_Encryption_Creation extends ExecutionerClass {

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

	@When("^User navigates to Add Encryption Page$")
	public void user_Navigates_to_Add_Encryption() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		//Click on Customer tab
		functions.clickAnElement("Customer_Tab", "Customer");
		// Navigate to Encryption 
		functions.clickAnElement("Encryption_Tab", "Encryption Tab");
		// Navigate to  Add Encryption
		functions.clickAnElement("Encryption_Add", "Encryption_Add");
		}
	}
	@When("^User navigates to Encryption Page$")
	public void user_Navigates_to_Encryption() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		//Click on Customer tab
		functions.clickAnElement("Customer_Tab", "Customer");
		// Navigate to Encryption 
		functions.clickAnElement("Encryption_Tab", "Encryption Tab");
		}
	}
	@And("^User Create Unique Encryption name$")
	public void user_createUniqueEncryptionName() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			Random ran = new Random(System.currentTimeMillis());
			int x = (int)(Math.random()) + Math.abs(ran.nextInt());
			String strEncryptionName = "MC_Encryption Key";
			String strEncryptionName1 = Integer.toString(x).substring(2, 6);
			strEncryptionName = strEncryptionName.concat(strEncryptionName1);
			functions.setEnvironmentVariable("EncryptionName", strEncryptionName);
			functions.globalWait(2);
			// Enter Encryption Name;
			functions.enterText("Encryption_name", strEncryptionName);
		}
	}
	//Create unique Key Serial index
	@And("^User Create Unique Serial Index File$")
	public void user_createUniqueSerialIndxFile() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			Random ran = new Random(System.currentTimeMillis());
			int x = (int)(Math.random()) + Math.abs(ran.nextInt());
			String strSerialIndx = "3D";
			String strSerialIndx1=Integer.toString(x).substring(2, 6);
			strSerialIndx = strSerialIndx.concat(strSerialIndx1);

			//Utilities.setEnvironmentVariable("BigBatchID", strBigBatchID);
			functions.setEnvironmentVariable("KeySerialIndex", strSerialIndx);

			functions.globalWait(2);
			// Enter Encryption Name;
			functions.enterText("Encryption_keySerialIndex", strSerialIndx);
		}
	}
	@And("^User Enter Encryption common details$")
	public void user_Enter_details() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			//enter Encryption Key
			functions.enterText("Encryption_key", testData.get("Encryption_key"));
			//enter Re-enter Encryption Key
			functions.enterText("Encryption_reenterKey", testData.get("Encryption_key"));
			//enter Encryption Key
			functions.enterText("Encryption_keyBlockedKey", testData.get("Encryption_keyBlockedKey"));
			//enter Re-enter Encryption Key
			functions.enterText("Encryption_reenterKeyBlockedKey", testData.get("Encryption_keyBlockedKey"));
			//enterKey type
			functions.selectDropdownByVisibleText("Encryption_key_type", testData.get("Encryption_key_type"));
			//enter Is Encryption Key a 3DES Key?
			functions.selectDropdownByVisibleText("Encryption_tripleDESIndicator", testData.get("Encryption_tripleDESIndicator"));
			
		}
	}
	@Then("^User Click on Save$")
	public void user_Click_Save() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click Save
		functions.clickAnElement("Encryption_Save", "Encryption_Save");	
		functions.globalWait(10);
		
		functions.verifyElementTextContains("Encryption_Save_SuccessMsg", testData.get("Encryption_Save_SuccessMsg"));
		
		}
	}
	@Then("^User Validating Encryption CMF Database Region \"([^\"]*)\"$")
	public void CMF_DB_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.CMFDatabase(Region);
		String Encryption=functions.getEnvironmentVariable("EncryptionName");
		String query=testData.get("Encryption_CMF_Query1")+Encryption.toUpperCase()+"'";
		functions.globalWait(65);
		functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("Encryption_CMF_DBExpected"));
		}
	}
	@Then("^User Validating Encryption G2 Database Region \"([^\"]*)\"$")
	public void G2DB_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.G2Database(Region);
		String Encryption=functions.getEnvironmentVariable("EncryptionName");
		String query=testData.get("Encryption_G2_Query1")+Encryption.toUpperCase()+"' and ROWNUM='1'";
		functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("Encryption_G2_DBExpected"));
		}
	}
	@Then("^User Validating Encryption CMF Database Multiple values \"([^\"]*)\"$")
	public void CMF_DB_Multiple_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.CMFDatabase(Region);
		String Encryption=functions.getEnvironmentVariable("EncryptionName");
		String[] CMFDBExpected=testData.get("Encryption_CMF_DBExpected").split("@@");
		functions.globalWait(65);
		for(int i=1;i<=CMFDBExpected.length;i++)
		{
		String query=testData.get("Encryption_CMF_Query"+i)+Encryption.toUpperCase()+"'";
			
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, CMFDBExpected[i]);
		}
		}
	}
	@Then("^User Validating Encryption G2 Database Multiple values \"([^\"]*)\"$")
	public void G2DB_Multiple_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.G2Database(Region);
		String Encryption=functions.getEnvironmentVariable("EncryptionName");
		String[] G2DBExpected=testData.get("Encryption_G2_DBExpected").split("@@");
		functions.globalWait(10);
		for(int i=1;i<=G2DBExpected.length;i++)
		{
		String query=testData.get("Encryption_G2_Query"+i)+Encryption.toUpperCase()+"' and ROWNUM='1'";
			
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, G2DBExpected[i]);
		}
		}
	}
	
	/*
	//verify cmf database values
		public void verifyEncryptionDatabaseValues(String strDataFileName,String strReportFilename,RemoteWebDriver webDriver, GridReporter reporter,String strEncryptionName,String strSerialIndex){
			
		String strQuery="";
		String strQuery1="";
		Utilities.setEnvironmentVariable("SERIAL_INDEX", strSerialIndex);
	
		strQuery="select ENCRYPTION_KEY,TRIPLE_DES_IND from ENCRYPTION where ENCRYPTION_NAME='"+strEncryptionName.toUpperCase()+"'";
		verificationFunctions.verifyDatabaseValues("DBDetailsCMF",strQuery, strDataFileName,"DBValues",reporter, strReportFilename);
		strQuery1="select KEY_SERIAL_INDEX from ENCRYPTION where ENCRYPTION_NAME='"+strEncryptionName.toUpperCase()+"'";
		verificationFunctions.verifyDynamicDBValues("DBDetailsCMF","SERIAL_INDEX", strQuery1,false, strDataFileName,"DBVALUES1", reporter, strReportFilename);
		
		}
		
		public void verifyEncryptionDatabaseValuesG2(String strDataFileName,String strReportFilename,RemoteWebDriver webDriver, GridReporter reporter,String strEncryptionName,String strSerialIndex){
			
			String strQuery="";
			String strQuery1="";
			Utilities.setEnvironmentVariable("SERIAL_INDEXG2", strSerialIndex);
			
			strQuery1="select KSI from EB_CRYPTO_KEY where DESCRIPTION='"+strEncryptionName.toUpperCase()+"'";
			verificationFunctions.verifyDynamicDBValues("DBDetailsG2","SERIAL_INDEXG2", strQuery1,false, strDataFileName,"DBVALUES1", reporter, strReportFilename);
		
		}



	//Modify Encryption
	public void ModifyEncryptionDetails(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter,String strReportFilename,String strRegion){

		//Click edit btn	
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Edit'])", "Edit", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(12);
		webDriver.findElementById("key").clear();
		//enter Encryption Key
		stepExecutor.enterTextValue("findElementById", "key", strDataFileName, "Textbox_key", webDriver, reporter, strReportFilename);
		webDriver.findElementById("reenterKey").clear();
		//enter Re-enter Encryption Key
		stepExecutor.enterTextValue("findElementById", "reenterKey", strDataFileName, "Textbox_reenterKey", webDriver, reporter, strReportFilename);
		//Click Save
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Save'])[1]", "Save", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(15);
		//verify success Message

		stepExecutor.waitForElementToDisplay("findElementByXPath", "//span[contains(text(),'Successfully updated the Encryption Setup')]", webDriver, reporter, strReportFilename);
		String strEncryptionNumber = webDriver.findElementByXPath("//span[contains(text(),'Successfully updated the Encryption Setup')]").getText();
		Utilities.setEnvironmentVariable("EncryptionName", strEncryptionNumber);
		
		verificationFunctions.verifyElementTextPresent(webDriver, "//span[contains(text(),'Successfully updated the Encryption Setup')]", "xpath", "EncryptionName", reporter, strReportFilename);

	}


*/



}
