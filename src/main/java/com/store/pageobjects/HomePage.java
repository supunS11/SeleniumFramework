package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.store.base.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space(text())='Add my first address']")
	WebElement lblFirstAddress;
	
	@FindBy(xpath = "//span[normalize-space(text())='Order history and details']")
	WebElement lblOrderHistory;
	
	public void verifyDetails() {
		
		System.out.println("----Starting method verifyDetails-----");
		try {
			
			lblFirstAddress.isDisplayed();
			String address = lblFirstAddress.getText();
			Assert.assertEquals(address, "ADD MY FIRST ADDRESS");
			
			lblOrderHistory.isDisplayed();
			String history = lblOrderHistory.getText();
			Assert.assertEquals(history, "ORDER HISTORY AND DETAILS");
			
		}catch(Exception c) {
			
			System.out.println("Did not verify details successfully");
		}
		
		System.out.println("----Ending method verifyDetails-----");
	}
}
