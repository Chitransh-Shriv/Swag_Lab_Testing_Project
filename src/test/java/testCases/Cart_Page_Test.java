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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Cart_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new Cart_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.clickOnCart();
	}
	
	@Test
	public void verifycartPageURLTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 6); // https://www.saucedemo.com/cart.html
		String actURL=cart.verifycartPageURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Cart Page URL = "+actURL);
		
	}
	
	@Test
	public void verifyPageTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0, 7); // Your Cart
		String actTitle=cart.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Cart Page Title = "+actTitle);
		
	}
	
	@Test
	public void clickonCheckOutBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 8); // https://www.saucedemo.com/checkout-step-one.html
		String actURL=cart.clickonCheckOutBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Checkout Page step-1 URL = "+actURL);
		
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
