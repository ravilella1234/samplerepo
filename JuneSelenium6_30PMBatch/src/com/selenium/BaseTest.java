package com.selenium;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class BaseTest 
{
	public static WebDriver driver;
	public static FileInputStream fis;
	public static String projectPath=System.getProperty("user.dir");
	public static Properties p;
	public static Properties parentInstance;
	public static Properties childInstance;
	public static Properties orProp;
	
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
		
		fis = new FileInputStream(projectPath + "//or.properties");
		orProp = new Properties();
		orProp.load(fis);
	}
	
	
	public static void launchBrowser(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\MayBatch Drivers\\chromedriver.exe");
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 10");
			option.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(option);
		}
		else if(p.getProperty(browser).equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\MayBatch Drivers\\geckodriver.exe");
			
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("juneFFprofile");
			
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			option.addPreference("dom.webnotifications.enabled", false);
			
			driver = new FirefoxDriver(option);
		}
	}
	
	
	public static void navigateUrl(String url)
	{
		//driver.get(url);
		driver.navigate().to(childInstance.getProperty(url));
	}
	
	
	public static WebElement getElement(String locatorKey) 
	{
		WebElement element = null;
		
		if(locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
		}
		return element;
		
	}
	
	
	public static void clickElement(String locatorKey) 
	{
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(locatorKey)).click();
	}

	

	public static void typeText(String locatorKey, String text) 
	{
		getElement(locatorKey).sendKeys(text);
		//driver.findElement(By.name(locatorKey)).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String item) 
	{
		getElement(locatorKey).sendKeys(item);
		//driver.findElement(By.id(locatorKey)).sendKeys(item);
	}

}
