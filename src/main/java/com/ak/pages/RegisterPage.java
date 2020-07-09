package com.ak.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ak.pageElements.RegisterPageElements;
import com.ak.utils.PropertyReader;

public class RegisterPage extends Base {

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		this.explicitwait = new WebDriverWait(driver, 30);
	}

	public void verifyForm() throws InterruptedException, IOException {
		String dir = System.getProperty("user.dir");
		Properties testData = PropertyReader.readPropertiesFile("/testconfig.properties");
		enterText(RegisterPageElements.email, testData.getProperty("email"));
		enterText(RegisterPageElements.password, testData.getProperty("password"));
		click(RegisterPageElements.checkBox);
		Select Country = new Select(driver.findElement(RegisterPageElements.dropdown));
		Country.selectByVisibleText("India");
		enterText(RegisterPageElements.imageField, dir + "/src/test/resources/images/image1.jpg");
		click(RegisterPageElements.submit);
		waitForElement(RegisterPageElements.modalSave);
		click(RegisterPageElements.modalSave);

	}

}
