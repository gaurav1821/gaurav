package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.Testbase.Base;
import com.pagelibrary.com.ranford.Generic;
import com.pagelibrary.com.ranford.Repository;
import com.relevantcodes.extentreports.LogStatus;

public class TableHandling extends Base {

	static boolean status=false;
	public static void  table(By prop,String operation,String id)
	{
		try {
			boolean flag=false;
			WebElement table=driver.findElement(prop);
			
			List<WebElement> rows=table.findElements(By.tagName("tr"));
			
			String[] pagelinks=rows.get(rows.size()-1).getText().split(" ");
			
			for(int i=1;i<pagelinks.length;i++)
			{
				table=driver.findElement(prop);
				rows=table.findElements(By.tagName("tr"));
				for(WebElement r:rows)
				{
					List<WebElement> columns=r.findElements(By.tagName("td"));
					for(WebElement c:columns)
					{
						if(c.getText().matches(id))
						{
							if(operation.equalsIgnoreCase("edit"))
							{
								columns.get(columns.size()-2).findElement(By.tagName("a")).click();
								driver.findElement(getlocatersname("update_btn")).click();
								if(Generic.Alerthandle(driver).getText().contains("updated Sucessfully")) 
								{
									Reporter.log("update passed");
					                Repository.test.log(LogStatus.PASS, "branchupdt passed");
									Generic.Alerthandle(driver).accept();
								}else
								{
									Repository.test.log(LogStatus.FAIL,"branchupdt fail" );
									Reporter.log("update failed");
								}
								//Generic.Alerthandle(driver).accept();
								
							}
							else if(operation.equalsIgnoreCase("delete"))
							{
								columns.get(columns.size()-1).findElement(By.tagName("a")).click();
								
								Generic.Alerthandle(driver).accept();
								
								if(Generic.Alerthandle(driver).getText().contains("Deleted successfully"))
								{
									Reporter.log("deleted the record");
									Generic.Alerthandle(driver).accept();
									
								}
								else
								{
									Reporter.log("shared record cannot be deleted");
								}
							}
							else
							{
								Reporter.log("operation is failed in table");
							}
							flag=true;
							break;
						}
					}
					if(flag==true)
					{
						break;
					}
				}
				
				if(flag==true)
				{
					break;
				}
				try {
					if(pagelinks[i].contains("...") & status==true)
					{
						driver.findElement(By.xpath("//a[text()='...'][2]")).click();
					}
					else
					{
						table.findElement(By.linkText(pagelinks[i])).click();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pagelinks[i].contains("..."))
				{
					status=true;
					table(prop, operation, id);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
