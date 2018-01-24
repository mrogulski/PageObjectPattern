package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends Page {

	private static By continueButtonSelector = By.xpath("//a[@class='step2']");
	
	public CartPage(WebDriver driver) {
		super(driver);
	}

	public CalculateShippingPricePage goToCalculateShippingPricePage() {
		
		driver.findElement(continueButtonSelector).click();
		waitUntilItemsDisplayed(By.id("wpsc_shopping_cart_container"));
		return new CalculateShippingPricePage(driver);
	}

	
	public CartsPageItem gotoItem(String item) {
		return new CartsPageItem(driver, item);
	}



}
