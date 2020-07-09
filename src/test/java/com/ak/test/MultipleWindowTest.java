package com.ak.test;

import org.testng.annotations.Test;

import com.ak.pages.MultipleWindowPage;

public class MultipleWindowTest extends TestBase {

	@Test
	public void verifyMultipleWindow() {

		MultipleWindowPage window = new MultipleWindowPage(driver);
		window.verifyMultipleWindows();

	}

}
