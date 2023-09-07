package com.hyr.dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeDataProviderdemo {
	
	@Test(dataProvider = "getData",dataProviderClass = ExcelDataSupplier.class)
	public void LaunchApp(String Uname,String pwd) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("username")).sendKeys(Uname);		
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='My Info']")).isDisplayed());
		Thread.sleep(3000);
		driver.quit();

}
}
