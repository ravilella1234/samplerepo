package com.project.JuneMavenSelenium6_30PMBatch;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends BaseTest
{
	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			Date dt = new Date();
			String reportFilePath = dt.toString().replace(":", "_").replace(" ", "_")+".html";
			extent = new ExtentReports(projectPath + "//Reports//" + reportFilePath);
			extent.loadConfig(new File(projectPath + "//extentreportconfig.xml"));
			extent.addSystemInfo("Selenium Language", "3.141.59").addSystemInfo("Environment",parentEnv.getProperty("env"));
		}
		
		return extent;
	}

}
