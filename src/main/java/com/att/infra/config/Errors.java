package com.att.infra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("errors")
public class Errors {

	String e001;
	String e002;
	
	public String getE001() {
		return e001;
	}
	public void setE001(String e001) {
		this.e001 = e001;
	}
	public String getE002() {
		return e002;
	}
	public void setE002(String e002) {
		this.e002 = e002;
	}
	

	
}