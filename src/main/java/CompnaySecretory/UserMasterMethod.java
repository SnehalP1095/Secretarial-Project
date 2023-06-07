package CompnaySecretory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UserMasterMethod 
{
private static List<WebElement> elementsList = null;

	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static XSSFSheet sheet1 = null;		//Sheet variable


	
	public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Snehal\\ComplianceLatest\\Secreterial\\TestData\\SecreterialSheet3.xlsx");
		
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	public static void AddUser(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		sheet = workbook.getSheetAt(0);	
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
	    Locator.selectImg(driver).click();
		Thread.sleep(2000);
	     Locator.ClickMaster(driver).click();
	    
		//js.executeScript("window.scrollBy(0,500)");
		//js.executeScript("document.querySelector("div[id='ascrail2001'] div").scrollLeft=5000");
	  
		Thread.sleep(3000);
	    Locator.clickUser(driver).click();
	   
		Thread.sleep(2000);
	    Locator.clickNewUser(driver).click();
		   
	    Thread.sleep(2000);
	    XSSFSheet sheet = ReadExcel();
		Row row = sheet.getRow(9);						//Selected 1st index row (Second row)
		Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
		String Firstname = c.getStringCellValue();			//Got the URL stored at position 1,1
		Locator.clickFirstName(driver).sendKeys(Firstname);
		
		Thread.sleep(2000);
		Row row1 = sheet.getRow(10);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String Lastname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		Locator.clickLastName(driver).sendKeys(Lastname);
		
		Thread.sleep(2000);
		Row row2 = sheet.getRow(11);						//Selected 1st index row (Second row)
		Cell c2 = row2.getCell(1);						//Selected cell (1 row,1 column)
		String Email = c2.getStringCellValue();			//Got the URL stored at position 1,1
		Locator.clickEmail(driver).sendKeys(Email);
		
		Thread.sleep(2000);
//		Row row3 = sheet.getRow(12);						//Selected 1st index row (Second row)
//		Cell c3 = row3.getCell(1);						//Selected cell (1 row,1 column)
//		int ContactNo = (int) c1.getNumericCellValue();		//Got the URL stored at position 1,1
//		Locator.clickContactNo(driver).sendKeys(ContactNo + "");
		
		Locator.clickContactNo(driver).sendKeys("2312343234");
		
		Locator.clickAddress(driver).sendKeys("Pune");
		
		Thread.sleep(2000);
		Locator.clickSecreterialRole(driver).click();
		Thread.sleep(2000);
		Locator.SelectSecreterialRole(driver).click();
		Thread.sleep(2000);
		Locator.ClickSaveBtn(driver).click();
		
		
		 Thread.sleep(3000);
		 String msg1 = Locator.ValidationUserMsg1(driver).getText();
			if(msg1.contains("Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Message Dispalyed = User " +msg1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message Dispalyed =" +msg1);
			}
			
			Thread.sleep(4000);
			Locator.CloseUserPopup(driver).click();
			Thread.sleep(4000);
			  EntityLocator.ClickDashboard(driver).click();
	}
	public static void UpdateUser(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(2000);
	    Locator.selectImg(driver).click();
		Thread.sleep(2000);
	     Locator.ClickMaster(driver).click();
	    
		//js.executeScript("window.scrollBy(0,500)");
		//js.executeScript("document.querySelector("div[id='ascrail2001'] div").scrollLeft=5000");
	  
		Thread.sleep(3000);
	    Locator.clickUser(driver).click();
			
			Thread.sleep(2000);
			Locator.ClickEditUser(driver).click();
			
			Thread.sleep(2000);
			Locator.clickFirstName(driver).clear();
			Thread.sleep(2000);
		    
			Row row4 = sheet.getRow(13);						//Selected 1st index row (Second row)
			Cell c4 = row4.getCell(1);						//Selected cell (1 row,1 column)
			String Firstname1 = c4.getStringCellValue();			//Got the URL stored at position 1,1
			Locator.clickFirstName(driver).sendKeys(Firstname1);
			
			Thread.sleep(2000);
			Locator.ClickSaveBtn(driver).click();
			Thread.sleep(3000);
			 String msg2 = Locator.ValidationUserMsg1(driver).getText();
				if(msg2.contains("Updated Successfully"))
				{
					test.log(LogStatus.PASS, "Message Dispalyed = User " +msg2);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message Dispalyed =" +msg2);
				}
				Thread.sleep(2000);
				Locator.CloseUserPopup(driver).click();
				Thread.sleep(4000);
				  EntityLocator.ClickDashboard(driver).click();
	}
				

				
	public static void FilterUser(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{	
		
		Thread.sleep(2000);
	    Locator.selectImg(driver).click();
		Thread.sleep(2000);
	     Locator.ClickMaster(driver).click();
	    
		//js.executeScript("window.scrollBy(0,500)");
		//js.executeScript("document.querySelector("div[id='ascrail2001'] div").scrollLeft=5000");
	  
		Thread.sleep(3000);
	    Locator.clickUser(driver).click();		
		Thread.sleep(2000);
		Locator.ClickFilter(driver).sendKeys("Director");
				
		String msg="Director";
				
		if(msg.equalsIgnoreCase(msg))
		{
			test.log(LogStatus.PASS, "Filter Work Successfully");
		}
		else
		{
		    test.log(LogStatus.FAIL, "Filter Dose not Work Successfully");
		}
		Thread.sleep(4000);
		EntityLocator.ClickDashboard(driver).click();
	}
	public static void WithoutEnteringDataUser(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
				//Without Entering data 
		Thread.sleep(2000);
	    Locator.selectImg(driver).click();
		Thread.sleep(2000);
	     Locator.ClickMaster(driver).click();
	    
		//js.executeScript("window.scrollBy(0,500)");
		//js.executeScript("document.querySelector("div[id='ascrail2001'] div").scrollLeft=5000");
	  
		Thread.sleep(3000);
	    Locator.clickUser(driver).click();	
				Thread.sleep(2000);
			    Locator.clickNewUser(driver).click();
			    
			    Thread.sleep(2000);
				Locator.ClickSaveBtn(driver).click();
				
				String msg3=Locator.FNValidMsg(driver).getText();
				String msg4=Locator.LNValidMsg(driver).getText();
				String msg5=Locator.EmailValidMsg(driver).getText();
				String msg6=Locator.ContactNoValidMsg(driver).getText();
				
				 test.log(LogStatus.PASS, "Without entering data = " +msg3 +"," +msg4 +"," +msg5 +"," +msg6);
				 
				   Thread.sleep(4000);
					Locator.CloseUserPopup(driver).click();
					Thread.sleep(4000);
					EntityLocator.ClickDashboard(driver).click();
	}
					
					
	public static void EnterInvalidDataUser(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{				
					//Enter invalid data
	               Thread.sleep(2000);
                    Locator.selectImg(driver).click();
	               Thread.sleep(2000);
                   Locator.ClickMaster(driver).click();
    
	
  
	                  Thread.sleep(3000);
                      Locator.clickUser(driver).click();	
					Thread.sleep(2000);
				    Locator.clickNewUser(driver).click();
				    Thread.sleep(2000);
					Locator.clickFirstName(driver).sendKeys("GFD5$455");
					Thread.sleep(2000);
					Locator.clickLastName(driver).sendKeys("jgfgty$3");
					Thread.sleep(2000);
					Locator.clickEmail(driver).sendKeys("gag@bam");
					Thread.sleep(2000);
					Locator.clickContactNo(driver).sendKeys("231234");
					Thread.sleep(2000);
					Locator.clickAddress(driver).sendKeys("Pu#ne");
					
					Thread.sleep(2000);
					Locator.ClickSaveBtn(driver).click();
					
					
					String msg7=Locator.FNValidMsg(driver).getText();
					String msg8=Locator.LNValidMsg(driver).getText();
					String msg11=Locator.EmailValidMsg(driver).getText();
					String msg12=Locator.ContactNoValidMsg(driver).getText();
					
					 test.log(LogStatus.PASS, "Enter Invalid Data = " +msg7 +"," +msg8 +"," +msg11 +"," +msg12);
					
					
					 Thread.sleep(4000);
						Locator.CloseUserPopup(driver).click();
						Thread.sleep(4000);
						EntityLocator.ClickDashboard(driver).click();
	}
						
	public static void EnterValidDataUser(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{					
						// valid Data Accept 
						
						Thread.sleep(2000);
					    Locator.clickNewUser(driver).click();
					    Thread.sleep(2000);
						Locator.clickFirstName(driver).sendKeys("Sneha");
						Thread.sleep(2000);
						Locator.clickLastName(driver).sendKeys("Patil");
						Thread.sleep(2000);
						Locator.clickEmail(driver).sendKeys("sneha@gmail.com");
						Thread.sleep(2000);
						Locator.clickContactNo(driver).sendKeys("2313454234");
						Thread.sleep(2000);
						Locator.clickAddress(driver).sendKeys("Pune");
						
						Thread.sleep(2000);
						Locator.ClickSaveBtn(driver).click();
						
						
						 Thread.sleep(3000);
						 String msg13 = Locator.ValidationUserMsg1(driver).getText();
							if(msg13.contains("Saved Successfully"))
							{
								test.log(LogStatus.PASS, "Enter Valid Data= User " +msg13);
							}
							else
							{
								test.log(LogStatus.FAIL, "Enter Valid Data =" +msg13);
							}
						
							 Thread.sleep(4000);
								Locator.CloseUserPopup(driver).click();
								Thread.sleep(4000);
								EntityLocator.ClickDashboard(driver).click();
	}
						
						
		
	}
	
	

