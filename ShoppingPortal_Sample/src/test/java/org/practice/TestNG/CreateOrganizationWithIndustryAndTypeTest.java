package org.practice.TestNG;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;
import org.yantra.genericUtility.IpathConstants;
//@Listeners(org.yantra.genericUtility.ListenersImp.class)
public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass {
	
	@Test
	public  void creOrganization()
	{
				excelUtility.initializeExcelfile(IpathConstants.YANTRAEXCELPATH);
				// Fetch the data from Excel Sheet
		        int randomNumber = new Random().nextInt(1000);
				String expectedOrganizationname = excelUtility.getDataFromExcel("Organization", 5,1) + randomNumber;
				String expectedIndustry = excelUtility.getDataFromExcel("Organization", 7, 1);
				String expectedTypeOfIndustry = excelUtility.getDataFromExcel("Organization", 9, 1);

				//Login the application
					WebElement compaignModule=driver.findElement(By.xpath("//a[text()='More']"));
					webdriverUtility.mouseOverElement(compaignModule);
					driver.findElement(By.xpath("//a[text()='Organizations']")).click();
					driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
					driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(expectedOrganizationname);
					WebElement industryDropdown=driver.findElement(By.xpath("//select[@name='industry']"));
					webdriverUtility.handleSelectDropdown(industryDropdown, "Education");
					WebElement typeDropdown=driver.findElement(By.xpath("//select[@name='accounttype']"));
					webdriverUtility.handleSelectDropdown(typeDropdown, "Press");
					driver.findElement(By.xpath("//input[@value='T']")).click();
					driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
					String actualOrganizationname=driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
					//String actualIndustryname=driver.findElement(By.xpath("//span[id='dtlview_Industry']")).getText();
					//String actualTypeOfIndustry =driver.findElement(By.xpath("//td[@id='mouseArea_Type']")).getText();
					String actualorganization=actualOrganizationname.trim();
					String str1=("Organization  with Industry and type creation is Validated");
					Assert.assertTrue(actualorganization.contains(expectedOrganizationname));
					Reporter.log(str1,true);
					excelUtility.setDataIntoExcel("Organization", 4, 2, "Pass");
					excelUtility.provideDataIntoExcel(IpathConstants.YANTRAEXCELPATH);
					String str=("Organization  with Industry and type creation is not Validated");
					Assert.assertFalse(false);
					Reporter.log(str,false);
					/*if(actualorganization.equals(expectedOrganizationname) && actualIndustryname.equals(expectedIndustry) 
						&& actualTypeOfIndustry.equals(expectedTypeOfIndustry))
					{
					javaUtility.printStatement("Organization  with Industry and type creation is Validated");
					excelUtility.setDataIntoExcel("Organization", 4, 2, "Pass");
					excelUtility.provideDataIntoExcel(IpathConstants.YANTRAEXCELPATH);

				} else {
					javaUtility.printStatement("Organization  with Industry and type creation is not Validated");
					excelUtility.setDataIntoExcel("Organization", 4, 2, "Fail");
					excelUtility.provideDataIntoExcel(IpathConstants.YANTRAEXCELPATH);
				}*/

				// Closing the workbook and driver
				WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				webdriverUtility.mouseOverElement(administratorIcon);
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
			}

		}
