/**
 *   File Name: Helper.java<br>
 *
 *   Sarana, Maria<br>
 *
 *   Created: Jan 19, 2016
 *
 */

package com.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;

/**
 * Helper //ADDD (description of class)
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
public class Helper {
	WebDriver driver;

	public void loginToAmazon(String email, String password) throws InterruptedException {
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

}
