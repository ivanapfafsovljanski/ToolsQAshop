package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTest extends BeginningClass{
	
	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to("http://shop.demoqa.com/");
		pageHome.clickOnMyAccountTab();
	}
	@Test(priority = 1)
	public void validLogIn() {
		pageMyAccount.logInValid();
		Assert.assertEquals(pageMyAccount.assertMyAccountPageLoded(), reader.taxtualValue("login", 1, 0));
		
	}
	@Test(priority = 2)
	public void goToOrders() throws InterruptedException {
		pageMyAccount.clickOrdersLink();
		Assert.assertTrue(pageMyAccount.assertOrdersPage());
	}
	@Test(priority = 3)
	public void clickBrowseProductBtn() {
		pageMyAccount.clickOrdersLink();
		pageMyAccount.goToProductPage();
		
	}
	

}
