package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.ExcelReader;

public class MyAccountPage {
	WebDriver driver;
	ExcelReader reader;
	JavascriptExecutor js;
	WebElement userNameFeild;
	WebElement psw;
	WebElement logInBtn;
	WebElement usersNameDesplayed;
	WebElement ordersLink;
	WebElement ordersMesage;
	WebElement browseProductsBtn;
	
	public MyAccountPage(WebDriver driver, ExcelReader reader, JavascriptExecutor js) {
		this.driver = driver;
		this.reader = reader;
		this.js = js;
	}

	public void logInValid() {
		logInBtn = driver.findElement(By.name("login"));
		js.executeScript("window.scrollBy(0,150)");
		userNameFeild = driver.findElement(By.id("username"));
		userNameFeild.clear();
		userNameFeild.sendKeys(reader.taxtualValue("login", 1, 0));
		psw = driver.findElement(By.id("password"));
		psw.clear();
		psw.sendKeys(reader.taxtualValue("login", 3, 0));
		logInBtn.click();
		
	}
	public String assertMyAccountPageLoded() {
		usersNameDesplayed = driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/p[1]/strong[1]"));
		return usersNameDesplayed.getText();
	}
	public void clickOrdersLink() {
		ordersLink = driver.findElement(By.linkText("Orders"));
		ordersLink.click();
	}
	
	public boolean assertOrdersPage() throws InterruptedException {
		Thread.sleep(2000);
		ordersMesage = driver.findElement(By.className("woocommerce-Message--info"));
		String txt = ordersMesage.getText();
		return txt.contains("order");	
	}
	
	public void goToProductPage() {
		browseProductsBtn = driver.findElement(By.className("woocommerce-Button"));
		browseProductsBtn.click();
	}
}
