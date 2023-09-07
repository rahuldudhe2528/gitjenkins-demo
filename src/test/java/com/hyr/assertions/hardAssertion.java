package com.hyr.assertions;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hardAssertion {
	@Test
	public void TestGoogle() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials",Keys.ENTER);
		String actualtitle=driver.getTitle();
		String expectedtitle="HYR Tutorials - Google Searchhh";
		assertEquals(actualtitle, expectedtitle,"Title is mismacthed");
		Thread.sleep(3000);
		driver.quit();
	}
}
