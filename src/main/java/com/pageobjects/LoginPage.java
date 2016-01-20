/**
 *   File Name: LoginPage.java<br>
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
 * LoginPage //ADDD (description of class)
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
public class LoginPage {

	private WebDriver driver;

	@FindBy(id = "ap_email")
	private WebElement emailInputField;

	@FindBy(id = "ap_password")
	private WebElement passwordInputField;

	@FindBy(id = "a-autoid-0")
	private WebElement signInBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage clickOnSignInBtn() {
		this.signInBtn.click();
		return PageFactory.initElements(this.driver, HomePage.class);

	}

	public void enterEmail(String email) {
		this.emailInputField.sendKeys(email);
	}

	public void enterPassword(String password) {
		this.passwordInputField.sendKeys(password);
	}
}