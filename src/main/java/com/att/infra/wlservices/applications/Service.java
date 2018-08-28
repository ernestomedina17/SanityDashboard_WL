package com.att.infra.wlservices.applications;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import com.att.infra.ServiceAbstract;
import com.att.infra.json.Apps;
import com.att.infra.json.AppsBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.util.Arrays;

public abstract class Service extends ServiceAbstract {
	
	public static final String SERVICE = "applications";
	
	public static String getService() {
		return SERVICE;
	}
	
	public void setModel(Model model, String COMPONENT) {
		try {
			
			AppsBody appBody = new ObjectMapper().readValue(msg,AppsBody.class);
			
			Integer Contador = appBody.getBody().getItems().size();
			Integer Wldeploy = findOccurrences("depends=", "./src/main/resources/static/wldeploy/" + COMPONENT + ".xml") + 2; // + 2 is becasue jms which are on all envs are not listed on wldeploy file.
			
			model.addAttribute(COMPONENT + "AppsItems", appBody.getBody().getItems());
			model.addAttribute(COMPONENT + "Contador", Contador);
					
		    model.addAttribute(COMPONENT + "wldeploy", Wldeploy);
		    
			if (Contador != Wldeploy ) {

				model.addAttribute(COMPONENT + "appDiff", "Not all Ears are deployed");
				
			}

			else {

				model.addAttribute(COMPONENT + "appDiff", "All Ears are deployed");
			
			}
		    		
			
		} catch (Exception e) {
			System.out.println(e);
				List<Apps> listApps = new ArrayList<Apps>();
				Apps apps = new Apps();
				apps.setName("ERROR");
				apps.setHealth("UNKNOWN");
				apps.setState("UNKNOWN");
				listApps.add(apps);
				
				model.addAttribute(COMPONENT + "AppsItems", listApps);		
		}
	}
	
	public static int findOccurrences (String searchWord, String filename) throws IOException
	{
		//int count = 0;
		BufferedReader br = new BufferedReader(new FileReader(filename));
	    String line = null;
	    while( (line = br.readLine( )) != null)
        {
            if (line.indexOf(searchWord) != -1)
                {
                    //System.out.println(line);
                    break;
                }
        }
	String input = line;
	String[] exclude = {"<target","name=\"deployAll\"","depends=\"","jms-xa-adp","jms-notran-adp"," ,"," ","\"/>"};
	for (int ix = 0; ix < exclude.length; ix++) {
		input = input.replaceAll(exclude[ix], "");
	  }
	List<String> deplApps = Arrays.asList(input.split("\\s*,\\s*"));
	System.out.println(deplApps);
	br.close( );
    //System.out.println(filename);
	//System.out.println(input);	
	//System.out.println(deplApps.size());
	return deplApps.size();
	}
	
	

}
