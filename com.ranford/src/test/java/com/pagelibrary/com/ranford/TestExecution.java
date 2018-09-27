package com.pagelibrary.com.ranford;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Excel.Excel_class;

public class TestExecution extends Repository {
	
	@Parameters("browser")
	@BeforeClass
	public void openbrowser() {
		launch("firefox");
		
		
	}
	@Test(priority=0)
	public void loginTest() {
		

		login();	
	}
	
	
	@Test(priority=1)
	public void branchlinkTest()
	{
		branchbtn();
	}
	
	/*@Test(priority=2)
	public void newBranchLinkTest() {
		newbranchlink();
	}*/
	/*@Test(priority= 2,dataProvider="branches")
	public void newBranchTest(String bname, String address1, String address2, String address3, String Area, String zipcode, String country, String state, String city) {
		newbranch(bname,address1,address2,address3,Area,zipcode,country,state,city);
		
	}
	
	@DataProvider(name="branches")
	public Object[][] verify_excelcontent()
	{
		return excelcontent("data.xls","Sheet1");
	}8*/
	@Test(priority=2)
	public void verifyexcel()
	{
		Excel_class.excelconnection("data.xls", "Sheet1");
		Excel_class.output_Excelconnection("data.xls", "output.xls", "Sheet1");
		int c = Excel_class.getcolumns();
		for(int r=1;r<Excel_class.getrows();r++)
		{
			newbranch(Excel_class.readdata(0, r), Excel_class.readdata(1, r), Excel_class.readdata(2, r), Excel_class.readdata(3, r), Excel_class.readdata(4, r), Excel_class.readdata(5, r), Excel_class.readdata(6, r), Excel_class.readdata(7, r), Excel_class.readdata(8, r));
			String text= Generic.Alerthandle(driver).getText();
			
	
			 if(text.contains("created successfully"))
			 {
				 Excel_class.writedata(c++, r, text);
				 c--;
			 }
			 else if(text.contains("Branch name already Exist"))
			 {
				 Excel_class.writedata(c++, r, text);
				 c--; 
			 }
			 else
			 {
				 Excel_class.writedata(c++, r, "N/a");
				 c--;
			 }
			 Generic.Alerthandle(driver).accept();
		}
		
		Excel_class.save_workspace();
			
	}
	@Test(priority=3)
	public void branchsearchTest() {
		branchsearch();
	}
	@Test(priority=4)
	public void branch_up_delete1() {
		branch_up_delete();
		
	}
	/*@Test(priority=5)
	public void roles_linktest() {
		roles_link();
	}
	/*@Test(priority=6,dataProvider="roles")
	public void new_rolestest(String rolename, String desc, String type) {
		new_roles(rolename,desc,type);
		
	}
	@DataProvider(name="roles")
	public Object[][] verify_excelcontent1()
	{
		return excelcontent("data.xls","Sheet2");
	}
	@Test(priority=6)
	public void verify_excel_roles() {
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
	@Test(priority=7)
	public void roles_edit_test() {
		roles_edit();
	}*/

	@Test(priority=5)
	public void logoutTest() {
		logout();
	}

	

}
