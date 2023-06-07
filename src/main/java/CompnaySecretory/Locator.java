package CompnaySecretory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Locator {
	
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
	public static WebElement CommitteeMaster(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastermenu']/ul/li[3]/a")));
		return Secreterial;
	}
	public static WebElement NewCommittee(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='customCommand']")));
		return Secreterial;
	}
	public static WebElement CommitteeName(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Name']")));
		return Secreterial;
	}
	public static WebElement Description(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//textarea[@class='form-control k-textbox k-valid']"));
		return Secreterial;
	}
	public static WebElement SaveBtn(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnsub1']")));
		return Secreterial;
	}
	public static WebElement ValidationMsg(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divDetailsNew']/div/div/div/div/lable")));
		return Secreterial;
	}
	public static WebElement ValidationMsg1(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divDetailsNew']/div/fieldset/div/div[1]/span[2]")));
		return Secreterial;
	}
	public static WebElement ValidationMsg2(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divDetailsNew']/div/fieldset/div/div[1]/span[2]")));
		return Secreterial;
	}
	public static WebElement CloseBtn(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnclose1']")));
		return Secreterial;
	}
	public static WebElement EditIcon(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//a[@class='k-grid-Edit k-grid-edit hoverCircle k-grid-button'])[1]"));
		return Secreterial;
	}
	public static WebElement ClickRule(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@class='k-grid-R hoverCircle']"));
		return Secreterial;
	}
	public static WebElement ClickComapnayName(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='divDetailsNew']/div/fieldset/div[1]/div/div[1]/span/span/span[1]"));
		return Secreterial;
	}
	
	public static WebElement SelectComapnayName(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='ddlEntityId_listbox']/li[1]"));
		return Secreterial;
	}
	public static WebElement SelectComapnayName1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlEntityId_listbox']/li[5])[2]"));
		return Secreterial;
	}
	public static WebElement ClickDesignation(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateMinimumDirector']/fieldset/div[1]/div/div[1]/span/span/span[1]"));
		return Secreterial;
	}
	public static WebElement SelectDesignation(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='DesignationId_listbox']/li[1]"));
		return Secreterial;
	}
	
	public static WebElement TotalStrength(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='DesignationCount']"));
		return Secreterial;
	}
	public static WebElement TotalStrength1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='DesignationCount'])[2]"));
		return Secreterial;
	}
	public static WebElement TotalStrengthNo(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='DesignationNumerator']"));
		return Secreterial;
	}
	public static WebElement TotalStrengthNo1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='DesignationNumerator'])[2]"));
		return Secreterial;
	}
	public static WebElement TotalStrengthDenomirator(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='DesignationDenominator']"));
		return Secreterial;
	}
	public static WebElement TotalStrengthDenomirator1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='DesignationDenominator'])[2]"));
		return Secreterial;
	}
	public static WebElement ClickAdd(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		return Secreterial;
	}
	public static WebElement ClickAdd1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		return Secreterial;
	}
	public static WebElement ValidationQuram(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateQuorum']/fieldset/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement ClickClose(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html/body/div[10]/div[1]/div/a"));
		return Secreterial;
	}
	public static WebElement RuleValidationMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateMinimumDirector']/fieldset/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement RuleQuoram(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='viewPlaceHolder']/div/ul/li[2]"));
		return Secreterial;
	}
	public static WebElement QuoramDesignation(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateQuorum']/fieldset/div[1]/div/div[1]/span/span/span[1]"));
		return Secreterial;
	}
	public static WebElement SelectQuoramDesignation(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='DesignationIdQuorum_listbox']/li[2]"));
		return Secreterial;
	}
	public static WebElement clickMeeting(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='viewPlaceHolder']/div/ul/li[3]"));
		return Secreterial;
	}
	public static WebElement clickMeeting1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='MinMeeting']"));
		return Secreterial;
	}
	public static WebElement clickGapMeeting(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='MeetingGapInDays']"));
		return Secreterial;
	}
	public static WebElement SaveMeeting(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='btnsub1']"));
		return Secreterial;
	}
	public static WebElement ValidationMeeting(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateMeeting']/fieldset/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement UploadDocument(WebDriver driver)
	{
		
		//Secreterial =driver.findElement(By.xpath("//*[@id='gridKendo_active_cell']/a[4]/span/img"));
		Secreterial =driver.findElement(By.xpath("//a[@class='k-grid-Upload k-grid-upload hoverCircle k-grid-button']"));
		return Secreterial;
	}
	public static WebElement SelectFiles(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='files']"));
		return Secreterial;
	}
	public static WebElement ClickUploadBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmAgendaDocumentUpload']/div/div/div[2]/p[2]/button"));
		return Secreterial;
	}
	
	public static WebElement UploadFileValidation(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmAgendaDocumentUpload']/div[1]/div/div/label"));
		return Secreterial;
	}
	public static WebElement UploadFileValidation1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmAgendaDocumentUpload']/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement CloseBtn1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html/body/div[11]/div[1]/div/a"));
		return Secreterial;
	}
	public static WebElement ClickDeleteCommittee(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//a[@class='k-grid-Delete k-grid-delete hoverCircle k-grid-button'])[1]"));
		return Secreterial;
	}
	public static WebElement clickEditMemberRule(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='tblDetailsOfMinDirector']/tbody/tr/td[3]/a[1]/span/img"));
		return Secreterial;
	}
	public static WebElement clickDeleteMemberRule(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@class='k-grid-delete k-grid-button']"));
		return Secreterial;
	}
	public static WebElement clickDeleteQuramRule(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='tblDetailsOfQuorum']/tbody/tr[1]/td[3]/a[2]/span/img"));
		return Secreterial;
	}
	public static WebElement clickValidationMemberRule(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateMinimumDirector']/fieldset/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement clickeditQuramRule(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='tblDetailsOfQuorum']/tbody/tr/td[3]/a[1]/span/img"));
		return Secreterial;
	}
	public static WebElement clickValidationQuramRule(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateQuorum']/fieldset/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement clickUser(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Mastermenu']/ul/li[9]"));
		return Secreterial;
	}
	public static WebElement clickNewUser(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='btnCreateNewUser']"));
		return Secreterial;
	}
	public static WebElement clickFirstName(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='FirstName']"));
		return Secreterial;
	}
	public static WebElement clickLastName(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='LastName']"));
		return Secreterial;
	}
	public static WebElement clickEmail(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Email']"));
		return Secreterial;
	}
	public static WebElement clickContactNo(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='ContactNumber']"));
		return Secreterial;
	}
	public static WebElement clickAddress(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Address']"));
		return Secreterial;
	}
	public static WebElement clickSecreterialRole(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='divAddUser']/fieldset/div[6]/div/div[2]/span[1]/span/span[1]"));
		return Secreterial;
	}
	public static WebElement SelectSecreterialRole(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='SecretarialRoleId_listbox']/li[2]"));
		return Secreterial;
	}
	public static WebElement ClickSaveBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='command_name1']"));
		return Secreterial;
	}
	public static WebElement ClickMaster(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Mastermenu']/span"));
		return Secreterial;
	}
	public static WebElement ValidationUserMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		return Secreterial;
	}
	public static WebElement CloseUserPopup(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html/body/div[9]/div[1]/div/a"));
		return Secreterial;
	}
	public static WebElement ClickEditUser(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//a[@class='k-grid-Edit k-grid-edit k-grid-button'])[1]"));
		return Secreterial;
	}
	public static WebElement ValidationUserMsg1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='divAddUser']/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement ClickFilter(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='filter']"));
		return Secreterial;
	}
	public static WebElement ValidationContactNo(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='ContactNumber_validationMessage']"));
		return Secreterial;
	}
	public static WebElement InvalidMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='FirstName_validationMessage']"));
		return Secreterial;
	}
	public static WebElement ClickCommitteeCompistion(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Mastermenu']/ul/li[4]"));
		return Secreterial;
	}
	public static WebElement ClickNewBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='childrow']/div/div/div/div[1]/div/div[5]/button"));
		return Secreterial;
	}
	public static WebElement ClickEntity(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id=\"window\"]/div[3]/div/div[2]/span[1]/span/span[1]"));
		return Secreterial;
	}
	public static WebElement SelectEntity(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Entity_Id_listbox']/li[2]"));
		return Secreterial;
	}
	public static WebElement ClickCommittee(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='window']/div[4]/div/div[2]/span[1]/span/span[1]"));
		return Secreterial;
	}
	public static List<WebElement> SelectCommittee(WebDriver driver)
	{
		
		elementsList =driver.findElements(By.xpath("//*[@id='Committee_Id_listbox']/li"));
		return elementsList;
	}
	public static WebElement ClickDirector(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='divUserMember']/span[1]/span/span[1]"));
		return Secreterial;
	}
	public static List<WebElement> SelectDirector(WebDriver driver)
	{
		WebDriverWait Wait = new WebDriverWait(driver,30);
		elementsList =driver.findElements(By.xpath("//*[@id='UserId_listbox']/li"));
		return elementsList;
	}
	public static WebElement ClickPostion(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='window']/div[6]/div/div[2]/span[1]/span/span[1]"));
		return Secreterial;
	}
	public static WebElement SelectPostion(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='PositionId_listbox']/li[2]"));
		return Secreterial;
	}
	public static WebElement SelectPostion1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='PositionId_listbox']/li[3]"));
		return Secreterial;
	}
	public static WebElement DateOfAppoinment(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='AppointmentFrom']"));
		return Secreterial;
	}
	public static WebElement DateofCessation(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='AppointmentTo']"));
		return Secreterial;
	}
	public static WebElement SaveBtn1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//button[@class='k-primary k-button k-grid-update k-button-icontext']"));
		return Secreterial;
	}
	public static WebElement ValidationMsgCommittee(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='lblsuccess']"));
		return Secreterial;
	}
	public static WebElement ValidationMsgCommittee1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='lblerrormsg']"));
		return Secreterial;
	}
	public static WebElement clickdropdown(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='childrow']/div/div/div/div[1]/div/div[1]/span/span/span[1]"));
		return Secreterial;
	}
	public static WebElement selectdropdown(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//ul[@id='ddlEntityId_listbox']/li)[2]"));
		return Secreterial;
	}
	public static WebElement clickediticon(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//a[@class='k-grid-edit k-grid-button'])[1]"));
		return Secreterial;
	}
	public static WebElement clickdeleteicon(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@class='k-grid-delete k-grid-button'][1]"));
		return Secreterial;
	}
	public static WebElement clickExportToPdf(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@class='btn btn-primary k-grid-pdf pull-right']"));
		return Secreterial;
	}
	public static WebElement ReadPageNo(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//span[@class='k-pager-info k-label']"));
		return Secreterial;
	}
	public static WebElement ClickConfiguration(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Mastermenu']/ul/li[8]"));
		return Secreterial;
	}
	public static WebElement ClickNewBtn1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='CreatenewMeetingModule']"));
		return Secreterial;
	}
	public static WebElement ClickEntity1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateMeetings']/div[3]/div/div[1]/div/div[1]/span[2]/span/span[1]"));
		return Secreterial;
	}
	public static List<WebElement> SelectEntity1(WebDriver driver)
	{
		
		elementsList =driver.findElements(By.xpath("//*[@id='entityID_listbox']/li"));
		return elementsList;
	}
	public static WebElement ClickMeetingType(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateMeetings']/div[3]/div/div[2]/div/div/span[2]/span/span[1]"));
		return Secreterial;
	}
	public static List<WebElement> SelectMeetingType(WebDriver driver)
	{
		
		elementsList =driver.findElements(By.xpath("//*[@id='MeetingType_listbox']/li"));
		return elementsList;
	}
	public static WebElement SelectMeetingType1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//li[@class='k-item'])[328]"));
		return Secreterial;
	}
	public static WebElement clickMeetingDate(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='MeetingDate']"));
		return Secreterial;
	}
	public static WebElement clickMeetingNumberingPattern(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateMeetings']/div[3]/div/fieldset/div[1]/div/div[2]/span[2]/span/span[1]"));
		return Secreterial;
	}
	public static WebElement clickMeetingNumberingPatternDP(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='ddlMeetingNoType_listbox']/li[3]"));
		return Secreterial;
	}
	public static WebElement clickMeetingNumberingPatternDP1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlMeetingNoType_listbox']/li[2])[7]"));
		return Secreterial;
	}
	public static WebElement clickMeetingNumberingPatternDP2(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlMeetingNoType_listbox']/li[2])[12]"));
		return Secreterial;
	}
	
	public static WebElement ClickPreviousNumber(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='txtmeetingNo']"));
		return Secreterial;
	}
	public static WebElement ClickSave(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='saveconfig']"));
		return Secreterial;
	}
	public static WebElement ValidMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateMeetings']/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement InValidMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateMeetings']/div[2]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement clickdetailsofcircular(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateMeetings']/div[3]/div/fieldset/div[2]/div/div/div[2]/label[1]"));
		return Secreterial;
	}
	public static WebElement Clickpreviouscirculardate(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='CircularDate']"));
		return Secreterial;
	}
	public static WebElement clickcircularNumberingpattern(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='DivCircular']/div[2]/span[2]/span/span[1]"));
		return Secreterial;
	}
	public static List<WebElement> clickcircularNumberingpatternDP(WebDriver driver)
	{
		
		elementsList =driver.findElements(By.xpath("//ul[@id='ddlCircularNoType_listbox']/li"));
		return elementsList;
	}
	public static WebElement clickcircularNumber(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='txtCircularNo']"));
		return Secreterial;
	}
	
	public static WebElement clickFY(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateMeetings']/div[3]/div/fieldset/div[1]/div/div[4]/span[2]/span/span[1]"));
		return Secreterial;
	}
	public static WebElement clickFYDropdown(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='ddlFinancialYear_listbox']/li[5]"));
		return Secreterial;
	}
	
	public static WebElement clickFY1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='ddlFinancialYearforCircular_listbox']/li[4]"));
		return Secreterial;
	}
	public static WebElement clickFYDropdown1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//a[@class='k-button k-bare k-button-icon k-window-action'])[1]"));
		return Secreterial;
	}
	public static WebElement clickEditIcon(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@class='k-grid-Edit k-grid-edit hoverCircle k-grid-button']"));
		return Secreterial;
	}
	public static WebElement clickEditIcon1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@class='k-grid-Edit k-grid-edit']"));
		return Secreterial;
	}
	public static WebElement clickUpdate(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//button[@type='submit']"));
		return Secreterial;
	}
	public static WebElement clickClose(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@class='k-button k-bare k-button-icon k-window-action']"));
		return Secreterial;
	}
	public static WebElement clickUpdateBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateMeetings']/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement clickDate(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//a[@title='Thursday, April 20, 2023'])"));
		return Secreterial;
	}
	public static WebElement clickCalender(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//span[@class='k-icon k-i-calendar']"));
		return Secreterial;
	}
	public static WebElement clickAuditor(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Mastermenu']/ul/li[5]"));
		return Secreterial;
	}
	public static WebElement clickAuditorNew(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='customCommand']"));
		return Secreterial;
	}
	public static WebElement clickAuditorCreateNew(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='viewPlaceHolder']/div[1]/div[1]/label[1]"));
		return Secreterial;
	}
	public static WebElement clickAuditorType(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='panelbar_AuditorDetails']/li/div/div[1]/div/div[1]/span/span/span[1]"));
		return Secreterial;
	}
	public static WebElement SelectAuditorTypeDropDown(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='ddlAuditor_Type_listbox']/li[1]"));
		return Secreterial;
	}
	public static WebElement SelectAuditorTypeDropDown4(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Type_listbox']/li[1])[10]"));
		return Secreterial;
	}
	public static WebElement SelectAuditorTypeDropDown5(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Type_listbox']/li[1])[13]"));
		return Secreterial;
	}
	public static WebElement SelectAuditorTypeDropDown3(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Type_listbox']/li[1])[2]"));
		return Secreterial;
	}
	public static WebElement SelectAuditorTypeDropDown1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Type_listbox']/li[1])[6]"));
		return Secreterial;
	}
	public static List<WebElement> SelectAuditorTypeDropDown6(WebDriver driver)
	{
		
		//Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Type_listbox']/li[2])[17]"));
		elementsList =driver.findElements(By.xpath("//*[@id='ddlAuditor_Type_listbox']/li"));
		return elementsList;
	}
	public static WebElement SelectAuditorTypeDropDown7(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Type_listbox']/li[1])[24]"));
		return Secreterial;
	}
	public static WebElement SelectAuditorTypeDropDown8(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Type_listbox']/li[2])[25]"));
		return Secreterial;
	}
	public static WebElement SelectAuditorTypeDropDownInternal(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Type_listbox']/li[2])[8]"));
		return Secreterial;
	}
	public static WebElement SelectAuditorTypeDropDownSecreterial(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Type_listbox']/li[3])[3]"));
		return Secreterial;
	}
	public static WebElement SelectInternalAuditorDropDown(WebDriver driver)
	{
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
		Secreterial =driver.findElement(By.xpath("(//li[@class='k-item'])[59]"));
		return Secreterial;
	}
	public static WebElement SelectSecretarialAuditorDropDown(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Type_listbox']/li[3])"));
		return Secreterial;
	}
	public static WebElement SelectCostAuditorDropDown(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Type_listbox']/li[4])"));
		return Secreterial;
	}
	public static WebElement clickCategoryOfAuditor(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='panelbar_AuditorDetails']/li/div/div[1]/div/div[2]/span/span/span[1]"));
		return Secreterial;
	}
	public static WebElement SelectCategoryOfAuditor(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='ddlAuditor_Category_listbox']/li[2]"));
		//Secreterial =driver.findElement(By.linkText("Individual"));
		return Secreterial;
	}
	public static WebElement SelectCategoryOfAuditor1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Category_listbox']/li[2])"));
		return Secreterial;
	}
	public static WebElement SelectCategoryOfAuditor2(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Category_listbox']/li[2])[5]"));
		return Secreterial;
	}
	public static WebElement SelectCategoryOfAuditor3(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Category_listbox']/li[3])[7]"));
		return Secreterial;
	}
	public static WebElement SelectCategoryOfAuditor4(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Category_listbox']/li[2])[13]"));
		return Secreterial;
	}
	public static List<WebElement> SelectCategoryOfAuditor5(WebDriver driver)
	{
		
		//Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_Category_listbox']/li[2])[17]"));
		elementsList=driver.findElements(By.xpath("//*[@id='ddlAuditor_Category_listbox']/li"));
		
		return elementsList;
	}
	public static WebElement clickAuditorName(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='txtFirstName_Auditor_or_AuditorFirm']"));
		return Secreterial;
	}
	public static WebElement clickAuditorName1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("name='Audit_FirmName_FullName"));
		return Secreterial;
	}
	public static WebElement clickAuditorEmail(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='txtEmail']"));
		return Secreterial;
	}
	public static WebElement clickRegistrationNo(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='txtName_of_Auditor_or_AuditorFirm']"));
		return Secreterial;
	}
	public static WebElement clickMobileNo(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//input[@data-val-number='The field MobileNo must be a number.']"));
		return Secreterial;
	}
	public static WebElement clickPANno(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//input[@data-val-regex='Please Enter valid PAN Number']"));
		return Secreterial;
	}
	public static WebElement clickAddressLine(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='txtAddressLine1']"));
		return Secreterial;
	}
	public static WebElement clickSaveBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='btnllp']"));
		return Secreterial;
	}
	public static WebElement clickValidMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateAuditor']/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement clickValidMsgAuditor(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmUpdateAuditor']/div[2]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement clickValidMsg1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Audit_FirmName_FullName_validationMessage']"));
		return Secreterial;
	}
	public static WebElement clickValidMsg2(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Audit_CategoryId_validationMessage']"));
		return Secreterial;
	}
	public static WebElement clickValidMsg3(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Auditor_Type_validationMessage']"));
		return Secreterial;
	}
	public static WebElement clickValidMsg4(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Email_Id_validationMessage']"));
		return Secreterial;
	}
	public static WebElement clickValidMsg5(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='AuditorFirmRegistration_Number_validationMessage']"));
		return Secreterial;
	}
	public static WebElement clickValidMsg6(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='AddressLine1_validationMessage']"));
		return Secreterial;
	}
	public static WebElement clickValidMsg7(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='MobileNo_validationMessage']"));
		return Secreterial;
	}
	public static WebElement clickValidMsg8(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Pan_Number_validationMessage']"));
		return Secreterial;
	}
	public static WebElement clickAuditorCreateFromExisting(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='viewPlaceHolder']/div[1]/div[1]/label[2]"));
		return Secreterial;
	}
	public static WebElement clickAuditorFirm(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='divAuditorList']/span/span/span[1]"));
		return Secreterial;
	}
	public static WebElement SelectAuditorFirm(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_listbox']/li[3])[5]"));
		return Secreterial;
	}
	public static WebElement clickCloseBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='btncloseAuditorMasterNew']"));
		return Secreterial;
	}
	public static WebElement clickEditicon(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@class='k-grid-Edit k-grid-edit hoverCircle k-grid-button']"));
		return Secreterial;
	}
	public static WebElement clickDeleteicon(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@class='k-grid-Delete k-grid-delete k-grid-button']"));
		return Secreterial;
	}
	public static WebElement clickYes(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='yes']"));
		return Secreterial;
	}
	public static WebElement clickUploadBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='childrow']/div/div/div/div[1]/div/div[3]/input"));
		return Secreterial;
	}
	public static WebElement clickChooseFile(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement Secreterial = wait.until(ExpectedConditions.elementToBeClickable(By.name("File")));
		return Secreterial;
	}
	public static WebElement clickUploadFile(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='btnuploadEntity']"));
		return Secreterial;
	}
	public static WebElement clickUploadValidMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='DivAuditorUpload']/div[1]/div/lable"));
		return Secreterial;
	}
	
	public static WebElement clickClosebtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html/body/div[9]/div[1]/div/a"));
		return Secreterial;
	}
	public static WebElement clickCounrty(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='step1Content']/div[2]/div/div[1]/span[2]/span/span[1]"));
		return Secreterial;
	}
	public static WebElement clickAuditorDropdown(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='divAuditorList']/span/span/span[1]"));
		return Secreterial;
	}
	public static WebElement selectAuditorDropdown(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='ddlAuditor_listbox']/li[3]"));
		return Secreterial;
	}
	public static WebElement selectAuditorDropdown1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_listbox']/li[4])[3]"));
		return Secreterial;
	}
	public static WebElement selectAuditorDropdown2(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_listbox']/li[5])[5]"));
		return Secreterial;
	}
	public static WebElement selectAuditorDropdown3(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_listbox']/li[2])[7]"));
		return Secreterial;
	}
	public static List<WebElement> selectAuditorDropdown4(WebDriver driver)
	{
		
		elementsList =driver.findElements(By.xpath("//*[@id='ddlAuditor_listbox']/li"));
		return elementsList;
	}
	public static WebElement selectAuditorDropdown5(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_listbox']/li[6])[17]"));
		return Secreterial;
	}
	public static WebElement selectAuditorDropdown6(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@id='ddlAuditor_listbox']/li[6])[18]"));
		return Secreterial;
	}
	public static WebElement FNValidMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='FirstName_validationMessage']"));
		return Secreterial;
	}
	public static WebElement LNValidMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='LastName_validationMessage']"));
		return Secreterial;
	}
	public static WebElement EmailValidMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Email_validationMessage']"));
		return Secreterial;
	}
	public static WebElement ContactNoValidMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='ContactNumber_validationMessage']"));
		return Secreterial;
	}
	
}
