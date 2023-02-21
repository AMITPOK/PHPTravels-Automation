package com.qa.PHPTravels.PageLayer;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.PHPTravels.BaseLayer.BasePage;

public class HomePage extends BasePage {

	WebDriver driver;
	By loginButton = By.linkText("Login");
	By signUpButton = By.linkText("Sign Up");
	By pageHeader = By.xpath("//h1[@class='mb-0']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isLoginButtonPresent() {
		return driver.findElement(loginButton).isDisplayed();
	}

	public boolean isSignUpButtonPresent() {
		return driver.findElement(signUpButton).isDisplayed();
	}

	public String pageheader() {
		return driver.findElement(pageHeader).getText();
	}
	
	public LoginPage doClickLogin() {
		driver.findElement(loginButton).click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.toString());
		Iterator<String> it = windows.iterator();
		it.next();
		driver.switchTo().window(it.next());
		return new LoginPage(driver);
	}
}
