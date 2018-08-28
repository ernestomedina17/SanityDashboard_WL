package com.att.infra.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppsBody {

	private AppsList body;

	public AppsList getBody() {
		return body;
	}

	public void setBody(AppsList body) {
		this.body = body;
	}


	
	
}
