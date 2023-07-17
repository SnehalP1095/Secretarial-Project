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
	 static void selectOptionFromDropDown_bs(List<WebElement> options, String value) {
			
			for(WebElement option:options) {
				if(option.getText().equals(value)) {
					option.click();
					break;
				}
			}
		 }



}
