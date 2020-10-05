package com.webapp.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.webapp.executioner.ExecutionerClass;
import com.webapp.pojo.GetAutomationContentId;
import com.webapp.pojo.GetFieldIdAndValues;
import com.webapp.pojo.GetTestCasesWithFields;

public class GetAutomationField 
{
	public static Map<String, String> getAutomationField() throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		Map<String,String> automationField=new HashMap<String,String>();
        try { 
			TypeFactory typeFactory = mapper.getTypeFactory();
	        CollectionType collectionType = typeFactory.constructCollectionType(List.class, GetAutomationContentId.class);
	        API api=new API();
	        Properties config = new ExecutionerClass().setEnv();
	        String data=api.get(config.getProperty("qTest_TestCaseFieldsURL"));
	        List<String> val= mapper.readValue(data, collectionType);

	        List<String> automationContentId=new ArrayList<String>();
	        automationContentId.add(GetAutomationContentId.getId());
	        List<String> automationContentLabel=new ArrayList<String>();
	        automationContentLabel.add(GetAutomationContentId.getLabel());
	        
	        for (int i = 0; i < automationContentLabel.size(); i++) 
	        {
	        	automationField.put(automationContentId.get(i), automationContentLabel.get(i));
			}
	        System.out.println(automationField);
	        
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return automationField;
	}
	
	public static Map<String, Map<String, String>> getTestCaseFields(String automationKey) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		 Map<String,Map<String,String>> testCaseFields=new HashMap<String,Map<String,String>>();
        try { 
			TypeFactory typeFactory = mapper.getTypeFactory();
	        CollectionType collectionType1 = typeFactory.constructCollectionType(List.class, GetTestCasesWithFields.class);
	        API api=new API();
	        Properties config = new ExecutionerClass().setEnv();
	        String data=api.get(config.getProperty("qTest_TestCaseURL"));
	        List<String> val1= mapper.readValue(data, collectionType1);

	        List<String> feildId=new ArrayList<String>();
	        feildId.addAll(GetFieldIdAndValues.getField_id());
	        List<String> fieldValue=new ArrayList<String>();
	        fieldValue.addAll(GetFieldIdAndValues.getField_value());
	        List<String> testCaseId=new ArrayList<String>();
	        testCaseId.addAll(GetTestCasesWithFields.getId());
	        
	        List<Map<String,String>> listOfMap=new ArrayList<Map<String,String>>();
	        for (int i = 0; i < feildId.size(); i++) 
	        {
	        	Map<String,String> str=new LinkedHashMap<String,String>();
	        	if(feildId.get(i).equalsIgnoreCase(automationKey))
	        	{
	        		str.put(feildId.get(i),fieldValue.get(i));
	        		listOfMap.add(str);
	        	}
			}
	        for (int i = 0; i < testCaseId.size(); i++) 
	        {
	        	testCaseFields.put(testCaseId.get(i),listOfMap.get(i));
			}
	      System.out.println(testCaseFields);
	      
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testCaseFields;
	
	}

}
