package org.practice.TestNG;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;
import org.yantra.genericUtility.IpathConstants;

public class ContactswithWipro extends BaseClass{
	
	@Test
	    public void deleteorganization()
	    {
	    	excelUtility.initializeExcelfile(IpathConstants.YANTRAEXCELPATH);
	    	driver.findElement(By.xpath("//a[.='Contacts']")).click();
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			String expectedContactLastname =excelUtility.getDataFromExcel("Contacts",1,1);
			String expectedOrganizationName =excelUtility.getDataFromExcel("Contacts",2,1);
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(expectedContactLastname);
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			webdriverUtility.windowPopup("Account", url);
			driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(expectedOrganizationName);
			driver.findElement(By.xpath("//input[@name='search']")).click();
			driver.findElement(By.linkText(expectedOrganizationName)).click();
			webdriverUtility.windowPopup("Contacts", url);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			String actualOrganization = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
			String actualOrganizationname = actualOrganization.trim();
			String actualLastname = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
			if (actualOrganizationname.equals(expectedOrganizationName) && actualLastname.equals(expectedContactLastname)) {
			javaUtility.printStatement("Contact is created with Organization is Validated");
			excelUtility.setDataIntoExcel("Contacts", 2, 2, "Pass");
			excelUtility.provideDataIntoExcel(IpathConstants.YANTRAEXCELPATH);

		}
		else
		{
			javaUtility.printStatement("Contact is created with Organization is not Validated");
			excelUtility.setDataIntoExcel("Contacts", 2, 2, "Fail");
			excelUtility.provideDataIntoExcel(IpathConstants.YANTRAEXCELPATH);
		}

		//Closing the workbook and driver
		WebElement administratorIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		webdriverUtility.mouseOverElement(administratorIcon);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		}
	
	@Test(dependsOnMethods="deleteorganization")
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
					String actualIndustryname=driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
					String actualTypeOfIndustry =driver.findElement(By.xpath("//td[@id='mouseArea_Type']")).getText();
					String actualorganization=actualOrganizationname.trim();
					if(actualorganization.equals(expectedOrganizationname) && actualIndustryname.equals(expectedIndustry) 
						&& actualTypeOfIndustry.equals(expectedTypeOfIndustry))
					{
					javaUtility.printStatement("Organization  with Industry and type creation is Validated");
					excelUtility.setDataIntoExcel("Organization", 4, 2, "Pass");
					excelUtility.provideDataIntoExcel(IpathConstants.YANTRAEXCELPATH);

				} else {
					javaUtility.printStatement("Organization  with Industry and type creation is not Validated");
					excelUtility.setDataIntoExcel("Organization", 4, 2, "Fail");
					excelUtility.provideDataIntoExcel(IpathConstants.YANTRAEXCELPATH);
				}

				// Closing the workbook and driver
				WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				webdriverUtility.mouseOverElement(administratorIcon);
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
			}


}

