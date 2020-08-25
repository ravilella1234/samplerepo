package com.project.Salesforce.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{
	public static ExtentReports extent;
	
	public static ExtentReports getInstance(String reportPath)
	{
		if(extent == null)
		{
			System.out.println(reportPath+"//extent.html");
			createInstance(reportPath+"//extent.html");
		}
			
		
		return extent;
	}

	public static ExtentReports createInstance(String fileName) 
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("HTML Reports");
		htmlReporter.config().setReportName("Report -  Automation testing...");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}

}
