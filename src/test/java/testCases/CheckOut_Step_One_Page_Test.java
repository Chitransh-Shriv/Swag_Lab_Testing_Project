package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOut_Step_One_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class CheckOut_Step_One_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	CheckOut_Step_One_Page check1;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new Cart_Page();
		check1=new CheckOut_Step_One_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.clickOnCart();
		cart.clickonCheckOutBtn();
	}
	
	@Test
	public void verifyCheckOutFirstLogoTest() throws EncryptedDocumentException, IOException
	{
		String expLogoText = ReadData.readExcel(0, 9); // Swag Labs
		String actLogoText = check1.verifyCheckOutFirstLogo();
		Assert.assertEquals(expLogoText, actLogoText);
		Reporter.log("Logo text on the checkout page: "+actLogoText);
	}
	
	@Test
	public void inputInformationTest() throws EncryptedDocumentException, IOException
	{
		String expURL= ReadData.readExcel(0, 13); //https://www.saucedemo.com/checkout-step-two.html
		String actURL=check1.inputInformation();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Checkout Page 2 URL = "+actURL);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.cs(it.getName());
		}
		driver.close(); 
	}
}
