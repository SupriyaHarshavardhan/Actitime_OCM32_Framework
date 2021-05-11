package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorIMG;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;

	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	
	public WebElement getAdminstratorIMG() {
		return adminstratorIMG;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	/**
	 * click on organization link
	 */
	public void clickOnOrganizationLink() {
	//public OrganizationPage  clickOnOrganizationLink() {
		organizationLink.click();
		//return new OrganizationPage(driver);
	}
	
	/**
	 * Signout from app
	 */
	public void signOut() {
	
		mouseHover(driver, adminstratorIMG);
		signOutLink.click();
	}

}
