package com.crm.vtigerTests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	@DataProvider
	public  Object[][] getData()
	{
		Object[][] arr=new Object[2][2];
		arr[0][0]="TestYantra";
		arr[0][1]="Techonolgy";
		arr[1][0]="TestYantra1";
		arr[1][1]="Technology";
		return arr;
	
	}
	@Test(dataProvider="getData")
	
	public void test(String name,String dropdown)
	{
		System.out.println(name+"\t"+dropdown);
	}
	

}
