package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class GoogleSearchSteps 
{
	WebDriver driver = null;
	
	@Given("Browser to open")
	public void OpenBrowser() 
	{
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Sept Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() 
	{
	    driver.get("https:/www.google.com");
	}

	@When("user enters a textin search box")
	public void user_enters_a_textin_search_box() 
	{
	   driver.findElement(By.name("q")).sendKeys("Selenium tutorial");
	   
	}

	@And("Hits enter button")
	public void hits_enter_button() {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("User is navigated to search results page")
	public void user_is_navigated_to_search_results_page() {
	   driver.getPageSource().contains("Selenium Tutorial - javatpoint");
	   
	   driver.quit();
	}

}
