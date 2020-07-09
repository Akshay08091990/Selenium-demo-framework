package com.ak.pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Base {
	public WebDriver driver = null;
	public WebDriverWait explicitwait = null;

	public void click(By locator) {
		try {
			waitForElement(locator);
			driver.findElement(locator).click();
		} catch (Exception e) {
			Assert.assertEquals(isElementDisplayed(locator), true, "Cannot click on " + locator + "");
		}

	}

	public void waitForElement(By locator) {
		try {
			explicitwait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			Assert.assertEquals(isElementDisplayed(locator), true, "Element '" + locator + "'not located");

		}

	}

	public void enterText(By locator, String testdata) {
		try {
			waitForElement(locator);
			click(locator);
			driver.findElement(locator).clear();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(locator).sendKeys(testdata);
		} catch (Exception e) {
			Assert.assertEquals(isElementDisplayed(locator), true, "Element " + locator + " not located");
		}
	}

	public String getText(By element) {
		String text = null;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		text = driver.findElement(element).getText();
		return text;
	}

	public boolean isElementDisplayed(By locator) {
		boolean elementDisplayed = false;
		try {
			List<WebElement> w1 = driver.findElements(locator);
			if (!w1.isEmpty()) {
				elementDisplayed = true;
			}
			return elementDisplayed;
		} catch (NoSuchElementException e) {
			return elementDisplayed;
		}

	}

	public void scroll(int i, int j) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy('" + i + "','" + j + "')", "");

	}

}
