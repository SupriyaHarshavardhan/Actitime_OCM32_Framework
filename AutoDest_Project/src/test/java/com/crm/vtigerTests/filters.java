package com.crm.vtigerTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class filters {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./drives/chromedriver.exe");
	}
	
	@Test
	public void createOrganizationShipping() throws InterruptedException, IOException
	{
		WebDriverUtility util=new WebDriverUtility();
		//getting data from properties file
		String path="./datas/commondata.property";
		FileInputStream fis=new FileInputStream(path);
		Properties p=new Properties();
		p.load(fis);
		//launch browser
		WebDriver driver=new ChromeDriver();
		util.waitUntillPageLoad(driver);
		//get the url"
		driver.get(p.getProperty("url"));
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(p.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(p.getProperty("passward"));
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
		driver.findElement(By.linkText("Organizations")).click();
//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Ty2");
	//creating shipping address
		driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("btm layout");
		driver.findElement(By.xpath("//input[@id='ship_pobox']")).sendKeys("micolayout");
		driver.findElement(By.xpath("//input[@id='ship_city']")).sendKeys("bangalore");
		driver.findElement(By.xpath("//input[@id='ship_state']")).sendKeys("karnataka");
		driver.findElement(By.xpath("//input[@id='ship_code']")).sendKeys("561236");
		driver.findElement(By.xpath("//input[@id='ship_country']")).sendKeys("india");
//checking shipping button is enable or not
		boolean cpyshippingbutton = driver.findElement(By.xpath("//input[@name='cpy'][1]")).isEnabled();
		if(cpyshippingbutton )
		{
			System.out.println("copy shipping button is enable");
		}
		else
		{
			System.out.println("copy shipping button is not enable");
		}
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		util.mouseHover(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

}}
