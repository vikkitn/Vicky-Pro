package org.shopping_portal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackorderPage {
	@FindBy(xpath = "//input[@name='orderid']")

	private WebElement orderIdTextFiled;
	@FindBy(xpath = "//input[@type='email']")
	private WebElement EmailTextField;
	@FindBy(xpath = "//button[.='Track']")
	private WebElement clickonTrackButton;

	public TrackorderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void trackplacedorder(String orderName, String emailId) {
		orderIdTextFiled.sendKeys(orderName);
		EmailTextField.sendKeys(emailId);
		clickonTrackButton.click();
	}

	
	}

