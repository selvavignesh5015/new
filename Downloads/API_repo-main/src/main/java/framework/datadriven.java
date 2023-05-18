package framework;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datadriven {

	public static WebDriver driver;

	public static WebDriverWait wait;

	public static String URL = "https://demo.guru99.com/test/newtours/register.php";

	public static void main(String[] args) throws IOException, InterruptedException {

//      Values to be passed

		String firstName = getDataFromProperty(0, 1);

		String lastName = getDataFromProperty(1, 1);

		String phone = (String) getDataFromProperty(2, 1);

		String email = getDataFromProperty(3, 1);

		String address = getDataFromProperty(4, 1);

		String city = getDataFromProperty(5, 1);

		String state = getDataFromProperty(6, 1);

		String postalCode = (String) getDataFromProperty(7, 1);

		String country = getDataFromProperty(8, 1);

		String userName = getDataFromProperty(9, 1);

		String password = getDataFromProperty(10, 1);

		String confirmPassword = getDataFromProperty(11, 1);

//      Browser actions
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get(URL);

		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstName']"));

		WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastName']"));

		WebElement phoneField = driver.findElement(By.xpath("//input[@name='phone']"));

		WebElement emailField = driver.findElement(By.xpath("//input[@name='userName']"));

		WebElement addressField = driver.findElement(By.xpath("//input[@name='address1']"));

		WebElement cityField = driver.findElement(By.xpath("//input[@name='city']"));

		WebElement stateField = driver.findElement(By.xpath("//input[@name='state']"));

		WebElement postalCodeField = driver.findElement(By.xpath("//input[@name='postalCode']"));

		WebElement countryField = driver.findElement(By.xpath("//select[@name='country']"));

		WebElement userNameField = driver.findElement(By.xpath("//input[@id='email']"));

		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));

		WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@name='confirmPassword']"));

		WebElement submitBtn = driver.findElement(By.xpath("//input[@name='submit']"));

//      Insert Values

		firstNameField.sendKeys(firstName);

		lastNameField.sendKeys(lastName);

		phoneField.sendKeys(phone);

		emailField.sendKeys(email);

		addressField.sendKeys(address);

		cityField.sendKeys(city);

		stateField.sendKeys(state);

		postalCodeField.sendKeys(postalCode);

		Select countryFieldMenu = new Select(countryField);

		countryFieldMenu.selectByVisibleText(country);

		userNameField.sendKeys(userName);

		passwordField.sendKeys(password);

		confirmPasswordField.sendKeys(confirmPassword);

		submitBtn.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Dear')]")));

		String res = driver.findElement(By.xpath("//*[contains(text(),'Dear')]")).getText();

		assertEquals(res, "Dear " + firstName + " " + lastName + ",");

//      Quit browser

		Thread.sleep(5000);

		driver.quit();

	}

//   Reads data from file and returns it

	public static String getDataFromProperty(int row, int cell) throws IOException {

//      Get the file

		String pathOfFile = "/Users/TA20463982/Tamilworkspace/restproject/src/main/java/utilities/data.xlsx";

		File file = new File(pathOfFile);

		FileInputStream fis = new FileInputStream(file);

//      Store it in XSSFWorkBook

		@SuppressWarnings("resource")

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Sheet1");

//      Get the value from the sheet

		return sheet.getRow(row).getCell(cell).getStringCellValue();

	}

}
