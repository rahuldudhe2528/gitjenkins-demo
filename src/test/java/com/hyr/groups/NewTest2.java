package com.hyr.groups;

import org.testng.annotations.Test;

public class NewTest2 {

	@Test(groups= {"smoke"})
	public void Test4()
	{
		System.out.println("Test4");
	}
    
    @Test(groups= {"smoke","functional","sanity"})
	public void Test5()
	{
		System.out.println("Test5");
	}
		@Test(groups= {"functional","regression"})
		public void Test6()
		{
			System.out.println("Test6");
		
}
		@Test
		public void Test7()
		{
			System.out.println("Test7");
		}
		}
