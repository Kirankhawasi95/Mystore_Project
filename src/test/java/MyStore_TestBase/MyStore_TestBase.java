package MyStore_TestBase;
/**
 * 
 */

import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.io.*;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author kpkmt942
 *
 */
public class MyStore_TestBase {
	
	public static WebDriver driver;
	public static WebElement ele;
	
	public static Properties  pro;
	public static ResourceBundle rb;
	
	@BeforeClass
	public void Launch_Application() throws IOException
	{
		rb=ResourceBundle.getBundle("Config");
//		pro=new Properties();
//		FileInputStream reader=new FileInputStream(System.getProperty("user.dir") + "\\Config\\");
//		pro.load(reader);
		
		driver = new ChromeDriver();
		
		driver.get(rb.getString("BaseURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	@AfterClass
	public void Close()
	{
		driver.quit();
	}
	
	//Method Generate the random string for Newaccount Reg (Fname,Lname,Email,Password)
	//To generate this add a (org.apache) library in POM.xml file
	
	public String GenRandomString()
	{
		String Reandomstring=RandomStringUtils.randomAlphabetic(5);
		return Reandomstring;
	}
	
	public String GenRandomNumber()
	{
		String ReandomNumber=RandomStringUtils.randomAlphanumeric(10);
		return ReandomNumber;
	}
	
	public String GenRandomEmail()
	{
		String str=RandomStringUtils.randomAlphabetic(4);
		String number=RandomStringUtils.randomAlphanumeric(2);
		return str+number;
	}
	
	public String CapctureScreen(String Tname)
	{	String TimeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	
	TakesScreenshot ScreenShoot = (TakesScreenshot) driver;
	File srcfile = ScreenShoot.getScreenshotAs(OutputType.FILE);
	String destfile = System.getProperty("user.dir") + "\\Screenshot2\\" + Tname + "_" + TimeStamp + ".Png";
	
	try {
	FileUtils.copyFile(srcfile,new File(destfile));
	
	}catch(Exception e)
	
	{
		e.getMessage();
	}
	return destfile;
		
	}
	

}
