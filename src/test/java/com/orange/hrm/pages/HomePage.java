package com.orange.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(xpath = "//span[text()=\"Admin\"]//parent::a")
	WebElement adminLink;

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	WebElement userProfil;

	@FindBy(linkText = "Logout")
	WebElement logoutButton;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickOnAdminLink() {
		adminLink.click();
	}

	public void logoutFromApplication() {
		userProfil.click();
		logoutButton.click();
	}
}
