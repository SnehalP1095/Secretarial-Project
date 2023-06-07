package CompnaySecretory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;





public class CommitteeMethod {
	

	private static List<WebElement> elementsList = null;

	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static XSSFSheet sheet1 = null;		//Sheet variable


	
	public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Snehal\\ComplianceLatest\\Secreterial\\TestData\\SecreterialSheet3.xlsx");
		
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	
	public static void Committee(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
	
		sheet = workbook.getSheetAt(0);	
		Thread.sleep(2000);
	    Locator.selectImg(driver).click();
	    
	    Thread.sleep(2000);
		 Locator.ClickMaster(driver).click();
	    
		Thread.sleep(2000);
	    Locator.CommitteeMaster(driver).click();
	    Thread.sleep(2000);
	    Locator.NewCommittee(driver).click();
	    
	    Thread.sleep(2000);
	    Locator.CommitteeName(driver).clear();
	    
	    XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(6);						//Selected 1st index row (Second row)
		Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String CommitteeName = c2.getStringCellValue();			//Got the URL stored at position 1,1
	   Locator.CommitteeName(driver).sendKeys(CommitteeName);
	   
	 
	  
		/*Row row2 = sheet.getRow(7);						//Selected 1st index row (Second row)
		Cell c3 = row2.getCell(1);						//Selected cell (1 row,1 column)
		String Description = c3.getStringCellValue();			//Got the URL stored at position 1,1
	   Locator.Description(driver).sendKeys(Description);*/
	   
	   Thread.sleep(2000);
	   Locator.SaveBtn(driver).click();
	   

		 Thread.sleep(3000);
		 String msg1 = Locator.ValidationMsg(driver).getText();
			if(msg1.contains("Saved Successfully."))
			{
				test.log(LogStatus.PASS, "Message Dispalyed =" +msg1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message Dispalyed =" +msg1);
			}
			Locator.CloseBtn(driver).click();
			
		     Thread.sleep(4000);
			  EntityLocator.ClickDashboard(driver).click();
	}
	public static void AcceptAlphaCharactersCommittee(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(2000);
	    Locator.selectImg(driver).click();
	    
	    Thread.sleep(2000);
		 Locator.ClickMaster(driver).click();
	    
		Thread.sleep(2000);
	    Locator.CommitteeMaster(driver).click();
			 Thread.sleep(2000);
			    Locator.NewCommittee(driver).click();
			    
			    Thread.sleep(2000);
			    Locator.CommitteeName(driver).sendKeys("ABCDE");
			    
			    Thread.sleep(2000);
				 Locator.SaveBtn(driver).click();
				   Thread.sleep(3000);
					 String MSG1 = Locator.ValidationMsg(driver).getText();
						if(MSG1.contains("Saved Successfully."))
						{
							test.log(LogStatus.PASS, "Accept Alpha Characters =" +MSG1);
						}
						else
						{
							test.log(LogStatus.FAIL, "Accept Alpha Characters =" +MSG1);
						}
						Locator.CloseBtn(driver).click();
						Thread.sleep(4000);
						  EntityLocator.ClickDashboard(driver).click();
	}
						
	public static void CloseBtnCommittee(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		
	        	Thread.sleep(2000);
	             Locator.selectImg(driver).click();
	    
	            Thread.sleep(2000);
		        Locator.ClickMaster(driver).click();
	    
		         Thread.sleep(2000);
	             Locator.CommitteeMaster(driver).click();
						 Thread.sleep(2000);
						    Locator.NewCommittee(driver).click();
						    
						
						Thread.sleep(4000);
						WebElement text=driver.findElement(By.xpath("//*[@id='btnclose1']"));
						 
						 
						 if(text.isEnabled())
							{
							     Locator.CloseBtn(driver).click();
								
								test.log(LogStatus.PASS, "Close button is clickable");
								
							}
						 Thread.sleep(4000);
						  EntityLocator.ClickDashboard(driver).click();
	}
						
						/*Thread.sleep(2000);
						    Locator.NewCommittee(driver).click();
						    
						    Thread.sleep(2000);
						    Locator.CommitteeName(driver).sendKeys("ABCDEF");
						
						  Locator.Description(driver).sendKeys("test567$");
						  Thread.sleep(2000);
							 Locator.SaveBtn(driver).click();
							   Thread.sleep(3000);
								 String MSG2 = Locator.ValidationMsg(driver).getText();
									if(MSG2.contains("Saved Successfully."))
									{
										test.log(LogStatus.PASS, "Message Dispalyed = Accept  Alpha numeric and special characters of description " +MSG2);
									}
									else
									{
										test.log(LogStatus.FAIL, "Message Dispalyed =Accept Alpha numeric and special characters description " +MSG2);
									}
									Locator.CloseBtn(driver).click();*/
	
	public static void WithoutEnteringDataCommittee(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		
		
		             Thread.sleep(2000);
	                  Locator.selectImg(driver).click();
	    
	                  Thread.sleep(2000);
		               Locator.ClickMaster(driver).click();
	    
		                Thread.sleep(2000);
	                    Locator.CommitteeMaster(driver).click();
						 Thread.sleep(2000);
						    Locator.NewCommittee(driver).click();		
						    Thread.sleep(2000);
							 Locator.SaveBtn(driver).click();
							 
							 Thread.sleep(3000);
							 String MSG3 = Locator.ValidationMsg1(driver).getText();
								if(MSG3.contains("Please enter name"))
								{
									test.log(LogStatus.PASS, "Without Entering Data = " +MSG3);
								}
								else
								{
									test.log(LogStatus.FAIL, "Without Entering Data = " +MSG3);
								}
								Thread.sleep(4000);
								Locator.CloseBtn(driver).click();
								Thread.sleep(4000);
								  EntityLocator.ClickDashboard(driver).click();
	}
	
								
		public static void EnterInvalidDataCommittee(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
		 {		
									
								Thread.sleep(2000);
								 Locator.selectImg(driver).click();
								  
								    Thread.sleep(2000);
					               Locator.ClickMaster(driver).click();
								    
									 Thread.sleep(2000);
								           Locator.CommitteeMaster(driver).click();
			
								 Thread.sleep(2000);
								    Locator.NewCommittee(driver).click();
								    
								    Thread.sleep(2000);
								    Locator.CommitteeName(driver).sendKeys("bdgfh#234");
								    
								    Thread.sleep(2000);
									 Locator.SaveBtn(driver).click();
								   
								    Thread.sleep(3000);
									 String MSG4 = Locator.ValidationMsg2(driver).getText();
										if(MSG4.contains("Please Enter valid name"))
										{
											test.log(LogStatus.PASS, "Committee Name is Wrong = " +MSG4);
										}
										else
										{
											test.log(LogStatus.FAIL, "Committee Name is Wrong = " +MSG4);
										}
										 Locator.CloseBtn(driver).click();
										 Thread.sleep(4000);
										  EntityLocator.ClickDashboard(driver).click();
	}
								
	public static void UpdateCommittee(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{	
		
        Thread.sleep(2000);
        Locator.selectImg(driver).click();

        Thread.sleep(2000);
         Locator.ClickMaster(driver).click();

          Thread.sleep(2000);
          Locator.CommitteeMaster(driver).click();
			Thread.sleep(2000);
			Locator.EditIcon(driver).click();
			
			Locator.CommitteeName(driver).clear();
			
			Thread.sleep(2000);
			Row row2 = sheet.getRow(7);						//Selected 1st index row (Second row)
			Cell c3 = row2.getCell(1);						//Selected cell (1 row,1 column)
			String CommitteeName1 = c3.getStringCellValue();			
			Locator.CommitteeName(driver).sendKeys(CommitteeName1);
			
			  Thread.sleep(2000);
			   Locator.SaveBtn(driver).click();
			   

				 Thread.sleep(3000);
				 String msg2 = Locator.ValidationMsg(driver).getText();
					if(msg2.contains("Updated Successfully."))
					{
						test.log(LogStatus.PASS, "Message Dispalyed = " +msg2);
					}
					else
					{
						test.log(LogStatus.FAIL, "Message Dispalyed = " +msg2);
					}
					Locator.CloseBtn(driver).click();
					
					 Thread.sleep(4000);
					  EntityLocator.ClickDashboard(driver).click();
	}
	public static void AddCommitteeMemberRule(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{			
        Thread.sleep(2000);
        Locator.selectImg(driver).click();

        Thread.sleep(2000);
         Locator.ClickMaster(driver).click();

          Thread.sleep(2000);
          Locator.CommitteeMaster(driver).click();
					Thread.sleep(2000);
					Locator.ClickRule(driver).click();
					Thread.sleep(2000);
					Locator.ClickComapnayName(driver).click();
					Thread.sleep(2000);
					Locator.SelectComapnayName(driver).click();
					Thread.sleep(2000);
					Locator.ClickDesignation(driver).click();
					Thread.sleep(2000);
					Locator.SelectDesignation(driver).click();
					Thread.sleep(2000);
					Locator.TotalStrength(driver).sendKeys("2");
					Thread.sleep(2000);
					Locator.TotalStrengthNo(driver).sendKeys("1");
					Thread.sleep(2000);
					Locator.TotalStrengthDenomirator(driver).sendKeys("2");
					Thread.sleep(2000);
					Locator.ClickAdd(driver).click();
					
					 Thread.sleep(3000);
					 String msg3 = Locator.RuleValidationMsg(driver).getText();
						if(msg3.contains("Saved Successfully."))
						{
							test.log(LogStatus.PASS, "Message Dispalyed =Member " +msg3);
						}
						else
						{
							test.log(LogStatus.FAIL, "Message Dispalyed = Member " +msg3);
						}
						
						Thread.sleep(2000);
						Locator.ClickClose(driver).click();
						 Thread.sleep(4000);
						  EntityLocator.ClickDashboard(driver).click();
	}
	public static void UpdateCommitteeMemberRule(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
        Thread.sleep(2000);
        Locator.selectImg(driver).click();

        Thread.sleep(2000);
         Locator.ClickMaster(driver).click();

          Thread.sleep(2000);
          Locator.CommitteeMaster(driver).click();
					Thread.sleep(2000);
					Locator.ClickRule(driver).click();
					Thread.sleep(2000);
					Locator.ClickComapnayName(driver).click();
					Thread.sleep(2000);
					Locator.SelectComapnayName(driver).click();
						Thread.sleep(2000);
						Locator.clickEditMemberRule(driver).click();
						Thread.sleep(2000);
						Locator.TotalStrength(driver).clear();
						Thread.sleep(2000);
						Locator.TotalStrength(driver).sendKeys("3");
						Thread.sleep(2000);
						Locator.TotalStrengthNo(driver).sendKeys("1");
						Thread.sleep(2000);
						Locator.TotalStrengthDenomirator(driver).clear();
						Thread.sleep(2000);
						Locator.TotalStrengthDenomirator(driver).sendKeys("3");
						Thread.sleep(2000);
						Locator.ClickAdd(driver).click();
						
						 Thread.sleep(3000);
						 String msg7 = Locator.clickValidationMemberRule(driver).getText();
							if(msg7.contains("Updated Successfully."))
							{
								test.log(LogStatus.PASS, "Message Dispalyed =Member " +msg7);
							}
							else
							{
								test.log(LogStatus.FAIL, "Message Dispalyed =Member " +msg7);
							}
							
							Thread.sleep(2000);
							Locator.clickDeleteMemberRule(driver).click();
							
							Thread.sleep(2000);
							Locator.ClickClose(driver).click();
							 Thread.sleep(4000);
							  EntityLocator.ClickDashboard(driver).click();
	}

					
			public static void AddCommitteeQuoramRule(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
			{				
		        Thread.sleep(2000);
		        Locator.selectImg(driver).click();

		        Thread.sleep(2000);
		         Locator.ClickMaster(driver).click();

		          Thread.sleep(2000);
		          Locator.CommitteeMaster(driver).click();
							Thread.sleep(2000);
							Locator.ClickRule(driver).click();
							Thread.sleep(2000);
							Locator.ClickComapnayName(driver).click();
							Thread.sleep(2000);
							Locator.SelectComapnayName(driver).click();
						Thread.sleep(2000);
						Locator.RuleQuoram(driver).click();
						Thread.sleep(2000);
						Locator.QuoramDesignation(driver).click();
						Thread.sleep(2000);
						Locator.SelectQuoramDesignation(driver).click();
						Thread.sleep(2000);
						Locator.TotalStrength1(driver).sendKeys("3");
						Thread.sleep(2000);
						Locator.TotalStrengthNo1(driver).sendKeys("1");
						Thread.sleep(2000);
						Locator.TotalStrengthDenomirator1(driver).sendKeys("2");
						Thread.sleep(2000);
						Locator.ClickAdd1(driver).click();
						
						 Thread.sleep(3000);
						 String msg4 = Locator.ValidationQuram(driver).getText();
							if(msg4.contains("Saved Successfully."))
							{
								test.log(LogStatus.PASS, "Message Dispalyed =Quoram " +msg4);
							}
							else
							{
								test.log(LogStatus.FAIL, "Message Dispalyed =Quoram " +msg4);
							}
							
							Thread.sleep(2000);
							Locator.ClickClose(driver).click();
							 Thread.sleep(4000);
							  EntityLocator.ClickDashboard(driver).click();
			}
							
			public static void UpdateCommitteeQuoramRule(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
			{	
				
		        Thread.sleep(2000);
		        Locator.selectImg(driver).click();

		        Thread.sleep(2000);
		         Locator.ClickMaster(driver).click();

		          Thread.sleep(2000);
		          Locator.CommitteeMaster(driver).click();
							Thread.sleep(2000);
							Locator.ClickRule(driver).click();
							Thread.sleep(2000);
							Locator.ClickComapnayName(driver).click();
							Thread.sleep(2000);
							Locator.SelectComapnayName(driver).click();
							Thread.sleep(2000);
							Locator.RuleQuoram(driver).click();
							Thread.sleep(2000);
							Locator.clickeditQuramRule(driver).click();
							
							Thread.sleep(2000);
							Locator.TotalStrength1(driver).clear();
							Thread.sleep(2000);
							Locator.TotalStrength1(driver).sendKeys("3");
							Thread.sleep(2000);
							Locator.TotalStrengthNo1(driver).sendKeys("1");
							Thread.sleep(2000);
							Locator.TotalStrengthDenomirator1(driver).sendKeys("2");
							Thread.sleep(2000);
							Locator.ClickAdd1(driver).click();
							
							
							 Thread.sleep(3000);
							 String msg8 = Locator.clickValidationQuramRule(driver).getText();
								if(msg8.contains("Updated Successfully."))
								{
									test.log(LogStatus.PASS, "Message Dispalyed = Quoram " +msg8);
								}
								else
								{
									test.log(LogStatus.FAIL, "Message Dispalyed =Quoram " +msg8);
								}
								
								Thread.sleep(2000);
								Locator.clickDeleteQuramRule(driver).click();
								
								Thread.sleep(2000);
								Locator.ClickClose(driver).click();
								 Thread.sleep(4000);
								  EntityLocator.ClickDashboard(driver).click();
			}
			
							
			public static void AddCommitteeMeetingRule(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
			{		
				
		        Thread.sleep(2000);
		        Locator.selectImg(driver).click();

		        Thread.sleep(2000);
		         Locator.ClickMaster(driver).click();

		          Thread.sleep(2000);
		          Locator.CommitteeMaster(driver).click();
							Thread.sleep(2000);
							Locator.ClickRule(driver).click();
							Thread.sleep(2000);
							Locator.ClickComapnayName(driver).click();
							Thread.sleep(2000);
							Locator.SelectComapnayName(driver).click();
						
						Thread.sleep(2000);
						Locator.clickMeeting(driver).click();
						Thread.sleep(2000);
						Locator.clickMeeting1(driver).clear();
						Thread.sleep(2000);
						Locator.clickMeeting1(driver).sendKeys("4");
						Thread.sleep(2000);
						Locator.clickGapMeeting(driver).sendKeys("90");
						Thread.sleep(2000);
						Locator.SaveMeeting(driver).click();
						
						 Thread.sleep(3000);
						 String msg5 = Locator.ValidationMeeting(driver).getText();
							if(msg5.contains("Meeting Save Successfully."))
							{
								test.log(LogStatus.PASS, "Message Dispalyed = Meeting " +msg5);
							}
							else
							{
								test.log(LogStatus.FAIL, "Message Dispalyed = Meeting " +msg5);
							}
						Thread.sleep(2000);
						Locator.ClickClose(driver).click();
						Thread.sleep(4000);
						  EntityLocator.ClickDashboard(driver).click();
			}
			
      public static void UploadCommitteDocument(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
       {	
    	  
			
	        Thread.sleep(2000);
	        Locator.selectImg(driver).click();

	        Thread.sleep(2000);
	         Locator.ClickMaster(driver).click();

	          Thread.sleep(2000);
	          Locator.CommitteeMaster(driver).click();
						
						Thread.sleep(2000);
						Locator.UploadDocument(driver).click();
						
						Thread.sleep(2000);
						Locator.SelectFiles(driver).sendKeys("C:\\Users\\Admin\\Documents\\file-sample_500kB.docx");
						
						Thread.sleep(2000);
						Locator.ClickUploadBtn(driver).click();
						

						 Thread.sleep(3000);
						 String msg6 = Locator.UploadFileValidation(driver).getText();
							if(msg6.contains("File Upload successfully"))
							{
								test.log(LogStatus.PASS, "Message Dispalyed =" +msg6);
							}
							else
							{
								test.log(LogStatus.FAIL, "Message Dispalyed =" +msg6);
							}
							
							Thread.sleep(2000);
							Locator.CloseBtn1(driver).click();
							
							Thread.sleep(4000);
							  EntityLocator.ClickDashboard(driver).click();
       }
							
      public static void DeleteCommitteDocument(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
      {	
    	  
			
	        Thread.sleep(2000);
	        Locator.selectImg(driver).click();

	        Thread.sleep(2000);
	         Locator.ClickMaster(driver).click();

	          Thread.sleep(2000);
	          Locator.CommitteeMaster(driver).click();
							Thread.sleep(2000);
							Locator.ClickDeleteCommittee(driver).click();
							
							  Thread.sleep(5000);
							    // Switching to Alert        
						        Alert alert1 = driver.switchTo().alert();		
						        		
						        // Capturing alert message.    
						        String alertMessage1= driver.switchTo().alert().getText();	
						        
						        
						        test.log(LogStatus.PASS, alertMessage1);
						        		
						        // Displaying alert message		
						        System.out.println(alertMessage1);
						        
						     // Accepting alert		
						        alert1.accept();
						    	Thread.sleep(4000);
								  EntityLocator.ClickDashboard(driver).click();
      }
      public static void WithoutUploadCommitteDocument(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
      {					
    	  
			
	        Thread.sleep(2000);
	        Locator.selectImg(driver).click();

	        Thread.sleep(2000);
	         Locator.ClickMaster(driver).click();

	          Thread.sleep(2000);
	          Locator.CommitteeMaster(driver).click();
							Thread.sleep(2000);
							Locator.UploadDocument(driver).click();
											
							Thread.sleep(2000);
							Locator.SelectFiles(driver).sendKeys("C:\\Users\\Admin\\Documents\\Secreaterial test cases.xlsx");
											
							Thread.sleep(2000);
							Locator.ClickUploadBtn(driver).click();
											

						    Thread.sleep(3000);
						    String msg9 = Locator.UploadFileValidation1(driver).getText();
							if(msg9.contains("Please select file to upload"))
							{
								test.log(LogStatus.PASS, "Message Dispalyed =" +msg9);
							}
							else
							{
							 	test.log(LogStatus.FAIL, "Message Dispalyed =" +msg9);
							}
												
							Thread.sleep(2000);
							Locator.CloseBtn1(driver).click();
							Thread.sleep(4000);
							  EntityLocator.ClickDashboard(driver).click();
      }
      public static void AcceptTotalStrengthNumericFont(WebDriver driver, ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
      {				
			
          Thread.sleep(2000);
	        Locator.selectImg(driver).click();

	        Thread.sleep(2000);
	         Locator.ClickMaster(driver).click();

	          Thread.sleep(2000);
	          Locator.CommitteeMaster(driver).click();
						Thread.sleep(2000);
						Locator.ClickRule(driver).click();
						Thread.sleep(2000);
						Locator.ClickComapnayName(driver).click();
						Thread.sleep(2000);
						Locator.SelectComapnayName(driver).click();
							Thread.sleep(2000);
							Locator.TotalStrength(driver).sendKeys("2");
							Thread.sleep(2000);
							Locator.TotalStrengthNo(driver).sendKeys("1");
							Thread.sleep(2000);
							Locator.TotalStrengthDenomirator(driver).sendKeys("2");
							Thread.sleep(2000);
							Locator.ClickAdd(driver).click();
							
							 Thread.sleep(3000);
							 String MSG5 = Locator.RuleValidationMsg(driver).getText();
								if(MSG5.contains("Saved Successfully."))
								{
									test.log(LogStatus.PASS, "Accept Total Strength Numeric Font =" +MSG5);
								}
								else
								{
									test.log(LogStatus.FAIL, "Accept Total Strength Numeric Font =" +MSG5);
								}
								Thread.sleep(2000);
								Locator.ClickClose(driver).click();
								Thread.sleep(4000);
								  EntityLocator.ClickDashboard(driver).click();
					}
										 
	}


