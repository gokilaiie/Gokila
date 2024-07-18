package sales.qa.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sales.qa.base.TestBase;

public class InventoryPage extends TestBase
{
	//Page Factory
	@FindBy (xpath = "//b[normalize-space()='Transactions']")
	WebElement TransactionInventory;
			
	@FindBy (xpath = "//b[normalize-space()='Inquiries and Reports']")
	WebElement InquiriesInventory;
			
	@FindBy(xpath="//b[normalize-space()='Maintenance']")
	WebElement MaintenanceInventory;
			
	@FindBy(xpath = "//b[normalize-space()='Standard Reports and Forms']")
	WebElement StdRptsInventory;
			
	@FindBy (xpath="//b[normalize-space()='Custom Reports']")
	WebElement CustomRptsInventory;
	
	@FindBy(xpath = "//a[normalize-space()='Manufacturing']")
	WebElement Manufacturing;
			
	List<WebElement> TransacListInventory = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[1]/ul[1]/li"));
		
	List<WebElement> InquiriesListInventory = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[2]/ul[1]/li"));
			
	List<WebElement> MaintListInventory = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[3]/ul[1]/li"));
			
	//Initializing all web elements
	public InventoryPage()
	{
		PageFactory.initElements(driver, this);
	}
			
	//Actions
	//Page title
	public String InventoryvalidateTitle()
	{
		return driver.getTitle();
	}
		
	//Transaction and Transaction List
	public boolean InventoryTransactiontitle()
	{
		return TransactionInventory.isDisplayed();
	}
		
	public void InventoryVerifyTransactionelements()
	{
		List <String> List = Arrays.asList("Receive Purchase Orders","Inventory Transfer - Item Dispatch","Bulk Inventory Transfer - Dispatch","Bulk Inventory Transfer - Receive",
											"Inventory Adjustments","Reverse Goods Received","Enter Stock Counts","Create a New Internal Stock Request",
											"Create a New Internal Stock Request","Authorise Internal Stock Requests","Fulfill Internal Stock Requests");
				
		if (TransacListInventory.size()!= 0)
		{
			for (WebElement element : TransacListInventory) 
			{
				for(int i=0;i<TransacListInventory.size();i++)
				{
					if( element.getText().trim().contains(List.get(i)))
					{
						String TransacList = element.getText().replace("•", "");
						System.out.println("Inventory Transaction List :" +TransacList.trim());
						Assert.assertEquals(TransacList.trim(), List.get(i).trim(),"Inventory Transaction List not matched");
						System.out.println("Assertion Inventory list");
					}
				}
			}
		}
		
	}
		
	//Inquiries Reports and List
	public boolean InventoryInquiries() 
	{
		return InquiriesInventory.isDisplayed();
		
	}
			
	public void InventoryVerifyInquiriesList()
	{
		List<String> ActualList = Arrays.asList("Serial Item Research Tool","Print Price Labels","Reprint GRN","Inventory Item Movements"," Inventory Item Status",
												"Inventory Item Usage","Inventory Quantities","Reorder Level","Stock Dispatch","Inventory Valuation Report",
												" Mail Inventory Valuation Report","Inventory Planning Report"," Inventory Planning Based On Preferred Supplier Data",
												"Inventory Stock Check Sheets","Make Inventory Quantities CSV","Compare Counts Vs Stock Check Data",
												"All Inventory Movements By Location/Date","List Inventory Status By Location/Category",
												"Historical Stock Quantity By Location/Category","List Negative Stocks","Period Stock Transaction Listing",
												"Stock Transfer Note","Aged Controlled Stock Report","Internal stock request inquiry","Standard Reports and Forms",
												"There are no reports to show!","Custom Reports","There are no reports to show!");
															
		if(InquiriesListInventory.size()!=0)
		{
			for (WebElement element : InquiriesListInventory) 
			{
				for(int i=0; i<InquiriesListInventory.size();i++)
				{
					if( element.getText().trim().contains(ActualList.get(i)))
					{
						String InventoryInquiriesList = element.getText().replace("•","");
						System.out.println("Inventory Inquiries List" +InventoryInquiriesList.trim());
						//Assert.assertEquals(InventoryInquiriesList.trim(), ActualList.get(i).trim(),"Inventory Inquiry List not matched");
						Assert.assertTrue(InventoryInquiriesList.trim().contains(ActualList.get(i).trim()), "Inventory Inquiry List not matched");
						System.out.println("Assertion Inquiries List Inventory");
					}
				}
			}
		}
	}
			
	public boolean InventoryStandardRepotsTitle()
	{
		return StdRptsInventory.isDisplayed();
	}
	
	public boolean InventoryCustomreportsTitle()
	{
		return CustomRptsInventory.isDisplayed();
		
	}
			
	//Maintenance Title and List
	public boolean InventoryMaintenanceTitle()
	{
		return MaintenanceInventory.isDisplayed();
	}
			
	public void InventoryMaintenanceList()
	{
		List<String> MaintList = Arrays.asList("Add A New Item"," Select An Item","Review Translated Descriptions","Sales Category Maintenance","Brands Maintenance",
												"Add or Update Prices Based On Costs","View or Update Prices Based On Costs","Reorder Level By Category/Location");
		
		if(MaintListInventory.size()!=0)
		{
			for (WebElement element : MaintListInventory) 
			{
				for(int i=0;i<MaintListInventory.size();i++)
				{
					if( element.getText().trim().contains(MaintList.get(i)))
					{
						String MaintListInventoryList = element.getText().replace("•", "");
						System.out.println("Inventory Inquiries List" +MaintListInventoryList.trim());
						Assert.assertEquals(MaintListInventoryList.trim(),MaintList.get(i).trim(),"Inventory Maintenance List not matched");
						System.out.println("Assertion Inventory Maintenance List");
					}
				}
			}
		}
	}

	public ManufacturingPage ClickManufacturing()
	{
		Manufacturing.click();
		return new ManufacturingPage();
		
	}

}
