package CompanySecretoryTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CompnaySecretory.MyWorkspaceMethod;

public class MyWorkspaceTestCases 

{
	
	
	public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	
	public static XSSFSheet ReadExcel() throws IOException
	{

		fis = new FileInputStream("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\SecreterialSheet3.xlsx");
		
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	@BeforeTest

	void setBrowser() throws Exception
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//MyWorkspace.html",true);
		test = extent.startTest("Verify OpenBrowser");
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	@BeforeMethod

	void Login() throws InterruptedException, IOException
	{
	    XSSFSheet sheet = ReadExcel();
		//
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c2.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c3 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c3.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,"Compnay Secretory");		//Method of Login class to login user.

	}

	//@Test(priority=1)

	  void MyWorkspace() throws InterruptedException, IOException
	  {
		test = extent.startTest("My Workspace tab Verification");
		
		MyWorkspaceMethod.ClickMyWorkspace(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=2)

	  void ClickConcludedMeeting() throws InterruptedException, IOException
	  {
		test = extent.startTest("Concluded Meeting tab Verification");
		
		MyWorkspaceMethod.ClickConcludedMeeting(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
//@Test(priority=3)

	  void ClickNewButton() throws InterruptedException, IOException
	  {
		test = extent.startTest("New Button Verification");
		
		MyWorkspaceMethod.ClickNewButton(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=4)

	  void ClickEditButton() throws InterruptedException, IOException
	  {
		test = extent.startTest("Edit Button Verification");
		
		MyWorkspaceMethod.ClickEditButton(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=5)

	  void ClickMoreAction() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown Verification");
		
		MyWorkspaceMethod.ClickMoreAction(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=6)

	  void ClickComplianceTab() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Compliances tab Verification");
		
		MyWorkspaceMethod.ClickComplianceTab(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority=7)

	  void ClickDraftResolutionandMinuteTabTab() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab Verification");
		
		MyWorkspaceMethod.ClickDraftResolutionandMinuteTab(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority=8)

	  void ClickDraftResolutionandMinuteDownloadIcon() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab- Download Icon Verification");
		
		MyWorkspaceMethod.ClickDraftResolutionandMinuteDownloadIcon(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority=9)

	  void ClickAnnetureTab() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab -Annexure tab Verification");
		
		MyWorkspaceMethod.ClickAnnetureTab(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	@AfterMethod
	 
	 void Close()
	 {
		 driver.close(); 
	 }

}
