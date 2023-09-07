package com.hyr.parameters;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTest {
	public static WebDriver driver;
	
	@Parameters("Browsername")
	@BeforeTest
	public void InitialiseBrowser(String browsername)
	{	switch (browsername.toLowerCase()) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		break;
	case "edge":
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		break;

	default:
		System.err.print("Browsername is invalid");
		break;
	}
		
	}
	@Parameters("url")
	@Test
	public void LaunchApp(String URL) throws Exception
	{
		
		driver.get(URL);

	}
	@AfterTest
	public void TearDOwn()
	{
		driver.quit();
	}
	@Parameters({"username","password"})
	@Test
	public void EnterLoginDetails(String Uname, String Pwd)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("username")).sendKeys(Uname);		
		driver.findElement(By.name("password")).sendKeys(Pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();


	}
	@Test
	public void NavigateToMyInfoTab()
	{	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();

	}
	@Test
	public void VerifyMyInfo()
	{	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 	boolean actualvalue=driver.findElement(By.xpath("//div[@class='oxd-layout-context']")).isDisplayed();
	 	assertTrue(actualvalue);
	}

	@Test
	public void VeriFyLogin()
	{	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		boolean actualvalue=driver.findElement(By.xpath("//div[@class='oxd-layout-context']")).isDisplayed();
		assertTrue(actualvalue);
	}
}
