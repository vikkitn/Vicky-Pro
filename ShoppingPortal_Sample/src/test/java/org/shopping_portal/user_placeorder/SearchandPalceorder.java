package org.shopping_portal.user_placeorder;

import org.openqa.selenium.WebDriver;
import org.shopping_portal.objectRepository.AddressPage;
import org.shopping_portal.objectRepository.CommonPage;
import org.shopping_portal.objectRepository.HomePage;
import org.shopping_portal.objectRepository.LoginPage;
import org.shopping_portal.objectRepository.SearchResultPage;
import org.shopping_portal.objectRepository.ShoppingcartPage;
import org.shopping_portal.objectRepository.TrackorderPage;
import org.yantra.genericUtility.ExcelUtility;
import org.yantra.genericUtility.FileUtility;
import org.yantra.genericUtility.IpathConstants;
import org.yantra.genericUtility.JavaScriptUtility;
import org.yantra.genericUtility.JavaUtility;
import org.yantra.genericUtility.WebdriverUtility;

public class SearchandPalceorder {
	public static void main(String[] args) {
		// Creating an object to call utilities
		ExcelUtility excelUtility = new ExcelUtility();
		JavaUtility javaUtility = new JavaUtility();
		FileUtility fileUtility = new FileUtility();
		WebdriverUtility webdriverUtility = new WebdriverUtility();
		JavaScriptUtility javaScriptUtility = new JavaScriptUtility();

		// Initialize data from Property File
		fileUtility.initializePropertyFile(IpathConstants.YANTRAPROPERTYFILEPATH);

		// Generate the Random number
		//int randomnumber = javaUtility.getRandomNumber();

		// Initialize the ExcelSheet
		excelUtility.initializeExcelfile(IpathConstants.YANTRAEXCELPATH);
		// Fetch the data from Excel Sheet
		String value = excelUtility.getDataFromExcel("Search", 1, 1).toUpperCase();
		System.out.println(value);
		String orderName = excelUtility.getDataFromExcel("Search", 2, 1);
		String emailId = excelUtility.getDataFromExcel("Search", 3, 1);

		// Fetch the data from Property File

		String url = fileUtility.getDataFromPropertyFile("url");
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		String timeouts = fileUtility.getDataFromPropertyFile("timeout");
		String browser = fileUtility.getDataFromPropertyFile("browser");

		// Set up the Browser
		WebDriver driver = webdriverUtility.setupDriver(browser);
		javaScriptUtility.intializeJsExecutor(driver);
		// Pre-setting for browser
		webdriverUtility.maximizebrowser();
		long timeout = javaUtility.convertStringToLong(timeouts);
		webdriverUtility.implicitwait(timeout);

		// navigate the application
		webdriverUtility.openApplication(url);
		// Login the Application
		LoginPage loginpage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		AddressPage addressPage = new AddressPage(driver);
		ShoppingcartPage shoppingcart = new ShoppingcartPage(driver);
		CommonPage commonPage = new CommonPage(driver);
		// Login the Application
		loginpage.loginAction(username, password);
		homePage.searchProduct(value);
		// Scroll action up to element
		javaScriptUtility.scrollTillElement(searchResultPage.scrollByAction());
		// Add product to the cart
		searchResultPage.addProduct();
		webdriverUtility.acceptAlertpopup();
		addressPage.ClickonProced().paymethodtype().clickonPaymentSubmit();
		
		//Validation
		String actualordername = shoppingcart.listofOrders(null, null);
		if (actualordername.contains(value)) {
			String sp = "Your order is Placed successfully";
			excelUtility.setDataIntoExcel("Search", 9, 1, sp);
			excelUtility.provideDataIntoExcel(IpathConstants.YANTRAEXCELPATH);
		} else {
			String sf = "Your order is Not Palced";
			excelUtility.setDataIntoExcel("Search", 9, 1, sf);
			excelUtility.provideDataIntoExcel(IpathConstants.YANTRAEXCELPATH);
		}
		
		// Logout the application
		//commonPage.clickonLogout();
		
		// Close the browser
		//webdriverUtility.closeBrowser();

	}
}
