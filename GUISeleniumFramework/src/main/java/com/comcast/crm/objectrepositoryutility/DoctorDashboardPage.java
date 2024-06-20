package com.comcast.crm.objectrepositoryutility;
/**
 * @author aditya
 * Contains Web elements and Business method for DoctorDashboard Page
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashboardPage {


	WebDriver driver;
	public DoctorDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement docDropdown;

	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logoutlink;
	@FindBy(xpath = "//span[contains(text(),'Patients')]")
	private WebElement patientsdropdown;
	@FindBy(xpath = "//span[contains(text(),'Add Patient')]")
	private WebElement addpatientLink;
	@FindBy(xpath = "//h1[text()='Doctor | Dashboard']")
	private WebElement doctordashboardHeder;

	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement appointmentHistoryLink;
	public WebElement getPatientsdropdown() {
		return patientsdropdown;
	}
	public WebElement getAddpatientLink() {
		return addpatientLink;
	}
	public WebElement getDoctordashboardHeder() {
		return doctordashboardHeder;
	}


	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getDocDropdown() {
		return docDropdown;
	}
	public WebElement getLogoutlink() {
		return logoutlink;
	}
	public WebElement getAppointmentHistoryLink() {
		return appointmentHistoryLink;
	}
	/**
	 * @author aditya
	 * Method for log out as doctor
	 */
	public void doctorlogout()
	{
		docDropdown.click();
		logoutlink.click();
	}

}

