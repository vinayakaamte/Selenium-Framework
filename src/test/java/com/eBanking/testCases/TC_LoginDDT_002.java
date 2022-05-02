package com.eBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.BaseDriver;
import com.eBanking.pageObjects.LoginPage;
import com.eBanking.utilities.XLUtils;

public class TC_LoginDDT_002 {
	LoginPage lp;
	String excelPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "java" + File.separator + "com" + File.separator + "eBanking" + File.separator
			+ "testData" + File.separator + "LoginData.xlsx";

	@Parameters("browser")
	@BeforeClass
	public void init(String browser) {
		lp = new LoginPage(BaseDriver.driver,browser);
	}

	
	@SuppressWarnings("unused")
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		lp.launchURL();
		lp.setUserName(user);
		BaseDriver.logger.info("Entering done in User Name Text Box");
		lp.setPassword(pwd);
		BaseDriver.logger.info("Entering done in password Test Box");
		lp.clickLogin();
		Thread.sleep(3000);
		if(true) {
			lp.clickLogOut();
			Thread.sleep(3000);
			lp.verifyFalse(lp.acceptAlert(), "Logout is success");
		}
		
		else {
			BaseDriver.logger.info("Clicking on login button is done");
			lp.verifyTrue(lp.acceptAlert(), "Invalid Login");
		}
		
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		int rowCount = XLUtils.getRowCount(excelPath, "Sheet1");
		int colCount = XLUtils.getCellCount(excelPath, "Sheet1", 1);

		String loginData[][] = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(excelPath, "Sheet1", i, j);
			}
		}

		return loginData;
	}

	@AfterClass
	public void close() {
		lp.quitBrowser();
	}

}
