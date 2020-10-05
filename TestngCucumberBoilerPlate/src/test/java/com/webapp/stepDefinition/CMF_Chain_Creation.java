package com.webapp.stepDefinition;

import cucumber.api.java.en.When;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.webapp.baseLibrary.FunctionsLibrary;
import com.webapp.executioner.ExecutionerClass;
import com.webapp.page.ReusableFunctions;
import com.webapp.utilities.GridReporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CMF_Chain_Creation extends ExecutionerClass{

	public static String releaseName = "";
	public String dataFileName = CommonStepDefinitions.dataFileName;
	public String tc_id = CommonStepDefinitions.tc_id;
	public String scenarioName = CommonStepDefinitions.scenarioName;
	GridReporter reporter = getReporter();
	public static String strReportFilename = "";
	public long executionStartTime;
	private ReusableFunctions reusable;
	// public static Map<String,String> testData=new HashMap<String,String>();
	FunctionsLibrary functions = new FunctionsLibrary();
	public Map<String, String> testData = CommonStepDefinitions.testData;
	public boolean executeScenario = CommonStepDefinitions.executeScenario();
	Connection con = ReusableFunctions.con;
	Statement stmt = ReusableFunctions.stmt;

	@When("^User navigates to Chain Page$")
	public void user_Navigates_Chain() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			functions.clickAnElement("Chain_NavtoChain", "NavtoChain");
			functions.waitForElementUsingVisibility("Chain_Search");
		}
	}
	@And("^User Click Add Chain Page$")
	public void user_Navigates_to_AddChain() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Chain_AddChain", "Chain_AddChain");
				
			}
	}
	@When("^User navigates to Add Chain Page$")
	public void user_Navigates_AddChain() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			functions.clickAnElement("Chain_NavtoChain", "NavtoChain");
			functions.waitForElementUsingVisibility("Chain_Search");
			functions.clickAnElement("Chain_AddChain", "Chain_AddChain");
		}
	}
	@And("^User Search Chain ID$")
	public void user_Search_ChainID() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.enterText("Chain_IDSearch", testData.get("Chain_IDSearch"));
			functions.clickAnElement("Chain_Search", "Chain_Search");
			functions.clickAnElement("Chain_SearchResult", "Chain_SearchResult");
		}
	}
	@And("^User Enter Parent Customer for Chain Dynamically$")
	public void user_Enter_CustNo() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.enterText("Chain_ParentCust", functions.getEnvironmentVariable("CustomerNumber"));
			
			functions.clickAnElement("Chain_MerchantNo", "Chain_MerchantNo");
		}
	}
	@And("^User Create Unique Chain ID$")
	public void user_Create_UniqueChainID() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			Random ran = new Random(System.currentTimeMillis());
			int x = (int)(Math.random()) + Math.abs(ran.nextInt());
			String strChainID = "745";
			String strChainID1=Integer.toString(x).substring(2, 6);
			strChainID = strChainID.concat(strChainID1);

			functions.setEnvironmentVariable("ChainID", strChainID);
			functions.globalWait(5);
			functions.enterText("Chain_MerchantNo", functions.getEnvironmentVariable("ChainID"));
			functions.globalWait(5);
		}
	}
	
	@And("^User Create Unique Chain Name1$")
	public void user_Create_UniqueChainName1() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.globalWait(2);
			Random ran = new Random(System.currentTimeMillis());
			int x = (int)(Math.random()) + Math.abs(ran.nextInt());
			String strChainName = "AutoChain";
			String strChainName1=Integer.toString(x).substring(2, 6);
			strChainName = strChainName.concat(strChainName1);

			functions.setEnvironmentVariable("ChainName1", strChainName);
			functions.enterText("Chain_ChainName", functions.getEnvironmentVariable("ChainName1"));

		}
	}
	@And("^User Create Unique Chain Name2$")
	public void user_Create_UniqueChainName2() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.globalWait(2);
			Random ran = new Random(System.currentTimeMillis());
			int x = (int)(Math.random()) + Math.abs(ran.nextInt());
			String strChainName = "AutoChain";
			String strChainName1=Integer.toString(x).substring(2, 6);
			strChainName = strChainName.concat(strChainName1);

			functions.setEnvironmentVariable("ChainName2", strChainName);
			functions.enterText("Chain_ChainName", functions.getEnvironmentVariable("ChainName2"));

		}
	}
	
	@And("^User Enter Chain Common details$")
	public void user_Enter_ChainDetails() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			//Enter	Address 1
			functions.enterText("Chain_chainAddress1", testData.get("Chain_chainAddress1"));
			//Enter	Address 2
			functions.enterText("Chain_chainAddress2", testData.get("Chain_chainAddress2"));
			//Enter	City
			functions.enterText("Chain_chainCity", testData.get("Chain_chainCity"));
			//Enter	Zip / Postal Code
			functions.enterText("Chain_chainPostalCode", testData.get("Chain_chainPostalCode"));
			//Enter	Country
			functions.enterText("Chain_chainCountry", testData.get("Chain_chainCountry"));
			FunctionsLibrary.driver.findElement(By.id("chainPostalCode")).click();
			functions.globalWait(5);
			//Select	State or Province
			functions.selectDropdownByVisibleText("Chain_chainState", testData.get("Chain_chainState"));
			//Enter	Primary Contact
			functions.enterText("Chain_primaryContactName", testData.get("Chain_primaryContactName"));
			//Enter	Chain Phone Number
			functions.enterText("Chain_primaryContactPrimaryPhone", testData.get("Chain_primaryContactPrimaryPhone"));

		}
	}

	@And("^User Click on Chain Save Button$")
	public void user_Chain_Save() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Chain_Save", "Chain_Save");
			
			functions.waitForElementUsingPresence("Chain_Save_SuccessMsg");
			functions.verifyElementPresent("Chain_Save_SuccessMsg");
			
		}
	}
	
	@And("^User Create Chain1 CPR Validations$")
	public void user_Create_Chain1() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			
			user_Navigates_AddChain();
			
			user_Enter_CustNo1();
			
			user_Create_UniqueChainID();
			
			user_Create_UniqueChainName1();
			
			user_Enter_ChainDetails();
			
			user_Chain_Save();
			
		}
	}
	@And("^User Create Chain2 CPR Validations$")
	public void user_Create_Chain2() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			
			user_Navigates_AddChain();
			
			user_Enter_CustNo2();
			
			user_Create_UniqueChainID();
			
			user_Create_UniqueChainName2();
			
			user_Enter_ChainDetails();
			
			user_Chain_Save();
			
		}
	}
	
	@And("^User Enter Parent Customer1 for Chain Dynamically$")
	public void user_Enter_CustNo1() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.enterText("Chain_ParentCust", functions.getEnvironmentVariable("CustomerNumber1"));
			
			functions.clickAnElement("Chain_MerchantNo", "Chain_MerchantNo");
		}
	}
	@And("^User Enter Parent Customer2 for Chain Dynamically$")
	public void user_Enter_CustNo2() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.enterText("Chain_ParentCust", functions.getEnvironmentVariable("CustomerNumber2"));
			
			functions.clickAnElement("Chain_MerchantNo", "Chain_MerchantNo");
		}
	}
	
	

	

	/*public void updateChain(String strDataFileName,RemoteWebDriver webDriver, String strReportFilename){
		//click edit btn
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Edit'])[1]", "Edit", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(15);	
		//update chain name
		webDriver.findElementById("name").clear();
		Random ran = new Random(System.currentTimeMillis());
		int x = (int)(Math.random()) + Math.abs(ran.nextInt());
		String strChainName = "Update_";
		String strChainName1=Integer.toString(x).substring(2, 6);
		strChainName = strChainName.concat(strChainName1);
		Utilities.setEnvironmentVariable("ChainName", strChainName);
		// Enter chain Name;
		stepExecutor.globalWait(2);
		stepExecutor.enterTextValue("findElementById", "name", "ChainName", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(5);

		//update address 1
		webDriver.findElementById("chainAddress1").clear();
		stepExecutor.enterTextValue("findElementById", "chainAddress1", strDataFileName, "Textbox_chainAddress1", webDriver, reporter, strReportFilename);
		//update primary contact
		webDriver.findElementById("primaryContactName").clear();
		stepExecutor.enterTextValue("findElementById", "primaryContactName", strDataFileName, "Textbox_primaryContactName", webDriver, reporter, strReportFilename);
		//click save and verify msg
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Save'])[1]", "Save", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(15);

		//verify success Message
		stepExecutor.waitForElementToDisplay("findElementByXPath", "//span[contains(text(),'Successfully updated the Chain Record.')]", webDriver, reporter, strReportFilename);
		verificationFunctions.verifyElementTextPresent(webDriver, "//span[contains(text(),'Successfully updated the Chain Record.')]", "xpath", strDataFileName, "Msg_Chain_Sucess", reporter, strReportFilename);

	}
	public void enterChainCustNumber1(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter,String strReportFilename,String strRegion){
		//enter Customer
		stepExecutor.enterTextValue("findElementById", "customerNumber", strDataFileName, "Textbox_customerNumber_"+strRegion, webDriver, reporter, strReportFilename);
		webDriver.findElementById("merchantChainNumber").click();
		stepExecutor.globalWait(7);
	}
	*/


}