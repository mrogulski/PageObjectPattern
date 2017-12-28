package SeleniumGrid;

import org.junit.Assert;
import org.junit.Test;

import Pages.CategoryPage;
import Pages.MainPage;

public class SGFirstTC extends TestCaseGrid {
	
	private static String expectedHeader = "Accessoriessss";
	

	@Test
	public void checkHeaderTest(){
		
		CategoryPage categoryPage = new MainPage(driver).goToCategory("Accessories");
		
		String pageHeader = categoryPage.getHeader().getText();
		
		Assert.assertTrue("FAILED! Section header is:  " + pageHeader, pageHeader.equals(expectedHeader));
	}

}
