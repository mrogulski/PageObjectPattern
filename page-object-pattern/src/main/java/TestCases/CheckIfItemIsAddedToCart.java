package TestCases;

import org.junit.Assert;
import org.junit.Test;

import Pages.ItemPage;
import Pages.MainPage;
import Pages.RegisterPage;

public class CheckIfItemIsAddedToCart extends TestCase {

	
	@Test()
	public void checkIfItemIsAddedToCart() {
		ItemPage itemPage = new MainPage(driver).goToCategory("Accessories").openItem("Magic Mouse");
		itemPage.addToCard();
	}
}
