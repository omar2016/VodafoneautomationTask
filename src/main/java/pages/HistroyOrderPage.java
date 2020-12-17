package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HistroyOrderPage extends PageBase {

	public HistroyOrderPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "order-list")
	public static WebElement table;

	

	@FindBy(xpath ="//*[@class='cheque-indent']")
	public WebElement orderconfirmtxt;
	
	

	public void reorderFromHistoryPage() {
		WebElement tables =table;
		WebElement ro = tables.findElement(By.cssSelector("tr.first_item"));
		
		WebElement cell = ro.findElement(By.linkText("Reorder"));
		
		cell.click();
	}
}
