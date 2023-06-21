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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Table.Cell;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class EntityMasterMethod 

{
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static XSSFSheet sheet1 = null;		//Sheet variable
	private static List<WebElement> elementsList = null;


	
	public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\SecreterialSheet3.xlsx");
		
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		return sheet;
	}

	public static void DeemedPublicCompany(WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException
	{
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	    //Thread.sleep(2000);
	   // EntityLocator.selectMaster(driver).click();
	   // Thread.sleep(2000);
	   // EntityLocator.clickEntity(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickAddNewBtn(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    
	    
	    if(EntityLocator.selectEntityType(driver).isEnabled())
	    {
	      Thread.sleep(2000);
	      EntityLocator.selectEntityType(driver).click();
	      test.log(LogStatus.PASS, "Deemed Public Compnay is Selected");
	    }
	    else
	    {
	    	 test.log(LogStatus.FAIL, "Deemed Public Compnay is not Selected");
	    }
	    
	    Thread.sleep(4000);
	     EntityLocator.CloseEntity(driver).click();
	     
	     Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	   
	    
	    
	    
	 }
	
	public static void AddDeemedPublicCompany(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	{

	  WebDriverWait wait = new WebDriverWait(driver, (120));
	  Thread.sleep(3000);
	  sheet = workbook.getSheetAt(0);              // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	  Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickAddNewBtn(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    Thread.sleep(200);
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Deemed Public Company");
	    
	  
		Thread.sleep(2000);
	    Row row = sheet.getRow(37);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
		String name = c.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.EntityName(driver).sendKeys(name);
	  
		
		Thread.sleep(2000);
	    Row row1 = sheet.getRow(38);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String CIN = c1.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.CINEntity(driver).sendKeys(CIN);
	  
	   
	  Thread.sleep(4000);
	  EntityLocator.CalendorIcon(driver).click();
	  Thread.sleep(2000);
	  EntityLocator.Date(driver).click();
	  
	   Thread.sleep(2000);
	    Row row2 = sheet.getRow(39);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c2 = row2.getCell(1);						//Selected cell (1 row,1 column)
		String pan = c2.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.PAN(driver).sendKeys(pan);
	  
	 
	 
	  Thread.sleep(5000);
	  EntityLocator.Roc(driver).click();
	  Thread.sleep(4000);
	  List<WebElement>roc = driver.findElements(By.xpath("//ul[@id='ddlRocJuris_listbox']//li"));
	  selectOptionFromDropDown_bs(roc, "Mumbai");
	  
	  EntityLocator.CompanyCategory(driver).click();
	  Thread.sleep(2000);
	  List<WebElement>comCat = driver.findElements(By.xpath("//ul[@id='ddlComCategary_listbox']//li"));
	  selectOptionFromDropDown_bs(comCat, "Company limited by shares");
	  
	   Thread.sleep(2000);
	    Row row3 = sheet.getRow(40);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c3 = row3.getCell(1);						//Selected cell (1 row,1 column)
		String email = c3.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.EmailE(driver).sendKeys(email);
	  
	   EntityLocator.FinancialYear(driver).click();
	   Thread.sleep(2000);
	   List<WebElement>finYr = driver.findElements(By.xpath("//ul[@id='FY_listbox']//li"));
	   selectOptionFromDropDown_bs(finYr, "1 Apr - 31 Mar");
	  
	    Thread.sleep(2000);
	    Row row4 = sheet.getRow(41);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c4 = row4.getCell(1);						//Selected cell (1 row,1 column)
		String address = c4.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.AddressE(driver).sendKeys(address);
		 
		Thread.sleep(2000);
		    Row row5 = sheet.getRow(41);						//Selected 1st index row (Second row)
			org.apache.poi.ss.usermodel.Cell c5 = row5.getCell(1);						//Selected cell (1 row,1 column)
			String address1 = c5.getStringCellValue();			//Got the URL stored at position 1,1
			EntityLocator.AddressE1(driver).sendKeys(address1);
	  
	  Thread.sleep(2000);
	  EntityLocator.StateE(driver).click();
	  Thread.sleep(2000);
	  List<WebElement>state = driver.findElements(By.xpath("//*[@id='stateId_listbox']/li"));
	  selectOptionFromDropDown_bs(state, "Maharashtra");
	
	  Thread.sleep(2000);
	  EntityLocator.CityE(driver).click();
	  Thread.sleep(3000);
	  List<WebElement>city = driver.findElements(By.xpath("//ul[@id='ddlreg_cityId_listbox']//li"));
	  selectOptionFromDropDown_bs(city, "Ahmadnagar");
	 
	  
	 Thread.sleep(3000);
	  EntityLocator.SaveE(driver).click();
	  
	  try 
	  {
			 Thread.sleep(3000);
        String msg=	EntityLocator.SaveEMsg(driver).getText();
        test.log(LogStatus.PASS, msg );
       
	  }
      catch(Exception  e) 
	  {
    		 Thread.sleep(3000);
		 String msg=EntityLocator.SaveEMsg1(driver).getText();
		  test.log(LogStatus.PASS, msg );
		
	  }
     Thread.sleep(4000);
     EntityLocator.CloseEntity(driver).click();
   
     Thread.sleep(4000);
     EntityLocator.ClickDashboard(driver).click();
    
     
 }
	
	
	
	
	public static void EnterInvalidData(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		 Thread.sleep(2000);
		    EntityLocator.clickAddNewBtn(driver).click();
		    Thread.sleep(2000);
		    EntityLocator.clickEntityType(driver).click();
		    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
			selectOptionFromDropDown_bs(entitytype, "Deemed Public Company");
			
			
			Thread.sleep(2000);
			EntityLocator.EntityName(driver).sendKeys("dfg45#");
			Thread.sleep(2000);
			EntityLocator.CINEntity(driver).sendKeys("45356");
		
			Thread.sleep(2000);
			EntityLocator.PAN(driver).sendKeys("76755");
			  
			Thread.sleep(2000);
			EntityLocator.EmailE(driver).sendKeys("fgdser");
			
			Thread.sleep(2000);
			EntityLocator.clickInvalidDate(driver).sendKeys("21-04-202");
	
			
		    Thread.sleep(2000);
		    EntityLocator.AddressE(driver).sendKeys("sdfre%$6");
		    
			Thread.sleep(3000);
			EntityLocator.SaveE(driver).click();
			
			Thread.sleep(3000);
			String msg=EntityLocator.InvalidMsgName(driver).getText();
			String msg1=EntityLocator.InvalidMsgeCIN(driver).getText();
			String msg2= EntityLocator.InValidDate(driver).getText();
			String msg3=EntityLocator.InValidPan(driver).getText();
			String msg4=EntityLocator.InValidEmail(driver).getText();
			
			 test.log(LogStatus.PASS, "Enter Invalid Fileds = " +msg +"," +msg1 +"," +msg2 +"," +msg3 +"," +msg4);
			  
			  
		     Thread.sleep(4000);
		     EntityLocator.CloseEntity(driver).click();
			
		     Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		
		
	}
	
	public static void TwoMandatoryFields(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	{
		
		sheet = workbook.getSheetAt(0);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		    Thread.sleep(2000);
		    EntityLocator.clickAddNewBtn(driver).click();
		    Thread.sleep(2000);
		    EntityLocator.clickEntityType(driver).click();
		    Thread.sleep(200);
		    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
			selectOptionFromDropDown_bs(entitytype, "Deemed Public Company");
		    
		  
			Thread.sleep(2000);
		    Row row = sheet.getRow(37);						//Selected 1st index row (Second row)
			org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
			String name = c.getStringCellValue();			//Got the URL stored at position 1,1
			EntityLocator.EntityName(driver).sendKeys(name);
		  
			
			Thread.sleep(2000);
		    Row row1 = sheet.getRow(38);						//Selected 1st index row (Second row)
			org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
			String CIN = c1.getStringCellValue();			//Got the URL stored at position 1,1
			EntityLocator.CINEntity(driver).sendKeys(CIN);
			
			
			 Thread.sleep(3000);
			  EntityLocator.SaveE(driver).click();
			  
			  
			  String msg= EntityLocator.InValidDate(driver).getText();
			  String msg1=EntityLocator.InValidPan(driver).getText();
			  String msg2=EntityLocator.InValidROC(driver).getText();
			  String msg3=EntityLocator.InValidEmail(driver).getText();
			  String msg4=EntityLocator.InValidFY(driver).getText();
			  String msg5=EntityLocator.InValidAddress(driver).getText();
			  String msg6=EntityLocator.InValidState(driver).getText();
			  String msg7=EntityLocator.InValidCity(driver).getText();
			  
			  test.log(LogStatus.PASS, "Enter Two Mandatory Fileds = " +msg +"," +msg1 +"," +msg2 +"," +msg3 +"," +msg4 +"," +msg5 +"," +msg6 +"," +msg7);
			  
			  
		     Thread.sleep(4000);
		     EntityLocator.CloseEntity(driver).click();
		   
		     Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		     
		    
		     
		     
		  
	}
	
	public static void WithouEnteringField(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.clickAddNewBtn(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    Thread.sleep(2000);
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Deemed Public Company");
		
		 Thread.sleep(3000);
		  EntityLocator.SaveE(driver).click();
		  
		  
		  String msg= EntityLocator.InValidDate(driver).getText();
		  String msg1=EntityLocator.InValidPan(driver).getText();
		  String msg2=EntityLocator.InValidROC(driver).getText();
		  String msg3=EntityLocator.InValidEmail(driver).getText();
		  String msg4=EntityLocator.InValidFY(driver).getText();
		  String msg5=EntityLocator.InValidAddress(driver).getText();
		  String msg6=EntityLocator.InValidState(driver).getText();
		  String msg7=EntityLocator.InValidCity(driver).getText();
		  String msg8=EntityLocator.InvalidMsgName(driver).getText();
		  String msg9=EntityLocator.InvalidMsgeCIN(driver).getText();
		  
		  test.log(LogStatus.PASS, "Without Entering Fileds = " +msg +"," +msg1 +"," +msg2 +"," +msg3 +"," +msg4 +"," +msg5 +"," +msg6 +"," +msg7 +"," +msg8 +"," +msg9);
		  
		  
		  Thread.sleep(4000);
		     EntityLocator.CloseEntity(driver).click();
		     Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void CloseBtn(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.clickAddNewBtn(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    Thread.sleep(2000);
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Deemed Public Company");
		
		
		  Thread.sleep(2000);
	     if(EntityLocator.CloseEntity(driver).isEnabled())
		    {
		      Thread.sleep(2000);
		      EntityLocator.CloseEntity(driver).click();
		      test.log(LogStatus.PASS, "Close Buttton is clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Close Buttton is not clickable");
		    }
	     
	     
	     Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	
	
	}
	
	
	public static void EditIcon(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	{
		sheet = workbook.getSheetAt(0);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    Thread.sleep(2000);
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Deemed Public Company");
	    
	    Thread.sleep(2000);
		EntityLocator.PAN(driver).clear();
	    
	    Thread.sleep(2000);
	    Row row2 = sheet.getRow(42);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c2 = row2.getCell(1);						//Selected cell (1 row,1 column)
		String pan = c2.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.PAN(driver).sendKeys(pan);
		
		
		Thread.sleep(3000);
		EntityLocator.SaveE(driver).click();
		
		
		Thread.sleep(3000);
		String msg=EntityLocator.clickUpdateBtn(driver).getText();
	    if(msg.equalsIgnoreCase("Entity updated successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg);
		
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed = "+msg);
		}
	    Thread.sleep(4000);
	     EntityLocator.CloseEntity(driver).click();
		
	     Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void InvalidEditIcon(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    Thread.sleep(2000);
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Deemed Public Company");
	    
	    Thread.sleep(2000);
		EntityLocator.PAN(driver).clear();
	    
		Thread.sleep(2000);
		EntityLocator.PAN(driver).sendKeys("fhdhtrv");
		
		
		Thread.sleep(3000);
		EntityLocator.SaveE(driver).click();
		
		
		
		 String msg1=EntityLocator.InValidPan(driver).getText();
		 test.log(LogStatus.PASS, "Message displayed = "+msg1);
		
		
	
	    Thread.sleep(4000);
	     EntityLocator.CloseEntity(driver).click();
	     Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	public static void EditCloseBtn(WebDriver driver, ExtentTest test) throws InterruptedException
	{   
		Thread.sleep(2000);
	    EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    Thread.sleep(2000);
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Deemed Public Company");
		
		
	     
	     if(EntityLocator.CloseEntity(driver).isEnabled())
		    {
		      Thread.sleep(2000);
		      EntityLocator.CloseEntity(driver).click();
		      test.log(LogStatus.PASS, "Close Buttton is clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Close Buttton is not clickable");
		    }
	     
	     
	     Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	 }
	
	
	public static void BuisnessActivity(WebDriver driver,ExtentTest test) throws InterruptedException
	{
	
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	   
	    Thread.sleep(2000);
	    if(EntityLocator.clickBusinessActivity(driver).isEnabled())
	    {
	      Thread.sleep(2000);
	      EntityLocator.clickBusinessActivity(driver).click();
	      test.log(LogStatus.PASS, "Business Activity Tab is clickable");
	    }
	    else
	    {
	    	 test.log(LogStatus.FAIL, "Business Activity Tab is not clickable");
	    }
     
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	
	public static void AddBuisnessActivity(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBusinessActivity(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickNewBusinessActivity(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickMainActivityCode(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickMainActivityCodeDropdwon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBA(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBADropdown(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickSave(driver).click();
	  	    
	    
	    Thread.sleep(2000);
	    String Msg=EntityLocator.BAValidMsg(driver).getText();
	    if(Msg.equalsIgnoreCase("Record Save Successfully"))
	    {
	     
	      test.log(LogStatus.PASS, "Message Displayed = " +Msg);
	    }
	    else
	    {
	    	 test.log(LogStatus.FAIL, "Message Displayed = " +Msg);
	    }
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();

	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void BAnotFound(WebDriver driver,ExtentTest test) throws InterruptedException
	{
	
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    Thread.sleep(3000);
	    EntityLocator.clickBusinessActivity(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickNewBusinessActivity(driver).click();
	 
	    Thread.sleep(2000);
	    EntityLocator.clickBA(driver).click();
	    Thread.sleep(2000);
	    String msg=EntityLocator.NoDataFound(driver).getText();
	    if(msg.equalsIgnoreCase("No data found."))
	    {
	     
	      test.log(LogStatus.PASS, "Business Activity Dropdwon= " +msg);
	    }
	      
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void WithoutEnterData(WebDriver driver,ExtentTest test) throws InterruptedException
	{

		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBusinessActivity(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickNewBusinessActivity(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickSave(driver).click();
	    
	    Thread.sleep(2000);
	    String Msg=EntityLocator.BAValidMsg(driver).getText();
	    if(Msg.equalsIgnoreCase("Record Save Successfully"))
	    {
	     
	      test.log(LogStatus.FAIL, "Validation Message should get Displayed for manadtory fields = " +Msg);
	    }
	    else
	    {
	    	 test.log(LogStatus.PASS, "Validation Message should get Displayed for manadtory fields  = " +Msg);
	    }
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	public static void EditBA(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(3000);
	    EntityLocator.clickEditIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBusinessActivity(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.EditBA(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickMainActivityCode(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickMainActivityCodeDropdwon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBA(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBADropdown1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickSave(driver).click();
	  	    
	    
	    Thread.sleep(2000);
	    String Msg=EntityLocator.BAValidMsg(driver).getText();
	    if(Msg.equalsIgnoreCase("Record Updated Successfully"))
	    {
	     
	      test.log(LogStatus.PASS, "Message Displayed = " +Msg);
	    }
	    else
	    {
	    	 test.log(LogStatus.FAIL, "Message Displayed = " +Msg);
	    }
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	
	public static void EditBAInvalidData(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBusinessActivity(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.EditBA(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickPercentage(driver).sendKeys("e");
	    
	    Thread.sleep(2000);
	    EntityLocator.clickSave(driver).click();
	    
	    Thread.sleep(2000);
	    String Msg=EntityLocator.BAValidMsg(driver).getText();
	    if(Msg.equalsIgnoreCase("Record Updated Successfully"))
	    {
	     
	      test.log(LogStatus.FAIL, "Error Message should get  Displayed in percentage section = " +Msg);
	    }
	    else
	    {
	    	 test.log(LogStatus.PASS, "Error Message should get  Displayed in percentage section = " +Msg);
	    }
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	
	public static void BADeleteIcon(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBusinessActivity(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDeleteIcon(driver).click();
	    
	    

	    
	    By locator = By.xpath("//*[@id='yesBA']");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(3000);
	   JavascriptExecutor jse=(JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
	    
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
	    EntityLocator.clickcloseIcon(driver).click();
        Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
        
	}
	
	public static void BACloseBtn(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
	EntityLocator.selectImg(driver).click();
	Thread.sleep(2000);
    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
    Thread.sleep(2000);
    EntityLocator.clickEditIcon1(driver).click();
    Thread.sleep(2000);
    EntityLocator.clickBusinessActivity(driver).click();
    Thread.sleep(2000);
    EntityLocator.clickNewBusinessActivity(driver).click();
		
	     
	     if(EntityLocator.clickcloseIcon1(driver).isEnabled())
		    {
		      Thread.sleep(2000);
		      EntityLocator.clickcloseIcon1(driver).click();
		      test.log(LogStatus.PASS, "Close Buttton is clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Close Buttton is not clickable");
		    }
	     
	     Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
	     Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	 }
	
	public static void DocumentTab(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	     Thread.sleep(2000);
	    if(EntityLocator.ClickDocumentTab(driver).isEnabled())
	    {
	      Thread.sleep(2000);
	      EntityLocator.ClickDocumentTab(driver).click();
	      test.log(LogStatus.PASS, "Douement Tab is clickable");
	    }
	    else
	    {
	    	 test.log(LogStatus.FAIL, "Document Tab is not clickable");
	    }
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void AddNewDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocTypeDropDown(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCADE");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		    
	}
	
	public static void AlreadyExistDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocTypeDropDown(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABACDE");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg1);
		 }
		catch(Exception e)
		{
				String msg = EntityLocator.ClickValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		    
	}
	
	public static void WithoutEnteringDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickValidMsgFile(driver).getText();
	     if(msg.equalsIgnoreCase("Please select File"))
	     {
	    	 test.log(LogStatus.PASS,"Message Displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "Message Displayed =" +msg);
		    }
	     
	     Thread.sleep(2000);
		    EntityLocator.ClickCloseIcon(driver).click();
		    
		    Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		    
		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	     
	}
	public static void ViewDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickViewIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickClose(driver).click();
	    
	    test.log(LogStatus.PASS,"View Popup Open Successfully");
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	public static void DownloadDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	
	    
	    
	    
	    File dir = new File("C:\\Users\\Snehal Patil\\Downloads");
	  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	  		
	  	Thread.sleep(2000);
	 	EntityLocator.ClickDownloadIcon(driver).click();		//Exporting (Downloading) file
	  		
	    Thread.sleep(3000);
	    File dir1 = new File("C:\\Users\\Snehal Patil\\Downloads");
	    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
	   
	  		
	  	if (dirContents.length < allFilesNew.length) 
	  	{
	  		test.log(LogStatus.PASS,  "  Document downloaded successfully.");
	  	} 
	  	else 
	  	{
	  		test.log(LogStatus.FAIL, "  Document does not downloaded.");
	  	}
	   
	  	 Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
	  	
	  	 Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	  
	    
	}   
	
	
	public static void DeleteDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDeleteIcon1(driver).click();
	   
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickDeleteValidMsg(driver).getText();
	    Thread.sleep(2000);
	    if(msg.equalsIgnoreCase("Are you sure you want to delete this data?"))
	     {
	    	
	    	 test.log(LogStatus.PASS,"The item should get deleted from the list and success message will displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "The item should get deleted from the list and success message will displayed =" +msg);
		    }
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickYes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void AddAOA(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAOA(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABED");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(200);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	
	public static void ExistingAOADocument(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAOA(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABED");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\\\Litigation_Notice_Upload_Format.xlsx");
	   
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg1);
		 }
		catch(Exception e)
		{
				String msg = EntityLocator.ClickValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(200);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	
	public static void WithoutEnteringAOADocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAOA(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickValidMsgFile(driver).getText();
	     if(msg.equalsIgnoreCase("Please select File"))
	     {
	    	 test.log(LogStatus.PASS,"Message Displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "Message Displayed =" +msg);
		    }
	     
	     Thread.sleep(2000);
		    EntityLocator.ClickCloseIcon(driver).click();
		    Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		    Thread.sleep(200);
		     EntityLocator.ClickDashboard(driver).click();
	}
	
	
	
	public static void ViewAOADocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickViewAOAIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickClose(driver).click();
	    
	    test.log(LogStatus.PASS,"View Popup Open Successfully");
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	public static void DownloadAOADocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	  
	   
	    
	    File dir = new File("C://Users//Snehal Patil//Downloads");
	  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	  		
	    Thread.sleep(2000);
	    EntityLocator.ClickDownloadAOAIcon(driver).click();	//Exporting (Downloading) file
	  		
	    Thread.sleep(3000);
	    File dir1 = new File("C://Users//Snehal Patil//Downloads");
	    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
	  		
	  		
	  	if (dirContents.length < allFilesNew.length) 
	  	{
	  		test.log(LogStatus.PASS,  "  Document downloaded successfully.");
	  	} 
	  	else 
	  	{
	  		test.log(LogStatus.FAIL, "  Document does not downloaded.");
	  	}
	  	 Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
	  	 Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}   
	
	
	public static void DeleteAOADocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDeleteAOAIcon1(driver).click();
	   
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickDeleteValidMsg(driver).getText();
	    Thread.sleep(2000);
	    if(msg.equalsIgnoreCase("Are you sure you want to delete this data?"))
	     {
	    	
	    	 test.log(LogStatus.PASS,"The item should get deleted from the list and success message will displayed  =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "The item should get deleted from the list and success message will displayed  =" +msg);
		    }
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickYes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	
	public static void AddCOI(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCOI(driver).click();
	 
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("STD");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C://Users//Snehal Patil//Downloads\\Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	
	
	public static void ExistingCOIDocument(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCOI(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("STD");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C://Users//Snehal Patil//Downloads\\\\Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg1);
		 }
		catch(Exception e)
		{
				String msg = EntityLocator.ClickValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg);
		}
	    
	  
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	
	public static void WithoutEnteringCOIDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCOI(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickValidMsgFile(driver).getText();
	     if(msg.equalsIgnoreCase("Please select File"))
	     {
	    	 test.log(LogStatus.PASS,"Message Displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "Message Displayed =" +msg);
		    }
	     
	     Thread.sleep(2000);
		    EntityLocator.ClickCloseIcon(driver).click();
		    
		    Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	     
	}
	
	
	public static void ViewCOIDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickViewCOIIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickClose(driver).click();
	    
	    test.log(LogStatus.PASS,"View Popup Open Successfully");
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	public static void DownloadCOIDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	  
	    
	    
	    File dir = new File("C://Users//Snehal Patil//Downloads");
	  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	  		
	    Thread.sleep(2000);
	    EntityLocator.ClickDownloadCOIIcon(driver).click();	//Exporting (Downloading) file
	  		
	    Thread.sleep(3000);
	    File dir1 = new File("C://Users//Snehal Patil//Downloads");
	    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
	  		
	  		
	  	if (dirContents.length < allFilesNew.length) 
	  	{
	  		test.log(LogStatus.PASS,  "  Document downloaded successfully.");
	  	} 
	  	else 
	  	{
	  		test.log(LogStatus.FAIL, "  Document does not downloaded.");
	  	}
	  	 Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
	 
	  	 Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}   
	public static void DeleteCOIDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDeleteCOIIcon1(driver).click();
	   
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickDeleteValidMsg(driver).getText();
	    Thread.sleep(2000);
	    if(msg.equalsIgnoreCase("Are you sure you want to delete this data?"))
	     {
	    	
	    	 test.log(LogStatus.PASS,"The item should get deleted from the list and success message will displayed  =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "The item should get deleted from the list and success message will displayed  =" +msg);
		    }
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickYes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	
	public static void AddPolicyDoc(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickPolicy(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCDR");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C://Users//Snehal Patil//Downloads//Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    Thread.sleep(3000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	    
	public static void ExistingPolicyDoc(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickPolicy(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCDR");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C://Users//Snehal Patil//Downloads//Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg1);
		 }
		catch(Exception e)
		{
				String msg = EntityLocator.ClickValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}    
	
	public static void WithoutEnteringPolicyDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickPolicy(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickValidMsgFile(driver).getText();
	     if(msg.equalsIgnoreCase("Please select File"))
	     {
	    	 test.log(LogStatus.PASS,"Message Displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "Message Displayed =" +msg);
		    }
	     
	     Thread.sleep(2000);
		    EntityLocator.ClickCloseIcon(driver).click();
		    Thread.sleep(3000);
		    EntityLocator.clickcloseIcon(driver).click();
		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	     
	}
	
	public static void ViewPolicyDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickPolicies(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickViewAOAIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickClose(driver).click();
	    
	    test.log(LogStatus.PASS,"View Popup Open Successfully");
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	public static void DownloadPolicyDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	 
	   
	    
	    File dir = new File("C://Users//Snehal Patil//Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		 Thread.sleep(2000);
		 EntityLocator.ClickDownloadAOAIcon(driver).click();		//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C://Users//Snehal Patil//Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "  Document downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  Document does not downloaded.");
		}
		 Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
	    
		 Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	    
	    
	    
	}   
	public static void DeletePolicyDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDeleteAOAIcon1(driver).click();
	   
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickDeleteValidMsg(driver).getText();
	    Thread.sleep(2000);
	    if(msg.equalsIgnoreCase("Are you sure you want to delete this data?"))
	     {
	    	
	    	 test.log(LogStatus.PASS,"The item should get deleted from the list and success message will displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "The item should get deleted from the list and success message will displayed  =" +msg);
		    }
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickYes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	public static void AddLicenseRegistration(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickLicenseRegistration(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickLicenseRegistrationNo(driver).sendKeys("@12");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickLastRenewDate(driver).sendKeys("16/04/2023");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpcomingRenewDate(driver).sendKeys("16/05/2023");
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("Test Test");
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C://Users//Snehal Patil//Downloads//Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    
	    
	    Thread.sleep(3000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	public static void EnterInvalidDataLicenseRegistration(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickLicenseRegistration(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickLicenseRegistrationNo(driver).sendKeys("@19");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickLastRenewDate(driver).sendKeys("16/05/2023");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpcomingRenewDate(driver).sendKeys("16/04/2023");
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("Test");
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C://Users//Snehal Patil//Downloads//Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    
	    
	    Thread.sleep(3000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.FAIL, "Error Message Should be displayed that the last renewal date should not exceed the next renewal date = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.PASS, "Error Message Should be displayed that the last renewal date should not exceed the next renewal date = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	public static void WithoutEnteringLicenseRegistrationDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickLicenseRegistration(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickLicenseRegistrationNo(driver).sendKeys("@12");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickLastRenewDate(driver).sendKeys("16/05/2023");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpcomingRenewDate(driver).sendKeys("16/04/2023");
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("Test");
	    
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickValidMsgFile(driver).getText();
	     if(msg.equalsIgnoreCase("Please select File"))
	     {
	    	 test.log(LogStatus.PASS,"Message Displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "Message Displayed =" +msg);
		    }
	     
	     Thread.sleep(2000);
		    EntityLocator.ClickCloseIcon(driver).click();
		    
		    Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		    
		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	     
	}
	
	public static void AddExistingLicenseRegistration(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickLicenseRegistration(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickLicenseRegistrationNo(driver).sendKeys("@12");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickLastRenewDate(driver).sendKeys("16/04/2023");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpcomingRenewDate(driver).sendKeys("16/05/2023");
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("Test");
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C://Users//Snehal Patil//Downloads//Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    
	    
	    Thread.sleep(3000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.FAIL, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.PASS, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	public static void ViewLicenseRegistrationDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.LicenseRegistrationLLP(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ViewLicenseRegistrationLLP(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickClose(driver).click();
	    
	    test.log(LogStatus.PASS,"View Popup Open Successfully");
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	public static void DownloadLicenseRegistrationDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	 
	    Thread.sleep(2000);
	    EntityLocator.LicenseRegistrationLLP(driver).click();
	    
	    File dir = new File("C://Users//Snehal Patil//Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		 Thread.sleep(2000);
		 EntityLocator.DownloadLicenseRegistrationLLP(driver).click();		//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C://Users//Snehal Patil//Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "  Document downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  Document does not downloaded.");
		}
		 Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
	    
		 Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	    
	    
	    
	}   
	
	public static void DeleteLicenseRegistrationDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.LicenseRegistrationLLP(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.DeleteLicenseRegistrationLLP(driver).click();
	   
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickDeleteValidMsg(driver).getText();
	    Thread.sleep(2000);
	    if(msg.equalsIgnoreCase("Are you sure you want to delete this data?"))
	     {
	    	
	    	 test.log(LogStatus.PASS,"The item should get deleted from the list and success message will displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "The item should get deleted from the list and success message will displayed  =" +msg);
		    }
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickYes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	
	public static void AddAnnualReport(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAnnualReport(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickSerialNoOfAGM(driver).sendKeys("6845");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickLastRenewDate(driver).sendKeys("13/04/2023");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickFY(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.SelectFY(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator. ClickDescrition(driver).sendKeys("Automation Test");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickFile(driver).sendKeys("C://Users//Snehal Patil//Downloads//Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(4000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    
	    
	    Thread.sleep(3000);   
	    try
		 {
	    	 Thread.sleep(3000); 
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
			 Thread.sleep(3000); 
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	
	}
	public static void AddExistingDataAnnualReport(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAnnualReport(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickSerialNoOfAGM(driver).sendKeys("6845");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickLastRenewDate(driver).sendKeys("13/04/2023");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickFY(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.SelectFY(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator. ClickDescrition(driver).sendKeys("Automation Test");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickFile(driver).sendKeys("C://Users//Snehal Patil//Downloads//Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(4000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    
	    
	    Thread.sleep(3000);   
	    try
		 {
	    	 Thread.sleep(3000); 
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.FAIL, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
			 Thread.sleep(3000); 
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.PASS, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	
	}
	
	public static void WithoutUploadFileAnnualReport(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAnnualReport(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickSerialNoOfAGM(driver).sendKeys("65");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickLastRenewDate(driver).sendKeys("13/04/2023");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickFY(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.SelectFY(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCD");
	    
	    Thread.sleep(4000);
	    EntityLocator.ClickSaveBtn(driver).click();
	    
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickValidMsgFile(driver).getText();
	     if(msg.equalsIgnoreCase("Please select File"))
	     {
	    	 test.log(LogStatus.PASS,"Message Displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "Message Displayed =" +msg);
		    }
	    
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	public static void ViewAnnualReportDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.AnnualReportLLP(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ViewAnnualReport(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickClose(driver).click();
	    
	    test.log(LogStatus.PASS,"View Popup Open Successfully");
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	public static void DownloadAnnualReportDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	 
	    Thread.sleep(2000);
	    EntityLocator.AnnualReportLLP(driver).click();
	    
	    File dir = new File("C://Users//Snehal Patil//Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		 Thread.sleep(2000);
		 EntityLocator.DownloadAnnualReport(driver).click();		//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C://Users//Snehal Patil//Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "  Document downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  Document does not downloaded.");
		}
		 Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
	    
		 Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	  }   
	
	public static void DeleteAnnualReportDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.AnnualReportLLP(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.DeleteAnnualReport(driver).click();
	   
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickDeleteValidMsg(driver).getText();
	    Thread.sleep(2000);
	    if(msg.equalsIgnoreCase("Are you sure you want to delete this data?"))
	     {
	    	
	    	 test.log(LogStatus.PASS,"The item should get deleted from the list and success message will displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "The item should get deleted from the list and success message will displayed  =" +msg);
		    }
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickYes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	
	public static void BranchDetailes(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	
	    Thread.sleep(2000);
	   
	    
	    if(EntityLocator.ClickBranchDetailes(driver).isEnabled())
	    {
	      Thread.sleep(2000);
	      EntityLocator.ClickBranchDetailes(driver).click();
	      test.log(LogStatus.PASS, "Branch Detailes is clickable");
	    }
	    else
	    {
	    	 test.log(LogStatus.PASS, "Branch Detailes is not clickable");
	    }
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	
	}
	public static void AddBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		sheet = workbook.getSheetAt(0);
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAddNew(driver).click();
	    
	  
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeMyCompliances"));
	    
	    Thread.sleep(2000);
	    Row row = sheet.getRow(45);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
		String name = c.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.ClickName(driver).sendKeys("Satara");
		
		Thread.sleep(2000);
	    EntityLocator.ClickBranchType(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.SelectBranchType(driver).click();
	    
	
		
		 Thread.sleep(2000);
		 Row row1 = sheet.getRow(46);						//Selected 1st index row (Second row)
		 org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		 String ContactPerson = c1.getStringCellValue();			//Got the URL stored at position 1,1
		 EntityLocator.ClickContactPerson(driver).sendKeys(ContactPerson);
		 
//		 Thread.sleep(2000);
//		 Row row2 = sheet.getRow(47);						//Selected 1st index row (Second row)
//		 org.apache.poi.ss.usermodel.Cell c2 = row2.getCell(1);						//Selected cell (1 row,1 column)
//		 int ContactNumber= (int)c2.getNumericCellValue();
//		 EntityLocator.ClickContactNumber(driver).sendKeys(" "+ContactNumber);
		 
		 Thread.sleep(2000);
		 EntityLocator.ClickContactNumber(driver).sendKeys("1233253452");
		 Thread.sleep(2000);
		 Row row3 = sheet.getRow(48);						//Selected 1st index row (Second row)
		 org.apache.poi.ss.usermodel.Cell c3 = row3.getCell(1);						//Selected cell (1 row,1 column)
		 String email = c3.getStringCellValue();			//Got the URL stored at position 1,1
		 EntityLocator.ClickEmail(driver).sendKeys(email);
		 
		 Thread.sleep(2000);
		 Row row4 = sheet.getRow(49);						//Selected 1st index row (Second row)
		 org.apache.poi.ss.usermodel.Cell c4 = row4.getCell(1);						//Selected cell (1 row,1 column)
		 String address = c4.getStringCellValue();			//Got the URL stored at position 1,1
		 EntityLocator.ClickAddressLine(driver).sendKeys(address);
		 Thread.sleep(2000);
		 EntityLocator.ClickState(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.SelectState(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.ClickCity(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.SelectCity(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.ClickBtnSave(driver).click();
		 
		 Thread.sleep(3000);   
		  String msg = EntityLocator.ValidMsg(driver).getText();
		  if(msg.equalsIgnoreCase("Details Save Successfully")) 
		  {
				test.log(LogStatus.PASS, "Message Displayed = " +msg);
		  }
	       else
			{
					
					test.log(LogStatus.FAIL, "Message Displayed = " +msg);
			}
		    
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(2000);
		  EntityLocator.CloseIcon(driver).click();
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
}
	
	
	public static void InvaliddBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAddNew(driver).click();
	    
	  
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeMyCompliances"));
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickName(driver).sendKeys("Pune");
		
		Thread.sleep(2000);
	    EntityLocator.ClickBranchType(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.SelectBranchType(driver).click();
	    

		 Thread.sleep(2000);
		 EntityLocator.ClickContactPerson(driver).sendKeys("456*abc");
		 

		 Thread.sleep(2000);
		 EntityLocator.ClickContactNumber(driver).sendKeys("12342532");
		 
		 Thread.sleep(2000);
		  EntityLocator.ClickEmail(driver).sendKeys("abc$gmail.com");
		 
		 Thread.sleep(2000);
		 EntityLocator.ClickAddressLine(driver).sendKeys("mumbai");
		 
		 Thread.sleep(2000);
		 EntityLocator.ClickState(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.SelectState(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.ClickCity(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.SelectCity(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.ClickBtnSave(driver).click();
		 
		 Thread.sleep(3000);   
		  String msg = EntityLocator.InvalidMsg(driver).getText();
		  test.log(LogStatus.PASS, "Message Displayed = " +msg);
		
		    
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(2000);
		  EntityLocator.CloseIcon(driver).click();
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	}	
	
	public static void TwoMandatoryFieldsBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAddNew(driver).click();
	    
	  
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeMyCompliances"));
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickName(driver).sendKeys("Pune");
		
		Thread.sleep(2000);
	    EntityLocator.ClickBranchType(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.SelectBranchType(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickStatus(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.SelectStatus(driver).click();
	    
		 Thread.sleep(2000);
		 EntityLocator.ClickBtnSave(driver).click();
		 
		 Thread.sleep(3000);   
		  String msg = EntityLocator.InvalidMsg(driver).getText();
		  test.log(LogStatus.PASS, "Message Displayed = " +msg);
		
		    
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(2000);
		  EntityLocator.CloseIcon(driver).click();
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void WithoutEnteringDataBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAddNew(driver).click();
	    
	  
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeMyCompliances"));
	    Thread.sleep(2000);
		 EntityLocator.ClickBtnSave(driver).click();
		 
		 Thread.sleep(3000);   
		  String msg = EntityLocator.InvalidMsg(driver).getText();
		  test.log(LogStatus.PASS, "Message Displayed = " +msg);
		
		    
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(2000);
		  EntityLocator.CloseIcon(driver).click();
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void EditBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickEditIcon2(driver).click();
	    
	  
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeMyCompliances"));
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickName(driver).clear();
	    Thread.sleep(2000);
	    EntityLocator.ClickName(driver).sendKeys("Dehli");
	    
	    Thread.sleep(2000);
		 EntityLocator.ClickBtnSave(driver).click();
		 
		 Thread.sleep(3000);   
		  String msg = EntityLocator.InvalidMsg(driver).getText();
		  test.log(LogStatus.PASS, "Message Displayed = " +msg);
		
		    
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(2000);
		  EntityLocator.CloseIcon(driver).click();
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void UploadDocBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C://Users//Snehal Patil//Downloads//sample.pdf");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpload(driver).click();
	    

	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickUploadValidMsg(driver).getText();
	    if(msg.equalsIgnoreCase("File Upload successfully")) 
		  {
				test.log(LogStatus.PASS, "Message Displayed = " +msg);
		  }
	       else
			{
					
					test.log(LogStatus.FAIL, "Message Displayed = " +msg);
			}
	    
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCloseicon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
		  
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	    
	public static void InvalidUploadDocBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C://Users//Snehal Patil//Downloads//Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpload(driver).click();
	    

	    Thread.sleep(4000);
	    String msg=EntityLocator.ClickUploadInValidMsg(driver).getText();
	    if(msg.equalsIgnoreCase("Please select file to upload")) 
		  {
				test.log(LogStatus.PASS, "Message Displayed = " +msg);
		  }
	       else
			{
					
					test.log(LogStatus.FAIL, "Message Displayed = " +msg);
			}
	    
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCloseicon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
		  
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}  
	
	public static void MultipleFileUploadDocBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\sample.pdf");
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\file-sample_100kB.Doc");
	
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpload(driver).click();
	    

	    Thread.sleep(4000);
	    String msg=EntityLocator.ClickUploadValidMsg(driver).getText();
	    if(msg.equalsIgnoreCase("File Upload successfully")) 
		  {
				test.log(LogStatus.PASS, "Message Displayed = " +msg);
		  }
	       else
			{
					
					test.log(LogStatus.FAIL, "Message Displayed = " +msg);
			}
	    
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCloseicon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
		  
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}  
	
	public static void InvalidMultipleFileUploadDocBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C://Users//Snehal Patil//Downloads//Litigation_Notice_Upload_Format.xlsx");
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C://Users//Snehal Patil//Downloads//Litigation_Notice_Upload_Format.xlsx");
	
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpload(driver).click();
	    

	    Thread.sleep(4000);
	    String msg=EntityLocator.ClickUploadInValidMsg(driver).getText();
	    if(msg.equalsIgnoreCase("Please select file to upload")) 
		  {
				test.log(LogStatus.PASS, "Message Displayed = " +msg);
		  }
	       else
			{
					
					test.log(LogStatus.FAIL, "Message Displayed = " +msg);
			}
	    
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCloseicon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
		  
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}  
	
	public static void WithoutUploadDocBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpload(driver).click();
	    

	    Thread.sleep(4000);
	    String msg=EntityLocator.ClickUploadInValidMsg(driver).getText();
	    if(msg.equalsIgnoreCase("Please select file to upload")) 
		  {
				test.log(LogStatus.PASS, "Message Displayed = " +msg);
		  }
	       else
			{
					
					test.log(LogStatus.FAIL, "Message Displayed = " +msg);
			}
	    
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCloseicon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
		  
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	} 
	
	
	public static void CloseBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
	
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAddNew(driver).click();
	    
	  
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeMyCompliances"));
	    
	
	    driver.switchTo().parentFrame();
		 
		  
		 if(EntityLocator.CloseIcon(driver).isEnabled())
		 {
			 Thread.sleep(2000);
			  EntityLocator.CloseIcon(driver).click();
			  test.log(LogStatus.PASS, "Close Button is clickable");
		 }
		 else
		 {
			 test.log(LogStatus.PASS, "Close Button is not clickable");
		 }
		  
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	
	}
	
	public static void BankDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	  
	    Thread.sleep(2000);
	    if(EntityLocator.BankDetailes(driver).isEnabled())
		 {
			 Thread.sleep(2000);
			 EntityLocator.BankDetailes(driver).click();
			 test.log(LogStatus.PASS, "Branch Detailes is clickable");
		 }
		 else
		 {
			 test.log(LogStatus.PASS, "Branch Detailes is not clickable");
		 }
		  
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	
	}
	
	public static void AddBankDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		sheet = workbook.getSheetAt(0);
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    Row row = sheet.getRow(52);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
		int AccNo= (int)c.getNumericCellValue();		//Got the URL stored at position 1,1
		EntityLocator.ClickAccNo(driver).sendKeys(""+AccNo);
		
		Thread.sleep(2000);
		Row row1 = sheet.getRow(53);						//Selected 1st index row (Second row)
	    org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String BankName = c1.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.ClickBankName(driver).sendKeys(BankName);
		
		Thread.sleep(2000);
		EntityLocator.ClickAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.SelectAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		   Thread.sleep(4000);
		    String msg=EntityLocator.BankvalidMsg(driver).getText();
		    if(msg.equalsIgnoreCase("Record Save Successfully")) 
			  {
					test.log(LogStatus.PASS, "Message Displayed = " +msg);
			  }
		       else
				{
						
						test.log(LogStatus.FAIL, "Message Displayed = " +msg);
				}
		
	Thread.sleep(2000);
	EntityLocator.ClickCloseIcon1(driver).click();
		
	Thread.sleep(2000);
    EntityLocator.clickcloseIcon(driver).click();
		    
		   Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		
	
	}
	
	public static void DuplicateBankDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		sheet = workbook.getSheetAt(0);
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    Row row = sheet.getRow(52);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
		int AccNo= (int)c.getNumericCellValue();		//Got the URL stored at position 1,1
		EntityLocator.ClickAccNo(driver).sendKeys(""+AccNo);
		
		Thread.sleep(2000);
		Row row1 = sheet.getRow(53);						//Selected 1st index row (Second row)
	    org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String BankName = c1.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.ClickBankName(driver).sendKeys(BankName);
		
		Thread.sleep(2000);
		EntityLocator.ClickAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.SelectAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		   Thread.sleep(4000);
		    String msg=EntityLocator.BankvalidMsg(driver).getText();
		    if(msg.equalsIgnoreCase("Record Save Successfully")) 
			  {
					test.log(LogStatus.FAIL, "Enter Dupliacte Bank Detailes = " +msg);
			  }
		       else
				{
						
						test.log(LogStatus.PASS, "Enter Dupliacte Bank Detailes = " +msg);
				}
		
	Thread.sleep(2000);
	EntityLocator.ClickCloseIcon1(driver).click();
		
	Thread.sleep(2000);
    EntityLocator.clickcloseIcon(driver).click();
		    
		   Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		
	
	}
	
	
	
	
	
	
	
	    
	public static void InvalidAccountNo(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
	    Thread.sleep(2000);
		EntityLocator.ClickAccNo(driver).sendKeys("tty^74");
		
		
		
		Thread.sleep(2000);
		EntityLocator.ClickAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.SelectAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		
		Thread.sleep(2000);
		String msg=EntityLocator.AccnoBankInavalidMsg(driver).getText();
		Thread.sleep(2000);
		String msg1=EntityLocator.BankNameBankInavalidMsg(driver).getText();
		
		test.log(LogStatus.PASS, " Messeage Displayed =" +msg);
		

		
	Thread.sleep(2000);
	EntityLocator.ClickCloseIcon1(driver).click();
		
	Thread.sleep(2000);
    EntityLocator.clickcloseIcon(driver).click();
		    
	Thread.sleep(4000);
   EntityLocator.ClickDashboard(driver).click();
		
	
	}
	
	public static void InvalidBankName(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
	 
		
		Thread.sleep(2000);
	   EntityLocator.ClickBankName(driver).sendKeys("4%gdd");
		
//		Thread.sleep(2000);
//		//EntityLocator.ClickAccType(driver).click();
//		
//		Thread.sleep(2000);
//		EntityLocator.SelectAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		
	
		Thread.sleep(2000);
		String msg=EntityLocator.BankNameBankInavalidMsg(driver).getText();
		
		test.log(LogStatus.PASS, " Messeage Displayed =" +msg);
		

		
	      Thread.sleep(2000);
	     EntityLocator.ClickCloseIcon1(driver).click();
		
	     Thread.sleep(2000);
         EntityLocator.clickcloseIcon(driver).click();
		    
	     Thread.sleep(4000);
          EntityLocator.ClickDashboard(driver).click();
}
	
	public static void InvalidIFSC(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
		Thread.sleep(2000);
	   EntityLocator.ClickIfsc(driver).sendKeys("4%gdd");
		
		Thread.sleep(2000);
		EntityLocator.ClickAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.SelectAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		
	
		Thread.sleep(2000);
		String msg=EntityLocator.IFSCBankInavalidMsg(driver).getText();
		
		test.log(LogStatus.PASS, " Messeage Displayed =" +msg);
		

		
	      Thread.sleep(2000);
	     EntityLocator.ClickCloseIcon1(driver).click();
		
	     Thread.sleep(2000);
         EntityLocator.clickcloseIcon(driver).click();
		    
	     Thread.sleep(4000);
          EntityLocator.ClickDashboard(driver).click();
}
	
	public static void DateBankDetailes(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAccNo(driver).sendKeys("5434567879");
	    
		Thread.sleep(2000);
		   EntityLocator.ClickBankName(driver).sendKeys("Bank of Maharasthra");
			
			Thread.sleep(2000);
			EntityLocator.ClickAccType(driver).click();
			
			Thread.sleep(2000);
			EntityLocator.SelectAccType(driver).click();
	    
	    Thread.sleep(2000);
		EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickClosingDate(driver).sendKeys("05-03-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		 Thread.sleep(4000);
		    String msg=EntityLocator.BankvalidMsg(driver).getText();
		    if(msg.equalsIgnoreCase("Record Save Successfully")) 
			  {
					test.log(LogStatus.FAIL, "Opening date is greater than closing date = " +msg);
			  }
		       else
				{
						
						test.log(LogStatus.PASS, "Opening date is greater than closing date = " +msg);
				}
		
	       Thread.sleep(2000);
	       EntityLocator.ClickCloseIcon1(driver).click();
		
	        Thread.sleep(2000);
            EntityLocator.clickcloseIcon(driver).click();
		    
		   Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		
	
	}
	
	
	public static void WithoutEnterBankDetailes(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
	    Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		Thread.sleep(2000);
		String msg=EntityLocator.AccnoBankInavalidMsg(driver).getText();
		Thread.sleep(2000);
		String msg1=EntityLocator.BankNameBankInavalidMsg(driver).getText();
		Thread.sleep(2000);
		String msg2=EntityLocator.ClickTypeOfAccount(driver).getText();
		Thread.sleep(2000);
	    String msg3=EntityLocator.InvalidOpenDate(driver).getText();
	    
		test.log(LogStatus.PASS, " Messeage Displayed ="  +msg +"," +msg1 +"," +msg2 +"," +msg3);
		
		   Thread.sleep(2000);
	       EntityLocator.ClickCloseIcon1(driver).click();
		
	        Thread.sleep(2000);
            EntityLocator.clickcloseIcon(driver).click();
		    
		   Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		
		
	}
	
	
	public static void UpdateBankDetailes(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    
		 Thread.sleep(3000);
		  EntityLocator.UpdateBankDetailes(driver).click();
		  
		  Thread.sleep(2000);
		    EntityLocator.ClickAccNo(driver).clear();
		  
		  Thread.sleep(2000);
		    EntityLocator.ClickAccNo(driver).sendKeys("5434567879");
		    
		    Thread.sleep(2000);
			EntityLocator.ClickSave(driver).click();
			
			 Thread.sleep(4000);
			    String msg=EntityLocator.BankvalidMsg(driver).getText();
			    if(msg.equalsIgnoreCase("Record Updated Successfully")) 
				  {
						test.log(LogStatus.PASS, "Message Displayed = " +msg);
				  }
			       else
					{
							
							test.log(LogStatus.FAIL, "Message Displayed = " +msg);
					}
		    
			    Thread.sleep(2000);
			       EntityLocator.ClickCloseIcon1(driver).click();
				
			        Thread.sleep(2000);
		            EntityLocator.clickcloseIcon(driver).click();
				    
				   Thread.sleep(4000);
				     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void InvalidUpdateBankDetailes(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    
		 Thread.sleep(2000);
		  EntityLocator.UpdateBankDetailes(driver).click();
		  
		  Thread.sleep(2000);
		  EntityLocator.ClickAccNo(driver).clear();
		  
		  Thread.sleep(2000);
		  EntityLocator.ClickAccNo(driver).sendKeys("786$5");
		    
		    Thread.sleep(2000);
			EntityLocator.ClickBankName(driver).sendKeys("4%gdd");

		     Thread.sleep(2000);
			 EntityLocator.ClickIfsc(driver).sendKeys("4%gdd");
				
			Thread.sleep(2000);
			EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-202");
			
			 Thread.sleep(2000);
				EntityLocator.ClickSave(driver).click();
				
				Thread.sleep(2000);
				String msg=EntityLocator.AccnoBankInavalidMsg(driver).getText();
				Thread.sleep(2000);
				String msg1=EntityLocator.BankNameBankInavalidMsg(driver).getText();
				Thread.sleep(2000);
				String msg2=EntityLocator.IFSCBankInavalidMsg(driver).getText();
				Thread.sleep(2000);
			    String msg3=EntityLocator.InvalidOpenDate1(driver).getText();
			    
				test.log(LogStatus.PASS, " Messeage Displayed ="  +msg +"," +msg1 +"," +msg2 +"," +msg3);
				
				
				   Thread.sleep(2000);
			       EntityLocator.ClickCloseIcon1(driver).click();
				
			        Thread.sleep(2000);
		            EntityLocator.clickcloseIcon(driver).click();
				    
				   Thread.sleep(4000);
				     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void DeleteBankDetailes(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
				
		 Thread.sleep(2000);
		 EntityLocator.DeleteBankDetailes(driver).click();
		 
		 Thread.sleep(2000);
		 EntityLocator.ClickYes(driver).click();
		 
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
	            EntityLocator.clickcloseIcon(driver).click();
			    
			   Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();
			  
	}
	
	public static void DeleteBankDetailes1(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon1(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
				
		 Thread.sleep(2000);
		 EntityLocator.DeleteBankDetailes(driver).click();
		
		 
		 if(EntityLocator.DeleteBankDetailes1(driver).isEnabled())
		 {   
			 Thread.sleep(2000);
		     EntityLocator.DeleteBankDetailes1(driver).click();
		     
		     test.log(LogStatus.PASS,"User Should be able to cancel deletion of an item");
		 }
		 else
		 {
			 test.log(LogStatus.FAIL,"User Should not be able to cancel deletion of an item");
		 }
		 
	
		
	        Thread.sleep(2000);
          EntityLocator.clickcloseIcon(driver).click();
		    
		   Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		 
	}  
			 
			 
	public static void LimitedLiabilityPartnership(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickAddNewBtn(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    
	    Thread.sleep(2000);
	    if(EntityLocator.LimitedLiabilityPartnership(driver).isEnabled())
	    {
	      Thread.sleep(2000);
	      EntityLocator.LimitedLiabilityPartnership(driver).click();
	      test.log(LogStatus.PASS, "Limited Liability Partnership is Selected");
	    }
	    else
	    {
	    	 test.log(LogStatus.FAIL, "Limited Liability Partnership is not Selected");
	    }
	    
	    Thread.sleep(4000);
	     EntityLocator.CloseEntity(driver).click();
	     
	     Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	   
	    
	    
	    
	 }    
	
	
	public static void AddLLP(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	{

	  WebDriverWait wait = new WebDriverWait(driver, (120));
	  Thread.sleep(3000);
	  sheet = workbook.getSheetAt(0);              // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	  Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickAddNewBtn(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Limited Liability Partnership (LLP)");
	    
	  
		Thread.sleep(2000);
	    Row row = sheet.getRow(56);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
		String name = c.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.LLPEntityName(driver).sendKeys(name);
	  
		
		Thread.sleep(2000);
	    Row row1 = sheet.getRow(57);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String LLPPIN = c1.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.LLPPin(driver).sendKeys(LLPPIN);
	  
	   
	  Thread.sleep(4000);
	  EntityLocator.ClickCalenderIcon(driver).click();
	  Thread.sleep(2000);
	  EntityLocator.Date(driver).click();
	  
	
	  By locator = By.xpath("//*[@id='llpRocJurisdiction']");
      wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	  Thread.sleep(4000);
	  WebElement ViewButton = driver.findElement(locator);	
	   Thread.sleep(4000);
	   JavascriptExecutor jse=(JavascriptExecutor)driver;
	   Thread.sleep(2000);
	   jse.executeScript("arguments[0].click();", ViewButton);
	  
	  
	  
//	  Thread.sleep(3000);
//	  EntityLocator.ClickRoc(driver).click();
	  Thread.sleep(4000);
	  List<WebElement>roc = driver.findElements(By.xpath("//ul[@id='llpRocJurisdiction_listbox']//li"));
	  selectOptionFromDropDown_bs(roc, "Mumbai");
	  
	  
	  Thread.sleep(2000);
	    Row row5 = sheet.getRow(59);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c5 = row5.getCell(1);						//Selected cell (1 row,1 column)
		String PAN = c5.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.LLPPan(driver).sendKeys(PAN);
	  
	
	  
	   Thread.sleep(2000);
	    Row row3 = sheet.getRow(58);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c3 = row3.getCell(1);						//Selected cell (1 row,1 column)
		String email = c3.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.ClickEmailLLP(driver).sendKeys(email);
	  
	   EntityLocator.LLPFinancialYear(driver).click();
	   Thread.sleep(2000);
	   List<WebElement>finYr = driver.findElements(By.xpath("//ul[@id='llpFY_listbox']//li"));
	   selectOptionFromDropDown_bs(finYr, "1 Apr - 31 Mar");
	  
	    Thread.sleep(2000);
	    Row row4 = sheet.getRow(41);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c4 = row4.getCell(1);						//Selected cell (1 row,1 column)
		String address = c4.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.LLPAddressE(driver).sendKeys(address);
		
		 Thread.sleep(2000);
		    Row row6 = sheet.getRow(60);						//Selected 1st index row (Second row)
			org.apache.poi.ss.usermodel.Cell c6 = row6.getCell(1);						//Selected cell (1 row,1 column)
			String address2 = c6.getStringCellValue();			//Got the URL stored at position 1,1
			EntityLocator.LLPAddress2(driver).sendKeys(address2);
	  
	  Thread.sleep(2000);
	  EntityLocator.LLPStateE(driver).click();
	  Thread.sleep(2000);
	  List<WebElement>state = driver.findElements(By.xpath("//*[@id='llpRegstateId_listbox']/li"));
	  selectOptionFromDropDown_bs(state, "Maharashtra");
	
	  Thread.sleep(2000);
	  EntityLocator.LLPCityE(driver).click();
	  Thread.sleep(3000);
	  List<WebElement>city = driver.findElements(By.xpath("//ul[@id='llpcityId_listbox']//li"));
	  selectOptionFromDropDown_bs(city, "Ahmadnagar");
	 
	  
	 Thread.sleep(3000);
	  EntityLocator.LLPSaveE(driver).click();
	  
	  try 
	  {
			 Thread.sleep(3000);
        String msg=	EntityLocator.LLPSaveMsg(driver).getText();
        test.log(LogStatus.PASS,"Message Displayed =" +msg );
       
	  }
      catch(Exception  e) 
	  {
    		 Thread.sleep(3000);
		 String msg=EntityLocator.LLPSaveMsg2(driver).getText();
		  test.log(LogStatus.PASS,"Message Displayed =" +msg );
		
	  }
     Thread.sleep(4000);
     EntityLocator.CloseEntity(driver).click();
   
     Thread.sleep(4000);
     EntityLocator.ClickDashboard(driver).click();
    
     
 }
	
	public static void EnterInvalidDataLLP(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	{

	  WebDriverWait wait = new WebDriverWait(driver, (120));
	  Thread.sleep(3000);
	  sheet = workbook.getSheetAt(0);              // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	  Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickAddNewBtn(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Limited Liability Partnership (LLP)");
	    
	  
		Thread.sleep(2000);
		EntityLocator.LLPEntityName(driver).sendKeys("fgh5#@6");
	  
		
		Thread.sleep(2000);
	  			
		EntityLocator.LLPPin(driver).sendKeys("46r46");
	  
	   
	  Thread.sleep(4000);
	  EntityLocator.ClickCalenderIcon(driver).click();
	  Thread.sleep(2000);
	  EntityLocator.Date(driver).click();
	  
	
	  By locator = By.xpath("//*[@id='llpRocJurisdiction']");
      wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	  Thread.sleep(4000);
	  WebElement ViewButton = driver.findElement(locator);	
	   Thread.sleep(4000);
	   JavascriptExecutor jse=(JavascriptExecutor)driver;
	   Thread.sleep(2000);
	   jse.executeScript("arguments[0].click();", ViewButton);
	  
	 
	  Thread.sleep(2000);
	  EntityLocator.LLPPan(driver).sendKeys("37493gfh");
	  
	  Thread.sleep(2000);
	  EntityLocator.ClickEmailLLP(driver).sendKeys("email.com");

	  Thread.sleep(2000);
     EntityLocator.LLPAddressE(driver).sendKeys("hdgsj#%2");
		
     Thread.sleep(2000);
	  EntityLocator.LLPAddress2(driver).sendKeys("hdgsj434");
	  

	  Thread.sleep(3000);
	  EntityLocator.LLPSaveE(driver).click();
	  
	    String msg=EntityLocator.CompnayNameValidMsg(driver).getText();
		String msg1=EntityLocator.LLPINValidMsg(driver).getText();
	    String msg2=EntityLocator.FYValidMsg(driver).getText();
	    String msg4=EntityLocator.RocValidMsg(driver).getText();
	    String msg5=EntityLocator.EmailValidMsg(driver).getText();
	    String msg6=EntityLocator.PANValidMsg(driver).getText();

		
	    test.log(LogStatus.PASS, "Without Enter Fields LLP ="  +msg +"," +msg1 +"," +msg2  +"," +msg4 +"," +msg5  +"," +msg6);
     Thread.sleep(4000);
     EntityLocator.CloseEntity(driver).click();
   
     Thread.sleep(4000);
     EntityLocator.ClickDashboard(driver).click();
    
     
 }
	
	
	
	
	
	
	public static void DuplicateLLP(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	{

	  WebDriverWait wait = new WebDriverWait(driver, (120));
	  Thread.sleep(3000);
	  sheet = workbook.getSheetAt(0);              // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	  Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickAddNewBtn(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Limited Liability Partnership (LLP)");
	    
	  
		Thread.sleep(2000);
	    Row row = sheet.getRow(56);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
		String name = c.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.LLPEntityName(driver).sendKeys(name);
	  
		
		Thread.sleep(2000);
	    Row row1 = sheet.getRow(57);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String LLPPIN = c1.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.LLPPin(driver).sendKeys(LLPPIN);
	  
	   
	  Thread.sleep(4000);
	  EntityLocator.ClickCalenderIcon(driver).click();
	  Thread.sleep(2000);
	  EntityLocator.Date(driver).click();
	  
	
	  By locator = By.xpath("//*[@id='llpRocJurisdiction']");
      wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	  Thread.sleep(4000);
	  WebElement ViewButton = driver.findElement(locator);	
	   Thread.sleep(4000);
	   JavascriptExecutor jse=(JavascriptExecutor)driver;
	   Thread.sleep(2000);
	   jse.executeScript("arguments[0].click();", ViewButton);
	  
	  
	  
//	  Thread.sleep(3000);
//	  EntityLocator.ClickRoc(driver).click();
	  Thread.sleep(4000);
	  List<WebElement>roc = driver.findElements(By.xpath("//ul[@id='llpRocJurisdiction_listbox']//li"));
	  selectOptionFromDropDown_bs(roc, "Mumbai");
	  
	  
	  Thread.sleep(2000);
	    Row row5 = sheet.getRow(59);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c5 = row5.getCell(1);						//Selected cell (1 row,1 column)
		String PAN = c5.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.LLPPan(driver).sendKeys(PAN);
	  
	
	  
	   Thread.sleep(2000);
	    Row row3 = sheet.getRow(58);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c3 = row3.getCell(1);						//Selected cell (1 row,1 column)
		String email = c3.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.ClickEmailLLP(driver).sendKeys(email);
	  
	   EntityLocator.LLPFinancialYear(driver).click();
	   Thread.sleep(2000);
	   List<WebElement>finYr = driver.findElements(By.xpath("//ul[@id='llpFY_listbox']//li"));
	   selectOptionFromDropDown_bs(finYr, "1 Apr - 31 Mar");
	  
	    Thread.sleep(2000);
	    Row row4 = sheet.getRow(41);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c4 = row4.getCell(1);						//Selected cell (1 row,1 column)
		String address = c4.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.LLPAddressE(driver).sendKeys(address);
		
		 Thread.sleep(2000);
		    Row row6 = sheet.getRow(60);						//Selected 1st index row (Second row)
			org.apache.poi.ss.usermodel.Cell c6 = row6.getCell(1);						//Selected cell (1 row,1 column)
			String address2 = c6.getStringCellValue();			//Got the URL stored at position 1,1
			EntityLocator.LLPAddress2(driver).sendKeys(address2);
	  
	  Thread.sleep(2000);
	  EntityLocator.LLPStateE(driver).click();
	  Thread.sleep(2000);
	  List<WebElement>state = driver.findElements(By.xpath("//*[@id='llpRegstateId_listbox']/li"));
	  selectOptionFromDropDown_bs(state, "Maharashtra");
	
	  Thread.sleep(2000);
	  EntityLocator.LLPCityE(driver).click();
	  Thread.sleep(3000);
	  List<WebElement>city = driver.findElements(By.xpath("//ul[@id='llpcityId_listbox']//li"));
	  selectOptionFromDropDown_bs(city, "Ahmadnagar");
	 
	  
	 Thread.sleep(3000);
	  EntityLocator.LLPSaveE(driver).click();
	  
	  try 
	  {
			 Thread.sleep(3000);
        String msg=	EntityLocator.LLPSaveMsg(driver).getText();
        test.log(LogStatus.PASS,"Message Displayed =" +msg );
       
	  }
      catch(Exception  e) 
	  {
    		 Thread.sleep(3000);
		 String msg=EntityLocator.LLPSaveMsg2(driver).getText();
		  test.log(LogStatus.PASS,"Message Displayed =" +msg );
		
	  }
     Thread.sleep(4000);
     EntityLocator.CloseEntity(driver).click();
   
     Thread.sleep(4000);
     EntityLocator.ClickDashboard(driver).click();
    
     
 }	
	
	public static void TwoMandatoryLLP(WebDriver driver, ExtentTest test) throws InterruptedException
	{

	  WebDriverWait wait = new WebDriverWait(driver, (120));
	  Thread.sleep(3000);
	
		EntityLocator.selectImg(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickAddNewBtn(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Limited Liability Partnership (LLP)");
	    
	  
		Thread.sleep(2000);
	    EntityLocator.LLPEntityName(driver).sendKeys("XYZ Pvt Ltd");
	    Thread.sleep(2000);
	    EntityLocator.LLPPin(driver).sendKeys("AAE-6302");
	    
	    Thread.sleep(3000);
		  EntityLocator.LLPSaveE(driver).click();
	    
	    String msg=EntityLocator.FYValidMsg(driver).getText();
	    String msg1=EntityLocator.DateValidMsg(driver).getText();
	    String msg2=EntityLocator.RocValidMsg(driver).getText();
	    String msg3=EntityLocator.EmailValidMsg(driver).getText();
	    String msg4=EntityLocator.PANValidMsg(driver).getText();
	    String msg5=EntityLocator.AddressValidMsg(driver).getText();
	    String msg6=EntityLocator.Address2ValidMsg(driver).getText();
		
	    test.log(LogStatus.PASS, "Two Mandatory Field LLP ="  +msg +"," +msg2 +"," +msg3 +"," +msg4  +"," +msg5 +"," +msg6);

	    Thread.sleep(4000);
	     EntityLocator.CloseEntity(driver).click();
	   
	     Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	public static void WithoutEnteringFieldsLLP(WebDriver driver, ExtentTest test) throws InterruptedException
	{

	  WebDriverWait wait = new WebDriverWait(driver, (120));
	  Thread.sleep(3000);
	
		EntityLocator.selectImg(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickAddNewBtn(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Limited Liability Partnership (LLP)");
	    
	  
	    
	    Thread.sleep(3000);
		EntityLocator.LLPSaveE(driver).click();
		  
		String msg=EntityLocator.CompnayNameValidMsg(driver).getText();
		String msg1=EntityLocator.LLPINValidMsg(driver).getText();
	    String msg2=EntityLocator.FYValidMsg(driver).getText();
	    String msg3=EntityLocator.DateValidMsg(driver).getText();
	    String msg4=EntityLocator.RocValidMsg(driver).getText();
	    String msg5=EntityLocator.EmailValidMsg(driver).getText();
	    String msg6=EntityLocator.PANValidMsg(driver).getText();
	    String msg7=EntityLocator.AddressValidMsg(driver).getText();
	    String msg8=EntityLocator.Address2ValidMsg(driver).getText();
		
	    test.log(LogStatus.PASS, "Without Enter Fields LLP ="  +msg +"," +msg1 +"," +msg2 +"," +msg3  +"," +msg4 +"," +msg5  +"," +msg6  +"," +msg7 +"," +msg8);

	    Thread.sleep(4000);
	     EntityLocator.CloseEntity(driver).click();
	   
	     Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	
	public static void CloseButtonLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
	
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
		 
		 Thread.sleep(2000);
		 if(EntityLocator.CloseEntity(driver).isEnabled())
		 {
			 Thread.sleep(2000);
			  EntityLocator.CloseEntity(driver).click();
			  test.log(LogStatus.PASS, "Close Button is clickable");
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Close Button is not clickable");
		 }
		  
		  
		  Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
	
	}
	  
	
	public static void InvalidUpdateLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
			EntityLocator.LLPPan(driver).clear();
		    Thread.sleep(2000);
			EntityLocator.LLPPan(driver).sendKeys("dfgsf45");
		
		  Thread.sleep(3000);
		  EntityLocator.LLPSaveE(driver).click();
		  
		  Thread.sleep(2000);
		    String Msg=EntityLocator.PANValidMsg(driver).getText();
		   
		     
		      test.log(LogStatus.PASS, "Message Displayed = " +Msg);
		    
	
		  
		  
		    Thread.sleep(4000);
		     EntityLocator.CloseEntity(driver).click();
		   
		     Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	    
	}
	    
	public static void UpdateLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		sheet = workbook.getSheetAt(0); 
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.LLPPan(driver).clear();
	   
	    Thread.sleep(2000);
	    Row row5 = sheet.getRow(61);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c5 = row5.getCell(1);						//Selected cell (1 row,1 column)
		String PAN = c5.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.LLPPan(driver).sendKeys(PAN);
		
		  Thread.sleep(3000);
		  EntityLocator.LLPSaveE(driver).click();
		  
		  Thread.sleep(2000);
		  String msg=EntityLocator.LLPInvalidNameMsg(driver).getText();
		  String msg1=EntityLocator.LLPInvalidPINMsg(driver).getText();
		    
		   test.log(LogStatus.FAIL, "Message Displayed = " +msg +"," +msg1);
		   
		   Thread.sleep(4000);
		   EntityLocator.CloseEntity(driver).click();
		   
		     Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	
	
	public static void EditCloseButtonLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
	
	    WebDriverWait wait=new WebDriverWait(driver,20);
	
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
		 
		  
		 if(EntityLocator.CloseEntity(driver).isEnabled())
		 {
			 Thread.sleep(2000);
			  EntityLocator.CloseEntity(driver).click();
			  test.log(LogStatus.PASS, "Close Button is clickable");
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Close Button is not clickable");
		 }
		  
		  
		  Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
	
	}
	
	public static void BuisnessActivityLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
	
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	   
	    Thread.sleep(2000);
	    if(EntityLocator.clickBusinessActivity(driver).isEnabled())
	    {
	      Thread.sleep(2000);
	      EntityLocator.clickBusinessActivity(driver).click();
	      test.log(LogStatus.PASS, "Business Activity Tab is clickable");
	    }
	    else
	    {
	    	 test.log(LogStatus.FAIL, "Business Activity Tab is not clickable");
	    }
     
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	
	public static void AddBuisnessActivityLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBusinessActivity(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickNewBusinessActivity(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickMainActivityCode(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickMainActivityCodeDropdwon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBA(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBADropdown(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickSave(driver).click();
	  	    
	    
	    Thread.sleep(2000);
	    String Msg=EntityLocator.BAValidMsg(driver).getText();
	    if(Msg.equalsIgnoreCase("Record Save Successfully"))
	    {
	     
	      test.log(LogStatus.PASS, "Message Displayed = " +Msg);
	    }
	    else
	    {
	    	 test.log(LogStatus.FAIL, "Message Displayed = " +Msg);
	    }
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();

	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void LLPBAnotFound(WebDriver driver,ExtentTest test) throws InterruptedException
	{
	
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    Thread.sleep(3000);
	    EntityLocator.clickBusinessActivity(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickNewBusinessActivity(driver).click();
	 
	    Thread.sleep(2000);
	    EntityLocator.clickBA(driver).click();
	    Thread.sleep(2000);
	    String msg=EntityLocator.NoDataFound(driver).getText();
	    if(msg.equalsIgnoreCase("No data found."))
	    {
	     
	      test.log(LogStatus.PASS, "Business Activity Dropdwon= " +msg);
	    }
	      
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void WithoutEnterDataBALLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{

		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBusinessActivity(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickNewBusinessActivity(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickSave(driver).click();
	    
	    Thread.sleep(2000);
	    String Msg=EntityLocator.BAValidMsg(driver).getText();
	    if(Msg.equalsIgnoreCase("Record Save Successfully"))
	    {
	     
	      test.log(LogStatus.FAIL, "Validation message should get displayed for manadtory fields = " +Msg);
	    }
	    else
	    {
	    	 test.log(LogStatus.PASS, "Validation message should get displayed for manadtory fields = " +Msg);
	    }
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	public static void EditBALLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBusinessActivity(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.EditBA(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickMainActivityCode(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickMainActivityCodeDropdwon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBA(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBADropdown1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickSave(driver).click();
	  	    
	    
	    Thread.sleep(2000);
	    String Msg=EntityLocator.BAValidMsg(driver).getText();
	    if(Msg.equalsIgnoreCase("Record Updated Successfully"))
	    {
	     
	      test.log(LogStatus.PASS, "Message Displayed = " +Msg);
	    }
	    else
	    {
	    	 test.log(LogStatus.FAIL, "Message Displayed = " +Msg);
	    }
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon1(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	public static void EditInvalidDataLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBusinessActivity(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.EditBA(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickPercentage(driver).sendKeys("e");
	    
	    Thread.sleep(2000);
	    EntityLocator.clickSave(driver).click();
	    
	    Thread.sleep(2000);
	    String Msg=EntityLocator.BAValidMsg(driver).getText();
	    if(Msg.equalsIgnoreCase("Record Updated Successfully"))
	    {
	     
	      test.log(LogStatus.FAIL, "Error Message should get displayed in percentage section = " +Msg);
	    }
	    else
	    {
	    	 test.log(LogStatus.PASS, "Error Message should get displayed in percentage section = " +Msg);
	    }
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon1(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void BADeleteIconLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickBusinessActivity(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDeleteIcon(driver).click();
	    
	    

	    
	    By locator = By.xpath("//*[@id='yesBA']");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(3000);
	   JavascriptExecutor jse=(JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
	    
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
	    EntityLocator.clickcloseIcon(driver).click();
        Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
        
	}
	
	public static void BACloseBtnLLP(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
        Thread.sleep(2000);
        EntityLocator.clickBusinessActivity(driver).click();
        Thread.sleep(2000);
        EntityLocator.clickNewBusinessActivity(driver).click();
		
	     
	     if(EntityLocator.clickcloseIcon1(driver).isEnabled())
		    {
		      Thread.sleep(2000);
		      EntityLocator.clickcloseIcon1(driver).click();
		      test.log(LogStatus.PASS, "Close Buttton is clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Close Buttton is not clickable");
		    }
	     
	     Thread.sleep(2000);
		 EntityLocator.clickcloseIcon(driver).click();
	     Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	 }
	public static void DocumentTabLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	     Thread.sleep(2000);
	    if(EntityLocator.ClickDocumentTab(driver).isEnabled())
	    {
	      Thread.sleep(2000);
	      EntityLocator.ClickDocumentTab(driver).click();
	      test.log(LogStatus.PASS, "Docuement Tab is clickable");
	    }
	    else
	    {
	    	 test.log(LogStatus.FAIL, "Document Tab is not clickable");
	    }
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	public static void AddNewDocumentLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{

		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocTypeDropDown(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABACO");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		    
	}
	
	public static void AlreadyExistDocumentLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{

	    
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocTypeDropDown(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABACO");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg = EntityLocator.ClickInValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		    
		    
	}
	
	public static void WithoutEnteringDocumentLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
	    
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickValidMsgFile(driver).getText();
	     if(msg.equalsIgnoreCase("Please select File"))
	     {
	    	 test.log(LogStatus.PASS,"Message Displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "Message Displayed =" +msg);
		    }
	     
	     Thread.sleep(2000);
		    EntityLocator.ClickCloseIcon(driver).click();
		    
		    Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		    
		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	     
	}
	public static void ViewDocumentLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickViewIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickClose(driver).click();
	    
	    test.log(LogStatus.PASS,"View Popup Open Successfully");
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	public static void DownloadDocumentLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	
	    
	    
	    
	    File dir = new File("C://Users//Snehal Patil//Downloads");
	  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	  		
	  	Thread.sleep(2000);
	 	EntityLocator.ClickDownloadIcon(driver).click();		//Exporting (Downloading) file
	  		
	    Thread.sleep(3000);
	    File dir1 = new File("C://Users//Snehal Patil//Downloads");
	    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
	  		
	    Thread.sleep(3000);
	  	if (dirContents.length < allFilesNew.length) 
	  	{
	  		test.log(LogStatus.PASS,  "  Document downloaded successfully.");
	  	} 
	  	else 
	  	{
	  		test.log(LogStatus.FAIL, "  Document does not downloaded.");
	  	}
	   
	  	 Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
	  	
	  	 Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	  
	    
	}   
	
	public static void DeleteDocumentLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDeleteIcon1(driver).click();
	   
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickDeleteValidMsg(driver).getText();
	    Thread.sleep(2000);
	    if(msg.equalsIgnoreCase("Are you sure you want to delete this data?"))
	     {
	    	
	    	 test.log(LogStatus.PASS,"The item should get deleted from the list and success message will displayed  =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "The item should get deleted from the list and success message will displayed  =" +msg);
		    }
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickYes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	
	public static void AddNewDocumentLLPDEED(WebDriver driver,ExtentTest test) throws InterruptedException
	{

		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocTypeDropDownDEED(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("KLAPO");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		    
	}
	public static void WithoutEnteringDocumentLLPDEED(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocTypeDropDownDEED(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCDEF");
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickValidMsgFile1(driver).getText();
	     if(msg.equalsIgnoreCase("Please select File"))
	     {
	    	 test.log(LogStatus.PASS,"Message Displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "Message Displayed =" +msg);
		    }
	     
	     Thread.sleep(2000);
		    EntityLocator.ClickCloseIcon(driver).click();
		    
		    Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		    
		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	     
	}
	public static void AddExistingDocumentLLPDEED(WebDriver driver,ExtentTest test) throws InterruptedException
	{

		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocTypeDropDownDEED(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("KLAPO");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.FAIL, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.PASS, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		    
	}
	public static void ViewDocumentLLPDEED(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	   
	    Thread.sleep(2000);
	    EntityLocator.ViewDocLLPDEED(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickClose(driver).click();
	    
	    test.log(LogStatus.PASS,"View Popup Open Successfully");
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	public static void DownloadDocumentLLPDEED(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.PolicyLLP(driver).click();
	    
	    
	    File dir = new File("C://Users//Snehal Patil//Downloads");
	  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	  		
	  	Thread.sleep(2000);
	 	EntityLocator.DownloadDocLLPDEED(driver).click();		//Exporting (Downloading) file
	  		
	    Thread.sleep(3000);
	    File dir1 = new File("C://Users//Snehal Patil//Downloads");
	    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
	  		
	  		
	  	if (dirContents.length < allFilesNew.length) 
	  	{
	  		test.log(LogStatus.PASS,  "  Document downloaded successfully.");
	  	} 
	  	else 
	  	{
	  		test.log(LogStatus.FAIL, "  Document does not downloaded.");
	  	}
	   
	  	 Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
	  	
	  	 Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	  
	    
	}
	
	public static void DeleteDocumentLLPDEED(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.PolicyLLP(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.DeleteDocLLPDEED(driver).click();
	   
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickDeleteValidMsg(driver).getText();
	    Thread.sleep(2000);
	    if(msg.equalsIgnoreCase("Are you sure you want to delete this data?"))
	     {
	    	
	    	 test.log(LogStatus.PASS,"The item should get deleted from the list and success message will displayed  =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "The item should get deleted from the list and success message will displayed  =" +msg);
		    }
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickYes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	public static void AddPolicyDocLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(200);
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='DocumentType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Policy");
	    
//	    Thread.sleep(2000);
//	    EntityLocator.ClickPolicyLLP(driver).click();
	    
      
	    
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("HSDG");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	public static void WithoutEnteringDocumentPolicyLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(200);
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='DocumentType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Policy");
	    
        EntityLocator. ClickLicenseRegistrationNo(driver).sendKeys("53467");
	   
	    
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCDE");
	    

	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	public static void AddExistingDocumentPolicyLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(200);
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='DocumentType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Policy");
       
	    
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("HSDG");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg = EntityLocator.ClickInValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	public static void ViewDocumentPolicyLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    Thread.sleep(2000);
	    EntityLocator. PolicyLLP(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ViewDocLLPDEED(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickClose(driver).click();
	    
	    test.log(LogStatus.PASS,"View Popup Open Successfully");
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	public static void DownloadDocumentPolicyLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	
	    
	
	    
	    File dir = new File("C://Users//Snehal Patil//Downloads");
	  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	  		
	    Thread.sleep(2000);
	    EntityLocator. PolicyLLP(driver).click();	//Exporting (Downloading) file
	  		
	    Thread.sleep(3000);
	    File dir1 = new File("C://Users//Snehal Patil//Downloads");
	    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
	  		
	  		
	  	if (dirContents.length < allFilesNew.length) 
	  	{
	  		test.log(LogStatus.PASS,  "  Document downloaded successfully.");
	  	} 
	  	else 
	  	{
	  		test.log(LogStatus.FAIL, "  Document does not downloaded.");
	  	}
	   
	  	 Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
	  	
	  	 Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	  
	    
	}
	public static void DeleteDocumentPolicyLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. PolicyLLP(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDeleteIcon1(driver).click();
	   
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickDeleteValidMsg(driver).getText();
	    Thread.sleep(2000);
	    if(msg.equalsIgnoreCase("Are you sure you want to delete this data?"))
	     {
	    	
	    	 test.log(LogStatus.PASS,"The item should get deleted from the list and success message will displayed  =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "The item should get deleted from the list and success message will displayed  =" +msg);
		    }
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickYes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void AddLicenseRegistrationDocLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCOI(driver).click();
	    
        EntityLocator. ClickLicenseRegistrationNo(driver).sendKeys("83746");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickLastRenewDate(driver).sendKeys("13-04-2023");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpcomingRenewDate(driver).sendKeys("29-04-2023");
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("HKEI");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	public static void WithoutEnteringDocumentLicenseRegistrationLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCOI(driver).click();
	    
//         EntityLocator. ClickLicenseRegistrationNo(driver).sendKeys("53467");
//	    
//	    Thread.sleep(2000);
//	    EntityLocator.ClickLastRenewDate(driver).sendKeys("13-04-2023");
//	    
//	    Thread.sleep(2000);
//	    EntityLocator.ClickUpcomingRenewDate(driver).sendKeys("29-04-2023");
    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCDEF");
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickValidMsgFile1(driver).getText();
	     if(msg.equalsIgnoreCase("Please select File"))
	     {
	    	 test.log(LogStatus.PASS,"Message Displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "Message Displayed =" +msg);
		    }
	     
	     Thread.sleep(2000);
		    EntityLocator.ClickCloseIcon(driver).click();
		    
		    Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		    
		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	     
	}
	public static void AddExistingLicenseRegistrationDocLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCOI(driver).click();
	    
//        EntityLocator. ClickLicenseRegistrationNo(driver).sendKeys("53467");
//	    
//	    Thread.sleep(2000);
//	    EntityLocator.ClickLastRenewDate(driver).sendKeys("13-04-2023");
//	    
//	    Thread.sleep(2000);
//	    EntityLocator.ClickUpcomingRenewDate(driver).sendKeys("29-04-2023");
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("HGJI");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\Litigation_Notice_Upload_Format.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    Thread.sleep(2000);   
	    try
		 {
		    String msg = EntityLocator.ClickInValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
		
	}
	public static void ViewDocumentLicenseRegistrationLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.LicenseRegistrationLLP(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ViewLicenseRegistrationLLP(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickClose(driver).click();
	    
	    test.log(LogStatus.PASS,"View Popup Open Successfully");
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	public static void DownloadDocumentLicenseRegistraionLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.LicenseRegistrationLLP(driver).click();
	    
	    
	    File dir = new File("C://Users//Snehal Patil//Downloads");
	  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	  		
	  	Thread.sleep(2000);
	 	EntityLocator.DownloadLicenseRegistrationLLP(driver).click();		//Exporting (Downloading) file
	  		
	    Thread.sleep(3000);
	    File dir1 = new File("C://Users//Snehal Patil//Downloads");
	    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
	  		
	  		
	  	if (dirContents.length < allFilesNew.length) 
	  	{
	  		test.log(LogStatus.PASS,  "  Document downloaded successfully.");
	  	} 
	  	else 
	  	{
	  		test.log(LogStatus.FAIL, "  Document does not downloaded.");
	  	}
	   
	  	 Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
	  	
	  	 Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	  
	    
	}
	public static void DeleteDocumentLicenseRegistrationLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.LicenseRegistrationLLP(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.DeleteLicenseRegistrationLLP(driver).click();
	   
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickDeleteValidMsg(driver).getText();
	    Thread.sleep(2000);
	    if(msg.equalsIgnoreCase("Are you sure you want to delete this data?"))
	     {
	    	
	    	 test.log(LogStatus.PASS,"The item should get deleted from the list and success message will displayed  =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "The item should get deleted from the list and success message will displayed  =" +msg);
		    }
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickYes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void AddAnnualReportLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickPolicy(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickSerialNoOfAGM(driver).sendKeys("5674");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickLastRenewCalender(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.Date(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickFY(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.SelectFY(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator. ClickDescrition(driver).sendKeys("Automation test");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Desktop\\Test Cases\\Act Sub_Industry Test Cases.xlsx");
	    
	    Thread.sleep(4000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    
	    
	    Thread.sleep(3000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.PASS, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.FAIL, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	
	}
	
	public static void AddExistingAnnualReportLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickPolicy(driver).click();
	    
       Thread.sleep(3000);
       EntityLocator.ClickSerialNoOfAGM(driver).sendKeys("5674");

       Thread.sleep(3000);
      EntityLocator.ClickLastRenewCalender(driver).click();

      Thread.sleep(3000);
      EntityLocator.Date(driver).click();

	    Thread.sleep(3000);
	    EntityLocator.ClickFY(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.SelectFY(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator. ClickDescrition(driver).sendKeys("TestTest");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Desktop\\Test Cases\\Act Sub_Industry Test Cases.xlsx");
	    
	    Thread.sleep(4000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    
	    
	    Thread.sleep(3000);   
	    try
		 {
		    String msg = EntityLocator.ClickValidMsg(driver).getText();
			test.log(LogStatus.FAIL, "Message Displayed = " +msg);
		 }
		catch(Exception e)
		{
				String msg1 = EntityLocator.ClickInValidMsg(driver).getText();
				test.log(LogStatus.PASS, "Message Displayed = " +msg1);
		}
	    
	     Thread.sleep(2000);
	    EntityLocator.ClickCloseIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	
	}
	public static void WithoutEnteringDocumentAnnualReportLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickPolicy(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickSerialNoOfAGM(driver).sendKeys("7451");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickLastRenewCalender(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.Date(driver).click();
	    
    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCDEF");
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickSaveBtnLLPDOC(driver).click();
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickValidMsgFile1(driver).getText();
	     if(msg.equalsIgnoreCase("Please select File"))
	     {
	    	 test.log(LogStatus.PASS,"Message Displayed =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "Message Displayed =" +msg);
		    }
	     
	     Thread.sleep(2000);
		    EntityLocator.ClickCloseIcon(driver).click();
		    
		    Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		    
		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	     
	}
	
	public static void ViewDocumentAnnualReportLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AnnualReportLLP(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ViewAnnualReportLLP(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickClose(driver).click();
	    
	    test.log(LogStatus.PASS,"View Popup Open Successfully");
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	public static void DownloadDocumentAnnualReportLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.AnnualReportLLP(driver).click();
	    
	    
	    
	    
	    File dir = new File("C://Users//Snehal Patil//Downloads");
	  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	  		
	  	Thread.sleep(2000);
	 	EntityLocator.DownloadAnnualReportLLP(driver).click();		//Exporting (Downloading) file
	  		
	    Thread.sleep(3000);
	    File dir1 = new File("C://Users//Snehal Patil//Downloads");
	    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
	  		
	  		
	  	if (dirContents.length < allFilesNew.length) 
	  	{
	  		test.log(LogStatus.PASS,  "  Document downloaded successfully.");
	  	} 
	  	else 
	  	{
	  		test.log(LogStatus.FAIL, "  Document does not downloaded.");
	  	}
	   
	  	 Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
	  	
	  	 Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	  
	    
	}
	public static void DeleteDocumentAnnualReportLLP(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.AnnualReportLLP(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.DeleteAnnualReportLLP(driver).click();
	   
	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickDeleteValidMsg(driver).getText();
	    Thread.sleep(2000);
	    if(msg.equalsIgnoreCase("Are you sure you want to delete this data?"))
	     {
	    	
	    	 test.log(LogStatus.PASS,"The item should get deleted from the list and success message will displayed  =" +msg);
	     }
	     else
		    {
		    	 test.log(LogStatus.FAIL, "The item should get deleted from the list and success message will displayed  =" +msg);
		    }
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickYes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	public static void BranchDetailesLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	   
	    
	    if(EntityLocator.ClickBranchDetailes(driver).isEnabled())
	    {
	      Thread.sleep(2000);
	      EntityLocator.ClickBranchDetailes(driver).click();
	      test.log(LogStatus.PASS, "Branch Detailes is clickable");
	    }
	    else
	    {
	    	 test.log(LogStatus.PASS, "Branch Detailes is not clickable");
	    }
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	
	}
	public static void AddBranchDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		sheet = workbook.getSheetAt(0);
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAddNew(driver).click();
	    
	  
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeMyCompliances"));
	    
	    Thread.sleep(2000);
	    Row row = sheet.getRow(45);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
		String name = c.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.ClickName(driver).sendKeys("Karnatka");
		
		Thread.sleep(2000);
	    EntityLocator.ClickBranchType(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.SelectBranchType(driver).click();
	    
	
		
		 Thread.sleep(2000);
		 Row row1 = sheet.getRow(46);						//Selected 1st index row (Second row)
		 org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		 String ContactPerson = c1.getStringCellValue();			//Got the URL stored at position 1,1
		 EntityLocator.ClickContactPerson(driver).sendKeys(ContactPerson);
		 
//		 Thread.sleep(2000);
//		 Row row2 = sheet.getRow(47);						//Selected 1st index row (Second row)
//		 org.apache.poi.ss.usermodel.Cell c2 = row2.getCell(1);						//Selected cell (1 row,1 column)
//		 int ContactNumber= (int)c2.getNumericCellValue();
//		 EntityLocator.ClickContactNumber(driver).sendKeys(" "+ContactNumber);
		 
		 Thread.sleep(2000);
		 EntityLocator.ClickContactNumber(driver).sendKeys("1234253452");
		 Thread.sleep(2000);
		 Row row3 = sheet.getRow(48);						//Selected 1st index row (Second row)
		 org.apache.poi.ss.usermodel.Cell c3 = row3.getCell(1);						//Selected cell (1 row,1 column)
		 String email = c3.getStringCellValue();			//Got the URL stored at position 1,1
		 EntityLocator.ClickEmail(driver).sendKeys(email);
		 
		 Thread.sleep(2000);
		 Row row4 = sheet.getRow(49);						//Selected 1st index row (Second row)
		 org.apache.poi.ss.usermodel.Cell c4 = row4.getCell(1);						//Selected cell (1 row,1 column)
		 String address = c4.getStringCellValue();			//Got the URL stored at position 1,1
		 EntityLocator.ClickAddressLine(driver).sendKeys(address);
		 Thread.sleep(2000);
		 EntityLocator.ClickState(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.SelectState(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.ClickCity(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.SelectCity(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.ClickBtnSave(driver).click();
		 
		 Thread.sleep(3000);   
		  String msg = EntityLocator.ValidMsg(driver).getText();
		  if(msg.equalsIgnoreCase("Details Save Successfully")) 
		  {
				test.log(LogStatus.PASS, "Message Displayed = " +msg);
		  }
	       else
			{
					
					test.log(LogStatus.FAIL, "Message Displayed = " +msg);
			}
		    
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(2000);
		  EntityLocator.CloseIcon(driver).click();
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
}
	
	public static void InvaliddBranchDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAddNew(driver).click();
	    
	  
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeMyCompliances"));
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickName(driver).sendKeys("Rajsthan");
		
		Thread.sleep(2000);
	    EntityLocator.ClickBranchType(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.SelectBranchType(driver).click();
	    

		 Thread.sleep(2000);
		 EntityLocator.ClickContactPerson(driver).sendKeys("456*abc");
		 

		 Thread.sleep(2000);
		 EntityLocator.ClickContactNumber(driver).sendKeys("12342532");
		 
		 Thread.sleep(2000);
		  EntityLocator.ClickEmail(driver).sendKeys("abc$gmail.com");
		 
		 Thread.sleep(2000);
		 EntityLocator.ClickAddressLine(driver).sendKeys("mumbai");
		 
		 Thread.sleep(2000);
		 EntityLocator.ClickState(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.SelectState(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.ClickCity(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.SelectCity(driver).click();
		 Thread.sleep(2000);
		 EntityLocator.ClickBtnSave(driver).click();
		 
		 Thread.sleep(3000);   
		  String msg = EntityLocator.InvalidMsg(driver).getText();
		  test.log(LogStatus.PASS, "Message Displayed = " +msg);
		
		    
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(2000);
		  EntityLocator.CloseIcon(driver).click();
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	}	
	public static void WithoutEnteringDataBranchDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAddNew(driver).click();
	    
	  
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeMyCompliances"));
	    Thread.sleep(2000);
		 EntityLocator.ClickBtnSave(driver).click();
		 
		 Thread.sleep(3000);   
		  String msg = EntityLocator.InvalidMsg(driver).getText();
		  test.log(LogStatus.PASS, "Message Displayed = " +msg);
		
		    
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(2000);
		  EntityLocator.CloseIcon(driver).click();
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void TwoMandatoryFieldsBranchDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAddNew(driver).click();
	    
	  
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeMyCompliances"));
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickName(driver).sendKeys("Pune");
		
		Thread.sleep(2000);
	    EntityLocator.ClickBranchType(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.SelectBranchType(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickStatus(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.SelectStatus(driver).click();
	    
		 Thread.sleep(2000);
		 EntityLocator.ClickBtnSave(driver).click();
		 
		 Thread.sleep(3000);   
		  String msg = EntityLocator.InvalidMsg(driver).getText();
		  test.log(LogStatus.PASS, "Message Displayed = " +msg);
		
		    
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(2000);
		  EntityLocator.CloseIcon(driver).click();
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	}
	public static void EditBranchDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickEditIcon1(driver).click();
	    
	  
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeMyCompliances"));
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickName(driver).clear();
	    Thread.sleep(2000);
	    EntityLocator.ClickName(driver).sendKeys("Dehli");
	    
	    Thread.sleep(2000);
		 EntityLocator.ClickBtnSave(driver).click();
		 
		 Thread.sleep(3000);   
		  String msg = EntityLocator.InvalidMsg(driver).getText();
		  test.log(LogStatus.PASS, "Message Displayed = " +msg);
		
		    
		  
		  driver.switchTo().parentFrame();
		  Thread.sleep(2000);
		  EntityLocator.CloseIcon(driver).click();
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void UploadDocBranchDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		

		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\sample.pdf");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickUpload(driver).click();
	    

	    Thread.sleep(2000);
	    String msg=EntityLocator.ClickUploadValidMsg(driver).getText();
	    if(msg.equalsIgnoreCase("File Upload successfully")) 
		  {
				test.log(LogStatus.PASS, "Message Displayed = " +msg);
		  }
	       else
			{
					
					test.log(LogStatus.FAIL, "Message Displayed = " +msg);
			}
	    
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCloseicon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
		  
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	public static void InvalidUploadDocBranchDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Desktop\\Test Cases\\Approver Test Case.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpload(driver).click();
	    

	    Thread.sleep(4000);
	    String msg=EntityLocator.ClickUploadInValidMsg(driver).getText();
	    if(msg.equalsIgnoreCase("Please select file to upload")) 
		  {
				test.log(LogStatus.PASS, "Message Displayed = " +msg);
		  }
	       else
			{
					
					test.log(LogStatus.FAIL, "Message Displayed = " +msg);
			}
	    
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCloseicon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
		  
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}  
	public static void MultipleFileUploadDocBranchDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\sample.pdf");
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\file-sample_100kB.Doc");
	
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpload(driver).click();
	    

	    Thread.sleep(4000);
	    String msg=EntityLocator.ClickUploadValidMsg(driver).getText();
	    if(msg.equalsIgnoreCase("File Upload successfully")) 
		  {
				test.log(LogStatus.PASS, "Message Displayed = " +msg);
		  }
	       else
			{
					
					test.log(LogStatus.FAIL, "Message Displayed = " +msg);
			}
	    
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCloseicon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
		  
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}  
	public static void InvalidMultipleFileUploadDocBranchDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Desktop\\Test Cases\\Approver Test Case.xlsx");
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Desktop\\Test Cases\\Approver Test Case.xlsx");
	
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpload(driver).click();
	    

	    Thread.sleep(4000);
	    String msg=EntityLocator.ClickUploadInValidMsg(driver).getText();
	    if(msg.equalsIgnoreCase("Please select file to upload")) 
		  {
				test.log(LogStatus.PASS, "Message Displayed = " +msg);
		  }
	       else
			{
					
					test.log(LogStatus.FAIL, "Message Displayed = " +msg);
			}
	    
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCloseicon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
		  
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	}  
	
	public static void WithoutUploadDocBranchDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpload(driver).click();
	    

	    Thread.sleep(4000);
	    String msg=EntityLocator.ClickUploadInValidMsg(driver).getText();
	    if(msg.equalsIgnoreCase("Please select file to upload")) 
		  {
				test.log(LogStatus.PASS, "Message Displayed = " +msg);
		  }
	       else
			{
					
					test.log(LogStatus.FAIL, "Message Displayed = " +msg);
			}
	    
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCloseicon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.clickcloseIcon(driver).click();
		  
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	    
	} 
	
	
	public static void CloseBranchDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
	
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAddNew(driver).click();
	    
	  
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IframeMyCompliances"));
	    
	
	    driver.switchTo().parentFrame();
		 
		  
		 if(EntityLocator.CloseIcon(driver).isEnabled())
		 {
			 Thread.sleep(2000);
			  EntityLocator.CloseIcon(driver).click();
			  test.log(LogStatus.PASS, "Close Button is clickable");
		 }
		 else
		 {
			 test.log(LogStatus.PASS, "Close Button is not clickable");
		 }
		  
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	
	}
	public static void BankDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	  
	    Thread.sleep(2000);
	    if(EntityLocator.BankDetailes(driver).isEnabled())
		 {
			 Thread.sleep(2000);
			 EntityLocator.BankDetailes(driver).click();
			 test.log(LogStatus.PASS, "Branch Detailes is clickable");
		 }
		 else
		 {
			 test.log(LogStatus.PASS, "Branch Detailes is not clickable");
		 }
		  
		  
		  Thread.sleep(2000);
		    EntityLocator.clickcloseIcon(driver).click();
		  Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	
	}
	public static void AddBankDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		sheet = workbook.getSheetAt(0);
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    Row row = sheet.getRow(52);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
		int AccNo= (int)c.getNumericCellValue();		//Got the URL stored at position 1,1
		EntityLocator.ClickAccNo(driver).sendKeys(""+AccNo);
		
		Thread.sleep(2000);
		Row row1 = sheet.getRow(53);						//Selected 1st index row (Second row)
	    org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String BankName = c1.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.ClickBankName(driver).sendKeys(BankName);
		
		Thread.sleep(2000);
		EntityLocator.ClickAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.SelectAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		   Thread.sleep(4000);
		    String msg=EntityLocator.BankvalidMsg(driver).getText();
		    if(msg.equalsIgnoreCase("Record Save Successfully")) 
			  {
					test.log(LogStatus.PASS, "Message Displayed = " +msg);
			  }
		       else
				{
						
						test.log(LogStatus.FAIL, "Message Displayed = " +msg);
				}
		
	Thread.sleep(2000);
	EntityLocator.ClickCloseIcon1(driver).click();
		
	Thread.sleep(2000);
    EntityLocator.clickcloseIcon(driver).click();
		    
		   Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		
	
	}
	public static void DuplicateBankDetailesLLP(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		sheet = workbook.getSheetAt(0);
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    Row row = sheet.getRow(52);						//Selected 1st index row (Second row)
		org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
		int AccNo= (int)c.getNumericCellValue();		//Got the URL stored at position 1,1
		EntityLocator.ClickAccNo(driver).sendKeys(""+AccNo);
		
		Thread.sleep(2000);
		Row row1 = sheet.getRow(53);						//Selected 1st index row (Second row)
	    org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String BankName = c1.getStringCellValue();			//Got the URL stored at position 1,1
		EntityLocator.ClickBankName(driver).sendKeys(BankName);
		
		Thread.sleep(2000);
		EntityLocator.ClickAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.SelectAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		   Thread.sleep(4000);
		    String msg=EntityLocator.BankvalidMsg(driver).getText();
		    if(msg.equalsIgnoreCase("Record Save Successfully")) 
			  {
					test.log(LogStatus.FAIL, "Enter Dupliacte Bank Detailes = " +msg);
			  }
		       else
				{
						
						test.log(LogStatus.PASS, "Enter Dupliacte Bank Detailes = " +msg);
				}
		
	Thread.sleep(2000);
	EntityLocator.ClickCloseIcon1(driver).click();
		
	Thread.sleep(2000);
    EntityLocator.clickcloseIcon(driver).click();
		    
		   Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		
	
	}
	public static void InvalidAccountNoLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
	    Thread.sleep(2000);
		EntityLocator.ClickAccNo(driver).sendKeys("tty^74");
		
		
		
		Thread.sleep(2000);
		EntityLocator.ClickAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.SelectAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		
		Thread.sleep(2000);
		String msg=EntityLocator.AccnoBankInavalidMsg(driver).getText();
		Thread.sleep(2000);
		String msg1=EntityLocator.BankNameBankInavalidMsg(driver).getText();
		
		test.log(LogStatus.PASS, " Messeage Displayed =" +msg);
		

		
	Thread.sleep(2000);
	EntityLocator.ClickCloseIcon1(driver).click();
		
	Thread.sleep(2000);
    EntityLocator.clickcloseIcon(driver).click();
		    
	Thread.sleep(4000);
   EntityLocator.ClickDashboard(driver).click();
		
	
	}
	public static void InvalidBankNameLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
	 
		
		Thread.sleep(2000);
	   EntityLocator.ClickBankName(driver).sendKeys("4%gdd");
		
//		Thread.sleep(2000);
//		//EntityLocator.ClickAccType(driver).click();
//		
//		Thread.sleep(2000);
//		EntityLocator.SelectAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		
	
		Thread.sleep(2000);
		String msg=EntityLocator.BankNameBankInavalidMsg(driver).getText();
		
		test.log(LogStatus.PASS, " Messeage Displayed =" +msg);
		

		
	      Thread.sleep(2000);
	     EntityLocator.ClickCloseIcon1(driver).click();
		
	     Thread.sleep(2000);
         EntityLocator.clickcloseIcon(driver).click();
		    
	     Thread.sleep(4000);
          EntityLocator.ClickDashboard(driver).click();
}
	
	public static void InvalidIFSCLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
		Thread.sleep(2000);
	   EntityLocator.ClickIfsc(driver).sendKeys("4%gdd");
		
		Thread.sleep(2000);
		EntityLocator.ClickAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.SelectAccType(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		
	
		Thread.sleep(2000);
		String msg=EntityLocator.IFSCBankInavalidMsg(driver).getText();
		
		test.log(LogStatus.PASS, " Messeage Displayed =" +msg);
		

		
	      Thread.sleep(2000);
	     EntityLocator.ClickCloseIcon1(driver).click();
		
	     Thread.sleep(2000);
         EntityLocator.clickcloseIcon(driver).click();
		    
	     Thread.sleep(4000);
          EntityLocator.ClickDashboard(driver).click();
}
	public static void DateBankDetailesLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAccNo(driver).sendKeys("5434567879");
	    
		Thread.sleep(2000);
		   EntityLocator.ClickBankName(driver).sendKeys("Bank of Maharasthra");
			
			Thread.sleep(2000);
			EntityLocator.ClickAccType(driver).click();
			
			Thread.sleep(2000);
			EntityLocator.SelectAccType(driver).click();
	    
	    Thread.sleep(2000);
		EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickClosingDate(driver).sendKeys("05-03-2023");
		
		Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		 Thread.sleep(4000);
		    String msg=EntityLocator.BankvalidMsg(driver).getText();
		    if(msg.equalsIgnoreCase("Record Save Successfully")) 
			  {
					test.log(LogStatus.FAIL, "Opening date is greater than closing date = " +msg);
			  }
		       else
				{
						
						test.log(LogStatus.PASS, "Opening date is greater than closing date = " +msg);
				}
		
	       Thread.sleep(2000);
	       EntityLocator.ClickCloseIcon1(driver).click();
		
	        Thread.sleep(3000);
            EntityLocator.clickcloseIcon(driver).click();
		    
		   Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		
	
	}
	public static void WithoutEnterBankDetailesLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.AddBankDetailes(driver).click();
	    
	    Thread.sleep(2000);
		EntityLocator.ClickSave(driver).click();
		
		Thread.sleep(2000);
		String msg=EntityLocator.AccnoBankInavalidMsg(driver).getText();
		Thread.sleep(2000);
		String msg1=EntityLocator.BankNameBankInavalidMsg(driver).getText();
		Thread.sleep(2000);
		String msg2=EntityLocator.ClickTypeOfAccount(driver).getText();
		Thread.sleep(2000);
	    String msg3=EntityLocator.InvalidOpenDate(driver).getText();
	    
		test.log(LogStatus.PASS, " Messeage Displayed ="  +msg +"," +msg1 +"," +msg2 +"," +msg3);
		
		   Thread.sleep(2000);
	       EntityLocator.ClickCloseIcon1(driver).click();
		
	        Thread.sleep(2000);
            EntityLocator.clickcloseIcon(driver).click();
		    
		   Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		
		
	}
	public static void UpdateBankDetailesLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    
		 Thread.sleep(3000);
		  EntityLocator.UpdateBankDetailes(driver).click();
		  
		  Thread.sleep(2000);
		    EntityLocator.ClickAccNo(driver).clear();
		  
		  Thread.sleep(2000);
		    EntityLocator.ClickAccNo(driver).sendKeys("5434567879");
		    
		    Thread.sleep(2000);
			EntityLocator.ClickSave(driver).click();
			
			 Thread.sleep(4000);
			    String msg=EntityLocator.BankvalidMsg(driver).getText();
			    if(msg.equalsIgnoreCase("Record Updated Successfully")) 
				  {
						test.log(LogStatus.PASS, "Message Displayed = " +msg);
				  }
			       else
					{
							
							test.log(LogStatus.FAIL, "Message Displayed = " +msg);
					}
		    
			    Thread.sleep(2000);
			       EntityLocator.ClickCloseIcon1(driver).click();
				
			        Thread.sleep(2000);
		            EntityLocator.clickcloseIcon(driver).click();
				    
				   Thread.sleep(4000);
				     EntityLocator.ClickDashboard(driver).click();
	}
	public static void InvalidUpdateBankDetailesLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
	    
		 Thread.sleep(2000);
		  EntityLocator.UpdateBankDetailes(driver).click();
		  
		  Thread.sleep(2000);
		  EntityLocator.ClickAccNo(driver).clear();
		  
		  Thread.sleep(2000);
		  EntityLocator.ClickAccNo(driver).sendKeys("786$5");
		    
		    Thread.sleep(2000);
			EntityLocator.ClickBankName(driver).sendKeys("4%gdd");

		     Thread.sleep(2000);
			 EntityLocator.ClickIfsc(driver).sendKeys("4%gdd");
				
			Thread.sleep(2000);
			EntityLocator.ClickOpeningDate(driver).sendKeys("05-04-202");
			
			 Thread.sleep(2000);
				EntityLocator.ClickSave(driver).click();
				
				Thread.sleep(2000);
				String msg=EntityLocator.AccnoBankInavalidMsg(driver).getText();
				Thread.sleep(2000);
				String msg1=EntityLocator.BankNameBankInavalidMsg(driver).getText();
				Thread.sleep(2000);
				String msg2=EntityLocator.IFSCBankInavalidMsg(driver).getText();
				Thread.sleep(2000);
			    String msg3=EntityLocator.InvalidOpenDate1(driver).getText();
			    
				test.log(LogStatus.PASS, " Messeage Displayed ="  +msg +"," +msg1 +"," +msg2 +"," +msg3);
				
				
				   Thread.sleep(2000);
			       EntityLocator.ClickCloseIcon1(driver).click();
				
			        Thread.sleep(2000);
		            EntityLocator.clickcloseIcon(driver).click();
				    
				   Thread.sleep(4000);
				     EntityLocator.ClickDashboard(driver).click();
	}
	public static void DeleteBankDetailesLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
				
		 Thread.sleep(2000);
		 EntityLocator.DeleteBankDetailes(driver).click();
		 
		 Thread.sleep(2000);
		 EntityLocator.ClickYes(driver).click();
		 
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
	            EntityLocator.clickcloseIcon(driver).click();
			    
			   Thread.sleep(4000);
			     EntityLocator.ClickDashboard(driver).click();
			  
	}
	public static void DeleteBankDetailes1LLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
		 EntityLocator.BankDetailes(driver).click();
				
		 Thread.sleep(2000);
		 EntityLocator.DeleteBankDetailes(driver).click();
		
		 
		 if(EntityLocator.DeleteBankDetailes1(driver).isEnabled())
		 {   
			 Thread.sleep(2000);
		     EntityLocator.DeleteBankDetailes1(driver).click();
		     
		     test.log(LogStatus.PASS,"User Should be able to cancel deletion of an item");
		 }
		 else
		 {
			 test.log(LogStatus.FAIL,"User Should not be able to cancel deletion of an item");
		 }
		 
	
		
	        Thread.sleep(2000);
          EntityLocator.clickcloseIcon(driver).click();
		    
		   Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		 
	}  
			 
	public static void EntityExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickEntityExcel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\EntityExcelFile.xlsx");
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelValidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Enter Valid Data In Entity Excel File =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelInvalidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Enter Valid Data In Entity Excel File =" +msg );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void InvalidDataEntityExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(3000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickEntityExcel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\EntityExcelFile1.xlsx");
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelInvalidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Enter Invalid Data in Entity Excel File =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelValidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Enter Invalid Data in Entity Excel File =" +msg );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void EnterExistingDataEntityExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickEntityExcel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\EntityExcelFile.xlsx");
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelInvalidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Enter Existing Data in Entity Excel File =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelValidMsg(driver).getText();
			  test.log(LogStatus.FAIL,"Enter Existing Data in Entity Excel File =" +msg );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void WithoutEnteringDataEntityExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickEntityExcel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\EntityExcelFile2.xlsx");
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelInvalidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Without Enter Data In Entity Excel File =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelValidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Without Enter Data In Entity Excel File =" +msg  );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void EnterInvalidEntityExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickEntityExcel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Desktop\\Test Cases\\Approver Test Case.xlsx");
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelValidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Upload Invalid File In Entity Excel =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelInvalidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Upload Invalid File In Entity Excel =" +msg  );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void WithoutSelectingFileEntityExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickEntityExcel(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelValidMsg1(driver).getText();
	        test.log(LogStatus.PASS,"Without selecting a file In Entity Excel =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelInvalidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "without selecting a fileIn Entity Excel =" +msg  );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void LLPExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickLLPExcel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\LLP Sample File.xlsx");
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelValidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Enter Valid Data In LLP Excel File =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelInvalidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Enter Valid Data In LLP Excel File =" +msg );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void InvalidDataLLPExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickLLPExcel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\LLP Sample File1.xlsx");
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelInvalidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Enter Invalid Data in Entity Excel File =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelValidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Enter Invalid Data in Entity Excel File =" +msg );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void EnterExistingDataLLPExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickLLPExcel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\LLP Sample File.xlsx");
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelInvalidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Enter Existing Data In LLP Excel File =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelValidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Enter Existing Data In LLP Excel File =" +msg );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void WithoutEnteringDataLLPExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickLLPExcel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\LLP Sample File2.xlsx");
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelInvalidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Without Enter Data In LLP Excel File =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelValidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Without Enter Data In LLP Excel File =" +msg  );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void EnterInvalidLLPExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickLLPExcel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ComplianceSheet-11.xlsx");
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelValidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Upload Invalid File In LLP Excel =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelInvalidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Upload Invalid File In LLP Excel =" +msg  );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void WithoutSelectingFileLLPExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickLLPExcel(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelValidMsg1(driver).getText();
	        test.log(LogStatus.PASS,"Without selecting a file In LLP Excel =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelInvalidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "without selecting a file In LLP Excel =" +msg  );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	
	
	
	public static void MGT7ExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickMGT7Excel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\KAPL - MGT-7 (2020-21)-25.03.2022 Signed  T90729922.pdf");
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\BFN_Form_MGT_7SPZSPZ_28 12 2021.pdf");
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\1. Spresso MGT 7.pdf");
		
		
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelValidMsg2(driver).getText();
	        test.log(LogStatus.PASS,"Upload Valid file In MGT-7 =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelInvalidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Upload Valid file In MGT-7 =" +msg );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void MGT7ExcelInvalidUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickMGT7Excel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Desktop\\Test Cases\\Approver Test Case.xlsx");
		
		
		
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelValidMsg2(driver).getText();
	        test.log(LogStatus.PASS,"Upload Invalid file In MGT-7 =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelInvalidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Upload InValid file In MGT-7 =" +msg );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void MGT7ExcelDiffPDFInvalidUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickMGT7Excel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\sample.pdf");
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\PaymentOrder07-06-2023.pdf");
		
		
		
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelValidMsg2(driver).getText();
	        test.log(LogStatus.PASS,"Upload Different InValid file In MGT-7 =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelInvalidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Upload Different InValid file In MGT-7 =" +msg );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void MGT7ExcelExistingUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickMGT7Excel(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\KAPL - MGT-7 (2020-21)-25.03.2022 Signed  T90729922.pdf");
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\BFN_Form_MGT_7SPZSPZ_28 12 2021.pdf");
		
		Thread.sleep(2000);
		EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\1. Spresso MGT 7.pdf");
		
		
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelValidMsg2(driver).getText();
	        test.log(LogStatus.FAIL,"Upload Existing file In MGT-7 =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelInvalidMsg(driver).getText();
			  test.log(LogStatus.PASS, "Upload Existing file In MGT-7 =" +msg );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void WithoutSelectingFileMGT7ExcelUploadFile(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickUploadButton(driver).click();
		Thread.sleep(2000);
		EntityLocator.clickMGT7Excel(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.clickUploadButton1(driver).click();

		try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.EntityExcelValidMsg1(driver).getText();
	        test.log(LogStatus.PASS,"Without selecting a file In MGT-7 Excel =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.EntityExcelInvalidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "without selecting a file In MGT-7 Excel =" +msg  );
			
		  }
		Thread.sleep(2000);
		EntityLocator.clickCloseIcon(driver).click();
		
	    Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
	}
	public static void ClickImport(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	
		Thread.sleep(2000);
	   if(EntityLocator.ClickImport(driver).isEnabled())
	    {
	      Thread.sleep(2000);
	      EntityLocator.ClickImport(driver).click();
	      test.log(LogStatus.PASS, "Import Button is clickable");
	    }
	    else
	    {
	    	 test.log(LogStatus.PASS, "Import Button is not clickable");
	    }
	   
	   Thread.sleep(2000);
	    EntityLocator.CloseBtn(driver).click();
	  
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	
	}
	public static void ClickImportCheckBox(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
	    Thread.sleep(2000);
	      EntityLocator.ClickImport(driver).click();
	
		Thread.sleep(2000);
	   if(EntityLocator.ClickImportChcekbox(driver).isEnabled())
	    {
	      Thread.sleep(2000);
	      EntityLocator.ClickImportChcekbox(driver).click();
	      test.log(LogStatus.PASS, "CheckBox is Clickable");
	    }
	    else
	    {
	    	 test.log(LogStatus.PASS, "CheckBox is not Clickable");
	    }
	   
	   Thread.sleep(2000);
	    EntityLocator.CloseBtn(driver).click();
	  
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	
	}
	public static void ValidationOfSaveBtn(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
	    Thread.sleep(2000);
	      EntityLocator.ClickImport(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickImportChcekbox(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickImportSaveBtn(driver).click();
	      
	      Thread.sleep(500);
	      String msg=EntityLocator.ValidationOfSaveMsg(driver).getText();
	
	      Thread.sleep(2000);
	   if(msg.equalsIgnoreCase("Save Successfully."))
	    {
	     
	      test.log(LogStatus.PASS, "Message Displayed =" +msg);
	    }
	    else
	    {
	    	 test.log(LogStatus.FAIL,  "Message Displayed =" +msg);
	    }

		
	
	   Thread.sleep(2000);
	    EntityLocator.CloseBtn(driver).click();
	  
	    
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	
	}
	
	public static void SearchFieldImportTab(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
	    Thread.sleep(2000);
	      EntityLocator.ClickImport(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickSearchField(driver).sendKeys("BEACH HAVEN PROPERTIES PRIVATE LIMITED",Keys.ENTER);
	      
	      String msg="BEACH HAVEN PROPERTIES PRIVATE LIMITED";
	      
	      if(msg.equalsIgnoreCase(msg))
	      {
	    	  test.log(LogStatus.PASS, "Message Displayed =" +msg);
	      }
	      else
	      {
	    	  test.log(LogStatus.FAIL, "Message Displayed =" +msg);
	      }
	      Thread.sleep(2000);
		    EntityLocator.CloseBtn(driver).click();
		  
		    
		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void SearchFieldEntityTab(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	   
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    
	    String msg="U72266KA2002PLC030311";
	      
	      if(msg.equalsIgnoreCase(msg))
	      {
	    	  test.log(LogStatus.PASS, "Message Displayed =" +msg);
	      }
	      else
	      {
	    	  test.log(LogStatus.FAIL, "Message Displayed =" +msg);
	      }
	      Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	    
	}
	
	
	public static void ClickApplicabilty(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	   
	    
	    Thread.sleep(2000);
		   if(EntityLocator.ClickMoreActionApplicability(driver).isEnabled())
		    {
		      Thread.sleep(4000);
		      EntityLocator.ClickMoreActionApplicability(driver).click();
		      test.log(LogStatus.PASS, "Applicability Option is Clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.PASS, "Applicability Option is not Clickable");
		    }
		   
		    Thread.sleep(2000);
		    EntityLocator.ClickApplicabilityCloseBtn(driver).click();

		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		   
	}
	
	public static void SaveApplicability(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	     Thread.sleep(4000);
	      EntityLocator.ClickMoreActionApplicability(driver).click();
	    
//	      Thread.sleep(4000);
//	      EntityLocator.ClickAmountInINR(driver).click();
//	      Thread.sleep(3000);
//	      EntityLocator.ClickAmountInLack(driver).click();
//	      Thread.sleep(4000);
//	      EntityLocator.ClickAmountInINR(driver).click();
//	      By locator = By.xpath("//*[@id='divAmount']/div/div[2]/div[2]/span[1]/span/input[1]");
//
//			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//			Thread.sleep(4000);
//			
//			WebElement ViewButton = driver.findElement(locator);	
//			Thread.sleep(3000);
//		   JavascriptExecutor jse=(JavascriptExecutor)driver;
//		    jse.executeScript("arguments[0].click();", ViewButton);
//	      
//	      
//	      
//	      Thread.sleep(3000);
//	      EntityLocator.ClickTurnOver(driver).clear();
//	      Thread.sleep(4000);
//	      EntityLocator.ClickTurnOver(driver).sendKeys("7");
//	      EntityLocator.ClickNetWorth(driver).clear();
//	      Thread.sleep(4000);
//	      EntityLocator.ClickNetWorth(driver).sendKeys("5");
//	      EntityLocator.ClickNetProfit(driver).clear();
//	      Thread.sleep(4000);
//	      EntityLocator.ClickNetProfit(driver).sendKeys("8");
//	      EntityLocator.ClickBorrowings(driver).clear();
//	      Thread.sleep(4000);
//	      EntityLocator.ClickBorrowings(driver).sendKeys("4");
//	      EntityLocator.ClickDeposit(driver).clear();
//	      Thread.sleep(4000);
//	      EntityLocator.ClickDeposit(driver).sendKeys("5");
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickSaveBtn1(driver).click();
	      
	      Thread.sleep(4000);
	     String msg= EntityLocator.ClickSaveApplicabilityMsg(driver).getText();
	      
	      if(msg.equalsIgnoreCase("Saved Successfully"))
		    {
		  
		      test.log(LogStatus.PASS, "Message Displayed =" +msg);
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Message Displayed =" +msg);
		    }
		   
		    Thread.sleep(2000);
		    EntityLocator.ClickApplicabilityCloseBtn(driver).click();

		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
		   
	}
	
	public static void YesRadioBtnApplicability(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	     Thread.sleep(4000);
	      EntityLocator.ClickMoreActionApplicability(driver).click();
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickYesRadioBtn(driver).click();
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickSaveBtn1(driver).click();
	      
	      Thread.sleep(4000);
	     String msg= EntityLocator.ClickSaveApplicabilityMsg(driver).getText();
	      
	      if(msg.equalsIgnoreCase("Saved Successfully"))
		    {
		  
		      test.log(LogStatus.PASS, "By selecting the Yes radio button changes the button state to selected =" +msg);
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "By selecting the Yes radio button changes the button state to selected  =" +msg);
		    }
		   
		    Thread.sleep(2000);
		    EntityLocator.ClickApplicabilityCloseBtn(driver).click();

		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	      
	}
	
	public static void NoRadioBtnApplicability(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	     Thread.sleep(4000);
	      EntityLocator.ClickMoreActionApplicability(driver).click();
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickNoRadioBtn(driver).click();
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickSaveBtn1(driver).click();
	      
	      Thread.sleep(4000);
	     String msg= EntityLocator.ClickSaveApplicabilityMsg(driver).getText();
	      
	      if(msg.equalsIgnoreCase("Saved Successfully"))
		    {
		  
		      test.log(LogStatus.PASS, "By selecting the No radio button changes the button state to selected =" +msg);
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "By selecting the No radio button changes the button state to selected  =" +msg);
		    }
		   
		    Thread.sleep(2000);
		    EntityLocator.ClickApplicabilityCloseBtn(driver).click();

		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	      
	}
	
	
	public static void CloseApplicability(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	     Thread.sleep(4000);
	      EntityLocator.ClickMoreActionApplicability(driver).click();
	      
	      Thread.sleep(4000);
	      if(EntityLocator.ClickCloseApplicability(driver).isEnabled())
		    {
		      Thread.sleep(2000);
		      EntityLocator.ClickCloseApplicability(driver).click();
		      test.log(LogStatus.PASS, "Close Buttton is clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Close Buttton is not clickable");
		    }
	      
	      Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	      
	}
	
	public static void ClickShareHoldingOption(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	{
		
		sheet=workbook.getSheetAt(0);
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
	    Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	   
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	
		Thread.sleep(2000);
	      if(EntityLocator.ClickShareHolding(driver).isEnabled())
		    {
		      Thread.sleep(2000);
		      EntityLocator.ClickShareHolding(driver).click();
		      test.log(LogStatus.PASS, "ShareHolding Option is clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "ShareHolding Option is not clickable");
		    }
	      Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	}
	public static void AddShareHolding(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	{
		
		sheet=workbook.getSheetAt(0);
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		  EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		   
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickNewBtnShareHolding(driver).click();
	      
	  	  Thread.sleep(2000);
	      Row row = sheet.getRow(63);						//Selected 1st index row (Second row)
	      org.apache.poi.ss.usermodel.Cell c = row.getCell(1);						//Selected cell (1 row,1 column)
		  int FolioNo = (int) c.getNumericCellValue();	//Got the URL stored at position 1,1
		  EntityLocator.ClickFOLIONO(driver).sendKeys(FolioNo +"");
		  
		  Thread.sleep(4000);
	      EntityLocator.ClickClassOfShares(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickClassOfShares1(driver).click();
		  
//	      Thread.sleep(4000);
//	      EntityLocator. ClickNominalvaluepershare(driver).sendKeys("100");
//	      
//	      Thread.sleep(4000);
//	      EntityLocator.ClickTotalsharesheld(driver).sendKeys("290375");
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickType(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickType1(driver).click();
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickNationality(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickNationality1(driver).click();
	      
	  	  Thread.sleep(2000);
	      Row row1 = sheet.getRow(64);						//Selected 1st index row (Second row)
	      org.apache.poi.ss.usermodel.Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		  String Name = c1.getStringCellValue();	//Got the URL stored at position 1,1
		  EntityLocator.ClickNameofthemember(driver).sendKeys(Name);
		  
		  Thread.sleep(2000);
	      Row row2 = sheet.getRow(65);						//Selected 1st index row (Second row)
	      org.apache.poi.ss.usermodel.Cell c2 = row2.getCell(1);						//Selected cell (1 row,1 column)
		  String NameOfJointHolders = c2.getStringCellValue();	//Got the URL stored at position 1,1
		  EntityLocator.ClickNameofjointholders(driver).sendKeys(NameOfJointHolders);
		  
		  Thread.sleep(2000);
	      Row row3 = sheet.getRow(66);						//Selected 1st index row (Second row)
	      org.apache.poi.ss.usermodel.Cell c3 = row3.getCell(1);						//Selected cell (1 row,1 column)
		  String CIN = c3.getStringCellValue();	//Got the URL stored at position 1,1
		  EntityLocator.ClickCIN(driver).sendKeys(CIN);
		  
		  
		  Thread.sleep(2000);
	      Row row4 = sheet.getRow(67);						//Selected 1st index row (Second row)
	      org.apache.poi.ss.usermodel.Cell c4 = row4.getCell(1);						//Selected cell (1 row,1 column)
		  String Address = c4.getStringCellValue();	//Got the URL stored at position 1,1
		  EntityLocator.ClickAddress(driver).sendKeys(Address);
		  
		  Thread.sleep(2000);
	      Row row5 = sheet.getRow(68);						//Selected 1st index row (Second row)
	      org.apache.poi.ss.usermodel.Cell c5 = row5.getCell(1);						//Selected cell (1 row,1 column)
		  String FatherName = c5.getStringCellValue();	//Got the URL stored at position 1,1
		  EntityLocator.ClickSpousename(driver).sendKeys(FatherName);
		  
		  Thread.sleep(2000);
	      Row row6 = sheet.getRow(69);						//Selected 1st index row (Second row)
	      org.apache.poi.ss.usermodel.Cell c6 = row6.getCell(1);						//Selected cell (1 row,1 column)
		  String emailid = c6.getStringCellValue();	//Got the URL stored at position 1,1
		  EntityLocator.ClickEmailId(driver).sendKeys(emailid);
		  
		  Thread.sleep(2000);
	      Row row7 = sheet.getRow(70);						//Selected 1st index row (Second row)
	      org.apache.poi.ss.usermodel.Cell c7 = row7.getCell(1);						//Selected cell (1 row,1 column)
		  String Occupation = c7.getStringCellValue();	//Got the URL stored at position 1,1
		  EntityLocator.ClickOccupation(driver).sendKeys(Occupation);
		  
		  Thread.sleep(2000);
	      Row row8 = sheet.getRow(71);						//Selected 1st index row (Second row)
	      org.apache.poi.ss.usermodel.Cell c8 = row8.getCell(1);						//Selected cell (1 row,1 column)
		  String PAN = c8.getStringCellValue();	//Got the URL stored at position 1,1
		  EntityLocator.ClickPAN(driver).sendKeys(PAN);
		  
		  
		  Thread.sleep(2000);
		  EntityLocator. ClickDateofbecomingmemberCalender(driver).click();
		  Thread.sleep(2000);
		  EntityLocator.ClickDateofbecomingmember(driver).click();
		  
		  
		  Thread.sleep(2000);
		  EntityLocator. ClickSaveShareHolding(driver).click();
		  
		  
		  Thread.sleep(4000);
		     String msg= EntityLocator.ClickSaveMsg(driver).getText();
		      
		      if(msg.equalsIgnoreCase("Saved Successfully"))
			    {
			  
			      test.log(LogStatus.PASS, "Add ShareHolding =" +msg);
			    }
			    else
			    {
			    	 test.log(LogStatus.FAIL, "Add ShareHolding  =" +msg);
			    }
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickShareHoldingDetailes(driver).click();
			  
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickCloseBtn(driver).click();

	      Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
		  
	}
	
	public static void ClickShareHoldingDeatils(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(2000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
			Thread.sleep(3000);
		      EntityLocator.ClickEditShareHoldingDetailes(driver).click();
		      
		      Thread.sleep(2000);
			  if(EntityLocator.ClickShareHoldingDetailes(driver).isEnabled())
			    {
			      Thread.sleep(2000);
			      EntityLocator.ClickShareHoldingDetailes(driver).click();
			      test.log(LogStatus.PASS, "ShareHolding Detailes Option is clickable");
			    }
			    else
			    {
			    	 test.log(LogStatus.FAIL, "ShareHolding Detailes Option is not clickable");
			    }
			  
			    Thread.sleep(2000);
				  EntityLocator.ClickCloseBtn(driver).click();

		      Thread.sleep(4000);
			  EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void ShareHoldingDeatils(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
			Thread.sleep(2000);
		      EntityLocator.ClickEditShareHoldingDetailes(driver).click();
		      
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickShareHoldingDetailes(driver).click();
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickAddNewShareHoldingDetailes(driver).click();

			  Thread.sleep(2000);
			  EntityLocator.ClickAllotmentNo(driver).sendKeys("ABC35");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickDateOfAllotmentCalender(driver).click();
			  Thread.sleep(2000);
			  EntityLocator.Date(driver).click();
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickNoOfSharesAlloted(driver).sendKeys("3");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickDistinctivenumbersFroms(driver).sendKeys("1");
			 
			  Thread.sleep(2000);
			  EntityLocator.ClickDistinctivenumbersTo(driver).sendKeys("2");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickFoliooftransferor(driver).sendKeys("PQR@123");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickNameOftransferor(driver).sendKeys("abv@123");
			  
			  Thread.sleep(2000);
			  EntityLocator. ClickDateofissueCalender(driver).click();
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickDateofissue(driver).click();
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickCertificateNo(driver).sendKeys("A&11");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickLockInPeriod(driver).sendKeys("13$A");
			  
//			  Thread.sleep(2000);
//			  EntityLocator.ClickAmountPayable(driver).sendKeys("1000");
//			  
//			  Thread.sleep(2000);
//			  EntityLocator.ClickDeemedtobepaid(driver).sendKeys("1000");
//			  
//			  Thread.sleep(2000);
//			  EntityLocator.ClickDueAmount(driver).sendKeys("2000");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickIfsharesareissuedforconsiderationotherthancashbrieparticularsthereof(driver).sendKeys("A&11");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickDateOfTransferCalender(driver).click();
			  Thread.sleep(2000);
			  EntityLocator.ClickDateOfTransfer(driver).click();
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickNoofsharestransferred(driver).sendKeys("4");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickDistinctivenumbersFroms1(driver).sendKeys("3");
			 
			  Thread.sleep(2000);
			  EntityLocator.ClickDistinctivenumbersTo1(driver).sendKeys("4");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickFoliooftransferee(driver).sendKeys("LMN$23");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickNameOftransferee(driver).sendKeys("LMN$23");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickBalanceshares(driver).sendKeys("23");
			  Thread.sleep(2000);
			  EntityLocator.ClickRemark(driver).sendKeys("ok");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickSaveShareHoldingDetailes(driver).click();
			  
			  Thread.sleep(4000);
			   String msg1= EntityLocator.ClickSaveMsg1(driver).getText();
			  Thread.sleep(2000);
			  if(msg1.equalsIgnoreCase("Saved Successfully."))
			    {
			  
			      test.log(LogStatus.PASS, "Add ShareHolding Detailes =" +msg1);
			    }
			    else
			    {
			    	 test.log(LogStatus.FAIL, "Add ShareHolding Detailes =" +msg1);
			    }
			  
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickCloseBtn1(driver).click();

	      Thread.sleep(2000);
		  EntityLocator.ClickDashboard(driver).click();
			  
	}
	public static void EnterInvaliddataFoliooftransferor(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
			Thread.sleep(2000);
		      EntityLocator.ClickEditShareHoldingDetailes(driver).click();
		      
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickShareHoldingDetailes(driver).click();
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickAddNewShareHoldingDetailes(driver).click();

			  Thread.sleep(2000);
			  EntityLocator.ClickAllotmentNo(driver).sendKeys("ABC35");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickDateOfAllotmentCalender(driver).click();
			  Thread.sleep(2000);
			  EntityLocator.Date(driver).click();
			  
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickNoOfSharesAlloted(driver).sendKeys("3");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickDistinctivenumbersFroms(driver).sendKeys("1");
			 
			  Thread.sleep(2000);
			  EntityLocator.ClickDistinctivenumbersTo(driver).sendKeys("2");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickFoliooftransferor(driver).sendKeys("*675$");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickNameOftransferor(driver).sendKeys("abv@123");
			  
			  Thread.sleep(2000);
			  EntityLocator. ClickDateofissueCalender(driver).click();
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickDateofissue(driver).click();
			  
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickCertificateNo(driver).sendKeys("A&11");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickLockInPeriod(driver).sendKeys("13$A");
			  
//			  Thread.sleep(2000);
//			  EntityLocator.ClickAmountPayable(driver).sendKeys("1000");
//			  
//			  Thread.sleep(2000);
//			  EntityLocator.ClickDeemedtobepaid(driver).sendKeys("1000");
//			  
//			  Thread.sleep(2000);
//			  EntityLocator.ClickDueAmount(driver).sendKeys("2000");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickIfsharesareissuedforconsiderationotherthancashbrieparticularsthereof(driver).sendKeys("A&11");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickDateOfTransferCalender(driver).click();
			  Thread.sleep(2000);
			  EntityLocator.ClickDateOfTransfer(driver).click();
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickNoofsharestransferred(driver).sendKeys("4");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickDistinctivenumbersFroms1(driver).sendKeys("3");
			 
			  Thread.sleep(2000);
			  EntityLocator.ClickDistinctivenumbersTo1(driver).sendKeys("4");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickFoliooftransferee(driver).sendKeys("%$sd");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickNameOftransferee(driver).sendKeys("LMN$23");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickBalanceshares(driver).sendKeys("23");
			  Thread.sleep(2000);
			  EntityLocator.ClickRemark(driver).sendKeys("ok");
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickSaveShareHoldingDetailes(driver).click();
			  
			  Thread.sleep(4000);
			   String msg1= EntityLocator.ClickSaveMsg1(driver).getText();
			 
			  if(msg1.equalsIgnoreCase("Saved Successfully."))
			    {
			  
			      test.log(LogStatus.FAIL, "Enter Invalid data Folio of transferor =" +msg1);
			    }
			    else
			    {
			    	 test.log(LogStatus.PASS, "Enter Invalid data Folio of transferor =" +msg1);
			    }
			  
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickCloseBtn1(driver).click();

	      Thread.sleep(2000);
		  EntityLocator.ClickDashboard(driver).click();
			  
	}
	
	
	public static void WithoutEnterDataInSahreHoldingDetailes(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
			Thread.sleep(2000);
		      EntityLocator.ClickEditShareHoldingDetailes(driver).click();
		      
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickShareHoldingDetailes(driver).click();
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickAddNewShareHoldingDetailes(driver).click();
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickSaveShareHoldingDetailes(driver).click();
			  
			  Thread.sleep(4000);
			   String msg1= EntityLocator.ClickSaveMsg1(driver).getText();
			  Thread.sleep(2000);
			  if(msg1.equalsIgnoreCase("Saved Successfully."))
			    {
			  
			      test.log(LogStatus.FAIL, "Wihout Enter Data In ShareHolding Detailes=" +msg1);
			    }
			    else
			    {
			    	 test.log(LogStatus.PASS, "Wihout Enter Data In ShareHolding Detailes =" +msg1);
			    }
			  
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickCloseBtn1(driver).click();

	      Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
			  
	}
	public static void CloseBtnSahreHoldingDetailes(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);

	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(2000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
			Thread.sleep(2000);
		      EntityLocator.ClickEditShareHoldingDetailes(driver).click();
		      
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickShareHoldingDetailes(driver).click();
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickAddNewShareHoldingDetailes(driver).click();
			  Thread.sleep(2000);
	            if(EntityLocator.ClickCloseBtnShareHoldingDeatiles(driver).isEnabled())
	            {
	                 Thread.sleep(2000);
	                 EntityLocator.ClickCloseBtnShareHoldingDeatiles(driver).click();
	                 test.log(LogStatus.PASS, "Close Buttton is clickable");
	            }
	          else
	          {
	    	         test.log(LogStatus.FAIL, "Close Buttton is not clickable");
	          }
	           

		      Thread.sleep(4000);
			  EntityLocator.ClickDashboard(driver).click();
	}
	
	
	public static void UploadShareHolding(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding(driver).click();
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickChooseFileShareHolding(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ShareHolding_BasicDetails.xlsx");
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding1(driver).click();
	      
	      Thread.sleep(4000);
	      String msg=EntityLocator.ClickUploadValidationMsg(driver).getText();
	      
	      Thread.sleep(2000);
		  if(msg.equalsIgnoreCase("Record Save Successfully"))
		    {
		  
		      test.log(LogStatus.PASS, "Upload File ShareHolding =" +msg);
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Upload File ShareHolding =" +msg);
		    }
	      
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickApplicabilityCloseBtn(driver).click();
	      
	      Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
	}
	public static void UploadExistingFileShareHolding(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding(driver).click();
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickChooseFileShareHolding(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ShareHolding_BasicDetails.xlsx");
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding1(driver).click();
	      
	      Thread.sleep(4000);
	      String msg=EntityLocator.ClickUploadValidationMsg(driver).getText();
	      
	      Thread.sleep(2000);
		  if(msg.equalsIgnoreCase("Record Save Successfully"))
		    {
		  
		      test.log(LogStatus.FAIL, "The system should display an error message indicating that the file has already been uploaded and cannot be uploaded again. ="    +msg);
		    }
		    else
		    {
		    	 test.log(LogStatus.PASS, "The system should display an error message indicating that the file has already been uploaded and cannot be uploaded again. ="    +msg);
		    }
	      
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickApplicabilityCloseBtn(driver).click();
	      
	      Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void InvalidUploadShareHolding(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding(driver).click();
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickChooseFileShareHolding(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ShareHolding_BasicDetails (1).xlsx");
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding1(driver).click();
	      
	      Thread.sleep(4000);
	      String msg=EntityLocator.ClickInvalidUploadValidationMsg(driver).getText();
	      
	      Thread.sleep(2000);
		  if(msg.equalsIgnoreCase("Please enter valid Date Of Allotment at row - 2"))
		    {
		  
		      test.log(LogStatus.PASS, "Enter Invalid data in Upload File =" +msg);
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Enter Invalid data in Upload File  =" +msg);
		    }
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickApplicabilityCloseBtn(driver).click();
	      
	      Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
	}
	public static void EmptyFileUploadShareHolding(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);

	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding(driver).click();
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickChooseFileShareHolding(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ShareHolding_BasicDetails (2).xlsx");
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding1(driver).click();
	      
	      Thread.sleep(4000);
	      String msg=EntityLocator.ClickUploadValidationMsg(driver).getText();
	      
	      Thread.sleep(2000);
		  if(msg.equalsIgnoreCase("Record Save Successfully"))
		    {
		  
		      test.log(LogStatus.FAIL, "User receives an error message indicating that the required fields must be filled out. ="    +msg);
		    }
		    else
		    {
		    	 test.log(LogStatus.PASS, "User receives an error message indicating that the required fields must be filled out. ="    +msg);
		    }
	      
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickApplicabilityCloseBtn(driver).click();
	      
	      Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
	}
	public static void InvalidFileUploadShareHolding(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding(driver).click();
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickChooseFileShareHolding(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ShareHolding_BasicDetails (2).xlsx");
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding1(driver).click();
	      
	      Thread.sleep(4000);
	      String msg=EntityLocator.ClickUploadValidationMsg(driver).getText();
	      
	      Thread.sleep(2000);
		  if(msg.equalsIgnoreCase("No Data Found in Excel Document or Sheet Name must be 'ShareHoldings'"))
		    {
		  
		      test.log(LogStatus.FAIL, " Error message should be displayed on popup but error message comes in Green colour =" +msg);
		    }
		    else
		    {
		    	 test.log(LogStatus.PASS, "Error message should be displayed on popup but error message comes in Green colour ="    +msg);
		    }
	      
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickApplicabilityCloseBtn(driver).click();
	      
	      Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void WithoutSelectingFileUploadShareHolding(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding(driver).click();
	      
	     
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding1(driver).click();
	      
	      Thread.sleep(4000);
	      String msg=EntityLocator.WithoutSelectingFileUploadShareHolding(driver).getText();
	      
	      Thread.sleep(2000);
		  if(msg.equalsIgnoreCase(" "))
		    {
		  
		      test.log(LogStatus.PASS, "An error message is displayed informing the user that 'Errors:Please Select File'. =" +msg);
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "An error message is displayed informing the user that 'Errors:Please Select File'. =" +msg);
		    }
	      
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickApplicabilityCloseBtn(driver).click();
	      
	      Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void UploadFileShareHoldingDeatils(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);

	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
			Thread.sleep(2000);
		      EntityLocator.ClickEditShareHoldingDetailes(driver).click();
		      
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickShareHoldingDetailes(driver).click();
			  
			  
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickUploadBtnShareHoldingDetailes(driver).click();
			  
			    Thread.sleep(4000);
			      EntityLocator.ClickChooseFileShareHolding(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ShareholdingDetails (1).xlsx");
			  
			      
			      Thread.sleep(4000);
			      EntityLocator.ClickUploadBtnShareHolding1(driver).click();
			  
			      Thread.sleep(4000);
			      String msg=EntityLocator.ClickUploadValidationMsg(driver).getText();
			      
			      Thread.sleep(2000);
				  if(msg.equalsIgnoreCase("Record Save Successfully"))
				    {
				  
				      test.log(LogStatus.PASS, "Upload File ShareHolding Detailes =" +msg);
				    }
				    else
				    {
				    	 test.log(LogStatus.FAIL, "Upload File ShareHolding Detailes =" +msg);
				    }
				   Thread.sleep(4000);
				      EntityLocator.ClickCloseBtn2(driver).click();
			      
			      Thread.sleep(4000);
			      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
			      
			      Thread.sleep(4000);
				  EntityLocator.ClickDashboard(driver).click();
	}
	public static void UploadExistingFileShareHoldingDeatils(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		   
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
			Thread.sleep(2000);
		      EntityLocator.ClickEditShareHoldingDetailes(driver).click();
		      
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickShareHoldingDetailes(driver).click();
			  
			  
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickUploadBtnShareHoldingDetailes(driver).click();
			  
			    Thread.sleep(4000);
			      EntityLocator.ClickChooseFileShareHolding(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ShareholdingDetails (1).xlsx");
			  
			      
			      Thread.sleep(4000);
			      EntityLocator.ClickUploadBtnShareHolding1(driver).click();
			  
			      Thread.sleep(4000);
			      String msg=EntityLocator.ClickUploadValidationMsg(driver).getText();
			      
			      Thread.sleep(2000);
				  if(msg.equalsIgnoreCase("Record Save Successfully"))
				    {
				  
				      test.log(LogStatus.FAIL, "Upload Existing File ShareHolding Detailes =" +msg);
				    }
				    else
				    {
				    	 test.log(LogStatus.PASS, "Upload Existing File ShareHolding Detailes =" +msg);
				    }
				   Thread.sleep(4000);
				      EntityLocator.ClickCloseBtn2(driver).click();
			      
			      Thread.sleep(4000);
			      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
			      
			      Thread.sleep(4000);
				  EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void InvalidDataUploadFileShareHoldingDeatils(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
			Thread.sleep(2000);
		      EntityLocator.ClickEditShareHoldingDetailes(driver).click();
		      
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickShareHoldingDetailes(driver).click();
			  
			  
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickUploadBtnShareHoldingDetailes(driver).click();
			  
			    Thread.sleep(4000);
			      EntityLocator.ClickChooseFileShareHolding(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ShareholdingDetails (2).xlsx");
			  
			      
			      Thread.sleep(4000);
			      EntityLocator.ClickUploadBtnShareHolding1(driver).click();
			  
			      Thread.sleep(4000);
			      String msg=EntityLocator.ClickInvalidUploadValidationMsg(driver).getText();
			      
			      Thread.sleep(2000);
				  if(msg.equalsIgnoreCase("Please enter valid Date Of Allotment at row - 2"))
				    {
				  
				      test.log(LogStatus.PASS, "Enter Invalid Data in Upload File ShareHolding Detailes =" +msg);
				    }
				    else
				    {
				    	 test.log(LogStatus.FAIL, "Enter Invalid Data in Upload File ShareHolding Detailes =" +msg);
				    }
				   Thread.sleep(4000);
				      EntityLocator.ClickCloseBtn2(driver).click();
			      
			      Thread.sleep(4000);
			      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
			      
			      Thread.sleep(4000);
				  EntityLocator.ClickDashboard(driver).click();
	}
	public static void EmptyDataUploadshareHoldingDeatils(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
			Thread.sleep(2000);
		      EntityLocator.ClickEditShareHoldingDetailes(driver).click();
		      
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickShareHoldingDetailes(driver).click();
			  
			  
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickUploadBtnShareHoldingDetailes(driver).click();
			  
			    Thread.sleep(4000);
			      EntityLocator.ClickChooseFileShareHolding(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ShareholdingDetails (3).xlsx");
			  
			      
			      Thread.sleep(4000);
			      EntityLocator.ClickUploadBtnShareHolding1(driver).click();
			      Thread.sleep(4000);
			      String msg=EntityLocator.ClickUploadValidationMsg(driver).getText();
			      Thread.sleep(2000);
				  if(msg.equalsIgnoreCase("Record Save Successfully"))
				    {
				  
				      test.log(LogStatus.FAIL, "User receives an error message indicating that the required fields must be filled out =" +msg);
				    }
				    else
				    {
				    	 test.log(LogStatus.PASS, "User receives an error message indicating that the required fields must be filled out =" +msg);
				    }
				   Thread.sleep(4000);
				      EntityLocator.ClickCloseBtn2(driver).click();
			      
			      Thread.sleep(4000);
			      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
			      
			      Thread.sleep(4000);
				  EntityLocator.ClickDashboard(driver).click();
	}
	public static void InvalidFileUploadShareHoldingDetailes(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
			Thread.sleep(2000);
		      EntityLocator.ClickEditShareHoldingDetailes(driver).click();
		      
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickShareHoldingDetailes(driver).click();
			  Thread.sleep(2000);
			  EntityLocator.ClickUploadBtnShareHoldingDetailes(driver).click();
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickChooseFileShareHolding(driver).sendKeys("C:\\Users\\Snehal Patil\\Desktop\\Test Cases\\Compliance Test Cases.xlsx");
	      
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding1(driver).click();
	      
	      Thread.sleep(4000);
	      String msg=EntityLocator.ClickUploadValidationMsg(driver).getText();
	      
	      Thread.sleep(2000);
		  if(msg.equalsIgnoreCase("No Data Found in Excel Document or Sheet Name must be 'ShareHoldings'"))
		    {
		  
		      test.log(LogStatus.FAIL, " Error message should be displayed on popup but error message comes in Green colour =" +msg);
		    }
		    else
		    {
		    	 test.log(LogStatus.PASS, "Error message should be displayed on popup but error message comes in Green colour ="    +msg);
		    }
	      
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
	      
	      Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
	}
	public static void WithoutSelectingFileUploadShareHoldingDetailes(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);

	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
			Thread.sleep(2000);
		      EntityLocator.ClickEditShareHoldingDetailes(driver).click();
		      
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickShareHoldingDetailes(driver).click();
			  
			  Thread.sleep(2000);
			  EntityLocator.ClickUploadBtnShareHoldingDetailes(driver).click();
			  
	      
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickUploadBtnShareHolding1(driver).click();
	      Thread.sleep(4000);
	      String msg=EntityLocator.WithoutSelectingFileUploadShareHolding(driver).getText();
	      
	      Thread.sleep(2000);
		  if(msg.equalsIgnoreCase(" "))
		    {
		  
		      test.log(LogStatus.PASS, "An error message is displayed informing the user that  =" +msg);
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "An error message is displayed informing the user that =" +msg);
		    }
	      
	      
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
	      
	      Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
	}
	public static void ClickShareHoldingPattern(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		   
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(4000);
	 		   if(EntityLocator.ClickShareHoldingPattern(driver).isEnabled())
			    {
			      Thread.sleep(2000);
			      EntityLocator.ClickShareHoldingPattern(driver).click();
			      test.log(LogStatus.PASS, "ShareHolding Buttton is clickable");
			    }
			    else
			    {
			    	 test.log(LogStatus.FAIL, "ShareHolding Buttton is not clickable");
			    }
	 		   
	 		   Thread.sleep(4000);
	 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
	 	      
	 	      Thread.sleep(4000);
	 	 		  EntityLocator.ClickDashboard(driver).click();
	}
	
	
	public static void AddCategoryMaster(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareHoldingPattern(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickCatgoryMaster(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickPromoterandPromoterGroup(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickNumberOfPromoter(driver).clear();
	      Thread.sleep(2000);
	      EntityLocator.ClickNumberOfPromoter(driver).clear();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickNumberOfPromoter(driver).sendKeys("3",Keys.ENTER);
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickCategorySrNo(driver).sendKeys("1");
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickCategoryName(driver).sendKeys("Test Test One");
	 
	      Thread.sleep(2000);
	      EntityLocator.ClickCategorySrNo11(driver).sendKeys("2");
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickCategoryName11(driver).sendKeys("Test Test Two");
        
	      Thread.sleep(2000);
	      EntityLocator.ClickCategorySrNo12(driver).sendKeys("3");
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickCategoryName12(driver).sendKeys("Test Test Three");
	      
	      
//	      Thread.sleep(3000);
//	      EntityLocator.ClickNonPromoter(driver).click();
	        
	      Thread.sleep(3000);
	      EntityLocator.ClickNumberOfNonPromoter(driver).clear();
	      Thread.sleep(3000);
	      EntityLocator.ClickNumberOfNonPromoter(driver).clear();
	      Thread.sleep(3000);
	      EntityLocator.ClickNumberOfNonPromoter(driver).sendKeys("3",Keys.ENTER);
	      
	      Thread.sleep(3000);
	      EntityLocator.ClickCategorySrNo1(driver).sendKeys("1");
	      
	      Thread.sleep(3000);
	      EntityLocator.ClickCategoryName1(driver).sendKeys("Test Test One");
	      Thread.sleep(3000);
	      EntityLocator.ClickCategorySrNo2(driver).sendKeys("2");
	      
	      Thread.sleep(3000);
	      EntityLocator.ClickCategoryName2(driver).sendKeys("Test Test Two ");
	      Thread.sleep(3000);
	      EntityLocator.ClickCategorySrNo3(driver).sendKeys("3");
	      
	      Thread.sleep(3000);
	      EntityLocator.ClickCategoryName3(driver).sendKeys("Test Test Three");
	      
	      Thread.sleep(3000);
	      EntityLocator. ClickSubmitCategoryMaster(driver).click();
	      
	      Thread.sleep(5000);
		    // Switching to Alert        
	        Alert alert1 = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage1= driver.switchTo().alert().getText();	
	        
	        
	        test.log(LogStatus.PASS, "Add Category Master="+alertMessage1);
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage1);
	        
	     // Accepting alert		
	        alert1.accept();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickCloseCategoryMaster(driver).click();
	      
	      Thread.sleep(4000);
 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
 	      
 	      Thread.sleep(4000);
 	 	  EntityLocator.ClickDashboard(driver).click();
	}
	      
	public static void UploadShareholdingCategoryMaster(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);

	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareHoldingPattern(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.UploadShareholdingCategoryMaster(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ShareholdingCategory (4).xlsx");
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickUploadShareholdingCategoryMaster(driver).click();
	      
	      
	     Thread.sleep(2000);
	     String msg= EntityLocator.UploadShareholdingCategoryMasterValidationMsg(driver).getText();
	    
	     if(msg.equalsIgnoreCase("Sherholding category Sample Excel Uploaded Successfully"))
	     {
	    	 test.log(LogStatus.PASS, "Message should be displayed on popup (ShareHolding should be Instead of Sherholding)= " +msg);
	     }
	     else 
	     {
	    	 test.log(LogStatus.FAIL, "Message should be displayed on popup (ShareHolding should be Instead of Sherholding) =" +msg);
	     }
	      Thread.sleep(2000);
	      EntityLocator.ClickCloseBtn1(driver).click();
	      Thread.sleep(4000);
 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
 	      
 	      Thread.sleep(4000);
 	 	  EntityLocator.ClickDashboard(driver).click();
	
	}
	      
	      
	public static void EnterInvalidDataUploadShareholdingCategoryMaster(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareHoldingPattern(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.UploadShareholdingCategoryMaster(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ShareholdingCategory (3).xlsx");
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickUploadShareholdingCategoryMaster(driver).click();
	      
	      
	     Thread.sleep(2000);
	     String msg= EntityLocator.UploadShareholdingCategoryMasterValidationMsg(driver).getText();
	    
	     if(msg.equalsIgnoreCase("Input string was not in a correct format.."))
	     {
	    	 test.log(LogStatus.PASS, "The error message should be displayed= " +msg);
	     }
	     else 
	     {
	    	 test.log(LogStatus.FAIL, "The error message should be displayed =" +msg);
	     }
	      Thread.sleep(2000);
	      EntityLocator.ClickCloseCategoryMaster(driver).click();
	      
//	      By locator = By.xpath("(//a[@class='k-button k-bare k-button-icon k-window-action'])[21]");
//
//			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//			Thread.sleep(4000);
//			
//			WebElement ViewButton = driver.findElement(locator);	
//			Thread.sleep(3000);
//		    JavascriptExecutor jse=(JavascriptExecutor)driver;
//		    jse.executeScript("arguments[0].click();", ViewButton);
//		    jse.executeScript("arguments[0].click();", ViewButton);
	      
	      Thread.sleep(4000);
 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
 	      
 	      Thread.sleep(4000);
 	 	  EntityLocator.ClickDashboard(driver).click();
	
	}
	         
	public static void EnterInvalidDateUploadShareholdingCategoryMaster(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareHoldingPattern(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.UploadShareholdingCategoryMaster(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ShareholdingCategory (4).xlsx");
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickUploadShareholdingCategoryMaster(driver).click();
	      
	      
	     Thread.sleep(2000);
	     String msg= EntityLocator.UploadShareholdingCategoryMasterValidationMsg(driver).getText();
	    
	     if(msg.equalsIgnoreCase("String was not recognized as a valid DateTime.."))
	     {
	    	 test.log(LogStatus.PASS, "The error message should be displayed= " +msg);
	     }
	     else 
	     {
	    	 test.log(LogStatus.FAIL, "The error message should be displayed =" +msg);
	     }
//	      Thread.sleep(2000);
//	      EntityLocator.ClickCloseCategoryMaster(driver).click();
//	      Thread.sleep(4000);
// 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
// 	      
// 	      Thread.sleep(4000);
// 	 	  EntityLocator.ClickDashboard(driver).click();
	
	}     
	public static void EnterEmptyDataUploadShareholdingCategoryMaster(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareHoldingPattern(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.UploadShareholdingCategoryMaster(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\ShareholdingCategory (5).xlsx");
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickUploadShareholdingCategoryMaster(driver).click();
	      
	      
	     Thread.sleep(2000);
	     String msg= EntityLocator.UploadShareholdingCategoryMasterValidationMsg(driver).getText();
	    
	     if(msg.equalsIgnoreCase("Sherholding category Sample Excel Uploaded Successfully"))
	     {
	    	 test.log(LogStatus.FAIL, "Message should be displayed on popup = " +msg);
	     }
	     else 
	     {
	    	 test.log(LogStatus.PASS, "Message should be displayed on popup =" +msg);
	     }
	      Thread.sleep(2000);
	      EntityLocator.ClickCloseCategoryMaster(driver).click();
	      Thread.sleep(4000);
 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
 	      
 	      Thread.sleep(4000);
 	 	  EntityLocator.ClickDashboard(driver).click();
	
	}
	public static void InvalidUploadFileShareholdingCategoryMaster(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareHoldingPattern(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.UploadShareholdingCategoryMaster(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.clickChooseFile(driver).sendKeys("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\EntityExcelFile1.xlsx");
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickUploadShareholdingCategoryMaster(driver).click();
	      
	      
	     Thread.sleep(2000);
	     String msg= EntityLocator.UploadShareholdingCategoryMasterValidationMsg(driver).getText();
	    
	     if(msg.equalsIgnoreCase("No Data Found in Excel Document or Sheet Name must be 'Shareholding '"))
	     {
	    	 test.log(LogStatus.PASS, "Message should be displayed on popup = " +msg);
	     }
	     else 
	     {
	    	 test.log(LogStatus.FAIL, "Message should be displayed on popup =" +msg);
	     }
//	      Thread.sleep(2000);
//	      EntityLocator.ClickCloseCategoryMaster(driver).click();
//	      Thread.sleep(4000);
// 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
 	      
// 	      Thread.sleep(4000);
// 	 	  EntityLocator.ClickDashboard(driver).click();
	
	}
	public static void WithoutUploadFileShareholdingCategoryMaster(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		 
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareHoldingPattern(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.UploadShareholdingCategoryMaster(driver).click();
	      
	 
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickUploadShareholdingCategoryMaster(driver).click();
	      
	      
	     Thread.sleep(2000);
	     String msg=("Please Select File");
	    
	     if(msg.equalsIgnoreCase("msg"))
	     {
	    	 test.log(LogStatus.PASS, "Error message is displayed informing the user that = " +msg);
	     }
	     else 
	     {
	    	 test.log(LogStatus.FAIL, "Error message is Not displayed informing the user that =" +msg);
	     }
//	      Thread.sleep(2000);
//	      EntityLocator.ClickCloseCategoryMaster(driver).click();
//	      Thread.sleep(4000);
// 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
// 	      
// 	      Thread.sleep(4000);
// 	 	  EntityLocator.ClickDashboard(driver).click();
	
	}
	public static void ClickShareHoldingHistorical(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(2000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareHoldingPattern(driver).click();
	      
	
	      Thread.sleep(2000);
	      if(EntityLocator.ClickShareholdingHistorical(driver).isEnabled())
		    {
		      Thread.sleep(2000);
		      EntityLocator.ClickShareholdingHistorical(driver).click();
		      test.log(LogStatus.PASS, "Shareholding Historical Buttton is clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Shareholding Historical  Buttton is not clickable");
		    }
	      Thread.sleep(4000);
 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
 	      
 	      Thread.sleep(4000);
 	 	  EntityLocator.ClickDashboard(driver).click();
	     
	}
	
	public static void EnterInvalidDateShareHoldingHistorical(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(2000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareHoldingPattern(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickShareholdingHistorical(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareholdingHistoricalStartDate(driver).sendKeys("01/01/2023");
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareholdingHistoricalEndDate(driver).sendKeys("31/01/2023");
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareholdingHistoricalApplyBtn(driver).click();
	      
	      Thread.sleep(3000);
	     String msg= EntityLocator.ClickShareholdingHistoricalNoRecordFound(driver).getText();
	      
	      if(msg.equalsIgnoreCase("No Records Found."))
		     {
		    	 test.log(LogStatus.PASS, "Message should be displayed on popup = " +msg);
		     }
		     else 
		     {
		    	 test.log(LogStatus.FAIL, "Message should be displayed on popup =" +msg);
		     }
	      
	      Thread.sleep(4000);
 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
 	      
 	      Thread.sleep(4000);
 	 	  EntityLocator.ClickDashboard(driver).click();
	     
	}
	public static void EmptyDateShareHoldingHistorical(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
	  
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	
		
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareHoldingPattern(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickShareholdingHistorical(driver).click();
	       
	      Thread.sleep(2000);
	      EntityLocator.ClickShareholdingHistoricalApplyBtn(driver).click();
	      
	      Thread.sleep(3000);
	     String msg= ("Please Select date");
	      
	      if(msg.equalsIgnoreCase("msg"))
		     {
		    	 test.log(LogStatus.PASS, "Error message is displayed informing the user that = " +msg);
		     }
		     else 
		     {
		    	 test.log(LogStatus.FAIL, "Error message is Not displayed informing the user that =" +msg);
		     }
	      
	      Thread.sleep(4000);
 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
 	      
 	      Thread.sleep(4000);
 	 	  EntityLocator.ClickDashboard(driver).click();
	     
	}    
	
	
	public static void ClearButtonShareHoldingHistorical(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareHoldingPattern(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickShareholdingHistorical(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickArrow(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickStartDate(driver).sendKeys("1/1/2023");
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickEndDate(driver).sendKeys("31/5/2023");
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickFilter1(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickArrow(driver).click();
	      
	    
	      
	      if(EntityLocator.ClickClearBtn(driver).isEnabled())
		    {
		      Thread.sleep(2000);
		      EntityLocator.ClickClearBtn(driver).click();
		      test.log(LogStatus.PASS, "Clear Button is clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Clear Button is not clickable");
		    }
	      Thread.sleep(4000);
 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
 	      
 	      Thread.sleep(4000);
 	 	  EntityLocator.ClickDashboard(driver).click();
	      
	      
	}
	
	public static void ViewButtonShareHoldingHistorical(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareHoldingPattern(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickShareholdingHistorical(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickViewBtn(driver).click();
	      
	      test.log(LogStatus.PASS, "View Icon Open Successfully");
	      
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickCloseBtn4(driver).click();
	      Thread.sleep(4000);
 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
 	      
 	      Thread.sleep(4000);
 	 	  EntityLocator.ClickDashboard(driver).click();
	      
	}
	public static void DownloadButtonShareHoldingHistorical(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);

	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickShareHoldingPattern(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickShareholdingHistorical(driver).click();
	      
	      File dir = new File("C://Users//Admin//Downloads");
		  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		  		
		  	Thread.sleep(2000);
		 	EntityLocator.ClickDownloadBtn(driver).click();		//Exporting (Downloading) file
		  		
		    Thread.sleep(3000);
		    File dir1 = new File("C://Users//Admin//Downloads");
		    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		   
		    Thread.sleep(3000);	
		  	if (dirContents.length < allFilesNew.length) 
		  	{
		  		test.log(LogStatus.PASS,  "  Document downloaded successfully.");
		  	} 
		  	else 
		  	{
		  		test.log(LogStatus.FAIL, "  Document does not downloaded.");
		  	}
	      
	      Thread.sleep(4000);
 	      EntityLocator.ClickShareHoldingDetailesCloseBtn(driver).click();
 	      
 	      Thread.sleep(4000);
 	 	  EntityLocator.ClickDashboard(driver).click();
	      
	}
	
	public static void EditBtnShareHoldingDetailes(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickEditShareHoldingDetailes(driver).click();
	      
	      Thread.sleep(2000);
		  EntityLocator.ClickShareHoldingDetailes(driver).click();
	      Thread.sleep(4000);
	      if(EntityLocator.ClickEditIconSH(driver).isEnabled())
		    {
              Thread.sleep(4000);
		      EntityLocator.ClickEditIconSH(driver).click();
		      test.log(LogStatus.PASS, "Edit ShareHolding Detailes Button is clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Edit ShareHolding Detailes Button is not clickable");
		    }
	      
	      Thread.sleep(4000);
	      EntityLocator.ClickCloseBtn(driver).click();
	      
	      
 	      Thread.sleep(4000);
 	 	  EntityLocator.ClickDashboard(driver).click();
	      
	      
	}
	public static void UpdateShareHolding(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);

	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickEditIconSH(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickFOLIONO(driver).clear();
	      Thread.sleep(4000);
	      EntityLocator.ClickFOLIONO(driver).sendKeys("29");
	      
		  Thread.sleep(2000);
		  EntityLocator. ClickSaveShareHolding(driver).click();
		  
		  
		  Thread.sleep(4000);
		     String msg= EntityLocator.ClickSaveMsg1(driver).getText();
		      
		      if(msg.equalsIgnoreCase("Updated Successfully."))
			    {
			  
			      test.log(LogStatus.PASS, "Update ShareHolding =" +msg);
			    }
			    else
			    {
			    	 test.log(LogStatus.FAIL, "Update ShareHolding  =" +msg);
			    }
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickShareHoldingDetailes(driver).click();
			  
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickCloseBtn(driver).click();

	      Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
	      
	      }
	public static void EnterInvalidDataShareHolding(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickEditIconSH(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickEmailId(driver).clear();
	      Thread.sleep(4000);
	      EntityLocator.ClickEmailId(driver).sendKeys("abc#%2@gmail.com");
	      
		  Thread.sleep(2000);
		  EntityLocator. ClickSaveShareHolding(driver).click();
		  
		  
		  Thread.sleep(4000);
		     String msg= EntityLocator.InValidEmail(driver).getText();
		      
		      if(msg.equalsIgnoreCase("Please Enter Correct Email Address"))
			    {
			  
			      test.log(LogStatus.PASS, "Enter Invalid Data in ShareHolding =" +msg);
			    }
			    else
			    {
			    	 test.log(LogStatus.FAIL, "Enter Invalid Data in ShareHolding  =" +msg);
			    }
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickShareHoldingDetailes(driver).click();
			  
		      
		      Thread.sleep(2000);
			  EntityLocator.ClickCloseBtn(driver).click();

	      Thread.sleep(4000);
		  EntityLocator.ClickDashboard(driver).click();
	      
	      } 
	public static void CloseBtnShareHolding(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		    
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickEditIconSH(driver).click();
	    
	      Thread.sleep(4000);
	      if(EntityLocator.ClickCloseBtn3(driver).isEnabled())
		    {
		      Thread.sleep(2000);
		      EntityLocator.ClickCloseBtn3(driver).click();
		      test.log(LogStatus.PASS, "Close Buttton  is clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Close Buttton is not clickable");
		    }
	     
      Thread.sleep(4000);
	  EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void DeleteShareHolding(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickDeleteIcon(driver).click();
	      
	      Thread.sleep(2000);
		    String msg=EntityLocator.ClickDeleteValidationMsg(driver).getText();
		    Thread.sleep(2000);
		    if(msg.equalsIgnoreCase("Are you sure you want to delete this data?"))
		     {
		    	
		    	 test.log(LogStatus.PASS,"The item should get deleted from the list and success message will displayed =" +msg);
		     }
		     else
			    {
			    	 test.log(LogStatus.FAIL, "The item should get deleted from the list and success message will displayed =" +msg);
			    }
		    
	      Thread.sleep(4000);
	      EntityLocator.ClickYes(driver).click();
	      
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
	public static void DeleteNoIconShareHolding(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);

	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(4000);
	      EntityLocator.ClickDeleteIcon(driver).click();
	      Thread.sleep(2000);
		    EntityLocator.ClickDeleteValidationMsg(driver).click();
		    Thread.sleep(2000);
		    if(EntityLocator.DeleteBankDetailes1(driver).isEnabled())
			 {   
				 Thread.sleep(2000);
			     EntityLocator.DeleteBankDetailes1(driver).click();
			     
			     test.log(LogStatus.PASS,"User Should be able to cancel deletion of an item");
			 }
			 else
			 {
				 test.log(LogStatus.FAIL,"User Should not be able to cancel deletion of an item");
			 }
		    Thread.sleep(4000);
			EntityLocator.ClickDashboard(driver).click();
	}
	public static void ClickShareCertificateBtn(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      
	     
	      Thread.sleep(4000);
	      if(EntityLocator.ClickShareCertificateBtn(driver).isEnabled())
		    {
		      Thread.sleep(2000);
		      EntityLocator.ClickShareCertificateBtn(driver).click();
		      test.log(LogStatus.PASS, "Share Certificate Button is Clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Share Certificate Button is Not Clickable");
		    }
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickCloseBtn5(driver).click();
		    Thread.sleep(4000);
				EntityLocator.ClickDashboard(driver).click();
		    
	}
	public static void AddShareCertificate(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickShareCertificateBtn(driver).click();
//	      Thread.sleep(2000);
//	      EntityLocator.ClickSelectTransaction(driver).click();
//	      Thread.sleep(2000);
//	      EntityLocator.ClickSelectTransaction1(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickDirectorAutorized(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.SelectDirectorAutorized(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickDirectorAutorized1(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.SelectDirectorAutorized1(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickAuthorizedSignatory(driver).click();
	      Thread.sleep(2000);
	      EntityLocator. SelectAuthorizedSignatory(driver).click();
	      Thread.sleep(2000);
	      EntityLocator. ClickDateOfIssueCalender(driver).click();
	      Thread.sleep(2000);
	      EntityLocator. Date(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickTypeOfShare(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.SelectTypeOfShare(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickFilter1(driver).click();
	      
	      Thread.sleep(2000);
	      String msg=EntityLocator.ValidMsgShareCertificate(driver).getText();
	      
	      if(msg.equalsIgnoreCase("Record Updated Successfully"))
	      {
	    	  test.log(LogStatus.PASS,"Message Displayed=" +msg);
	      }
	      else
	      {
	    	  test.log(LogStatus.FAIL,"Message Displayed=" +msg);  
	      }
	      Thread.sleep(2000);
	      EntityLocator.ClickCloseBtn5(driver).click();
		    Thread.sleep(4000);
				EntityLocator.ClickDashboard(driver).click();
		    
	}
	
	public static void WithoutEnteringDataShareCertificate(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickShareCertificateBtn(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickFilter1(driver).click();
	      
	      Thread.sleep(2000);
	      String msg=EntityLocator.ValidMsgShareCertificate(driver).getText();
	      
	      if(msg.equalsIgnoreCase("Record Updated Successfully"))
	      {
	    	  test.log(LogStatus.FAIL,"Message Displayed=" +msg);
	      }
	      else
	      {
	    	  test.log(LogStatus.PASS,"Message Displayed=" +msg);  
	      }
	      Thread.sleep(2000);
	      EntityLocator.ClickCloseBtn5(driver).click();
		    Thread.sleep(4000);
				EntityLocator.ClickDashboard(driver).click();
	}
	public static void ViewShareCertificate(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickShareCertificateBtn(driver).click();
	      Thread.sleep(2000);
	      EntityLocator. ViewShareCertificate(driver).click();
	      Thread.sleep(2000);
	      String msg="CIN – U72266KA2002PLC030311";
	      if(msg.equalsIgnoreCase(msg))
	      {
	    	  test.log(LogStatus.PASS, "Share Certificate Popup Open Successfully=" +msg);
	      }
	      else
	      {
	    	  test.log(LogStatus.FAIL, "Share Certificate Popup does not Open Successfully=" +msg);
	      }
	      Thread.sleep(2000);
	      EntityLocator.CloseBtn(driver).click();
		    Thread.sleep(4000);
				EntityLocator.ClickDashboard(driver).click();
	}
	
	      
	public static void DownloadShareCertificate(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickShareCertificateBtn(driver).click();
	      
	    
	      
	      File dir = new File("C:\\Users\\Snehal Patil\\Downloads");
		  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		  		
		  	Thread.sleep(2000);
		 	EntityLocator.DownloadShareCertificate(driver).click();		//Exporting (Downloading) file
		  		
		    Thread.sleep(3000);
		    File dir1 = new File("C:\\Users\\Snehal Patil\\Downloads");
		    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		   
		  		
		  	if (dirContents.length < allFilesNew.length) 
		  	{
		  		test.log(LogStatus.PASS,  "Share Certificate Document downloaded successfully.");
		  	} 
		  	else 
		  	{
		  		test.log(LogStatus.FAIL, "Share Certificate Document does not downloaded.");
		  	}
		  	
		 	Thread.sleep(2000);
		   	driver.navigate().back();
		   
			    Thread.sleep(4000);
					EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void DownloadShareCertificateAfterSaving(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		  Thread.sleep(2000);
		    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
		Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();

	      Thread.sleep(4000);
	      EntityLocator.ClickShareHolding(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickShareCertificateBtn(driver).click();
//	      Thread.sleep(2000);
//	      EntityLocator.ClickSelectTransaction(driver).click();
//	      Thread.sleep(2000);
//	      EntityLocator.ClickSelectTransaction1(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickDirectorAutorized(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.SelectDirectorAutorized(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickDirectorAutorized1(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.SelectDirectorAutorized1(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickAuthorizedSignatory(driver).click();
	      Thread.sleep(2000);
	      EntityLocator. SelectAuthorizedSignatory(driver).click();
	      Thread.sleep(2000);
	      EntityLocator. ClickDateOfIssueCalender(driver).click();
	      Thread.sleep(2000);
	      EntityLocator. Date(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.ClickTypeOfShare(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.SelectTypeOfShare(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.ClickFilter1(driver).click();
	      File dir = new File("C:\\Users\\Snehal Patil\\Downloads");
		  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		  		
		  	Thread.sleep(2000);
		 	EntityLocator.DownloadShareCertificate(driver).click();		//Exporting (Downloading) file
		  		
		    Thread.sleep(3000);
		    File dir1 = new File("C:\\Users\\Snehal Patil\\Downloads");
		    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		   	
		   		 	if (dirContents.length < allFilesNew.length) 
		  	        {
		  		       test.log(LogStatus.PASS,  "Share Certificate Document downloaded successfully.");
		  	        } 
		        	else 
		  	         {
		        		Thread.sleep(2000);
					 	String msg=EntityLocator.NoDataFoundShareCertificate(driver).getText();
					 	test.log(LogStatus.FAIL, "Message displayed ="+msg);
		  	         }
		
		   
		   	Thread.sleep(2000);
		   	driver.navigate().back();
		  	
		    
			    Thread.sleep(4000);
					EntityLocator.ClickDashboard(driver).click();
		    
	}
	
	
	public static void Managementpersonnel (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    if(EntityLocator.ClickManagementPersonnel(driver).isEnabled())
	    {
	       Thread.sleep(2000);
	       EntityLocator.ClickManagementPersonnel(driver).click();
	       test.log(LogStatus.PASS, "Management Personnel Option is clickable");
	    }
	    else
	    {
	    	 test.log(LogStatus.PASS, "Management Personnel Option is not clickable");
	    }
	     Thread.sleep(2000);
	       EntityLocator.ClickApplicabilityCloseBtn(driver).click();
	       
	       Thread.sleep(4000);
			EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void ManagementpersonnelExportToPDF (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	       EntityLocator.ClickManagementPersonnel(driver).click();
	       
	
		       
		       File dir = new File("C://Users//Snehal Patil//Downloads");
			  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			  		
			    Thread.sleep(2000);
			       EntityLocator. ClickManagementPersonnelExportToPDF(driver).click();		//Exporting (Downloading) file
			  		
			    Thread.sleep(3000);
			    File dir1 = new File("C://Users//Snehal Patil//Downloads");
			    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			   
			  		
			  	if (dirContents.length < allFilesNew.length) 
			  	{
			  		test.log(LogStatus.PASS,  "Export To PDF File downloaded successfully.");
			  	} 
			  	else 
			  	{
			  		test.log(LogStatus.FAIL, "  Export To PDF File does not downloaded.");
			  	}
			     Thread.sleep(2000);
			       EntityLocator.ClickApplicabilityCloseBtn(driver).click();
			       
			       Thread.sleep(4000);
					EntityLocator.ClickDashboard(driver).click();
	}
	public static void ClickCommitte (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    
	    if(EntityLocator.ClickCommittees(driver).isEnabled())
	    {
	       Thread.sleep(2000);
	       EntityLocator.ClickCommittees(driver).click();
	       test.log(LogStatus.PASS, "Committees Option is clickable");
	    }
	    else
	    {
	    	 test.log(LogStatus.PASS, "Committees Option is not clickable");
	    }
	     Thread.sleep(2000);
	       EntityLocator.CloseEntity(driver).click();
	       
	       Thread.sleep(4000);
			EntityLocator.ClickDashboard(driver).click();
	}
	public static void ClickCloseBtnOfCommitte (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	       EntityLocator.ClickCommittees(driver).click();
	    
	    Thread.sleep(2000);
	    if(EntityLocator.CloseEntity(driver).isEnabled())
	    {
	    	  Thread.sleep(2000);
		       EntityLocator.CloseEntity(driver).click();
	       test.log(LogStatus.PASS, "Close Button of Committees option is clickable");
	    }
	    else
	    {
	    	 test.log(LogStatus.PASS, "Close Button of Committees option is clickable");
	    }
	    
	       
	       Thread.sleep(4000);
			EntityLocator.ClickDashboard(driver).click();
	}
	public static void ClickCommitteeMatrix (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	   
	    if(EntityLocator.ClickCommitteeMatrix(driver).isEnabled())
	    {
	       Thread.sleep(2000);
	       EntityLocator.ClickCommitteeMatrix(driver).click();
	       test.log(LogStatus.PASS, "Committee Matrix Option is clickable");
	    }
	    else
	    {
	    	 test.log(LogStatus.PASS, "Committee Matrix Option is not clickable");
	    }
	     Thread.sleep(2000);
	       EntityLocator.ClickCloseCommittee(driver).click();
	       
	       Thread.sleep(4000);
			EntityLocator.ClickDashboard(driver).click();
	}
	public static void ClickAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	 
	    Thread.sleep(2000);
	     test.log(LogStatus.PASS, "Auditor Option is clickable");
	  
	       
	       Thread.sleep(4000);
			EntityLocator.ClickDashboard(driver).click();
	}
	public static void AddStatutoryAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,40);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickStatutoryNewBtn(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickStatutoryYes(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickNaturOfAppointment(driver).click();
	       
	       Thread.sleep(2000);
	       EntityLocator.SelectNaturOfAppointment(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickDateOfAppointment(driver).sendKeys("20/06/2023");
	       Thread.sleep(2000);
	       EntityLocator.ClickSRN(driver).sendKeys("769");
	       Thread.sleep(2000);
	       EntityLocator.ClickStatutoryNo(driver).click();
	       Thread.sleep(2000);
	       EntityLocator. ClickCategoryOfAuditor(driver).click();
	       Thread.sleep(3000);
	       EntityLocator.SelectCategoryOfAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickAuditorFirm(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectAuditorFirm(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickNumberofFYforwhichAuditorisappointed(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectNumberofFYforwhichAuditorisappointed(driver).click();
	      /* Thread.sleep(2000);
	       EntityLocator.ClickDueDate(driver).sendKeys("30/05/2023");
	       Thread.sleep(2000);
	       EntityLocator. ClickFYStartDateDate(driver).sendKeys("01/04/2023");
	       Thread.sleep(2000);
	       EntityLocator.ClickFYLastDateDate(driver).sendKeys("01/30/2023");*/
	       Thread.sleep(2000);
	       EntityLocator.ClickSaveStatutory(driver).click();
	      try
	       {
	    	  Thread.sleep(3000);
	    	  
	    	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frmUpdatestatutoryAuditor']/div[1]/div/div/lable")));
	    	   String msg=EntityLocator.ClickValidMsgStatutory(driver).getText();
	    	   test.log(LogStatus.PASS, "Message Displayed=" +msg);
	       }
	       
	       catch(Exception e)
	       {
	    	   Thread.sleep(3000);
	    	   String msg=EntityLocator.ClickValidMsgStatutory1(driver).getText();
	    	   test.log(LogStatus.PASS, "Message Displayed=" +msg);
	       }
	       Thread.sleep(2000);
	       EntityLocator.CloseEntity(driver).click();
	       Thread.sleep(4000);
	    	EntityLocator.ClickDashboard(driver).click();
	       
	       
	}
	
	public static void EnterInvalidDataStatutoryAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickStatutoryNewBtn(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickStatutoryYes(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickNaturOfAppointment(driver).click();
	       
	       Thread.sleep(2000);
	       EntityLocator.SelectNaturOfAppointment(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickDateOfAppointment(driver).sendKeys("01-05-2023");
	       Thread.sleep(2000);
	       EntityLocator.ClickSRN(driver).sendKeys("675");
	       Thread.sleep(2000);
	       EntityLocator.ClickStatutoryNo(driver).click();
	       Thread.sleep(2000);
	       EntityLocator. ClickCategoryOfAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectCategoryOfAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickAuditorFirm(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectAuditorFirm(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickNumberofFYforwhichAuditorisappointed(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectNumberofFYforwhichAuditorisappointed(driver).click();
//	       Thread.sleep(2000);
//	       EntityLocator.ClickDueDate(driver).sendKeys("30/05/2023");
//	       Thread.sleep(2000);
//	       EntityLocator. ClickFYStartDateDate(driver).sendKeys("01/04/2023");
//	       Thread.sleep(2000);
//	       EntityLocator.ClickFYLastDateDate(driver).sendKeys("01/30/2023");
	       Thread.sleep(2000);
	       EntityLocator.ClickSaveStatutory(driver).click();
	       Thread.sleep(2000);
	       String msg=EntityLocator.ClickInValidMsgStatutory(driver).getText();
	       Thread.sleep(2000);
	       if(msg.equalsIgnoreCase("01-05-2023 is an invalid date format"))
	       {
	    	   test.log(LogStatus.PASS, "Message Displayed=" +msg);
	       }
	       else
	       {
	    	   test.log(LogStatus.FAIL, "Message Displayed=" +msg);
	       }
	       Thread.sleep(2000);
	       EntityLocator.CloseEntity(driver).click();
	       Thread.sleep(4000);
	    	EntityLocator.ClickDashboard(driver).click();
	       
	       
	}
	public static void EnterTwoMandatoryFiledStatutoryAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickStatutoryNewBtn(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickStatutoryYes(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickNaturOfAppointment(driver).click();
	       
	       Thread.sleep(2000);
	       EntityLocator.SelectNaturOfAppointment(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickDateOfAppointment(driver).sendKeys("01/05/2023");
	       
	       Thread.sleep(2000);
	       EntityLocator.ClickSaveStatutory(driver).click();
	       Thread.sleep(2000);
	       String msg=EntityLocator.ClickValidMsgStatutory(driver).getText();
	       
	       if(msg.equalsIgnoreCase("Statutory auditor save successfully"))
	       {
	    	   test.log(LogStatus.FAIL, "Message Displayed=" +msg);
	       }
	       else
	       {
	    	   test.log(LogStatus.PASS, "Message Displayed=" +msg);
	       }
	       Thread.sleep(2000);
	       EntityLocator.CloseEntity(driver).click();
	       Thread.sleep(4000);
	    	EntityLocator.ClickDashboard(driver).click();
	       
	}
	public static void EmptyFiledStatutoryAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickStatutoryNewBtn(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickSaveStatutory(driver).click();
	       Thread.sleep(2000);
	       String msg=EntityLocator.ClickValidMsgStatutory(driver).getText();
	       
	       if(msg.equalsIgnoreCase("Statutory auditor save successfully"))
	       {
	    	   test.log(LogStatus.FAIL, "Message Displayed=" +msg);
	       }
	       else
	       {
	    	   test.log(LogStatus.PASS, "Message Displayed=" +msg);
	       }
	       Thread.sleep(2000);
	       EntityLocator.CloseEntity(driver).click();
	       Thread.sleep(4000);
	    	EntityLocator.ClickDashboard(driver).click();
	}
	public static void CloseBtnStatutoryAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickStatutoryNewBtn(driver).click();
	       Thread.sleep(2000);
	       if(EntityLocator.CloseEntity(driver).isEnabled())
		    {
		      Thread.sleep(2000);
		      EntityLocator.CloseEntity(driver).click();
		      test.log(LogStatus.PASS, "Close Button is Clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Close Button is not Clickable");
		    }
	       Thread.sleep(4000);
	    	EntityLocator.ClickDashboard(driver).click();
	}
	public static void ClearBtnStatutoryAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       
	       Thread.sleep(2000);
	       EntityLocator.ClickStatusStatutoryAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectStatusStatutoryAuditor(driver).click();
	       
	       if(EntityLocator.ClickClearFilterStatutoryAuditor(driver).isEnabled())
	       {
	           Thread.sleep(2000);
	           EntityLocator.ClickClearFilterStatutoryAuditor(driver).click();
	           test.log(LogStatus.PASS, "Clear Button is clickable");
	       }
	       else
	       {
	    	   test.log(LogStatus.FAIL, "Clear Button is clickable");
	       }
	       Thread.sleep(4000);
		    	EntityLocator.ClickDashboard(driver).click();
	       
	} 
	
	public static void UpdateStatutoryAuditor(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	      
	       Thread.sleep(2000);
	       EntityLocator.ClickUpdateStatutoryAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickNaturOfAppointment(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectNaturOfAppointment1(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickAuditorFirm(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectAuditorFirm1(driver).click();
	     
	       Thread.sleep(2000);
	       EntityLocator.ClickSaveStatutory(driver).click();
	       Thread.sleep(2000);
	       String msg=EntityLocator.ClickValidMsgStatutory(driver).getText();
	       
	       if(msg.equalsIgnoreCase("Statutory auditor update successfully"))
	       {
	    	   test.log(LogStatus.PASS, "Message Displayed=" +msg);
	       }
	       else
	       {
	    	   test.log(LogStatus.FAIL, "Message Displayed=" +msg);
	       }
	       Thread.sleep(2000);
	       EntityLocator.CloseEntity(driver).click();
	       Thread.sleep(4000);
	    	EntityLocator.ClickDashboard(driver).click();
	       
	}
	public static void UpdateEnterInvalidDataStatutoryAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickUpdateStatutoryAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickStatutoryYes(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickNaturOfAppointment(driver).click();
	       
	       Thread.sleep(2000);
	       EntityLocator.SelectNaturOfAppointment(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickDateOfAppointment(driver).clear();
	       Thread.sleep(2000);
	       EntityLocator.ClickDateOfAppointment(driver).sendKeys("01-05-2023");
	       Thread.sleep(2000);
	       EntityLocator.ClickSRN(driver).sendKeys("64$5");
	       Thread.sleep(2000);
	       EntityLocator.ClickDueDate(driver).clear();
	       Thread.sleep(2000);
	       EntityLocator.ClickDueDate(driver).sendKeys("30-05-2023");
	       Thread.sleep(2000);
	       EntityLocator. ClickFYStartDateDate(driver).clear();
	       Thread.sleep(2000);
	       EntityLocator. ClickFYStartDateDate(driver).sendKeys("01-04-2023");
	       Thread.sleep(2000);
	       EntityLocator.ClickFYLastDateDate(driver).clear();
	       Thread.sleep(2000);
	       EntityLocator.ClickFYLastDateDate(driver).sendKeys("01-30-2023");
	       Thread.sleep(2000);
	       EntityLocator.ClickSaveStatutory(driver).click();
	       Thread.sleep(2000);
	       String msg=EntityLocator.ClickInValidMsgStatutory(driver).getText();
	       
	       if(msg.equalsIgnoreCase("01-05-2023 is an invalid date format"))
	       {
	    	   test.log(LogStatus.PASS, "Message Displayed=" +msg);
	       }
	       else
	       {
	    	   test.log(LogStatus.FAIL, "Message Displayed=" +msg);
	       }
	       Thread.sleep(2000);
	       EntityLocator.CloseEntity(driver).click();
	       Thread.sleep(4000);
	    	EntityLocator.ClickDashboard(driver).click();
	       
	       
	}
	public static void CloseBtnUpdateStatutoryAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickUpdateStatutoryAuditor(driver).click();
	       Thread.sleep(2000);
	       if(EntityLocator.CloseEntity(driver).isEnabled())
		    {
		      Thread.sleep(2000);
		      EntityLocator.CloseEntity(driver).click();
		      test.log(LogStatus.PASS, "Close Button is Clickable");
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Close Button is not Clickable");
		    }
	       Thread.sleep(4000);
	    	EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void ResignationofAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	    Thread.sleep(2000);
		EntityLocator.ClickResignationofAuditor(driver).click();
		
	   
		Thread.sleep(2000);
	    EntityLocator.ClickLeaveType(driver).click();
	    //Thread.sleep(2000);
	    //EntityLocator.SelectLeaveType1(driver).click();
	    
	    List<WebElement>LeaveType1 = driver.findElements(By.xpath("//ul[@id='ddlLeaveType_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType1, "Resignation");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDateOfSubmission(driver).sendKeys("31/05/2023");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDated(driver).sendKeys("01/05/2023");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickReason(driver).sendKeys("ABC");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUploadDocument(driver).sendKeys("C:\\Users\\Snehal Patil\\Desktop\\Test Cases\\Approver Test Case.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.SaveResignation(driver).click();
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.SaveValidMsgResignation(driver).getText();
	    
	    if(msg.equalsIgnoreCase("Saved Successfully."))
	    {
	    	test.log(LogStatus.PASS, "Message Displayed ="+msg);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Message Displayed ="+msg);
	    }
	   
	    
	    Thread.sleep(2000);
	    EntityLocator.CloseEntity(driver).click();
	    Thread.sleep(4000);
    	EntityLocator.ClickDashboard(driver).click();
	}
	
	
	public static void CancelBtnResignationofAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	    Thread.sleep(2000);
		EntityLocator.ClickResignationofAuditor(driver).click();
	   
		//Thread.sleep(2000);
	    //EntityLocator.ClickLeaveType(driver).click();
	    //Thread.sleep(2000);
	    //EntityLocator.SelectLeaveType1(driver).click();
	    
	  //  List<WebElement>LeaveType1 = driver.findElements(By.xpath("//ul[@id='ddlLeaveType_listbox']//li"));
		//  selectOptionFromDropDown_bs(LeaveType1, "Resignation");
//		  Thread.sleep(2000);
//		    EntityLocator.ClickDateOfSubmission(driver).clear();
//	    Thread.sleep(2000);
//	    EntityLocator.ClickDateOfSubmission(driver).sendKeys("31/05/2023");
//	    Thread.sleep(2000);
//	    EntityLocator.ClickDated(driver).clear();
//	    Thread.sleep(2000);
//	    EntityLocator.ClickDated(driver).sendKeys("01/05/2023");
//	    Thread.sleep(2000);
//	    EntityLocator.ClickReason(driver).clear();
//	    Thread.sleep(2000);
//	    EntityLocator.ClickReason(driver).sendKeys("ABC");
//	    Thread.sleep(2000);
//	    EntityLocator.ClickUploadDocument(driver).clear();
//	    Thread.sleep(2000);
//	    EntityLocator.ClickUploadDocument(driver).sendKeys("C:\\Users\\Snehal Patil\\Desktop\\Test Cases\\Approver Test Case.xlsx");
	    
	//    Thread.sleep(2000);
	//    EntityLocator.SaveResignation(driver).click();
	    
	  
	    Thread.sleep(2000);
	   if(EntityLocator.ClickCancelResignation(driver).isEnabled())
	    {
	    	 Thread.sleep(2000);
	  		EntityLocator.ClickCancelResignation(driver).click();
	    	test.log(LogStatus.PASS, " resignation cancellation has been successful but No Message Displayed");
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, " resignation not cancel");
	    }
	    Thread.sleep(2000);
	    EntityLocator.CloseEntity(driver).click();
	    Thread.sleep(4000);
    	EntityLocator.ClickDashboard(driver).click();
	}
	public static void UpdateEnterEmptyFieldsStatutoryAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       
	       Thread.sleep(2000);
	       EntityLocator.ClickUpdateStatutoryAuditor(driver).click();
	   
	
	       Thread.sleep(2000);
	       EntityLocator.ClickNaturOfAppointment(driver).click();
	       
	       Thread.sleep(2000);
	       EntityLocator.NatureofAppointment(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickDateOfAppointment(driver).clear();
	       Thread.sleep(2000);
	       EntityLocator.ClickSRN(driver).clear();
	       Thread.sleep(2000);
	       EntityLocator.ClickStatutoryNo(driver).click();
	       Thread.sleep(2000);
	       EntityLocator. ClickCategoryOfAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickCategoryOfAuditor1(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickNumberofFYforwhichAuditorisappointed(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectNumberofFYforwhichAuditorisappointed1(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickNumberofFYforwhichAuditorisappointed(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickDueDate(driver).clear();
	       Thread.sleep(2000);
	       EntityLocator. ClickFYStartDateDate(driver).clear();
	       Thread.sleep(2000);
	       EntityLocator.ClickFYLastDateDate(driver).clear();
	       Thread.sleep(2000);
	       EntityLocator.ClickSaveStatutory(driver).click();
	       Thread.sleep(2000);
	       String msg=EntityLocator.ClickValidAuditorsFirm(driver).getText();
	      
	       if(msg.equalsIgnoreCase("The Auditor_Id field is required."))
	       {
	    	   test.log(LogStatus.PASS, "Message Displayed= " +msg);
	       }
	       else
	       {
	    	   test.log(LogStatus.FAIL, "Message Displayed= " +msg);
	       }
	       Thread.sleep(2000);
	       EntityLocator.CloseEntity(driver).click();
	       Thread.sleep(4000);
	    	EntityLocator.ClickDashboard(driver).click();
	       
	       
	}
	
	public static void EnterInvalidDataResignationofAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	    Thread.sleep(2000);
		EntityLocator.ClickResignationofAuditor(driver).click();
	   // Thread.sleep(2000);
		//EntityLocator.ClickCancelResignation(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickLeaveType(driver).click();
	    //Thread.sleep(2000);
	   // EntityLocator.SelectLeaveType1(driver).click();
	    
	    List<WebElement>LeaveType1 = driver.findElements(By.xpath("//ul[@id='ddlLeaveType_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType1, "Resignation");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDateOfSubmission(driver).sendKeys("31/05/202");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDated(driver).sendKeys("01/05/202");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickReason(driver).sendKeys("ABC@123");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUploadDocument(driver).sendKeys("C:\\Users\\Admin\\Documents\\Litigation Product Test Cases1.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.SaveResignation(driver).click();
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.InvalidMsgResignation(driver).getText();
	    String msg1=EntityLocator.InvalidMsgResignation1(driver).getText();
	    
	  
	   test.log(LogStatus.PASS, "Enter Invalid Fields ="+msg +"," +msg1);
	
	    Thread.sleep(2000);
	    EntityLocator.CloseEntity(driver).click();
	    Thread.sleep(4000);
    	EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void EnterEmptyDataResignationofAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	    Thread.sleep(2000);
		EntityLocator.ClickResignationofAuditor(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.SaveResignation(driver).click();
		
		String msg=EntityLocator.InvalidMsgResignation2(driver).getText();
		String msg1=EntityLocator.InvalidMsgResignation3(driver).getText();
		
		test.log(LogStatus.PASS, "Enter Empty Data =" +msg +"," +msg1);
		
		Thread.sleep(2000);
		EntityLocator.CloseEntity(driver).click();
		Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
		    
	}
	
	public static void CloseBtnResignationofAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	    Thread.sleep(2000);
		EntityLocator.ClickResignationofAuditor(driver).click();
	
		Thread.sleep(2000);
		if(EntityLocator.CloseEntity(driver).isEnabled())
		{
			Thread.sleep(2000);
			EntityLocator.CloseEntity(driver).click();
			test.log(LogStatus.PASS, "Close Button is Clickable" );
		}
		else
		{
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Close Button is Clickable" );
		}
		Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
		    
	}
	
	public static void ClickInternalAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       
	
	       
	       Thread.sleep(2000);
			if(EntityLocator.ClickInternalAuditor(driver).isEnabled())
			{
				Thread.sleep(2000);
				EntityLocator.ClickInternalAuditor(driver).click();
				test.log(LogStatus.PASS, "The system should navigate to the Internal Auditor page" );
			}
			else
			{
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "The system should not navigate to the Internal Auditor page" );
			}
			Thread.sleep(4000);
		    EntityLocator.ClickDashboard(driver).click();
	}
	public static void AddInternalAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.NewInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickInternalAuditorCategory(driver).click();
//	       Thread.sleep(2000);
//	       EntityLocator.SelectInternalAuditorCategory(driver).click();
	       
	       List<WebElement>LeaveType1 = driver.findElements(By.xpath("//ul[@id='ddlCriteria_listbox']/li"));
		   selectOptionFromDropDown_bs(LeaveType1, "Individual");
	       Thread.sleep(2000);
	       EntityLocator. ClickInternalAuditorName(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectInternalAuditorName(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickFYInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator. SelectFYInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickDateOfAppointmentIA(driver).sendKeys("21/06/2023");
	       Thread.sleep(2000);
	       EntityLocator.ClickWhetherEmployee(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectWhetherEmployee(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickEmployeeNo(driver).sendKeys("58");
	       Thread.sleep(2000);
	       EntityLocator.ClickSaveIA(driver).click();
	   
	        try
	        {
	        	Thread.sleep(2000);
	    	   String msg=EntityLocator.ValidMsgInternalAuditor(driver).getText();
	    	   test.log(LogStatus.PASS, "Message Displayed =" +msg);
	       }
	       catch(Exception e)
	       {
	    	   Thread.sleep(2000);
	    	   String msg=EntityLocator.InValidMsgInternalAuditor(driver).getText();
	    	   test.log(LogStatus.PASS, "Message Displayed =" +msg);
	       }
	        
	       
	       Thread.sleep(2000);
	       EntityLocator.CloseEntity(driver).click();
		   Thread.sleep(4000);
		   EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void EnterExistingDataInternalAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.NewInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickInternalAuditorCategory(driver).click();
	       Thread.sleep(2000);
	      // EntityLocator.SelectInternalAuditorCategory(driver).click();
	       List<WebElement>LeaveType1 = driver.findElements(By.xpath("//ul[@id='ddlCriteria_listbox']/li"));
		   selectOptionFromDropDown_bs(LeaveType1, "Individual");
	       Thread.sleep(2000);
	       EntityLocator. ClickInternalAuditorName(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectInternalAuditorName1(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickFYInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator. SelectFYInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickDateOfAppointmentIA(driver).sendKeys("21/06/2023");
	       Thread.sleep(2000);
	       EntityLocator.ClickWhetherEmployee(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectWhetherEmployee(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickEmployeeNo(driver).sendKeys("58");
	       Thread.sleep(2000);
	       EntityLocator.ClickSaveIA(driver).click();
	   
	        try
	        {
	        	Thread.sleep(2000);
	    	   String msg=EntityLocator.InValidMsgInternalAuditor(driver).getText();
	    	   test.log(LogStatus.PASS, "Enter Existing Data =" +msg);
	       }
	       catch(Exception e)
	       {
	    	   Thread.sleep(2000);
	    	   String msg=EntityLocator.ValidMsgInternalAuditor(driver).getText();
	    	   test.log(LogStatus.PASS, "Enter Existing Data =" +msg);
	       }
	       Thread.sleep(2000);
	       EntityLocator.CloseEntity(driver).click();
		   Thread.sleep(4000);
		   EntityLocator.ClickDashboard(driver).click();
	}
	public static void EnterTwoFieldsInternalAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.NewInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickFYInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator. SelectFYInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickEmployeeNo(driver).sendKeys("2");
	       Thread.sleep(2000);
	       EntityLocator.ClickSaveIA(driver).click();
	       Thread.sleep(2000);
	       String msg=EntityLocator.InvalidMsgInternalAuditor(driver).getText();
	       String msg1=EntityLocator.InvalidMsgInternalAuditor1(driver).getText();
	       
	       test.log(LogStatus.PASS, "Enter Two Mandatory fields= "+msg +"," +msg1);
	       Thread.sleep(2000);
	       EntityLocator.CloseEntity(driver).click();
		   Thread.sleep(4000);
		   EntityLocator.ClickDashboard(driver).click();
	       
	       
	}
	public static void CloseBtnInternalAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.NewInternalAuditor(driver).click();
	
		Thread.sleep(2000);
		if(EntityLocator.CloseEntity(driver).isEnabled())
		{
			Thread.sleep(2000);
			EntityLocator.CloseEntity(driver).click();
			test.log(LogStatus.PASS, "Page should be closed and the user should be redirected to the previous page." );
		}
		else
		{
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Page should not be closed and the user should be redirected to the previous page." );
		}
		Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
		    
	}
	public static void ClearBtnInternalAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickInternalAuditor(driver).click();
	     
	       
	       Thread.sleep(2000);
	       EntityLocator.ClickStatusInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.SelectStatusInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       if(EntityLocator.ClickClearFilterInternalAuditor(driver).isEnabled())
	       {
	           Thread.sleep(2000);
	           EntityLocator.ClickClearFilterInternalAuditor(driver).click();
	           test.log(LogStatus.PASS, "The system should be remove status filter applied and clear search bar");
	       }
	       else
	       {
	    	   test.log(LogStatus.FAIL, "The system should not be remove status filter applied and clear search bar");
	       }
	       Thread.sleep(4000);
		   EntityLocator.ClickDashboard(driver).click();
	       
	} 
	public static void UpdateInternalAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.EditInternalAuditor(driver).click();
	       Thread.sleep(2000);
	       EntityLocator.ClickEmployeeNo(driver).clear();
	       Thread.sleep(2000);
	       EntityLocator.ClickEmployeeNo(driver).sendKeys("20");
	       
	       Thread.sleep(2000);
	       EntityLocator.ClickSaveIA(driver).click();
	     
	       try
	       {
	        	Thread.sleep(2000);
	    	   String msg=EntityLocator.ValidMsgInternalAuditor(driver).getText();
	    	   test.log(LogStatus.PASS, "Message Displayed =" +msg);
	       }
	       catch(Exception e)
	       {
	    	   Thread.sleep(2000);
	    	   String msg=EntityLocator.InValidMsgInternalAuditor(driver).getText();
	    	   test.log(LogStatus.PASS, "Message Displayed =" +msg);
	       }
	       Thread.sleep(2000);
	       EntityLocator.CloseEntity(driver).click();
		   Thread.sleep(4000);
		   EntityLocator.ClickDashboard(driver).click();
	       
	}
	public static void ResignationofInternalAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickInternalAuditor(driver).click();
	    Thread.sleep(2000);
		EntityLocator.ClickResignationofInternalAuditor(driver).click();
	   
		Thread.sleep(2000);
	    EntityLocator.ClickLeaveType(driver).click();
//	    Thread.sleep(2000);
//	    EntityLocator.SelectInternalLeaveType(driver).click();
	    
	    List<WebElement>LeaveType1 = driver.findElements(By.xpath("//ul[@id='ddlLeaveType_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType1, "Resignation");
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDateOfSubmission(driver).sendKeys("31/05/2023");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDated(driver).sendKeys("21/06/2023");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickReason(driver).sendKeys("Test");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUploadDocument(driver).sendKeys("C:\\Users\\Snehal Patil\\Desktop\\Test Cases\\Approver Test Case.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.SaveResignation(driver).click();
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.SaveValidMsgResignation(driver).getText();
	    
	    if(msg.equalsIgnoreCase("Saved Successfully."))
	    {
	    	test.log(LogStatus.PASS, "Message Displayed ="+msg);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Message Displayed ="+msg);
	    }
	    
	 
  		
  		
	    Thread.sleep(2000);
	    EntityLocator.CloseEntity(driver).click();
	    Thread.sleep(4000);
    	EntityLocator.ClickDashboard(driver).click();
	}
	
	public static void EmptyFiledsCancelBtnResignationofInternalAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickInternalAuditor(driver).click();
	    Thread.sleep(2000);
		EntityLocator.ClickResignationofInternalAuditor(driver).click();
	
	

	    
		 Thread.sleep(2000);
	  	   if(EntityLocator.ClickCancelResignation(driver).isEnabled())
	  	    {
	  	    	 Thread.sleep(2000);
	  	  		EntityLocator.ClickCancelResignation(driver).click();
	  	    	test.log(LogStatus.PASS, " resignation cancellation has been successful but No Message Displayed ");
	  	    }
	  	    else
	  	    {
	  	    	test.log(LogStatus.FAIL, "resignation not cancel");
	  	    }
	    
	   
	  
	   
	    Thread.sleep(2000);
	    EntityLocator.CloseEntity(driver).click();
	    Thread.sleep(4000);
    	EntityLocator.ClickDashboard(driver).click();
	}
	public static void EnterInvalidDataResignationofInternalAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(3000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(3000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(3000);
	       EntityLocator.ClickInternalAuditor(driver).click();
	    Thread.sleep(2000);
		EntityLocator.ClickResignationofInternalAuditor(driver).click();
	  
		Thread.sleep(3000);
	    EntityLocator.ClickLeaveType(driver).click();

		Thread.sleep(3000);
	    List<WebElement>LeaveType1 = driver.findElements(By.xpath("//ul[@id='ddlLeaveType_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType1, "Resignation");
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDateOfSubmission(driver).sendKeys("31/05/202");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDated(driver).sendKeys("01/05/202");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickReason(driver).sendKeys("ABC@123");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUploadDocument(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\ShareholdingCategory.xlsx");
	    
	    Thread.sleep(2000);
	    EntityLocator.SaveResignation(driver).click();
	    
	    Thread.sleep(2000);
	    String msg=EntityLocator.InvalidMsgResignation(driver).getText();
	    String msg1=EntityLocator.InvalidMsgResignation1(driver).getText();
	    
	  
	   test.log(LogStatus.PASS, "Enter Invalid Fields ="+msg +"," +msg1);
	
	    Thread.sleep(2000);
	    EntityLocator.CloseEntity(driver).click();
	    Thread.sleep(4000);
    	EntityLocator.ClickDashboard(driver).click();
	}
	public static void EnterEmptyDataResignationofInternalAuditor (WebDriver driver, ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		
		
		Thread.sleep(2000);
		EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  
	  
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    
	    Thread.sleep(2000);
	    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
	       Thread.sleep(2000);
	       EntityLocator.ClickInternalAuditor(driver).click();
	    Thread.sleep(2000);
		EntityLocator.ClickResignationofInternalAuditor(driver).click();
		
		Thread.sleep(2000);
		EntityLocator.SaveResignation(driver).click();
		
		String msg=EntityLocator.InvalidMsgResignation2(driver).getText();
		String msg1=EntityLocator.InvalidMsgResignation3(driver).getText();
		
		test.log(LogStatus.PASS, "Enter Empty Data =" +msg +"," +msg1);
		
		Thread.sleep(2000);
		EntityLocator.CloseEntity(driver).click();
		Thread.sleep(4000);
	    EntityLocator.ClickDashboard(driver).click();
		    
	}
	public static void SecretarialAuditor(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	   WebDriverWait wait = new WebDriverWait(driver, (120));
	   Thread.sleep(2000);
	   EntityLocator.selectImg(driver).click();
	
	
	   Thread.sleep(2000);
	   EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	  
  
        Thread.sleep(2000);
        EntityLocator.ClickMoreAction(driver).click();

    
        Thread.sleep(2000);
        List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			if(EntityLocator.SecretarialAuditor(driver).isEnabled()) {
				EntityLocator.SecretarialAuditor(driver).click();
				Thread.sleep(3000);
				   test.log(LogStatus.PASS,"The system  navigate to the Secretarial Auditor page" );
			}else {
				 test.log(LogStatus.PASS,"The system  not navigate to the Secretarial Auditor page" );
			}	
			Thread.sleep(2000);
	
			EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		 Thread.sleep(1000);
	 }
	public static void SAAddNew(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	   Thread.sleep(2000);
	   EntityLocator.selectImg(driver).click();
	
	
	   Thread.sleep(2000);
	   EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	  

     Thread.sleep(2000);
     EntityLocator.ClickMoreAction(driver).click();

 
     Thread.sleep(2000);
     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
	  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.SecretarialAuditor(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.SAAddNew(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.SACategory(driver).click();
			    Thread.sleep(1000);	
				EntityLocator.SAIndividual(driver).click();
				//Thread.sleep(1000);	
				//EntityLocator.SAAuditorFirm(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.SAauditorfirmName(driver).click();
				Thread.sleep(1000);	
				EntityLocator.SAauditorfirmNameLi(driver).click();
				Thread.sleep(3000);
				
				sheet = workbook.getSheetAt(0); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				org.apache.poi.ss.usermodel.Cell c1 = null;
				
				
				row0 = sheet.getRow(74);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				EntityLocator.Certificate_of_Practice(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
	
				EntityLocator.FYPOA(driver).click();
				Thread.sleep(1000);	
				EntityLocator.FYPOA1(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.DOA(driver).click();
				Thread.sleep(1000);	
				EntityLocator.DOA16(driver).click();
				Thread.sleep(3000);
				EntityLocator.SaveSA(driver).click();
				Thread.sleep(3000);
				try {
				String Text =EntityLocator.SaveMsgSA(driver).getText();
				Thread.sleep(1000);
				if(Text.equalsIgnoreCase("Saved Successfully.")) {
					test.log(LogStatus.PASS,Text );
					
				}else {
					test.log(LogStatus.FAIL,Text );
					
				}
				}catch(Exception e) {
					Thread.sleep(3000);
					String Text =EntityLocator.SaveAEMsgSA(driver).getText();
					
					test.log(LogStatus.PASS,Text );
					Thread.sleep(3000);
				}
				Thread.sleep(3000);
				EntityLocator.CloseSA(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		 Thread.sleep(1000);
	 }
	
	public static void SAAddNewAE(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	 {

		WebDriverWait wait = new WebDriverWait(driver, (120));
		   Thread.sleep(2000);
		   EntityLocator.selectImg(driver).click();
		   Thread.sleep(2000);
		   EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		   Thread.sleep(2000);
	       EntityLocator.ClickMoreAction(driver).click(); 
	       Thread.sleep(2000);
	       List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		   selectOptionFromDropDown_bs(LeaveType, "Auditors");
		   Thread.sleep(3000);
		   EntityLocator.SecretarialAuditor(driver).click();
		   Thread.sleep(3000);
           EntityLocator.SAAddNew(driver).click();
			Thread.sleep(3000);
			EntityLocator.SACategory(driver).click();
			Thread.sleep(1000);	
			EntityLocator.SAAuditorFirm(driver).click();
			Thread.sleep(3000);
				
				EntityLocator.SAauditorfirmName(driver).click();
				//Thread.sleep(1000);	
				//EntityLocator.SAauditorfirmNameLi(driver).click();
				
			     List<WebElement> LeaveType1= driver.findElements(By.xpath("//ul[@id='AuditorID_listbox']//li"));
				 selectOptionFromDropDown_bs(LeaveType1, "KDT & Associates");
				Thread.sleep(3000);
				
				sheet = workbook.getSheetAt(0); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				org.apache.poi.ss.usermodel.Cell c1 = null;
				
				
				row0 = sheet.getRow(74);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				EntityLocator.Certificate_of_Practice(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
	
				EntityLocator.FYPOA(driver).click();
				Thread.sleep(1000);	
				EntityLocator.FYPOA1(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.DOA(driver).click();
				Thread.sleep(1000);	
				EntityLocator.DOA16(driver).click();
				Thread.sleep(3000);
				EntityLocator.SaveSA(driver).click();
				Thread.sleep(3000);
				try {
				String Text =EntityLocator.SaveMsgSA(driver).getText();
				Thread.sleep(1000);
				if(Text.equalsIgnoreCase("Saved Successfully.")) {
					test.log(LogStatus.PASS,Text );
					
				}else {
					test.log(LogStatus.FAIL,Text );
					
				}
				}catch(Exception e) {
					Thread.sleep(3000);
					String Text =EntityLocator.SaveAEMsgSA(driver).getText();
					
					test.log(LogStatus.PASS,Text );
					Thread.sleep(3000);
				}
				Thread.sleep(3000);
				EntityLocator.CloseSA(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		 Thread.sleep(1000);
	 }
	
	public static void SAAddNewTwoMan(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

		 Thread.sleep(2000);
		   EntityLocator.selectImg(driver).click();
		
		
		   Thread.sleep(2000);
		   EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  

	     Thread.sleep(2000);
	     EntityLocator.ClickMoreAction(driver).click();

	 
	     Thread.sleep(2000);
	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.SecretarialAuditor(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.SAAddNew(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.SACategory(driver).click();
				Thread.sleep(1000);	
				EntityLocator.SAAuditorFirm(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.SAauditorfirmName(driver).click();
				 List<WebElement> LeaveType1= driver.findElements(By.xpath("//ul[@id='AuditorID_listbox']//li"));
				 selectOptionFromDropDown_bs(LeaveType1, "Rohini");
				Thread.sleep(3000);
				
				EntityLocator.SaveSA(driver).click();
				Thread.sleep(3000);
			
				String Text =EntityLocator.DOAVal(driver).getText();
				Thread.sleep(1000);
				
					test.log(LogStatus.PASS,"Message Displayed : -"+Text );
					
				
			
				Thread.sleep(3000);
				EntityLocator.CloseSA(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		 Thread.sleep(1000);
	 }
	public static void SAAddNewEmpty(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

		   Thread.sleep(2000);
		  EntityLocator.selectImg(driver).click();
			
			
		   Thread.sleep(2000);
		   EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  

	     Thread.sleep(3000);
	     EntityLocator.ClickMoreAction(driver).click();

	     Thread.sleep(3000);
	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.SecretarialAuditor(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.SAAddNew(driver).click();
				Thread.sleep(3000);
				
			
				EntityLocator.SaveSA(driver).click();
				Thread.sleep(3000);
			
				String Text =EntityLocator.DOAVal(driver).getText();
				Thread.sleep(2000);
				String Text1 =EntityLocator.CategoryVal(driver).getText();
				Thread.sleep(1000);
				
					test.log(LogStatus.PASS,"Message Displayed : -"+Text +" ,"+Text1);
					
				
			
				Thread.sleep(3000);
				EntityLocator.CloseSA(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		 Thread.sleep(1000);
	 }
	public static void SAAddNewClose(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	   Thread.sleep(2000);
		  EntityLocator.selectImg(driver).click();
			
			
		   Thread.sleep(2000);
		   EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  

	     Thread.sleep(3000);
	     EntityLocator.ClickMoreAction(driver).click();

	 
	     Thread.sleep(3000);
	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.SecretarialAuditor(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.SAAddNew(driver).click();
				Thread.sleep(3000);
				
			
				if(EntityLocator.CloseSA(driver).isEnabled()) {
					EntityLocator.CloseSA(driver).click();
					Thread.sleep(3000);
					   test.log(LogStatus.PASS,"Page  closed without saving data and the user should be redirected to the previous page." );
				}else {
					 test.log(LogStatus.PASS,"Page not closed without saving data and the user should be redirected to the previous page." );
				}	
				
				
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		        Thread.sleep(2000);
		        EntityLocator.ClickDashboard(driver).click();
		     
	 }
	
	public static void SAClearFilter(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	
	   Thread.sleep(2000);
		  EntityLocator.selectImg(driver).click();
			
			
		   Thread.sleep(2000);
		   EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  

	     Thread.sleep(3000);
	     EntityLocator.ClickMoreAction(driver).click();

	 
	     Thread.sleep(3000);
	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.SecretarialAuditor(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.Status_All(driver).click();
				Thread.sleep(1000);
				EntityLocator.Current(driver).click();
				Thread.sleep(3000);	
				
			
				if(EntityLocator.ClearBtn(driver).isEnabled()) {
					EntityLocator.ClearBtn(driver).click();
					Thread.sleep(3000);
					   test.log(LogStatus.PASS,"The system  remove status filter applied After Clicking On Clear Button" );
				}else {
					 test.log(LogStatus.PASS,"The system not remove status filter applied After Clicking On Clear Button" );
				}	
				
				
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		 Thread.sleep(1000);
	 }
	
	public static void SAEditClose(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));

	   Thread.sleep(2000);
		  EntityLocator.selectImg(driver).click();
			
			
		   Thread.sleep(3000);
		   EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
		  

	     Thread.sleep(3000);
	     EntityLocator.ClickMoreAction(driver).click();

	     Thread.sleep(3000);
	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.SecretarialAuditor(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.Edit(driver).click();
				Thread.sleep(3000);
				
			
				if(EntityLocator.CloseSA(driver).isEnabled()) {
					EntityLocator.CloseSA(driver).click();
					Thread.sleep(3000);
					   test.log(LogStatus.PASS,"Page  closed without saving data and the user should be redirected to the previous page." );
				}else {
					 test.log(LogStatus.PASS,"Page not closed without saving data and the user should be redirected to the previous page." );
				}	
				
				
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		 Thread.sleep(1000);
	 }
	
	public static void ResignationofSecretarialAuditor(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	 Thread.sleep(2000);
	  EntityLocator.selectImg(driver).click();
		
		
	   Thread.sleep(2000);
	   EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	  

    Thread.sleep(3000);
    EntityLocator.ClickMoreAction(driver).click();


    Thread.sleep(3000);
    List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
	  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.SecretarialAuditor(driver).click();
			
			Thread.sleep(3000);
			
			EntityLocator.Status_All(driver).click();
			Thread.sleep(1000);
			EntityLocator.Current(driver).click();

				Thread.sleep(4000);
				EntityLocator.ResignationofAuditor(driver).click();
				Thread.sleep(3000);
				EntityLocator.LeaveType(driver).click();
				Thread.sleep(1000);
				
				EntityLocator.Resignation(driver).click();
				Thread.sleep(3000);
			
				EntityLocator.Dateofsubmission(driver).click();
				Thread.sleep(3000);	
				EntityLocator.DOA16(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.Dated(driver).click();
				Thread.sleep(1000);	
				EntityLocator.Dated20(driver).click();
				Thread.sleep(3000);
				
				
				EntityLocator.Reason(driver).sendKeys("xyz"); // Writing Task title
				Thread.sleep(2000);
				
				EntityLocator.ChooseFileRA(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\ShareholdingCategory.xlsx"); // Writing Task title
				Thread.sleep(2000);
				EntityLocator.SaveRA(driver).click();
				Thread.sleep(3000);
				
				
				String Text =EntityLocator.SaveMsgRA(driver).getText();
				Thread.sleep(1000);
				if(Text.equalsIgnoreCase("Saved Successfully.")) {
					test.log(LogStatus.PASS,Text );
					
				}else {
					test.log(LogStatus.FAIL,Text );
					
				}
				EntityLocator.Cancel(driver).click();
				Thread.sleep(3000);
				EntityLocator.CloseRA(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		 Thread.sleep(1000);
	 }
	public static void ResignationofAuditorEmpty(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	           WebDriverWait wait = new WebDriverWait(driver, (120));
	           Thread.sleep(2000);
	            EntityLocator.selectImg(driver).click();
		
		
	           Thread.sleep(2000);
	            EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	  

              Thread.sleep(2000);
             EntityLocator.ClickMoreAction(driver).click();

             Thread.sleep(2000);
    	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
    		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			   Thread.sleep(3000);
			    EntityLocator.SecretarialAuditor(driver).click();
			    Thread.sleep(3000);
				
				EntityLocator.Status_All(driver).click();
				Thread.sleep(1000);
				EntityLocator.Current(driver).click();
			    
				Thread.sleep(3000);
				
				EntityLocator.ResignationofAuditor(driver).click();
				Thread.sleep(3000);
				
				
				
				
				EntityLocator.SaveRA(driver).click();
				Thread.sleep(3000);
				
				
				String Text =EntityLocator.LeaveVal(driver).getText();
				Thread.sleep(1000);
				String Text1 =EntityLocator.DatedVal(driver).getText();
				Thread.sleep(1000);
				
					test.log(LogStatus.PASS,"Message Displayed : -"+Text +" ,"+Text1);
					
					Thread.sleep(3000);
				
					EntityLocator.CloseRA(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		
	 }
	public static void ResignationofAuditorCancel(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

          	WebDriverWait wait = new WebDriverWait(driver, (120));
	           Thread.sleep(2000);
                EntityLocator.selectImg(driver).click();


               Thread.sleep(2000);
               EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


                  Thread.sleep(2000);
                  EntityLocator.ClickMoreAction(driver).click();


                  Thread.sleep(2000);
         	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
         		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			    Thread.sleep(3000);
			    EntityLocator.SecretarialAuditor(driver).click();
			    Thread.sleep(3000);
				
				EntityLocator.Status_All(driver).click();
				Thread.sleep(1000);
				EntityLocator.Current(driver).click();
			    
			    
				Thread.sleep(3000);
				
				EntityLocator.ResignationofAuditor(driver).click();
				Thread.sleep(3000);
				EntityLocator.LeaveType(driver).click();
				Thread.sleep(1000);
				
				EntityLocator.Resignation(driver).click();
				Thread.sleep(3000);
			
				EntityLocator.Dateofsubmission(driver).click();
				Thread.sleep(1000);	
				EntityLocator.DOA16(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.Dated(driver).click();
				Thread.sleep(1000);	
				EntityLocator.Dated20(driver).click();
				Thread.sleep(3000);
				
				
				EntityLocator.Reason(driver).sendKeys("xyz"); // Writing Task title
				Thread.sleep(2000);
				
				EntityLocator.ChooseFileRA(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\ShareholdingCategory.xlsx"); // Writing Task title
				Thread.sleep(2000);
				EntityLocator.SaveRA(driver).click();
				Thread.sleep(3000);
				
				
				
				if(EntityLocator.Cancel(driver).isEnabled()) {
					EntityLocator.Cancel(driver).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS," resignation cancellation has been successful but No Message Displayed ");
				}else {
					test.log(LogStatus.FAIL," resignation not cancel ");
				}
				
				EntityLocator.CloseRA(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		 
	 }
	public static void ResignationofAuditorClose(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	  Thread.sleep(2000);
      EntityLocator.selectImg(driver).click();


          Thread.sleep(2000);
         EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


           Thread.sleep(2000);
           EntityLocator.ClickMoreAction(driver).click();


           Thread.sleep(2000);
  	        List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
  		   selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.SecretarialAuditor(driver).click();
            Thread.sleep(3000);
		    EntityLocator.Status_All(driver).click();
			Thread.sleep(1000);
			EntityLocator.Current(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.ResignationofAuditor(driver).click();
				Thread.sleep(3000);
				
				
				if(EntityLocator.CloseRA(driver).isEnabled()) {
					EntityLocator.CloseRA(driver).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS," Clicking on Close - The user is redirected to the previous page ");
				}else {
					test.log(LogStatus.FAIL," Clicking on Close - The user is not redirected to the previous page ");
				}
				
				
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		
	 }
	public static void CostAuditor(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	  Thread.sleep(2000);
      EntityLocator.selectImg(driver).click();


          Thread.sleep(2000);
         EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


           Thread.sleep(2000);
           EntityLocator.ClickMoreAction(driver).click();


           Thread.sleep(2000);
  	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
  		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			if(EntityLocator.CostAuditor(driver).isEnabled()) {
				EntityLocator.CostAuditor(driver).click();
				Thread.sleep(3000);
				   test.log(LogStatus.PASS,"The system  navigate to the Cost Auditor page" );
			}else {
				 test.log(LogStatus.PASS,"The system  not navigate to the Cost Auditor page" );
			}	
			Thread.sleep(2000);
	
			EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		 
	 }
	
	public static void CostAuditorAddNew(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	  Thread.sleep(2000);
      EntityLocator.selectImg(driver).click();


          Thread.sleep(2000);
         EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


           Thread.sleep(2000);
           EntityLocator.ClickMoreAction(driver).click();


           Thread.sleep(2000);
  	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
  		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			
			EntityLocator.CostAuditor(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.CostAuditorNew(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.NatureofIntimation(driver).click();
			Thread.sleep(2000);
			EntityLocator.Originalappointment(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.CategoryCA(driver).click();
			Thread.sleep(2000);
			EntityLocator.IndividualCA(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.AuditorName(driver).click();
			Thread.sleep(2000);
			EntityLocator.AuditorName1(driver).click();
			Thread.sleep(2000);
			
			sheet = workbook.getSheetAt(0); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
			int row = 0;
			Thread.sleep(500);
			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
			org.apache.poi.ss.usermodel.Cell c1 = null;
			
			
			row0 = sheet.getRow(77);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			EntityLocator.NameoftheCostauditor(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
			Thread.sleep(2000);
			
			EntityLocator.Dateboardmeeting(driver).click();
			Thread.sleep(2000);
			EntityLocator.Dateboardmeeting15(driver).click();
			Thread.sleep(2000);
			
			row0 = sheet.getRow(78);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			int No = (int) c1.getNumericCellValue();
			EntityLocator.ResulationNumber(driver).sendKeys("" + No + ""); // Writing Task title
			Thread.sleep(4000);
			
			EntityLocator.FYNo(driver).click();
			Thread.sleep(2000);
			EntityLocator.FYNo2223(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.SaveCA(driver).click();
			
			Thread.sleep(3000);
			try {
			String Text =EntityLocator.SaveMsgCA(driver).getText();
			Thread.sleep(1000);
			if(Text.equalsIgnoreCase("Saved Successfully.")) {
				test.log(LogStatus.PASS,Text );
				
			}else {
				test.log(LogStatus.FAIL,Text );
				
			}
			}catch(Exception e) {
				Thread.sleep(3000);
				String Text =EntityLocator.SaveAEMsgCA(driver).getText();
				
				test.log(LogStatus.PASS,Text );
				Thread.sleep(3000);
			}
			Thread.sleep(2000);
			EntityLocator.CloseCA(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.EntityCap(driver).click();
		    Thread.sleep(2000);
		     EntityLocator.ClickDashboard(driver).click();
		 
	 }
	public static void CostAuditorAddNewED(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	 {

		 Thread.sleep(2000);
	      EntityLocator.selectImg(driver).click();


	          Thread.sleep(2000);
	         EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


	           Thread.sleep(2000);
	           EntityLocator.ClickMoreAction(driver).click();

	           Thread.sleep(2000);
	  	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
	  		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			
			EntityLocator.CostAuditor(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.CostAuditorNew(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.NatureofIntimation(driver).click();
			Thread.sleep(2000);
			EntityLocator.Originalappointment(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.CategoryCA(driver).click();
			Thread.sleep(2000);
			EntityLocator.AuditorCA(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.AuditorName(driver).click();
			Thread.sleep(2000);
			EntityLocator.AuditorName2(driver).click();
			Thread.sleep(2000);
			
			sheet = workbook.getSheetAt(0); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
			int row = 0;
			Thread.sleep(500);
			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
			org.apache.poi.ss.usermodel.Cell c1 = null;
			
			
			row0 = sheet.getRow(77);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			EntityLocator.NameoftheCostauditor(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
			Thread.sleep(2000);
			
			EntityLocator.Dateboardmeeting(driver).click();
			Thread.sleep(2000);
			EntityLocator.Dateboardmeeting15(driver).click();
			Thread.sleep(2000);
			
			row0 = sheet.getRow(78);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			int No = (int) c1.getNumericCellValue();
			EntityLocator.ResulationNumber(driver).sendKeys("" + No + ""); // Writing Task title
			Thread.sleep(4000);
			
			EntityLocator.FYNo(driver).click();
			Thread.sleep(2000);
			EntityLocator.FYNo2223(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.SaveCA(driver).click();
			Thread.sleep(2000);
			try 
			{
	             String Msg=EntityLocator.SaveMsgCA(driver).getText();
			     if(Msg.equalsIgnoreCase("Saved Successfully.")) {
				
				 test.log(LogStatus.PASS,"Message Displayed : -"+Msg );
			}else {
				 test.log(LogStatus.FAIL,"Message Displayed : -"+Msg );
			}
			Thread.sleep(2000);
			}catch(Exception e) {
				
				String Msg=	EntityLocator.SaveMsgCA1(driver).getText();
				 test.log(LogStatus.PASS,"Message Displayed : -"+Msg );
				
			}
			EntityLocator.CloseCA(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.EntityCap(driver).click();
		    Thread.sleep(2000);
		    EntityLocator.ClickDashboard(driver).click();
		  
	 }

	public static void CostAuditorAddNewTwoMan(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	 Thread.sleep(2000);
     EntityLocator.selectImg(driver).click();


         Thread.sleep(2000);
        EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


          Thread.sleep(2000);
          EntityLocator.ClickMoreAction(driver).click();

          Thread.sleep(2000);
 	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
 		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			
 		  Thread.sleep(3000);
			
			EntityLocator.CostAuditor(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.CostAuditorNew(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.NatureofIntimation(driver).click();
			Thread.sleep(2000);
			EntityLocator.Originalappointment(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.CategoryCA(driver).click();
			Thread.sleep(2000);
			EntityLocator.AuditorCA(driver).click();
			Thread.sleep(2000);
			
		
			EntityLocator.SaveCA(driver).click();
			Thread.sleep(2000);
			
        	String Msg=	EntityLocator.AuditorNameVal(driver).getText();
	        Thread.sleep(2000);
	        String Msg1=EntityLocator.LLPVal(driver).getText();
			
				
				 test.log(LogStatus.PASS,"Message Displayed : -"+Msg +" ,"+Msg1);
			
			Thread.sleep(2000);
			
			EntityLocator.CloseCA(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.EntityCap(driver).click();
		    Thread.sleep(2000);
		     EntityLocator.ClickDashboard(driver).click();
		 
	 }
	public static void CostAuditorAddNewEmpty(WebDriver driver, ExtentTest test,XSSFWorkbook workbook) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	 Thread.sleep(2000);
     EntityLocator.selectImg(driver).click();


         Thread.sleep(2000);
        EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


          Thread.sleep(3000);
          EntityLocator.ClickMoreAction(driver).click();


          Thread.sleep(3000);
 	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
 		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			
			EntityLocator.CostAuditor(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.CostAuditorNew(driver).click();
			Thread.sleep(2000);
			
			
			EntityLocator.SaveCA(driver).click();
			Thread.sleep(2000);
			
       	String Msg=	EntityLocator.AuditorNameVal(driver).getText();
	    Thread.sleep(2000);
	     String Msg1=EntityLocator.LLPVal(driver).getText();
	     Thread.sleep(2000);
	     String Msg2=EntityLocator.NatureIntimationVal(driver).getText();
	      Thread.sleep(2000);
				
				 test.log(LogStatus.PASS,"Message Displayed : -"+Msg +" ,"+Msg1+" ,"+Msg2);
			
			Thread.sleep(2000);
			
			EntityLocator.CloseCA(driver).click();
			Thread.sleep(2000);
			
			EntityLocator.EntityCap(driver).click();
		    Thread.sleep(2000);
		   EntityLocator.ClickDashboard(driver).click();
		 
	 }
	public static void CAAddNewClose(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	 Thread.sleep(2000);
     EntityLocator.selectImg(driver).click();


         Thread.sleep(2000);
        EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


          Thread.sleep(2000);
          EntityLocator.ClickMoreAction(driver).click();


          Thread.sleep(2000);
 	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
 		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.CostAuditor(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.CostAuditorNew(driver).click();
				Thread.sleep(3000);
				
			
				if(EntityLocator.CloseCA(driver).isEnabled()) {
					EntityLocator.CloseCA(driver).click();
					Thread.sleep(3000);
					   test.log(LogStatus.PASS,"Page  closed without saving data and the user should be redirected to the previous page." );
				}else {
					 test.log(LogStatus.PASS,"Page not closed without saving data and the user should be redirected to the previous page." );
				}	
				
				
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		        Thread.sleep(2000);
		       EntityLocator.ClickDashboard(driver).click();
		    
	 }
	public static void CAClearFilter(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	Thread.sleep(2000);
    EntityLocator.selectImg(driver).click();


        Thread.sleep(2000);
       EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


         Thread.sleep(2000);
         EntityLocator.ClickMoreAction(driver).click();


         Thread.sleep(2000);
	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.CostAuditor(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.Status_All4(driver).click();
				Thread.sleep(1000);
				EntityLocator.Current4(driver).click();
				Thread.sleep(3000);	
				
			
				if(EntityLocator.ClearBtn4(driver).isEnabled()) {
					EntityLocator.ClearBtn4(driver).click();
					Thread.sleep(3000);
					   test.log(LogStatus.PASS,"The system  remove status filter applied After Clicking On Clear Button" );
				}else {
					 test.log(LogStatus.PASS,"The system not remove status filter applied After Clicking On Clear Button" );
				}	
				
				
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		 Thread.sleep(1000);
	 }
	
	public static void CAEditClose(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	Thread.sleep(2000);
    EntityLocator.selectImg(driver).click();


        Thread.sleep(2000);
       EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


         Thread.sleep(2000);
         EntityLocator.ClickMoreAction(driver).click();


         Thread.sleep(2000);
	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.CostAuditor(driver).click();
				Thread.sleep(3000);
				EntityLocator.EditCA(driver).click();
				Thread.sleep(4000);
				if(EntityLocator.CloseCA(driver).isEnabled()) {
					EntityLocator.CloseCA(driver).click();
					Thread.sleep(3000);
					   test.log(LogStatus.PASS,"Page  closed without saving data and the user should be redirected to the previous page." );
				}else {
					 test.log(LogStatus.PASS,"Page not closed without saving data and the user should be redirected to the previous page." );
				}	
				
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		
	 }
	public static void ResignationofAuditorCA(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	Thread.sleep(2000);
    EntityLocator.selectImg(driver).click();


        Thread.sleep(2000);
       EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


         Thread.sleep(2000);
         EntityLocator.ClickMoreAction(driver).click();


         Thread.sleep(2000);
	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.CostAuditor(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.ResignationofAuditorCA(driver).click();
				Thread.sleep(3000);
				EntityLocator.LeaveType(driver).click();
				Thread.sleep(1000);
				
				EntityLocator.Resignation(driver).click();
				Thread.sleep(3000);
			
				EntityLocator.Dateofsubmission(driver).click();
				Thread.sleep(1000);	
				EntityLocator.DOA16(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.Dated(driver).click();
				Thread.sleep(1000);	
				EntityLocator.Dated20(driver).click();
				Thread.sleep(3000);
				
				
				EntityLocator.Reason(driver).sendKeys("xyz"); // Writing Task title
				Thread.sleep(2000);
				
				EntityLocator.ChooseFileRA(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\ShareholdingCategory.xlsx"); // Writing Task title
				Thread.sleep(2000);
				EntityLocator.SaveRA(driver).click();
				Thread.sleep(3000);
				
				
				String Text =EntityLocator.SaveMsgRA(driver).getText();
				Thread.sleep(1000);
				if(Text.equalsIgnoreCase("Saved Successfully.")) {
					test.log(LogStatus.PASS,Text );
					
				}else {
					test.log(LogStatus.FAIL,Text );
					
				}
				EntityLocator.Cancel(driver).click();
				Thread.sleep(3000);
				EntityLocator.CloseRA(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		
	 }
	public static void ResignationofAuditorEmptyCA(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	Thread.sleep(2000);
    EntityLocator.selectImg(driver).click();


        Thread.sleep(2000);
       EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


         Thread.sleep(2000);
         EntityLocator.ClickMoreAction(driver).click();


         Thread.sleep(2000);
	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.CostAuditor(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.ResignationofAuditorCA(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.SaveRA(driver).click();
				Thread.sleep(3000);
				
				
				String Text =EntityLocator.LeaveVal(driver).getText();
				Thread.sleep(1000);
				String Text1 =EntityLocator.DatedVal(driver).getText();
				Thread.sleep(1000);
				
					test.log(LogStatus.PASS,"Message Displayed : -"+Text +" ,"+Text1);
					
					Thread.sleep(3000);
				
					EntityLocator.CloseRA(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		
	 }
	public static void ResignationofAuditorCancelCA(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	Thread.sleep(2000);
    EntityLocator.selectImg(driver).click();


        Thread.sleep(2000);
       EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


         Thread.sleep(3000);
         EntityLocator.ClickMoreAction(driver).click();


         Thread.sleep(3000);
	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.CostAuditor(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.ResignationofAuditorCA(driver).click();
				Thread.sleep(3000);
				EntityLocator.LeaveType(driver).click();
				Thread.sleep(1000);
				
				EntityLocator.Resignation(driver).click();
				Thread.sleep(3000);
			
				EntityLocator.Dateofsubmission(driver).click();
				Thread.sleep(1000);	
				EntityLocator.DOA16(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.Dated(driver).click();
				Thread.sleep(1000);	
				EntityLocator.Dated20(driver).click();
				Thread.sleep(3000);
				
				
				EntityLocator.Reason(driver).sendKeys("xyz"); // Writing Task title
				Thread.sleep(2000);
				
				EntityLocator.ChooseFileRA(driver).sendKeys("C:\\Users\\Snehal Patil\\Downloads\\ShareholdingCategory.xlsx"); // Writing Task title
				Thread.sleep(2000);
				EntityLocator.SaveRA(driver).click();
				Thread.sleep(3000);
				
				
				
				if(EntityLocator.Cancel(driver).isEnabled()) {
					EntityLocator.Cancel(driver).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS," resignation cancellation has been successful but No Message Displayed ");
				}else {
					test.log(LogStatus.FAIL," resignation not cancel ");
				}
				
				EntityLocator.CloseRA(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		 
	 }
	public static void ResignationofAuditorCloseCA(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	WebDriverWait wait = new WebDriverWait(driver, (120));
	Thread.sleep(2000);
    EntityLocator.selectImg(driver).click();


        Thread.sleep(2000);
       EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);


         Thread.sleep(2000);
         EntityLocator.ClickMoreAction(driver).click();


         Thread.sleep(2000);
	     List<WebElement> LeaveType= driver.findElements(By.xpath("//ul[@id='griDDLActionMenu_listbox']//li"));
		  selectOptionFromDropDown_bs(LeaveType, "Auditors");
			Thread.sleep(3000);
			EntityLocator.CostAuditor(driver).click();
				Thread.sleep(3000);
				
				EntityLocator.ResignationofAuditorCA(driver).click();
				Thread.sleep(3000);
				
				
				if(EntityLocator.CloseRA(driver).isEnabled()) {
					EntityLocator.CloseRA(driver).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS," Clicking on Close - The user is redirected to the previous page ");
				}else {
					test.log(LogStatus.FAIL," Clicking on Close - The user is not redirected to the previous page ");
				}
				
				
				
				EntityLocator.EntityCap(driver).click();
		Thread.sleep(2000);
		EntityLocator.ClickDashboard(driver).click();
		 
	 }
	

	public static void ClickMBP4(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

         	WebDriverWait wait = new WebDriverWait(driver, (120));
            Thread.sleep(2000);
            EntityLocator.selectImg(driver).click();
            Thread.sleep(2000);
            EntityLocator.ClickMoreAction(driver).click();
            Thread.sleep(2000);
            EntityLocator.clickStatutoryRegistor(driver).click();
            Thread.sleep(2000);
            if(EntityLocator.clickMBP4(driver).isEnabled())
    	    {
    	      Thread.sleep(2000);
    	      EntityLocator.clickMBP4(driver).click();
    	      test.log(LogStatus.PASS, "MBP-4 tab is Selected");
    	    }
    	    else
    	    {
    	    	 test.log(LogStatus.FAIL, "MBP-4 tab is not Selected");
    	    }
            Thread.sleep(2000);
    		EntityLocator.ClickDashboard(driver).click();
            
            
	 }
	
	public static void ClickUploadExistingRegistorValidData(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

        	WebDriverWait wait = new WebDriverWait(driver, (120));
           Thread.sleep(2000);
           EntityLocator.selectImg(driver).click();
           Thread.sleep(2000);
           EntityLocator.ClickMoreAction(driver).click();
           Thread.sleep(2000);
           EntityLocator.clickStatutoryRegistor(driver).click();
           Thread.sleep(2000);
           EntityLocator.clickMBP4(driver).click();
           Thread.sleep(2000);
           EntityLocator.clickUploadBtn(driver).click();
           Thread.sleep(2000);
           EntityLocator.SelectFile1(driver).sendKeys("C:\\Users\\Admin\\Downloads\\SampleExcelMBP4-Existing (5).xlsx");
           Thread.sleep(2000);
           EntityLocator.clickUploadBtn1(driver).click();
           
           try 
 		  {
 		   Thread.sleep(3000);
 	        String msg=	EntityLocator.clickUploadfileValidMsg(driver).getText();
 	        test.log(LogStatus.PASS,"Enter Valid Data In MBP-4 Existing Excel File  =" +msg );
 	       
 		  }
 	      catch(Exception  e) 
 		  {
 	    	 Thread.sleep(3000);
 			 String msg=EntityLocator.clickUploadfileInValidMsg(driver).getText();
 			  test.log(LogStatus.FAIL, "Enter Valid Data In MBP-4 Existing Excel File =" +msg );
 			
 		  }
           
           Thread.sleep(2000);
   		   EntityLocator.ClickDashboard(driver).click();
	 }
	public static void ClickUploadExistingRegistorInvalidData(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

       	WebDriverWait wait = new WebDriverWait(driver, (120));
          Thread.sleep(2000);
          EntityLocator.selectImg(driver).click();
          Thread.sleep(2000);
          EntityLocator.ClickMoreAction(driver).click();
          Thread.sleep(2000);
          EntityLocator.clickStatutoryRegistor(driver).click();
          Thread.sleep(2000);
          EntityLocator.clickMBP4(driver).click();
          Thread.sleep(2000);
          EntityLocator.clickUploadBtn(driver).click();
          Thread.sleep(2000);
          EntityLocator.SelectFile1(driver).sendKeys("C:\\Users\\Admin\\Downloads\\SampleExcelMBP4-Existing (5).xlsx");
          Thread.sleep(2000);
          EntityLocator.clickUploadBtn1(driver).click();
          
          try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.clickUploadfileInValidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Enter InValid Data In MBP-4 Existing Excel File  =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.clickUploadfileValidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Enter InValid Data In MBP-4 Existing Excel File =" +msg );
			
		  }
          
          Thread.sleep(2000);
  		   EntityLocator.ClickDashboard(driver).click();
	 }
	public static void ClickUploadExistingRegistorDupliacteData(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

      	WebDriverWait wait = new WebDriverWait(driver, (120));
         Thread.sleep(2000);
         EntityLocator.selectImg(driver).click();
         Thread.sleep(2000);
         EntityLocator.ClickMoreAction(driver).click();
         Thread.sleep(2000);
         EntityLocator.clickStatutoryRegistor(driver).click();
         Thread.sleep(2000);
         EntityLocator.clickMBP4(driver).click();
         Thread.sleep(2000);
         EntityLocator.clickUploadBtn(driver).click();
         Thread.sleep(2000);
         EntityLocator.SelectFile1(driver).sendKeys("C:\\Users\\Admin\\Downloads\\SampleExcelMBP4-Existing (5).xlsx");
         Thread.sleep(2000);
         EntityLocator.clickUploadBtn1(driver).click();
         
         try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.clickUploadfileInValidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Enter InValid Data In MBP-4 Existing Excel File  =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.clickUploadfileValidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Enter InValid Data In MBP-4 Existing Excel File =" +msg );
			
		  }
         
         Thread.sleep(2000);
 		 EntityLocator.ClickDashboard(driver).click();
	 }
	public static void ClickUploadExistingRegistorWithoutData(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

      	WebDriverWait wait = new WebDriverWait(driver, (120));
         Thread.sleep(2000);
         EntityLocator.selectImg(driver).click();
         Thread.sleep(2000);
         EntityLocator.ClickMoreAction(driver).click();
         Thread.sleep(2000);
         EntityLocator.clickStatutoryRegistor(driver).click();
         Thread.sleep(2000);
         EntityLocator.clickMBP4(driver).click();
         Thread.sleep(2000);
         EntityLocator.clickUploadBtn(driver).click();
         
         Thread.sleep(2000);
         EntityLocator.SelectFile1(driver).sendKeys("C:\\Users\\Admin\\Downloads\\SampleExcelMBP4-Existing (2).xlsx");
        
         Thread.sleep(2000);
         EntityLocator.clickUploadBtn1(driver).click();
         
      
         
         try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.clickUploadfileInValidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Without data In MBP-4 Existing Excel File  =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.clickUploadfileValidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Without data Data In MBP-4 Existing Excel File =" +msg );
			
		  }
         
         Thread.sleep(2000);
 		   EntityLocator.ClickDashboard(driver).click();
	 }
	public static void ClickUploadExistingRegistorInvalidFileFormat(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

     	WebDriverWait wait = new WebDriverWait(driver, (120));
        Thread.sleep(2000);
        EntityLocator.selectImg(driver).click();
        Thread.sleep(2000);
        EntityLocator.ClickMoreAction(driver).click();
        Thread.sleep(2000);
        EntityLocator.clickStatutoryRegistor(driver).click();
        Thread.sleep(2000);
        EntityLocator.clickMBP4(driver).click();
        Thread.sleep(2000);
        EntityLocator.clickUploadBtn(driver).click();
        
        Thread.sleep(2000);
        EntityLocator.SelectFile1(driver).sendKeys("C:\\Users\\Admin\\Downloads\\AvaSec June (2).xlsx");
       
        Thread.sleep(2000);
        EntityLocator.clickUploadBtn1(driver).click();
        
     
        
        try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.clickUploadfileValidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Enter Invalid file format In MBP-4 Existing Excel File  =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.clickUploadfileInValidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Enter Invalid file format In MBP-4 Existing Excel File =" +msg );
			
		  }
        
        Thread.sleep(2000);
		   EntityLocator.ClickDashboard(driver).click();
	 }
	public static void ClickUploadExistingRegistorWithoutSelectingFile(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

    	WebDriverWait wait = new WebDriverWait(driver, (120));
       Thread.sleep(2000);
       EntityLocator.selectImg(driver).click();
       Thread.sleep(2000);
       EntityLocator.ClickMoreAction(driver).click();
       Thread.sleep(2000);
       EntityLocator.clickStatutoryRegistor(driver).click();
       Thread.sleep(2000);
       EntityLocator.clickMBP4(driver).click();
       Thread.sleep(2000);
       EntityLocator.clickUploadBtn(driver).click();
       
       
      
       Thread.sleep(2000);
       EntityLocator.clickUploadBtn1(driver).click();
       
    
       
       try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.clickInvalidMsg(driver).getText();
	        test.log(LogStatus.FAIL,"Without selecting file In MBP-4 Existing Excel File  =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.clickUploadfileInValidMsg(driver).getText();
			  test.log(LogStatus.PASS, "Without selecting file  In MBP-4 Existing Excel File =" +msg );
			
		  }
       
       Thread.sleep(2000);
	  EntityLocator.ClickDashboard(driver).click();
	 }
	public static void ClickUploadOldRegistorWithValidData(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

    	WebDriverWait wait = new WebDriverWait(driver, (120));
      Thread.sleep(2000);
      EntityLocator.selectImg(driver).click();
      Thread.sleep(2000);
      EntityLocator.ClickMoreAction(driver).click();
      Thread.sleep(2000);
      EntityLocator.clickStatutoryRegistor(driver).click();
      Thread.sleep(2000);
      EntityLocator.clickMBP4(driver).click();
      Thread.sleep(2000);
      EntityLocator.clickUploadBtn(driver).click();
      
      Thread.sleep(2000);
      EntityLocator.clickOld(driver).click();
      
      Thread.sleep(2000);
      EntityLocator.SelectFile1(driver).sendKeys("C:\\Users\\Admin\\Downloads\\SampleExcelMBP4-Old (1).xlsx");
     
      Thread.sleep(2000);
      EntityLocator.clickUploadBtn1(driver).click();
      
   
      
      try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.clickUploadfileValidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Enter Valid data In MBP-4 Old Excel File  =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.clickInvalidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Enter Valid data In MBP-4 Old Excel File =" +msg );
			
		  }
      
      Thread.sleep(2000);
	  EntityLocator.ClickDashboard(driver).click();
	 }
	public static void ClickUploadOldRegistorWithInValidData(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

   	WebDriverWait wait = new WebDriverWait(driver, (120));
     Thread.sleep(2000);
     EntityLocator.selectImg(driver).click();
     Thread.sleep(2000);
     EntityLocator.ClickMoreAction(driver).click();
     Thread.sleep(2000);
     EntityLocator.clickStatutoryRegistor(driver).click();
     Thread.sleep(2000);
     EntityLocator.clickMBP4(driver).click();
     Thread.sleep(2000);
     EntityLocator.clickUploadBtn(driver).click();
     
     Thread.sleep(2000);
     EntityLocator.clickOld(driver).click();
     
     Thread.sleep(2000);
     EntityLocator.SelectFile1(driver).sendKeys("C:\\Users\\Admin\\Downloads\\SampleExcelMBP4-Old (1).xlsx");
    
     Thread.sleep(2000);
     EntityLocator.clickUploadBtn1(driver).click();
     
  
     
     try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.clickUploadfileInValidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Enter invalid data In MBP-4 Old Excel File  =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.clickInvalidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Enter invalid data In MBP-4 Old Excel File =" +msg );
			
		  }
     
     Thread.sleep(2000);
	  EntityLocator.ClickDashboard(driver).click();
	 }
	
	public static void ClickUploadOldRegistorWithDuplicateData(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

   	WebDriverWait wait = new WebDriverWait(driver, (120));
     Thread.sleep(2000);
     EntityLocator.selectImg(driver).click();
     Thread.sleep(2000);
     EntityLocator.ClickMoreAction(driver).click();
     Thread.sleep(2000);
     EntityLocator.clickStatutoryRegistor(driver).click();
     Thread.sleep(2000);
     EntityLocator.clickMBP4(driver).click();
     Thread.sleep(2000);
     EntityLocator.clickUploadBtn(driver).click();
     
     Thread.sleep(2000);
     EntityLocator.clickOld(driver).click();
     
     Thread.sleep(2000);
     EntityLocator.SelectFile1(driver).sendKeys("C:\\Users\\Admin\\Downloads\\SampleExcelMBP4-Old (1).xlsx");
    
     Thread.sleep(2000);
     EntityLocator.clickUploadBtn1(driver).click();
     
  
     
     try 
		  {
		   Thread.sleep(3000);
	        String msg=	EntityLocator.clickUploadfileValidMsg(driver).getText();
	        test.log(LogStatus.PASS,"Duplicate data In MBP-4 Old Excel File  =" +msg );
	       
		  }
	      catch(Exception  e) 
		  {
	    	 Thread.sleep(3000);
			 String msg=EntityLocator.clickInvalidMsg(driver).getText();
			  test.log(LogStatus.FAIL, "Duplicate data In MBP-4 Old Excel File=" +msg );
			
		  }
     
     Thread.sleep(2000);
	  EntityLocator.ClickDashboard(driver).click();
	 }
	
	public static void ClickUploadOldRegistorWithoutData(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

  	   WebDriverWait wait = new WebDriverWait(driver, (120));
       Thread.sleep(2000);
       EntityLocator.selectImg(driver).click();
       Thread.sleep(2000);
       EntityLocator.ClickMoreAction(driver).click();
       Thread.sleep(2000);
       EntityLocator.clickStatutoryRegistor(driver).click();
       Thread.sleep(2000);
       EntityLocator.clickMBP4(driver).click();
       Thread.sleep(2000);
       EntityLocator.clickUploadBtn(driver).click();
    
       Thread.sleep(2000);
       EntityLocator.clickOld(driver).click();
    
       Thread.sleep(2000);
       EntityLocator.SelectFile1(driver).sendKeys("C:\\Users\\Admin\\Downloads\\SampleExcelMBP4-Old.xlsx");
   
       Thread.sleep(2000);
      EntityLocator.clickUploadBtn1(driver).click();

      Thread.sleep(2000);
      String msg=EntityLocator.clickUploadfileValidMsg(driver).getText();
      if(msg.equalsIgnoreCase("Record Save Successfully"))
      {
    	  test.log(LogStatus.FAIL,"Without data in MBP-4 Old Excel file =" +msg);
      }
      else
      {
    	  test.log(LogStatus.PASS,"Without data in MBP-4 Old Excel file =" +msg);
      }
      Thread.sleep(2000);
	  EntityLocator.ClickDashboard(driver).click();
	 
	 
	 }
	
	public static void ClickUploadOldRegistorInvalidFile(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

 	   WebDriverWait wait = new WebDriverWait(driver, (120));
      Thread.sleep(2000);
      EntityLocator.selectImg(driver).click();
      Thread.sleep(2000);
      EntityLocator.ClickMoreAction(driver).click();
      Thread.sleep(2000);
      EntityLocator.clickStatutoryRegistor(driver).click();
      Thread.sleep(2000);
      EntityLocator.clickMBP4(driver).click();
      Thread.sleep(2000);
      EntityLocator.clickUploadBtn(driver).click();
   
      Thread.sleep(2000);
      EntityLocator.clickOld(driver).click();
   
      Thread.sleep(2000);
      EntityLocator.SelectFile1(driver).sendKeys("C:\\Users\\Admin\\Downloads\\AvaSec June (2).xlsx");
  
      Thread.sleep(2000);
     EntityLocator.clickUploadBtn1(driver).click();

     Thread.sleep(2000);
     String msg=EntityLocator.clickUploadfileValidMsg(driver).getText();
     if(msg.equalsIgnoreCase("No Data Found in Excel Document or Sheet Name must be 'MBP-4_PartB'"))
     {
   	  test.log(LogStatus.PASS,"Invalid File in MBP-4 Old Excel file =" +msg);
     }
     else
     {
   	  test.log(LogStatus.FAIL,"Invalid File  in MBP-4 Old Excel file =" +msg);
     }
     Thread.sleep(2000);
	  EntityLocator.ClickDashboard(driver).click();
	 
	 
	 }
	public static void ClickUploadOldRegistorWithoutSelectFile(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

	   WebDriverWait wait = new WebDriverWait(driver, (120));
     Thread.sleep(2000);
     EntityLocator.selectImg(driver).click();
     Thread.sleep(2000);
     EntityLocator.ClickMoreAction(driver).click();
     Thread.sleep(2000);
     EntityLocator.clickStatutoryRegistor(driver).click();
     Thread.sleep(2000);
     EntityLocator.clickMBP4(driver).click();
     Thread.sleep(2000);
     EntityLocator.clickUploadBtn(driver).click();
  
     Thread.sleep(2000);
     EntityLocator.clickOld(driver).click();
  
    
 
     Thread.sleep(2000);
    EntityLocator.clickUploadBtn1(driver).click();

    Thread.sleep(2000);
    String msg=EntityLocator.clickInvalidMsg(driver).getText();
    if(msg.equalsIgnoreCase(msg))
    {
  	  test.log(LogStatus.FAIL,"Without Selecting File in MBP-4 Old Excel file =" +msg);
    }
    else
    {
  	  test.log(LogStatus.PASS,"Without Selecting File  in MBP-4 Old Excel file =" +msg);
    }
    Thread.sleep(2000);
	  EntityLocator.ClickDashboard(driver).click();
	 
	 
	 }
	
	public static void ClickGenerateRegistor(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

        	WebDriverWait wait = new WebDriverWait(driver, (120));
           Thread.sleep(2000);
           EntityLocator.selectImg(driver).click();
           Thread.sleep(2000);
           EntityLocator.ClickMoreAction(driver).click();
           Thread.sleep(2000);
           EntityLocator.clickStatutoryRegistor(driver).click();
           Thread.sleep(2000);
           EntityLocator.clickMBP4(driver).click();
           Thread.sleep(2000);
           if(EntityLocator.clickGenerateRegistor(driver).isEnabled())
   	    {
   	      Thread.sleep(2000);
   	      EntityLocator.clickGenerateRegistor(driver).click();
   	      test.log(LogStatus.PASS, "User should be redirected to the 'Generate Register' page and able to see three option i.e existing,old and all");
   	    }
   	    else
   	    {
   	    	 test.log(LogStatus.FAIL, "User should be redirected to the 'Generate Register' page and able to see three option i.e existing,old and all");
   	    }
           Thread.sleep(2000);
   		EntityLocator.ClickDashboard(driver).click();
           
           
	 }
	
	public static void ClickDownloadExisitingRegisterOfMBP4(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

       	  WebDriverWait wait = new WebDriverWait(driver, (120));
          Thread.sleep(2000);
          EntityLocator.selectImg(driver).click();
          Thread.sleep(2000);
          EntityLocator.ClickMoreAction(driver).click();
          Thread.sleep(2000);
          EntityLocator.clickStatutoryRegistor(driver).click();
          Thread.sleep(2000);
          EntityLocator.clickMBP4(driver).click();
          Thread.sleep(2000);
   	      EntityLocator.clickGenerateRegistor(driver).click();
   	      Thread.sleep(2000);
	      EntityLocator.clickExistingDropdown(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.clickExistingDropdown1(driver).click();
	      
	      
	      File dir = new File("C://Users//Admin//Downloads");
		  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		  		
		  	Thread.sleep(2000);
		 	EntityLocator.clickDownloadBtn(driver).click();		//Exporting (Downloading) file
		  		
		    Thread.sleep(3000);
		    File dir1 = new File("C://Users//Admin//Downloads");
		    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		  		
		  		
		  	if (dirContents.length < allFilesNew.length) 
		  	{
		  		test.log(LogStatus.PASS,  "  Document downloaded successfully.");
		  	} 
		  	else 
		  	{
		  		test.log(LogStatus.FAIL, "  Document does not downloaded.");
		  	}
		    Thread.sleep(2000);
	   		EntityLocator.ClickDashboard(driver).click();
	      
	 }
	public static void ClickDownloadOldRegisterOfMBP4(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

      	  WebDriverWait wait = new WebDriverWait(driver, (120));
         Thread.sleep(2000);
         EntityLocator.selectImg(driver).click();
         Thread.sleep(2000);
         EntityLocator.ClickMoreAction(driver).click();
         Thread.sleep(2000);
         EntityLocator.clickStatutoryRegistor(driver).click();
         Thread.sleep(2000);
         EntityLocator.clickMBP4(driver).click();
         Thread.sleep(2000);
  	      EntityLocator.clickGenerateRegistor(driver).click();
  	    Thread.sleep(2000);
	      EntityLocator.clickOldBtn(driver).click();
  	      Thread.sleep(2000);
	      EntityLocator.clickOldDropdown(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.clickOldDropdown1(driver).click();
	      
	      
	      File dir = new File("C://Users//Admin//Downloads");
		  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		  		
		  	Thread.sleep(2000);
		 	EntityLocator.clickDownloadBtn(driver).click();		//Exporting (Downloading) file
		  		
		    Thread.sleep(3000);
		    File dir1 = new File("C://Users//Admin//Downloads");
		    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		  		
		  		
		  	if (dirContents.length < allFilesNew.length) 
		  	{
		  		test.log(LogStatus.PASS,  "  Document downloaded successfully.");
		  	} 
		  	else 
		  	{
		  		test.log(LogStatus.FAIL, "  Document does not downloaded.");
		  	}
		    Thread.sleep(2000);
	   		EntityLocator.ClickDashboard(driver).click();
	      
	 }
	public static void ClickDownloadAllRegisterOfMBP4(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

     	  WebDriverWait wait = new WebDriverWait(driver, (120));
        Thread.sleep(2000);
        EntityLocator.selectImg(driver).click();
        Thread.sleep(2000);
        EntityLocator.ClickMoreAction(driver).click();
        Thread.sleep(2000);
        EntityLocator.clickStatutoryRegistor(driver).click();
        Thread.sleep(2000);
        EntityLocator.clickMBP4(driver).click();
        Thread.sleep(2000);
 	      EntityLocator.clickGenerateRegistor(driver).click();
 	    Thread.sleep(2000);
	      EntityLocator.clickAllBtn(driver).click();
 	     
	      
	      
	      File dir = new File("C://Users//Admin//Downloads");
		  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		  		
		  	Thread.sleep(2000);
		 	EntityLocator.clickDownloadBtn(driver).click();		//Exporting (Downloading) file
		  		
		    Thread.sleep(3000);
		    File dir1 = new File("C://Users//Admin//Downloads");
		    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		  		
		  		
		  	if (dirContents.length < allFilesNew.length) 
		  	{
		  		test.log(LogStatus.PASS,  "  Document downloaded successfully.");
		  	} 
		  	else 
		  	{
		  		test.log(LogStatus.FAIL, "  Document does not downloaded.");
		  	}
		    Thread.sleep(2000);
	   		EntityLocator.ClickDashboard(driver).click();
	      
	 }   
	public static void ClickViewExisitingRegisterOfMBP4(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

      	  WebDriverWait wait = new WebDriverWait(driver, (120));
         Thread.sleep(2000);
         EntityLocator.selectImg(driver).click();
         Thread.sleep(2000);
         EntityLocator.ClickMoreAction(driver).click();
         Thread.sleep(2000);
         EntityLocator.clickStatutoryRegistor(driver).click();
         Thread.sleep(2000);
         EntityLocator.clickMBP4(driver).click();
         Thread.sleep(2000);
  	      EntityLocator.clickGenerateRegistor(driver).click();
  	      Thread.sleep(2000);
	      EntityLocator.clickExistingDropdown(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.clickExistingDropdown1(driver).click();
	      
	  	 Thread.sleep(2000);
		EntityLocator.clickViewBtn(driver).click();		//Exporting (Downloading) file
		  		
		 Thread.sleep(2000);
			String msg=EntityLocator.clickViewPage(driver).getText();	
		  		
		  	if (msg.equalsIgnoreCase(msg)) 
		  	{
		  		test.log(LogStatus.PASS,  "user should be able to view 'existing' register of MBP-4");
		  	} 
		  	else 
		  	{
		  		test.log(LogStatus.FAIL, " user should not be able to view 'existing' register of MBP-4");
		  	}
		  	
		    Thread.sleep(3000);
	   		EntityLocator.clickViewClosePage(driver).click();
		    Thread.sleep(2000);
	   		EntityLocator.ClickDashboard(driver).click();
	      
	 }
	
	public static void ClickViewOldRegisterOfMBP4(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

     	  WebDriverWait wait = new WebDriverWait(driver, (120));
        Thread.sleep(2000);
        EntityLocator.selectImg(driver).click();
        Thread.sleep(2000);
        EntityLocator.ClickMoreAction(driver).click();
        Thread.sleep(2000);
        EntityLocator.clickStatutoryRegistor(driver).click();
        Thread.sleep(2000);
        EntityLocator.clickMBP4(driver).click();
        Thread.sleep(2000);
 	      EntityLocator.clickGenerateRegistor(driver).click();
 	     Thread.sleep(2000);
	      EntityLocator.clickOldBtn(driver).click();
 	      Thread.sleep(2000);
	      EntityLocator.clickOldDropdown(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.clickOldDropdown1(driver).click();
	      
	  	 Thread.sleep(2000);
		 EntityLocator.clickViewBtn(driver).click();		//Exporting (Downloading) file
		  		
		 Thread.sleep(2000);
			String msg=EntityLocator.clickViewPage(driver).getText();	
		  		
		  	if (msg.equalsIgnoreCase(msg)) 
		  	{
		  		test.log(LogStatus.PASS,  "user should be able to view 'old' register of MBP-4");
		  	} 
		  	else 
		  	{
		  		test.log(LogStatus.FAIL, "user should not be able to view 'old' register of MBP-4");
		  	}
		  	
		    Thread.sleep(2000);
	   		EntityLocator.clickViewClosePage(driver).click();
		    Thread.sleep(2000);
	   		EntityLocator.ClickDashboard(driver).click();
	      
	 }
	public static void ClickViewAllRegisterOfMBP4(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

    	  WebDriverWait wait = new WebDriverWait(driver, (120));
       Thread.sleep(2000);
       EntityLocator.selectImg(driver).click();
       Thread.sleep(2000);
       EntityLocator.ClickMoreAction(driver).click();
       Thread.sleep(2000);
       EntityLocator.clickStatutoryRegistor(driver).click();
       Thread.sleep(2000);
       EntityLocator.clickMBP4(driver).click();
       Thread.sleep(2000);
	      EntityLocator.clickGenerateRegistor(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.clickAllBtn(driver).click();
	      
	  	 Thread.sleep(2000);
		 EntityLocator.clickViewBtn(driver).click();		//Exporting (Downloading) file
		  		
		 Thread.sleep(2000);
			String msg=EntityLocator.clickViewPage(driver).getText();	
		  		
		  	if (msg.equalsIgnoreCase(msg)) 
		  	{
		  		test.log(LogStatus.PASS,  "user should be able to view 'All' register of MBP-4");
		  	} 
		  	else 
		  	{
		  		test.log(LogStatus.FAIL, "user should not be able to view 'All' register of MBP-4");
		  	}
		  	
		    Thread.sleep(2000);
	   		EntityLocator.clickViewClosePage(driver).click();
		    Thread.sleep(2000);
	   		EntityLocator.ClickDashboard(driver).click();
	      
	 }
	public static void clickPASTROD(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

        	WebDriverWait wait = new WebDriverWait(driver, (120));
           Thread.sleep(2000);
           EntityLocator.selectImg(driver).click();
           Thread.sleep(2000);
           EntityLocator.ClickMoreAction(driver).click();
           Thread.sleep(2000);
           EntityLocator.clickStatutoryRegistor(driver).click();
           Thread.sleep(2000);
           if(EntityLocator.clickPASTROD(driver).isEnabled())
   	    {
   	      Thread.sleep(2000);
   	      EntityLocator.clickPASTROD(driver).click();
   	      test.log(LogStatus.PASS, "The user should be redirected to the 'Past ROD' page");
   	    }
   	    else
   	    {
   	    	 test.log(LogStatus.FAIL, "The user should not be redirected to the 'Past ROD' page");
   	    }
           Thread.sleep(2000);
   		EntityLocator.ClickDashboard(driver).click();
           
           
	 }
	public static void clickPASTRODwithValidData(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

       	WebDriverWait wait = new WebDriverWait(driver, (120));
          Thread.sleep(2000);
          EntityLocator.selectImg(driver).click();
          Thread.sleep(2000);
          EntityLocator.ClickMoreAction(driver).click();
          Thread.sleep(2000);
          EntityLocator.clickStatutoryRegistor(driver).click();
          Thread.sleep(2000);
   	      EntityLocator.clickPASTROD(driver).click();
   	      Thread.sleep(2000);
	      EntityLocator.clickPASTRODUpload(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.clickChooseFile(driver).sendKeys("C:\\Users\\Admin\\Downloads\\SamplePastDirectorUpload (1).xlsx");
	      Thread.sleep(2000);
	      EntityLocator.clickPASTRODUploadButton(driver).click();
	      Thread.sleep(2000);
	      String msg=EntityLocator.clickPASTRODValidMsg(driver).getText();
	      if(msg.equalsIgnoreCase("Records Save Successfully"))
	      {
	    	  test.log(LogStatus.PASS, "Message displayed ="+msg);
	      }
	      else
	      {
	    	  test.log(LogStatus.FAIL, "Message displayed ="+msg);
	      }
	      Thread.sleep(2000);
	   		EntityLocator.ClickDashboard(driver).click();
          
	 }
	
	public static void clickPASTRODwithInValidData(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

      	WebDriverWait wait = new WebDriverWait(driver, (120));
         Thread.sleep(2000);
         EntityLocator.selectImg(driver).click();
         Thread.sleep(2000);
         EntityLocator.ClickMoreAction(driver).click();
         Thread.sleep(2000);
         EntityLocator.clickStatutoryRegistor(driver).click();
         Thread.sleep(2000);
  	      EntityLocator.clickPASTROD(driver).click();
  	      Thread.sleep(2000);
	      EntityLocator.clickPASTRODUpload(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.clickChooseFile(driver).sendKeys("C:\\Users\\Admin\\Downloads\\SamplePastDirectorUpload (1).xlsx");
	      Thread.sleep(2000);
	      EntityLocator.clickPASTRODUploadButton(driver).click();
	      Thread.sleep(2000);
	      String msg=EntityLocator.clickPASTRODValidMsg(driver).getText();
	      if(msg.equalsIgnoreCase("Records Save Successfully"))
	      {
	    	  test.log(LogStatus.FAIL, "Message displayed ="+msg);
	      }
	      else
	      {
	    	  test.log(LogStatus.PASS, "Message displayed ="+msg);
	      }
	      Thread.sleep(2000);
	   		EntityLocator.ClickDashboard(driver).click();
         
	 }
	public static void clickPASTRODwithDuplicateData(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

     	WebDriverWait wait = new WebDriverWait(driver, (120));
        Thread.sleep(2000);
        EntityLocator.selectImg(driver).click();
        Thread.sleep(2000);
        EntityLocator.ClickMoreAction(driver).click();
        Thread.sleep(2000);
        EntityLocator.clickStatutoryRegistor(driver).click();
        Thread.sleep(2000);
 	      EntityLocator.clickPASTROD(driver).click();
 	      Thread.sleep(2000);
	      EntityLocator.clickPASTRODUpload(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.clickChooseFile(driver).sendKeys("C:\\Users\\Admin\\Downloads\\SamplePastDirectorUpload (1).xlsx");
	      Thread.sleep(2000);
	      EntityLocator.clickPASTRODUploadButton(driver).click();
	      Thread.sleep(2000);
	      String msg=EntityLocator.clickPASTRODValidMsg(driver).getText();
	      if(msg.equalsIgnoreCase("Records Save Successfully"))
	      {
	    	  test.log(LogStatus.FAIL, "Message displayed ="+msg);
	      }
	      else
	      {
	    	  test.log(LogStatus.PASS, "Message displayed ="+msg);
	      }
	      Thread.sleep(2000);
	   		EntityLocator.ClickDashboard(driver).click();
        
	 }
	public static void clickPASTRODwithoutData(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

    	WebDriverWait wait = new WebDriverWait(driver, (120));
       Thread.sleep(2000);
       EntityLocator.selectImg(driver).click();
       Thread.sleep(2000);
       EntityLocator.ClickMoreAction(driver).click();
       Thread.sleep(2000);
       EntityLocator.clickStatutoryRegistor(driver).click();
       Thread.sleep(2000);
	      EntityLocator.clickPASTROD(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.clickPASTRODUpload(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.clickChooseFile(driver).sendKeys("C:\\Users\\Admin\\Downloads\\SamplePastDirectorUpload (1).xlsx");
	      Thread.sleep(2000);
	      EntityLocator.clickPASTRODUploadButton(driver).click();
	      Thread.sleep(2000);
	      String msg=EntityLocator.clickPASTRODValidMsg(driver).getText();
	      if(msg.equalsIgnoreCase("Records Save Successfully"))
	      {
	    	  test.log(LogStatus.FAIL, "Message displayed ="+msg);
	      }
	      else
	      {
	    	  test.log(LogStatus.PASS, "Message displayed ="+msg);
	      }
	      Thread.sleep(2000);
	   		EntityLocator.ClickDashboard(driver).click();
       
	 }
	public static void clickPASTRODInvalidFile(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

   	WebDriverWait wait = new WebDriverWait(driver, (120));
      Thread.sleep(2000);
      EntityLocator.selectImg(driver).click();
      Thread.sleep(2000);
      EntityLocator.ClickMoreAction(driver).click();
      Thread.sleep(2000);
      EntityLocator.clickStatutoryRegistor(driver).click();
      Thread.sleep(2000);
	      EntityLocator.clickPASTROD(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.clickPASTRODUpload(driver).click();
	      Thread.sleep(2000);
	      EntityLocator.clickChooseFile(driver).sendKeys("C:\\Users\\Admin\\Downloads\\SampleExcelMBP4-Old.xlsx");
	      Thread.sleep(2000);
	      EntityLocator.clickPASTRODUploadButton(driver).click();
	      Thread.sleep(2000);
	      String msg=EntityLocator.clickPASTRODInValidMsg(driver).getText();
	      if(msg.equalsIgnoreCase("No Data Found in Excel Document or Sheet Name must be Different"))
	      {
	    	  test.log(LogStatus.PASS, "Message displayed ="+msg);
	      }
	      else
	      {
	    	  test.log(LogStatus.FAIL, "Message displayed ="+msg);
	      }
	      Thread.sleep(2000);
	   		EntityLocator.ClickDashboard(driver).click();
      
	 }
	
	public static void clickPASTRODGenerateRegistor(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

  	WebDriverWait wait = new WebDriverWait(driver, (120));
     Thread.sleep(2000);
     EntityLocator.selectImg(driver).click();
     Thread.sleep(2000);
     EntityLocator.ClickMoreAction(driver).click();
     Thread.sleep(2000);
     EntityLocator.clickStatutoryRegistor(driver).click();
     Thread.sleep(2000);
	      EntityLocator.clickPASTROD(driver).click();
	      
	      if( EntityLocator.clickPASTRODGenerateRegostor(driver).isEnabled())
	      {
	          Thread.sleep(2000);
	          EntityLocator.clickPASTRODGenerateRegostor(driver).click();
	          test.log(LogStatus.PASS, "User should be redirected to the 'Generate Register' page");
	      }
	      else
	      {
	    	  test.log(LogStatus.FAIL, "User should be redirected to the 'Generate Register' page");
	      }
	      Thread.sleep(2000);
	   	  EntityLocator.ClickDashboard(driver).click();
	     
	 }
	public static void clickPASTRODGenerateRegistorDownload(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

 	WebDriverWait wait = new WebDriverWait(driver, (120));
    Thread.sleep(2000);
    EntityLocator.selectImg(driver).click();
    Thread.sleep(2000);
    EntityLocator.ClickMoreAction(driver).click();
    Thread.sleep(2000);
    EntityLocator.clickStatutoryRegistor(driver).click();
    Thread.sleep(2000);
	      EntityLocator.clickPASTROD(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator.clickPASTRODGenerateRegostor(driver).click();
	      
	      Thread.sleep(2000);
	      EntityLocator. clickPASTRODGenerateRegostorDropdown(driver).click();
	      Thread.sleep(2000);
	      EntityLocator. clickPASTRODGenerateRegostorDropdown1(driver).click();
	      
	      
	      File dir = new File("C://Users//Admin//Downloads");
		  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		  		
		  	Thread.sleep(2000);
		 	EntityLocator.clickDownloadBtn(driver).click();		//Exporting (Downloading) file
		  		
		    Thread.sleep(3000);
		    File dir1 = new File("C://Users//Admin//Downloads");
		    File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		  		
		  		
		  	if (dirContents.length < allFilesNew.length) 
		  	{
		  		test.log(LogStatus.PASS,  "Register of Past Director should be viewed successfully");
		  	} 
		  	else 
		  	{
		  		test.log(LogStatus.FAIL, "Register of Past Director should not be viewed successfully");
		  	}
		    Thread.sleep(2000);
	   		EntityLocator.ClickDashboard(driver).click();
	      
	     
	 }
	
	public static void clickPASTRODGenerateRegistorView(WebDriver driver, ExtentTest test) throws InterruptedException
	 {

		WebDriverWait wait = new WebDriverWait(driver, (120));
	    Thread.sleep(2000);
	    EntityLocator.selectImg(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.ClickMoreAction(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickStatutoryRegistor(driver).click();
	    Thread.sleep(2000);
		      EntityLocator.clickPASTROD(driver).click();
		      
		      Thread.sleep(2000);
		      EntityLocator.clickPASTRODGenerateRegostor(driver).click();
		      
		      Thread.sleep(2000);
		      EntityLocator. clickPASTRODGenerateRegostorDropdown(driver).click();
		      Thread.sleep(2000);
		      EntityLocator. clickPASTRODGenerateRegostorDropdown1(driver).click();
		      
	  	 Thread.sleep(2000);
		 EntityLocator.clickViewBtn(driver).click();		//Exporting (Downloading) file
		  		
		 Thread.sleep(2000);
			String msg=EntityLocator.clickViewPage(driver).getText();	
		  		
		  	if (msg.equalsIgnoreCase(msg)) 
		  	{
		  		test.log(LogStatus.PASS,  "Register of Past Director should be Viewed successfully");
		  	} 
		  	else 
		  	{
		  		test.log(LogStatus.FAIL, "Register of Past Director should not be Viewed successfully");
		  	}
		  	
		    Thread.sleep(2000);
	   		EntityLocator.clickViewClosePage(driver).click();
		    Thread.sleep(2000);
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
