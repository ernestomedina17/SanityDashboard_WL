package com.att.infra.json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DSListDS {

	private String name;
	private List<DS> instances;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DS> getInstances() {
		return instances;
	}
	public void setInstances(List<DS> instances) {
		this.instances = instances;
	}
	
	
}
