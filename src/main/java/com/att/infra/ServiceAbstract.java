package com.att.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.att.infra.config.*;

public abstract class ServiceAbstract {
	
	public String msg;
	public String SERVICE;
	public String COMPONENT;
	@Autowired public User user;
	@Autowired public Errors errors;
	@Autowired public CamoConfig camo;
	@Autowired public DNConfig dn;
	@Autowired public OcximConfig ocxim;
	@Autowired public OmxConfig omx;
	@Autowired public ReportingConfig reporting;
	@Autowired public TnmgtConfig tnmgt;
	@Autowired public TnplatformConfig tnplatform;
	@Autowired public WorkermgtConfig workermgt;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public String doSanity(RestTemplate restTemplate, String url, String COMPONENT, String SERVICE) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", "Basic " + user.getUserpassEncoded());
		HttpEntity<String> request = new HttpEntity<String>(httpHeaders);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url + SERVICE, HttpMethod.GET, request,	String.class);
			if (response.hasBody()) {
				msg = response.getBody();
			} else {
				msg = "Warn: " + COMPONENT + " " + SERVICE + " Html Body is empty";
			}
			
		} catch (RestClientException e) {
			msg = "Error: " + COMPONENT + " " + SERVICE + " status cannot be retrieved";
		}
		
		return msg;
	}
	
	public String selectCamoEnvironment(RestTemplate restTemplate, String env, String COMPONENT, String SERVICE ) {
		switch (env) {
		case "dev2":
			doSanity(restTemplate, camo.getDev2(), COMPONENT, SERVICE);
			break;
		case "dev3":
			doSanity(restTemplate, camo.getDev3(), COMPONENT, SERVICE);
			break;
		case "dev6":
			doSanity(restTemplate, camo.getDev6(), COMPONENT, SERVICE);
			break;
		case "it3":
			doSanity(restTemplate, camo.getIt3(), COMPONENT, SERVICE);
			break;
		case "it5":
			doSanity(restTemplate, camo.getIt5(), COMPONENT, SERVICE);
			break;
		case "sit1":
			doSanity(restTemplate, camo.getSit1(), COMPONENT, SERVICE);
			break;
		case "st2":
			doSanity(restTemplate, camo.getSt2(), COMPONENT, SERVICE);
			break;
		case "st3":
			doSanity(restTemplate, camo.getSt3(), COMPONENT, SERVICE);
			break;
		case "st4":
			doSanity(restTemplate, camo.getSt4(), COMPONENT, SERVICE);
			break;
		case "st5":
			doSanity(restTemplate, camo.getSt5(), COMPONENT, SERVICE);
			break;
		case "err":
			msg = errors.getE001();
			break;
		default:
			msg = errors.getE002();
			break;
		}
		
		return msg;
	}
	
	public String selectDNEnvironment(RestTemplate restTemplate, String env, String COMPONENT, String SERVICE) {
		switch (env) {
		case "dev2":
			doSanity(restTemplate, dn.getDev2(), COMPONENT, SERVICE);
			break;
		case "dev3":
			doSanity(restTemplate, dn.getDev3(), COMPONENT, SERVICE);
			break;
		case "dev6":
			doSanity(restTemplate, dn.getDev6(), COMPONENT, SERVICE);
			break;
		case "it3":
			doSanity(restTemplate, dn.getIt3(), COMPONENT, SERVICE);
			break;
		case "it5":
			doSanity(restTemplate, dn.getIt5(), COMPONENT, SERVICE);
			break;
		case "sit1":
			doSanity(restTemplate, dn.getSit1(), COMPONENT, SERVICE);
			break;
		case "st2":
			doSanity(restTemplate, dn.getSt2(), COMPONENT, SERVICE);
			break;
		case "st3":
			doSanity(restTemplate, dn.getSt3(), COMPONENT, SERVICE);
			break;
		case "st4":
			doSanity(restTemplate, dn.getSt4(), COMPONENT, SERVICE);
			break;
		case "st5":
			doSanity(restTemplate, dn.getSt5(), COMPONENT, SERVICE);
			break;
		case "err":
			msg = errors.getE001();
			break;
		default:
			msg = errors.getE002();
			break;
		}

		return msg;
		
	}
	
	public String  selectOcximEnvironment(RestTemplate restTemplate, String env, String COMPONENT, String SERVICE) {
		switch (env) {
		case "dev2":
			doSanity(restTemplate, ocxim.getDev2(), COMPONENT, SERVICE);
			break;
		case "dev3":
			doSanity(restTemplate, ocxim.getDev3(), COMPONENT, SERVICE);
			break;
		case "dev6":
			doSanity(restTemplate, ocxim.getDev6(), COMPONENT, SERVICE);
			break;
		case "it3":
			doSanity(restTemplate, ocxim.getIt3(), COMPONENT, SERVICE);
			break;
		case "it5":
			doSanity(restTemplate, ocxim.getIt5(), COMPONENT, SERVICE);
			break;
		case "sit1":
			doSanity(restTemplate, ocxim.getSit1(), COMPONENT, SERVICE);
			break;
		case "st2":
			doSanity(restTemplate, ocxim.getSt2(), COMPONENT, SERVICE);
			break;
		case "st3":
			doSanity(restTemplate, ocxim.getSt3(), COMPONENT, SERVICE);
			break;
		case "st4":
			doSanity(restTemplate, ocxim.getSt4(), COMPONENT, SERVICE);
			break;
		case "st5":
			doSanity(restTemplate, ocxim.getSt5(), COMPONENT, SERVICE);
			break;
		case "err":
			msg = errors.getE001();
			break;
		default:
			msg = errors.getE002();
			break;
		}

		return msg;
	}

	public String selectOMXEnvironment(RestTemplate restTemplate, String env, String COMPONENT, String SERVICE) {
		switch (env) {
		case "dev2":
			doSanity(restTemplate, omx.getDev2(), COMPONENT, SERVICE);
			break;
		case "dev3":
			doSanity(restTemplate, omx.getDev3(), COMPONENT, SERVICE);
			break;
		case "dev6":
			doSanity(restTemplate, omx.getDev6(), COMPONENT, SERVICE);
			break;
		case "it3":
			doSanity(restTemplate, omx.getIt3(), COMPONENT, SERVICE);
			break;
		case "it5":
			doSanity(restTemplate, omx.getIt5(), COMPONENT, SERVICE);
			break;
		case "sit1":
			doSanity(restTemplate, omx.getSit1(), COMPONENT, SERVICE);
			break;
		case "st2":
			doSanity(restTemplate, omx.getSt2(), COMPONENT, SERVICE);
			break;
		case "st3":
			doSanity(restTemplate, omx.getSt3(), COMPONENT, SERVICE);
			break;
		case "st4":
			doSanity(restTemplate, omx.getSt4(), COMPONENT, SERVICE);
			break;
		case "st5":
			doSanity(restTemplate, omx.getSt5(), COMPONENT, SERVICE);
			break;
		case "err":
			msg = errors.getE001();
			break;
		default:
			msg = errors.getE002();
			break;
		}

		return msg;
		
	}

	public String selectReportingEnvironment(RestTemplate restTemplate, String env, String COMPONENT, String SERVICE) {
		switch (env) {
		case "dev2":
			doSanity(restTemplate, reporting.getDev2(), COMPONENT, SERVICE);
			break;
		case "dev3":
			doSanity(restTemplate, reporting.getDev3(), COMPONENT, SERVICE);
			break;
		case "dev6":
			doSanity(restTemplate, reporting.getDev6(), COMPONENT, SERVICE);
			break;
		case "it3":
			doSanity(restTemplate, reporting.getIt3(), COMPONENT, SERVICE);
			break;
		case "it5":
			doSanity(restTemplate, reporting.getIt5(), COMPONENT, SERVICE);
			break;
		case "sit1":
			doSanity(restTemplate, reporting.getSit1(), COMPONENT, SERVICE);
			break;
		case "st2":
			doSanity(restTemplate, reporting.getSt2(), COMPONENT, SERVICE);
			break;
		case "st3":
			doSanity(restTemplate, reporting.getSt3(), COMPONENT, SERVICE);
			break;
		case "st4":
			doSanity(restTemplate, reporting.getSt4(), COMPONENT, SERVICE);
			break;
		case "st5":
			doSanity(restTemplate, reporting.getSt5(), COMPONENT, SERVICE);
			break;
		case "err":
			msg = errors.getE001();
			break;
		default:
			msg = errors.getE002();
			break;
		}

		return msg;
		
	}

	public String selectTnmgtEnvironment(RestTemplate restTemplate, String env, String COMPONENT, String SERVICE) {
		switch (env) {
		case "dev2":
			doSanity(restTemplate, tnmgt.getDev2(), COMPONENT, SERVICE);
			break;
		case "dev3":
			doSanity(restTemplate, tnmgt.getDev3(), COMPONENT, SERVICE);
			break;
		case "dev6":
			doSanity(restTemplate, tnmgt.getDev6(), COMPONENT, SERVICE);
			break;
		case "it3":
			doSanity(restTemplate, tnmgt.getIt3(), COMPONENT, SERVICE);
			break;
		case "it5":
			doSanity(restTemplate, tnmgt.getIt5(), COMPONENT, SERVICE);
			break;
		case "sit1":
			doSanity(restTemplate, tnmgt.getSit1(), COMPONENT, SERVICE);
			break;
		case "st2":
			doSanity(restTemplate, tnmgt.getSt2(), COMPONENT, SERVICE);
			break;
		case "st3":
			doSanity(restTemplate, tnmgt.getSt3(), COMPONENT, SERVICE);
			break;
		case "st4":
			doSanity(restTemplate, tnmgt.getSt4(), COMPONENT, SERVICE);
			break;
		case "st5":
			doSanity(restTemplate, tnmgt.getSt5(), COMPONENT, SERVICE);
			break;
		case "err":
			msg = errors.getE001();
			break;
		default:
			msg = errors.getE002();
			break;
		}

		return msg;
	}

	public String selectTnplatformEnvironment(RestTemplate restTemplate, String env, String COMPONENT, String SERVICE) {
		switch (env) {
		case "dev2":
			doSanity(restTemplate, tnplatform.getDev2(), COMPONENT, SERVICE);
			break;
		case "dev3":
			doSanity(restTemplate, tnplatform.getDev3(), COMPONENT, SERVICE);
			break;
		case "dev6":
			doSanity(restTemplate, tnplatform.getDev6(), COMPONENT, SERVICE);
			break;
		case "it3":
			doSanity(restTemplate, tnplatform.getIt3(), COMPONENT, SERVICE);
			break;
		case "it5":
			doSanity(restTemplate, tnplatform.getIt5(), COMPONENT, SERVICE);
			break;
		case "sit1":
			doSanity(restTemplate, tnplatform.getSit1(), COMPONENT, SERVICE);
			break;
		case "st2":
			doSanity(restTemplate, tnplatform.getSt2(), COMPONENT, SERVICE);
			break;
		case "st3":
			doSanity(restTemplate, tnplatform.getSt3(), COMPONENT, SERVICE);
			break;
		case "st4":
			doSanity(restTemplate, tnplatform.getSt4(), COMPONENT, SERVICE);
			break;
		case "st5":
			doSanity(restTemplate, tnplatform.getSt5(), COMPONENT, SERVICE);
			break;
		case "err":
			msg = errors.getE001();
			break;
		default:
			msg = errors.getE002();
			break;
		}

		return msg;
	}

	public String selectWorkermgtEnvironment(RestTemplate restTemplate, String env, String COMPONENT, String SERVICE) {
		switch (env) {
		case "dev2":
			doSanity(restTemplate, workermgt.getDev2(), COMPONENT, SERVICE);
			break;
		case "dev3":
			doSanity(restTemplate, workermgt.getDev3(), COMPONENT, SERVICE);
			break;
		case "dev6":
			doSanity(restTemplate, workermgt.getDev6(), COMPONENT, SERVICE);
			break;
		case "it3":
			doSanity(restTemplate, workermgt.getIt3(), COMPONENT, SERVICE);
			break;
		case "it5":
			doSanity(restTemplate, workermgt.getIt5(), COMPONENT, SERVICE);
			break;
		case "sit1":
			doSanity(restTemplate, workermgt.getSit1(), COMPONENT, SERVICE);
			break;
		case "st2":
			doSanity(restTemplate, workermgt.getSt2(), COMPONENT, SERVICE);
			break;
		case "st3":
			doSanity(restTemplate, workermgt.getSt3(), COMPONENT, SERVICE);
			break;
		case "st4":
			doSanity(restTemplate, workermgt.getSt4(), COMPONENT, SERVICE);
			break;
		case "st5":
			doSanity(restTemplate, workermgt.getSt5(), COMPONENT, SERVICE);
			break;
		case "err":
			msg = errors.getE001();
			break;
		default:
			msg = errors.getE002();
			break;
		}
		
		return msg;
		
	}
}

	
