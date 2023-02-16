package Pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	static By txtUserName = By.name("username");
	static By txtpassword = By.name("password");
	static By btnLogin    = By.cssSelector("button[type='submit']");
	static By txtError    = By.xpath("(//div[@class='oxd-form-row']//span)[1]");
	static By txtInvalidError = By.xpath("(//div[@class='orangehrm-login-form']//p)[1]");
	
	
	public LoginPage()
	{
		super();
		
	}
	
	public static void enterUserName(String un)
	{
		Util.Utilities.enterText(txtUserName,un);
	}
	public static void enterPassword(String pwd)
	{
		Util.Utilities.enterText(txtpassword, pwd);
	}
	public static void clickOnLoginBtn()
	{
		Util.Utilities.clickOnElement(btnLogin);
		 
	}
	public LandingPage LoginToAppl(String un, String pwd)
	{
		enterUserName(un);
		enterPassword(pwd);
		clickOnLoginBtn();
		return new LandingPage();
	}
	
	public String getErrorMsg()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		return wait.until(ExpectedConditions.presenceOfElementLocated(txtError)).getText();
	}
	
	public String getErrorMsgForInvalidCredentials()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		return wait.until(ExpectedConditions.presenceOfElementLocated(txtInvalidError)).getText();
	}
}
