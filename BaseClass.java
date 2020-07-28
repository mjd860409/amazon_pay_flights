package com.amazon.boson.flights.web.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.amazon.boson.flights.web.ObjectRepo.Home;
import com.amazon.boson.flights.web.utils.Login;


public class BaseClass {

	public static WebDriver dr;	
	
	/* Launch the browser.*/
	
	@BeforeSuite
	public void configBC() throws IOException {	
				
		
		String pbrowser = "chrome";

		if (pbrowser.equals("firefox"))
		{			
			System.setProperty("webdriver.gecko.driver","/Users/dmanas/Documents/geckodriver");
			dr = new FirefoxDriver();
		}
		else if (pbrowser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","/Users/dmanas/Documents/chromedriver" );
			dr = new ChromeDriver();
		}
		else if (pbrowser.equals("ie"))
			dr = new SafariDriver();
				
	
		Reporter.log("Browser Launched..");
		
		//dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//dr.manage().window().maximize();

		String currentUrl = FileLib.getPropertyvalue("url");
		String uname = FileLib.getPropertyvalue("username");
		String psd = FileLib.getPropertyvalue("password");

		dr.get(currentUrl);
		
		Login login = PageFactory.initElements(dr, Login.class);
		login.loginToApp(uname, psd);
	}

	/*	Login into application.*/
	
	@BeforeClass
	public void configBM() throws IOException {
		
		//dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//dr.manage().window().maximize();

		String currentUrl = FileLib.getPropertyvalue("url");
		String uname = FileLib.getPropertyvalue("username");
		String psd = FileLib.getPropertyvalue("password");

		dr.get(currentUrl);
		
		//Login login = PageFactory.initElements(dr, Login.class);
		//login.loginToApp(uname, psd);
		//Reporter.log("User Succesfully LogedIn");		
	}
	
	
}
