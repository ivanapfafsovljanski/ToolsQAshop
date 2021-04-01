package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BeginningClass{
	
	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to("http://shop.demoqa.com/");
	}

	@Test
	public void addToWishlistFromHomepage() {
		pageHome.addToWishlist();
		//za assert - na wishlistPage Proveriti da li je dodat
	}
	
	//@Test
	public void goToMyAccount() {
		pageHome.clickOnMyAccountTab();
	}
	
}

