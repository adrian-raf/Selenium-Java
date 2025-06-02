package com.orange.hrm.test;

import org.testng.annotations.Test;

import com.orange.hrm.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void loginWithValidData() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication("Admin", "admin123");

	}
}
