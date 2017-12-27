package TestCases;

import org.junit.Assert;
import org.junit.Test;

import Pages.MainPage;
import Pages.RegisterPage;

public class CheckInvalidRegistration extends TestCase {
	
	private static String username = "";
	private static String email = "";
	private static String expectedErrorMessage = "ERROR";
	
	@Test
	public void checkIfErrorAppears(){
		
		RegisterPage registerPage = new MainPage(driver).goToLoginPage().goToRegisterPage(); 
		registerPage.register(username, email);
		
		String errorMessage = registerPage.errorMessage().getText();
		
		Assert.assertTrue("FAILED! Error message is: " + errorMessage, errorMessage.contains(expectedErrorMessage));
		
	}

}
