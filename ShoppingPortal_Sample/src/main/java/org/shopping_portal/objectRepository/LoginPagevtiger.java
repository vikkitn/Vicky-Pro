package org.shopping_portal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagevtiger {

	@FindBy(xpath ="//input[@name='user_name']")
	private WebElement usernamevt;
	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement passwordvt;
	@FindBy(xpath = "//input[@id='submitButton']")
	private WebElement loginButton;

	public LoginPagevtiger(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	/**
	 * This method is used to login the application
	 * 
	 * @param driver
	 * @return
	 */

	public void loginAction(String username, String password) {
		usernamevt.sendKeys(username);
		passwordvt.sendKeys(password);
		loginButton.click();

	}
}
