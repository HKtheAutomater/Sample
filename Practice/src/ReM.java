import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReM {
	
	public static void launchBrowserwithUrl()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Harshal.Kadakia\\Note\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		WebDriver webDriverObject = new FirefoxDriver();
		webDriverObject.get("http://www.google.com");
	}
	
	public static void findLinks(String texttobeFound, WebDriver webDriverObject) throws InterruptedException 
	
	{
		webDriverObject.findElement(By.id("lst-ib")).sendKeys(texttobeFound);
		Thread.sleep(2000);
		webDriverObject.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		int pc = 1; 
		try {
			for (int i = 0; i < pc; i++) {
				webDriverObject.findElement(By.linkText("Next")).isDisplayed();
				{
					webDriverObject.findElement(By.xpath(".//*[@id='pnnext']/span[2]")).click();
					pc = pc + 1;
					Thread.sleep(3000);
					// System.out.println("Total number of pages are: "+pc);
				}
			}
	}
		
		catch (Exception e) {
			//System.out.println("Total number of pages are: " + pc);
			//webDriverObject.quit();
		}
	}
		
	{
		/*Scanner s = new Scanner(System.in);
		System.out.println("Enter you query");
		String h = s.nextLine();*/
	}
		
public static void junk()
{
	try
	{
		int a = 0;
		int b= 1;
		System.out.println(b/a);
		System.out.println("TRY");
	}
	catch(Exception c)
	{
		System.out.println("Catch" +  c.getMessage());
	}
	finally
	{
		System.out.println("Finally");
	}
}
	
	public static String readExcel(String filePath, int sheetNumber,int rowNumber, int colNumber) throws IOException
	{
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(sheetNumber);
		String d = sh.getRow(rowNumber).getCell(colNumber).getStringCellValue();
		return d;
	}
	
	public static void writeExcel(String filePath, int sheetNumber,int rowNumber, int colNumber, String value) throws IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Cell searchText3 = sheet.getRow(rowNumber).getCell(colNumber);
		searchText3.setCellValue(value);
		fis.close();
		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
		fos.close();
	}
	
	
	
	
	
	
	
	

}
