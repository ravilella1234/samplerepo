package com.project.JuneMavenSelenium6_30PMBatch.parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGParallelMethods 
{
	WebDriver driver; 
	
  @Test
  public void test1() throws Exception 
  {
	  System.out.println("Iam inside test1..." + Thread.currentThread().getId());
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\MayBatch Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.amazon.in");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  driver.quit();
  }
  
  @Test
  public void test2() throws Exception 
  {
	  System.out.println("Iam inside test2..." + Thread.currentThread().getId());
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\MayBatch Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.bestbuy.com");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  driver.quit();
  }
  
  
  
}
