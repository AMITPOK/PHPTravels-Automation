package com.qa.PHPTravels.TestLayer;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.PHPTravels.BaseLayer.BasePage;
import com.qa.PHPTravels.PageLayer.HomePage;

public class HomePageTest {

	BasePage basePage;
	Properties prop;
	HomePage homePage;
	WebDriver driver;
	
	@BeforeTest
	public void init() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		homePage = new HomePage(driver);
	}
	
	@Test
	public void homePageTitleTest() {
		Assert.assertEquals("Book Your Free Demo Now - Phptravels", homePage.getPageTitle());
	}
	@Test
	public void isLoginButtonDisplayedTest() {
		Assert.assertTrue(homePage.isLoginButtonPresent());
	}
	@Test
	public void isSignUpButtonDisplayedTest() {
		Assert.assertTrue(homePage.isSignUpButtonPresent());
	}
	@Test
	public void homePageHeaderTest() {
		Assert.assertEquals("PHPTRAVELS Demo", homePage.pageheader());
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
