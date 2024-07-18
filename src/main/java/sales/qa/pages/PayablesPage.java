package sales.qa.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sales.qa.base.TestBase;

public class PayablesPage extends TestBase  
{
	//Page Factory
	@FindBy (xpath = "//b[normalize-space()='Transactions']")
	WebElement TransactionPayables;
			
	@FindBy (xpath = "//b[normalize-space()='Inquiries and Reports']")
	WebElement InquiriesPayables;
			
	@FindBy(xpath="//b[normalize-space()='Maintenance']")
	WebElement MaintenancePayables;
			
	@FindBy(xpath = "//b[normalize-space()='Standard Reports and Forms']")
	WebElement StdRptsPayables;
			
	@FindBy (xpath="//b[normalize-space()='Custom Reports']")
	WebElement CustomRptsPayables;
	
	@FindBy(xpath = "//a[normalize-space()='Inventory']")
	WebElement Inventory;
			
	List<WebElement> TransacListPayables = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[1]/ul[1]/li"));
		
	List<WebElement> InquiriesListPayables = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[2]/ul[1]/li"));
			
	List<WebElement> MaintListPayables = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[3]/ul[1]/li"));
			
	//Initializing all web elements
	public PayablesPage()
	{
		PageFactory.initElements(driver, this);
	}
			
	//Actions
	//Page title
	public String PayablesvalidateTitle()
	{
		return driver.getTitle();
	}
		
	//Transaction and Transaction List
	public boolean PayablesTransactiontitle()
	{
		return TransactionPayables.isDisplayed();
	}
		
	public void PayablesVerifyTransactionelements()
	{
		List <String> List = Arrays.asList("Select Vendor","Vendor Allocations");
				
		if (TransacListPayables.size()!= 0)
		{
			for (WebElement element : TransacListPayables) 
			{
				for(int i=0;i<TransacListPayables.size();i++)
				{
					if( element.getText().trim().contains(List.get(i)))
					{
						String TransacList = element.getText().replace("•", "");
						System.out.println("Payables Transaction List :" +TransacList.trim());
						Assert.assertEquals(TransacList.trim(), List.get(i).trim(),"Payables Transaction List not matched");
						System.out.println("Assertion Payables list");
					}
				}
			}
		}
		
	}
		
	//Inquiries Reports and List
	public boolean PayablesInquiries() 
	{
		return InquiriesPayables.isDisplayed();
		
	}
			
	public void PayablesVerifyInquiriesList()
	{
		List<String> ActualList = Arrays.asList("Where Allocated Inquiry","Aged Vendor Report","Payment Run Report","Remittance Advices","Outstanding GRNs Report",
												"Vendor Balances At A Prior Month End"," List Daily Transactions","Vendor Transaction Inquiries","Standard Reports and Forms",
												"There are no reports to show!","Custom Reports","There are no reports to show!");
															
		if(InquiriesListPayables.size()!=0)
		{
			for (WebElement element : InquiriesListPayables) 
			{
				for(int i=0; i<InquiriesListPayables.size();i++)
				{
					if( element.getText().trim().contains(ActualList.get(i)))
					{
						String PayablesInquiriesList = element.getText().replace("•","");
						System.out.println("Payables Inquiries List" +PayablesInquiriesList.trim());
						Assert.assertEquals(PayablesInquiriesList.trim(), ActualList.get(i).trim(),"Payables Inquiry List not matched");
						System.out.println("Assertion Inquiries List Payables");
					}
				}
			}
		}
	}
			
	public boolean PayablesStandardRepotsTitle()
	{
		return StdRptsPayables.isDisplayed();
	}
	
	public boolean PayablesCustomreportsTitle()
	{
		return CustomRptsPayables.isDisplayed();
		
	}
			
	//Maintenance Title and List
	public boolean PayablesMaintenanceTitle()
	{
		return MaintenancePayables.isDisplayed();
	}
			
	public void PayablesMaintenanceList()
	{
		List<String> MaintList = Arrays.asList("Add Vendor","Select Vendor","Maintain Factor Companies");
		
		if(MaintListPayables.size()!=0)
		{
			for (WebElement element : MaintListPayables) 
			{
				for(int i=0;i<MaintListPayables.size();i++)
				{
					if( element.getText().trim().contains(MaintList.get(i)))
					{
						String MaintListPayablesList = element.getText().replace("•", "");
						System.out.println("Payables Inquiries List" +MaintListPayablesList.trim());
						Assert.assertEquals(MaintListPayablesList.trim(),MaintList.get(i).trim(),"Payables Maintenance List not matched");
						System.out.println("Assertion Payables Maintenance List");
					}
				}
			}
		}
	}
	
	public InventoryPage ClickInventory()
	{
		Inventory.click();
		return new InventoryPage();
		
	}


}
