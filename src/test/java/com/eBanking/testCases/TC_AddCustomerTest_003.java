package com.eBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.AddCustomerPage;
import com.eBanking.pageObjects.BaseDriver;
import com.eBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 {
	LoginPage lb;
	AddCustomerPage acp;

	@Parameters("browser")
	@BeforeClass
	public void init(String browser) {
		lb = new LoginPage(BaseDriver.driver, browser);
		acp = new AddCustomerPage(BaseDriver.driver, browser);
	}

	@Test
	public void addNewCustomerTest() throws InterruptedException, IOException {
		lb.launchURL();
		lb.setUserName(lb.userName);
		BaseDriver.logger.info("Entering done in User Name Text Box");
		lb.setPassword(lb.password);
		BaseDriver.logger.info("Entering done in password Test Box");
		lb.clickLogin();
		BaseDriver.logger.info("Clicking on login button is done");
		Thread.sleep(3000);

		acp.clickAddNewCustomer();
		BaseDriver.logger.info("Providing customer details....");
		acp.custName("Vinayak");
		acp.custGender("f");
		acp.custDob("25", "05", "1992");
		Thread.sleep(3000);
		acp.custAddress("INDIA");
		acp.custcity("Pune");
		acp.custstate("MH");
		acp.custpinno("411058");
		acp.custtelephoneno("1234567890");

		String email = RandomStringUtils.randomAlphanumeric(8) + "@gmail.com";
		acp.custemailid(email);
		acp.custpassword("abcdef");
		acp.custsubmit();
		Thread.sleep(3000);
		BaseDriver.logger.info("Validation Started......");

		boolean res = BaseDriver.driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			lb.verifyTrue(true);
			BaseDriver.logger.info("Test case passed....");
		} else {
			BaseDriver.logger.info("Test case failed....");
			lb.captureScreenshot(BaseDriver.driver, "addNewCustomerTest");
			lb.verifyTrue(false);
		}
	}

	@AfterClass
	public void close() {
		lb.quitBrowser();
	}
}
