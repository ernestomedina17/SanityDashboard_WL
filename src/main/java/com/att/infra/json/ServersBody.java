package com.att.infra.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServersBody {

	private ServersList body;

	public ServersList getBody() {
		return body;
	}

	public void setBody(ServersList body) {
		this.body = body;
	}


	
	
}
