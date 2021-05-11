package pptddt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
@Listeners(com.crm.vtiger.GenericUtils.ListenerImplimentationClass .class)
public class copyshppingadress_Test extends BaseClass {

	@Test(groups = "smokeTest")
	public void createshippingbutton() throws Throwable {

		String orgName = eUtil.getExcelData("Sheet1", 1, 2) + "_" + Jutil.getRandomData();
		// navigate to organization
		driver.findElement(By.linkText("Organizations")).click();

		// create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName );

		// check weather copyshippingadressselectoption is enable or not
		boolean shippingradiobutton = driver.findElement(By.xpath("//input[@name='cpy'][1]")).isEnabled();
		Assert.assertEquals(shippingradiobutton, true);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verification
		String expdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(expdata.contains(orgName));
		

	}
}