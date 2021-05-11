package pptddt;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

public class createwithBillingtest extends BaseClass {

	@Test(groups = "regressionTest" )
	public void createorgwithbilling() throws Throwable {

		String orgName = eUtil.getExcelData("Sheet1", 1, 2) + "_" + Jutil.getRandomData();
		String adddress=eUtil.getExcelData("Sheet1", 8, 2);
		String adddress1=eUtil.getExcelData("Sheet1", 9, 2);
		String adddress2=eUtil.getExcelData("Sheet1", 10, 2);
		String adddress3=eUtil.getExcelData("Sheet1", 11, 2);
		//String adddress4=eUtil.getExcelData("Sheet1", 12, 2);
		String adddress5=eUtil.getExcelData("Sheet1", 13, 2);
		// navigate to organization
		driver.findElement(By.linkText("Organizations")).click();

		// create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName + Jutil.getRandomData());

		//creating shipping adress
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(adddress);
		driver.findElement(By.xpath("//input[@id='bill_pobox']")).sendKeys(adddress1);
		driver.findElement(By.xpath("//input[@id='bill_city']")).sendKeys(adddress2);
		driver.findElement(By.xpath("//input[@id='bill_state']")).sendKeys(adddress3);
		//driver.findElement(By.xpath("//input[@id='bill_code']")).sendKeys(adddress4);
		driver.findElement(By.xpath("//input[@id='bill_country']")).sendKeys(adddress5);
;
        //click on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verification
		String expdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(expdata.contains(orgName));


}


}
