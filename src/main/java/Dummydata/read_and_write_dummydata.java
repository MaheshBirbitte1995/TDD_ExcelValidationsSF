package Dummydata;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.checker.units.qual.s;


public class read_and_write_dummydata {

	
	
	public static void main(String [] args) throws InvalidFormatException, IOException {
		
		
     FileInputStream fis = new FileInputStream("C:/documents/Jump.csv");
     Workbook wb = WorkbookFactory.create(fis);
     Sheet.s=wb.getSheet("sheetName");
     String value = s.getRow(rownum).getCell(cellNum).getStringCellvalue();
     
     FileOutputStream fos =  new FileOutputStream("C:/pictures/documents/ju,ping.csv");
     wb.write(fos);
     
		
	}
	

	/*
	 * FileInputStream fis = new FileInputStream(“path of excel file”);
	 * 
	 * Workbook wb = WorkbookFactory.create(fis); Sheet s =
	 * wb.getSheet("sheetName"); String value =
	 * s.getRow(rowNum).getCell(cellNum).getStringCellValue(); // read data
	 * s.getRow(rowNum).getCell(cellNum).setCellValue("value to be set"); //write
	 * data FileOutputStream fos = new FileOutputStream(“path of file”);
	 * wb.write(fos); //save file
	 */	
	
	
	
	
	
	
	
	
	
}
