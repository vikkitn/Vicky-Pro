package org.shopping_portal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='search-field']")
	private WebElement searchValue;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement clickonSearchButton;
	@FindBy(xpath = "//span[.='Track Order']")
	private WebElement clickonTrackorder;
	
	@FindBy(xpath = "//a[.='Home']")
	private WebElement clickonHome;

	public void searchProduct(String value) {
		searchValue.sendKeys(value);
		clickonSearchButton.click();
		
		
	}

	public HomePage trackOrder() {
		clickonTrackorder.click();
		return this;
	}
	public void homemodule()
	{
	clickonHome.click();
	}

}
