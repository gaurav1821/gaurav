package Utility;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Library {

	public static String screenshort(String screenname)
	{
		try {
			Robot r=new Robot();
			
			Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rec=new Rectangle(d);
			BufferedImage bi=r.createScreenCapture(rec);
			ImageIO.write(bi, "png", new File("./screen/"+screenname+".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenname;
	}
}
