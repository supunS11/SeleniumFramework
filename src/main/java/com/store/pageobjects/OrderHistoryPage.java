package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.store.base.BaseClass;

public class OrderHistoryPage extends BaseClass{
	
	public OrderHistoryPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space(text())='Order history and details']")
	WebElement lblOrderDetails;
	
	@FindBy(xpath = "//div[@id='block-history']//child::p")
	WebElement blockParagraph;
	
	public void verifyBlock() {
		
		System.out.println("----Starting method verifyBlock----");
		try {
			
			lblOrderDetails.click();
			blockParagraph.isDisplayed();
			String text = blockParagraph.getText();
			Assert.assertEquals(text, "You have not placed any orders.");
			System.out.println("Successfully verified block");
			
		}catch(Exception c) {
			
			System.out.println("Did not verify text");
		}
		
		
		System.out.println("----Ending method verifyBlock----");
	}

}
