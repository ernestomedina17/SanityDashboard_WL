package com.att.infra;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Controller
public class ListMappings {

	private final RequestMappingHandlerMapping handlerMapping;
	
	@Autowired
	public ListMappings(RequestMappingHandlerMapping handlerMapping) {
		this.handlerMapping = handlerMapping;
	}
	
    @RequestMapping("/listMappings")
    public String listMappings(Model model) {
    	model.addAttribute("defaultEnv", "?env=dev2");
    	
    	Map<RequestMappingInfo, HandlerMethod> map = this.handlerMapping.getHandlerMethods();
    	
    	List<String> href = new ArrayList<String>();
    	
    	for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : map.entrySet()) {
    		String temp;
    		temp = entry.getKey().toString().replaceAll("\\{|\\[|\\]|\\}|\\/", "");
    		href.add(temp);  
    	}
    	
    	model.addAttribute("defaultEnv", "?env=dev2");
    	model.addAttribute("hrefs", href);
    	System.out.println("#######################333");
        return "listMappings";
    }
    
    
}