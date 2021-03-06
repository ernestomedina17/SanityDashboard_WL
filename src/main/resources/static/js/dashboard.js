function dashboard(env) {
	var startDate = new Date(); 
	var endDate;
	$("#template").empty(); //Cleans the DashBoard Tag with Template ID. 
			      //loads template.html which is retrieved by com.att.infra.TemplateController.java
	$("#template").load("/template", function(responseTxt, statusTxt, xhr) { 
		if (statusTxt == "success") {
			console.log("External content loaded successfully!");
			//Sets the DashBoard Header E.g. Sanity for sit1 - Wed Nov 08 2017 14:36:57 GMT-0600 (Central Standard Time)
			$('.dashboardtitle').append(env);
			$('.dashboardtitle').append(" - ");
			$('.dashboardtitle').append(startDate);
			
			//Adds the blue circle CSS animation while loading the static/css/style.css:.spinner class
			$('#thCamo').addClass('spinner');
			$('#thDN').addClass('spinner');
			$('#thOcxim').addClass('spinner');
			$('#thOmx').addClass('spinner');
			$('#thReporting').addClass('spinner');
			$('#thTnmgt').addClass('spinner');
			$('#thTnplatform').addClass('spinner');
			$('#thWorkermgt').addClass('spinner');
			
			//Use JQuery AJAX functions defined below to consume the WebLogic's REST Services
			sanityCamo(env);
			sanityDN(env);
			sanityOcxim(env);
			sanityOmx(env);
			sanityReporting(env);
			sanityTnmgt(env);
			sanityTnplatform(env);
			sanityWorkermgt(env);
			
			//While the spinner class is set loop, once all spinner classes have been unset Run Sanity Check
			var isSpinnerActive = true;
			var myVar = setInterval(function(){ checkSpinnerStatus(isSpinnerActive, myVar, env, startDate, endDate) }, 3000);
		
		}
		if (statusTxt == "error") {
			console.error("Error: " + xhr.status + ": " + xhr.statusText);
		}
	});

}

function checkSpinnerStatus(isSpinnerActive, myVar, env, startDate, endDate){
	if ( 
    		$('#thCamo').hasClass('spinner') || 
    		$('#thDN').hasClass('spinner') ||
			$('#thOcxim').hasClass('spinner') ||
			$('#thOmx').hasClass('spinner') ||
			$('#thReporting').hasClass('spinner') ||
			$('#thTnmgt').hasClass('spinner') ||
			$('#thTnplatform').hasClass('spinner') ||
			$('#thWorkermgt').hasClass('spinner') 
    ) { 
    	console.log("isSpinnerActive: " + isSpinnerActive);
    } else {
    	isSpinnerActive = false;
    	console.log("isSpinnerActive: " + isSpinnerActive);
    	myVar = clearInterval(myVar);
    	var sanityPassed;
    	checkSanityStatus(sanityPassed);
    	//Alert Sanity Result
    	
    	endDate = new Date();
    	var timer = ((endDate.getMinutes() * 60) + endDate.getSeconds()) -
    				((startDate.getMinutes() * 60) + startDate.getSeconds());
    	
    	if(sanityPassed){
    		alert("The Sanity PASSED for " + env + " - Timer: " + timer + " seconds");
    	} else {
    		alert("The Sanity FAILED for " + env + " - Timer: " + timer + " seconds");
    	}
    }
}

function checkSanityStatus(sanityPassed){
	//Health Check 
	if( $("td:contains('HEALTH_WARN')") ){
		$("td:contains('HEALTH_WARN')").css({  	
			"border-color":"red", "background-color":"yellow" });
		sanityPassed = false;
	}
			
	//Data Source Status
	if( $("td:contains('No instance')") ){
		$("td:contains('No instance')").css({  	
			"border-color":"red", "background-color":"yellow" });
		sanityPassed = false;
	}
	
	//Deployment Status
	if( $("td:contains('STATE_ADMIN')") ){
		$("td:contains('STATE_ADMIN')").css({  	
			"border-color":"red", "background-color":"yellow" });
		sanityPassed = false;
	}
	
	if( $("td:contains('STATE_FAILED')") ){
	$("td:contains('STATE_FAILED')").css({ 	
		"border-color":"red", "background-color":"yellow" });
		sanityPassed = false;
	}
	
	if( $("td:contains('STATE_NEW')") ){
		$("td:contains('STATE_NEW')").css({    	
			"border-color":"red", "background-color":"yellow" });
		sanityPassed = false;
	}
	
	if( $("td:contains('STATE_PREPARED')") ){
		$("td:contains('STATE_PREPARED')").css({
			"border-color":"red", "background-color":"yellow" });	
		sanityPassed = false;
	}
	
	//Servers Status
	if( $("td:contains('STARTING')") ){
	$("td:contains('STARTING')").css({ 		
		"border-color":"green","background-color":"yellow"});
	sanityPassed = false;
	}
	
	if( $("td:contains('SHUTDOWN')") ){
	$("td:contains('SHUTDOWN')").css({ 		
		"border-color":"red", "background-color":"yellow" });
	sanityPassed = false;
	}
	
	if( $("td:contains('ADMIN')") ){
	$("td:contains('ADMIN')").css({ 		
		"border-color":"red", "background-color":"yellow" });
	sanityPassed = false;
	}
	
	if( $("td:contains('ERROR')") ){
		$("td:contains('ERROR')").css({ 		
			"border-color":"red", "background-color":"yellow" });
		sanityPassed = false;
	}
	
	if( $("td:contains('UNKNOWN')") ){
		$("td:contains('UNKNOWN')").css({ 		
			"border-color":"red", "background-color":"yellow" });
		sanityPassed = false;
	}	
	
	//Empty == Error
	if( $("td:empty") ){
	$("td:empty").css({ 					
		"border-color":"red", "background-color":"yellow" });
	sanityPassed = false;
	}
	
	//Apps Compare
	
	if( $("td:contains('Not all Ears are deployed')") ){
		$("td:contains('Not all Ears are deployed')").css({ 		
			"border-color":"red", "background-color":"yellow" });
		sanityPassed = false;
	}
	
	console.log("sanityPassed: " + sanityPassed);
}

function sanityCamo(env) {
	$(document).ready(function() {
		// CamoServers
		$.ajax({
			type : "GET",
			url : "camo_servers?env=" + env,
			success : function(result) {
				$('#camoTable').append(result);				
			}
		});
		
		// CamoDeployments
		$.ajax({
			type : "GET",
			url : "camo_applications?env=" + env,
			success : function(result) {
				$('#camoTable').append(result);
				$('#thCamo').removeClass('spinner');
				
			}



		});
		
		// CamoDataSources 
		$.ajax({
			type : "GET",
			url : "camo_datasources?env=" + env,
			success : function(result) {
				$('#camoTable').append(result);
			}
		});
	//End document function
	});
// End sanity function
}

function sanityDN(env) {
	$(document).ready(function() {
		// DNServers
		$.ajax({
			type : "GET",
			url : "dn_servers?env=" + env,
			success : function(result) {
				$('#dnTable').append(result);
			}
		});
		
		// DNDeployments
		$.ajax({
			type : "GET",
			url : "dn_applications?env=" + env,
			success : function(result) {
				$('#dnTable').append(result);
				$('#thDN').removeClass('spinner');
			}
		});
		
		// DNDataSources 
		$.ajax({
			type : "GET",
			url : "dn_datasources?env=" + env,
			success : function(result) {
				$('#dnTable').append(result);
			}
		});
	//End document function
	});
// End sanity function
}

function sanityOcxim(env) {
	$(document).ready(function() {
		// OcximServers
		$.ajax({
			type : "GET",
			url : "ocxim_servers?env=" + env,
			success : function(result) {
				$('#ocximTable').append(result);
			}
		});
		
		// OcximDeployments
		$.ajax({
			type : "GET",
			url : "ocxim_applications?env=" + env,
			success : function(result) {
				$('#ocximTable').append(result);
				$('#thOcxim').removeClass('spinner');
			}


		});
		
		// OcximDataSources 
		$.ajax({
			type : "GET",
			url : "ocxim_datasources?env=" + env,
			success : function(result) {
				$('#ocximTable').append(result);
			}
		});
	//End document function
	});
// End sanity function
}

function sanityOmx(env) {
	$(document).ready(function() {
		// OmxServers
		$.ajax({
			type : "GET",
			url : "omx_servers?env=" + env,
			success : function(result) {
				$('#omxTable').append(result);
			}
		});
		
		// OmxDeployments
		$.ajax({
			type : "GET",
			url : "omx_applications?env=" + env,
			success : function(result) {
				$('#omxTable').append(result);
				$('#thOmx').removeClass('spinner');
			}
		});
		
		// OmxDataSources 
		$.ajax({
			type : "GET",
			url : "omx_datasources?env=" + env,
			success : function(result) {
				$('#omxTable').append(result);
			}
		});
	//End document function
	});
// End sanity function
}

function sanityReporting(env) {
	$(document).ready(function() {
		// ReportingServers
		$.ajax({
			type : "GET",
			url : "reporting_servers?env=" + env,
			success : function(result) {
				$('#reportingTable').append(result);
			}
		});
		
		// ReportingDeployments
		$.ajax({
			type : "GET",
			url : "reporting_applications?env=" + env,
			success : function(result) {
				$('#reportingTable').append(result);
				$('#thReporting').removeClass('spinner');
			}
		});
		
		// ReportingDataSources 
		$.ajax({
			type : "GET",
			url : "reporting_datasources?env=" + env,
			success : function(result) {
				$('#reportingTable').append(result);
			}
		});
	//End document function
	});
// End sanity function
}

function sanityTnmgt(env) {
	$(document).ready(function() {
		// TnmgtServers
		$.ajax({
			type : "GET",
			url : "tnmgt_servers?env=" + env,
			success : function(result) {
				$('#tnmgtTable').append(result);
			}
		});
		
		// TnmgtDeployments
		$.ajax({
			type : "GET",
			url : "tnmgt_applications?env=" + env,
			success : function(result) {
				$('#tnmgtTable').append(result);
				$('#thTnmgt').removeClass('spinner');
			}

		});
		
		// TnmgtDataSources 
		$.ajax({
			type : "GET",
			url : "tnmgt_datasources?env=" + env,
			success : function(result) {
				$('#tnmgtTable').append(result);
			}
		});
	//End document function
	});
// End sanity function
}

function sanityTnplatform(env) {
	$(document).ready(function() {
		// TnplatformServers
		$.ajax({
			type : "GET",
			url : "tnplatform_servers?env=" + env,
			success : function(result) {
				$('#tnplatformTable').append(result);
			}
		});
		
		// TnplatformDeployments
		$.ajax({
			type : "GET",
			url : "tnplatform_applications?env=" + env,
			success : function(result) {
				$('#tnplatformTable').append(result);
				$('#thTnplatform').removeClass('spinner');
			}
		});
		
		// TnplatformDataSources 
		$.ajax({
			type : "GET",
			url : "tnplatform_datasources?env=" + env,
			success : function(result) {
				$('#tnplatformTable').append(result);
			}
		});
	//End document function
	});
// End sanity function
}

function sanityWorkermgt(env) {
	$(document).ready(function() {
		// WorkermgtServers
		$.ajax({
			type : "GET",
			url : "workermgt_servers?env=" + env,
			success : function(result) {
				$('#workermgtTable').append(result);
			}
		});
		
		// WorkermgtDeployments
		$.ajax({
			type : "GET",
			url : "workermgt_applications?env=" + env,
			success : function(result) {
				$('#workermgtTable').append(result);
				$('#thWorkermgt').removeClass('spinner');
			}
		});
		
		// WorkermgtDataSources 
		$.ajax({
			type : "GET",
			url : "workermgt_datasources?env=" + env,
			success : function(result) {
				$('#workermgtTable').append(result);
			}
		});
	//End document function
	});
// End sanity function
}
