package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;

import com.Testbase.Base;


public class NewBranch  extends Base{
	public static WebElement configBranchName() {
		return driver.findElement(getlocatersname("BranchName"));
	}
	public static WebElement configAdd1() {
		return driver.findElement(getlocatersname("Address1"));
	}
	public static WebElement configAdd2() {
		
		return driver.findElement(getlocatersname("Address2"));
	}
	public static WebElement configAdd3() {
		return driver.findElement(getlocatersname("Address3"));
		
	}
	public static WebElement configArea() {
		return driver.findElement(getlocatersname("Area"));
		
	}
	public static WebElement configZipcode() {
		return driver.findElement(getlocatersname("ZipCode"));
		
		
		
		}
	public static WebElement configCountry() {
		return driver.findElement(getlocatersname("Country"));
		
	}
	public static WebElement configState() {
		return driver.findElement(getlocatersname("State"));
		
	}
	public static WebElement configCity() {
		return driver.findElement(getlocatersname("City"));
	}
	public static WebElement configsubmit() {
		return driver.findElement(getlocatersname("Submitbtn"));
		
	}
	public static WebElement configReset() {
		return driver.findElement(getlocatersname("Resetbtn"));
		
	}
	public static WebElement configcancel() {
		return driver.findElement(getlocatersname("Cancelbtn"));
	}
	

}
