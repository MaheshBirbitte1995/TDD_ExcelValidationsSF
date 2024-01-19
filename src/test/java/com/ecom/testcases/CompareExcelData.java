package com.ecom.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.Base.TestBase;
import com.ecom.pages.Inventorypage;
import com.ecom.pages.LoginPage;
import com.ecom.until.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CompareExcelData extends TestBase{
	LoginPage loginPage;
	Xls_Reader reader;
	static ExtentTest test;
	static ExtentReports report;
	public CompareExcelData(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		//initialization(prop.getProperty("MerchantURL"));
		//loginPage = new LoginPage();

	}


	@Test(priority = 1)
	public void Create_Inventry() throws InterruptedException {
		try {
			reader = new Xls_Reader("C:\\Users\\Mahesh\\Desktop\\DataValidations.xlsx ");
		} catch (Exception e) {
			e.printStackTrace(); // D:\CommerceDataLoad.xlsx
		}

		int row=reader.getRowCount("Final_products");
		int col=reader.getColumnCount("Final_products");  //Final_products
		String regex = "^[a-zA-Z0-9_-]*$";

		int name_length=0,des_length=0, price=0;
		String des;


		StringBuilder update=new StringBuilder();  
		for(int i=2;i<=row;i++) {

			name_length=reader.getCellData("Final_products", 13, i).length();
			des_length=reader.getCellData("Final_products", 14, i).length();
			price=reader.getCellData("Final_products", 30, i).length();

			// System.out.println("Name : "+reader.getCellData("Final_products", 13, i));
			// System.out.println("desc : "+reader.getCellData("Final_products", 14, i));
			//String update="";

			if( name_length>=3 && name_length<=95 ) {
				update.append("Name len: Pass");
				reader.setCellData("Final_products", "Status", i, update.toString());

				if(des_length>=0 && des_length<=7500) {
					update.append(" + Desc len: Pass");
					reader.setCellData("Final_products", "Status", i, update.toString());

					if( price>=0 && price<=1000 ) {
						update.append("Price: Pass");
						reader.setCellData("Final_products", "Status", i, update.toString());
					}else {
						update.append(" + Price: Fail");
						reader.setCellData("Final_products", "Status", i, update.toString());
					}


				}else {
					update.append(" + Desc len: Fail");
					reader.setCellData("Final_products", "Status", i, update.toString());
				}


			}
			else {
				// reader.setCellData(regex, regex, row, regex);
				update.append("Name len: Fail");
				reader.setCellData("Final_products", "Status", i, update.toString());
				if(des_length>=0 && des_length<=7500) {
					update.append(" + Desc len: Pass");
					reader.setCellData("Final_products", "Status", i, update.toString());
				}else {
					update.append(" + Desc len: Fail");
					reader.setCellData("Final_products", "Status", i, update.toString());
				}


			}





			update.setLength(0);
			if(i==10) break;

		}




	}

}
