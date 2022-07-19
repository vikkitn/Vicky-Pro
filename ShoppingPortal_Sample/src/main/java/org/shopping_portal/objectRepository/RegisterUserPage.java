package org.shopping_portal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterUserPage {
	
@FindBy(xpath="//input[@id='fullname']")
private WebElement fullNameTextFiled;
@FindBy(xpath="//input[@id='email']")
private WebElement emailTextFiled;
@FindBy(xpath="//input[@id='contactno']")
private WebElement contactField;
@FindBy (xpath="//input[@id='password']")
private WebElement passwordFiled;
@FindBy(xpath="//input[@id='confirmpassword']")
private WebElement confirmPasswordFiled;
@FindBy(xpath="//button[@id='submit']")
private WebElement submitButton;

public RegisterUserPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
}
public void registerUser(String fullName,String emailId,String contact,String password,String confirmPassword)
{
	fullNameTextFiled.sendKeys(fullName);
	emailTextFiled.sendKeys(emailId);
	contactField.sendKeys(contact);
	passwordFiled.sendKeys(password);
	confirmPasswordFiled.sendKeys(confirmPassword);
	submitButton.click();
}
}
