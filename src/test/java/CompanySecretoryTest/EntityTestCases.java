package CompanySecretoryTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CompnaySecretory.CommitteeMethod;
import CompnaySecretory.EntityMasterMethod;

public class EntityTestCases {
	
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
		fis = new FileInputStream("E:\\Snehal\\ComplianceLatest\\Secretarial-Project-main\\Secretarial-Project-main\\TestData\\SecreterialSheet3.xlsx");
		
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	@BeforeTest

	void setBrowser() throws Exception
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//EntityMaster.html",true);
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
	
	/*@Test(priority = 2)
	
		void EntityType() throws InterruptedException, IOException
		{
			test = extent.startTest(" Entity Type Verification");
			
			EntityMasterMethod.DeemedPublicCompany(driver, test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}

	@Test(priority =3 )
	
	void TwoMandatoryFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Two Mandatory Fields Verification");
		
		EntityMasterMethod.TwoMandatoryFields(driver, test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
   @Test(priority = 4)
	
	void WithoutEnteringField() throws InterruptedException, IOException
	{
		test = extent.startTest("Without Entering  Fields Verification");
		
		EntityMasterMethod.WithouEnteringField(driver, test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
  @Test(priority = 5)

  void CloseBtn() throws InterruptedException, IOException
  {
	test = extent.startTest("Close Button Verification");
	
	EntityMasterMethod.CloseBtn(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

  @Test(priority = 6)

  void AddEntity() throws InterruptedException, IOException
 {
	test = extent.startTest(" Add DeemedPublic Company Verification");
	
	EntityMasterMethod.AddDeemedPublicCompany(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
 }
 @Test(priority = 7)

void EnterInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest(" Invalid Data Verification");
	
	EntityMasterMethod.EnterInvalidData(driver, test);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority = 8)

void EditIcon() throws InterruptedException, IOException
{
	test = extent.startTest("Update Entity Verification");
	
	EntityMasterMethod.EditIcon(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority = 9)

void InvalidEditIcon() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid field Entity Verification");
	
	EntityMasterMethod.InvalidEditIcon(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 10)

void EditCloseBtn() throws InterruptedException, IOException
{
	test = extent.startTest("Edit = Close Button Verification");
	
	EntityMasterMethod.EditCloseBtn(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 11)

void BuisnessActivity() throws InterruptedException, IOException
{
	test = extent.startTest("Buisness Activity Tab Verification");
	
	EntityMasterMethod.BuisnessActivity(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 12)

void AddBuisnessActivity() throws InterruptedException, IOException
{
	test = extent.startTest("Buisness Activity Tab Verification");
	
	EntityMasterMethod.AddBuisnessActivity(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 13)

void NoDataFound() throws InterruptedException, IOException
{
	test = extent.startTest("Buisness Activity Tab Verification");
	
	EntityMasterMethod.BAnotFound(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 14)

void WithOutEnterData() throws InterruptedException, IOException
{
	test = extent.startTest("Without Enter Data Buisness Activity  Verification");
	
	EntityMasterMethod.WithoutEnterData(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 15)

void EditBA() throws InterruptedException, IOException
{
	test = extent.startTest("Update Buisness Activity  Verification");
	
	EntityMasterMethod.EditBA(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 16)

void EditInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Data Buisness Activity  Verification");
	
	EntityMasterMethod.EditBAInvalidData(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 17)

void BADeleteIcon() throws InterruptedException, IOException
{
	test = extent.startTest("Delete Icon Buisness Activity  Verification");
	
	EntityMasterMethod.BADeleteIcon(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 18)

void BACloseBtn() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button Buisness Activity  Verification");
	
	EntityMasterMethod.BACloseBtn(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 19)

void DocumentTab() throws InterruptedException, IOException
{
	test = extent.startTest("Document tab  Verification");
	
	EntityMasterMethod.DocumentTab(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 20)

void AddDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Add Document Verification");
	
	EntityMasterMethod.AddNewDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 21)

void AlreadyExistDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Already Exists Document Verification");
	
	EntityMasterMethod.AlreadyExistDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 22)

void WithoutEnteringDoc() throws InterruptedException, IOException
{
	test = extent.startTest("Without Upload Document Verification");
	
	EntityMasterMethod.WithoutEnteringDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 23)

void ViewDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Document View Verification");
	
	EntityMasterMethod.ViewDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 24)

void DownloadDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Download Document Verification");
	
	EntityMasterMethod.DownloadDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 25)

void DeleteDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Delete Document Verification");
	
	EntityMasterMethod.DeleteDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 26)

void AddAOA() throws InterruptedException, IOException
{
	test = extent.startTest("Add Article of Association(AOA) Document Verification");
	
	EntityMasterMethod.AddAOA(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 27)

void ExistingAOADocument() throws InterruptedException, IOException
{
	test = extent.startTest("Existing Article of Association(AOA) Document Verification");
	
	EntityMasterMethod.ExistingAOADocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority = 28)

void WithoutEnterignAOADocument() throws InterruptedException, IOException
{
	test = extent.startTest("Without enetring Article of Association(AOA) Document Verification");
	
	EntityMasterMethod.WithoutEnteringAOADocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 29)

void ViewAOADocument() throws InterruptedException, IOException
{
	test = extent.startTest("Article of Association(AOA) Document View Verification");
	
	EntityMasterMethod.ViewAOADocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 30)

void DownloadAOADocument() throws InterruptedException, IOException
{
	test = extent.startTest("Article of Association(AOA)  Download Document Verification");
	
	EntityMasterMethod.DownloadAOADocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 31)

void DeleteAOADocument() throws InterruptedException, IOException
{
	test = extent.startTest("Article of Association(AOA)  Delete Document Verification");
	
	EntityMasterMethod.DeleteAOADocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority = 32)
void AddCOI() throws InterruptedException
{
	test=extent.startTest("Certificate of Incorporation(COI) Add Document Verification");
	
	EntityMasterMethod.AddCOI(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 33)
void ExistingCOIDocument() throws InterruptedException
{
	test=extent.startTest("Existing Certificate of Incorporation(COI)  Document Verification");
	
	EntityMasterMethod.ExistingCOIDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 34)

void WithoutEnterignCOIDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Without enetring Certificate of Incorporation(COI) Document Verification");
	
	EntityMasterMethod.WithoutEnteringCOIDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority =35)

void ViewCOIDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Certificate of Incorporation(COI) Document View Verification");
	
	EntityMasterMethod.ViewCOIDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 36)

void DownloadCOIDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Certificate of Incorporation(COI)  Download Document Verification");
	
	EntityMasterMethod.DownloadCOIDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 37)

void DeleteCOIDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Certificate of Incorporation(COI)  Delete Document Verification");
	
	EntityMasterMethod.DeleteCOIDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 38)

void AddPolicyDoc() throws InterruptedException, IOException
{
	test = extent.startTest("Add Policy  Document Verification");
	
	EntityMasterMethod.AddPolicyDoc(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 39)

void ExistingPolicyDoc() throws InterruptedException, IOException
{
	test = extent.startTest("Existing Policy  Document Verification");
	
	EntityMasterMethod.ExistingPolicyDoc(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 40)

void WithoutEnterignPolicyDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Without enetring Policy Document Verification");
	
	EntityMasterMethod.WithoutEnteringPolicyDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 41)

void ViewPolicyDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Policy Document View Verification");
	
	EntityMasterMethod.ViewPolicyDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 42)

void DownloadPolicyDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Policy  Download Document Verification");
	
	EntityMasterMethod.DownloadPolicyDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 43)

void DeletePolicyDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Policy  Delete Document Verification");
	
	EntityMasterMethod.DeletePolicyDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 44)

void AddLicenseRegistration() throws InterruptedException, IOException
{
	test = extent.startTest("Add License/Registration  Document Verification");
	
	EntityMasterMethod.AddLicenseRegistration(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 45)

void EnterInvalidDataLicenseRegistration() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Data License/Registration  Document Verification");
	
	EntityMasterMethod.EnterInvalidDataLicenseRegistration(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 46)

void WithoutEnteringLicenseRegistrationDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Without upload  License/Registration  Document Verification");
	
	EntityMasterMethod.WithoutEnteringLicenseRegistrationDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 47)

void AddExistingLicenseRegistration() throws InterruptedException, IOException
{
	test = extent.startTest("Add Existing License/Registration  Document Verification");
	
	EntityMasterMethod.AddExistingLicenseRegistration(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 48)

void ViewLicenseRegistrationDocument() throws InterruptedException, IOException
{
	test = extent.startTest("View  License/Registration  Document Verification");
	
	EntityMasterMethod.ViewLicenseRegistrationDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 49)

void DownloadLicenseRegistrationDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Download  License/Registration Document Verification");
	
	EntityMasterMethod.DownloadLicenseRegistrationDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 50)

void DeleteLicenseRegistrationDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Delete License/Registration Document Verification");
	
	EntityMasterMethod.DeleteLicenseRegistrationDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 51)

void AddAnnualReport() throws InterruptedException, IOException
{
	test = extent.startTest("Add Annual Report  Document Verification");
	
	EntityMasterMethod.AddAnnualReport(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 52)

void AddExistingDataAnnualReport() throws InterruptedException, IOException
{
	test = extent.startTest("Add Existing Data Annual Report  Document Verification");
	
	EntityMasterMethod.AddExistingDataAnnualReport(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 53)

void WithoutUploadFileAnnualReport() throws InterruptedException, IOException
{
	test = extent.startTest("Without Upload File Annual Report Verification");
	
	EntityMasterMethod.WithoutUploadFileAnnualReport(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 54)

void ViewAnnualReportDocument() throws InterruptedException, IOException
{
	test = extent.startTest("View  Annual Report  Document Verification");
	
	EntityMasterMethod.ViewAnnualReportDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 55)

void DownloadAnnualReportDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Download  Annual Report Document Verification");
	
	EntityMasterMethod.DownloadAnnualReportDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 56)

void DeleteAnnualReportDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Delete Annual Report Document Verification");
	
	EntityMasterMethod.DeleteAnnualReportDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 57)

void BranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Branch Detailes Verification");
	
	EntityMasterMethod.BranchDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 58)

void AddBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Add Branch Detailes Verification");
	
	EntityMasterMethod.AddBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 59)

void InvaliddBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Branch Detailes Verification");
	
	EntityMasterMethod.InvaliddBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 60)

void TwoMandatoryFieldsBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Two Mandatory Fields Branch Detailes Verification");
	
	EntityMasterMethod.TwoMandatoryFieldsBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 61)

void WithoutEnteringDataBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Without Entering Fields Branch Detailes Verification");
	
	EntityMasterMethod.WithoutEnteringDataBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 62)

void EditBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Update Branch Detailes Verification");
	
	EntityMasterMethod.EditBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 63)

void UploadDocBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Upload Document  Branch Detailes Verification");
	
	EntityMasterMethod.UploadDocBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 64)

void InvalidUploadDocBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Upload Document  Branch Detailes Verification");
	
	EntityMasterMethod.InvalidUploadDocBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 65)

void MultipleFileUploadDocBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Multiple File Upload Branch Detailes Verification");
	
	EntityMasterMethod.MultipleFileUploadDocBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 66)

void InvalidMultipleFileUploadDocBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Multiple File Upload Branch Detailes Verification");
	
	EntityMasterMethod.InvalidMultipleFileUploadDocBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 67)

void WithoutUploadDocBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Without Upload File Branch Detailes Verification");
	
	EntityMasterMethod.WithoutUploadDocBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 68)

void CloseBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button Branch Detailes Verification");
	
	EntityMasterMethod.CloseBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 69)

void BankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest(" Bank Detailes Verification");
	
	EntityMasterMethod.BankDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority = 70)

void AddBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Add Bank Detailes Verification");
	
	EntityMasterMethod.AddBankDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 71)

void DuplicateBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Duplicate Bank Detailes Verification");
	
	EntityMasterMethod.DuplicateBankDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 72)

void InvalidAccountNo() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Account No Verification");
	
	EntityMasterMethod.InvalidAccountNo(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 73)

void InvalidBankName() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Bank Name Verification");
	
	EntityMasterMethod.InvalidBankName(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 74)

void InvalidIFSC() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Bank IFSC Number Verification");
	
	EntityMasterMethod.InvalidIFSC(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 75)

void DateBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Opening date is greater than closing date Verification");
	
	EntityMasterMethod.DateBankDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 76)

void WithoutEnterBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Without Enter Bank Detailes Verification");
	
	EntityMasterMethod.WithoutEnterBankDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 77)

void UpdateBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Update Bank Detailes Verification");
	
	EntityMasterMethod.UpdateBankDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 78)

void InvalidUpdateBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Update Bank Detailes Verification");
	
	EntityMasterMethod.InvalidUpdateBankDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 79)

void DeleteBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Delete Confirmation Bank Detailes Verification");
	
	EntityMasterMethod.DeleteBankDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 80)

void DeleteBankDetailes1() throws InterruptedException, IOException
{
	test = extent.startTest(" Cancel button Bank Detailes Verification");
	
	EntityMasterMethod.DeleteBankDetailes1(driver, test);
	
	extent.endTest(test);
	extent.flush();
}


        ------------------------ LimitedLiabilityPartnership--------------------------------------------
@Test(priority = 81)

void LimitedLiabilityPartnership() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Verification");
	
	EntityMasterMethod.LimitedLiabilityPartnership(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 82)

void AddLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Add Limited Liability Partnership Verification");
	
	EntityMasterMethod.AddLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 83)

void EnterInvalidDataLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Enter Invalid Data Limited Liability Partnership Verification");
	
	EntityMasterMethod.EnterInvalidDataLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 84)

void DuplicateLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Duplicate Limited Liability Partnership Verification");
	
	EntityMasterMethod.DuplicateLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 85)

void TwoMandatoryLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Two Mandatory Fields Limited Liability Partnership Verification");
	
	EntityMasterMethod.TwoMandatoryLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 86)

void WithoutEnteringFieldsLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Without Entering Fields Limited Liability Partnership Verification");
	
	EntityMasterMethod.WithoutEnteringFieldsLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 87)

void CloseButtonLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Close Button Limited Liability Partnership Verification");
	
	EntityMasterMethod.CloseButtonLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 88)

void UpdateLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Update Limited Liability Partnership Verification");
	
	EntityMasterMethod.UpdateLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =89)

void InvalidUpdateLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Update Limited Liability Partnership Verification");
	
	EntityMasterMethod.InvalidUpdateLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 90)

void EditCloseButtonLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Edit Close Button Limited Liability Partnership Verification");
	
	EntityMasterMethod.CloseButtonLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 91)

void BuisnessActivityLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Buisness Activity Tab Limited Liability Partnership Verification");
	
	EntityMasterMethod.BuisnessActivityLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 92)

void AddBuisnessActivityLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Add Buisness Activity Tab Limited Liability Partnership Verification");
	
	EntityMasterMethod.AddBuisnessActivityLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 93)

void NoDataFoundLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Business activity' dropdown is not Activated -Buisness Activity Tab Limited Liability Partnership Verification");
	
	EntityMasterMethod.LLPBAnotFound(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 94)

void WithOutEnterDataLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Without Enter Data Limited Liability Partnership Buisness Activity  Verification");
	
	EntityMasterMethod.WithoutEnterDataBALLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 95)

void EditLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Update Limited Liability Partnership Buisness Activity   Verification");
	
	EntityMasterMethod.EditBALLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 96)

void EditInvalidDataLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Data Limited Liability Partnership Buisness Activity  Verification");
	
	EntityMasterMethod.EditInvalidDataLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 97)

void BADeleteIconLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Delete Icon Limited Liability Partnership Buisness Activity  Verification");
	
	EntityMasterMethod.BADeleteIconLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 98)

void BACloseBtnLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button Limited Liability Partnership Buisness Activity  Verification");
	
	EntityMasterMethod.BACloseBtnLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 99)

void DocumentTabLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Document tab  Verification");
	
	EntityMasterMethod.DocumentTabLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 100)

void AddDocumentLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership (COI) Add Document Verification");
	
	EntityMasterMethod.AddNewDocumentLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 101)

void AlreadyExistDocumentLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Already (COI)Exists Document Verification");
	
	EntityMasterMethod.AlreadyExistDocumentLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 102)

void WithoutEnteringDocLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership(COI) Without Upload Document Verification");
	
	EntityMasterMethod.WithoutEnteringDocumentLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 103)

void ViewDocumentLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership (COI) Document View Verification");
	
	EntityMasterMethod.ViewDocumentLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 104)

void DownloadDocumentLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership (COI) Download Document Verification");
	
	EntityMasterMethod.DownloadDocumentLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 105)

void DeleteDocumentLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership (COI)Delete Document Verification");
	
	EntityMasterMethod.DeleteDocumentLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 106)

void AddDocumentLLPDEED() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership DEED Add Document Verification");
	
	EntityMasterMethod.AddNewDocumentLLPDEED(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 107)

void WithoutEnteringDocumentLLPDEED() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership DEED Without Upload Document Verification");
	
	EntityMasterMethod.WithoutEnteringDocumentLLPDEED(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 108)

void AddExistingDocumentLLPDEED() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership DEED Add Existing Document Verification");
	
	EntityMasterMethod.AddExistingDocumentLLPDEED(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 109)

void ViewDocumentLLPDEED() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership DEED View Document Verification");
	
	EntityMasterMethod.ViewDocumentLLPDEED(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 110)

void DownloadDocumentLLPDEED() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership DEED Download Document Verification");
	
	EntityMasterMethod.DownloadDocumentLLPDEED(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =111)

void DeleteDocumentLLPDEED() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership DEED Delete Document Verification");
	
	EntityMasterMethod.DeleteDocumentLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 112)

void AddPolicyDocLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Add Policy  Document Verification");
	
	EntityMasterMethod.AddPolicyDocLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 113)

void WithoutEnteringDocumentPolicyLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Policy Without Upload Document Verification");
	
	EntityMasterMethod.WithoutEnteringDocumentLLPDEED(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 114)

void AddExistingDocumentPolicyLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Policy Add Existing Document Verification");
	
	EntityMasterMethod.AddExistingDocumentPolicyLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 115)

void ViewDocumentPolicyLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Policy View Document Verification");
	
	EntityMasterMethod.ViewDocumentPolicyLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 116)

void DownloadDocumentPolicyLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Policy Download Document Verification");
	
	EntityMasterMethod.DownloadDocumentPolicyLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 117)

void DeleteDocumentPolicyLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Policy Delete Document Verification");
	
	EntityMasterMethod.DeleteDocumentPolicyLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 118)

void AddDocumentLicenseRegistrationLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership License/Registration Add Document Verification");
	
	EntityMasterMethod.AddLicenseRegistrationDocLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 119)

void WithoutEnteringDocumenLicenseRegistrationLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership LicensecRegistration Without Upload Document Verification");
	
	EntityMasterMethod.WithoutEnteringDocumentLicenseRegistrationLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 120)

void AddExistingDocumenLicenseRegistrationLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership LicensecRegistration Add Existing  Document Verification");
	
	EntityMasterMethod.AddExistingLicenseRegistrationDocLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 121)

void ViewDocumentLicenseRegistrationLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership License/Registration View Document Verification");
	
	EntityMasterMethod.ViewDocumentLicenseRegistrationLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 122)

void DownloadDocumentLicenseRegistraionLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership License/Registration Download Document Verification");
	
	EntityMasterMethod.DownloadDocumentLicenseRegistraionLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority =123)

void DeleteDocumentLicenseRegistrationLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership License/Registration Delete Document Verification");
	
	EntityMasterMethod.DeleteDocumentLicenseRegistrationLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 124)

void AddDocumentAnnualReportLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Annual Report Add Document Verification");
	
	EntityMasterMethod.AddAnnualReportLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 125)

void AddExistingAnnualReportLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Annual Report Add Existing Document Verification");
	
	EntityMasterMethod.AddExistingAnnualReportLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 126)

void WithoutEnteringDocumentAnnualReportLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Annual Report Without Upload Document Verification");
	
	EntityMasterMethod.WithoutEnteringDocumentAnnualReportLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 127)

void ViewDocumentAnnualReportLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Annual Report View Document Verification");
	
	EntityMasterMethod.ViewDocumentAnnualReportLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 128)

void DownloadDocumentAnnualReportLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Annual Report Download Document Verification");
	
	EntityMasterMethod.DownloadDocumentAnnualReportLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority =129)

void DeleteDocumentAnnualReportLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Annual Report Delete Document Verification");
	
	EntityMasterMethod.DeleteDocumentAnnualReportLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 130)

void BranchDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Branch Detailes LLP Verification");
	
	EntityMasterMethod.BranchDetailesLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 131)

void AddBranchDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Add  Branch Detailes LLP Verification");
	
	EntityMasterMethod.AddBranchDetailesLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 132)

void InvaliddBranchDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid LLP Branch Detailes Verification");
	
	EntityMasterMethod.InvaliddBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 133)

void WithoutEnteringDataBranchDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Without Entering Fields LLP Branch Detailes Verification");
	
	EntityMasterMethod.WithoutEnteringDataBranchDetailesLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 134)

void TwoMandatoryFieldsBranchDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Two Mandatory Fields Branch Detailes LLP Verification");
	
	EntityMasterMethod.TwoMandatoryFieldsBranchDetailesLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 135)

void EditBranchDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Update Branch Detailes LLP Verification");
	
	EntityMasterMethod.EditBranchDetailesLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 136)

void UploadDocBranchDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Upload Document  Branch Detailes LLP Verification");
	
	EntityMasterMethod.UploadDocBranchDetailesLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 137)

void InvalidUploadDocBranchDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Upload Document  Branch Detailes LLP Verification");
	
	EntityMasterMethod.InvalidUploadDocBranchDetailesLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 138)

void MultipleFileUploadDocBranchDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Multiple File Upload Branch Detailes LLP Verification");
	
	EntityMasterMethod.MultipleFileUploadDocBranchDetailesLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =139)

void InvalidMultipleFileUploadDocBranchDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Multiple File Upload Branch Detailes LLP Verification");
	
	EntityMasterMethod.InvalidMultipleFileUploadDocBranchDetailesLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 140)

void WithoutUploadDocBranchDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Without Upload File Branch Detailes LLP Verification");
	
	EntityMasterMethod.WithoutUploadDocBranchDetailesLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 141)

void CloseBranchDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button Branch Detailes LLP Verification");
	
	EntityMasterMethod.CloseBranchDetailesLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 142)

void BankDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Bank Detailes LLP Verification");
	
	EntityMasterMethod.BankDetailesLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority = 143)

void AddBankDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Add Bank Detailes LLP Verification");
	
	EntityMasterMethod.AddBankDetailesLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 144)

void DuplicateBankDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Duplicate Bank Detailes LLP Verification");
	
	EntityMasterMethod.DuplicateBankDetailesLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 145)

void InvalidAccountNoLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Account No LLP Verification");
	
	EntityMasterMethod.InvalidAccountNoLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 146)

void InvalidBankNameLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Bank Name LLP Verification");
	
	EntityMasterMethod.InvalidBankNameLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 147)

void InvalidIFSCLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid IFSC LLP Verification");
	
	EntityMasterMethod.InvalidIFSCLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 148)

void DateBankDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Opening date is greater than closing date Verification");
	
	EntityMasterMethod.DateBankDetailesLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 149)

void WithoutEnterBankDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Without Enter Bank Detailes LLP Verification");
	
	EntityMasterMethod.WithoutEnterBankDetailesLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 2)

void UpdateBankDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Update Bank Detailes LLP Verification");
	
	EntityMasterMethod.UpdateBankDetailesLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 3)

void InvalidUpdateBankDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Update Bank Detailes LLP Verification");
	
	EntityMasterMethod.InvalidUpdateBankDetailesLLP (driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 149)

void DeleteBankDetailesLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Delete Confirmation Bank Detailes LLP Verification");
	
	EntityMasterMethod.DeleteBankDetailesLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 150)

void DeleteBankDetailes1LLP() throws InterruptedException, IOException
{
	test = extent.startTest("Delete  Cancel Bank Detailes LLP Verification");
	
	EntityMasterMethod.DeleteBankDetailes1LLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 154)

void ValidDataEntityExcelUpload() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Valid Data Entity Excel Upload File Verification");
	
	EntityMasterMethod.EntityExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 155)

void InvalidDataEntityExcelUpload() throws InterruptedException, IOException
{
	test = extent.startTest("Enter InValid Data Entity Excel Upload File Verification");
	
	EntityMasterMethod.InvalidDataEntityExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 156)

void ExistingDataEntityExcelUpload() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Existing Data Entity Excel Upload File Verification");
	
	EntityMasterMethod.EnterExistingDataEntityExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 157)

void WithoutEnteringDataEntityExcelUpload() throws InterruptedException, IOException
{
	test = extent.startTest("Without Entering Data Entity Excel Upload File Verification");
	
	EntityMasterMethod.WithoutEnteringDataEntityExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 158)

void EnterInvalidEntityExcelUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest("Upload Invalid file Entity Excel Verification");
	
	EntityMasterMethod.EnterInvalidEntityExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 159)

void WithoutselectingfileEntityExcelUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest("Without selecting a file Entity Excel Verification");
	
	EntityMasterMethod.WithoutSelectingFileEntityExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 160)

void LLPExcelUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Valid LLP Excel Verification");
	
	EntityMasterMethod.LLPExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 161)

void InvalidDataLLPExcelUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest("Enter InValid Data In LLP Excel Verification");
	
	EntityMasterMethod.InvalidDataLLPExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 162)

void EnterExistingDataInvalidDataLLPExcelUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Existing Data In LLP Excel Verification");
	
	EntityMasterMethod.EnterExistingDataLLPExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 163)

void WithoutEnteringDataLLPExcelUpload() throws InterruptedException, IOException
{
	test = extent.startTest("Without Entering Data LLP Excel Upload File Verification");
	
	EntityMasterMethod.WithoutEnteringDataLLPExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 164)

void EnterInvalidLLPExcelUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest("Upload Invalid file LLP Excel Verification");
	
	EntityMasterMethod.EnterInvalidLLPExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 165)

void WithoutselectingfileLLPExcelUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest("Without selecting a file LLP Excel Verification");
	
	EntityMasterMethod.WithoutSelectingFileLLPExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 166)

void MGT7ExcelUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest("Upload Valid file MGT-7 Excel Verification");
	
	EntityMasterMethod.MGT7ExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 167)

void MGT7ExcelInvalidUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest("Upload InValid file(uploading a different file format except pdf) MGT-7 Excel Verification");
	
	EntityMasterMethod.MGT7ExcelInvalidUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 168)

void MGT7ExcelDiffInvalidUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest("Upload InValid Multiple(PDF file) file MGT-7 Excel Verification");
	
	EntityMasterMethod.MGT7ExcelDiffPDFInvalidUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 169)

void MGT7ExcelExistingUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest("Upload Existing file MGT-7 Excel Verification");
	
	EntityMasterMethod.MGT7ExcelExistingUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 170)

void WithoutselectingfileMGT7ExcelUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest("Without selecting a file MGT-7 Excel Verification");
	
	EntityMasterMethod.WithoutSelectingFileMGT7ExcelUploadFile(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 171)

void ClickImport() throws InterruptedException, IOException
{
	test = extent.startTest("Import Button is clickable or not ");
	
	EntityMasterMethod.ClickImport(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 172)

void ClickImportCheckBox() throws InterruptedException, IOException
{
	test = extent.startTest("CheckBox is Selected or not ");
	
	EntityMasterMethod.ClickImportCheckBox(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 173)

void ValidationOfSaveBtn() throws InterruptedException, IOException
{
	test = extent.startTest("In Import Tab -Select chcekbox- click on save Button ");
	
	EntityMasterMethod.ValidationOfSaveBtn(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 174)

void SearchFieldImportTab() throws InterruptedException, IOException
{
	test = extent.startTest("In Import Tab Search Filed Verification ");
	
	EntityMasterMethod.SearchFieldImportTab(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =175)

void SearchFieldEntityTab() throws InterruptedException, IOException
{
	test = extent.startTest("In Entity Tab Search Filed Verification ");
	
	EntityMasterMethod.SearchFieldEntityTab(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 176)

void ClickApplicabilty() throws InterruptedException, IOException
{
	test = extent.startTest("Applicability Option is clickable or not ");
	
	EntityMasterMethod.ClickApplicabilty(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 177)

void ClickAmountInINR() throws InterruptedException, IOException
{
	test = extent.startTest("Save Applicability Verification");
	
	EntityMasterMethod.SaveApplicability(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 178)

void YesRadioBtnApplicability() throws InterruptedException, IOException
{
	test = extent.startTest("Yes Radio Btn Applicability Verification");
	
	EntityMasterMethod.YesRadioBtnApplicability(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 179)

void NoRadioBtnApplicability() throws InterruptedException, IOException
{
	test = extent.startTest("No Radio Btn Applicability Verification");
	
	EntityMasterMethod.NoRadioBtnApplicability(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 180)

void CloseApplicability() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button Applicability Verification ");
	
	EntityMasterMethod.CloseApplicability(driver, test);
	
	extent.endTest(test);
	extent.flush();
}*/

@Test(priority = 181)

void ClickShareHoldingOption() throws InterruptedException, IOException
{
	test = extent.startTest("ShareHolding Verification ");
	
	EntityMasterMethod.ClickShareHoldingOption(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 182)

void AddShareHolding() throws InterruptedException, IOException
{
	test = extent.startTest("ShareHolding Verification ");
	
	EntityMasterMethod.AddShareHolding(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 183)

void ClickShareHoldingDeatils() throws InterruptedException, IOException
{
	test = extent.startTest("ShareHolding Detailes Verification ");
	
	EntityMasterMethod.ClickShareHoldingDeatils(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 184)

void AddShareHoldingDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("ShareHolding Detailes Verification ");
	
	EntityMasterMethod.ShareHoldingDeatils(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 185)

void EnterInvaliddataFoliooftransferor() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid data Folio of transferor ShareHolding Detailes Verification ");
	
	EntityMasterMethod.EnterInvaliddataFoliooftransferor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 186)

void WithoutEnterDataInSahreHoldingDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Without Enter Data In ShareHolding Detailes Verification ");
	
	EntityMasterMethod.WithoutEnterDataInSahreHoldingDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 187)

void CloseBtnSahreHoldingDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button ShareHolding Detailes Verification ");
	
	EntityMasterMethod.CloseBtnSahreHoldingDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 188)

void UploadFileShareHoldingDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Upload File ShareHolding Detailes Verification ");
	
	EntityMasterMethod.UploadFileShareHoldingDeatils(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 189)

void UploadExistingFileShareHoldingDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Upload Existing File ShareHolding Detailes Verification ");
	
	EntityMasterMethod.UploadExistingFileShareHoldingDeatils(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 190)

void InvalidDataUploadFileShareHoldingDeatils() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Data in Upload File ShareHolding Detailes Verification ");
	
	EntityMasterMethod.InvalidDataUploadFileShareHoldingDeatils(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 191)

void EmptyDataUploadshareHoldingDeatils() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Empty Data in Upload file ShareHolding Detailes Verification ");
	
	EntityMasterMethod.EmptyDataUploadshareHoldingDeatils(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 192)

void InvalidFileUploadShareHoldingDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Upload file ShareHolding Detailes Verification ");
	
	EntityMasterMethod.InvalidFileUploadShareHoldingDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 193)

void WithoutSelectingFileUploadShareHoldingDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Without Selecting Upload file ShareHolding Detailes Verification ");
	
	EntityMasterMethod.WithoutSelectingFileUploadShareHoldingDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority = 194)

void UploadFileSahreHolding() throws InterruptedException, IOException
{
	test = extent.startTest("Upload File ShareHolding  Verification ");
	
	EntityMasterMethod.UploadShareHolding(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 195)

void ExistingUploadFileSahreHolding() throws InterruptedException, IOException
{
	test = extent.startTest("Upload Existing File ShareHolding  Verification ");
	
	EntityMasterMethod.UploadExistingFileShareHolding(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =196)
void InvalidUploadShareHolding() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid  Data  Upload Existing File ShareHolding  Verification ");
	
	EntityMasterMethod.InvalidUploadShareHolding(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 197)
void EmptyFileUploadShareHolding() throws InterruptedException, IOException
{
	test = extent.startTest("Empty File Uploads shareHolding  Verification ");
	
	EntityMasterMethod.EmptyFileUploadShareHolding(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 198)
void InvalidFileUploadShareHolding() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid File Upload ShareHolding Verification ");
	
	EntityMasterMethod.InvalidFileUploadShareHolding(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 199)
void WithoutSelectingFileUploadShareHolding() throws InterruptedException, IOException
{
	test = extent.startTest("Without selecting File Upload ShareHolding Verification ");
	
	EntityMasterMethod.WithoutSelectingFileUploadShareHolding(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 200)
void ClickShareHoldingPattern() throws InterruptedException, IOException
{
	test = extent.startTest("ShareHolding Pattern Button is clickable or not ");
	
	EntityMasterMethod.ClickShareHoldingPattern(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 201)
void AddCategoryMaster() throws InterruptedException, IOException
{
	test = extent.startTest("Add Category Master ShareHolding Verification ");
	
	EntityMasterMethod.AddCategoryMaster(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 202)
void UploadShareholdingCategoryMaster() throws InterruptedException, IOException
{
	test = extent.startTest("Upload file  Category Master ShareHolding Verification ");
	
	EntityMasterMethod.UploadShareholdingCategoryMaster(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =203)
void EnterInvalidDataUploadShareholdingCategoryMaster() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Data Upload file Category Master ShareHolding Verification ");
	
	EntityMasterMethod.EnterInvalidDataUploadShareholdingCategoryMaster(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 204)
void EnterInvalidDateUploadShareholdingCategoryMaster() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Date Upload file Category Master ShareHolding Verification ");
	
	EntityMasterMethod.EnterInvalidDateUploadShareholdingCategoryMaster(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 205)
void EnterEmptyDataUploadShareholdingCategoryMaster() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Empty data Upload file Category Master ShareHolding Verification ");
	
	EntityMasterMethod.EnterEmptyDataUploadShareholdingCategoryMaster(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 206)
void InvalidUploadFileShareholdingCategoryMaster() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Upload file Category Master ShareHolding Verification ");
	
	EntityMasterMethod.InvalidUploadFileShareholdingCategoryMaster(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 207)
void WithoutUploadFileShareholdingCategoryMaster() throws InterruptedException, IOException
{
	test = extent.startTest("Without Selecting File Category Master ShareHolding Verification ");
	
	EntityMasterMethod.WithoutUploadFileShareholdingCategoryMaster(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 208)
void ClickShareHoldingHistorical() throws InterruptedException, IOException
{
	test = extent.startTest("ShareHolding Historical Button is clickable or not ");
	
	EntityMasterMethod.ClickShareHoldingHistorical(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 209)
void EnterInvalidDateShareHoldingHistorical() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Date In ShareHolding Historical Verification ");
	
	EntityMasterMethod.EnterInvalidDateShareHoldingHistorical(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 210)
void EmptyDateShareHoldingHistorical() throws InterruptedException, IOException
{
	test = extent.startTest("Empty Date In ShareHolding Historical Verification ");
	
	EntityMasterMethod.EmptyDateShareHoldingHistorical(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 211)
void ClearButtonShareHoldingHistorical() throws InterruptedException, IOException
{
	test = extent.startTest("Clear Button ShareHolding Historical Verification ");
	
	EntityMasterMethod.ClearButtonShareHoldingHistorical(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 212)
void ViewButtonShareHoldingHistorical() throws InterruptedException, IOException
{
	test = extent.startTest("View Button ShareHolding Historical Verification ");
	
	EntityMasterMethod.ViewButtonShareHoldingHistorical(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 213)
void DownloadButtonShareHoldingHistorical() throws InterruptedException, IOException
{
	test = extent.startTest("Download Button ShareHolding Historical Verification ");
	
	EntityMasterMethod.DownloadButtonShareHoldingHistorical(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 214)
 void EditBtnShareHolding() throws InterruptedException, IOException
{
	test = extent.startTest("Edit Button ShareHolding Verification ");
	
	EntityMasterMethod.EditBtnShareHoldingDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =215)
void UpdateShareHolding() throws InterruptedException, IOException
{
	test = extent.startTest("Update ShareHolding Verification ");
	
	EntityMasterMethod.UpdateShareHolding(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =216)
void EnterInvalidDataShareHolding() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Data ShareHolding Verification ");
	
	EntityMasterMethod.EnterInvalidDataShareHolding(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =217)
void CloseBtnShareHolding() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button ShareHolding Verification ");
	
	EntityMasterMethod.CloseBtnShareHolding(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =218)
void DeleteYesShareHolding() throws InterruptedException, IOException
{
	test = extent.startTest("Delete Button ShareHolding Verification ");
	
	EntityMasterMethod.DeleteShareHolding(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 219)
void DeleteNoIconShareHolding() throws InterruptedException, IOException
{
	test = extent.startTest("Cancel Button ShareHolding Verification ");
	
	EntityMasterMethod.DeleteNoIconShareHolding(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 220)
void ClickShareCertificateBtn() throws InterruptedException, IOException
{
	test = extent.startTest("Share Certificate Button is clickable or not ");
	
	EntityMasterMethod.ClickShareCertificateBtn(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =221)
void WithoutEnteringDataShareCertificate() throws InterruptedException, IOException
{
	test = extent.startTest("Without Entering data  Share Certificate Verification ");
	
	EntityMasterMethod.WithoutEnteringDataShareCertificate(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 222)
void AddShareCertificate() throws InterruptedException, IOException
{
	test = extent.startTest("Add Share Certificate Verification ");
	
	EntityMasterMethod.AddShareCertificate(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 223)
void ViewShareCertificate() throws InterruptedException, IOException
{
	test = extent.startTest(" View Share Certificate Document  Verification ");
	
	EntityMasterMethod.ViewShareCertificate(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 224)
void DownloadShareCertificate() throws InterruptedException, IOException
{
	test = extent.startTest(" Download Share Certificate Document  Verification ");
	
	EntityMasterMethod.DownloadShareCertificate(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 225)
void DownloadShareCertificateAfterSaving() throws InterruptedException, IOException
{
	test = extent.startTest("After Saving Download Share Certificate Document  Verification ");
	
	EntityMasterMethod.DownloadShareCertificateAfterSaving(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 226)
void Managementpersonnel() throws InterruptedException, IOException
{
	test = extent.startTest("Management personnel Option is Clickable or not ");
	
	EntityMasterMethod.Managementpersonnel(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 227)
void ManagementpersonnelExportToPDF() throws InterruptedException, IOException
{
	test = extent.startTest("Export To Pdf File Management personnel Verification");
	
	EntityMasterMethod.ManagementpersonnelExportToPDF(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 228)
void ClickCommitte() throws InterruptedException, IOException
{
	test = extent.startTest("Committees option is clickable or not");
	
	EntityMasterMethod.ClickCommitte(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 229)
void ClickCloseBtnOfCommitte() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button of Committees option is clickable or not");
	
	EntityMasterMethod.ClickCloseBtnOfCommitte(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 230)
void ClickCommitteeMatrix() throws InterruptedException, IOException
{
	test = extent.startTest("Committee Matrix option is clickable or not");
	
	EntityMasterMethod.ClickCommitteeMatrix(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
/*@Test(priority = 231)
void ClickAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Auditor option is clickable or not");
	
	EntityMasterMethod.ClickAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =232)
void AddStatutoryAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Add Statutory Auditor Verification");
	
	EntityMasterMethod.AddStatutoryAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =233)
void EnterInvalidDataStatutoryAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Data Statutory  Auditor Verification");
	
	EntityMasterMethod.EnterInvalidDataStatutoryAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 234)
void EnterTwoMandatoryFiledStatutoryAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Two Mandatory Filed Statutory Auditor Verification");
	
	EntityMasterMethod.EnterTwoMandatoryFiledStatutoryAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 235)
void EmptyFiledStatutoryAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Empty Field Statutory Auditor Verification");
	
	EntityMasterMethod.EmptyFiledStatutoryAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 236)
void CloseBtnStatutoryAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Add=Close button is clickable or not  Statutory Auditor Verification");
	
	EntityMasterMethod.CloseBtnStatutoryAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =237)
void ClearBtnStatutoryAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Clear button is clickable or not  Statutory Auditor Verification");
	
	EntityMasterMethod.ClearBtnStatutoryAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 238)
void UpdateStatutoryAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Update Statutory Auditor Verification");
	
	EntityMasterMethod.UpdateStatutoryAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 239)
void UpdateEnterInvalidDataStatutoryAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Edit= Enter Invalid Data Statutory Auditor Verification");
	
	EntityMasterMethod.UpdateEnterInvalidDataStatutoryAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 240)
void UpdateEnterEmptyFieldsStatutoryAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Edit= Enter Empty Data Statutory Auditor Verification");
	
	EntityMasterMethod.UpdateEnterEmptyFieldsStatutoryAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 241)
void CloseBtnUpdateStatutoryAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Edit=Close button is clickable or not  Statutory Auditor Verification");
	
	EntityMasterMethod.CloseBtnUpdateStatutoryAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 242)
void Resignationofauditor() throws InterruptedException, IOException
{
	test = extent.startTest("Add Resignation Statutory Auditor Verification");
	
	EntityMasterMethod.ResignationofAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}


@Test(priority = 243)
void CancelBtnResignationofAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Cancel Button - Resignation Statutory Auditor Verification");
	
	EntityMasterMethod.CancelBtnResignationofAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =244)
void EnterInvalidDataResignationofAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Data Resignation Statutory Auditor Verification");
	
	EntityMasterMethod.EnterInvalidDataResignationofAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 245)
void EnterEmptyDataResignationofAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Empty Data Resignation Statutory Auditor Verification");
	
	EntityMasterMethod.EnterEmptyDataResignationofAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 246)
void CloseBtnResignationofAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button is clickable or not Resignation Statutory Auditor Verification");
	
	EntityMasterMethod.CloseBtnResignationofAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 247)
void ClickInternalAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Internal Auditor Verification");
	
	EntityMasterMethod.ClickInternalAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =248)
void AddInternalAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Add-Internal Auditor Verification");
	
	EntityMasterMethod.AddInternalAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 249)
void EnterExistingDataInternalAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Existing Data-Internal Auditor Verification");
	
	EntityMasterMethod.EnterExistingDataInternalAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority =250)
void EnterTwoFieldsInternalAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Two Fields -Internal Auditor Verification");
	
	EntityMasterMethod.EnterTwoFieldsInternalAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 251)
void CloseBtnInternalAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button -Internal Auditor Verification");
	
	EntityMasterMethod.CloseBtnInternalAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 252)
void ClearBtnInternalAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Clear button - Internal Auditor Verification");
	
	EntityMasterMethod.ClearBtnInternalAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 253)
void EditInternalAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Update - Internal Auditor Verification");
	
	EntityMasterMethod.UpdateInternalAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 254)
void ResignationofInternalAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Add Resignation - Internal Auditor Verification");
	
	EntityMasterMethod.ResignationofInternalAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority =255)
void EmptyFiledsCancelBtnResignationofInternalAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Empty fileds cancel button Resignation Internal Auditor Verification");
	
	EntityMasterMethod.EmptyFiledsCancelBtnResignationofInternalAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 256)
void EnterInvalidDataResignationofInternalAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Data Resignation Internal Auditor Verification");
	
	EntityMasterMethod.EnterInvalidDataResignationofInternalAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 257)
void EnterEmptyDataResignationofInternalAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Empty Data Resignation Internal Auditor Verification");
	
	EntityMasterMethod.EnterEmptyDataResignationofInternalAuditor(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 258) 
void SecretarialAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Entity - More Action - Auditors - Secretarial Auditor Verification ");
	
	EntityMasterMethod.SecretarialAuditor(driver,test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 259) 
void SAAddNew() throws InterruptedException, IOException
{
	test = extent.startTest("Add New- Secretarial Auditor Verification");
	
	EntityMasterMethod.SAAddNew(driver,test,workbook);
	
	extent.endTest(test);
	extent.flush();
}	
@Test(priority = 260) 
void SAAddNewAE() throws InterruptedException, IOException
{
	test = extent.startTest("Enter  Existing data-Secretarial Auditor Verification");
	
	EntityMasterMethod.SAAddNewAE(driver,test,workbook);
	
	extent.endTest(test);
	extent.flush();
}	
@Test(priority = 261) 
void SAAddNewTwoMan() throws InterruptedException, IOException
{
	test = extent.startTest("Enter two mandatory fields - Secretarial Auditor Verification");
	
	EntityMasterMethod.SAAddNewTwoMan(driver,test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 262) 
void SAAddNewEmpty() throws InterruptedException, IOException
{
	test = extent.startTest(" Empty fields - Secretarial Auditor Verification");
	
	EntityMasterMethod.SAAddNewEmpty(driver,test);
	
	extent.endTest(test);
	extent.flush();
}	
@Test(priority = 263) 
void SAAddNewClose() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button - Secretarial Auditor Verification");
	
	EntityMasterMethod.SAAddNewClose(driver,test);
	
	extent.endTest(test);
	extent.flush();
}	
@Test(priority =264) 
void SAClearFilter() throws InterruptedException, IOException
{
	test = extent.startTest("Clear Filter  - Secretarial Auditor Verification");
	
	EntityMasterMethod.SAClearFilter(driver,test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 265) 
void SAEditClose() throws InterruptedException, IOException
{
	test = extent.startTest("Entity - More Action - Auditors - Secretarial Auditor - Edit - Close");
	
	EntityMasterMethod.SAEditClose(driver,test);
	
	extent.endTest(test);
	extent.flush();
}	
@Test(priority =266) 
void ResignationofAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Entity - More Action - Auditors - Secretarial Auditor - Resignation of Auditor - With Valid data ");
	
	EntityMasterMethod.ResignationofSecretarialAuditor(driver,test);
	
	extent.endTest(test);
	extent.flush();
}	
@Test(priority =267) 
void ResignationofAuditorEmpty() throws InterruptedException, IOException
{
	test = extent.startTest("Entity - More Action - Auditors - Secretarial Auditor - Resignation of Auditor - With Empty Fileds ");
	
	EntityMasterMethod.ResignationofAuditorEmpty(driver,test);
	
	extent.endTest(test);
	extent.flush();
}	
@Test(priority = 268) 
void ResignationofAuditorCancel() throws InterruptedException, IOException
{
	test = extent.startTest("Entity - More Action - Auditors - Secretarial Auditor - Resignation of Auditor - Cancel ");
	
	EntityMasterMethod.ResignationofAuditorCancel(driver,test);
	
	extent.endTest(test);
	extent.flush();
}	
@Test(priority = 269) 
void ResignationofAuditorClose() throws InterruptedException, IOException
{
	test = extent.startTest("Entity - More Action - Auditors - Secretarial Auditor - Resignation of Auditor - Close ");
	
	EntityMasterMethod.ResignationofAuditorClose(driver,test);
	
	extent.endTest(test);
	extent.flush();
}	
@Test(priority = 270) 
void CostAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Entity - More Action - Auditors - Cost Auditor - Click  ");
	
	EntityMasterMethod.CostAuditor(driver,test);
	
	extent.endTest(test);
	extent.flush();
}	
@Test(priority = 271) 
void CostAuditorAddNew() throws InterruptedException, IOException
{
	test = extent.startTest("Entity - More Action - Auditors - Cost Auditor - Add New  ");
	
	EntityMasterMethod.CostAuditorAddNew(driver,test,workbook);
	
	extent.endTest(test);
	extent.flush();
}	

	@Test(priority = 272) 
void CostAuditorAddNewED() throws InterruptedException, IOException
{
	test = extent.startTest("Entity - More Action - Auditors - Cost Auditor - Add New - with Existing data ");
	
	EntityMasterMethod.CostAuditorAddNewED(driver,test,workbook);
	
	extent.endTest(test);
	extent.flush();
}	
	@Test(priority =273) 
	void CostAuditorAddNewTwoMan() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Auditors - Cost Auditor - Add New - with two mandatory fields ");
		
		EntityMasterMethod.CostAuditorAddNewTwoMan(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority = 274) 
	void CostAuditorAddNewEmpty() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Auditors - Cost Auditor - Add New - with Empty fields ");
		
		EntityMasterMethod.CostAuditorAddNewEmpty(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}	
	
		@Test(priority =275) 
	void CAAddNewClose() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Auditors - Cost Auditor - Add New - Close ");
		
		EntityMasterMethod.CAAddNewClose(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 276) 
	void CAClearFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Auditors - Cost Auditor - Clear Filter ");
		
		EntityMasterMethod.CAClearFilter(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}		
	
	@Test(priority =277) 
	void CAEditClose() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Auditors - Cost Auditor - Edit - Close ");
		
		EntityMasterMethod.CAEditClose(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority = 278) 
	void ResignationofAuditorCA() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Auditors - Cost Auditor - Resignation of Auditor - With Valid data ");
		
		EntityMasterMethod.ResignationofAuditorCA(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 279) 
	void ResignationofAuditorEmptyCA() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Auditors - Cost Auditor - Resignation of Auditor - With Empty fields ");
		
		EntityMasterMethod.ResignationofAuditorEmptyCA(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority = 280) 
	void ResignationofAuditorCancelCA() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Auditors - Cost Auditor - Resignation of Auditor - Cancel ");
		
		EntityMasterMethod.ResignationofAuditorCancelCA(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 281) 
	void ResignationofAuditorCloseCA() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Auditors - Cost Auditor - Resignation of Auditor - Close ");
		
		EntityMasterMethod.ResignationofAuditorCloseCA(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
/*	@Test(priority =282) 
	void ClickMBP4() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab ");
		
		EntityMasterMethod.ClickMBP4(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority =283) 
	void ClickUploadExistingRegistor() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab -Upload File with valid data ");
		
		EntityMasterMethod.ClickUploadExistingRegistorValidData(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority = 284) 
	void ClickUploadExistingRegistorInvalidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab -Upload File with Invalid data ");
		
		EntityMasterMethod.ClickUploadExistingRegistorInvalidData(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority = 285) 
	void ClickUploadExistingRegistorDupliacteData() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab -Upload File with Duplicate data ");
		
		EntityMasterMethod.ClickUploadExistingRegistorDupliacteData(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority = 286) 
	void ClickUploadExistingRegistorWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab -Upload File without data ");
		
		EntityMasterMethod.ClickUploadExistingRegistorWithoutData(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority = 287) 
	void ClickUploadExistingRegistorInvalidFileFormat() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab -Invalid File Format ");
		
		EntityMasterMethod.ClickUploadExistingRegistorInvalidFileFormat(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority = 288) 
	void ClickUploadExistingRegistorWithoutSelectingFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab -Without selecting file ");
		
		EntityMasterMethod.ClickUploadExistingRegistorWithoutSelectingFile(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority = 289) 
	void ClickUploadOldRegistorWithValidFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab -Select Old Btn-with valid file ");
		
		EntityMasterMethod.ClickUploadOldRegistorWithValidData(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority =290) 
	void ClickUploadOldRegistorWithInValidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab -Select Old Btn-with invalid data ");
		
		EntityMasterMethod.ClickUploadOldRegistorWithInValidData(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority =291) 
	void ClickUploadOldRegistorWithDuplicateData() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab -Select Old Btn-with Duplicate data ");
		
		EntityMasterMethod.ClickUploadOldRegistorWithDuplicateData(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority =292) 
	void ClickUploadOldRegistorWithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab -Select Old Btn-without data ");
		
		EntityMasterMethod.ClickUploadOldRegistorWithoutData(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority =293) 
	void ClickUploadOldRegistorInvalidFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab -Select Old Btn-Invalid File ");
		
		EntityMasterMethod.ClickUploadOldRegistorInvalidFile(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority =294) 
	void ClickUploadOldRegistorWithoutSelectFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab -Select Old Btn- Without selecting file ");
		
		EntityMasterMethod.ClickUploadOldRegistorWithoutSelectFile(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =295) 
	void ClickGenerateRegistor() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab - click Generate Registor tab");
		
		EntityMasterMethod.ClickGenerateRegistor(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =296) 
	void ClickDownloadExisitingRegisterOfMBP4() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab - click Generate Registor tab-Existing Download Report");
		
		EntityMasterMethod.ClickDownloadExisitingRegisterOfMBP4(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority =297) 
	void ClickDownloadOldRegisterOfMBP4() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab - click Generate Registor tab-Old Download Report");
		
		EntityMasterMethod.ClickDownloadOldRegisterOfMBP4(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority =298) 
	void ClickDownloadAllRegisterOfMBP4() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab - click Generate Registor tab-All btn -Download Report");
		
		EntityMasterMethod.ClickDownloadAllRegisterOfMBP4(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority =299) 
	void ClickViewExisitingRegisterOfMBP4() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab - click Generate Registor tab-Existing- Viewed Document");
		
		EntityMasterMethod.ClickViewExisitingRegisterOfMBP4(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority =300) 
	void ClickViewOldRegisterOfMBP4() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab - click Generate Registor tab-Old Btn- Viewed Document");
		
		EntityMasterMethod.ClickViewOldRegisterOfMBP4(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}	
	@Test(priority =301) 
	void ClickViewAllRegisterOfMBP4() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-MBP-4 tab - click Generate Registor tab-All Btn- Viewed Document");
		
		EntityMasterMethod.ClickViewAllRegisterOfMBP4(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =302) 
	void clickPASTROD() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-Past ROD Tab");
		
		EntityMasterMethod.clickPASTROD(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =303) 
	void clickPASTRODwithValidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-Past ROD Tab-With valid data");
		
		EntityMasterMethod.clickPASTRODwithValidData(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority =304) 
	void clickPASTRODwithInValidData() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-Past ROD Tab-With invalid data");
		
		EntityMasterMethod.clickPASTRODwithInValidData(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =305) 
	void clickPASTRODwithDuplicateData() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-Past ROD Tab-With Duplicate data");
		
		EntityMasterMethod.clickPASTRODwithDuplicateData(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =306) 
	void clickPASTRODwithoutData() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-Past ROD Tab-Without data");
		
		EntityMasterMethod.clickPASTRODwithoutData(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =307) 
	void clickPASTRODInvalidFile() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-Past ROD Tab-Invliad File Format");
		
		EntityMasterMethod.clickPASTRODInvalidFile(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =308) 
	void clickPASTRODGenerateRegistor() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-Past ROD Tab-Generate Registor Tab");
		
		EntityMasterMethod.clickPASTRODGenerateRegistor(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =309) 
	void clickPASTRODGenerateRegistorDownload() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-Past ROD Tab-Generate Registor Tab - Download Report");
		
		EntityMasterMethod.clickPASTRODGenerateRegistorDownload(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =310) 
	void clickPASTRODGenerateRegistorview() throws InterruptedException, IOException
	{
		test = extent.startTest("Entity - More Action - Statutory Auditors-Past ROD Tab-Generate Registor Tab - View Document");
		
		EntityMasterMethod.clickPASTRODGenerateRegistorDownload(driver,test);
		
		extent.endTest(test);
		extent.flush();  
	}*/
	
 @AfterMethod
	 
	 void Close()
	 {
		 driver.close(); 
	 }
	 
	


}
