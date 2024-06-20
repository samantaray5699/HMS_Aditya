package com.comcast.crm.objectrepositoryutility;
/**
 *@author aditya
 * Contains Web elements and  for PatientBookAppointment Page
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class PatientBookAppointmentPage extends WebDriverUtility {


	WebDriver driver;
	public PatientBookAppointmentPage(WebDriver driver) {            
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h1[text()='User | Book Appointment']")
	private WebElement bookappointmentHeader;
	@FindBy(name = "Doctorspecialization")
	private WebElement doctorSpeciializationDropdown;
	@FindBy(name = "doctor")
	private WebElement doctorsDropdown;
	@FindBy(name = "appdate")
	private WebElement appdate;
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	public WebElement getBookappointmentHeader() {
		return bookappointmentHeader;
	}
	

	public WebElement getDoctorSpeciializationDropdown() {
		return doctorSpeciializationDropdown;
	}


	public WebElement getDoctorsDropdown() {
		return doctorsDropdown;
	}


	public WebElement getAppdate() {
		return appdate;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}


	/**
	 * 
	 * @param doctorspecialization
	 * @param doctorname
	 * @param date
	 * @throws InterruptedException
	 * Method to book an appointment as patient
	 */
	public void bookAppointment(String doctorspecialization, String doctorname, String date) throws InterruptedException
	{
	  select(doctorSpeciializationDropdown, doctorspecialization);
	  select(doctorsDropdown, doctorname);
	  appdate.sendKeys(date);
	  submitBtn.click();
	  switchtoAlertAndAccept(driver);
	}


}
