package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	//object repository
	@FindBy(xpath = "//input[@id='user-name']") private WebElement userTxtBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passWordTxtBox;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String loginToApplication() throws IOException
	{
		userTxtBox.sendKeys(ReadData.readPropertyFile("Username"));
		passWordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		loginBtn.click();
		return driver.getCurrentUrl(); //https://www.saucedemo.com/inventory.html
	}
	
	
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	}
}
