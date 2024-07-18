package sales.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sales.qa.base.TestBase;
import sales.qa.pages.GeneralLedgerPage;
import sales.qa.pages.InventoryPage;
import sales.qa.pages.LoginPage;
import sales.qa.pages.ManufacturingPage;
import sales.qa.pages.SalesPage;

public class ManufacturingTest extends TestBase  
{
	LoginPage LoginPage;
	SalesPage SalesPage;
	
	InventoryPage InventoryPage;
	ManufacturingPage ManufacturingPage;
	GeneralLedgerPage GeneralLedger;
	
	
	public ManufacturingTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		LoginPage = new LoginPage();
		
		
		SalesPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		InventoryPage = new InventoryPage();
		ManufacturingPage = InventoryPage.ClickManufacturing();
		
		
		GeneralLedger = new GeneralLedgerPage();
		System.out.println("BeforeMethod");
	}
	
	@Test(priority=1)
	public void ValidateTitle()
	{
		String VerifyTitle = ManufacturingPage.ManufacturingvalidateTitle();
		System.out.println("Validate Payable Page title:" +VerifyTitle);
		System.out.println("priority=1");
		Assert.assertEquals(VerifyTitle,"webERP - Main Menu","Manufacturing Page Title No match.");
	}
	
	@Test(priority=2)
	public void ValidateTransactionTitle()
	{
		Boolean Transaction = ManufacturingPage.ManufacturingTransactiontitle();
		System.out.println("priority=2");
		System.out.println("Validate Manufacturing TransactionTitle :" +Transaction);
		Assert.assertEquals(true, Transaction,"Manufacturing Transaction Title no match");
		
	}
	
	@Test(priority=3)
	public void ValidateTransacList()
	{
		ManufacturingPage.ManufacturingVerifyTransactionelements();
		System.out.println("priority=3");
		
	}
	
	@Test(priority=4)
	public void ValidateInquiriesTitle()
	{
		boolean Inquiries = ManufacturingPage.ManufacturingInquiries();
		System.out.println("Validate Manufacturing InquiriesTitle :" +Inquiries);
		System.out.println("priority=4");
		Assert.assertEquals(true,Inquiries,"Inquiries Manufacturing Title No match");
	}
	
	@Test(priority=5)
	public void ValidateInquiriesList()
	{
		ManufacturingPage.ManufacturingVerifyInquiriesList();
		 System.out.println("priority=5");
		
	}
	
	@Test(priority=6)
	public void ValidateCustomRptstitle()
	{
		boolean Customrpts = ManufacturingPage.ManufacturingCustomreportsTitle();
		System.out.println("ValidateCustomRptstitle :" +Customrpts);
		System.out.println("priority=6");
		Assert.assertEquals(true, Customrpts,"Manufacturing Custom Reports Title no Match");
	}
	
	@Test(priority=7)
	public void ValidateStdRptsTitle()
	{
		boolean StdRpts = ManufacturingPage.ManufacturingStandardRepotsTitle();
		System.out.println("ValidateStdRptsTitle :" +StdRpts);
		System.out.println("priority=7");
		Assert.assertEquals(true,StdRpts,"Manufacturing Std Rpts title no match");
	}
	
	@Test(priority=8)
	public void ValidateMaintenceTitle()
	{
		boolean Maintenance = ManufacturingPage.ManufacturingMaintenanceTitle();
		System.out.println("ValidateMaintenceTitle :" +Maintenance);
		System.out.println("priority=8");
		Assert.assertEquals(true,Maintenance,"Manufacturing Maintenance Title No Match.");
	}
	
	@Test(priority=9)
	public void ValidateMaintenanceList()
	{
		ManufacturingPage.ManufacturingMaintenanceList();
		System.out.println("priority=9");
	}
	
	public void GeneralLedgerClick()
	{
		ManufacturingPage.ClickGnrlLedger();
		
	}
	
	
	  @AfterMethod
	  public void teardown() { driver.quit(); 
	  System.out.println("AfterMethod");}
	 
	 


}
