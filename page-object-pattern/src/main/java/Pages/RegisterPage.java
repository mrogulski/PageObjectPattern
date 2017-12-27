package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Page {
	
	private static By usernameLocator = By.cssSelector("#user_login");
	private static By emailLocator = By.cssSelector("#user_email");
	private static By registerButtonLocator = By.cssSelector("#wp-submit");
	private static By errorLocator = By.id("login_error");

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	public void register(String username, String email) {
		driver.findElement(usernameLocator).sendKeys(username);
		driver.findElement(emailLocator).sendKeys(email);
		driver.findElement(registerButtonLocator).click();
	}
	
	public WebElement errorMessage() {
		waitUntilItemsDisplayed(errorLocator);
		WebElement errorMessageContainer = driver.findElement(errorLocator);
		return errorMessageContainer;
		
	}

}
