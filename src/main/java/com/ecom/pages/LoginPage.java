package com.ecom.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecom.Base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory - OR:
	@FindBy(xpath ="//div//input[@id=\"email\"]")
	WebElement user_name;
	
	@FindBy(xpath ="//div[@class=\"c-login-action\"]//button")
	WebElement next_btn;

	@FindBy(xpath ="//div//input[@id=\"password\"]")
	WebElement password;

	@FindBy(xpath ="//div[@class=\"c-login-action\"]//button")
	WebElement login_btn;
	

	
	
	@FindBy(xpath ="//div[@class=\"input-group\"]//input[@id=\"username\"]")
	WebElement m_userName;
	@FindBy(xpath ="//div[@class=\"c-login-action\"]//button")
	WebElement m_Nxtbtn;
	@FindBy(xpath ="//div[@class=\"input-group\"]//input[@id=\"password\"]")
	WebElement m_passwrd;



		//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	


			public void scroll() {
				 ((JavascriptExecutor) driver).executeScript("scroll(0,250);");
			 }


			public void Scrolldownbottom() {
				JavascriptExecutor js = (JavascriptExecutor) driver;
		        //Scroll down till the bottom of the page
		        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		        driver.navigate().refresh();

			}

			 public void switchToFrme(WebElement F_el) {
				 driver.switchTo().frame(F_el);

			 }
			 
			 public void logininto_Store(String uname, String pwd) throws InterruptedException {
				 user_name.sendKeys(uname);
				 Thread.sleep(3000);
				 next_btn.click();
				 Thread.sleep(3000);
				 password.sendKeys(pwd);
				 Thread.sleep(3000);
				 login_btn.click();
			 }
			 
			 public void logininto_Merchant(String m_uname, String m_pwd) throws InterruptedException {
				 m_userName.sendKeys(m_uname);
				 Thread.sleep(3000);
				 m_Nxtbtn.click();
				 Thread.sleep(3000);
				 m_passwrd.sendKeys(m_pwd);
				 Thread.sleep(3000);
				 m_Nxtbtn.click();
			 }



}
