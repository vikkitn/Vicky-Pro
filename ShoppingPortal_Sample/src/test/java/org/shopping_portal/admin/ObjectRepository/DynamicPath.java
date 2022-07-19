package org.shopping_portal.admin.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPath {
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-12 col-md-3 sidebar']")
	private WebElement allCategories;
	
	public DynamicPath(WebDriver driver)
	{
	PageFactory.initElements(driver,this);
	
	}
}

