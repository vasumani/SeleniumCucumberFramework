package com.webapp.stepDefinition;

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
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CMF_BigBatchCreation extends ExecutionerClass{

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

	@When("^User navigates to Bigbatch Page$")
	public void user_Navigates_to_Bigbatch() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			//Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			//Click on Bigbatch tab
			functions.clickAnElement("Bigbatch_Tab", "Bigbatch_Tab");
			functions.waitForElementUsingVisibility("Bigbatch_Search");
			}
			}
	@When("^User navigates to Add Bigbatch Page$")
	public void user_Navigates_to_AddBigbatch() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			//Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			//Click on Bigbatch tab
			functions.clickAnElement("Bigbatch_Tab", "Bigbatch_Tab");
			//Click on Add Bigbatch tab
			functions.clickAnElement("Bigbatch_AddBigBatch", "Bigbatch_AddBigBatch");
			}
		}
	@And("^User search for existing Bigbatch$")
	public void user_Search_Bigbatch() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			//Enter Bigbatch name
			functions.enterText("Bigbatch_Name_search", testData.get("Bigbatch_Name_search"));
			//Click on Search button
			functions.clickAnElement("Bigbatch_searchButton", "Bigbatch_searchButton");
			//Click on search result
			functions.clickAnElement("Bigbatch_Searchresult", "Bigbatch_Searchresult");
			
			}
			}
	@And("^User Create Unique Bigbatch name$")
	public void user_Create_UniqueBigbatchname() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			Random ran = new Random(System.currentTimeMillis());
			int x = (int)(Math.random()) + Math.abs(ran.nextInt());
			String strBigBatchName = "Sample BigBatch_4";
			String strBigBatchName1 = Integer.toString(x).substring(2, 6);
			strBigBatchName = strBigBatchName.concat(strBigBatchName1);
			functions.setEnvironmentVariable("strBigBatchName", strBigBatchName);
			functions.globalWait(2);
			// Enter Big Batch Name
			functions.enterText("Bigbatch_name", strBigBatchName);
			}
			}
	@And("^User Create Unique BigBatchID$")
	public void user_Create_UniqueBigBatchID() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			Random ran = new Random(System.currentTimeMillis());
			int x = (int)(Math.random()) + Math.abs(ran.nextInt()) + (int)(Math.random());
			String strBigBatchID = "5";
			String strBigBatchID1=Integer.toString(x).substring(2, 5);
			strBigBatchID = strBigBatchID.concat(strBigBatchID1);
			functions.setEnvironmentVariable("BigbatchID", strBigBatchID);
			functions.globalWait(2);
			// Enter Big Batch Name
			functions.enterText("Bigbatch_ID", strBigBatchID);
			}
		}
	

	//Enter all common details
	@And("^User Enter BigBatch Common Details$")
	public void user_enterBigBatchCommonDetails() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			//enter Contact Name
			functions.enterText("Bigbatch_primaryContactName", testData.get("Bigbatch_primaryContactName"));
			//enter Contact Phone
			functions.enterText("Bigbatch_primaryContactPhone", testData.get("Bigbatch_primaryContactPhone"));
			//enter Contact Email
			functions.enterText("Bigbatch_primaryContactEmail", testData.get("Bigbatch_primaryContactEmail"));
			//enter Notification Email
			functions.enterText("Bigbatch_notificationEmail", testData.get("Bigbatch_notificationEmail"));
			//enter Notification Email CC1
			functions.enterText("Bigbatch_notificationEmailCC1", testData.get("Bigbatch_notificationEmailCC1"));
			//enter Internal notification Email
			functions.enterText("Bigbatch_internalNotificationEmail", testData.get("Bigbatch_internalNotificationEmail"));
			//enter Datatrans Directory 
			functions.enterText("Bigbatch_dataTransDirectory", testData.get("Bigbatch_dataTransDirectory"));
			//enter Datatrans AP Batch Report Directory
			functions.enterText("Bigbatch_dataTransAPBatchReportDirectory", testData.get("Bigbatch_dataTransAPBatchReportDirectory"));
			//enter Datatrans File Name
			user_Create_UniqueDatatransFile();
			//enter Account Inquiry Customer Response File Datatrans Dir
			functions.enterText("Bigbatch_custRespFDDirectory", testData.get("Bigbatch_custRespFDDirectory"));
			//enter Account Inquiry Customer Response File Name
			user_Create_UniqueAccountDatatransFile();
			//enter Visa Account Inquiry Card Associations Request File Datatrans Dir
			functions.enterText("Bigbatch_cardAssReqFDDirectory", testData.get("Bigbatch_cardAssReqFDDirectory"));
			//enter Visa Account Inquiry Card Association Request File Datatrans File Name
			user_Create_UniqueVisaDatatransFile();
			//enter MC Account Inquiry Card Assc Req file Data Tran dir
			functions.enterText("Bigbatch_cardAssRespFDDirectory", testData.get("Bigbatch_cardAssRespFDDirectory"));
			//enter MC Account Inquiry Card Assc Req file Data Tran file name
			user_Create_UniqueMasterDatatransFile();
			//enter DISC Account Inquiry Card Associations Request File Datatrans Dir
			functions.enterText("Bigbatch_discCardAssReqFDDirectory", testData.get("Bigbatch_discCardAssReqFDDirectory"));
			//enter Disc Account Inquiry Card Association Request File Datatrans File Name
			user_Create_UniqueDiscoverDatatransFileName();
			//enter Card number Masking
			functions.selectDropdownByVisibleText("Bigbatch_cardNumberMasking", testData.get("Bigbatch_cardNumberMasking"));
			//enter Processing Option
			functions.selectDropdownByVisibleText("Bigbatch_processingOption", testData.get("Bigbatch_processingOption"));
			//enter Destiantion Endpoint
			functions.selectDropdownByVisibleText("Bigbatch_destinationEndPoint", testData.get("Bigbatch_destinationEndPoint"));
			//enter transmission Method
			functions.selectDropdownByVisibleText("Bigbatch_transmissionMethod", testData.get("Bigbatch_transmissionMethod"));
			//enter Reject Level
			functions.selectDropdownByVisibleText("Bigbatch_rejectLevel", testData.get("Bigbatch_rejectLevel"));
			//enter Account Updater Pro
			functions.changeRadioButtonOrCheckBoxStatus("Bigbatch_VisaCheckBox", testData.get("Bigbatch_Visa_Checkbox"));
			functions.changeRadioButtonOrCheckBoxStatus("Bigbatch_MasterCardCheckBox", testData.get("Bigbatch_MC_Checkbox"));
			functions.changeRadioButtonOrCheckBoxStatus("Bigbatch_DiscoverCheckBox", testData.get("Bigbatch_Dis_Checkbox"));
			//enter Replay Threshold
			functions.selectDropdownByVisibleText("Bigbatch_replayThreshold", testData.get("Bigbatch_replayThreshold"));
			//enter Markets Certified
			functions.selectDropdownByVisibleText("Bigbatch_marketsCertified", testData.get("Bigbatch_marketsCertified"));
			//enter Duplicate Da te / time
			functions.selectDropdownByVisibleText("Bigbatch_dateTimeDuplicateCheck", testData.get("Bigbatch_dateTimeDuplicateCheck"));
			//enter Duplicate Seq Numbr
			functions.selectDropdownByVisibleText("Bigbatch_sequenceNoDuplicateCheck", testData.get("Bigbatch_sequenceNoDuplicateCheck"));
			//enter Response File Ind
			functions.selectDropdownByVisibleText("Bigbatch_responseFileRequired", testData.get("Bigbatch_responseFileRequired"));
			//enter Replay referrals
			functions.selectDropdownByVisibleText("Bigbatch_replayReferral", testData.get("Bigbatch_replayReferral"));
			//enter Message Spec
			functions.selectDropdownByVisibleText("Bigbatch_messageSpecIndicator", testData.get("Bigbatch_messageSpecIndicator"));
			}
		}
	//Click Save btn and verify success msg
	@Then("^User Click on Save Button$")
	public void user_Click_Save() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			//Click Save
			functions.clickAnElement("Bigbatch_SaveButton", "SaveButton");
			functions.globalWait(5);
			//verify success Message
			functions.verifyElementTextContains("Bigbatch_SuccessMsg", testData.get("Bigbatch_SuccessMsg"));
			}
		}
	@And("^Select Log Submission Record$")
	public void user_Select_LogSubmission() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			// Select Log Submission Record
			functions.selectDropdownByVisibleText("Bigbatch_LogSubmissionSelect", testData.get("Bigbatch_LogSubmissionSelect"));
			}
		}
	@And("^User Create Unique DatatransFile$")
	public void user_Create_UniqueDatatransFile() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			Random ran = new Random(System.currentTimeMillis());
			int x = (int)(Math.random() * 99) + Math.abs(ran.nextInt());
			String strDatatransFileName = "SAMPLE_BB1234";
			strDatatransFileName = strDatatransFileName.concat(Integer.toString(x));

			functions.setEnvironmentVariable("DatatransFileName", strDatatransFileName);

			functions.globalWait(2);
			// Enter Big Batch Name
			functions.enterText("Bigbatch_dataTransFileName", strDatatransFileName);
			}
		}
	//Create unique Account Datatrans File Name 
	@And("^User Create Unique Account Datatrans File Name$")
	public void user_Create_UniqueAccountDatatransFile() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			Random ran = new Random(System.currentTimeMillis());
			int x = (int)(Math.random() * 99) + Math.abs(ran.nextInt());
			String strDatatransFileName = "SAMPLE_BB1234_01";
			strDatatransFileName = strDatatransFileName.concat(Integer.toString(x));
			functions.setEnvironmentVariable("AccDatatransFileName", strDatatransFileName);

			functions.globalWait(2);
			// Enter Big Batch Name
			functions.enterText("Bigbatch_custRespFDFilename", strDatatransFileName);
			}
		}
	

	//Create unique Visa Datatrans File Name 
	@And("^User Create Unique Account VisaDatatransFile$")
	public void user_Create_UniqueVisaDatatransFile() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			Random ran = new Random(System.currentTimeMillis());
			int x = (int)(Math.random() * 99) + Math.abs(ran.nextInt());
			String strDatatransFileName = "SAMPLE_BB1234_02";
			strDatatransFileName = strDatatransFileName.concat(Integer.toString(x));
			functions.setEnvironmentVariable("VisaDatatransFileName", strDatatransFileName);

			functions.globalWait(2);
			// Enter Big Batch Name
			functions.enterText("Bigbatch_cardAssReqFDFilename", strDatatransFileName);
			}
		}

	//Create unique Master Datatrans File Name 
	@And("^User Create Unique Master DatatransFile$")
	public void user_Create_UniqueMasterDatatransFile() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			Random ran = new Random(System.currentTimeMillis());
			int x = (int)(Math.random() * 99) + Math.abs(ran.nextInt());
			String strDatatransFileName = "SAMPLE_BB1234_03";
			strDatatransFileName = strDatatransFileName.concat(Integer.toString(x));
			functions.setEnvironmentVariable("MasterDatatransFileName", strDatatransFileName);

			functions.globalWait(2);
			// Enter Big Batch Name
			functions.enterText("Bigbatch_cardAssRespFDFilename", strDatatransFileName);
			}
		}

	//Create unique Discover  Datatrans File Name 	
	@And("^User Create Unique Discover Datatrans File Name$")
	public void user_Create_UniqueDiscoverDatatransFileName() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			Random ran = new Random(System.currentTimeMillis());
			int x = (int)(Math.random() * 99) + Math.abs(ran.nextInt());
			String strDatatransFileName = "SAMPLE_BB1234_03";
			strDatatransFileName = strDatatransFileName.concat(Integer.toString(x));
			functions.setEnvironmentVariable("DiscoverDatatransFileName", strDatatransFileName);

			functions.globalWait(2);
		
			functions.enterText("Bigbatch_discCardAssReqFDFilename", strDatatransFileName);
			}
		}
	@And("^User Edit Big Batch$")
	public void user_Edit_Bigbatch() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Bigbatch_Edit", "Bigbatch_Edit");
			functions.waitForElementUsingVisibility("Bigbatch_SaveButton");
		}
	}
	@Then("^User Click on Save Button to Update$")
	public void user_Click_Save_To_Update() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			//Click Save
			functions.clickAnElement("Bigbatch_SaveButton", "SaveButton");
			functions.globalWait(5);
			//verify success Message
			functions.verifyElementTextContains("Bigbatch_SuccessUpdateMsg", testData.get("Bigbatch_SuccessUpdateMsg"));
			}
		}
	@And("^User change Log submission$")
	public void user_Change_LogSubmission() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			//functions.verifyElementPresentWithReport("Bigbatch_LogSubmission");
			functions.selectDropdownByVisibleText("Bigbatch_LogSubmissionSelect", testData.get("Bigbatch_LogSubmissionSelect"));
		}
	}
	
	//*******************************************************************************************/
	//********************************DB Validations*********************************************/
	//*******************************************************************************************/
	
	@Then("^User Validating Bigbatch CMF Database Region \"([^\"]*)\"$")
	public void CMF_DB_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.CMFDatabase(Region);
		String Bigbatch=functions.getEnvironmentVariable("strBigBatchName");
		String query=testData.get("Bigbatch_CMF_Query1")+Bigbatch+"'";
		functions.globalWait(65);
		functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("Bigbatch_CMF_DBExpected"));
		}
	}
	@Then("^User Validating Bigbatch G2 Database Region \"([^\"]*)\"$")
	public void G2DB_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.G2Database(Region);
		String Bigbatch=functions.getEnvironmentVariable("strBigBatchName");
		String query=testData.get("Bigbatch_G2_Query1")+Bigbatch+"'";
		functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("Bigbatch_G2_DBExpected"));
		}
	}
	@Then("^User Validating Bigbatch CMF Database Multiple values \"([^\"]*)\"$")
	public void CMF_DB_Multiple_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.CMFDatabase(Region);
		String Bigbatch=functions.getEnvironmentVariable("strBigBatchName");
		String[] CMFDBExpected=testData.get("Bigbatch_CMF_DBExpected").split("@@");
		functions.globalWait(65);
		for(int i=1;i<=CMFDBExpected.length;i++)
		{
		String query=testData.get("Bigbatch_CMF_Query"+i)+Bigbatch+"'";
			
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, CMFDBExpected[i]);
		}
		}
	}
	@Then("^User Validating Bigbatch G2 Database Multiple values \"([^\"]*)\"$")
	public void G2DB_Multiple_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.G2Database(Region);
		String Bigbatch=functions.getEnvironmentVariable("strBigBatchName");
		String[] G2DBExpected=testData.get("Bigbatch_G2_DBExpected").split("@@");
		functions.globalWait(65);
		for(int i=1;i<=G2DBExpected.length;i++)
		{
		String query=testData.get("Bigbatch_G2_Query"+i)+Bigbatch+"'";
			
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, G2DBExpected[i]);
		}
		}
	}
/*	//CMF data validation query
	public void verifyDBBigBatchCMF1(String strDataFileName, String strReportFilename) throws IOException{
		String strBigBatchName = Utilities.getEnvironmentVariable("BigBatchName1");

		String strQuery = null;
		//Verify data Markets Certified, 
		strQuery = "SELECT markets_certified_desc markets_certified FROM cmf.big_batch_market_view WHERE big_batch_id = (SELECT big_batch_id FROM big_batch_setup_view WHERE NAME = '" + strBigBatchName + "') and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetailsCMF", strQuery, strDataFileName, "DBValuesMarketCert", reporter, strReportFilename);

		//Verify data  Processing Option Destination Endpoint,transmission Method,Account Updater Pro,Replay Threshold,Duplciate Da te / time,Duplicate Seq Numbr,Response File Ind, Replay referrals, Message Spec
		strQuery = "SELECT bsv.card_number_masking_desc card_number_masking,ddbpo.business_term processing_option,bsv.destination_endpoint_desc destination_endpoint,bsv.transmission_method_desc transmission_method,bsv.accounter_updater_programs,bsv.replay_threshold,decode(bsv.is_duplicate_date_time, 'Y', 'Yes', 'N', 'No') is_duplicate_date_time,decode(bsv.is_duplicate_sequence_number, 'Y', 'Yes', 'N', 'No') is_duplicate_sequence_number,ddrf.business_term is_response_file,decode(bsv.is_replay_referral, 'Y', 'Yes', 'N', 'No') is_replay_referral,bsv.message_spec_ind_desc message_spec_ind FROM cmf.big_batch_setup_view bsv,data_dict_bus_terms ddbpo,data_dict_bus_terms ddrf WHERE NAME = '" + strBigBatchName + "' AND bsv.processing_option = ddbpo.business_term_id AND bsv.is_response_file = ddrf.business_term_id and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetailsCMF", strQuery, strDataFileName, "DBValuesBigbatchCMF", reporter, strReportFilename);

		//Verify Data Reject Level
		strQuery =  "SELECT business_term FROM cmf.data_dict_bus_terms WHERE business_term_id IN (SELECT big_batch_reject_level FROM big_batch_setup WHERE NAME = '" + strBigBatchName + "') and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetailsCMF", strQuery, strDataFileName, "DBValuesRejectLvl", reporter, strReportFilename);
	}
	
	//G2 data validation query
	public void verifyDBBigBatchG2(String strDataFileName, String strReportFilename) throws IOException{
		String strBigBatchName = Utilities.getEnvironmentVariable("BigBatchName1");

		String strQuery = null;
		//Verify data Card number Masking,Processing Option,Destiantion Endpoint,transmission Method,Replay referrals,Message Spec
		//Reject Level,Account Updater Pro,Replay Threshold,Markets Certified,Duplciate Da te / time,Duplicate Seq Numbr,Response File Ind
 
		strQuery = "Select RESP_FILE_REDACT,PROC_OPTION,DEST_ENDPOINT,TRANS_METHOD,AUTO_ACCT_UPDATES,NUM_REPLAY,RESP_FILE_REDACT,DUP_CHECK_DATE,DUP_CHECK_SEQ,REPLAY_REF,BATCH_MSG_SPEC_IND from eba.BIG_BATCH_CUST WHERE BB_USER_NAME = '" + strBigBatchName + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "DBValuesG2Bigbatch", reporter, strReportFilename);

	}

	//Modify Data
	public void modifyBigBatchCommonDetails(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter,String strReportFilename,String strRegion){

		//click link edit
		stepExecutor.clickButton("findElementByXPath", "//input[@value='Edit']", "Edit", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(15);
		stepExecutor.waitForElementToDisplay("findElementByXPath", "(//input[@value='Save'])[1]", webDriver, reporter, strReportFilename);
		
		//enter Card number Masking
		stepExecutor.selectListValue("findElementById", "cardNumberMasking", strDataFileName, "Listbox_cardNumberMasking", webDriver, reporter, strReportFilename);
		//enter Processing Option
		stepExecutor.selectListValue("findElementById", "processingOption", strDataFileName, "Listbox_processingOption", webDriver, reporter, strReportFilename);
		//enter Destination Endpoint
		stepExecutor.selectListValue("findElementById", "destinationEndPoint", strDataFileName, "Listbox_destEndPoint", webDriver, reporter, strReportFilename);
		//enter transmission Method
		stepExecutor.selectListValue("findElementById", "transmissionMethod", strDataFileName, "Listbox_transmissionMethod", webDriver, reporter, strReportFilename);
		//enter Reject Level
		stepExecutor.selectListValue("findElementById", "rejectLevel", strDataFileName, "Listbox_rejectLevel", webDriver, reporter, strReportFilename);
		//enter Account Updater Pro
		stepExecutor.changeCheckboxStatus("findElementByXpath", "//table[@id='overview']/tbody/tr[27]/td[2]/span[2]/input", "Visa", strDataFileName, "Checkbox_Visa", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXpath", "//table[@id='overview']/tbody/tr[27]/td[2]/span[3]/input", "Visa", strDataFileName, "Checkbox_Mastercard", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXpath", "//table[@id='overview']/tbody/tr[27]/td[2]/span[4]/input", "Visa", strDataFileName, "Checkbox_Discover", webDriver, reporter, strReportFilename);

		//enter Replay Threshold
		stepExecutor.selectListValue("findElementById", "replayThreshold", strDataFileName, "Listbox_replayThreshold", webDriver, reporter, strReportFilename);
		//enter Markets Certified
		stepExecutor.globalWait(3);
		Select select = new Select(webDriver.findElementById("marketsCertified"));
		select.deselectAll();
		stepExecutor.selectListValue("findElementById", "marketsCertified", strDataFileName, "Listbox_marketsCertified", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(5);
		//enter Duplicate Da te / time
		stepExecutor.selectListValue("findElementById", "dateTimeDuplicateCheck", strDataFileName, "Listbox_DuplicatedateTime", webDriver, reporter, strReportFilename);
		//enter Duplicate Seq Numbr
		stepExecutor.selectListValue("findElementById", "sequenceNoDuplicateCheck", strDataFileName, "Listbox_DuplicateSeqNum", webDriver, reporter, strReportFilename);
		//enter Response File Ind
		stepExecutor.selectListValue("findElementById", "responseFileRequired", strDataFileName, "Listbox_responseFileInd", webDriver, reporter, strReportFilename);
		//enter Replay referrals
		stepExecutor.selectListValue("findElementById", "replayReferral", strDataFileName, "Listbox_replayReferral", webDriver, reporter, strReportFilename);
		//enter Message Spec
		stepExecutor.selectListValue("findElementById", "messageSpecIndicator", strDataFileName, "Listbox_messageSpec", webDriver, reporter, strReportFilename);

		//Click Save
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Save'])[1]", "Save", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(15);

		//verify success Message
		stepExecutor.waitForElementToDisplay("findElementByXPath", "//span[contains(text(),'Big Batch record successfully updated.')]", webDriver, reporter, strReportFilename);
		verificationFunctions.verifyElementTextPresent(webDriver, "//span[contains(text(),'Big Batch record successfully updated.')]", "xpath", strDataFileName, "Msg_BigBatch_Sucess", reporter, strReportFilename);
	}
*/

}






