package org.shopping_portal.user_placeorder;

import org.openqa.selenium.WebDriver;
import org.shopping_portal.objectRepository.HomePage;
import org.shopping_portal.objectRepository.LoginPage;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;
import org.yantra.genericUtility.ExcelUtility;
import org.yantra.genericUtility.FileUtility;
import org.yantra.genericUtility.IpathConstants;
import org.yantra.genericUtility.JavaScriptUtility;
import org.yantra.genericUtility.JavaUtility;
import org.yantra.genericUtility.WebdriverUtility;

public class CategoryPage extends BaseClass {
	@Test
	public void test() {
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelUtility excelUtility = new ExcelUtility();
		JavaUtility javaUtility = new JavaUtility();
		FileUtility fileUtility = new FileUtility();
		WebdriverUtility webdriverUtility = new WebdriverUtility();
		JavaScriptUtility jsUtility=new JavaScriptUtility();

		// Initialize data from Property File
		fileUtility.initializePropertyFile(IpathConstants.YANTRAPROPERTYFILEPATH);

		// Generate the Random number
		//int randomnumber = javaUtility.getRandomNumber();

		// Get the control for particular sheet in excel
		|excelUtility.initializeExcelfile(IpathConstants.YANTRAEXCELPATH);
		String url = fileUtility.getDataFromPropertyFile("url");
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		String timeouts = fileUtility.getDataFromPropertyFile("timeout");
		String browser = fileUtility.getDataFromPropertyFile("browser");

		// Fetch the data from Excel Sheet
		// Runtime polymorphism
		WebDriver driver = webdriverUtility.setupDriver(browser);

		// Pre-setting for browser
		webdriverUtility.maximizebrowser();
		long timeout = javaUtility.convertStringToLong(timeouts);
		webdriverUtility.implicitwait(timeout);

		// navigate the application
		webdriverUtility.openApplication(url);
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage=new HomePage(driver);
		loginpage.loginAction(username, password);*/

		excelUtility.initializeExcelfile(IpathConstants.YANTRAEXCELPATH);
	String Productname=	excelUtility.getDataFromExcel("Search",1, 1);
	    HomePage homepage=new HomePage(driver);
		homepage.searchProduct(Productname);
		//jsUtility.intializeJsExecutor(driver);
		//jsUtility.scrollTillEnd("up");
	}

}
