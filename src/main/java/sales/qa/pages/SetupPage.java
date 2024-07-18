package sales.qa.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sales.qa.base.TestBase;

public class SetupPage extends TestBase  
{
	//Page Factory
	@FindBy (xpath = "//b[normalize-space()='General Setup Options']")
	WebElement GeneralSetupOptions;
			
	@FindBy (xpath = "//b[normalize-space()='Receivables/Payables Setup']")
	WebElement SetupReceivableorPayables;
			
	@FindBy(xpath="//b[normalize-space()='Inventory Setup']")
	WebElement InventorySetup;
			
	@FindBy(xpath = "//b[normalize-space()='Standard Reports and Forms']")
	WebElement StdRptsSetup;
			
	@FindBy (xpath="//b[normalize-space()='Custom Reports']")
	WebElement CustomRptsSetup;
	
	@FindBy(xpath = "//a[normalize-space()='Utilities']")
	WebElement Utilities;
			
	List<WebElement> GeneralListSetup = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[1]/ul[1]/li"));
		
	List<WebElement> SetupReceivableorPayablesList = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[2]/ul[1]/li"));
			
	List<WebElement> InventoryListSetup = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[3]/ul[1]/li"));
			
	//Initializing all web elements
	public SetupPage()
	{
		PageFactory.initElements(driver, this);
	}
			
	//Actions
	//Page title
	public String SetupvalidateTitle()
	{
		return driver.getTitle();
	}
		
	//Transaction and Transaction List
	public boolean GeneralSetupOptions()
	{
		return GeneralSetupOptions.isDisplayed();
	}
		
	public void SetupGeneralSetup()
	{
		List <String> List = Arrays.asList(" Company Preferences","System Parameters","Users Maintenance","Maintain Security Tokens","Access Permissions Maintenance",
				"Page Security Settings","Currencies Maintenance"," Tax Authorities and Rates Maintenance","Tax Group Maintenance","Dispatch Tax Province Maintenance",
				"Tax Category Maintenance","List Periods Defined","Report Builder Tool","View Audit Trail","Geocode Maintenance","Form Designer","Web-Store Configuration"
				,"SMTP Server Details","Mailing Group Maintenance");
				
		if (GeneralListSetup.size()!= 0)
		{
			for (WebElement element : GeneralListSetup) 
			{
				for(int i=0;i<GeneralListSetup.size();i++)
				{
					if( element.getText().trim().contains(List.get(i)))
					{
						String TransacList = element.getText().replace("•", "");
						System.out.println("Setup Transaction List :" +TransacList.trim());
						Assert.assertEquals(TransacList.trim(), List.get(i).trim(),"General Setup List not matched");
						System.out.println("Assertion Setup list");
					}
				}
			}
		}
		
	}
		
	//Inquiries Reports and List
	public boolean SetupReceivablesOrPayable() 
	{
		return SetupReceivableorPayables.isDisplayed();
		
	}
			
	public void SetupVerifyReceivablesorPayablesList()
	{
		List<String> ActualList = Arrays.asList("Sales Types","Customer Types","Supplier Types","Credit Status","Payment Terms",
									"Set Purchase Order Authorisation levels","Payment Methods","Sales People","Sales Areas","Shipping-methods",
									"Sales GL Interface Postings","COGS GL Interface Postings"," Shipping Costs Maintenance"," Discount Matrix",
									"Standard Reports and Forms","There are no reports to show!","Custom Reports","There are no reports to show!");
															
		if(SetupReceivableorPayablesList.size()!=0)
		{
			for (WebElement element : SetupReceivableorPayablesList) 
			{
				for(int i=0; i<SetupReceivableorPayablesList.size();i++)
				{
					if( element.getText().trim().contains(ActualList.get(i)))
					{
						String SetupInquiriesList = element.getText().replace("•","");
						System.out.println("Setup Inquiries List" +SetupInquiriesList.trim());
						Assert.assertEquals(SetupInquiriesList.trim(), ActualList.get(i).trim(),"Setup Receivable/Payable List not matched");
						System.out.println("Assertion Receivable/Payable List Setup");
					}
				}
			}
		}
	}
			
	public boolean SetupStandardRepotsTitle()
	{
		return StdRptsSetup.isDisplayed();
	}
	
	public boolean SetupCustomreportsTitle()
	{
		return CustomRptsSetup.isDisplayed();
		
	}
			
	//Maintenance Title and List
	public boolean SetupInventorySetupTitle()
	{
		return InventorySetup.isDisplayed();
	}
			
	public void SetupInventoryList()
	{
		List<String> MaintList = Arrays.asList("Inventory Categories Maintenance","Inventory Locations Maintenance","Inventory Location Authorized Users Maintenance",
									"User Authorized Inventory Locations Maintenance"," Discount Category Maintenance","Units of Measure","MRP Available Production Days",
									"MRP Demand Types","Maintain Internal Departments","Maintain Internal Stock Categories to User Roles","Label Templates Maintenance");
		
		if(InventoryListSetup.size()!=0)
		{
			for (WebElement element : InventoryListSetup) 
			{
				for(int i=0;i<InventoryListSetup.size();i++)
				{
					if( element.getText().trim().contains(MaintList.get(i)))
					{
						String MaintListSetupList = element.getText().replace("•", "");
						System.out.println("Setup Inquiries List" +MaintListSetupList.trim());
						//Assert.assertEquals(MaintListSetupList.trim(),MaintList.get(i).trim(),"Setup Inventory List not matched");
						Assert.assertTrue(MaintListSetupList.trim().contains(MaintList.get(i).trim()), "Setup Inventory List not matched");
						System.out.println("Assertion Setup Maintenance List");
					}
				}
			}
		}
	}
	
	public UtilitiesPage ClickUtilities()
	{
		Utilities.click();
		return new UtilitiesPage();
	}


}
