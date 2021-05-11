package com.crm.vtiger.organizatonpomclas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{
		WebDriver driver;
		public CreateOrganizationPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="accountname")
		private WebElement organizationNameTF;
		
		@FindBy(xpath = "//input[@name='cpy'][1]")
		private WebElement ShippingradiobuttonTF;
		
		@FindBy(xpath = "//input[@name='cpy']/../../td[3]")
		private WebElement BillingradiobuttonTF;
		
		
		@FindBy(xpath = "//textarea[@name='ship_street']")
		private WebElement shipingstreetTF;
		
		@FindBy(xpath = "//input[@id='ship_pobox']")
		private WebElement shipingpoboxTF;
		

		@FindBy(xpath = "//input[@id='ship_city']")
		private WebElement shipingshipTF;
		

		@FindBy(xpath = "//input[@id='ship_state']")
		private WebElement shipingstateTF;
		

		@FindBy(xpath = "//input[@id='ship_country']")
		private WebElement shipingcountryTF;
		
		@FindBy(xpath = "//textarea[@name='bill_street']")
		private WebElement billstreetTF;
		
		
		@FindBy(xpath = "//input[@id='bill_pobox']")
		private WebElement billpoTF;
		@FindBy(xpath = "//input[@id='bill_city']")
		private WebElement billcityTF;
		@FindBy(xpath = "//input[@id='bill_state']")
		private WebElement billstateTF;
		@FindBy(xpath = "//input[@id='bill_country']")
		private WebElement billcountryTF;
		
		public WebElement getShipingstreetTF() {
			return shipingstreetTF;
		}

		public WebElement getShipingpoboxTF() {
			return shipingpoboxTF;
		}

		public WebElement getShipingshipTF() {
			return shipingshipTF;
		}


		public WebElement getShipingstateTF() {
			return shipingstateTF;
		}


		public WebElement getShipingcountryTF() {
			return shipingcountryTF;
		}

		public WebElement getShippingradiobuttonTF() {
			return ShippingradiobuttonTF;
		}

       

		public WebElement getBillstreetTF() {
			return billstreetTF;
		}

		public WebElement getBillpoTF() {
			return billpoTF;
		}

		public WebElement getBillcityTF() {
			return billcityTF;
		}

		public WebElement getBillstateTF() {
			return billstateTF;
		}

		public WebElement getBillcountryTF() {
			return billcountryTF;
		}

		public WebElement getBillingradiobuttonTF() {
			return BillingradiobuttonTF;
		}

		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;

		public WebElement getOrganizationNameTF() {
			return organizationNameTF;
		}

		
		public WebElement getSaveBtn() {
			return saveBtn;
		}

		/**
		 * Use this method to create organization by entering mandatory field
		 * @param organizationName
		 */
		public void createOrganization(String organizationName) {
			organizationNameTF.sendKeys(organizationName);
			//ShippingradiobuttonTF.isEnabled();
			//BillingradiobuttonTF.isEnabled();
	        saveBtn.click();
			
		}
		public void createOrganization1(String organizationName) {
			organizationNameTF.sendKeys(organizationName);
			ShippingradiobuttonTF.isEnabled();

			
		}
		public void Creatrshippig(String organizationName,String srbtn,String spbx,String sship,String state,String country)
		{
			organizationNameTF.sendKeys(organizationName);
			shipingstreetTF.sendKeys(srbtn);
			shipingpoboxTF.sendKeys(spbx);
			shipingshipTF.sendKeys(sship);
			shipingstateTF.sendKeys(state);
			shipingcountryTF.sendKeys(country);
			 saveBtn.click();
			
		}
		public void Creatrbilling(String organizationName,String srbtn,String spbx,String sship,String state,String country)
		{
			organizationNameTF.sendKeys(organizationName);
			billstreetTF.sendKeys(srbtn);
			billpoTF.sendKeys(spbx);
			billcityTF.sendKeys(sship);
			billstateTF.sendKeys(state);
			billcountryTF.sendKeys(country);
			 saveBtn.click();
			
		}
		
		

}
