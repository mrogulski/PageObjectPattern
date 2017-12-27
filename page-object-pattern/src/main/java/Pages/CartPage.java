package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends Page {

	private static By continueButtonSelector = By.xpath("//*[contains(text(), 'Continue')]");
	
	public CartPage(WebDriver driver) {
		super(driver);
	}

	public CalculateShippingPricePage goToCalculateShippingPricePage() {
		
		driver.findElement(continueButtonSelector).click();
		return new CalculateShippingPricePage(driver);
	}
	//method takes index of needed input and returns input field element
	public WebElement quantityInputField(int index) {
		//finds element by provided index and return it
		By quantityInputSelector = By.cssSelector(".wpsc_product_quantity_"+ index + " > form:nth-child(1) > input:nth-child(1)");
		WebElement quantityInput = driver.findElement(quantityInputSelector);
		return quantityInput;
		
	}



}
