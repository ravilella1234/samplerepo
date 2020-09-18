package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps 
{
	
	@Given("user is on login page")
	public void user_is_on_login_page()
	{
	   System.out.println("LoginStep : user is on login page");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() 
	{
	   System.out.println("LoginStep : user enters username and password");
	}

	@And("Clicks on login buton")
	public void clicks_on_login_buton() 
	{
	   System.out.println("LoginStep : Clicks on login buton");
	}

	@Then("user should navigated to the home page")
	public void user_should_navigated_to_the_home_page() 
	{
	    System.out.println("LoginStep : user should navigated to the home page");
	}
	
}
