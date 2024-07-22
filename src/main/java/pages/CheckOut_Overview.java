package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOut_Overview extends TestBase
{
	//repo
	@FindBy(xpath = "//span[text()='Checkout: Overview']") private WebElement title;
	@FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']") private WebElement prodBoltTShirt;
	@FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']") private WebElement prodFleeceJacket;
	@FindBy(xpath = "//div[text()='15.99']") private WebElement priceBoltTShirt;
	@FindBy(xpath = "//div[text()='49.99']") private WebElement priceFleeceJacket;
	@FindBy(xpath = "//div[text()='Payment Information:']") private WebElement labelPaymentInfo;
	@FindBy(xpath = "//div[text()='SauceCard #31337']") private WebElement labelPaymentValue;
	@FindBy(xpath = "//div[text()='Shipping Information:']") private WebElement labelShippingInfo;
	@FindBy(xpath = "//div[text()='Free Pony Express Delivery!']") private WebElement labelShippingValue;
	@FindBy(xpath = "//div[text()='Price Total']") private WebElement labelPriceTotal;
	@FindBy(xpath = "//div[text()='65.98']") private WebElement labelSubTotal;
	@FindBy(xpath = "//div[text()='5.28']") private WebElement labelTax;
	@FindBy(xpath = "//div[text()='71.26']") private WebElement labelTotal;
	@FindBy(xpath = "//button[@id='finish']") private WebElement finishBtn;
	
	public CheckOut_Overview()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifytTitle()
	{
		return title.getText();
	}
	
	public String verifyprodBoltTShirt()
	{
		return prodBoltTShirt.getText();
	}
	
	public String verifypriceBoltTShirt()
	{
		return priceBoltTShirt.getText();
	}
	
	public String verifyprodFleeceJacket()
	{
		return prodFleeceJacket.getText();
	}
	
	public String verifypriceFleeceJacket()
	{
		return priceFleeceJacket.getText();
	}
	
	public String verifylabelPaymentInfo()
	{
		return labelPaymentInfo.getText();
	}
	
	public String verifylabelPaymentValue()
	{
		return labelPaymentValue.getText();
	}
	
	public String verifylabelShippingInfo()
	{
		return labelShippingInfo.getText();
	}
	
	public String verifylabelShippingValue()
	{
		return labelShippingValue.getText();
	}
	
	public String verifylabelSubTotal()
	{
		return labelSubTotal.getText();
	}
	
	public String verifylabelPriceTotal()
	{
		return labelPriceTotal.getText();
	}
	
	public String verifylabelTax()
	{
		return labelTax.getText();
	}
	
	public String verifylabelTotal()
	{
		return labelTotal.getText();
	}
	
	public String verifyfinishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();
	}
}
