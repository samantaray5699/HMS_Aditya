package com.comcast.crm.objectrepositoryutility;
/**
 * @author aditya
 * Contains Web elements and Business method for AdminDashboard Page
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {

	WebDriver driver;
	public AdminDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement admindropdown;

	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logoutlink;

	@FindBy(xpath = "//span[text()=' Users ']")
	private WebElement usersdropdown;

	@FindBy(xpath = "//span[text()=' Manage Users ']")
	private WebElement manageuserslnk;
	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement patientDropdown;

	@FindBy(xpath = "//span[text()=' Manage Patients ']")
	private WebElement managepatientlnk;

	@FindBy(xpath = "//h1[text()='Admin | Dashboard']")
	private WebElement adminDashboard;
	//span[contains(text(), 'Pages')]
	@FindBy(xpath = "//span[contains(text(), 'Pages')]")
	private WebElement pagesLink;
	@FindBy(xpath = "//span[contains(text(),'About Us')]")
	private WebElement aboutusLink;
	@FindBy(xpath = "//span[contains(text(),'User Session Logs')]")
	private WebElement userSessionlogsLink;
	
	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement AppoinmentHistoryLink;
	
	
	public WebElement getAdminDashboard() {
		return adminDashboard;
	}

	public WebElement getAdmindropdown() {
		return admindropdown;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}

	public WebElement getUsersdropdown() {
		return usersdropdown;
	}

	public WebElement getManageuserslnk() {
		return manageuserslnk;
	}


	public WebElement getPatientDropdown() {
		return patientDropdown;
	}

	public WebElement getManagepatientlnk() {
		return managepatientlnk;
	}

	public WebElement getPagesLink() {
		return pagesLink;
	}

	public WebElement getAboutusLink() {
		return aboutusLink;
	}
	

	public WebElement getUserSessionlogsLink() {
		return userSessionlogsLink;
	}
	

	public WebElement getAppoinmentHistoryLink() {
		return AppoinmentHistoryLink;
	}

	/**
	 * @author aditya
	 * method for log out as admin
	 */
	public void logout()
	{
		admindropdown.click();
		logoutlink.click();
	}

}
