package com.qa.PHPTravels.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public WebElement getWebElement(By locator) {
		WebElement element = null;
		try {
			driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("WebEslementcouldnot be created for locator " + locator);
		}

		return element;

	}

	public void doClick(By locator) {
		getWebElement(locator).click();
	}

	public String doGetText(By locator) {
		return getWebElement(locator).getText();
	}

	public void doSendKeys(By locator, String value) {
		getWebElement(locator).sendKeys(value);
	}

	/*
	 * public void doWaitForElementPresent(By locator) { wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(20));
	 * wait.until(ExpectedConditions.presenceOfElementLocated(locator)); }
	 * 
	 * public void doWaitForElementVisible(By locator) { wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(20));
	 * wait.until(ExpectedConditions.visibilityOf(getWebElement(locator))); }
	 */
	public void doClear(By locator) {
		getWebElement(locator).clear();
	}

	public Boolean doisDisplayed(By locator) {
		return getWebElement(locator).isDisplayed();
	}

	public String doGetPageTitle() {
		return driver.getTitle();
	}
	public void switchToDefaultContent(){
		driver.switchTo().defaultContent();	
	}
}
