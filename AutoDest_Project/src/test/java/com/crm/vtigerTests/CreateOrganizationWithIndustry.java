package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOrganizationWithIndustry {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./drives/chromedriver.exe");
	}
	@Test
	public void createOrganization() throws InterruptedException
	{
		//launch browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
        Actions actions = new Actions(driver);
		//get the url"
		driver.get("http://localhost:8888");
		//login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
		driver.findElement(By.linkText("Organizations")).click();
//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("tata");
		//Step 5: click on Industry
				WebElement selection = driver.findElement(By.name("industry"));
				Select select = new Select(selection);
				select.selectByVisibleText("Education");
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				Thread.sleep(5000);
				
				//Step 5: Sign out
				actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
				//driver.findElement(By.xpath("(//td[@valign=\"bottom\"])[2]")).click();
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			}

		
}
