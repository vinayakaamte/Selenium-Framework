package com.eBanking.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.BaseDriver;
import com.eBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 {
	LoginPage lb;
	String expetedTitle = "Guru99 Bank Manager HomePage";

	@Parameters("browser")
	@BeforeClass
	public void init(String browser) {

		lb = new LoginPage(BaseDriver.driver, browser);
	}

	@BeforeTest
	public void loadURL() {

	}

	@Test
	public void loginTest() {
		lb.launchURL();
		lb.setUserName(lb.userName);
		BaseDriver.logger.info("Entering done in User Name Text Box");
		lb.setPassword(lb.password);
		BaseDriver.logger.info("Entering done in password Test Box");
		lb.clickLogin();
		BaseDriver.logger.info("Clicking on login button is done");
		lb.verifyEqual(lb.getTitle(), expetedTitle, "Titel of page is not mattching");
	}

	@AfterClass
	public void close() {
		lb.quitBrowser();
	}
}
