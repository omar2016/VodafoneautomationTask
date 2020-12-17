package steps;

import org.testng.Assert;

import data.LoadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestirationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {

	HomePage homePageObject ;
	UserRegestirationPage userRegestirationObject;
	CreateAccountPage createAccountPageObject;
	LoginPage loginObject;
	String firstname = LoadProperties.userData.getProperty("firstname");
	String lastname = LoadProperties.userData.getProperty("lastname"); 
	String email = LoadProperties.userData.getProperty("email"); 
	String password = LoadProperties.userData.getProperty("password"); 
	String postcode = LoadProperties.userData.getProperty("postcode"); 
	String phone = LoadProperties.userData.getProperty("phone"); 
	String city = LoadProperties.userData.getProperty("city"); 
	String address = LoadProperties.userData.getProperty("address"); 
	
	@Given("the user in home page")
	public void the_user_in_home_page() {
		homePageObject = new HomePage(driver);
		homePageObject.openSigninPage();
		
	
		
	}

	@When("user Enter Data To Register")
	public void user_enter_data_to_register() {
		userRegestirationObject = new UserRegestirationPage(driver);
		userRegestirationObject.openCreateAccountpage(email);

		createAccountPageObject = new CreateAccountPage(driver);
		createAccountPageObject.userRegisteration(firstname, lastname, password, postcode, address, city, phone);
	}

	@When("user Register Sucessfully")
	public void user_register_sucessfully() {
		Assert.assertTrue(userRegestirationObject.signout.getText().equals("Sign out"));

	}

	@When("user Register LogOut sucessfully")
	public void user_register_log_out_sucessfully() {
		createAccountPageObject.userLogout();
		Assert.assertTrue(homePageObject.signinlink.getText().equals("Sign in"));

	}

	@Then("user can login sucessfully")
	public void user_can_login_sucessfully() {

		homePageObject.openSigninPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(userRegestirationObject.signout.getText().equals("Sign out"));

	}
}
