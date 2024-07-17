package sales.qa.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sales.qa.base.TestBase;

public class GeneralLedgerPage extends TestBase 
{
	//Page Factory
	@FindBy (xpath = "//b[normalize-space()='Transactions']")
	WebElement TransactionGeneralLedger;
			
	@FindBy (xpath = "//b[normalize-space()='Inquiries and Reports']")
	WebElement InquiriesGeneralLedger;
			
	@FindBy(xpath="//b[normalize-space()='Maintenance']")
	WebElement MaintenanceGeneralLedger;
			
	@FindBy(xpath = "//b[normalize-space()='Standard Reports and Forms']")
	WebElement StdRptsGeneralLedger;
			
	@FindBy (xpath="//b[normalize-space()='Custom Reports']")
	WebElement CustomRptsGeneralLedger;
	
	@FindBy (xpath = "//a[normalize-space()='Asset Manager']")
	WebElement AssetMngr;
			
	List<WebElement> TransacListGeneralLedger = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[1]/ul[1]/li"));
		
	List<WebElement> InquiriesListGeneralLedger = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[2]/ul[1]/li"));
			
	List<WebElement> MaintListGeneralLedger = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[3]/ul[1]/li"));
			
	//Initializing all web elements
	public GeneralLedgerPage()
	{
		PageFactory.initElements(driver, this);
	}
			
	//Actions
	//Page title
	public String GeneralLedgervalidateTitle()
	{
		return driver.getTitle();
	}
		
	//Transaction and Transaction List
	public boolean GeneralLedgerTransactiontitle()
	{
		return TransactionGeneralLedger.isDisplayed();
	}
		
	public void GeneralLedgerVerifyTransactionelements()
	{
		List <String> List = Arrays.asList("Bank Account Payments Entry","Bank Account Receipts Entry","Import Bank Transactions","Bank Account Payments Matching"
				,"Bank Account Receipts Matching","Journal Entry");
				
		if (TransacListGeneralLedger.size()!= 0)
		{
			for (WebElement element : TransacListGeneralLedger) 
			{
				for(int i=0;i<TransacListGeneralLedger.size();i++)
				{
					String TransacList = element.getText().replace("•", "");
					System.out.println("GeneralLedger Transaction List :" +TransacList.trim());
					Assert.assertEquals(TransacList.trim(), List.get(i).trim(),"GeneralLedger Transaction List not matched");
					System.out.println("Assertion GeneralLedger list");
				}
			}
		}
		
	}
		
	//Inquiries Reports and List
	public boolean GeneralLedgerInquiries() 
	{
		return InquiriesGeneralLedger.isDisplayed();
		
	}
			
	public void GeneralLedgerVerifyInquiriesList()
	{
		List<String> ActualList = Arrays.asList("Bank Account Balances","Bank Account Reconciliation Statement","Check Payments Listing","Daily Bank Transactions",
				"Account Inquiry","Graph of Account Transactions","Account Listing","Account Listing to CSV File","General Ledger Journal Inquiry",
				"Trial Balance","Balance Sheet","Profit and Loss Statement","Statement of Cash Flows","Financial Statements",
				"Horizontal Analysis of Statement of Financial Position","Horizontal Analysis of Statement of Comprehensive Income","Tag Reports","Tax Reports");
															
		if(InquiriesListGeneralLedger.size()!=0)
		{
			for (WebElement element : InquiriesListGeneralLedger) 
			{
				for(int i=0; i<InquiriesListGeneralLedger.size();i++)
				{
					if( element.getText().trim().contains(ActualList.get(i)))
					{
						String GeneralLedgerInquiriesList = element.getText().replace("•","");
						System.out.println("GeneralLedger Inquiries List" +GeneralLedgerInquiriesList.trim());
						Assert.assertEquals(GeneralLedgerInquiriesList.trim(), ActualList.get(i).trim(),"GeneralLedger Inquiry List not matched");
						System.out.println("Assertion Inquiries List GeneralLedger");
					}
				}
			}
		}
	}
			
	public boolean GeneralLedgerStandardRepotsTitle()
	{
		return StdRptsGeneralLedger.isDisplayed();
	}
	
	public boolean GeneralLedgerCustomreportsTitle()
	{
		return CustomRptsGeneralLedger.isDisplayed();
		
	}
			
	//Maintenance Title and List
	public boolean GeneralLedgerMaintenanceTitle()
	{
		return MaintenanceGeneralLedger.isDisplayed();
	}
			
	public void GeneralLedgerMaintenanceList()
	{
		List<String> MaintList = Arrays.asList("Account Sections","Account Groups","GL Accounts","GL Account Authorized Users","User Authorized GL Accounts",
												"GL Budgets","GL Tags"," Bank Accounts","Bank Account Authorized Users","User Authorized Bank Accounts",
												"Maintain Journal Templates");
		
		if(MaintListGeneralLedger.size()!=0)
		{
			for (WebElement element : MaintListGeneralLedger) 
			{
				for(int i=0;i<MaintListGeneralLedger.size();i++)
				{
					if( element.getText().trim().contains(MaintList.get(i)))
					{
						String MaintListGeneralLedgerList = element.getText().replace("•", "");
						System.out.println("GeneralLedger Inquiries List" +MaintListGeneralLedgerList.trim());
						Assert.assertEquals(MaintListGeneralLedgerList.trim(),MaintList.get(i).trim(),"GeneralLedger Maintenance List not matched");
						System.out.println("Assertion GeneralLedger Maintenance List");
					}
				}
			}
		}
	}

	public AssetManagerPage ClickAssetManagr()
	{
		AssetMngr.click();
		return new AssetManagerPage();
		
	}
	

}
