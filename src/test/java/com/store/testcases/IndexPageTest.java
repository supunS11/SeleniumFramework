package com.store.testcases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass{
	
	
	@BeforeMethod
	public void setup(){
		launchApp();
	}
	
	@Test
	public void login(){
		
		IndexPage indexPage = new IndexPage();
		indexPage.logIn("supunrathnayake11@gmail.com", "test123");
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
