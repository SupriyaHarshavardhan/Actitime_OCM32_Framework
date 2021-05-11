package com.crm.vtigerTests.organization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.organizatonpomclas.CreateOrganizationPage;
import com.crm.vtiger.organizatonpomclas.OrganizationPage;
import com.crm.vtiger.organizatonpomclas.OrganizatonInformationPage;
import com.crm.vtiger.pomclass.HomePage;

public class TL_18_CreateOrganizationWithShippingAddress_Test extends BaseClass{
	
	@Test(groups = "regressionTest" )
	public void createorgwithShipping() throws Throwable {

		String orgName = eUtil.getExcelData("Sheet1", 1, 2) ;
		String adddress=eUtil.getExcelData("Sheet1", 8, 2);
		String adddress1=eUtil.getExcelData("Sheet1", 9, 2);
		String adddress2=eUtil.getExcelData("Sheet1", 10, 2);
		String adddress3=eUtil.getExcelData("Sheet1", 11, 2);
		//String adddress4=eUtil.getExcelData("Sheet1", 12, 2);
		String adddress5=eUtil.getExcelData("Sheet1", 13, 2);
		// navigate to organization
		
					HomePage homepage = new HomePage(driver);
					homepage.clickOnOrganizationLink();

					// create organizationlink

					OrganizationPage orgPage = new OrganizationPage(driver);
					orgPage.clickOnCreateOrganizationIMG();

					// create organization
					CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
					//createOrgPage.createOrganization(orgName  + Jutil.getRandomData());

		//creating shippingadress
					createOrgPage.Creatrshippig(orgName+Jutil.getRandomData(), adddress, adddress1, adddress2, adddress3, adddress5);
					

		// verification
		OrganizatonInformationPage orgInfoPage = new OrganizatonInformationPage(driver);
		String actualOrgName = orgInfoPage.getOrganizationText();

		Assert.assertTrue(actualOrgName.contains(orgName));
		



}
}