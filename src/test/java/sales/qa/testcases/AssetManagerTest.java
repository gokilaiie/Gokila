package sales.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sales.qa.base.TestBase;
import sales.qa.pages.AssetManagerPage;
import sales.qa.pages.GeneralLedgerPage;
import sales.qa.pages.LoginPage;
import sales.qa.pages.PettyCashPage;
import sales.qa.pages.SalesPage;

public class AssetManagerTest extends TestBase  
{
	LoginPage LoginPage;
	SalesPage SalesPage;
	//ReceivablesPage ReceivablesPage;
	//PurchasesPage PurchasePage;
	//PayablesPage PayablesPage;
	//InventoryPage InventoryPage;
	//ManufacturingPage ManufacturingPage;
	GeneralLedgerPage GeneralLedger;
	AssetManagerPage AssetManager;
	PettyCashPage PettyCash;
	
	public AssetManagerTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		SalesPage = new SalesPage();
		LoginPage = new LoginPage();
		//ReceivablesPage = new ReceivablesPage();
		//PurchasePage =new PurchasesPage();
		//PayablesPage = new PayablesPage();
		//InventoryPage = new InventoryPage();
		//ManufacturingPage = new ManufacturingPage();
		GeneralLedger = new GeneralLedgerPage();
		AssetManager = new AssetManagerPage();
		PettyCash = new PettyCashPage();
		SalesPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		AssetManager = GeneralLedger.ClickAssetManagr();
		System.out.println("BeforeMethod");
	}
	
	@Test(priority=1)
	public void ValidateTitle()
	{
		String VerifyTitle = AssetManager.AssetManagervalidateTitle();
		System.out.println("Validate AssetManager Page title:" +VerifyTitle);
		System.out.println("priority=1");
		Assert.assertEquals(VerifyTitle,"webERP - Main Menu","AssetManager Page Title No match.");
	}
	
	@Test(priority=2)
	public void ValidateTransactionTitle()
	{
		Boolean Transaction = AssetManager.AssetManagerTransactiontitle();
		System.out.println("priority=2");
		System.out.println("Validate AssetManager TransactionTitle :" +Transaction);
		Assert.assertEquals(true, Transaction,"AssetManager Transaction Title no match");
		
	}
	
	@Test(priority=3)
	public void ValidateTransacList()
	{
		AssetManager.AssetManagerVerifyTransactionelements();
		System.out.println("priority=3");
		
	}
	
	@Test(priority=4)
	public void ValidateInquiriesTitle()
	{
		boolean Inquiries = AssetManager.AssetManagerInquiries();
		System.out.println("Validate AssetManager InquiriesTitle :" +Inquiries);
		System.out.println("priority=4");
		Assert.assertEquals(true,Inquiries,"Inquiries AssetManager Title No match");
	}
	
	@Test(priority=5)
	public void ValidateInquiriesList()
	{
		AssetManager.AssetManagerVerifyInquiriesList();
		 System.out.println("priority=5");
		
	}
	
	@Test(priority=6)
	public void ValidateCustomRptstitle()
	{
		boolean Customrpts = AssetManager.AssetManagerCustomreportsTitle();
		System.out.println("ValidateCustomRptstitle :" +Customrpts);
		System.out.println("priority=6");
		Assert.assertEquals(true, Customrpts,"AssetManager Custom Reports Title no Match");
	}
	
	@Test(priority=7)
	public void ValidateStdRptsTitle()
	{
		boolean StdRpts = AssetManager.AssetManagerStandardRepotsTitle();
		System.out.println("ValidateStdRptsTitle :" +StdRpts);
		System.out.println("priority=7");
		Assert.assertEquals(true,StdRpts,"AssetManager Std Rpts title no match");
	}
	
	@Test(priority=8)
	public void ValidateMaintenceTitle()
	{
		boolean Maintenance = AssetManager.AssetManagerMaintenanceTitle();
		System.out.println("ValidateMaintenceTitle :" +Maintenance);
		System.out.println("priority=8");
		Assert.assertEquals(true,Maintenance,"AssetManager Maintenance Title No Match.");
	}
	
	@Test(priority=9)
	public void ValidateMaintenanceList()
	{
		AssetManager.AssetManagerMaintenanceList();
		System.out.println("priority=9");
	}
	
	public void PettyCashClick()
	{
		AssetManager.ClickPettyCash();
		
	}
	
	
	  @AfterMethod
	  public void teardown() { driver.quit(); 
	  System.out.println("AfterMethod");}
	 
	 


}
