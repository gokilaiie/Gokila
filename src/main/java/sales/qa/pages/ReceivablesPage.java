package sales.qa.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sales.qa.base.TestBase;

public class ReceivablesPage extends TestBase 
{
	//Page Factory
	@FindBy (xpath = "//b[normalize-space()='Transactions']")
	WebElement TransactionReceivables;
	
	@FindBy (xpath = "//b[normalize-space()='Inquiries and Reports']")
	WebElement InquiriesReceivables;
	
	@FindBy(xpath="//b[normalize-space()='Maintenance']")
	WebElement MaintenanceReceivables;
	
	@FindBy(xpath = "//b[normalize-space()='Standard Reports and Forms']")
	WebElement StdRptsReceivables;
	
	@FindBy (xpath="//b[normalize-space()='Custom Reports']")
	WebElement CustomRptsReceivables;
	
	@FindBy(xpath = "//a[normalize-space()='Purchases']")
	WebElement PurchasePage;
	
	List<WebElement> TransacListReceivables = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[1]/ul[1]/li"));
	
	List<WebElement> InquiriesListReceivables = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[2]/ul[1]/li"));
	
	List<WebElement> MaintListReceivables = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[3]/ul[1]/li"));
	
	//Initializing all web elements
	public ReceivablesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	//Page title
	public String ReceivablesvalidateTitle()
	{
		return driver.getTitle();
	}
	
	//Transaction and Transaction List
	public boolean ReceivablesTransactiontitle()
	{
		return TransactionReceivables.isDisplayed();
	}
	
	public void ReceivablesVerifyTransactionelements()
	{
		List <String> List = Arrays.asList("Select Order to Invoice","Create A Credit Note","Enter Customer Payments","Allocate Customer Payments or Credit Memos");
		
		if (TransacListReceivables.size()!= 0)
		{
			for (WebElement element : TransacListReceivables) 
			{
				for(int i=0;i<TransacListReceivables.size();i++)
				{
					if( element.getText().trim().contains(List.get(i)))
					{
						String TransacList = element.getText().replace("•", "");
						System.out.println("Receivables Transaction List :" +TransacList.trim());
						System.out.println("Assertion Transaction list");
						Assert.assertEquals(TransacList.trim(), List.get(i).trim(),"Receivables Transaction List not matched");
						
					}
				}
			}
		}
		
	}
	
	//Inquiries Reports and List
	public boolean ReceivablesInquiries() 
	{
		return InquiriesReceivables.isDisplayed();
		
	}
	
	public void ReceivablesVerifyInquiriesList()
	{
		List<String> InList = Arrays.asList("Where Allocated Inquiry","Print Invoices or Credit Notes","Print Statements","Aged Customer Balances/Overdues Report",
										"Re-Print A Deposit Listing","Debtor Balances At A Prior Month End",
										"Customer Listing By Area/Salesperson","List Daily Transactions","Customer Transaction Inquiries","Customer Activity and Balances",
										"Standard Reports and Forms","There are no reports to show!","Custom Reports","There are no reports to show!");
		
		if(InquiriesListReceivables.size()!=0)
		{
			for (WebElement element : InquiriesListReceivables) 
			 {
				for(int i=0;i<InquiriesListReceivables.size();i++)
				{
					if( element.getText().trim().contains(InList.get(i)))
					{
						String InquiriesList = element.getText().replace("•","");
						System.out.println("Receivables Inquiries List" +InquiriesList.trim());
						System.out.println("Assertion Inquiries List Receivable");
						Assert.assertEquals(InquiriesList.trim(),InList.get(i).trim(),"Receivable Inquiry List not matched");
						
					}
				  
				}
			 }
		}
	}
	
	public boolean ReceivablesStandardRepotsTitle()
	{
		return StdRptsReceivables.isDisplayed();
	}
	
	public boolean ReceivablesCustomreportsTitle()
	{
		return CustomRptsReceivables.isDisplayed();
		
	}
	
	//Maintenance Title and List
	public boolean ReceivablesMaintenanceTitle()
	{
		return MaintenanceReceivables.isDisplayed();
	}
	
	public void ReceivablesMaintenanceList()
	{
		List<String> MaintList = Arrays.asList("Add Customer","Select Customer");
		
		if(MaintListReceivables.size()!=0)
		{
			for (WebElement element : MaintListReceivables) 
			{
				for(int i=0;i<MaintListReceivables.size();i++)
				{
					if( element.getText().trim().contains(MaintList.get(i)))
					{
					
						String ActualList = element.getText().replace("•", "");
						System.out.println("Receivables Maintenace List" +ActualList.trim());
						System.out.println("Assertion Receivables Maintenance List");
						Assert.assertEquals(ActualList.trim(),MaintList.get(i).trim(),"Receivables Maintenace List not matched");
					}
						
				}
			}
		}
	}
	
	public PurchasesPage ClickPurchase()
	{
		PurchasePage.click();
		return new PurchasesPage();
		
	}
}
