package com.ecom.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecom.Base.TestBase;

public class Inventorypage extends TestBase {

	//Page Factory - OR:
	
	//Inventry_link
	@FindBy(xpath ="//div[@id=\"1686848392319\"]//a[text()=\" Inventory \"]")
	WebElement Inventry_link;

	//invtry_add_btn
	@FindBy(xpath ="//div[@class=\"grid-header form-row\"]//div//ul//li[2]")
	public WebElement invtry_add_btn;

	//prod_name
	@FindBy(xpath ="//div//input[@id=\"product-name-value\"]")
	WebElement prod_name;

	//Catgry_drpdown
// prod_name, Catgry_drpdown,Serv_delivery,Serv_pickup,description,price,tax_Catgry,stck_qty
	@FindBy(xpath ="//select[@id=\"Categories-dp\"]")
	WebElement Catgry_drpdown;


	//Serv_delivery
	@FindBy(xpath ="//div[@id=\"service_types\"]//div//input[@id=\"Delivery\"]")
	WebElement Serv_delivery;

	//Serv_pickup
	@FindBy(xpath ="//div[@id=\"service_types\"]//div//input[@id=\"Pick_Up\"]")
	WebElement Serv_pickup;

	//description
	@FindBy(xpath ="//div[@class=\"form-group form-div\"]//textarea[@id=\"description-value\"]")
	WebElement description;

	//price
	@FindBy(xpath ="//div[@class=\"form-group\"]//input[@id=\"price-value\"]")
	WebElement price_value;

	//tax_Catgry
	@FindBy(xpath ="//select[@id=\"tax_category\"]")
	WebElement tax_Catgry;

	//stck_qty
	@FindBy(xpath ="//input[@id=\"product_stock\"]")
	WebElement stck_qty;

	//save btn
	@FindBy(xpath ="//div[@class=\"footer-btn-one d-flex\"]//button[text()=\"Save\"]")
	WebElement save_btn;

		//Initializing the Page Objects:
	public Inventorypage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOn_InventryLink() throws InterruptedException {
		Inventry_link.click();
		Thread.sleep(14000);
	}
	
	public void Inventry_add_btn() throws InterruptedException {
		
		invtry_add_btn.click();
		Thread.sleep(4000);
	}
	public void create_Inventry(String pname,String categry,String ser_type,String descriptn,
			String price,String tax_catgry,String stc_qty) throws InterruptedException {
		// prod_name, Catgry_drpdown,Serv_delivery,Serv_pickup,description,price_value,tax_Catgry,stck_qty,save_btn
		prod_name.sendKeys(pname);
		
		Select cat_drpdwn=new Select(Catgry_drpdown);
		Thread.sleep(2000);
		cat_drpdwn.selectByVisibleText(categry); 
		
		/*List<WebElement>  lst = grt_voice.getOptions();
        int i=1;
        for(WebElement options: lst) {
        	if(i==2) {
        	grt_voice.selectByVisibleText(options.getText()); 
	}}*/
		
		if(ser_type.equals("Delivery")) {
			Serv_delivery.click();
		}else {
			Serv_pickup.click();
		
	           }
		
		description.sendKeys(descriptn);
		price_value.sendKeys(price);
		
		Select Taxcat_drpdwn=new Select(tax_Catgry);
		Thread.sleep(3000);
		Taxcat_drpdwn.selectByVisibleText(tax_catgry); 
		
		stck_qty.sendKeys(stc_qty);
		save_btn.click();
		Thread.sleep(9000);
     }
}
