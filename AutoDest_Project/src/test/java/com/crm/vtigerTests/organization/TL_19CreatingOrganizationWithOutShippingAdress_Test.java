package com.crm.vtigerTests.organization;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.organizatonpomclas.CreateOrganizationPage;
import com.crm.vtiger.organizatonpomclas.OrganizationPage;
import com.crm.vtiger.organizatonpomclas.OrganizatonInformationPage;
import com.crm.vtiger.pomclass.HomePage;

public class TL_19CreatingOrganizationWithOutShippingAdress_Test extends BaseClass {
	
	@Test(groups = "smokeTest")
	public void createsorgwithoutshipping() throws Throwable {

		String orgName = eUtil.getExcelData("Sheet1", 1, 2) + "_" + Jutil.getRandomData();
		// navigate to organization

		HomePage homepage = new HomePage(driver);
		homepage.clickOnOrganizationLink();

		// create organizationlink

		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.clickOnCreateOrganizationIMG();

		// create organization without shippingadresss
		CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(orgName);

		
		// verification
		OrganizatonInformationPage orgInfoPage = new OrganizatonInformationPage(driver);
		String actualOrgName = orgInfoPage.getOrganizationText();

		Assert.assertTrue(actualOrgName.contains(orgName));

	}
}