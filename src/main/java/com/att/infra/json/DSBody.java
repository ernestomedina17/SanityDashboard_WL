package com.att.infra.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DSBody {

	private DSListItems body;

	public DSListItems getBody() {
		return body;
	}

	public void setBody(DSListItems body) {
		this.body = body;
	}


	
	
}
