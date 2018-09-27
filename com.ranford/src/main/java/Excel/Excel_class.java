package Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import com.Testbase.Base;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Excel_class  extends  Base {
	
	public static String folderpath = getconfig("folderpath");
	static Workbook wb;
	static Sheet sh;
	static WritableWorkbook wwb;
	static WritableSheet wsh;
	public static void excelconnection(String filename,String sheet)
	{
		try {
			FileInputStream fis=new FileInputStream(folderpath+filename);
			
			wb=Workbook.getWorkbook(fis);
			System.out.println(wb);
			sh=wb.getSheet(sheet);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static int getrows()
	{
		int rows=sh.getRows();
		return rows;
	}
	public static int getcolumns()
	{
		int rows=sh.getColumns();
		return rows;
	}

	public static  String readdata(int col,int row) 
	{
		 
			String x = sh.getCell(col, row).getContents();
		
		return x;
	}
	public static void output_Excelconnection(String ifilename, String ofilename,String sheet) {
		try {
			FileInputStream fis = new FileInputStream(folderpath+ifilename);
			wb= Workbook.getWorkbook(fis);
			sh= wb.getSheet(sheet);
			FileOutputStream fos = new FileOutputStream(folderpath+ofilename);
			wwb =Workbook.createWorkbook(fos,wb);
			wsh= wwb.getSheet(sheet);
		} catch (Exception e) {
			System.out.println("system");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void writedata(int col,int row,String data)
	{
		try {
			Label l=new Label(col, row, data);
			wsh.addCell(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("exception 1");
		} 
	}
	public static void save_workspace() {
		try {
			wwb.write();
			wwb.close();
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
