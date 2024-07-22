package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import utility.HandleDropDownList;

public class Inventory_Page extends TestBase
{
	//object repository
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']") private WebElement productBackpack;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bike-light']") private WebElement productBikeLight;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement productBoltTShirt;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-fleece-jacket']") private WebElement productJacket;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-onesie']")private WebElement productOnesie;
	@FindBy(xpath = "//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement productRedShirt;
	@FindBy(xpath = "//span[@class='title']") private WebElement title;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement FacebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement LinkedInLogo;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement footerText;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement dropDown;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-bolt-t-shirt']") private WebElement removeProdBoltTShirt;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-fleece-jacket']") private WebElement removeProdJacekt ;
	//calling
	public Inventory_Page()
	{
		PageFactory.initElements(driver, this);
	}
	//methods
	public String verifyPageTitle()
	{
		return title.getText();
	}
	
	public boolean verifyTwitterLogo()
	{
		return TwitterLogo.isDisplayed();
	}
	
	public boolean verifyFacebookLogo()
	{
		return FacebookLogo.isDisplayed();
	}
	
	public boolean verifyLinkedInLogo()
	{
		return LinkedInLogo.isDisplayed();
	}
	
	public String add6Products()
	{
		HandleDropDownList.handleSelect(dropDown, "Price (low to high)");
		productBackpack.click();
		productBikeLight.click();
		productBoltTShirt.click();
		productJacket.click();
		productOnesie.click();
		productRedShirt.click();
		return cartCount.getText();
	}
	
	public String remove2Products()
	{
		add6Products();//calling add method
		removeProdBoltTShirt.click();
		removeProdJacekt.click();
		return cartCount.getText();
	}
	
	public void clickOnCart()
	{
		cartIcon.click();
	}
	
	
}
