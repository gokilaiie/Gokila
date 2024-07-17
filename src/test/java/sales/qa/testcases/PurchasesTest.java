package sales.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sales.qa.base.TestBase;
import sales.qa.pages.LoginPage;
import sales.qa.pages.PayablesPage;
import sales.qa.pages.PurchasesPage;
import sales.qa.pages.ReceivablesPage;
import sales.qa.pages.SalesPage;

public class PurchasesTest extends TestBase 
{
	LoginPage LoginPage;
	SalesPage SalesPage;
	ReceivablesPage ReceivablesPage;
	PurchasesPage PurchasePage;
	PayablesPage PayablesPage;
	
	public PurchasesTest()
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
		PayablesPage = new PayablesPage();
		SalesPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		PurchasePage = ReceivablesPage.ClickPurchase();
		System.out.println("BeforeMethod");
	}
	
	@Test(priority=1)
	public void ValidateTitle()
	{
		String PurchasesTitle = PurchasePage.PurchasesvalidateTitle();
		System.out.println("Validate Purchase Page title:" +PurchasesTitle);
		System.out.println("priority=1");
		Assert.assertEquals(PurchasesTitle,"webERP - Main Menu","Purchase Page Title No match.");
	}
	
	@Test(priority=2)
	public void ValidateTransactionTitle()
	{
		Boolean Transaction = PurchasePage.PurchasesTransactiontitle();
		System.out.println("priority=2");
		System.out.println("Validate Purchase TransactionTitle :" +Transaction);
		Assert.assertEquals(true, Transaction,"Purchase Transaction Title no match");
		
	}
	
	@Test(priority=3)
	public void ValidateTransacList()
	{
		PurchasePage.PurchasesVerifyTransactionelements();
		System.out.println("priority=3");
		
	}
	
	@Test(priority=4)
	public void ValidateInquiriesTitle()
	{
		boolean Inquiries = PurchasePage.PurchasesInquiries();
		System.out.println("Validate Purchase InquiriesTitle :" +Inquiries);
		System.out.println("priority=4");
		Assert.assertEquals(true,Inquiries,"Purchase Inquiries Title No match");
	}
	
	@Test(priority=5)
	public void ValidateInquiriesList()
	{
		PurchasePage.PurchasesVerifyInquiriesList();
		 System.out.println("priority=5");
		
	}
	
	@Test(priority=6)
	public void ValidateCustomRptstitle()
	{
		boolean Customrpts = PurchasePage.PurchasesCustomreportsTitle();
		System.out.println("ValidateCustomRptstitle :" +Customrpts);
		System.out.println("priority=6");
		Assert.assertEquals(true, Customrpts,"Purchase Custom Reports Title no Match");
	}
	
	@Test(priority=7)
	public void ValidateStdRptsTitle()
	{
		boolean StdRpts = PurchasePage.PurchasesStandardRepotsTitle();
		System.out.println("ValidateStdRptsTitle :" +StdRpts);
		System.out.println("priority=7");
		Assert.assertEquals(true,StdRpts,"Purchase Std Rpts title no match");
	}
	
	@Test(priority=8)
	public void ValidateMaintenceTitle()
	{
		boolean Maintenance = PurchasePage.PurchasesMaintenanceTitle();
		System.out.println("ValidateMaintenceTitle :" +Maintenance);
		System.out.println("priority=8");
		Assert.assertEquals(true,Maintenance,"Purchase Maintenance Title No Match.");
	}
	
	@Test(priority=9)
	public void ValidateMaintenanceList()
	{
		PurchasePage.PurchasesMaintenanceList();
		System.out.println("priority=9");
	}
	
	public void PayablesClick()
	{
		PayablesPage = PurchasePage.ClickPayables();
		
	}
	
	
	  @AfterMethod
	  public void teardown() { driver.quit(); 
	  System.out.println("AfterMethod");}
	 
	 


}
