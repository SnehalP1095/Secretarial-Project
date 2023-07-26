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
//	@Test(priority=7)

	  void ClickDraftResolutionandMinuteTabTab() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab Verification");
		
		MyWorkspaceMethod.ClickDraftResolutionandMinuteTab(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
//	@Test(priority=8)

	  void ClickDraftResolutionandMinuteDownloadIcon() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab- Download Icon Verification");
		
		MyWorkspaceMethod.ClickDraftResolutionandMinuteDownloadIcon(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=9)

	  void ClickAnnetureTab() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab -Annexure tab Verification");
		
		MyWorkspaceMethod.ClickAnnetureTab(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority=10)

	  void ClickAnnetureTabValidUploadFile() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab -Annexure tab -File Upload Verification");
		
		MyWorkspaceMethod.ClickAnnetureTabValidUploadFile(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=11)

	  void ClickAnnetureTabMultipleUploadFile() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab -Annexure tab - Multiple File Upload Verification");
		
		MyWorkspaceMethod.ClickAnnetureTabMultipleUploadFile(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=12)

	  void ClickAnnetureTabInvalidUploadFile() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab -Annexure tab - Invalid File Upload Verification");
		
		MyWorkspaceMethod.ClickAnnetureTabInvalidUploadFile(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=13)

	  void ClickAnnetureTabMultipleInvalidUploadFile() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab -Annexure tab - Multiple Invalid File Upload Verification");
		
		MyWorkspaceMethod.ClickAnnetureTabMultipleInvalidUploadFile(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=14)

	  void ClickAnnetureTabWithoutSelectingUploadFile() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab -Annexure tab - Without Selecting File Upload Verification");
		
		MyWorkspaceMethod.ClickAnnetureTabWithoutSelectingUploadFile(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
//	@Test(priority=15)

	  void ClickAnnetureTabViewFile() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab -Annexure tab - View  file Verification");
		
		MyWorkspaceMethod.ClickAnnetureTabViewFile(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=16)

	  void ClickAnnetureTabDownloadFile() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab -Annexure tab - Download file Verification");
		
		MyWorkspaceMethod.ClickAnnetureTabDownloadFile(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=17)

	  void ClickAnnetureTabDeleteFile() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown-Draft Resolution and Minute tab -Annexure tab - Delete file Verification");
		
		MyWorkspaceMethod.ClickAnnetureTabDeleteFile(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
//	@Test(priority=18)

	  void ClickMinutesTab() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown - Minutes  tab Verification");
		
		MyWorkspaceMethod.ClickMinutesTab(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=19)

	  void ClickMinutesTabDownloadIcon() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown - Minutes  tab - Download file  Verification");
		
		MyWorkspaceMethod.ClickMinutesTabDownloadIcon(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=20)

	  void ClickCertifiedTrueCopy() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown -Certified True Copy Tab  Verification");
		
		MyWorkspaceMethod.ClickCertifiedTrueCopy(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=21)

	  void ClickCTCPreviewIcon() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown -Certified True Copy Tab -Preview CTC View Icon  Verification");
		
		MyWorkspaceMethod.ClickCTCPreviewIcon(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=22)

	  void ClickCTCDownloadIcon() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown -Certified True Copy Tab - Download CTC in word  Icon  Verification");
		
		MyWorkspaceMethod.ClickCTCDownloadIcon(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=23)

	  void ClickCTCDownloadpdfIcon() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown -Certified True Copy Tab - Download CTC in PDF  Icon  Verification");
		
		MyWorkspaceMethod.ClickCTCDownloadpdfIcon(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=24)

	  void ClickUploadDocTab() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown -Upload document tab Verification");
		
		MyWorkspaceMethod.ClickUploadDocTab(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=25)

	  void ClickUploadDoc() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown -Upload document tab-Upload document file Verification");
		
		MyWorkspaceMethod.ClickUploadDoc(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=26)

	  void ClickMultipleUploadDoc() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown - Upload document tab-Upload Multiple document file Verification");
		
		MyWorkspaceMethod.ClickMultipleUploadDoc(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=27)

	  void ClickWithoutSelectingFile() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown - Upload document tab-Without Selecting file Verification");
		
		MyWorkspaceMethod.ClickWithoutSelectingFile(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=28)

	  void ClickViewFile() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown -Upload document tab- View file Verification");
		
		MyWorkspaceMethod.ClickViewFile(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority=29)

	  void ClickDownloadFile() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown -Upload document tab- Download file Verification");
		
		MyWorkspaceMethod.ClickDownloadFile(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority=30)

	  void ClickDeleteFile() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown -Upload document tab- Delete file Verification");
		
		MyWorkspaceMethod.ClickDeleteFile(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
//	@Test(priority=31)

	  void ClickCopyMeetingTab() throws InterruptedException, IOException
	  {
		test = extent.startTest("More Action dropdown -Copy Meeting tab- Delete file Verification");
		
		MyWorkspaceMethod.ClickCopyMeetingTab(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
		//@Test(priority=32)

		  void ClickCopyMeetingAgenda() throws InterruptedException, IOException
		  {
			test = extent.startTest("More Action dropdown -Copy Meeting tab- Copy Meeting Agenda Verification");
			
			MyWorkspaceMethod.ClickCopyMeetingAgenda(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		//@Test(priority=33)

		  void ClickCopyMeetingMultipleAgenda() throws InterruptedException, IOException
		  {
			test = extent.startTest("More Action dropdown -Copy Meeting tab- Copy Meeting Agenda(Select multiple entity from dropdown) Verification");
			
			MyWorkspaceMethod.ClickCopyMeetingMultipleAgenda(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		//@Test(priority=34)

		  void ClickCopyMeetingMultiplecheckboxAgenda() throws InterruptedException, IOException
		  {
			test = extent.startTest("More Action dropdown -Copy Meeting tab- Copy Meeting Agenda(all agenda should be selected after clicking on agenda checkbox button) Verification");
			
			MyWorkspaceMethod.ClickCopyMeetingMultiplecheckboxAgenda(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		//@Test(priority=35)

		  void ClickCopyMeetingAgendaWithoutEnterData() throws InterruptedException, IOException
		  {
			test = extent.startTest("More Action dropdown -Copy Meeting tab- Copy Meeting Agenda-Without Enter Data Verification");
			
			MyWorkspaceMethod.ClickCopyMeetingAgendaWithoutEnterData(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		//@Test(priority=36)

		  void ClickCopyMeetingAgendaCloseBtn() throws InterruptedException, IOException
		  {
			test = extent.startTest("More Action dropdown -Copy Meeting tab- Copy Meeting Agenda- Close button Verification");
			
			MyWorkspaceMethod.ClickCopyMeetingAgendaCloseBtn(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		//@Test(priority=37)

		  void ClickCopyMeetingAgendaLog() throws InterruptedException, IOException
		  {
			test = extent.startTest("More Action dropdown -Copy Meeting tab- Copy Meeting Agenda- Delete Log Verification");
			
			MyWorkspaceMethod.ClickCopyMeetingAgendaLog(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		//@Test(priority=38)

		  void ClickCopyMeetingAgendaDeleteNoBtn() throws InterruptedException, IOException
		  {
			test = extent.startTest("More Action dropdown -Copy Meeting tab- Copy Meeting Agenda- Delete Log (No Button) Verification");
			
			MyWorkspaceMethod.ClickCopyMeetingAgendaDeleteNoBtn(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority=39)

		  void ClickConcludedMeetingAdd() throws InterruptedException, IOException
		  {
			test = extent.startTest("My Workspace- Concluded Meeting -Add Tab Verification");
			
			MyWorkspaceMethod.ClickConcludedMeetingAdd(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		//@Test(priority=40)

		  void ClickMyCompliance() throws InterruptedException, IOException
		  {
			test = extent.startTest("My Workspace- My Compliance tab Verification");
			
			MyWorkspaceMethod.ClickMyCompliance(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		//@Test(priority=41)

		  void ClickMyComplianceEditBtn() throws InterruptedException, IOException
		  {
			test = extent.startTest("My Workspace- My Compliance tab -Edit Icon Verification");
			
			MyWorkspaceMethod.ClickMyComplianceEditBtn(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		//@Test(priority=42)

		  void ClickMyTask() throws InterruptedException, IOException
		  {
			test = extent.startTest("My Workspace- My Task tab Verification");
			
			MyWorkspaceMethod.ClickMyTask(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		//@Test(priority=43)

		  void AddTask() throws InterruptedException, IOException
		  {
			test = extent.startTest("My Workspace- My Task tab - Add Task -Meeting Type Verification");
			
			MyWorkspaceMethod.AddMyTaskMetting(driver, test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	//	@Test(priority=44)

		  void AddMyTaskAgenda() throws InterruptedException, IOException
		  {
			test = extent.startTest("My Workspace- My Task tab - Add Task- Agenda Type Verification");
			
			MyWorkspaceMethod.AddMyTaskAgenda(driver, test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
		//@Test(priority=45)

		  void AddMyTaskOther() throws InterruptedException, IOException
		  {
			test = extent.startTest("My Workspace- My Task tab - Add Task- Other Type Verification");
			
			MyWorkspaceMethod.AddMyTaskOther(driver, test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
		
		//@Test(priority=46)

		  void WithoutEnterDataTask() throws InterruptedException, IOException
		  {
			test = extent.startTest("My Workspace- My Task tab - Add Task-Without Enter Data Verification");
			
			MyWorkspaceMethod.WithoutEnterDataTask(driver, test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
		//@Test(priority=47)

		  void AddMyTaskCloseBtn() throws InterruptedException, IOException
		  {
			test = extent.startTest("My Workspace- My Task tab - Add Task-close button Verification");
			
			MyWorkspaceMethod.AddMyTaskCloseBtn(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		//@Test(priority=48)

		  void EditBtn() throws InterruptedException, IOException
		  {
			test = extent.startTest("My Workspace- My Task tab - Edit button Verification");
			
			MyWorkspaceMethod.EditBtn(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority=49)

		  void TaskViewDeatiles() throws InterruptedException, IOException
		  {
			test = extent.startTest("My Workspace- My Task tab - Task View Detailes Tab Verification");
			
			MyWorkspaceMethod.TaskViewDeatiles(driver, test);
			
			extent.endTest(test);
			extent.flush();
		}
	@AfterMethod
	 
	 void Close()
	 {
		 driver.close(); 
	 }

}
