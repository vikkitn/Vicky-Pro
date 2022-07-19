package org.practice.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;
import org.yantra.genericUtility.IpathConstants;
public class Contact extends BaseClass{
	
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
			System.out.println(actualLastname);
		        System.out.println(actualLastname);
		        System.out.println(actualLastname);
		         System.out.println(actualLastname);
		        System.out.println(actualLastname);
		        System.out.println(actualLastname);
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
		}



