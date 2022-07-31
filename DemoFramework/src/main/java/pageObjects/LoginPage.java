package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage     {

	public WebDriver driver;
	@FindBy(xpath = "//a[@class='btn btn-dark btn-lg'][1]")
	public WebElement MakeAppointment;
	
	@FindBy(xpath = "(//input[@placeholder='Username'])[2]")
	public WebElement userName;

	@FindBy(xpath = "(//input[@placeholder='Password'])[2]")
	public WebElement password;

	@FindBy(css = "#btn-login")
	public WebElement loginButton;
	
	@FindBy(xpath = "//p[@class='lead']")
	public WebElement AppointmentConfirmation;
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void MakeAppointment() {
		MakeAppointment.click();
	}

	public void setUserName(String strUserName) {
		userName.sendKeys(strUserName);
	}

	 void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}

	public void clickLogin() throws InterruptedException {
		loginButton.click();
	}

	public void loginApp(String strUserName, String strPasword) throws InterruptedException {
		MakeAppointment();
		setUserName(strUserName);
		setPassword(strPasword);
		clickLogin();
		Thread.sleep(3000);
	}


}


 