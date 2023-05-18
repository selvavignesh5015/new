package framework;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

	private WebDriver driver;
	private Actions actions;
	private ReadExcelFile excel;

	public String locator = "";
	public By field = By.xpath("//input[@" + locator + "]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public void initiateActions() {
		this.actions = new Actions(driver);
	}

	public void sendText(By field, String text) {
		actions.sendKeys(driver.findElement(field), text).build().perform();
		;
	}

	public void clickAction(By field) {
		driver.findElement(field).click();
	}

	public void execute(String locator, String action, String value) {
		if (action.equals("openBrowser")) {
			driver = new ChromeDriver();
			initiateActions();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		} else if (action.equals("closeBrowser")) {
			driver.quit();
		} else if (action.equals("sendURL")) {
			driver.get(value);
		} else if (action.equals("sendText")) {
			String[] arr = locator.split("=");
			field = By.xpath("//input[@" + arr[0].trim() + "='" + arr[1].trim() + "'" + "]");
			sendText(field, value);
		} else if (action.equals("click")) {
			String[] arr = locator.split("=");
			field = By.xpath("//input[@" + arr[0].trim() + "='" + arr[1].trim() + "'" + "]");
			clickAction(field);
		}
	}

	public void TestLogin() throws IOException {

		String filePath = "/Users/TA20463982/Tamilworkspace/restproject/src/main/java/utilities/KeywordDrivenExcel.xlsx";
		excel = new ReadExcelFile();
		excel.readexcelfile(filePath);
		int rowCount = excel.getRowCount(0);

		for (int i = 1; i < rowCount; i++) {
			locator = excel.getData(0, i, 1).toString();
			execute(locator, excel.getData(0, i, 2).toString(), excel.getData(0, i, 3).toString());
		}

	}

}
