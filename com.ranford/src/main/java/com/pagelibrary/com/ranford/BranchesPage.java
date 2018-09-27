package com.pagelibrary.com.ranford;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import com.Testbase.Base;

public class BranchesPage extends Base{
	public static WebElement configCountry() {
		 return driver.findElement(getlocatersname("countrydropdown"));
		
			
		
	}
	public static WebElement configState(){
		 return driver.findElement(getlocatersname("statedropdown"));
		

	}
	public static WebElement configCity() {
	 return driver.findElement(getlocatersname("citydropdown"));
		
	}
	public static WebElement configSearchbtn() {
		WebElement Searchbtn = driver.findElement(getlocatersname("searchbtn"));
		return Searchbtn;
	}
	public static WebElement configclearbtn() {
		return driver.findElement(getlocatersname("clearbtn"));
	}
	public static WebElement configNewBranch() {
		return driver.findElement(getlocatersname("newbranch"));
	}
	public static WebElement configbranchpage17() {
		
		return driver.findElement(getlocatersname("17thpage"));
	}
	public static WebElement confignextbtn() {
		return driver.findElement(getlocatersname("nextbtn"));
	}
	public static WebElement connfigdelete() {
		return driver.findElement(getlocatersname("deletebank"));
		
	}
	public static Alert configpopup() {
		Alert alt = driver.switchTo().alert();
		return alt;
	
			
		
		
		
		
	}
	

	
	
	

}
