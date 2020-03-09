package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.datadriventest.excelutility.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {

	public static void main(String[] args) throws InterruptedException {
		// get data from excel file
		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\shwetamahajan\\Documents\\facebookRegiData.xlsx");
		String firstName = reader.getCellData("RegiTestData", "firstname", 3);
		System.out.println(firstName);

		String surName = reader.getCellData("RegiTestData", "surname", 3);
		System.out.println(surName);

		String email = reader.getCellData("RegiTestData", "email", 3);
		System.out.println(email);

		//String emailOrMob1 = reader.getCellData("RegiTestData", "email", 3);
		//System.out.println(emailOrMob1);
		
		String password = reader.getCellData("RegiTestData", "password", 3);
		System.out.println(password);

//		String birthdate = reader.getCellData("RegiTestData", "birthday", 3);
//		System.out.println(birthdate);
//
//		String[] date = birthdate.split("/");
//		String day = date[0];
//		String month = date[1];
//		String year = date[2];
		String gender = reader.getCellData("RegiTestData", "gender", 3);
		System.out.println(gender);

		// web driver code for getting data from excel file
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='u_0_m']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='u_0_o']")).sendKeys(surName);
		driver.findElement(By.xpath("//input[@id='u_0_r']")).sendKeys(email);
		driver.findElement(By.id("u_0_r")).clear();
		//driver.findElement(By.xpath("//input[@id='u_0_r']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='u_0_w']")).sendKeys(password);
		//driver.findElement(By.xpath("//label[contains(text(),'female')]")).click();
		
//		Select daySelect = new Select(driver.findElement(By.id("day")));
//		daySelect.selectByVisibleText(day);
//
//		Select monthSelect = new Select(driver.findElement(By.id("month")));
//		monthSelect.selectByVisibleText(month);
//
//		Select yearSelect = new Select(driver.findElement(By.id("year")));
//		yearSelect.selectByVisibleText(year);

		Thread.sleep(3000);
		driver.close();
	}
}

