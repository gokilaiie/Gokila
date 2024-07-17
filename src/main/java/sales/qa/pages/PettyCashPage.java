package sales.qa.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sales.qa.base.TestBase;

public class PettyCashPage extends TestBase  
{
	//Page Factory
	@FindBy (xpath = "//b[normalize-space()='Transactions']")
	WebElement TransactionPettyCash;
			
	@FindBy (xpath = "//b[normalize-space()='Inquiries and Reports']")
	WebElement InquiriesPettyCash;
			
	@FindBy(xpath="//b[normalize-space()='Maintenance']")
	WebElement MaintenancePettyCash;
			
	@FindBy(xpath = "//b[normalize-space()='Standard Reports and Forms']")
	WebElement StdRptsPettyCash;
			
	@FindBy (xpath="//b[normalize-space()='Custom Reports']")
	WebElement CustomRptsPettyCash;
	
	@FindBy(xpath = "//a[normalize-space()='Setup']")
	WebElement Setup;
			
	List<WebElement> TransacListPettyCash = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[1]/ul[1]/li"));
		
	List<WebElement> InquiriesListPettyCash = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[2]/ul[1]/li"));
			
	List<WebElement> MaintListPettyCash = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[3]/ul[1]/li"));
			
	//Initializing all web elements
	public PettyCashPage()
	{
		PageFactory.initElements(driver, this);
	}
			
	//Actions
	//Page title
	public String PettyCashvalidateTitle()
	{
		return driver.getTitle();
	}
		
	//Transaction and Transaction List
	public boolean PettyCashTransactiontitle()
	{
		return TransactionPettyCash.isDisplayed();
	}
		
	public void PettyCashVerifyTransactionelements()
	{
		List <String> List = Arrays.asList("Assign Cash to PC Tab","Transfer Assigned Cash Between PC Tabs","Claim Expenses From PC Tab","Authorise Expenses",
				"Authorise Assigned Cash");
				
		if (TransacListPettyCash.size()!= 0)
		{
			for (WebElement element : TransacListPettyCash) 
			{
				for(int i=0;i<TransacListPettyCash.size();i++)
				{
					if( element.getText().trim().contains(List.get(i)))
					{
						String TransacList = element.getText().replace("•", "");
						System.out.println("PettyCash Transaction List :" +TransacList.trim());
						Assert.assertEquals(TransacList.trim(), List.get(i).trim(),"PettyCash Transaction List not matched");
						System.out.println("Assertion PettyCash list");
					}
				}
			}
		}
		
	}
		
	//Inquiries Reports and List
	public boolean PettyCashInquiries() 
	{
		return InquiriesPettyCash.isDisplayed();
		
	}
			
	public void PettyCashVerifyInquiriesList()
	{
		List<String> ActualList = Arrays.asList("PC Tab General Report","PC Expense General Report","PC Tab Expenses List"," PC Expenses Analysis");
															
		if(InquiriesListPettyCash.size()!=0)
		{
			for (WebElement element : InquiriesListPettyCash) 
			{
				for(int i=0; i<InquiriesListPettyCash.size();i++)
				{
					if( element.getText().trim().contains(ActualList.get(i)))
					{
						String PettyCashInquiriesList = element.getText().replace("•","");
						System.out.println("PettyCash Inquiries List" +PettyCashInquiriesList.trim());
						Assert.assertEquals(PettyCashInquiriesList.trim(), ActualList.get(i).trim(),"PettyCash Inquiry List not matched");
						System.out.println("Assertion Inquiries List PettyCash");
					}
				}
			}
		}
	}
			
	public boolean PettyCashStandardRepotsTitle()
	{
		return StdRptsPettyCash.isDisplayed();
	}
	
	public boolean PettyCashCustomreportsTitle()
	{
		return CustomRptsPettyCash.isDisplayed();
		
	}
			
	//Maintenance Title and List
	public boolean PettyCashMaintenanceTitle()
	{
		return MaintenancePettyCash.isDisplayed();
	}
			
	public void PettyCashMaintenanceList()
	{
		List<String> MaintList = Arrays.asList("Types of PC Tabs","PC Tabs","PC Expenses","Expenses for Type of PC Tab");
		
		if(MaintListPettyCash.size()!=0)
		{
			for (WebElement element : MaintListPettyCash) 
			{
				for(int i=0;i<MaintListPettyCash.size();i++)
				{
					if( element.getText().trim().contains(MaintList.get(i)))
					{
						String MaintListPettyCashList = element.getText().replace("•", "");
						System.out.println("PettyCash Inquiries List" +MaintListPettyCashList.trim());
						Assert.assertEquals(MaintListPettyCashList.trim(),MaintList.get(i).trim(),"PettyCash Maintenance List not matched");
						System.out.println("Assertion PettyCash Maintenance List");
					}
				}
			}
		}
	}
	
	public SetupPage ClickSetup()
	{
		Setup.click();
		return new SetupPage();
		
	}


}
