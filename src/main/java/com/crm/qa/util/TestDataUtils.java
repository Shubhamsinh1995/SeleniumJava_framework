package com.crm.qa.util;

import java.util.ArrayList;


public class TestDataUtils {
	static Xls_Reader reader;

	public static ArrayList<Object[]> getTestDataFromExcel() {
		
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		
		try {
			reader=new Xls_Reader("C:\\my java\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testData\\CRMTestData.xlsx");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int rowcount=reader.getRowCount("crmdata");
		for(int rowNum=2;rowNum<=rowcount;rowNum++) {
			System.out.println();
			String firstname=reader.getCellData("crmdata", "firstname", rowNum);
			
			String lastname=reader.getCellData("crmdata", "lastname",rowNum);
			
			String company=reader.getCellData("crmdata", "company", rowNum);
			
			//String password=reader.getCellData("crmdata", "password", rowNum);
			
			Object[] ob = {firstname, lastname, company};
			myData.add(ob);
	}
		return myData;
}
}
