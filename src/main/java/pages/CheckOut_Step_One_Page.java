package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class CheckOut_Step_One_Page extends TestBase
{
	//repo
	@FindBy(xpath = "//div[text()='Swag Labs']") private WebElement CheckOutFirstLogo;
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstnameTxtBox;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastnameTxtBox;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement postalCodeTxtBox;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;
	
	public CheckOut_Step_One_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckOutFirstLogo()
	{
		return CheckOutFirstLogo.getText();
	}
	
	public String inputInformation() throws EncryptedDocumentException, IOException
	{
		firstnameTxtBox.sendKeys(ReadData.readExcel(0, 10));
		lastnameTxtBox.sendKeys(ReadData.readExcel(0, 11));
		postalCodeTxtBox.sendKeys(ReadData.readExcel(0, 12));
		continueBtn.click();
		return driver.getCurrentUrl();
	}

}
