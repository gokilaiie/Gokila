package sales.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sales.qa.base.TestBase;
import sales.qa.pages.LoginPage;
import sales.qa.pages.PettyCashPage;
import sales.qa.pages.SalesPage;
import sales.qa.pages.SetupPage;
import sales.qa.pages.UtilitiesPage;

public class SetupTest extends TestBase  
{
	LoginPage LoginPage;
	SalesPage SalesPage;
	//ReceivablesPage ReceivablesPage;
	//PurchasesPage PurchasePage;
	//PayablesPage PayablesPage;
	//InventoryPage InventoryPage;
	//ManufacturingPage ManufacturingPage;
	//GeneralLedgerPage GeneralLedger;
	//AssetManagerPage AssetManager;
	PettyCashPage PettyCash;
	SetupPage Setup;
	UtilitiesPage Utilities;
	
	public SetupTest()
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
		//AssetManager = new AssetManagerPage();
		PettyCash = new PettyCashPage();
		Setup = new SetupPage();
		Utilities = new UtilitiesPage();
		SalesPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Setup = PettyCash.ClickSetup();
		System.out.println("BeforeMethod");
	}
	
	@Test(priority=1)
	public void ValidateTitle()
	{
		String VerifyTitle = Setup.SetupvalidateTitle();
		System.out.println("Validate Setup Page title:" +VerifyTitle);
		System.out.println("priority=1");
		Assert.assertEquals(VerifyTitle,"webERP - Main Menu","Setup Page Title No match.");
	}
	
	@Test(priority=2)
	public void ValidateGeneralSetupOptionsTitile()
	{
		Boolean GeneralSetupOptions = Setup.GeneralSetupOptions();
		System.out.println("priority=2");
		System.out.println("Validate GeneralSetupOptions Title :" +GeneralSetupOptions);
		Assert.assertEquals(true, GeneralSetupOptions,"GeneralSetupOptions Title no match");
		
	}
	
	@Test(priority=3)
	public void ValidateGeneralSetupList()
	{
		Setup.SetupGeneralSetup();
		System.out.println("priority=3");
		
	}
	
	@Test(priority=4)
	public void ValidateReceivablesorPayablesTitle()
	{
		boolean Inquiries = Setup.SetupReceivablesOrPayable();
		System.out.println("Validate ReceivablesorPayablesTitle :" +Inquiries);
		System.out.println("priority=4");
		Assert.assertEquals(true,Inquiries,"ReceivablesorPayablesTitle No match");
	}
	
	@Test(priority=5)
	public void ValidateReceivablesorPayablesList()
	{
		Setup.SetupVerifyReceivablesorPayablesList();
		 System.out.println("priority=5");
		
	}
	
	@Test(priority=6)
	public void ValidateCustomRptstitle()
	{
		boolean Customrpts = Setup.SetupCustomreportsTitle();
		System.out.println("ValidateCustomRptstitle :" +Customrpts);
		System.out.println("priority=6");
		Assert.assertEquals(true, Customrpts,"Setup Custom Reports Title no Match");
	}
	
	@Test(priority=7)
	public void ValidateStdRptsTitle()
	{
		boolean StdRpts = Setup.SetupStandardRepotsTitle();
		System.out.println("ValidateStdRptsTitle :" +StdRpts);
		System.out.println("priority=7");
		Assert.assertEquals(true,StdRpts,"Setup Std Rpts title no match");
	}
	
	@Test(priority=8)
	public void ValidateInventorySetupTitle()
	{
		boolean Maintenance = Setup.SetupInventorySetupTitle();
		System.out.println("ValidateInventorySetupTitle :" +Maintenance);
		System.out.println("priority=8");
		Assert.assertEquals(true,Maintenance,"InventorySetup Title No Match.");
	}
	
	@Test(priority=9)
	public void ValidateInventorySetupList()
	{
		Setup.SetupInventoryList();
		System.out.println("priority=9");
	}
	
	public void UtilitiesClick()
	{
		Setup.ClickUtilities();
		
	}
	
	
	  @AfterMethod
	  public void teardown() { driver.quit(); 
	  System.out.println("AfterMethod");}


}
