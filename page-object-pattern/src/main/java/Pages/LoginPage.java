package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {
	private static By usernameLocator = By.cssSelector("#log");
	private static By passwordLocator = By.cssSelector("#pwd");
	private static By loginButtonLocator = By.cssSelector("#login");
	private static By errorLoginMessageLocator = By.cssSelector("p.response");
	private static By registerLinkLocator = By.xpath("//*[contains(text(), 'Register')]");

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void logIn(String username, String password) {
		driver.findElement(usernameLocator).sendKeys(username);
		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(loginButtonLocator).click();
	}
	
	public WebElement errorLoginResponse() {
		
		waitUntilItemsDisplayed(errorLoginMessageLocator);
		
		WebElement errorLoginResponse = driver.findElement(errorLoginMessageLocator);
		return errorLoginResponse;
	}
	
	public RegisterPage goToRegisterPage() {
		
		driver.findElement(registerLinkLocator).click();		
		return new RegisterPage(driver);
	}



}
