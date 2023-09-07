package com.hyr.testdependency;

import org.testng.annotations.Test;

public class TestGroupDependency {
	@Test(groups="smoke")
	public void Test1()
	{
		System.out.println("smoke");
	}
	@Test(groups="smoke")
	public void Test2()
	{
		System.out.println("smoke");
	}
	@Test(groups="smoke")
	public void Test3()
	{
		System.out.println("smoke");
	}
	@Test(dependsOnGroups = "smoke")
	public void Test0()
	{
		System.out.println("smoke");
	}
	

}
