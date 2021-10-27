package com.fbtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FoodboxAdminOperations {
	WebDriver driver;
	@BeforeClass
	public void testSetup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Academics\\Simplilearn\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void openBrowser() {
		driver.get("http://localhost:4200/admin");
		driver.findElement(By.id("defaultForm-username")).sendKeys("admin");
		driver.findElement(By.id("defaultForm-pass")).sendKeys("password");
		driver.findElement(By.className("btn")).click();
	}
	
	@Test (priority = 1)
	public void AdminOperations(){
		driver.findElement(By.className("AddProd")).click();
		driver.findElement(By.id("name")).sendKeys("TestItem");
		driver.findElement(By.id("desc")).sendKeys("TestItem");
		driver.findElement(By.id("category")).sendKeys("Indian");
		driver.findElement(By.id("actualPrice")).sendKeys(""+100);
		driver.findElement(By.id("discount")).sendKeys(""+10);
		driver.findElement(By.className("form-check-input")).sendKeys("yes");
		driver.findElement(By.id("imagepath")).sendKeys("Test");
		driver.findElement(By.id("addItem")).click();
	}
	@Test (priority = 2)
	public void AdmindeleteItem() {
		driver.findElement(By.id("mpu")).click();
		driver.findElement(By.id("mcu")).click();
		driver.findElement(By.id("mpo")).click();
	}

}
