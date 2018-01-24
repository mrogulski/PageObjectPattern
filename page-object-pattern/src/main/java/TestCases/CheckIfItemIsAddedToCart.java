package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import Pages.CartPage;
import Pages.ItemPage;
import Pages.MainPage;
import Pages.RegisterPage;

public class CheckIfItemIsAddedToCart extends TestCase {
	static String item = "Magic Mouse";

	
	@Test()
	public void checkIfItemIsAddedToCart() throws InterruptedException {
		
		ItemPage itemPage = new MainPage(driver).goToCategory("Accessories").openItem(item);
		itemPage.addToCard();
		
		CartPage cartPage = new MainPage(driver).goToCartPage();
		
		WebElement itemsName = cartPage.gotoItem(item).itemsName();
		
		Assert.assertTrue("FAILED! Item is not added to the cart", itemsName.isDisplayed());

	}
}
