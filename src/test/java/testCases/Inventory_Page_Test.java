package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import base.TestBase;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Inventory_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		login.loginToApplication();
	}
	@Test
	public void verifyTwitterLogoTest()
	{
		boolean result = invent.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Twitter Logo is present= "+result);
	}
	
	@Test
	public void verifyFacebookLogoTest()
	{
		boolean result = invent.verifyFacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Facebook Logo is present= "+result);
	}
	
	@Test
	public void verifyLinkedInLogoTest()
	{
		boolean result = invent.verifyLinkedInLogo();
		Assert.assertEquals(result, true);
		Reporter.log("LinkedIn Logo is present= "+result);
	}
	
	@Test
	public void add6Products() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0, 3); // 6(0,3)
		String actCount=invent.add6Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total products add to the cart = "+actCount);
		
	}
	
	@Test
	public void remove2ProductsTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0, 4); // 4(0,4)
		String actCount=invent.remove2Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("After removal, Total products left to the cart = "+actCount);
	}
	
	@Test
	public void verifyPageTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0, 5); // Products(0,5)
		String actTilte=invent.verifyPageTitle();
		Assert.assertEquals(expTitle, actTilte);
		Reporter.log("Inventory Title= "+actTilte);
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
