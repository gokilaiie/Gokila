package sales.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sales.qa.base.TestBase;
import sales.qa.pages.AssetManagerPage;
import sales.qa.pages.GeneralLedgerPage;
import sales.qa.pages.LoginPage;
import sales.qa.pages.ManufacturingPage;
import sales.qa.pages.SalesPage;

public class GeneralLedgerTest extends TestBase 
{
	LoginPage LoginPage;
	SalesPage SalesPage;
	//ReceivablesPage ReceivablesPage;
	//PurchasesPage PurchasePage;
	//PayablesPage PayablesPage;
	//InventoryPage InventoryPage;
	ManufacturingPage ManufacturingPage;
	GeneralLedgerPage GeneralLedger;
	AssetManagerPage AssetManager;
	
	
	public GeneralLedgerTest()
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
		ManufacturingPage = new ManufacturingPage();
		GeneralLedger = new GeneralLedgerPage();
		AssetManager = new AssetManagerPage();
		SalesPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		GeneralLedger = ManufacturingPage.ClickGnrlLedger();
		System.out.println("BeforeMethod");
	}
	
	@Test(priority=1)
	public void ValidateTitle()
	{
		String VerifyTitle = GeneralLedger.GeneralLedgervalidateTitle();
		System.out.println("Validate Payable Page title:" +VerifyTitle);
		System.out.println("priority=1");
		Assert.assertEquals(VerifyTitle,"webERP - Main Menu","General Ledger Page Title No match.");
	}
	
	@Test(priority=2)
	public void ValidateTransactionTitle()
	{
		Boolean Transaction = GeneralLedger.GeneralLedgerTransactiontitle();
		System.out.println("priority=2");
		System.out.println("Validate GeneralLedger TransactionTitle :" +Transaction);
		Assert.assertEquals(true, Transaction,"GeneralLedger Transaction Title no match");
		
	}
	
	@Test(priority=3)
	public void ValidateTransacList()
	{
		GeneralLedger.GeneralLedgerVerifyTransactionelements();
		System.out.println("priority=3");
		
	}
	
	@Test(priority=4)
	public void ValidateInquiriesTitle()
	{
		boolean Inquiries = GeneralLedger.GeneralLedgerInquiries();
		System.out.println("Validate GeneralLedger InquiriesTitle :" +Inquiries);
		System.out.println("priority=4");
		Assert.assertEquals(true,Inquiries,"Inquiries GeneralLedger Title No match");
	}
	
	@Test(priority=5)
	public void ValidateInquiriesList()
	{
		GeneralLedger.GeneralLedgerVerifyInquiriesList();
		 System.out.println("priority=5");
		
	}
	
	@Test(priority=6)
	public void ValidateCustomRptstitle()
	{
		boolean Customrpts = GeneralLedger.GeneralLedgerCustomreportsTitle();
		System.out.println("ValidateCustomRptstitle :" +Customrpts);
		System.out.println("priority=6");
		Assert.assertEquals(true, Customrpts,"GeneralLedger Custom Reports Title no Match");
	}
	
	@Test(priority=7)
	public void ValidateStdRptsTitle()
	{
		boolean StdRpts = GeneralLedger.GeneralLedgerStandardRepotsTitle();
		System.out.println("ValidateStdRptsTitle :" +StdRpts);
		System.out.println("priority=7");
		Assert.assertEquals(true,StdRpts,"GeneralLedger Std Rpts title no match");
	}
	
	@Test(priority=8)
	public void ValidateMaintenceTitle()
	{
		boolean Maintenance = GeneralLedger.GeneralLedgerMaintenanceTitle();
		System.out.println("ValidateMaintenceTitle :" +Maintenance);
		System.out.println("priority=8");
		Assert.assertEquals(true,Maintenance,"GeneralLedger Maintenance Title No Match.");
	}
	
	@Test(priority=9)
	public void ValidateMaintenanceList()
	{
		GeneralLedger.GeneralLedgerMaintenanceList();
		System.out.println("priority=9");
	}
	
	public void AssetManagerClick()
	{
		GeneralLedger.ClickAssetManagr();
		
	}
	
	
	  @AfterMethod
	  public void teardown() { driver.quit(); 
	  System.out.println("AfterMethod");}
	 
	 


}
