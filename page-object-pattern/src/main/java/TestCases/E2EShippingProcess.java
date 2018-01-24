package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import Pages.CalculateShippingPricePage;
import Pages.CartPage;
import Pages.ItemPage;
import Pages.MainPage;
import Pages.TransactionResultsPage;

public class E2EShippingProcess extends TestCase {
	static String item = "Magic Mouse";
	private static String email = "email@email.com";
	private static String name = "Test";
	private static String lastName = "User";
	private static String address = "Ul. Testowa 67";
	private static String city = "Warszawa";
	private static String country = "Poland";
	private static String phone = "111222333";

	@Test()
	public void e2eShippingProcessTest() throws InterruptedException{
		//add item to cart
		ItemPage itemPage = new MainPage(driver).goToCategory("Accessories").openItem(item);
		itemPage.addToCard();
		//go to cart page and go to calculate shipping price page
		CartPage cartPage = new MainPage(driver).goToCartPage();
		CalculateShippingPricePage calculateShippingPage = cartPage.goToCalculateShippingPricePage();

		//provide details
		calculateShippingPage.provideEmail(email);
		calculateShippingPage.provideBillingName(name);
		calculateShippingPage.provideBillingLastName(lastName);
		calculateShippingPage.provideBillingAddressDetails(address);
		calculateShippingPage.provideBillingCity(city);
		calculateShippingPage.selectBillingCountry(country);
		calculateShippingPage.provideBillingPhone(phone);
		//go to results page
		TransactionResultsPage results = calculateShippingPage.finalizeShipping();
		WebElement header = results.getHeader();
		
		Assert.assertEquals("Transaction Results", header.getText());

	}
}
