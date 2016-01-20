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

	private WebDriver driver;

	@FindBy(id = "nav-link-yourAccount")
	private WebElement signInBtn;

	@FindBy(className = "nav-line-3")
	private WebElement userName;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage clickOnSignInBtn() {
		this.signInBtn.click();
		return PageFactory.initElements(this.driver, LoginPage.class);
	}

	public WebElement getUsername() {
		return this.userName;
	}

	public boolean isLoggedInAs(String username) {
		System.out.println(this.userName.getText());
		if (this.userName.getAttribute("innerHTML").equals(username)) {
			return true;
		}
		return false;
	}

	public HomePage navigateToHomePage() {
		this.driver.get("http://www.amazon.com/");
		return PageFactory.initElements(this.driver, HomePage.class);
	}

}