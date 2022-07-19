package org.shopping_portal.user_placeorder;

import org.openqa.selenium.WebDriver;
import org.shopping_portal.objectRepository.RegisterUserPage;
import org.yantra.genericUtility.ExcelUtility;
import org.yantra.genericUtility.FileUtility;
import org.yantra.genericUtility.IpathConstants;
import org.yantra.genericUtility.JavaUtility;
import org.yantra.genericUtility.WebdriverUtility;

public class RegisterUser {
	public static void main(String[] args) {
		
		//Creating an object to access the Utilities
		ExcelUtility excelUtility = new ExcelUtility();
		JavaUtility javaUtility = new JavaUtility();
		FileUtility fileUtility = new FileUtility();
		WebdriverUtility webdriverUtility = new WebdriverUtility();

		// Initialize data from Property File
		fileUtility.initializePropertyFile(IpathConstants.YANTRAPROPERTYFILEPATH);

		// Generate the Random number
		int randomnumber = javaUtility.getRandomNumber();

		// Get Initialize the excel sheet
		excelUtility.initializeExcelfile(IpathConstants.YANTRAEXCELPATH);
		//Get data from Excel sheet
		String fullName = excelUtility.getDataFromExcel("RegisterUser", 2, 1);
		String emailId = excelUtility.getDataFromExcel("RegisterUser", 4, 1)+ randomnumber+"@gmail.com";
		String contact = excelUtility.getDataFromExcel("RegisterUser", 6, 1);
		String registerpassword = excelUtility.getDataFromExcel("RegisterUser", 8, 1);
		String confirmregisterpassword = excelUtility.getDataFromExcel("RegisterUser", 10, 1);

		// Fetch the data from Property File

		String url = fileUtility.getDataFromPropertyFile("url");
		String timeouts = fileUtility.getDataFromPropertyFile("timeout");
		String browser = fileUtility.getDataFromPropertyFile("browser");

	    //Setup the Browser to launch
		WebDriver driver = webdriverUtility.setupDriver(browser);

		// Pre-setting for browser
		webdriverUtility.maximizebrowser();
		long timeout = javaUtility.convertStringToLong(timeouts);
		webdriverUtility.implicitwait(timeout);

		// navigate the application
		webdriverUtility.openApplication(url);
        //Register the User-Scenario
		RegisterUserPage registerUserPage = new RegisterUserPage(driver);
		registerUserPage.registerUser(fullName, emailId, contact, registerpassword, confirmregisterpassword);
		webdriverUtility.initializeAlertPopup();
		//Set data into Excel
		String output=webdriverUtility.getTextAlertpopup(javaUtility);
		excelUtility.setDataIntoExcel("RegisterUser",11,1,output);
		excelUtility.provideDataIntoExcel(IpathConstants.YANTRAEXCELPATH);
		webdriverUtility.acceptAlertpopup();
		//Close the browser
		webdriverUtility.closeBrowser();
		
	}
}
