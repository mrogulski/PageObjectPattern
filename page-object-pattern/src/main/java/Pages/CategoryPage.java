package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CategoryPage extends Page {
	
	private final By headerLocator = By.cssSelector(".entry-title");
	private final By itemsListLocator = By.cssSelector("div #container > #content");

	public CategoryPage(WebDriver driver) {
		super(driver);
		
	}
	
	public WebElement getHeader() {
		waitUntilItemsDisplayed(itemsListLocator);
		WebElement header = driver.findElement(headerLocator);
		return header;
	}
	
	public ItemPage openItem(String itemName) {
		waitUntilItemsDisplayed(By.xpath("//*[contains(text(), '" + itemName + "')]"));
		WebElement itemPage =  driver.findElement(By.xpath("//*[contains(text(), '" + itemName + "')]"));
		itemPage.click();
		
		return new ItemPage(driver);
		
	}
	

}
