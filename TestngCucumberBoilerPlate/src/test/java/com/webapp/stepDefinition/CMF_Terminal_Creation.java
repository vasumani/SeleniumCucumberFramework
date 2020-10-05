package com.webapp.stepDefinition;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webapp.baseLibrary.FunctionsLibrary;
import com.webapp.executioner.ExecutionerClass;
import com.webapp.page.ReusableFunctions;
import com.webapp.utilities.GridReporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CMF_Terminal_Creation extends ExecutionerClass {

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

	// Terminal Module
	// Navigate To Add Terminal Page

	@When("^User navigates to Add Terminal Page$")
	public void user_Navigates_to_AddTerminalPage() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Terminal tab
			functions.clickAnElement("Terminal_NavToTerminal", "Terminal_NavToTerminal");
			// Click on add Terminal
			functions.clickAnElement("Terminal_AddTerminal", "Terminal_AddTerminal");
		}
	}
	@And("^User Enters  Merchant number Dynamically$")
	public void user_Enter_MerchantNumber_Dynamically() throws Throwable {
		// Verify Alert text and click OK
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			//functions.acceptAlertWithoutText("accept");
			functions.globalWait(6);
			// Enter Parent customer
			functions.enterText("Terminal_MerchantId", functions.getEnvironmentVariable("MerchantNumber"));
			//functions.globalWait(5);
			FunctionsLibrary.driver.findElement(By.id("dbaName")).click();
			functions.globalWait(8);
			functions.waitForElementUsingPresence("Terminal_Save");
			//String ParentCustNumber = testData.get("Merchant_ParentCustomerNumber");
			functions.globalWait(12);
			// functions.setEnvironmentVariable(EnvVariable, ParentCustNumber);
		}
	}

	// Enter Merchant ID
	@And("^User Enter Merchant Id$")
	public void user_Enter_MerchantID() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.enterText("Terminal_MerchantId", testData.get("Terminal_MerchantId"));
			functions.clickAnElement("Terminal_ClickElement", "Terminal_ClickElement");
			functions.waitForElementUsingPresence("Terminal_Save");
		}
	}
	@And("^User Enter Merchant Id Dynamically$")
	public void user_Enter_MerchantID_Dynamically() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.enterText("Terminal_MerchantId", functions.getEnvironmentVariable("MerchantNumber"));
			functions.clickAnElement("Terminal_ClickElement", "Terminal_ClickElement");
			functions.waitForElementUsingPresence("Terminal_Save");
		}
	}

	@And("^User Creating unique TerminalID$")
	public void user_Creating_UniqueTerminalID() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			Random ran = new Random(System.currentTimeMillis());
			int x = (int) (Math.random() * 999) + Math.abs(ran.nextInt());
			String strTermID = "91";
			strTermID = strTermID.concat(Integer.toString(x));
			functions.setEnvironmentVariable("TerminalID", strTermID);
			functions.enterText("Terminal_TerminalId", functions.getEnvironmentVariable("TerminalID"));
			functions.globalWait(8);

		}
	}

	@And("^User Search By TerminalID$")
	public void user_Search_By_TerminalId() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Terminal_NavToTerminal", "Terminal_NavToTerminal");
			// Enter Terminal Number to search
			functions.enterText("Terminal_TerminalIdSearch", testData.get("Terminal_TerminalIdSearch"));
			// Click on Search Button
			//functions.waitForElementUsingPresence("Terminal_Edit");
			functions.clickAnElement("Terminal_ClickSearch", "Terminal_ClickSearch");
			String TerminalId = testData.get("Terminal_TerminalIdSearch");
			functions.setEnvironmentVariable("TerminalID", TerminalId);

		}
	}

	@And("^User Enters All Details$")
	public void user_Enters_All_Details() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Enter Terminal Type
			functions.enterText("Terminal_ConfigureTerminalType", testData.get("Terminal_ConfigureTerminalType"));
			// Select Configured Terminal Type
			functions.selectDropdown("Terminal_TerminalCapability", "VisibleText",
					testData.get("Terminal_TerminalCapability"));
			// Enter MCC
			functions.enterText("Terminal_MCC", testData.get("Terminal_MCC"));

			functions.clickAnElement("Terminal_MCCDescription", "Terminal_MCCDescription");

			functions.globalWait(5);
			// Verify TCC Value
			functions.verifyElementAttribute("Terminal_TCC", testData.get("Terminal_TCC"), "value");
			// Select Message Spec Ind
			functions.selectDropdown("Terminal_MessageSpecificationIndicator", "VisibleText",
					testData.get("Terminal_MessageSpecificationIndicator"));
		}
	}

	@And("^User Enters Refund and Purchase Details$")

	public void user_Enters_RefundAndPurchaseDetails() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Enter Number of Refunds Allowed Per Individual batch
			functions.enterText("Customer_NumberOfRefunds", testData.get("Customer_NumberOfRefunds"));
			// Enter Total Dollar Amount of Refunds Allowed per Individual Batch
			functions.enterText("Terminal_TotalDollarAmount", testData.get("Terminal_TotalDollarAmount"));
			// Enter Dollar Amount of Individual Purchase Transaction Allowed
			functions.enterText("Terminal_DollarAmountIndividualPurchase",
					testData.get("Terminal_DollarAmountIndividualPurchase"));
			// Enter Dollar Amount of Individual Refund Transaction Allowed
			functions.enterText("Terminal_DollarAmountIndividualRefund",
					testData.get("Terminal_DollarAmountIndividualRefund"));
			// Select 90% Healthcare
			functions.enterText("Terminal_HealthCare", testData.get("Terminal_HealthCare"));

		}
	}

	@And("^User Enters Terminal Details for MerchantInitiated$")

	public void user_Enters_Terminal_Details_MerchantInitiated() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Select Capture method
			functions.selectDropdown("Terminal_CaptureMethod", "VisibleText", testData.get("Terminal_CaptureMethod"));
			functions.globalWait(5);
			// Select Batch Close Type
			functions.selectDropdown("Terminal_BatchCloseType", "VisibleText", testData.get("Terminal_BatchCloseType"));
			functions.globalWait(5);
			functions.selectDropdown("Terminal_MaxDaysToSettle", "VisibleText",
					testData.get("Terminal_MaxDaysToSettle"));
			functions.globalWait(2);

			/*
			 * else { functions.VerifyDropDownListValues("Terminal_MaxDaysToSettle",
			 * testData.get("Terminal_MaxDaysToSettle")); }
			 */
			// Select Force Close
			functions.selectDropdown("Terminal_ForceSettleAllowed", "VisibleText",
					testData.get("Terminal_ForceSettleAllowed"));
			// Select Voice Allowed
			functions.selectDropdown("Terminal_VoiceAllowed", "VisibleText", testData.get("Terminal_VoiceAllowed"));
			// MasterCard CAT level
			functions.selectDropdown("Terminal_MCCatLevel", "VisibleText", testData.get("Terminal_MCCatLevel"));
			// VISA CAT level
			functions.selectDropdown("Terminal_VISACatLevel", "VisibleText", testData.get("Terminal_VISACatLevel"));
			// Select HelpDesk
			functions.selectDropdown("Terminal_HelpDesk", "VisibleText", testData.get("Terminal_HelpDesk"));
			// Select Product Code
			functions.selectDropdown("Terminal_ProductCode", "VisibleText", testData.get("Terminal_ProductCode"));
			// Select Alternate DBA Indicator
			functions.selectDropdown("Terminal_AlternateDBA", "VisibleText", testData.get("Terminal_AlternateDBA"));
			// Select Stand In Processing
			functions.selectDropdown("Terminal_StandInProcessing", "VisibleText",
					testData.get("Terminal_StandInProcessing"));
			// Timezone
			functions.selectDropdown("Terminal_TimeZone", "VisibleText", testData.get("Terminal_TimeZone"));
		}
	}

	@And("^User Enters Terminal Mandatory Details$")

	public void user_Enters_Terminal_MandatoryDetails() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Select Capture method
			functions.selectDropdown("Terminal_CaptureMethod", "VisibleText", testData.get("Terminal_CaptureMethod"));
			functions.globalWait(5);
			// Select Batch Close Type
			functions.selectDropdown("Terminal_BatchCloseType", "VisibleText", testData.get("Terminal_BatchCloseType"));
			// Timezone
			functions.selectDropdown("Terminal_TimeZone", "VisibleText", testData.get("Terminal_TimeZone"));
		}
	}

	/*
	 * @When("^User Enters Terminal  Details 16QR3$")
	 * 
	 * public void user_Enters_Terminal_Details16QR3() throws Throwable {
	 * if(CommonStepDefinitions.executeScenario()){
	 * if(!CommonStepDefinitions.exescenario) return; //Select Capture method
	 * functions.selectDropdown("Terminal_CaptureMethod", "VisibleText",
	 * testData.get("Terminal_CaptureMethod")); functions.globalWait(5); //Select
	 * Batch Close Type functions.selectDropdown("Terminal_BatchCloseType",
	 * "VisibleText", testData.get("Terminal_BatchCloseType"));
	 * if(strBatchCloseType=="Merchant-Initiated"){
	 * functions.selectDropdown("Terminal_MaxDaysToSettle", "VisibleText",
	 * testData.get("Terminal_MaxDaysToSettle")); functions.globalWait(2);
	 * 
	 * } //Timezone functions.selectDropdown("Terminal_TimeZone", "VisibleText",
	 * testData.get("Terminal_TimeZone")); } }
	 */

	@And("^User Enters Terminal Details WithOutStandIn$")

	public void user_Enters_Terminal_DetailsWithoutStandIn() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Select Capture method
			functions.selectDropdown("Terminal_CaptureMethod", "VisibleText", testData.get("Terminal_CaptureMethod"));
			functions.globalWait(5);
			// Select Batch Close Type
			functions.selectDropdown("Terminal_BatchCloseType", "VisibleText", testData.get("Terminal_BatchCloseType"));
			functions.globalWait(5);
			functions.selectDropdown("Terminal_MaxDaysToSettle", "VisibleText",
					testData.get("Terminal_MaxDaysToSettle"));
			functions.globalWait(2);

			/*
			 * else { functions.VerifyDropDownListValues("Terminal_MaxDaysToSettle",
			 * "Terminal_MaxDaysToSettle"); }
			 */
			// Select Force Close
			functions.selectDropdown("Terminal_ForceSettleAllowed", "VisibleText",
					testData.get("Terminal_ForceSettleAllowed"));
			// Select Voice Allowed
			functions.selectDropdown("Terminal_VoiceAllowed", "VisibleText", testData.get("Terminal_VoiceAllowed"));
			// MasterCard CAT level
			functions.selectDropdown("Terminal_MCCatLevel", "VisibleText", testData.get("Terminal_MCCatLevel"));
			// VISA CAT level
			functions.selectDropdown("Terminal_VISACatLevel", "VisibleText", testData.get("Terminal_VISACatLevel"));
			// Select HelpDesk
			functions.selectDropdown("Terminal_HelpDesk", "VisibleText", testData.get("Terminal_HelpDesk"));
			// Verify ACI List Value
			functions.VerifyDropDownListValues("Terminal_ACIConversion", "Terminal_ACIConversion");
			// Select Product Code
			functions.selectDropdown("Terminal_ProductCode", "VisibleText", testData.get("Terminal_ProductCode"));
			// Select Alternate DBA Indicator
			functions.selectDropdown("Terminal_AlternateDBA", "VisibleText", testData.get("Terminal_AlternateDBA"));

			// Timezone
			functions.selectDropdown("Terminal_TimeZone", "VisibleText", testData.get("Terminal_TimeZone"));
		}
	}

	@And("^User Check merchant Adress for Terminal$")
	public void user_check_MerhAddressDetails() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;

			// Enter Terminal Merchant DBA Name
			functions.enterText("Terminal_TerminalMerchnatDBAName", testData.get("Terminal_TerminalMerchnatDBAName"));
			functions.changeRadioButtonOrCheckBoxStatus("Terminal_UseMerchnatAddress",
					testData.get("Terminal_UseMerchnatAddress"));
			// Enter Currency
			functions.enterText("Terminal_Currency", testData.get("Terminal_Currency"));
			functions.clickAnElement("Terminal_currencyCodeDescription", "Terminal_currencyCodeDescription");
		}
	}

	@And("^User Enters Address Details$")
	public void user_Enters_AddressDetails() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;

			// Enter Terminal Merchant DBA Name
			functions.enterText("Terminal_TerminalMerchnatDBAName", testData.get("Terminal_TerminalMerchnatDBAName"));

			// Enter Address 1
			functions.enterText("Terminal_Address1", testData.get("Terminal_Address1"));
			// Enter Address 2
			functions.enterText("Terminal_Address2", testData.get("Terminal_Address2"));
			// Enter City
			functions.enterText("Terminal_City", testData.get("Terminal_City"));
			// Enter Zip/Postal Code
			functions.enterText("Terminal_PostalCode", testData.get("Terminal_PostalCode"));
			// Enter Country
			functions.enterText("Terminal_Country", testData.get("Terminal_Country"));
			functions.clickAnElement("Terminal_DBACountryDescription", "Terminal_DBACountryDescription");
			functions.globalWait(5);
			functions.selectDropdown("Terminal_State", "VisibleText", testData.get("Terminal_State"));

			// Enter Currency
			functions.enterText("Terminal_Currency", testData.get("Terminal_Currency"));
			functions.clickAnElement("Terminal_currencyCodeDescription", "Terminal_currencyCodeDescription");
		}
	}

	@And("^User Enters Debit Details$")
	public void user_Enters_DebitDetails() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Select Debit/EBT returns
			functions.selectDropdown("Terminal_DebitAndEBTReturnsAllowed", "VisibleText",
					testData.get("Terminal_DebitAndEBTReturnsAllowed"));
			// Select PIN debit
			functions.selectDropdown("Terminal_PinDebit", "VisibleText", testData.get("Terminal_PinDebit"));
			// Select PINLess debit
			functions.selectDropdown("Terminal_PinLessGateWay", "VisibleText", testData.get("Terminal_PinLessGateWay"));
			// Select EBT cash benefits
			functions.selectDropdown("Terminal_EBTCashBenefits", "VisibleText",
					testData.get("Terminal_EBTCashBenefits"));
			// Select EBT foodstamp
			functions.selectDropdown("Terminal_EBTFoodStamp", "VisibleText", testData.get("Terminal_EBTFoodStamp"));
			// Select Encryption name
			functions.selectDropdown("Terminal_EncryptionName", "VisibleText", testData.get("Terminal_EncryptionName"));
		}
	}

	@And("^User Enters Debit Details WithNoEncryption$")
	public void user_Enters_DebitDetails_WithNoEncryption() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Select Debit/EBT returns
			functions.selectDropdown("Terminal_DebitAndEBTReturnsAllowed", "VisibleText",
					testData.get("Terminal_DebitAndEBTReturnsAllowed"));
			// Select PIN debit
			functions.selectDropdown("Terminal_PinDebit", "VisibleText", testData.get("Terminal_PinDebit"));
			// Select PINLess debit
			functions.selectDropdown("Terminal_PinLessGateWay", "VisibleText", testData.get("Terminal_PinLessGateWay"));
			// Select EBT cash benefits
			functions.selectDropdown("Terminal_EBTCashBenefits", "VisibleText",
					testData.get("Terminal_EBTCashBenefits"));
			// Select EBT foodstamp
			functions.selectDropdown("Terminal_EBTFoodStamp", "VisibleText", testData.get("Terminal_EBTFoodStamp"));
		}
	}

	@And("^User Enters Debit Details WithNoDebitAndEBT$")
	public void user_Enters_DebitDetails_WithNoDebitAndEBT() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Select PIN debit
			functions.selectDropdown("Terminal_PinDebit", "VisibleText", testData.get("Terminal_PinDebit"));
			// Select PINLess debit
			functions.waitForElementUsingPresence("Terminal_DebitAndEBTReturnsAllowed");
			functions.selectDropdown("Terminal_PinLessGateWay", "VisibleText", testData.get("Terminal_PinLessGateWay"));
			// Select EBT cash benefits
			functions.selectDropdown("Terminal_EBTCashBenefits", "VisibleText",
					testData.get("Terminal_EBTCashBenefits"));
			// Select EBT foodstamp
			functions.selectDropdown("Terminal_EBTFoodStamp", "VisibleText", testData.get("Terminal_EBTFoodStamp"));
			// Select Encryption name
			functions.selectDropdown("Terminal_EncryptionName", "VisibleText", testData.get("Terminal_EncryptionName"));
		}
	}

	@And("^User Enters Debit Details WithNoDebitAndEBT And Encryption $")
	public void user_Enters_DebitDetails_WithNoDebitAndEBT_Encryption() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Select PIN debit
			functions.selectDropdown("Terminal_PinDebit", "VisibleText", testData.get("Terminal_PinDebit"));
			// Select PINLess debit
			functions.waitForElementUsingPresence("Terminal_DebitAndEBTReturnsAllowed");
			functions.selectDropdown("Terminal_PinLessGateWay", "VisibleText", testData.get("Terminal_PinLessGateWay"));
			// Select EBT cash benefits
			functions.selectDropdown("Terminal_EBTCashBenefits", "VisibleText",
					testData.get("Terminal_EBTCashBenefits"));
			// Select EBT foodstamp
			functions.selectDropdown("Terminal_EBTFoodStamp", "VisibleText", testData.get("Terminal_EBTFoodStamp"));

		}
	}

	@And("^User Enters Service Details$")
	public void user_Enters_Service_Details() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Select Check Service Type
			functions.selectDropdown("Terminal_CheckServiceType", "VisibleText",
					testData.get("Terminal_CheckServiceType"));
			// Select Electronic Check
			functions.selectDropdown("Terminal_ElectronicCheck", "VisibleText",
					testData.get("Terminal_ElectronicCheck"));
			// Enter Check Servie ID
			functions.enterText("Terminal_CheckServiceId", testData.get("Terminal_CheckServiceId"));
		}
	}

	@And("^User Save the Terminal$")
	public void user_Save_Terminal() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Save
			functions.waitForElementUsingPresence("Terminal_Save");
			functions.clickAnElement("Terminal_Save", "Terminal_Save");
			// verify sucess Message
			functions.verifyElementTextPresent("Terminal_SuccessMsg", testData.get("Terminal_SuccessMsg"));
		}
	}

	@And("^User nav to Terminal AddCardsPage$")
	public void user_nav_to_TerminalAddCards() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Add Card Types
			functions.clickAnElement("Terminal_AddCards", "Terminal_AddCards");
			functions.globalWait(5);
		}
	}

	@And("^User Adding Card types to Terminal$")
	public void user_Add_CardTypes_Terminal() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Add
			functions.clickAnElement("Terminal_AddCards", "Terminal_AddCards");
			functions.globalWait(5);
			functions.waitForElementUsingPresence("Terminal_CardType");
			functions.globalWait(10);

			String[] CardTypes = testData.get("Terminal_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				String CardName = CardTypes[i];
				int Cardlistvalue=0;
				
				if(CardName.equalsIgnoreCase("HSBC Private Label")){
					Cardlistvalue=5909;
				}
				if(CardName.equalsIgnoreCase("Union Pay International")){
					Cardlistvalue=6086;
				}
				if(CardName.equalsIgnoreCase("MasterCard")){
					Cardlistvalue=663;
				}
				if(CardName.equalsIgnoreCase("Visa")){
					Cardlistvalue=659;
				}
				if(CardName.equalsIgnoreCase("JCB")){
					Cardlistvalue=669;
				}
				if(CardName.equalsIgnoreCase("HSBC Bonus Points")){
					Cardlistvalue=5910;
				}
				if(CardName.equalsIgnoreCase("Discover")){
					Cardlistvalue=668;
				}
				if(CardName.equalsIgnoreCase("American Express")){
					Cardlistvalue=666;
				}
				if(CardName.equalsIgnoreCase("Debit")){
					Cardlistvalue=690;
				}
				if(CardName.equalsIgnoreCase("EBT")){
					Cardlistvalue=5952;
				}
				if(CardName.equalsIgnoreCase("BPI Private Label")){
					Cardlistvalue=6193;
				}
				if(CardName.equalsIgnoreCase("Alipay")){
					Cardlistvalue=6205;
				}
				if(CardName.equalsIgnoreCase("WeChat")){
					Cardlistvalue=6206;
				}
				WebElement cardpath=FunctionsLibrary.driver.findElement(By.xpath("//input[@value='"+Cardlistvalue+"']"));
				functions.changeRadioButtonOrCheckBoxStatus(cardpath, testData.get("Terminal_Checkbox"));
				// Select EDC Indicator
				WebElement EdcInd=FunctionsLibrary.driver.findElement(By.xpath("//input[@value='"+Cardlistvalue+"']//following::select[@name='cardEdcIndicator'][1]"));
				functions.selectDropdownByVisibleText(EdcInd, testData.get("Terminal_EDcIndicator_" + CardTypes[i]));
				// Select Transaction Switching Option
				WebElement TranSwitch=FunctionsLibrary.driver.findElement(By.xpath("//input[@value='"+Cardlistvalue+"']//following::select[@name='transactionSwitch'][1]"));
				functions.selectDropdownByVisibleText(TranSwitch, testData.get("Terminal_TransactionSwitch_" + CardTypes[i]));
				// Click Save
				functions.clickAnElement("Terminal_Save", "Terminal_Save");

				functions.globalWait(8);
				functions.waitForElementUsingPresence("Terminal_CardAccepted_SuccessMsg");
				functions.verifyElementTextContains("Terminal_CardAccepted_SuccessMsg",
						testData.get("Terminal_CardAccepted_SuccessMsg"));

			}
		}
	}
	

	@And("^User Adding Card types to Terminal AuthOnly$")
	public void user_Add_CardTypes_Terminal_AuthOnly() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Add
			functions.waitForElementUsingPresence("Terminal_CardType");
			functions.globalWait(10);

			String[] CardTypes = testData.get("Terminal_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				functions.selectDropdownByVisibleText("Terminal_CardType", CardTypes[i]);

				// Select Transaction Switching Option
				functions.selectDropdownByVisibleText("Terminal_TransactionSwitch",
						testData.get("Terminal_TransactionSwitch_" + CardTypes[i]));
				// Click Save
				functions.globalWait(20);

				functions.clickAnElement("Terminal_Save", "Terminal_Save");

				functions.globalWait(8);
				functions.waitForElementUsingPresence("Terminal_CardAccepted_SuccessMsg");
				functions.verifyElementTextContains("Terminal_CardAccepted_SuccessMsg",
						testData.get("Terminal_CardAccepted_SuccessMsg"));
			}

		}
	}

	@And("^User Clicking Back To Terminal$")
	public void user_Back_To_terminal() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Terminal_BackToTerminal", "Terminal_BackToTerminal");
		}
	}

	

	@And("^User Updating  the Terminal$")
	public void user_update_terminal(String Terminal) {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
		functions.waitForElementUsingPresence("Terminal_Edit");
		functions.clickAnElement("Terminal_Edit", "Terminal_Edit");
		functions.clearText("Terminal_MCC");
		functions.enterText("Terminal_MCC", testData.get("Terminal_MCC"));
		functions.clickAnElement("Terminal_MCCDescription", "Terminal_MCCDescription");
		functions.globalWait(5);
		functions.verifyElementAttribute("Terminal_TCC", testData.get("Terminal_TCC"), "value");
		functions.clearText("Customer_NumberOfRefunds");
		functions.enterText("Customer_NumberOfRefunds", testData.get("Customer_NumberOfRefunds"));
		// Enter Total Dollar Amount of Refunds Allowed per Individual Batch
		functions.clearText("Terminal_TotalDollarAmount");
		functions.enterText("Terminal_TotalDollarAmount", testData.get("Terminal_TotalDollarAmount"));
		// Enter Dollar Amount of Individual Purchase Transaction Allowed
		functions.clearText("Terminal_DollarAmountIndividualPurchase");
		functions.enterText("Terminal_DollarAmountIndividualPurchase",
				testData.get("Terminal_DollarAmountIndividualPurchase"));
		// Enter Dollar Amount of Individual Refund Transaction Allowed
		functions.clearText("Terminal_DollarAmountIndividualRefund");
		functions.enterText("Terminal_DollarAmountIndividualRefund",
				testData.get("Terminal_DollarAmountIndividualRefund"));
		// Save
		functions.waitForElementUsingPresence("Terminal_Save");
		functions.clickAndEnterAnElement("Terminal_Save", "Terminal_Save");
		// verify sucess Message
		functions.waitForElementUsingPresence("Terminal_UpdateMsg");
		functions.verifyElementTextPresent("Terminal_UpdateMsg", testData.get("Terminal_UpdateMsg"));
		}
	}

	@And("^User Updating  the TerminalDetails$")
	public void user_update_terminalDetails(String TerminalDetails) {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
		// Select 90% Healthcare
		functions.enterText("Terminal_HealthCare", testData.get("Terminal_HealthCare"));
		// Select Capture method
		functions.selectDropdown("Terminal_CaptureMethod", "VisibleText", testData.get("Terminal_CaptureMethod"));
		functions.globalWait(5);
		// Select Batch Close Type
		functions.selectDropdown("Terminal_BatchCloseType", "VisibleText", testData.get("Terminal_BatchCloseType"));
		functions.globalWait(5);
		// Select Voice Allowed
		functions.selectDropdown("Terminal_VoiceAllowed", "VisibleText", testData.get("Terminal_VoiceAllowed"));
		// MasterCard CAT level
		functions.selectDropdown("Terminal_MCCatLevel", "VisibleText", testData.get("Terminal_MCCatLevel"));
		// VISA CAT level
		functions.selectDropdown("Terminal_VISACatLevel", "VisibleText", testData.get("Terminal_VISACatLevel"));
		// Select HelpDesk
		functions.selectDropdown("Terminal_HelpDesk", "VisibleText", testData.get("Terminal_HelpDesk"));
		functions.globalWait(2);
		// Select Product Code
		functions.selectDropdown("Terminal_ProductCode", "VisibleText", testData.get("Terminal_ProductCode"));
		// Select Alternate DBA Indicator
		functions.selectDropdown("Terminal_AlternateDBA", "VisibleText", testData.get("Terminal_AlternateDBA"));
		functions.globalWait(5);
		}
	}

	@And("^User Updating  the DebitDetails$")
	public void user_update_DebitDetails(String DebitDetails) {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
		// Select Debit/EBT returns
		functions.waitForElementUsingPresence("Terminal_DebitAndEBTReturnsAllowed");
		functions.selectDropdown("Terminal_DebitAndEBTReturnsAllowed", "VisibleText",
				testData.get("Terminal_DebitAndEBTReturnsAllowed"));
		// Select PIN debit
		functions.selectDropdown("Terminal_PinDebit", "VisibleText", testData.get("Terminal_PinDebit"));
		// Select PINLess debit
		functions.waitForElementUsingPresence("Terminal_PinLessGateWay");
		functions.selectDropdown("Terminal_PinLessGateWay", "VisibleText", testData.get("Terminal_PinLessGateWay"));
		// Select EBT cash benefits
		functions.selectDropdown("Terminal_EBTCashBenefits", "VisibleText", testData.get("Terminal_EBTCashBenefits"));
		// Select EBT foodstamp
		functions.selectDropdown("Terminal_EBTFoodStamp", "VisibleText", testData.get("Terminal_EBTFoodStamp"));
		// Select Encryption name
		functions.selectDropdown("Terminal_EncryptionName", "VisibleText", testData.get("Terminal_EncryptionName"));
		}
	}

	@And("^User Updating  the  AddressDetails$")
	public void user_update_AddressDetails(String AddressDetails) {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;

		functions.changeRadioButtonOrCheckBoxStatus("Terminal_UseMerchnatAddress",
				testData.get("Terminal_UseMerchnatAddress"));
		// Enter Address 1
		functions.clearText("Terminal_Address1");
		functions.enterText("Terminal_Address1", testData.get("Terminal_Address1"));
		// Enter Address 2
		functions.clearText("Terminal_Address2");
		functions.enterText("Terminal_Address2", testData.get("Terminal_Address2"));
		// Enter City
		functions.clearText("Terminal_City");
		functions.enterText("Terminal_City", testData.get("Terminal_City"));
		// Enter Zip/Postal Code
		functions.clearText("Terminal_PostalCode");
		functions.enterText("Terminal_PostalCode", testData.get("Terminal_PostalCode"));
		// Enter Country
		functions.clearText("Terminal_Country");
		functions.enterText("Terminal_Country", testData.get("Terminal_Country"));
		functions.clickAnElement("Terminal_DBACountryDescription", "Terminal_DBACountryDescription");
		functions.globalWait(5);
		functions.selectDropdown("Terminal_State", "VisibleText", testData.get("Terminal_State"));

	}
	}

	@And("^User validate the terminal$")
	public void user_validate_terminal() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
		// Click Button Validate
		functions.waitForElementUsingPresence("Terminal_Validate");
		functions.clickAnElement("Terminal_Validate", "Terminal_Validate");
		// verify validate Message
		functions.waitForElementUsingPresence("Terminal_ValidateMsg");
		functions.verifyElementTextContains("Terminal_ValidateMsg", testData.get("Terminal_ValidateMsg"));
		}
	}

	@Then("^User Change the terminal Status$")
	public void user_validate_terminalStatus() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
		// Click Button Edit
		functions.waitForElementUsingPresence("Terminal_Edit");
		functions.clickAnElement("Terminal_Edit", "Terminal_Edit");
		functions.waitForElementUsingPresence("Terminal_Save");
		// Change Status
		functions.selectDropdownByVisibleText("Terminal_Status", testData.get("Terminal_Status"));
		// click on save
		functions.clickAndEnterAnElement("Terminal_Save", "Terminal_Save");
		functions.globalWait(10);
		// Verify Confirm Message
		functions.waitForElementUsingPresence("Terminal_UpdateMsg");
		functions.verifyElementTextPresent("Terminal_UpdateMsg", testData.get("Terminal_UpdateMsg"));
		}
	}

	@And("^User search the terminal $")
	public void user_search_terminal() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
		// Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		// Click on Terminal tab
		functions.clickAnElement("Terminal_NavToTerminal", "Terminal_NavToTerminal");
		functions.waitForElementUsingPresence("Terminal_TerminalIdSearch");
		// Enter Terminal Number to search

		functions.enterText("Terminal_TerminalIdSearch", testData.get("Terminal_TerminalIdSearch"));
		// Click on Search Button
		//functions.clickAnElement("Terminal_LikeSearch", "Terminal_LikeSearch");
		functions.clickAnElement("Terminal_Search", "Terminal_Search");
	}
	}
	@When("^User Create Open Terminal$")
	public void user_Create_OpenTerminal() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			user_Navigates_to_AddTerminalPage();
			
			user_Enter_MerchantID_Dynamically();
			
			user_Creating_UniqueTerminalID();
			
			user_Enters_All_Details();
			
			user_Enters_Terminal_Details_MerchantInitiated();
			
			user_check_MerhAddressDetails();
			
			user_Enters_RefundAndPurchaseDetails();
			
			user_Save_Terminal();
			
			user_Add_CardTypes_Terminal();
			
			user_Back_To_terminal();
			
			user_validate_terminal();
			
			user_validate_terminalStatus();
		}
	}
	@Then("^User Validating Terminal CMF Database Region \"([^\"]*)\"$")
	public void CMF_DB_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.CMFDatabase(Region);
		String TermNum=functions.getEnvironmentVariable("TerminalID");
		String query=testData.get("Terminal_CMF_Query1")+TermNum+"' and rownum='1'";
		functions.globalWait(65);
		functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("Term_CMF_DBExpected"));
		}
	}
	@Then("^User Validating Terminal G2 Database Region \"([^\"]*)\"$")
	public void G2DB_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.G2Database(Region);
		String TermNum=functions.getEnvironmentVariable("TerminalID");
		String query=testData.get("Terminal_G2_Query1")+TermNum+"' and rownum='1'";
		functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("Term_G2_DBExpected"));
		}
	}
	@Then("^User Validating Terminal CMF Database Multiple values \"([^\"]*)\"$")
	public void CMF_DB_Multiple_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.CMFDatabase(Region);
		String TermNum=functions.getEnvironmentVariable("TerminalID");
		String[] CMFDBExpected=testData.get("Term_CMF_DBExpected").split("@@");
		functions.globalWait(65);
		for(int i=1;i<=CMFDBExpected.length;i++)
		{
		String query=testData.get("Terminal_CMF_Query"+i)+TermNum+"' and rownum='1'";
			
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, CMFDBExpected[i]);
		}
		}
	}
	@Then("^User Validating Terminal G2 Database Multiple values \"([^\"]*)\"$")
	public void G2DB_Multiple_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.G2Database(Region);
		String TermNum=functions.getEnvironmentVariable("TerminalID");
		String[] G2DBExpected=testData.get("Term_G2_DBExpected").split("@@");
		functions.globalWait(65);
		for(int i=1;i<=G2DBExpected.length;i++)
		{
		String query=testData.get("Terminal_G2_Query"+i)+TermNum+"' and rownum='1'";
			
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, G2DBExpected[i]);
		}
		}
	}
}




/*
 * // Verify values in DB for Customer
 * 
 * public void verifyDBValuesTerminalUS(String strDataFileName, String
 * strReportFileName){ String strTerminalNumber =
 * Utilities.getEnvironmentVariable("DBTerminalNumber1"); //String
 * strTerminalNumber = Utilities.getEnvironmentVariable("SrchdTerminalNo1");
 * String strQuery = null;
 * 
 * // Verify strQuery =
 * "SELECT mccv.numeric_mcc,mccv.merchant_cat_code_description ,mccv.tcc_description ,tdv.message_format_desc ,tdv.REFUND_ALLOWED_PER_IND_BATCH ,tdv.TOT_AMT_PER_IND_BATCH ,tdv.AMT_IND_PURCHASE_TRX ,tdv.AMT_IND_REFUND_TRX FROM merchant_cat_code_view mccv, terminal_details_view tdv WHERE mccv.merchant_category_codes_id = tdv.merchant_category_codes_id AND tdv.terminal_number = '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues1", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT NINETY_PER_HEALTHCARE, CAPTURE_METHOD, BATCH_CLOSE_TYPE, MC_CAT_LEVEL, VISA_CAT_LEVEL, IS_VOICE_ALLOWED FROM terminal_details_view WHERE TERMINAL_NUMBER ='"
 * + strTerminalNumber + "' AND rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues2", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT HELP_DESK_IND, ACI_CONVERSION, PRODUCT_CODE, ALTERNATE_DBA_INDICATOR, STAND_IN_PROCESSING FROM terminal_details_view WHERE TERMINAL_NUMBER= '"
 * + strTerminalNumber + "' AND rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues3", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT max_days FROM terminal_details_view WHERE terminal_number = '" +
 * strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues4", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT TIME_ZONE, USE_MERCHANT_ADDRESS, PIN_DEBIT_IND, PINLESS_DEBIT_IND FROM terminal_details_view WHERE TERMINAL_NUMBER= '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues5", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT MERCHANT_DBA_NAME FROM terminal_details_view WHERE terminal_number = '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues6", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT ADDRESS1, ADDRESS2, CITY, STATE_NAME, POSTAL_CODE, COUNTRY_NAME FROM terminal_address_view WHERE TERMINAL_NUMBER= '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues7", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT tctv.card_type_desc FROM terminal_card_type_view tctv, terminal_details_view tdv WHERE tctv.terminal_id = tdv.terminal_id AND tdv.terminal_number= '"
 * + strTerminalNumber + "'  order by tctv.card_type_desc";
 * verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues8", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT PIN_DEBIT_RETURNS_ALLOWED, IS_EBT_CASH_BENEFIT, IS_EBT_FOOD_STAMP, ENCRYPTION_ID, IS_ELECTRONIC_CHECK FROM terminal_details_view WHERE TERMINAL_NUMBER='"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues9", reporter, strReportFileName); }
 * 
 * public void verifyG2DBValuesTerminalUS(String strDataFileName, String
 * strReportFileName){ String strTerminalNumber =
 * Utilities.getEnvironmentVariable("DBTerminalNumber1"); //String
 * strTerminalNumber = Utilities.getEnvironmentVariable("SrchdTerminalNo1");
 * String strQuery = null;
 * 
 * // Verify
 * strQuery="SELECT ebdf.MERCH_CAT_CD, ebdf.MESSAGE_SPEC_IND, ebdf.MAX_REFUND_BATCH_COUNT, ebdf.MAX_REFUND_BATCH_AMOUNT,ebdf.MAX_REFUND_TRAN_AMOUNT,ebdf.MAX_TRAN_AMOUNT,ebdf.NINETY_HEALTHCARE,ebdf.CAPTURE_METHOD, ebdf.BATCH_CLOSE_TYPE,ebdf.VOICE_IND from  EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_TermDtls", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="Select ebdf.ACI_CONV_IND,ebdf.ALT_DBA_IND,ebdf.STAND_IN_IND,ebdf.MAX_DAYS_SETTLE from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_DeviceDtls", reporter, strReportFileName);
 * 
 * // Verify strQuery="select  TIMEZONE from EB_device  where DEVICE_NAME= '" +
 * strTerminalNumber + "'";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Timezone", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select ebdf.PIN_DEBIT_IND, ebdf.PINLESS_DEBIT_IND , ebdf.DBA_NAME from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_PinDtls", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select ebdf.ADDR1,ebdf.ADDR2,ebdf.CITY,ebdf.STATE,ebdf.POSTCODE,ebdf.COUNTRY,ebdf.CURRENCY_CD from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Addr", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select  ebm.CARD_TYPE from EB_MERCH_XREF ebm,EB_DEVICE ebd   where ebm.DEVICE_NBR = ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' order by ebm.CARD_TYPE";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Cards", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select ebdf.PINDB_RET_ALLOW, ebdf.EBT_CASH_IND,ebdf. EBT_FOOD_IND,ebdf.CRYPTO_KEY_ID,ebdf.ELEC_CHECK_IND from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_EncryptionDtls", reporter, strReportFileName); }
 * public void verifyDBValuesTerminalUS(String strDataFileName, String
 * strReportFileName,String strTerminalNumber){ //String strTerminalNumber =
 * Utilities.getEnvironmentVariable("DBTerminalNumber1"); //String
 * strTerminalNumber = Utilities.getEnvironmentVariable("SrchdTerminalNo1");
 * String strQuery = null; stepExecutor.globalWait(60); // Verify strQuery =
 * "SELECT mccv.numeric_mcc,mccv.merchant_cat_code_description ,mccv.tcc_description ,tdv.message_format_desc ,tdv.REFUND_ALLOWED_PER_IND_BATCH ,tdv.TOT_AMT_PER_IND_BATCH ,tdv.AMT_IND_PURCHASE_TRX ,tdv.AMT_IND_REFUND_TRX FROM merchant_cat_code_view mccv, terminal_details_view tdv WHERE mccv.merchant_category_codes_id = tdv.merchant_category_codes_id AND tdv.terminal_number = '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues1", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT NINETY_PER_HEALTHCARE, CAPTURE_METHOD, BATCH_CLOSE_TYPE, MC_CAT_LEVEL, VISA_CAT_LEVEL, IS_VOICE_ALLOWED FROM terminal_details_view WHERE TERMINAL_NUMBER ='"
 * + strTerminalNumber + "' AND rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues2", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT HELP_DESK_IND, ACI_CONVERSION, PRODUCT_CODE, ALTERNATE_DBA_INDICATOR, STAND_IN_PROCESSING FROM terminal_details_view WHERE TERMINAL_NUMBER= '"
 * + strTerminalNumber + "' AND rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues3", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT max_days FROM terminal_details_view WHERE terminal_number = '" +
 * strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues4", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT TIME_ZONE, USE_MERCHANT_ADDRESS, PIN_DEBIT_IND, PINLESS_DEBIT_IND FROM terminal_details_view WHERE TERMINAL_NUMBER= '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues5", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT MERCHANT_DBA_NAME FROM terminal_details_view WHERE terminal_number = '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues6", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT ADDRESS1, ADDRESS2, CITY, STATE_NAME, POSTAL_CODE, COUNTRY_NAME FROM terminal_address_view WHERE TERMINAL_NUMBER= '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues7", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT tctv.card_type_desc FROM terminal_card_type_view tctv, terminal_details_view tdv WHERE tctv.terminal_id = tdv.terminal_id AND tdv.terminal_number= '"
 * + strTerminalNumber + "'  order by tctv.card_type_desc";
 * verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues8", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT PIN_DEBIT_RETURNS_ALLOWED, IS_EBT_CASH_BENEFIT, IS_EBT_FOOD_STAMP, ENCRYPTION_ID, IS_ELECTRONIC_CHECK FROM terminal_details_view WHERE TERMINAL_NUMBER='"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues9", reporter, strReportFileName); }
 * 
 * public void verifyG2DBValuesTerminalUS(String strDataFileName, String
 * strReportFileName,String strTerminalNumber){ //String strTerminalNumber =
 * Utilities.getEnvironmentVariable("DBTerminalNumber1"); //String
 * strTerminalNumber = Utilities.getEnvironmentVariable("SrchdTerminalNo1");
 * String strQuery = null;
 * 
 * // Verify
 * strQuery="SELECT ebdf.MERCH_CAT_CD, ebdf.MESSAGE_SPEC_IND, ebdf.MAX_REFUND_BATCH_COUNT, ebdf.MAX_REFUND_BATCH_AMOUNT,ebdf.MAX_REFUND_TRAN_AMOUNT,ebdf.MAX_TRAN_AMOUNT,ebdf.NINETY_HEALTHCARE,ebdf.CAPTURE_METHOD, ebdf.BATCH_CLOSE_TYPE,ebdf.VOICE_IND from  EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_TermDtls", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="Select ebdf.ACI_CONV_IND,ebdf.ALT_DBA_IND,ebdf.STAND_IN_IND,ebdf.MAX_DAYS_SETTLE from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_DeviceDtls", reporter, strReportFileName);
 * 
 * // Verify strQuery="select  TIMEZONE from EB_device  where DEVICE_NAME= '" +
 * strTerminalNumber + "'";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Timezone", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select ebdf.PIN_DEBIT_IND, ebdf.PINLESS_DEBIT_IND , ebdf.DBA_NAME from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_PinDtls", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select ebdf.ADDR1,ebdf.ADDR2,ebdf.CITY,ebdf.STATE,ebdf.POSTCODE,ebdf.COUNTRY,ebdf.CURRENCY_CD from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Addr", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select ebm.CARD_TYPE from EB_MERCH_XREF ebm,EB_DEVICE ebd where ebm.DEVICE_NBR = ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' order by ebm.CARD_TYPE";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Cards", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select ebdf.PINDB_RET_ALLOW, ebdf.EBT_CASH_IND,ebdf. EBT_FOOD_IND,ebdf.CRYPTO_KEY_ID,ebdf.ELEC_CHECK_IND from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_EncryptionDtls", reporter, strReportFileName); }
 * 
 * public void verifyDBValuesTerminalAP(String strDataFileName, String
 * strReportFileName){ String strTerminalNumber =
 * Utilities.getEnvironmentVariable("DBTerminalNumber2"); //String
 * strTerminalNumber = Utilities.getEnvironmentVariable("APSrchdTerminalNo");
 * String strQuery = null;
 * 
 * // Verify strQuery =
 * "SELECT mccv.numeric_mcc,mccv.merchant_cat_code_description ,mccv.tcc_description ,tdv.message_format_desc ,tdv.REFUND_ALLOWED_PER_IND_BATCH ,tdv.TOT_AMT_PER_IND_BATCH ,tdv.AMT_IND_PURCHASE_TRX ,tdv.AMT_IND_REFUND_TRX FROM merchant_cat_code_view mccv, terminal_details_view tdv WHERE mccv.merchant_category_codes_id = tdv.merchant_category_codes_id AND tdv.terminal_number = '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues1", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT NINETY_PER_HEALTHCARE, CAPTURE_METHOD, BATCH_CLOSE_TYPE, MC_CAT_LEVEL, VISA_CAT_LEVEL, IS_VOICE_ALLOWED FROM terminal_details_view WHERE TERMINAL_NUMBER ='"
 * + strTerminalNumber + "' AND rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues2", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT HELP_DESK_IND, ACI_CONVERSION, PRODUCT_CODE, ALTERNATE_DBA_INDICATOR, STAND_IN_PROCESSING FROM terminal_details_view WHERE TERMINAL_NUMBER= '"
 * + strTerminalNumber + "' AND rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues3", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT max_days FROM terminal_details_view WHERE terminal_number = '" +
 * strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues4", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT TIME_ZONE, USE_MERCHANT_ADDRESS, PIN_DEBIT_IND, PINLESS_DEBIT_IND FROM terminal_details_view WHERE TERMINAL_NUMBER= '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues5", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT MERCHANT_DBA_NAME FROM terminal_details_view WHERE terminal_number = '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues6", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT ADDRESS1, ADDRESS2, CITY, POSTAL_CODE, COUNTRY_NAME FROM terminal_address_view WHERE TERMINAL_NUMBER= '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues7", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT tctv.card_type_desc FROM terminal_card_type_view tctv, terminal_details_view tdv WHERE tctv.terminal_id = tdv.terminal_id AND tdv.terminal_number= '"
 * + strTerminalNumber + "' order by tctv.card_type_desc";
 * verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues8", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT PIN_DEBIT_RETURNS_ALLOWED, IS_EBT_CASH_BENEFIT, IS_EBT_FOOD_STAMP, ENCRYPTION_ID, IS_ELECTRONIC_CHECK FROM terminal_details_view WHERE TERMINAL_NUMBER='"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues9", reporter, strReportFileName); }
 * 
 * public void verifyDBValuesTerminalAP(String strDataFileName, String
 * strReportFileName,String strTerminalNumber){ //String strTerminalNumber =
 * Utilities.getEnvironmentVariable("DBTerminalNumber2"); //String
 * strTerminalNumber = Utilities.getEnvironmentVariable("APSrchdTerminalNo");
 * String strQuery = null; stepExecutor.globalWait(60); // Verify strQuery =
 * "SELECT mccv.numeric_mcc,mccv.merchant_cat_code_description ,mccv.tcc_description ,tdv.message_format_desc ,tdv.REFUND_ALLOWED_PER_IND_BATCH ,tdv.TOT_AMT_PER_IND_BATCH ,tdv.AMT_IND_PURCHASE_TRX ,tdv.AMT_IND_REFUND_TRX FROM merchant_cat_code_view mccv, terminal_details_view tdv WHERE mccv.merchant_category_codes_id = tdv.merchant_category_codes_id AND tdv.terminal_number = '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues1", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT NINETY_PER_HEALTHCARE, CAPTURE_METHOD, BATCH_CLOSE_TYPE, MC_CAT_LEVEL, VISA_CAT_LEVEL, IS_VOICE_ALLOWED FROM terminal_details_view WHERE TERMINAL_NUMBER ='"
 * + strTerminalNumber + "' AND rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues2", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT HELP_DESK_IND, ACI_CONVERSION, PRODUCT_CODE, ALTERNATE_DBA_INDICATOR, STAND_IN_PROCESSING FROM terminal_details_view WHERE TERMINAL_NUMBER= '"
 * + strTerminalNumber + "' AND rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues3", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT max_days FROM terminal_details_view WHERE terminal_number = '" +
 * strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues4", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT TIME_ZONE, USE_MERCHANT_ADDRESS, PIN_DEBIT_IND, PINLESS_DEBIT_IND FROM terminal_details_view WHERE TERMINAL_NUMBER= '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues5", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT MERCHANT_DBA_NAME FROM terminal_details_view WHERE terminal_number = '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues6", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT ADDRESS1, ADDRESS2, CITY, POSTAL_CODE, COUNTRY_NAME FROM terminal_address_view WHERE TERMINAL_NUMBER= '"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues7", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT tctv.card_type_desc FROM terminal_card_type_view tctv, terminal_details_view tdv WHERE tctv.terminal_id = tdv.terminal_id AND tdv.terminal_number= '"
 * + strTerminalNumber + "' order by tctv.card_type_desc";
 * verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues8", reporter, strReportFileName);
 * 
 * // Verify strQuery =
 * "SELECT PIN_DEBIT_RETURNS_ALLOWED, IS_EBT_CASH_BENEFIT, IS_EBT_FOOD_STAMP, ENCRYPTION_ID, IS_ELECTRONIC_CHECK FROM terminal_details_view WHERE TERMINAL_NUMBER='"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues9", reporter, strReportFileName); }
 * 
 * 
 * public void verifyG2DBValuesTerminalAP(String strDataFileName, String
 * strReportFileName){ String strTerminalNumber =
 * Utilities.getEnvironmentVariable("DBTerminalNumber2"); //String
 * strTerminalNumber = Utilities.getEnvironmentVariable("APSrchdTerminalNo");
 * String strQuery = null;
 * 
 * // Verify
 * strQuery="SELECT ebdf.MERCH_CAT_CD, ebdf.MESSAGE_SPEC_IND, ebdf.MAX_REFUND_BATCH_COUNT, ebdf.MAX_REFUND_BATCH_AMOUNT,ebdf.MAX_REFUND_TRAN_AMOUNT,ebdf.MAX_TRAN_AMOUNT,ebdf.NINETY_HEALTHCARE,ebdf.CAPTURE_METHOD, ebdf.BATCH_CLOSE_TYPE,ebdf.VOICE_IND from  EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_TermDtls", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="Select ebdf.ACI_CONV_IND,ebdf.ALT_DBA_IND,ebdf.STAND_IN_IND,ebdf.MAX_DAYS_SETTLE from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_DeviceDtls", reporter, strReportFileName);
 * 
 * // Verify strQuery="select  TIMEZONE from EB_device  where DEVICE_NAME= '" +
 * strTerminalNumber + "'";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Timezone", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select ebdf.PIN_DEBIT_IND, ebdf.PINLESS_DEBIT_IND , ebdf.DBA_NAME from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_PinDtls", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select ebdf.ADDR1,ebdf.ADDR2,ebdf.CITY,ebdf.STATE,ebdf.POSTCODE,ebdf.COUNTRY,ebdf.CURRENCY_CD from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Addr", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select  ebm.CARD_TYPE from EB_MERCH_XREF ebm,EB_DEVICE ebd   where ebm.DEVICE_NBR = ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' order by ebm.CARD_TYPE";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Cards", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select ebdf.PINDB_RET_ALLOW, ebdf.EBT_CASH_IND,ebdf. EBT_FOOD_IND,ebdf.CRYPTO_KEY_ID,ebdf.ELEC_CHECK_IND from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_EncryptionDtls", reporter, strReportFileName); }
 * 
 * public void verifyG2DBValuesTerminalAP(String strDataFileName, String
 * strReportFileName,String strTerminalNumber){ //String strTerminalNumber =
 * Utilities.getEnvironmentVariable("DBTerminalNumber2"); //String
 * strTerminalNumber = Utilities.getEnvironmentVariable("APSrchdTerminalNo");
 * String strQuery = null;
 * 
 * // Verify
 * strQuery="SELECT ebdf.MERCH_CAT_CD, ebdf.MESSAGE_SPEC_IND, ebdf.MAX_REFUND_BATCH_COUNT, ebdf.MAX_REFUND_BATCH_AMOUNT,ebdf.MAX_REFUND_TRAN_AMOUNT,ebdf.MAX_TRAN_AMOUNT,ebdf.NINETY_HEALTHCARE,ebdf.CAPTURE_METHOD, ebdf.BATCH_CLOSE_TYPE,ebdf.VOICE_IND from  EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_TermDtls", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="Select ebdf.ACI_CONV_IND,ebdf.ALT_DBA_IND,ebdf.STAND_IN_IND,ebdf.MAX_DAYS_SETTLE from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_DeviceDtls", reporter, strReportFileName);
 * 
 * // Verify strQuery="select  TIMEZONE from EB_device  where DEVICE_NAME= '" +
 * strTerminalNumber + "'";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Timezone", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select ebdf.PIN_DEBIT_IND, ebdf.PINLESS_DEBIT_IND , ebdf.DBA_NAME from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_PinDtls", reporter, strReportFileName);
 * 
 * // Verify //
 * strQuery="select ebdf.ADDR1,ebdf.ADDR2,ebdf.CITY,ebdf.STATE,ebdf.POSTCODE,ebdf.COUNTRY,ebdf.CURRENCY_CD from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1 ";
 * //verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Addr", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select  ebm.CARD_TYPE from EB_MERCH_XREF ebm,EB_DEVICE ebd   where ebm.DEVICE_NBR = ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' order by ebm.CARD_TYPE";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Cards", reporter, strReportFileName);
 * 
 * // Verify
 * strQuery="select ebdf.PINDB_RET_ALLOW, ebdf.EBT_CASH_IND,ebdf. EBT_FOOD_IND,ebdf.CRYPTO_KEY_ID,ebdf.ELEC_CHECK_IND from EB_DEV_FIN ebdf,EB_DEVICE ebd where ebdf.DEVICE_NBR=ebd.DEVICE_NBR and DEVICE_NAME='"
 * + strTerminalNumber + "' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_EncryptionDtls", reporter, strReportFileName);
 * 
 * }
 */
