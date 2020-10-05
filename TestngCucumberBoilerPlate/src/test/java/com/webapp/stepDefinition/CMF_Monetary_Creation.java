package com.webapp.stepDefinition;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Map;
import java.util.Random;
import org.openqa.selenium.By;
import com.webapp.baseLibrary.FunctionsLibrary;
import com.webapp.executioner.ExecutionerClass;
import com.webapp.page.ReusableFunctions;
import com.webapp.utilities.GridReporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CMF_Monetary_Creation extends ExecutionerClass {

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


	@When("^User navigates to Add Monetary Destination Page$")
	public void user_Navigates_to_AddCustomerPage(String AddCustpage) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		//Click on Customer tab
		functions.clickAnElement("Customer_Tab", "Customer_Tab");
		//Click on MonetaryDest tab
		functions.clickAnElement("MonetaryDest_Monetaryclicktab", "MonetaryDest_Monetaryclicktab");
		//Click on Add MonetaryDest tab
		functions.clickAnElement("MonetartyDest_AddMonetary", "MonetartyDest_AddMonetary");
	}
	}
	@When("^User search and open MonDest$")
	public void user_search_And_open_Mondest(String search)
	{
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//nacigate to customer page
		functions.clickAnElement("Customer_Tab", "Customer_Tab");
		// Verify Monetary Destination  is present
		functions.clickAnElement("MonetaryDest_Monetaryclicktab", "MonetaryDest_Monetaryclicktab");
		functions.enterText("Monetary_MonNameSearch", testData.get("Monetary_MonNameSearch"));
		functions.clickAnElement("Monetary_SearchClick", "Monetary_SearchClick");
		functions.clickAnElement("Monetary_ListFieilds", "Monetary_ListFieilds");
	}
	}
	@And("^User creates unique Mondest name$")
	public void user_creates_unique_mondestname(String MonName)
	{
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		Random ran = new Random(System.currentTimeMillis());
		int x = (int)(Math.random() * 999) + Math.abs(ran.nextInt());
		String strMonName = "Mondest_91";
		strMonName=strMonName.concat(Integer.toString(x));
		functions.setEnvironmentVariable(MonName, strMonName);
		functions.enterText("Monetary_DestName", MonName);
		functions.globalWait(8);
		}
	}
	@And("^User creates unique DataTransFile name$")
	public void user_creates_unique_transfilename(String filename, String strDataTransFile)
	{
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		Random ran = new Random(System.currentTimeMillis());
		int x = (int)(Math.random() * 999) + Math.abs(ran.nextInt());
		String strfileName = strDataTransFile;
		strfileName=strfileName.concat(Integer.toString(x));
		functions.setEnvironmentVariable(filename, strfileName);
		functions.enterText("Monetary_dataFilName", filename);
		}
	}
	
	@And("^User fills the datafile Amex Details$")
	
	public void user_fills_datafile_Amex_details(String Details)
	{
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.selectDropdownByVisibleText("Monetary_fileformatspcId", testData.get("Monetary_fileformatspcId"));
		functions.enterText("Monetary_dataTransDirectory", testData.get("Monetary_dataTransDirectory"));
		functions.selectDropdownByVisibleText("Monetary_destinationEndPoint", testData.get("Monetary_destinationEndPoint"));
		functions.selectDropdownByVisibleText("Monetary_transmissionMethod", testData.get("Monetary_transmissionMethod"));
		functions.enterText("Monetary_fileHeaderText", testData.get("Monetary_fileHeaderText"));
		functions.VerifyDropDownListValues("Monetary_emptyFileGenId", testData.get("Monetary_emptyFileGenId"));
		functions.selectDropdownByVisibleText("Monetary_depositDate", testData.get("Monetary_depositDate"));
		functions.enterText("Monetary_amexSubId", testData.get("Monetary_amexSubId"));
		functions.enterText("Monetary_referenceNo", testData.get("Monetary_referenceNo"));
		}	
	}
	
	@And("^User fills the datafile Discover Details$")
	public void user_fills_datafile_Discover_details(String Details)
	{
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.selectDropdownByVisibleText("Monetary_fileformatspcId", testData.get("Monetary_fileformatspcId"));
		functions.enterText("Monetary_dataTransDirectory", testData.get("Monetary_dataTransDirectory"));
		functions.selectDropdownByVisibleText("Monetary_destinationEndPoint", testData.get("Monetary_destinationEndPoint"));
		functions.selectDropdownByVisibleText("Monetary_transmissionMethod", testData.get("Monetary_transmissionMethod"));
		functions.enterText("Monetary_fileHeaderText", testData.get("Monetary_fileHeaderText"));
		functions.VerifyDropDownListValues("Monetary_emptyFileGenId", testData.get("Monetary_emptyFileGenId"));
		functions.selectDropdownByVisibleText("Monetary_depositDate", testData.get("Monetary_depositDate"));
		functions.enterText("Monetary_discoverClientId", testData.get("Monetary_discoverClientId"));
		functions.enterText("Monetary_referenceNo", testData.get("Monetary_referenceNo"));
		functions.enterText("Monetary_discoverClientPrefix", testData.get("Monetary_discoverClientPrefix"));
	}
	}
	
@And("^User fills the datafile  Details$")
	public void user_fills_datafile_details(String Details)
	{
	if(CommonStepDefinitions.executeScenario()){
		if(!CommonStepDefinitions.exescenario)
			return;
		functions.selectDropdownByVisibleText("Monetary_fileformatspcId", testData.get("Monetary_fileformatspcId"));
		functions.enterText("Monetary_dataTransDirectory", testData.get("Monetary_dataTransDirectory"));
		functions.selectDropdownByVisibleText("Monetary_destinationEndPoint", testData.get("Monetary_destinationEndPoint"));
		functions.selectDropdownByVisibleText("Monetary_transmissionMethod", testData.get("Monetary_transmissionMethod"));
		functions.enterText("Monetary_fileHeaderText", testData.get("Monetary_fileHeaderText"));
		functions.VerifyDropDownListValues("Monetary_emptyFileGenId", testData.get("Monetary_emptyFileGenId"));
		functions.selectDropdownByVisibleText("Monetary_depositDate", testData.get("Monetary_depositDate"));
		functions.enterText("Monetary_recordSource", testData.get("Monetary_recordSource"));
		functions.enterText("Monetary_sourceId", testData.get("Monetary_sourceId"));
		functions.enterText("Monetary_corporateId", testData.get("Monetary_corporateId"));
		functions.enterText("Monetary_scanCharge", testData.get("Monetary_scanCharge"));
		functions.enterText("Monetary_referenceNo", testData.get("Monetary_referenceNo"));
	}
	}
	

@And("^User fills the datafile full  Details$")
public void user_fills_datafile_fulldetails(String Details)
{
	if(CommonStepDefinitions.executeScenario()){
		if(!CommonStepDefinitions.exescenario)
			return;
	functions.selectDropdownByVisibleText("Monetary_fileformatspcId", testData.get("Monetary_fileformatspcId"));
	functions.selectDropdownByVisibleText("Monetary_layout", testData.get("Monetary_layout"));
	functions.enterText("Monetary_dataTransDirectory", testData.get("Monetary_dataTransDirectory"));
	functions.selectDropdownByVisibleText("Monetary_destinationEndPoint", testData.get("Monetary_destinationEndPoint"));
	functions.selectDropdownByVisibleText("Monetary_transmissionMethod", testData.get("Monetary_transmissionMethod"));
	functions.enterText("Monetary_fileHeaderText", testData.get("Monetary_fileHeaderText"));
	functions.VerifyDropDownListValues("Monetary_emptyFileGenId", testData.get("Monetary_emptyFileGenId"));
	functions.selectDropdownByVisibleText("Monetary_retrievalNumber", testData.get("Monetary_retrievalNumber"));
	functions.selectDropdownByVisibleText("Monetary_depositDate", testData.get("Monetary_depositDate"));
	functions.enterText("Monetary_recordSource", testData.get("Monetary_recordSource"));
	functions.enterText("Monetary_sourceId", testData.get("Monetary_sourceId"));
	functions.enterText("Monetary_amexSubId", testData.get("Monetary_amexSubId"));
	functions.enterText("Monetary_discoverClientId", testData.get("Monetary_discoverClientId"));
	functions.enterText("Monetary_originatorName", testData.get("Monetary_originatorName"));
	functions.enterText("Monetary_destDataCenter", testData.get("Monetary_destDataCenter"));
	functions.enterText("Monetary_corporateId", testData.get("Monetary_corporateId"));
	functions.enterText("Monetary_scanCharge", testData.get("Monetary_scanCharge"));
	functions.enterText("Monetary_edsMultiCurrDest", testData.get("Monetary_edsMultiCurrDest"));
	functions.enterText("Monetary_referenceNo", testData.get("Monetary_referenceNo"));
	functions.enterText("Monetary_discoverClientPrefix", testData.get("Monetary_discoverClientPrefix"));

}
}


@And("^User fills the Exception  Details$")
public void user_fills_Exception_details(String Details)
{
	if(CommonStepDefinitions.executeScenario()){
		if(!CommonStepDefinitions.exescenario)
			return;
	functions.selectDropdownByVisibleText("Monetary_Exceptionday1", testData.get("Monetary_Exceptionday1"));
	functions.selectDropdownByVisibleText("Monetary_Excepday1opt", testData.get("Monetary_Excepday1opt"));
	functions.selectDropdownByVisibleText("Monetary_Excepday1transopt", testData.get("Monetary_Excepday1transopt"));
	functions.selectDropdownByVisibleText("Monetary_Exceptionday2", testData.get("Monetary_Exceptionday2"));
	functions.selectDropdownByVisibleText("Monetary_Excepday2opt", testData.get("Monetary_Excepday2opt"));
	functions.selectDropdownByVisibleText("Monetary_Excepday2transopt", testData.get("Monetary_Excepday2transopt"));
	}
}


@And("^User fills the holiday  Details$")
public void user_fills_holiday_details(String Details, String strCreateOption)
{
	if(CommonStepDefinitions.executeScenario()){
		if(!CommonStepDefinitions.exescenario)
			return;
	functions.selectDropdownByVisibleText("Monetary_holidayCreateOpts", testData.get("Monetary_holidayCreateOpts"));
	if(strCreateOption.equalsIgnoreCase("Create the File"))
	{
		functions.waitForElementUsingPresence("Monetary_holidayTransOptsId");
		functions.selectDropdownByVisibleText("Monetary_holidayTransOptsId", testData.get("Monetary_holidayTransOptsId"));
	}
	else if(strCreateOption.equalsIgnoreCase("Do not Create the File"))
	{
		functions.VerifyDropDownListValues("Monetary_holidayTransOptsId", testData.get("Monetary_holidayTransOptsId"));
	}
	}
}
	@And("^User assign card types$")
	public void user_assign_cardTypes(String cards, String strcardTypes)
	{
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		String[] CardTypes=testData.get("Monetary_CardTypes").split("@@");
		for(int i=0; i<CardTypes.length;i++){
			//Select Card Types
			functions.selectDropdownByVisibleText("Monetary_availableCardTypes", CardTypes[i]);
			//Click Button
			functions.clickAnElement("Monetary_selectbutton", "Monetary_selectbutton");
		}
		}
	}
	
	@And("^User add All  FileCutTimes$")
	public void user_add_All_FileCutTimes(String CutTimes)
	{
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.selectDropdownByVisibleText("Monetary_fileCutTime1", testData.get("Monetary_fileCutTime1"));
		functions.selectDropdownByVisibleText("Monetary_fileCutTime2", testData.get("Monetary_fileCutTime2"));
		functions.selectDropdownByVisibleText("Monetary_fileCutTime3", testData.get("Monetary_fileCutTime3"));
		functions.selectDropdownByVisibleText("Monetary_fileCutTime4", testData.get("Monetary_fileCutTime4"));
		functions.selectDropdownByVisibleText("Monetary_fileCutTime5", testData.get("Monetary_fileCutTime5"));
		functions.selectDropdownByVisibleText("Monetary_fileCutTime6", testData.get("Monetary_fileCutTime6"));
		functions.clickAnElement("Monetary_AddCutTime", "Monetary_AddCutTime");
	}
	}
	@And("^User add 3 FileCutTimes$")
	public void user_add_3FileCutTimes(String CutTimes)
	{
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.selectDropdownByVisibleText("Monetary_fileCutTime1", testData.get("Monetary_fileCutTime1"));
		functions.selectDropdownByVisibleText("Monetary_fileCutTime2", testData.get("Monetary_fileCutTime2"));
		functions.selectDropdownByVisibleText("Monetary_fileCutTime3", testData.get("Monetary_fileCutTime3"));
		functions.clickAnElement("Monetary_AddCutTime", "Monetary_AddCutTime");
	}
	}
	
	@And("^User add RecordTypes$")
	public void user_add_RecordTypes(String Types)
	{
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.clickAnElement("Monetary_SelectRecordButton", "Monetary_SelectRecordButton");
		functions.switchToNewWindow();
		functions.changeRadioButtonOrCheckBoxStatus("Monetary_RecordTypeList1", "Monetary_RecordTypeList1");
		functions.changeRadioButtonOrCheckBoxStatus("Monetary_RecordTypeList2", "Monetary_RecordTypeList2");
		functions.changeRadioButtonOrCheckBoxStatus("Monetary_RecordTypeList3", "Monetary_RecordTypeList3");
		functions.changeRadioButtonOrCheckBoxStatus("Monetary_RecordTypeList4", "Monetary_RecordTypeList4");
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
		functions.globalWait(10);
		try{
			String strWinHandle = functions.getEnvironmentVariable("MainWindow");
			FunctionsLibrary.driver.switchTo().window(strWinHandle);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}
		}
	}

	@And("^User add RecordTypes MerchantHeader$")
	public void user_add_RecordTypesMerchnatHeader(String Types)
	{
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.clickAnElement("Monetary_SelectRecordButton", "Monetary_SelectRecordButton");
		functions.globalWait(8);
		functions.switchToNewWindow();
		functions.changeRadioButtonOrCheckBoxStatus("Monetary_RecordTypeList1", "Monetary_RecordTypeList1");
		functions.verifyRadioButtonOrCheckBoxIsSelected("Monetary_MerchantTrailer", "Monetary_MerchantTrailer");
		functions.changeRadioButtonOrCheckBoxStatus("Monetary_RecordTypeList1", "Monetary_RecordTypeList1");
		functions.verifyRadioButtonOrCheckBoxIsSelected("Monetary_MerchantTrailer", "Monetary_MerchantTrailer");
		functions.changeRadioButtonOrCheckBoxStatus("Monetary_MerchantTrailer", "Monetary_MerchantTrailer");
		functions.verifyRadioButtonOrCheckBoxIsSelected("Monetary_RecordTypeList1", "Monetary_RecordTypeList1");
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
		functions.globalWait(10);
		try{
			String strWinHandle = functions.getEnvironmentVariable("MainWindow");
			FunctionsLibrary.driver.switchTo().window(strWinHandle);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}
		}
	}
	@And("^User update MonetaryDestValues$")
	public void user_update_MonetaryDestValues(String values)
	{	
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
    functions.clickAnElement("Monetary_Edit", "Monetary_Edit");
    functions.globalWait(10);
	user_update_datafile_formatvalues(values);
	functions.globalWait(5);
	user_update_Exception_values(values);
	user_update_Holidat_values(values);
	
	functions.clickAnElement("Monetary_save", "Monetary_save");
	functions.globalWait(10);
	
    functions.waitForElementUsingPresence("Monetray_SuccessMsg");
    functions.verifyElementTextPresent("Monetray_SuccessMsg", "Monetray_SuccessMsg");
	}
	}

	@And("^User update data file formatvalues$")
	public void user_update_datafile_formatvalues(String values) {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
	
		functions.selectDropdownByVisibleText("Monetary_fileformatspcId", testData.get("Monetary_fileformatspcId"));
		functions.selectDropdownByVisibleText("Monetary_destinationEndPoint", testData.get("Monetary_destinationEndPoint"));
		functions.selectDropdownByVisibleText("Monetary_transmissionMethod", testData.get("Monetary_transmissionMethod"));
		
		}
	}
	@And("^User update Exception values$")
	public void user_update_Exception_values(String values) {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
				//Select Day 1 Processing File Creation Options
				functions.selectDropdownByVisibleText("Monetary_Excepday1opt", testData.get("Monetary_Excepday1opt"));
				functions.selectDropdownByVisibleText("Monetary_Excepday1transopt", testData.get("Monetary_Excepday1transopt"));
				functions.selectDropdownByVisibleText("Monetary_Excepday2opt", testData.get("Monetary_Excepday2opt"));
				functions.selectDropdownByVisibleText("Monetary_Excepday2transopt", testData.get("Monetary_Excepday2transopt"));
	}
	}
	@And("^User update Holiday values$")
	public void user_update_Holidat_values(String values) {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		functions.selectDropdownByVisibleText("Monetary_holidayCreateOpts", testData.get("Monetary_holidayCreateOpts"));
		functions.selectDropdownByVisibleText("Monetary_holidayTransOptsId", testData.get("Monetary_holidayTransOptsId"));
	}
	}
	
	@Then("^User save MonetaryDest$")
	public void user_save_monetarydest(String save){
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		// Click on Add Button
		functions.clickAnElement("Monetary_AddMonetary", "Monetary_AddMonetary");
		functions.verifyElementTextPresent("Monetray_SuccessMsg", "Monetray_SuccessMsg");
	}
	}

	
	/*public void verifyDBMonetaryValuesUS(String strDataFileName, String strReportFileName){

		String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");

		String strQuery = null;

		// Verify Data File Format Values
		strQuery = "SELECT ddsv.specification_name dest_datafile_format_spec_id,mdv.destination_endpoint_desc destination_endpoint,mdv.transmission_method_desc transmission_method,decode(mdv.empty_file_generation, 'Y', 'Yes', 'N', 'No') empty_file_generation,ddbd.business_term eds_deposit_date FROM mon_destination_view    mdv,dest_datafile_spec_view ddsv,data_dict_bus_terms     ddbd WHERE destination_name = '" + strMonDest + "'AND mdv.dest_datafile_format_spec_id = ddsv.specification_id AND mdv.eds_deposit_date = ddbd.business_term_id and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFileName);

		//Verify Exception Values
		strQuery = "Select EXCEP_PROC_DAY1_FILE_CREATE,EXCEP_PROC_DAY1_FILE_TRANSMIT,EXCEP_PROC_DAY2_FILE_CREATE,EXCEP_PROC_DAY2_FILE_TRANSMIT FROM MON_DESTINATION_VIEW  WHERE DESTINATION_NAME= '" + strMonDest + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues2", reporter, strReportFileName);

		//Verify Holiday Processing Values
		strQuery = "Select HOLIDAY_PROCESS_FILE_CREATE,HOLIDAY_PROCESS_FILE_TRANSMIT from MON_DESTINATION_VIEW WHERE DESTINATION_NAME= '" + strMonDest + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues3", reporter, strReportFileName);
	}


	public void verifyCMFDB(String strDataFileName, String strReportFileName, String MonOrNon)
	{
		stepExecutor.globalWait(20);
		//String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");
		String DateValue = Utilities.getEnvironmentVariable("UpdatedDate");


		System.out.println("DateValue"+DateValue);
		String strQuery = "";
		//Verify processed flag and Entity Action in SSI_REPLICATION_MESSAGE
		strQuery = "select processed_flag, Entity_action from ssi_replication_message where ENTITY_TYPE = '"+MonOrNon+"' and time_stamp >= to_date('"+DateValue+":00','mm/dd/yyyy hh24:mi:ss')";
		System.out.println("Query 1"+strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFileName);

		//Verify processed flag and Entity Action in SSI_REPLICATION_Items
		strQuery = "select processed_flag, Entity_action from ssi_replication_items where ENTITY_TYPE = '"+MonOrNon+"' and time_stamp >= to_date('"+DateValue+":00','mm/dd/yyyy hh24:mi:ss')";
		System.out.println("Query 2"+strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFileName);

		 		
	}


	public void UpdatedDate(String Time)
	{

		String[] hr = Time.split(":");
		int hrs = Integer.parseInt(hr[0]);
		if(hrs>12)
		{
			hrs=hrs-12;
		}
		hr[0] = Integer.toString(hrs);

		Date myDate = new Date();


		SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MMM-yyyy");
		// Format the date to Strings
		String DMY = dmyFormat.format(myDate);
		DMY = DMY+" "+hr[0]+"."+hr[1];
		System.out.println(DMY);
		Utilities.setEnvironmentVariable("UpdatedDate", DMY);
	}

	public void verifyDBMonetaryValuesUS1(String strDataFileName, String strReportFileName,String strMonDest){

		//String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");

		String strQuery = null;

		// Verify Data File Format Values
		strQuery = "SELECT ddsv.specification_name dest_datafile_format_spec_id,mdv.destination_endpoint_desc destination_endpoint,mdv.transmission_method_desc transmission_method,decode(mdv.empty_file_generation, 'Y', 'Yes', 'N', 'No') empty_file_generation,ddbd.business_term eds_deposit_date FROM mon_destination_view    mdv,dest_datafile_spec_view ddsv,data_dict_bus_terms     ddbd WHERE destination_name = '" + strMonDest + "'AND mdv.dest_datafile_format_spec_id = ddsv.specification_id AND mdv.eds_deposit_date = ddbd.business_term_id and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFileName);

		//Verify Exception Values
		strQuery = "Select EXCEP_PROC_DAY1_FILE_CREATE,EXCEP_PROC_DAY1_FILE_TRANSMIT,EXCEP_PROC_DAY2_FILE_CREATE,EXCEP_PROC_DAY2_FILE_TRANSMIT FROM MON_DESTINATION_VIEW  WHERE DESTINATION_NAME= '" + strMonDest + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues2", reporter, strReportFileName);

		//Verify Holiday Processing Values
		strQuery = "Select HOLIDAY_PROCESS_FILE_CREATE,HOLIDAY_PROCESS_FILE_TRANSMIT from MON_DESTINATION_VIEW WHERE DESTINATION_NAME= '" + strMonDest + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues3", reporter, strReportFileName);
	}

	public void verifyDBMonetaryValuesUS2(String strDataFileName, String strReportFileName,String strMonDest){

		//String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");

		String strQuery = null;

		// Verify Data File Format Values
		strQuery = "SELECT ddsv.specification_name dest_datafile_format_spec_id,mdv.destination_endpoint_desc destination_endpoint,mdv.transmission_method_desc transmission_method,decode(mdv.empty_file_generation, 'Y', 'Yes', 'N', 'No') empty_file_generation,ddbd.business_term eds_deposit_date FROM mon_destination_view    mdv,dest_datafile_spec_view ddsv,data_dict_bus_terms     ddbd WHERE destination_name = '" + strMonDest + "'AND mdv.dest_datafile_format_spec_id = ddsv.specification_id AND mdv.eds_deposit_date = ddbd.business_term_id and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFileName);

		//Verify Exception Values
		strQuery = "Select EXCEP_PROC_DAY1_FILE_CREATE,EXCEP_PROC_DAY1_FILE_TRANSMIT,EXCEP_PROC_DAY2_FILE_CREATE,EXCEP_PROC_DAY2_FILE_TRANSMIT FROM MON_DESTINATION_VIEW  WHERE DESTINATION_NAME= '" + strMonDest + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues2", reporter, strReportFileName);

		//Verify Holiday Processing Values
		strQuery = "Select HOLIDAY_PROCESS_FILE_CREATE,HOLIDAY_PROCESS_FILE_TRANSMIT from MON_DESTINATION_VIEW WHERE DESTINATION_NAME= '" + strMonDest + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues3", reporter, strReportFileName);
	}

	public void verifyDBMonetaryValuesUSG2(String strDataFileName, String strReportFileName){

		String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");

		String strQuery = null;

		// Verify Destination Endpoint,Transmission Method,Empty File Generation,EDS Deposit date,Day 1 Processing File Creatiom Options,Day1 Processing File Transmission Options ,Day 2 Processing File Creatiom Options,Day 2 Processing File Transmission Options
		strQuery="select DEST_ENDPOINT,TRANS_METHOD,EMPTY_FILE_IND,WK_END1_CREATE_IND,WK_END1_XMIT_IND,WK_END2_CREATE_IND,WK_END2_XMIT_IND from EDC_SETTLE where name ='" + strMonDest + "'";
		stepExecutor.globalWait(50);
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues_MonDest", reporter, strReportFileName);
	}

	public void verifyDBMonetaryValuesG2(String strDataFileName, String strReportFileName){
		
		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);

		String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");
		String DataTransFileName = Utilities.getEnvironmentVariable("DataTransFileName");
		String DatatransDirectory = scriptExecutor.readDataFile(strDataFileName, rowNumber, "TextBox_dataTransDirectory");
		String ExpectedValues = strMonDest + "@@" + DataTransFileName + "@@" + DatatransDirectory;
		String strQuery = null;
		stepExecutor.globalWait(60);
		// Verify Destination name, Data trans file name, data trans Directory
		strQuery="select NAME, OUTPUT_FILE_NAME,DT_DIRECTORY from EDC_SETTLE where name='"+strMonDest+"'";
		verificationFunctions.verifyDatabaseValuesExpectedDynamic("DBDetailsG2", strQuery, ExpectedValues, strDataFileName, reporter, strReportFileName);

		strQuery="select DEST_ENDPOINT, TRANS_METHOD, FILE_HEADER_TEXT, EMPTY_FILE_IND from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues1", reporter, strReportFileName);

		strQuery="select WK_END_1, WK_END1_CREATE_IND, WK_END1_XMIT_IND, WK_END_2, WK_END2_CREATE_IND, WK_END2_XMIT_IND from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues2", reporter, strReportFileName);

		strQuery="select CREATE_CALENDAR_ID, HOLIDAY_CREATE_IND, HOLIDAY_XMIT_IND from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		//verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues3", reporter, strReportFileName);

		//Get Settle ID from application
		strQuery="select settle_id from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		String Settle_ID = verificationFunctions.getValueFromDatabase("DBDetailsG2", strQuery, strDataFileName, reporter, strReportFileName);

		//validate Cut Times
		strQuery = "select Cut_time from edc_settle_cut_times where settle_id ='"+Settle_ID+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseRowValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues4", reporter, strReportFileName);

		//GCF_File_Records
		strQuery="select GCF_File_Records from EDC_SETTLE where name='"+strMonDest+"'";
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues5", reporter, strReportFileName);

	}
public void verifyDBMonetaryValuesG217QR2(String strDataFileName, String strReportFileName, String EDCDB){
		
		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);

		String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");
		String DataTransFileName = Utilities.getEnvironmentVariable("DataTransFileName");
		String DatatransDirectory = scriptExecutor.readDataFile(strDataFileName, rowNumber, "TextBox_dataTransDirectory");
		String ExpectedValues = strMonDest + "@@" + DataTransFileName + "@@" + DatatransDirectory;
		String strQuery = null;
		stepExecutor.globalWait(60);
		// Verify Destination name, Data trans file name, data trans Directory
		strQuery="select NAME, OUTPUT_FILE_NAME,DT_DIRECTORY from EDC_SETTLE where name='"+strMonDest+"'";
		verificationFunctions.verifyDatabaseValuesExpectedDynamic(EDCDB, strQuery, ExpectedValues, strDataFileName, reporter, strReportFileName);

		strQuery="select DEST_ENDPOINT, TRANS_METHOD, FILE_HEADER_TEXT, EMPTY_FILE_IND from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues(EDCDB, strQuery, strDataFileName, "G2DBValues1", reporter, strReportFileName);

		strQuery="select WK_END_1, WK_END1_CREATE_IND, WK_END1_XMIT_IND, WK_END_2, WK_END2_CREATE_IND, WK_END2_XMIT_IND from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues(EDCDB, strQuery, strDataFileName, "G2DBValues2", reporter, strReportFileName);

		strQuery="select CREATE_CALENDAR_ID, HOLIDAY_CREATE_IND, HOLIDAY_XMIT_IND from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		//verificationFunctions.verifyDatabaseValues(EDCDB, strQuery, strDataFileName, "G2DBValues3", reporter, strReportFileName);

		//Get Settle ID from application
		strQuery="select settle_id from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		String Settle_ID = verificationFunctions.getValueFromDatabase(EDCDB, strQuery, strDataFileName, reporter, strReportFileName);

		//validate Cut Times
		strQuery = "select Cut_time from edc_settle_cut_times where settle_id ='"+Settle_ID+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseRowValues(EDCDB, strQuery, strDataFileName, "G2DBValues4", reporter, strReportFileName);

		
	}

	public void verifyDBMonetaryValuesG217QR1P1(String strDataFileName, String strReportFileName){

		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);

		String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");
		String DataTransFileName = Utilities.getEnvironmentVariable("DataTransFileName");
		String DatatransDirectory = scriptExecutor.readDataFile(strDataFileName, rowNumber, "TextBox_dataTransDirectory");
		String ExpectedValues = strMonDest + "@@" + DataTransFileName + "@@" + DatatransDirectory;
		String strQuery = null;
		stepExecutor.globalWait(55);
		// Verify Destination name, Data trans file name, data trans Directory
		strQuery="select NAME, OUTPUT_FILE_NAME,DT_DIRECTORY from EDC_SETTLE where name='"+strMonDest+"'";
		verificationFunctions.verifyDatabaseValuesExpectedDynamic("DBDetailsG2", strQuery, ExpectedValues, strDataFileName, reporter, strReportFileName);

		strQuery="select WK_END_1, WK_END1_CREATE_IND, WK_END1_XMIT_IND, WK_END_2, WK_END2_CREATE_IND, WK_END2_XMIT_IND from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues1", reporter, strReportFileName);

		strQuery="select HOLIDAY_CREATE_IND, HOLIDAY_XMIT_IND, EMPTY_FILE_IND, DATA_CENTER, CAN_ORIG_NAME, SFTP_IND from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues2", reporter, strReportFileName);

		strQuery="select EDS_CORPORATE_ID, EDS_DEPOSIT_DATE, EDS_RECORD_SOURCE, EDS_SCAN_CHARGE, EDS_SOURCE_ID from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues3", reporter, strReportFileName);

		strQuery="select FILE_HEADER_TEXT, GCF_FILE_RECORDS,CREATE_CALENDAR_ID, XMIT_CALENDAR_ID, AMEX_SUBMITTER_ID, TRAN_REF_NBR_FMT from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues4", reporter, strReportFileName);

		//Get Settle ID from application
		strQuery="select settle_id from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		String Settle_ID = verificationFunctions.getValueFromDatabase("DBDetailsG2", strQuery, strDataFileName, reporter, strReportFileName);
		Utilities.setEnvironmentVariable("Settle_ID", Settle_ID);

		//validate Cut Times
		strQuery = "select Cut_time from edc_settle_cut_times where settle_id ='"+Settle_ID+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseRowValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues5", reporter, strReportFileName);

	}
	
	public void verifyDBMonetaryValuesG217QR1P2(String strDataFileName, String strReportFileName){

		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);

		String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");
		String DataTransFileName = Utilities.getEnvironmentVariable("DataTransFileName");
		String DatatransDirectory = scriptExecutor.readDataFile(strDataFileName, rowNumber, "TextBox_dataTransDirectory");
		String ExpectedValues = strMonDest + "@@" + DataTransFileName + "@@" + DatatransDirectory;
		String strQuery = null;
		stepExecutor.globalWait(55);
		// Verify Destination name, Data trans file name, data trans Directory
		strQuery="select NAME, OUTPUT_FILE_NAME,DT_DIRECTORY from EDC_SETTLE where name='"+strMonDest+"'";
		verificationFunctions.verifyDatabaseValuesExpectedDynamic("DBDetailsG2", strQuery, ExpectedValues, strDataFileName, reporter, strReportFileName);

		strQuery="select WK_END_1, WK_END1_CREATE_IND, WK_END1_XMIT_IND, WK_END_2, WK_END2_CREATE_IND, WK_END2_XMIT_IND from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues1", reporter, strReportFileName);

		strQuery="select HOLIDAY_CREATE_IND, HOLIDAY_XMIT_IND, EMPTY_FILE_IND, DATA_CENTER, CAN_ORIG_NAME, SFTP_IND from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues2", reporter, strReportFileName);

		strQuery="select EDS_CORPORATE_ID, EDS_DEPOSIT_DATE, EDS_RECORD_SOURCE, EDS_SCAN_CHARGE, EDS_SOURCE_ID from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues3", reporter, strReportFileName);

		strQuery="select FILE_HEADER_TEXT, GCF_FILE_RECORDS,CREATE_CALENDAR_ID, XMIT_CALENDAR_ID, AMEX_SUBMITTER_ID, TRAN_REF_NBR_FMT from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues4", reporter, strReportFileName);

		//Get Settle ID from application
		strQuery="select settle_id from EDC_SETTLE where name='"+strMonDest+"'";
		System.out.println(strQuery);
		String Settle_ID = verificationFunctions.getValueFromDatabase("DBDetailsG2", strQuery, strDataFileName, reporter, strReportFileName);
		Utilities.setEnvironmentVariable("Settle_ID", Settle_ID);

		//validate Cut Times
		strQuery = "select Cut_time from edc_settle_cut_times where settle_id ='"+Settle_ID+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseRowValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues5", reporter, strReportFileName);

	}
	
	public void verifyDBMonetaryValuesG2Updated(String strDataFileName, String strReportFileName){
		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);

		String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");
		String DataTransFileName = Utilities.getEnvironmentVariable("DataTransFileName");
		String DatatransDirectory = scriptExecutor.readDataFile(strDataFileName, rowNumber, "TextBox_dataTransDirectory");
		String ExpectedValues = strMonDest + "@@" + DataTransFileName + "@@" + DatatransDirectory;
		String strQuery = null;
		stepExecutor.globalWait(65);
		// Verify Destination name, Data trans file name, data trans Directory
		strQuery="select NAME, OUTPUT_FILE_NAME,DT_DIRECTORY from EDC_SETTLE where name='"+strMonDest+"'";
		verificationFunctions.verifyDatabaseValuesExpectedDynamic("DBDetailsG2", strQuery, ExpectedValues, strDataFileName, reporter, strReportFileName);

		strQuery="select DEST_ENDPOINT, TRANS_METHOD, FILE_HEADER_TEXT, EMPTY_FILE_IND from EDC_SETTLE where name='"+strMonDest+"'";
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues1", reporter, strReportFileName);

		strQuery="select WK_END_1, WK_END1_CREATE_IND, WK_END1_XMIT_IND, WK_END_2, WK_END2_CREATE_IND, WK_END2_XMIT_IND from EDC_SETTLE where name='"+strMonDest+"'";
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues2", reporter, strReportFileName);

		strQuery="select CREATE_CALENDAR_ID, HOLIDAY_CREATE_IND, HOLIDAY_XMIT_IND from EDC_SETTLE where name='"+strMonDest+"'";
		//verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues3", reporter, strReportFileName);

		//Get Settle ID from application
		strQuery="select settle_id from EDC_SETTLE where name='"+strMonDest+"'";
		String Settle_ID = verificationFunctions.getValueFromDatabase("DBDetailsG2", strQuery, strDataFileName, reporter, strReportFileName);
		System.out.println(Settle_ID);
		//validate Cut Times
		strQuery = "select Cut_time from edc_settle_cut_times where settle_id ='"+Settle_ID+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseRowValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues4", reporter, strReportFileName);


		//G2 Database		
		strQuery="select GCF_File_Records from EDC_SETTLE where name='"+strMonDest+"'";
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues6", reporter, strReportFileName);

	}


	public void verifyDBMonetaryValuesUSG21(String strDataFileName, String strReportFileName,String strMonDest){

		//String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");

		String strQuery = null;

		// Verify Destination Endpoint,Transmission Method,Empty File Generation,EDS Deposit date,Day 1 Processing File Creatiom Options,Day1 Processing File Transmission Options ,Day 2 Processing File Creatiom Options,Day 2 Processing File Transmission Options
		strQuery="select DEST_ENDPOINT,TRANS_METHOD,EMPTY_FILE_IND,WK_END1_CREATE_IND,WK_END1_XMIT_IND,WK_END2_CREATE_IND,WK_END2_XMIT_IND from EDC_SETTLE where name ='" + strMonDest + "'";
		stepExecutor.globalWait(50);
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues_MonDest", reporter, strReportFileName);
	}

	public void verifyDBMonetaryValuesAP(String strDataFileName, String strReportFileName){

		String strMonDest = Utilities.getEnvironmentVariable("MonDest1AP");

		String strQuery = null;

		// Verify Data File Format Values
		strQuery = "SELECT ddsv.specification_name dest_datafile_format_spec_id,mdv.destination_endpoint_desc destination_endpoint,mdv.transmission_method_desc transmission_method,decode(mdv.empty_file_generation, 'Y', 'Yes', 'N', 'No') empty_file_generation,ddbd.business_term eds_deposit_date FROM mon_destination_view    mdv,dest_datafile_spec_view ddsv,data_dict_bus_terms     ddbd WHERE destination_name = '" + strMonDest + "'AND mdv.dest_datafile_format_spec_id = ddsv.specification_id AND mdv.eds_deposit_date = ddbd.business_term_id and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFileName);

		//Verify Exception Values
		strQuery = "Select EXCEP_PROC_DAY1_FILE_CREATE,EXCEP_PROC_DAY1_FILE_TRANSMIT,EXCEP_PROC_DAY2_FILE_CREATE,EXCEP_PROC_DAY2_FILE_TRANSMIT FROM MON_DESTINATION_VIEW  WHERE DESTINATION_NAME= '" + strMonDest + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues2", reporter, strReportFileName);

		//Verify Holiday Processing Values
		strQuery = "Select HOLIDAY_PROCESS_FILE_CREATE,HOLIDAY_PROCESS_FILE_TRANSMIT from MON_DESTINATION_VIEW WHERE DESTINATION_NAME= '" + strMonDest + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues3", reporter, strReportFileName);
	}

	public void verifyDBMonetaryValuesAPG2(String strDataFileName, String strReportFileName){

		String strMonDest = Utilities.getEnvironmentVariable("MonDest1AP");

		String strQuery = null;

		// Verify Destination Endpoint,Transmission Method,Empty File Generation,EDS Deposit date,Day 1 Processing File Creatiom Options,Day1 Processing File Transmission Options ,Day 2 Processing File Creatiom Options,Day 2 Processing File Transmission Options
		strQuery="select DEST_ENDPOINT,TRANS_METHOD,EMPTY_FILE_IND,WK_END1_CREATE_IND,WK_END1_XMIT_IND,WK_END2_CREATE_IND,WK_END2_XMIT_IND from EDC_SETTLE where name ='" + strMonDest + "'";
		stepExecutor.globalWait(50);
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues_MonDest", reporter, strReportFileName);
	}

	public void navigateToMonDest(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter,String strReportFilename) 
	{	
		// Navigate to Customer page
	//	stepExecutor.clickLink("findElementByXPath", "//a[contains(text(),'Home')]", webDriver, "Home", reporter, strReportFilename);
		stepExecutor.clickLink("findElementByXPath", "//a[contains(text(),'Customer')]", webDriver, "Customer", reporter, strReportFilename);

		// Verify Monetary Destination link is present
		stepExecutor.clickLink("findElementByXPath", "//a[contains(text(),'Monetary Destination')]", webDriver, "Monetary Destination", reporter, strReportFilename);
	}
	public void assignCardTypesR18(String strDataFileName,RemoteWebDriver webDriver, int strcardTypes,  GridReporter reporter, String strReportFilename){

		//Select Card Types
		stepExecutor.selectListValue("findElementById", "availableCardTypes", strDataFileName, "ListBox_CardTypes_"+strcardTypes, webDriver, reporter, strReportFilename);

		//Click Button
		stepExecutor.clickButtonWithoutScreenshot("findElementByXPath", "//input[@value='>']", "select", webDriver, reporter, strReportFilename);	
	}
	public void verifyDBNonMonetaryValuesG2(String strDataFileName, String strReportFilename){

		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);

		String strMonDest = Utilities.getEnvironmentVariable("MonDestName");
		String DataTransFileName = Utilities.getEnvironmentVariable("DataTransFile");
		String DatatransDirectory = Utilities.getEnvironmentVariable("dataTransDirectoryPrevious");
		String ExpectedValues = strMonDest + "@@" + DataTransFileName + "@@" + DatatransDirectory;

		String strQuery = null;
		stepExecutor.globalWait(65);
		//Verify Destination name, Data trans file name, data trans Directory
		strQuery="select NAME, OUTPUT_FILE_NAME,DT_DIRECTORY from EDC_nmon_dest where name like'%"+strMonDest+"%'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValuesExpectedDynamic("DBDetailsG2", strQuery, ExpectedValues, strDataFileName, reporter, strReportFilename);

	}

	public void removeCardTypes(String strDataFileName,RemoteWebDriver webDriver, String strcardTypes,  GridReporter reporter, String strReportFilename){

		//Select Card Types
		stepExecutor.selectListValue("findElementByName", "cardTypes", strDataFileName, "ListBox_CardTypes_"+strcardTypes, webDriver, reporter, strReportFilename);

		//Click Button
		stepExecutor.clickButton("findElementByXPath", "//input[@value='<']", "select", webDriver, reporter, strReportFilename);	
	}
public void verifyAssignCardTypesMonetry(String strDataFileName,RemoteWebDriver webDriver, String strcardTypes,String Card,GridReporter reporter, String strReportFilename){
		
		verificationFunctions.verifyElementTextPresentString(webDriver, "//select[@id='availableCardTypes']//option[text()='"+Card+"']", "findElementByXPath", Card, reporter, strReportFilename);
		//Select Card Types
		//stepExecutor.selectListValue("findElementByXPath", "//select[@id='availableCardTypes']//option[text()='"+Card+"']", strDataFileName, "ListBox_CardTypes_"+strcardTypes, webDriver, reporter, strReportFilename);

	}
public void addALLFileCutTimesupdate(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFileName){

	//Select File Cut Time1
	stepExecutor.selectListValue("findElementById", "fileCutTime1", strDataFileName, "ListBox_FileCutTime1", webDriver, reporter, strReportFileName);

	//Select File Cut Time2
	stepExecutor.selectListValue("findElementById", "fileCutTime2", strDataFileName, "ListBox_FileCutTime2", webDriver, reporter, strReportFileName);

	//Select File Cut Time3
	stepExecutor.selectListValue("findElementById", "fileCutTime3", strDataFileName, "ListBox_FileCutTime3", webDriver, reporter, strReportFileName);

	//Select File Cut Time4
	stepExecutor.selectListValue("findElementById", "fileCutTime4", strDataFileName, "ListBox_FileCutTime4", webDriver, reporter, strReportFileName);

	//Select File Cut Time5
	stepExecutor.selectListValue("findElementById", "fileCutTime5", strDataFileName, "ListBox_FileCutTime5", webDriver, reporter, strReportFileName);

	//Select File Cut Time6
	stepExecutor.selectListValue("findElementById", "fileCutTime6", strDataFileName, "ListBox_FileCutTime6", webDriver, reporter, strReportFileName);
	String EffectiveDate = webDriver.findElementByXPath("//td[contains(@id,'cutTime7Cell')]").getText();
	
	//String x=EffectiveDate.substring(3, 5);
	
	int date=(Integer.parseInt(EffectiveDate.substring(3, 5)))+1;
	
	String xy=EffectiveDate.substring(0, 3)+date+""+EffectiveDate.substring(5, 10);
	
	
	
	//Select File Cut Time6
	stepExecutor.enterTextValueUsingDynamicValues("findElementByXPath", "//input[@id='effectiveDate']", xy, webDriver, reporter, strReportFileName);

	//Click Add Button
	stepExecutor.clickButton("findElementByXPath", "//input[@value='Add']", "Add Cut Time", webDriver, reporter, strReportFileName);
	
	//Click Add Button
	stepExecutor.clickButton("findElementByXPath", "(//input[@name='fileCutRadio'])[2]", "Select cut time", webDriver, reporter, strReportFileName);	
	
	//Click Add Button
	//stepExecutor.clickButton("findElementByXPath", "//input[@value='Update']", "Select cut time", webDriver, reporter, strReportFileName);	
	
	//stepExecutor.AcceptIfAlertPresent(webDriver);
	
	//webDriver.switchTo().alert().accept();

}
*/}