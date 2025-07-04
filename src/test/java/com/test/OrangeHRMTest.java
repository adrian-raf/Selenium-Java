package com.test;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMTest {
//	public static ChromeDriver;
	public static RemoteWebDriver driver;
	public static WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void loginToApplication() {

		driver.get("https://opensource-demo.orangehrmlive.com/");

		WebElement inputName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		inputName.sendKeys("Admin");

		WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		inputPassword.sendKeys("admin123");

		WebElement btnSubmit = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Login'])[1]")));
		btnSubmit.click();

	}

	@Test(priority = 2)
	public void searchAdmin() throws Exception {
		WebElement leaveMenu = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Admin\"]//parent::a")));
		leaveMenu.click();
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void logout() {
		WebElement userProfile = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='oxd-userdropdown-tab']")));
		userProfile.click();

		WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
		logoutBtn.click();

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
