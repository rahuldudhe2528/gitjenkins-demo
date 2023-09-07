package com.hyr.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ninja {
	@Test(dataProvider = "GetData",dataProviderClass = NInjaExcelDataProvider.class)
	public void TestNinja(String email,String pwd) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(pwd);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='account-account']//div[@class='row']//ul[1]")).isDisplayed());

		Thread.sleep(3000);
		driver.quit();
	}
}
