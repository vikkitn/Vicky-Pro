package org.shopping_portal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsertOrderDetails {
	public InsertOrderDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name='category']")
	private WebElement clickonCategory;

	@FindBy(xpath = "//select[@name='subcategory']")
	private WebElement clickonsubCategory;

	@FindBy(xpath = "//input[@name='productName']")
	private WebElement productnamtxtfiled;
	@FindBy(xpath = "//input[@name='productCompany']")
	private WebElement productcompany;
	@FindBy(xpath = "//input[@name='productShippingcharge']")
	private WebElement productcharge;
	@FindBy(xpath = "//input[@name='productpricebd']")
	private WebElement productpricetxtfiled;
	@FindBy(xpath = "//input[@name='productprice']")
	private WebElement productpricebdtxtfiled;

	@FindBy(xpath = "//select[@id='productAvailability']")
	private WebElement productavailability;
	@FindBy(xpath = "//input[@name='productimage1']")
	private WebElement fileupload;
	@FindBy(xpath = "//input[@name='productimage2']")
	private WebElement fileuploadtwo;
	@FindBy(xpath = "//input[@name='productimage3']")
	private WebElement fileuploadthree;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement clickinsert;

	// Business Library

	public WebElement Insertorderclick() {
		return clickonCategory;
	}

	public WebElement subcategory() {
		return clickonsubCategory;
	}

	public void productname(String productname, String price, String discountprice,String company,String charges) {
		productnamtxtfiled.sendKeys(productname);
		productpricetxtfiled.sendKeys(price);
		productpricebdtxtfiled.sendKeys(discountprice);
		productcompany.sendKeys(company);
		productcharge.sendKeys(charges);
	}

	public WebElement availability() {
		return productavailability;
	}

	public void fileupload(String fileuploadf) {
		fileupload.sendKeys(fileuploadf);
		
	}

	public void fileuploadtwo(String fileuploadftwo) {
		fileuploadtwo.sendKeys(fileuploadftwo);
		
	}
	public void fileuploadthree(String fileuploadfythree) {
		fileuploadthree.sendKeys(fileuploadfythree);
		
	}


	public void insert() {
		clickinsert.click();
	}
	
}
