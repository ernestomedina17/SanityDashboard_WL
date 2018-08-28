package com.att.infra.wlservices.applications;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class TnplatformApps extends Service {

	private static final String COMPONENT = "tnplatform";

	@RequestMapping("/" + COMPONENT + "_" + SERVICE)
	public String sanity(@RequestParam(value = "env", defaultValue = "err") String env, 
			RestTemplate restTemplate, Model model) {
		selectTnplatformEnvironment(restTemplate, env, COMPONENT, SERVICE);
		setModel(model, COMPONENT);
		return "tnplatformApps";
	}

}