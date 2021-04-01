package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import pages.HomepagePage;
import pages.MyAccountPage;
import pages.ProductsPage;

public class BeginningClass {
	WebDriver driver;
	JavascriptExecutor js;
	HomepagePage pageHome;
	ExcelReader reader;
	MyAccountPage pageMyAccount;
	ProductsPage pageProducts;

	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.js = (JavascriptExecutor) driver;
		this.pageHome = new HomepagePage(driver, js);
		this.reader = new ExcelReader("data\\testData.xlsx");
		this.pageMyAccount = new MyAccountPage(driver, reader, js);
		this.pageProducts = new ProductsPage(driver, js, reader);
		
		
		driver.manage().window().maximize();
	}
	
	//@AfterClass
	public void afterClass() {
		driver.close();
	}
}
