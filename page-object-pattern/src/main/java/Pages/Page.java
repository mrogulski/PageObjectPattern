package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	protected WebDriver driver;
	private static By cartSelector = By.cssSelector("#header_cart");
	
	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitUntilItemsDisplayed(By locator) {
		//wait until item shows on page
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locator));

		}
	
	public CartPage goToCartPage() {
		driver.findElement(cartSelector).click();
		waitUntilItemsDisplayed(By.id("checkout_page_container"));
		return new CartPage(driver);
	}

}
