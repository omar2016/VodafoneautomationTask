package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HistroyOrderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SelectProductpage;

public class HistroyOrderTest extends TestBase{

	HomePage homePageObject ;
	HistroyOrderPage histroyOrderPageObject;
	LoginPage loginPageObject;
	SelectProductpage selectObject;
	
	
	String email = LoadProperties.userData.getProperty("email"); 
	String password = LoadProperties.userData.getProperty("password");
	
	@Test(priority = 1 , alwaysRun = true)
	public void loginForOrderFromHistory() {
		

		loginPageObject =new LoginPage(driver);
		loginPageObject.siginForFirstTime(email,password);
		
		
	}
	
	@Test(dependsOnMethods = "loginForOrderFromHistory")
	public void orderFromHistorysucessfully () throws InterruptedException{
		homePageObject = new HomePage(driver);
		homePageObject.openhistroypage();
		histroyOrderPageObject = new  HistroyOrderPage(driver);
		histroyOrderPageObject.reorderFromHistoryPage();	
		selectObject =new SelectProductpage(driver);
		selectObject.checkoutafterhistroyreorder();
		Assert.assertTrue(histroyOrderPageObject.orderconfirmtxt.getText().equals("Your order on My Store is complete."));

		Thread.sleep(3000);
	}
	
}
