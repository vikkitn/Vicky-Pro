package org.shopping_portal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethod {
	WebDriver driver;

	@FindBy(xpath = "//input[@value='Internet Banking']")
	private WebElement paymentMode;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitbutton;

	public PaymentMethod(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public PaymentMethod paymethodtype() {
		paymentMode.click();
		return this;
	}

	public HomePage clickonPaymentSubmit() {
		submitbutton.click();
		return new HomePage(driver);
	}
}

