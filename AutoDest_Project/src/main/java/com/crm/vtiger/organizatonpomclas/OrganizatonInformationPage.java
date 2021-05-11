package com.crm.vtiger.organizatonpomclas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizatonInformationPage {
	
		
		public OrganizatonInformationPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement organizationInfo;
		
		
		public WebElement getOrganizationInfo() {
			return organizationInfo;
		}

		 
		
		
		public String getOrganizationText() {
			return organizationInfo.getText();
		}
		
		
		

	}



