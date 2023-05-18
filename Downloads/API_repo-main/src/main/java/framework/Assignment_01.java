package framework;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_01 {

	private WebDriver driver;
	
	@BeforeTest
	public void before() {
		WebDriverManager.chromedriver().setup();
		
	}
	
	@Test
	public void test() throws IOException {
		LoginPage login = new LoginPage(driver);
		login.TestLogin();
		
	}
	
	@AfterTest
	public void after() throws InterruptedException {
		Thread.sleep(2500);
		
	}
}
