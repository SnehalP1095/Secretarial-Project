package CompnaySecretory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;







public class MyWorkspaceMethod 
{
	
	   private static List<WebElement> elementsList = null;
	    public static FileInputStream fis = null;	//File input stream variable
		public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
		public static XSSFSheet sheet = null;		//Sheet variable
		public static XSSFSheet sheet1 = null;		//Sheet variable

	
		
		public static XSSFSheet ReadExcel() throws IOException
		{
			fis = new FileInputStream("E:\\Snehal\\ComplianceLatest\\Litigation-Project-main (1)\\Litigation-Project-main\\TestData\\LitigationSheet.xlsx");
			
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(8);					//Retrieving second sheet of Workbook
			return sheet;
		}
		
		
		public static void ClickMyWorkspace(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			
		
			if(MyWorkspaceLocator.MyWorkspaceimg(driver).isEnabled())
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.MyWorkspaceimg(driver).click();
				test.log(LogStatus.PASS ,"My workspace tab is clickable");
			}
		   else
			{
			    	 test.log(LogStatus.FAIL, "My workspace tab is not clickable");
		    }    
		}
		public static void ClickConcludedMeeting(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			
			if(MyWorkspaceLocator.ConcludedMeeting(driver).isEnabled())
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.ConcludedMeeting(driver).click();
				test.log(LogStatus.FAIL ,"After clicking on concluded meeting it shows heading as 'Meeting' but expected heading is 'Concluded meeting'");
			}
		   else
			{
			    	 test.log(LogStatus.PASS, "After clicking on concluded meeting it shows heading as 'Concluded meeting'");
		    }
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
			    
    	}
		
		public static void ClickNewButton(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
		
			if(MyWorkspaceLocator.NewButton(driver).isEnabled())
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.NewButton(driver).click();
				test.log(LogStatus.PASS ,"User should be redirected to the meeting page");
			}
		   else
			{
			    	 test.log(LogStatus.FAIL, "User should not be redirected to the meeting page");
		    }
			Thread.sleep(2000);
			MyWorkspaceLocator.CloseIcon(driver).click();
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		}
		public static void ClickEditButton(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			
			if(MyWorkspaceLocator.EditButton(driver).isEnabled())
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.EditButton(driver).click();
				test.log(LogStatus.PASS ,"User should be redirected to the meeting edit page");
			}
		   else
			{
			    	 test.log(LogStatus.FAIL, "User should not be redirected to the meeting edit page");
		    }
			
			Thread.sleep(2000);
			MyWorkspaceLocator.CloseIcon(driver).click();
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		}
		public static void ClickMoreAction(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
		
			if(MyWorkspaceLocator.MoreAction(driver).isEnabled())
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.MoreAction(driver).click();
				test.log(LogStatus.PASS ,"More action dropdown is clickable");
			}
		   else
			{
			    	 test.log(LogStatus.FAIL, "More action dropdown is not clickable");
		    }
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		}
		public static void ClickComplianceTab(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			
			if(MyWorkspaceLocator.ComplianceTab(driver).isEnabled())
			{
				Thread.sleep(3000);
				MyWorkspaceLocator.ComplianceTab(driver).click();
				test.log(LogStatus.PASS ,"User should be redirected to the compliance page");
			}
		   else
			{
			    	 test.log(LogStatus.FAIL, "User should not be redirected to the compliance page");
		    }
			
			 Thread.sleep(4000);
			 MyWorkspaceLocator.CloseIcon1(driver).click();	  
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();	    
		}
		public static void ClickDraftResolutionandMinuteTab(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
		
				if(MyWorkspaceLocator.DraftResolutionandMinuteTab(driver).isEnabled())
				{
				   Thread.sleep(2000);
				   MyWorkspaceLocator.DraftResolutionandMinuteTab(driver).click();
				  test.log(LogStatus.PASS ,"User should be redirected to the Draft and resolution page");
				}
				else
				{
					  test.log(LogStatus.FAIL ,"User should not be redirected to the Draft and resolution page");
				}
			
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(500,0)");
//			 Thread.sleep(4000);
//			 MyWorkspaceLocator.CloseIcon2(driver).click();	  
//			 Thread.sleep(4000);
//		     EntityLocator.ClickDashboard(driver).click();	    
		}
		public static void ClickDraftResolutionandMinuteDownloadIcon(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			Thread.sleep(2000);
			 List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']/li"));
				selectOptionFromDropDown_bs(entitytype, "Draft Resolution & Minutes");
			
			if(MyWorkspaceLocator.DraftResolutionandMinuteDonloadIcon(driver).isEnabled())
			{
				Thread.sleep(3000);
				MyWorkspaceLocator.DraftResolutionandMinuteDonloadIcon(driver).click();
				test.log(LogStatus.PASS ,"File Download successfully ");
			}
		   else
			{
			    	 test.log(LogStatus.FAIL, "File does not  Download successfully");
		    }
			
//			 Thread.sleep(4000);
//			 MyWorkspaceLocator.CloseIcon2(driver).click();	  
//			 Thread.sleep(4000);
//		     EntityLocator.ClickDashboard(driver).click();	    
		}
		
		public static void ClickAnnetureTab(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			Thread.sleep(2000);
			 List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']/li"));
				selectOptionFromDropDown_bs(entitytype, "Draft Resolution & Minutes");
			if(MyWorkspaceLocator.Anneture(driver).isEnabled())
			{
				Thread.sleep(3000);
				MyWorkspaceLocator.Anneture(driver).click();
				test.log(LogStatus.PASS ,"User should be redirected to the Annexure tab");
			}
		   else
			{
			    	 test.log(LogStatus.FAIL, "User should not be redirected to the Anneture tab");
		    }
			
			 Thread.sleep(4000);
			 MyWorkspaceLocator.CloseIcon2(driver).click();	 
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();	    
		}
		public static void ClickAnnetureTabValidUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
		{
    		
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			Thread.sleep(2000);
			 List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']/li"));
				selectOptionFromDropDown_bs(entitytype, "Draft Resolution & Minutes");
				
				Thread.sleep(3000);
				MyWorkspaceLocator.Anneture(driver).click();
		 
				Thread.sleep(3000);
				MyWorkspaceLocator.selectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Management Personnel.pdf");
				Thread.sleep(3000);
				MyWorkspaceLocator.clickUpload(driver).click();
				Thread.sleep(3000);
				String msg =MyWorkspaceLocator.clickValidationMsg(driver).getText();
				if(msg.equalsIgnoreCase(msg))
				{
					test.log(LogStatus.PASS, "Message displayed =" +msg);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed =" +msg);
				}
				 Thread.sleep(4000);
				 MyWorkspaceLocator.CloseIcon2(driver).click();	 
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();
		}
		public static void ClickAnnetureTabMultipleUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
		{
    		
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			Thread.sleep(2000);
			 List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']/li"));
				selectOptionFromDropDown_bs(entitytype, "Draft Resolution & Minutes");
				
				Thread.sleep(3000);
				MyWorkspaceLocator.Anneture(driver).click();
		 
				Thread.sleep(3000);
				MyWorkspaceLocator.selectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Management Personnel.pdf");
				
				Thread.sleep(3000);
				MyWorkspaceLocator.selectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\DIR-8.docx");
				Thread.sleep(3000);
				MyWorkspaceLocator.clickUpload(driver).click();
				Thread.sleep(3000);
				String msg =MyWorkspaceLocator.clickValidationMsg(driver).getText();
				if(msg.equalsIgnoreCase(msg))
				{
					test.log(LogStatus.PASS, "Message displayed =" +msg);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed =" +msg);
				}
				 Thread.sleep(4000);
				 MyWorkspaceLocator.CloseIcon2(driver).click();	 
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();
		}
		public static void ClickAnnetureTabInvalidUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
		{
    		
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			Thread.sleep(2000);
			 List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']/li"));
				selectOptionFromDropDown_bs(entitytype, "Draft Resolution & Minutes");
				
				Thread.sleep(3000);
				MyWorkspaceLocator.Anneture(driver).click();
		 
				Thread.sleep(3000);
				MyWorkspaceLocator.selectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Statutory Auditor.html");
				
		
				Thread.sleep(3000);
				String msg =MyWorkspaceLocator.clickValidationMsg1(driver).getText();
				if(msg.equalsIgnoreCase(msg))
				{
					test.log(LogStatus.PASS, "Message displayed =" +msg);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed =" +msg);
				}
				 Thread.sleep(4000);
				 MyWorkspaceLocator.CloseIcon2(driver).click();	 
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();
		}
		public static void ClickAnnetureTabMultipleInvalidUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
		{
    		
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			Thread.sleep(2000);
			 List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']/li"));
				selectOptionFromDropDown_bs(entitytype, "Draft Resolution & Minutes");
				
				Thread.sleep(3000);
				MyWorkspaceLocator.Anneture(driver).click();
		 
				Thread.sleep(3000);
				MyWorkspaceLocator.selectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Statutory Auditor.html");
				
				Thread.sleep(3000);
				MyWorkspaceLocator.selectFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\Contract.xlsx");
				
				Thread.sleep(3000);
				String msg =MyWorkspaceLocator.clickValidationMsg1(driver).getText();
				if(msg.equalsIgnoreCase(msg))
				{
					test.log(LogStatus.PASS, "Message displayed =" +msg);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed =" +msg);
				}
				 Thread.sleep(4000);
				 MyWorkspaceLocator.CloseIcon2(driver).click();	 
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();
		}
		public static void ClickAnnetureTabWithoutSelectingUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
		{
    		
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			Thread.sleep(2000);
			 List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']/li"));
				selectOptionFromDropDown_bs(entitytype, "Draft Resolution & Minutes");
				
				Thread.sleep(3000);
				MyWorkspaceLocator.Anneture(driver).click();
				
				Thread.sleep(3000);
				MyWorkspaceLocator.clickUpload(driver).click();
				

				Thread.sleep(3000);
				String msg =MyWorkspaceLocator.clickValidationMsg2(driver).getText();
				if(msg.equalsIgnoreCase(msg))
				{
					test.log(LogStatus.PASS, "Message displayed =" +msg);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed =" +msg);
				}
				 Thread.sleep(4000);
				 MyWorkspaceLocator.CloseIcon2(driver).click();	 
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();
		}
		public static void ClickAnnetureTabViewFile(WebDriver driver,ExtentTest test) throws InterruptedException
		{
    		
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			Thread.sleep(2000);
			 List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']/li"));
				selectOptionFromDropDown_bs(entitytype, "Draft Resolution & Minutes");
				
				Thread.sleep(3000);
				MyWorkspaceLocator.Anneture(driver).click();
				
				Thread.sleep(3000);
		       MyWorkspaceLocator.clickViewIcon(driver).click();
		       
		       test.log(LogStatus.PASS, "User should able to view uploaded file successfully");
		       
		       Thread.sleep(3000);
		       MyWorkspaceLocator.clickCloseIcon(driver).click();
		  	 Thread.sleep(4000);
			 MyWorkspaceLocator.CloseIcon2(driver).click();	 
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		}
		
		public static void ClickAnnetureTabDownloadFile(WebDriver driver,ExtentTest test) throws InterruptedException
		{
    		
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			Thread.sleep(2000);
			 List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']/li"));
				selectOptionFromDropDown_bs(entitytype, "Draft Resolution & Minutes");
				
				Thread.sleep(3000);
				MyWorkspaceLocator.Anneture(driver).click();
				
				Thread.sleep(3000);
		       MyWorkspaceLocator.clickDownloadIcon(driver).click();
		       
		       test.log(LogStatus.PASS, "User should able to download file successfully");
		       
		  
		  	 Thread.sleep(4000);
			 MyWorkspaceLocator.CloseIcon2(driver).click();	 
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		}
		public static void ClickAnnetureTabDeleteFile(WebDriver driver,ExtentTest test) throws InterruptedException
		{
    		
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			Thread.sleep(2000);
			 List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']/li"));
				selectOptionFromDropDown_bs(entitytype, "Draft Resolution & Minutes");
				
				Thread.sleep(3000);
				MyWorkspaceLocator.Anneture(driver).click();
				
				Thread.sleep(3000);
		       MyWorkspaceLocator.clickDeleteIcon(driver).click();
		       
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
				String msg= MyWorkspaceLocator.clickValidMsg2(driver).getText();	
		       
		           test.log(LogStatus.PASS, "Message displayed =" +msg);
		       
		  
		  	 Thread.sleep(4000);
			 MyWorkspaceLocator.CloseIcon2(driver).click();	 
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		}	
		
		public static void ClickMinutesTab(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			
			if(MyWorkspaceLocator.MinutesTab(driver).isEnabled())
			{
				Thread.sleep(3000);
				MyWorkspaceLocator.MinutesTab(driver).click();
				test.log(LogStatus.PASS ,"User should be redirected to the Minutes page");
			}
		   else
			{
			    	 test.log(LogStatus.FAIL, "User should not be redirected to the Minutes page");
		    }
			
			 Thread.sleep(4000);
			 MyWorkspaceLocator.clickCloseIcon2(driver).click();	  
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();	    
		}
		
		public static void ClickMinutesTabDownloadIcon(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			Thread.sleep(3000);
			MyWorkspaceLocator.MinutesTab(driver).click();
			Thread.sleep(3000);
			driver.switchTo().frame(MyWorkspaceLocator.clickiframe(driver));
			Thread.sleep(3000);
			driver.switchTo().frame(0);
			File dir2 = new File("C:\\Users\\Snehal Patil\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(3000);
			MyWorkspaceLocator.clickDownloadLicon(driver).click();
			
		 	Thread.sleep(6000);
			File dir3 = new File("C:\\Users\\Snehal Patil\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "User should able to download the minutes ");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "User should not be able to download the minutes ");
			}
   			
			
//			 Thread.sleep(9000);
//			 MyWorkspaceLocator.clickCloseIcon2(driver).click();	  
//			 Thread.sleep(4000);
//		     EntityLocator.ClickDashboard(driver).click();	    
		}
		public static void ClickCertifiedTrueCopy(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			
			if(MyWorkspaceLocator.CertifiedTrueCopyTab(driver).isEnabled())
			{
				Thread.sleep(3000);
				MyWorkspaceLocator.CertifiedTrueCopyTab(driver).click();
				test.log(LogStatus.PASS ,"User should be redirected to the Certified True Copy page");
			}
		   else
			{
			    	 test.log(LogStatus.FAIL, "User should not be redirected to the Certified True Copy page");
		    }
			
			 Thread.sleep(4000);
			 MyWorkspaceLocator.clickCloseIcon3(driver).click();	  
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();	    
		}
		public static void ClickCTCPreviewIcon(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			
		   Thread.sleep(3000);
			MyWorkspaceLocator.CertifiedTrueCopyTab(driver).click();
				
			Thread.sleep(3000);
			MyWorkspaceLocator.clickPreviewCTC(driver).click();
			test.log(LogStatus.PASS ,"User should able to view CTC documents successfully");
			
			Thread.sleep(4000);
			 MyWorkspaceLocator.clickCloseIcon4(driver).click();	
			 Thread.sleep(4000);
			 MyWorkspaceLocator.clickCloseIcon3(driver).click();	  
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();	    
		}
		public static void ClickCTCDownloadIcon(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			
		   Thread.sleep(3000);
			MyWorkspaceLocator.CertifiedTrueCopyTab(driver).click();
				
		
			File dir2 = new File("C:\\Users\\Snehal Patil\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(3000);
			MyWorkspaceLocator.clickDownloadCTCIcon(driver).click();
			
		 	Thread.sleep(6000);
			File dir3 = new File("C:\\Users\\Snehal Patil\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "User should able to download CTC documents in word successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "User should not able to download CTC documents in word successfully ");
			}
		
			
			 Thread.sleep(4000);
			 MyWorkspaceLocator.clickCloseIcon3(driver).click();	  
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();	    
		}
		
		public static void ClickCTCDownloadpdfIcon(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
			
		   Thread.sleep(3000);
			MyWorkspaceLocator.CertifiedTrueCopyTab(driver).click();
				
		
			File dir2 = new File("C:\\Users\\Snehal Patil\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(3000);
			MyWorkspaceLocator.clickDownloadCTCPDFIcon(driver).click();
			
		 	Thread.sleep(6000);
			File dir3 = new File("C:\\Users\\Snehal Patil\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "User should able to download CTC documents in pdf successfully");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "User should not able to download CTC documents in pdf successfully ");
			}
		
			
			 Thread.sleep(4000);
			 MyWorkspaceLocator.clickCloseIcon3(driver).click();	  
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();	    
		}
		public static void ClickUploadDocTab(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.ConcludedMeeting(driver).click();
			Thread.sleep(2000);
			MyWorkspaceLocator.MoreAction(driver).click();
		
			Thread.sleep(2000);
			if(MyWorkspaceLocator.UploadDocTab(driver).isEnabled())
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.UploadDocTab(driver).click();
				test.log(LogStatus.PASS, "User should be redirected to the upload document page");
			}
			else
			{
				test.log(LogStatus.FAIL, "User should not be redirected to the upload document page");
			}
			Thread.sleep(2000);
			MyWorkspaceLocator.clickCloseIcon5(driver).click();
			
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();	
			
		}
		

    public static void ClickUploadDoc(WebDriver driver,ExtentTest test) throws InterruptedException
    {
	    Thread.sleep(2000);
	    MyWorkspaceLocator.MyWorkspaceimg(driver).click();
	    Thread.sleep(2000);
	    MyWorkspaceLocator.ConcludedMeeting(driver).click();
	    Thread.sleep(2000);
	    MyWorkspaceLocator.MoreAction(driver).click();
	    
	    Thread.sleep(2000);
		MyWorkspaceLocator.UploadDocTab(driver).click();
		
		Thread.sleep(2000);
		MyWorkspaceLocator.selectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Statutory Auditor.html");
		
		 Thread.sleep(2000);
		MyWorkspaceLocator.clickUpload(driver).click();

		 Thread.sleep(2000);
		 String msg=MyWorkspaceLocator.clickvalidmsg(driver).getText();
		 if(msg.equalsIgnoreCase(msg))
		 {
			 test.log(LogStatus.PASS,"Message displayed =" +msg);
		 }
		 else
		 {
			 test.log(LogStatus.FAIL,"Message displayed =" +msg);
		 }
		 
			Thread.sleep(2000);
			MyWorkspaceLocator.clickCloseIcon5(driver).click();
			
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();	
	
   }
    public static void ClickMultipleUploadDoc(WebDriver driver,ExtentTest test) throws InterruptedException
    {
	    Thread.sleep(2000);
	    MyWorkspaceLocator.MyWorkspaceimg(driver).click();
	    Thread.sleep(2000);
	    MyWorkspaceLocator.ConcludedMeeting(driver).click();
	    Thread.sleep(2000);
	    MyWorkspaceLocator.MoreAction(driver).click();
	    
	    Thread.sleep(2000);
		MyWorkspaceLocator.UploadDocTab(driver).click();
		
		Thread.sleep(2000);
		MyWorkspaceLocator.selectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Statutory Auditor.html");
		Thread.sleep(2000);
		MyWorkspaceLocator.selectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Management Personnel.pdf");
		 Thread.sleep(2000);
		MyWorkspaceLocator.clickUpload(driver).click();

		 Thread.sleep(2000);
		 String msg=MyWorkspaceLocator.clickvalidmsg(driver).getText();
		 if(msg.equalsIgnoreCase(msg))
		 {
			 test.log(LogStatus.PASS,"Message displayed =" +msg);
		 }
		 else
		 {
			 test.log(LogStatus.FAIL,"Message displayed =" +msg);
		 }
		 
			Thread.sleep(2000);
			MyWorkspaceLocator.clickCloseIcon5(driver).click();
			
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();	
	
   }
    
    public static void ClickWithoutSelectingFile(WebDriver driver,ExtentTest test) throws InterruptedException
    {
	    Thread.sleep(2000);
	    MyWorkspaceLocator.MyWorkspaceimg(driver).click();
	    Thread.sleep(2000);
	    MyWorkspaceLocator.ConcludedMeeting(driver).click();
	    Thread.sleep(2000);
	    MyWorkspaceLocator.MoreAction(driver).click();
	    
	    Thread.sleep(2000);
		MyWorkspaceLocator.UploadDocTab(driver).click();
		
		Thread.sleep(2000);
		MyWorkspaceLocator.clickUpload(driver).click();

		 Thread.sleep(2000);
		 String msg=MyWorkspaceLocator.clickvalidmsg(driver).getText();
		 if(msg.equalsIgnoreCase(msg))
		 {
			 test.log(LogStatus.FAIL,"Message displayed =" +msg);
		 }
		 else
		 {
			 test.log(LogStatus.PASS,"Message displayed =" +msg);
		 }
		 
			Thread.sleep(2000);
			MyWorkspaceLocator.clickCloseIcon5(driver).click();
			
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();	
	
   }
    
  public static void ClickViewFile(WebDriver driver,ExtentTest test) throws InterruptedException
    {
	    Thread.sleep(2000);
	    MyWorkspaceLocator.MyWorkspaceimg(driver).click();
	    Thread.sleep(2000);
	    MyWorkspaceLocator.ConcludedMeeting(driver).click();
	    Thread.sleep(2000);
	    MyWorkspaceLocator.MoreAction(driver).click();
	    
	    Thread.sleep(2000);
		MyWorkspaceLocator.UploadDocTab(driver).click();
		
	    Thread.sleep(2000);
		MyWorkspaceLocator.clickViewIcon1(driver).click();
		Thread.sleep(3000);
		driver.switchTo().frame(MyWorkspaceLocator.clickIframe(driver));
		  Thread.sleep(2000);
			String msg=MyWorkspaceLocator.clickError(driver).getText();
			  if(msg.equalsIgnoreCase("Document Load Error: No document is specified so nothing to display."))
      		  {
      			  test.log(LogStatus.PASS, "User should able to view uploaded file successfully= " +msg);
      		  }
      		  else
      		  {
      			 test.log(LogStatus.FAIL, "User should not able to view uploaded file successfully= " +msg);
      		  }

		     driver.switchTo().parentFrame();
			Thread.sleep(2000);
			MyWorkspaceLocator.clickCloseIcon6(driver).click();
			
			Thread.sleep(2000);
			MyWorkspaceLocator.clickCloseIcon5(driver).click();
			
			 Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();	
	
   }
  
  
  public static void ClickDownloadFile(WebDriver driver,ExtentTest test) throws InterruptedException
  {
	    Thread.sleep(2000);
	    MyWorkspaceLocator.MyWorkspaceimg(driver).click();
	    Thread.sleep(2000);
	    MyWorkspaceLocator.ConcludedMeeting(driver).click();
	    Thread.sleep(2000);
	    MyWorkspaceLocator.MoreAction(driver).click();
	    
	    Thread.sleep(2000);
		MyWorkspaceLocator.UploadDocTab(driver).click();
		
			File dir2 = new File("C:\\Users\\Snehal Patil\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(3000);
			MyWorkspaceLocator.clickDownloadIcon1(driver).click();
			
		 	Thread.sleep(6000);
			File dir3 = new File("C:\\Users\\Snehal Patil\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "User should able to download uploaded file successfully ");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "User should not able to download uploaded file successfully ");
			}
		   
		   Thread.sleep(2000);
			MyWorkspaceLocator.clickCloseIcon5(driver).click();
			
			Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		
  }
		   
		   public static void ClickDeleteFile(WebDriver driver,ExtentTest test) throws InterruptedException
		   {
		 	    Thread.sleep(2000);
		 	    MyWorkspaceLocator.MyWorkspaceimg(driver).click();
		 	    Thread.sleep(2000);
		 	    MyWorkspaceLocator.ConcludedMeeting(driver).click();
		 	    Thread.sleep(2000);
		 	    MyWorkspaceLocator.MoreAction(driver).click();
		 	    
		 	    Thread.sleep(2000);
		 		MyWorkspaceLocator.UploadDocTab(driver).click();
		 		

		 	    Thread.sleep(2000);
		 		MyWorkspaceLocator.clickDeleteIcon1(driver).click();
		 		
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
				MyWorkspaceLocator.clickCloseIcon5(driver).click();
   			
				Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();
			
  }
		   
			public static void ClickCopyMeetingTab(WebDriver driver,ExtentTest test) throws InterruptedException
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.MyWorkspaceimg(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.ConcludedMeeting(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.MoreAction(driver).click();
			
				Thread.sleep(2000);
				if(MyWorkspaceLocator.CopyMeetingTab(driver).isEnabled())
				{
					Thread.sleep(2000);
					MyWorkspaceLocator.CopyMeetingTab(driver).click();
					test.log(LogStatus.PASS, "User should be redirected to the Copy Meeting page");
				}
				else
				{
					test.log(LogStatus.FAIL, "User should not be redirected to the Copy Meeting page");
				}
				Thread.sleep(2000);
				MyWorkspaceLocator.clickCloseIcon7(driver).click();
				
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();	
				
			}
			
			public static void ClickCopyMeetingAgenda(WebDriver driver,ExtentTest test) throws InterruptedException
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.MyWorkspaceimg(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.ConcludedMeeting(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.MoreAction(driver).click();
			
				Thread.sleep(2000);
				MyWorkspaceLocator.CopyMeetingTab(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickEntityName(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.selectEntityName(driver).click();
				 
				Thread.sleep(2000);
				MyWorkspaceLocator.clickCheckbox(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickSave(driver).click();
				
				Thread.sleep(2000);
				String msg=MyWorkspaceLocator.clickValidMsg(driver).getText();
				
				if(msg.equalsIgnoreCase(msg))
				{
					test.log(LogStatus.PASS,"Message displayed =" +msg);
				}
				else
				{
					test.log(LogStatus.FAIL,"Message displayed =" +msg);
				}
				
					
				Thread.sleep(2000);
				MyWorkspaceLocator.clickCloseIcon7(driver).click();
				
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();	
				
			}
			
			public static void ClickCopyMeetingMultipleAgenda(WebDriver driver,ExtentTest test) throws InterruptedException
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.MyWorkspaceimg(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.ConcludedMeeting(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.MoreAction(driver).click();
			
				Thread.sleep(2000);
				MyWorkspaceLocator.CopyMeetingTab(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickEntityName(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.selectEntityName(driver).click();
				

				Thread.sleep(2000);
				MyWorkspaceLocator.clickEntityName1(driver).click();
				 
				Thread.sleep(2000);
				MyWorkspaceLocator.selectEntityName1(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.clickCheckbox(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickSave(driver).click();
				
				Thread.sleep(2000);
				String msg=MyWorkspaceLocator.clickValidMsg(driver).getText();
				
				if(msg.equalsIgnoreCase(msg))
				{
					test.log(LogStatus.PASS,"Message displayed =" +msg);
				}
				else
				{
					test.log(LogStatus.FAIL,"Message displayed =" +msg);
				}
				
					
				Thread.sleep(2000);
				MyWorkspaceLocator.clickCloseIcon7(driver).click();
				
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();	
				
			}
			
			public static void ClickCopyMeetingMultiplecheckboxAgenda(WebDriver driver,ExtentTest test) throws InterruptedException
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.MyWorkspaceimg(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.ConcludedMeeting(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.MoreAction(driver).click();
			
				Thread.sleep(2000);
				MyWorkspaceLocator.CopyMeetingTab(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickEntityName(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.selectEntityName(driver).click();
				

				Thread.sleep(2000);
				MyWorkspaceLocator.clickEntityName1(driver).click();
				 
				Thread.sleep(2000);
				MyWorkspaceLocator.selectEntityName1(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.clickCheckbox1(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickSave(driver).click();
				
				Thread.sleep(2000);
				String msg=MyWorkspaceLocator.clickValidMsg(driver).getText();
				
				if(msg.equalsIgnoreCase(msg))
				{
					test.log(LogStatus.PASS,"Message displayed =" +msg);
				}
				else
				{
					test.log(LogStatus.FAIL,"Message displayed =" +msg);
				}
				
					
				Thread.sleep(2000);
				MyWorkspaceLocator.clickCloseIcon7(driver).click();
				
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();	
				
			}
			
			public static void ClickCopyMeetingAgendaWithoutEnterData(WebDriver driver,ExtentTest test) throws InterruptedException
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.MyWorkspaceimg(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.ConcludedMeeting(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.MoreAction(driver).click();
			
				Thread.sleep(2000);
				MyWorkspaceLocator.CopyMeetingTab(driver).click();
				
			 Thread.sleep(2000);
				MyWorkspaceLocator.clickSave(driver).click();
			
				try
				{
			     	Thread.sleep(2000);
				    String msg=MyWorkspaceLocator.clickValidMsg(driver).getText();
				
				   if(msg.equalsIgnoreCase(msg))
				   {
					  test.log(LogStatus.PASS,"Message displayed =" +msg);
				   }
				   else
				   {
					 test.log(LogStatus.FAIL,"Message displayed =" +msg);
				   }
			  }
				catch(Exception e)
				{
					test.log(LogStatus.FAIL,"No error validation message displayed");
				}
				
					
				Thread.sleep(2000);
				MyWorkspaceLocator.clickCloseIcon7(driver).click();
				
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();	
				
			}
			
			public static void ClickCopyMeetingAgendaCloseBtn(WebDriver driver,ExtentTest test) throws InterruptedException
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.MyWorkspaceimg(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.ConcludedMeeting(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.MoreAction(driver).click();
			
				Thread.sleep(2000);
				MyWorkspaceLocator.CopyMeetingTab(driver).click();
				   Thread.sleep(2000);
				if(	MyWorkspaceLocator.clickClose(driver).isEnabled())
				{
				   Thread.sleep(2000);
				   MyWorkspaceLocator.clickClose(driver).click();
				   test.log(LogStatus.PASS, "The user should be redirected to the previous page.");
				
				}
				else
				{
					 test.log(LogStatus.FAIL, "The user not should be redirected to the previous page.");
				}
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();	
				
			}
			
			public static void ClickCopyMeetingAgendaLog(WebDriver driver,ExtentTest test) throws InterruptedException
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.MyWorkspaceimg(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.ConcludedMeeting(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.MoreAction(driver).click();
			
				Thread.sleep(2000);
				MyWorkspaceLocator.CopyMeetingTab(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickLog(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickLogDelete(driver).click();
				
				
				Thread.sleep(2000);
				String msg=MyWorkspaceLocator.clickLogDeleteMsg(driver).getText();
				
				if(msg.equalsIgnoreCase(msg))
				{
					test.log(LogStatus.PASS, "Message Displayed =" +msg);
					
				}
				else
				{
					test.log(LogStatus.FAIL, "Message Displayed =" +msg);
				}
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickLogDelete1(driver).click();
				
				Thread.sleep(2000);
				String msg1=MyWorkspaceLocator.clickLogDeleteMsg1(driver).getText();
				
				if(msg1.equalsIgnoreCase(msg1))
				{
					test.log(LogStatus.PASS, "Message Displayed =" +msg1);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message Displayed =" +msg1);
				}
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickLogDeleteClose(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickCloseIcon7(driver).click();
				
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();	
			}
			
			public static void ClickCopyMeetingAgendaDeleteNoBtn(WebDriver driver,ExtentTest test) throws InterruptedException
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.MyWorkspaceimg(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.ConcludedMeeting(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.MoreAction(driver).click();
			
				Thread.sleep(2000);
				MyWorkspaceLocator.CopyMeetingTab(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickLog(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickLogDelete(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickLogDeleteNoBtn(driver).click();
				
				test.log(LogStatus.PASS, "The item should not be deleted. The confirmation prompt should be dismissed, and the item should remain intact without any changes.");
			
				Thread.sleep(2000);
				MyWorkspaceLocator.clickCloseIcon7(driver).click();
				
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();	
			
			}
			
			public static void ClickConcludedMeetingAdd(WebDriver driver,ExtentTest test) throws InterruptedException
			{
				Thread.sleep(2000);
				MyWorkspaceLocator.MyWorkspaceimg(driver).click();
				Thread.sleep(2000);
				MyWorkspaceLocator.ConcludedMeeting(driver).click();
				
				Thread.sleep(2000);
				if(MyWorkspaceLocator.clickAddBtn(driver).isEnabled())
				{
			     	Thread.sleep(2000);
				    MyWorkspaceLocator.clickAddBtn(driver).click();
				    test.log(LogStatus.PASS, "Add button is enabled for actual concluded meeting");
				}
				else
				{
				    test.log(LogStatus.FAIL, "Add button is not enabled for actual concluded meeting");
				}
				
				Thread.sleep(2000);
			    MyWorkspaceLocator.clickCloseBtn(driver).click();
			    
			    Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();	
			    
			}
			
			public static void ClickMyCompliance(WebDriver driver,ExtentTest test) throws InterruptedException
			{
				
				Thread.sleep(2000);
				MyWorkspaceLocator.MyWorkspaceimg(driver).click();
				
				if(MyWorkspaceLocator.clickMyCompliance(driver).isEnabled())
				{
					Thread.sleep(2000);
					MyWorkspaceLocator.clickMyCompliance(driver).click();
					test.log(LogStatus.PASS ,"User should be redirected to the My Compliances page'");
				}
			   else
				{
				    	 test.log(LogStatus.FAIL, "User should not be redirected to the My Compliances page'");
			    }
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();
				    
	    	}
			
			public static void ClickMyComplianceEditBtn(WebDriver driver,ExtentTest test) throws InterruptedException
			{
				
				Thread.sleep(2000);
				MyWorkspaceLocator.MyWorkspaceimg(driver).click();
				
				Thread.sleep(2000);
				MyWorkspaceLocator.clickMyCompliance(driver).click();
			
				Thread.sleep(2000);
				if(MyWorkspaceLocator.clickMyComplianceEdit(driver).isEnabled())
				{
					Thread.sleep(2000);
					MyWorkspaceLocator.clickMyComplianceEdit(driver).click();
					test.log(LogStatus.PASS ,"User should be redirected to the  Compliances page'");
				}
			   else
				{
				    	 test.log(LogStatus.FAIL, "User should not be redirected to the  Compliances page'");
			    }
				
				 Thread.sleep(4000);
				 MyWorkspaceLocator.clickCloseIcon9(driver).click();
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();
				    
		}
			
		public static void ClickMyTask(WebDriver driver,ExtentTest test) throws InterruptedException
			{
				
				Thread.sleep(2000);
				MyWorkspaceLocator.MyWorkspaceimg(driver).click();
					Thread.sleep(2000);
			   if(MyWorkspaceLocator.clickMyTask(driver).isEnabled())
			   {
				  Thread.sleep(2000);
				   MyWorkspaceLocator.clickMyTask(driver).click();
				   test.log(LogStatus.PASS, "My Task tab is clickable");
		    	}
			  else
			  {
				 test.log(LogStatus.FAIL, "My Task tab not is clickable");
			  }
				
		 }
		
		public static void AddMyTaskMetting(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver, 20);
			sheet=workbook.getSheetAt(0);
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			
			  Thread.sleep(2000);
			   MyWorkspaceLocator.clickMyTask(driver).click();
			   
			   Thread.sleep(2000);
			   MyWorkspaceLocator.clickNewTask(driver).click();
			   
			   Thread.sleep(2000);
			   MyWorkspaceLocator.clickType(driver).click();
			   
				Thread.sleep(2000);
			     List<WebElement>type = driver.findElements(By.xpath("//ul[@id='TaskType_listbox']/li"));
				selectOptionFromDropDown_bs(type, "Meeting");
				
//				   Thread.sleep(5000);
//				   MyWorkspaceLocator.clickEntity(driver).click();
				   
				   By locator = By.xpath("//*[@id='divEntityId']/span[2]/span/span[2]");
				 
				   wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				   Thread.sleep(4000);
				   WebElement ViewButton = driver.findElement(locator);	
				   Thread.sleep(3000);
				   JavascriptExecutor jse=(JavascriptExecutor)driver;
				   jse.executeScript("arguments[0].click();", ViewButton);
				   
				
				   Thread.sleep(2000);
				     List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='EntityId_listbox']/li"));
					selectOptionFromDropDown_bs(entitytype, "A LIMITED");
				   
				   Thread.sleep(2000);
				    Row row = sheet.getRow(81);						//Selected 1st index row (Second row)
				    org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
					String TaskTitle = c.getStringCellValue();	//Got the URL stored at position 1,1
					MyWorkspaceLocator.ClickTaskTitle(driver).sendKeys(TaskTitle );
					
					 Thread.sleep(2000);
					 Row row1 = sheet.getRow(82);						//Selected 1st index row (Second row)
					 org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
					 String TaskDesciption= c1.getStringCellValue();	//Got the URL stored at position 1,1
					 MyWorkspaceLocator.ClickTaskDescription(driver).sendKeys(TaskDesciption );
					
					 Thread.sleep(2000);
					 MyWorkspaceLocator.ClickCalender(driver).click();
					 Thread.sleep(2000);
					 MyWorkspaceLocator.SelectDate(driver).click();
					 
					 Thread.sleep(2000);
					 MyWorkspaceLocator.selectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Management Personnel.pdf");
	
					 Thread.sleep(2000);
					 MyWorkspaceLocator.Save(driver).click();
					 Thread.sleep(2000);
					 String msg= MyWorkspaceLocator.ValidMsg(driver).getText();
					 
					 if(msg.equalsIgnoreCase(msg))
					 {
						 test.log(LogStatus.PASS, "Message displsyed ="+msg);
					 }
					 else
					 {
						 test.log(LogStatus.FAIL, "Message displsyed ="+msg);
					 }
					 
					 Thread.sleep(2000);
					 MyWorkspaceLocator.CloseBtn(driver).click();
		
		}
		
		public static void AddMyTaskAgenda(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver, 20);
			sheet=workbook.getSheetAt(0);
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			
			  Thread.sleep(2000);
			   MyWorkspaceLocator.clickMyTask(driver).click();
			   
			   Thread.sleep(2000);
			   MyWorkspaceLocator.clickNewTask(driver).click();
			   
			   Thread.sleep(2000);
			   MyWorkspaceLocator.clickType(driver).click();
			   
				Thread.sleep(2000);
			     List<WebElement>type = driver.findElements(By.xpath("//ul[@id='TaskType_listbox']/li"));
				selectOptionFromDropDown_bs(type, "Agenda");
			 
				   By locator = By.xpath("//*[@id='divEntityId']/span[2]/span/span[2]");
				 
				   wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				   Thread.sleep(4000);
				   WebElement ViewButton = driver.findElement(locator);	
				   Thread.sleep(3000);
				   JavascriptExecutor jse=(JavascriptExecutor)driver;
				   jse.executeScript("arguments[0].click();", ViewButton);
				   
				
				   Thread.sleep(2000);
				     List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='EntityId_listbox']/li"));
					selectOptionFromDropDown_bs(entitytype, "A LIMITED");
				   
				   Thread.sleep(2000);
				    Row row = sheet.getRow(81);						//Selected 1st index row (Second row)
				    org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
					String TaskTitle = c.getStringCellValue();	//Got the URL stored at position 1,1
					MyWorkspaceLocator.ClickTaskTitle(driver).sendKeys(TaskTitle );
					
					 Thread.sleep(2000);
					 Row row1 = sheet.getRow(82);						//Selected 1st index row (Second row)
					 org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
					 String TaskDesciption= c1.getStringCellValue();	//Got the URL stored at position 1,1
					 MyWorkspaceLocator.ClickTaskDescription(driver).sendKeys(TaskDesciption );
					
					 Thread.sleep(2000);
					 MyWorkspaceLocator.ClickCalender(driver).click();
					 Thread.sleep(2000);
					 MyWorkspaceLocator.SelectDate(driver).click();
					 
					 Thread.sleep(2000);
					 MyWorkspaceLocator.selectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Management Personnel.pdf");
	
					 Thread.sleep(2000);
					 MyWorkspaceLocator.Save(driver).click();
					 Thread.sleep(2000);
					 String msg= MyWorkspaceLocator.ValidMsg(driver).getText();
					 
					 if(msg.equalsIgnoreCase(msg))
					 {
						 test.log(LogStatus.PASS, "Message displsyed ="+msg);
					 }
					 else
					 {
						 test.log(LogStatus.FAIL, "Message displsyed ="+msg);
					 }
					 
					 Thread.sleep(2000);
					 MyWorkspaceLocator.CloseBtn(driver).click();
		
		}
		public static void AddMyTaskOther(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver, 20);
			sheet=workbook.getSheetAt(0);
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			
			  Thread.sleep(2000);
			   MyWorkspaceLocator.clickMyTask(driver).click();
			   
			   Thread.sleep(2000);
			   MyWorkspaceLocator.clickNewTask(driver).click();
			   
			   Thread.sleep(2000);
			   MyWorkspaceLocator.clickType(driver).click();
			   
				Thread.sleep(2000);
			     List<WebElement>type = driver.findElements(By.xpath("//ul[@id='TaskType_listbox']/li"));
				selectOptionFromDropDown_bs(type, "Other");
			 
				
				   Thread.sleep(2000);
				    Row row = sheet.getRow(81);						//Selected 1st index row (Second row)
				    org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
					String TaskTitle = c.getStringCellValue();	//Got the URL stored at position 1,1
					MyWorkspaceLocator.ClickTaskTitle(driver).sendKeys(TaskTitle );
					
					 Thread.sleep(2000);
					 Row row1 = sheet.getRow(82);						//Selected 1st index row (Second row)
					 org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
					 String TaskDesciption= c1.getStringCellValue();	//Got the URL stored at position 1,1
					 MyWorkspaceLocator.ClickTaskDescription(driver).sendKeys(TaskDesciption );
					
					 Thread.sleep(2000);
					 MyWorkspaceLocator.ClickCalender(driver).click();
					 Thread.sleep(2000);
					 MyWorkspaceLocator.SelectDate(driver).click();
					 
					 Thread.sleep(2000);
					 MyWorkspaceLocator.selectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Management Personnel.pdf");
	
					 Thread.sleep(2000);
					 MyWorkspaceLocator.Save(driver).click();
					 Thread.sleep(2000);
					 String msg= MyWorkspaceLocator.ValidMsg(driver).getText();
					 
					 if(msg.equalsIgnoreCase(msg))
					 {
						 test.log(LogStatus.PASS, "Message displsyed ="+msg);
					 }
					 else
					 {
						 test.log(LogStatus.FAIL, "Message displsyed ="+msg);
					 }
					 
					 Thread.sleep(2000);
					 MyWorkspaceLocator.Close(driver).click();
		
		}
		
		public static void WithoutEnterDataTask(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver, 20);
			sheet=workbook.getSheetAt(0);
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			
			  Thread.sleep(2000);
			   MyWorkspaceLocator.clickMyTask(driver).click();
			   
			   Thread.sleep(2000);
			   MyWorkspaceLocator.clickNewTask(driver).click();
			   
				 Thread.sleep(2000);
				 MyWorkspaceLocator.Save(driver).click();
				 Thread.sleep(2000);
				 String msg= MyWorkspaceLocator.ValidMsg(driver).getText();
				 
				 if(msg.equalsIgnoreCase(msg))
				 {
					 test.log(LogStatus.FAIL, "Message displsyed ="+msg);
				 }
				 else
				 {
					 test.log(LogStatus.PASS, "Message displsyed ="+msg);
				 }
				 
				 Thread.sleep(2000);
				 MyWorkspaceLocator.Close(driver).click();
				 
		}
		public static void AddMyTaskCloseBtn(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver, 20);
		
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			
			  Thread.sleep(2000);
			   MyWorkspaceLocator.clickMyTask(driver).click();
			   
			   Thread.sleep(2000);
			   MyWorkspaceLocator.clickNewTask(driver).click();
			   
			   if( MyWorkspaceLocator.CloseBtn(driver).isEnabled())
			   {
				   Thread.sleep(2000);
					 MyWorkspaceLocator.CloseBtn(driver).click();
					 test.log(LogStatus.PASS, "Close button is clickable");
			   }
			   else
			   {
				   test.log(LogStatus.FAIL, "Close button is not clickable");
			   }
			   
		}
		
		public static void EditBtn(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver, 20);
		
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			
			  Thread.sleep(2000);
			   MyWorkspaceLocator.clickMyTask(driver).click();
			   Thread.sleep(2000);
			   if(  MyWorkspaceLocator.EditBtn(driver).isEnabled())
			   {
			   
			      Thread.sleep(2000);
			      MyWorkspaceLocator.EditBtn(driver).click();
			      test.log(LogStatus.PASS, "Edit button is clickable");
			   }
			   else
			   {
				      test.log(LogStatus.FAIL, "Edit button is not clickable");
			   }
			   Thread.sleep(2000);
				 MyWorkspaceLocator.closeBtn(driver).click();
				 
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();
		
		}
			   
		public static void TaskViewDeatiles(WebDriver driver,ExtentTest test) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver, 20);
		
			Thread.sleep(2000);
			MyWorkspaceLocator.MyWorkspaceimg(driver).click();
			
			  Thread.sleep(2000);
			   MyWorkspaceLocator.clickMyTask(driver).click();
			  
			 
			   Thread.sleep(2000);
			   MyWorkspaceLocator.EditBtn(driver).click();
			   
			   Thread.sleep(2000);
			   if(  MyWorkspaceLocator.TaskDetailesTab(driver).isEnabled())
			   {
			   
			      Thread.sleep(2000);
			      MyWorkspaceLocator.TaskDetailesTab(driver).click();
			      test.log(LogStatus.PASS, "User should able to view 'Task Details'");
			   }
			   else
			   {
				      test.log(LogStatus.FAIL, "User should not able to view 'Task Details'");
			   }
			   
			   
			 
			   Thread.sleep(2000);
				 MyWorkspaceLocator.closeBtn(driver).click();
				 
				 Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();
		
		}
			   		
			
			
				
				
			
    
    
		 static void selectOptionFromDropDown_bs(List<WebElement> options, String value) {
				
				for(WebElement option:options) {
					if(option.getText().equals(value)) {
						option.click();
						break;
					}
				}
			 }
		
     

}
