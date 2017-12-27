package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage extends Page {
	
	private static By addToCardButtonSelector = By.cssSelector(".wpsc_buy_button");

	public ItemPage(WebDriver driver) {
		super(driver);
	}
	
	public void addToCard() {
		waitUntilItemsDisplayed(addToCardButtonSelector);
		driver.findElement(addToCardButtonSelector).click();
		
	}

}
