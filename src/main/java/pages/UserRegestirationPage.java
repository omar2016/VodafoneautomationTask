package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegestirationPage extends PageBase {

	public UserRegestirationPage(WebDriver driver) {
		super(driver);
	}

	
@FindBy(xpath="//input[@name='email_create']")
WebElement emailcreateaccount;	
	

@FindBy(linkText = "Sign out")
public WebElement signout;

@FindBy(id = "SubmitCreate")
WebElement createaccountbutton;


public void openCreateAccountpage (String email) {
	
	setElementText(emailcreateaccount, email);
	clickButton(createaccountbutton);
}
}
