package com.store.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.OrderHistoryPage;

public class OrderHistoryPageTest extends BaseClass{
	
	@BeforeMethod
	public void setup(){
		launchApp();
	}
	
	@Test(priority=1)
	public void login(){
		
		IndexPage indexPage = new IndexPage();
		indexPage.logIn("supunrathnayake11@gmail.com", "test123");
		
		OrderHistoryPage orderHistoryPage = new OrderHistoryPage();
		orderHistoryPage.verifyBlock();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
