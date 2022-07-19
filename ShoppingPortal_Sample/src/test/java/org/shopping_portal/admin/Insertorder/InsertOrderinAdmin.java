package org.shopping_portal.admin.Insertorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.shopping_portal.objectRepository.AdminHomePage;
import org.shopping_portal.objectRepository.InsertOrderDetails;
import org.shopping_portal.objectRepository.LoginPage_Admin;
import org.yantra.genericUtility.ExcelUtility;
import org.yantra.genericUtility.FileUtility;
import org.yantra.genericUtility.IpathConstants;
import org.yantra.genericUtility.JavaUtility;
import org.yantra.genericUtility.WebdriverUtility;

public class InsertOrderinAdmin {
public static void main(String[] args) {
	
	WebdriverUtility webdriverutility=new WebdriverUtility();
	JavaUtility javautility=new JavaUtility();
	ExcelUtility excelutility=new ExcelUtility();
	FileUtility fileutility=new FileUtility();
	
	//Initialize the Property file
	fileutility.initializePropertyFile(IpathConstants.YANTRAPROPERTYFILEPATH);
	//Initialize the ExcelUtility
	excelutility.initializeExcelfile(IpathConstants.YANTRAEXCELPATH);
	//Fetch Data from Property file
	String url=fileutility.getDataFromPropertyFile("urladmin");
	String username=fileutility.getDataFromPropertyFile("usernameadmin");
	String password=fileutility.getDataFromPropertyFile("passwordadmin");
	String browser=fileutility.getDataFromPropertyFile("browser");
	String timeouts=fileutility.getDataFromPropertyFile("timeout");
	//Fetech the data from excel
	String visibletext=excelutility.getDataFromExcel("Search", 5,1);
	String visibletxtsub=excelutility.getDataFromExcel("Search", 5,2);
	String productname=excelutility.getDataFromExcel("Search", 5,3);
	String price=excelutility.getDataFromExcel("Search", 5,4);
	String discountprice=excelutility.getDataFromExcel("Search", 5,5);
	String company=excelutility.getDataFromExcel("Search", 5,7);
	String charges=excelutility.getDataFromExcel("Search", 5,8);

	String productavailability=excelutility.getDataFromExcel("Search", 5,6);
	String fileupload=excelutility.getDataFromExcel("Search", 7,1);
	String fileuploadtwo=excelutility.getDataFromExcel("Search", 8,1);
	String fileuploadthree=excelutility.getDataFromExcel("Search", 7,1);
	//Setup the Browser
	WebDriver driver=webdriverutility.setupDriver(browser);
	webdriverutility.maximizebrowser();
	Long timeout=javautility.convertStringToLong(timeouts);
	webdriverutility.implicitwait(timeout);
	//Launch the browser
	webdriverutility.openApplication(url);
	//Login the Application
	LoginPage_Admin loginpage=new LoginPage_Admin(driver);
	AdminHomePage insertdropdown=new AdminHomePage(driver);
	InsertOrderDetails InsertOrderDetails =new InsertOrderDetails(driver);
	loginpage.loginActionAdmin(username, password);
	insertdropdown.insertOrder();
	WebElement visibletextd=InsertOrderDetails.Insertorderclick();
	webdriverutility.handleSelectDropdown(visibletextd, visibletext);
	WebElement visibletextsub=InsertOrderDetails.subcategory();
	webdriverutility.handleSelectDropdown(visibletextsub,visibletxtsub);
	InsertOrderDetails.productname(productname, price, discountprice,company,charges);
	WebElement availability=InsertOrderDetails.availability();
	webdriverutility.handleSelectDropdown(availability, productavailability);
	InsertOrderDetails.fileupload(fileupload);
	InsertOrderDetails.fileuploadtwo(fileuploadtwo);
	InsertOrderDetails.fileuploadthree(fileuploadthree);
	InsertOrderDetails.insert();
	
	
	
	
	
	
	
	
	
	
	/*driver.findElement(By.xpath("//a[.='Manage Products ']"));
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Samsung M12");
	String actualOrganizationname=driver.findElement(By.xpath("//h1[.='Samsung M12']")).getText();
	System.out.println(actualOrganizationname);
	
	/*if (actualOrganizationname.equals(expectedOrganizationName) {
		javaUtility.printStatement("Contact is created with Organization is Validated");
		excelUtility.setDataIntoExcel("ContactCreation", 2, 2, "Pass");
		excelUtility.provideDataToExcelPass(IpathConstants.YANTRAEXCELPATH);

	}
	else
	{
		javaUtility.printStatement("Contact is created with Organization is not Validated");
		excelUtility.setDataIntoExcel("ContactCreation", 2, 2, "Fail");
		excelUtility.provideDataToExcelPass(IpathConstants.YANTRAEXCELPATH);
	}*/
	
	
	
}
}
