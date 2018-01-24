package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Pages.CartPage;
import Pages.ItemPage;
import Pages.MainPage;

public class RemoveItemTest extends TestCase {
	
	static String item = "Magic Mouse";
	private String expectedMsg = "Oops, there is nothing in your cart.";
	private static By emptyContentSelector = By.xpath("//div[@class='entry-content']");


	
	@Test()
	public void checkIfItemIsRemovedFromCart(){
		//add product
		ItemPage itemPage = new MainPage(driver).goToCategory("Accessories").openItem(item);
		itemPage.addToCard();
		CartPage cartPage = new MainPage(driver).goToCartPage();
		
		//remove product
		cartPage.gotoItem(item).removeItem();
		
		WebElement emptyContent = driver.findElement(emptyContentSelector);
		String emptyContentMsg = emptyContent.getText();
		
		Assert.assertEquals("FAILED! Item not removed from the cart!", expectedMsg, emptyContentMsg);


	}

}
