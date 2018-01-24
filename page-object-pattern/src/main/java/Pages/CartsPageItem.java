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
	
	
	public void updateQuantity(String quantity){
		WebElement quantityInput = driver.findElement(By.xpath("//a[text()=" + "'" + item + "'" + "]/ancestor::tr/td[3]/form/input[@name='quantity']"));
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
		WebElement updateQuantityButton = driver.findElement(By.xpath("//a[text()=" + "'" + item + "'" + "]/ancestor::tr/td[3]/form/input[@name='submit']"));
		updateQuantityButton.click();
		waitUntilItemsDisplayed(By.className("yourtotal"));
		
		
	}
	
	public WebElement price() {
		WebElement price = driver.findElement(By.xpath("//a[text()=" + "'" + item + "'" + "]/ancestor::tr/td[4]/span"));
		return price;
	}
	
	public WebElement totalPrice() {
		WebElement totalPrice = driver.findElement(By.xpath("//a[text()=" + "'" + item + "'" + "]/ancestor::tr/td[5]/span"));
		return totalPrice;
	}
	
	public void removeItem() {
		WebElement removeButton =  driver.findElement(By.xpath("//a[text()=" + "'" + item + "'" + "]/ancestor::tr/td[6]/form/input[@value='Remove']"));
		removeButton.click();
		waitUntilItemsDisplayed(By.xpath("//div[@class='entry-content']"));

	}

}
