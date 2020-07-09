package com.ak.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ak.pageElements.MultipleWindowPageElements;

public class MultipleWindowPage extends Base {

	public MultipleWindowPage(WebDriver driver) {
		this.driver = driver;
		this.explicitwait = new WebDriverWait(driver, 30);
	}

	public void verifyMultipleWindows() {
		System.out.println("Title of page is: " + driver.getTitle());
		waitForElement(MultipleWindowPageElements.viewDetails);
		String ParentWindow = driver.getWindowHandle();
		click(MultipleWindowPageElements.viewDetails);
		Set<String> windowHandle = driver.getWindowHandles();

		for (String handle : windowHandle) {
			String childWindow = handle;
			if (!(ParentWindow.equals(childWindow))) {
				driver.switchTo().window(childWindow);
				System.out.println("Title of page is: " + driver.getTitle());
				/* perform operation here on new window. */
				driver.close();
			}
		}
		/* Switch back to Parent window. */
		driver.switchTo().window(ParentWindow);
		waitForElement(MultipleWindowPageElements.viewDetails);

	}
}
