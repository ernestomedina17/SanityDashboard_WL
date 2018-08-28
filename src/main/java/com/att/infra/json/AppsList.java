package com.att.infra.json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppsList {
	
	private List<Apps> items;

	public List<Apps> getItems() {
		return items;
	}

	public void setItems(List<Apps> items) {
		this.items = items;
	}

	

	
	

}
