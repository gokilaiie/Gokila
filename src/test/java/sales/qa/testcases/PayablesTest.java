package sales.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sales.qa.base.TestBase;
import sales.qa.pages.InventoryPage;
import sales.qa.pages.LoginPage;
import sales.qa.pages.PayablesPage;
import sales.qa.pages.PurchasesPage;
import sales.qa.pages.SalesPage;

public class PayablesTest extends TestBase  
{
	LoginPage LoginPage;
	SalesPage SalesPage;
	//ReceivablesPage ReceivablesPage;
	PurchasesPage PurchasePage;
	PayablesPage PayablesPage;
	InventoryPage inventoryPage;
	
	public PayablesTest()
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
		PurchasePage =new PurchasesPage();
		PayablesPage = new PayablesPage();
		inventoryPage = new InventoryPage();
		SalesPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		PayablesPage = PurchasePage.ClickPayables();
		System.out.println("BeforeMethod");
	}
	
	@Test(priority=1)
	public void ValidateTitle()
	{
		String PayableTitle = PayablesPage.PayablesvalidateTitle();
		System.out.println("Validate Payable Page title:" +PayableTitle);
		System.out.println("priority=1");
		Assert.assertEquals(PayableTitle,"webERP - Main Menu","Payable Page Title No match.");
	}
	
	@Test(priority=2)
	public void ValidateTransactionTitle()
	{
		Boolean Transaction = PayablesPage.PayablesTransactiontitle();
		System.out.println("priority=2");
		System.out.println("Validate Payable TransactionTitle :" +Transaction);
		Assert.assertEquals(true, Transaction,"Payable Transaction Title no match");
		
	}
	
	@Test(priority=3)
	public void ValidateTransacList()
	{
		PayablesPage.PayablesVerifyTransactionelements();
		System.out.println("priority=3");
		
	}
	
	@Test(priority=4)
	public void ValidateInquiriesTitle()
	{
		boolean Inquiries = PayablesPage.PayablesInquiries();
		System.out.println("Validate Payable InquiriesTitle :" +Inquiries);
		System.out.println("priority=4");
		Assert.assertEquals(true,Inquiries,"Payable Inquiries Title No match");
	}
	
	@Test(priority=5)
	public void ValidateInquiriesList()
	{
		PayablesPage.PayablesVerifyInquiriesList();
		 System.out.println("priority=5");
		
	}
	
	@Test(priority=6)
	public void ValidateCustomRptstitle()
	{
		boolean Customrpts = PayablesPage.PayablesCustomreportsTitle();
		System.out.println("ValidateCustomRptstitle :" +Customrpts);
		System.out.println("priority=6");
		Assert.assertEquals(true, Customrpts,"Payable Custom Reports Title no Match");
	}
	
	@Test(priority=7)
	public void ValidateStdRptsTitle()
	{
		boolean StdRpts = PayablesPage.PayablesStandardRepotsTitle();
		System.out.println("ValidateStdRptsTitle :" +StdRpts);
		System.out.println("priority=7");
		Assert.assertEquals(true,StdRpts,"Payable Std Rpts title no match");
	}
	
	@Test(priority=8)
	public void ValidateMaintenceTitle()
	{
		boolean Maintenance = PayablesPage.PayablesMaintenanceTitle();
		System.out.println("ValidateMaintenceTitle :" +Maintenance);
		System.out.println("priority=8");
		Assert.assertEquals(true,Maintenance,"Payable Maintenance Title No Match.");
	}
	
	@Test(priority=9)
	public void ValidateMaintenanceList()
	{
		PayablesPage.PayablesMaintenanceList();
		System.out.println("priority=9");
	}
	
	public void InventoryClick()
	{
		inventoryPage = PayablesPage.ClickInventory();
		
	}
	
	
	  @AfterMethod
	  public void teardown() { driver.quit(); 
	  System.out.println("AfterMethod");}
	 
	 


}
