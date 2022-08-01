package TestCases;

import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.BookAppointmentPage;


import pageObjects.LoginPage;
import resources.SendEmail;
import resources.TestBase;

public class TC extends TestBase {
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	public WebDriver driver;
	

	@BeforeTest
	public void initialize() throws IOException {
		driver = browserSetUp();

	}


	@Test(priority = 1, description = "Login Functionality")
	public void validatelogin() throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
	
		lp.loginApp(prop.getProperty("userName"), prop.getProperty("passWord"));

	}
	
	@Test(priority = 2, description = "Validate Booking Confirmation")
	public void validateBookingConfirmation() throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.loginApp(prop.getProperty("userName"), prop.getProperty("passWord"));
		BookAppointmentPage ba = new BookAppointmentPage(driver);
		ba.ConfirmBookAppointment("Appointment confirmation");
		Assert.assertTrue(ba.validatingAppointmentConfirmation("Please be informed that your appointment has been booked as following:"));

	}
	

	@Test(priority = 3, description = "Validate Booking Confirmation without Date Selection")
	public void validateBookingConfirmationWithoutDate() throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.loginApp(prop.getProperty("userName"), prop.getProperty("passWord"));
		BookAppointmentPage ba = new BookAppointmentPage(driver);
		Assert.assertFalse(ba.validateBookAppointmentWithPreviousDate("Please be informed that your appointment has been booked as following:"));
	
	}
	
	
	@AfterTest
	public void tearDown(ITestResult result) throws EmailException {
	
		if(result.getStatus() == ITestResult.FAILURE)
		{
			SendEmail.sendEmail();
		}
		driver.close();
		
	}

}
