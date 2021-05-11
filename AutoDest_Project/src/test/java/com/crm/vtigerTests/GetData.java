package com.crm.vtigerTests;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;

public class GetData {
	@Test
	public void getData() throws Throwable
	{
		ExcelUtility  e =new ExcelUtility();
		String value = e.getExcelData("Sheet1", "TC_02", "lastname");
		System.out.println(value);
		}
	}

