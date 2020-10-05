package  com.webapp.stepDefinition;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.swing.text.Utilities;

import org.apache.commons.jxpath.FunctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.base.Functions;
import com.webapp.baseLibrary.FunctionsLibrary;
import com.webapp.executioner.ExecutionerClass;
import com.webapp.page.ReusableFunctions;
import com.webapp.utilities.GridReporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.extensions.TestDecorator;

public class CMF_Customer_Creation extends ExecutionerClass {

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


	@When("^User navigates to Add Customer Page$")
	public void user_Navigates_to_AddCustomerPage() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		//Click on Customer tab
		functions.clickAnElement("Customer_Tab", "Customer_Tab");
		//Click on add Customer
		functions.clickAnElement("Customer_AddCustomer", "Customer_AddCustomer");
	}
		}
	
	@When("^User navigates to Customer Page$")
	public void user_Navigates_to_Cust_Page(String CustTab) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		//Click on Customer tab
		functions.clickAnElement("Customer_Tab", "Customer_Tab");
	}}
	@And("^User enter Customer Mandatory details$")
	public void user_Enters_MandatoryDetails() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		// Enter Line Of Business
		functions.selectDropdown("Customer_LineOfBusiness","VisibleText", testData.get("Customer_LineOfBusiness"));
		// Select Customer Type
		functions.selectDropdown("Customer_CustomerType","VisibleText", testData.get("Customer_CustomerType"));
		// Select Customer Type
		//functions.selectDropdown("Customer_Processor","VisibleText", testData.get("Customer_Processor"));
		// Select StandIn Processing
		functions.selectDropdownByVisibleText("Customer_StandInProcessing", testData.get("Customer_StandInProcessing"));
		// Enter Credit Velocity
		functions.enterText("Customer_CreditVelocity", testData.get("Customer_CreditVelocity"));
		// Enter Purchase Velocity
		functions.enterText("Customer_PurchaseVelocity", testData.get("Customer_PurchaseVelocity"));
		// Enter ship To ID
		functions.enterText("Customer_ShipToID", testData.get("Customer_ShipToID"));
		// Select StandIn Processing
		functions.selectDropdownByVisibleText("Customer_BinBlocking", testData.get("Customer_BinBlocking"));
		// Select Reference number Sequence
		functions.selectDropdown("Customer_ReferenceNumberSequence","VisibleText", testData.get("Customer_ReferenceNumberSequence"));
		// Select Reference number level
		functions.selectDropdown("Customer_ReferenceNumberLevel","VisibleText", testData.get("Customer_ReferenceNumberLevel"));
		// Select Reference number Type
		functions.selectDropdown("Customer_ReferenceNumberType","VisibleText", testData.get("Customer_ReferenceNumberType"));
		// Enter Reference number format
		functions.enterText("Customer_ReferenceNumberFormat", testData.get("Customer_ReferenceNumberFormat"));
		// Enter Max Refund Batch Count
		functions.enterText("Customer_NumberOfRefunds", testData.get("Customer_NumberOfRefunds"));
		// Enter Max Refund Batch Count
		functions.enterText("Customer_TotalDollarAmount", testData.get("Customer_TotalDollarAmount"));
		
		user_Enters_CustAddressDetails();
		
		// Select Debit system reversal
		functions.selectDropdown("Customer_DebitSystemReversalHandling","VisibleText", testData.get("Customer_DebitSystemReversalHandling"));
		// Select Debit and EBT Returns Allowed
		functions.selectDropdown("Customer_DebitAndEBTReturns","VisibleText", testData.get("Customer_DebitAndEBTReturns"));			
	}}

	@And("^User enter Customer Address details$")
	public void user_Enters_CustAddressDetails() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		// Enter Service Phone No.
		functions.enterText("Customer_customerServicePhone", testData.get("Customer_customerServicePhone"));
		// Enter Voice Center Phone No.
		functions.enterText("Customer_voiceCenterNumber", testData.get("Customer_voiceCenterNumber"));
		// Fill Address Section
		// Enter Address1
		functions.enterText("Customer_Adress1", testData.get("Customer_Adress1"));
		// Enter Address2
		functions.enterText("Customer_Adress2", testData.get("Customer_Adress2"));
		// Enter City
		functions.enterText("Customer_City", testData.get("Customer_City"));
		// Enter Country Code
		functions.enterText("Customer_Country", testData.get("Customer_Country"));
		
		functions.clickAnElement("Customer_CountryCodeDesc", "CountryCodeDesc");
		functions.globalWait(8);
		// Select State/Province
		functions.selectDropdownByVisibleText("Customer_StateorProvince", testData.get("Customer_StateorProvince"));
		// enter Zip code
		functions.enterText("Customer_PostalCode", testData.get("Customer_PostalCode"));
		// Enter Customer Service Phone 
		functions.enterText("Customer_PhoneNumber", testData.get("Customer_PhoneNumber"));
		// Enter Primary Contact Name
		functions.enterText("Customer_ContactName", testData.get("Customer_ContactName"));
		// Enter Primary Contact Email
		functions.enterText("Customer_ContactEmail", testData.get("Customer_ContactEmail"));
		// Enter Primary Contact Phone
		functions.enterText("Customer_ContactPhone", testData.get("Customer_ContactPhone"));
		// Check check box Use Customer Address
		functions.changeRadioButtonOrCheckBoxStatus("Customer_useCustomerAddressIndicator", testData.get("Customer_useCustomerAddressIndicator"));
	}}
	@And("^User Adding Customer Mandatory cut Time$")
	public void user_Adding_MandatoryCustCutTime() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		// Select CutTime 1
		functions.selectDropdownByVisibleText("Customer_AddCutTime1", testData.get("Customer_AddCutTime1"));
		// Select Option 1
		functions.selectDropdownByVisibleText("Customer_AddOption1", testData.get("Customer_AddOption1"));
		// Click Add button
		functions.clickAnElement("Customer_ClickAddCutTime", "Add Cut Time");
	}
	}
	@And("^User Adding Customer all cut Times$")
	public void user_Adding_AllCustCutTime() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		// Select CutTime 1
		functions.selectDropdownByVisibleText("Customer_AddCutTime1", testData.get("Customer_AddCutTime1"));
		// Select Option 1
		functions.selectDropdownByVisibleText("Customer_AddOption1", testData.get("Customer_AddOption1"));
		// Select CutTime 2
		functions.selectDropdownByVisibleText("Customer_AddCutTime2", testData.get("Customer_AddCutTime2"));
		// Select Option 2
		functions.selectDropdownByVisibleText("Customer_AddOption2", testData.get("Customer_AddOption2"));
		// Select CutTime 3
		functions.selectDropdownByVisibleText("Customer_AddCutTime3", testData.get("Customer_AddCutTime3"));
		// Select Option 3
		functions.selectDropdownByVisibleText("Customer_AddOption3", testData.get("Customer_AddOption3"));
		// Select CutTime 4
		functions.selectDropdownByVisibleText("Customer_AddCutTime4", testData.get("Customer_AddCutTime4"));
		// Select Option 4
		functions.selectDropdownByVisibleText("Customer_AddOption4", testData.get("Customer_AddOption4"));
		// Select CutTime 5
		functions.selectDropdownByVisibleText("Customer_AddCutTime5", testData.get("Customer_AddCutTime5"));
		// Select Option 5
		functions.selectDropdownByVisibleText("Customer_AddOption5", testData.get("Customer_AddOption5"));
		// Select CutTime 6
		functions.selectDropdownByVisibleText("Customer_AddCutTime6", testData.get("Customer_AddCutTime6"));
		// Select Option 6
		functions.selectDropdownByVisibleText("Customer_AddOption6", testData.get("Customer_AddOption6"));
		//Select End of the day
		functions.selectDropdownByVisibleText("Customer_EndOfDay", testData.get("Customer_EndOfDay"));
		// Click Add button
		functions.clickAnElement("Customer_ClickAddCutTime", "Add Cut Time");
	}
	}
	@And("^User Searching Customer By number$")
	public void user_Searching_CustNumber() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		//Click on Customer tab
		functions.clickAnElement("Customer_Tab", "Customer_Tab");
		//Enter Customer Number to search
		functions.enterText("Customer_NumberSearch", testData.get("Customer_NumberSearch"));
		//Click on Search Button
		functions.waitForElementUsingPresence("Customer_ClickSearch");
		functions.clickAnElement("Customer_ClickSearch", "Search_Button");
		String CustomerNumber= functions.getElementTextValue("Customer_CustomerNumber");
		functions.setEnvironmentVariable("CustomerNumber", CustomerNumber);
		String strCustomerName= functions.getElementTextValue("Customer_CustomerName");
		functions.setEnvironmentVariable("CustomerName", strCustomerName);
	}
		}
	
	@And("^User Searching Customer By namer$")
	public void user_Searching_CustName() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		//Click on Customer tab
		functions.clickAnElement("Customer_Tab", "Customer_Tab");
		//Enter Customer Number to search
		functions.enterText("Customer_NameSearch", testData.get("Customer_NameSearch"));
		//Click on Search Button
		functions.waitForElementUsingPresence("Customer_ClickSearch");
		functions.clickAnElement("Customer_ClickSearch", "Search_Button");
		String CustomerNumber= functions.getElementTextValue("Customer_CustomerNumber");
		functions.setEnvironmentVariable("CustomerNumber", CustomerNumber);
		String strCustomerName= functions.getElementTextValue("Customer_CustomerName");
		functions.setEnvironmentVariable("CustomerName", strCustomerName);
	}}
	@And("^User Creating unique Customer Number$")
	public void createUniqueCustomerNo() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		Random ran = new Random(System.currentTimeMillis());
		int x = (int)(Math.random() * 999) + Math.abs(ran.nextInt());
		String strCustNumber = "91";
		String strCustomerName = "Customer_91";
		strCustNumber = strCustNumber.concat(Integer.toString(x));
		strCustomerName = strCustomerName.concat(Integer.toString(x));
		functions.setEnvironmentVariable("CustomerNumber", strCustNumber);
		functions.setEnvironmentVariable("CustomerName", strCustomerName);
		
		functions.enterText("Customer_CustomerNumber", functions.getEnvironmentVariable("CustomerNumber"));
		functions.enterText("Customer_CustomerName", functions.getEnvironmentVariable("CustomerName"));
		functions.globalWait(8);
		
	}}
	@And("^User giving Specific Logic to Customer$")
	public void SpecificL_Logic() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		
		functions.selectDropdownByVisibleText("Customer_SpecificLogicIndicator", testData.get("Customer_SpecificLogicIndicator"));
		
	}}
	@And("^User Adding Card Types to Customer$")
	public void AddCardsTo_Customer() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//click on Add Card Button
		functions.waitForElementUsingVisibility("Customer_AddCardButton");
		//Add Card Types
		functions.clickAnElement("Customer_AddCardButton", "AddCardButton");
		//functions.globalWait(10);
		
		String[] CardTypes = testData.get("Customer_CardTypes").split("@@");
		for(int i=0;i<CardTypes.length;i++)
		{
			//functions.globalWait(5);
			functions.waitForElementUsingVisibility("Customer_CardType");
			functions.selectDropdownByVisibleText("Customer_CardType", CardTypes[i]);
			
			//Select Voice Authorization -- JCB
			if(CardTypes[i].equalsIgnoreCase("JCB")||CardTypes[i].equalsIgnoreCase("Dinners")){
				functions.globalWait(5);
				functions.selectDropdownByVisibleText("Customer_voiceAllowed",testData.get("Customer_voiceAllowedYes"));
			}
			if(CardTypes[i].equalsIgnoreCase("Diners Club")) {
				functions.globalWait(5);
				functions.selectDropdownByVisibleText("Customer_voiceAllowed",testData.get("Customer_voiceAllowedNo"));
			}
			
			if (CardTypes[i].equalsIgnoreCase("Diners Club")|| CardTypes[i].equalsIgnoreCase("Union Pay International")
					|| CardTypes[i].equalsIgnoreCase("HRSI") || CardTypes[i].equalsIgnoreCase("EBT")|| CardTypes[i].equalsIgnoreCase("JCB") 
					|| CardTypes[i].equalsIgnoreCase("Debit")|| CardTypes[i].equalsIgnoreCase("Discover")
					|| CardTypes[i].equalsIgnoreCase("Alipay")|| CardTypes[i].equalsIgnoreCase("WeChat")|| CardTypes[i].equalsIgnoreCase("Visa")
					|| CardTypes[i].equalsIgnoreCase("American Express")||CardTypes[i].equalsIgnoreCase("BPI Private Label")
					|| CardTypes[i].equalsIgnoreCase("HSBC Bonus Points")||CardTypes[i].equalsIgnoreCase("HSBC Private Label")
					||CardTypes[i].equalsIgnoreCase("MasterCard")||CardTypes[i].equalsIgnoreCase("Philippines Local Debit")) {
				functions.globalWait(5);
				functions.selectDropdownByVisibleText("Customer_processingLevel",testData.get("Customer_processingLevel"));
				if(testData.get("Customer_processingLevel").equals("Auth and Capture")) {
					functions.globalWait(5);
					String winhandleBefore = FunctionsLibrary.driver.getWindowHandle();
					functions.setEnvironmentVariable("MainWindow", winhandleBefore);
					// Add Monetary Destination 
					functions.waitForElementUsingVisibility("Customer_Card_Monetary_Search");
					functions.clickAnElement("Customer_Card_Monetary_Search", "Monetary_Search");
					functions.globalWait(10);
					
					functions.switchToNewWindow();
					
					if(FunctionsLibrary.driver.findElements(By.id("overridelink")).size()!=0)
					{
						System.out.println("Clicking Certificate link");
						FunctionsLibrary.driver.findElement(By.id("overridelink")).click();
						functions.globalWait(5);
					}
					// Enter Value in Monetary Destination  
					functions.enterText("Customer_card_MonDestName", testData.get("Customer_card_MonDestName"));
					// Click on Search Button
					functions.clickAnElement("Customer_card_MonDestSearch", "Search");
					functions.globalWait(5);
					
					functions.waitForElementUsingVisibility("Customer_card_MonDestSearch_RadioButton");
					
					functions.changeRadioButtonOrCheckBoxStatus("Customer_card_MonDestSearch_RadioButton", testData.get("RadioButton"));
					int counter = 0;
					while(FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size()<=0){
						functions.globalWait(1);
						counter++;
						if(counter==60){
							break;
						}
					}
					counter = 0;
					while(!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()){
						functions.globalWait(1);
						counter++;
						if(counter==60){
							break;
						}
					}
					functions.clickAnElement("Customer_Select", "Select_MonDest");
					functions.globalWait(10);
					try{
						String strWinHandle = functions.getEnvironmentVariable("MainWindow");
						FunctionsLibrary.driver.switchTo().window(strWinHandle);
					}catch(Exception ee1){
						System.out.println(" Monetory Dest Failed----" + ee1.getMessage());
					}
					functions.globalWait(5);
					
					String winhandleBefore1 = FunctionsLibrary.driver.getWindowHandle();
					functions.globalWait(5);
					functions.clickAnElement("Customer_card_NonMonetary_Search", "NonMonSearch");
					functions.globalWait(10);
					
					functions.switchToNewWindow();
					
					if(FunctionsLibrary.driver.findElements(By.id("overridelink")).size()!=0)
					{
						System.out.println("Clicking Certificate link");
						FunctionsLibrary.driver.findElement(By.id("overridelink")).click();
						functions.globalWait(5);
					}
					// Enter Value in Non Monetary Destination  
					functions.enterText("Customer_card_NonMonetary_name", testData.get("Customer_card_NonMonetary_name"));
					functions.clickAnElement("Customer_card_NonMonetary_NameSearch", "NonMon_Search");
					
					functions.waitForElementUsingVisibility("Customer_card_MonDestSearch_RadioButton");
					functions.changeRadioButtonOrCheckBoxStatus("Customer_card_MonDestSearch_RadioButton", testData.get("RadioButton"));
					
					int counter1 = 0;
					while(FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size()<=0){
						functions.globalWait(1);
						counter1++;
						if(counter1==60){
							break;
						}
					}
					counter1 = 0;
					while(!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()){
						functions.globalWait(1);
						counter1++;
						if(counter1==60){
							break;
						}
					}
					functions.clickAnElement("Customer_card_NonMonetary_NameSelect", "NonMon_Select");
					functions.globalWait(10);
					try{
						FunctionsLibrary.driver.switchTo().window(winhandleBefore1);
					}catch(Exception ee1){
						System.out.println("Non Monetory Dest Failed----" + ee1.getMessage());
					}
					functions.globalWait(5);
				}
			if(testData.get("Customer_processingLevel").equals("Auth Only")) {
				functions.globalWait(5);
				
				String winhandleBefore1 = FunctionsLibrary.driver.getWindowHandle();
				functions.globalWait(5);
				functions.clickAnElement("Customer_card_NonMonetary_Search", "NonMonSearch");
				functions.globalWait(10);
				
				functions.switchToNewWindow();
				
				if(FunctionsLibrary.driver.findElements(By.id("overridelink")).size()!=0)
				{
					System.out.println("Clicking Certificate link");
					FunctionsLibrary.driver.findElement(By.id("overridelink")).click();
					functions.globalWait(5);
				}
				// Enter Value in Non Monetary Destination  
				functions.enterText("Customer_card_NonMonetary_name", testData.get("Customer_card_NonMonetary_name"));
				functions.clickAnElement("Customer_card_NonMonetary_NameSearch", "NonMon_Search");
				
				functions.waitForElementUsingVisibility("Customer_card_MonDestSearch_RadioButton");
				functions.changeRadioButtonOrCheckBoxStatus("Customer_card_MonDestSearch_RadioButton", testData.get("RadioButton"));
				
				int counter1 = 0;
				while(FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size()<=0){
					functions.globalWait(1);
					counter1++;
					if(counter1==60){
						break;
					}
				}
				counter1 = 0;
				while(!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()){
					functions.globalWait(1);
					counter1++;
					if(counter1==60){
						break;
					}
				}
				functions.clickAnElement("Customer_card_NonMonetary_NameSelect", "NonMon_Select");
				functions.globalWait(10);
				try{
					FunctionsLibrary.driver.switchTo().window(winhandleBefore1);
				}catch(Exception ee1){
					System.out.println("Non Monetory Dest Failed----" + ee1.getMessage());
				}
				functions.globalWait(5);
			}
			}
			// Click on Add Button
			functions.clickAnElement("Customer_AddCardType", "Add_CardType");
			functions.waitForElementUsingPresence("Customer_card_Add_SuccessMsg");
			functions.verifyElementTextContains("Customer_card_Add_SuccessMsg", testData.get("Customer_card_Add_SuccessMsg"));
			functions.globalWait(5);
		}
		}
		
	}
	@And("^User click on Back to Customer link$")
	public void BackTo_Customer() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.waitForElementUsingPresence("Customer_BackToCustomer");
		functions.clickAnElement("Customer_BackToCustomer", "BackToCustomer");
	}}
	@And("^User click on Save button to create Pending Customer$")
	public void Save_Pending_Customer() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.clickAnElement("Customer_Save_Button", "Save_PendingCust");
		functions.globalWait(5);
		functions.verifyElementTextPresent("Customer_Save_SuccessMsg", testData.get("Customer_Save_SuccessMsg"));
	}}
	@And("^User adding Acquirer Account to Customer Dynamically$")
	public void AddAcquirer_To_CustomerDynamically() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.globalWait(5);
		String winhandleBefore = FunctionsLibrary.driver.getWindowHandle();
		
		functions.clickAnElement("Customer_Acquirer_AddButton", "Add_Acquirer_Button");
		functions.globalWait(10);
		//Switching to new window
		functions.switchToNewWindow();
		// Enter Accquirer Account     
		functions.enterText("Customer_AcquirerNameSearch", functions.getEnvironmentVariable("AcquirerAccount"));
		functions.clickAnElement("Customer_AcquirerNameSearchClick", "Acquirer_Search");
		// Check check box Acquirer Account List
		functions.changeRadioButtonOrCheckBoxStatus("Customer_AcquirerAccountListStatus", testData.get("Customer_check"));
		int counter = 0;
		while(FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size()<=0){
			functions.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()){
			functions.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		functions.clickAnElement("Customer_Select", "Acquirer_select");
		//functions.globalWait(5)
		try{
			FunctionsLibrary.driver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Non Monetory Dest Failed----" + ee1.getMessage());
		}
		//functions.switchToTheParentWindow();

		//functions.globalWait(10);
		// Verify Added Accquirer Account
		functions.verifyElementTextPresentContains("Customer_Acquirer_SuccessMsg", testData.get("Customer_Acquirer_SuccessMsg"));
		
		//functions.verifyColumnValues(testData.get("Customer_Acquirer_Verifycolumn"));
		
	}}
	@And("^User adding Acquirer Account to Customer$")
	public void AddAcquirer_To_Customer() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.globalWait(5);
		String winhandleBefore = FunctionsLibrary.driver.getWindowHandle();
		
		functions.clickAnElement("Customer_Acquirer_AddButton", "Add_Acquirer_Button");
		functions.globalWait(10);
		//Switching to new window
		functions.switchToNewWindow();
		// Enter Accquirer Account     
		functions.enterText("Customer_AcquirerNameSearch", testData.get("Customer_AcquirerNameSearch"));
		functions.clickAnElement("Customer_AcquirerNameSearchClick", "Acquirer_Search");
		// Check check box Acquirer Account List
		functions.changeRadioButtonOrCheckBoxStatus("Customer_AcquirerAccountListStatus", testData.get("Customer_check"));
		int counter = 0;
		while(FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size()<=0){
			functions.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()){
			functions.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		functions.clickAnElement("Customer_Select", "Acquirer_select");
		//functions.globalWait(5)
		try{
			FunctionsLibrary.driver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Non Monetory Dest Failed----" + ee1.getMessage());
		}
		//functions.switchToTheParentWindow();

		//functions.globalWait(10);
		// Verify Added Accquirer Account
		functions.verifyElementTextPresentContains("Customer_Acquirer_SuccessMsg", testData.get("Customer_Acquirer_SuccessMsg"));
		
		//functions.verifyColumnValues(testData.get("Customer_Acquirer_Verifycolumn"));
		
	}}
	@And("^User adding second Acquirer Account to Customer$")
	public void Add_Second_Acquirer_To_Customer() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.globalWait(5);
		String winhandleBefore = FunctionsLibrary.driver.getWindowHandle();
		
		functions.clickAnElement("Customer_Acquirer_AddButton", "Add_Acquirer_Button");
		functions.globalWait(10);
		//Switching to new window
		functions.switchToNewWindow();
		// Enter Accquirer Account     
		functions.enterText("Customer_AcquirerNameSearch", testData.get("Customer_AcquirerNameSearch1"));
		functions.clickAnElement("Customer_AcquirerNameSearchClick", "Acquirer_Search");
		// Check check box Acquirer Account List
		functions.changeRadioButtonOrCheckBoxStatus("Customer_AcquirerAccountListStatus", testData.get("Customer_check"));
		int counter = 0;
		while(FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size()<=0){
			functions.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()){
			functions.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		functions.clickAnElement("Customer_Select", "Acquirer_select");
		//functions.globalWait(5)
		try{
			FunctionsLibrary.driver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Non Monetory Dest Failed----" + ee1.getMessage());
		}
		//functions.switchToTheParentWindow();

		//functions.globalWait(10);
		// Verify Added Accquirer Account
		functions.verifyElementTextPresentContains("Customer_Acquirer_SuccessMsg", testData.get("Customer_Acquirer_SuccessMsg"));
		
		//functions.verifyColumnValues(testData.get("Customer_Acquirer_Verifycolumn"));
		
	}
	}
	@And("^User adding Encryption to Customer$")
	public void AddEncryption_To_Customer() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.globalWait(5);
		
		functions.enterText("Customer_EncryptionAssisName", testData.get("Customer_EncryptionAssisName"));
		functions.clickAnElement("Customer_EncryptionAssisNameSearch", "Encryption_Search");
		
		functions.switchToNewWindow();
		
		if(FunctionsLibrary.driver.findElements(By.id("overridelink")).size()!=0)
		{
			System.out.println("Clicking Certificate link");
			FunctionsLibrary.driver.findElement(By.id("overridelink")).click();
			functions.globalWait(5);
		}
		
		int counter = 0;
		while(FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size()<=0){
			functions.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Check checkbox Encryption Assignment  
		functions.changeRadioButtonOrCheckBoxStatus("Customer_Encryption_checkbox", testData.get("Customer_check"));
		counter = 0;
		while(!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()){
			functions.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		functions.clickAnElement("Customer_card_Encryption_NameSelect", "Select_Encryption");
		System.out.println("clicked on Encyrp Assng Ok Buttom");
		functions.globalWait(10);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");
			functions.switchToParentWindow();
		}catch(Exception ee1){
			System.out.println(" Encrp Assgn  Failed----" + ee1.getMessage());
		}
		//functions.verifyElementPresent("Customer_CustomerNumber");
		//functions.verifyElementTextPresent("Customer_CustomerNumber", functions.getEnvironmentVariable("CustomerNumber"));
		//functions.verifyColumnValues(testData.get("Customer_Encryption_Verifycolumn"));
		functions.globalWait(2);
	}}
	@And("^User adding Encryption to Customer Dynamically$")
	public void AddEncryption_To_Customer_Dynamically() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.globalWait(5);
		
		functions.enterText("Customer_EncryptionAssisName", functions.getEnvironmentVariable("EncryptionName"));
		functions.clickAnElement("Customer_EncryptionAssisNameSearch", "Encryption_Search");
		
		functions.switchToNewWindow();
		
		if(FunctionsLibrary.driver.findElements(By.id("overridelink")).size()!=0)
		{
			System.out.println("Clicking Certificate link");
			FunctionsLibrary.driver.findElement(By.id("overridelink")).click();
			functions.globalWait(5);
		}
		
		int counter = 0;
		while(FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size()<=0){
			functions.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Check checkbox Encryption Assignment  
		functions.changeRadioButtonOrCheckBoxStatus("Customer_Encryption_checkbox", testData.get("Customer_check"));
		counter = 0;
		while(!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()){
			functions.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		functions.clickAnElement("Customer_card_Encryption_NameSelect", "Select_Encryption");
		System.out.println("clicked on Encyrp Assng Ok Buttom");
		functions.globalWait(10);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");
			functions.switchToParentWindow();
		}catch(Exception ee1){
			System.out.println(" Encrp Assgn  Failed----" + ee1.getMessage());
		}
		//functions.verifyElementPresent("Customer_CustomerNumber");
		//functions.verifyElementTextPresent("Customer_CustomerNumber", functions.getEnvironmentVariable("CustomerNumber"));
		//functions.verifyColumnValues(testData.get("Customer_Encryption_Verifycolumn"));
		functions.globalWait(2);
	}}
	@And("^User Validate Customer$")
	public void Validate_Customer() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click Button Validate
		functions.waitForElementUsingPresence("Customer_Validate");
		functions.clickAnElement("Customer_Validate", "Validate");
		// Verify Validate Message   
		functions.waitForElementUsingPresence("Customer_Validate_SuccessMsg");
		functions.verifyElementTextContains("Customer_Validate_SuccessMsg", testData.get("Customer_Validate_SuccessMsg"));
	}
	}
	@Then("^User changing Customer status to Open$")
	public void Open_Customer_Status() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click Button Edit
		functions.clickAnElement("Customer_Edit_Button", "Edit");
		functions.waitForElementUsingPresence("Customer_Save_Button");
		//Change Status
		functions.selectDropdownByVisibleText("Customer_Satus_Listbox", testData.get("Customer_Satus_Listbox"));
		//Click on Save Button
		functions.clickAnElement("Customer_Save_Button", "Save");
		
		functions.waitForElementUsingPresence("Customer_Updated_Msg");
		functions.verifyElementTextContains("Customer_Updated_Msg", testData.get("Customer_Updated_Msg"));
		
	}}
	@Then("^User Validating Customer CMF Database Region \"([^\"]*)\"$")
	public void CMF_DB_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.CMFDatabase(Region);
		String CustNum=functions.getEnvironmentVariable("CustomerNumber");
		String query=testData.get("Customer_CMF_Query1")+CustNum+"'";
		functions.globalWait(65);
		functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("CMF_DBExpected"));
		}
	}
	@Then("^User Validating Customer G2 Database Region \"([^\"]*)\"$")
	public void G2DB_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.G2Database(Region);
		String CustNum=functions.getEnvironmentVariable("CustomerNumber");
		String query=testData.get("Customer_G2_Query1")+CustNum+"'";
		functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("G2_DBExpected"));
		}
	}
	@Then("^User Validating Customer CMF Database Multiple values \"([^\"]*)\"$")
	public void CMF_DB_Multiple_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.CMFDatabase(Region);
		String CustNum=functions.getEnvironmentVariable("CustomerNumber");
		String[] CMFDBExpected=testData.get("CMF_DBExpected").split("@@");
		functions.globalWait(65);
		for(int i=1;i<=CMFDBExpected.length;i++)
		{
		String query=testData.get("Customer_CMF_Query"+i)+CustNum+"'";
			
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, CMFDBExpected[i]);
		}
		}
	}
	@Then("^User Validating Customer G2 Database Multiple values \"([^\"]*)\"$")
	public void G2DB_Multiple_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.G2Database(Region);
		String CustNum=functions.getEnvironmentVariable("CustomerNumber");
		String[] G2DBExpected=testData.get("G2_DBExpected").split("@@");
		functions.globalWait(65);
		for(int i=1;i<=G2DBExpected.length;i++)
		{
		String query=testData.get("Customer_G2_Query"+i)+CustNum+"'";
			
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, G2DBExpected[i]);
		}
		}
	}
	@Then("^User Validating Customer CMF Database CPR cust2 Region \"([^\"]*)\"$")
	public void CMF_DB_ValidationsCPR(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.CMFDatabase(Region);
		String CustNum=functions.getEnvironmentVariable("CustomerNumber2");
		String query=testData.get("Customer_CMF_QueryCPR1")+CustNum+"'";
		functions.globalWait(65);
		functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("CMF_DBExpectedCPR"));
		}
	}
	@Then("^User Validating Customer CMF Database CPR Cust1 Region \"([^\"]*)\"$")
	public void CMF_DB_CPR(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.CMFDatabase(Region);
		String CustNum=functions.getEnvironmentVariable("CustomerNumber1");
		String query=testData.get("Customer_CMF_Query1")+CustNum+"'";
		functions.globalWait(65);
		functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("CMF_DBExpected"));
		}
	}
	
	@When("^User create Open Customer$")
	public void user_Create_OpenCustomer() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
						
		user_Navigates_to_AddCustomerPage();
		
		createUniqueCustomerNo();
		
		user_Enters_MandatoryDetails();
		
		SpecificL_Logic();
		
		user_Adding_AllCustCutTime();
		
		Save_Pending_Customer();
		
		AddAcquirer_To_Customer();
		
		AddEncryption_To_Customer();
		
		AddCardsTo_Customer();
		
		BackTo_Customer();
		
		Validate_Customer();
		
		Open_Customer_Status();
		}
	}
	
	
	@And("^User Adding Card Types to Customer2$")
	public void AddCardsTo_Customer2() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//click on Add Card Button
		functions.waitForElementUsingVisibility("Customer_AddCardButton");
		//Add Card Types
		functions.clickAnElement("Customer_AddCardButton", "AddCardButton");
		//functions.globalWait(10);
		
		String[] CardTypes = testData.get("Customer_CardTypes1").split("@@");
		for(int i=0;i<CardTypes.length;i++)
		{
			//functions.globalWait(5);
			functions.waitForElementUsingVisibility("Customer_CardType");
			functions.selectDropdownByVisibleText("Customer_CardType", CardTypes[i]);
			
			//Select Voice Authorization -- JCB
			if(CardTypes[i].equalsIgnoreCase("JCB")||CardTypes[i].equalsIgnoreCase("Dinners")){
				functions.globalWait(5);
				functions.selectDropdownByVisibleText("Customer_voiceAllowed",testData.get("Customer_voiceAllowedYes"));
			}
			if(CardTypes[i].equalsIgnoreCase("Diners Club")) {
				functions.globalWait(5);
				functions.selectDropdownByVisibleText("Customer_voiceAllowed",testData.get("Customer_voiceAllowedNo"));
			}
			/*if(CardTypes[i].equalsIgnoreCase("JCB")){
				functions.selectDropdownByVisibleText("Customer_processingLevel",testData.get("Customer_processingLevel1"));
				functions.globalWait(5);
				String winhandleBefore = FunctionsLibrary.driver.getWindowHandle();
				functions.setEnvironmentVariable("MainWindow", winhandleBefore);
				// Add Monetary Destination 
				functions.waitForElementUsingVisibility("Customer_Card_Monetary_Search");
				functions.clickAnElement("Customer_Card_Monetary_Search", "Monetary_Search");
				//functions.globalWait(10);
				
				functions.switchToNewWindow();
				
				if(FunctionsLibrary.driver.findElements(By.id("overridelink")).size()!=0)
				{
					System.out.println("Clicking Certificate link");
					FunctionsLibrary.driver.findElement(By.id("overridelink")).click();
					
					functions.globalWait(5);
				}
				// Enter Value in Monetary Destination  
				functions.enterText("Customer_card_MonDestName", testData.get("Customer_card_MonDestName1"));
				// Click on Search Button
				functions.clickAnElement("Customer_card_MonDestSearch", "Search");
				functions.globalWait(5);
				
				functions.waitForElementUsingVisibility("Customer_card_MonDestSearch_RadioButton");
				functions.changeRadioButtonOrCheckBoxStatus("Customer_card_MonDestSearch_RadioButton", testData.get("RadioButton"));
				int counter = 0;
				while(FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size()<=0){
					functions.globalWait(1);
					counter++;
					if(counter==60){
						break;
					}
				}
				counter = 0;
				while(!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()){
					functions.globalWait(1);
					counter++;
					if(counter==60){
						break;
					}
				}
				functions.clickAnElement("Customer_Select", "Select_MonDest");
				functions.globalWait(10);
				try{
					String strWinHandle = functions.getEnvironmentVariable("MainWindow");
					FunctionsLibrary.driver.switchTo().window(strWinHandle);
				}catch(Exception ee1){
					System.out.println(" Monetory Dest Failed----" + ee1.getMessage());
				}
				functions.globalWait(5);
			}*/
			if (CardTypes[i].equalsIgnoreCase("Diners Club")|| CardTypes[i].equalsIgnoreCase("Union Pay International")
					|| CardTypes[i].equalsIgnoreCase("HRSI") || CardTypes[i].equalsIgnoreCase("EBT")|| CardTypes[i].equalsIgnoreCase("JCB") 
					|| CardTypes[i].equalsIgnoreCase("Debit")|| CardTypes[i].equalsIgnoreCase("Discover")
					|| CardTypes[i].equalsIgnoreCase("Alipay")|| CardTypes[i].equalsIgnoreCase("WeChat")|| CardTypes[i].equalsIgnoreCase("Visa")
					|| CardTypes[i].equalsIgnoreCase("American Express")||CardTypes[i].equalsIgnoreCase("BPI Private Label")
					|| CardTypes[i].equalsIgnoreCase("HSBC Bonus Points")||CardTypes[i].equalsIgnoreCase("HSBC Private Label")
					||CardTypes[i].equalsIgnoreCase("MasterCard")||CardTypes[i].equalsIgnoreCase("Philippines Local Debit")) {
				functions.globalWait(5);
				functions.selectDropdownByVisibleText("Customer_processingLevel",testData.get("Customer_processingLevel1"));
				if(testData.get("Customer_processingLevel1").equals("Auth and Capture")) {
					functions.globalWait(5);
					String winhandleBefore = FunctionsLibrary.driver.getWindowHandle();
					functions.setEnvironmentVariable("MainWindow", winhandleBefore);
					// Add Monetary Destination 
					functions.waitForElementUsingVisibility("Customer_Card_Monetary_Search");
					functions.clickAnElement("Customer_Card_Monetary_Search", "Monetary_Search");
					functions.globalWait(10);
					
					functions.switchToNewWindow();
					
					if(FunctionsLibrary.driver.findElements(By.id("overridelink")).size()!=0)
					{
						System.out.println("Clicking Certificate link");
						FunctionsLibrary.driver.findElement(By.id("overridelink")).click();
						functions.globalWait(5);
					}
					// Enter Value in Monetary Destination  
					functions.enterText("Customer_card_MonDestName", testData.get("Customer_card_MonDestName1"));
					// Click on Search Button
					functions.clickAnElement("Customer_card_MonDestSearch", "Search");
					functions.globalWait(5);
					
					functions.waitForElementUsingVisibility("Customer_card_MonDestSearch_RadioButton");
					
					functions.changeRadioButtonOrCheckBoxStatus("Customer_card_MonDestSearch_RadioButton", testData.get("RadioButton"));
					int counter = 0;
					while(FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size()<=0){
						functions.globalWait(1);
						counter++;
						if(counter==60){
							break;
						}
					}
					counter = 0;
					while(!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()){
						functions.globalWait(1);
						counter++;
						if(counter==60){
							break;
						}
					}
					functions.clickAnElement("Customer_Select", "Select_MonDest");
					functions.globalWait(10);
					try{
						String strWinHandle = functions.getEnvironmentVariable("MainWindow");
						FunctionsLibrary.driver.switchTo().window(strWinHandle);
					}catch(Exception ee1){
						System.out.println(" Monetory Dest Failed----" + ee1.getMessage());
					}
					functions.globalWait(5);
					
					String winhandleBefore1 = FunctionsLibrary.driver.getWindowHandle();
					functions.globalWait(5);
					functions.clickAnElement("Customer_card_NonMonetary_Search", "NonMonSearch");
					functions.globalWait(10);
					
					functions.switchToNewWindow();
					
					if(FunctionsLibrary.driver.findElements(By.id("overridelink")).size()!=0)
					{
						System.out.println("Clicking Certificate link");
						FunctionsLibrary.driver.findElement(By.id("overridelink")).click();
						functions.globalWait(5);
					}
					// Enter Value in Non Monetary Destination  
					functions.enterText("Customer_card_NonMonetary_name", testData.get("Customer_card_NonMonetary_name1"));
					functions.clickAnElement("Customer_card_NonMonetary_NameSearch", "NonMon_Search");
					
					functions.waitForElementUsingVisibility("Customer_card_MonDestSearch_RadioButton");
					functions.changeRadioButtonOrCheckBoxStatus("Customer_card_MonDestSearch_RadioButton", testData.get("RadioButton"));
					
					int counter1 = 0;
					while(FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size()<=0){
						functions.globalWait(1);
						counter1++;
						if(counter1==60){
							break;
						}
					}
					counter1 = 0;
					while(!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()){
						functions.globalWait(1);
						counter1++;
						if(counter1==60){
							break;
						}
					}
					functions.clickAnElement("Customer_card_NonMonetary_NameSelect", "NonMon_Select");
					functions.globalWait(10);
					try{
						FunctionsLibrary.driver.switchTo().window(winhandleBefore1);
					}catch(Exception ee1){
						System.out.println("Non Monetory Dest Failed----" + ee1.getMessage());
					}
					functions.globalWait(5);
				}
			if(testData.get("Customer_processingLevel1").equals("Auth Only")) {
				functions.globalWait(5);
				
				String winhandleBefore1 = FunctionsLibrary.driver.getWindowHandle();
				functions.globalWait(5);
				functions.clickAnElement("Customer_card_NonMonetary_Search", "NonMonSearch");
				functions.globalWait(10);
				
				functions.switchToNewWindow();
				
				if(FunctionsLibrary.driver.findElements(By.id("overridelink")).size()!=0)
				{
					System.out.println("Clicking Certificate link");
					FunctionsLibrary.driver.findElement(By.id("overridelink")).click();
					functions.globalWait(5);
				}
				// Enter Value in Non Monetary Destination  
				functions.enterText("Customer_card_NonMonetary_name", testData.get("Customer_card_NonMonetary_name1"));
				functions.clickAnElement("Customer_card_NonMonetary_NameSearch", "NonMon_Search");
				
				functions.waitForElementUsingVisibility("Customer_card_MonDestSearch_RadioButton");
				functions.changeRadioButtonOrCheckBoxStatus("Customer_card_MonDestSearch_RadioButton", testData.get("RadioButton"));
				
				int counter1 = 0;
				while(FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size()<=0){
					functions.globalWait(1);
					counter1++;
					if(counter1==60){
						break;
					}
				}
				counter1 = 0;
				while(!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()){
					functions.globalWait(1);
					counter1++;
					if(counter1==60){
						break;
					}
				}
				functions.clickAnElement("Customer_card_NonMonetary_NameSelect", "NonMon_Select");
				functions.globalWait(10);
				try{
					FunctionsLibrary.driver.switchTo().window(winhandleBefore1);
				}catch(Exception ee1){
					System.out.println("Non Monetory Dest Failed----" + ee1.getMessage());
				}
				functions.globalWait(5);
			}
			}
			// Click on Add Button
			functions.clickAnElement("Customer_AddCardType", "Add_CardType");
			functions.waitForElementUsingPresence("Customer_card_Add_SuccessMsg");
			functions.verifyElementTextContains("Customer_card_Add_SuccessMsg", testData.get("Customer_card_Add_SuccessMsg"));
			functions.globalWait(5);
		}
		}
		
	}
	@And("^User adding Acquirer Account to Customer2$")
	public void AddAcquirer_To_Customer2() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.globalWait(5);
		String winhandleBefore = FunctionsLibrary.driver.getWindowHandle();
		
		functions.clickAnElement("Customer_Acquirer_AddButton", "Add_Acquirer_Button");
		functions.globalWait(10);
		//Switching to new window
		functions.switchToNewWindow();
		// Enter Accquirer Account     
		functions.enterText("Customer_AcquirerNameSearch", testData.get("Customer_AcquirerNameSearch1"));
		functions.clickAnElement("Customer_AcquirerNameSearchClick", "Acquirer_Search");
		// Check check box Acquirer Account List
		functions.changeRadioButtonOrCheckBoxStatus("Customer_AcquirerAccountListStatus", testData.get("Customer_check"));
		int counter = 0;
		while(FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]")).size()<=0){
			functions.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]")).isDisplayed()){
			functions.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		functions.clickAnElement("Customer_Select", "Acquirer_select");
		//functions.globalWait(5)
		try{
			FunctionsLibrary.driver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Non Monetory Dest Failed----" + ee1.getMessage());
		}
		//functions.switchToTheParentWindow();

		//functions.globalWait(10);
		// Verify Added Accquirer Account
		functions.verifyElementTextPresentContains("Customer_Acquirer_SuccessMsg", testData.get("Customer_Acquirer_SuccessMsg"));
		
		//functions.verifyColumnValues(testData.get("Customer_Acquirer_Verifycolumn"));
		
	}}
	
	@And("^User enter Customer2 Mandatory details$")
	public void user_Enters_MandatoryDetails2() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			// Enter Line Of Business
			functions.selectDropdown("Customer_LineOfBusiness","VisibleText", testData.get("Customer_LineOfBusiness1"));
			// Select Customer Type
			functions.selectDropdown("Customer_CustomerType","VisibleText", testData.get("Customer_CustomerType1"));
			// Select Customer Type
			functions.selectDropdown("Customer_Processor","VisibleText", testData.get("Customer_Processor1"));
			// Select StandIn Processing
			functions.selectDropdownByVisibleText("Customer_StandInProcessing", testData.get("Customer_StandInProcessing1"));
			// Enter Credit Velocity
			functions.enterText("Customer_CreditVelocity", testData.get("Customer_CreditVelocity1"));
			// Enter Purchase Velocity
			functions.enterText("Customer_PurchaseVelocity", testData.get("Customer_PurchaseVelocity1"));
			// Enter ship To ID
			functions.enterText("Customer_ShipToID", testData.get("Customer_ShipToID1"));
			// Select StandIn Processing
			functions.selectDropdownByVisibleText("Customer_BinBlocking", testData.get("Customer_BinBlocking1"));
			// Select Reference number Sequence
			functions.selectDropdown("Customer_ReferenceNumberSequence","VisibleText", testData.get("Customer_ReferenceNumberSequence1"));
			// Select Reference number level
			functions.selectDropdown("Customer_ReferenceNumberLevel","VisibleText", testData.get("Customer_ReferenceNumberLevel1"));
			// Select Reference number Type
			functions.selectDropdown("Customer_ReferenceNumberType","VisibleText", testData.get("Customer_ReferenceNumberType1"));
			// Enter Reference number format
			functions.enterText("Customer_ReferenceNumberFormat", testData.get("Customer_ReferenceNumberFormat1"));
			// Enter Max Refund Batch Count
			functions.enterText("Customer_NumberOfRefunds", testData.get("Customer_NumberOfRefunds1"));
			// Enter Max Refund Batch Count
			functions.enterText("Customer_TotalDollarAmount", testData.get("Customer_TotalDollarAmount1"));
			
			user_Enters_CustAddressDetails2();
			
			// Select Debit system reversal
			functions.selectDropdown("Customer_DebitSystemReversalHandling","VisibleText", testData.get("Customer_DebitSystemReversalHandling1"));
			// Select Debit and EBT Returns Allowed
			functions.selectDropdown("Customer_DebitAndEBTReturns","VisibleText", testData.get("Customer_DebitAndEBTReturns1"));	

			}}
	@And("^User enter Customer2 Address details$")
	public void user_Enters_CustAddressDetails2() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		// Enter Service Phone No.
		functions.enterText("Customer_customerServicePhone", testData.get("Customer_customerServicePhone1"));
		// Enter Voice Center Phone No.
		functions.enterText("Customer_voiceCenterNumber", testData.get("Customer_voiceCenterNumber1"));
		// Fill Address Section
		// Enter Address1
		functions.enterText("Customer_Adress1", testData.get("Customer_Adress11"));
		// Enter Address2
		functions.enterText("Customer_Adress2", testData.get("Customer_Adress21"));
		// Enter City
		functions.enterText("Customer_City", testData.get("Customer_City1"));
		// Enter Country Code
		functions.enterText("Customer_Country", testData.get("Customer_Country1"));
		
		functions.clickAnElement("Customer_CountryCodeDesc", "CountryCodeDesc");
		functions.globalWait(8);
		// Select State/Province
		functions.selectDropdownByVisibleText("Customer_StateorProvince", testData.get("Customer_StateorProvince1"));
		// enter Zip code
		functions.enterText("Customer_PostalCode", testData.get("Customer_PostalCode1"));
		// Enter Customer Service Phone 
		functions.enterText("Customer_PhoneNumber", testData.get("Customer_PhoneNumber1"));
		// Enter Primary Contact Name
		functions.enterText("Customer_ContactName", testData.get("Customer_ContactName1"));
		// Enter Primary Contact Email
		functions.enterText("Customer_ContactEmail", testData.get("Customer_ContactEmail1"));
		// Enter Primary Contact Phone
		functions.enterText("Customer_ContactPhone", testData.get("Customer_ContactPhone1"));
		// Check check box Use Customer Address
		functions.changeRadioButtonOrCheckBoxStatus("Customer_useCustomerAddressIndicator", testData.get("Customer_useCustomerAddressIndicator1"));
	}}
	@And("^User giving Specific Logic to Customer2$")
	public void SpecificL_Logic_Cust2() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		
		functions.selectDropdownByVisibleText("Customer_SpecificLogicIndicator", testData.get("Customer_SpecificLogicIndicator1"));
		
	}}
	@And("^User Adding Customer2 all cut Times$")
	public void user_Adding_AllCustCutTime_Cust2() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			// Select CutTime 1
			functions.selectDropdownByVisibleText("Customer_AddCutTime1", testData.get("Customer_AddCutTime11"));
			// Select Option 1
			functions.selectDropdownByVisibleText("Customer_AddOption1", testData.get("Customer_AddOption11"));
			// Select CutTime 2
			functions.selectDropdownByVisibleText("Customer_AddCutTime2", testData.get("Customer_AddCutTime21"));
			// Select Option 2
			functions.selectDropdownByVisibleText("Customer_AddOption2", testData.get("Customer_AddOption21"));
			// Select CutTime 3
			functions.selectDropdownByVisibleText("Customer_AddCutTime3", testData.get("Customer_AddCutTime31"));
			// Select Option 3
			functions.selectDropdownByVisibleText("Customer_AddOption3", testData.get("Customer_AddOption31"));
			// Select CutTime 4
			functions.selectDropdownByVisibleText("Customer_AddCutTime4", testData.get("Customer_AddCutTime41"));
			// Select Option 41
			functions.selectDropdownByVisibleText("Customer_AddOption4", testData.get("Customer_AddOption41"));
			// Select CutTime 5
			functions.selectDropdownByVisibleText("Customer_AddCutTime5", testData.get("Customer_AddCutTime51"));
			// Select Option 5
			functions.selectDropdownByVisibleText("Customer_AddOption5", testData.get("Customer_AddOption51"));
			// Select CutTime 6
			functions.selectDropdownByVisibleText("Customer_AddCutTime6", testData.get("Customer_AddCutTime61"));
			// Select Option 6
			functions.selectDropdownByVisibleText("Customer_AddOption6", testData.get("Customer_AddOption61"));
			//Select End of the day
			functions.selectDropdownByVisibleText("Customer_EndOfDay", testData.get("Customer_EndOfDay1"));
			// Click Add button
			functions.clickAnElement("Customer_ClickAddCutTime", "Add Cut Time");
	}
	}
	@And("^User Creating unique Customer Number For Cust1$")
	public void createUniqueCustomerNo1() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		Random ran = new Random(System.currentTimeMillis());
		int x = (int)(Math.random() * 999) + Math.abs(ran.nextInt());
		String strCustNumber = "91";
		String strCustomerName = "Customer_91";
		strCustNumber = strCustNumber.concat(Integer.toString(x));
		strCustomerName = strCustomerName.concat(Integer.toString(x));
		functions.setEnvironmentVariable("CustomerNumber1", strCustNumber);
		functions.setEnvironmentVariable("CustomerName1", strCustomerName);
		
		functions.enterText("Customer_CustomerNumber", functions.getEnvironmentVariable("CustomerNumber1"));
		functions.enterText("Customer_CustomerName", functions.getEnvironmentVariable("CustomerName1"));
		functions.globalWait(8);
		
	}}
	@And("^User Creating unique Customer Number For Cust2$")
	public void createUniqueCustomerNo2() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		Random ran = new Random(System.currentTimeMillis());
		int x = (int)(Math.random() * 999) + Math.abs(ran.nextInt());
		String strCustNumber = "91";
		String strCustomerName = "Customer_91";
		strCustNumber = strCustNumber.concat(Integer.toString(x));
		strCustomerName = strCustomerName.concat(Integer.toString(x));
		functions.setEnvironmentVariable("CustomerNumber2", strCustNumber);
		functions.setEnvironmentVariable("CustomerName2", strCustomerName);
		
		functions.enterText("Customer_CustomerNumber", functions.getEnvironmentVariable("CustomerNumber2"));
		functions.enterText("Customer_CustomerName", functions.getEnvironmentVariable("CustomerName2"));
		functions.globalWait(8);
		
	}}
	
	
	@When("^User create Open Customer1$")
	public void user_Create_OpenCustomer1() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
						
		user_Navigates_to_AddCustomerPage();
		
		createUniqueCustomerNo1();
	
		user_Enters_MandatoryDetails();
		
		SpecificL_Logic();
		
		user_Adding_AllCustCutTime();
		
		Save_Pending_Customer();
		
		AddAcquirer_To_Customer();
		
		AddEncryption_To_Customer();
		
		AddCardsTo_Customer();
		
		BackTo_Customer();
		
		Validate_Customer();
		
		Open_Customer_Status();
		}
	}
	@When("^User create Pending Customer1$")
	public void user_Create_PendingCustomer1() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
						
		user_Navigates_to_AddCustomerPage();
		
		createUniqueCustomerNo1();
	
		user_Enters_MandatoryDetails();
		
		SpecificL_Logic();
		
		user_Adding_AllCustCutTime();
		
		Save_Pending_Customer();
		
		AddAcquirer_To_Customer();
		
		AddEncryption_To_Customer();
		
		AddCardsTo_Customer();
		
		BackTo_Customer();
		
		
		
		}
	}
	@And("^User create Open Customer2$")
	public void user_Create_OpenCustomer2() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
						
		user_Navigates_to_AddCustomerPage();
		
		createUniqueCustomerNo2();
		
		user_Enters_MandatoryDetails2();
		
		
		SpecificL_Logic_Cust2();
		
		
		user_Adding_AllCustCutTime_Cust2();
		
		
		Save_Pending_Customer();
		
		AddAcquirer_To_Customer2();
		
		
		AddCardsTo_Customer2();
		
		BackTo_Customer();
		
		Validate_Customer();
		
		Open_Customer_Status();
		}
	}
	@And("^User create Pending Customer2$")
	public void user_Create_PendingCustomer2() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
						
		user_Navigates_to_AddCustomerPage();
		
		createUniqueCustomerNo2();
		
		user_Enters_MandatoryDetails2();
		
		
		SpecificL_Logic_Cust2();
		
		
		user_Adding_AllCustCutTime_Cust2();
		
		
		Save_Pending_Customer();
		
		AddAcquirer_To_Customer2();
		
		
		AddCardsTo_Customer2();
		
		BackTo_Customer();
		}
	}
	@And("^User Searching Customer2 for CPR and Change LOB$")
	public void user_Search_CPRCust2() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		//Click on Customer tab
		functions.clickAnElement("Customer_Tab", "Customer_Tab");
		//Enter Customer Number to search
		functions.enterText("Customer_NumberSearch", functions.getEnvironmentVariable("CustomerNumber2"));
		//Click on Search Button
		functions.waitForElementUsingPresence("Customer_ClickSearch");
		functions.clickAnElement("Customer_ClickSearch", "Search_Button");
		//Click Button Edit
		functions.clickAnElement("Customer_Edit_Button", "Edit");
		functions.waitForElementUsingPresence("Customer_Save_Button");
		// Enter Line Of Business
		functions.selectDropdown("Customer_LineOfBusiness","VisibleText", testData.get("Customer_UpdateLOB"));
				
	}
		}
	@And("^User Searching Customer Dynamically$")
	public void user_Search_CustDynamic() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		//Click on Customer tab
		functions.clickAnElement("Customer_Tab", "Customer_Tab");
		//Enter Customer Number to search
		functions.enterText("Customer_NumberSearch", functions.getEnvironmentVariable("CustomerNumber"));
		//Click on Search Button
		functions.waitForElementUsingPresence("Customer_ClickSearch");
		functions.clickAnElement("Customer_ClickSearch", "Search_Button");
		
	}
		}
}

	/*public void verifyDBCustValuesUS(String strDataFileName, String strReportFilename){

		String strCustomerNumber = Utilities.getEnvironmentVariable("DBCustomerNumber1");
		//String strCustomerNumber = Utilities.getEnvironmentVariable("SrchdCustomerNo1");
		String strCustomerName = Utilities.getEnvironmentVariable("CustomerName");
		//String strCustomerName = Utilities.getEnvironmentVariable("SrchdCustomerName");	

		String strQuery = null;
		// Verify VELOCITY And Refund Values
		//strQuery = "SELECT CREDIT_VELOCITY, PURCHASE_VELOCITY, REFUND_ALLOWED_PER_IND_BATCH, TOT_AMT_PER_IND_BATCH, USE_CUST_ADD_FOR_CONTACT FROM CUSTOMER_DETAILS WHERE CUSTOMER_NUMBER= '" + strCustomerNumber + "' and rownum=1";
		strQuery="SELECT cdv.credit_velocity,cdv.purchase_velocity,cdv.refund_allowed_per_ind_batch,cdv.tot_amt_per_ind_batch,decode(cdv.use_cust_add_for_contact, 'Y', 'Yes', 'N', 'No') use_cust_add_for_contact,cdv.customer_priority,cdv.cust_specific_logic_ind_desc,cty.business_term customer_type,decode(cdv.is_voice_authorizations, 'Y', 'Yes', 'N', 'No') is_voice_authorizations,clb.business_term line_of_business FROM customer_details_view cdv,data_dict_bus_terms   cty,data_dict_bus_terms   clb WHERE cdv.customer_type = cty.business_term_id AND cdv.line_of_business = clb.business_term_id AND customer_number = '" + strCustomerNumber + "' AND rownum = 1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFilename);

		// Verify Address
		strQuery = "SELECT ADDRESS1, ADDRESS2, CITY, STATE_NAME, POSTAL_CODE FROM customer_address_view WHERE customer_name = (SELECT customer_name FROM customer_details WHERE customer_number = '" + strCustomerNumber + "') and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues2", reporter, strReportFilename);

		// Verify Contact details
		strQuery = "SELECT PRIMARY_PHONE, CONTACT_NAME, EMAIL FROM customer_contact_view WHERE customer_name = (SELECT customer_name FROM customer_details WHERE customer_number = '" + strCustomerNumber + "') and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues3", reporter, strReportFilename);

		// Verify Cut time
		strQuery = "SELECT CUT_TIME_VALUE FROM customer_cut_time_view WHERE customer_name = (SELECT customer_name FROM customer_details WHERE customer_number = '" + strCustomerNumber + "') ";
		verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery, strDataFileName, "DBValues5", reporter, strReportFilename);

		// Verify Card types
		strQuery = "SELECT card_type_desc FROM cust_cardtype_view WHERE customer_number = '" + strCustomerNumber + "' order by card_type_desc";
		verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery, strDataFileName, "DBValues6", reporter, strReportFilename);

		// Verify Settlement
		strQuery = "SELECT ddbt.business_term Settlement FROM customer_cut_time_view cct, data_dict_bus_terms ddbt, customer_details cd WHERE cct.cut_time_option = ddbt.business_term_id AND cd.party_id = cct.customer_id AND cd.customer_number = '" + strCustomerNumber + "' AND cct.end_date IS NULL AND rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues7", reporter, strReportFilename);

		// Verify Processing level
		strQuery = " SELECT process_level_desc FROM cust_cardtype_view WHERE customer_number = '" + strCustomerNumber + "' and rownum=1 ";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues8", reporter, strReportFilename);

		// Verify Monetary destination
		strQuery = "SELECT destination_name FROM mon_dest_assignment_view WHERE customer_number = '" + strCustomerNumber + "' and rownum=1 ";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues9", reporter, strReportFilename);

		// Verify Non monetary destination
		strQuery = "SELECT non_mon_dest_name FROM non_mon_dest_assign_view WHERE customer_number = '" + strCustomerNumber + "' and rownum=1 ";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues10", reporter, strReportFilename);

		//Verify Use Customer Address 
		strQuery = "SELECT use_cust_add_for_contact FROM customer_details_view WHERE customer_number = '" + strCustomerNumber + "' and rownum=1  ";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues11", reporter, strReportFilename);

		//Verify Contact Phone 
		strQuery = "SELECT primary_phone contact_phone FROM customer_contact_view WHERE customer_name = '" +strCustomerName +"' AND contact_type_name = 'CUSTOMER' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues12", reporter, strReportFilename);

		//Verify Acquirer Account 
		strQuery = "SELECT acquirer_account_name FROM cust_acquirer_acc_view caa, customer_details cd WHERE cd.party_id = caa.customer_id AND cd.customer_number =  '" + strCustomerNumber + "' ";
		verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery, strDataFileName, "DBValues13", reporter, strReportFilename);

		// Verify Encryption Name
		strQuery = "SELECT ENCRYPTION_NAME FROM customer_encryption_view WHERE customer_name = (SELECT customer_name FROM customer_details WHERE customer_number = '" + strCustomerNumber + "') ";
		verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery, strDataFileName, "DBValues4", reporter, strReportFilename);

	}

	public void verifyDBCustValuesUSG2(String strDataFileName, String strReportFilename){

		stepExecutor.globalWait(60);
		String strCustomerNumber = Utilities.getEnvironmentVariable("DBCustomerNumber1");
		//String strCustomerNumber = Utilities.getEnvironmentVariable("SrchdCustomerNo1");
		String strCustomerName = Utilities.getEnvironmentVariable("CustomerName");
		//String strCustomerName = Utilities.getEnvironmentVariable("SrchdCustomerName");	

		String strQuery = null;

		// Verify VELOCITY And Refund Values,Bin blocking ,Customer priority
		strQuery="SELECT credit_velocity,purchase_velocity,max_refund_batch_count,max_refund_batch_amount,cust_priority,BIN_BLOCKING_IND FROM edc.edc_customer WHERE cust_nbr = '" + strCustomerNumber + "' AND rownum = 1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DB_VelocityAndRefund_BIN_Values", reporter, strReportFilename);

		//****************************** Moved to Merchant DB Validation steps  **************************************
		// Verify Line of Business ,Debit system reversal,Customer Specific Logic Ind
		strQuery="select ebm.LOB_IND,ebm.CUST_SPEC_LOGIC, ebm.DEBIT_SYSTEM_REV from EB_MERCHANT ebm , edc.edc_customer edc where edc.cust_nbr = edc.cust_nbr and edc.cust_nbr='" + strCustomerNumber + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DB_LOB_CustLogicInd_Values", reporter, strReportFilename);

		// Verify Card Types
		strQuery="select CARD_TYPE from EDC_CUST_CARDS where cust_nbr = '" + strCustomerNumber + "' order by CARD_TYPE";
		verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery, strDataFileName, "DB_CardType_Values", reporter, strReportFilename);

		// Verify SETTLE_ID for monetary destination
		strQuery="select  SETTLE_ID from EDC_CUST_CARDS where cust_nbr = '" + strCustomerNumber + "' and rownum = 1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DB_SETTLE_ID_Values", reporter, strReportFilename);
	}

	public void verifyDBCustValuesAP(String strDataFileName, String strReportFilename){

		String strCustomerNumber = Utilities.getEnvironmentVariable("DBCustomerNumber2");
		//String strCustomerNumber = Utilities.getEnvironmentVariable("APSrchdCustomerNo");
		String strCustomerName = Utilities.getEnvironmentVariable("CustomerName");
		//String strCustomerName = Utilities.getEnvironmentVariable("APSrchdCustomerName");	

		String strQuery = null;
		// Verify VELOCITY And Refund Values
		strQuery = "SELECT CREDIT_VELOCITY, PURCHASE_VELOCITY, REFUND_ALLOWED_PER_IND_BATCH, TOT_AMT_PER_IND_BATCH, USE_CUST_ADD_FOR_CONTACT FROM CUSTOMER_DETAILS WHERE CUSTOMER_NUMBER= '" + strCustomerNumber + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFilename);

		// Verify Address
		strQuery = "SELECT ADDRESS1, ADDRESS2, CITY, POSTAL_CODE FROM customer_address_view WHERE customer_name = (SELECT customer_name FROM customer_details WHERE customer_number = '" + strCustomerNumber + "') and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues2", reporter, strReportFilename);

		// Verify Contact details
		strQuery = "SELECT PRIMARY_PHONE, CONTACT_NAME, EMAIL FROM customer_contact_view WHERE customer_name = (SELECT customer_name FROM customer_details WHERE customer_number = '" + strCustomerNumber + "') and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues3", reporter, strReportFilename);

		// Verify Cut time
		strQuery = "SELECT CUT_TIME_VALUE FROM customer_cut_time_view WHERE customer_name = (SELECT customer_name FROM customer_details WHERE customer_number = '" + strCustomerNumber + "') ";
		verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery, strDataFileName, "DBValues5", reporter, strReportFilename);

		// Verify Card types
		strQuery = "SELECT card_type_desc FROM cust_cardtype_view WHERE customer_number = '" + strCustomerNumber + "' order by card_type_desc";
		verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery, strDataFileName, "DBValues6", reporter, strReportFilename);

		// Verify Settlement
		strQuery = "SELECT ddbt.business_term Settlement FROM customer_cut_time_view cct, data_dict_bus_terms ddbt, customer_details cd WHERE cct.cut_time_option = ddbt.business_term_id AND cd.party_id = cct.customer_id AND cd.customer_number = '" + strCustomerNumber + "' AND cct.end_date IS NULL AND rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues7", reporter, strReportFilename);

		// Verify Processing level
		strQuery = " SELECT process_level_desc FROM cust_cardtype_view WHERE customer_number = '" + strCustomerNumber + "' and rownum=1 ";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues8", reporter, strReportFilename);

		// Verify Monetary destination
		strQuery = "SELECT destination_name FROM mon_dest_assignment_view WHERE customer_number = '" + strCustomerNumber + "' and rownum=1 ";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues9", reporter, strReportFilename);

		// Verify Non monetary destination
		strQuery = "SELECT non_mon_dest_name FROM non_mon_dest_assign_view WHERE customer_number = '" + strCustomerNumber + "' and rownum=1 ";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues10", reporter, strReportFilename);

		//Verify Use Customer Address 
		strQuery = "SELECT use_cust_add_for_contact FROM customer_details_view WHERE customer_number = '" + strCustomerNumber + "' and rownum=1  ";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues11", reporter, strReportFilename);

		//Verify Contact Phone 
		strQuery = "SELECT primary_phone contact_phone FROM customer_contact_view WHERE customer_name = '" +strCustomerName +"' AND contact_type_name = 'CUSTOMER' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues12", reporter, strReportFilename);

		//Verify Acquirer Account 
		strQuery = "SELECT acquirer_account_name FROM cust_acquirer_acc_view caa, customer_details cd WHERE cd.party_id = caa.customer_id AND cd.customer_number =  '" + strCustomerNumber + "' ";
		verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery, strDataFileName, "DBValues13", reporter, strReportFilename);

		// Verify Encryption Name
		strQuery = "SELECT ENCRYPTION_NAME FROM customer_encryption_view WHERE customer_name = (SELECT customer_name FROM customer_details WHERE customer_number = '" + strCustomerNumber + "') ";
		verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery, strDataFileName, "DBValues4", reporter, strReportFilename);

	}
	
	public void verifyDBCustValuesAPG2(String strDataFileName, String strReportFilename){

		String strCustomerNumber = Utilities.getEnvironmentVariable("DBCustomerNumber2");
		//String strCustomerNumber = Utilities.getEnvironmentVariable("SrchdCustomerNo1");
		String strCustomerName = Utilities.getEnvironmentVariable("CustomerName");
		//String strCustomerName = Utilities.getEnvironmentVariable("SrchdCustomerName");	

		String strQuery = null;

		// Verify VELOCITY And Refund Values,Bin blocking ,Customer priority
		strQuery="SELECT credit_velocity,purchase_velocity,max_refund_batch_count,max_refund_batch_amount,cust_priority,BIN_BLOCKING_IND FROM edc.edc_customer WHERE cust_nbr = '" + strCustomerNumber + "' AND rownum = 1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DB_VelocityAndRefund_BIN_Values", reporter, strReportFilename);

		
		//***********  Below DB validation is moved to Merchat DB Vaslidation ****************************** 
		// Verify Line of Business ,Debit system reversal,Customer Specific Logic Ind
		strQuery="select ebm.LOB_IND,ebm.CUST_SPEC_LOGIC, ebm.DEBIT_SYSTEM_REV from EB_MERCHANT ebm , edc.edc_customer edc where edc.cust_nbr = edc.cust_nbr and edc.cust_nbr='" + strCustomerNumber + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DB_LOB_CustLogicInd_Values", reporter, strReportFilename);

		// Verify SETTLE_ID for monetary destination
		strQuery="select  SETTLE_ID from EDC_CUST_CARDS where cust_nbr = '" + strCustomerNumber + "' and rownum = 1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DB_SETTLE_ID_Values", reporter, strReportFilename);
		
		// Verify Card Types
		strQuery="select CARD_TYPE  from EDC_CUST_CARDS where cust_nbr = '" + strCustomerNumber + "' order by CARD_TYPE";
		verificationFunctions.verifyDatabaseRowValues("DBDetails", strQuery, strDataFileName, "DB_CardType_Values", reporter, strReportFilename);
	}
*/
	
	/*public void verifyCMFDB(String strDataFileName, String strReportFilename, String Entity,RemoteWebDriver webDriver)
	{
		stepExecutor.globalWait(20);
		//String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");
		String DateValue = webDriver.findElementByXPath("//tr[td[contains(text(),'Last Updated')]]/td[2]/input").getAttribute("value");
				
		String strQuery = "";
		//Verify processed flag in SSI_REPLICATION_MESSAGE
		strQuery = "select processed_flag from ssi_replication_message where ENTITY_TYPE = '"+Entity+"' and time_stamp >= to_date('"+DateValue+":00','mm/dd/yyyy hh24:mi:ss')";
		System.out.println("Query 1"+strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFilename);
		
		//Verify processed flag in SSI_REPLICATION_Items
		strQuery = "select processed_flag from ssi_replication_items where ENTITY_TYPE = '"+Entity+"' and time_stamp >= to_date('"+DateValue+":00','mm/dd/yyyy hh24:mi:ss')";
		System.out.println("Query 2"+strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFilename);
		
		//Verify Amex Retained Action in SSI_REPLICATION_Items
		String Customer_number = utils.getEnvironmentVariable("DBCustomerNumber1");
		strQuery = "select AX_Retained from customer_details where Customer_Number = '"+Customer_number+"'";
		System.out.println("Query 2"+strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues2", reporter, strReportFilename);
				
				
		//Verify Amex Retained Action in SSI_REPLICATION_Items
		String Customer_number1 = utils.getEnvironmentVariable("DBCustomerNumber1");
	
		strQuery = "select AX_Retained from merchant_details where Customer_Number = '"+Customer_number+"'";
		System.out.println("Query 2"+strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues2", reporter, strReportFilename);
	
	}
	public void verifyCMFDBValues(String strDataFileName, String strReportFilename, String Entity,RemoteWebDriver webDriver)
	{
		stepExecutor.globalWait(20);

		String strQuery = "";
		int rowNumber1 = executionRowNumber.getExecutionRowNumber(strDataFileName);
		//Verify Amex Retained Action in SSI_REPLICATION_Items
		String Customer_number = scriptExecutor.readDataFile(strDataFileName, rowNumber1, "customerNumber");
		strQuery = "select AX_Retained from customer_details where Customer_Number = '"+Customer_number+"'";
		System.out.println("Query 2"+strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsCMF", strQuery, strDataFileName, "DBValues11", reporter, strReportFilename);
		
	
		for (int j = 1; j <=5; j++) {
		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);
	
		String mercahntNum = scriptExecutor.readDataFile(strDataFileName, rowNumber, "mercahntNum"+j);
	
		strQuery = "select AX_RETAINED from merchant where global_merchant_number= '"+mercahntNum+"'";
		System.out.println("Query 2"+strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsCMF", strQuery, strDataFileName, "DBValues11", reporter, strReportFilename);
		
				}

		for (int j = 1; j <=5; j++) {
		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);
	
		String mercahntNum = scriptExecutor.readDataFile(strDataFileName, rowNumber, "mercahntNum"+j);
	
		strQuery = "select ax_retained from eb_merchant where global_merchant_id= '"+mercahntNum+"'";
		System.out.println("Query 2"+strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsEBA", strQuery, strDataFileName, "DBValues11", reporter, strReportFilename);
		
				}
		

		//verify EBA database AX retained value
		strQuery = "select AX_Retained from customer_details where Customer_Number = '"+Customer_number+"'";
		System.out.println("Query 2"+strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsEBA", strQuery, strDataFileName, "DBValues11", reporter, strReportFilename);
	

	}*/
	
	
	                            
		
	



/*else {
	functions.selectDropdownByVisibleText("Customer_processingLevel",testData.get("Customer_processingLevel"));
	
	functions.globalWait(8);
	
	String winhandleBefore = webDriver.getWindowHandle();
	
	functions.clickAnElement("Customer_Card_Monetary_Search", "MonDest Search");
	functions.globalWait(10);
	
	functions.switchToNewWindow();
	if(webDriver.findElementsById("overridelink").size()!=0)
	{
		System.out.println("Clicking Certificate link");
		webDriver.findElementById("overridelink").click();
		functions.globalWait(5);
	}*/
	
	
















