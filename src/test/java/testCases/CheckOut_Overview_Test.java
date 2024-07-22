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
import pages.CheckOut_Overview;
import pages.CheckOut_Step_One_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class CheckOut_Overview_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	CheckOut_Step_One_Page check1;
	CheckOut_Overview check2;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new Cart_Page();
		check1=new CheckOut_Step_One_Page();
		check2=new CheckOut_Overview();
		login.loginToApplication();
		invent.add6Products();
		invent.clickOnCart();
		cart.clickonCheckOutBtn();
		check1.inputInformation();
	}
	
	@Test
	public void verifytTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle = ReadData.readExcel(1, 0); // Checkout: Overview
		String actTitle = check2.verifytTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Checkout Overview page title: "+actTitle);
	}
	
	@Test
	public void verifyprodBoltTShirtTest() throws EncryptedDocumentException, IOException
	{
		String expProd = ReadData.readExcel(1, 1); // Sauce Labs Bolt T-Shirt
		String actProd = check2.verifyprodBoltTShirt();
		Assert.assertEquals(expProd, actProd);
		Reporter.log("Added Product: "+actProd);
	}
	
	@Test
	public void verifypriceBoltTShirtTest() throws EncryptedDocumentException, IOException
	{
		String expPrice = ReadData.readExcel(1, 2); // 15.99
		String actPrice = check2.verifypriceBoltTShirt();
		Assert.assertEquals(expPrice, actPrice);
		Reporter.log("Added Product price: "+actPrice);
	}
	
	@Test
	public void verifyprodFleeceJacket() throws EncryptedDocumentException, IOException
	{
		String expProd = ReadData.readExcel(1, 3); // Sauce Labs Fleece Jacket
		String actProd = check2.verifyprodFleeceJacket();
		Assert.assertEquals(expProd, actProd);
		Reporter.log("Added Product: "+actProd);
	}
	
	@Test
	public void verifypriceFleeceJacketTest() throws EncryptedDocumentException, IOException
	{
		String expPrice = ReadData.readExcel(1, 4); // 49.99
		String actPrice = check2.verifypriceFleeceJacket();
		Assert.assertEquals(expPrice, actPrice);
		Reporter.log("Added Product price: "+actPrice);
	}
	
	@Test
	public void verifylabelPaymentInfoTest() throws EncryptedDocumentException, IOException
	{
		String expText = ReadData.readExcel(1, 5); // Payment Information:
		String actText = check2.verifylabelPaymentInfo();
		Assert.assertEquals(expText, actText);
		Reporter.log("Payment Information: "+actText);
	}
	
	@Test
	public void verifylabelPaymentValueTest() throws EncryptedDocumentException, IOException
	{
		String expValue = ReadData.readExcel(1, 6); // SauceCard #31337
		String actValue = check2.verifylabelPaymentValue();
		Assert.assertEquals(expValue, actValue);
		Reporter.log("Payment Value Information: "+actValue);
	}
	
	@Test
	public void verifylabelShippingInfoTest() throws EncryptedDocumentException, IOException
	{
		String expText = ReadData.readExcel(1, 7); // Shipping Information:
		String actText = check2.verifylabelShippingInfo();
		Assert.assertEquals(expText, actText);
		Reporter.log("Shipping Information: "+actText);
	}
	
	@Test
	public void verifylabelShippingValueTest() throws EncryptedDocumentException, IOException
	{
		String expValue = ReadData.readExcel(1, 8); // Free Pony Express Delivery!
		String actValue = check2.verifylabelShippingInfo();
		Assert.assertEquals(expValue, actValue);
		Reporter.log("Shipping Value Information: "+actValue);
	}
	
	@Test
	public void verifylabelSubTotalTest() throws EncryptedDocumentException, IOException
	{
		String expText = ReadData.readExcel(1, 9); // Price Total
		String actText = check2.verifylabelSubTotal();
		Assert.assertEquals(expText, actText);
		Reporter.log("Sub Total: "+actText);
	}
	
	@Test
	public void verifylabelPriceTotalTest() throws EncryptedDocumentException, IOException
	{
		String expTotal = ReadData.readExcel(1, 10); // '65.98
		String actTotal = check2.verifylabelPriceTotal();
		Assert.assertEquals(expTotal, actTotal);
		Reporter.log("Sub Total: "+actTotal);
	}
	
	@Test
	public void verifylabelTaxTest() throws EncryptedDocumentException, IOException
	{
		String expText = ReadData.readExcel(1, 11); // '5.28
		String actText = check2.verifylabelTax();
		Assert.assertEquals(expText, actText);
		Reporter.log("Tax: "+actText);
	}
	
	@Test
	public void verifylabelTotalTest() throws EncryptedDocumentException, IOException
	{
		String expTotal = ReadData.readExcel(1, 12); // '71.26
		String actTotal = check2.verifylabelPriceTotal();
		Assert.assertEquals(expTotal, actTotal);
		Reporter.log("Total: "+actTotal);
	}
	
	@Test
	public void verifyfinishBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL = ReadData.readExcel(1, 13); // https://www.saucedemo.com/checkout-complete.html
		String actURL = check2.verifyfinishBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("CheckOut Complete URL: "+actURL);
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
