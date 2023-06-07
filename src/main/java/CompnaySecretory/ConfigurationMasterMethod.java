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
	public static void ConfigurationMaster(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
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
    selectOptionFromDropDown_bs( Locator.SelectEntity1(driver), "A LIMITED");
    
    Thread.sleep(3000);
    Locator.ClickMeetingType(driver).click();
    Thread.sleep(2000);
    selectOptionFromDropDown_bs( Locator.SelectMeetingType(driver), "Board");
    Thread.sleep(2000);
    Locator.clickMeetingDate(driver).sendKeys("13/04/2023");
    Thread.sleep(2000);
    Locator.clickMeetingNumberingPattern(driver).click();
    Thread.sleep(2000);
    Locator.clickMeetingNumberingPatternDP(driver).click();
    Thread.sleep(2000);
    Locator.ClickPreviousNumber(driver).sendKeys("2");
    Thread.sleep(2000);
    Locator.clickFY(driver).click();
    Thread.sleep(2000);
    Locator.clickFYDropdown(driver).click();
    
    Locator.ClickSave(driver).click();
    
    
  
    try
    {
    	 Thread.sleep(3000);
		 String msg6 = Locator.ValidMsg(driver).getText();
		 test.log(LogStatus.PASS, "Message Dispalyed =" +msg6);
				
   }  
    catch(Exception e)
    {
    	String msg7=Locator.InValidMsg(driver).getText();
    	test.log(LogStatus.PASS, "Message Dispalyed =" +msg7);
    }
    Thread.sleep(2000);
    Locator.clickClose(driver).click();
	
    	   	    
		    //Detailes of circular
				
				
		 Thread.sleep(2000);
		   Locator.ClickNewBtn1(driver).click();
		   Thread.sleep(2000);
		   Locator.ClickEntity1(driver).click();
		   Thread.sleep(2000);
		   selectOptionFromDropDown_bs(Locator.SelectEntity1(driver), "A LIMITED");
		  
		   Thread.sleep(2000);
		   Locator.ClickMeetingType(driver).click();
		   Thread.sleep(2000);
		   selectOptionFromDropDown_bs( Locator.SelectMeetingType(driver), "Board");
		   
//		    Thread.sleep(4000);
//		    Locator.clickdetailsofcircular(driver).click();
		    
		    By locator2 = By.xpath("//*[@id='frmUpdateMeetings']/div[3]/div/fieldset/div[2]/div/div/div[2]/label[1]");
            wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			WebElement ViewButton2 = driver.findElement(locator2);	
			Thread.sleep(4000);
		    JavascriptExecutor jse2=(JavascriptExecutor)driver;
		    Thread.sleep(2000);
		    jse2.executeScript("arguments[0].click();", ViewButton2);
		    
		    
		    
		    
		    Thread.sleep(2000);
		    Locator.Clickpreviouscirculardate(driver).sendKeys("04-04-2023");
		    Thread.sleep(2000);
		    Locator.clickcircularNumberingpattern(driver).click();
		    selectOptionFromDropDown_bs( Locator.clickcircularNumberingpatternDP(driver), "Continuous");
		   
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
		    Thread.sleep(4000);
			  EntityLocator.ClickDashboard(driver).click();
			}
		    
		    
		    
	public static void UpdateConfiguration(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
		    //Update Configuration
		Thread.sleep(2000);
	    Locator.selectImg(driver).click();
	    Thread.sleep(2000);
	    Locator.ClickMaster(driver).click();
	    Thread.sleep(2000);
	    Locator.ClickConfiguration(driver).click();
				   Thread.sleep(2000);
				    Locator.clickEditIcon(driver).click();
				    Thread.sleep(2000);
				    Locator.clickEditIcon1(driver).click();
				    Thread.sleep(2000);
				    Locator.clickMeetingNumberingPattern(driver).click();
				    selectOptionFromDropDown_bs( Locator.clickcircularNumberingpatternDP(driver), "FY Wise");
				    Thread.sleep(2000);
				    Locator.clickUpdate(driver).click();
				    Thread.sleep(3000);
					 String msg7 = Locator.clickUpdateBtn(driver).getText();
						if(msg7.contains("Updated Successfully."))
						{
							test.log(LogStatus.PASS, "Message Dispalyed =" +msg7);
						}
						else
						{
							test.log(LogStatus.FAIL, "Message Dispalyed =" +msg7);
						}
						Thread.sleep(2000);
					    Locator.clickClose(driver).click();
					    Thread.sleep(4000);
						  EntityLocator.ClickDashboard(driver).click();
	}
					    
    
        public static void DateFormateConfiguration(WebDriver driver,ExtentTest test) throws InterruptedException 
        {
				    
           //Date Pattern DD//MM//YYYY
        	WebDriverWait wait=new WebDriverWait(driver,20);
        	Thread.sleep(2000);
    	    Locator.selectImg(driver).click();
    	    Thread.sleep(2000);
    	    Locator.ClickMaster(driver).click();
    	    Thread.sleep(2000);
    	    Locator.ClickConfiguration(driver).click();
					    
					    Thread.sleep(2000);
					    Locator.ClickNewBtn1(driver).click();
					    
					    //Thread.sleep(2000);
					   // Locator.clickCalender(driver).click();
					    
					    By locator1 = By.xpath("//span[@class='k-icon k-i-calendar']");
			            wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
						Thread.sleep(4000);
						WebElement ViewButton1 = driver.findElement(locator1);	
						Thread.sleep(4000);
					    JavascriptExecutor jse1=(JavascriptExecutor)driver;
					    Thread.sleep(2000);
					    jse1.executeScript("arguments[0].click();", ViewButton1);
					    
					    
					    
					    
					    if(Locator.clickDate(driver).isEnabled())
					    {
					    	Thread.sleep(2000);
					    	 Locator.clickDate(driver).click();
					    	 test.log(LogStatus.PASS,"Date DD/MM/YYYY Format is selected");
					    }
					    else
					    {
					    	test.log(LogStatus.PASS,"Date DD/MM/YYYY Format is not selected");
					    }
					    
					    Thread.sleep(2000);
					    Locator.clickClose(driver).click();
					    Thread.sleep(4000);
						  EntityLocator.ClickDashboard(driver).click();
        }
        public static void MeetingNumberingpatternConfiguration(WebDriver driver,ExtentTest test) throws InterruptedException 
        {
				    
         
        	WebDriverWait wait=new WebDriverWait(driver,20);		    
					    //Meeting Numbering pattern
        	
        	Thread.sleep(2000);
    	    Locator.selectImg(driver).click();
    	    Thread.sleep(2000);
    	    Locator.ClickMaster(driver).click();
    	    Thread.sleep(2000);
    	    Locator.ClickConfiguration(driver).click();
					    
					    Thread.sleep(2000);
					    Locator.ClickNewBtn1(driver).click();
					    
					    Thread.sleep(2000);
					    Locator.clickMeetingNumberingPattern(driver).click();
					   
					   
					    Thread.sleep(2000);
					    if( Locator.clickMeetingNumberingPatternDP2(driver).isEnabled())
					    {
					    	 Thread.sleep(2000);
					    	 Locator.clickMeetingNumberingPatternDP2(driver).click();
					    	 test.log(LogStatus.PASS,"Meeting Numbering pattern  is selected");
					    }
					    else
					    {
					    	test.log(LogStatus.FAIL,"Meeting Numbering pattern  is not selected");
					    }
					    Thread.sleep(5000);
					    Locator.clickClose(driver).click();
					    Thread.sleep(4000);
						  EntityLocator.ClickDashboard(driver).click();
        }
					    
        public static void AddButtonConfiguration(WebDriver driver,ExtentTest test) throws InterruptedException 
        {
				    
					  //Add Button Working or not
        	        WebDriverWait wait=new WebDriverWait(driver,20);		    
		   

                     Thread.sleep(2000);
                     Locator.selectImg(driver).click();
                     Thread.sleep(2000);
                     Locator.ClickMaster(driver).click();
                     Thread.sleep(2000);
                     Locator.ClickConfiguration(driver).click();
					    Thread.sleep(4000);
		                Locator.ClickNewBtn1(driver).click();
						
		                Thread.sleep(4000);     
						if(Locator.ClickSave(driver).isEnabled())
								{
							            Thread.sleep(4000);
							            By locator3 = By.xpath("//*[@id='saveconfig']");
							            wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
										Thread.sleep(4000);
										WebElement ViewButton3 = driver.findElement(locator3);	
										Thread.sleep(4000);
									    JavascriptExecutor jse3=(JavascriptExecutor)driver;
									    Thread.sleep(2000);
									    jse3.executeScript("arguments[0].click();", ViewButton3);
									    
									   // Locator.ClickSave(driver).click();
										test.log(LogStatus.PASS, "Add button is clickable");
										
								}
						  Thread.sleep(4000);
						Locator.clickClose(driver).click();
						  Thread.sleep(4000);
						  EntityLocator.ClickDashboard(driver).click();
		 }
					    
					    
					    
					    
    

	
    public static void selectOptionFromDropDown_bs(List<WebElement> options, String value) {
		
		for(WebElement option:options) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	 }
}
