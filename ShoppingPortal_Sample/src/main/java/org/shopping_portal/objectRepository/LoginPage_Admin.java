package org.shopping_portal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Admin {
	
	@FindBy(xpath = "//input[@id='inputEmail']")
	private WebElement userNameTextField;
	@FindBy(xpath = "//input[@id='inputPassword']")
	private WebElement passwordTextField;
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement clickonLoginButton;

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getClickonLoginButton() {
		return clickonLoginButton;
	}

	public LoginPage_Admin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginActionAdmin(String username, String password) {
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		clickonLoginButton.click();
	}

}
