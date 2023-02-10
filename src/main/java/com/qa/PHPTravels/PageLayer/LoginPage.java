package com.qa.PHPTravels.PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.PHPTravels.util.ElementUtil;

public class LoginPage {

	WebDriver driver;
	ElementUtil util;
	By loginPageHeader = By.xpath("//h6[@class='h3']");
	By email = By.xpath("//input[@id='inputEmail']");
	By password = By.id("inputPassword");
	By captcha = By.xpath("//div[@class='recaptcha-checkbox-border']");
	By loginButton = By.xpath("//button[@id='login']");
	By iframeForCaptcha = By.xpath("//iframe[contains(@name,'a-')]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}
	
	public String getLoginPageTitle() {
		return util.doGetPageTitle();
	}

	public String getLoginPageHeader() {
		return util.doGetText(loginPageHeader);
	}

	public void doLogin() throws InterruptedException {
		util.doSendKeys(email, "amitpokharel0923@gmail.com");
		util.doSendKeys(password, "Welcome1#");
		driver.switchTo().frame(util.getWebElement(iframeForCaptcha));
		util.doClick(captcha);
		driver.switchTo().defaultContent();
		Thread.sleep(500);
		util.doClick(loginButton);
	}

}
