package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionResultsPage extends Page {
	
	private By headerLocator = By.xpath("//header[@class='page-header']/h1");

	public TransactionResultsPage(WebDriver driver) {
		super(driver);
		
	}
	
	public WebElement getHeader() {
		WebElement header = driver.findElement(headerLocator);
		return header;
	} 

}
