package com.project.JuneMavenSelenium6_30PMBatch;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TC_002 extends BaseTest
{
  
  
  @BeforeMethod(groups = {"regression","sanity"})
  @Parameters("browser")
  public void startProcess(String bType) throws Exception 
  {
	  init();
	  test=report.startTest("TC_002");
	  test.log(LogStatus.INFO, "Initializing the Properties & configuration files......");
	  
	  launchBrowser(bType);
	  test.log(LogStatus.PASS, "Opened the Browser : " + p.getProperty("chromebrowser"));
	  
	  navigateUrl("amazonurl");
	  test.log(LogStatus.PASS, "Navigated to url : " + childEnv.getProperty("amazonurl"));
  }
  
  
  @Test(groups = {"regression","sanity"})
  public void amazon()
  {
	  
	    selectOption("amazondropbox_id","Books");	
		test.log(LogStatus.PASS, "Selected the option  Books By using the locator :- " + orprop.getProperty("amazondropbox_id"));
		
		typeText("amazonsearchtext_name","Harry potter");
		test.log(LogStatus.PASS, "Entered the text Harry Portter by using the locator :- " + orprop.getProperty("amazonsearchtext_name"));	
		
		elementClick("amazonsearchbutton_xpath");
		test.log(LogStatus.PASS, "Clicked on Search Button By using the locator :- " + orprop.getProperty("amzonsearchbotton_xpath"));
	  
  }

  @AfterMethod(groups = {"regression","sanity"})
  public void endProcess()
  {
	 if(driver!=null)
		 driver.quit();
	 
	 
		 report.endTest(test);
	 	 report.flush();
  }

}
