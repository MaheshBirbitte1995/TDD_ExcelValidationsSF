package com.ecom.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.Base.TestBase;
import com.ecom.pages.Inventorypage;
import com.ecom.pages.LoginPage;
import com.ecom.pages.StorefrontHomepage;
import com.ecom.until.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class StorefrontHomeTest  extends TestBase{
	LoginPage loginPage;
	StorefrontHomepage storefrnthome;
	Xls_Reader reader;
	static ExtentTest test;
	static ExtentReports report;
	
		public StorefrontHomeTest(){
			super();
		}

		@BeforeMethod
		public void setUp() throws InterruptedException{
			initialization(prop.getProperty("StoreURL"));
			//loginPage = new LoginPage();
			storefrnthome=new StorefrontHomepage();
			//loginPage.logininto_Merchant(prop.getProperty("m_username"), prop.getProperty("m_pwd"));
			//loginPage.logininto_Store(prop.getProperty("s_username"), prop.getProperty("s_pwd"));	
		
		}
		
		@Test(priority = 1)
		public void Storefront() throws InterruptedException {
			Thread.sleep(8000);
			cookiepopup("//div[@class=\"modal-box\"]//div//button[1]","Accepting Consent popup..!!");
			Thread.sleep(5000);
			cookiepopup("//div[@class=\"modal-box\"]//div//button[1]", "Cookie popup..");
			//storefrnthome.consent_popup.click();
			
			//ScrollIntoView(storefrnthome.pagination_count);
			storefrnthome.Extract_Inventry();
			Thread.sleep(3000);
		}
		

}
