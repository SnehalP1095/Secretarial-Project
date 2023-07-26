package CompnaySecretory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWorkspaceLocator 
{

	private static WebElement Secreterial;
	private static List<WebElement> elementsList = null;
	
	
	public static WebElement MyWorkspaceimg(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='k-link k-header'])[6]")));
		return Secreterial;
	}
	
	public static WebElement ConcludedMeeting(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='myWorkspacemenu']/ul/li[4]/a/span")));
		return Secreterial;
	}
	public static WebElement NewButton(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='customCommand1']")));
		return Secreterial;
	}
	public static WebElement EditButton(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='k-grid-Edit k-grid-edit hoverCircle k-grid-button']")));
		return Secreterial;
	}
	public static WebElement MoreAction(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='k-input'])[5]")));
		return Secreterial;
	}
	public static WebElement ComplianceTab(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='griDDLActionMenu_listbox']/li[1]/span)[11]")));
		return Secreterial;
	}
	public static WebElement CloseIcon(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='k-button k-bare k-button-icon k-window-action'])[4]")));
		return Secreterial;
	}
	public static WebElement CloseIcon1(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[10]/div[1]/div/a")));
		return Secreterial;
	}
	public static WebElement CloseIcon2(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[15]/div[1]/div/a")));
		return Secreterial;
	}
	public static WebElement DraftResolutionandMinuteTab(WebDriver driver)
	{
		//WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =driver.findElement(By.xpath("(//*[@class='k-item'])[206]"));
	  
		return Secreterial;
	}
	public static WebElement DraftResolutionandMinuteDonloadIcon(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='lnkDownloadDoc']")));
		return Secreterial;
	}
	public static WebElement Anneture(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divTabPanel1']/ul/li[2]/a")));
		return Secreterial;
	}
	public static WebElement selectFile(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//input[@id='files']"));
		return Secreterial;
	}
	public static WebElement clickUpload(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[2]")));
		return Secreterial;
	}
	public static WebElement clickValidationMsg(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frmAgendaDocumentUpload']/div[1]/div/div/label")));
		return Secreterial;
	}
	public static WebElement clickValidationMsg1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//span[@class='k-file-validation-message']"));
		return Secreterial;
	}
	public static WebElement clickValidationMsg2(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmAgendaDocumentUpload']/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement clickViewIcon(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@class='k-grid-View k-grid-view k-grid-button hoverCircle']"));
		return Secreterial;
	}
	public static WebElement clickCloseIcon(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html[1]/body[1]/div[70]/div[1]/div[1]/a[1]"));
		return Secreterial;
	}
	public static WebElement clickDownloadIcon(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@class='k-grid-Download k-grid-download k-grid-button hoverCircle']"));
		return Secreterial;
	}
	public static WebElement clickDeleteIcon(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[3]/a[3]"));
		return Secreterial;
	}
	public static WebElement clickValidMsg2(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='divAgendaDocsDeleteMsg']/div/div/div/lable"));
		return Secreterial;
	}
	
	public static WebElement MinutesTab(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='k-item'])[207]")));
		return Secreterial;
	}
	
	public static WebElement clickCloseIcon2(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html[1]/body[1]/div[15]/div[1]/div[1]/a[1]"));
		return Secreterial;
	}
	public static WebElement clickDownloadLicon(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//span[@id='downloadButton']"));
		return Secreterial;
	}
	public static WebElement clickiframe(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//iframe[@id='docViewerStatutory']"));
		return Secreterial;
	}
	public static WebElement clickiframe1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//iframe[@id='7885']"));
		return Secreterial;
	}
	

	public static WebElement CertifiedTrueCopyTab(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='k-item'])[208]")));
		return Secreterial;
	}
	public static WebElement clickCloseIcon3(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html[1]/body[1]/div[19]/div[1]/div[1]/a[1]"));
		return Secreterial;
	}
	public static WebElement clickPreviewCTC(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@id='btnPriview1']"));
		return Secreterial;
	}
	
	public static WebElement clickCloseIcon4(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html[1]/body[1]/div[70]/div[1]/div[1]/a[1]"));
		return Secreterial;
	}
	public static WebElement clickDownloadCTCIcon(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@id='btnDownloadword1']"));
		return Secreterial;
	}
	public static WebElement clickDownloadCTCPDFIcon(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@id='btnDownloadpdf1']"));
		return Secreterial;
	}
	
	public static WebElement UploadDocTab(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='k-item'])[209]")));
		return Secreterial;
	}
	public static WebElement clickCloseIcon5(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[30]/div[1]/div[1]/a[1]")));
		return Secreterial;
	}
	public static WebElement clickvalidmsg(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//lable[@id='lblsuccessI']")));
		return Secreterial;
	}
	public static WebElement clickViewIcon1(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='k-grid-View k-grid-view k-grid-button hoverCircle']")));
		return Secreterial;
	}
	public static WebElement clickError(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =driver.findElement(By.xpath("//div[@class='jconfirm-content']"));
		return Secreterial;
	}
	public static WebElement clickCloseIcon6(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =driver.findElement(By.xpath("/html/body/div[14]/div[1]/div/a"));
		return Secreterial;
	}
	public static WebElement clickIframe(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/div[3]/span[2]/div/iframe"));
		return Secreterial;
	}
	
	public static WebElement clickDownloadIcon1(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='k-grid-Download k-grid-download k-grid-button hoverCircle']")));
		return Secreterial;
	}
	public static WebElement clickDeleteIcon1(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[30]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[3]/span[1]/img[1]")));
		return Secreterial;
	}
	public static WebElement CopyMeetingTab(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Secreterial =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='k-item'])[212]")));
		return Secreterial;
	}
	public static WebElement clickCloseIcon7(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html[1]/body[1]/div[40]/div[1]/div[1]/a[1]"));
		return Secreterial;
	}
	public static WebElement clickEntityName(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//input[@class='k-input k-readonly']"));
		return Secreterial;
	}
	public static WebElement clickEntityName1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='lstEntityId_taglist']/li/span[1]"));
		return Secreterial;
	}
	public static WebElement selectEntityName(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@type='checkbox'])[5]"));
		return Secreterial;
	}
	public static WebElement selectEntityName1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//*[@type='checkbox'])[6]"));
		return Secreterial;
	}
	public static WebElement clickCheckbox(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//input[@class='chkbxCopyAgenda']"));
		return Secreterial;
	}
	public static WebElement clickCheckbox1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//input[@id='CopyAgendaHeader_chb']"));
		return Secreterial;
	}
	public static WebElement clickSave(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//button[@id='btnSaveAgendaItemSelected']"));
		return Secreterial;
	}
	public static WebElement clickClose(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//button[@id='btnCloseCopyMeetingWnd']"));
		return Secreterial;
	}
	public static WebElement clickValidMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='divCopyMeetingMessage']/div/div/div/lable"));
		return Secreterial;
	}
	public static WebElement clickLog(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//span[@class='k-link k-header'])[10]"));
		return Secreterial;
	}
	public static WebElement clickLogDelete(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html[1]/body[1]/div[40]/div[2]/div[1]/form[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/a[1]/span[1]/img[1]"));
		return Secreterial;
	}
	public static WebElement clickLogDelete1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//button[@type='Submit']"));
		return Secreterial;
	}
	public static WebElement clickLogDeleteMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='frmDeleteMeeting']/div[1]/div/div"));
		return Secreterial;
	}
	public static WebElement clickLogDeleteMsg1(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//lable[@id='lblsuccessI']"));
		return Secreterial;
	}
	public static WebElement clickLogDeleteClose(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html[1]/body[1]/div[26]/div[1]/div[1]/a[1]"));
		return Secreterial;
	}
	public static WebElement clickLogDeleteNoBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//button[@id='btnCloseDeleteAgendaItem']"));
		return Secreterial;
	}
	public static WebElement clickAddBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@title='Add Agenda']"));
		return Secreterial;
	}
	public static WebElement clickCloseBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html[1]/body[1]/div[12]/div[1]/div[1]/a[1]"));
		return Secreterial;
	}
	public static WebElement clickMyCompliance(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='myWorkspacemenu']/ul/li[5]/a/span"));
		return Secreterial;
	}
	public static WebElement clickMyComplianceEdit(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@class='k-grid-edit k-grid-button']"));
		return Secreterial;
	}
	public static WebElement clickCloseIcon9(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html[1]/body[1]/div[16]/div[1]/div[1]/a[1]"));
		return Secreterial;
	}
	
	public static WebElement clickMyTask(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='myWorkspacemenu']/ul/li[6]/a/span"));
		return Secreterial;
	}
	public static WebElement clickNewTask(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//button[@id='customCommand']"));
		return Secreterial;
	}
	public static WebElement clickType(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[2]"));
		return Secreterial;
	}
	public static WebElement clickEntity(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[3]"));
		return Secreterial;
	}
	public static WebElement ClickTaskTitle(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//input[@id='TaskTitle']"));
		return Secreterial;
	}
	public static WebElement ClickTaskDescription(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='Description']"));
		return Secreterial;
	}
	public static WebElement ClickCalender(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//span[@class='k-icon k-i-calendar']"));
		return Secreterial;
	}
	public static WebElement SelectDate(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.linkText("31"));
		return Secreterial;
	}
	public static WebElement Save(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//button[@id='btnsave']"));
		return Secreterial;
	}
	public static WebElement ValidMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='DivTask']/div/div/div[1]/div/div/lable"));
		return Secreterial;
	}
	public static WebElement CloseBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//button[@id='btnholidayclose']"));
		return Secreterial;
	}
	public static WebElement Close(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("/html/body/div[11]/div[1]/div/a"));
		return Secreterial;
	}
	public static WebElement EditBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//a[@class='k-grid-Edit k-grid-edit k-grid-button']"));
		return Secreterial;
	}
	public static WebElement closeBtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("(//a[@class='k-button k-bare k-button-icon k-window-action'])[2]"));
		return Secreterial;
	}
	public static WebElement TaskDetailesTab(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='panelbarEditDirector']/li[1]/span[1]"));
		return Secreterial;
	}
	public static WebElement Status(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='panelbarEditDirector']/li[2]/div/div[1]/div/div/div[2]/label[1]"));
		return Secreterial;
	}
	public static WebElement Remark(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//input[@id='txtRemark']"));
		return Secreterial;
	}
	public static WebElement File(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='files1']"));
		return Secreterial;
	}
	public static WebElement Savebtn(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//button[@id='btnsave1']"));
		return Secreterial;
	}
	public static WebElement validMsg(WebDriver driver)
	{
		
		Secreterial =driver.findElement(By.xpath("//*[@id='panelbarEditDirector']/li[2]/div/div[2]/div/div/lable"));
		return Secreterial;
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
