package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateOrganizationTest {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./drives/chromedriver.exe");
	}
	@Test
	public void createOrganization() throws Throwable
	{ 
		ExcelUtility eutil=new ExcelUtility();
		//String orgName=eutil.getExcelData("Sheet1", 1, 2);
		FileUtility futil=new FileUtility();
		String browserName=futil.getDatafromJason("browser");
		String url=futil.getDatafromJason("url");
		String username=futil.getDatafromJason("username");
		String passward=futil.getDatafromJason("passward");
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
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
      //get the url"
		driver.get("http://localhost:8888");
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(passward);
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
		driver.findElement(By.linkText("Organizations")).click();
//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("techmahindra"+jutil.getRandomData());
		//System.out.println(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.close();
		
	}
	}


