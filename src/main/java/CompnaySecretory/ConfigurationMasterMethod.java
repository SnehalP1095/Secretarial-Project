package CompnaySecretory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ConfigurationMasterMethod 
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
	public static void ConfigurationMaster(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException
	{
		
		//Add Configuration
	Thread.sleep(2000);
    Locator.selectImg(driver).click();
    Thread.sleep(2000);
    Locator.ClickMaster(driver).click();
    Thread.sleep(2000);
    Locator.ClickConfiguration(driver).click();
    Thread.sleep(2000);
    Locator.ClickNewBtn1(driver).click();
    Thread.sleep(2000);
    Locator.ClickEntity1(driver).click();
    Thread.sleep(2000);
    Locator.SelectEntity1(driver).click();
    Thread.sleep(2000);
    Locator.ClickMeetingType(driver).click();
    Thread.sleep(2000);
    Locator.SelectMeetingType(driver).click();
    Thread.sleep(2000);
    Locator.clickMeetingDate(driver).sendKeys("11/03/2023");
    Thread.sleep(2000);
    Locator.clickMeetingNumberingPattern(driver).click();
    Thread.sleep(2000);
    Locator.clickMeetingNumberingPatternDP(driver).click();
    Thread.sleep(2000);
    Locator.ClickPreviousNumber(driver).sendKeys("5");
    Thread.sleep(2000);
    Locator.clickFY(driver).click();
    Thread.sleep(2000);
    Locator.clickFYDropdown(driver).click();
   
		    Thread.sleep(2000);
		    Locator.clickdetailsofcircular(driver).click();
		    Thread.sleep(2000);
		    Locator.Clickpreviouscirculardate(driver).sendKeys("04-04-2023");
		    Thread.sleep(2000);
		    Locator.clickcircularNumberingpattern(driver).click();
		    Thread.sleep(2000);
		    Locator.clickcircularNumberingpatternDP(driver).click();
		    Thread.sleep(2000);
		    Locator.clickcircularNumber(driver).sendKeys("4");
//		    Thread.sleep(2000);
//		    Locator.clickFY1(driver).click();
//		    Thread.sleep(2000);
//		    Locator.clickFYDropdown1(driver).click();
		    
		    Thread.sleep(2000);
		    Locator.ClickSave(driver).click();
		    Thread.sleep(2000);
		    Locator.ClickSave(driver).click();
		    
		    Thread.sleep(2000);
		    Locator.clickClose(driver).click();
		/*  Thread.sleep(3000);
			 String msg6 = Locator.ValidMsg(driver).getText();
				if(msg6.contains("Saved Successfully."))
				{
					test.log(LogStatus.PASS, "Message Dispalyed =" +msg6);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message Dispalyed =" +msg6);
				} */
		    
		    
		    //Update Configuration
				   Thread.sleep(2000);
				    Locator.clickEditIcon(driver).click();
				    Thread.sleep(2000);
				    Locator.clickEditIcon1(driver).click();
//				    Thread.sleep(2000);
//				    Locator.ClickMeetingType(driver).click();
//				    Thread.sleep(2000);
//				    Locator.SelectMeetingType1(driver).click();
				    Thread.sleep(2000);
				    Locator.clickUpdate(driver).click();
				    Thread.sleep(3000);
					 String msg6 = Locator.clickUpdateBtn(driver).getText();
						if(msg6.contains("Updated Successfully."))
						{
							test.log(LogStatus.PASS, "Message Dispalyed =" +msg6);
						}
						else
						{
							test.log(LogStatus.FAIL, "Message Dispalyed =" +msg6);
						}
						Thread.sleep(2000);
					    Locator.clickClose(driver).click();
					    
					    //Date Pattern DD//MM//YYYY
					    
					    Thread.sleep(2000);
					    Locator.ClickNewBtn1(driver).click();
					    
					    Thread.sleep(2000);
					    Locator.clickCalender(driver).click();
					    
					    
					    
					    
					    if(Locator.clickDate(driver).isEnabled())
					    {
					    	Thread.sleep(2000);
					    	 Locator.clickDate(driver).click();
					    	 test.log(LogStatus.PASS,"Date is selected");
					    }
					    else
					    {
					    	test.log(LogStatus.PASS,"Date is not selected");
					    }
					    
					    Thread.sleep(2000);
					    Locator.clickClose(driver).click();
					    
					    //Meeting Numbering pattern
					    
					    Thread.sleep(2000);
					    Locator.ClickNewBtn1(driver).click();
					    
					    Thread.sleep(2000);
					    Locator.clickMeetingNumberingPattern(driver).click();
					   
					    Thread.sleep(2000);
					    if( Locator.clickMeetingNumberingPatternDP1(driver).isSelected())
					    {
					    	 Thread.sleep(2000);
					    	 Locator.clickMeetingNumberingPatternDP1(driver).click();
					    	 test.log(LogStatus.PASS,"Meeting Numbering pattern  is selected");
					    }
					    else
					    {
					    	test.log(LogStatus.PASS,"Meeting Numbering pattern  is not selected");
					    }
					    Thread.sleep(2000);
					    Locator.clickClose(driver).click();
					    
					    
					    
					    
					    
					    
    
	}
}
