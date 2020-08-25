package com.project.Salesforce.Base;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.project.Salesforce.driverClass.DriverScript;
import com.project.Salesforce.reports.ExtentManager;
import com.project.Salesforce.utilities.ExcelAPI;

public class BaseTest 
{
	public static String projectPath=System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties baseproperties;
	public static Properties childproperties;
	public Properties orProp;
	public static ExcelAPI xls;
	public String testName;
	public DriverScript ds;
	public  ExtentReports rep;
	public  ExtentTest test;
	
	public  void load() throws Exception
	{
		fis = new FileInputStream(projectPath + "//src//test//resources//environment.properties");
		baseproperties = new Properties();
		baseproperties.load(fis);
		String envType = baseproperties.getProperty("env");
		System.out.println(envType);
		
		fis = new FileInputStream(projectPath + "//src//test//resources//" + envType + ".properties");
		childproperties = new Properties();
		childproperties.load(fis);
		String value = childproperties.getProperty("zohourl");
		System.out.println(value);
		
		fis = new FileInputStream(projectPath + "//src//test//resources//" + "or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		//init the TestName
		testName = this.getClass().getSimpleName();
		System.out.println(testName);
		
		//How do i come to know which suite Excel file to load dynamically
		String[] pack = this.getClass().getPackage().getName().split("\\.");
		String suiteName = pack[pack.length-1];
		System.out.println(suiteName);
		
		//init the excel file
		xls = new ExcelAPI(childproperties.getProperty(suiteName+"_xls"));
		
		//init Driverscript
		 ds = new DriverScript();
		 ds.setOrProp(orProp);
		 
	}
	
	 @BeforeTest
	 public void init() throws Exception 
	 {
		  System.out.println("iam init method from BeforeTest....");
		  load(); 
		 rep =  ExtentManager.getInstance(baseproperties.getProperty("reportPath"));
		test =  rep.createTest(testName);
		ds.setTest(test);
	 }
	 
	 

	 @AfterTest
	 public void quit()
	 {
		 if(ds!=null)
			 ds.quit();
		 
		 if(rep!=null)
			 rep.flush();
	 }
	 
}
