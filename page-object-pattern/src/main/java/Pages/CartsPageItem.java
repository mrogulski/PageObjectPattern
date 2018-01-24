package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartsPageItem extends Page {
	
	 String item;

	public CartsPageItem(WebDriver driver) {
		super(driver);
	}
	
	public CartsPageItem(WebDriver driver, String item) {
		super(driver);
		this.item = item;
	}
	
	public WebElement itemsName() {
		WebElement itemsName = driver.findElement(By.xpath("//a[text()=" + "'" + item + "'" + "]/ancestor::tr/td[2]"));
		return itemsName;
	}
	

	public WebElement quantityInputField() {
		
		WebElement quantityInput = driver.findElement(By.xpath("//a[text()=" + "'" + item + "'" + "]/ancestor::tr/td[3]/form"));
		return quantityInput;
		
	}

}
