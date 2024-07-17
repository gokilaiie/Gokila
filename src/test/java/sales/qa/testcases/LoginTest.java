package sales.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sales.qa.base.TestBase;
import sales.qa.pages.LoginPage;
import sales.qa.pages.SalesPage;

public class LoginTest extends TestBase
{
	LoginPage LoginPage;
	SalesPage SalesPage;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		LoginPage = new LoginPage();
		
	}
	@Test(priority = 1)
	public void LoginPageTitleTest()
	{
		String Title = LoginPage.validatelogintitle();
		Assert.assertEquals(Title, "webERP Login screen");
	}
	
	@Test(priority = 2)
	public void LogoTest()
	{
		Boolean Logo = LoginPage.validatelogo();
		Assert.assertEquals(true, Logo);	
	}
	
	@Test(priority = 3)
	public void Login()
	{
		SalesPage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	 @AfterMethod 
	 public void teardown() { driver.quit(); } 
	 
	

}
