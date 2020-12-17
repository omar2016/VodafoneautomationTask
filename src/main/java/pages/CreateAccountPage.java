package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends PageBase {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@name='id_gender']")
	WebElement radiobuttongender;

	@FindBy(id ="customer_firstname")
	WebElement firstname;

	@FindBy(id ="customer_lastname")
	WebElement lastname;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "address1")
	WebElement address;
	

	@FindBy(id = "city")
	WebElement cityy;
	
	@FindBy(id = "postcode")
	WebElement postcodal;
	
	@FindBy(id = "id_state")
	WebElement selectstate;
	
	@FindBy(id = "phone_mobile")
	WebElement mobilephonenumber;

	@FindBy(id = "submitAccount")
	WebElement registerbutton;
	
	@FindBy(linkText = "Sign out")
	public WebElement signout;
	
	Select state = new Select(selectstate);
	
	public void userRegisteration(String firstnam, String lastnam, String passwd ,String postcod,String addres ,String city,String phone) {

		clickButton(radiobuttongender);;
		setElementText(firstname, firstnam);
		setElementText(lastname, lastnam);
		setElementText(password, passwd);
		setElementText(address, addres);
		setElementText(postcodal, postcod);
		setElementText(cityy, city);
		state.selectByVisibleText("Alaska");
		setElementText(mobilephonenumber, phone);
		clickButton(registerbutton);

	}
	public void userLogout() {
		clickButton(signout);
	}
}