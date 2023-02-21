package com.qa.PHPTravels.TestLayer;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.PHPTravels.BaseLayer.BasePage;
import com.qa.PHPTravels.PageLayer.HomePage;
import com.qa.PHPTravels.PageLayer.LoginPage;
import com.qa.PHPTravels.util.AppConstants;
import com.qa.PHPTravels.util.ExcelUtil;

public class LoginPageTest {
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	WebDriver driver;
	LoginPage loginPage;

	@BeforeTest
	public void init() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		homePage = new HomePage(driver);
		loginPage = homePage.doClickLogin();
	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		Assert.assertEquals(AppConstants.LOGIN_PAGE_TITLE, loginPage.getLoginPageTitle());
	}
	@DataProvider
	public Object[][] getData() {
		Object data[][] = ExcelUtil.getdata(AppConstants.LOGIN_PAGE_SEETNAME);
		return data;
	}
	

	@Test(priority=2,dataProvider = "getData")
	public void loginPageHeaderTest(String firstName,String lastName,String dob,String email) {
		Assert.assertEquals(AppConstants.LOGIN_PAGE_HEAEDR, loginPage.getLoginPageHeader());
	}

	@Test(priority=3)
	public void doLoginTest() throws InterruptedException {
		loginPage.doLogin();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
