package com.webapp.stepDefinition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.webapp.baseLibrary.FunctionsLibrary;
import com.webapp.executioner.ExecutionerClass;
import com.webapp.page.ReusableFunctions;
import com.webapp.utilities.FeatureFileUpdate;
import com.webapp.utilities.GridReporter;
import com.webapp.utilities.QTestIntegration;
import com.webapp.stepDefinition.CMF_Customer_Creation;
import com.webapp.stepDefinition.CMF_Acquirer_Creation;
import com.webapp.stepDefinition.CMF_Terminal_Creation;
import com.webapp.stepDefinition.CMF_Merchant_Creation;
import com.webapp.stepDefinition.CMF_Monetary_Creation;
import com.webapp.stepDefinition.CMF_NonMonetary_Creation;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.JSONParser;

public class CommonStepDefinitions extends ExecutionerClass {

	public CommonStepDefinitions() {
		PageFactory.initElements(FunctionsLibrary.driver, this);
	}

	public static String releaseName = "";
	public static String dataFileName = "";
	public static String tc_id = "";
	public static String scenarioName = "";
	static GridReporter reporter = getReporter();
	public static String strReportFilename = "";
	public long executionStartTime;
	private ReusableFunctions reusable;
	// CMF_Customer_Creation CustCreation = new CMF_Customer_Creation();
	public static Map<String, String> testData = new HashMap<String, String>();
	FunctionsLibrary functions = new FunctionsLibrary();
	public static String executeScenario = "";
	public static boolean exescenario = false;
	public static int iterationCount = 0;
	public static int numberOfRow = 0;
	public static String testCycle = "";
	public static String moduleName = "";
	public static String s = null;
	public static Map<String, String> commonData = new HashMap<String, String>();
	public static Map<String, String> testData1 = new HashMap<String, String>();
	public static String startTime;
	public static int exceptioncounter = 0;

	public String getReportFileName() {
		return strReportFilename;
	}

	@Given("^: User loads the \"([^\"]*)\" json file$")
	public void getDataFileName(String fileName) throws Throwable {
		System.out.println();
		this.dataFileName = fileName;

	}

	public static String getDataFileName() {
		return dataFileName;
	}

	public static String getTestCaseIdScenarioName() {
		return tc_id + "&" + scenarioName;
	}

	public static String getReleaseName() {
		return releaseName;
	}

	@After
	public void afterHook() throws Exception {
		String strStopTime = reporter.stop();
		GridReporter.strStopTime = strStopTime;
		float timeElapsed = reporter.getElapsedTime();
		String status = reporter.addDynamicContents(tc_id, scenarioName, testCycle, moduleName, timeElapsed);
		detailsForqTest(status);
	}

	public void detailsForqTest(String status) {

		List<Map<String, String>> listOfTestCaseData = new ArrayList<Map<String, String>>();
		Map<String, String> testCaseData = new HashMap<String, String>();
		//testCaseData.put("Test Case ID", tc_id.split("_")[1]);
		testCaseData.put("Test Case ID", tc_id);
		testCaseData.put("Status", status);
		testCaseData.put("Module", moduleName);
		testCaseData.put("Test Cycle", testCycle);
		testCaseData.put("Scenario", scenarioName);

		SimpleDateFormat inDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat outDateFormat = new SimpleDateFormat("YYYY-MM-dd");
		SimpleDateFormat inTimeFormat = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat outTimeFormat = new SimpleDateFormat("HH:mm:ss+05:30");

		// SimpleDateFormat outTimeFormat = new SimpleDateFormat("hh:mm:ss+05:30");

		String[] arr = startTime.trim().split(" ");
		System.out.println(arr[0]);
		System.out.println(arr[1]);

		String start_Date;
		try {
			start_Date = outDateFormat.format(inDateFormat.parse(arr[0]));

			String start_Time = outTimeFormat.format(inTimeFormat.parse(arr[1]));
			String startDateAndTime = start_Date + "T" + start_Time;

			testCaseData.put("Execution Start Time", startDateAndTime);

			String stopTime = GridReporter.strStopTime;

			SimpleDateFormat inFormat = new SimpleDateFormat("hh:mm:ss aa");
			SimpleDateFormat outFormat = new SimpleDateFormat("HH:mm:ss");
			String stopTimeUpdated = outFormat.format(inFormat.parse(stopTime));

			String stop_Time = outTimeFormat.format(inTimeFormat.parse(stopTimeUpdated));
			String stopDateAndTime = start_Date + "T" + stop_Time;

			testCaseData.put("Execution Stop Time", stopDateAndTime);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listOfTestCaseData.add(testCaseData);

		try {
			QTestIntegration.qTestIntegration(listOfTestCaseData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * parse the json input
	 */
	public String getReleaseName(String filename) {
		String value = "";
		JSONParser parser = new JSONParser(null, null);
		try {
			Object obj = parser.parse(new FileReader("Data/" + filename + ".json"));

			JSONObject lev1 = (JSONObject) obj;
			Object jObj = lev1.get("ReleaseDetails");

			if (jObj instanceof Map) {
				// HashMap<String, ArrayList<String>> map = (HashMap<String, ArrayList<String>>)
				// jObj;
				// Object in=map.get("Input");
				HashMap<String, ArrayList<String>> map1 = (HashMap<String, ArrayList<String>>) jObj;
				// Object input=map1.get(data);
				// HashMap<String, ArrayList<String>> parseData= (HashMap<String,
				// ArrayList<String>>) input;
				for (Entry<String, ArrayList<String>> entry : map1.entrySet()) {
					for (int i = 0; i < entry.getValue().size(); i++) {
						value = entry.getValue().get(i);
						// value.add(val);
					}
				}
				System.out.println(" " + value);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;
	}

	@Given("^User executes the test case '(.*)' for '(.*)'$")
	public void getTestCaseIdScenarioName(String tc_id, String scenarioNames) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		this.tc_id = tc_id;
		this.scenarioName = scenarioNames.replaceAll(" ", "_");
		this.releaseName = getReleaseName(dataFileName);

		this.testData = functions.parse(tc_id, dataFileName);

		executionStartTime = reporter.start();
		strReportFilename = reporter.reportFilestart(currentDateTime(), tc_id, scenarioName);

	}

	@SuppressWarnings("static-access")
	@Given("^User execute testcaseId '(.*)' for testcasename '(.*)' and module '(.*)' Execute \"([^\"]*)\"$")
	public void getTestCaseIdScenarioNameAndModule(String tc_id, String scenarioNames, String module,
			String executeScenario) throws Throwable {
		/*
		 * testCaseCount++; if(runFromFeatureFile==true&&testCaseCount==1) { setUp(); }
		 */

		config = new ExecutionerClass().setEnv();
		this.tc_id = tc_id;
		this.scenarioName = scenarioNames.replaceAll(" ", "_");
		this.releaseName = config.getProperty("Release");
		this.testCycle = config.getProperty("TestCycleId");
		this.moduleName = module;
		this.executeScenario = executeScenario;
		this.exescenario = true;
		// this.commonData = functions.parse("Common_Data", dataFileName);
		// System.out.println(this.commonData);
		this.testData = functions.parse(tc_id, dataFileName);
		// for (String common : this.testData.keySet())
		// {
		// this.commonData.put(common, this.testData.get(common));
		// }
		System.out.println();
		// this.testData=this.commonData;
		// System.out.println(this.testData);

		executionStartTime = reporter.start();
		startTime = currentDateTime();
		strReportFilename = reporter.reportFilestart(currentDateTime(), tc_id, scenarioName);
		if (executeScenario()) {

			printIteration();
		}
	}

	@SuppressWarnings("static-access")
	@Given("^User execute testcases Id \"([^\"]*)\" for testcasename '(.*)' and module '(.*)' Execute \"([^\"]*)\"$")
	public void getMultipleTestcaseIdScenarioNameAndModule(String tc_id, String scenarioNames, String module,
			String executeScenario) throws Throwable {
		/*
		 * testCaseCount++; if(runFromFeatureFile==true&&testCaseCount==1) { setUp(); }
		 */

		config = new ExecutionerClass().setEnv();
		this.tc_id = tc_id;
		this.scenarioName = scenarioNames.replaceAll(" ", "_");
		this.releaseName = config.getProperty("Release");
		this.testCycle = config.getProperty("TestCycleId");
		this.moduleName = module;
		this.executeScenario = executeScenario;
		this.exescenario = true;
		// this.commonData = functions.parse("Common_Data", dataFileName);
		// System.out.println(this.commonData);
		this.testData = functions.parse(tc_id, dataFileName);
		// for (String common : this.testData.keySet())
		// {
		// this.commonData.put(common, this.testData.get(common));
		// }
		System.out.println();
		// this.testData=this.commonData;
		// System.out.println(this.testData);

		executionStartTime = reporter.start();
		startTime = currentDateTime();
		strReportFilename = reporter.reportFilestart(currentDateTime(), tc_id, scenarioName);
		if (executeScenario()) {

			printIteration();
		}
	}

	@Then("^User Giving Invalid SE number to Merchant Card and Validate Error Msg$")
	public void user_Give_Invalid_SENumber_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Add
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			functions.globalWait(10);
			String[] Cardnames = {"MasterCard","Visa","American Express","Alipay","JCB","Union Pay International","HSBC Private Label","Discover","EBT","BPI Private Label","WeChat"};
			int[] Cardnumbers= {663,659,666,6205,669,6086,5909,668,5952,6193,6206};
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
							functions.verifyElementTextContains(Senumber, functions.getEnvironmentVariable("MerchantNumber"));
							//functions.enterText(Senumber, functions.getEnvironmentVariable("MerchantNumber"));
						}
						else {
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
				functions.waitForElementUsingPresence("Merchant_AddCard_ErrorMsg");
				functions.verifyElementTextContains("Merchant_AddCard_ErrorMsg",
						testData.get("Merchant_AddCard_Invalid_SE"));
			}
		}
	}
	/*
	 * @SuppressWarnings("static-access")
	 *
	 * @Given("^User executes the test case \"([^\"]*)\" for testcasename '(.*)' and module '(.*)' Execute \"([^\"]*)\"$"
	 * ) public void getMultipleTestcaseIdScenarioNameAndModule(String tc_id, String
	 * scenarioNames,String module,String executeScenario ) throws Throwable {
	 * testCaseCount++; if(runFromFeatureFile==true&&testCaseCount==1) { setUp(); }
	 *
	 * config=new ExecutionerClass().setEnv(); this.tc_id = tc_id; this.scenarioName
	 * = scenarioNames.replaceAll(" ", "_"); this.releaseName =
	 * config.getProperty("Release");
	 * this.testCycle=config.getProperty("TestCycleId"); this.moduleName=module;
	 * this.executeScenario =executeScenario;
	 *
	 * //this.commonData = functions.parse("Common_Data", dataFileName);
	 * //System.out.println(this.commonData); this.testData = functions.parse(tc_id,
	 * dataFileName); // for (String common : this.testData.keySet()) // { //
	 * this.commonData.put(common, this.testData.get(common)); // }
	 * System.out.println(); //this.testData=this.commonData;
	 * //System.out.println(this.testData);
	 *
	 * executionStartTime = reporter.start(); startTime=currentDateTime();
	 * strReportFilename = reporter.reportFilestart(currentDateTime(), tc_id,
	 * scenarioName); if(executeScenario()){
	 *
	 * printIteration(); } }
	 */

	@Given("^User executes the test case '(.*)' for '(.*)' Execute \"([^\"]*)\"$")
	public void getTestCaseIdScenarioNameExecute(String tc_id, String scenarioNames, String executeScenario)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		this.tc_id = tc_id;
		this.scenarioName = scenarioNames.replaceAll(" ", "_");
		this.releaseName = getReleaseName(dataFileName);
		this.executeScenario = executeScenario;
		this.testData = functions.parse(tc_id, dataFileName);

		// executionStartTime=reporter.start();
		// strReportFilename =
		// reporter.reportFilestart(currentDateTime(),tc_id,scenarioName);
		numberOfRow = FeatureFileUpdate.numberOfRowsInOutline(tc_id);
		if (iterationCount == 0) {
			executionStartTime = reporter.start();

			strReportFilename = reporter.reportFilestart(currentDateTime(), tc_id, scenarioName);
		}
		iterationCount++;
		if (executeScenario()) {

			printIteration();
		}

	}

	public void printIteration() {
		if (iterationCount > 0) {
			reporter.writeStepResult(tc_id, scenarioName, "--------------------------------------Row : "
					+ iterationCount + " Execution Starts here -----------------------------", "", "", "",
					strReportFilename);
		}
	}

	public static void printEndOfIteration() {
		if (iterationCount > 0) {
			reporter.writeStepResult(tc_id, scenarioName, "--------------------------------------Row : "
					+ iterationCount + " Execution Ends here -------------------------------", "", "", "",
					strReportFilename);
		}
	}

	@Given("^User executes the test case \"([^\"]*)\" for '(.*)' Execute \"([^\"]*)\"$")
	public void getMultipleTestcaseIdScenarioName(String tc_id, String scenarioNames, String executeScenario)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		this.tc_id = tc_id;
		this.scenarioName = scenarioNames.replaceAll(" ", "_");
		this.releaseName = getReleaseName(dataFileName);
		this.executeScenario = executeScenario;
		this.testData = functions.parse(tc_id, dataFileName);

		// executionStartTime=reporter.start();
		// strReportFilename =
		// reporter.reportFilestart(currentDateTime(),tc_id,scenarioName);
		numberOfRow = FeatureFileUpdate.numberOfRowsInOutline(tc_id);
		if (iterationCount == 0) {
			executionStartTime = reporter.start();

			strReportFilename = reporter.reportFilestart(currentDateTime(), tc_id, scenarioName);
		}
		iterationCount++;
		if (executeScenario()) {

			printIteration();
		}

	}

	/** Launch the Application and Login with the given user **/
	@When("^Launch the Application and Login with the User \"([^\"]*)\" Region \"([^\"]*)\"$")
	public void launchTheApplicationAndLogin(String username, String Region) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (executeScenario()) {
			if (!exescenario)
				return;

			reusable = new ReusableFunctions();
			reusable.loginToApplication(username, Region);
		}
	}
	
	@When("^Launch the USAT Application and Login with the User \"([^\"]*)\" Region \"([^\"]*)\"$")
	public void launchTheUSATApplicationAndLogin(String USATLoginuser, String Region) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (executeScenario()) {
			if (!exescenario)
				return;
				reusable = new ReusableFunctions();
				reusable.loginToUSAT(USATLoginuser, Region);
			
		}
	}
	@And("^Search for user \"([^\"]*)\" to Delete existing roles and Add new roles$")
	public void DeleteAndAddNewRoles(String SearchUser) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (executeScenario()) {
			if (!exescenario)
				return;
				reusable = new ReusableFunctions();
				//enter search name
				functions.enterText("USAT_searchName", SearchUser);
				//click on search
				functions.clickAnElement("USAT_SearchButton", "SearchButton");
				//click on edit
				functions.clickAnElement("USAT_EditLink", "Edit link");
				//deleting existing roles
				//click on role assignment
				functions.clickAnElement("USAT_RoleAssignment", "RoleAssignment");
				System.out.println("Number of Delete Link "+FunctionsLibrary.driver.findElements(By.linkText("Delete")).size());
				while(FunctionsLibrary.driver.findElements(By.linkText("Delete")).size()!=0)
				{
					FunctionsLibrary.driver.findElement(By.linkText("Delete")).click();
					functions.globalWait(2);
					functions.acceptAlertWithoutText("accept");
					functions.globalWait(2);
				}
				//Adding wanted roles to user
				functions.clickAnElement("USAT_AddRoles", "Add roles");
				//Select Frame
				functions.switchToFrame("USAT_GB_frame");
				functions.switchToFrame("USAT_GB_frame");
				
				WebElement htmltable=FunctionsLibrary.driver.findElement(By.id("mytableAdd"));
				List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
				//String strDetails = utils.getDataFileInfo();
				String[] Roles = testData.get("USAT_Add_Rolenames").split("@@");
				System.out.println("Row Size: "+rows.size());
				for(int i=0; i<=Roles.length;i++)
				{
					String Role= Roles[i];
					for(int rnum=1;rnum<rows.size();rnum++)
					{
						if(FunctionsLibrary.driver.findElement(By.xpath("//table[@id='mytableAdd']/tbody/tr["+ rnum +"]/td[2]")).getText().equals(Role))
						{
							WebElement AddRole=FunctionsLibrary.driver.findElement(By.xpath("\"//table[@id='mytableAdd']/tbody/tr[\" + rnum + \"]/td/input[2]"));
							functions.changeRadioButtonOrCheckBoxStatus(AddRole, "check");
						}
					}
					
				}
				//Click on Add roles
				functions.clickAnElement("USAT_submitButton", "Add Roles");
				functions.globalWait(3);
				//Switch to Default window
				FunctionsLibrary.driver.switchTo().defaultContent();

		}
	}
	@And("^Search for user \"([^\"]*)\" to Delete existing CPR roles$")
	public void DeleteCPRRoles(String SearchUser) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (executeScenario()) {
			if (!exescenario)
				return;
				reusable = new ReusableFunctions();
				//enter search name
				functions.enterText("USAT_searchName", SearchUser);
				//click on search
				functions.clickAnElement("USAT_SearchButton", "SearchButton");
				//click on edit
				functions.clickAnElement("USAT_EditLink", "Edit link");
				//deleting existing roles
				//click on role assignment
				user_Delete_CPR_Roles();
		}
	}
	@And("^Search for user \"([^\"]*)\" to Delete existing CPR roles and Add new CPR roles$")
	public void DeleteCPRRolesAddCPRroles(String SearchUser) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (executeScenario()) {
			if (!exescenario)
				return;
				reusable = new ReusableFunctions();
				//enter search name
				functions.enterText("USAT_searchName", SearchUser);
				//click on search
				functions.clickAnElement("USAT_SearchButton", "SearchButton");
				//click on edit
				functions.clickAnElement("USAT_EditLink", "Edit link");
				//deleting existing roles
				//click on role assignment
				user_Delete_CPR_Roles();
				//Adding CPR roles
				user_Add_CPR_Roles();
		}
	}
	public void user_Delete_CPR_Roles() throws Throwable {
		// Click Add
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("USAT_RoleAssignment", "RoleAssignment");
			System.out.println("Number of Delete Link "+FunctionsLibrary.driver.findElements(By.xpath("//td[contains(text(),'CPR role')]/../td/a[contains(text(),'Delete')]")).size());
			while(FunctionsLibrary.driver.findElements(By.xpath("//td[contains(text(),'CPR role')]/../td/a[contains(text(),'Delete')]")).size()!=0)
			{
				FunctionsLibrary.driver.findElement(By.xpath("//td[contains(text(),'CPR role')]/../td/a[contains(text(),'Delete')]")).click();
				functions.globalWait(2);
				functions.acceptAlertWithoutText("accept");
				functions.globalWait(2);
			}
		}
	}
	public void user_Add_CPR_Roles() throws Throwable {
		// Click Add
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			//Adding wanted roles to user
			functions.clickAnElement("USAT_AddRoles", "Add roles");
			//Select Frame
			functions.switchToFrame("USAT_GB_frameName");
			functions.switchToFrame("USAT_GB_frameId");
			
			WebElement htmltable=FunctionsLibrary.driver.findElement(By.id("mytableAdd"));
			List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
			//String strDetails = utils.getDataFileInfo();
			String[] Roles = testData.get("USAT_Add_Rolenames").split("@@");
			System.out.println("Row Size: "+rows.size());
			for(int i=0; i<Roles.length;i++)
			{
				String Role= Roles[i];
				for(int rnum=1;rnum<=(rows.size())-1;rnum++)
				{
					if(FunctionsLibrary.driver.findElement(By.xpath("//table[@id='mytableAdd']/tbody/tr["+ rnum +"]/td[2]")).getText().equals(Role))
					{
						WebElement AddRole=FunctionsLibrary.driver.findElement(By.xpath("//table[@id='mytableAdd']/tbody/tr[" + rnum + "]/td/input[2]"));
						functions.changeRadioButtonOrCheckBoxStatus(AddRole, "check");
					}
					
				}
		
			}
			//Click on Add roles
			functions.clickAnElement("USAT_submitButton", "Add Roles");
			functions.globalWait(3);
			//Switch to Default window
			FunctionsLibrary.driver.switchTo().defaultContent();
			}
		}
	
	/*
	 * 17MR7 ...TC_23912273 testcase validation
	 *
	 */
	@Then("^Adding Diners Club card to Merchant and Verifying Error Msg$")
	public void user_Add_CardTypes_Merchant() throws Throwable {
		// Click Add
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			functions.globalWait(10);

			String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				functions.waitForElementUsingPresence("Merchant_AddCards_CardType");
				functions.selectDropdownByVisibleText("Merchant_AddCards_CardType", CardTypes[i]);
				functions.globalWait(5);
				functions.waitForElementUsingPresence("Merchant_AddCards_SENumber");
				functions.enterText("Merchant_AddCards_SENumber", testData.get("Merchant_SENumber_" + CardTypes[i]));
				functions.globalWait(5);
				// Click Save
				functions.waitForElementUsingPresence("Merchant_Save");
				functions.clickAnElement("Merchant_Save", "AddCard_Save");
				functions.globalWait(5);
				// verify sucess Message
				functions.waitForElementUsingPresence("Merchant_AddCard_ErrorMsg");
				functions.verifyElementTextContains("Merchant_AddCard_ErrorMsg",
						testData.get("Merchant_AddCard_ErrorMsg"));
			}

		}
	}

	@Then("^Delete Acq Discover ID and Validate error message$")
	public void user_DelAcqDisID() throws Throwable {
		// Click Add
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Edit Button
			functions.clickAnElement("Acquirer_Edit_Button", "Edit");
			functions.waitForElementUsingPresence("Acquirer_Save");
			// Clear text field
			functions.clearTextField("Acquirer_discoverAcquirerId");
			// Click on Save Button
			functions.clickAnElement("Acquirer_Save", "Save");
			// Verify Error message
			functions.verifyElementTextContains("Acquirer_Discover_Error", testData.get("Acquirer_Discover_Error1"));
			functions.verifyElementTextContains("Acquirer_Discover_Error", testData.get("Acquirer_Discover_Error2"));
		}
	}

	@Then("^Update Acquirer Discover ID$")
	public void user_UpdateAcqDisID() throws Throwable {
		// Click Add
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Edit Button
			functions.clickAnElement("Acquirer_Edit_Button", "Edit");
			functions.waitForElementUsingPresence("Acquirer_Save");
			// Clear text field
			functions.clearTextField("Acquirer_discoverAcquirerId");
			functions.enterText("Acquirer_discoverAcquirerId", testData.get("Acquirer_New_discoverAcquirerId"));
			// Click on Save Button
			functions.clickAnElement("Acquirer_Save", "Save");
			// Verify Error message
			functions.verifyElementTextContains("Acquirer_Update_SuccessMsg",
					testData.get("Acquirer_Update_SuccessMsg"));
		}
	}

	@Then("^User validate and open customer for Merchant$")
	public void user_Validate_Open_Customer() throws Throwable {
		// Click Add
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.waitForElementUsingPresence("Customer_Validate");
			functions.clickAnElement("Customer_Validate", "Validate");
			// Click Button Edit
			functions.clickAnElement("Customer_Edit_Button", "Edit");
			functions.waitForElementUsingPresence("Customer_Save_Button");
			// Change Status
			functions.selectDropdownByVisibleText("Customer_Satus_Listbox", testData.get("Customer_Satus_Listbox"));
			// Click on Save Button
			functions.clickAnElement("Customer_Save_Button", "Save");
			// verify expected error
			functions.verifyElementTextContains("Acquirer_Discover_Error",
					testData.get("Customer_Open_Discover_Error"));
		}
	}

	@Then("^User delete Acquirer and validate Error message$")
	public void user_Delete_Acquirer_Error() throws Throwable {
		// Click Add
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;

			functions.waitForElementUsingPresence("Customer_DeleteAcq_Checkbox");
			functions.changeRadioButtonOrCheckBoxStatus("Customer_DeleteAcq_Checkbox", testData.get("Customer_check"));
			// functions.changeRadioButtonOrCheckBoxStatus("//td[contains(text(),'AcqWithDisAcqID')]/../td/input[@name='acqAcctId']",
			// testData.get("Customer_check"));
			// delete button
			functions.clickAnElement("Customer_Acquirer_Delete", "Acquirer Delete");
			functions.acceptAlertWithoutText("accept");

			functions.verifyElementTextContains("Acquirer_Discover_Error", testData.get("Customer_Discover_Error"));
		}
	}

	@Then("^Adding Card type to Customer and Verifying Error Msg$")
	public void user_Add_CardTypes_Customer_Error() throws Throwable {
		// Click Add
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// click on Add Card Button
			functions.waitForElementUsingVisibility("Customer_AddCardButton");
			// Add Card Types
			functions.clickAnElement("Customer_AddCardButton", "AddCardButton");
			// functions.globalWait(10);

			String[] CardTypes = testData.get("Customer_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				// functions.globalWait(5);
				functions.waitForElementUsingVisibility("Customer_CardType");
				functions.selectDropdownByVisibleText("Customer_CardType", CardTypes[i]);

				// Select Voice Authorization -- JCB
				if (CardTypes[i].equalsIgnoreCase("JCB") || CardTypes[i].equalsIgnoreCase("Dinners")) {
					functions.selectDropdownByVisibleText("Customer_voiceAllowed",
							testData.get("Customer_voiceAllowedYes"));
				}
				if (CardTypes[i].equalsIgnoreCase("Diners Club")) {
					functions.selectDropdownByVisibleText("Customer_voiceAllowed",
							testData.get("Customer_voiceAllowedNo"));
				}
				if (CardTypes[i].equalsIgnoreCase("JCB")) {
					functions.selectDropdownByVisibleText("Customer_processingLevel",
							testData.get("Customer_processingLevel"));
					functions.globalWait(5);
					String winhandleBefore = FunctionsLibrary.driver.getWindowHandle();
					functions.setEnvironmentVariable("MainWindow", winhandleBefore);
					// Add Monetary Destination
					functions.waitForElementUsingVisibility("Customer_Card_Monetary_Search");
					functions.clickAnElement("Customer_Card_Monetary_Search", "Monetary_Search");
					// functions.globalWait(10);

					functions.switchToNewWindow();

					if (FunctionsLibrary.driver.findElements(By.id("overridelink")).size() != 0) {
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
					functions.changeRadioButtonOrCheckBoxStatus("Customer_card_MonDestSearch_RadioButton",
							testData.get("RadioButton"));
					int counter = 0;
					while (FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]"))
							.size() <= 0) {
						functions.globalWait(1);
						counter++;
						if (counter == 60) {
							break;
						}
					}
					counter = 0;
					while (!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]"))
							.isDisplayed()) {
						functions.globalWait(1);
						counter++;
						if (counter == 60) {
							break;
						}
					}
					functions.clickAnElement("Customer_Select", "Select_MonDest");
					functions.globalWait(10);
					try {
						String strWinHandle = functions.getEnvironmentVariable("MainWindow");
						FunctionsLibrary.driver.switchTo().window(strWinHandle);
					} catch (Exception ee1) {
						System.out.println(" Monetory Dest Failed----" + ee1.getMessage());
					}
					functions.globalWait(5);
				} else {
					functions.selectDropdownByVisibleText("Customer_processingLevel",
							testData.get("Customer_processingLevel"));
					functions.globalWait(5);
					String winhandleBefore = FunctionsLibrary.driver.getWindowHandle();
					functions.setEnvironmentVariable("MainWindow", winhandleBefore);
					// Add Monetary Destination
					functions.waitForElementUsingVisibility("Customer_Card_Monetary_Search");
					functions.clickAnElement("Customer_Card_Monetary_Search", "Monetary_Search");
					functions.globalWait(10);

					functions.switchToNewWindow();

					if (FunctionsLibrary.driver.findElements(By.id("overridelink")).size() != 0) {
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

					functions.changeRadioButtonOrCheckBoxStatus("Customer_card_MonDestSearch_RadioButton",
							testData.get("RadioButton"));
					int counter = 0;
					while (FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]"))
							.size() <= 0) {
						functions.globalWait(1);
						counter++;
						if (counter == 60) {
							break;
						}
					}
					counter = 0;
					while (!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]"))
							.isDisplayed()) {
						functions.globalWait(1);
						counter++;
						if (counter == 60) {
							break;
						}
					}
					functions.clickAnElement("Customer_Select", "Select_MonDest");
					functions.globalWait(10);
					try {
						String strWinHandle = functions.getEnvironmentVariable("MainWindow");
						FunctionsLibrary.driver.switchTo().window(strWinHandle);
					} catch (Exception ee1) {
						System.out.println(" Monetory Dest Failed----" + ee1.getMessage());
					}
					functions.globalWait(5);

					String winhandleBefore1 = FunctionsLibrary.driver.getWindowHandle();
					functions.globalWait(5);
					functions.clickAnElement("Customer_card_NonMonetary_Search", "NonMonSearch");
					functions.globalWait(10);

					functions.switchToNewWindow();

					if (FunctionsLibrary.driver.findElements(By.id("overridelink")).size() != 0) {
						System.out.println("Clicking Certificate link");
						FunctionsLibrary.driver.findElement(By.id("overridelink")).click();
						functions.globalWait(5);
					}
					// Enter Value in Non Monetary Destination
					functions.enterText("Customer_card_NonMonetary_name",
							testData.get("Customer_card_NonMonetary_name"));
					functions.clickAnElement("Customer_card_NonMonetary_NameSearch", "NonMon_Search");

					functions.waitForElementUsingVisibility("Customer_card_MonDestSearch_RadioButton");
					functions.changeRadioButtonOrCheckBoxStatus("Customer_card_MonDestSearch_RadioButton",
							testData.get("RadioButton"));

					int counter1 = 0;
					while (FunctionsLibrary.driver.findElements(By.xpath("(//input[@value='Select'])[1]"))
							.size() <= 0) {
						functions.globalWait(1);
						counter1++;
						if (counter1 == 60) {
							break;
						}
					}
					counter1 = 0;
					while (!FunctionsLibrary.driver.findElement(By.xpath("(//input[@value='Select'])[1]"))
							.isDisplayed()) {
						functions.globalWait(1);
						counter1++;
						if (counter1 == 60) {
							break;
						}
					}
					functions.clickAnElement("Customer_card_NonMonetary_NameSelect", "NonMon_Select");
					functions.globalWait(10);
					try {
						FunctionsLibrary.driver.switchTo().window(winhandleBefore1);
					} catch (Exception ee1) {
						System.out.println("Non Monetory Dest Failed----" + ee1.getMessage());
					}
					functions.globalWait(5);
				}
				// Click on Add Button
				functions.clickAnElement("Customer_AddCardType", "Add_CardType");
				// functions.waitForElementUsingPresence("Customer_card_Add_SuccessMsg");
				functions.verifyElementTextContains("Customer_CardType_Error",
						testData.get("Customer_Cardtype_ErrorMsg"));
				functions.globalWait(5);
			}
		}
	}

	@Then("^Encryption blocked key Special characters alert validation$")
	public void user_Giving_Special_Characters_Verify() throws Throwable {
		// Click Add
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
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
			//Click Save
			functions.clickAnElement("Encryption_Save", "Encryption_Save");

			functions.acceptAlertVerifyText("accept", testData.get("Encryption_AlertText"));
			//enter Encryption Key
			functions.clearTextField("Encryption_keyBlockedKey");
			functions.enterText("Encryption_keyBlockedKey", testData.get("Encryption_keyBlockedKey1"));
			//enter Re-enter Encryption Key
			functions.clearTextField("Encryption_reenterKeyBlockedKey");
			functions.enterText("Encryption_reenterKeyBlockedKey", testData.get("Encryption_keyBlockedKey1"));
			//Click Save
			functions.clickAnElement("Encryption_Save", "Encryption_Save");

			functions.verifyElementTextContains("Encryption_Save_SuccessMsg", testData.get("Encryption_Save_SuccessMsg"));
		}
	}
	@Then("^User Adding EBT card to Terminal and Verify Error$")
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
				functions.selectDropdownByVisibleText("Terminal_CardType", CardTypes[i]);
				// Select EDC Indicator
				functions.selectDropdown("Terminal_EDcIndicator", "VisibleText",
						testData.get("Terminal_EDcIndicator_" + CardTypes[i]));
				// Select Transaction Switching Option
				functions.selectDropdownByVisibleText("Terminal_TransactionSwitch",
						testData.get("Terminal_TransactionSwitch_" + CardTypes[i]));
				// Click Save
				functions.clickAnElement("Terminal_Save", "Terminal_Save");

				functions.globalWait(8);
				functions.waitForElementUsingPresence("Terminal_CardType_Error");
				functions.verifyElementTextContains("Terminal_CardType_Error",
						testData.get("Terminal_CardAccepted_SuccessMsg"));

			}
		}
	}
	@Then("^User verify Log submission field$")
	public void user_Verify_LogSubmission() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.verifyElementPresentWithReport("Bigbatch_LogSubmission");
		}
	}
	@And("^User verify Log submission field Default Value$")
	public void user_Verify_LogSubmission_Default() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.verifyElementPresentWithReport("Bigbatch_LogSubmission");
			functions.verifySelectedDropDownValue("Bigbatch_LogSubmissionSelect", "Yes");
		}
	}
	@And("^User change Log submission to No$")
	public void user_Change_LogSubmission_to_No() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			//functions.verifyElementPresentWithReport("Bigbatch_LogSubmission");
			functions.selectDropdownByVisibleText("Bigbatch_LogSubmissionSelect", "No");
		}
	}
	@And("^User change Log submission to Yes$")
	public void user_Change_LogSubmission_to_Yes() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			//functions.verifyElementPresentWithReport("Bigbatch_LogSubmission");
			functions.selectDropdownByVisibleText("Bigbatch_LogSubmissionSelect", "Yes");
		}
	}
	@Then("^User Verify effective date in Merchant Chain$")
	public void user_Add_Chain_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			//click on add chain Button
			functions.clickAnElement("Merchant_Chain_Add", "Merchant_Chain_Add");
			functions.globalWait(5);
			functions.verifyElementNotPresent("MerchantChainEffectivedate", "Merchant_Chain_Effectivedate");
		}
		}
	@And("^User Click on Edit Button$")
	public void user_click_Edit() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			//Click Button Edit
			functions.clickAnElement("Customer_Edit_Button", "Edit");
			functions.waitForElementUsingPresence("Customer_Save_Button");
		}
	}
	@And("^User Click on customer Save changes Successfully$")
	public void Cust_Save(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			//Click on Save Button
			functions.clickAnElement("Customer_Save_Button", "Save");
			
			functions.waitForElementUsingPresence("Customer_Updated_Msg");
			functions.verifyElementTextContains("Customer_Updated_Msg", testData.get("Customer_Updated_Msg"));
		}
		}
	@Then("^User Verify Cust Number and Name disabled$")
	public void VerifyDisbledfields(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			functions.verifyElementisDisabled("Customer_CustomerNumber");
			functions.verifyElementisDisabled("Customer_CustomerName");
		}
		}
	@Then("^User change Merchant's Parent Customer1 to Parent Customer2$")
	public void user_Change_Parent_Cust(String Region) throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
			functions.verifyElementisDisabled("Customer_CustomerNumber");
			functions.verifyElementisDisabled("Customer_CustomerName");
		}
		}
	@Then("^User Click on Card type on Merchant page$")
	public void user_click_Card() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			//functions.verifyElementPresentWithReport("Bigbatch_LogSubmission");
			functions.clickAnElement("Merchant_Cardtype_Discover", "Merchant_Cardtype_Discover");
			functions.globalWait(5);
			functions.verifyElementisDisabled("Merchant_Card_EffeDate");
		}
	}
	@And("^User click disable Element$")
   public void user_click_disable_Element() throws Throwable{
	   if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnDisableElement("Merchant_Card_EffeTime", "Merchant_Card_EffeTime");
	   }
	   
   }
	@And("^User click disable CalenderElement$")
	   public void user_click_disable_calender_Element() throws Throwable{
		   if (CommonStepDefinitions.executeScenario()) {
				if (!CommonStepDefinitions.exescenario)
					return;
				functions.clickAnDisableElement("Merchant_Calender", "Merchant_Calender");
		   }
		   
	   }
	@And("^User click disable dropdown for Effectivetime$")
	   public void user_click_disable_dropdown_Element() throws Throwable{
		   if (CommonStepDefinitions.executeScenario()) {
				if (!CommonStepDefinitions.exescenario)
					return;
				functions.selectDropdowndisable("Merchant_Card_EffeTime", "Merchant_Card_EffeTime", "Merchant_Card_EffeTime");
		   }
		   
	   }
	@And("^User validate the terminal to Validate TimeZone Req Error$")
	public void user_validate_terminal_TimeZone() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
		// Click Button Validate
		functions.waitForElementUsingPresence("Terminal_Validate");
		functions.clickAnElement("Terminal_Validate", "Terminal_Validate");
		// verify validate Message
		functions.waitForElementUsingPresence("Terminal_ValidateMsg");
		functions.verifyElementTextContains("Terminal_ValidateTimezoneErrorMsg", testData.get("Terminal_ValidateMsg"));
		}
	}
	@Then("^User Click on Add Child Customer link and Verify LOB$")
	public void user_ClickAddChildCust() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
		// Click Add Child Customer
		functions.clickAnElement("Customer_Addchildcustomer", "Click Add Child Customer");
		// verify validate Message
		functions.verifySelectedDropDownValue("Customer_LineOfBusiness", "Customer_VerifyLOB");
		functions.VerifyDropDownListValues("Customer_LineOfBusiness", "Customer_LOBCanadaListValues");
		}
	}
	@Then("^User Click on Add Child Customer link and Verify Processor$")
	public void user_ChildCustProcessor() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
		// Click Add Child Customer
		functions.clickAnElement("Customer_Addchildcustomer", "Click Add Child Customer");
		// verify validate Message
		functions.verifySelectedDropDownValue("Customer_Processor", "Customer_VerifyProcessor");
		functions.VerifyDropDownListValues("Customer_Processor", "Customer_ProcessorCanadaListValues");
		}
	}

	@Then("^User validate Terminal TimeZone All New Values$")
	public void user_validate_terminalNewTimeZones() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			String[] NewTimeZones=testData.get("Terminal_All_NewTimeZones").split("@@");
			for(int i=0; i<NewTimeZones.length;i++) {
				functions.VerifyDropDownListValues("Terminal_TimeZone", NewTimeZones[i]);
			}
			
			
		}
	}
	@Then("^User validate Terminal TimeZone Default Value$")
	public void user_validate_terminal() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.verifySelectedDropDownValue("Terminal_TimeZone", testData.get("Terminal_TimeZone"));
		}
	}
	@Then("^User search Open Merchant to Validate Risk Management Not present$")
	public void user_Any_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Merchant_Existing_Search", "Merchant_Search");
			functions.globalWait(2);
			
			functions.clickAnElement("Merchant_Search_Dynamic", "Open_Merchant");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_Riskmanagement", "Merchant_Riskmanagement");
		}
	}
	@Then("^User search Open Terminal to Validate Risk Management Not present$")
	public void user_Any_Terminal() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Terminal tab
			functions.clickAnElement("Terminal_NavToTerminal", "Terminal_NavToTerminal");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Terminal_ClickSearch", "Terminal_ClickSearch");
			functions.globalWait(2);
			
			functions.clickAnElement("Terminal_Search_Dynamic", "Open_Terminal");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_Riskmanagement", "Merchant_Riskmanagement");
		}
	}
	@Then("^User search Open Merchant to Validate VISA MERCHANT Not present$")
	public void user_VISA_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Merchant_Existing_Search", "Merchant_Search");
			functions.globalWait(2);
			
			functions.clickAnElement("Merchant_Search_Dynamic", "Open_Merchant");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_VisaMerchant", "Merchant_VisaMerchant");
		}
	}	
	@Then("^User search Open Merchant to Validate WELCOME KITS Not present$")
	public void user_Merch_WelcomeKits() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Merchant_Existing_Search", "Merchant_Search");
			functions.globalWait(2);
			
			functions.clickAnElement("Merchant_Search_Dynamic", "Open_Merchant");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_WelcomeKits", "Merchant_WelcomeKits");
		}
	}	
	@Then("^User search Open Merchant to Validate VOICE CENTER Not present$")
	public void user_Merch_VoiceCenter() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Merchant_Existing_Search", "Merchant_Search");
			functions.globalWait(2);
			
			functions.clickAnElement("Merchant_Search_Dynamic", "Open_Merchant");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_VoiceCenter", "Merchant_VoiceCenter");
		}
	}
	@Then("^User search Open Merchant to Validate TRAINING Not present$")
	public void user_Merch_Training() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Merchant_Existing_Search", "Merchant_Search");
			functions.globalWait(2);
			
			functions.clickAnElement("Merchant_Search_Dynamic", "Open_Merchant");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_Training", "Merchant_Training");
		}
	}
	@Then("^User search Open Merchant to Validate SUPPLIES Not present$")
	public void user_Merch_Supplies() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Merchant_Existing_Search", "Merchant_Search");
			functions.globalWait(2);
			
			functions.clickAnElement("Merchant_Search_Dynamic", "Open_Merchant");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_Supplies", "Merchant_Supplies");
		}
	}
	@Then("^User search Open Merchant to Validate REPLACEMENTS Not present$")
	public void user_Merch_Replacements() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Merchant_Existing_Search", "Merchant_Search");
			functions.globalWait(2);
			
			functions.clickAnElement("Merchant_Search_Dynamic", "Open_Merchant");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_Replacements", "Merchant_Replacements");
		}
	}
	@Then("^User search Open Terminal to Validate REPLACEMENTS Not present$")
	public void user_Any_TermReplacement() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Terminal tab
			functions.clickAnElement("Terminal_NavToTerminal", "Terminal_NavToTerminal");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Terminal_ClickSearch", "Terminal_ClickSearch");
			functions.globalWait(2);
			
			functions.clickAnElement("Terminal_Search_Dynamic", "Open_Terminal");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Terminal_Replacements", "Merchant_Replacements");
		}
	}
	@Then("^User search Open Terminal to Validate DEBIT REVERSAL Not present$")
	public void user_Any_TermDebitReversal() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Terminal tab
			functions.clickAnElement("Terminal_NavToTerminal", "Terminal_NavToTerminal");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Terminal_ClickSearch", "Terminal_ClickSearch");
			functions.globalWait(2);
			
			functions.clickAnElement("Terminal_Search_Dynamic", "Open_Terminal");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_DebitReversal", "Merchant_DebitReversal");
		}
	}
	@Then("^User search Open Terminal to Validate ALL REMOVED fields Not present$")
	public void user_Any_TermRemovedfileds() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Terminal tab
			functions.clickAnElement("Terminal_NavToTerminal", "Terminal_NavToTerminal");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Terminal_ClickSearch", "Terminal_ClickSearch");
			functions.globalWait(2);
			
			functions.clickAnElement("Terminal_Search_Dynamic", "Open_Terminal");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Terminal_DebitReversal", "Merchant_DebitReversal");
			functions.verifyElementNotPresent("Terminal_Replacements", "Merchant_Replacements");
			functions.verifyElementNotPresent("Terminal_Supplies", "Merchant_Supplies");
			functions.verifyElementNotPresent("Terminal_Training", "Merchant_Training");
			functions.verifyElementNotPresent("Terminal_VoiceCenter", "Merchant_VoiceCenter");
			functions.verifyElementNotPresent("Terminal_WelcomeKits", "Merchant_WelcomeKits");
			functions.verifyElementNotPresent("Terminal_Riskmanagement", "Merchant_Riskmanagement");
			functions.verifyElementNotPresent("Terminal_CreditUnderwriting", "Terminal_CreditUnderwriting");
			functions.verifyElementNotPresent("Terminal_Collections", "Terminal_Collections");
			functions.verifyElementNotPresent("Terminal_PlateOrders", "Terminal_PlateOrders");
			functions.verifyElementNotPresent("Terminal_Conversions", "Terminal_Conversions");
			functions.verifyElementNotPresent("Terminal_HardwareDeployments", "Terminal_HardwareDeployments");
			functions.verifyElementNotPresent("Terminal_Chargebacks", "Terminal_Chargebacks");
			functions.verifyElementNotPresent("Terminal_AMEXESAAgent", "Terminal_AMEXESAAgent");
			functions.verifyElementNotPresent("Terminal_CustomerService", "Terminal_CustomerService");
			functions.verifyElementNotPresent("Terminal_Downloads", "Terminal_Downloads");
			functions.verifyElementNotPresent("Terminal_FullHelpDeskSupport", "Terminal_FullHelpDeskSupport");
			functions.verifyElementNotPresent("Terminal_AfterHoursHelpDeskSupport", "Terminal_AfterHoursHelpDeskSupport");
			functions.verifyElementNotPresent("Terminal_CustomerServicePhone", "Terminal_CustomerServicePhone");
			
		}
	}
	@Then("^User search Open Merchant to Validate ALL REMOVED fields Not present$")
	public void user_Merch_PlateOrder() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Merchant_Existing_Search", "Merchant_Search");
			functions.globalWait(2);
			
			functions.clickAnElement("Merchant_Search_Dynamic", "Open_Merchant");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_DebitReversal", "Merchant_DebitReversal");
			functions.verifyElementNotPresent("Merchant_Replacements", "Merchant_Replacements");
			functions.verifyElementNotPresent("Merchant_Supplies", "Merchant_Supplies");
			functions.verifyElementNotPresent("Merchant_Training", "Merchant_Training");
			functions.verifyElementNotPresent("Merchant_VoiceCenter", "Merchant_VoiceCenter");
			functions.verifyElementNotPresent("Merchant_WelcomeKits", "Merchant_WelcomeKits");
			functions.verifyElementNotPresent("Merchant_Riskmanagement", "Merchant_Riskmanagement");
			functions.verifyElementNotPresent("Merchant_CreditUnderwriting", "Terminal_CreditUnderwriting");
			functions.verifyElementNotPresent("Merchant_Collections", "Terminal_Collections");
			functions.verifyElementNotPresent("Merchant_PlateOrders", "Terminal_PlateOrders");
			functions.verifyElementNotPresent("Merchant_Conversions", "Terminal_Conversions");
			functions.verifyElementNotPresent("Merchant_HardwareDeployments", "Terminal_HardwareDeployments");
			functions.verifyElementNotPresent("Merchant_Chargebacks", "Terminal_Chargebacks");
			functions.verifyElementNotPresent("Merchant_AMEXESAAgent", "Terminal_AMEXESAAgent");
			functions.verifyElementNotPresent("Merchant_CustomerService", "Terminal_CustomerService");
			functions.verifyElementNotPresent("Merchant_Downloads", "Terminal_Downloads");
			functions.verifyElementNotPresent("Merchant_FullHelpDeskSupport", "Terminal_FullHelpDeskSupport");
			functions.verifyElementNotPresent("Merchant_AfterHoursHelpDeskSupport", "Terminal_AfterHoursHelpDeskSupport");
			functions.verifyElementNotPresent("Merchant_CustomerServicePhone", "Terminal_CustomerServicePhone");
			
		}
	}
	@Then("^User search Open Merchant to Validate PLATE ORDER Not present$")
	public void user_Merch_AllFields() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Merchant_Existing_Search", "Merchant_Search");
			functions.globalWait(2);
			
			functions.clickAnElement("Merchant_Search_Dynamic", "Open_Merchant");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_PlateOrders", "Terminal_PlateOrders");
		}
	}
	@Then("^User search Open Merchant to Validate HARDWARE DEPLOYMENT Not present$")
	public void user_Merch_Hardware() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Merchant_Existing_Search", "Merchant_Search");
			functions.globalWait(2);
			
			functions.clickAnElement("Merchant_Search_Dynamic", "Open_Merchant");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_HardwareDeployments", "Terminal_HardwareDeployments");
		}
	}
	@Then("^User search Open Merchant to Validate HELPDESK SUPPOURT Not present$")
	public void user_Merch_HelpDesk() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Merchant_Existing_Search", "Merchant_Search");
			functions.globalWait(2);
			
			functions.clickAnElement("Merchant_Search_Dynamic", "Open_Merchant");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_FullHelpDeskSupport", "Terminal_FullHelpDeskSupport");
			}
	}
	@Then("^User search Open Merchant to Validate RACIAL/ETHENIC Not present$")
	public void user_Merch_Racial() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			//Select Open Status
			functions.selectDropdownByVisibleText("Customer_StatusSearch", "Open");
			//Click on Search
			functions.clickAnElement("Merchant_Existing_Search", "Merchant_Search");
			functions.globalWait(2);
			
			functions.clickAnElement("Merchant_Search_Dynamic", "Open_Merchant");
				
			functions.globalWait(2);
			
			functions.verifyElementNotPresent("Merchant_Racial", "Merchant_Racial");
			}
	}
	
	
	

	@Then("^User verify Invalid SENumber$")
	public void user_verify_Invalid_SENumber() throws InterruptedException {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Add
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			functions.globalWait(10);
			String[] Cardnames = { "MasterCard", "Visa", "American Express", "Alipay", "JCB", "Union Pay International",
					"HSBC Private Label", "Discover", "EBT", "BPI Private Label", "WeChat" };
			int[] Cardnumbers = { 663, 659, 666, 6205, 669, 6086, 5909, 668, 5952, 6193, 6206 };
			String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				for (int j = 0; j < Cardnames.length; j++) {
					if (CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
						int Cardvalue = Cardnumbers[j];
						// Select card type
						WebElement CardCheckBox = FunctionsLibrary.driver
								.findElement(By.xpath("//input[@value='" + Cardvalue + "']"));
						functions.changeRadioButtonOrCheckBoxStatus(CardCheckBox, "check");
						WebElement Senumber = FunctionsLibrary.driver.findElement(
								By.xpath("//input[@value='" + Cardvalue + "']/../../td[2]/input[@id='seNumber']"));

						if (CardTypes[i].equalsIgnoreCase("MasterCard") || CardTypes[i].equalsIgnoreCase("Visa")) {
							functions.enterText(Senumber, functions.getEnvironmentVariable("MerchantNumber"));
						} else {
							functions.enterText(Senumber, testData.get("Merchant_SENumber_" + CardTypes[i]));
						}
					}
				}
				functions.globalWait(10);
				// Click Save
				functions.waitForElementUsingPresence("Merchant_Save");
				functions.clickAnElement("Merchant_Save", "AddCard_Save");
				functions.globalWait(5);
				// functions.verifyElementTextContains("Merchant_InvalidSENumber",
				// testData.get("Merchant_InvalidSENumber"));
				functions.verifyElementPresentWithReport("Merchant_InvalidSENumber");

			}
		}
	}

	@And("^User Deleting  Card types to Open  Merchant$")
	public void user_Deleting_CardTypes_openMerchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Add
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			String[] Cardnames = { "MasterCard", "Visa", "American Express", "Alipay", "JCB", "Union Pay International",
					"HSBC Private Label", "Discover", "EBT", "BPI Private Label", "WeChat", "Debit" };
			int[] Cardnumbers = { 663, 659, 666, 6205, 669, 6086, 5909, 668, 5952, 6193, 6206, 690 };
			String[] CardTypes = testData.get("Merchant_DeleteCardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				for (int j = 0; j < Cardnames.length; j++) {
					if (CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
						int Cardvalue = Cardnumbers[j];
						// Select card type
						WebElement CardCheckBox = FunctionsLibrary.driver
								.findElement(By.xpath("//input[@value='" + Cardvalue + "']"));
						functions.changeRadioButtonOrCheckBoxStatus(CardCheckBox, testData.get("Merchant_uncheck"));

					}
				}
			}
			functions.waitForElementUsingPresence("Merchant_Save");
			functions.clickAnElement("Merchant_Save", "AddCard_Save");
			functions.verifyElementPresentWithReport("Merchant_AddCard_ErrorVerifyMsg");

		}
	}

	@And("^User Deleting Card type to Open  Merchant without error$")
	public void user_Deleting_EBTCardType_openMerchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Add
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			String[] Cardnames = { "MasterCard", "Visa", "American Express", "Alipay", "JCB", "Union Pay International",
					"HSBC Private Label", "Discover", "EBT", "BPI Private Label", "WeChat", "Debit" };
			int[] Cardnumbers = { 663, 659, 666, 6205, 669, 6086, 5909, 668, 5952, 6193, 6206, 690 };
			String[] CardTypes = testData.get("Merchant_DeleteCardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				for (int j = 0; j < Cardnames.length; j++) {
					if (CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
						int Cardvalue = Cardnumbers[j];
						// Select card type
						WebElement CardCheckBox = FunctionsLibrary.driver
								.findElement(By.xpath("//input[@value='" + Cardvalue + "']"));
						functions.changeRadioButtonOrCheckBoxStatus(CardCheckBox, testData.get("Merchant_uncheck"));

					}
				}
			}
			functions.waitForElementUsingPresence("Merchant_Save");
			functions.clickAnElement("Merchant_Save", "AddCard_Save");
			// functions.verifyElementPresentWithReport("Merchant_AddCard_ErrorVerifyMsg");
			functions.verifyElementTextContains("Merchant_AddCard_VerifyMsg",
					testData.get("Merchant_AddCard_VerifyMsg"));
		}
	}

	@And("^User Adding Card types to Terminal with errror$")
	public void user_Add_CardTypes_Terminal_witherror() throws Throwable {
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
				int Cardlistvalue = 0;

				if (CardName.equalsIgnoreCase("HSBC Private Label")) {
					Cardlistvalue = 5909;
				}
				if (CardName.equalsIgnoreCase("HSBC Private Label")) {
					Cardlistvalue = 5909;
				}
				if (CardName.equalsIgnoreCase("Union Pay International")) {
					Cardlistvalue = 6086;
				}
				if (CardName.equalsIgnoreCase("MasterCard")) {
					Cardlistvalue = 663;
				}
				if (CardName.equalsIgnoreCase("Visa")) {
					Cardlistvalue = 659;
				}
				if (CardName.equalsIgnoreCase("JCB")) {
					Cardlistvalue = 669;
				}
				if (CardName.equalsIgnoreCase("HSBC Bonus Points")) {
					Cardlistvalue = 5910;
				}
				if (CardName.equalsIgnoreCase("Discover")) {
					Cardlistvalue = 668;
				}
				if (CardName.equalsIgnoreCase("American Express")) {
					Cardlistvalue = 666;
				}
				if (CardName.equalsIgnoreCase("Debit")) {
					Cardlistvalue = 690;
				}
				if (CardName.equalsIgnoreCase("EBT")) {
					Cardlistvalue = 5952;
				}
				if (CardName.equalsIgnoreCase("BPI Private Label")) {
					Cardlistvalue = 6193;
				}
				if (CardName.equalsIgnoreCase("Alipay")) {
					Cardlistvalue = 6205;
				}
				if (CardName.equalsIgnoreCase("WeChat")) {
					Cardlistvalue = 6206;
				}
				WebElement cardpath = FunctionsLibrary.driver
						.findElement(By.xpath("//input[@value='" + Cardlistvalue + "']"));
				functions.changeRadioButtonOrCheckBoxStatus(cardpath, testData.get("Terminal_Checkbox"));
				// Select EDC Indicator
				WebElement EdcInd = FunctionsLibrary.driver.findElement(By.xpath(
						"//input[@value='" + Cardlistvalue + "']//following::select[@name='cardEdcIndicator'][1]"));
				functions.selectDropdownByVisibleText(EdcInd, testData.get("Terminal_EDcIndicator_" + CardTypes[i]));
				// Select Transaction Switching Option
				WebElement TranSwitch = FunctionsLibrary.driver.findElement(By.xpath(
						"//input[@value='" + Cardlistvalue + "']//following::select[@name='transactionSwitch'][1]"));
				functions.selectDropdownByVisibleText(TranSwitch,
						testData.get("Terminal_TransactionSwitch_" + CardTypes[i]));
				// Click Save
				functions.clickAnElement("Terminal_Save", "Terminal_Save");
				functions.globalWait(8);
				functions.verifyElementPresentWithReport("Terminal_AddCard_ErrorVerifyMsg");
				// functions.waitForElementUsingPresence("Terminal_CardAccepted_SuccessMsg");
				// functions.verifyElementTextContains("Terminal_CardAccepted_SuccessMsg",
				// testData.get("Terminal_CardAccepted_SuccessMsg"));

			}
		}
	}

	@And("^User clicking update terminal  to Merchantcards$")
	public void user_Updateterminal_to_Merchantcards() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Add
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			String[] Cardnames = { "MasterCard", "Visa", "American Express", "Alipay", "JCB", "Union Pay International",
					"HSBC Private Label", "Discover", "EBT", "BPI Private Label", "WeChat", "Debit" };
			int[] Cardnumbers = { 663, 659, 666, 6205, 669, 6086, 5909, 668, 5952, 6193, 6206, 690 };
			String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				for (int j = 0; j < Cardnames.length; j++) {
					if (CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
						int Cardvalue = Cardnumbers[j];
						// Select card type
						WebElement CardCheckBox = FunctionsLibrary.driver
								.findElement(By.xpath("//input[@value='" + Cardvalue + "']"));
						functions.changeRadioButtonOrCheckBoxStatus(CardCheckBox, "check");
						WebElement Senumber = FunctionsLibrary.driver.findElement(
								By.xpath("//input[@value='" + Cardvalue + "']/../../td[2]/input[@id='seNumber']"));

						if (CardTypes[i].equalsIgnoreCase("MasterCard") || CardTypes[i].equalsIgnoreCase("Visa")) {
							functions.enterText(Senumber, functions.getEnvironmentVariable("MerchantNumber"));
						} else {
							functions.enterText(Senumber, testData.get("Merchant_SENumber_" + CardTypes[i]));
						}
					}
				}

			}
			functions.waitForElementUsingPresence("Merchant_updateAllterminal");
			functions.clickAnElement("Merchant_updateAllterminal", "Merchant_updateAllterminal");
			functions.waitForElementUsingPresence("Merchant_AddCard_ErrorVerifyMsg");
			functions.verifyElementPresentWithReport("Merchant_AddCard_ErrorVerifyMsg");

		}
	}

	@And("^User clicking update terminal  to Merchantcards without error$")
	public void user_Updateterminal_to_Merchantcards_withouterror() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Add
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			String[] Cardnames = { "MasterCard", "Visa", "American Express", "Alipay", "JCB", "Union Pay International",
					"HSBC Private Label", "Discover", "EBT", "BPI Private Label", "WeChat", "Debit" };
			int[] Cardnumbers = { 663, 659, 666, 6205, 669, 6086, 5909, 668, 5952, 6193, 6206, 690 };
			String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				for (int j = 0; j < Cardnames.length; j++) {
					if (CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
						int Cardvalue = Cardnumbers[j];
						// Select card type
						WebElement CardCheckBox = FunctionsLibrary.driver
								.findElement(By.xpath("//input[@value='" + Cardvalue + "']"));
						functions.changeRadioButtonOrCheckBoxStatus(CardCheckBox, "check");
						WebElement Senumber = FunctionsLibrary.driver.findElement(
								By.xpath("//input[@value='" + Cardvalue + "']/../../td[2]/input[@id='seNumber']"));
						

						if (CardTypes[i].equalsIgnoreCase("MasterCard") || CardTypes[i].equalsIgnoreCase("Visa")) {
							
						
							functions.enterText(Senumber, functions.getEnvironmentVariable("MerchantNumber"));
						} else {
							functions.clearText(Senumber);
							functions.enterText(Senumber, testData.get("Merchant_SENumber_" + CardTypes[i]));
						}
					}
				}

			}
			functions.waitForElementUsingPresence("Merchant_updateAllterminal");
			functions.clickAnElement("Merchant_updateAllterminal", "Merchant_updateAllterminal");
			functions.verifyElementTextContains("Merchant_AddUpdateAll_VerifyMsg",
					testData.get("Merchant_AddUpdateAll_VerifyMsg"));

		}
	}
	@And("^User clicking update terminal  to Merchant already existing cards without error$")
	public void user_Updateterminal_to_Merchantcards_alreadyexisting_withouterror() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Add
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			String[] Cardnames = { "MasterCard", "Visa", "American Express", "Alipay", "JCB", "Union Pay International",
					"HSBC Private Label", "Discover", "EBT", "BPI Private Label", "WeChat", "Debit" };
			int[] Cardnumbers = { 663, 659, 666, 6205, 669, 6086, 5909, 668, 5952, 6193, 6206, 690 };
			String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				for (int j = 0; j < Cardnames.length; j++) {
					if (CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
						int Cardvalue = Cardnumbers[j];
						// Select card type
						WebElement CardCheckBox = FunctionsLibrary.driver
								.findElement(By.xpath("//input[@value='" + Cardvalue + "']"));
						functions.changeRadioButtonOrCheckBoxStatus(CardCheckBox, "check");
						WebElement Senumber = FunctionsLibrary.driver.findElement(
								By.xpath("//input[@value='" + Cardvalue + "']/../../td[2]/input[@id='seNumber']"));
						

						if (CardTypes[i].equalsIgnoreCase("MasterCard") || CardTypes[i].equalsIgnoreCase("Visa")) {
							
						
							//functions.enterText(Senumber, functions.getEnvironmentVariable("MerchantNumber"));
						} else {
							functions.clearText(Senumber);
							functions.enterText(Senumber, testData.get("Merchant_SENumber_" + CardTypes[i]));
						}
					}
				}

			}
			functions.waitForElementUsingPresence("Merchant_updateAllterminal");
			functions.clickAnElement("Merchant_updateAllterminal", "Merchant_updateAllterminal");
			functions.verifyElementTextContains("Merchant_AddUpdateAll_VerifyMsg",
					testData.get("Merchant_AddUpdateAll_VerifyMsg"));

		}
	}
	@And("^User clicking uncheckbox  to Merchantcards without error$")
	public void user_Updateterminal_to_uncheck_Merchantcards_withouterror() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click Add
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			String[] Cardnames = { "MasterCard", "Visa", "American Express", "Alipay", "JCB", "Union Pay International",
					"HSBC Private Label", "Discover", "EBT", "BPI Private Label", "WeChat", "Debit" };
			int[] Cardnumbers = { 663, 659, 666, 6205, 669, 6086, 5909, 668, 5952, 6193, 6206, 690 };
			String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				for (int j = 0; j < Cardnames.length; j++) {
					if (CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
						int Cardvalue = Cardnumbers[j];
						// Select card type
						WebElement CardCheckBox = FunctionsLibrary.driver
								.findElement(By.xpath("//input[@value='" + Cardvalue + "']"));
						functions.changeRadioButtonOrCheckBoxStatus(CardCheckBox, testData.get("Merchant_uncheck"));
						
						}
					}
				}

			}
		functions.waitForElementUsingPresence("Merchant_Save");
		functions.clickAnElement("Merchant_Save", "AddCard_Save");
		functions.globalWait(5);
			functions.verifyElementTextContains("Merchant_AddCard_VerifyMsg",
					testData.get("Merchant_AddCard_VerifyMsg"));

		}
	
	@When("^User verify EBT card in terminal page$")
	public void user_verify_EBTcard_Terminalpage() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;

			functions.verifyElementPresentWithReport("Terminal_EBTCardVerify");

		}
	}

	@And("^User gets unique Merchant ID$")
	public void user_create_MerchantID() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;

			s = functions.getElementText("Merchant_MerchantId");
		}
	}

	@And("^User searching for the  Merchant by gettext$")
	public void user_Search_for_Merchant() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			// Click on Home button
			functions.clickAnElement("Home", "Home_Tab");
			// Click on Customer tab
			functions.clickAnElement("Merchant_NavtoMerch", "NavtoMerch");
			// Enter Merchant Number to search
			// functions.enterText("Merchant_MerchantIdSearch",
			// functions.getEnvironmentVariable("MerchantNumber"));
			functions.enterText("Merchant_MerchantIdSearch", s);
			// Click on Search Button
			functions.clickAnElement("Merchant_Existing_Search", "Search");
			String MerchantNumber = testData.get("Merchant_MerchantIdSearch");
			functions.setEnvironmentVariable("MerchNumber", MerchantNumber);
		}
	}

	@And("^User move terminal to deactivate state$")
	public void user_move_terminal_deactivatestate() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Terminal_Edit", "Terminal_Edit");
			functions.selectDropdownByVisibleText("Terminal_Status", testData.get("Terminal_Status"));
			// click on save
			functions.clickAndEnterAnElement("Terminal_Save", "Terminal_Save");

		}
	}

	@And("^User move Merchant to deactivate state and open$")
	public void user_move_merchant_deactivatestate_and_open() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;

			functions.clickAnElement("Merchant_EditButton", "Edit");
			functions.selectDropdownByVisibleText("MerchAndTerm_Status", testData.get("MerchAndTerm_Status"));
			functions.clickAnElement("Merchant_Save", "Save");
			functions.clickAnElement("Merchant_Reopen", "Reopen");
		}
	}

	@And("^User verify alert message for merchant SE number$")
	public void user_verify_alertmessage_merchant_SENumber() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			functions.globalWait(10);
			String[] Cardnames = { "MasterCard", "Visa", "American Express", "Alipay", "JCB", "Union Pay International",
					"HSBC Private Label", "Discover", "EBT", "BPI Private Label", "WeChat", "Debit" };
			int[] Cardnumbers = { 663, 659, 666, 6205, 669, 6086, 5909, 668, 5952, 6193, 6206, 690 };
			String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				for (int j = 0; j < Cardnames.length; j++) {
					if (CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
						int Cardvalue = Cardnumbers[j];
						// Select card type
						WebElement CardCheckBox = FunctionsLibrary.driver
								.findElement(By.xpath("//input[@value='" + Cardvalue + "']"));
						functions.changeRadioButtonOrCheckBoxStatus(CardCheckBox, "check");
						WebElement Senumber = FunctionsLibrary.driver.findElement(
								By.xpath("//input[@value='" + Cardvalue + "']/../../td[2]/input[@id='seNumber']"));

					}

				}
				functions.globalWait(10);
				// Click Save
				functions.waitForElementUsingPresence("Merchant_Save");
				functions.clickAnElement("Merchant_Save", "AddCard_Save");
				functions.acceptAlertVerifyText("accept", testData.get("Merchant_alertText"));

			}
		}

	}

	@And("^User verify Transaction Switch listvalue$")
	public void user_verify_Transactionswitch_listvalue() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;

			functions.VerifyDropDownListValues("Terminal_TransactionSwitch",
					testData.get("Terminal_TransactionSwitch"));
		}
	}

	@And("^User verify SE number for Visa and Mastercard$")
	public void user_verify_SEnumber_visaandMaster() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			functions.globalWait(10);
			functions.verifyElementTextContains("Merchant_MasterSEnumber",
					functions.getEnvironmentVariable("MerchantNumber"));
			functions.verifyElementTextContains("Merchant_VisaSEnumber",
					functions.getEnvironmentVariable("MerchantNumber"));

		}

	}

	@Then("^User verify Disabled EDCIndicator for AuthOnly$")
	public void user_verify_Disabled_EDCIndicator() throws Throwable {
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
				int Cardlistvalue = 0;

				if (CardName.equalsIgnoreCase("HSBC Private Label")) {
					Cardlistvalue = 5909;
				}
				if (CardName.equalsIgnoreCase("HSBC Private Label")) {
					Cardlistvalue = 5909;
				}
				if (CardName.equalsIgnoreCase("Union Pay International")) {
					Cardlistvalue = 6086;
				}
				if (CardName.equalsIgnoreCase("MasterCard")) {
					Cardlistvalue = 663;
				}
				if (CardName.equalsIgnoreCase("Visa")) {
					Cardlistvalue = 659;
				}
				if (CardName.equalsIgnoreCase("JCB")) {
					Cardlistvalue = 669;
				}
				if (CardName.equalsIgnoreCase("HSBC Bonus Points")) {
					Cardlistvalue = 5910;
				}
				if (CardName.equalsIgnoreCase("Discover")) {
					Cardlistvalue = 668;
				}
				if (CardName.equalsIgnoreCase("American Express")) {
					Cardlistvalue = 666;
				}
				if (CardName.equalsIgnoreCase("Debit")) {
					Cardlistvalue = 690;
				}
				if (CardName.equalsIgnoreCase("EBT")) {
					Cardlistvalue = 5952;
				}
				if (CardName.equalsIgnoreCase("BPI Private Label")) {
					Cardlistvalue = 6193;
				}
				if (CardName.equalsIgnoreCase("Alipay")) {
					Cardlistvalue = 6205;
				}
				if (CardName.equalsIgnoreCase("WeChat")) {
					Cardlistvalue = 6206;
				}
				WebElement EdcInd = FunctionsLibrary.driver.findElement(By.xpath(
						"//input[@value='" + Cardlistvalue + "']//following::select[@name='cardEdcIndicator'][1]"));
				functions.selectDropdowndisable(EdcInd, "VisibleText", testData.get("Terminal_EDcIndicator_" + CardTypes[i]));
				//functions.verifyElementisDisabled("EdcInd");

			}
		}
	}
	@And("^User validates Merchant cards page$")
	public void user_validates_merchantcards_page() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
	
	  functions.verifyElementPresent("MerchantNameverify", "MerchantNameVerify");
      functions.verifyElementPresent("MerchantIDVerify", "MerchantIDVerify");
      // functions.verifyElementTextContains("MerchantIDNumberVerify", functions.getEnvironmentVariable("MerchantNumber"));
      functions.verifyElementPresent("MerchantIDNumberVerify", "MerchantIDNumberVerify");
      functions.verifyElementPresent("Merchant_Save", "Merchant_Save");
      functions.verifyElementPresent("Merchant_updateAllterminal", "Merchant_updateAllterminal");
      functions.verifyElementPresent("Merchant_UndoAll", "Merchant_UndoAll");
		String[] Cardnames = { "MasterCard", "Visa", "American Express", "Alipay", "JCB", "Union Pay International",
				"HSBC Private Label", "Discover", "EBT", "BPI Private Label", "WeChat", "Debit" };
		int[] Cardnumbers = { 663, 659, 666, 6205, 669, 6086, 5909, 668, 5952, 6193, 6206, 690 };
		String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
		for (int i = 0; i < CardTypes.length; i++) {
			for (int j = 0; j < Cardnames.length; j++) {
				if (CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
					int Cardvalue = Cardnumbers[j];
					String CardType=Cardnames[j];
					
					
					
	WebElement checkboxverify = FunctionsLibrary.driver.findElement(By.xpath("//input[@value='" +Cardvalue+ "']"));
		functions.verifyElementPresent("checkboxverify", checkboxverify);
		WebElement Cardtypesverify = FunctionsLibrary.driver.findElement(By.xpath("//td[contains(text(),'" +CardType+ "')]"));
		functions.verifyElementPresent("cardtypesverify", Cardtypesverify);
		WebElement Senumber = FunctionsLibrary.driver.findElement(By.xpath("//input[@value='" + Cardvalue + "']/../../td[2]/input[@id='seNumber']"));

		functions.verifyElementPresent("Senumber", Senumber);
		functions.verifyElementPresent("Merchant_SaveUndercards", "Merchant_SaveUndercards");
	      functions.verifyElementPresent("Merchant_updateAllterminalundercards", "Merchant_updateAllterminalundercards");
	      functions.verifyElementPresent("Merchant_UndoAllUndercards", "Merchant_UndoAllUndercards");
	      functions.verifyElementPresent("Merchant_BacktoMerchant", "Merchant_BacktoMerchant");
	      functions.verifyElementPresent("Merchant_checkallcardtypes", "Merchant_checkallcardtypes");
	      
		

			
				}
			}
		}
		}
	}
	
	@Then("^User validates Merchant cards for canada$")
	public void user_validates_merchantcards_canada() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			functions.globalWait(10);
			String[] Cardnames = { "MasterCard", "Visa", "American Express", "Alipay", "JCB", "Union Pay International",
					"HSBC Private Label", "Discover", "EBT", "BPI Private Label", "WeChat", "Debit" };
			int[] Cardnumbers = { 663, 659, 666, 6205, 669, 6086, 5909, 668, 5952, 6193, 6206, 690 };
			String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				for (int j = 0; j < Cardnames.length; j++) {
					if (CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
						int Cardvalue = Cardnumbers[j];
						String CardType=Cardnames[j];
						WebElement Cardtypesverify = FunctionsLibrary.driver.findElement(By.xpath("//td[contains(text(),'" +CardType+ "')]"));
						functions.verifyElementPresent("cardtypesverify", Cardtypesverify);
					}
				}
			}
			
			
			
		}
		
	}
	
	@Then("^User verify deleting two cards for terminalpage$")
	public void user_verify_deletingtwocards_terminalpage() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Terminal_AddCards", "Terminal_AddCards");
			functions.globalWait(5);
			
			String[] CardTypes = testData.get("Terminal_TwoCardTypesDelete").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				String CardName = CardTypes[i];
				int Cardlistvalue = 0;

				if (CardName.equalsIgnoreCase("HSBC Private Label")) {
					Cardlistvalue = 5909;
				}
				if (CardName.equalsIgnoreCase("HSBC Private Label")) {
					Cardlistvalue = 5909;
				}
				if (CardName.equalsIgnoreCase("Union Pay International")) {
					Cardlistvalue = 6086;
				}
				if (CardName.equalsIgnoreCase("MasterCard")) {
					Cardlistvalue = 663;
				}
				if (CardName.equalsIgnoreCase("Visa")) {
					Cardlistvalue = 659;
				}
				if (CardName.equalsIgnoreCase("JCB")) {
					Cardlistvalue = 669;
				}
				if (CardName.equalsIgnoreCase("HSBC Bonus Points")) {
					Cardlistvalue = 5910;
				}
				if (CardName.equalsIgnoreCase("Discover")) {
					Cardlistvalue = 668;
				}
				if (CardName.equalsIgnoreCase("American Express")) {
					Cardlistvalue = 666;
				}
				if (CardName.equalsIgnoreCase("Debit")) {
					Cardlistvalue = 690;
				}
				if (CardName.equalsIgnoreCase("EBT")) {
					Cardlistvalue = 5952;
				}
				if (CardName.equalsIgnoreCase("BPI Private Label")) {
					Cardlistvalue = 6193;
				}
				if (CardName.equalsIgnoreCase("Alipay")) {
					Cardlistvalue = 6205;
				}
				if (CardName.equalsIgnoreCase("WeChat")) {
					Cardlistvalue = 6206;
				}
				WebElement cardpath = FunctionsLibrary.driver.findElement(By.xpath("//input[@value='" + Cardlistvalue + "']"));
				functions.changeRadioButtonOrCheckBoxStatus(cardpath, testData.get("Terminal_Uncheck"));
							
			}
			functions.clickAnElement("Terminal_Save", "Terminal_Save"); 
			functions.globalWait(8);
			functions.verifyElementTextContains("Terminal_CardAccepted_SuccessMsg", testData.get("Terminal_CardAccepted_SuccessMsg"));
		}
	}
	@Then("^User verify deleting full cards for terminalpage$")
	public void user_verify_deletingfullcards_terminalpage() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			
			//functions.waitForElementUsingPresence("Terminal_CardType");
			//functions.globalWait(10);


			String[] CardTypes = testData.get("Terminal_fullCardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				String CardName = CardTypes[i];
				int Cardlistvalue = 0;

				if (CardName.equalsIgnoreCase("HSBC Private Label")) {
					Cardlistvalue = 5909;
				}
				if (CardName.equalsIgnoreCase("HSBC Private Label")) {
					Cardlistvalue = 5909;
				}
				if (CardName.equalsIgnoreCase("Union Pay International")) {
					Cardlistvalue = 6086;
				}
				if (CardName.equalsIgnoreCase("MasterCard")) {
					Cardlistvalue = 663;
				}
				if (CardName.equalsIgnoreCase("Visa")) {
					Cardlistvalue = 659;
				}
				if (CardName.equalsIgnoreCase("JCB")) {
					Cardlistvalue = 669;
				}
				if (CardName.equalsIgnoreCase("HSBC Bonus Points")) {
					Cardlistvalue = 5910;
				}
				if (CardName.equalsIgnoreCase("Discover")) {
					Cardlistvalue = 668;
				}
				if (CardName.equalsIgnoreCase("American Express")) {
					Cardlistvalue = 666;
				}
				if (CardName.equalsIgnoreCase("Debit")) {
					Cardlistvalue = 690;
				}
				if (CardName.equalsIgnoreCase("EBT")) {
					Cardlistvalue = 5952;
				}
				if (CardName.equalsIgnoreCase("BPI Private Label")) {
					Cardlistvalue = 6193;
				}
				if (CardName.equalsIgnoreCase("Alipay")) {
					Cardlistvalue = 6205;
				}
				if (CardName.equalsIgnoreCase("WeChat")) {
					Cardlistvalue = 6206;
				}
				WebElement cardpath = FunctionsLibrary.driver.findElement(By.xpath("//input[@value='" + Cardlistvalue + "']"));
				functions.changeRadioButtonOrCheckBoxStatus(cardpath, testData.get("Terminal_Uncheck"));
				
				//functions.verifyElementPresentWithReport("Terminal_AddCard_ErrorVerifyMsg");
									
				
			}
			functions.clickAnElement("Terminal_Save", "Terminal_Save"); 
			functions.globalWait(8);
			functions.acceptAlertVerifyText("accept", testData.get("Alert"));
		}
	}
	
	
	
	
	@Then("^User clicks checkall and uncheck cardtypes in merchantpage$")
	public void user_clicks_checkall_cardtypes_merchantpage() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.waitForElementUsingPresence("Merchant_AddCards");
			functions.clickAnElement("Merchant_AddCards", "AddCard");
			functions.globalWait(5);
			String[] Cardnames = { "MasterCard", "Visa", "American Express", "Alipay", "JCB", "Union Pay International",
					"HSBC Private Label", "Discover", "EBT", "BPI Private Label", "WeChat", "Debit" };
			int[] Cardnumbers = { 663, 659, 666, 6205, 669, 6086, 5909, 668, 5952, 6193, 6206, 690 };
			String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				for (int j = 0; j < Cardnames.length; j++) {
					if (CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
						int Cardvalue = Cardnumbers[j];
						String CardType=Cardnames[j];
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
			}	
		functions.clickAnElement("Merchant_checkallcardtypes", "checkall");
		functions.waitForElementUsingPresence("Merchant_Save");
		functions.clickAnElement("Merchant_Save", "AddCard_Save");
		functions.verifyElementTextContains("Merchant_AddCard_VerifyMsg",
				testData.get("Merchant_AddCard_VerifyMsg"));
		functions.clickAnElement("Merchant_checkallcardtypes", "uncheckall");
		functions.waitForElementUsingPresence("Merchant_Save");
		functions.clickAnElement("Merchant_Save", "AddCard_Save");
		functions.verifyElementTextContains("Merchant_AddCard_VerifyMsg",
				testData.get("Merchant_AddCard_VerifyMsg"));
		
						
			
		}
				}
	@Then("^User verify jcb added to terminal page$")
	public void user_verify_jcb_addedto_terminalpage() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
		

			String[] CardTypes = testData.get("Terminal_CardTypesJCBVerify").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				String CardName = CardTypes[i];
				int Cardlistvalue = 0;

				if (CardName.equalsIgnoreCase("HSBC Private Label")) {
					Cardlistvalue = 5909;
				}
				if (CardName.equalsIgnoreCase("HSBC Private Label")) {
					Cardlistvalue = 5909;
				}
				if (CardName.equalsIgnoreCase("Union Pay International")) {
					Cardlistvalue = 6086;
				}
				if (CardName.equalsIgnoreCase("MasterCard")) {
					Cardlistvalue = 663;
				}
				if (CardName.equalsIgnoreCase("Visa")) {
					Cardlistvalue = 659;
				}
				if (CardName.equalsIgnoreCase("JCB")) {
					Cardlistvalue = 669;
				}
				if (CardName.equalsIgnoreCase("HSBC Bonus Points")) {
					Cardlistvalue = 5910;
				}
				if (CardName.equalsIgnoreCase("Discover")) {
					Cardlistvalue = 668;
				}
				if (CardName.equalsIgnoreCase("American Express")) {
					Cardlistvalue = 666;
				}
				if (CardName.equalsIgnoreCase("Debit")) {
					Cardlistvalue = 690;
				}
				if (CardName.equalsIgnoreCase("EBT")) {
					Cardlistvalue = 5952;
				}
				if (CardName.equalsIgnoreCase("BPI Private Label")) {
					Cardlistvalue = 6193;
				}
				if (CardName.equalsIgnoreCase("Alipay")) {
					Cardlistvalue = 6205;
				}
				if (CardName.equalsIgnoreCase("WeChat")) {
					Cardlistvalue = 6206;
				}
				WebElement cardpath = FunctionsLibrary.driver
						.findElement(By.xpath("//input[@value='" + Cardlistvalue + "']"));
				functions.verifyRadioButtonOrCheckBoxIsSelected(cardpath, "checkboxselected");
				
						
					
				
			}
		}
	}
			
	@Then("^User verify AuditDetails in Merchantpage$")
	public void user_verify_AuditDetails_merchantpage() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Merchant_EditButton", "Edit");
			functions.verifyElementPresent("Merchant_AuditUserID", "Merchant_AuditUserID");
			//functions.verifyElementTextContains("Merchant_AuditUserID", testData.get("Merchant_AuditUserID"));
			functions.verifyElementPresent("Merchant_AuditLastName", "Merchant_AuditLastName");
			//functions.verifyElementTextContains("Merchant_AuditLastName", testData.get("Merchant_AuditLastName"));
			functions.verifyElementPresent("Merchant_AuditFirstName", "Merchant_AuditFirstName");
			//functions.verifyElementTextContains("Merchant_AuditFirstName", testData.get("Merchant_AuditFirstName"));
			functions.clickAnElement("Merchant_Save", "Save");
			
		}
	}
	
	@Then("^User verify Undefined MCC in terminalPage$")
	public void user_verify_undefinedMCC_terminalPage() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.enterText("Terminal_ConfigureTerminalType", testData.get("Terminal_ConfigureTerminalType"));
			// Select Configured Terminal Type
			//functions.selectDropdown("Terminal_TerminalCapability", "VisibleText",testData.get("Terminal_TerminalCapability"));
			// Enter MCC
			functions.enterText("Terminal_MCC", testData.get("Terminal_MCC"));
			//functions.verifyElementTextPresentContains("Terminal_AuthorizationStatus", testData.get("Terminal_AuthorizationStatus"));

			functions.verifyElementTextContains("Terminal_AuthorizationStatus", testData.get("Terminal_AuthorizationStatus"));
			
		}
	}
	@Then("^User verify SE numbers for merchant page$")
	public void user_veerify_SENumbers_Merchantpage() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
		
			String[] Cardnames = {"MasterCard","Visa","American Express","Alipay","JCB","Union Pay International","HSBC Private Label","Discover","EBT","BPI Private Label","WeChat","Debit","Diners Club"};
			int[] Cardnumbers= {663,659,666,6205,669,6086,5909,668,5952,6193,6206,690,667};
			String[] CardTypes = testData.get("Merchant_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				for(int j=0; j<Cardnames.length;j++) {
					if(CardTypes[i].equalsIgnoreCase(Cardnames[j])) {
						int Cardvalue=Cardnumbers[j];
						//Select card type
						WebElement CardCheckBox=FunctionsLibrary.driver.findElement(By.xpath("//input[@value='"+Cardvalue+"']"));
						functions.verifyElementPresent("CardCheckBox", CardCheckBox);
						WebElement Senumber=FunctionsLibrary.driver.findElement(By.xpath("//input[@value='"+Cardvalue+"']/../../td[2]/input[@id='seNumber']"));
						functions.verifyElementPresent("Senumber", Senumber);
						//functions.verifyElementTextContains(Senumber, testData.get("Merchant_SENumber_" + CardTypes[i]));
						
						
						}
					}
				}
			
		}
	}

	@Then("^User Edit Country Code in MerchantPage$")
	public void user_Edit_CountryCode_MerchantPage() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			functions.clickAnElement("Merchant_EditButton", "Edit");
			// Enter Country
						functions.enterText("Merchant_Country", testData.get("Merchant_CountryEdit"));
						FunctionsLibrary.driver.findElement(By.id("dbaCountryCodeDescription")).click();
						functions.globalWait(10);
			
						// Enter Zip/Postal Code
						functions.enterText("Merchant_PostalCode", testData.get("Merchant_PostalCodeEdit"));
						// if(FunctionsLibrary.driver.getCurrentUrl().contains("CMFNA")) {
						functions.selectDropdownByVisibleText("Merchant_State", testData.get("Merchant_StateEdit"));
		}
	}
			
	@And("^User Verify EDC indicator to Terminal$")
	public void user_EDCIndicator_Terminal() throws Throwable {
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
									
									// Select EDC Indicator
									WebElement EdcInd=FunctionsLibrary.driver.findElement(By.xpath("//input[@value='"+Cardlistvalue+"']//following::select[@name='cardEdcIndicator'][1]"));
									functions.verifyElementPresent("EDCIndicatorVerify", EdcInd);
								}
							}
						} 
	
	@And("^User Change EDC Indicator to Terminal$")
	public void user_change_EDCIndicator_Terminal() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			

			String[] CardTypes = testData.get("Terminal_CardTypes").split("@@");
			for (int i = 0; i < CardTypes.length; i++) {
				String CardName = CardTypes[i];
				int Cardlistvalue=0;
				
				if(CardName.equalsIgnoreCase("HSBC Private Label")){
					Cardlistvalue=5909;
				} 
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
								
									WebElement EdcIndChange=FunctionsLibrary.driver.findElement(By.xpath("//input[@value='"+Cardlistvalue+"']//following::select[@name='cardEdcIndicator'][1]"));
									functions.selectDropdownByVisibleText(EdcIndChange, testData.get("Terminal_EDcIndicatorChange_" + CardTypes[i]));
									functions.clickAnElement("Terminal_Save", "Terminal_Save"); 
									functions.globalWait(8);
									functions.waitForElementUsingPresence("Terminal_CardAccepted_SuccessMsg");
									functions.verifyElementTextContains("Terminal_CardAccepted_SuccessMsg", testData.get("Terminal_CardAccepted_SuccessMsg"));
									functions.verifyElementPresent("ECDChange", EdcIndChange);

								}
							}
						} 
	@And("^User Creating Child Customer and verify LOB$")
	public void createChildCustomer() throws Throwable {
		if(CommonStepDefinitions.executeScenario()){
			if(!CommonStepDefinitions.exescenario)
				return;
		Random ran = new Random(System.currentTimeMillis());
		int x = (int)(Math.random() * 999) + Math.abs(ran.nextInt());
		String strCustNumber = "91";
		String strCustomerName = "Customer_91";
		strCustNumber = strCustNumber.concat(Integer.toString(x));
		strCustomerName = strCustomerName.concat(Integer.toString(x));
		functions.setEnvironmentVariable("ChildCustomerNumber", strCustNumber);
		functions.setEnvironmentVariable("ChildCustomerName", strCustomerName);
		
		functions.enterText("Customer_CustomerNumber", functions.getEnvironmentVariable("ChildCustomerNumber"));
		functions.enterText("Customer_CustomerName", functions.getEnvironmentVariable("ChildCustomerName"));
		functions.globalWait(8);
		functions.clickAnElement("Customer_Save_Button", "Save_PendingCust");
		functions.globalWait(5);
		functions.verifyElementTextPresent("Customer_Save_SuccessMsg", testData.get("Customer_Save_SuccessMsg"));
		functions.clickAnElement("Customer_Edit_Button", "Edit");
		functions.waitForElementUsingPresence("Customer_Save_Button");
		//Change Status
		functions.selectDropdownByVisibleText("Customer_Satus_Listbox", testData.get("Customer_Satus_Listbox"));
		//Click on Save Button
		functions.clickAnElement("Customer_Save_Button", "Save");
		
		functions.waitForElementUsingPresence("Customer_Updated_Msg");
		functions.verifyElementTextContains("Customer_Updated_Msg", testData.get("Customer_Updated_Msg"));
		functions.clickAnElement("Customer_Edit_Button", "Edit");
		functions.selectDropdownByVisibleText("Customer_LineOfBusiness", "Customer_LineOfBusiness");
		// verify validate Message
		functions.verifySelectedDropDownValue("Customer_LineOfBusiness", "Customer_LineOfBusiness");
		
		
	}}
	@And("^User Navigates to child customernumber$")
	public void user_Navigate_ChildCustomer_Number() {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
		
			// Click Add Child Customer
			functions.clickAnElement("Customer_Addchildcustomer", "Click Add Child Customer");
			
			
		}
	}
	
	@And("^User Verifying cardtypes for different Terminal$")
	public void user_verify_cardtypes_terminal() throws Throwable {
		if (CommonStepDefinitions.executeScenario()) {
			if (!CommonStepDefinitions.exescenario)
				return;
			
			
			for(int j=1; j<=3; j++)
			{
				// Click on Home button
				functions.clickAnElement("Home", "Home_Tab");
				// Click on Terminal tab
				functions.clickAnElement("Terminal_NavToTerminal", "Terminal_NavToTerminal");
			functions.waitForElementUsingPresence("Terminal_TerminalIdSearch");
			// Enter Terminal Number to search

			functions.enterText("Terminal_TerminalIdSearch", testData.get("Terminal_TerminalIdSearch"+j));
			// Click on Search Button
			functions.clickAnElement("Terminal_Search", "Terminal_Search");
			
			
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
				//functions.changeRadioButtonOrCheckBoxStatus(cardpath, testData.get("Terminal_Checkbox"));
				functions.verifyElementPresent("checkboxverify", cardpath);
			/*	// Select EDC Indicator
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
						testData.get("Terminal_CardAccepted_SuccessMsg"));*/
			}

			}
		}
	}
	
	
	public static boolean executeScenario() {
		boolean executeTC = false;
		if (executeScenario.equalsIgnoreCase("Yes")) {
			executeTC = true;
		} else
			executeTC = false;

		return executeTC;
	}

}
