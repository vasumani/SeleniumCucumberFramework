package com.webapp.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.webapp.executioner.ExecutionerClass;

public class QTestIntegration
{
	public static Properties pidstoid = null;
	public static void qTestIntegration(List<Map<String, String>> listOfTestCaseData) throws Exception
	{
		for (Map<String, String> summeryMap : listOfTestCaseData)
		{
			String tc_id = summeryMap.get("Test Case ID");
			if (HTML.detailReport.contains(tc_id))
			{
				LoadTCIDsPropertyFile();
				if(tc_id.contains("TC-")) {
					tc_id = pidstoid.getProperty(tc_id);
					summeryMap.put("Test Case ID", tc_id);
				} else {
					summeryMap.put("Test Case ID", tc_id.split("_")[1]);
				}
				API api2 = new API();
				try {
					String tcResponse = api2.get(QtestTCList.loadConfigFile().getProperty("qTest_TestCaseURL")+"/"+summeryMap.get("Test Case ID"));
					 JSONObject jo = (JSONObject) new JSONParser().parse(tcResponse);
					 String name = (String) jo.get("name");
					 summeryMap.put("Scenario", name);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}

				Properties config = new ExecutionerClass().setEnv();
				String encodedstring = null;

				if(config.getProperty("AttachDetailedReport").equalsIgnoreCase("Yes"))
				{
					encodedstring = ReportEncoder.encodeFileToBase64Binary(HTML.detailReport);
				}
				else if(config.getProperty("AttachDetailedReport").equalsIgnoreCase("No"))
				{
					//encodedstring null and no attachment is attached
				}
				else if(config.getProperty("AttachDetailedReport").equalsIgnoreCase("Fail")&&summeryMap.get("Status").equalsIgnoreCase("Fail"))
				{
					encodedstring = ReportEncoder.encodeFileToBase64Binary(HTML.detailReport);
				}

				String automationContentValue;
				if(config.getProperty("GetAutomationContent").equalsIgnoreCase("Yes"))
				{
					automationContentValue = getAutomationContentValue(summeryMap.get("Test Case ID"));
					if (automationContentValue.equalsIgnoreCase("null"))
					{
						automationContentValue = summeryMap.get("Test Case ID");
					}
				}
				else
				{
					automationContentValue = summeryMap.get("Test Case ID");
				}

				String result;
				result = updateJson(summeryMap,encodedstring, automationContentValue);
				API api = new API();

				try {
					// POST method to update the pass or fail status in qTest
					String qTestStatus = api.postData(result, config.getProperty("qTestURL"));

					ObjectMapper mapper = new ObjectMapper();
					Map<String, String> qTestResponse = mapper.readValue(qTestStatus,new TypeReference<HashMap<String, String>>() {});

					// Verifying if qTest is updated successfully or not
					String verfySuccessMsg = api.get(config.getProperty("qTest_VerifySuccessMsg") + qTestResponse.get("id"));
					Map<String, String> qTestVerifySuccessResponse = mapper.readValue(verfySuccessMsg,new TypeReference<HashMap<String, String>>() {});
					System.out.println("Response message is: " + qTestVerifySuccessResponse.get("state"));

					if (qTestVerifySuccessResponse.get("state").equalsIgnoreCase("SUCCESS"))
					{
						HTML.fnInsertResult(summeryMap.get("Test Case ID"), summeryMap.get("Scenario"),"qTest is updated Successfully", "", "", "", "");
					}
					else if (qTestVerifySuccessResponse.get("state").equalsIgnoreCase("IN_WAITING"))
					{
						HTML.fnInsertResult(summeryMap.get("Test Case ID"), summeryMap.get("Scenario"),"qTest updated is IN_WAITING", "", "", "", "");
					}
					else if (qTestVerifySuccessResponse.get("state").equalsIgnoreCase("IN_PROGRESS"))
					{
						HTML.fnInsertResult(summeryMap.get("Test Case ID"), summeryMap.get("Scenario"),"qTest update is IN_PROGRESS", "", "", "", "");
					}
					else
					{
						HTML.fnInsertResult(summeryMap.get("Test Case ID"), summeryMap.get("Scenario"),"qTest is not updated", "", "", "", "");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static String updateJson(Map<String, String> summeryMap,String encodedstring,String automationContentValue) throws Exception
	{
		Properties config = new ExecutionerClass().setEnv();
		ObjectMapper mapper = new ObjectMapper();
		String strAbsolutePath = new File("").getAbsolutePath();
		JsonNode root = mapper.readTree(new File("" + strAbsolutePath + "\\qTest\\POSTRequest.json"));

		String resultOriginal = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
		System.out.println("Before Update " + resultOriginal);

		((ObjectNode) root).put("test_cycle", summeryMap.get("Test Cycle"));

		ArrayNode testLogs = mapper.createArrayNode();

		// Object Node
		ObjectNode test_logs1 = mapper.createObjectNode();
		test_logs1.put("status", summeryMap.get("Status").toUpperCase() + "ED");
		test_logs1.put("exe_start_date", summeryMap.get("Execution Start Time"));
		test_logs1.put("exe_end_date", summeryMap.get("Execution Stop Time"));
		ArrayNode moduleName1 = mapper.createArrayNode();

		if(summeryMap.get("Module").contains("->"))
		{
			String[] arrayModule=summeryMap.get("Module").split("->");
			for (int i = 0; i < arrayModule.length; i++)
				moduleName1.add(arrayModule[i]);
		}
		else
		{
			moduleName1.add(summeryMap.get("Module"));
		}
		test_logs1.put("module_names", moduleName1);

		test_logs1.put("name", summeryMap.get("Scenario")); // module_names
		test_logs1.put("automation_content", automationContentValue);

		if(config.getProperty("AttachDetailedReport").equalsIgnoreCase("Yes"))
		{
			// Array Node for Attachment
			ArrayNode attachmentNode = mapper.createArrayNode();
			ObjectNode attachmentLog = mapper.createObjectNode();
			attachmentLog.put("name", summeryMap.get("Scenario") + ".htm");
			attachmentLog.put("content_type", "application/htm");
			attachmentLog.put("data", encodedstring);

			ObjectNode authorObject = mapper.createObjectNode();
			attachmentLog.put("author", authorObject);
			attachmentNode.add(attachmentLog);
			test_logs1.put("attachments", attachmentNode);
		}
		else if(config.getProperty("AttachDetailedReport").equalsIgnoreCase("No"))
		{
			//encoded string null and no attachment is attached
		}
		else if(config.getProperty("AttachDetailedReport").equalsIgnoreCase("Fail")&&summeryMap.get("Status").equalsIgnoreCase("Fail"))
		{
			// Array Node for Attachment
			ArrayNode attachmentNode = mapper.createArrayNode();
			ObjectNode attachmentLog = mapper.createObjectNode();
			attachmentLog.put("name", summeryMap.get("Scenario") + ".htm");
			attachmentLog.put("content_type", "application/htm");
			attachmentLog.put("data", encodedstring);

			ObjectNode authorObject = mapper.createObjectNode();
			attachmentLog.put("author", authorObject);
			attachmentNode.add(attachmentLog);
			test_logs1.put("attachments", attachmentNode);
		}

/*		ArrayNode testStepLog1 = mapper.createArrayNode();
		test_logs1.put("test_step_logs", testStepLog1);*/

		testLogs.add(test_logs1);

		((ObjectNode) root).set("test_logs", testLogs);

		String resultUpdate = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
		System.out.println("After Update " + resultUpdate);
		mapper.writeValue(new File("" + strAbsolutePath + "\\qTest\\POSTRequest.json"), root);

		return resultUpdate;
	}

	public static String getAutomationContentValue(String tcId) throws Exception {

		String automationContentValue = null;
		String automationKey = null;
		Map<String, String> automationFields = GetAutomationField.getAutomationField();
		for (String key : automationFields.keySet())
		{
			if (automationFields.get(key).equalsIgnoreCase("Automation Content"))
			{
				automationKey = key;
			}
		}

		Map<String, Map<String, String>> testCaseFields = GetAutomationField.getTestCaseFields(automationKey);
		for (String map : testCaseFields.get(tcId).keySet())
		{
			automationContentValue = testCaseFields.get(tcId).get(map);
		}

		return automationContentValue;
	}

	public static void LoadTCIDsPropertyFile() throws IOException
	{
		try {
			pidstoid = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "//config//TestCasesList.properties");
			pidstoid.load(ip);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
