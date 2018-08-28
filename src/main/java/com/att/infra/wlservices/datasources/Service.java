package com.att.infra.wlservices.datasources;

import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import com.att.infra.ServiceAbstract;
import com.att.infra.json.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Service extends ServiceAbstract {
	
	public static final String SERVICE = "datasources";
	
	public static String getService() {
		return SERVICE;
	}
	
	public void setModel(Model model, String COMPONENT) {
		try {
			DSBody dsBody = new ObjectMapper().readValue(msg,DSBody.class);
			List<DataSource> dsList = new ArrayList<DataSource>();
			DataSource ds = new DataSource();
			
			int tmp = dsBody.getBody().getItems().size(); 
			
				for (int i = 0; i < tmp ; i++) {
					ds.setName(dsBody.getBody().getItems().get(i).getName());
					if (dsBody.getBody().getItems().get(i).getInstances().size() == 0) {
						ds.setState("No instance");
					} else {
						ds.setState(dsBody.getBody().getItems().get(i).getInstances().get(0).getState());
					}
					
					dsList.add(i, ds);
				}
						
			model.addAttribute(COMPONENT + "DSItems", dsList);
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error setting WorkerMgt DS");
			List<DataSource> dsList = new ArrayList<DataSource>();
			DataSource ds = new DataSource();
			ds.setName("ERROR");
			ds.setState("UNKNOWN");
			dsList.add(0,ds);
			model.addAttribute(COMPONENT + "DSItems", dsList);
		}
	}
}
