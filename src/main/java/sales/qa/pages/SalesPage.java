package sales.qa.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sales.qa.base.TestBase;

public class SalesPage extends TestBase 
{
	@FindBy(xpath = "//b[normalize-space()='Transactions']")
	WebElement Transactions;
	
	
	
	
	List <WebElement> TransactionList = driver.findElements(By.xpath(".//body/section[@class='MainBody clearfix']/fieldset[1]/ul[1]/li"));
	
	@FindBy(xpath = "//b[normalize-space()='Inquiries and Reports']")
	WebElement Inquiries;
	
	List<WebElement> InquirieList = driver.findElements(By.xpath(".//body/section[@class='MainBody clearfix']/fieldset[2]/ul/li"));
	
	@FindBy(xpath = "//b[normalize-space()='Standard Reports and Forms']")
	WebElement StdRpts;
	
	@FindBy(xpath = "//b[normalize-space()='Custom Reports']")
	WebElement CustomReports;
	
	@FindBy(xpath = "//b[normalize-space()='Maintenance']")
	WebElement Maintenance;
	
	List<WebElement> MaintList = driver.findElements(By.xpath(".//body/section[@class='MainBody clearfix']/fieldset[3]/ul/li"));
	
	@FindBy (xpath = "//a[normalize-space()='Receivables']")
	WebElement Receivablespage;
	
	//Initializing all web elements
	public SalesPage()
	{
		PageFactory.initElements(driver, this );
	}
	
	
	//Actions
	public String validatesalespagetitle()
	{
		return driver.getTitle();
		
	}
	//Transaction title and List
	public boolean  validatetransactiontitle()
	{
		return Transactions.isDisplayed();
	}
	
	public void validatetransactionlist()
	{
		List<String> Actuallist = Arrays.asList("New Sales Order or Quotation","Enter Counter Sales","Enter Counter Returns","Generate/Print Picking Lists",
											"Outstanding Sales Orders/Quotations","Special Order"," Recurring Order Template"," Process Recurring Orders",
											"Maintain Picking Lists");
		
		if (TransactionList.size()!=0)
		{
				for (WebElement webElement : TransactionList) 
				{
					for(int i=0;i<Actuallist.size();i++)
					{
						if( webElement.getText().contains(Actuallist.get(i)))
						{
							String Transact = webElement.getText().replace("•", "");
							System.out.println("TransactionList :" + Transact.trim());
							System.out.println("Assertion");
							Assert.assertEquals(Transact.trim(), Actuallist.get(i).trim());
							
							
							
						}
					}
					
				}
				
		}
			
	}
	
	//Inquiries title and List
	public boolean validateinquiriesandreportstitle()
	{
		return Inquiries.isDisplayed();
	}
	
	public void validateinquirieslist()
	{
		List<String> Actuallist = Arrays.asList("Sales Order Inquiry","Print Price Lists","Order Status Report","Orders Invoiced Reports",
											"Daily Sales Inquiry","Sales By Sales Type Inquiry","Sales By Category Inquiry","Sales By Category By Item Inquiry",
											"Sales Analysis Reports","Sales Graphs","Top Sellers Inquiry","Order Delivery Differences Report","Delivery In Full On Time (DIFOT) Report",
											"Sales Order Detail Or Summary Inquiries","Top Sales Items Inquiry","Top Customers Inquiry","Worst Sales Items Report","Sales With Low Gross Profit Report",
											"Sell Through Support Claims Report","Sales to Customers","Standard Reports and Forms","There are no reports to show!",
											"Custom Reports","There are no reports to show!");
		
		if (InquirieList.size()!=0)
		{
			for (WebElement webElement: InquirieList) 
			{
				for(int i=0; i< Actuallist.size();i++)
				{
					if( webElement.getText().trim().contains(Actuallist.get(i)))
					{
						String Inquirie = webElement.getText().replace("•", "");
						System.out.println("Inquirie List :" + Inquirie.trim());
						Assert.assertEquals( Inquirie.trim(),Actuallist.get(i).trim());
						System.out.println("Assertion");
					}
					
				}
			}
		}
			
	}
	
	//Standard Reports and Forms
	public boolean validatestdrptsandfrmstitle()
	{
		return StdRpts.isDisplayed();
	}
	
	//CustomReports
	public boolean validatecustomrptstitle()
	{
		return CustomReports.isDisplayed();
	}
	
	//Maintenance
	public boolean validatemaintenancetitle()
	{
		return Maintenance.isDisplayed();
	}
	
	public void validatemaintenancelist()
	{
		List<String> actuallist = Arrays.asList("Create Contract","Select Contract","Sell Through Support Deals");
		
		if (MaintList.size()!=0)
		{
			for (WebElement webElement: MaintList) 
			{
				for(int i=0; i< actuallist.size();i++)
				{
					if( webElement.getText().trim().contains(actuallist.get(i)))
					{
						String Maintenance = webElement.getText().replace("•", "");
						System.out.println("MaintList :" + Maintenance.trim());
						Assert.assertEquals( Maintenance.trim(), actuallist.get(i).trim());
						System.out.println("Assertion");
						
					}
				
				}
			}
		}
			
	}
	
	public ReceivablesPage ClickReceivables()
	{
		Receivablespage.click();
		return new ReceivablesPage();
		
	}
}
