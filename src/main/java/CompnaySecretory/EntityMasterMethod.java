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
		fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Snehal\\ComplianceLatest\\Secreterial\\TestData\\SecreterialSheet3.xlsx");
		
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
	    	 test.log(LogStatus.PASS, "Deemed Public Compnay is not Selected");
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
	    EntityLocator.clickEditIcon(driver).click();
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
	    EntityLocator.clickEditIcon(driver).click();
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
	    EntityLocator.clickEditIcon(driver).click();
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
	
	public static void AddBuisnessActivity(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void BAnotFound(WebDriver driver,ExtentTest test) throws InterruptedException
	{
	
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void WithoutEnterData(WebDriver driver,ExtentTest test) throws InterruptedException
	{

		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	
	public static void EditBAInvalidData(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
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
	
	public static void BACloseBtn(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
	EntityLocator.selectImg(driver).click();
	Thread.sleep(2000);
    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void DocumentTab(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
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
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCD");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Change Role Test Cases.xlsx");
	    
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
	    EntityLocator. ClickDescrition(driver).sendKeys("ABC");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Change Role Test Cases.xlsx");
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	    
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
	public static void DownloadDocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	
	    
	    
	    
	    File dir = new File("C://Users//Admin//Downloads");
	  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	  		
	  	Thread.sleep(2000);
	 	EntityLocator.ClickDownloadIcon(driver).click();		//Exporting (Downloading) file
	  		
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
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAOA(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCD");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Change Role Test Cases.xlsx");
	    
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
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	
	public static void ExistingAOADocument(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAOA(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCD");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Change Role Test Cases.xlsx");
	    
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
	    Thread.sleep(4000);
	     EntityLocator.ClickDashboard(driver).click();
	}
	
	
	public static void WithoutEnteringAOADocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
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
		    Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	}
	
	
	
	public static void ViewAOADocument(WebDriver driver,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	  
	   
	    
	    File dir = new File("C://Users//Admin//Downloads");
	  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	  		
	    Thread.sleep(2000);
	    EntityLocator.ClickDownloadAOAIcon(driver).click();	//Exporting (Downloading) file
	  		
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
	    EntityLocator.clickEditIcon(driver).click();
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCOI(driver).click();
	 
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("PQR");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Change Role Test Cases.xlsx");
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickCOI(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCD");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Change Role Test Cases.xlsx");
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	  
	    
	    
	    File dir = new File("C://Users//Admin//Downloads");
	  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	  		
	    Thread.sleep(2000);
	    EntityLocator.ClickDownloadCOIIcon(driver).click();	//Exporting (Downloading) file
	  		
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
	    EntityLocator.clickEditIcon(driver).click();
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickPolicy(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCD");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Change Role Test Cases.xlsx");
	    
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
	    
	public static void ExistingPolicyDoc(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCD");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Change Role Test Cases.xlsx");
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	 
	   
	    
	    File dir = new File("C://Users//Admin//Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		 Thread.sleep(2000);
		 EntityLocator.ClickDownloadAOAIcon(driver).click();		//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C://Users//Admin//Downloads");
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
	    EntityLocator.clickEditIcon(driver).click();
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickLicenseRegistration(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickLicenseRegistrationNo(driver).sendKeys("53467");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickLastRenewDate(driver).sendKeys("13-04-2023");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUpcomingRenewDate(driver).sendKeys("29-04-2023");
	    
	    Thread.sleep(2000);
	    EntityLocator. ClickDescrition(driver).sendKeys("Test");
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Act and Section Column Test Cases.xlsx");
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocumentTab(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickNewBtn(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickDocType(driver).click();
	    
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickAnnualReport(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickSerialNoOfAGM(driver).sendKeys("7365");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickLastRenewDate(driver).sendKeys("13-04-2023");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickFY(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.SelectFY(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator. ClickDescrition(driver).sendKeys("Test");
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Admin\\Downloads\\4_25_2023 11_02_26 AM.zip");
	    
	    Thread.sleep(4000);
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
	public static void AddBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		sheet = workbook.getSheetAt(0);
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
		EntityLocator.ClickName(driver).sendKeys("Pune");
		
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
	
	
	public static void InvaliddBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void WithoutEnteringDataBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void EditBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickEditIcon(driver).click();
	    
	  
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
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Committee Composition.pdf");
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Act and Event Act Group Test Cases.xlsx");
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Committee Composition.pdf");
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\file-sample_100kB.Doc");
	
	    
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
	    EntityLocator.clickEditIcon(driver).click();
	
	    Thread.sleep(2000);
	    EntityLocator.ClickBranchDetailes(driver).click();
	    
	    Thread.sleep(3000);
	    EntityLocator.ClickUploadDoc(driver).click();
	    
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Act and Event Act Group Test Cases.xlsx");
	    Thread.sleep(2000);
	    EntityLocator.SelectFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Act and Event Act Group Test Cases.xlsx");
	
	    
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
	
	
	public static void CloseBranchDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
	
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void BankDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void AddBankDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		sheet = workbook.getSheetAt(0);
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void DuplicateBankDetailes(WebDriver driver,ExtentTest test,XSSFWorkbook workbook) throws InterruptedException 
	{
		sheet = workbook.getSheetAt(0);
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	
	
	
	
	
	
	    
	public static void InvalidAccountNo(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void InvalidBankName(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void InvalidIFSC(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void DateBankDetailes(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	
	public static void UpdateBankDetailes(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void InvalidUpdateBankDetailes(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void DeleteBankDetailes(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	
	public static void DeleteBankDetailes1(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("U72266KA2002PLC030311",Keys.ENTER);
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
	    EntityLocator.clickAddNewBtn(driver).click();
	    Thread.sleep(2000);
	    EntityLocator.clickEntityType(driver).click();
	    List<WebElement>entitytype = driver.findElements(By.xpath("//ul[@id='ddlEntityType_listbox']/li"));
		selectOptionFromDropDown_bs(entitytype, "Limited Liability Partnership (LLP)");
		 
		  
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
			EntityLocator.LLPEntityName(driver).clear();
	    Thread.sleep(2000);
		EntityLocator.LLPEntityName(driver).sendKeys("LNT Pvt Ltd");
		
		  Thread.sleep(3000);
		  EntityLocator.LLPSaveE(driver).click();
		  
		  Thread.sleep(2000);
		    String Msg=EntityLocator.UpdateLLPValidMsg(driver).getText();
		    if(Msg.equalsIgnoreCase("Record Updated Successfully"))
		    {
		     
		      test.log(LogStatus.PASS, "Message Displayed = " +Msg);
		    }
		    else
		    {
		    	 test.log(LogStatus.FAIL, "Message Displayed = " +Msg);
		    }
		  
		  
		    Thread.sleep(4000);
		     EntityLocator.CloseEntity(driver).click();
		   
		     Thread.sleep(4000);
		     EntityLocator.ClickDashboard(driver).click();
	    
	}
	    
	public static void UpdateLLP(WebDriver driver,ExtentTest test) throws InterruptedException 
	{
		
	    WebDriverWait wait=new WebDriverWait(driver,20);
		Thread.sleep(2000);
		EntityLocator.selectImg(driver).click();
		Thread.sleep(2000);
	    EntityLocator.ClickFilter(driver).sendKeys("AAE-6302",Keys.ENTER);
	    Thread.sleep(2000);
	    EntityLocator.clickEditIcon(driver).click();
	    
	    Thread.sleep(2000);
			EntityLocator.LLPEntityName(driver).clear();
	    Thread.sleep(2000);
	    EntityLocator.LLPPin(driver).sendKeys("abcd");
		
		  Thread.sleep(3000);
		  EntityLocator.LLPSaveE(driver).click();
		  
		  Thread.sleep(2000);
		  String msg=EntityLocator.LLPINValidMsg(driver).getText();
		    
		     
		      test.log(LogStatus.PASS, "Message Displayed = " +msg);
		   
		    
		  
		  
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
	    EntityLocator.EditBALLP(driver).click();
	    
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
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCD");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Change Role Test Cases.xlsx");
	    
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
	    EntityLocator. ClickDescrition(driver).sendKeys("ABCD");
	    
	    Thread.sleep(2000);
	    EntityLocator.ClickFile(driver).sendKeys("C:\\Users\\Admin\\Documents\\Change Role Test Cases.xlsx");
	    
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
	
	    
	    
	    
	    File dir = new File("C://Users//Admin//Downloads");
	  	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	  		
	  	Thread.sleep(2000);
	 	EntityLocator.ClickDownloadIcon(driver).click();		//Exporting (Downloading) file
	  		
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
	
	
	 public static void selectOptionFromDropDown_bs(List<WebElement> options, String value) {
			
			for(WebElement option:options) {
				if(option.getText().equals(value)) {
					option.click();
					break;
				}
			}
		 }
	
	

}
