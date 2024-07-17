package sales.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sales.qa.base.TestBase;

public class LoginPage extends TestBase
{
	//Page Factory or OR	
	@FindBy(id="login_logo")
	WebElement logo;
	
	@FindBy(name="UserNameEntryField")
	WebElement username;
		
	@FindBy(name="Password")
	WebElement password;
		
	@FindBy(name="SubmitUser")
	WebElement loginbtn;
		
	//Initializing all Web elements
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String validatelogintitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean validatelogo()
	{
		return logo.isDisplayed();
		
	}
	
	public SalesPage Login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new SalesPage();
	}
}
