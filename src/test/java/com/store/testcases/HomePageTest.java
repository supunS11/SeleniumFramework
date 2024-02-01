package com.store.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.HomePage;
import com.store.pageobjects.IndexPage;

public class HomePageTest extends BaseClass{
	
	@BeforeMethod
	public void setup(){
		launchApp();
	}
	
	@Test(priority=1)
	public void login(){
		
		IndexPage indexPage = new IndexPage();
		indexPage.logIn("supunrathnayake11@gmail.com", "test123");
		
		HomePage homePage = new HomePage();
		homePage.verifyDetails();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test(priority=2)
//	public void homePageVerify() {
//		
//
//	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
