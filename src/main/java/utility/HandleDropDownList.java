package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDownList 
{
	public static void handleSelect(WebElement ele,String value)
	{
		Select s=new Select(ele);//webelement
		s.selectByVisibleText(value);//options
	}
	
}
