package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import tests.ExcelReader;

public class ProductsPage {
	WebDriver driver;
	JavascriptExecutor js;
	ExcelReader reader;
	
	public ProductsPage(WebDriver driver, JavascriptExecutor js, ExcelReader reader) {
		this.driver = driver;
		this.js = js;
		this.reader = reader;
	}
	
	

}
