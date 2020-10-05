package com.webapp.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAutomationContentId {
	private static String id;
	private static List<String> tcId = new ArrayList<String>();

	private static String label;
	private static List<String> tcLabel = new ArrayList<String>();
	public static String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public static List<String> getTcId() {
		return tcId;
	}
	public static void setTcId(List<String> tcId) {
		GetAutomationContentId.tcId = tcId;
	}
	public static String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public static List<String> getTcLabel() {
		return tcLabel;
	}
	public static void setTcLabel(List<String> tcLabel) {
		GetAutomationContentId.tcLabel = tcLabel;
	}

	
}
