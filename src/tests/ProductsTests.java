package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTests extends BeginningClass{
	

	/*@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to("http://shop.demoqa.com/");
		pageHome.clickOnMyAccountTab();
		pageMyAccount.logInValid();
		pageMyAccount.clickOrdersLink();
		pageMyAccount.goToProductPage();
	}*/
	@Test (priority = 1)
	public void chooseFirstItem() {
		driver.navigate().to("http://shop.demoqa.com/");
		pageHome.clickOnMyAccountTab();
		pageMyAccount.logInValid();
		pageMyAccount.clickOrdersLink();
		pageMyAccount.goToProductPage();
		pageProducts.chooseingProduct();
		Assert.assertEquals(pageProducts.chooseingProduct(), pageProducts.selectedItem());
		//titleOfFirstitem.toLowerCase(), titleOfSelectedItem.toLowerCase()
	}
	@Test (priority = 2)
	public void addToCard() {
		pageProducts.addingItemToCard();
	}
	
}
