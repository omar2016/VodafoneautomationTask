package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Sign in")
	public WebElement signinlink;
	
	
	@FindBy(xpath ="//*[@class='icon-list-ol']")
	public WebElement historyorder;


	@FindBy(xpath ="//*[@class='account']")
	WebElement account;
	
	

	public void openSigninPage() {

		clickButton(signinlink);
	}
	
	
	public void openhistroypage() {
		
		clickButton(account);
		clickButton(historyorder);
	}

}