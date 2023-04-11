package CompnaySecretory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AuditorMasterMethod 
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
	
	public static void AuditorPage(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException
	{
		sheet = workbook.getSheetAt(0);	
		Thread.sleep(2000);
	    Locator.selectImg(driver).click();
	    Thread.sleep(2000);
	    Locator.ClickMaster(driver).click();
	    Thread.sleep(2000);
	    Locator.clickAuditor(driver).click();
	    
	    //Statutory Auditor
	    
	  /*  Thread.sleep(2000);
	    Locator.clickAuditorNew(driver).click();
	    Thread.sleep(2000);
	    Locator.clickAuditorCreateNew(driver).click();
	    Thread.sleep(2000);
	    Locator.clickAuditorType(driver).click();
	    Thread.sleep(2000);
	    Locator.SelectAuditorTypeDropDown(driver).click();
	    Thread.sleep(2000);
	    Locator.clickCategoryOfAuditor(driver).click();
	    Thread.sleep(2000);
	    Locator.SelectCategoryOfAuditor(driver).get(1).click();
		
		Thread.sleep(2000);
	    Row row = sheet.getRow(16);						//Selected 1st index row (Second row)
		Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
		String name = c.getStringCellValue();			//Got the URL stored at position 1,1
		Locator.clickAuditorName(driver).sendKeys(name);
		
		Thread.sleep(2000);
		Row row1 = sheet.getRow(17);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String email = c1.getStringCellValue();			//Got the URL stored at position 1,1
		Locator.clickAuditorEmail(driver).sendKeys(email);
		
		Thread.sleep(2000);
		Locator.clickRegistrationNo(driver).sendKeys("342345");
		
		Thread.sleep(2000);
		Row row2 = sheet.getRow(18);						//Selected 1st index row (Second row)
		Cell c2 = row2.getCell(1);						//Selected cell (1 row,1 column)
		String address = c2.getStringCellValue();			//Got the URL stored at position 1,1
		Locator.clickAddressLine(driver).sendKeys(address);
		
		Thread.sleep(2000);
		Locator.clickSaveBtn(driver).click();
		
		 Thread.sleep(3000);
		 String msg1 = Locator.clickValidMsg(driver).getText();
			if(msg1.contains("Auditor/Firm saved successfully"))
			{
				test.log(LogStatus.PASS, "Message Dispalyed =" +msg1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message Dispalyed =" +msg1);
			}
			
			Thread.sleep(2000);
			Locator.clickCloseBtn(driver).click();
			//Internal Auditor
			
			   Thread.sleep(2000);
			    Locator.clickAuditorNew(driver).click();
			    Thread.sleep(2000);
			    Locator.clickAuditorCreateNew(driver).click();
			    Thread.sleep(2000);
			    Locator.clickAuditorType(driver).click();
			    Thread.sleep(2000);
			    Select objSelect =new Select(driver.findElement(By.xpath("//*[@id='ddlAuditor_Type_listbox']/li[2]")));
				objSelect.selectByIndex(1); 
			    //Thread.sleep(2000);
			    //Locator.SelectInternalAuditorDropDown(driver).get(3).click();
			    Thread.sleep(2000);
			    Locator.clickCategoryOfAuditor(driver).click();
			    Thread.sleep(2000);
			    Locator.SelectCategoryOfAuditor(driver).get(1).click();
				
				Thread.sleep(2000);
			    Row row3 = sheet.getRow(22);						//Selected 1st index row (Second row)
				Cell c3 = row3.getCell(1);						//Selected cell (1 row,1 column)
				String name1 = c3.getStringCellValue();			//Got the URL stored at position 1,1
				Locator.clickAuditorName(driver).sendKeys(name1);
				
				Thread.sleep(2000);
				Row row4 = sheet.getRow(23);						//Selected 1st index row (Second row)
				Cell c4 = row4.getCell(1);						//Selected cell (1 row,1 column)
				String email1 = c4.getStringCellValue();			//Got the URL stored at position 1,1
				Locator.clickAuditorEmail(driver).sendKeys(email1);
				
				Thread.sleep(2000);
				Locator.clickRegistrationNo(driver).sendKeys("342345");
				
				Thread.sleep(2000);
				Row row5 = sheet.getRow(24);						//Selected 1st index row (Second row)
				Cell c5 = row5.getCell(1);						//Selected cell (1 row,1 column)
				String address1 = c5.getStringCellValue();			//Got the URL stored at position 1,1
				Locator.clickAddressLine(driver).sendKeys(address1);
				
				Thread.sleep(2000);
				Locator.clickSaveBtn(driver).click();
				
				 Thread.sleep(3000);
				 String msg2 = Locator.clickValidMsg(driver).getText();
					if(msg2.contains("Auditor/Firm saved successfully"))
					{
						test.log(LogStatus.PASS, "Message Dispalyed =" +msg2);
					}
					else
					{
						test.log(LogStatus.FAIL, "Message Dispalyed =" +msg2);
					}
					Thread.sleep(2000);
					Locator.clickCloseBtn(driver).click();
					
					//Secretarial Auditor
					
					  Thread.sleep(2000);
					    Locator.clickAuditorNew(driver).click();
					    Thread.sleep(2000);
					    Locator.clickAuditorCreateNew(driver).click();
					    Thread.sleep(2000);
					    Locator.clickAuditorType(driver).click();
					    
				
					    Thread.sleep(2000);
					    Locator.SelectSecretarialAuditorDropDown(driver).click();
					    Thread.sleep(2000);
					    Locator.clickCategoryOfAuditor(driver).click();
					    Thread.sleep(2000);
					    Locator.SelectCategoryOfAuditor(driver).get(1).click();
						
						Thread.sleep(2000);
					    Row row6 = sheet.getRow(27);						//Selected 1st index row (Second row)
						Cell c6 = row6.getCell(1);						//Selected cell (1 row,1 column)
						String name2 = c6.getStringCellValue();			//Got the URL stored at position 1,1
						Locator.clickAuditorName(driver).sendKeys(name2);
						
						Thread.sleep(2000);
						Row row7 = sheet.getRow(28);						//Selected 1st index row (Second row)
						Cell c7 = row7.getCell(1);						//Selected cell (1 row,1 column)
						String email12 = c7.getStringCellValue();			//Got the URL stored at position 1,1
						Locator.clickAuditorEmail(driver).sendKeys(email12);
						
						Thread.sleep(2000);
						Locator.clickRegistrationNo(driver).sendKeys("342345");
						
						Thread.sleep(2000);
						Row row8 = sheet.getRow(29);						//Selected 1st index row (Second row)
						Cell c8 = row8.getCell(1);						//Selected cell (1 row,1 column)
						String address2 = c8.getStringCellValue();			//Got the URL stored at position 1,1
						Locator.clickAddressLine(driver).sendKeys(address2);
						
						Thread.sleep(2000);
						Locator.clickSaveBtn(driver).click();
						
						 Thread.sleep(3000);
						 String msg3 = Locator.clickValidMsg(driver).getText();
							if(msg3.contains("Auditor/Firm saved successfully"))
							{
								test.log(LogStatus.PASS, "Message Dispalyed =" +msg3);
							}
							else
							{
								test.log(LogStatus.FAIL, "Message Dispalyed =" +msg3);
							}	
							Thread.sleep(2000);
							Locator.clickCloseBtn(driver).click();
							
						//Cost Auditor	
							  
						Thread.sleep(2000);
					    Locator.clickAuditorNew(driver).click();
						Thread.sleep(2000);
					    Locator.clickAuditorCreateNew(driver).click();
						Thread.sleep(2000);
                         Locator.clickAuditorType(driver).click();
                         Thread.sleep(3000);
             			Locator.SelectCostAuditorDropDown(driver).click();
						Thread.sleep(2000);
						Locator.clickCategoryOfAuditor(driver).click();
						Thread.sleep(2000);
						Locator.SelectCategoryOfAuditor(driver).get(1).click();
						
						Thread.sleep(2000);
						Row row9 = sheet.getRow(32);						//Selected 1st index row (Second row)
						Cell c9 = row9.getCell(1);						//Selected cell (1 row,1 column)
						String name3 = c9.getStringCellValue();			//Got the URL stored at position 1,1
						Locator.clickAuditorName(driver).sendKeys(name3);
						
						Thread.sleep(2000);
						Row row10 = sheet.getRow(33);						//Selected 1st index row (Second row)
						Cell c10 = row10.getCell(1);						//Selected cell (1 row,1 column)
						String email3 = c10.getStringCellValue();			//Got the URL stored at position 1,1
						Locator.clickAuditorEmail(driver).sendKeys(email3);
															
						Thread.sleep(2000);
						Locator.clickRegistrationNo(driver).sendKeys("342345");
															
						Thread.sleep(2000);
						Row row11 = sheet.getRow(34);						//Selected 1st index row (Second row)
						Cell c11 = row11.getCell(1);						//Selected cell (1 row,1 column)
						String address14 = c11.getStringCellValue();			//Got the URL stored at position 1,1
						Locator.clickAddressLine(driver).sendKeys(address14);
						
						Thread.sleep(2000);
						Locator.clickSaveBtn(driver).click();
						
						Thread.sleep(3000);
						String msg4 = Locator.clickValidMsg(driver).getText();
						if(msg4.contains("Auditor/Firm saved successfully"))
						{
							test.log(LogStatus.PASS, "Message Dispalyed =" +msg4);
						}
						else
						{
							test.log(LogStatus.FAIL, "Message Dispalyed =" +msg4);
						}	
						
						Thread.sleep(2000);
						Locator.clickCloseBtn(driver).click();
						
			Thread.sleep(2000);
			Locator.clickAuditorNew(driver).click();			
						
			Thread.sleep(4000);
			Locator.clickAuditorCreateFromExisting(driver).click();
			
			Thread.sleep(4000);
			Locator.clickAuditorFirm(driver).click();
			
			Thread.sleep(4000);
			Locator.SelectAuditorFirm(driver).get(9).click();
	       
			Thread.sleep(3000);
			Locator.clickAuditorType(driver).click();
			Thread.sleep(3000);
			Locator.SelectCostAuditorDropDown(driver).click();
		
			Thread.sleep(6000);
			Locator.clickSaveBtn(driver).click();
			Thread.sleep(3000);
			 String msg5 = Locator.clickValidMsg(driver).getText();
				if(msg5.contains("Auditor/Firm saved successfully"))
				{
					test.log(LogStatus.PASS, "Message Dispalyed =" +msg5);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message Dispalyed =" +msg5);
				}
				
				Thread.sleep(2000);
				Locator.clickCloseBtn(driver).click();*/
				
				Thread.sleep(2000);
				Locator.clickEditicon(driver).click();
				
				Thread.sleep(2000);
			    Locator.clickCategoryOfAuditor(driver).click();
			    Thread.sleep(2000);
			    Locator.SelectCategoryOfAuditor(driver).get(1).click();
			    
			    Locator.clickAuditorName(driver).clear();
			    Thread.sleep(2000);
				Row row9 = sheet.getRow(19);						//Selected 1st index row (Second row)
				Cell c9 = row9.getCell(1);						//Selected cell (1 row,1 column)
				String name3 = c9.getStringCellValue();			//Got the URL stored at position 1,1
				Locator.clickAuditorName(driver).sendKeys(name3);
				
		        Thread.sleep(2000);
				Locator.clickSaveBtn(driver).click();
				
				Thread.sleep(2000);
				Locator.clickCloseBtn(driver).click();
				
				Thread.sleep(2000);
				Locator.clickDeleteicon(driver).click();
				
				Thread.sleep(2000);
				Locator.clickYes(driver).click();
					
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
				  
					Thread.sleep(2000);
					Locator.clickUploadBtn(driver).click();
					
					Thread.sleep(3000);
					Locator.clickChooseFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Auditor.xlsx");
	    

					Thread.sleep(2000);
					Locator.clickUploadFile(driver).click();
					
					Thread.sleep(3000);
					 String msg6 = Locator.clickUploadValidMsg(driver).getText();
						if(msg6.contains("Auditor Details Uploaded Successfully"))
						{
							test.log(LogStatus.PASS, "Message Dispalyed =" +msg6);
						}
						else
						{
							test.log(LogStatus.FAIL, "Message Dispalyed =" +msg6);
						}
						
						Thread.sleep(2000);
						Locator.clickClosebtn(driver).click();
					
	}

}
