package com.crm.vtigerTests.organization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.organizatonpomclas.CreateOrganizationPage;
import com.crm.vtiger.organizatonpomclas.OrganizationPage;
import com.crm.vtiger.organizatonpomclas.OrganizatonInformationPage;
import com.crm.vtiger.pomclass.HomePage;

public class TL_16_CreatingOrganizationCopyingShippingAddressSelectoptionisenablesornot_Test extends BaseClass {

	@Test(groups = "smokeTest")
	public void createshippingbutton() throws Throwable {

		String orgName = eUtil.getExcelData("Sheet1", 1, 2) ;
		// navigate to organization

		HomePage homepage = new HomePage(driver);
		homepage.clickOnOrganizationLink();

		// create organizationlink

		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.clickOnCreateOrganizationIMG();

		// create organization
		CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(orgName + "_" + Jutil.getRandomData());

		// // check weather copyshippingadressselectoption is enable or not
		boolean shippingradiobutton = createOrgPage.getShippingradiobuttonTF().isEnabled();
		Assert.assertEquals(shippingradiobutton, true);

		// verification
		OrganizatonInformationPage orgInfoPage = new OrganizatonInformationPage(driver);
		String actualOrgName = orgInfoPage.getOrganizationText();

		Assert.assertTrue(actualOrgName.contains(orgName));
		

	}
}