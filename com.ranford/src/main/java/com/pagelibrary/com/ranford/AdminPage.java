package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;

import com.Testbase.Base;

public class AdminPage extends Base {
	public static WebElement Brancheslink() {
		WebElement Br_link =  driver.findElement(getlocatersname("branches"));
		return Br_link;
	}
	public static WebElement roles_link()
	{
		return driver.findElement(getlocatersname("roleslink"));
	}
	public static WebElement users_link() {
		return driver.findElement(getlocatersname("userslink"));
	}
	public static WebElement employee_link() {
		return driver.findElement(getlocatersname("employeelink"));
	}
	public static WebElement logout() {
		return driver.findElement(getlocatersname("logoutbtn"));
	}
	
	

}
