package com.hyr.groups;

import org.testng.annotations.Test;
@Test(groups= {"all"})
public class NewTest1 {
    @Test(groups= {"smoke","sanity"})
	public void Test1()
	{
		System.out.println("Test1");
	}
    
    @Test(groups= { "regression","sanity"})
	public void Test2()
	{
		System.out.println("Test2");
	}
		@Test(groups= {"functional","regression"})
		public void Test3()
		{
			System.out.println("Test3");
		
}}
