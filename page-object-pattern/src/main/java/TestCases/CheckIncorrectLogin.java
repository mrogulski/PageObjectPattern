package TestCases;

import org.junit.Assert;
import org.junit.Test;

import Pages.LoginPage;
import Pages.MainPage;

public class CheckIncorrectLogin extends TestCase {
	
	private static String expectedResponse = "ERROR";
	private static String username = "user";
	private static String password = "pswd";
	

	@Test()
	public void checkHeaderTest(){
		
		LoginPage loginPage = new MainPage(driver).goToLoginPage();
		loginPage.logIn(username, password);
		
		String pageHeader = loginPage.errorLoginResponse().getText();
		
		Assert.assertTrue("FAILED! Error response is:  " + pageHeader, pageHeader.contains(expectedResponse));
	}

}
