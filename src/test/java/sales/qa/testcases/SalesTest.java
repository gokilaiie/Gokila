package sales.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sales.qa.base.TestBase;
import sales.qa.pages.LoginPage;
import sales.qa.pages.ReceivablesPage;
import sales.qa.pages.SalesPage;

public class SalesTest extends TestBase
{
	LoginPage LoginPage;
	SalesPage SalesPage;
	ReceivablesPage ReceivablesPage;
	
	public SalesTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		LoginPage = new LoginPage();
		
		SalesPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
		ReceivablesPage = new ReceivablesPage();
		System.out.println("BeforeMethod");
	}
	
	@Test(priority=1)
	public void ValidateTitle()
	{
		String SalespageTitle = SalesPage.validatesalespagetitle();
		System.out.println("Validate title:" +SalespageTitle);
		System.out.println("priority=1");
		Assert.assertEquals(SalespageTitle,"webERP - Main Menu");
	}
	
	@Test(priority=2)
	public void ValidateTransactionTitle()
	{
		Boolean Transaction = SalesPage.validatetransactiontitle();
		System.out.println("priority=2");
		System.out.println("ValidateTransactionTitle :" +Transaction);
		Assert.assertEquals(true, Transaction);
		
	}
	
	@Test(priority=3)
	public void ValidateTransacList()
	{
		SalesPage.validatetransactionlist();
		System.out.println("priority=3");
		
	}
	
	@Test(priority=4)
	public void ValidateInquiriesTitle()
	{
		boolean Inquiries = SalesPage.validateinquiriesandreportstitle();
		System.out.println("ValidateInquiriesTitle :" +Inquiries);
		System.out.println("priority=4");
		Assert.assertEquals(true,Inquiries);
	}
	
	@Test(priority=5)
	public void ValidateInquiriesList()
	{
		 SalesPage.validateinquirieslist();
		 System.out.println("priority=5");
		
	}
	
	@Test(priority=6)
	public void ValidateCustomRptstitle()
	{
		boolean Customrpts = SalesPage.validatecustomrptstitle();
		System.out.println("ValidateCustomRptstitle :" +Customrpts);
		System.out.println("priority=6");
		Assert.assertEquals(true, Customrpts);
	}
	
	@Test(priority=7)
	public void ValidateStdRptsTitle()
	{
		boolean StdRpts = SalesPage.validatecustomrptstitle();
		System.out.println("ValidateStdRptsTitle :" +StdRpts);
		System.out.println("priority=7");
		Assert.assertEquals(true,StdRpts);
	}
	
	@Test(priority=8)
	public void ValidateMaintenceTitle()
	{
		boolean Maintenance = SalesPage.validatemaintenancetitle();
		System.out.println("ValidateMaintenceTitle :" +Maintenance);
		System.out.println("priority=8");
		Assert.assertEquals(true,Maintenance);
	}
	
	@Test(priority=9)
	public void ValidateMaintenanceList()
	{
		SalesPage.validatemaintenancelist();
		System.out.println("priority=9");
	}
	
	public void ClickReceivables()
	{
		ReceivablesPage = SalesPage.ClickReceivables();
	}
	
	  @AfterMethod
	  public void teardown() { driver.quit(); 
	  System.out.println("AfterMethod");}
	 
	 
}
