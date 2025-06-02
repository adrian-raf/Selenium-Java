package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMTestSaucelab {
//	public static ChromeDriver;
	public static RemoteWebDriver driver;
	public static WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException {
//		driver = new ChromeDriver();
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("latest");

		Properties props = new Properties();
		try (FileInputStream fis = new FileInputStream("path/to/config.properties")) {
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", props.getProperty("usernameSaucelab"));
		sauceOptions.put("accessKey", props.getProperty("accessKey"));
		sauceOptions.put("build", props.getProperty("build"));
		sauceOptions.put("name", "Sanity Test");
		browserOptions.setCapability("sauce:options", sauceOptions);

		// start the session
		URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
		driver = new RemoteWebDriver(url, browserOptions);

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
