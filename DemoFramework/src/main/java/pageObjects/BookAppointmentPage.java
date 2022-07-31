package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BookAppointmentPage {

	public WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='dd/mm/yyyy']")
	public WebElement Calender;

	@FindBy(xpath = "div[class='datepicker-days'] th[class='prev']")
	public WebElement BackwardButton;

	@FindBy(xpath = "(//th[@class='next'])[1]")
	public WebElement ForwardButton;

	@FindBy(xpath = "//td[@class='day']")
	public List<WebElement> Date;

	@FindBy(xpath = "//textarea[@placeholder='Comment']")
	public WebElement CommentBox;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	public WebElement BookAppointmentButton;

	@FindBy(xpath = "//select[@class='form-control']")
	public WebElement Facility;

	@FindBy(xpath = "//select[@class='form-control']/option")
	public List<WebElement> ListOfFacility;

	@FindBy(id = "//label[@class='radio-inline']//input")
	public List<WebElement> HealthcareProgramRadioButton;

	@FindBy(xpath = "//p[@class='lead']")
	public WebElement AppointmentConfirmation;

	public BookAppointmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateBookAppointmentWithPreviousDate(String message) {
		boolean status = false;
		Calender.click();
		// BackwardButton.click();
		// Date.get(5).click();
		selectcalender();
		clickBookAppointmentButton();
		status &= AppointmentConfirmation.getText().equalsIgnoreCase(message);
		return status;

	}

	public void FacilityDropDown() {
		Facility.click();
	}

	public void SelectFacility() throws InterruptedException {
		Thread.sleep(2000);
		ListOfFacility.get(1).click();
		Facility.click();

	}

	public void SelectHealthcareProgram() {
		HealthcareProgramRadioButton.get(1).click();
	}

	public void selectcalender() {
		Calender.click();
		ForwardButton.click();
		Date.get(11).click();
	}

	public void AddComment(String comment) {
		CommentBox.sendKeys(comment);
	}

	public void clickBookAppointmentButton() {
		BookAppointmentButton.click();
	}

	public void ConfirmBookAppointment(String usercomment) throws InterruptedException {

		FacilityDropDown();
		SelectFacility();
		selectcalender();
		AddComment(usercomment);
		clickBookAppointmentButton();

	}

	public boolean validatingAppointmentConfirmation(String message) {
		boolean status = true;

		status &= AppointmentConfirmation.getText().equalsIgnoreCase(message);
		return status;
	}
}
