package com.project.Salesforce.Base;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class BaseTest 
{
	public static String projectPath=System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties baseproperties;
	public static Properties childproperties;
	
	public static void load() throws Exception
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
	}
	
	 @BeforeTest
	 public void init() throws Exception 
	 {
		  System.out.println("iam init method from BeforeTest....");
		  load(); 
	 }

}
