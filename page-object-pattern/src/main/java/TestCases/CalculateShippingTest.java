package TestCases;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import Pages.CalculateShippingPricePage;
import Pages.CartPage;
import Pages.ItemPage;
import Pages.MainPage;
import junit.framework.Assert;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Additions.SpreadsheetData;

@RunWith(Parameterized.class)
public class CalculateShippingTest extends TestCase {
	
	static String item = "Magic Mouse";
	private String country;
	private String price;
	
	public CalculateShippingTest(String country, String price) {
		this.country = country;
		this.price = price;
	}
	
	@Parameters
	public static Collection testData() throws Exception {
	InputStream spreadsheet = new FileInputStream("./src/main/java/Additions/Data.xls");
		return new SpreadsheetData(spreadsheet).getData();
		}

	
	@Test
	public void checkShippingPrice() {
		//add item to cart
		ItemPage itemPage = new MainPage(driver).goToCategory("Accessories").openItem(item);
		itemPage.addToCard();
		//go to cart page and go to calculate shipping price page
		CartPage cartPage = new MainPage(driver).goToCartPage();
		CalculateShippingPricePage calculateShippingPage = cartPage.goToCalculateShippingPricePage();
		//calculate price
		String shippingPrice = calculateShippingPage.calculateShippingPrice(country);
		Assert.assertEquals(price, shippingPrice);
	}

}
