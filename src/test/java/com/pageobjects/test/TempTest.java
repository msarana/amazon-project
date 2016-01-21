/**
 *   File Name: TempTest.java<br>
 *
 *   Sarana, Maria<br>
 *
 *   Created: Jan 20, 2016
 *
 */

package com.pageobjects.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * TempTest //ADDD (description of class)
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
public class TempTest {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		this.driver = new FirefoxDriver();

	}

	@AfterClass
	public void tearDown() {
		this.driver.quit();
	}

	@Test(enabled = false)
	public void test() throws InterruptedException {
		this.driver.get(
				"http://www.amazon.com/Fire-Display-Wi-Fi-GB-Special/dp/B00TSUGXKE/ref=sr_1_1?ie=UTF8&qid=1453340923&sr=8-1&keywords=kindle");
		Select select = new Select(this.driver.findElement(By.id("quantity")));
		Thread.sleep(1000);
		select.selectByIndex(1);
		Thread.sleep(1000);
		this.driver.findElement(By.id("add-to-cart-button")).click();

	}

	@Test(enabled = false)
	public void test2() throws InterruptedException {
		this.driver
				.get("http://www.amazon.com/gp/product/B00TSUGXKE?keywords=kindle&qid=1453352031&ref_=sr_1_1&sr=8-1");
		System.out.println(this.driver.findElement(By.id("productTitle")).getText());

	}

	@Test
	public void test3() throws InterruptedException {
		this.driver.get("http://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=kindle");
		this.driver.findElement(By.linkText("Fire, 7\" Display, Wi-Fi, 8 GB - Includes Special Offers, Black")).click();
		Thread.sleep(1000);
	}

}
