package com.webapp.utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webapp.baseLibrary.FunctionsLibrary;
import com.webapp.executioner.ExecutionerClass;
import com.webapp.utilities.HTML;
import com.webapp.utilities.HTML2XML;

public class QtestPage extends ExecutionerClass
{
	public QtestPage() 
	{
		PageFactory.initElements(FunctionsLibrary.driver, this);
	}
	
	static FunctionsLibrary functions=new FunctionsLibrary();
	
/*	public String tc_id=CommonStepDefinitions.tc_id;
	public String scenarioName=CommonStepDefinitions.scenarioName;
	public String dataFileName=CommonStepDefinitions.dataFileName;
	public String strReportFilename="";
	static GridReporter reporter = getReporter();
	static FunctionsLibrary functions=new FunctionsLibrary();
	
	public String getReportFileName()
	{
		return strReportFilename;
	}*/
	
	public void QtestIntegration() 
	{
		
		Actions builder = new Actions(FunctionsLibrary.driver);
		EncryptFileData encryptFile = new EncryptFileData();

		try
		{
		 
		WebDriverWait wait = new WebDriverWait(FunctionsLibrary.driver, 120);
		
		FunctionsLibrary.driver.get("https://heartland.qtestnet.com");
		//FunctionsLibrary.driver.manage().window().maximize();
		
		final String userName = config.getProperty("qTestUsername");
		
		if (!Boolean.valueOf(config.getProperty("isFileDataEncrypted"))) {
			try {

				encryptFile.encryptConfigFileData("qTestPassword");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			encryptFile.serializeKeys();
		} 

		config = new ExecutionerClass().setEnv();
		
		EncryptFileData.secretKey = encryptFile.deserializeKey();
		

		final String qTestPassword = encryptFile.decrypt(config.getProperty("qTestPassword"), EncryptFileData.secretKey);
		
		functions.waitForElementUsingPresence("Login_Username");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Login_Username)));
		functions.clearTextWithOutReport("Login_Username");
		functions.enterTextWithOutReport("Login_Username", userName);
		functions.waitForElementUsingPresence("Login_Password");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Login_Password)));
		functions.clearTextWithOutReport("Login_Password");
		functions.enterTextWithOutReport("Login_Password", qTestPassword);

		//FunctionsLibrary.driver.findElement(By.xpath("//span[@class='text-uppercase small']")).sendKeys(Keys.ENTER);
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='text-uppercase small']")));
		functions.clickAnElementWithOutReport("Login_button","Login Button");
		//FunctionsLibrary.driver.findElement(By.xpath("//span[@class='text-uppercase small']")).sendKeys(Keys.ENTER);
		
		String mainwindow = FunctionsLibrary.driver.getWindowHandle();
		
		// Clicking Test Plan Button
		functions.waitForElementUsingPresence("TestPlan_Button");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(testPlanButton)));
		functions.clickAnElementWithOutReport("TestPlan_Button","Test Plan Button");
		
		// Clicking Test Execution Button
		functions.waitForElementUsingPresence("TestExecution_Button");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(testExecution_Button)));
		functions.clickAnElementWithOutReport("TestExecution_Button","Test Execution Button");
		
		Thread.sleep(4000);
		//FunctionsLibrary.driver.navigate().refresh();
		
		if(!(FunctionsLibrary.driver.findElements(By.xpath("//*[@id='testrun_dataQueryPane']/div[1]/div/span[2]")).size()==0))
		{
			functions.waitForElementUsingPresence("waitFOrClause");
			if(FunctionsLibrary.driver.findElements(By.xpath("//td[@id='testrun_dataQueryGrid_cell_0_1']")).size()>0)
			{
				System.out.println("Empty Row Already Present");
			}
			else
			{
				// Click New Clause Button
				functions.waitForElementUsingPresence("Query_AddnewClause");
				//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(query_AddnewClause)));
				functions.clickAnElementWithOutReport("Query_AddnewClause","Add new clause");
			}
		}
		else
		{
			//Clicking Execute Query Icon
			functions.waitForElementUsingPresence("ExecuteQuery_Icon");
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(executeQuery_Icon)));
			functions.clickAnElementWithOutReport("ExecuteQuery_Icon","Execute Query");
		}
		
		List<Map<String,String>> summeryMapList=HTML2XML.getTcidAndStatus();
		
		//LinkedHashMap<String,String> tcid_Status=HTML2XML.getTcidAndStatus();
		
		//System.out.println("tc id and statuses are "+tcid_Status);
		
		for (Map<String, String> summeryMap : summeryMapList) 
		{
		
		String []TestCaseId=summeryMap.get("Test Case ID").split("_");
			
		//System.out.println("Detailed reports "+TestCaseId[1]);
		//System.out.println("Detailed reports "+HTML.storeDetailReport);
		
		// Click and Enter Criteria
		functions.waitForElementUsingPresence("Query_Criteria");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(query_Criteria)));
		functions.clickAnElementWithOutReport("Query_Criteria","Query Criteria");
		
		builder.clickAndHold(FunctionsLibrary.driver.findElement(By.id("testrun_dataQueryGrid_cell_0_1"))).sendKeys("Test Case Id").sendKeys(Keys.TAB).build().perform();
		//reporter.writeStepResult(tc_id, scenarioName, "Click and hold Query Criteria", "Entering Query Criteria", "Query Criteria entered ", "Pass", strReportFilename);
		
		// Enter Operator and Enter Value
		functions.waitForElementUsingPresence("Query_Value");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(query_Value)));//tc_id
		//builder.clickAndHold(FunctionsLibrary.driver.findElement(By.cssSelector(query_Value))).sendKeys(TestCaseId[1]).build().perform();
		builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE).sendKeys(Keys.SHIFT).pause(2000).sendKeys(TestCaseId[1]).build().perform();
		//reporter.writeStepResult(tc_id, scenarioName, "Enter the Query Value", "Entering the test case id", "Test case id is entered", "Pass", strReportFilename);
		//builder.clickAndHold(FunctionsLibrary.driver.findElement(By.id(query_Value))).sendKeys(TestcaseName[0]).build().perform();
		
		// Click New Clause Button
		functions.waitForElementUsingPresence("Query_AddnewClause");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(query_AddnewClause)));
		functions.clickAnElement("Query_AddnewClause","Add new clause");
		//reporter.writeStepResult(tc_id, scenarioName, "Click on add new clause", "Click on add new clause", "Clicks on add new clause", "Pass", strReportFilename);
		
		//Enter Group
		functions.waitForElementUsingPresence("Query_Group1");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(query_Group1)));
		FunctionsLibrary.driver.findElement(By.id("testrun_dataQueryGrid_cell_1_0")).click();
		builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).build().perform();
		//reporter.writeStepResult(tc_id, scenarioName, "Select the Query Operator", "Selecting the Query Operator", "Selects the Query Operator", "Pass", strReportFilename);
		
		// Click and Enter Criteria
		functions.waitForElementUsingPresence("Query_Criteria1");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(query_Criteria1)));
		functions.clickAnElementWithOutReport("Query_Criteria1","Query Criteria");
		
		builder.clickAndHold(FunctionsLibrary.driver.findElement(By.id("testrun_dataQueryGrid_cell_1_1"))).sendKeys("Test Suite").sendKeys(Keys.TAB).build().perform();
		//reporter.writeStepResult(tc_id, scenarioName, "Enter Query Criteria", "Entering Query Criteria", "Query Criteria is entered", "Pass", strReportFilename);
		
		//Enter Operator
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("testrun_dataQueryGrid_cell_1_2")));
		
		builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE).sendKeys(Keys.SHIFT).pause(2000).sendKeys(summeryMap.get("Release")).build().perform();
		
		//click Run Query button
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("testrun_dataQueryRunBtn_label")));
		functions.clickAnElementWithOutReport("Query_RunQuery","Run Query");
		Thread.sleep(2000);
		
/*		//verify Query Results
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(query_Message)));
		String Message = FunctionsLibrary.driver.findElement(By.className(query_Message)).getText();
		//verificationFunctions.verifyElementTextPresentAsExpected(webDriver, objPropertyValue, driverMethod, "1 test run(s) found", reporter, strReportFileName);
		String TotalTests = Message.substring(0, 1);
		int a = Integer.parseInt(TotalTests);
		
		for(int i=1; i<=a; i++)
		{*/
			
		//click Testcase ID button
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='testrun_dataQueryResultGrid']/div[3]/div[2]/div/table/tbody/tr/td[1]")));
		FunctionsLibrary.driver.findElement(By.xpath("(//a[@target='_self'])[1]")).click();
		//stepExecutor.clickButton(driverMethod, objPropertyValue, "Test Case ID Button", webDriver,reporter, strReportFileName);
		
		//click Run button
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='btn btn-default'])[1]")));
		functions.clickAnElementWithOutReport("Run_Button","Run Button");
		//reporter.writeStepResult(tc_id, scenarioName, "Click run button", "Clicking run button", "Clicks run button", "Pass", strReportFilename);

/*		WebElement RunButton = FunctionsLibrary.driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)FunctionsLibrary.driver;
		executor.executeScript("arguments[0].click();", RunButton);
*/		
		
		if(FunctionsLibrary.driver.findElement(By.id("baselineTestRunDialog_title")).getText().equalsIgnoreCase("Execute Approved Test Case"))
		{
			//click OK button
			//functions.waitForElementUsingPresence(locatorKey);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnBaselineOK_label")));
			functions.clickAnElement("Run_OkButton","Run Ok Button");
			//reporter.writeStepResult(tc_id, scenarioName, "Click run ok button", "Clicking run ok button", "Clicks run ok button", "Pass", strReportFilename);
		}
		
		Thread.sleep(3000);
		functions.switchBetweenWindows();
		//stepExecutor.switchToWindow(webDriver);
		
		functions.waitForPageLoad();
		//Enter Quick run Status
		//functions.waitForElementUsingPresence(locatorKey);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("testRunStatus_selectNode")));
		functions.clearTextWithOutReport("TestPad_Status");
		if(summeryMap.get("Status").equalsIgnoreCase("Pass"))
		{
			functions.enterTextWithOutReport("TestPad_Status", "Passed");
		}
		else if(summeryMap.get("Status").equalsIgnoreCase("Fail"))
		{
			functions.enterTextWithOutReport("TestPad_Status", "Failed");
		}
		//reporter.writeStepResult(tc_id, scenarioName, "Enter the text", "Enter the pass or fail status", "Clicks run ok button", "Pass", strReportFilename);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("testRunStatus_selectNode")));
		//FunctionsLibrary.driver.findElement(By.cssSelector("testRunStatus_selectNode")).sendKeys(Keys.ENTER);
		
		//click Apply changes button
		builder.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnMarkAllTestStepStatus_label")));
		//functions.clickAnElement("TestPad_ApplyChangesButton","Apply Changes");
		//reporter.writeStepResult(tc_id, scenarioName, "Click run ok button", "Clicking run ok button", "Clicks run ok button", "Pass", strReportFilename);
		
		//click Resources button
				
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Resources')]")));
		functions.clickAnElementWithOutReport("TestPad_Resourcesbutton","Resources button");
		
		//click Test Case Attachment Link
		//functions.waitForElementUsingPresence(locatorKey);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("testExecutionAttachment_attachmentLink")));
		functions.clickAnElement("TestPad_TestCaseAttachment","Testcase Attachment");

		for (String value : HTML.storeDetailReport) 
		{
			  /* if(value.contains(summeryMap.get("Test Case ID")))
		        {
		        
		        }*/
			System.out.println(" "+value);
	        if(value.contains(summeryMap.get("Test Case ID")))
	        {
	        	String gsTempFile=(String) HTML.properties.get("TempResultPath");
	        	String detailedReport=value;
	        	String resultsPath=FilenameUtils.concat(gsTempFile,detailedReport);
	        	System.out.println(resultsPath);
	        	String path=resultsPath.replace("\\", "/");
	        	String updatedPath=path.replace("results/results", "results");
	        	String SummaryFileName=updatedPath.replace("/", "\\");
	        	System.out.println("  "+SummaryFileName);
	    		
				Robot r = new Robot();
				StringSelection selection = new StringSelection(SummaryFileName);
			    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(selection, selection); 
				System.out.println(clipboard);
				Thread.sleep(1000);
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_C);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_C);
				Thread.sleep(1000);
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_V);
	    		Thread.sleep(1000);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
	    		Thread.sleep(1000);
	    		//click Save Button
	    		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("testExecutionToolbarSave_label")));
	    		functions.clickAnElementWithOutReport("TestPad_SaveButton","Save Button");
	    		Thread.sleep(1000);

	    		if(!(FunctionsLibrary.driver.findElements(By.id("confirmExecutionDialogActionSkip_label")).size()==0))
	    		{
	    			FunctionsLibrary.driver.findElement(By.id("confirmExecutionDialogActionSkip_label")).click();
	    		}
	    		FunctionsLibrary.driver.close();
	    		FunctionsLibrary.driver.switchTo().window(mainwindow);
	        }
		}
		
		
		
		functions.clickAnElementWithOutReport("ExecuteQuery_Icon","Execute Query");
		functions.clickAnElementWithOutReport("Query_ClearButton","Clear Query");
		
		}
		
		//}
		
		builder.moveToElement(FunctionsLibrary.driver.findElement(By.id("avatarHeader"))).click(FunctionsLibrary.driver.findElement(By.id("log-out-link"))).build().perform();
		//FunctionsLibrary.driver.quit();
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
	}
	
}
