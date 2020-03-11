package com.datadriven.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.datadriven.utility.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookTest 
{
static WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData = Utility.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider = "getTestData")
	public void fbRegiPageTest(String firstName,String surName,String email,String password) throws InterruptedException
	{
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
					
					driver.findElement(By.id("u_0_w")).clear();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//input[@id='u_0_w']")).sendKeys(password);
					Thread.sleep(1000);
					
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
