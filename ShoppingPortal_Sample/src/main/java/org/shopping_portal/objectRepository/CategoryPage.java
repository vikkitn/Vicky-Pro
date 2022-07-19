package org.shopping_portal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	@FindBy(xpath = "//div[@class='side-menu animate-dropdown outer-bottom-xs']/div/i")
	private WebElement categeorylist;
	
	public CategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void categorymodule() {
		categeorylist.click();
	}
}
