package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalculateShippingPricePage extends Page {
	
	private static By shippingCountrDropdownLocator = By.xpath("//select[@name='country']");
	private static By calculateLocator = By.xpath("//input[@value='Calculate']");
	private static By totalShippingLocator = By.xpath("//*[@id=\"wpsc_shopping_cart_container\"]/form/div[3]/table/tbody/tr[2]/td[2]/span/span");
	private static By emailLocator = By.id("wpsc_checkout_form_9");
	//billing details locators
	private static By billingNameLocator = By.id("wpsc_checkout_form_2");
	private static By billingLastNameLocator = By.id("wpsc_checkout_form_3");
	private static By billingAddressLocator = By.id("wpsc_checkout_form_4");
	private static By billingCityLocator = By.id("wpsc_checkout_form_5");
	private static By billingCountryLocator = By.id("wpsc_checkout_form_7");
	private static By billingPhoneLocator = By.id("wpsc_checkout_form_18");
	
	//shipping details locators - to do
	
	private static By purchaseButtonLocator = By.xpath("//input[@value='Purchase']");

	public CalculateShippingPricePage(WebDriver driver) {
		super(driver);

	}
	
	public String calculateShippingPrice(String country) {
		WebElement dropdown = driver.findElement(shippingCountrDropdownLocator);
		Select cuntryDropdown = new Select(dropdown);
		cuntryDropdown.selectByVisibleText(country);
		
		WebElement calculate = driver.findElement(calculateLocator);
		calculate.click();
		
		waitUntilItemsDisplayed(totalShippingLocator);
		
		WebElement totalShipping = driver.findElement(totalShippingLocator);
		String shippingAmount = totalShipping.getText();
				
		return shippingAmount;
	}
	
	public void provideEmail(String email) {
		WebElement emailField = driver.findElement(emailLocator);
//		emailField.clear();
		emailField.sendKeys(email);
		
	}
	
	public void provideBillingName(String name) {
		WebElement billingNameField = driver.findElement(billingNameLocator);
		billingNameField.clear();
		billingNameField.sendKeys(name);
		
	}
	
	public void provideBillingLastName(String lastName) {
		WebElement billingLastNameField = driver.findElement(billingLastNameLocator);
		billingLastNameField.clear();
		billingLastNameField.sendKeys(lastName);
		
	}
	
	public void provideBillingAddressDetails(String address) {
		WebElement addressField = driver.findElement(billingAddressLocator);
		addressField.clear();
		addressField.sendKeys(address);
		
	}
	
	public void provideBillingCity(String city) {
		WebElement cityField = driver.findElement(billingCityLocator);
		cityField.clear();
		cityField.sendKeys(city);
		
	}
	
	public void selectBillingCountry(String country) {
		WebElement dropdown = driver.findElement(billingCountryLocator);
		Select cuntryDropdown = new Select(dropdown);
		cuntryDropdown.selectByVisibleText(country);
	}
	
	public void provideBillingPhone(String phone) {
		WebElement phoneField = driver.findElement(billingPhoneLocator);
		phoneField.clear();
		phoneField.sendKeys(phone);
		
	}
	
	public TransactionResultsPage finalizeShipping() {
		WebElement purchaseButton = driver.findElement(purchaseButtonLocator);
		purchaseButton.click();
		
		waitUntilItemsDisplayed(By.xpath("//div[@class='wpsc-transaction-results-wrap']"));
		
		return new TransactionResultsPage(driver);
		
	}

}
