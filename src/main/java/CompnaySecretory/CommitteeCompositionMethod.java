package CompnaySecretory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class CommitteeCompositionMethod {
	
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
	 public static void CommitteeComposition(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	 {
			Thread.sleep(2000);
		    Locator.selectImg(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickMaster(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickCommitteeCompistion(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickNewBtn(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickEntity(driver).click();
		 Thread.sleep(2000);
		 Locator.SelectEntity(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickCommittee(driver).click();
		 Thread.sleep(2000);
		 Locator.SelectCommittee(driver).get(8).click();
		 Thread.sleep(2000);
		 Locator.ClickCommittee(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickDirector(driver).click();
		 Thread.sleep(4000);
		 Locator.SelectDirector(driver).get(3).click();
		 Thread.sleep(3000);
		 Locator.ClickPostion(driver).click();
		 Thread.sleep(3000);
		 Locator.SelectPostion(driver).click();
		 Thread.sleep(3000);
		 Locator.DateOfAppoinment(driver).sendKeys("04/03/2023");
		 Thread.sleep(3000);
		 Locator.DateofCessation(driver).sendKeys("02/04/2023");
		 Thread.sleep(3000);
		 Locator.SaveBtn1(driver).click();
		 
		 Thread.sleep(3000);
		 String msg = Locator.ValidationMsgCommittee(driver).getText();
			if(msg.contains("Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Message Dispalyed =" +msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message Dispalyed =" +msg);
			}
			
			 Thread.sleep(3000);
			 Locator.CloseBtn(driver).click();
			 
				Thread.sleep(4000);
				  EntityLocator.ClickDashboard(driver).click();
	 }
			 
	 public static void WithoutEnteringData(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	  { 
			 //Without Entering Data
			 
		 Thread.sleep(2000);
		    Locator.selectImg(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickMaster(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickCommitteeCompistion(driver).click();
			 Thread.sleep(2000);
			 Locator.ClickNewBtn(driver).click();
			 
			 Thread.sleep(3000);
			 Locator.SaveBtn1(driver).click();
			 
			 Thread.sleep(3000);
			 String msg1 = Locator.ValidationMsgCommittee1(driver).getText();
				if(msg1.contains("Please Select Committee."))
				{
					test.log(LogStatus.PASS, "Without entering data =" +msg1);
				}
				else
				{
					test.log(LogStatus.FAIL, "Without entering data =" +msg1);
				}
			 
				 Thread.sleep(3000);
				 Locator.CloseBtn(driver).click();
					Thread.sleep(4000);
					  EntityLocator.ClickDashboard(driver).click();
	  }
	 public static void CloseBtnCommitteeComposition(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	  { 	 
			//Close Button working or not
		 Thread.sleep(2000);
		    Locator.selectImg(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickMaster(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickCommitteeCompistion(driver).click();
				 Thread.sleep(2000);
				 Locator.ClickNewBtn(driver).click();
				 
					Thread.sleep(4000);
					WebElement text=driver.findElement(By.xpath("//*[@id='btnclose1']"));
					 
					 
					 if(text.isEnabled())
						{
						     Locator.CloseBtn(driver).click();
							
							test.log(LogStatus.PASS, "Close button is clickable");
							
						}
					 Thread.sleep(4000);
					  EntityLocator.ClickDashboard(driver).click();
	  }
	 public static void DateFormatCommitteeComposition(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	  { 
			 //Date format dd/mm/yyyy accept or not
		 Thread.sleep(2000);
		    Locator.selectImg(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickMaster(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickCommitteeCompistion(driver).click();
					 Thread.sleep(2000);
					 Locator.ClickNewBtn(driver).click();
					 Thread.sleep(2000);
					 Locator.ClickEntity(driver).click();
					 Thread.sleep(2000);
					 Locator.SelectEntity(driver).click();
					 Thread.sleep(2000);
					 Locator.ClickCommittee(driver).click();
					 Thread.sleep(2000);
					 Locator.SelectCommittee(driver).get(3).click();
					 Thread.sleep(2000);
					 Locator.ClickCommittee(driver).click();
					 Thread.sleep(2000);
					 Locator.ClickDirector(driver).click();
					 Thread.sleep(4000);
					 Locator.SelectDirector(driver).get(2).click();
					 Thread.sleep(3000);
					 Locator.ClickPostion(driver).click();
					 Thread.sleep(3000);
					 Locator.SelectPostion(driver).click();
					 Thread.sleep(3000);
					 Locator.DateOfAppoinment(driver).sendKeys("05/03/2023");
					 Thread.sleep(3000);
					 Locator.DateofCessation(driver).sendKeys("06/04/2023");
					 Thread.sleep(3000);
					 Locator.SaveBtn1(driver).click();
					 
					 Thread.sleep(3000);
					 String msg3 = Locator.ValidationMsgCommittee(driver).getText();
						if(msg3.contains("Saved Successfully"))
						{
							test.log(LogStatus.PASS, "Accept DD/MM/YYYY date Format =" +msg3);
						}
						else
						{
							test.log(LogStatus.FAIL, "Accept DD/MM/YYYY date Format =" +msg3);
						}
						
						 Thread.sleep(3000);
						 Locator.CloseBtn(driver).click();
						 Thread.sleep(4000);
						  EntityLocator.ClickDashboard(driver).click();
	  }
	 public static void UpdateCommitteeComposition(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	  { 
		 Thread.sleep(2000);
		    Locator.selectImg(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickMaster(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickCommitteeCompistion(driver).click();	

		     Thread.sleep(3000);
			 Locator.clickdropdown(driver).click();
			 Thread.sleep(3000);
			 Locator.selectdropdown(driver).click();
		     Thread.sleep(3000);
			 Locator.clickediticon(driver).click();
			 Thread.sleep(3000);
			 Locator.ClickPostion(driver).click();
			 Thread.sleep(3000);
			 Locator.SelectPostion1(driver).click();
			 Thread.sleep(3000);
			 Locator.SaveBtn1(driver).click();
			 
			 Thread.sleep(3000);
			 String msg2 = Locator.ValidationMsgCommittee(driver).getText();
				if(msg2.contains("Update Successfully"))
				{
					test.log(LogStatus.PASS, "Message Dispalyed =" +msg2);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message Dispalyed =" +msg2);
				} 
				
				Thread.sleep(3000);
				 Locator.CloseBtn(driver).click(); 
				 
				 Thread.sleep(4000);
				  EntityLocator.ClickDashboard(driver).click();
	  }
	 
	 public static void DeleteCommitteeComposition(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	  { 		 
		 Thread.sleep(2000);
		    Locator.selectImg(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickMaster(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickCommitteeCompistion(driver).click();
				 Locator.clickdropdown(driver).click();
				 Thread.sleep(3000);
				 Locator.selectdropdown(driver).click();
				 
				 Thread.sleep(3000);
				 Locator.clickdeleteicon(driver).click();
				 
				 Thread.sleep(5000);
				    // Switching to Alert        
			        Alert alert1 = driver.switchTo().alert();		
			        		
			        // Capturing alert message.    
			        String alertMessage1= driver.switchTo().alert().getText();	
			        
			        
			        test.log(LogStatus.PASS, alertMessage1);
			        		
			        // Displaying alert message		
			        System.out.println(alertMessage1);
			        
			     // Accepting alert		
			        alert1.accept();
			   	 
					 Thread.sleep(4000);
					  EntityLocator.ClickDashboard(driver).click();
	  }
		
	 public static void ExportToPDFCommitteeComposition(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
    { 
		 
		 Thread.sleep(2000);
		    Locator.selectImg(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickMaster(driver).click();
		 Thread.sleep(2000);
		 Locator.ClickCommitteeCompistion(driver).click();
			            Thread.sleep(100);
						File dir = new File("C://Users//Admin//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						Thread.sleep(250);
						Locator.clickExportToPdf(driver).click();					//Clicking on 'Excel Report' image.
						Thread.sleep(5500);
						File dir1 = new File("C://Users//Admin//Downloads");
						File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
						
						if(dirContents.length < allFilesNew.length)
						{
							
							
							test.log(LogStatus.PASS, "File downloaded successfully.");
						}
						else
						{
							test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
						}
						
						 
						 Thread.sleep(4000);
						  EntityLocator.ClickDashboard(driver).click();
						
					
	 }

}
