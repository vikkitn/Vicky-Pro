package org.shopping_portal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.yantra.genericUtility.BaseClass;

public class LoginPage {
	
	public LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement userNameTextField;
	@FindBy(xpath = "//input[@id='exampleInputPassword1']")
	private WebElement passwordTextField;
	@FindBy(xpath="//button[@name='login']")
	private WebElement loginButton;
     
	
	/**
	 * This method is used to login the application
	 * @param driver
	 * @return 
	 */
	

public void loginAction(String username,String password)
{
	userNameTextField.sendKeys(username);
	passwordTextField.sendKeys(password);
	loginButton.click();
	
}
}
