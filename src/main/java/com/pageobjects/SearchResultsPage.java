/**
 *   File Name: SearchResultsPage.java<br>
 *
 *   Sarana, Maria<br>
 *
 *   Created: Jan 20, 2016
 *
 */

package com.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * SearchResultsPage //ADDD (description of class)
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
public class SearchResultsPage {

	private WebDriver driver;

	@FindBy(className = "s-access-detail-page")
	private List<WebElement> searchResults;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public ProductPage clickOnProduct(int productNumber) {
		this.getSearchResult(productNumber).click();
		return PageFactory.initElements(this.driver, ProductPage.class);

	}

	public WebElement getSearchResult(int num) {
		return this.searchResults.get(num);
	}

}
