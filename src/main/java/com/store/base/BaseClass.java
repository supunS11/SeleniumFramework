package com.store.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;

	@BeforeMethod
	public void loadConfig(){
		
		try{
			
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir")+ "\\configuration\\config.properties");
			prop.load(ip);
			System.out.println("driver: "+driver);
		}catch(FileNotFoundException c){
			c.printStackTrace();
			
		}catch(IOException c){
			c.printStackTrace();
		}
	}
	
	public static void launchApp(){
		
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome")){
			driver = new ChromeDriver();	
		}else if(browserName.contains("FireFox")){
			driver = new FirefoxDriver();
		}else if(browserName.contains("IE")){
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
