/**

 *   File Name: ProductPage.java<br>
 *
 *   Sarana, Maria<br>
 *
 *   Created: Jan 20, 2016
 *
 */

package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * ProductPage //ADDD (description of class)
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
public class ProductPage {
	// @FindBy(id = "add-to-cart-button")
	@FindBy(name = "submit.add-to-cart")
	private WebElement addToCartBtn;

	private WebDriver driver;

	@FindBy(name = "quantity")
	private WebElement quantityDropDown;

	public CartPage clickOnAddToCartBtn() {
		this.addToCartBtn.click();
		return PageFactory.initElements(this.driver, CartPage.class);
	}

	public WebElement getAddToCartBtn() {
		return this.addToCartBtn;
	}

	public WebElement getQuantityDropDown() {
		return this.quantityDropDown;
	}

	public void selectDropDownValue(String value) {
		Select dropdown = new Select(this.quantityDropDown);
		dropdown.selectByValue(value);
	}

}
