/**
 *   File Name: HomePage.java<br>
 *
 *   Sarana, Maria<br>
 *
 *   Created: Jan 19, 2016
 *
 */

package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * HomePage //ADDD (description of class)
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
public class HomePage {

	@FindBy(id = "nav-cart")
	private WebElement cartLink;

	private WebDriver driver;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchTextBox;

	@FindBy(id = "nav-link-yourAccount")
	private WebElement signInBtn;

	@FindBy(id = "nav-item-signout")
	private WebElement signOutLink;

	@FindBy(id = "nav-search-submit-text")
	private WebElement submitSearchRequestBtn;

	@FindBy(className = "nav-line-3")
	private WebElement userName;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public CartPage clickOnCartLink() {
		this.cartLink.click();
		return PageFactory.initElements(this.driver, CartPage.class);
	}

	public LoginPage clickOnSignInBtn() {
		this.signInBtn.click();
		return PageFactory.initElements(this.driver, LoginPage.class);
	}

	public LoginPage clickOnSignOutLink() throws InterruptedException {
		new Actions(this.driver).moveToElement(this.getSignInBtn()).perform();
		Thread.sleep(1000);
		this.getSignOutLink().click();
		return PageFactory.initElements(this.driver, LoginPage.class);

	}

	public SearchResultsPage clickOnSubmitSearchRequestBtn() throws InterruptedException {
		this.submitSearchRequestBtn.click();
		Thread.sleep(1000);
		return PageFactory.initElements(this.driver, SearchResultsPage.class);
	}

	public void enterRequestInSearchTextBox(String request) {
		this.searchTextBox.sendKeys(request);
	}

	public WebElement getCartLink() {
		return this.cartLink;
	}

	public WebElement getSearchTextBox() {
		return this.searchTextBox;
	}

	public WebElement getSignInBtn() {
		return this.signInBtn;
	}

	public WebElement getSignOutLink() {
		return this.signOutLink;
	}

	public WebElement getSubmitSearchRequestBtn() {
		return this.submitSearchRequestBtn;
	}

	public WebElement getUsername() {
		return this.userName;
	}

	public WebElement getUserName() {
		return this.userName;
	}

	public HomePage navigateToHomePage() {
		this.driver.get("http://www.amazon.com/");
		return PageFactory.initElements(this.driver, HomePage.class);
	}

}