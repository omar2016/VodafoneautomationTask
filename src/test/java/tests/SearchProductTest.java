package tests;




import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.LoginPage;
import pages.SelectProductpage;




public class SearchProductTest extends TestBase{

	
	SelectProductpage searchProductObject;
	LoginPage loginObject;
	
	String email = LoadProperties.userData.getProperty("email"); 
	String password = LoadProperties.userData.getProperty("password");
	
	@Test(priority = 1 , alwaysRun = true)
	public void loginforcheckout() {
		
		loginObject =new LoginPage(driver);
		loginObject.siginForFirstTime(email,password);
		
	}

	@Test(dependsOnMethods = "loginforcheckout" )
	public void searchBlouses() {
	
		searchProductObject =new SelectProductpage(driver);
		
		searchProductObject.searchBlousesProduct();
	
	}
	@Test(dependsOnMethods = "searchBlouses")
	public void SelectResultedProduct() throws InterruptedException {
		
		searchProductObject.openpagedetails();
		
	}
		
	@Test (dependsOnMethods = "SelectResultedProduct")
	public void checkProceedCheckOutsuccessfully() throws InterruptedException {
		
		searchProductObject.proceedCheckout();
		Assert.assertTrue(searchProductObject.orderconfirmtxt.getText().equals("Your order on My Store is complete."));
		Thread.sleep(3000);
	}
}
