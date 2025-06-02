package com.orange.hrm.test;

import org.testng.annotations.Test;

import com.orange.hrm.pages.HomePage;
import com.orange.hrm.pages.LoginPage;

public class HomePageTest extends BaseTest {

	@Test
	public void logout() {

		logger.info("*****Start HomePage Test*****");
		try {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginToApplication("Admin", "admin123");

			HomePage homePage = new HomePage(driver);

			logger.info("*****Click Admin Menu*****");
			homePage.clickOnAdminLink();
			homePage.logoutFromApplication();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Test Failed..");

		}
		logger.info("Finish HomePage Test");
	}

}
