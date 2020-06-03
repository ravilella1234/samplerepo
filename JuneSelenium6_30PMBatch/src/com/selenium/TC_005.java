package com.selenium;

public class TC_005 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launchBrowser("chromebrowser");
		
		navigateUrl("amazonurl");
		
		selectOption("amazondropbox_id","Books");
				
		typeText("amzonsearchtext_id","Harry potter");
		
		clickElement("amazonsearchbutton_xpath");
		
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry potter");
		
		//driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();

	}

	
}
