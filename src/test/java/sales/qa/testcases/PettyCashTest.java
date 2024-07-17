package sales.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sales.qa.base.TestBase;
import sales.qa.pages.AssetManagerPage;
import sales.qa.pages.LoginPage;
import sales.qa.pages.PettyCashPage;
import sales.qa.pages.SalesPage;
import sales.qa.pages.SetupPage;

public class PettyCashTest extends TestBase  
{
	LoginPage LoginPage;
	SalesPage SalesPage;
	//ReceivablesPage ReceivablesPage;
	//PurchasesPage PurchasePage;
	//PayablesPage PayablesPage;
	//InventoryPage InventoryPage;
	//ManufacturingPage ManufacturingPage;
	//GeneralLedgerPage GeneralLedger;
	AssetManagerPage AssetManager;
	PettyCashPage PettyCash;
	SetupPage Setup;
	
	public PettyCashTest()
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
		//GeneralLedger = new GeneralLedgerPage();
		AssetManager = new AssetManagerPage();
		PettyCash = new PettyCashPage();
		Setup = new SetupPage();
		SalesPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		PettyCash = AssetManager.ClickPettyCash();
		System.out.println("BeforeMethod");
	}
	
	@Test(priority=1)
	public void ValidateTitle()
	{
		String VerifyTitle = PettyCash.PettyCashvalidateTitle();
		System.out.println("Validate PettyCash Page title:" +VerifyTitle);
		System.out.println("priority=1");
		Assert.assertEquals(VerifyTitle,"webERP - Main Menu","PettyCash Page Title No match.");
	}
	
	@Test(priority=2)
	public void ValidateTransactionTitle()
	{
		Boolean Transaction = PettyCash.PettyCashTransactiontitle();
		System.out.println("priority=2");
		System.out.println("Validate PettyCash TransactionTitle :" +Transaction);
		Assert.assertEquals(true, Transaction,"PettyCash Transaction Title no match");
		
	}
	
	@Test(priority=3)
	public void ValidateTransacList()
	{
		PettyCash.PettyCashVerifyTransactionelements();
		System.out.println("priority=3");
		
	}
	
	@Test(priority=4)
	public void ValidateInquiriesTitle()
	{
		boolean Inquiries = PettyCash.PettyCashInquiries();
		System.out.println("Validate PettyCash InquiriesTitle :" +Inquiries);
		System.out.println("priority=4");
		Assert.assertEquals(true,Inquiries,"Inquiries PettyCash Title No match");
	}
	
	@Test(priority=5)
	public void ValidateInquiriesList()
	{
		PettyCash.PettyCashVerifyInquiriesList();
		 System.out.println("priority=5");
		
	}
	
	@Test(priority=6)
	public void ValidateCustomRptstitle()
	{
		boolean Customrpts = PettyCash.PettyCashCustomreportsTitle();
		System.out.println("ValidateCustomRptstitle :" +Customrpts);
		System.out.println("priority=6");
		Assert.assertEquals(true, Customrpts,"PettyCash Custom Reports Title no Match");
	}
	
	@Test(priority=7)
	public void ValidateStdRptsTitle()
	{
		boolean StdRpts = PettyCash.PettyCashStandardRepotsTitle();
		System.out.println("ValidateStdRptsTitle :" +StdRpts);
		System.out.println("priority=7");
		Assert.assertEquals(true,StdRpts,"PettyCash Std Rpts title no match");
	}
	
	@Test(priority=8)
	public void ValidateMaintenceTitle()
	{
		boolean Maintenance = PettyCash.PettyCashMaintenanceTitle();
		System.out.println("ValidateMaintenceTitle :" +Maintenance);
		System.out.println("priority=8");
		Assert.assertEquals(true,Maintenance,"PettyCash Maintenance Title No Match.");
	}
	
	@Test(priority=9)
	public void ValidateMaintenanceList()
	{
		PettyCash.PettyCashMaintenanceList();
		System.out.println("priority=9");
	}
	
	public void SetupClick()
	{
		PettyCash.ClickSetup();
		
	}
	
	
	  @AfterMethod
	  public void teardown() { driver.quit(); 
	  System.out.println("AfterMethod");}

}
