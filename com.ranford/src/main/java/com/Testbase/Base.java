package com.Testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base {
	 static Properties p;
	 static public WebDriver driver;
	public static void loadconfigproperty() 
	{
		
		try {
				File f=new File(".\\src\\main\\java\\configuration\\config.properties");
				 
				FileReader fr=new FileReader(f);
				 p=new Properties();
				 
				 p.load(fr);
				 }
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static  String    getconfig(String key)
	{
		loadconfigproperty();
		    String value= p.getProperty(key);
		    return  value;
	}
		
		public static void configOr() {		
	try
		{
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\configuration\\objectrepository.properties");
			p= new Properties();
			p.load(fis);
			}
	
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
		
	
	

		
	
	public static By getlocatersname(String key) {
		configOr();
		String value2 = p.getProperty(key);
		String locatername = value2.split(":")[0];
		String locateradd = value2.split(":")[1];
		By BY = null ;
		switch(locatername){
		
		
		case "id":
		
			BY= By.id(locateradd);
			 break;
			
		
		case "name":
		
			BY = By.name(locateradd);
			 break;
		
		case"xpath":
		
			 BY = By.xpath(locateradd);
			 break;
		
		case "classname":
		
			BY = By.className(locateradd);
			 break;
		}
		return BY;
	} 
}
	

