package com.ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.Base.TestBase;
import com.ecom.pages.LoginPage;
import com.ecom.until.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginTest extends TestBase{
	LoginPage loginPage;
	Xls_Reader reader;
	static ExtentTest test;
	static ExtentReports report;
		public LoginTest(){
			super();
		}

		@BeforeMethod
		public void setUp(){
			initialization(prop.getProperty("MerchantURL"));
			loginPage = new LoginPage();
		
		}
		
		@Test(priority = 1)
		public void loginpage() throws InterruptedException {
			loginPage.logininto_Merchant(prop.getProperty("m_username"), prop.getProperty("m_pwd"));
			//Assert.assertEquals("Inbox", loginPage.Inbox_header_label.getText().trim(), "Login failed..!!"); 
		}
		

}
