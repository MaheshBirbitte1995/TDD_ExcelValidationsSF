package com.ecom.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.Base.TestBase;
import com.ecom.pages.Inventorypage;
import com.ecom.pages.LoginPage;
import com.ecom.until.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class InventoryTest extends TestBase{
	LoginPage loginPage;
	Inventorypage invntry;
	Xls_Reader reader;
	static ExtentTest test;
	static ExtentReports report;
	
		public InventoryTest(){
			super();
		}

		@BeforeMethod
		public void setUp() throws InterruptedException{
			initialization(prop.getProperty("MerchantURL"));
			loginPage = new LoginPage();
			invntry=new Inventorypage();
			loginPage.logininto_Merchant(prop.getProperty("m_username"), prop.getProperty("m_pwd"));
			
		
		}
		
		@Test(priority = 1)
		public void Create_Inventry() throws InterruptedException {
			//Inventry_link,invtry_add_btn
		//	invntry.clickOn_InventryLink();
			
			try {
				reader = new Xls_Reader("D:\\BackupOnedrive\\OneDrive - Uncode Inc\\Documents\\Ecommercedata.xlsx");
			} catch (Exception e) {
				e.printStackTrace();
			}

			int rows=reader.getRowCount("Liquordata");
			int col=reader.getColumnCount("Liquordata");
			System.out.println("rows:"+rows +"col:"+col);

			for(int i=2;i<=rows;i++) {
				invntry.Inventry_add_btn();
				if(i==2)break;
				for(int j=0;j<1;j++) { 
				String p_name=reader.getCellData("Liquordata", j, i);
				String catgry_name=reader.getCellData("Liquordata", j+1, i);
				String Ser_type=reader.getCellData("Liquordata", j+2, i);
				String Tax_Cat=reader.getCellData("Liquordata", j+3, i);
				String Price_amunt=reader.getCellData("Liquordata", j+4, i);
				String descript=reader.getCellData("Liquordata", j+5, i);
				System.out.println("p_name:"+p_name +"catgry_name:"+catgry_name +"Ser_type:"+Ser_type );
		
				invntry.create_Inventry(p_name,catgry_name,Ser_type,descript,Price_amunt,Tax_Cat,"10");
				
				}
			//if(i==4)break;
				}
}
}
