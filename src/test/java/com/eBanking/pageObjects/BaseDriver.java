package com.eBanking.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.eBanking.utilities.ReadConfig;

public class BaseDriver {

	ReadConfig redconfig = new ReadConfig();

	public String baseURL = redconfig.getApplicationURL();
	public String userName = redconfig.getUserName();
	public String password = redconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	public BaseDriver(String br) {
		driver=initDriver(br);
	}

	public WebDriver initDriver(String br) {
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		switch (br) {
		case "chrome":
			launchChrome();
			break;
		case "firefox":
			launchFireFox();
			break;
		case "IE":
			launchIE();
			break;
		default:
			logger.info("Invalid browser");
			break;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	private void launchChrome() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "Drivers" + File.separator + "chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("Initlizing Chrome Driver");
		driver.manage().window().maximize();
		logger.info("Maximizing Chrome browser");
	}

	private void launchFireFox() {
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + File.separator + "Drivers" + File.separator + "geckodriver.exe");
		driver = new FirefoxDriver();
		logger.info("Initlizing FireFox Driver");
		driver.manage().window().maximize();
		logger.info("Maximizing FireFox browser");
	}

	private void launchIE() {

		System.setProperty("webdriver.ie.driver",
				System.getProperty("user.dir") + File.separator + "Drivers" + File.separator + "IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		logger.info("Initlizing Internet Explorer Driver");
		driver.manage().window().maximize();
		logger.info("Maximizing Internet Explorer browser");
	}

	public void quitBrowser() {
		logger.info("Closing browser");
		driver.quit();
	}

	public void launchURL() {
		logger.info("Openning URL");
		driver.get(baseURL);
	}

	public String getTitle() {
		logger.info("Feattching titel of page");
		return driver.getTitle();
	}

	public void verifyEqual(String actual, String expeted) {
		logger.info("Performaing Assert Equal");
		Assert.assertEquals(actual, expeted);
	}

	public void verifyEqual(String actual, String expeted, String msg) {
		logger.info("Performaing Assert Equal with message");
		Assert.assertEquals(actual, expeted, msg);
	}

	public void verifyTrue(boolean condition) {
		logger.info("Performaing Assert True");
		Assert.assertTrue(condition);
	}

	public void verifyTrue(boolean condition, String msg) {
		logger.info("Performaing Assert True with message");
		Assert.assertTrue(condition, msg);
	}

	public void verifyFalse(boolean condition) {
		logger.info("Performaing Assert False");
		Assert.assertFalse(condition);
	}

	public void verifyFalse(boolean condition, String msg) {
		logger.info("Performaing Assert False with message");
		Assert.assertFalse(condition, msg);
	}

	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(
				System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + tname + ".png");
		FileUtils.copyFile(source, target);
		logger.info("Screenshot taken");
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public boolean acceptAlert() {
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			return false;
		} else
			return true;
	}
}
