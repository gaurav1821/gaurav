package com.pagelibrary.com.ranford;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Excel.Excel_class;

public class TestExecution2 extends Repository {
	@Parameters("browser2")
	@BeforeClass
	public void launch_test() {
		launch("chrome");
	}
	@Test(priority=0)
	public void login_test() {
		login();
	}
	@Test(priority=1)
	public void roles_test() {
		roles_link();
	}
	@Test(priority=2)
	public void new_roles_test() {
		Excel_class.excelconnection("data.xls", "Sheet2");
		Excel_class.output_Excelconnection("data.xls", "output1.xls", "Sheet2");
		int c1=Excel_class.getcolumns();
		for(int r1 = 1; r1< Excel_class.getrows(); r1++) {
			new_roles(Excel_class.readdata(0, r1),Excel_class.readdata(1,r1),Excel_class.readdata(2, r1));
			String text1= Generic.Alerthandle(driver).getText();
			
			
			
			if(text1.contains("created Sucessfully")) {
				Excel_class.writedata(c1++, r1, text1);
				c1--;
				
			}else if(text1.contains("Role Already existed")) {
				Excel_class.writedata(c1++, r1, text1);
				c1--;
			
				
			}else {
				Excel_class.writedata(c1++, r1, "N/A");
				c1--;
			}
			Generic.Alerthandle(driver).accept();
			
			
		}
		Excel_class.save_workspace();
	}
		
	
	@Test(priority=3)
	public void roles_edit_test() {
		roles_edit();
	}
	
	@Test(priority=4)
	public void logout_test() {
		logout();
		
	}
	

}
