package CompnaySecretory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntityLocator

{
	private static WebElement Secreterial;
	private static List<WebElement> elementsList = null;
	
	
	public static WebElement selectImg(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastermenu']/a/img")));
		return Secreterial;
	}
	public static WebElement selectMaster(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastermenu']/span")));
		return Secreterial;
	}
	public static WebElement clickEntity(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastermenu']/ul/li[3]/a/span")));
		return Secreterial;
	}
	public static WebElement clickAddNewBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.cssSelector(".AddNewspan1"));
		return Secreterial;
	}
	public static WebElement clickEntityType(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='window']/div[1]/div[1]/span[2]/span/span[1]"));
		return Secreterial;
	}
	public static WebElement selectEntityType(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='ddlEntityType_listbox']/li[4]"));
		return Secreterial;
	}
	public static WebElement EntityName(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='txtEntityName']"));
		return Secreterial;
	}
	
	public static WebElement CINEntity(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='txtCIN']"));
		return Secreterial;
	}
	
	public static WebElement CalendorIcon(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='panelbar_DetailsPrivatepublicCompany']/li/div/div[1]/div[4]/span[2]/span/span/span"));
		return Secreterial;
	}
	
	
	public static WebElement Date(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.linkText("1"));
		return Secreterial;
	}
	
	public static WebElement PAN(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='txtPan']"));
		return Secreterial;
	}
	
	public static WebElement Roc(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='panelbar_DetailsPrivatepublicCompany']/li/div/div[2]/div/div[1]/span[2]/span/span[2]"));
		return Secreterial;
	}
	
	public static WebElement Ahmedabad(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.linkText("Ahmedabad"));
		return Secreterial;
	}
	
	
	public static WebElement CompanyCategory(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='panelbar_DetailsPrivatepublicCompany']/li/div/div[2]/div/div[2]/span[2]/span/span[2]"));
		return Secreterial;
	}
	
	public static WebElement Companylimitedbyshares(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.linkText("Company limited by shares"));
		return Secreterial;
	}
	
	public static WebElement EmailE(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='txtEmailId']"));
		return Secreterial;
	}
	
	public static WebElement FinancialYear(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='panelbar_DetailsPrivatepublicCompany']/li/div/div[4]/div/div[2]/span[2]/span/span[2]"));
		return Secreterial;
	}
	
	public static WebElement JAnDec(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='FY_listbox']/li[2]"));
		return Secreterial;
	}
	
	public static WebElement AddressE(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='txtRegAddress1']"));
		return Secreterial;
	}
	
	public static WebElement StateE(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='step1Content']/div/div[1]/div/div[3]/span[2]/span/span[2]"));
		return Secreterial;
	}
	
	public static WebElement MaharashtraS(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='stateId_listbox']/li[28]"));
		return Secreterial;
	}
	
	public static WebElement CityE(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='step1Content']/div/div[1]/div/div[4]/span[2]/span/span[2]"));
		return Secreterial;
	}
	
	public static WebElement AhmadnagarE(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='ddlreg_cityId_listbox']/li[3]"));
		return Secreterial;
	}
	
	public static WebElement SaveE(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='saveppcom']"));
		return Secreterial;
	}
	
	public static WebElement SaveEMsg(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='frmUpdatePublicprivatelisted']/div[1]/div/div/lable"));
		return Secreterial;                       
	}
	
	public static WebElement SaveEMsg1(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='frmUpdatePublicprivatelisted']/div[2]/div/div/lable"));
		return Secreterial;   //Entity/Company with same CIN already exists                     
	}
	
	public static WebElement CloseEntity(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='btnclose2']"));
		return Secreterial;                 
	}
	public static WebElement ClickDashboard(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='leftdashboardmenu']/a"));
		return Secreterial;                 
	}
	public static WebElement InValidDate(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='IncorporationDate_validationMessage']"));
		return Secreterial;                 
	}
	public static WebElement InValidPan(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='PAN_validationMessage']"));
		return Secreterial;                 
	}
	public static WebElement InValidROC(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='ROC_Code_validationMessage']"));
		return Secreterial;                 
	}
	public static WebElement InValidEmail(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='Email_Id_validationMessage']"));
		return Secreterial;                 
	}
	public static WebElement InValidFY(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='FY_validationMessage']"));
		return Secreterial;                 
	}
	public static WebElement InValidAddress(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='Regi_Address_Line1_validationMessage']"));
		return Secreterial;                 
	}
	public static WebElement InValidState(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='Regi_StateId_validationMessage']"));
		return Secreterial;                 
	}
	public static WebElement InValidCity(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='Regi_CityId_validationMessage']"));
		return Secreterial;                 
	}
	public static WebElement InvalidMsgName(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='EntityName_validationMessage']"));
		return Secreterial;                     
	}
	public static WebElement InvalidMsgeCIN(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='CIN_validationMessage']"));
		return Secreterial;                     
	}
	public static WebElement ClickFilter(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='filterSearch']"));
		return Secreterial;                     
	}
	public static WebElement clickEditIcon(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@class='k-grid-Edit k-grid-edit hoverCircle k-grid-button']"));
		return Secreterial;                     
	}
	public static WebElement clickUpdateBtn(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='frmUpdatePublicprivatelisted']/div[1]/div/div/lable"));
		return Secreterial;                     
	}
	public static WebElement clickInvalidDate(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='dpIncdate']"));
		return Secreterial;                     
	}
	public static WebElement clickBusinessActivity(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='mytabBA']/a"));
		return Secreterial;                     
	}
	public static WebElement clickcloseIcon(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("(//*[@class='k-button k-bare k-button-icon k-window-action'])[5]"));
		return Secreterial;                     
	}
	public static WebElement clickNewBusinessActivity(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='btnAddActivity']"));
		return Secreterial;                     
	}
	public static WebElement clickMainActivityCode(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='frmBusinessActivity']/div[1]/div/span[2]/span/span[1]"));
		return Secreterial;                     
	}
	public static WebElement clickMainActivityCodeDropdwon(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='MainActivityCode_listbox']/li[1]"));
		return Secreterial;                     
	}
	public static WebElement clickMainActivityCodeDropdwon1(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='MainActivityCode_listbox']/li[2]"));
		return Secreterial;                     
	}
	public static WebElement clickBA(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='frmBusinessActivity']/div[2]/div/span[2]/span/span[1]"));
		return Secreterial;                     
	}
	public static WebElement clickBADropdown(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='BusinessActivityCode_listbox']/li[1]"));
		return Secreterial;                     
	}
	public static WebElement clickBADropdown1(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='BusinessActivityCode_listbox']/li[1]"));
		return Secreterial;                     
	}
	public static WebElement clickSave(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='command_name']"));
		return Secreterial;                     
	}
	public static WebElement clickcloseIcon1(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("(//*[@class='k-button k-bare k-button-icon k-window-action'])[13]"));
		return Secreterial;                     
	}
	
	public static WebElement BAValidMsg(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='frmBusinessActivity']/div[1]/div/div/lable"));
		return Secreterial;                     
	}
	public static WebElement NoDataFound(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//*[@id='BusinessActivityCode-list']/div[4]/div)"));
		return Secreterial;
	}
	public static WebElement EditBA(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//*[@class='k-grid-Edit k-grid-edit hoverCircle k-grid-button'])[2]"));
		return Secreterial;
	}
	public static WebElement ClickPercentage(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='Percentages']"));
		return Secreterial;
	}
	public static WebElement ClickDeleteIcon(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-grid-Delete k-grid-delete hoverCircle k-grid-button'])"));
		return Secreterial;
	}
	public static WebElement ClickDelete(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='yesBA']"));
		return Secreterial;
	}
	public static WebElement ClickDeleteMsg(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='modalWindowBA']/h5"));
		return Secreterial;
	}
	
	public static WebElement ClickDocumentTab(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='mytab2']/a"));
		return Secreterial;
	}
	public static WebElement ClickNewBtn(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='customCommand1']"));
		return Secreterial;
	}
	public static WebElement ClickDocType(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='frmEntityDocumentsTypes']/div[3]/div/div[1]/div/div[2]/span/span/span[1]"));
		return Secreterial;
	}
	public static WebElement ClickDocTypeDropDown(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='DocumentType_listbox']/li[1]"));
		return Secreterial;
	}
	public static WebElement ClickFile(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//*[@id='files1'])[2]"));
		return Secreterial;
	}
	public static WebElement ClickSaveBtn(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//*[@id='saveppcom'])[2]"));
		return Secreterial;
	}
	public static WebElement ClickSaveBtnLLPDOC(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//*[@id='saveppcom'])"));
		return Secreterial;
	}
	public static WebElement ClickValidMsg(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='frmEntityDocumentsTypes']/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement ClickInValidMsg(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='frmEntityDocumentsTypes']/div[2]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement ClickCloseIcon(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-button k-bare k-button-icon k-window-action'])[18]"));
		return Secreterial;
	}
	public static WebElement ClickValidMsgFile(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='frmEntityDocumentsTypes']/div[2]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement ClickDescrition (WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='Discription']"));
		return Secreterial;
	}
	public static WebElement ClickViewIcon (WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//a[@class='k-grid-View k-grid-view k-grid-button hoverCircle']"));
		return Secreterial;
	}
	public static WebElement ClickViewAOAIcon (WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-grid-View k-grid-view k-grid-button hoverCircle'])[2]"));
		return Secreterial;
	}
	public static WebElement ClickViewCOIIcon (WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-grid-View k-grid-view k-grid-button hoverCircle'])[3]"));
		return Secreterial;
	}
	public static WebElement ClickClose (WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-button k-bare k-button-icon k-window-action'])[14]"));
		return Secreterial;
	}
	public static WebElement ClickDownloadIcon (WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//a[@class='k-grid-Download k-grid-download k-grid-button hoverCircle']"));
		return Secreterial;
	}
	public static WebElement ClickDownloadAOAIcon (WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-grid-Download k-grid-download k-grid-button hoverCircle'])[2]"));
		return Secreterial;
	}
	public static WebElement ClickDownloadCOIIcon (WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-grid-Download k-grid-download k-grid-button hoverCircle'])[3]"));
		return Secreterial;
	}
	public static WebElement ClickDeleteIcon1 (WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//a[@class='k-grid-Delete k-grid-delete k-grid-button']"));
		return Secreterial;
	}
	public static WebElement ClickDeleteAOAIcon1 (WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-grid-Delete k-grid-delete k-grid-button'])[2]"));
		return Secreterial;
	}
	public static WebElement ClickDeleteCOIIcon1 (WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-grid-Delete k-grid-delete k-grid-button'])[3]"));
		return Secreterial;
	}
	public static WebElement ClickYes(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='yes']"));
		return Secreterial;
	}
	public static WebElement ClickDeleteValidMsg(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='modalWindow']/h5"));
		return Secreterial;
	}
	public static WebElement ClickPolicies(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='PolicesDocument']/a"));
		return Secreterial;
	}
	public static WebElement ClickPoliciesType(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='DocumentType_listbox']/li[4]"));
		return Secreterial;
	}
	public static WebElement ClickAOA(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='DocumentType_listbox']/li[2]"));
		return Secreterial;
	}
	public static WebElement ClickCOI(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='DocumentType_listbox']/li[3]"));
		return Secreterial;
	}
	public static WebElement ClickPolicy(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='DocumentType_listbox']/li[4]"));
		return Secreterial;
	}
	public static WebElement ClickLicenseRegistration(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='DocumentType_listbox']/li[5]"));
		return Secreterial;
	}
	public static WebElement ClickLicenseRegistrationNo(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='LicenceNo']"));
		return Secreterial;
	}
	public static WebElement ClickLastRenewDate(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='BMDate']"));
		return Secreterial;
	}
	public static WebElement ClickUpcomingRenewDate(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='GMDate']"));
		return Secreterial;
	}
	public static WebElement ClickAnnualReport(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='DocumentType_listbox']/li[6]"));
		return Secreterial;
	}
	public static WebElement ClickSerialNoOfAGM(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='LicenceNo']"));
		return Secreterial;
	}
	public static WebElement ClickFY(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='divFY']/div/div[2]/span/span/span[1]"));
		return Secreterial;
	}
	public static WebElement SelectFY(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='FYID_listbox']/li[1]"));
		return Secreterial;
	}
	public static WebElement ClickBranchDetailes(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='mytab3']"));
		return Secreterial;
	}
	public static WebElement ClickName(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='tbxName']"));
		return Secreterial;
	}
	public static WebElement ClickContactPerson(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='tbxContactPerson']"));
		return Secreterial;
	}
	public static WebElement ClickContactNumber(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='tbxLandline']"));
		return Secreterial;
	}
	public static WebElement ClickEmail(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='tbxEmail']"));
		return Secreterial;
	}
	public static WebElement ClickAddressLine(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='tbxAddressLine1']"));
		return Secreterial;
	}
	public static WebElement ClickBtnSave(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='btnSave']"));
		return Secreterial;
	}
	public static WebElement ClickAddNew(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='btnaddBranch']"));
		return Secreterial;
	}
	public static WebElement ClickBranchType(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='ddlType_chosen']"));
		return Secreterial;
	}
	public static WebElement SelectBranchType(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='ddlType_chosen']/div/ul/li[3]"));
		return Secreterial;
	}
	public static WebElement ClickState(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='ddlState_chosen']"));
		return Secreterial;
	}
	public static WebElement SelectState(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='ddlState_chosen']/div/ul/li[4]"));
		return Secreterial;
	}
	public static WebElement ClickCity(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='ddlCity_chosen']"));
		return Secreterial;
	}
	public static WebElement SelectCity(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='ddlCity_chosen']/div/ul/li[3]"));
		return Secreterial;
	}
	public static WebElement ValidMsg(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='vsEntityBranchPage']/ul/li"));
		return Secreterial;
	}
	public static WebElement CloseIcon(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-button k-bare k-button-icon k-window-action'])[28]"));
		return Secreterial;
	}
	public static WebElement InvalidMsg(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='vsEntityBranchPage']/ul"));
		return Secreterial;
	}
	public static WebElement ClickStatus(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='ddlCustomerStatus_chosen']"));
		return Secreterial;
	}
	public static WebElement SelectStatus(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='ddlCustomerStatus_chosen']/div/ul/li[1]"));
		return Secreterial;
	}
	public static WebElement ClickEditIcon(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-grid-Edit k-grid-edit hoverCircle k-grid-button'])[6]"));
		return Secreterial;
	}
	public static WebElement ClickUploadDoc(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@class='k-grid-Upload k-grid-upload hoverCircle k-grid-button']"));
		return Secreterial;
	}
	public static WebElement SelectFile(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='files']"));
		return Secreterial;
	}
	public static WebElement ClickUpload(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='frmAgendaDocumentUpload']/div/div/div[2]/p[2]/button"));
		return Secreterial;
	}
	public static WebElement ClickCloseicon(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-button k-bare k-button-icon k-window-action'])[19]"));
		return Secreterial;
	}
	public static WebElement ClickUploadValidMsg(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='frmAgendaDocumentUpload']/div[1]/div/div/label"));
		return Secreterial;
	}
	public static WebElement ClickUploadInValidMsg(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='frmAgendaDocumentUpload']/div[1]/div/div/lable"));
		return Secreterial;
	}
	
	public static WebElement BankDetailes(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='mytab4']"));
		return Secreterial;
	}
	public static WebElement AddBankDetailes(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='CreateNewAccount']"));
		return Secreterial;
	}
	public static WebElement ClickAccNo(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='AccNo']"));
		return Secreterial;
	}
	public static WebElement ClickBankName(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='BankName']"));
		return Secreterial;
	}
	public static WebElement ClickAccType(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='frmNewBankDetails']/div[3]/div[3]/div/div[2]/span/span/span[1]"));
		return Secreterial;
	}
	public static WebElement SelectAccType(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='ddlType_listbox']/li[2]"));
		return Secreterial;
	}
	public static WebElement ClickSave(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='command_name']"));
		return Secreterial;
	}
	public static WebElement ClickCloseIcon1(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-button k-bare k-button-icon k-window-action'])[2]"));
		return Secreterial;
	}
	public static WebElement ClickOpeningDate(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='dpOpenDate']"));
		return Secreterial;
	}
	public static WebElement ClickClosingDate(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='dpCloseDate']"));
		return Secreterial;
	}
	public static WebElement BankvalidMsg(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='frmNewBankDetails']/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement AccnoBankInavalidMsg(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='AccNo_validationMessage']"));
		return Secreterial;
    }
	public static WebElement BankNameBankInavalidMsg(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='BankName_validationMessage']"));
		return Secreterial;
	}
	public static WebElement IFSCBankInavalidMsg(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='Ifsc_validationMessage']"));
		return Secreterial;
	}
	public static WebElement ClickIfsc(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='Ifsc']"));
		return Secreterial;
	}
	public static WebElement ClickTypeOfAccount(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='AccTypeId_validationMessage']"));
		return Secreterial;
	}
	public static WebElement InvalidOpenDate(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='OpenDate_validationMessage']"));
		return Secreterial;
	}
	public static WebElement InvalidOpenDate1(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='frmNewBankDetails']/div[3]/div[6]/div/div[2]/span[2]"));
		return Secreterial;
	}
	public static WebElement UpdateBankDetailes(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("(//a[@class='k-grid-Edit k-grid-edit hoverCircle k-grid-button'])[7]"));
		return Secreterial;
	}
	public static WebElement DeleteBankDetailes(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//a[@class='k-grid-delete k-grid-cancel hoverCircle k-grid-button']"));
		return Secreterial;
	}
	public static WebElement DeleteBankDetailes1(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='no']"));
		return Secreterial;
	}
	public static WebElement LimitedLiabilityPartnership(WebDriver driver)
	{
		Secreterial=driver.findElement(By.xpath("//*[@id='ddlEntityType_listbox']/li[6]"));
		return Secreterial;
	}public static WebElement LLPEntityName(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*//*[@id='txtllpEntityName']"));
		return Secreterial;
	}
	public static WebElement LLPPin(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='txtCINllp']"));
		return Secreterial;
	}
	public static WebElement GSTIN(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='txtGstnllp']"));
		return Secreterial;
	}
	public static WebElement ClickCalenderIcon(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*//span[@class='k-icon k-i-calendar']"));
		return Secreterial;
	}
	public static WebElement ClickRoc(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='llpRocJurisdiction']"));
		return Secreterial;
	}
	public static WebElement ClickEmailLLP(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='txtEmailIdllp']"));
		return Secreterial;
	}
	public static WebElement LLPFinancialYear(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='panelbar_LLPDetails']/li/div/div[1]/div/div[3]/span[2]/span/span[1]"));
		return Secreterial;
	}
	public static WebElement LLPAddressE(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='txtRegAddressllp1']"));
		return Secreterial;
	}
	public static WebElement LLPStateE(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='step1Content']/div[1]/div/div[3]/span[2]/span/span[1]"));
		return Secreterial;
	}
	public static WebElement LLPCityE(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='step1Content']/div[1]/div/div[4]/span[2]/span/span[1]"));
		return Secreterial;
	}
	public static WebElement LLPPan(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='txtPANllp']"));
		return Secreterial;
	}
	public static WebElement LLPSaveE(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='btnllp']"));
		return Secreterial;
	}
	public static WebElement LLPAddress2(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='txtRegAddress2llp']"));
		return Secreterial;
	}
	public static WebElement LLPSaveMsg(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='frmUpdateEntityLLP']/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement LLPSaveMsg2(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='frmUpdateEntityLLP']/div[2]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement FYValidMsg(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='llpFY_validationMessage']"));
		return Secreterial;
	}
	public static WebElement DateValidMsg(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='llpIncorporationDate_validationMessage']"));
		return Secreterial;
	}
	public static WebElement RocValidMsg(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='llpROC_Code_validationMessage']"));
		return Secreterial;
	}
	public static WebElement EmailValidMsg(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='llpEmail_Id_validationMessage']"));
		return Secreterial;
	}
	public static WebElement PANValidMsg(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='llpPAN_validationMessage']"));
		return Secreterial;
	}
	public static WebElement AddressValidMsg(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='llpRegi_Address_Line1_validationMessage']"));
		return Secreterial;
	}
	public static WebElement Address2ValidMsg(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='llpRegi_Address_Line2_validationMessage']"));
		return Secreterial;
	}
	public static WebElement CompnayNameValidMsg(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='EntityName_validationMessage']"));
		return Secreterial;
	}
	public static WebElement LLPINValidMsg(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='LLPIN_validationMessage']"));
		return Secreterial;
	}
	public static WebElement UpdateLLPValidMsg(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("//*[@id='frmUpdateEntityLLP']/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement EditBALLP(WebDriver driver)		//Method for closing Message Popup
	{
		Secreterial = driver.findElement(By.xpath("(//a[@class='k-grid-Edit k-grid-edit hoverCircle k-grid-button'])[2]"));
		return Secreterial;
	}
}
