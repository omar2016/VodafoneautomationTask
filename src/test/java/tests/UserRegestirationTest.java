package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestirationPage;

public class UserRegestirationTest extends TestBase {

	HomePage homePageObject;
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

	@Test(priority = 1, alwaysRun = true)
	public void userRediretToSiginpage() throws InterruptedException {

		homePageObject = new HomePage(driver);
		homePageObject.openSigninPage();
	}

	@Test(dependsOnMethods = "userRediretToSiginpage")
	public void userEnterDataToRegister() {
		userRegestirationObject = new UserRegestirationPage(driver);
		userRegestirationObject.openCreateAccountpage(email);

		createAccountPageObject = new CreateAccountPage(driver);
		createAccountPageObject.userRegisteration(firstname, lastname, password, postcode, address, city, phone);

	}
	
	@Test(dependsOnMethods ="userEnterDataToRegister" )
	public void checkuserRegisterSucessfully() {
		
		Assert.assertTrue(userRegestirationObject.signout.getText().equals("Sign out"));
		
	}

	@Test(dependsOnMethods = "userEnterDataToRegister")
	public void userRegisterLogOutsucessfully() {

		createAccountPageObject.userLogout();
		Assert.assertTrue(homePageObject.signinlink.getText().equals("Sign in"));

	}

	@Test(dependsOnMethods = "userRegisterLogOutsucessfully")
	public void checkuserLoginsucessfully()  {

		homePageObject.openSigninPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(userRegestirationObject.signout.getText().equals("Sign out"));

	}
}
