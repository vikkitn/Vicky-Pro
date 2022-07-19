package org.shopping_portal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	@FindBy(xpath = "//a[.='Samsung M12']")
	private WebElement scrollByuptoElement;
	@FindBy(xpath="//button[.='Add to cart']")
	private WebElement addProductinCart;
	
	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement scrollByAction() {
		return scrollByuptoElement;
	}
		public void addProduct()
		{
			addProductinCart.click();
		}
	
	}
