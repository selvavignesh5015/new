package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class demo extends Page_object_model {

	public static void fname(String Firstname) {
		WebElement Field1 = driver.findElement(By.xpath("//input[@name='firstName']"));
		Field1.sendKeys(Firstname);
	}

	public static void lname(String Lastname) {
		WebElement Field2 = driver.findElement(By.xpath("//input[@name='lastName']"));
		Field2.sendKeys(Lastname);
	}

	public static void phone(String Phone) {
		WebElement phoneField = driver.findElement(By.xpath("//input[@name='phone']"));
		phoneField.sendKeys(Phone);
	}

	public static void email(String Email) {
		WebElement emailField = driver.findElement(By.xpath("//input[@name='userName']"));
		emailField.sendKeys(Email);
	}

	public static void addressField(String Address) {
		WebElement addressField = driver.findElement(By.xpath("//input[@name='address1']"));
		addressField.sendKeys(Address);
	}

	public static void city(String City) {
		WebElement cityField = driver.findElement(By.xpath("//input[@name='city']"));
		cityField.sendKeys(City);
	}

	public static void state(String State) {
		WebElement stateField = driver.findElement(By.xpath("//input[@name='state']"));
		stateField.sendKeys(State);
	}

	public static void postal(String Postal) {
		WebElement postalCodeField = driver.findElement(By.xpath("//input[@name='postalCode']"));
		postalCodeField.sendKeys(Postal);
	}

	public static void country(String Country) {
		WebElement countryField = driver.findElement(By.xpath("//select[@name='country']"));

		Select countryFieldMenu = new Select(countryField);

		countryFieldMenu.selectByVisibleText(Country);
	}

	public static void uname(String Username) {
		WebElement userNameField = driver.findElement(By.xpath("//input[@id='email']"));
		userNameField.sendKeys(Username);
	}

	public static void pass(String Password) {

		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		passwordField.sendKeys(Password);
	}

	public static void confirm(String Confirmpassowrd) {
		WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
		confirmPasswordField.sendKeys(Confirmpassowrd);
	}

	public static void submit() {
		WebElement submitBtn = driver.findElement(By.xpath("//input[@name='submit']"));
		submitBtn.click();
		System.out.println("hello");
	}
}
