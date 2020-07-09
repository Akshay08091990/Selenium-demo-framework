package com.ak.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ak.pages.IframePage;
import com.ak.utils.TestListener;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Listeners({ TestListener.class })
public class IframeTest extends TestBase {
	@Test(priority = 1)
	@Severity(SeverityLevel.CRITICAL)
	@Story("verifying the iframe and enter user details")
	@Description("verifying the iframe and enter user details")
	public void enterUserDetails() throws InterruptedException {

		IframePage frame = new IframePage(driver);
		frame.enterDetails();

	}
}
