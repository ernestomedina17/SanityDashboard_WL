package com.att.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

import com.att.infra.config.*;

@EnableConfigurationProperties({
	CamoConfig.class, 
	DNConfig.class, 
	Errors.class, 
	OcximConfig.class,
	OmxConfig.class,
	ReportingConfig.class, 
	TnmgtConfig.class, 
	TnplatformConfig.class, 
	User.class, 
	WorkermgtConfig.class,})
@SpringBootApplication
public class DashBoardApplication extends SpringBootServletInitializer implements WebApplicationInitializer{
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DashBoardApplication.class);
    }
    
	public static void main(String args[]) {
		SpringApplication.run(DashBoardApplication.class);
	}	
}