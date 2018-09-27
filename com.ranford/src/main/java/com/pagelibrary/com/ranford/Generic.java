package com.pagelibrary.com.ranford;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Generic {

	public static Select  Dropdownhandle(WebDriver driver,By prop)
	{
		Select s=new Select(driver.findElement(prop));
		return s;
	}
	public static Select  Dropdownhandle2(WebDriver driver,By prop,String exp)
	{
		Select s=new Select(driver.findElement(prop));
		
		List<WebElement> list= s.getOptions();
		
		for(WebElement li:list)
		{
			String actual=li.getText();
			System.out.println(actual);
			if(actual.contains(exp))
			{
				s.selectByVisibleText(exp);
			}
		}
		return s;
	}
	public static Select Dropdownhandle3(WebDriver driver, By prop1 ) {
		Select s1 = new Select(driver.findElement(prop1));
		return s1;
	}
	public static  Alert Alerthandle(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		return a;
	}
	
}
