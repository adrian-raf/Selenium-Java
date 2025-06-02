package com.orange.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

//	username
	@FindBy(name = "username")
	WebElement userNameTextBox;
//	password
	@FindBy(name = "password")
	WebElement passwordTextBox;

//	login button
	@FindBy(xpath = "(//button[normalize-space()='Login'])[1]")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void loginToApplication(String userName, String password) {
		userNameTextBox.sendKeys(userName);
		passwordTextBox.sendKeys(password);
		loginButton.click();

	}

}
