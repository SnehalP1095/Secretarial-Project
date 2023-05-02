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
		fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Snehal\\ComplianceLatest\\Secreterial\\TestData\\SecreterialSheet3.xlsx");
		
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
	
	//@Test(priority = 2)
	
		void EntityType() throws InterruptedException, IOException
		{
			test = extent.startTest(" Entity Type Verification");
			
			EntityMasterMethod.DeemedPublicCompany(driver, test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}

//	@Test(priority =3 )
	
	void TwoMandatoryFields() throws InterruptedException, IOException
	{
		test = extent.startTest("Two Mandatory Fields Verification");
		
		EntityMasterMethod.TwoMandatoryFields(driver, test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
//@Test(priority = 4)
	
	void WithoutEnteringField() throws InterruptedException, IOException
	{
		test = extent.startTest("Without Entering  Fields Verification");
		
		EntityMasterMethod.WithouEnteringField(driver, test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
//@Test(priority = 5)

void CloseBtn() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button Verification");
	
	EntityMasterMethod.CloseBtn(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 6)

void AddEntity() throws InterruptedException, IOException
{
	test = extent.startTest(" Add DeemedPublic Company Verification");
	
	EntityMasterMethod.AddDeemedPublicCompany(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 7)

void EnterInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest(" Invalid Data Verification");
	
	EntityMasterMethod.EnterInvalidData(driver, test);
	
	extent.endTest(test);
	extent.flush();
}


//@Test(priority = 8)

void EditIcon() throws InterruptedException, IOException
{
	test = extent.startTest("Update Entity Verification");
	
	EntityMasterMethod.EditIcon(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}


//@Test(priority = 9)

void InvalidEditIcon() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid field Entity Verification");
	
	EntityMasterMethod.InvalidEditIcon(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 10)

void EditCloseBtn() throws InterruptedException, IOException
{
	test = extent.startTest("Edit = Close Button Verification");
	
	EntityMasterMethod.EditCloseBtn(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 11)

void BuisnessActivity() throws InterruptedException, IOException
{
	test = extent.startTest("Buisness Activity Tab Verification");
	
	EntityMasterMethod.BuisnessActivity(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 12)

void AddBuisnessActivity() throws InterruptedException, IOException
{
	test = extent.startTest("Buisness Activity Tab Verification");
	
	EntityMasterMethod.AddBuisnessActivity(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 13)

void NoDataFound() throws InterruptedException, IOException
{
	test = extent.startTest("Buisness Activity Tab Verification");
	
	EntityMasterMethod.BAnotFound(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 14)

void WithOutEnterData() throws InterruptedException, IOException
{
	test = extent.startTest("Without Enter Data Buisness Activity  Verification");
	
	EntityMasterMethod.WithoutEnterData(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 15)

void EditBA() throws InterruptedException, IOException
{
	test = extent.startTest("Update Buisness Activity  Verification");
	
	EntityMasterMethod.EditBA(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 16)

void EditInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Data Buisness Activity  Verification");
	
	EntityMasterMethod.EditBAInvalidData(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 17)

void BADeleteIcon() throws InterruptedException, IOException
{
	test = extent.startTest("Delete Icon Buisness Activity  Verification");
	
	EntityMasterMethod.BADeleteIcon(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 18)

void BACloseBtn() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button Buisness Activity  Verification");
	
	EntityMasterMethod.BACloseBtn(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 19)

void DocumentTab() throws InterruptedException, IOException
{
	test = extent.startTest("Document tab  Verification");
	
	EntityMasterMethod.DocumentTab(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
///@Test(priority = 20)

void AddDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Add Document Verification");
	
	EntityMasterMethod.AddNewDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 21)

void AlreadyExistDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Already Exist Document Verification");
	
	EntityMasterMethod.AlreadyExistDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 22)

void WithoutEnteringDoc() throws InterruptedException, IOException
{
	test = extent.startTest("Without Upload Document Verification");
	
	EntityMasterMethod.WithoutEnteringDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 23)

void ViewDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Document View Verification");
	
	EntityMasterMethod.ViewDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 24)

void DownloadDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Download Document Verification");
	
	EntityMasterMethod.DownloadDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 25)

void DeleteDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Delete Document Verification");
	
	EntityMasterMethod.DeleteDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 26)

void AddAOA() throws InterruptedException, IOException
{
	test = extent.startTest("Add Article of Association(AOA) Document Verification");
	
	EntityMasterMethod.AddAOA(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 27)

void ExistingAOADocument() throws InterruptedException, IOException
{
	test = extent.startTest("Existing Article of Association(AOA) Document Verification");
	
	EntityMasterMethod.ExistingAOADocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}


//@Test(priority = 27)

void WithoutEnterignAOADocument() throws InterruptedException, IOException
{
	test = extent.startTest("Without enetring Article of Association(AOA) Document Verification");
	
	EntityMasterMethod.WithoutEnteringAOADocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 28)

void ViewAOADocument() throws InterruptedException, IOException
{
	test = extent.startTest("Article of Association(AOA) Document View Verification");
	
	EntityMasterMethod.ViewAOADocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 29)

void DownloadAOADocument() throws InterruptedException, IOException
{
	test = extent.startTest("Article of Association(AOA)  Download Document Verification");
	
	EntityMasterMethod.DownloadAOADocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 30)

void DeleteAOADocument() throws InterruptedException, IOException
{
	test = extent.startTest("Article of Association(AOA)  Delete Document Verification");
	
	EntityMasterMethod.DeleteAOADocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}


//@Test(priority = 31)
void AddCOI() throws InterruptedException
{
	test=extent.startTest("Certificate of Incorporation(COI) Add Document Verification");
	
	EntityMasterMethod.AddCOI(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 32)
void ExistingCOIDocument() throws InterruptedException
{
	test=extent.startTest("Existing Certificate of Incorporation(COI)  Document Verification");
	
	EntityMasterMethod.ExistingCOIDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 33)

void WithoutEnterignCOIDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Without enetring Certificate of Incorporation(COI) Document Verification");
	
	EntityMasterMethod.WithoutEnteringCOIDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 34)

void ViewCOIDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Certificate of Incorporation(COI) Document View Verification");
	
	EntityMasterMethod.ViewCOIDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 35)

void DownloadCOIDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Certificate of Incorporation(COI)  Download Document Verification");
	
	EntityMasterMethod.DownloadCOIDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 36)

void DeleteCOIDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Certificate of Incorporation(COI)  Delete Document Verification");
	
	EntityMasterMethod.DeleteCOIDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 37)

void AddPolicyDoc() throws InterruptedException, IOException
{
	test = extent.startTest("Add Policy  Document Verification");
	
	EntityMasterMethod.AddPolicyDoc(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 38)

void ExistingPolicyDoc() throws InterruptedException, IOException
{
	test = extent.startTest("Existing Policy  Document Verification");
	
	EntityMasterMethod.ExistingPolicyDoc(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 39)

void WithoutEnterignPolicyDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Without enetring Policy Document Verification");
	
	EntityMasterMethod.WithoutEnteringPolicyDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 40)

void ViewPolicyDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Policy Document View Verification");
	
	EntityMasterMethod.ViewPolicyDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 41)

void DownloadPolicyDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Policy  Download Document Verification");
	
	EntityMasterMethod.DownloadPolicyDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 42)

void DeletePolicyDocument() throws InterruptedException, IOException
{
	test = extent.startTest("Policy  Delete Document Verification");
	
	EntityMasterMethod.DeletePolicyDocument(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 43)

void AddLicenseRegistration() throws InterruptedException, IOException
{
	test = extent.startTest("Add License/Registration  Document Verification");
	
	EntityMasterMethod.AddLicenseRegistration(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 44)

void AddAnnualReport() throws InterruptedException, IOException
{
	test = extent.startTest("Add Annual Report  Document Verification");
	
	EntityMasterMethod.AddAnnualReport(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 45)

void BranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Branch Detailes Verification");
	
	EntityMasterMethod.BranchDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 46)

void AddBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Add Branch Detailes Verification");
	
	EntityMasterMethod.AddBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 47)

void InvaliddBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Branch Detailes Verification");
	
	EntityMasterMethod.InvaliddBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 48)

void TwoMandatoryFieldsBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Two Mandatory Fields Branch Detailes Verification");
	
	EntityMasterMethod.TwoMandatoryFieldsBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 49)

void WithoutEnteringDataBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Without Entering Fields Branch Detailes Verification");
	
	EntityMasterMethod.WithoutEnteringDataBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 50)

void EditBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Update Branch Detailes Verification");
	
	EntityMasterMethod.EditBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 51)

void UploadDocBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Upload Document  Branch Detailes Verification");
	
	EntityMasterMethod.UploadDocBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 52)

void InvalidUploadDocBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Upload Document  Branch Detailes Verification");
	
	EntityMasterMethod.InvalidUploadDocBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 53)

void MultipleFileUploadDocBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Multiple File Upload Branch Detailes Verification");
	
	EntityMasterMethod.MultipleFileUploadDocBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 54)

void InvalidMultipleFileUploadDocBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Multiple File Upload Branch Detailes Verification");
	
	EntityMasterMethod.InvalidMultipleFileUploadDocBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 55)

void WithoutUploadDocBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Without Upload File Branch Detailes Verification");
	
	EntityMasterMethod.WithoutUploadDocBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 56)

void CloseBranchDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button Branch Detailes Verification");
	
	EntityMasterMethod.CloseBranchDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 57)

void BankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest(" Bank Detailes Verification");
	
	EntityMasterMethod.BankDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}


//@Test(priority = 58)

void AddBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Add Bank Detailes Verification");
	
	EntityMasterMethod.AddBankDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 59)

void DuplicateBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Duplicate Bank Detailes Verification");
	
	EntityMasterMethod.DuplicateBankDetailes(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
///@Test(priority = 60)

void InvalidAccountNo() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Account No Verification");
	
	EntityMasterMethod.InvalidAccountNo(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 61)

void InvalidBankName() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Bank Name Verification");
	
	EntityMasterMethod.InvalidBankName(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 62)

void InvalidIFSC() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid IFSC Verification");
	
	EntityMasterMethod.InvalidIFSC(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 63)

void DateBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Opening date is greater than closing date Verification");
	
	EntityMasterMethod.DateBankDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 64)

void WithoutEnterBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Without Enter Bank Detailes Verification");
	
	EntityMasterMethod.WithoutEnterBankDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 65)

void UpdateBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Update Bank Detailes Verification");
	
	EntityMasterMethod.UpdateBankDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 66)

void InvalidUpdateBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Update Bank Detailes Verification");
	
	EntityMasterMethod.InvalidUpdateBankDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 67)

void DeleteBankDetailes() throws InterruptedException, IOException
{
	test = extent.startTest("Delete Confirmation Bank Detailes Verification");
	
	EntityMasterMethod.DeleteBankDetailes(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 68)

void DeleteBankDetailes1() throws InterruptedException, IOException
{
	test = extent.startTest("Delete  Cancel Bank Detailes Verification");
	
	EntityMasterMethod.DeleteBankDetailes1(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 69)

void LimitedLiabilityPartnership() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Verification");
	
	EntityMasterMethod.LimitedLiabilityPartnership(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 70)

void AddLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Add Limited Liability Partnership Verification");
	
	EntityMasterMethod.AddLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 71)

void EnterInvalidDataLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Enter Invalid Data Limited Liability Partnership Verification");
	
	EntityMasterMethod.EnterInvalidDataLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 71)

void DuplicateLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Duplicate Limited Liability Partnership Verification");
	
	EntityMasterMethod.DuplicateLLP(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 72)

void TwoMandatoryLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Two Mandatory Fields Limited Liability Partnership Verification");
	
	EntityMasterMethod.TwoMandatoryLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 73)

void WithoutEnteringFieldsLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Without Entering Fields Limited Liability Partnership Verification");
	
	EntityMasterMethod.WithoutEnteringFieldsLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 74)

void CloseButtonLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Close Button Limited Liability Partnership Verification");
	
	EntityMasterMethod.CloseButtonLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 75)

void UpdateLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Update Limited Liability Partnership Verification");
	
	EntityMasterMethod.UpdateLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 76)

void InvalidUpdateLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Invalid Update Limited Liability Partnership Verification");
	
	EntityMasterMethod.InvalidUpdateLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 77)

void EditCloseButtonLLP() throws InterruptedException, IOException
{
	test = extent.startTest(" Edit Close Button Limited Liability Partnership Verification");
	
	EntityMasterMethod.CloseButtonLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 78)

void BuisnessActivityLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Buisness Activity Tab Limited Liability Partnership Verification");
	
	EntityMasterMethod.BuisnessActivityLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 79)

void AddBuisnessActivityLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Add Buisness Activity Tab Limited Liability Partnership Verification");
	
	EntityMasterMethod.AddBuisnessActivityLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 80)

void NoDataFoundLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Buisness Activity Tab Limited Liability Partnership Verification");
	
	EntityMasterMethod.LLPBAnotFound(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 81)

void WithOutEnterDataLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Without Enter Data Limited Liability Partnership Buisness Activity  Verification");
	
	EntityMasterMethod.WithoutEnterDataBALLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 82)

void EditLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Update Limited Liability Partnership Buisness Activity   Verification");
	
	EntityMasterMethod.EditBALLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 83)

void EditInvalidDataLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Data Limited Liability Partnership Buisness Activity  Verification");
	
	EntityMasterMethod.EditInvalidDataLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 84)

void BADeleteIconLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Delete Icon Limited Liability Partnership Buisness Activity  Verification");
	
	EntityMasterMethod.BADeleteIconLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 85)

void BACloseBtnLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button Limited Liability Partnership Buisness Activity  Verification");
	
	EntityMasterMethod.BACloseBtnLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

//@Test(priority = 86)

void DocumentTabLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Document tab  Verification");
	
	EntityMasterMethod.DocumentTabLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 87)

void AddDocumentLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Add Document Verification");
	
	EntityMasterMethod.AddNewDocumentLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
//@Test(priority = 88)

void AlreadyExistDocumentLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Already Exist Document Verification");
	
	EntityMasterMethod.AlreadyExistDocumentLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 89)

void WithoutEnteringDocLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Without Upload Document Verification");
	
	EntityMasterMethod.WithoutEnteringDocumentLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 90)

void ViewDocumentLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Document View Verification");
	
	EntityMasterMethod.ViewDocumentLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 91)

void DownloadDocumentLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Download Document Verification");
	
	EntityMasterMethod.DownloadDocumentLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 92)

void DeleteDocumentLLP() throws InterruptedException, IOException
{
	test = extent.startTest("Limited Liability Partnership Delete Document Verification");
	
	EntityMasterMethod.DeleteDocumentLLP(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
}
