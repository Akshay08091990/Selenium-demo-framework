package com.ak.pageElements;

import org.openqa.selenium.By;

public class RegisterPageElements {
	public static By email = By.id("exampleInputEmail1");
	public static By password = By.id("exampleInputPassword1");
	public static By checkBox = By.xpath("//input[@type='checkbox']");
	public static By submit = By.xpath("//*[@type='button' and contains(.,'Submit')]");
	public static By dropdown = By.id("country");
	public static By imageField = By.id("exampleInputFile");
	public static By modalSave = By.xpath("//*[@type='button' and contains(.,'Save')]");

}
