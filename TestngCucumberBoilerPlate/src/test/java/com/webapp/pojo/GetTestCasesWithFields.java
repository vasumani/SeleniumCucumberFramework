package com.webapp.pojo;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTestCasesWithFields {
	private String id;
	static List<String> listId = new ArrayList<String>();

	private String name;
	static List<String> listName = new ArrayList<String>();

	private GetFieldIdAndValues[] properties;

	public static List<String> getId() {
		return listId;
	}

	public void setId(String id) {
		this.id = id;
		listId.add(this.id);
	}

	public static List<String> getName() {
		return listName;
	}

	public void setName(String name) {
		this.name = name;
		listName.add(this.name);
	}
	
    public GetFieldIdAndValues[] getProperties ()
    {
        return properties;
    }

    public void setProperties (GetFieldIdAndValues[] properties)
    {
        this.properties = properties;
    }
}
