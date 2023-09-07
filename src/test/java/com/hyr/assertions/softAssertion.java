package com.hyr.assertions;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class softAssertion {
	@Test 
	public void TestFacebook() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("tutorials",Keys.ENTER);
		Thread.sleep(5000);
		
		SoftAssert sf=new SoftAssert();
		
		//Title Assertion
		String actualtitle=driver.getTitle();
		String expectedtitle="Log in to Facebook";
	    sf.assertEquals(actualtitle, expectedtitle,"Title is mismatched");
		
	    //URL assertion
	    String actualurl=driver.getCurrentUrl();
	    String expectedurl="https://www.facebook.com/";
	    sf.assertEquals(actualurl, expectedurl,"URL is mismatched");
	    
	    //Text assertion
	    String acutalText=driver.findElement(By.id("email")).getAttribute("value");
	    String expectedText="h";
	    sf.assertEquals(acutalText, expectedText, "Text is mismatched");
	    
	    //Border assertion
	    String acutalborder=driver.findElement(By.id("email")).getCssValue("border");
	    String expectedborder="1px solid rgb(240, 40, 73)";
	    sf.assertEquals(acutalborder, expectedborder, "Border is mismatched");
	    
	    //ErrMsg assertion
	    String actualmsg=driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
	    String expectedmsg="The eemail address or mobile number you entered isn't connected to an account. Find your account and log in.";
	    sf.assertEquals(actualmsg, expectedmsg,"Error message is mismatched");
		
		
		driver.quit();
		sf.assertAll();

	}
}
