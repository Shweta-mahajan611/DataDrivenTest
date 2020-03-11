package com.datadriven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//using testng.xml
public class ParameterTest 
{
WebDriver driver;
	
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}

	@Parameters({"emailid","password"})
	@Test	
	public void loginTest(@Optional String emailid, @Optional String password) throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailid); //enter username
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);    //enter password
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='u_0_b']")).click();   //click on login
	 	
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
