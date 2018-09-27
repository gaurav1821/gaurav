package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Testbase.Base;

public class Roles_page extends Base {
	public static WebElement new_Role() {
		return driver.findElement(getlocatersname("new_roles"));
	}
	public static WebElement rolename() {
		return driver.findElement(getlocatersname("role_name"));
	}
	public static WebElement role_desc() {
		return driver.findElement(getlocatersname("role_desc"));
	}
	public static Select role_type() {
		return Generic.Dropdownhandle(driver, getlocatersname("role_type"));
	}
	public static WebElement role_submit() {
		return driver.findElement(getlocatersname("role_submit"));
	}

}
