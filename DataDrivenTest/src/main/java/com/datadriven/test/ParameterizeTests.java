package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.datadriven.excelutility.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterizeTests 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		// get data from excel file
		Xls_Reader reader = new Xls_Reader("C:\\Users\\shwetamahajan\\Documents\\facebookRegiData.xlsx");
		int rowcount = reader.getRowCount("RegiTestData");
		
		//Add column in excel file
		reader.addColumn("RegiTestData", "status");
		
		//parameterization
		for(int rowno=2; rowno<=rowcount; rowno++)
		{
			System.out.println();
			String firstName = reader.getCellData("RegiTestData", "firstname", rowno);
			System.out.println(firstName);

			String surName = reader.getCellData("RegiTestData", "surname", rowno);
			System.out.println(surName);

			String email = reader.getCellData("RegiTestData", "email", rowno);
			System.out.println(email);

			//String emailOrMob1 = reader.getCellData("RegiTestData", "email", rowno);
			//System.out.println(email);
			
			String password = reader.getCellData("RegiTestData", "password", rowno);
			System.out.println(password);

//			String birthdate = reader.getCellData("RegTestData", "birthday", rowno);
//			System.out.println(birthdate);
			
	// web driver code for getting data from excel file
			driver.findElement(By.id("u_0_m")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='u_0_m']")).sendKeys(firstName);
			Thread.sleep(1000);
			
			driver.findElement(By.id("u_0_o")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='u_0_o']")).sendKeys(surName);
			Thread.sleep(1000);
			
			driver.findElement(By.id("u_0_r")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='u_0_r']")).sendKeys(email);
			Thread.sleep(1000);
			
//			driver.findElement(By.id("u_0_r")).clear();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@id='u_0_r']")).sendKeys(email);
//			Thread.sleep(1000);
			
			driver.findElement(By.id("u_0_w")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='u_0_w']")).sendKeys(password);
			Thread.sleep(1000);
			
			
			//write into excel file
			reader.setCellData("RegiTestData", "status", rowno, "pass");
		}
		driver.close();
	
	}
}
