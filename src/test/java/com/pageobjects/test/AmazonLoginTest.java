package com.pageobjects.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;

public class AmazonLoginTest {

	private WebDriver driver;

	@DataProvider
	public Object[][] getCredentianls() {
		return new Object[][] { { "amazon17.test@gmail.com", "amazon17" } };

	}

	@BeforeMethod
	public void setUp() {
		this.driver = new FirefoxDriver();
	}

	@AfterMethod
	public void tearDown() {
		this.driver.quit();
	}

	@Test(dataProvider = "getCredentianls")
	public void testAmazonLogin(String email, String password) throws InterruptedException {
		HomePage homePage = PageFactory.initElements(this.driver, HomePage.class);
		LoginPage loginPage = PageFactory.initElements(this.driver, LoginPage.class);
		homePage.navigateToHomePage();
		Thread.sleep(5000);
		homePage.clickOnSignInBtn();
		Thread.sleep(1000);
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickOnSignInBtn();
		Thread.sleep(1000);
		Assert.assertTrue(homePage.isLoggedInAs("Test"));
	}

	@Test
	public void testAmazonSignOut() {
		HomePage homePage = PageFactory.initElements(this.driver, HomePage.class);
		new Actions(this.driver).moveToElement(signInBtn).
	}

	new Actions(this.driver).dragAndDrop(this.driver.findElement(By.id("draggable")),this.driver.findElement(By.id("droppable"))).build().perform();

}

}