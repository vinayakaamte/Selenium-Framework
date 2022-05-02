package com.eBanking.pageObjects;

import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonOperation {

	public LoginPage(WebDriver driver, String br) {
		super(driver,br);
	}

	/*
 	To locate element path creation should be in below format:
 	 By.id() - String locator ="id=value"
 	 By.name() - String locator ="name=value"
 	 By.className() - String locator ="className=value"
 	 By.tagName() - String locator ="tagName=value"
 	 By.linkText() - String locator ="linkText=value"
 	 By.partialLinkText() - String locator ="partialLinkTest=value"
 	 By.xpath() - String locator ="xpath=value"
 	 By.cssSelector() - String locator ="cssSelector=value"
	 */
	String txtUserName="name=uid";
	String txtPassword="name=password";
	String btnLogin="name=btnLogin";
	String logoutLink="linkText=Log out";

	public void setUserName(String uname) {
		this.getElement(this.txtUserName).sendKeys(uname);
	}

	public void setPassword(String pwd) {
		this.getElement(this.txtPassword).sendKeys(pwd);
	}

	public void clickLogin() {
		this.getElement(this.btnLogin).click();
	}

	public void clickLogOut() {
		this.getElement(this.logoutLink).click();
	}
}
