package com.att.infra.wlservices.servers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import com.att.infra.ServiceAbstract;
import com.att.infra.json.Server;
import com.att.infra.json.ServersBody;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Service extends ServiceAbstract{
	
	public static final String SERVICE = "servers";
	
	public static String getService() {
		return SERVICE;
	}
	
	public void setModel(Model model, String COMPONENT) {
		try {
			ServersBody serverBody = new ObjectMapper().readValue(msg,ServersBody.class);
			model.addAttribute(COMPONENT + "ServerItems", serverBody.getBody().getItems());				
		} catch (Exception e) {
			System.out.println(e);
			List<Server> listServers = new ArrayList<Server>();
			Server server = new Server();
			server.setName("ERROR");
			server.setHealth("UNKNOWN");
			server.setState("UNKNOWN");
			listServers.add(server);
			
			model.addAttribute(COMPONENT + "ServerItems", listServers);	
		}
	}
}
