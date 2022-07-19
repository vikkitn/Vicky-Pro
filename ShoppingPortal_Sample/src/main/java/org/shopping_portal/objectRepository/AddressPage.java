package org.shopping_portal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
	WebDriver driver;
	@FindBy(xpath = "//button[@name='ordersubmit']")
	private WebElement clickOnProceedorder;

	public AddressPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public PaymentMethod ClickonProced() {
		clickOnProceedorder.click();
		return new PaymentMethod(driver);
	}
}