package com.fbtest;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FoodboxLoginAddToCart {

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
		driver.get("http://localhost:4200/");
	}
	
	@Test(priority = 1)
	public void login() {
		driver.findElement(By.id("custLogin")).click();
		driver.findElement(By.id("defaultForm-email")).sendKeys("nithin@mail.com");
		driver.findElement(By.id("defaultForm-pass")).sendKeys("nithin");
		driver.findElement(By.id("loginSubmit")).click();
	}
	
	@Test(priority = 2)
	public void searchProd() {
		driver.findElement(By.name("searchKey")).sendKeys("Indi");
	}
	
	@Test(priority = 3)
	public void clickCategory() {
		driver.findElement(By.id("chinese")).click();
	}
	
	@Test(priority = 4)
	public void AddToCart() {
		driver.findElement(By.id("addToCart")).click();
	}
	
	@Test(priority = 5)
	public void CartOperations() {
		driver.findElement(By.className("cart")).click();
		driver.findElement(By.id("checkout")).click();
	}
	
	@Test(priority = 6)
	public void paymentGateway() {
		driver.findElement(By.id("pay")).click();
	}
	
	@Test(priority = 7)
	public void orderPrint() {
		driver.findElement(By.className("printOrder")).click();
	}
	
}
