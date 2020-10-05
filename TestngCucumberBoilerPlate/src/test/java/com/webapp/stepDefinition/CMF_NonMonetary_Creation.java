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
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CMF_NonMonetary_Creation extends ExecutionerClass {

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

	@When("^User navigates to Add Non Monetary Page$")
	public void user_Navigates_to_Add_NonMonDest() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		//Click on Customer tab
		functions.clickAnElement("Customer_Tab", "Customer");
		// Navigate to Non Monetary Destination 
		functions.clickAnElement("NonMonDest_NonMonDest_Tab", "NonMonDest Tab");
		// Navigate to  Add Non Monetary Destination
		functions.clickAnElement("NonMonDest_Add_NonMonDest", "Add NonMonDest");
		}
	}
	@When("^User navigates to Non Monetary Page$")
	public void user_Navigates_to_NonMonDest() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Click on Home button
		functions.clickAnElement("Home", "Home_Tab");
		//Click on Customer tab
		functions.clickAnElement("Customer_Tab", "Customer");
		// Navigate to Non Monetary Destination 
		functions.clickAnElement("NonMonDest_NonMonDest_Tab", "NonMonDest Tab");
	}
	}
	@And("^User Search for Non Monetary$")
	public void user_Search_for_NonMonDest() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Enter Non MonDest name
		functions.enterText("NonMonDest_Search_DestName", testData.get("NonMonDest_Search_DestName"));
		functions.waitForElementUsingPresence("NonMonDest_Search");
		functions.clickAnElement("NonMonDest_Search", "Search");
		functions.clickAnElement("NonMonDest_Search_results", "Result");
		}
	}
	@And("^User Create Unique Non Monetary name$")
	public void user_Create_Unique_NonMonDestName() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		Random ran = new Random(System.currentTimeMillis());
		int x = (int)(Math.random() * 999) + Math.abs(ran.nextInt());
		String strMonDestName = "NonMonDestName";
		strMonDestName = strMonDestName.concat(Integer.toString(x));
		
		functions.setEnvironmentVariable("NonMonDestName", strMonDestName);
		
		functions.enterText("NonMonDest_destinationName", strMonDestName);
	}
	}

	@And("^User Create Unique Non Monetary DataTransFileName$")
	public void user_Create_Unique_DataTransFileName() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		Random ran = new Random(System.currentTimeMillis());
		int x = (int)(Math.random() * 999) + Math.abs(ran.nextInt());
		String DataTransFileName = "DTFNAME";
		DataTransFileName = DataTransFileName.concat(Integer.toString(x));
		
		functions.setEnvironmentVariable("DataTransFileName", DataTransFileName);
		
		functions.enterText("NonMonDest_DataTransFileName", DataTransFileName);
	}
	}
	@And("^User fill Mandatory details$")
	public void user_fillDataFileDetailsGFC2013() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Select Card Number Masking
		functions.selectDropdownByVisibleText("NonMonDest_cardNumberMasking", testData.get("NonMonDest_cardNumberMasking"));
		//Select Data File Format Specification
		functions.selectDropdownByVisibleText("NonMonDest_destFileFormatId", testData.get("NonMonDest_destFileFormatId"));
		//Select Layout
		functions.selectDropdownByVisibleText("NonMonDest_layout", testData.get("NonMonDest_layout"));
		//Enter Datatrans Directory
		functions.enterText("NonMonDest_dataTransDirectory", testData.get("NonMonDest_dataTransDirectory"));
		//Select Destination Endpoint
		functions.selectDropdownByVisibleText("NonMonDest_destinationEndPoint", testData.get("NonMonDest_destinationEndPoint"));
		//Select Transmission Method
		functions.selectDropdownByVisibleText("NonMonDest_transmissionMethod", testData.get("NonMonDest_transmissionMethod"));
		//Enter File Header text
		functions.enterText("NonMonDest_fileHeaderText", testData.get("NonMonDest_fileHeaderText"));
		//Select Empty File Generation
		functions.selectDropdownByVisibleText("NonMonDest_emptyFileGenerationId", testData.get("NonMonDest_emptyFileGenerationId"));
		}
	}
	@And("^User fillDataFileDetailsRiskNet$")
	public void fillDataFileDetailsRiskNet() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Select Card Number Masking
		functions.selectDropdownByVisibleText("NonMonDest_cardNumberMasking", testData.get("NonMonDest_cardNumberMasking"));
		//Select Data File Format Specification
		functions.selectDropdownByVisibleText("NonMonDest_destFileFormatId", testData.get("NonMonDest_destFileFormatId"));
		//Enter Datatrans Directory
		functions.enterText("NonMonDest_dataTransDirectory", testData.get("NonMonDest_dataTransDirectory"));
		//Select Destination Endpoint
		functions.selectDropdownByVisibleText("NonMonDest_destinationEndPoint", testData.get("NonMonDest_destinationEndPoint"));
		//Select Transmission Method
		functions.selectDropdownByVisibleText("NonMonDest_transmissionMethod", testData.get("NonMonDest_transmissionMethod"));
		//Enter File Header text
		functions.enterText("NonMonDest_fileHeaderText", testData.get("NonMonDest_fileHeaderText"));
		//Select Empty File Generation
		functions.selectDropdownByVisibleText("NonMonDest_emptyFileGenerationId", testData.get("NonMonDest_emptyFileGenerationId"));
		}
	}
	@And("^User fillDataFileDetailsGlobalAuthLog$")
	public void user_fillDataFileDetailsGlobalAuthLog() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Select Card Number Masking
		functions.selectDropdownByVisibleText("NonMonDest_cardNumberMasking", testData.get("NonMonDest_cardNumberMasking"));
		//Select Data File Format Specification
		functions.selectDropdownByVisibleText("NonMonDest_destFileFormatId", testData.get("NonMonDest_destFileFormatId"));
		//Select Layout
		functions.selectDropdownByVisibleText("NonMonDest_layout", testData.get("NonMonDest_layout"));
		//Enter Datatrans Directory
		functions.enterText("NonMonDest_dataTransDirectory", testData.get("NonMonDest_dataTransDirectory"));
		//Select Destination Endpoint
		functions.selectDropdownByVisibleText("NonMonDest_destinationEndPoint", testData.get("NonMonDest_destinationEndPoint"));
		//Select Transmission Method
		functions.selectDropdownByVisibleText("NonMonDest_transmissionMethod", testData.get("NonMonDest_transmissionMethod"));
		//Enter File Header text
		functions.enterText("NonMonDest_fileHeaderText", testData.get("NonMonDest_fileHeaderText"));
		//Select Empty File Generation
		functions.selectDropdownByVisibleText("NonMonDest_emptyFileGenerationId", testData.get("NonMonDest_emptyFileGenerationId"));
		}
	}
	@And("^User fillExceptionDetails$")
	public void user_fillExceptionDetails() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Select Processing Day 1
		functions.selectDropdownByVisibleText("NonMonDest_exceptDay1", testData.get("NonMonDest_exceptDay1"));
		//Select Day 1 Processing File Creation Options
		functions.selectDropdownByVisibleText("NonMonDest_exceptFileCreate1", testData.get("NonMonDest_exceptFileCreate1"));
		//Select Day1 Processing File Transmission Options 
		functions.selectDropdownByVisibleText("NonMonDest_exceptFileTransmit1", testData.get("NonMonDest_exceptFileTransmit1"));
		//Select Processing Day 2
		functions.selectDropdownByVisibleText("NonMonDest_exceptDay2", testData.get("NonMonDest_exceptDay2"));
		//Select Day 2 Processing File Creation Options
		functions.selectDropdownByVisibleText("NonMonDest_exceptFileCreate2", testData.get("NonMonDest_exceptFileCreate2"));
		//Select Day 2 Processing File Transmission Options
		functions.selectDropdownByVisibleText("NonMonDest_exceptFileTransmit2", testData.get("NonMonDest_exceptFileTransmit2"));
		}
	}
	@And("^User Add Card Types to NonMonDest$")
	public void user_Add_Cardtypes_To_NonMonDest() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		String[] CardTypes=testData.get("NonMonDest_CardTypes").split("@@");
		for(int i=0; i<CardTypes.length;i++) {
			//Select Card Types
			functions.selectDropdownByVisibleText("NonMonDest_Add_CardTypes", CardTypes[i]);
			//Click Button
			functions.clickAnElement("NonMonDest_Card_Select", "> Button");
		}
		}
	}
	@And("^User Add CutTimes to NonMonDest$")
	public void user_Add_CutTimes_To_NonMonDest() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Select File Cut Time1
		functions.selectDropdownByVisibleText("NonMonDest_fileCutTime1", testData.get("NonMonDest_fileCutTime1"));
		//Select File Cut Time2
		functions.selectDropdownByVisibleText("NonMonDest_fileCutTime2", testData.get("NonMonDest_fileCutTime2"));
		//Select File Cut Time3
		functions.selectDropdownByVisibleText("NonMonDest_fileCutTime3", testData.get("NonMonDest_fileCutTime3"));
		//Select File Cut Time4
		functions.selectDropdownByVisibleText("NonMonDest_fileCutTime4", testData.get("NonMonDest_fileCutTime4"));
		//Select File Cut Time5
		functions.selectDropdownByVisibleText("NonMonDest_fileCutTime5", testData.get("NonMonDest_fileCutTime5"));
		//Select File Cut Time6
		functions.selectDropdownByVisibleText("NonMonDest_fileCutTime6", testData.get("NonMonDest_fileCutTime6"));
		//Click Add Button
		functions.clickAnElement("NonMonDest_Add_CutTimes", "Add Cut Times");
	}
	}
	@Then("^User Save NonMonDest$")
	public void user_Save_NonMonDest() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		// Click on Add Button
		functions.clickAnElement("NonMonDest_Add", "Add NonMonDest");
		functions.globalWait(10);
		// Verify Confirm Message 
		functions.verifyElementTextPresent("NonMonDest_VerifyMsg", testData.get("NonMonDest_VerifyMsg"));
		}
	}
	@Then("^User Delete NonMonDest$")
	public void user_Delete_NonMonDest() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		// Click on Add Button
		functions.clickAnElement("NonMonDest_Delete", "NonMonDest_Delete");
		functions.globalWait(2);
		functions.acceptAlertWithoutText("accept");
		// Verify Confirm Message 
		functions.verifyElementTextPresent("NonMonDest_Delete_Msg", testData.get("NonMonDest_Delete_Msg"));
		}
	}
	@Then("^User Delete NonMonDest Validate Error$")
	public void user_Delete_NonMonDest_Error() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		// Click on Add Button
		functions.clickAnElement("NonMonDest_Delete", "NonMonDest_Delete");
		functions.globalWait(2);
		functions.acceptAlertWithoutText("accept");
		// Verify Confirm Message 
		functions.verifyElementTextPresent("NonMonDest_Delete_ErrorMsg", testData.get("NonMonDest_Delete_ErrorMsg"));
		}
	}
	@Then("^User remove Card Types to NonMonDest and validate error$")
	public void user_Remove_Cardtypes_To_NonMonDest() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("NonMonDest_Edit_Button", "Edit");
			
		String[] CardTypes=testData.get("NonMonDest_RemoveCardTypes").split("@@");
		for(int i=0; i<CardTypes.length;i++) {
			//Select Card Types
			functions.selectDropdownByVisibleText("NonMonDest_SelectedCards", CardTypes[i]);
			//Click Button
			functions.clickAnElement("NonMonDest_Card_Deselect", "< Button");
		}
		//click on save button
		functions.clickAnElement("NonMonDest_save", "Save");
		//Verify error message
		functions.verifyElementTextContains("NonMonDest_Delete_ErrorMsg", testData.get("NonMonDest_Delete_ErrorMsg"));
		
		}
	}
	@Then("^User Edit Non Mon and Update File Format$")
	public void user_Update_Fileformat() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		//Select Card Number Masking
		functions.selectDropdownByVisibleText("NonMonDest_cardNumberMasking", testData.get("NonMonDest_cardNumberMasking"));
		//Select Data File Format Specification
		functions.selectDropdownByVisibleText("NonMonDest_destFileFormatId", testData.get("NonMonDest_New_destFileFormatId"));
		//change Date
		FunctionsLibrary.driver.findElement(By.xpath("//input[@name='fileFormatEffDateTrigger']")).click();
		FunctionsLibrary.driver.findElement(By.xpath("//tr[@class='headrow']/td[4]/div")).click();
		//Select Layout
		functions.selectDropdownByVisibleText("NonMonDest_layout", testData.get("NonMonDest_layout"));
		
		functions.clickAnElement("NonMonDest_save", "Save");
		functions.verifyElementTextContains("NonMonDest_Update_Msg", testData.get("NonMonDest_Update_Msg"));
		}
	}
	@And("^User Validating NonMonDest CMF Database Region \"([^\"]*)\"$")
	public void CMF_DB_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.CMFDatabase(Region);
		String NonMonDest=functions.getEnvironmentVariable("NonMonDestName");
		String query=testData.get("NonMonDest_CMF_Query1")+NonMonDest+"'";
		functions.globalWait(65);
		functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("CMF_DBExpected"));
		}
	}
	@Then("^User Validating NonMonDest G2 Database Region \"([^\"]*)\"$")
	public void G2DB_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.G2Database(Region);
		String NonMonDest=functions.getEnvironmentVariable("NonMonDestName");
		String query=testData.get("NonMonDest_G2_Query1")+NonMonDest+"'";
		functions.verifyDatabaseRowValuesDynamically(regionvalue, query, testData.get("G2_DBExpected"));
		}
	}
	@Then("^User Validating NonMonDest CMF Database Multiple values \"([^\"]*)\"$")
	public void CMF_DB_Multiple_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.CMFDatabase(Region);
		String NonMonDest=functions.getEnvironmentVariable("NonMonDestName");
		String[] CMFDBExpected=testData.get("CMF_DBExpected").split("@@");
		functions.globalWait(65);
		for(int i=1;i<=CMFDBExpected.length;i++)
		{
		String query=testData.get("NonMonDest_CMF_Query"+i)+NonMonDest+"'";
			
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, CMFDBExpected[i]);
		}
		}
	}
	@Then("^User Validating NonMonDest G2 Database Multiple values \"([^\"]*)\"$")
	public void G2DB_Multiple_Validations(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		ReusableFunctions rf = new ReusableFunctions();
		String regionvalue= rf.G2Database(Region);
		String NonMonDest=functions.getEnvironmentVariable("NonMonDestName");
		String[] G2DBExpected=testData.get("G2_DBExpected").split("@@");
		functions.globalWait(65);
		for(int i=1;i<=G2DBExpected.length;i++)
		{
		String query=testData.get("NonMonDest_G2_Query"+i)+NonMonDest+"'";
			
			functions.verifyDatabaseRowValuesDynamically(regionvalue, query, G2DBExpected[i]);
		}
		}
	}
	/*public void EnterCalendar(String strDataFileName, RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename)
	{

		String winhandleBefore = webDriver.getWindowHandle();
		// Click on Add Button
		stepExecutor.clickElement("findelementByXpath", "//td[input[@id='generationTransmissionCalendar']]/input[2]", "Calendar Icon", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(30);


		//Utilities.setEnvironmentVariable("MainWindow", winhandleBefore);
		// Window handle
		Set <String> winHandles = webDriver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		String strcurrentWinHandle = null;
		if(it.hasNext()){
			strcurrentWinHandle = it.next();
			if(strcurrentWinHandle.equals(winhandleBefore)){
				strcurrentWinHandle = it.next();
				webDriver.switchTo().window(strcurrentWinHandle);
			}else{
				webDriver.switchTo().window(strcurrentWinHandle);
			}
		} 

		stepExecutor.enterTextValue("findElementById", "name", strDataFileName, "TextBox_TransmissionCalendar", webDriver, reporter, strReportFilename);
		stepExecutor.clickElement("findElementByXpath", "//td[input[@id='name']]/input[2]", "Calendar Search", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(5);
		//Selecting the searched calendar
		stepExecutor.changeRadioButtonStatus("findElementByXpath", "html/body/form/table[2]/tbody/tr[2]/td[1]/input", strDataFileName, "Radio_Select", webDriver, reporter, strReportFilename);
		stepExecutor.clickElement("findElementByXpath", "//tbody[tr[td[input[@id='name']]]]/tr[6]/td[1]/input[1]", "Select Button", webDriver, reporter, strReportFilename);
		//stepExecutor.clickElement("findElementByXpath", "//tbody[tr[td[input[@id='name']]]]/tr[6]/td[1]/input[1]", "Select Button", webDriver, reporter, strReportFilename);



		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");

			webDriver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println(" Accquirer Dest Failed----" + ee1.getMessage());
		}

	}


	
	public void addALLFileCutTimes(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		//Select File Cut Time1
		stepExecutor.selectListValue("findElementById", "fileCutTime1", strDataFileName, "ListBox_FileCutTime1", webDriver, reporter, strReportFilename);

		//Select File Cut Time2
		stepExecutor.selectListValue("findElementById", "fileCutTime2", strDataFileName, "ListBox_FileCutTime2", webDriver, reporter, strReportFilename);

		//Select File Cut Time3
		stepExecutor.selectListValue("findElementById", "fileCutTime3", strDataFileName, "ListBox_FileCutTime3", webDriver, reporter, strReportFilename);

		//Select File Cut Time4
		stepExecutor.selectListValue("findElementById", "fileCutTime4", strDataFileName, "ListBox_FileCutTime4", webDriver, reporter, strReportFilename);

		//Select File Cut Time5
		stepExecutor.selectListValue("findElementById", "fileCutTime5", strDataFileName, "ListBox_FileCutTime5", webDriver, reporter, strReportFilename);

		//Select File Cut Time6
		stepExecutor.selectListValue("findElementById", "fileCutTime6", strDataFileName, "ListBox_FileCutTime6", webDriver, reporter, strReportFilename);

		//Click Add Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Add'])[2]", "Add Cut Time", webDriver, reporter, strReportFilename);	
	}

	public void add3FileCutTimes(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		//Select File Cut Time1
		stepExecutor.selectListValue("findElementById", "fileCutTime1", strDataFileName, "ListBox_FileCutTime1", webDriver, reporter, strReportFilename);

		//Select File Cut Time2
		stepExecutor.selectListValue("findElementById", "fileCutTime2", strDataFileName, "ListBox_FileCutTime2", webDriver, reporter, strReportFilename);

		//Select File Cut Time3
		stepExecutor.selectListValue("findElementById", "fileCutTime3", strDataFileName, "ListBox_FileCutTime3", webDriver, reporter, strReportFilename);

		//Click Add Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Add'])[2]", "Add Cut Time", webDriver, reporter, strReportFilename);	
	}

	public void updateGFC2013NonMonDest1(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		// Click on Edit  Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Edit'])[1]", "Edit", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(10);

		//Select Layout
		stepExecutor.selectListValue("findElementById", "layout", strDataFileName, "ListBox_layout", webDriver, reporter, strReportFilename);

		// Select Destination Endpoint
		stepExecutor.selectListValue("findElementById", "destinationEndPoint", strDataFileName, "ListBox_destinationEndPoint", webDriver, reporter, strReportFilename);

		// Select Transmission Method
		stepExecutor.selectListValue("findElementById", "transmissionMethod", strDataFileName, "ListBox_transmissionMethod", webDriver, reporter, strReportFilename);

		// Click on Save Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Save'])[1]", "Save Monetary Dest", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		// Verify Confirm Message                                   
		stepExecutor.waitForElementToDisplay("findElementByXPath", "//span[contains(text(),'Successfully updated the Non Monetary Destination.')]", webDriver, reporter, strReportFilename);
		verificationFunctions.verifyElementTextPresent(webDriver, "//span[contains(text(),'Successfully updated the Non Monetary Destination.')]", "xpath", strDataFileName, "Verfy_Sucess_Message", reporter, strReportFilename);
	}

	public void updateGFC2013NonMonDest2(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		// Click on Edit  Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Edit'])[1]", "Edit", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(10);

		//Select Layout
		stepExecutor.selectListValue("findElementById", "layout", strDataFileName, "ListBox_layout", webDriver, reporter, strReportFilename);

		//Add Records
		addRecordTypes(strDataFileName, webDriver, reporter, strReportFilename);

		// Click on Add Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Save'])[1]", "Save Monetary Dest", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		// Verify Confirm Message                                   
		stepExecutor.waitForElementToDisplay("findElementByXPath", "//span[contains(text(),'Successfully updated the Non Monetary Destination.')]", webDriver, reporter, strReportFilename);
		verificationFunctions.verifyElementTextPresent(webDriver, "//span[contains(text(),'Successfully updated the Non Monetary Destination.')]", "xpath", strDataFileName, "Verfy_Sucess_Message", reporter, strReportFilename);
	}

	public void updateGlobalAuthNonMonDest1(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		// Click on Edit  Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Edit'])[1]", "Edit", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(10);

		//Select Card Number Masking
		stepExecutor.selectListValue("findElementByName", "cardNumberMasking", strDataFileName, "ListBox_cardNumberMasking", webDriver, reporter, strReportFilename);

		//Select Layout
		stepExecutor.selectListValue("findElementById", "layout", strDataFileName, "ListBox_layout", webDriver, reporter, strReportFilename);

		//Add Records
		addRecordTypesForGlobalAuthCustom(strDataFileName, webDriver, reporter, strReportFilename);

		//Select Destination Endpoint
		stepExecutor.selectListValue("findElementById", "destinationEndPoint", strDataFileName, "ListBox_destinationEndPoint", webDriver, reporter, strReportFilename);

		//Select Transmission Method
		stepExecutor.selectListValue("findElementById", "transmissionMethod", strDataFileName, "ListBox_transmissionMethod", webDriver, reporter, strReportFilename);

		//Select Empty File Generation
		stepExecutor.selectListValue("findElementById", "emptyFileGenerationId", strDataFileName, "ListBox_EmptyFile_Value", webDriver, reporter, strReportFilename);

		//Update Exception Details
		fillExceptionDetails(strDataFileName, webDriver, reporter, strReportFilename);

		//Update  Holiday Processing
		holidayProcessDetails(strDataFileName, webDriver, "Create the File", reporter, strReportFilename);

		//Add Cut Times
		addALLFileCutTimes(strDataFileName, webDriver, reporter, strReportFilename);

		// Click on Add Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Save'])[1]", "Save Monetary Dest", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		// Verify Confirm Message                                   
		stepExecutor.waitForElementToDisplay("findElementByXPath", "//span[contains(text(),'Successfully updated the Non Monetary Destination.')]", webDriver, reporter, strReportFilename);
		verificationFunctions.verifyElementTextPresent(webDriver, "//span[contains(text(),'Successfully updated the Non Monetary Destination.')]", "xpath", strDataFileName, "Verfy_Sucess_Message", reporter, strReportFilename);
	}

	public void updateGlobal2004NonMonDest1(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		// Click on Edit  Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Edit'])[1]", "Edit", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(10);

		//Select Layout
		stepExecutor.selectListValue("findElementById", "layout", strDataFileName, "ListBox_layout", webDriver, reporter, strReportFilename);

		//Add Records
		addRecordTypesForGlobalAuthCustom(strDataFileName, webDriver, reporter, strReportFilename);

		// Select Destination Endpoint
		stepExecutor.selectListValue("findElementById", "destinationEndPoint", strDataFileName, "ListBox_destinationEndPoint", webDriver, reporter, strReportFilename);

		// Select Transmission Method
		stepExecutor.selectListValue("findElementById", "transmissionMethod", strDataFileName, "ListBox_transmissionMethod", webDriver, reporter, strReportFilename);

		// Click on Add Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Save'])[1]", "Save Monetary Dest", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		// Verify Confirm Message                                   
		stepExecutor.waitForElementToDisplay("findElementByXPath", "//span[contains(text(),'Successfully updated the Non Monetary Destination.')]", webDriver, reporter, strReportFilename);
		verificationFunctions.verifyElementTextPresent(webDriver, "//span[contains(text(),'Successfully updated the Non Monetary Destination.')]", "xpath", strDataFileName, "Verfy_Sucess_Message", reporter, strReportFilename);
	}

	public void updateGlobal2004NonMonDest2(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		// Click on Edit  Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Edit'])[1]", "Edit", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(10);

		//Select Layout
		stepExecutor.selectListValue("findElementById", "layout", strDataFileName, "ListBox_layout", webDriver, reporter, strReportFilename);

		//Add Records
		addRecordTypesForGlobalAuthCustom(strDataFileName, webDriver, reporter, strReportFilename);

		// Click on Add Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Save'])[1]", "Save Monetary Dest", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		// Verify Confirm Message                                   
		stepExecutor.waitForElementToDisplay("findElementByXPath", "//span[contains(text(),'Successfully updated the Non Monetary Destination.')]", webDriver, reporter, strReportFilename);
		verificationFunctions.verifyElementTextPresent(webDriver, "//span[contains(text(),'Successfully updated the Non Monetary Destination.')]", "xpath", strDataFileName, "Verfy_Sucess_Message", reporter, strReportFilename);
	}

	public void updateExceptionValues(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		//Select Day 1 Processing File Creation Options
		stepExecutor.selectListValue("findElementById", "day1CreateOpts", strDataFileName, "ListBox_Day1CreateOps", webDriver, reporter, strReportFilename);

		//Select Day1 Processing File Transmission Options 
		stepExecutor.selectListValue("findElementById", "day1TransOpts", strDataFileName, "ListBox_Day1TransOps", webDriver, reporter, strReportFilename);

		//Select Day 2 Processing File Creation Options
		stepExecutor.selectListValue("findElementById", "day2CreateOpts", strDataFileName, "ListBox_Day2CreateOps", webDriver, reporter, strReportFilename);

		//Select Day 2 Processing File Transmission Options 
		stepExecutor.selectListValue("findElementById", "day2TransOpts", strDataFileName, "ListBox_Day2TransOps", webDriver, reporter, strReportFilename);
	}

	public void updateHolidayValues(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){
		//Select File Creation Options
		stepExecutor.selectListValue("findElementById", "holidayCreateOptsId", strDataFileName, "ListBox_HolidayCreateOpts", webDriver, reporter, strReportFilename);
		//Select File Transmission Options
		stepExecutor.selectListValue("findElementById", "holidayTransOptsId", strDataFileName, "ListBox_holidayTransOptsId", webDriver, reporter, strReportFilename);	
	}

	public void updateEffectiveDateTime(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){
		//Enter Effective Date
		stepExecutor.enterTextValue("findElementById", "fileFormatEffDateStr", strDataFileName, "TextBox_fileFormatEffDateStr", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(5);
		//Enter Effective Time
		stepExecutor.enterTextValue("findElementById", "fileFormatEffDateTime", strDataFileName, "TextBox_fileFormatEffDateTime", webDriver, reporter, strReportFilename);
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
	
	public void verifyCMFDB(String strDataFileName, String strReportFilename, String MonOrNon){
		stepExecutor.globalWait(20);
		//String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");
		String DateValue = Utilities.getEnvironmentVariable("UpdatedDate");
	
		
		System.out.println("DateValue"+DateValue);
		String strQuery = "";
		//Verify processed flag and Entity Action in SSI_REPLICATION_MESSAGE
		strQuery = "select processed_flag, Entity_action from ssi_replication_message where ENTITY_TYPE = '"+MonOrNon+"' and time_stamp >= to_date('"+DateValue+":00','mm/dd/yyyy hh24:mi:ss')";
		System.out.println("Query 1"+strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFilename);
		
		//Verify processed flag and Entity Action in SSI_REPLICATION_Items
		strQuery = "select processed_flag, Entity_action from ssi_replication_items where ENTITY_TYPE = '"+MonOrNon+"' and time_stamp >= to_date('"+DateValue+":00','mm/dd/yyyy hh24:mi:ss')";
		System.out.println("Query 2"+strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFilename);

		}
	
public void verifyDBMonetaryValuesG2(String strDataFileName, String strReportFilename){
		
		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);
		
		String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");
		String DataTransFileName = Utilities.getEnvironmentVariable("GCF13_NONMON");
		String DatatransDirectory = scriptExecutor.readDataFile(strDataFileName, rowNumber, "TextBox_dataTransDirectory");
		String ExpectedValues = strMonDest + "@@" + DataTransFileName + "@@" + DatatransDirectory;
		
		String strQuery = null;
		stepExecutor.globalWait(65);
		//Verify Destination name, Data trans file name, data trans Directory
		strQuery="select NAME, OUTPUT_FILE_NAME,DT_DIRECTORY from EDC_nmon_dest where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValuesExpectedDynamic("DBDetailsG2", strQuery, ExpectedValues, strDataFileName, reporter, strReportFilename);
		
		strQuery="select DEST_ENDPOINT, TRANS_METHOD, FILE_HEADER_TEXT, EMPTY_FILE_IND from EDC_nmon_dest where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues1", reporter, strReportFilename);
		
		strQuery="select WK_END_1, WK_END1_CREATE_IND, WK_END1_XMIT_IND, WK_END_2, WK_END2_CREATE_IND, WK_END2_XMIT_IND from EDC_nmon_dest where name='"+strMonDest+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues2", reporter, strReportFilename);
				
		strQuery="select CREATE_CALENDAR_ID, HOLIDAY_CREATE_IND, HOLIDAY_XMIT_IND from EDC_nmon_dest where name='"+strMonDest+"'";
		System.out.println(strQuery);
		//verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues3", reporter, strReportFilename);
	
		//Get Settle ID from application
		strQuery="select settle_id from EDC_nmon_dest where name='"+strMonDest+"'";
		System.out.println(strQuery);
		String Settle_ID = verificationFunctions.getValueFromDatabase("DBDetailsG2", strQuery, strDataFileName, reporter, strReportFilename);
		System.out.println(Settle_ID);
		//validate Cut Times
		strQuery = "select Cut_time from edc_nmon_cut_times where settle_id ='"+Settle_ID+"'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseRowValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues4", reporter, strReportFilename);
		
		
		//GCF_File_Records
		strQuery="select GCF_File_Records from EDC_nmon_dest where name='"+strMonDest+"'";
		verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues5", reporter, strReportFilename);

	}

public void verifyDBMonetaryValuesG2Updated(String strDataFileName, String strReportFilename){
	
	int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);
	
	String strMonDest = Utilities.getEnvironmentVariable("MonDest1US");
	String DataTransFileName = Utilities.getEnvironmentVariable("GCF13_NONMON");
	String DatatransDirectory = scriptExecutor.readDataFile(strDataFileName, rowNumber, "TextBox_dataTransDirectory");
	String ExpectedValues = strMonDest + "@@" + DataTransFileName + "@@" + DatatransDirectory;
	
	String strQuery = null;
	stepExecutor.globalWait(65);
	//Verify Destination name, Data trans file name, data trans Directory
	strQuery="select NAME, OUTPUT_FILE_NAME,DT_DIRECTORY from EDC_nmon_dest where name='"+strMonDest+"'";
	System.out.println(strQuery);
	verificationFunctions.verifyDatabaseValuesExpectedDynamic("DBDetailsG2", strQuery, ExpectedValues, strDataFileName, reporter, strReportFilename);
	
	strQuery="select DEST_ENDPOINT, TRANS_METHOD, FILE_HEADER_TEXT, EMPTY_FILE_IND from EDC_nmon_dest where name='"+strMonDest+"'";
	System.out.println(strQuery);
	verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues1", reporter, strReportFilename);
	
	strQuery="select WK_END_1, WK_END1_CREATE_IND, WK_END1_XMIT_IND, WK_END_2, WK_END2_CREATE_IND, WK_END2_XMIT_IND from EDC_nmon_dest where name='"+strMonDest+"'";
	System.out.println(strQuery);
	verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues2", reporter, strReportFilename);
			
	strQuery="select CREATE_CALENDAR_ID, HOLIDAY_CREATE_IND, HOLIDAY_XMIT_IND from EDC_nmon_dest where name='"+strMonDest+"'";
	System.out.println(strQuery);
	//verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues3", reporter, strReportFilename);

	//Get Settle ID from application
	strQuery="select settle_id from EDC_nmon_dest where name='"+strMonDest+"'";
	System.out.println(strQuery);
	String Settle_ID = verificationFunctions.getValueFromDatabase("DBDetailsG2", strQuery, strDataFileName, reporter, strReportFilename);
	System.out.println(Settle_ID);
	//validate Cut Times
	strQuery = "select Cut_time from edc_nmon_cut_times where settle_id ='"+Settle_ID+"'";
	System.out.println(strQuery);
	verificationFunctions.verifyDatabaseRowValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues4", reporter, strReportFilename);
	
	
	//GCF_File_Records
	strQuery="select GCF_File_Records from EDC_nmon_dest where name='"+strMonDest+"'";
	verificationFunctions.verifyDatabaseValues("DBDetailsG2", strQuery, strDataFileName, "G2DBValues6", reporter, strReportFilename);

}
	public void saveNonMonetaryDest(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){
		// Click on Add Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Add'])[1]", "Add Monetary Dest", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		// Verify Confirm Message                                   
		stepExecutor.waitForElementToDisplay("findElementByXPath", "//span[contains(text(),'Successfully created the Non Monetary Destination.')]", webDriver, reporter, strReportFilename);
		verificationFunctions.verifyElementTextPresent(webDriver, "//span[contains(text(),'Successfully created the Non Monetary Destination.')]", "xpath", strDataFileName, "Verfy_Sucess_Message", reporter, strReportFilename);
	}

	public void verifyDBNonMonetaryValuesUS(String strDataFileName, String strReportFilename){

		String strNonMonDest = Utilities.getEnvironmentVariable("NonMonDest1US");

		String strQuery = null;

		// Verify Data File Format Values
		strQuery = "SELECT ddt.business_term         card_number_masking,nmd.dest_file_format_name,ddtl.business_term        layout FROM non_mon_destination_view nmd,data_dict_bus_terms      ddt,data_dict_bus_terms      ddtl WHERE nmd.non_mon_dest_name = '" + strNonMonDest + "' AND nmd.card_number_masking = ddt.business_term_id AND nmd.layout = ddtl.business_term_id and rownum=1"; 
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFilename);

		strQuery = "SELECT destination_end_point_desc destination_end_point,transmission_method_desc transmission_method,decode(is_empty_file_generation, 'Y', 'Yes', 'N', 'No') is_empty_file_generation FROM non_mon_destination_view WHERE non_mon_dest_name = '" + strNonMonDest + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues2", reporter, strReportFilename);

		//Verify Exception Values
		strQuery="Select decode(IS_EXCEPT_FILE_CREATE1, 'Y', 'Yes', 'N', 'No'),decode(IS_EXCEPT_TRANSMIT1, 'Y', 'Yes', 'N', 'No'),decode(IS_EXCEPT_FILE_CREATE2, 'Y', 'Yes', 'N', 'No'),decode(IS_EXCEPT_TRANSMIT2, 'Y', 'Yes', 'N', 'No') From NON_MON_DESTINATION_VIEW where NON_MON_DEST_NAME= '" + strNonMonDest + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues3", reporter, strReportFilename);

		//Verify Holiday Processing Values
		strQuery = "Select decode(IS_HOLIDAY_FILE_CREATE, 'Y', 'Yes', 'N', 'No'),decode(IS_HOLIDAY_FILE_TRANSMIT, 'Y', 'Yes', 'N', 'No') From NON_MON_DESTINATION_VIEW where NON_MON_DEST_NAME= '" + strNonMonDest + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues4", reporter, strReportFilename);
	}

	public void verifyDBNonMonetaryValuesAP(String strDataFileName, String strReportFilename){

		String strMonDest = Utilities.getEnvironmentVariable("MonDest1AP");

		String strQuery = null;

		// Verify Data File Format Values
		strQuery = "SELECT ddsv.specification_name dest_datafile_format_spec_id,mdv.destination_endpoint_desc destination_endpoint,mdv.transmission_method_desc transmission_method,decode(mdv.empty_file_generation, 'Y', 'Yes', 'N', 'No') empty_file_generation,ddbd.business_term eds_deposit_date FROM mon_destination_view    mdv,dest_datafile_spec_view ddsv,data_dict_bus_terms     ddbd WHERE destination_name = '" + strMonDest + "'AND mdv.dest_datafile_format_spec_id = ddsv.specification_id AND mdv.eds_deposit_date = ddbd.business_term_id and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues1", reporter, strReportFilename);

		//Verify Exception Values
		strQuery = "Select EXCEP_PROC_DAY1_FILE_CREATE,EXCEP_PROC_DAY1_FILE_TRANSMIT,EXCEP_PROC_DAY2_FILE_CREATE,EXCEP_PROC_DAY2_FILE_TRANSMIT FROM MON_DESTINATION_VIEW  WHERE DESTINATION_NAME= '" + strMonDest + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues2", reporter, strReportFilename);

		//Verify Holiday Processing Values
		strQuery = "Select HOLIDAY_PROCESS_FILE_CREATE,HOLIDAY_PROCESS_FILE_TRANSMIT from MON_DESTINATION_VIEW WHERE DESTINATION_NAME= '" + strMonDest + "' and rownum=1";
		verificationFunctions.verifyDatabaseValues("DBDetails", strQuery, strDataFileName, "DBValues3", reporter, strReportFilename);
	}
	public void addRecordTypes1(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		String winhandleBefore = webDriver.getWindowHandle();
		//Select Records Types
		stepExecutor.clickButton("findElementById", "selRecBtn", "Select Record", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(8); 

		// Window handle
		Set <String> winHandles = webDriver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		String strcurrentWinHandle = null;
		if(it.hasNext()){
			strcurrentWinHandle = it.next();
			if(strcurrentWinHandle.equals(winhandleBefore)){
				strcurrentWinHandle = it.next();
				webDriver.switchTo().window(strcurrentWinHandle);
			}else{
				webDriver.switchTo().window(strcurrentWinHandle);
			}
		} 

		//Check checkbox Record Types 



		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[2]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[3]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
		//stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[5]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);


		int counter = 0;
		while(webDriver.findElementsByXPath("(//input[@value='Select'])[1]").size()<=0){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!webDriver.findElementByXPath("(//input[@value='Select'])[1]").isDisplayed()){

			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");

			webDriver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}

		//Verify Record Type Values
		//verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value", reporter, strReportFilename);

	}

	public void addRecordTypesPurchaseCardLevel(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		String winhandleBefore = webDriver.getWindowHandle();
		//Select Records Types
		stepExecutor.clickButton("findElementByXPath", "//input[@id='selRecBtn']", "Select Record", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(8); 

		// Window handle
		Set <String> winHandles = webDriver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		String strcurrentWinHandle = null;
		if(it.hasNext()){
			strcurrentWinHandle = it.next();
			if(strcurrentWinHandle.equals(winhandleBefore)){
				strcurrentWinHandle = it.next();
				webDriver.switchTo().window(strcurrentWinHandle);
			}else{
				webDriver.switchTo().window(strcurrentWinHandle);
			}
		} 

		//Check check box Record Types    
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[16]", "Record Type List", strDataFileName, "CheckBox_RecordType", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(1);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[17]", "xpath", "P2", strDataFileName, "verify_Checked", reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[18]", "xpath", "L1", strDataFileName, "verify_Checked", reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[19]", "xpath", "L2", strDataFileName, "verify_Checked", reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[20]", "xpath", "T1", strDataFileName, "verify_Checked", reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[21]", "xpath", "T2", strDataFileName, "verify_Checked", reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[22]", "xpath", "T3", strDataFileName, "verify_Checked", reporter, strReportFilename);



		int counter = 0;
		while(webDriver.findElementsByXPath("(//input[@value='Select'])[1]").size()<=0){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!webDriver.findElementByXPath("(//input[@value='Select'])[1]").isDisplayed()){

			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");

			webDriver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}

		//Verify Record Type Values
		//verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value", reporter, strReportFilename);

	}


	public void addRecordTypes(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		String winhandleBefore = webDriver.getWindowHandle();
		//Select Records Types
		stepExecutor.clickButton("findElementByXPath", "//input[@id='selRecBtn']", "Select Record", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(5); 

		// Window handle
		Set <String> winHandles = webDriver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		String strcurrentWinHandle = null;
		if(it.hasNext()){
			strcurrentWinHandle = it.next();
			if(strcurrentWinHandle.equals(winhandleBefore)){
				strcurrentWinHandle = it.next();
				webDriver.switchTo().window(strcurrentWinHandle);
			}else{
				webDriver.switchTo().window(strcurrentWinHandle);
			}
		} 

		//Check checkbox Record Types    
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[2]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[3]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[4]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[5]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);

		int counter = 0;
		while(webDriver.findElementsByXPath("(//input[@value='Select'])[1]").size()<=0){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!webDriver.findElementByXPath("(//input[@value='Select'])[1]").isDisplayed()){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");

			webDriver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}

		//Verify Record Type Values
		//verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value", reporter, strReportFilename);

	}

	public void addRecordTypesForGlobalAuthCustom(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		String winhandleBefore = webDriver.getWindowHandle();
		//Select Records Types
		stepExecutor.clickButton("findElementByXPath", "//input[@id='selRecBtn']", "Select Record", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(5); 

		// Window handle
		Set <String> winHandles = webDriver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		String strcurrentWinHandle = null;
		if(it.hasNext()){
			strcurrentWinHandle = it.next();
			if(strcurrentWinHandle.equals(winhandleBefore)){
				strcurrentWinHandle = it.next();
				webDriver.switchTo().window(strcurrentWinHandle);
			}else{
				webDriver.switchTo().window(strcurrentWinHandle);
			}
		} 

		//Check checkbox Record Types    
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[1]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[4]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[5]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[6]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[7]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);

		int counter = 0;
		while(webDriver.findElementsByXPath("(//input[@value='Select'])[1]").size()<=0){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!webDriver.findElementByXPath("(//input[@value='Select'])[1]").isDisplayed()){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");

			webDriver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}

		//Verify Record Type Values
		verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value1", reporter, strReportFilename);
		//Verify Record Type Values
		verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value2", reporter, strReportFilename);
		//Verify Record Type Values
		verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value3", reporter, strReportFilename);
		//Verify Record Type Values
		verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value4", reporter, strReportFilename);
		//Verify Record Type Values
		verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value5", reporter, strReportFilename);

	}

	public void addRecordTypes3_1(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		String winhandleBefore = webDriver.getWindowHandle();
		//Select Records Types
		stepExecutor.clickButton("findElementByXPath", "//input[@id='selRecBtn']", "Select Record", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(8); 

		// Window handle
		Set <String> winHandles = webDriver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		String strcurrentWinHandle = null;
		if(it.hasNext()){
			strcurrentWinHandle = it.next();
			if(strcurrentWinHandle.equals(winhandleBefore)){
				strcurrentWinHandle = it.next();
				webDriver.switchTo().window(strcurrentWinHandle);
			}else{
				webDriver.switchTo().window(strcurrentWinHandle);
			}
		} 

		//Check checkbox Record Types 
	
		for(int i=2;i<=4;i++)
			stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])["+i+"]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
		
		
		stepExecutor.globalWait(3);
		int counter = 0;
		while(webDriver.findElementsByXPath("(//input[@value='Select'])[1]").size()<=0){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!webDriver.findElementByXPath("(//input[@value='Select'])[1]").isDisplayed()){

			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		stepExecutor.globalWait(3);
		//stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		//stepExecutor.globalWait(5);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");

			webDriver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}

		//Verify Record Type Values
		//verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value", reporter, strReportFilename);

	}
	
	public void addRecordTypes3_2(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		String winhandleBefore = webDriver.getWindowHandle();
		//Select Records Types
		stepExecutor.clickButton("findElementByXPath", "//input[@id='selRecBtn']", "Select Record", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(8); 

		// Window handle
		Set <String> winHandles = webDriver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		String strcurrentWinHandle = null;
		if(it.hasNext()){
			strcurrentWinHandle = it.next();
			if(strcurrentWinHandle.equals(winhandleBefore)){
				strcurrentWinHandle = it.next();
				webDriver.switchTo().window(strcurrentWinHandle);
			}else{
				webDriver.switchTo().window(strcurrentWinHandle);
			}
		} 

		//Check checkbox Record Types 
	
		for(int i=2;i<=14;i++)
			stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])["+i+"]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
		
		
		stepExecutor.globalWait(3);
		int counter = 0;
		while(webDriver.findElementsByXPath("(//input[@value='Select'])[1]").size()<=0){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!webDriver.findElementByXPath("(//input[@value='Select'])[1]").isDisplayed()){

			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		stepExecutor.globalWait(3);
		//stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		//stepExecutor.globalWait(5);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");

			webDriver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}

		//Verify Record Type Values
		//verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value", reporter, strReportFilename);

	}
	
	public void addRecordTypesP1_P2(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		String winhandleBefore = webDriver.getWindowHandle();
		//Select Records Types
		stepExecutor.clickButton("findElementByXPath", "//input[@id='selRecBtn']", "Select Record", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(8); 

		// Window handle
		Set <String> winHandles = webDriver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		String strcurrentWinHandle = null;
		if(it.hasNext()){
			strcurrentWinHandle = it.next();
			if(strcurrentWinHandle.equals(winhandleBefore)){
				strcurrentWinHandle = it.next();
				webDriver.switchTo().window(strcurrentWinHandle);
			}else{
				webDriver.switchTo().window(strcurrentWinHandle);
			}
		} 

		//Check check box Record Types    
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[17]", "Record Type List", strDataFileName, "CheckBox_RecordType", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(1);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[16]", "xpath", "P1", strDataFileName, "verify_Checked", reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[17]", "Record Type List", strDataFileName, "CheckBox_RecordType_uncheck", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[16]", "Record Type List", strDataFileName, "CheckBox_RecordType", webDriver, reporter, strReportFilename);



		int counter = 0;
		while(webDriver.findElementsByXPath("(//input[@value='Select'])[1]").size()<=0){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!webDriver.findElementByXPath("(//input[@value='Select'])[1]").isDisplayed()){

			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");

			webDriver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}

		//Verify Record Type Values
		//verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value", reporter, strReportFilename);

	}

	public void addRecordTypesL1_L2(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		String winhandleBefore = webDriver.getWindowHandle();
		//Select Records Types
		stepExecutor.clickButton("findElementByXPath", "//input[@id='selRecBtn']", "Select Record", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(8); 

		// Window handle
		Set <String> winHandles = webDriver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		String strcurrentWinHandle = null;
		if(it.hasNext()){
			strcurrentWinHandle = it.next();
			if(strcurrentWinHandle.equals(winhandleBefore)){
				strcurrentWinHandle = it.next();
				webDriver.switchTo().window(strcurrentWinHandle);
			}else{
				webDriver.switchTo().window(strcurrentWinHandle);
			}
		} 

		//Check check box Record Types    
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[18]", "Record Type List", strDataFileName, "CheckBox_RecordType", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(1);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[19]", "xpath", "L2", strDataFileName, "verify_Checked", reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[18]", "Record Type List", strDataFileName, "CheckBox_RecordType_uncheck", webDriver, reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[19]", "xpath", "L2", strDataFileName, "verify_Unchecked", reporter, strReportFilename);

		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[19]", "Record Type List", strDataFileName, "CheckBox_RecordType", webDriver, reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[18]", "xpath", "L1", strDataFileName, "verify_Checked", reporter, strReportFilename);




		int counter = 0;
		while(webDriver.findElementsByXPath("(//input[@value='Select'])[1]").size()<=0){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!webDriver.findElementByXPath("(//input[@value='Select'])[1]").isDisplayed()){

			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");

			webDriver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}

		//Verify Record Type Values
		//verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value", reporter, strReportFilename);

	}
	public void addRecordTypesT1T2T3(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		String winhandleBefore = webDriver.getWindowHandle();
		//Select Records Types
		stepExecutor.clickButton("findElementByXPath", "//input[@id='selRecBtn']", "Select Record", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(8); 

		// Window handle
		Set <String> winHandles = webDriver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		String strcurrentWinHandle = null;
		if(it.hasNext()){
			strcurrentWinHandle = it.next();
			if(strcurrentWinHandle.equals(winhandleBefore)){
				strcurrentWinHandle = it.next();
				webDriver.switchTo().window(strcurrentWinHandle);
			}else{
				webDriver.switchTo().window(strcurrentWinHandle);
			}
		} 

		//Check check box Record Types T1 Selections  
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[20]", "Record Type List", strDataFileName, "CheckBox_RecordType", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(1);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[21]", "xpath", "T2", strDataFileName, "verify_Checked", reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[22]", "xpath", "T3", strDataFileName, "verify_Checked", reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[20]", "Record Type List", strDataFileName, "CheckBox_RecordType_uncheck", webDriver, reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[21]", "xpath", "T2", strDataFileName, "verify_Unchecked", reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[22]", "xpath", "T3", strDataFileName, "verify_Unchecked", reporter, strReportFilename);

		//Check check box Record Types T2 Selections  
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[21]", "Record Type List", strDataFileName, "CheckBox_RecordType", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(1);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[20]", "xpath", "T1", strDataFileName, "verify_Checked", reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[22]", "xpath", "T3", strDataFileName, "verify_Checked", reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[21]", "Record Type List", strDataFileName, "CheckBox_RecordType_uncheck", webDriver, reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[20]", "xpath", "T1", strDataFileName, "verify_Unchecked", reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[22]", "xpath", "T3", strDataFileName, "verify_Unchecked", reporter, strReportFilename);



		//Check check box Record Types T2 Selections  
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[22]", "Record Type List", strDataFileName, "CheckBox_RecordType", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(1);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[20]", "xpath", "T1", strDataFileName, "verify_Checked", reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[21]", "xpath", "T2", strDataFileName, "verify_Checked", reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[22]", "Record Type List", strDataFileName, "CheckBox_RecordType_uncheck", webDriver, reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[20]", "xpath", "T1", strDataFileName, "verify_Unchecked", reporter, strReportFilename);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[21]", "xpath", "T2", strDataFileName, "verify_Unchecked", reporter, strReportFilename);

		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[22]", "Record Type List", strDataFileName, "CheckBox_RecordType", webDriver, reporter, strReportFilename);


		int counter = 0;
		while(webDriver.findElementsByXPath("(//input[@value='Select'])[1]").size()<=0){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!webDriver.findElementByXPath("(//input[@value='Select'])[1]").isDisplayed()){

			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");

			webDriver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}

		//Verify Record Type Values
		//verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value", reporter, strReportFilename);

	}

	public void addRecordTypes3(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		String winhandleBefore = webDriver.getWindowHandle();
		//Select Records Types
		stepExecutor.clickButton("findElementByXPath", "//input[@id='selRecBtn']", "Select Record", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(8); 

		// Window handle
		Set <String> winHandles = webDriver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		String strcurrentWinHandle = null;
		if(it.hasNext()){
			strcurrentWinHandle = it.next();
			if(strcurrentWinHandle.equals(winhandleBefore)){
				strcurrentWinHandle = it.next();
				webDriver.switchTo().window(strcurrentWinHandle);
			}else{
				webDriver.switchTo().window(strcurrentWinHandle);
			}
		}

		for(int i=5;i<=15;i++)
		{
			stepExecutor.changeCheckboxStatusWithoutScreenshot("findElementByXPath", "(//input[@name='recName'])["+i+"]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
			stepExecutor.globalWait(1);
			verificationFunctions.acceptAlertWithoutText(strDataFileName, "accept", webDriver, reporter, strReportFilename);
	
		}
		int counter = 0;
		while(webDriver.findElementsByXPath("(//input[@value='Select'])[1]").size()<=0){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!webDriver.findElementByXPath("(//input[@value='Select'])[1]").isDisplayed()){

			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");

			webDriver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}

		//Verify Record Type Values
		//verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value", reporter, strReportFilename);

	}
	
	public void addRecordTypes2(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		String winhandleBefore = webDriver.getWindowHandle();
		//Select Records Types
		stepExecutor.clickButton("findElementByXPath", "//input[@id='selRecBtn']", "Select Record", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(8); 

		// Window handle
		Set <String> winHandles = webDriver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		String strcurrentWinHandle = null;
		if(it.hasNext()){
			strcurrentWinHandle = it.next();
			if(strcurrentWinHandle.equals(winhandleBefore)){
				strcurrentWinHandle = it.next();
				webDriver.switchTo().window(strcurrentWinHandle);
			}else{
				webDriver.switchTo().window(strcurrentWinHandle);
			}
		} 

		//Check checkbox Record Types 


		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[2]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[3]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[4]", "Record Type List", strDataFileName, "CheckBox_Record_Types", webDriver, reporter, strReportFilename);


		int counter = 0;
		while(webDriver.findElementsByXPath("(//input[@value='Select'])[1]").size()<=0){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!webDriver.findElementByXPath("(//input[@value='Select'])[1]").isDisplayed()){

			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");

			webDriver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}

		//Verify Record Type Values
		//verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value", reporter, strReportFilename);

	}
	
	
	
	public void addRecordTypesAmerican(String strDataFileName,RemoteWebDriver webDriver, GridReporter reporter, String strReportFilename){

		String winhandleBefore = webDriver.getWindowHandle();
		//Select Records Types
		stepExecutor.clickButton("findElementByXPath", "//input[@id='selRecBtn']", "Select Record", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(8); 

		// Window handle
		Set <String> winHandles = webDriver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		String strcurrentWinHandle = null;
		if(it.hasNext()){
			strcurrentWinHandle = it.next();
			if(strcurrentWinHandle.equals(winhandleBefore)){
				strcurrentWinHandle = it.next();
				webDriver.switchTo().window(strcurrentWinHandle);
			}else{
				webDriver.switchTo().window(strcurrentWinHandle);
			}
		} 

		//Check check box Record Types    
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[3]", "Record Type List", strDataFileName, "CheckBox_RecordType", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[4]", "Record Type List", strDataFileName, "CheckBox_RecordType", webDriver, reporter, strReportFilename);
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[8]", "Record Type List", strDataFileName, "CheckBox_RecordType", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(1);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[9]", "xpath", "American Express Addendum", strDataFileName, "verify_Checked", reporter, strReportFilename);
		//To validate if getting unchecked
		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[8]", "Record Type List", strDataFileName, "CheckBox_RecordType_uncheck", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(1);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[9]", "xpath", "American Express Addendum", strDataFileName, "verify_Unchecked", reporter, strReportFilename);

		stepExecutor.changeCheckboxStatus("findElementByXPath", "(//input[@name='recName'])[9]", "Record Type List", strDataFileName, "CheckBox_RecordType", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(1);
		verificationFunctions.verifyCheckboxStatus(webDriver, "(//input[@name='recName'])[8]", "xpath", "American Express Addendum", strDataFileName, "verify_Checked", reporter, strReportFilename);


		int counter = 0;
		while(webDriver.findElementsByXPath("(//input[@value='Select'])[1]").size()<=0){
			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		counter = 0;
		while(!webDriver.findElementByXPath("(//input[@value='Select'])[1]").isDisplayed()){

			stepExecutor.globalWait(1);
			counter++;
			if(counter==60){
				break;
			}
		}
		// Click on Select Button
		stepExecutor.clickButton("findElementByXPath", "(//input[@value='Select'])[1]", "Select", webDriver, false, reporter, strReportFilename);
		stepExecutor.globalWait(10);
		try{
			//String strWinHandle = Utilities.getEnvironmentVariable("MainWindow");

			webDriver.switchTo().window(winhandleBefore);
		}catch(Exception ee1){
			System.out.println("Adding Record Type Failed ----" + ee1.getMessage());
		}

		//Verify Record Type Values
		//verificationFunctions.verifyColumnValues(webDriver, strDataFileName, "Verify_RecordTypes_Value", reporter, strReportFilename);

	}
	public void assignCardTypes1(String strDataFileName,RemoteWebDriver webDriver, int strcardTypes,  GridReporter reporter, String strReportFilename){

		//Select Card Types
		stepExecutor.selectListValue("findElementByName", "availableCardTypes", strDataFileName, "ListBox_CardTypes_"+strcardTypes, webDriver, reporter, strReportFilename);

		//Click Button
		stepExecutor.clickButtonWithoutScreenshot("findElementByXPath", "//input[@value='>']", "select", webDriver, reporter, strReportFilename);	
	}
	public void verifyDBNonMonetaryValuesG2Update(String strDataFileName, String strReportFilename){

		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);
		
		String strMonDest = Utilities.getEnvironmentVariable("MonDestName");
		String DataTransFileName = Utilities.getEnvironmentVariable("strDataTransFileNew");
		String DatatransDirectory = Utilities.getEnvironmentVariable("strdataTransDirectoryNew");
		String ExpectedValues = strMonDest + "@@" + DataTransFileName + "@@" + DatatransDirectory;

		String strQuery = null;
		stepExecutor.globalWait(65);
		//Verify Destination name, Data trans file name, data trans Directory
		strQuery="select NAME, OUTPUT_FILE_NAME,DT_DIRECTORY from EDC_nmon_dest where name like'%"+strMonDest+"%'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValuesExpectedDynamic("DBDetailsG2", strQuery, ExpectedValues, strDataFileName, reporter, strReportFilename);

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
	public void verifyDBNonMonetaryValuesG2Deleted(String strDataFileName, String strReportFilename){

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
		verificationFunctions.verifyDatabaseValuesDeleted("DBDetailsG2", strQuery, ExpectedValues, strDataFileName, reporter, strReportFilename);

	
	}
	public void verifyMonetaryValuesG2Deleted(String strDataFileName, String strReportFilename){

		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);

		String strMonDest = Utilities.getEnvironmentVariable("MonDestName");
		String DataTransFileName = Utilities.getEnvironmentVariable("DataTransFile");
		String DatatransDirectory = Utilities.getEnvironmentVariable("dataTransDirectoryPrevious");
		String ExpectedValues = strMonDest + "@@" + DataTransFileName + "@@" + DatatransDirectory;

		String strQuery = null;
		stepExecutor.globalWait(65);
		//Verify Destination name, Data trans file name, data trans Directory

		strQuery="select DESTINATION_NAME,DATATRANS_FILENAME,DATATRANS_DIRECTORY from mon_destination_view where DESTINATION_NAME like'%"+strMonDest+"%'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValuesExpectedDynamic("DBDetails", strQuery, ExpectedValues, strDataFileName, reporter, strReportFilename);

	
	}
	public void removeCardTypes(String strDataFileName,RemoteWebDriver webDriver, String strcardTypes,  GridReporter reporter, String strReportFilename){

		//Select Card Types
		stepExecutor.selectListValue("findElementByName", "cardTypes", strDataFileName, "ListBox_CardTypes_"+strcardTypes, webDriver, reporter, strReportFilename);

		//Click Button
		stepExecutor.clickButton("findElementByXPath", "//input[@value='<']", "select", webDriver, reporter, strReportFilename);	
	}
	public void verifyDBNonStandardValuesG2(String strDataFileName, String strReportFilename){

		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);

		String strMonDest = Utilities.getEnvironmentVariable("MonDestName");
		String DataTransFileName = Utilities.getEnvironmentVariable("DataTranFile");
		String DatatransDirectory = Utilities.getEnvironmentVariable("dataTransDirectoryPrevious");
		

		String ExpectedValues = strMonDest + "@@" + DataTransFileName + "@@" + DatatransDirectory;

		String strQuery = null;
		stepExecutor.globalWait(65);
		//Verify Destination name, Data trans file name, data trans Directory
		strQuery="select NON_STANDARD_DEST_NAME,DATATRANS_FILENAME,DATATRANS_DIRECTORY from non_standard_destination_view where NON_STANDARD_DEST_NAME like'%"+strMonDest+"%'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValuesExpectedDynamic("DBDetails", strQuery, ExpectedValues, strDataFileName, reporter, strReportFilename);

	
	}
	public void verifyDBNonStandardValuesCMFDeleted(String strDataFileName, String strReportFilename){

		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);

		String strMonDest = Utilities.getEnvironmentVariable("MonDestName");
		String DataTransFileName = Utilities.getEnvironmentVariable("DataTranFile");
		String DatatransDirectory = Utilities.getEnvironmentVariable("dataTransDirectoryPrevious");
		String ExpectedValues = strMonDest + "@@" + DataTransFileName + "@@" + DatatransDirectory;

		String strQuery = null;
		stepExecutor.globalWait(65);
		//Verify Destination name, Data trans file name, data trans Directory
		strQuery="select NON_STANDARD_DEST_NAME,DATATRANS_FILENAME,DATATRANS_DIRECTORY from non_standard_destination_view where NON_STANDARD_DEST_NAME like'%"+strMonDest+"%'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValuesDeleted("DBDetails", strQuery, ExpectedValues, strDataFileName, reporter, strReportFilename);

	}
	public void verifyDBNonStandardValuesCMFUpdate(String strDataFileName, String strReportFilename){

		int rowNumber = executionRowNumber.getExecutionRowNumber(strDataFileName);
		
		String strMonDest = Utilities.getEnvironmentVariable("MonDestName");
		String DataTransFileName = Utilities.getEnvironmentVariable("strDataTransFileNew");
		String DatatransDirectory = Utilities.getEnvironmentVariable("strdataTransDirectoryNew");
		
		String ExpectedValues = strMonDest + "@@" + DataTransFileName + "@@" + DatatransDirectory;

		String strQuery = null;
		stepExecutor.globalWait(65);
		//Verify Destination name, Data trans file name, data trans Directory
		strQuery="select NON_STANDARD_DEST_NAME,DATATRANS_FILENAME,DATATRANS_DIRECTORY from non_standard_destination_view where NON_STANDARD_DEST_NAME like'%"+strMonDest+"%'";
		System.out.println(strQuery);
		verificationFunctions.verifyDatabaseValuesExpectedDynamic("DBDetails", strQuery, ExpectedValues, strDataFileName, reporter, strReportFilename);

	}
	public void fillDataFileDetailsGD2018(String strDataFileName,RemoteWebDriver webDriver,String fileFormet ,GridReporter reporter, String strReportFilename){

		//Select Card Number Masking
		stepExecutor.selectListValue("findElementByName", "cardNumberMasking", strDataFileName, "ListBox_cardNumberMasking", webDriver, reporter, strReportFilename);

		//Select Data File Format Specification
		stepExecutor.selectListValue("findElementById", "destFileFormatId", strDataFileName, "ListBox_destFileFormatId_"+fileFormet, webDriver, reporter, strReportFilename);
		stepExecutor.waitForElementToEnable("findElementById", "layout", webDriver, reporter, strReportFilename);
		stepExecutor.globalWait(2);
		//Select Layout
		
		if (webDriver.findElement(By.name("layout")).isEnabled()) { 

		stepExecutor.selectListValue("findElementById", "layout", strDataFileName, "ListBox_layout", webDriver, reporter, strReportFilename);
		}
		//Enter Datatrans Directory
		stepExecutor.enterTextValue("findElementById", "dataTransDirectory", strDataFileName, "TextBox_dataTransDirectory", webDriver, reporter, strReportFilename);

		//Select Destination Endpoint
		stepExecutor.selectListValue("findElementById", "destinationEndPoint", strDataFileName, "ListBox_destinationEndPoint", webDriver, reporter, strReportFilename);

		//Select Transmission Method
		stepExecutor.selectListValue("findElementById", "transmissionMethod", strDataFileName, "ListBox_transmissionMethod", webDriver, reporter, strReportFilename);

		//Enter File Header text
		stepExecutor.enterTextValue("findElementById", "fileHeaderText", strDataFileName, "TextBox_fileHeaderText", webDriver, reporter, strReportFilename);

		//Select Empty File Generation
		stepExecutor.selectListValue("findElementById", "emptyFileGenerationId", strDataFileName, "ListBox_EmptyFile_Value", webDriver, reporter, strReportFilename);

	}
public void verifyAssignCardTypes(String strDataFileName,RemoteWebDriver webDriver, String strcardTypes,String Card,GridReporter reporter, String strReportFilename){
		
		verificationFunctions.verifyElementTextPresentString(webDriver, "//select[@name='availableCardTypes']//option[text()='"+Card+"']", "findElementByXPath", Card, reporter, strReportFilename);
		//Select Card Types
		//stepExecutor.selectListValue("findElementByXPath", "//select[@id='availableCardTypes']//option[text()='"+Card+"']", strDataFileName, "ListBox_CardTypes_"+strcardTypes, webDriver, reporter, strReportFilename);

	}*/
/*public void holidayProcessDetails(String strDataFileName,RemoteWebDriver webDriver, String strCreateOption, GridReporter reporter, String strReportFilename){
//Enter Calendar
//stepExecutor.enterTextValue("findElementById", "generationTransmissionCalendar", strDataFileName, "TextBox_TransmissionCalendar", webDriver, reporter, strReportFilename);
EnterCalendar(strDataFileName, webDriver, reporter, strReportFilename);

//Select File Creation Options
stepExecutor.selectListValue("findElementById", "holidayFileCreateId", strDataFileName, "ListBox_holidayFileCreateId", webDriver, reporter, strReportFilename);

if(strCreateOption.equalsIgnoreCase("Create the File")){
	//wait for element to enable
	stepExecutor.waitForElementToEnable("findElementById", "holidayFileTransmitId", webDriver, reporter, strReportFilename);
	//Select File Transmission Options
	stepExecutor.selectListValue("findElementById", "holidayFileTransmitId", strDataFileName, "ListBox_holidayFileTransmitId", webDriver, reporter, strReportFilename);
}
else{
	//Verify List Value
	verificationFunctions.verifyListValue(webDriver, "holidayFileTransmitId", "id", strDataFileName, "Verify_Transmission_Values", reporter, strReportFilename);
}
}*/

}




















