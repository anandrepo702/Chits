package com.chits.pay.businesslogics;

public class Test {

	public static void main(String[] args) {
		
		String my = "122029";
		String month = my.substring(0, 2);
		int monthInt = Integer.parseInt(month);
		
		
		String year = my.substring(2, 6);
		int yearInt = Integer.parseInt(year);
		if(monthInt == 12) {
			yearInt = yearInt + 1;
			monthInt = 0;
		}
		
		monthInt = monthInt + 1;
		
		String str1 = Integer.toString(monthInt);
		if(monthInt < 10) {
			str1 = "0".concat(str1);
		}
	    String str2 = Integer.toString(yearInt);
	    System.out.println(str1.concat(str2));
	}

}
