package com.comcast.crm.objectrepositoryutility;
/**
 * @author aditya
 *Contains Web elements and Business method for AdminAppoiuntmentHistory Page
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAppoiuntmentHistoryPage {

	WebDriver driver;
	public AdminAppoiuntmentHistoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//h1[text()='Patients  | Appointment History']")
	private WebElement appointmenthistoryHeader;
	public WebElement getAppointmenthistoryHeader() {
		return appointmenthistoryHeader;
	}
	
}
