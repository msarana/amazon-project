/**
 *   File Name: AmazonShopping.java<br>
 *
 *   Sarana, Maria<br>
 *
 *   Created: Jan 20, 2016
 *
 */

package com.amazon.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;
import com.pageobjects.SearchResultsPage;

/**
 * AmazonShopping //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Sarana, Maria
 * @version 1.0.0
 * @since 1.0
 *
 */
public class AmazonShopping {
	public static boolean isLoggedInAs(WebDriver driver, HomePage homePage, String username) {
		if (homePage.getUsername().getAttribute("innerHTML").equals(username)) {
			return true;
		}
		return false;
	}

	/**
	 * @param loginPage2
	 * @return
	 */
	public static boolean isLoggedOut(LoginPage loginPage) {
		if (loginPage.getsignInBtn().isDisplayed()) {
			return true;
		}
		return false;
	}

	public static void loginToAmazon(WebDriver driver, HomePage homePage, LoginPage loginPage, String[] credentials)
			throws InterruptedException {
		homePage = PageFactory.initElements(driver, HomePage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		homePage.navigateToHomePage();
		Thread.sleep(5000);
		homePage.clickOnSignInBtn();
		Thread.sleep(1000);
		loginPage.enterEmail(credentials[0]);
		loginPage.enterPassword(credentials[1]);
		loginPage.clickOnSignInBtn();

	}

	public static SearchResultsPage searchForProduct(WebDriver driver, HomePage homePage, String product)
			throws InterruptedException {
		homePage.getSearchTextBox().sendKeys(product);
		homePage.clickOnSubmitSearchRequestBtn();
		return PageFactory.initElements(driver, SearchResultsPage.class);
	}

	public static LoginPage signOutFromAmazon(WebDriver driver, HomePage homePage) throws InterruptedException {
		homePage.clickOnSignOutLink();
		return PageFactory.initElements(driver, LoginPage.class);
	}

	private WebDriver driver;
	private HomePage homePage;

	private LoginPage loginPage;

	private SearchResultsPage searchResultsPage;

}
