package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends Page {
		
	private final String url = "http://store.demoqa.com/";
	private final By categoryButtonLocator = By.xpath("//*[contains(text(), 'Product Category')]");
	private final By accountButtonSelector = By.cssSelector("#account");

	

	public MainPage(WebDriver driver) {
		super(driver);
		driver.get(url);
	}
	
	
	
	public CategoryPage goToCategory(String category) {
		//find product category button
		WebElement productCategoryButton =  driver.findElement(categoryButtonLocator);
		//click on category button in order to expand dropdown list
		Actions action = new Actions(driver);
		action.moveToElement(productCategoryButton).click().perform();
		//find and click on category
		WebElement categoryPage =  driver.findElement(By.xpath("//*[contains(text(), '" + category + "')]"));
		action.moveToElement(categoryPage).click().perform();
		
		return new CategoryPage(driver);
		
	}
	
	public LoginPage goToLoginPage() {
		
		driver.findElement(accountButtonSelector).click();		
		return new LoginPage(driver);
		
	}
	




}
