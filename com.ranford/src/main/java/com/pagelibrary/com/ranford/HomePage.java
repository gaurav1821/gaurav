package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;
import com.Testbase.Base;



public class HomePage extends Base {
	
	
	
	
		public static WebElement configuserName() {
			WebElement username = driver.findElement(getlocatersname("username"));
         return username;
		}
		public static WebElement configPassword() {
			
			WebElement password = driver.findElement(getlocatersname("password"));
			return password;
		}
		public static WebElement LoginButton() {
			
	
		 WebElement loginbtn = driver.findElement(getlocatersname("loginbutton"));
		return loginbtn;
	}
	

}
