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
@Test(priority = 3)

void AcceptAlphaCharactersCommittee() throws InterruptedException, IOException
{
	test = extent.startTest(" Accept Alpha Chabracters Committee Master  Verification");
	
	CommitteeMethod.AcceptAlphaCharactersCommittee(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 4)

void CloseBtnCommittee() throws InterruptedException, IOException
{
	test = extent.startTest(" Close Button Committee Master  Verification");
	
	CommitteeMethod.CloseBtnCommittee(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 5)

void WithoutEnteringDataCommittee() throws InterruptedException, IOException
{
	test = extent.startTest(" Without Entering Data Committee Master  Verification");
	
	CommitteeMethod.WithoutEnteringDataCommittee(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 6)

void EnterInvalidDataCommittee() throws InterruptedException, IOException
{
	test = extent.startTest(" Enter Invalid Data Committee Master  Verification");
	
	CommitteeMethod.EnterInvalidDataCommittee(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 7)

void UpdateCommittee() throws InterruptedException, IOException
{
	test = extent.startTest(" Update Committee Master  Verification");
	
	CommitteeMethod.UpdateCommittee(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 8)

void AddCommitteeMemberRule() throws InterruptedException, IOException
{
	test = extent.startTest(" Add Committee Member Rule Committee Master  Verification");
	
	CommitteeMethod.AddCommitteeMemberRule(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 9)

void UpdateCommitteeMemberRule() throws InterruptedException, IOException
{
	test = extent.startTest(" Update Committee Member Rule Committee Master  Verification");
	
	CommitteeMethod.UpdateCommitteeMemberRule(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 10)

void AddCommitteeQuoramRule() throws InterruptedException, IOException
{
	test = extent.startTest(" Add Committee Quram  Rule Committee Master  Verification");
	
	CommitteeMethod.AddCommitteeQuoramRule(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 11)

void UpdateCommitteeQuoramRule() throws InterruptedException, IOException
{
	test = extent.startTest(" Update Committee Quram  Rule Committee Master  Verification");
	
	CommitteeMethod.UpdateCommitteeQuoramRule(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 12)

void AddCommitteeMeetingRule() throws InterruptedException, IOException
{
	test = extent.startTest(" Add Committee Meeting  Rule Committee Master  Verification");
	
	CommitteeMethod.AddCommitteeMeetingRule(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 13)

void UploadCommitteDocument() throws InterruptedException, IOException
{
	test = extent.startTest(" Upload Committee Document Committee Master  Verification");
	
	CommitteeMethod.UploadCommitteDocument(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 14)

void DeleteCommitteDocument() throws InterruptedException, IOException
{
	test = extent.startTest(" Delete Committee Document Committee Master  Verification");
	
	CommitteeMethod.DeleteCommitteDocument(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 15)

void WithoutUploadCommitteDocument() throws InterruptedException, IOException
{
	test = extent.startTest(" Without Upload Committee Document Committee Master  Verification");
	
	CommitteeMethod.WithoutUploadCommitteDocument(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 16)

void AcceptTotalStrengthNumericFont() throws InterruptedException, IOException
{
	test = extent.startTest(" Accept Total Strength Numeric Font Committee Master  Verification");
	
	CommitteeMethod.AcceptTotalStrengthNumericFont(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 17)

void CommitteComposition() throws InterruptedException, IOException
{
	test = extent.startTest("Add- Committe Composition Verification");
	
	CommitteeCompositionMethod.CommitteeComposition(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 18)

void WithoutEnteringData() throws InterruptedException, IOException
{
	test = extent.startTest("Without Enter Data- Committe Composition Verification");
	
	CommitteeCompositionMethod.WithoutEnteringData(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 19)

void CloseBtnCommitteeComposition() throws InterruptedException, IOException
{
	test = extent.startTest("Close Button- Committe Composition Verification");
	
	CommitteeCompositionMethod.CloseBtnCommitteeComposition(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 20)

void DateFormatCommitteeComposition() throws InterruptedException, IOException
{
	test = extent.startTest("Date Format- Committe Composition Verification");
	
	CommitteeCompositionMethod.DateFormatCommitteeComposition(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 21)

void UpdateCommitteeComposition() throws InterruptedException, IOException
{
	test = extent.startTest("Update- Committe Composition Verification");
	
	CommitteeCompositionMethod.UpdateCommitteeComposition(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 22)

void DeleteCommitteeComposition() throws InterruptedException, IOException
{
	test = extent.startTest("Delete- Committe Composition Verification");
	
	CommitteeCompositionMethod.DeleteCommitteeComposition(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 23)

void ExportToPDFCommitteeComposition() throws InterruptedException, IOException
{
	test = extent.startTest("Export To PDF- Committe Composition Verification");
	
	CommitteeCompositionMethod.ExportToPDFCommitteeComposition(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 24)

void AuditorPage() throws InterruptedException, IOException
{
	test = extent.startTest(" Create New Tab and Create From Existing tab  Auditor Verfication");
	
	AuditorMasterMethod.AuditorPage(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 25)

void NameFieldacceptalphabet() throws InterruptedException, IOException
{
	test = extent.startTest(" Name Field accept alphabet - Create New Tab Auditor Verfication");
	
	AuditorMasterMethod.NameFieldacceptalphabet(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 26)

void EnterInvalidData() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Data - Create New Tab Auditor Verfication");
	
	AuditorMasterMethod.EnterInvalidData(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 27)

void WithoutEnterData() throws InterruptedException, IOException
{
	test = extent.startTest("Without Enter Data - Create New Tab Auditor Verfication");
	
	AuditorMasterMethod.WithoutEnterData(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 28)

void AuditorMaster() throws InterruptedException, IOException
{
	test = extent.startTest(" Mob no,PAN No,Adrress Line - Create New Tab Auditor Verfication");
	
	AuditorMasterMethod.CreateNewTab(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 29)

void CloseBtnCreateNewTab() throws InterruptedException, IOException
{
	test = extent.startTest(" Close Button - Create New Tab Auditor Verfication");
	
	AuditorMasterMethod.CloseBtnCreateNewTab(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 30)

void SaveBtnCreateNewTab() throws InterruptedException, IOException
{
	test = extent.startTest(" Save Button - Create New Tab Auditor Verfication");
	
	AuditorMasterMethod.SaveBtnCreateNewTab(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 31)

void CountryCreateNewTab() throws InterruptedException, IOException
{
	test = extent.startTest(" Country Dropdown- Create New Tab Auditor Verfication");
	
	AuditorMasterMethod.CountryCreateNewTab(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 32)

void StatutoryAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Statutory Auditor Verification");
	
	AuditorMasterMethod.StatutoryAuditor(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 33)

void InternalAuditor() throws InterruptedException, IOException
{
	test = extent.startTest("Internal Auditor  Verification");
	
	AuditorMasterMethod.InternalAuditor(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 34)

void SecretarialAuditor() throws InterruptedException, IOException
{
	test = extent.startTest(" Secretarial Auditor  Verification");
	
	AuditorMasterMethod.SecretarialAuditor(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 35)

void CostAuditor() throws InterruptedException, IOException
{
	test = extent.startTest(" Cost Auditor  Verification");
	
	AuditorMasterMethod.CostAuditor(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Ignore
@Test(priority = 36)

void EditAuditor() throws InterruptedException, IOException
{
	test = extent.startTest(" Update -Auditor Verification");
	
	AuditorMasterMethod.EditAuditor(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 37)

void UploadFile() throws InterruptedException, IOException
{
	test = extent.startTest(" Upload File -Auditor  Verification");
	
	AuditorMasterMethod.UploadFile(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 38)

void DeleteAuditor() throws InterruptedException, IOException
{
	test = extent.startTest(" Delete -Auditor  Verification");
	
	AuditorMasterMethod.DeleteAuditor(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 39)

void AddCreateFromExisting() throws InterruptedException, IOException
{
	test = extent.startTest(" Add - Create From Existing tab Auditor  Verification");
	
	AuditorMasterMethod.AddCreateFromExisting(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 40)

void NameFieldacceptalphabet1() throws InterruptedException, IOException
{
	test = extent.startTest(" Name Field accept alphabet - Create From Existing tab Auditor  Verification");
	
	AuditorMasterMethod.NameFieldacceptalphabet(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 41)

void EnterInvalidData1() throws InterruptedException, IOException
{
	test = extent.startTest(" Enter Invalid Data - Create From Existing tab Auditor  Verification");
	
	AuditorMasterMethod.EnterInvalidData(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 42)

void WithoutEnteringData1() throws InterruptedException, IOException
{
	test = extent.startTest(" Without Entering Data- Create From Existing tab Auditor  Verification");
	
	AuditorMasterMethod.WithoutEnteringData(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 43)

void CreateFromExistingTab() throws InterruptedException, IOException
{
	test = extent.startTest(" Membership,Mob No,PAN No,Address- Create From Existing tab Auditor  Verification");
	
	AuditorMasterMethod.CreateFromExistingTab(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 44)

void CloseBtnCreateFromExistingTab() throws InterruptedException, IOException
{
	test = extent.startTest(" Close Button - Create From Existing Tab Auditor Verfication");
	
	AuditorMasterMethod.CloseBtnCreateFromExistingTab(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 45)

void SaveBtnCreateFromExistingTab() throws InterruptedException, IOException
{
	test = extent.startTest(" Save Button - Create From Existing Tab Auditor Verfication");
	
	AuditorMasterMethod.SaveBtnCreateFromExistingTab(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 46)

void CountryDropDownCreateFromExistingTab() throws InterruptedException, IOException
{
	test = extent.startTest(" Country Dropdown- Create From Existing Tab Auditor Verfication");
	
	AuditorMasterMethod.CountryDropDownCreateFromExistingTab(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 47)

void EnterInvalidDataUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest(" Enter Invalid Data Upload File- Create From Existing Tab Auditor Verfication");
	
	AuditorMasterMethod.EnterInvalidDataUploadFile(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 48)

void WithOutEnterDataUploadFile() throws InterruptedException, IOException
{
	test = extent.startTest(" WithOut Enter Data Upload File- Create From Existing Tab Auditor Verfication");
	
	AuditorMasterMethod.WithOutEnterDataUploadFile(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 49)

void ConfigurationMaster() throws InterruptedException, IOException
{
	test = extent.startTest("Add - Configuration Master  Verification");
	
	ConfigurationMasterMethod.ConfigurationMaster(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 50)

void UpdateConfiguration() throws InterruptedException, IOException
{
	test = extent.startTest("Update - Configuration Master  Verification");
	
	ConfigurationMasterMethod.UpdateConfiguration(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 51)

void DateFormateConfiguration() throws InterruptedException, IOException
{
	test = extent.startTest("Check Date Format  - Configuration Master  Verification");
	
	ConfigurationMasterMethod.DateFormateConfiguration(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 52)

void MeetingNumberingpatternConfiguration() throws InterruptedException, IOException
{
	test = extent.startTest("Meeting Numbering pattern - Configuration Master  Verification");
	
	ConfigurationMasterMethod.MeetingNumberingpatternConfiguration(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 53)

void AddButtonConfiguration() throws InterruptedException, IOException
{
	test = extent.startTest("Add Button - Configuration Master  Verification");
	
	ConfigurationMasterMethod.AddButtonConfiguration(driver, test);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 54)

void UserMaster() throws InterruptedException, IOException
{
	test = extent.startTest(" Add -User Master  Verification");
	
	UserMasterMethod.AddUser(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 55)

void UpdateUser() throws InterruptedException, IOException
{
	test = extent.startTest(" Update -User Master  Verification");
	
	UserMasterMethod.UpdateUser(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 56)

void FilterUserMaster() throws InterruptedException, IOException
{
	test = extent.startTest(" Search Filter Work or not  -User Master  Verification");
	
	UserMasterMethod.FilterUser(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}	
@Test(priority = 57)

void WithoutEnteringDataUser() throws InterruptedException, IOException
{
	test = extent.startTest("Without Entering Data -User Master  Verification");
	
	UserMasterMethod.WithoutEnteringDataUser(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}		
@Test(priority = 58)

void EnterInvalidDataUser() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Invalid Data  -User Master  Verification");
	
	UserMasterMethod.EnterInvalidDataUser(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}		
@Test(priority = 59)

void EnterValidDataUser() throws InterruptedException, IOException
{
	test = extent.startTest("Enter Valid Data -User Master  Verification");
	
	UserMasterMethod.EnterValidDataUser(driver, test,workbook);
	
	extent.endTest(test);
	extent.flush();
}		
}
