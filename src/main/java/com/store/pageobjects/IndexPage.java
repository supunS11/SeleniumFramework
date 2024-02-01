package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.store.base.BaseClass;

public class IndexPage extends BaseClass {
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space(text())='Sign in']")
	WebElement btnSignIn;

	@FindBy(xpath = "//div[@id='block_top_menu']//child::a[normalize-space(text())='Women']")
	WebElement txtMenu;
			

	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement lblSearch;

	@FindBy(xpath = "//form[@id='searchbox']//child::button[@type='submit']")
	WebElement btnSearch;

	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement txtPass;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement btnLogIn;

	public void logIn(String userName, String passWord) {

		System.out.println("----Starting method logIn----");
		try {

			txtMenu.isDisplayed();
			String text = txtMenu.getText();
			Assert.assertEquals(text, "WOMEN");
			btnSignIn.click();
			txtEmail.sendKeys(userName);
			txtPass.sendKeys(passWord);
			btnLogIn.click();

			System.out.println("log in pass");
		} catch (Exception c) {
			System.out.println("log in failed");
		}

		System.out.println("----Ending method logIn----");
	}
}
