package org.yantra.genericUtility;

import org.shopping_portal.objectRepository.LoginPagevtiger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass extends InstanceClass {
	/**
	 * This method used to open browser and Url
	 */
	
	@BeforeClass(alwaysRun=true)
	public void classSetup() {
		// Create object for Generic utility
		excelUtility = new ExcelUtility();
		javaUtility = new JavaUtility();
		fileUtility = new FileUtility();
		webdriverUtility = new WebdriverUtility();
		jsUtility = new JavaScriptUtility();

		// initialize the data from property file
		fileUtility.initializePropertyFile(IpathConstants.YANTRAPROPERTYFILEPATH);

		// Fetch data from Property file
		browser = fileUtility.getDataFromPropertyFile("browser");
		url = fileUtility.getDataFromPropertyFile("urlvt");
		username = fileUtility.getDataFromPropertyFile("usernamevt");
		password = fileUtility.getDataFromPropertyFile("passwordvt");
		String timeouts = fileUtility.getDataFromPropertyFile("timeout");
		longTimeout = javaUtility.convertStringToLong(timeouts);

		// Launching the browser in run time based on browser key
		driver = webdriverUtility.setupDriver(browser);
		//Listenerdriver=driver;
	
		// pre-setting for the Browser

		webdriverUtility.maximizebrowser();
		webdriverUtility.implicitwait(longTimeout);
		// Initialize the explicit wait ,Actions
		webdriverUtility.initializeActions();
		l=new LoginPagevtiger(driver); 
		//loginPage = new LoginPage(driver);
		//commonpage = new CommonPage(driver);
		// Navigate the Application
		webdriverUtility.openApplication(url);
	}

	/**
	 * This method is use to Login the Application
	 */
	@BeforeMethod(alwaysRun=true)
	public void login() {

		// Create object for common POM Repository classes
		l.loginAction(username, password);

	}

	/**
	 * This Method is used to Logout the Application
	 */
	@AfterMethod(alwaysRun=true)
	public void methodTearDown() {
		//commonpage.clickonLogout();
	}

	/**
	 * This class is used to close the browser
	 */
	@AfterClass(alwaysRun=true)
	public void classTearDown() {
		excelUtility.workbookClose();
		webdriverUtility.closeBrowser();
	}
}
