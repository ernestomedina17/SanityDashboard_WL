package com.att.infra.json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DSListItems {
	
	private List<DSListDS> items;

	//@JsonProperty("items")
	public List<DSListDS> getItems() {
		return items;
	}

	public void setItems(List<DSListDS> items) {
		this.items = items;
	}

	

	
	

}
