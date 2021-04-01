package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomepagePage {

	WebDriver driver;
	JavascriptExecutor js;
	WebElement dismissLink;
	List<WebElement> wishListSingleBtns;
	
	public HomepagePage(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}
	
	public void listBtnsWishlistSingle() {
		wishListSingleBtns = driver.findElements(By.className("single_add_to_wishlist"));
	}
	public void addToWishlist() {
		listBtnsWishlistSingle();
		wishListSingleBtns.get(2).click();
	}
	
	public void clickOnMyAccountTab() {
		boolean isDisplaed;
		try {
			driver.findElement(By.linkText("Dismiss"));
			isDisplaed = true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			isDisplaed = false;
		}
		if(isDisplaed) {
			driver.findElement(By.linkText("Dismiss")).click();
		}
		driver.findElement(By.linkText("My Account")).click();
	}
	
	
}
