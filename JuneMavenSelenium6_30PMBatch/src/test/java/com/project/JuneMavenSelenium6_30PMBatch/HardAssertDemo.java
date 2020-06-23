package com.project.JuneMavenSelenium6_30PMBatch;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertDemo extends BaseTest
{
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String bType) throws Exception 
	{
		init();
		launchBrowser(bType);
		navigateUrl("amazonurl");
	}
	
	@Test
	public void test()
	{
		String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		String expectedLink = "Customer Servic";
		
		//Assert.assertEquals(actualLink, expectedLink);
		//Assert.assertTrue(actualLink.equals(expectedLink), "Both links are not equal...");
		SoftAssert s = new SoftAssert();
		//s.assertEquals(actualLink, expectedLink);
		s.assertTrue(expectedLink.equals(actualLink), "Both links are not equal...");
		
		s.assertTrue(true, "error1");
		
		s.assertTrue(false, "error2");
		
		
		Assert.assertEquals(actualLink, expectedLink);
		
		s.assertTrue(true, "error3");
		
		s.assertTrue(false, "error4");
		
		driver.findElement(By.linkText("Customer Service")).click();
		
		s.assertAll();
		
	}

}
