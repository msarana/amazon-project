package com.pageobjects.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.helper.AmazonShopping;
import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;
import com.pageobjects.ProductPage;
import com.pageobjects.SearchResultsPage;

public class AmazonLoginTest {

	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;

	@DataProvider
	public Object[][] getCredentianls() {
		return new Object[][] { { new String[] { "amazon17.test@gmail.com", "amazon17", "Test" } } };

	}

	@DataProvider
	public Object[][] getShoppingList() {
		return new Object[][] { { new String[] { "kindle", "0", "2" } } };

	}

	@BeforeClass
	public void setUp() {
		this.driver = new FirefoxDriver();
		this.homePage = PageFactory.initElements(this.driver, HomePage.class);
		this.loginPage = PageFactory.initElements(this.driver, LoginPage.class);
	}

	@AfterClass
	public void tearDown() {
		this.driver.quit();
	}

	@Test(dataProvider = "getShoppingList", dependsOnMethods = "testAmazonLogin")
	public void testAddToCard(String[] shoppingList) throws InterruptedException {
		SearchResultsPage searchResults = AmazonShopping.searchForProduct(this.driver, this.homePage, shoppingList[0]);
		Thread.sleep(1000);
		ProductPage productPage = searchResults.clickOnProduct(Integer.parseInt(shoppingList[1]));
		Thread.sleep(1000);

	}

	@Test(dataProvider = "getCredentianls")
	public void testAmazonLogin(String[] credentials) throws InterruptedException {
		AmazonShopping.loginToAmazon(this.driver, this.homePage, this.loginPage, credentials);
		Thread.sleep(1000);
		Assert.assertTrue(AmazonShopping.isLoggedInAs(this.driver, this.homePage, credentials[2]));
		Thread.sleep(1000);

	}

	@Test(dependsOnMethods = "testAmazonLogin")
	public void testAmazonSignOut() throws InterruptedException {
		LoginPage loginPage = AmazonShopping.signOutFromAmazon(this.driver, this.homePage);
		Thread.sleep(1000);
		Assert.assertTrue(AmazonShopping.isLoggedOut(loginPage));
	}
}