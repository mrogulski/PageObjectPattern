package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import Pages.CartPage;
import Pages.CartsPageItem;
import Pages.ItemPage;
import Pages.MainPage;

public class UpdateQuantityTest extends TestCase {
	
	static String item = "Magic Mouse";

	@Test()
	public void checkIfPriceIsIncreased(){
		//add product
		ItemPage itemPage = new MainPage(driver).goToCategory("Accessories").openItem(item);
		itemPage.addToCard();
		CartPage cartPage = new MainPage(driver).goToCartPage();
		
		//update quantity
		CartsPageItem itemsRow = cartPage.gotoItem(item);
		itemsRow.updateQuantity("2");
		
		String totalPrice = itemsRow.totalPrice().getText();
		
		Assert.assertEquals("$300.00", totalPrice);
		

	}
}
