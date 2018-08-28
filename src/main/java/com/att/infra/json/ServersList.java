package com.att.infra.json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServersList {
	
	private List<Server> items;

	//@JsonProperty("items")
	public List<Server> getItems() {
		return items;
	}

	public void setItems(List<Server> items) {
		this.items = items;
	}

	

	
	

}
