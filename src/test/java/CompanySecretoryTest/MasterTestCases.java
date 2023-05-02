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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CompnaySecretory.AuditorMasterMethod;
import CompnaySecretory.CommitteeCompositionMethod;
import CompnaySecretory.CommitteeMethod;
import CompnaySecretory.ConfigurationMasterMethod;
import CompnaySecretory.UserMasterMethod;


public class MasterTestCases {
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
		//String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Snehal\\ComplianceLatest\\Secreterial\\TestData\\SecreterialSheet3.xlsx");
		
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	@BeforeTest

	void setBrowser() throws Exception
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//CompanySecretory.html",true);
		test = extent.startTest("Verify OpenBrowser");
		
		
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 1)

	void Login() throws InterruptedException, IOException
	{
	
		test = extent.startTest("Secreterial Logging In - Company Secretory");
		//test.log(LogStatus.INFO, "Logging into system");
		

		XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c2.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c3 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c3.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,"Compnay Secretory");		//Method of Login class to login user.
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 2)
	
	void CommitteeMaster() throws InterruptedException, IOException
	{
		test = extent.startTest(" Committee Master  Verification");
		
		CommitteeMethod.Committee(driver, test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}

//@Test(priority = 3)

void CommitteComposition() throws InterruptedException, IOException
{
	test = extent.startTest(" Committe Composition Verification");
	
	CommitteeCompositionMethod.CommitteeComposition(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 4)

void AuditorMaster() throws InterruptedException, IOException
{
	test = extent.startTest(" Statutory Auditor Verfication");
	
	AuditorMasterMethod.StatutoryAuditor(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}




///@Test(priority = 4)

void AuditorMaster1() throws InterruptedException, IOException
{
	test = extent.startTest("Internal Auditor  Verification");
	
	AuditorMasterMethod.InternalAuditor(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 5)

void AuditorMaster2() throws InterruptedException, IOException
{
	test = extent.startTest(" Secretarial Auditor  Verification");
	
	AuditorMasterMethod.SecretarialAuditor(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 6)

void AuditorMaster3() throws InterruptedException, IOException
{
	test = extent.startTest(" Cost Auditor  Verification");
	
	AuditorMasterMethod.CostAuditor(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 7)

void AuditorMaster4() throws InterruptedException, IOException
{
	test = extent.startTest(" Create From Existing  tab  Verification");
	
	AuditorMasterMethod.CreateFromExisting(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 8)

void AuditorMaster5() throws InterruptedException, IOException
{
	test = extent.startTest(" Enter Valid And Invalid Data Verification");
	
	AuditorMasterMethod.AuditorPage(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 9)

void AuditorMaster6() throws InterruptedException, IOException
{
	test = extent.startTest(" Create New Tab  Verification");
	
	AuditorMasterMethod.CreateNewTab(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 10)

void AuditorMaster7() throws InterruptedException, IOException
{
	test = extent.startTest(" Edit and Delete Verification");
	
	AuditorMasterMethod.EditAuditor(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 11)

void AuditorMaster8() throws InterruptedException, IOException
{
	test = extent.startTest(" Upload File  Verification");
	
	AuditorMasterMethod.UploadFile(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 12)

void AuditorMaster9() throws InterruptedException, IOException
{
	test = extent.startTest(" Create From Existing tab  Verification");
	
	AuditorMasterMethod.CreateFromExisting1(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 13)

void AuditorMaster10() throws InterruptedException, IOException
{
	test = extent.startTest(" Auditor Master  Verification");
	
	AuditorMasterMethod.CreateFromExistingTab(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority = 14)

void ConfigurationMaster() throws InterruptedException, IOException
{
	test = extent.startTest(" Configuration Master  Verification");
	
	ConfigurationMasterMethod.ConfigurationMaster(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 15)

void UserMaster() throws InterruptedException, IOException
{
	test = extent.startTest(" User Master  Verification");
	
	UserMasterMethod.User(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

	
	

}
