package pptddt;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreatOrgWIthContact extends BaseClass {
	

	@Test
	public void createorg() throws Throwable {
		JavaUtility jutil=new JavaUtility();
		 
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement((By.xpath("//input[@name='lastname']"))).sendKeys("supriya");
		driver.findElement(By.xpath("//input[@name='account_name']"));
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys("tata");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText("tata")).click();
		wUtil.switchToWindow(driver, "contacts");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

}}

