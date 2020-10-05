package com.webapp.stepDefinition;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.webapp.baseLibrary.FunctionsLibrary;
import com.webapp.executioner.ExecutionerClass;
import com.webapp.page.ReusableFunctions;
import com.webapp.utilities.GridReporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CMF_Merchant_Creation extends ExecutionerClass {

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

	@When("^User navigates to Add Merchant Page$")
	public void user_Navigates_to_AddMerchantPage() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			// Add Merchant link
			functions.clickAnElement("Merchant_AddMerchant", "Add Merchant");
		}
	}

	@When("^User navigates to Merchant Page$")
	public void user_Navigates_to_MerchantPage() throws Throwable {
		// Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		// Click on Customer tab
		functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
	}

	@And("^User Enters parent customer$")
	public void user_Enter_ParentCustomer_FromFile() throws Throwable {
		// Verify Alert text and click OK
		functions.acceptAlertWithoutText("accept");
		functions.globalWait(5);
		// Enter Parent customer
		functions.enterText("Merchant_ParentCustomerNumber", testData.get("Merchant_ParentCustomerNumber"));
		FunctionsLibrary.driver.findElement(By.id("customerName")).click();
		functions.waitForElementUsingPresence("Merchant_Save");
		String ParentCustNumber = testData.get("Merchant_ParentCustomerNumber");

		functions.setEnvironmentVariable("CustomerNumber", ParentCustNumber);
		functions.globalWait(15);
	}

	@And("^User Enters parent customer Dynamically$")
	public void user_Enter_ParentCustomer_Dynamically() throws Throwable {
		// Verify Alert text and click OK
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.acceptAlertWithoutText("accept");
			functions.globalWait(5);
			// Enter Parent customer
			functions.enterText("Merchant_ParentCustomerNumber", functions.getEnvironmentVariable("CustomerNumber"));
			FunctionsLibrary.driver.findElement(By.id("customerName")).click();
			functions.waitForElementUsingPresence("Merchant_Save");
			//String ParentCustNumber = testData.get("Merchant_ParentCustomerNumber");
			functions.globalWait(12);
			// functions.setEnvironmentVariable(EnvVariable, ParentCustNumber);
		}
	}

	@And("^User Search parent customer$")
	public void user_Searchfor_ParentCustomer() throws Throwable {
		// Verify Alert text and click OK
		functions.acceptAlertWithoutText("accept");
		functions.globalWait(5);
		// Click on search Button
		functions.clickAnElement("Merchant_ParentCustomerNumberSearch", "ParentCustNumberSearch_Button");
		functions.globalWait(5);
		// Window handle
		functions.switchToNewWindow();

		functions.enterText("Merchant_ParentCustomerNumber", testData.get("Merchant_ParentCustomerNumber"));

		functions.clickAnElement("Merchant_AcquirerNameSearch", "ParentCustSearch");

		functions.changeRadioButtonOrCheckBoxStatus("Merchant_ParentCustomer_Radio", testData.get("RadioButton"));
		int counter = 0;
		while (FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size() <= 0) {
			functions.globalWait(1);
			counter++;
			if (counter == 60) {
				break;
			}
		}
		counter = 0;
		while (!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()) {
			functions.globalWait(1);
			counter++;
			if (counter == 60) {
				break;
			}
		}
		functions.clickAnElement("Merchant_ParentCustomer_Select", "Select");
		functions.globalWait(5);
		functions.switchToParentWindow();
		functions.waitForElementUsingPresence("Merchant_Save");
	}

	@And("^User Creates unique Merchant ID$")
	public void user_create_MerchantID() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			Random ran = new Random(System.currentTimeMillis());
			int x = (int) (Math.random() * 99) + Math.abs(ran.nextInt());
			String strMerchantNum = "0000091";
			strMerchantNum = strMerchantNum.concat(Integer.toString(x));
			functions.setEnvironmentVariable("MerchantNumber", strMerchantNum);
			functions.enterText("Merchant_MerchantId", strMerchantNum);
			functions.globalWait(5);
		}
	}

	@And("^User searching for Existing Merchant$")
	public void user_Search_for_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			// Enter Merchant Number to search
			functions.enterText("Merchant_MerchantIdSearch", testData.get("Merchant_MerchantIdSearch"));
			// Click on Search Button
			functions.clickAnElement("Merchant_Existing_Search", "Search");
			String MerchantNumber = testData.get("Merchant_MerchantIdSearch");
			functions.setEnvironmentVariable("MerchNumber", MerchantNumber);
		}
	}

	@And("^User fill overview details of Merchant$")
	public void user_Fill_OverviewDetails_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Enter DBAName
			functions.enterText("Merchant_DBAName", testData.get("Merchant_DBAName"));
			// Enter LegalName
			functions.enterText("Merchant_LegalName", testData.get("Merchant_LegalName"));
			// Enter Store ID
			functions.enterText("Merchant_StoreId", testData.get("Merchant_StoreId"));
			// Select BIN Blocking
			//functions.selectDropdownByVisibleText("Merchant_BinBlocking", testData.get("Merchant_BinBlocking"));
		}
	}

	@And("^User fill Address details of Merchant$")
	public void user_Fill_AddressDetails_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Enter Address 1
			functions.enterText("Merchant_Address1", testData.get("Merchant_Address1"));
			// Enter Address 2
			functions.enterText("Merchant_Address2", testData.get("Merchant_Address2"));
			// Enter City
			functions.enterText("Merchant_city", testData.get("Merchant_city"));
			// Enter Zip/Postal Code
			functions.enterText("Merchant_PostalCode", testData.get("Merchant_PostalCode"));
			// Enter Country
			functions.enterText("Merchant_Country", testData.get("Merchant_Country"));
			FunctionsLibrary.driver.findElement(By.id("dbaCountryCodeDescription")).click();
			functions.globalWait(10);
			// if(FunctionsLibrary.driver.getCurrentUrl().contains("CMFNA")) {
			functions.selectDropdownByVisibleText("Merchant_State", testData.get("Merchant_State"));
			// }
			// Enter PrimaryContact
			functions.enterText("Merchant_PrimaryContact", testData.get("Merchant_PrimaryContact"));
			// Enter Merchant Phone Number
			functions.enterText("Merchant_MerchantPhoneNumber", testData.get("Merchant_MerchantPhoneNumber"));
			// Enter Customer Service Phone
			functions.enterText("Merchant_CustomerServicePhone", testData.get("Merchant_CustomerServicePhone"));
			// Enter PrimaryContactEmail
			functions.enterText("Merchant_EmailAddress", testData.get("Merchant_EmailAddress"));
		}
	}

	// Add Currency
	@And("^User Adding Currency to Merchant$")
	public void user_Adding_Currency_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Merchant_Currency_Add_Button", "AddCurrency");
			functions.globalWait(5);
			functions.switchToNewWindow();
			if (FunctionsLibrary.driver.findElements(By.id("overridelink")).size() != 0) {
				System.out.println("Clicking Certificate link");
				FunctionsLibrary.driver.findElement(By.id("overridelink")).click();
				functions.globalWait(5);
			}
			// Enter Currency Code
			functions.waitForElementUsingPresence("Merchant_CurrencyCode_filed");
			functions.enterText("Merchant_CurrencyCode_filed", testData.get("Merchant_CurrencyCode_filed"));
			// Click on search button
			functions.clickAnElement("Merchant_CurrencyCode_SearchButton", "Search");
			functions.waitForElementUsingPresence("Merchant_CurrencyCode_Checkbox");
			functions.changeRadioButtonOrCheckBoxStatus("Merchant_CurrencyCode_Checkbox",
					testData.get("Merchant_check"));
			int counter = 0;
			while (FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size() <= 0) {
				functions.globalWait(1);
				counter++;
				if (counter == 60) {
					break;
				}
			}
			counter = 0;
			while (!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()) {
				functions.globalWait(1);
				counter++;
				if (counter == 60) {
					break;
				}
			}
			// Click on Select Button
			functions.clickAnElement("Merchant_AcquirerSelect", "Select");
			functions.globalWait(10);
			// Switching to Main window
			functions.switchToParentWindow();
			functions.globalWait(5);
			// Verify Added Currency Code
			functions.verifyElementPresent("Merchant_AddedCurrencyCode_Verify");
		}
	}

	// Add Currency
	@And("^User Adding Multiple Currencies to Merchant$")
	public void user_Add_Currencies_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Merchant_Currency_Add_Button", "AddCurrency");
			functions.globalWait(5);
			functions.switchToNewWindow();
			if (FunctionsLibrary.driver.findElements(By.id("overridelink")).size() != 0) {
				System.out.println("Clicking Certificate link");
				FunctionsLibrary.driver.findElement(By.id("overridelink")).click();
				functions.globalWait(5);
			}
			// Enter Currency Code
			functions.waitForElementUsingPresence("Merchant_CurrencyCode_filed");
			String[] Cunrrency = testData.get("Merchant_Currencies").split("@@");
			for (int i = 0; i < Cunrrency.length; i++) {
				WebElement Currencycode = FunctionsLibrary.driver
						.findElement(By.xpath("//td[contains(text(),'" + Cunrrency[i] + "')]/../td/input"));
				functions.waitForElementUsingPresence("Merchant_CurrencyCode_Checkbox");
				functions.changeRadioButtonOrCheckBoxStatus(Currencycode, testData.get("Merchant_check"));
			}

			// functions.enterText("Merchant_CurrencyCode_filed",
			// testData.get("Merchant_CurrencyCode_filed"));
			// Click on search button
			// functions.clickAnElement("Merchant_CurrencyCode_SearchButton", "Search");

			// functions.changeRadioButtonOrCheckBoxStatus("Merchant_CurrencyCode_Checkbox",
			// testData.get("Merchant_check"));
			int counter = 0;
			while (FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size() <= 0) {
				functions.globalWait(1);
				counter++;
				if (counter == 60) {
					break;
				}
			}
			counter = 0;
			while (!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()) {
				functions.globalWait(1);
				counter++;
				if (counter == 60) {
					break;
				}
			}
			// Click on Select Button
			functions.clickAnElement("Merchant_AcquirerSelect", "Select");
			functions.globalWait(10);
			// Switching to Main window
			functions.switchToParentWindow();
			functions.globalWait(5);
			// Verify Added Currency Code
			functions.verifyElementTextContains("Merchant_AddedCurrencyCode_Verify",
					testData.get("Merchant_AddedCurrencyCode_Verify"));
		}
	}

	// Add Currency
	@And("^User Adding More than 100 Currencies to Merchant Error$")
	public void user_Adding_Currencies_Merchant_Error() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Merchant_Currency_Add_Button", "AddCurrency");
			functions.globalWait(5);
			functions.switchToNewWindow();
			if (FunctionsLibrary.driver.findElements(By.id("overridelink")).size() != 0) {
				System.out.println("Clicking Certificate link");
				FunctionsLibrary.driver.findElement(By.id("overridelink")).click();
				functions.globalWait(5);
			}
			// Enter Currency Code
			functions.waitForElementUsingPresence("Merchant_CurrencyCode_filed");
			String[] Cunrrency = testData.get("Merchant_Currencies").split("@@");
			for (int i = 0; i < Cunrrency.length; i++) {
				WebElement Currencycode = FunctionsLibrary.driver.findElement(By.xpath("//td[contains(text(),'" + Cunrrency[i] + "')]/../td/input"));
				functions.waitForElementUsingPresence("Merchant_CurrencyCode_Checkbox");
				functions.changeRadioButtonOrCheckBoxStatus(Currencycode, testData.get("Merchant_check"));
			}

			// functions.enterText("Merchant_CurrencyCode_filed",
			// testData.get("Merchant_CurrencyCode_filed"));
			// Click on search button
			// functions.clickAnElement("Merchant_CurrencyCode_SearchButton", "Search");

			// functions.changeRadioButtonOrCheckBoxStatus("Merchant_CurrencyCode_Checkbox",
			// testData.get("Merchant_check"));
			int counter = 0;
			while (FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size() <= 0) {
				functions.globalWait(1);
				counter++;
				if (counter == 60) {
					break;
				}
			}
			counter = 0;
			while (!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()) {
				functions.globalWait(1);
				counter++;
				if (counter == 60) {
					break;
				}
			}
			// Click on Select Button
			functions.clickAnElement("Merchant_AcquirerSelect", "Select");
			functions.globalWait(10);
			// Switching to Main window
			functions.switchToParentWindow();
			functions.globalWait(5);
			// Verify Added Currency Code
			functions.verifyElementTextContains("Merchant_Currencies_Error",testData.get("Merchant_AddedCurrencyCode_Verify_Error"));
		}
	}

	// Fill Debit Details
	@And("^User filling Debit details to Merchant$")
	public void user_Fill_DebitDetails_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Enter FNS Number
			functions.enterText("Merchant_DebitDetails_FNSNumber", testData.get("Merchant_DebitDetails_FNSNumber"));
			// Enter PINless Gateway ID
			functions.enterText("Merchant_DebitDetails_PinLessGateway",
					testData.get("Merchant_DebitDetails_PinLessGateway"));
		}
	}

	// Fill Business Details
	@And("^User filling Business Details to Merchant$")
	public void user_Fill_BusinessDetails_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Select PSP/Aggregator Type
			functions.selectDropdownByVisibleText("Merchant_BusinessDetails_PaymentFacilatorType",
					testData.get("Merchant_BusinessDetails_PaymentFacilatorType"));
			functions.globalWait(3);
			// enter psp name
			functions.enterText("Merchant_BusinessDetails_PaymentFacilatorName",
					testData.get("Merchant_BusinessDetails_PaymentFacilatorName"));
			// Select axRetained
			functions.selectDropdownByVisibleText("Merchant_BusinessDetails_AmericanExpressRetained",
					testData.get("Merchant_BusinessDetails_AmericanExpressRetained"));
			// Enter Tax ID
			functions.enterText("Merchant_BusinessDetails_TaxId", testData.get("Merchant_BusinessDetails_TaxId"));
			// Enter Test Card Indicator
			functions.selectDropdownByVisibleText("Merchant_BusinessDetails_TestCardIndicator",
					testData.get("Merchant_BusinessDetails_TestCardIndicator"));
			// Enter MasterCard Assigned ID
			functions.enterText("Merchant_BusinessDetails_MasterCardAssignedId",
					testData.get("Merchant_BusinessDetails_MasterCardAssignedId"));
			// Enter Visa MVV
			functions.enterText("Merchant_BusinessDetails_VISAMVV", testData.get("Merchant_BusinessDetails_VISAMVV"));
			// Select Deposit Control Indicator
			functions.selectDropdownByVisibleText("Merchant_BusinessDetails_DepositControlIndicator",
					testData.get("Merchant_BusinessDetails_DepositControlIndicator"));
			// Enter IntsallmentTerm
			if(FunctionsLibrary.driver.getCurrentUrl().contains("-ap-")) {
				functions.enterText("Merchant_BusinessDetails_installmentTerm",
						testData.get("Merchant_BusinessDetails_installmentTerm"));
			}
			
		}
	}
	@And("^User filling Manditory Business Details to Merchant$")
	public void user_Fill_Manditory_BusinessDetails_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Select PSP/Aggregator Type
			functions.selectDropdownByVisibleText("Merchant_BusinessDetails_PaymentFacilatorType",
					testData.get("Merchant_BusinessDetails_PaymentFacilatorType"));
			functions.globalWait(3);
			
			functions.selectDropdownByVisibleText("Merchant_BusinessDetails_AmericanExpressRetained",
					testData.get("Merchant_BusinessDetails_AmericanExpressRetained"));
			
			// Enter Test Card Indicator
			functions.selectDropdownByVisibleText("Merchant_BusinessDetails_TestCardIndicator",
					testData.get("Merchant_BusinessDetails_TestCardIndicator"));
			
			// Select Deposit Control Indicator
			functions.selectDropdownByVisibleText("Merchant_BusinessDetails_DepositControlIndicator",
					testData.get("Merchant_BusinessDetails_DepositControlIndicator"));
			// Enter IntsallmentTerm
			if(FunctionsLibrary.driver.getCurrentUrl().contains("-ap-")) {
				functions.enterText("Merchant_BusinessDetails_installmentTerm",
						testData.get("Merchant_BusinessDetails_installmentTerm"));
			}
			
		}
	}
	
	@And("^User click Save to create Pending Merchant$")
	public void user_Save_Pending_Merchant() throws Throwable {
		// Click Save
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Merchant_Save", "Save");
			// verify sucess Message
			functions.verifyElementTextPresent("Merchant_Save_VerifyMsg", testData.get("Merchant_Save_VerifyMsg"));
		}
	}

/*	@And("^User Adding Card types to Merchant$")
	public void user_Add_CardTypes_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Add
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			functions.globalWait(10);

			String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				functions.waitForElementUsingPresence("Merchant_AddCards_CardType");
				functions.selectDropdownByVisibleText("Merchant_AddCards_CardType", CardTypes[i]);
				functions.globalWait(15);
				if (CardTypes[i].equalsIgnoreCase("Diners Club")
						|| CardTypes[i].equalsIgnoreCase("Union Pay International")
						|| CardTypes[i].equalsIgnoreCase("HRSI") || CardTypes[i].equalsIgnoreCase("EBT")
						|| CardTypes[i].equalsIgnoreCase("JCB") || CardTypes[i].equalsIgnoreCase("Debit")
						|| CardTypes[i].equalsIgnoreCase("Discover")
						|| CardTypes[i].equalsIgnoreCase("Alipay")
						|| CardTypes[i].equalsIgnoreCase("WeChat")
						||CardTypes[i].equalsIgnoreCase("Philippines Local Debit")) {
					functions.waitForElementUsingPresence("Merchant_AddCards_SENumber");
					functions.enterText("Merchant_AddCards_SENumber", testData.get("Merchant_SENumber_" + CardTypes[i]));
				}

				if (CardTypes[i].equalsIgnoreCase("American Express")) {
					functions.waitForElementUsingPresence("Merchant_AddCards_SENumber");
					functions.acceptAlertWithoutText("accept");
					functions.globalWait(5);
					// Check checkbox Private Labels
					functions.changeRadioButtonOrCheckBoxStatus("Merchant_AddCards_PrivateLabel4",
							testData.get("Merchant_check"));
					functions.enterText("Merchant_AddCards_SENumber",
							testData.get("Merchant_SENumber_" + CardTypes[i]));
				}
				if (CardTypes[i].equalsIgnoreCase("BPI Private Label")) {
					functions.waitForElementUsingPresence("Merchant_AddCards_SENumber");
					functions.acceptAlertWithoutText("accept");
					functions.globalWait(5);
					// Check checkbox Private Labels
					functions.changeRadioButtonOrCheckBoxStatus("Merchant_AddCards_PrivateLabel1",
							testData.get("Merchant_check"));
					functions.enterText("Merchant_AddCards_SENumber",
							testData.get("Merchant_SENumber_" + CardTypes[i]));
				}
				if (CardTypes[i].equalsIgnoreCase("HSBC Bonus Points")) {
					functions.acceptAlertWithoutText("accept");
					functions.globalWait(15);
					// Check checkbox Private Labels
					functions.changeRadioButtonOrCheckBoxStatus("Merchant_AddCards_PrivateLabel2",
							testData.get("Merchant_check"));
				}
				if (CardTypes[i].equalsIgnoreCase("HSBC Private Label")) {
					functions.acceptAlertWithoutText("accept");
					functions.globalWait(15);
					// Check checkbox Private Labels
					functions.changeRadioButtonOrCheckBoxStatus("Merchant_AddCards_PrivateLabel3",
							testData.get("Merchant_check"));
					//Enter SE Number
					functions.waitForElementUsingPresence("Merchant_AddCards_SENumber");
					functions.enterText("Merchant_AddCards_SENumber",
							testData.get("Merchant_SENumber_" + CardTypes[i]));
				}
				functions.globalWait(10);
				// Click Save
				functions.waitForElementUsingPresence("Merchant_Save");
				functions.clickAnElement("Merchant_Save", "AddCard_Save");
				functions.globalWait(5);
				// verify sucess Message
				functions.waitForElementUsingPresence("Merchant_AddCard_VerifyMsg");
				functions.verifyElementTextContains("Merchant_AddCard_VerifyMsg",
						testData.get("Merchant_AddCard_VerifyMsg"));
			}
		}
	}*/
	@And("^User Adding Card types to Merchant$")
	public void user_Add_CardTypes_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Add
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			functions.globalWait(10);
			String[] Cardnames = {"MasterCard","Visa","American Express","Alipay","JCB","Union Pay International","HSBC Private Label","Discover","EBT","BPI Private Label","WeChat","Debit","Diners Club"};
			int[] Cardnumbers= {663,659,666,6205,669,6086,5909,668,5952,6193,6206,690,667};
			String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				for(int j=0; j<Cardnames.length;j++) {
					if(CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
						int Cardvalue=Cardnumbers[j];
						//Select card type
						WebElement CardCheckBox=FunctionsLibrary.driver.findElement(By.xpath("//input[@value='"+Cardvalue+"']"));
						functions.changeRadioButtonOrCheckBoxStatus(CardCheckBox, "check");
						WebElement Senumber=FunctionsLibrary.driver.findElement(By.xpath("//input[@value='"+Cardvalue+"']/../../td[2]/input[@id='seNumber']"));
						
						if(CardTypes[i].equalsIgnoreCase("MasterCard") ||CardTypes[i].equalsIgnoreCase("Visa")){
							functions.enterText(Senumber, functions.getEnvironmentVariable("MerchantNumber"));
						}
						else {
							functions.enterText(Senumber, testData.get("Merchant_SENumber_" + CardTypes[i]));
						}
					}
				}
				/*functions.waitForElementUsingPresence("Merchant_AddCards_CardType");
				functions.selectDropdownByVisibleText("Merchant_AddCards_CardType", CardTypes[i]);
				functions.globalWait(15);
				if (CardTypes[i].equalsIgnoreCase("Diners Club")
						|| CardTypes[i].equalsIgnoreCase("Union Pay International")
						|| CardTypes[i].equalsIgnoreCase("HRSI") || CardTypes[i].equalsIgnoreCase("EBT")
						|| CardTypes[i].equalsIgnoreCase("JCB") || CardTypes[i].equalsIgnoreCase("Debit")
						|| CardTypes[i].equalsIgnoreCase("Discover")
						|| CardTypes[i].equalsIgnoreCase("Alipay")
						|| CardTypes[i].equalsIgnoreCase("WeChat")
						||CardTypes[i].equalsIgnoreCase("Philippines Local Debit")) {
					functions.waitForElementUsingPresence("Merchant_AddCards_SENumber");
					functions.enterText("Merchant_AddCards_SENumber", testData.get("Merchant_SENumber_" + CardTypes[i]));
				}

				if (CardTypes[i].equalsIgnoreCase("American Express")) {
					functions.waitForElementUsingPresence("Merchant_AddCards_SENumber");
					functions.acceptAlertWithoutText("accept");
					functions.globalWait(5);
					// Check checkbox Private Labels
					functions.changeRadioButtonOrCheckBoxStatus("Merchant_AddCards_PrivateLabel4",
							testData.get("Merchant_check"));
					functions.enterText("Merchant_AddCards_SENumber",
							testData.get("Merchant_SENumber_" + CardTypes[i]));
				}
				if (CardTypes[i].equalsIgnoreCase("BPI Private Label")) {
					functions.waitForElementUsingPresence("Merchant_AddCards_SENumber");
					functions.acceptAlertWithoutText("accept");
					functions.globalWait(5);
					// Check checkbox Private Labels
					functions.changeRadioButtonOrCheckBoxStatus("Merchant_AddCards_PrivateLabel1",
							testData.get("Merchant_check"));
					functions.enterText("Merchant_AddCards_SENumber",
							testData.get("Merchant_SENumber_" + CardTypes[i]));
				}
				if (CardTypes[i].equalsIgnoreCase("HSBC Bonus Points")) {
					functions.acceptAlertWithoutText("accept");
					functions.globalWait(15);
					// Check checkbox Private Labels
					functions.changeRadioButtonOrCheckBoxStatus("Merchant_AddCards_PrivateLabel2",
							testData.get("Merchant_check"));
				}
				if (CardTypes[i].equalsIgnoreCase("HSBC Private Label")) {
					functions.acceptAlertWithoutText("accept");
					functions.globalWait(15);
					// Check checkbox Private Labels
					functions.changeRadioButtonOrCheckBoxStatus("Merchant_AddCards_PrivateLabel3",
							testData.get("Merchant_check"));
					//Enter SE Number
					functions.waitForElementUsingPresence("Merchant_AddCards_SENumber");
					functions.enterText("Merchant_AddCards_SENumber",
							testData.get("Merchant_SENumber_" + CardTypes[i]));
				}*/
				
			}
			functions.globalWait(10);
			// Click Save
			functions.waitForElementUsingPresence("Merchant_Save");
			functions.clickAnElement("Merchant_Save", "AddCard_Save");
			functions.globalWait(5);
			// verify sucess Message
			functions.waitForElementUsingPresence("Merchant_AddCard_VerifyMsg");
			functions.verifyElementTextContains("Merchant_AddCard_VerifyMsg",
					testData.get("Merchant_AddCard_VerifyMsg"));
		}
	}


	@And("^User Fill Bonus point Program Details to Merchant$")
	public void user_Fill_BonusPoint_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Country Code
			functions.enterText("Merchant_BonusPointCountryCode", testData.get("Merchant_BonusPointCountryCode"));
			// Group Member Abbreviation
			functions.enterText("Merchant_BonusPointgroupMemberAbbreviation",
					testData.get("Merchant_BonusPointgroupMemberAbbreviation"));
			// Account Branch
			functions.enterText("Merchant_BonusPointaccountBranch", testData.get("Merchant_BonusPointaccountBranch"));
			// Account Serial
			functions.enterText("Merchant_BonusPointaccountSerial", testData.get("Merchant_BonusPointaccountSerial"));
			// Account Suffix
			functions.enterText("Merchant_BonusPointaccountSuffix", testData.get("Merchant_BonusPointaccountSuffix"));
		}
	}

	// Back To Merchant Page
	@And("^User click Back to Merchant link$")
	public void user_click_BackTo_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Merchant_BacktoMerchant", "Back to Merchant");
			functions.globalWait(10);
		}
	}

	@And("^User Add Acquirer to Merchant$")
	public void user_Add_Acquirer_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Add Button
			functions.clickAnElement("Merchant_AddAcquirer", "AddAcquirer");
			functions.globalWait(10);
			// Switch to new Window
			functions.switchToNewWindow();
			if (functions.driver.findElements(By.id("overridelink")).size() != 0) {
				System.out.println("Clicking Certificate link");
				functions.driver.findElement(By.id("overridelink")).click();
			}
			functions.globalWait(5);

			// Enter Acquirer Account
			functions.waitForElementUsingPresence("Merchant_AcquirerName");
			functions.enterText("Merchant_AcquirerName", testData.get("Merchant_AcquirerName"));
			// Click on search button
			functions.clickAnElement("Merchant_CurrencyCode_SearchButton", "Search_Button");
			functions.waitForElementUsingPresence("Merchant_AcquirerAccountListStatus");
			// Change Radion Button Status Accquirer Acount List
			functions.changeRadioButtonOrCheckBoxStatus("Merchant_AcquirerAccountListStatus",
					testData.get("Merchant_check"));
			int counter = 0;
			while (FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size() <= 0) {
				functions.globalWait(1);
				counter++;
				if (counter == 60) {
					break;
				}
			}
			counter = 0;
			while (!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()) {
				functions.globalWait(1);
				counter++;
				if (counter == 60) {
					break;
				}
			}
			functions.clickAnElement("Merchant_AcquirerSelect", "Select_Acquirer");
			functions.globalWait(10);

			functions.switchToParentWindow();

			functions.globalWait(10);
			// Verify Element Present
			functions.verifyElementPresent("Merchant_MerchantId");
			functions.verifyElementPresent("Merchant_Added_AcquireAccount");
			// functions.verifyColumnValues("Merchant_Acquirer_ColumnValues");
		}
	}
	@And("^User navigates to Adding Card types to Merchant$")
	public void user_navigates_Add_CardTypes_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Add
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			
		}
	}
	
	
	@And("^User Add Acquirer Dynamically to Merchant$")
	public void user_Add_AcquirerDynamically_Merchant(String EnvAcquirer) throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Add Button
			functions.clickAnElement("Merchant_AddAcquirer", "AddAcquirer");
			functions.globalWait(10);
			// Switch to new Window
			functions.switchToNewWindow();
			if (functions.driver.findElements(By.id("overridelink")).size() != 0) {
				System.out.println("Clicking Certificate link");
				functions.driver.findElement(By.id("overridelink")).click();
			}
			functions.globalWait(5);

			// Enter Acquirer Account
			functions.waitForElementUsingPresence("Merchant_AcquirerName");
			functions.enterText("Merchant_AcquirerName", EnvAcquirer);
			// Click on search button
			functions.clickAnElement("Merchant_CurrencyCode_SearchButton", "Search_Button");
			functions.waitForElementUsingPresence("Merchant_AcquirerAccountListStatus");
			// Change Radion Button Status Accquirer Acount List
			functions.changeRadioButtonOrCheckBoxStatus("Merchant_AcquirerAccountListStatus",
					testData.get("Merchant_check"));
			int counter = 0;
			while (FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size() <= 0) {
				functions.globalWait(1);
				counter++;
				if (counter == 60) {
					break;
				}
			}
			counter = 0;
			while (!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()) {
				functions.globalWait(1);
				counter++;
				if (counter == 60) {
					break;
				}
			}
			functions.clickAnElement("Merchant_AcquirerSelect", "Select_Acquirer");
			functions.globalWait(10);

			functions.switchToParentWindow();

			functions.globalWait(10);
			// Verify Element Present
			functions.verifyElementPresent("Merchant_MerchantId");
			functions.verifyElementPresent("Merchant_Added_AcquireAccount");
			// functions.verifyColumnValues("Merchant_Acquirer_ColumnValues");
		}
	}

	@And("^User Validate Merchant$")
	public void user_Validate_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Button Validate
			functions.waitForElementUsingPresence("Merchant_Validate_Button");
			functions.clickAnElement("Merchant_Validate_Button", "Validate");
			// Verify Validate Message
			functions.waitForElementUsingPresence("Merchant_Validate_Msg");
			functions.verifyElementTextPresent("Merchant_Validate_Msg", testData.get("Merchant_Validate_Msg"));
		}
	}

	@Then("^User Change Merchant Status$")
	public void user_Change_Merchant_Status() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Button Edit
			functions.waitForElementUsingPresence("Merchant_EditButton");
			functions.clickAnElement("Merchant_EditButton", "Edit");
			functions.waitForElementUsingPresence("Merchant_Save");
			// Change Status
			functions.selectDropdownByVisibleText("MerchAndTerm_Status", testData.get("MerchAndTerm_Status"));
			// Click on Save Button
			functions.clickAnElement("Merchant_Save", "Save");
			//functions.globalWait(10);
			// Verify Confirm Message
			functions.waitForElementUsingPresence("Merchant_Updated_Msg");
			functions.verifyElementTextContains("Merchant_Updated_Msg", testData.get("Merchant_Updated_Msg"));
		}
	}
	@And("^User Adding Chain to Merchant$")
	public void user_Add_Chain_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			//click on add chain Button
			functions.clickAnElement("Merchant_Chain_Add", "Merchant_Chain_Add");
			functions.globalWait(5);
			functions.enterText("Merchnat_Chain_Name", testData.get("Merchnat_Chain_Name"));
			functions.clickAnElement("Merchant_Chain_Id", "Merchant_Chain_Id");
			functions.clickAnElement("Merchant_Chain_Assign", "Merchant_Chain_Assign");
			functions.waitForElementUsingPresence("Merchant_ChainAssignSuccess");
			functions.verifyElementPresent("Merchant_ChainAssignSuccess");
		}
	}
	@And("^User Change Discover Retained value$")
	public void user_Change_DiscoverRetained() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			//click on add chain Button
			functions.selectDropdownByVisibleText("Merchant_discoverRetained", testData.get("Merchant_discoverRetained"));
		}
	}
	
	@And("^User Adding Chain1 to Merchant Dynamically$")
	public void user_Add_Chain_MerchantDynamic1() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			//click on add chain Button
			functions.clickAnElement("Merchant_Chain_Add", "Merchant_Chain_Add");
			functions.globalWait(5);
			functions.clickAnElement("Chain_SearchIcon", "Chain_SearchIcon");
			functions.globalWait(5);
			functions.switchToNewWindow();
			functions.enterText("Merchnat_Chain_Name", functions.getEnvironmentVariable("ChainName1"));
			functions.clickAnElement("Chain_ChainNameGO", "Chain_ChainNameGO");
			functions.changeRadioButtonOrCheckBoxStatus("Merchant_Chain_result", "select");
			functions.clickAnElement("Customer_Select", "Chain_select");
			//functions.enterText("Merchnat_Chain_Name", "AutoChain4209");
			functions.switchToParentWindow();
			functions.globalWait(5);
			functions.clickAnElement("Merchant_Chain_Assign", "Merchant_Chain_Assign");
			//WebElement ChainAssign=FunctionsLibrary.driver.findElement(By.xpath("//span[contains(text(),'Successfully Assigned the Chain to the Merchant.')]"));
			/*if(ChainAssign.isDisplayed()==false) {
				functions.clickAnElement("Merchant_Chain_Assign", "Merchant_Chain_Assign");
			}*/
			/*while(FunctionsLibrary.driver.findElement(By.xpath("//span[contains(text(),'Successfully Assigned the Chain to the Merchant.')]")).isDisplayed()) {
				
				functions.clickAnElement("Merchant_Chain_Assign", "Merchant_Chain_Assign");
			}*/
			functions.waitForElementUsingPresence("Merchant_ChainAssignSuccess");
			functions.verifyElementPresent("Merchant_ChainAssignSuccess");
		}
	}
	@And("^User Adding Chain2 to Merchant Dynamically$")
	public void user_Add_Chain_MerchantDynamic2() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			//click on add chain Button
			functions.clickAnElement("Merchant_Chain_Add", "Merchant_Chain_Add");
			functions.globalWait(5);
			functions.enterText("Merchnat_Chain_Name", functions.getEnvironmentVariable("ChainName2"));
			functions.clickAnElement("Merchant_Chain_Id", "Merchant_Chain_Id");
			functions.globalWait(5);
			WebElement ChainAssign=FunctionsLibrary.driver.findElement(By.xpath("//span[contains(text(),'Successfully Assigned the Chain to the Merchant.')]"));
			while(ChainAssign.isDisplayed()) {
				
				functions.clickAnElement("Merchant_Chain_Assign", "Merchant_Chain_Assign");
			}
			functions.waitForElementUsingPresence("Merchant_ChainAssignSuccess");
			functions.verifyElementPresent("Merchant_ChainAssignSuccess");
		}
	}
	@And("^User Adding Issuer to Merchant$")
	public void user_Add_Isuer_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// click on ADD Issuer button
			functions.clickAnElement("Merchant_Add_Issuer_Button", "Add Issuer button");
			functions.globalWait(5);
			functions.selectDropdownByVisibleText("Merchant_Issuer_Dropdown", testData.get("Merchant_IssuerName"));
			functions.waitForElementUsingPresence("Merchant_MasMid");
			functions.changeRadioButtonOrCheckBoxStatus("Merchant_Issuer_Sip1", testData.get("Merchant_check"));
			functions.selectDropdownByVisibleText("Merchant_Issuer_SipPlan", testData.get("Merchant_Issuer_SIPPlan"));
			// Enter MASMIDS
			Random ran = new Random(System.currentTimeMillis());
			int x = (int) (Math.random() * 99) + Math.abs(ran.nextInt());
			String MasMid = "91";
			MasMid = MasMid.concat(Integer.toString(x));
			functions.setEnvironmentVariable("MASMID", MasMid);
			functions.enterText("Merchant_MasMid", MasMid);
			functions.clickAndEnterAnElement("Merchant_Issuer_Submit", "Submit");
			functions.verifyElementTextContains("Merchant_Issuer_SucessMsg", testData.get("Merchant_Issuer_SucessMsg"));

		}
	}

	@And("^User Adding Multiple Issuer to Merchant$")
	public void user_Add_Multuiple_Isuer_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Merchant_Add_Issuer_Button", "Add Issuer button");
			functions.globalWait(5);
			String[] Issuernames = testData.get("Merchant_IssuerName").split("@@");
			for (int i = 0; i < Issuernames.length; i++) {
				// click on ADD Issuer button
				functions.selectDropdownByVisibleText("Merchant_Issuer_Dropdown", Issuernames[i]);
				functions.waitForElementUsingPresence("Merchant_MasMid");
				functions.changeRadioButtonOrCheckBoxStatus("Merchant_Issuer_Sip1", testData.get("Merchant_check"));

				functions.selectDropdownByIndex("Merchant_Issuer_SipPlan", 1);
				// functions.selectDropdownByVisibleText("Merchant_Issuer_SipPlan",
				// testData.get("Merchant_Issuer_SIPPlan"));
				// Enter MASMIDS
				Random ran = new Random(System.currentTimeMillis());
				int x = (int) (Math.random() * 99) + Math.abs(ran.nextInt());
				String MasMid = "91";
				MasMid = MasMid.concat(Integer.toString(x));
				functions.setEnvironmentVariable("MASMID", MasMid);
				functions.enterText("Merchant_MasMid", MasMid);
				functions.clickAndEnterAnElement("Merchant_Issuer_Submit", "Submit");
				functions.verifyElementTextContains("Merchant_Issuer_SucessMsg",
						testData.get("Merchant_Issuer_SucessMsg"));
			}
		}
	}

	@And("^User searching for Existing Merchant Using MASMID$")
	public void user_Search_for_Merchant_MASMID() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			// Enter Merchant Number to search
			functions.enterText("Merchant_MasMidIdSearch", functions.getEnvironmentVariable("MASMID"));
			functions.selectDropdownByVisibleText("Merchant_Search_Like", testData.get("Merchant_Search_Like"));
			// Click on Search Button
			functions.clickAnElement("Merchant_Existing_Search", "Search");
			functions.verifyElementTextContains("Merchant_MerchantId",
					functions.getEnvironmentVariable("MerchantNumber"));
		}
	}

	@And("^User searching for Existing Merchant Using INVALID MASMID$")
	public void user_Search_for_Merchant_Invalid_MASMID() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			// Enter Merchant Number to search
			functions.enterText("Merchant_MasMidIdSearch", testData.get("Merchant_Invalid_MasMid"));
			// Click on Search Button
			functions.clickAnElement("Merchant_Existing_Search", "Search");
			functions.verifyElementPresent("NoResultFound");
		}
	}

	@Then("^User Validating Merchant CMF Database Region \"([^\"]*)\"$")
	public void CMF_DB_Validations(String Region) throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			ReusableFunctions rf = new ReusableFunctions();
			String regionvalue = rf.CMFDatabase(Region);
			String MerchantNum = functions.getEnvironmentVariable("MerchantNumber");
			String query = testData.get("Merchant_CMF_Query1") + MerchantNum + "'";
			functions.globalWait(65);
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("Merchant_CMF_DBExpected"));
		}
	}

	@Then("^User Validating Merchant G2 Database Region \"([^\"]*)\"$")
	public void G2DB_Validations(String Region) throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			ReusableFunctions rf = new ReusableFunctions();
			String regionvalue = rf.G2Database(Region);
			String MerchantNum = functions.getEnvironmentVariable("MerchantNumber");
			String query = testData.get("Merchant_G2_Query1") + MerchantNum + "' order by CARD_TYPE";
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("Merchant_G2_DBExpected"));
		}
	}

	@Then("^User Validating Merchant CMF Database Multiple values \"([^\"]*)\"$")
	public void CMF_DB_Multiple_Validations(String Region) throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			ReusableFunctions rf = new ReusableFunctions();
			String regionvalue = rf.CMFDatabase(Region);
			String MerchantNum = functions.getEnvironmentVariable("MerchantNumber");
			String[] CMFDBExpected = testData.get("Merchant_CMF_DBExpected").split("@@");
			functions.globalWait(65);
			for (int i = 1; i <= CMFDBExpected.length; i++) {
				String query = testData.get("Merchant_CMF_Query" + i) + MerchantNum + "'";

				functions.verifyDatabaseRowValuesDynamically(regionvalue, query, CMFDBExpected[i]);
			}
		}
	}

	@Then("^User Validating Merchant G2 Database Multiple values \"([^\"]*)\"$")
	public void G2DB_Multiple_Validations(String Region) throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			ReusableFunctions rf = new ReusableFunctions();
			String regionvalue = rf.G2Database(Region);
			String MerchantNum = functions.getEnvironmentVariable("MerchantNumber");
			String[] G2DBExpected = testData.get("Merchant_G2_DBExpected").split("@@");
			functions.globalWait(65);
			for (int i = 1; i <= G2DBExpected.length; i++) {
				String query = testData.get("Merchant_G2_Query" + i) + MerchantNum + "'";

				functions.verifyDatabaseRowValuesDynamically(regionvalue, query, G2DBExpected[i]);
			}
		}
	}

	

	
	@And("^User Creates unique Merchant ID1$")
	public void user_create_MerchantID1() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			Random ran = new Random(System.currentTimeMillis());
			int x = (int) (Math.random() * 99) + Math.abs(ran.nextInt());
			String strMerchantNum1 = "91";
			strMerchantNum1 = strMerchantNum1.concat(Integer.toString(x));
			functions.setEnvironmentVariable("MerchantNumber1", strMerchantNum1);
			functions.enterText("Merchant_MerchantId", strMerchantNum1);
			functions.globalWait(5);
		}
	}
	@Then("^User Validating Merchant CMF CPR Database Region \"([^\"]*)\"$")
	public void CMF_DB_ValidationsCPR(String Region) throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			ReusableFunctions rf = new ReusableFunctions();
			String regionvalue = rf.CMFDatabase(Region);
			String MerchantNum = functions.getEnvironmentVariable("MerchantNumber");
			String query = testData.get("Merchant_CMF_QueryCPR") + MerchantNum + "'";
			functions.globalWait(65);
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, functions.getEnvironmentVariable("CustomerNumber2"));
		}
	}
	@Then("^User Validating Merchant CPR G2 Database Region \"([^\"]*)\"$")
	public void G2DB_ValidationsCPR(String Region) throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			ReusableFunctions rf = new ReusableFunctions();
			String regionvalue = rf.G2Database(Region);
			String MerchantNum = functions.getEnvironmentVariable("MerchantNumber");
			String query = testData.get("Merchant_G2_QueryCPR") + MerchantNum + "' and rownum=1";
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, functions.getEnvironmentVariable("CustomerNumber2"));
		}
	}
	@And("^User create Open Merchant with Parent Cust1$")
	public void User_Create_Open_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			user_Navigates_to_AddMerchantPage();
			
			user_Enter_ParentCustomer1_Dynamically();
			
			user_create_MerchantID();
			
			user_Fill_OverviewDetails_Merchant();
			
			user_Fill_BusinessDetails_Merchant();
			
			user_Fill_AddressDetails_Merchant();

			user_Save_Pending_Merchant();
			
			user_Add_CardTypes_Merchant();
			
			user_click_BackTo_Merchant();
			
			user_Validate_Merchant();
			
			user_Change_Merchant_Status();
			
		}
	}
	@And("^User Enters parent customer1 Dynamically$")
	public void user_Enter_ParentCustomer1_Dynamically() throws Throwable {
		// Verify Alert text and click OK
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.acceptAlertWithoutText("accept");
			functions.globalWait(5);
			// Enter Parent customer
			functions.enterText("Merchant_ParentCustomerNumber", functions.getEnvironmentVariable("CustomerNumber1"));
			//functions.enterText("Merchant_ParentCustomerNumber", "911732924876");
			
			FunctionsLibrary.driver.findElement(By.id("customerName")).click();
			functions.waitForElementUsingPresence("Merchant_Save");
			//String ParentCustNumber = testData.get("Merchant_ParentCustomerNumber");
			functions.globalWait(12);
			// functions.setEnvironmentVariable(EnvVariable, ParentCustNumber);
		}
	}
	@And("^User searching for Existing Merchant Dynamically$")
	public void user_Search_Dynamically_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			// Enter Merchant Number to search
			functions.enterText("Merchant_MerchantIdSearch", functions.getEnvironmentVariable("MerchantNumber"));
			// Click on Search Button
			functions.clickAnElement("Merchant_Existing_Search", "Search");
			
		}
	}
	@Then("^User Change parent customer for CPR Validation$")
	public void user_Change_ParentCustomer() throws Throwable {
		// Click Button Edit
		functions.waitForElementUsingPresence("Merchant_EditButton");
		functions.clickAnElement("Merchant_EditButton", "Edit");
		functions.clickAnElement("Merchant_ParentCustChange", "Merchant_ParentCustChange");
		functions.globalWait(10);
		// Window handle
		functions.switchToNewWindow();

		functions.enterText("Merchant_ParentCustomerNumber", functions.getEnvironmentVariable("CustomerNumber2"));

		functions.clickAnElement("Merchant_ParentCustChangeSearch", "ParentCustSearch");

		functions.changeRadioButtonOrCheckBoxStatus("Merchant_ParentCustomer_Radio", testData.get("RadioButton"));
		int counter = 0;
		while (FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size() <= 0) {
			functions.globalWait(1);
			counter++;
			if (counter == 60) {
				break;
			}
		}
		counter = 0;
		while (!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()) {
			functions.globalWait(1);
			counter++;
			if (counter == 60) {
				break;
			}
		}
		functions.clickAnElement("Merchant_ParentCustomer_Select", "Select");
		functions.globalWait(5);
		functions.switchToParentWindow();
		functions.waitForElementUsingPresence("Merchant_Save");
		functions.clickAnElement("Merchant_Save", "Merchant_Save");
		functions.waitForElementUsingPresence("Merchant_Updated_Msg");
		functions.verifyElementTextContains("Merchant_Updated_Msg", testData.get("Merchant_Updated_Msg"));
	}
	@Then("^User Change Parent Cust and getting Error CPR validations$")
	public void user_Change_ParentCustomerError() throws Throwable {
		// Click Button Edit
		functions.waitForElementUsingPresence("Merchant_EditButton");
		functions.clickAnElement("Merchant_EditButton", "Edit");
		functions.clickAnElement("Merchant_ParentCustChange", "Merchant_ParentCustChange");
		functions.globalWait(10);
		// Window handle
		functions.switchToNewWindow();

		functions.enterText("Merchant_ParentCustomerNumber", functions.getEnvironmentVariable("CustomerNumber2"));

		functions.clickAnElement("Merchant_ParentCustChangeSearch", "ParentCustSearch");

		functions.changeRadioButtonOrCheckBoxStatus("Merchant_ParentCustomer_Radio", testData.get("RadioButton"));
		int counter = 0;
		while (FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size() <= 0) {
			functions.globalWait(1);
			counter++;
			if (counter == 60) {
				break;
			}
		}
		counter = 0;
		while (!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()) {
			functions.globalWait(1);
			counter++;
			if (counter == 60) {
				break;
			}
		}
		functions.clickAnElement("Merchant_ParentCustomer_Select", "Select");
		functions.globalWait(5);
		functions.switchToParentWindow();
		functions.waitForElementUsingPresence("Merchant_Save");
		functions.clickAnElement("Merchant_Save", "Merchant_Save");
		functions.waitForElementUsingPresence("Customer_CardType_Error");
		functions.verifyElementPresentWithReport("Customer_CardType_Error");
		//functions.verifyElementTextContains("Customer_CardType_Error", testData.get("Merchant_Updated_Msg"));
	}
	@Then("^User verify Privatelabels not present in UI$")
	public void user_verify_PrivateLabels() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			for(int i=1; i<=9; i++)
			{
				
				functions.verifyElementNotPresent("Private Label"+i, "Merchant_AddCards_PrivateLabel"+i);
           			
			}
     
	}
	}
	@Then("^User verify Cards Disable or enable after Edit$")
	public void user_verify_cards_afterEdit() throws InterruptedException {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
		functions.verifyElementPresent("Merchant_cardsAccepted");
					
     
	}
	}

@And("^User Adding Card types to Merchant for Canada$")
public void user_Add_CardTypes_Merchant_for_canada() throws Throwable {
	if (CommonStepDefinitions.executeScenario()) {
		if (!CommonStepDefinitions.exescenario)
			return;
		// Click Add
		functions.waitForElementUsingPresence("Merchant_AddCards");
		functions.clickAnElement("Merchant_AddCards", "AddCard");
		functions.globalWait(10);
		String[] Cardnames = {"MasterCard","Visa","American Express","Alipay","JCB","Union Pay International","HSBC Private Label","Discover","EBT","BPI Private Label","WeChat","Debit"};
		int[] Cardnumbers= {663,659,666,6205,669,6086,5909,668,5952,6193,6206,690};
		String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
		for (int i = 0; i < CardTypes.length; i++) {
			for(int j=0; j<Cardnames.length;j++) {
				if(CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
					int Cardvalue=Cardnumbers[j];
					//Select card type
					WebElement CardCheckBox=FunctionsLibrary.driver.findElement(By.xpath("//input[@value='"+Cardvalue+"']"));
					functions.changeRadioButtonOrCheckBoxStatus(CardCheckBox, "check");
					WebElement Senumber=FunctionsLibrary.driver.findElement(By.xpath("//input[@value='"+Cardvalue+"']/../../td[2]/input[@id='seNumber']"));
					
					
						functions.enterText(Senumber, testData.get("Merchant_SENumber_" + CardTypes[i]));
					}
				
			}
			
		}
		functions.globalWait(10);
		// Click Save
		functions.waitForElementUsingPresence("Merchant_Save");
		functions.clickAnElement("Merchant_Save", "AddCard_Save");
		functions.globalWait(5);
		// verify sucess Message
		functions.waitForElementUsingPresence("Merchant_AddCard_VerifyMsg");
		functions.verifyElementTextContains("Merchant_AddCard_VerifyMsg",
				testData.get("Merchant_AddCard_VerifyMsg"));
	}
	}
}
/*
 * // Verify values in DB for Merchant public void
 * verifyDBValuesMerchantUS(String strDataFileName, String strReportFilename){
 * String strMerchantNumber =
 * Utilities.getEnvironmentVariable("DBMerchantNumber1"); //String
 * strMerchantNumber = Utilities.getEnvironmentVariable("SrchdMerchantNo1");
 * String strQuery = null;
 * 
 * // Verify Address, City, State or Province ,Zip/Postal Code strQuery =
 * "SELECT ADDRESS1, ADDRESS2, CITY, STATE_NAME, POSTAL_CODE FROM merchant_address_view WHERE GLOBAL_MERCHANT_NUMBER='"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues1", reporter, strReportFilename);
 * 
 * // Verify Customer Service Phone #,Primary Contact Name ,Contact e-mail
 * Address , Merchant Phone Number strQuery
 * ="SELECT mc.secondary_phone , mc.contact_name , mc.email , mc.primary_phone FROM merchant_contact_view mc, merchant m WHERE mc.party_id = m.party_id AND m.global_merchant_number =  '"
 * + strMerchantNumber +
 * "' AND m.merchant_dba_name = 'Automation Test DBA name1' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues2", reporter, strReportFilename);
 * 
 * // Verify Acquirer Accounts
 * strQuery="SELECT aa.name FROM cmf.merchant_acquirer_accnt maa, cmf.acquirer_account aa, merchant m WHERE maa.acquirer_account_id = aa.acquirer_account_id AND maa.party_id = m.party_id AND m.global_merchant_number = '"
 * + strMerchantNumber +
 * "' AND m.merchant_dba_name = 'Automation Test DBA name1' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues3", reporter, strReportFilename);
 * 
 * // Verify Cards Accepted strQuery =
 * "SELECT card_type_desc FROM merchant_cardtype_view WHERE merchant_number = '"
 * + strMerchantNumber +
 * "'AND merchant_name = 'Automation Test DBA name1' order by card_type_desc";
 * verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues4", reporter, strReportFilename);
 * 
 * // Verify FNS Number, PINless Gateway ID strQuery =
 * "SELECT FNS_NUMBER, PINLESS_GATEWAY_ID from merchant_db_setup_view WHERE MERCHANT_ID = (SELECT MERCHANT_ID FROM merchant_view WHERE GLOBAL_MERCHANT_NUMBER ='"
 * + strMerchantNumber + "') and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues5", reporter, strReportFilename);
 * 
 * // Verify BIN BLOCKING strQuery =
 * "SELECT ddbt.business_term bin_blocking_ind FROM merchant_view mv, data_dict_bus_terms ddbt WHERE mv.bin_blocking_ind = ddbt.business_term_id AND mv.global_merchant_number = '"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues6", reporter, strReportFilename);
 * 
 * // Verify EDI indicato,Discover Retained,PSP/Aggregator Type,PSP/Aggregator
 * Name ,AX Retained ,Account Inquiry Participation strQuery =
 * "SELECT IS_EDI, IS_DISCOVER_RETAINED, AGGREGATOR_SELLER_FLAG, AGGREGATOR_NAME, AX_RETAINED, ACCT_INQUIRY_PARTICIPATION FROM merchant_view WHERE GLOBAL_MERCHANT_NUMBER = '"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues7", reporter, strReportFilename);
 * 
 * }
 * 
 * // Verify values in DB for Merchant public void
 * verifyDBValuesMerchantUS(String strDataFileName, String
 * strReportFilename,String strMerchantNumber){
 * 
 * stepExecutor.globalWait(60); //String strMerchantNumber =
 * Utilities.getEnvironmentVariable("DBMerchantNumber1"); //String
 * strMerchantNumber = Utilities.getEnvironmentVariable("SrchdMerchantNo1");
 * System.out.println("***************************CMF"+strMerchantNumber);
 * String strQuery = null;
 * 
 * // Verify Address, City, State or Province ,Zip/Postal Code strQuery =
 * "SELECT ADDRESS1, ADDRESS2, CITY, STATE_NAME, POSTAL_CODE FROM merchant_address_view WHERE GLOBAL_MERCHANT_NUMBER='"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues1", reporter, strReportFilename);
 * 
 * // Verify Customer Service Phone #,Primary Contact Name ,Contact e-mail
 * Address , Merchant Phone Number strQuery
 * ="SELECT mc.secondary_phone , mc.contact_name , mc.email , mc.primary_phone FROM merchant_contact_view mc, merchant m WHERE mc.party_id = m.party_id AND m.global_merchant_number =  '"
 * + strMerchantNumber +
 * "' AND m.merchant_dba_name = 'Automation Test DBA name1' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues2", reporter, strReportFilename);
 * 
 * // Verify Acquirer Accounts
 * strQuery="SELECT aa.name FROM cmf.merchant_acquirer_accnt maa, cmf.acquirer_account aa, merchant m WHERE maa.acquirer_account_id = aa.acquirer_account_id AND maa.party_id = m.party_id AND m.global_merchant_number = '"
 * + strMerchantNumber +
 * "' AND m.merchant_dba_name = 'Automation Test DBA name1' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues3", reporter, strReportFilename);
 * 
 * // Verify Cards Accepted strQuery =
 * "SELECT card_type_desc FROM merchant_cardtype_view WHERE merchant_number = '"
 * + strMerchantNumber +
 * "'AND merchant_name = 'Automation Test DBA name1' order by card_type_desc";
 * verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues4", reporter, strReportFilename);
 * 
 * // Verify FNS Number, PINless Gateway ID strQuery =
 * "SELECT FNS_NUMBER, PINLESS_GATEWAY_ID from merchant_db_setup_view WHERE MERCHANT_ID = (SELECT MERCHANT_ID FROM merchant_view WHERE GLOBAL_MERCHANT_NUMBER ='"
 * + strMerchantNumber + "') and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues5", reporter, strReportFilename);
 * 
 * // Verify BIN BLOCKING strQuery =
 * "SELECT ddbt.business_term bin_blocking_ind FROM merchant_view mv, data_dict_bus_terms ddbt WHERE mv.bin_blocking_ind = ddbt.business_term_id AND mv.global_merchant_number = '"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues6", reporter, strReportFilename);
 * 
 * // Verify EDI indicato,Discover Retained,PSP/Aggregator Type,PSP/Aggregator
 * Name ,AX Retained ,Account Inquiry Participation strQuery =
 * "SELECT IS_EDI, IS_DISCOVER_RETAINED, AGGREGATOR_SELLER_FLAG, AGGREGATOR_NAME, AX_RETAINED, ACCT_INQUIRY_PARTICIPATION FROM merchant_view WHERE GLOBAL_MERCHANT_NUMBER = '"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues7", reporter, strReportFilename); }
 * 
 * public void verifyG2DBValuesMerchantUS(String strDataFileName, String
 * strReportFilename){ stepExecutor.globalWait(60); String strMerchantNumber =
 * Utilities.getEnvironmentVariable("DBMerchantNumber1");
 * System.out.println("***************************G2"+strMerchantNumber);
 * 
 * //String strMerchantNumber =
 * Utilities.getEnvironmentVariable("SrchdMerchantNo1"); String strQuery = null;
 * 
 * int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);
 * String strParentCustomerNumber = scriptExecutor.readDataFile(strDataFileName,
 * rowNumber, "ParentCustomer"); //String strParentCustomerNumber =
 * Utilities.getEnvironmentVariable("DBCustomerNumber1");
 * System.out.println("+++++++ strParentCustomerNumber: ---"+
 * strParentCustomerNumber);
 * 
 * // Verify Line of Business ,Debit system reversal,Customer Specific Logic Ind
 * strQuery="select ebm.LOB_IND,ebm.CUST_SPEC_LOGIC, ebm.DEBIT_SYSTEM_REV from EB_MERCHANT ebm where cust_nbr='"
 * + strParentCustomerNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DB_LOB_CustLogicInd_Values", reporter, strReportFilename);
 * 
 * // Verify Customer Service Phone #,Primary Contact Name ,Contact e-mail
 * Address , Merchant Phone Number strQuery
 * ="select CUST_SERVICE_PHONE , NAME, EMAIL_ADDR from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_ContactDtls", reporter, strReportFilename);
 * 
 * // Verify PINless Gateway ID
 * strQuery="select PINLESS_GATEWAY_ID from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "'";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_PinlessID", reporter, strReportFilename);
 * 
 * // Verify BIN BLOCKING
 * strQuery="select BIN_BLOCKING_IND from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "'";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_BINID", reporter, strReportFilename);
 * 
 * // Verify EDI indicator, Discover Retained,PSP/Aggregator Type,PSP/Aggregator
 * Name ,AX Retained ,Account Inquiry Participation ,Test Card Indicator
 * strQuery="select  EDI_IND, DISCOVER_RETAINED,AGGREGATOR_NAME,AX_RETAINED,ACCT_INQUIRY_FLAG,TEST_CARD_IND from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_BussinsDtls", reporter, strReportFilename);
 * 
 * // Verify Cards accepted
 * strQuery="select mse.CARD_TYPE from EB_MERCH_SE_XREF mse, EB_MERCHANT m where m.merchant=mse.merchant and m.GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' order by mse.CARD_TYPE";
 * verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Cards", reporter, strReportFilename);
 * 
 * // Verify Se number values
 * strQuery="select mse.SE_MERCH_ID from EB_MERCH_SE_XREF mse, EB_MERCHANT m where m.merchant=mse.merchant and m.GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' "; // Code updated by Prasad to verify SE number
 * with dynamic merchant number rowNumber =
 * executionRowNumber.getExecutionRowNumber(strDataFileName); String
 * strDBInfoValues = scriptExecutor.readDataFile(strDataFileName, rowNumber,
 * "DBValues_SeNumber");
 * 
 * String strExpectedValues = strMerchantNumber + "@@" + strDBInfoValues;
 * Utilities.setEnvironmentVariable("SE_NUMBERS", strExpectedValues);
 * //verificationFunctions.verifyDatabaseRowValuesEnv("DBDetails", strQuery,
 * strDataFileName, "SE_NUMBERS", reporter, strReportFilename);
 * //verificationFunctions.verifyDynamicDBValues("DBDetails", "SE_NUMBER",
 * strQuery, false, strDataFileName, "", reporter, strReportFilename); }
 * 
 * public void verifyG2DBValuesMerchantUS(String strDataFileName, String
 * strReportFilename,String strMerchantNumber,String strParentCustomerNumber){
 * //String strMerchantNumber =
 * Utilities.getEnvironmentVariable("DBMerchantNumber1");
 * stepExecutor.globalWait(60); //String strMerchantNumber =
 * Utilities.getEnvironmentVariable("SrchdMerchantNo1"); String strQuery = null;
 * int rowNumber; //int rowNumber =
 * executionRowNumber.getExecutionRowNumber(strDataFileName); //String
 * strParentCustomerNumber = scriptExecutor.readDataFile(strDataFileName,
 * rowNumber, "ParentCustomer"); // Verify Line of Business ,Debit system
 * reversal,Customer Specific Logic Ind
 * strQuery="select ebm.LOB_IND,ebm.CUST_SPEC_LOGIC, ebm.DEBIT_SYSTEM_REV from EB_MERCHANT ebm where cust_nbr='"
 * + strParentCustomerNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DB_LOB_CustLogicInd_Values", reporter, strReportFilename);
 * 
 * // Verify Customer Service Phone #,Primary Contact Name ,Contact e-mail
 * Address , Merchant Phone Number strQuery
 * ="select CUST_SERVICE_PHONE , NAME, EMAIL_ADDR from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_ContactDtls", reporter, strReportFilename);
 * 
 * // Verify PINless Gateway ID
 * strQuery="select PINLESS_GATEWAY_ID from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "'";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_PinlessID", reporter, strReportFilename);
 * 
 * // Verify BIN BLOCKING
 * strQuery="select BIN_BLOCKING_IND from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "'";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_BINID", reporter, strReportFilename);
 * 
 * // Verify EDI indicator, Discover Retained,PSP/Aggregator Type,PSP/Aggregator
 * Name ,AX Retained ,Account Inquiry Participation ,Test Card Indicator
 * strQuery="select  EDI_IND, DISCOVER_RETAINED,AGGREGATOR_NAME,AX_RETAINED,ACCT_INQUIRY_FLAG,TEST_CARD_IND from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_BussinsDtls", reporter, strReportFilename);
 * 
 * // Verify Cards accepted
 * strQuery="select mse.CARD_TYPE from EB_MERCH_SE_XREF mse, EB_MERCHANT m where m.merchant=mse.merchant and m.GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' order by mse.CARD_TYPE";
 * verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Cards", reporter, strReportFilename);
 * 
 * // Verify Se number values
 * strQuery="select mse.SE_MERCH_ID from EB_MERCH_SE_XREF mse, EB_MERCHANT m where m.merchant=mse.merchant and m.GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' "; // Code updated by Prasad to verify SE number
 * with dynamic merchant number rowNumber =
 * executionRowNumber.getExecutionRowNumber(strDataFileName); String
 * strDBInfoValues = scriptExecutor.readDataFile(strDataFileName, rowNumber,
 * "DBValues_SeNumber");
 * 
 * String strExpectedValues = strMerchantNumber + "@@" + strDBInfoValues;
 * Utilities.setEnvironmentVariable("SE_NUMBERS", strExpectedValues);
 * //verificationFunctions.verifyDatabaseRowValuesEnv("DBDetails", strQuery,
 * strDataFileName, "SE_NUMBERS", reporter, strReportFilename);
 * //verificationFunctions.verifyDynamicDBValues("DBDetails", "SE_NUMBER",
 * strQuery, false, strDataFileName, "", reporter, strReportFilename); } public
 * void verifyDBValuesMerchantAP(String strDataFileName, String
 * strReportFilename){ String strMerchantNumber =
 * Utilities.getEnvironmentVariable("DBMerchantNumber2"); //String
 * strMerchantNumber = Utilities.getEnvironmentVariable("APSrchdMerchantNo");
 * String strQuery = null;
 * 
 * // Verify Address, City,Zip/Postal Code strQuery =
 * "SELECT ADDRESS1, ADDRESS2, CITY, POSTAL_CODE FROM merchant_address_view WHERE GLOBAL_MERCHANT_NUMBER='"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues1", reporter, strReportFilename);
 * 
 * // Verify Customer Service Phone #,Primary Contact Name ,Contact e-mail
 * Address , Merchant Phone Number strQuery
 * ="SELECT mc.secondary_phone , mc.contact_name , mc.email , mc.primary_phone FROM merchant_contact_view mc, merchant m WHERE mc.party_id = m.party_id AND m.global_merchant_number =  '"
 * + strMerchantNumber +
 * "' AND m.merchant_dba_name = 'Automation Test DBA name1' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues2", reporter, strReportFilename);
 * 
 * // Verify Cards Accepted strQuery =
 * "SELECT card_type_desc FROM merchant_cardtype_view WHERE merchant_number = '"
 * + strMerchantNumber +
 * "'AND merchant_name = 'Automation Test DBA name1' order by card_type_desc ";
 * verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues4", reporter, strReportFilename);
 * 
 * // Verify FNS Number, PINless Gateway ID strQuery =
 * "SELECT FNS_NUMBER, PINLESS_GATEWAY_ID from merchant_db_setup_view WHERE MERCHANT_ID = (SELECT MERCHANT_ID FROM merchant_view WHERE GLOBAL_MERCHANT_NUMBER ='"
 * + strMerchantNumber + "') and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues5", reporter, strReportFilename);
 * 
 * // Verify BIN BLOCKING strQuery =
 * "SELECT ddbt.business_term bin_blocking_ind FROM merchant_view mv, data_dict_bus_terms ddbt WHERE mv.bin_blocking_ind = ddbt.business_term_id AND mv.global_merchant_number = '"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues6", reporter, strReportFilename);
 * 
 * // Verify EDI indicato,Discover Retained,PSP/Aggregator Type,PSP/Aggregator
 * Name ,AX Retained ,Account Inquiry Participation strQuery =
 * "SELECT IS_EDI, IS_DISCOVER_RETAINED, AGGREGATOR_SELLER_FLAG, AX_RETAINED, ACCT_INQUIRY_PARTICIPATION FROM merchant_view WHERE GLOBAL_MERCHANT_NUMBER = '"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues7", reporter, strReportFilename);
 * 
 * // Verify Acquirer Accounts
 * strQuery="SELECT aa.name FROM cmf.merchant_acquirer_accnt maa, cmf.acquirer_account aa, merchant m WHERE maa.acquirer_account_id = aa.acquirer_account_id AND maa.party_id = m.party_id AND m.global_merchant_number = '"
 * + strMerchantNumber +
 * "' AND m.merchant_dba_name = 'Automation Test DBA name1' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues3", reporter, strReportFilename);
 * 
 * }
 * 
 * public void verifyDBValuesMerchantAP(String strDataFileName, String
 * strReportFilename,String strMerchantNumber){ //String strMerchantNumber =
 * Utilities.getEnvironmentVariable("DBMerchantNumber2"); //String
 * strMerchantNumber = Utilities.getEnvironmentVariable("APSrchdMerchantNo");
 * String strQuery = null; stepExecutor.globalWait(60); // Verify Address,
 * City,Zip/Postal Code strQuery =
 * "SELECT ADDRESS1, ADDRESS2, CITY, POSTAL_CODE FROM merchant_address_view WHERE GLOBAL_MERCHANT_NUMBER='"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues1", reporter, strReportFilename);
 * 
 * // Verify Customer Service Phone #,Primary Contact Name ,Contact e-mail
 * Address , Merchant Phone Number strQuery
 * ="SELECT mc.secondary_phone , mc.contact_name , mc.email , mc.primary_phone FROM merchant_contact_view mc, merchant m WHERE mc.party_id = m.party_id AND m.global_merchant_number =  '"
 * + strMerchantNumber +
 * "' AND m.merchant_dba_name = 'Automation Test DBA name1' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues2", reporter, strReportFilename);
 * 
 * // Verify Cards Accepted strQuery =
 * "SELECT card_type_desc FROM merchant_cardtype_view WHERE merchant_number = '"
 * + strMerchantNumber +
 * "'AND merchant_name = 'Automation Test DBA name1' order by card_type_desc ";
 * verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues4", reporter, strReportFilename);
 * 
 * // Verify FNS Number, PINless Gateway ID strQuery =
 * "SELECT FNS_NUMBER, PINLESS_GATEWAY_ID from merchant_db_setup_view WHERE MERCHANT_ID = (SELECT MERCHANT_ID FROM merchant_view WHERE GLOBAL_MERCHANT_NUMBER ='"
 * + strMerchantNumber + "') and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues5", reporter, strReportFilename);
 * 
 * // Verify BIN BLOCKING strQuery =
 * "SELECT ddbt.business_term bin_blocking_ind FROM merchant_view mv, data_dict_bus_terms ddbt WHERE mv.bin_blocking_ind = ddbt.business_term_id AND mv.global_merchant_number = '"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues6", reporter, strReportFilename);
 * 
 * // Verify EDI indicato,Discover Retained,PSP/Aggregator Type,PSP/Aggregator
 * Name ,AX Retained ,Account Inquiry Participation strQuery =
 * "SELECT IS_EDI, IS_DISCOVER_RETAINED, AGGREGATOR_SELLER_FLAG, AX_RETAINED, ACCT_INQUIRY_PARTICIPATION FROM merchant_view WHERE GLOBAL_MERCHANT_NUMBER = '"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues7", reporter, strReportFilename);
 * 
 * // Verify Acquirer Accounts
 * strQuery="SELECT aa.name FROM cmf.merchant_acquirer_accnt maa, cmf.acquirer_account aa, merchant m WHERE maa.acquirer_account_id = aa.acquirer_account_id AND maa.party_id = m.party_id AND m.global_merchant_number = '"
 * + strMerchantNumber +
 * "' AND m.merchant_dba_name = 'Automation Test DBA name1' and rownum=1 ";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues3", reporter, strReportFilename);
 * 
 * }
 * 
 * public void verifyG2DBValuesMerchantAP(String strDataFileName, String
 * strReportFilename){ String strMerchantNumber =
 * Utilities.getEnvironmentVariable("DBMerchantNumber2"); //String
 * strMerchantNumber = Utilities.getEnvironmentVariable("APSrchdMerchantNo");
 * String strQuery = null;
 * 
 * int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);
 * String strParentCustomerNumber = scriptExecutor.readDataFile(strDataFileName,
 * rowNumber, "ParentCustomer");
 * 
 * // Verify Line of Business ,Debit system reversal,Customer Specific Logic Ind
 * strQuery="select ebm.LOB_IND,ebm.CUST_SPEC_LOGIC, ebm.DEBIT_SYSTEM_REV from EB_MERCHANT ebm , edc.edc_customer edc where edc.cust_nbr = edc.cust_nbr and edc.cust_nbr='"
 * + strParentCustomerNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DB_LOB_CustLogicInd_Values", reporter, strReportFilename);
 * 
 * // Verify Customer Service Phone #,Primary Contact Name ,Contact e-mail
 * Address , Merchant Phone Number strQuery
 * ="select CUST_SERVICE_PHONE , NAME, EMAIL_ADDR from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_ContactDtls", reporter, strReportFilename);
 * 
 * // Verify PINless Gateway ID
 * strQuery="select PINLESS_GATEWAY_ID from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "'";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_PinlessID", reporter, strReportFilename);
 * 
 * // Verify BIN BLOCKING
 * strQuery="select BIN_BLOCKING_IND from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "'";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_BINID", reporter, strReportFilename);
 * 
 * // Verify EDI indicator, Discover Retained,PSP/Aggregator Type,PSP/Aggregator
 * Name ,AX Retained ,Account Inquiry Participation ,Test Card Indicator
 * strQuery="select  EDI_IND, DISCOVER_RETAINED,AGGREGATOR_NAME,AX_RETAINED,ACCT_INQUIRY_FLAG,TEST_CARD_IND from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_BussinsDtls", reporter, strReportFilename);
 * 
 * // Verify Cards accepted
 * strQuery="select mse.CARD_TYPE from EB_MERCH_SE_XREF mse, EB_MERCHANT m where m.merchant=mse.merchant and m.GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' order by mse.CARD_TYPE";
 * verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Cards", reporter, strReportFilename);
 * 
 * // Verify Se number values
 * strQuery="select mse.SE_MERCH_ID from EB_MERCH_SE_XREF mse, EB_MERCHANT m where m.merchant=mse.merchant and m.GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' ";
 * //verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_SeNumber", reporter, strReportFilename); // Code
 * updated by Prasad to verify SE number with dynamic merchant number rowNumber
 * = executionRowNumber.getExecutionRowNumber(strDataFileName); String
 * strDBInfoValues = scriptExecutor.readDataFile(strDataFileName, rowNumber,
 * "DBValues_SeNumber");
 * 
 * String strExpectedValues = strMerchantNumber + "@@" + strMerchantNumber +
 * "@@" + strDBInfoValues; Utilities.setEnvironmentVariable("SE_NUMBERS",
 * strExpectedValues);
 * verificationFunctions.verifyDatabaseRowValuesEnv("DBDetails", strQuery,
 * strDataFileName, "SE_NUMBERS", reporter, strReportFilename); }
 * 
 * public void verifyG2DBValuesMerchantAP(String strDataFileName, String
 * strReportFilename,String strMerchantNumber,String strParentCustomerNumber){
 * stepExecutor.globalWait(60);
 * 
 * //String strMerchantNumber =
 * Utilities.getEnvironmentVariable("DBMerchantNumber2"); //String
 * strMerchantNumber = Utilities.getEnvironmentVariable("APSrchdMerchantNo");
 * String strQuery = null;
 * 
 * //int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);
 * //String strParentCustomerNumber =
 * scriptExecutor.readDataFile(strDataFileName, rowNumber, "ParentCustomer");
 * 
 * // Verify Line of Business ,Debit system reversal,Customer Specific Logic Ind
 * strQuery="select ebm.LOB_IND,ebm.CUST_SPEC_LOGIC, ebm.DEBIT_SYSTEM_REV from EB_MERCHANT ebm , edc.edc_customer edc where edc.cust_nbr = edc.cust_nbr and edc.cust_nbr='"
 * + strParentCustomerNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DB_LOB_CustLogicInd_Values", reporter, strReportFilename);
 * 
 * // Verify Customer Service Phone #,Primary Contact Name ,Contact e-mail
 * Address , Merchant Phone Number strQuery
 * ="select CUST_SERVICE_PHONE , NAME, EMAIL_ADDR from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' and rownum=1";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_ContactDtls", reporter, strReportFilename);
 * 
 * // Verify PINless Gateway ID //
 * strQuery="select PINLESS_GATEWAY_ID from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "'";
 * //verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_PinlessID", reporter, strReportFilename);
 * 
 * // Verify BIN BLOCKING
 * strQuery="select BIN_BLOCKING_IND from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "'";
 * verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_BINID", reporter, strReportFilename);
 * 
 * // Verify EDI indicator, Discover Retained,PSP/Aggregator Type,PSP/Aggregator
 * Name ,AX Retained ,Account Inquiry Participation ,Test Card Indicator //
 * strQuery="select  EDI_IND, DISCOVER_RETAINED,AGGREGATOR_NAME,AX_RETAINED,ACCT_INQUIRY_FLAG,TEST_CARD_IND from EB_MERCHANT where GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' and rownum=1";
 * //verificationFunctions.verifyDatabaseValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_BussinsDtls", reporter, strReportFilename);
 * 
 * // Verify Cards accepted
 * strQuery="select mse.CARD_TYPE from EB_MERCH_SE_XREF mse, EB_MERCHANT m where m.merchant=mse.merchant and m.GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' order by mse.CARD_TYPE";
 * verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_Cards", reporter, strReportFilename);
 * 
 * // Verify Se number values
 * strQuery="select mse.SE_MERCH_ID from EB_MERCH_SE_XREF mse, EB_MERCHANT m where m.merchant=mse.merchant and m.GLOBAL_MERCHANT_ID ='"
 * + strMerchantNumber + "' ";
 * //verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery,
 * strDataFileName, "DBValues_SeNumber", reporter, strReportFilename); // Code
 * updated by Prasad to verify SE number with dynamic merchant number
 * 
 * rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName); String
 * strDBInfoValues = scriptExecutor.readDataFile(strDataFileName, rowNumber,
 * "DBValues_SeNumber");
 * 
 * String strExpectedValues = strMerchantNumber + "@@" + strMerchantNumber +
 * "@@" + strDBInfoValues; Utilities.setEnvironmentVariable("SE_NUMBERS",
 * strExpectedValues);
 * verificationFunctions.verifyDatabaseRowValuesEnv("DBDetails", strQuery,
 * strDataFileName, "SE_NUMBERS", reporter, strReportFilename);
 * 
 * //code updated by vipin Utilities.setEnvironmentVariable("senumber1",
 * strMerchantNumber); Utilities.setEnvironmentVariable("senumber2",
 * strMerchantNumber );
 * Utilities.setEnvironmentVariable("senumber3","70000999222551");
 * Utilities.setEnvironmentVariable("senumber4","0000000000000000");
 * Utilities.setEnvironmentVariable("senumber5","601101199000173");
 * //verificationFunctions.verifyDynamicDBValues("DBDetails",
 * "senumber1@@senumber2@@senumber3@@senumber4@@senumber5",strQuery, false,
 * strDataFileName, "DBVALUES", reporter,strReportFilename);
 * verificationFunctions.verifyDynamicDBValues1("DBDetails",
 * "senumber1@@senumber3@@senumber4@@senumber5",strQuery, false,
 * strDataFileName, "DBVALUES", reporter,strReportFilename); }
 * 
 * 
 * 
 * public void updateMerchant(String strDataFileName,RemoteWebDriver webDriver,
 * String strRegion, GridReporter reporter,String strReportFilename){
 * 
 * if(strRegion.equalsIgnoreCase("US")){ //Update Cards
 * UpdateMerchantCardsUS(strDataFileName, webDriver, reporter,
 * strReportFilename); } else{ //Update Cards
 * UpdateMerchantCardsAP(strDataFileName, webDriver, reporter,
 * strReportFilename); }
 * 
 * 
 * //Update Acquirer Account changeMerchantAcquirer(strDataFileName, webDriver,
 * reporter, strReportFilename);
 * 
 * //Click Button Edit
 * stepExecutor.waitForElementToDisplay("findElementByXPath",
 * "(//input[@value='Edit'])[1]", webDriver, reporter, strReportFilename);
 * stepExecutor.clickButton("findElementByXPath", "(//input[@value='Edit'])[1]",
 * "EDIT", webDriver, reporter, strReportFilename);
 * stepExecutor.waitForElementToDisplay("findElementByXPath",
 * "//input[@value='Save']", webDriver, reporter, strReportFilename);
 * 
 * if(strRegion.equalsIgnoreCase("US")){ //Update Address
 * updateAddressDetails(strDataFileName, webDriver, reporter,
 * strReportFilename); } else{ //Update Address
 * updateAddressDetailsAP(strDataFileName, webDriver, reporter,
 * strReportFilename); }
 * 
 * //Update DebitDetails //updateDebitDetails(strDataFileName, webDriver,
 * reporter, strReportFilename);
 * 
 * //Update BinBlocking //updateBinBlocking(strDataFileName, webDriver,
 * reporter, strReportFilename);
 * 
 * if(strRegion.equalsIgnoreCase("US")){ //Update Business Details
 * updateBusinessDetails(strDataFileName, webDriver, reporter,
 * strReportFilename); } else{ //Update Business Details
 * updateBusinessDetailsAP(strDataFileName, webDriver, reporter,
 * strReportFilename); }
 * 
 * 
 * // Click on Save Button
 * stepExecutor.waitForElementToDisplay("findElementByXPath",
 * "//input[@value='Save']", webDriver, reporter, strReportFilename);
 * stepExecutor.clickButton("findElementByXPath", "//input[@value='Save']",
 * "Save", webDriver, reporter, strReportFilename); stepExecutor.globalWait(10);
 * 
 * // Verify Confirm Message
 * stepExecutor.waitForElementToDisplay("findElementByXPath",
 * "//span[contains(text(),'Merchant successfully updated.')]", webDriver,
 * reporter, strReportFilename);
 * verificationFunctions.verifyElementTextPresent(webDriver,
 * "//span[contains(text(),'Merchant successfully updated.')]", "xpath",
 * strDataFileName, "Verfy_Confirmation_Message", reporter, strReportFilename);
 * }
 * 
 * public void updateAddressDetails(String strDataFileName,RemoteWebDriver
 * webDriver, GridReporter reporter, String strReportFilename){
 * 
 * // Fill Address Section // Enter Address1
 * stepExecutor.clearTextField("findElementByXPath",
 * "//input[@id='dbaAddress1'][1]", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByXPath",
 * "//input[@id='dbaAddress1'][1]", strDataFileName, "Address1", webDriver,
 * reporter, strReportFilename);
 * 
 * // Enter Address2 stepExecutor.clearTextField("findElementByXPath",
 * "//input[@id='dbaAddress2'][1]", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByXPath",
 * "//input[@id='dbaAddress2'][1]", strDataFileName, "Address2", webDriver,
 * reporter, strReportFilename);
 * 
 * // Enter City stepExecutor.clearTextField("findElementByName", "dbaCity",
 * webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByName", "dbaCity", strDataFileName,
 * "City", webDriver, reporter, strReportFilename);
 * 
 * // Select State/Province stepExecutor.selectListValue("findElementById",
 * "dbaStateCodeId", strDataFileName, "State or Province", webDriver, reporter,
 * strReportFilename);
 * 
 * //Enter Zip code stepExecutor.clearTextField("findElementByName",
 * "dbaPostalCode", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByName", "dbaPostalCode",
 * strDataFileName, "Zip/Postal Code", webDriver, reporter, strReportFilename);
 * 
 * // Enter Primary Contact Name
 * stepExecutor.clearTextField("findElementByXPath",
 * "//input[@id='primaryContactName']", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByXPath",
 * "//input[@id='primaryContactName']", strDataFileName, "Primary Contact Name",
 * webDriver, reporter, strReportFilename);
 * 
 * // Enter Contact e-mail Address
 * stepExecutor.clearTextField("findElementByName", "primaryContactEmail",
 * webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByName", "primaryContactEmail",
 * strDataFileName, "Contact e-mail Address", webDriver, reporter,
 * strReportFilename);
 * 
 * // Enter Contact Phone stepExecutor.clearTextField("findElementByName",
 * "primaryContactPrimaryPhone", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByName",
 * "primaryContactPrimaryPhone", strDataFileName, "Contact Phone", webDriver,
 * reporter, strReportFilename);
 * 
 * 
 * //Enter Customer Service Phone
 * stepExecutor.clearTextField("findElementByName",
 * "primaryContactSecondaryPhone", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByName",
 * "primaryContactSecondaryPhone", strDataFileName, "CustomerServicePhone",
 * webDriver, reporter, strReportFilename); }
 * 
 * public void updateAddressDetailsAP(String strDataFileName,RemoteWebDriver
 * webDriver, GridReporter reporter, String strReportFilename){
 * 
 * // Fill Address Section // Enter Address1
 * stepExecutor.clearTextField("findElementByXPath",
 * "//input[@id='dbaAddress1'][1]", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByXPath",
 * "//input[@id='dbaAddress1'][1]", strDataFileName, "Address1", webDriver,
 * reporter, strReportFilename);
 * 
 * // Enter Address2 stepExecutor.clearTextField("findElementByXPath",
 * "//input[@id='dbaAddress2'][1]", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByXPath",
 * "//input[@id='dbaAddress2'][1]", strDataFileName, "Address2", webDriver,
 * reporter, strReportFilename);
 * 
 * // Enter City stepExecutor.clearTextField("findElementByName", "dbaCity",
 * webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByName", "dbaCity", strDataFileName,
 * "City", webDriver, reporter, strReportFilename);
 * 
 * //Enter Zip code stepExecutor.clearTextField("findElementByName",
 * "dbaPostalCode", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByName", "dbaPostalCode",
 * strDataFileName, "Zip/Postal Code", webDriver, reporter, strReportFilename);
 * 
 * // Enter Primary Contact Name
 * stepExecutor.clearTextField("findElementByXPath",
 * "//input[@id='primaryContactName']", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByXPath",
 * "//input[@id='primaryContactName']", strDataFileName, "Primary Contact Name",
 * webDriver, reporter, strReportFilename);
 * 
 * // Enter Contact e-mail Address
 * stepExecutor.clearTextField("findElementByName", "primaryContactEmail",
 * webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByName", "primaryContactEmail",
 * strDataFileName, "Contact e-mail Address", webDriver, reporter,
 * strReportFilename);
 * 
 * // Enter Contact Phone stepExecutor.clearTextField("findElementByName",
 * "primaryContactPrimaryPhone", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByName",
 * "primaryContactPrimaryPhone", strDataFileName, "Contact Phone", webDriver,
 * reporter, strReportFilename);
 * 
 * 
 * //Enter Customer Service Phone
 * stepExecutor.clearTextField("findElementByName",
 * "primaryContactSecondaryPhone", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementByName",
 * "primaryContactSecondaryPhone", strDataFileName, "CustomerServicePhone",
 * webDriver, reporter, strReportFilename); }
 * 
 * public void UpdateMerchantCardsUS(String strDataFileName,RemoteWebDriver
 * webDriver, GridReporter reporter, String strReportFilename){
 * 
 * 
 * //Change checkbox Status Cards Accepted
 * //stepExecutor.changeCheckboxStatus("findElementByXPath",
 * "(//input[@id='cardsAcceptedCheck'])[1]", strDataFileName,
 * "Chekcbox_CardsAccepted", webDriver, reporter, strReportFilename); // Delete
 * JCB Card from Cards accepted list String strCardType = ""; for(int i=2;
 * i<=10;i++){ /*if(webDriver.findElementsByXPath(
 * "//table[@id='cardsAccepted']/tbody/tr/td/table/tbody/tr[" + i +
 * "]/td[2]").size()>0){ strCardType = webDriver.findElementByXPath(
 * "//table[@id='cardsAccepted']/tbody/tr/td/table/tbody/tr[" + i +
 * "]/td[2]").getText(); if(strCardType.contains("EBT")){
 * stepExecutor.changeCheckboxStatus("findElementByXPath",
 * "//table[@id='cardsAccepted']/tbody/tr/td/table/tbody/tr[" + i +
 * "]/td[1]/input", strDataFileName, "Chekcbox_CardsAccepted", webDriver,
 * reporter, strReportFilename); break; } }
 * //*[@id='cardsAcceptedBody']/tr[6]/td[2]/a
 * if(webDriver.findElementsByXPath("//*[@id='cardsAcceptedBody']/tr["+i+
 * "]/td[2]/a").size()>0) { strCardType =
 * webDriver.findElementByXPath("//*[@id='cardsAcceptedBody']/tr["+i+"]/td[2]/a"
 * ).getText(); if(strCardType.contains("Discover")) {
 * stepExecutor.changeCheckboxStatus("findElementByXPath",
 * "//tbody[@id='cardsAcceptedBody']/tr["+i+"]/td/input", strDataFileName,
 * "Chekcbox_CardsAccepted", webDriver, reporter, strReportFilename); break; } }
 * }
 * 
 * //Click on Delete Button //stepExecutor.clickButton("findElementByXPath",
 * "(//input[@value='Delete'])[3]", "Delete", webDriver, reporter,
 * strReportFilename);
 * webDriver.findElementByXPath("(//input[@value='Delete'])").click();
 * 
 * 
 * stepExecutor.globalWait(10);
 * verificationFunctions.verifyAlertText(strDataFileName, "CardsDelete_Alert",
 * "accept", webDriver, reporter, strReportFilename);
 * stepExecutor.globalWait(15); }
 * 
 * public void UpdateMerchantCardsAP(String strDataFileName,RemoteWebDriver
 * webDriver, GridReporter reporter, String strReportFilename){
 * 
 * //Change checkbox Status Cards Accepted
 * //stepExecutor.changeCheckboxStatus("findElementByXPath",
 * "(//input[@id='cardsAcceptedCheck'])[1]", strDataFileName,
 * "Chekcbox_CardsAccepted", webDriver, reporter, strReportFilename); // Delete
 * JCB Card from Cards accepted list String strCardType = ""; for(int i=2;
 * i<=10;i++) { if(webDriver.findElementsByXPath(
 * "//table[@id='cardsAccepted']/tbody/tr/td/table/tbody/tr[" + i +
 * "]/td[2]").size()>0) { strCardType = webDriver.findElementByXPath(
 * "//table[@id='cardsAccepted']/tbody/tr/td/table/tbody/tr[" + i +
 * "]/td[2]").getText(); if(strCardType.contains("Visa")) {
 * stepExecutor.changeCheckboxStatus("findElementByXPath",
 * "//table[@id='cardsAccepted']/tbody/tr/td/table/tbody/tr[" + i +
 * "]/td[1]/input", strDataFileName, "Chekcbox_CardsAccepted", webDriver,
 * reporter, strReportFilename); break; } }
 * //*[@id='cardsAcceptedBody']/tr[6]/td[2]/a
 * if(webDriver.findElementsByXPath("//*[@id='cardsAcceptedBody']/tr["+i+
 * "]/td[2]/a").size()>0) { strCardType =
 * webDriver.findElementByXPath("//*[@id='cardsAcceptedBody']/tr["+i+"]/td[2]/a"
 * ).getText(); if(strCardType.contains("Visa")) {
 * stepExecutor.changeCheckboxStatus("findElementByXPath",
 * "//tbody[@id='cardsAcceptedBody']/tr["+i+"]/td/input", strDataFileName,
 * "Chekcbox_CardsAccepted", webDriver, reporter, strReportFilename); break; } }
 * }
 * 
 * //Click on Delete Button //stepExecutor.clickButton("findElementByXPath",
 * "//*[@id='cardsAcceptedBody']/tr[8]/td[2]/input", "Delete", webDriver,
 * reporter, strReportFilename); //webDriver.findElementByXPath(
 * "//*[@id='cardsAcceptedBody']/tr[8]/td[2]/input").click();
 * webDriver.findElementByXPath("(//input[@value='Delete'])").click();
 * 
 * stepExecutor.globalWait(5);
 * verificationFunctions.verifyAlertText(strDataFileName, "CardsDelete_Alert",
 * "accept", webDriver, reporter, strReportFilename);
 * stepExecutor.globalWait(15); } public void updateDebitDetails(String
 * strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String
 * strReportFilename){ //Fill Debit Details
 * 
 * //Enter FNS Number stepExecutor.clearTextField("findElementById",
 * "fnsNumber", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementById", "fnsNumber", strDataFileName,
 * "FNS Number", webDriver, reporter, strReportFilename);
 * 
 * //Enter PINless Gateway ID stepExecutor.clearTextField("findElementById",
 * "pinlessGatewayId", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementById", "pinlessGatewayId",
 * strDataFileName, "GatewayID", webDriver, reporter, strReportFilename); }
 * 
 * public void updateBinBlocking(String strDataFileName,RemoteWebDriver
 * webDriver, GridReporter reporter, String strReportFilename){
 * 
 * //Select BIN Blocking stepExecutor.selectListValue("findElementById",
 * "binBlocking", strDataFileName, "Listbox_binBlocking", webDriver, reporter,
 * strReportFilename);
 * 
 * }
 * 
 * public void updateBusinessDetails(String strDataFileName,RemoteWebDriver
 * webDriver, GridReporter reporter, String strReportFilename){
 * 
 * //Fill Business Details
 * 
 * //Select EDI Indicator(EDI indicator listbox removed from applications)
 * //stepExecutor.selectListValue("findElementById", "EDI", strDataFileName,
 * "Listbox_EDI", webDriver, reporter, strReportFilename);
 * 
 * //Select Discover Retained stepExecutor.selectListValue("findElementById",
 * "discoverRetained", strDataFileName, "Listbox_discoverRetained", webDriver,
 * reporter, strReportFilename);
 * 
 * //Select PSP/Aggregator Type stepExecutor.selectListValue("findElementById",
 * "amexAggregatorIndicator", strDataFileName,
 * "Listbox_amexAggregatorIndicator", webDriver, reporter, strReportFilename);
 * 
 * //Enter PSP/Aggregator Name stepExecutor.clearTextField("findElementById",
 * "amexAggregatorName", webDriver, reporter, strReportFilename);
 * stepExecutor.enterTextValue("findElementById", "amexAggregatorName",
 * strDataFileName, "amexAggregatorName", webDriver, reporter,
 * strReportFilename);
 * 
 * //Select axRetained stepExecutor.selectListValue("findElementById",
 * "axRetained", strDataFileName, "Listbox_axRetained", webDriver, reporter,
 * strReportFilename);
 * 
 * //Check Account Inquiry Participation //Discover
 * //stepExecutor.changeCheckboxStatus("findElementByXPath",
 * "//table[@id='businessdetails']/tbody/tr[7]/td[2]/span[4]/input",
 * strDataFileName, "Checkbox_Discover", webDriver, reporter,
 * strReportFilename); }
 * 
 * public void updateBusinessDetailsAP(String strDataFileName,RemoteWebDriver
 * webDriver, GridReporter reporter, String strReportFilename){
 * 
 * //Fill Business Details
 * 
 * //Select EDI Indicator(EDI indicator listbox removed from applications)
 * //stepExecutor.selectListValue("findElementById", "EDI", strDataFileName,
 * "Listbox_EDI", webDriver, reporter, strReportFilename);
 * 
 * //Select Discover Retained stepExecutor.selectListValue("findElementById",
 * "discoverRetained", strDataFileName, "Listbox_discoverRetained", webDriver,
 * reporter, strReportFilename);
 * 
 * //Select PSP/Aggregator Type stepExecutor.selectListValue("findElementById",
 * "amexAggregatorIndicator", strDataFileName,
 * "Listbox_amexAggregatorIndicator", webDriver, reporter, strReportFilename);
 * 
 * //Select axRetained stepExecutor.selectListValue("findElementById",
 * "axRetained", strDataFileName, "Listbox_axRetained", webDriver, reporter,
 * strReportFilename);
 * 
 * //Check Account Inquiry Participation //Discover
 * //stepExecutor.changeCheckboxStatus("findElementByXPath",
 * "//table[@id='businessdetails']/tbody/tr[7]/td[2]/span[4]/input",
 * strDataFileName, "Checkbox_Discover", webDriver, reporter,
 * strReportFilename); }
 * 
 * public void changeMerchantAcquirer(String strDataFileName,RemoteWebDriver
 * webDriver, GridReporter reporter, String strReportFilename){
 * 
 * //Change checkbox Status Acquirer Account
 * stepExecutor.changeCheckboxStatus("findElementByXPath",
 * "(//input[@id='merchAcqAcctId'])[1]", strDataFileName, "Chekcbox_Acquirer",
 * webDriver, reporter, strReportFilename); String winhandleBefore =
 * webDriver.getWindowHandle(); //Click on Change Button
 * stepExecutor.clickButton("findElementByXPath",
 * "(//input[@value='Change'])[1]", "Change", webDriver, reporter,
 * strReportFilename); stepExecutor.globalWait(30);
 * 
 * //Utilities.setEnvironmentVariable("MainWindow", winhandleBefore); // Window
 * handle Set <String> winHandles = webDriver.getWindowHandles();
 * Iterator<String> it = winHandles.iterator(); String strcurrentWinHandle =
 * null; if(it.hasNext()){ strcurrentWinHandle = it.next();
 * if(strcurrentWinHandle.equals(winhandleBefore)){ strcurrentWinHandle =
 * it.next(); webDriver.switchTo().window(strcurrentWinHandle); }else{
 * webDriver.switchTo().window(strcurrentWinHandle); } }
 * if(webDriver.findElementsById("overridelink").size()!=0) {
 * System.out.println("Clicking Certificate link");
 * webDriver.findElementById("overridelink").click();
 * stepExecutor.globalWait(5); }
 * 
 * // Enter Accquirer Account
 * stepExecutor.waitForElementToDisplay("findElementById", "name", webDriver,
 * reporter, strReportFilename); stepExecutor.enterTextValue("findElementById",
 * "name", strDataFileName, "Acquirer_Name", webDriver, reporter,
 * strReportFilename); // Click on search button
 * stepExecutor.clickButton("findElementByXPath",
 * "//input[@name='searchBtn'][1]", "Search Accquirer", webDriver, reporter,
 * strReportFilename);
 * stepExecutor.waitForElementToDisplay("findElementByXPath",
 * "//input[@id='acqAcct']", webDriver, reporter, strReportFilename); // Change
 * Radion Button Status Accquirer Acount List
 * stepExecutor.changeRadioButtonStatus("findElementByXPath",
 * "//input[@id='acqAcct']", "Accquirer Acount List", strDataFileName,
 * "Accquirer_Acount_List", webDriver, reporter, strReportFilename); int counter
 * = 0;
 * while(webDriver.findElementsByXPath("(//input[@value='Select'])[1]").size()<=
 * 0){ stepExecutor.globalWait(1); counter++; if(counter==60){ break; } }
 * counter = 0;
 * while(!webDriver.findElementByXPath("(//input[@value='Select'])[1]").
 * isDisplayed()){ stepExecutor.globalWait(1); counter++; if(counter==60){
 * break; } } // Click on Select Button
 * stepExecutor.clickButton("findElementByXPath",
 * "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter,
 * strReportFilename); stepExecutor.globalWait(10); try{ //String strWinHandle =
 * Utilities.getEnvironmentVariable("MainWindow");
 * 
 * webDriver.switchTo().window(winhandleBefore); }catch(Exception ee1){
 * System.out.println(" Accquirer Dest Failed----" + ee1.getMessage()); }
 * 
 * stepExecutor.globalWait(10); // Verify Element Present
 * verificationFunctions.verifyElementPresent(webDriver,
 * "//input[@id='merchantNumber']", "XPath", "Merchant Number", reporter,
 * strReportFilename); // Verify Added Accquirer Account
 * verificationFunctions.verifyElementPresent(webDriver,
 * "//input[@id='merchAcqAcctId']", "XPath", "Added Accquirer Account",
 * reporter, strReportFilename);
 * verificationFunctions.verifyColumnValues(webDriver, strDataFileName,
 * "Verify_AccqAccount", reporter, strReportFilename);
 * 
 * //Verify Sucess Message
 * stepExecutor.waitForElementToDisplay("findElementByXPath",
 * "//span[contains(text(),'Successfully Changed the Acquirer Account.')]",
 * webDriver, reporter, strReportFilename);
 * verificationFunctions.verifyElementTextPresent(webDriver,
 * "//span[contains(text(),'Successfully Changed the Acquirer Account.')]",
 * "xpath", strDataFileName, "Verfy_AcqChange_Message", reporter,
 * strReportFilename);
 * 
 * }
 */
