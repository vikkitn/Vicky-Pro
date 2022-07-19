package org.shopping_portal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	@FindBy(xpath = "//i[@class='menu-icon icon-paste']")
	private WebElement clickonInsertOrder;
	
	public AdminHomePage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);
	}
	public void insertOrder()
	{
		clickonInsertOrder.click();
	}
}

