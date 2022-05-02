package com.eBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonOperation extends BaseDriver{
	public By by;

	public CommonOperation(WebDriver driver,String br) {
		super(br);	
	}

	// This function is use to locate element
	public WebElement getElement(String locator) {
		String[] sp = locator.split("=");
		String preFix = sp[0];
		String postFix = sp[1];

		switch (preFix) {
		case "id":
			by = By.id(postFix);
			break;
		case "className":
			by = By.className(postFix);
			break;
		case "name":
			by = By.name(postFix);
			break;
		case "tagName":
			by = By.tagName(postFix);
			break;
		case "linkText":
			by = By.linkText(postFix);
			break;
		case "partialLinkText":
			by = By.partialLinkText(postFix);
			break;
		case "xpath":
			by = By.xpath(postFix);
			break;
		case "cssSelector":
			by = By.cssSelector(postFix);
			break;
		default:
			System.out.println("Invalid option to locate xpath.");
		}
		return (driver.findElement(by));
	}	
}
