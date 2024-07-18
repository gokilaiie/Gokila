package sales.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sales.qa.base.TestBase;
import sales.qa.pages.LoginPage;
import sales.qa.pages.SalesPage;
import sales.qa.pages.SetupPage;
import sales.qa.pages.UtilitiesPage;

public class UtilitiesTest extends TestBase
{
	LoginPage LoginPage;
	SalesPage SalesPage;
	SetupPage Setup;
	UtilitiesPage Utilities;
	
	public UtilitiesTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		LoginPage = new LoginPage();
	
		
		SalesPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Setup = new SetupPage();
		Utilities = Setup.ClickUtilities();
		System.out.println("BeforeMethod");
	}
	
	@Test(priority=1)
	public void ValidateTitle()
	{
		String VerifyTitle = Utilities.UtilitiesvalidateTitle();
		System.out.println("Validate Utilities Page title:" +VerifyTitle);
		System.out.println("priority=1");
		Assert.assertEquals(VerifyTitle,"webERP - Main Menu","Utilities Page Title No match.");
	}
	
	@Test(priority=2)
	public void ValidateTransactionTitle()
	{
		Boolean Transaction = Utilities.UtilitiesTransactiontitle();
		System.out.println("priority=2");
		System.out.println("Validate Utilities TransactionTitle :" +Transaction);
		Assert.assertEquals(true, Transaction,"Utilities Transaction Title no match");
		
	}
	
	@Test(priority=3)
	public void ValidateTransacList()
	{
		Utilities.UtilitiesVerifyTransactionelements();
		System.out.println("priority=3");
		
	}
	
	@Test(priority=4)
	public void ValidateInquiriesTitle()
	{
		boolean Inquiries = Utilities.UtilitiesInquiries();
		System.out.println("Validate Utilities InquiriesTitle :" +Inquiries);
		System.out.println("priority=4");
		Assert.assertEquals(true,Inquiries,"Inquiries Utilities Title No match");
	}
	
	@Test(priority=5)
	public void ValidateInquiriesList()
	{
		Utilities.UtilitiesVerifyInquiriesList();
		 System.out.println("priority=5");
		
	}
	
	@Test(priority=6)
	public void ValidateCustomRptstitle()
	{
		boolean Customrpts = Utilities.UtilitiesCustomreportsTitle();
		System.out.println("ValidateCustomRptstitle :" +Customrpts);
		System.out.println("priority=6");
		Assert.assertEquals(true, Customrpts,"Utilities Custom Reports Title no Match");
	}
	
	@Test(priority=7)
	public void ValidateStdRptsTitle()
	{
		boolean StdRpts = Utilities.UtilitiesStandardRepotsTitle();
		System.out.println("ValidateStdRptsTitle :" +StdRpts);
		System.out.println("priority=7");
		Assert.assertEquals(true,StdRpts,"Utilities Std Rpts title no match");
	}
	
	@Test(priority=8)
	public void ValidateMaintenceTitle()
	{
		boolean Maintenance = Utilities.UtilitiesMaintenanceTitle();
		System.out.println("ValidateMaintenceTitle :" +Maintenance);
		System.out.println("priority=8");
		Assert.assertEquals(true,Maintenance,"Utilities Maintenance Title No Match.");
	}
	
	@Test(priority=9)
	public void ValidateMaintenanceList()
	{
		Utilities.UtilitiesMaintenanceList();
		System.out.println("priority=9");
	}
	
	
	
	  @AfterMethod
	  public void teardown() { driver.quit(); 
	  System.out.println("AfterMethod");}



}
