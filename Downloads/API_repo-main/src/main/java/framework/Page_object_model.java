package framework;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page_object_model {

	public static String URL = "https://demo.guru99.com/test/newtours/register.php";
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void main(String[] args) throws IOException {

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

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);

		demo.fname(firstName);
		demo.lname(lastName);
		demo.email(email);
		demo.addressField(address);
		demo.city(city);
		demo.state(state);
		demo.postal(postalCode);
		demo.country(country);
		demo.uname(userName);
		demo.pass(password);
		demo.confirm(confirmPassword);
		demo.submit();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Dear')]")));
		String res = driver.findElement(By.xpath("//*[contains(text(),'Dear')]")).getText();
		assertEquals(res, "Dear " + firstName + " " + lastName + ",");

		
		driver.quit();
	}

	public static String getDataFromProperty(int row, int cell) throws IOException {

		String pathOfFile = "/Users/TA20463982/Tamilworkspace/restproject/src/main/java/utilities/data.xlsx";
		File file = new File(pathOfFile);
		FileInputStream fis = new FileInputStream(file);

		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		return sheet.getRow(row).getCell(cell).getStringCellValue();

	}
}
