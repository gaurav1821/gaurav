package com.pagelibrary.com.ranford;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Testbase.Base;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Excel.Excel_class;
import Utility.Library;
import Utility.Validation;
import webtable.TableHandling;

public class Repository extends Base  {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void extentreport()
	{
		
		extent=new ExtentReports(".\\ExtentReport\\reporterhtml.html",true);
		
	}
	@BeforeMethod
	public void beforemethod(Method method)
	{
		test=extent.startTest((this.getClass().getSimpleName()+" :: "+method.getName()));
		test.assignAuthor("Gaurav");
		test.assignCategory("Regression");
	}
	
	public void launch(String bname) 
	{
		if(bname.equals("firefox")) {
		
		driver= new FirefoxDriver();
		}else if (bname.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver2.exe");
			driver=new ChromeDriver();
		}else {
			System.out.println("Browser not found");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(getconfig("buildurl2"));
		
		String actualurl=driver.getCurrentUrl();
		String exp=getconfig("buildurl2");
		
		
			try {
				if(Validation.Title_Velidation("KEXIM BANK"))
				{
					Reporter.log("Launch passed");

				}
				else
				{
					Reporter.log("Launch failed");
					test.log(LogStatus.FAIL,"exp value of page is " +exp+ " is not matching with my actual"+actualurl+""+test.addScreenCapture(Library.screenshort("launch")));
					Library.screenshort("launch");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("eXCEPTION OCCUR");
			}
			
		
	}
	
	
		
	
	public void login()
	{
		HomePage.configuserName().sendKeys(getconfig("username"));
		HomePage.configPassword().sendKeys(getconfig("password"));
		HomePage.LoginButton().click();
		
		try {
			if(Validation.Title_Velidation("KEXIM BANK")) 
			{
				test.log(LogStatus.PASS, "login test passed");
				Reporter.log("login passed");
			}
			else
			{
				test.log(LogStatus.INFO, "login test fail");
				test.log(LogStatus.FAIL, test.addScreenCapture(Library.screenshort("login")));
				Reporter.log("login fail");
				Library.screenshort("login");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ex");
		}
		
	}
	public void branchbtn() {
		
		AdminPage.Brancheslink().click();
		
		try {
			if(Validation.Title_Velidation("admin_banker_master"))
			
			{
				test.log(LogStatus.PASS, "branchbtn passed");
				Reporter.log("branchbtn passed");
			}
			else
			{
				test.log(LogStatus.INFO, "branchbtn failed");
				test.log(LogStatus.FAIL, test.addScreenCapture(Library.screenshort("branchlink")));
				Reporter.log("branchbtn fail");
				Library.screenshort("branchespage");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	public void branchsearch() {
		
		
		AdminPage.Brancheslink().click();
		Generic.Dropdownhandle(driver, getlocatersname("countrydropdown")).selectByVisibleText(getconfig("countrydropV"));
		Generic.Dropdownhandle(driver, getlocatersname("statedropdown")).selectByVisibleText(getconfig("statedropV"));
		Generic.Dropdownhandle(driver, getlocatersname("citydropdown")).selectByVisibleText(getconfig("citydropV"));
		
		/*WebElement ww1 = 	BranchesPage.configCountry();
		Select sel1 = new Select(ww1);
		sel1.selectByVisibleText("INDIA");
		WebElement ww2 =	BranchesPage.configState();
		Select sel2 = new Select(ww2);
		sel2.selectByVisibleText("GOA");
		WebElement ww3	= BranchesPage.configCity();
		Select sel3 = new Select(ww3);
		sel3.selectByVisibleText("GOA");*/
		
		
		
		
	
		
	

	 BranchesPage.configSearchbtn();
	
				
}
	public void newbranchlink() 
	{
		BranchesPage.configNewBranch().click();
	
		if(Validation.IsTextPresent("Welcome to Admin"))
		{
			test.log(LogStatus.PASS, "newbranchlink passed");
			Reporter.log("newbranchlink test passed");
			
			
		}
		else
			
		{
			test.log(LogStatus.INFO, "newbranchlink failed");
			test.log(LogStatus.FAIL, test.addScreenCapture(Library.screenshort("newbranchlink")));
			Reporter.log("new_branchlink failed");
			Library.screenshort("newbranchpage");
		}
	}
	
	public void newbranch(String bname, String address1, String address2, String address3, String Area, String zipcode, String country, String state, String city) {
		BranchesPage.configNewBranch().click();
		NewBranch.configBranchName().sendKeys(bname);
		NewBranch.configAdd1().sendKeys(address1);
		NewBranch.configAdd2().sendKeys(address2);
		NewBranch.configAdd3().sendKeys(address3);
		NewBranch.configArea().sendKeys(Area);
		NewBranch.configZipcode().sendKeys(zipcode);
		Generic.Dropdownhandle(driver, getlocatersname("CountryDropdown(N_B_entry)")).selectByVisibleText(country);
		Generic.Dropdownhandle(driver, getlocatersname("StateDropDown(N_B_entry)")).selectByVisibleText(state);
		Generic.Dropdownhandle(driver, getlocatersname("CityDropDown(N_B_entry)")).selectByVisibleText(city);
	    NewBranch.configsubmit().click();
	    
	    
	  /* try {
		
		   if( Validation.Alert_Velidation("New Branch with id created Sucessfully"))
		   {
			   test.log(LogStatus.PASS, "newbranch test passed");
			   Reporter.log("newbranch test passed");
		   }
		   else {
			   test.log(LogStatus.INFO, "branch is already exit");
			   test.log(LogStatus.FAIL, test.addScreenCapture(Library.screenshort("branchcreation")));
			  
			   Reporter.log("new branch test fail");
			  // Library.screenshort("new_branch");
		   }
	} 
	   catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	   
	   
			
		} 
	
	public void logout() {
		AdminPage.logout().click();
	}
	/*public void branchdlt()
	{
		List<WebElement> pagination = driver.findElements(By.xpath("//table[@id='DG_bankdetails']/tbody/tr[7]/td/a"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(pagination));
		for(int i=0; i<pagination.size()-1; i++) {
			  getElementWithIndex(locator, pos).click();
		}
		
		
		}
	
	while(true) {
			int count =1;
			
		
		
		try {
			for(int i=1; i<=pagination.size()-3; i++)
			{
				pagination.get(i);
				driver.findElement(By.xpath("//td[text()='Bhavani23']/../../tr[3]/td[8]/a")).click();
			
			}break;
		}
		catch (Exception e) {
			// TODO: handle exception
		
			if (count==1) {driver.findElement(By.xpath("//a[text()='...']")).click();
				
		} 
			else {
			driver.findElement(By.xpath("//a[text()='...'][2]")).click();
		}
		}
		count++;
	}
	
		
		BranchesPage.connfigdelete().click();
		BranchesPage.configpopup().accept();
	System.out.println(BranchesPage.configpopup().getText());
		
	}
	
	
	
	}*/
	
	public void branch_up_delete()
	{
		//AdminPage.Brancheslink().click();
		TableHandling.table(getlocatersname("branch_Webtable"), "edit", "237");
		
	}
	public void roles_link() {
		AdminPage.roles_link().click();
		if(Validation.Title_Velidation("Admin_Roles_details")) {
			test.log(LogStatus.PASS, "roles link passed");
		}else {
			test.log(LogStatus.FAIL, "roles link failed");
			Library.screenshort("Roleslink");
		}
	}
	public void new_roles(String rolename, String desc, String type) {
		Roles_page.new_Role().click();
		Roles_page.rolename().sendKeys(rolename);
		Roles_page.role_desc().sendKeys(desc);
		Roles_page.role_type().selectByVisibleText(type);
		Roles_page.role_submit().click();
		
	}
	
	public void roles_edit() {
		TableHandling.table(getlocatersname("roles_Webtable"), "edit", "53");
		
	}
	public void roles_delete() {
		TableHandling.table(getlocatersname("roles_Webtable"), "delete", "");
	}
	@AfterClass
	public void closebrowser() {
		driver.close();
	}
	@AfterSuite
	public void verifyflush()
	{
		extent.flush();
	}
	
	public Object[][] excelcontent(String filename,String sheet)
	{
		Excel_class.excelconnection(filename, sheet);
		
		int rc=Excel_class.getrows();
		int cc=Excel_class.getcolumns();
		
		String[][] data=new String[rc-1][cc];
		
		for(int r=1;r<rc;r++)
		{
			for(int c=0;c<cc;c++)
			{
				
				data[r-1][c]=Excel_class.readdata(c, r);
				
					
				
			}
		}
		
		return data;
		
	}
}




		
	
	
	
	


