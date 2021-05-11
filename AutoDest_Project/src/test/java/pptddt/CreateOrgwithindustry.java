package pptddt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class CreateOrgwithindustry  extends BaseClass{
	static {
		System.setProperty("webdriver.chrome.driver", "./drives/chromedriver.exe");
	}
	
	@Test
	public void createorg() throws Throwable {
		JavaUtility jutil=new JavaUtility();
		String orgName=eUtil.getExcelData("Sheet1", 1, 2);
		String industrytype=eUtil.getExcelData("Sheet1", 6, 3);
		// creating organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName+jutil.getRandomData());

		// creating organization with industry
		WebElement element = driver.findElement(By.xpath("//select[@name='industry']"));
	
		wUtil.selectOption(element, industrytype);
	
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	}

}


