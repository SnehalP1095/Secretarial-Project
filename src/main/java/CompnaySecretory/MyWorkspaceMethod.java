package CompnaySecretory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
//			   Thread.sleep(200);
//			    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']/li"));
//				selectOptionFromDropDown_bs(entitytype, "Draft Resolution & Minutes");
		
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
		 static void selectOptionFromDropDown_bs(List<WebElement> options, String value) {
				
				for(WebElement option:options) {
					if(option.getText().equals(value)) {
						option.click();
						break;
					}
				}
			 }
		
     

}
