package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDemoSteps 
{
	WebDriver driver = null;
	
	@Given("Open the Browser")
	public void open_the_browser() 
	{
	    System.setProperty("webdriver.chrome.driver","C:/Users/DELL/Desktop/Drivers/chromedriver.exe" );
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@And("USer is on login page")
	public void u_ser_is_on_login_page() 
	{
	    driver.get("https://example.testproject.io/web/");
	}

	@When("^User enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws Exception 
	{
	  driver.findElement(By.id("name")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  Thread.sleep(3000);
	  driver.findElement(By.id("login")).click();
	}

	@Then("User is navigated to the login homepage")
	public void user_is_navigated_to_the_login_homepage() {
	   driver.findElement(By.id("logout")).isDisplayed();
	   driver.quit();
	}

}
