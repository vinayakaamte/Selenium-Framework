package com.eBanking.pageObjects;

import org.openqa.selenium.WebDriver;

public class AddCustomerPage extends CommonOperation {

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
	String linkAddNewCustomer="linkText=New Customer";
	String txtCustomerName="name=name";
	String txtDob="id=dob";
	String txtAddress="name=addr";
	String txtCity="name=city";
	String txtState="name=state";
	String txtPinNo="name=pinno";
	String txtTelePhoneNo="name=telephoneno";
	String txtEmailId="name=emailid";
	String txtPassword="name=password";
	String btnSubmit="name=sub";
	String rGender="xpath=//input[@name='rad1' and @value='%s']";

	public AddCustomerPage(WebDriver driver, String br) {
		super(driver,br);
	}

	public void clickAddNewCustomer() {
		this.getElement(linkAddNewCustomer).click();
	}

	public void custName(String cname) {
		this.getElement(txtCustomerName).sendKeys(cname);
	}

	public void custGender(String cGender) {
		this.getElement(String.format(rGender, cGender)).click();
	}

	public void custDob(String mm, String dd, String yy) {
		this.getElement(txtDob).sendKeys(mm);
		this.getElement(txtDob).sendKeys(dd);
		this.getElement(txtDob).sendKeys(yy);
	}

	public void custAddress(String caddress) {
		this.getElement(txtAddress).sendKeys(caddress);
	}

	public void custcity(String ccity) {
		this.getElement(txtCity).sendKeys(ccity);
	}

	public void custstate(String cstate) {
		this.getElement(txtState).sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		this.getElement(txtPinNo).sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		this.getElement(txtTelePhoneNo).sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		this.getElement(txtEmailId).sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		this.getElement(txtPassword).sendKeys(cpassword);
	}

	public void custsubmit() {
		this.getElement(btnSubmit).click();
	}
}
