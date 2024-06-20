package com.comcast.crm.objectrepositoryutility;
/**
 * @author aditya
 * Contains Web elements and  for Home Page
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility{                             

	WebDriver driver;
	public HomePage(WebDriver driver) {            
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='assets/images/admin.jpg']/.. //button[text()='Click Here']")                        
	private WebElement adminclickherebtn;
	
	@FindBy(xpath = "//img[@src='assets/images/patient.jpg']/.. //button[text()='Click Here']")                        
	private WebElement patientclickherebtn;
	
	@FindBy(xpath = "//img[@src='assets/images/doctor.jpg']/.. //button[text()='Click Here']")                        
	private WebElement docclickherebtn;
	@FindBy(name="fullname")                        
	private WebElement fullnametEdt;

	@FindBy(name="emailid")                        
	private WebElement emailtEdt;
	
	@FindBy(name="mobileno")                        
	private WebElement mobiletEdt;
	
	@FindBy(name="description")                        
	private WebElement descriptiontEdt;
	
	@FindBy(name="submit")                        
	private WebElement submitbtn;
	
	@FindBy(xpath = "//a[text()='About Us']")                        
	private WebElement aboutusLink;
	
	
	public WebDriver getDriver() {
		return driver;
	}
	

	public WebElement getAdminclickherebtn() {
		return adminclickherebtn;
	}

	public WebElement getPatientclickherebtn() {
		return patientclickherebtn;
	}

	public WebElement getDocclickherebtn() {
		return docclickherebtn;
	}

	public WebElement getFullnametEdt() {
		return fullnametEdt;
	}

	public WebElement getEmailtEdt() {
		return emailtEdt;
	}

	public WebElement getMobiletEdt() {
		return mobiletEdt;
	}

	public WebElement getDescriptiontEdt() {
		return descriptiontEdt;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}


	public WebElement getAboutusLink() {
		return aboutusLink;
	}
	

	
	
	

}
