package com.ak.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ak.pageElements.IframePageElements;

public class IframePage extends Base {

	public IframePage(WebDriver driver) {
		this.driver = driver;
		this.explicitwait = new WebDriverWait(driver, 30);
	}

	public void enterDetails() throws InterruptedException {
		waitForElement(IframePageElements.hamburgerMenu);
		click(IframePageElements.hamburgerMenu);
		driver.switchTo().frame("frame1"); /*
											 * iframe can be identify via frame
											 * index, frame id and webElement.
											 */
		enterText(IframePageElements.fname, "Jane");
		enterText(IframePageElements.lname, "Doe");
		click(IframePageElements.submit);
		scroll(0, 250);
		waitForElement(IframePageElements.successMsg);
		Assert.assertTrue((getText(IframePageElements.successMsg).trim()).contains("Successfully Register."));
		driver.switchTo()
				.defaultContent(); /* Switch back from iframe to main window. */
		waitForElement(IframePageElements.hamburgerMenu);
		click(IframePageElements.hamburgerMenu);

	}

}
