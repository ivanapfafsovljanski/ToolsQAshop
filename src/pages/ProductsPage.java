package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import tests.ExcelReader;

public class ProductsPage {
	WebDriver driver;
	JavascriptExecutor js;
	ExcelReader reader;
	List<WebElement> products;
	WebElement firstDress;
	String titleOfFirstitem;
	String titleOfSelectedItem;
	WebElement addToCardBtn;
	Select choosingColor;
	Select choosingSize;
	WebElement quantityPlus;
	WebElement quantityMinus;
	WebElement quantity;
	WebElement cardIcon;
	
	public ProductsPage(WebDriver driver, JavascriptExecutor js, ExcelReader reader) {
		this.driver = driver;
		this.js = js;
		this.reader = reader;
	}
	
	public String chooseingProduct() {
		firstDress = driver.findElement(By.className("post-1162"));
		titleOfFirstitem = firstDress.findElement(By.cssSelector(".noo-product-inner>h3")).getText();
		js.executeScript("window.scrollBy(0,200)");
		firstDress.click();
		return titleOfFirstitem;
		
		//Assert.assertEquals(titleOfFirstitem.toLowerCase(), titleOfSelectedItem.toLowerCase());
	}
	public String selectedItem() {
		titleOfSelectedItem = driver.findElement(By.className("page-title")).getText();
		return titleOfSelectedItem;
	}
	
	public void addingItemToCard() {
		addToCardBtn = driver.findElement(By.cssSelector(".single_add_to_cart_button.button.alt"));
		js.executeScript("arguments[0].scrollIntoView();", addToCardBtn);
		//choosingColor = driver.findElement(By.id("pa_color"));
		choosingColor = new Select(driver.findElement(By.id("pa_color")));
		choosingColor.selectByIndex(2);
		//i'm going to need values of those elements
		choosingSize = new Select(driver.findElement(By.id("pa_size")));
		choosingSize.selectByIndex(2);
		quantityPlus = driver.findElement(By.className("qty-increase"));
		quantityPlus.click();
		quantity = driver.findElement(By.name("quantity"));
		Assert.assertEquals(quantity.getAttribute("value"), "2");
		quantityMinus = driver.findElement(By.className("qty-decrease"));
		quantityMinus.click();
		addToCardBtn.click();
		goToCardPage();
		//Make elements to do validation - item, color, size - 
		
	}
	public void goToCardPage() {
		cardIcon = driver.findElement(By.className("cart-item"));
		js.executeScript("arguments[0].scrollIntoView();", cardIcon);
		cardIcon.click();
	}
	
	
	
	
	

}
