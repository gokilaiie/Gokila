package sales.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sales.qa.base.TestBase;
import sales.qa.pages.LoginPage;
import sales.qa.pages.PurchasesPage;
import sales.qa.pages.ReceivablesPage;
import sales.qa.pages.SalesPage;

public class ReceivablesTest extends TestBase 
{
	LoginPage LoginPage;
	SalesPage SalesPage;
	ReceivablesPage ReceivablesPage;
	PurchasesPage PurchasePage;
	
	public ReceivablesTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		SalesPage = new SalesPage();
		LoginPage = new LoginPage();
		ReceivablesPage = new ReceivablesPage();
		PurchasePage =new PurchasesPage();
		SalesPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		ReceivablesPage = SalesPage.ClickReceivables();
		System.out.println("BeforeMethod");
	}
	
	@Test(priority=1)
	public void ValidateTitle()
	{
		String ReceivablPage = ReceivablesPage.ReceivablesvalidateTitle();
		System.out.println("Validate title:" +ReceivablPage);
		System.out.println("priority=1");
		Assert.assertEquals(ReceivablPage,"webERP - Main Menu","Receivable Page Title Not match");
	}
	
	@Test(priority=2)
	public void ValidateTransactionTitle()
	{
		Boolean Transaction = ReceivablesPage.ReceivablesTransactiontitle();
		System.out.println("priority=2");
		System.out.println("ValidateTransactionTitle :" +Transaction);
		Assert.assertEquals(true, Transaction,"Receivalbes Transaction no match");
		
	}
	
	@Test(priority=3)
	public void ValidateTransacList()
	{
		ReceivablesPage.ReceivablesVerifyTransactionelements();
		System.out.println("priority=3");
		
	}
	
	@Test(priority=4)
	public void ValidateInquiriesTitle()
	{
		boolean Inquiries = ReceivablesPage.ReceivablesInquiries();
		System.out.println("ValidateInquiriesTitle :" +Inquiries);
		System.out.println("priority=4");
		Assert.assertEquals(true,Inquiries,"Receivables Inquiries No match");
	}
	
	@Test(priority=5)
	public void ValidateInquiriesList()
	{
		 ReceivablesPage.ReceivablesVerifyInquiriesList();
		 System.out.println("priority=5");
		
	}
	
	@Test(priority=6)
	public void ValidateCustomRptstitle()
	{
		boolean Customrpts = ReceivablesPage.ReceivablesCustomreportsTitle();
		System.out.println("ValidateCustomRptstitle :" +Customrpts);
		System.out.println("priority=6");
		Assert.assertEquals(true, Customrpts,"Receivables Custom Reports Title no Match");
	}
	
	@Test(priority=7)
	public void ValidateStdRptsTitle()
	{
		boolean StdRpts = ReceivablesPage.ReceivablesStandardRepotsTitle();
		System.out.println("ValidateStdRptsTitle :" +StdRpts);
		System.out.println("priority=7");
		Assert.assertEquals(true,StdRpts,"Receivable Std Rpts title no match");
	}
	
	@Test(priority=8)
	public void ValidateMaintenceTitle()
	{
		boolean Maintenance = ReceivablesPage.ReceivablesMaintenanceTitle();
		System.out.println("ValidateMaintenceTitle :" +Maintenance);
		System.out.println("priority=8");
		Assert.assertEquals(true,Maintenance,"Receivables Maintenance Title No Match.");
	}
	
	@Test(priority=9)
	public void ValidateMaintenanceList()
	{
		ReceivablesPage.ReceivablesMaintenanceList();
		System.out.println("priority=9");
	}
	
	public void PurchaseClick()
	{
		PurchasePage = ReceivablesPage.ClickPurchase();
	}
	
	
	  @AfterMethod
	  public void teardown() { driver.quit(); 
	  System.out.println("AfterMethod");}
	 
	 

}
