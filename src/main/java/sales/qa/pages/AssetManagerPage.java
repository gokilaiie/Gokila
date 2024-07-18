package sales.qa.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sales.qa.base.TestBase;

public class AssetManagerPage extends TestBase  
{
	//Page Factory
	@FindBy (xpath = "//b[normalize-space()='Transactions']")
	WebElement TransactionAssetManager;
			
	@FindBy (xpath = "//b[normalize-space()='Inquiries and Reports']")
	WebElement InquiriesAssetManager;
			
	@FindBy(xpath="//b[normalize-space()='Maintenance']")
	WebElement MaintenanceAssetManager;
			
	@FindBy(xpath = "//b[normalize-space()='Standard Reports and Forms']")
	WebElement StdRptsAssetManager;
			
	@FindBy (xpath="//b[normalize-space()='Custom Reports']")
	WebElement CustomRptsAssetManager;
	
	@FindBy(xpath = "//a[normalize-space()='Petty Cash']")
	WebElement PettyCash;
			
	List<WebElement> TransacListAssetManager = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[1]/ul[1]/li"));
		
	List<WebElement> InquiriesListAssetManager = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[2]/ul[1]/li"));
			
	List<WebElement> MaintListAssetManager = driver.findElements(By.xpath("//body/section[@class='MainBody clearfix']/fieldset[3]/ul[1]/li"));
			
	//Initializing all web elements
	public AssetManagerPage()
	{
		PageFactory.initElements(driver, this);
	}
			
	//Actions
	//Page title
	public String AssetManagervalidateTitle()
	{
		return driver.getTitle();
	}
		
	//Transaction and Transaction List
	public boolean AssetManagerTransactiontitle()
	{
		return TransactionAssetManager.isDisplayed();
	}
		
	public void AssetManagerVerifyTransactionelements()
	{
		List <String> List = Arrays.asList("Add a new Asset","Select an Asset","Change Asset Location","Depreciation Journal");
				
		if (TransacListAssetManager.size()!= 0)
		{
			for (WebElement element : TransacListAssetManager) 
			{
				for(int i=0;i<TransacListAssetManager.size();i++)
				{
					if( element.getText().trim().contains(List.get(i)))
					{
						String TransacList = element.getText().replace("•", "");
						System.out.println("AssetManager Transaction List :" +TransacList.trim());
						Assert.assertEquals(TransacList.trim(), List.get(i).trim(),"AssetManager Transaction List not matched");
						System.out.println("Assertion AssetManager list");
					}
				}
			}
		}
		
	}
		
	//Inquiries Reports and List
	public boolean AssetManagerInquiries() 
	{
		return InquiriesAssetManager.isDisplayed();
		
	}
			
	public void AssetManagerVerifyInquiriesList()
	{
		List<String> ActualList = Arrays.asList("Asset Register","My Maintenance Schedule","Maintenance Reminder Emails","Standard Reports and Forms",
				"There are no reports to show!","Custom Reports","There are no reports to show!");
															
		if(InquiriesListAssetManager.size()!=0)
		{
			for (WebElement element : InquiriesListAssetManager) 
			{
				for(int i=0; i<InquiriesListAssetManager.size();i++)
				{
					if( element.getText().trim().contains(ActualList.get(i)))
					{
						String AssetManagerInquiriesList = element.getText().replace("•","");
						System.out.println("AssetManager Inquiries List" +AssetManagerInquiriesList.trim());
						Assert.assertEquals(AssetManagerInquiriesList.trim(), ActualList.get(i).trim(),"AssetManager Inquiry List not matched");
						System.out.println("Assertion Inquiries List AssetManager");
					}
				}
			}
		}
	}
			
	public boolean AssetManagerStandardRepotsTitle()
	{
		return StdRptsAssetManager.isDisplayed();
	}
	
	public boolean AssetManagerCustomreportsTitle()
	{
		return CustomRptsAssetManager.isDisplayed();
		
	}
			
	//Maintenance Title and List
	public boolean AssetManagerMaintenanceTitle()
	{
		return MaintenanceAssetManager.isDisplayed();
	}
			
	public void AssetManagerMaintenanceList()
	{
		List<String> MaintList = Arrays.asList("Fixed Asset Category Maintenance","Add or Maintain Asset Locations","Fixed Asset Maintenance Tasks");
		
		if(MaintListAssetManager.size()!=0)
		{
			for (WebElement element : MaintListAssetManager) 
			{
				for(int i=0;i<MaintListAssetManager.size();i++)
				{
					if( element.getText().trim().contains(MaintList.get(i)))
					{
						String MaintListAssetManagerList = element.getText().replace("•", "");
						System.out.println("AssetManager Inquiries List" +MaintListAssetManagerList.trim());
						Assert.assertEquals(MaintListAssetManagerList.trim(),MaintList.get(i).trim(),"AssetManager Maintenance List not matched");
						System.out.println("Assertion AssetManager Maintenance List");
					}
				}
			}
		}
	}
	
	public PettyCashPage ClickPettyCash()
	{
		PettyCash.click();
		return new PettyCashPage();
		
	}

}
