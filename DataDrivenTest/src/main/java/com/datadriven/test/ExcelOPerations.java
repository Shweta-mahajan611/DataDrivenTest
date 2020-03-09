package com.datadriven.test;

import com.datadriventest.excelutility.Xls_Reader;

public class ExcelOPerations 
{

	public static void main(String[] args) 
	{
		Xls_Reader reader = new Xls_Reader("C:\\Users\\shwetamahajan\\Documents\\facebookRegiData.xlsx");
		
	
		if(reader.isSheetExist("HomePage"))
			System.out.println("Sheet exist");
		else
			reader.addSheet("HomePage");	
		
		int colCount = reader.getColumnCount("RegTestData");
		System.out.println("no of columns : " +colCount);
		
		System.out.println(reader.getCellData("RegTestData", "firstname", 3));
		System.out.println(reader.getCellRowNum("RegTestData", "firstname", "mahi"));
	}

}
