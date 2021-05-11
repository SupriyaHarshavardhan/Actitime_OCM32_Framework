package com.crm.vtigerTests;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateContactWithOrganization {
	
	@Test
	public void createContactandOrg() throws Throwable {
		FileUtility futil=new FileUtility();
		String browserName=futil.getPropertyKeyValue("browser");
		String url=futil.getPropertyKeyValue("url");
		String username=futil.getPropertyKeyValue("username");
		String passward=futil.getPropertyKeyValue("passward");
		WebDriverUtility wutil=new WebDriverUtility();
		WebDriver driver=null;
		
		//launch the browser
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		
		
		//Step 1: Get Url
		driver.get(url);
		
		//Step 2: Login to application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(passward);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: click to Contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4: create contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("supriya");
		
		String parentwid=driver.getWindowHandle();
		String selectOrg="macd";
		
		//Step 3: click on organization
		driver.findElement(By.xpath("(//img[@alt=\"Select\"])[1]")).click();
		
		 Set<String> allWid = driver.getWindowHandles();
		 
		 for(String wid:allWid) {
			 driver.switchTo().window(wid);
			 List<WebElement> orgList = driver.findElements(By.xpath("//td[@class='lvtCol']/../..//a"));
			 for(WebElement org:orgList) {
				 if(org.getText().equalsIgnoreCase(selectOrg)) {
					 org.click();
					 break;
				 }
			 }
//			 Thread.sleep(5000);
//			 driver.close();
		 }
		 driver.switchTo().window(parentwid);
		 
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 5: Sign out
		actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

}
}