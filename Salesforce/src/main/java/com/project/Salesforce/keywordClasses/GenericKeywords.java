package com.project.Salesforce.keywordClasses;

import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericKeywords 
{
	public Properties orProp;
	public String objectKey;
	public String dataKey;
	public Hashtable<String, String> data;
	public WebDriver driver;
	
	
	public void setOrProp(Properties orProp) {
		this.orProp = orProp;
	}

	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public void setData(Hashtable<String, String> data) {
		this.data = data;
	}

	public void openBrowser()
	{
		String browser = data.get(dataKey);
		System.out.println("Opening the browser..." + browser);
		
		
		if(browser.equals("chrome"))
		{
			//Create BrowserProfile & invoke that profile by using ChromeOptions Class
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\JulyDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			//Create BrowserProfile & invoke that profile by using FirfoxOptions Class
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\JulyDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	public void navigateUrl()
	{
		System.out.println("Navigating the url...." + data.get(dataKey));
		driver.get(data.get(dataKey));
	}
	
	public void click()
	{
		System.out.println("Clicking on element..." + orProp.getProperty(objectKey));
		//driver.findElement(By.xpath(orProp.getProperty(objectKey))).click();
		getElement(objectKey).click();
	}
	
	

	public void type()
	{
		System.out.println("Typing the text... " + orProp.getProperty(objectKey) + "------" +  data.get(dataKey));
		//driver.findElement(By.xpath(orProp.getProperty(objectKey))).sendKeys(data.get(dataKey));
		getElement(objectKey).sendKeys(data.get(dataKey));
	}

	public void verifyTitle()
	{
		System.out.println("Title is verified....");
	}
	
	public WebElement getElement(String objectKey)
	{
		WebElement element=null;
		
		if(objectKey.endsWith("_id")) {
			element = driver.findElement(By.id(orProp.getProperty(objectKey)));
		}else if(objectKey.endsWith("_name")) {
			element = driver.findElement(By.name(orProp.getProperty(objectKey)));
		}else if(objectKey.endsWith("_classname")) {
			element = driver.findElement(By.className(orProp.getProperty(objectKey)));
		}else if(objectKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orProp.getProperty(objectKey)));
		}else if(objectKey.endsWith("_css")) {
			element = driver.findElement(By.cssSelector(orProp.getProperty(objectKey)));
		}else if(objectKey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orProp.getProperty(objectKey)));
		}else if(objectKey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(orProp.getProperty(objectKey)));
		}
		
		return element;
	}

}
