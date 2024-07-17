package sales.qa.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sales.qa.base.TestBase;

public class ManufacturingPage extends TestBase  
{
	//Page Factory
	@FindBy (xpath = "//b[normalize-space()='Transactions']")
	WebElement TransactionManufacturing;
			
	@FindBy (xpath = "//b[normalize-space()='Inquiries and Reports']")
	WebElement InquiriesManufacturing;
			
	@FindBy(xpath="//b[normalize-space()='Maintenance']")
	WebElement MaintenanceManufacturing;
			
	@FindBy(xpath = "//b[normalize-space()='Standard Reports and Forms']")
	WebElement StdRptsManufacturing;
			
	@FindBy (xpath="//b[normalize-space()='Custom Reports']")
	WebElement CustomRptsManufacturing;
	
	@FindBy(xpath = "//a[normalize-space()='General Ledger']")
	WebElement GnrlLedger;
			
	List<WebElement> TransacListManufacturing = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[1]/ul[1]/li"));
		
	List<WebElement> InquiriesListManufacturing = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[2]/ul[1]/li"));
			
	List<WebElement> MaintListManufacturing = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[3]/ul[1]/li"));
			
	//Initializing all web elements
	public ManufacturingPage()
	{
		PageFactory.initElements(driver, this);
	}
			
	//Actions
	//Page title
	public String ManufacturingvalidateTitle()
	{
		return driver.getTitle();
	}
		
	//Transaction and Transaction List
	public boolean ManufacturingTransactiontitle()
	{
		return TransactionManufacturing.isDisplayed();
	}
		
	public void ManufacturingVerifyTransactionelements()
	{
		List <String> List = Arrays.asList("Work Order Entry","Select A Work Order","QA Samples and Test Results","Timesheet Entry");
				
		if (TransacListManufacturing.size()!= 0)
		{
			for (WebElement element : TransacListManufacturing) 
			{
				for(int i=0;i<TransacListManufacturing.size();i++)
				{
					if( element.getText().trim().contains(List.get(i)))
					{
						String TransacList = element.getText().replace("•", "");
						System.out.println("Manufacturing Transaction List :" +TransacList.trim());
						Assert.assertEquals(TransacList.trim(), List.get(i).trim(),"Manufacturing Transaction List not matched");
						System.out.println("Assertion Manufacturing list");
					}
				}
			}
		}
		
	}
		
	//Inquiries Reports and List
	public boolean ManufacturingInquiries() 
	{
		return InquiriesManufacturing.isDisplayed();
		
	}
			
	public void ManufacturingVerifyInquiriesList()
	{
		List<String> ActualList = Arrays.asList("Select A Work Order","Costed Bill Of Material Inquiry","Where Used Inquiry","Bill Of Material Listing",
				" Indented Bill Of Material Listing","List Components Required","List Materials Not Used Anywhere","Indented Where Used Listing",
				"WO Items ready to produce","MRP","MRP Shortages","MRP Suggested Purchase Orders","MRP Suggested Work Orders","MRP Reschedules Required",
				"Print Product Specification","Print Certificate of Analysis","Historical QA Test Results","Multiple Work Orders Total Cost Inquiry");
															
		if(InquiriesListManufacturing.size()!=0)
		{
			for (WebElement element : InquiriesListManufacturing) 
			{
				for(int i=0; i<InquiriesListManufacturing.size();i++)
				{
					if( element.getText().trim().contains(ActualList.get(i)))
					{
						String ManufacturingInquiriesList = element.getText().replace("•","");
						System.out.println("Manufacturing Inquiries List" +ManufacturingInquiriesList.trim());
						Assert.assertEquals(ManufacturingInquiriesList.trim(), ActualList.get(i).trim(),"Manufacturing Inquiry List not matched");
						System.out.println("Assertion Inquiries List Manufacturing");
					}
				}
			}
		}
	}
			
	public boolean ManufacturingStandardRepotsTitle()
	{
		return StdRptsManufacturing.isDisplayed();
	}
	
	public boolean ManufacturingCustomreportsTitle()
	{
		return CustomRptsManufacturing.isDisplayed();
		
	}
			
	//Maintenance Title and List
	public boolean ManufacturingMaintenanceTitle()
	{
		return MaintenanceManufacturing.isDisplayed();
	}
			
	public void ManufacturingMaintenanceList()
	{
		List<String> MaintList = Arrays.asList("Work Centre","Bills Of Material","Copy a Bill Of Materials Between Items","Master Schedule","Auto Create Master Schedule",
												"MRP Calculation","Quality Tests Maintenance","Product Specifications","Employees");
		
		if(MaintListManufacturing.size()!=0)
		{
			for (WebElement element : MaintListManufacturing) 
			{
				for(int i=0;i<MaintListManufacturing.size();i++)
				{
					if( element.getText().trim().contains(MaintList.get(i)))
					{
						String MaintListManufacturingList = element.getText().replace("•", "");
						System.out.println("Manufacturing Inquiries List" +MaintListManufacturingList.trim());
						Assert.assertEquals(MaintListManufacturingList.trim(),MaintList.get(i).trim(),"Manufacturing Maintenance List not matched");
						System.out.println("Assertion Manufacturing Maintenance List");
					}
				}
			}
		}
	}

	public GeneralLedgerPage ClickGnrlLedger()
	{
		GnrlLedger.click();
		return new GeneralLedgerPage();
		
	}

}
