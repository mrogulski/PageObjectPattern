package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCaseGrid {
	
	protected WebDriver driver;
	private DesiredCapabilities capabilities;
	private String seleniumHub = "http://xxx.xxx.x.xxx:4444/wd/hub";
	
	@Before
	public void setUp() throws MalformedURLException {
// simple way
//		DesiredCapabilities capabilities =  DesiredCapabilities.firefox();
		capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		capabilities.setVersion("");
		capabilities.setPlatform(Platform.valueOf("WINDOWS"));
		driver = new RemoteWebDriver(new URL(seleniumHub), capabilities);
		driver.manage().window().maximize();
	
	}
	
	@After
	public void cleanUp() {
		driver.quit();
	}
	
}
