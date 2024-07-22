package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase
{
	//repo
	@FindBy(xpath = "//span[text()='Your Cart']") private WebElement pageTitle;
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkoutBtn;
	
	public Cart_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifycartPageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyPageTitle()
	{
		return pageTitle.getText();
	}
	
	public String clickonCheckOutBtn()
	{
		checkoutBtn.click();
		return driver.getCurrentUrl();
	}
}

