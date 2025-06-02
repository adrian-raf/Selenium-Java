package com.orange.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initiate all element can using driver by this class
	}
}
