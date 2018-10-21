package page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Admin_Page {
	@FindBy(xpath="//img[@src='images/Branches_but.jpg']")
	public static WebElement branch_link;
	
	@FindBy(xpath="//a[@href='Admin_Roles_details.aspx']")
	public static  WebElement roles_link;
	
	@FindBy(id="//img[@src ='images/admin_but_03.jpg']")
	public static WebElement logout_btn;

}
