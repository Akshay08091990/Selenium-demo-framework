package com.ak.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ak.pages.RegisterPage;

public class RegisterTest extends TestBase {

	@Test
	public void verifyHomePage() throws InterruptedException, IOException {

		RegisterPage register = new RegisterPage(driver);
		register.verifyForm();
	}
}
