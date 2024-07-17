package sales.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sales.qa.base.TestBase;
import sales.qa.pages.InventoryPage;
import sales.qa.pages.LoginPage;
import sales.qa.pages.ManufacturingPage;
import sales.qa.pages.PayablesPage;
import sales.qa.pages.SalesPage;

public class InventoryTest extends TestBase  
{
	LoginPage LoginPage;
	SalesPage SalesPage;
	//ReceivablesPage ReceivablesPage;
	//PurchasesPage PurchasePage;
	PayablesPage PayablesPage;
	InventoryPage InventoryPage;
	ManufacturingPage ManufacturingPage;
	
	public InventoryTest()
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
		PayablesPage = new PayablesPage();
		InventoryPage = new InventoryPage();
		ManufacturingPage = new ManufacturingPage();
		SalesPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		InventoryPage = PayablesPage.ClickInventory();
		System.out.println("BeforeMethod");
	}
	
	@Test(priority=1)
	public void ValidateTitle()
	{
		String PayableTitle = InventoryPage.InventoryvalidateTitle();
		System.out.println("Validate Payable Page title:" +PayableTitle);
		System.out.println("priority=1");
		Assert.assertEquals(PayableTitle,"webERP - Main Menu","Inventory Page Title No match.");
	}
	
	@Test(priority=2)
	public void ValidateTransactionTitle()
	{
		Boolean Transaction = InventoryPage.InventoryTransactiontitle();
		System.out.println("priority=2");
		System.out.println("Validate Payable TransactionTitle :" +Transaction);
		Assert.assertEquals(true, Transaction,"Inventory Transaction Title no match");
		
	}
	
	@Test(priority=3)
	public void ValidateTransacList()
	{
		InventoryPage.InventoryVerifyTransactionelements();
		System.out.println("priority=3");
		
	}
	
	@Test(priority=4)
	public void ValidateInquiriesTitle()
	{
		boolean Inquiries = InventoryPage.InventoryInquiries();
		System.out.println("Validate Inventory InquiriesTitle :" +Inquiries);
		System.out.println("priority=4");
		Assert.assertEquals(true,Inquiries,"Inquiries InventoryPage Title No match");
	}
	
	@Test(priority=5)
	public void ValidateInquiriesList()
	{
		InventoryPage.InventoryVerifyInquiriesList();
		 System.out.println("priority=5");
		
	}
	
	@Test(priority=6)
	public void ValidateCustomRptstitle()
	{
		boolean Customrpts = InventoryPage.InventoryCustomreportsTitle();
		System.out.println("ValidateCustomRptstitle :" +Customrpts);
		System.out.println("priority=6");
		Assert.assertEquals(true, Customrpts,"Inventory Custom Reports Title no Match");
	}
	
	@Test(priority=7)
	public void ValidateStdRptsTitle()
	{
		boolean StdRpts = InventoryPage.InventoryStandardRepotsTitle();
		System.out.println("ValidateStdRptsTitle :" +StdRpts);
		System.out.println("priority=7");
		Assert.assertEquals(true,StdRpts,"Inventory Std Rpts title no match");
	}
	
	@Test(priority=8)
	public void ValidateMaintenceTitle()
	{
		boolean Maintenance = InventoryPage.InventoryMaintenanceTitle();
		System.out.println("ValidateMaintenceTitle :" +Maintenance);
		System.out.println("priority=8");
		Assert.assertEquals(true,Maintenance,"Inventory Maintenance Title No Match.");
	}
	
	@Test(priority=9)
	public void ValidateMaintenanceList()
	{
		InventoryPage.InventoryMaintenanceList();
		System.out.println("priority=9");
	}
	
	public void ManuacturingClick()
	{
		ManufacturingPage = InventoryPage.ClickManufacturing();
		
	}
	
	
	  @AfterMethod
	  public void teardown() { driver.quit(); 
	  System.out.println("AfterMethod");}
	 
	 


}
