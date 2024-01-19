package com.ecom.testcases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyLast {

	//static String name="Hi Hello s";
	public static void main(String[] args) {
		String str=" abc d 51dsdsds";

		int cat_count=51;
		
		int pagination_for_Each_Catgry=cat_count/20; //51  2
		int loop=pagination_for_Each_Catgry; 
		while(cat_count>pagination_for_Each_Catgry*20) {
			loop++;
			pagination_for_Each_Catgry=pagination_for_Each_Catgry*20;
		}
		
		System.out.println("loop::"+"//div[@class=\"prdct-crd p-2 cursor-pointer\"]["+ 1 +"]");

	}

}
