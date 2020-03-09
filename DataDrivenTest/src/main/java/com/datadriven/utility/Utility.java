package com.datadriven.utility;


import java.util.ArrayList;

import com.datadriventest.excelutility.Xls_Reader;

public class Utility 
{
static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		reader = new Xls_Reader(
				"C:\\Users\\shwetamahajan\\Documents\\facebookRegiData.xlsx");
		
		for(int rowno=2; rowno<=reader.getRowCount("RegiTestData"); rowno++)
		{
			System.out.println();
			String firstname = reader.getCellData("RegiTestData", "firstname", rowno);
			System.out.println(firstname);

			String surname = reader.getCellData("RegiTestData", "surname", rowno);
			System.out.println(surname);

			String email = reader.getCellData("RegiTestData", "email", rowno);
			System.out.println(email);
			
			String password = reader.getCellData("RegiTestData", "password", rowno);
			System.out.println(password);
			
			Object obj[] = {firstname,surname,email,password};
			list.add(obj);
		}
		
		return list;
	}
	
}


