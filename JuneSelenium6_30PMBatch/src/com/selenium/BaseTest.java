package com.selenium;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest 
{
	public static WebDriver driver;
	public static FileInputStream fis;
	public static String projectPath=System.getProperty("user.dir");
	public static Properties p;
	public static Properties parentInstance;
	public static Properties childInstance;
	
	public static void init() throws Exception
	{
		fis = new FileInputStream(projectPath +"//data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath + "//environment.properties");
		parentInstance = new Properties();
		parentInstance.load(fis);
		String e = parentInstance.getProperty("env");
		System.out.println(e);
		
		
		fis = new FileInputStream(projectPath + "//" + e + ".properties");
		childInstance = new Properties();
		childInstance.load(fis);
		String url = childInstance.getProperty("amazonurl");
		System.out.println(url);
	}
	
	
	public static void launchBrowser(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\MayBatch Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(p.getProperty(browser).equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\MayBatch Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	
	public static void navigateUrl(String url)
	{
		//driver.get(url);
		driver.navigate().to(childInstance.getProperty(url));
	}

}
