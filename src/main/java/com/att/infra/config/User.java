package com.att.infra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "user")
public class User {

	String userpassEncoded;
	
	public void setUserpassEncoded(String userpassEncoded) {
		this.userpassEncoded = userpassEncoded;
	}

	public String getUserpassEncoded() {
		return userpassEncoded;
	}
	
}
