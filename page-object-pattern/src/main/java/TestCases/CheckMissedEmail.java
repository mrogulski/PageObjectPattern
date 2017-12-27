package TestCases;

import org.junit.Assert;
import org.junit.Test;

import Pages.MainPage;
import Pages.RegisterPage;

public class CheckMissedEmail extends TestCase{
	
	private static String username = "thatUserNameNotExistInDatabaseForSure";
	private static String email = "";
	private static String expectedErrorMessage = "ERROR: Please type your email address.";
	
	@Test
	public void checkIfMissedEmailErrorAppears(){
		
		RegisterPage registerPage = new MainPage(driver).goToLoginPage().goToRegisterPage(); 
		registerPage.register(username, email);
		
		String errorMessage = registerPage.errorMessage().getText();
		
		Assert.assertTrue("FAILED! Error message is: " + errorMessage, errorMessage.equals(expectedErrorMessage));
		
	}

}
