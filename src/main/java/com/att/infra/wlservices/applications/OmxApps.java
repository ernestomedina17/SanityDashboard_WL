package com.att.infra.wlservices.applications;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class OmxApps extends Service {

	private static final String COMPONENT = "omx";

	@RequestMapping("/" + COMPONENT + "_" + SERVICE)
	public String sanity(@RequestParam(value = "env", defaultValue = "err") String env, 
			RestTemplate restTemplate, Model model) {
		selectOMXEnvironment(restTemplate, env, COMPONENT, SERVICE);
		setModel(model, COMPONENT);
		return "omxApps";
	}

}