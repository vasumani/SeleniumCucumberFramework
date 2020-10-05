package com.webapp.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetFieldIdAndValues {
	private static List<String> fieldId = new ArrayList<String>();
	private static List<String> fieldValue = new ArrayList<String>();

	private static String field_id;
	private static String field_value;

	public void setField_id(String field_id) {
		this.field_id = field_id;
		fieldId.add(this.field_id);
	}

	public void setField_value(String field_value) {
		this.field_value = field_value;
		fieldValue.add(this.field_value);

		if (fieldId.size() != fieldValue.size()) {
			fieldValue.add(fieldValue.size() - 1, "nul");
		}
	}

	public static List<String> getField_value() {
		// return field_value;
		return fieldValue;
	}

	public static List<String> getField_id() {
		return fieldId;
	}
}