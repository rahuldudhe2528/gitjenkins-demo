package com.hyr.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTest {
	public static WebDriver driver;
	@Test(priority=1)
	public void LaunchApp() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		

	}
	@Test(priority=2)
	public void EnterLoginDetails()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("username")).sendKeys("Admin");		
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();


	}
	@Test(priority=3)
	public void NavigateToMyInfoTab()
	{	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();

	}
	@Test(priority=4)
	public void VerifyMyInfo()
	{	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//div[@class='oxd-layout-context']")).isDisplayed();
	}

	@Test(priority=5)
	public void VeriFyLogin()
	{	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//div[@class='oxd-layout-context']")).isDisplayed();
	}
}
