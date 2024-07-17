package sales.qa.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sales.qa.base.TestBase;

public class PurchasesPage extends TestBase  
{
	//Page Factory
		@FindBy (xpath = "//b[normalize-space()='Transactions']")
		WebElement TransactionPurchases;
		
		@FindBy (xpath = "//b[normalize-space()='Inquiries and Reports']")
		WebElement InquiriesPurchases;
		
		@FindBy(xpath="//b[normalize-space()='Maintenance']")
		WebElement MaintenancePurchases;
		
		@FindBy(xpath = "//b[normalize-space()='Standard Reports and Forms']")
		WebElement StdRptsPurchases;
		
		@FindBy (xpath="//b[normalize-space()='Custom Reports']")
		WebElement CustomRptsPurchases;
		
		@FindBy(xpath = "//a[normalize-space()='Payables']")
		WebElement Payables;
		
		List<WebElement> TransacListPurchases = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[1]/ul[1]/li"));
		
		List<WebElement> InquiriesListPurchases = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[2]/ul[1]/li"));
		
		List<WebElement> MaintListPurchases= driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[3]/ul[1]/li"));
		
		//Initializing all web elements
		public PurchasesPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		//Page title
		public String PurchasesvalidateTitle()
		{
			return driver.getTitle();
		}
		
		//Transaction and Transaction List
		public boolean PurchasesTransactiontitle()
		{
			return TransactionPurchases.isDisplayed();
		}
		
		public void PurchasesVerifyTransactionelements()
		{
			List <String> List = Arrays.asList("New Purchase Order","Purchase Orders","Purchase Order Grid Entry","Create a New Tender","Edit Existing Tenders",
												"Process Tenders and Offers","Orders to Authorise","Shipment Entry","Select A Shipment");
			
			if (TransacListPurchases.size()!= 0)
			{
				for (WebElement element : TransacListPurchases) 
				{
					for(int i=0;i<TransacListPurchases.size();i++)
					{
						if( element.getText().trim().contains(List.get(i)))
						{
							String TransacList = element.getText().replace("•", "");
							System.out.println("Purchases Transaction List :" +TransacList.trim());
							Assert.assertEquals(TransacList.trim(), List.get(i).trim(),"Purchases Transaction List not matched");
							System.out.println("Assertion Purchases list");
						}
					}
				}
			}
			
		}
		
		//Inquiries Reports and List
		public boolean PurchasesInquiries() 
		{
			return InquiriesPurchases.isDisplayed();
			
		}
		
		public void PurchasesVerifyInquiriesList()
		{
			List<String> ActualList = Arrays.asList("Purchase Order Inquiry","Purchase Order Detail Or Summary Inquiries","Vendor Price List",
													"Purchases from Suppliers");
														
			if(InquiriesListPurchases.size()!=0)
			{
				for (WebElement element : InquiriesListPurchases) 
				{
					for(int i=0; i<InquiriesListPurchases.size();i++)
					{
						if( element.getText().trim().contains(ActualList.get(i)))
						{
							String InquiriesList = element.getText().replace("•","");
							System.out.println("Purchase Inquiries List" +InquiriesList.trim());
							Assert.assertEquals(InquiriesList.trim(), ActualList.get(i).trim(),"Purchase Inquiry List not matched");
							System.out.println("Assertion Inquiries List Purchase");
						}
					}
				}
			}
		}
		
		public boolean PurchasesStandardRepotsTitle()
		{
			return StdRptsPurchases.isDisplayed();
		}
		
		public boolean PurchasesCustomreportsTitle()
		{
			return CustomRptsPurchases.isDisplayed();
			
		}
		
		//Maintenance Title and List
		public boolean PurchasesMaintenanceTitle()
		{
			return MaintenancePurchases.isDisplayed();
		}
		
		public void PurchasesMaintenanceList()
		{
			List<String> MaintList = Arrays.asList("Maintain Supplier Price Lists");
			
			if(MaintListPurchases.size()!=0)
			{
				for (WebElement element : MaintListPurchases) 
				{
					for(int i=0;i<MaintListPurchases.size();i++)
					{
						if( element.getText().trim().contains(MaintList.get(i)))
						{
							String MaintListPurchasesList = element.getText().replace("•", "");
							System.out.println("Purchases Inquiries List" +MaintListPurchasesList.trim());
							Assert.assertEquals(MaintListPurchasesList.trim(),MaintList.get(i).trim(),"Purchases Maintenance List not matched");
							System.out.println("Assertion Purchases Maintenance List");
						}
					}
				}
			}
		}

		public PayablesPage ClickPayables()
		{
			Payables.click();
			return new PayablesPage();
			
		}
}
