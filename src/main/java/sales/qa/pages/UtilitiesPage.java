package sales.qa.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sales.qa.base.TestBase;

public class UtilitiesPage extends TestBase 
{
	//Page Factory
	@FindBy (xpath = "//b[normalize-space()='Transactions']")
	WebElement TransactionUtilities;
			
	@FindBy (xpath = "//b[normalize-space()='Inquiries and Reports']")
	WebElement InquiriesUtilities;
			
	@FindBy(xpath="//b[normalize-space()='Maintenance']")
	WebElement MaintenanceUtilities;
			
	@FindBy(xpath = "//b[normalize-space()='Standard Reports and Forms']")
	WebElement StdRptsUtilities;
			
	@FindBy (xpath="//b[normalize-space()='Custom Reports']")
	WebElement CustomRptsUtilities;
			
	List<WebElement> TransacListUtilities = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[1]/ul[1]/li"));
		
	List<WebElement> InquiriesListUtilities = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[2]/ul[1]/li"));
			
	List<WebElement> MaintListUtilities = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[3]/ul[1]/li"));
			
	//Initializing all web elements
	public UtilitiesPage()
	{
		PageFactory.initElements(driver, this);
	}
			
	//Actions
	//Page title
	public String UtilitiesvalidateTitle()
	{
		return driver.getTitle();
	}
		
	//Transaction and Transaction List
	public boolean UtilitiesTransactiontitle()
	{
		return TransactionUtilities.isDisplayed();
	}
		
	public void UtilitiesVerifyTransactionelements()
	{
		List <String> List = Arrays.asList(" Change A Customer Code"," Change A Customer Branch Code","Change A GL Account Code","Change An Inventory Item Code",
				"Change A Location Code"," Change A Salesman Code","Change A Stock Category Code","Change A Supplier Code","Translate Item Descriptions",
				"Update costs for all BOM items, from the bottom up","Re-apply costs to Sales Analysis","Delete sales transactions","Reverse all supplier payments on a specified date"
				," Update sales analysis with latest customer data"," Copy Authority of GL Accounts from one user to another");
				
		if (TransacListUtilities.size()!= 0)
		{
			for (WebElement element : TransacListUtilities) 
			{
				for(int i=0;i<TransacListUtilities.size();i++)
				{
					if( element.getText().trim().contains(List.get(i)))
					{
						String TransacList = element.getText().replace("•", "");
						System.out.println("Utilities Transaction List :" +TransacList.trim());
						Assert.assertEquals(TransacList.trim(), List.get(i).trim(),"Utilities Transaction List not matched");
						System.out.println("Assertion Utilities list");
					}
				}
			}
		}
		
	}
		
	//Inquiries Reports and List
	public boolean UtilitiesInquiries() 
	{
		return InquiriesUtilities.isDisplayed();
		
	}
			
	public void UtilitiesVerifyInquiriesList()
	{
		List<String> ActualList = Arrays.asList("Debtors Balances By Currency Totals","Suppliers Balances By Currency Totals","Show General Transactions That Do Not Balance",
									"List of items without picture");
															
		if(InquiriesListUtilities.size()!=0)
		{
			for (WebElement element : InquiriesListUtilities) 
			{
				for(int i=0; i<InquiriesListUtilities.size();i++)
				{
					if( element.getText().trim().contains(ActualList.get(i)))
					{
						String UtilitiesInquiriesList = element.getText().replace("•","");
						System.out.println("Utilities Inquiries List" +UtilitiesInquiriesList.trim());
						Assert.assertEquals(UtilitiesInquiriesList.trim(), ActualList.get(i).trim(),"Utilities Inquiry List not matched");
						System.out.println("Assertion Inquiries List Utilities");
					}
				}
			}
		}
	}
			
	public boolean UtilitiesStandardRepotsTitle()
	{
		return StdRptsUtilities.isDisplayed();
	}
	
	public boolean UtilitiesCustomreportsTitle()
	{
		return CustomRptsUtilities.isDisplayed();
		
	}
			
	//Maintenance Title and List
	public boolean UtilitiesMaintenanceTitle()
	{
		return MaintenanceUtilities.isDisplayed();
	}
			
	public void UtilitiesMaintenanceList()
	{
		List<String> MaintList = Arrays.asList("Maintain Language Files","Make New Company","Data Export Options","Import Customers from .csv file","Import Stock Items from .csv file",
												"Import Price List from .csv file"," Import Fixed Assets from .csv file","Import GL Payments Receipts Or Journals From .csv file",
												"Create new company template SQL file and submit to webERP","Re-calculate brought forward amounts in GL","Re-Post all GL transactions from a specified period",
												"Purge all old prices","Remove all purchase back orders");
		
		if(MaintListUtilities.size()!=0)
		{
			for (WebElement element : MaintListUtilities) 
			{
				for(int i=0;i<MaintListUtilities.size();i++)
				{
					if( element.getText().trim().contains(MaintList.get(i)))
					{
						String MaintListUtilitiesList = element.getText().replace("•", "");
						System.out.println("Utilities Inquiries List" +MaintListUtilitiesList.trim());
						Assert.assertEquals(MaintListUtilitiesList.trim(),MaintList.get(i).trim(),"Utilities Maintenance List not matched");
						System.out.println("Assertion Utilities Maintenance List");
					}
				}
			}
		}
	}


}
