package Utility;

import org.openqa.selenium.By;

import com.Testbase.Base;

public class Validation extends Base {
	
	public static  boolean  IsTextPresent(String exp_expactedTitle)
	{
		boolean b=driver.findElement(By.tagName("tbody")).getText().contains(exp_expactedTitle);
		return b;
	}
	public static boolean Title_Velidation(String expactedTitle) 
	{
		return driver.getTitle().contains(expactedTitle);
	}
	public static boolean Alert_Velidation(String exp_Alert) {
		return driver.switchTo().alert().getText().contains(exp_Alert);
	}

}
