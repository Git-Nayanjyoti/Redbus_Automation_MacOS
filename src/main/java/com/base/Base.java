package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;

	public Base() {
		prop = new Properties();
		try {
			FileInputStream data = new FileInputStream("./src/main/java/com/config/data.properties");
			//System.out.println(data);
			prop.load(data);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!!!");
		} catch (IOException e) {
			System.out.println("Unable to read the file!!!");
		}
	}

 
	public void initialization() {

		String browser = prop.getProperty("browser"); 
		if (browser.equals("chrome")) { 			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("safari")) {
			
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else if (browser.equals("ie")) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
 
	public void closeDriver() {
		driver.close();
	}

}