package com.hyr.testdependency;

import org.testng.annotations.Test;

public class TestDependency {
	static String TrackingNumber=null;
	
	
	@Test(priority=1)
	public void CreateShipment() {
		System.out.println(5/0);
		System.out.println("CreateShipment");
		TrackingNumber="HYR12";
	}

	@Test(priority=2,dependsOnMethods = {"CreateShipment"})
	public void TrackShipment() throws Exception {
		if(TrackingNumber!=null)
		System.out.println("Trackshipment");
		else
			throw new Exception("Invalid tracking number");
		
	}

	@Test(priority=3,dependsOnMethods = {"CreateShipment"})
	public void CancelShipment() throws Exception {
		if(TrackingNumber!=null)
		System.out.println("CancelShipment");
		else
			throw new Exception("Invalid tracking number");
	}

}
