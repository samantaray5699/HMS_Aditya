package com.comcast.crm.objectrepositoryutility;
/**
 *@author aditya
 * Contains Web elements and  for PatientLogin Page
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class PatientLoginPage extends WebDriverUtility{

	WebDriver driver;
	public PatientLoginPage(WebDriver driver) {            
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Create an account')]")
	private WebElement createanaccountLink;

	@FindBy(name ="full_name")
	private WebElement fullnameEdt;
	@FindBy(name ="address")
	private WebElement addressEdt;
	@FindBy(name ="city")
	private WebElement cityEdt;
	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement gender;
	@FindBy(name ="email")
	private WebElement emailEdt;
	@FindBy(name ="password")
	private WebElement passwordEdt;


	@FindBy(name ="password_again")
	private WebElement password_againEdt;
	@FindBy(id = "submit")
	private WebElement submitbtn;
	@FindBy(name ="username")
	private WebElement usernameEdt;
	@FindBy(name ="password")
	private WebElement passworddEdt;
	@FindBy(name ="submit")
	private WebElement loginbtn;
	
	@FindBy(xpath = "//h2[text()=' HMS | Patient Login']")
	private WebElement patientloginheader;
	

	
	public WebElement getPatientloginheader() {
		return patientloginheader;
	}
	
	/**
	 * @author aditya
	 * @param username
	 * @param pass
	 * Mehtod for Patient Login
	 */
	public void patientLogin(String username, String pass)
	{
		HomePage hp= new HomePage(driver);
		hp.getPatientclickherebtn().click();
		switchToTabOnTitle(driver, "user");
		usernameEdt.sendKeys(username);
		passworddEdt.sendKeys(pass);
		loginbtn.click();
		
	}
	public void createNewUser(String fullname,String address, String city, String email, String pass)
	{
		HomePage hp= new HomePage(driver);
		hp.getPatientclickherebtn().click();
		switchToTabOnTitle(driver, "user");
		createanaccountLink.click();
		fullnameEdt.sendKeys(fullname);
		addressEdt.sendKeys(address);
		cityEdt.sendKeys(city);
		gender.click();
		emailEdt.sendKeys(email);
		passwordEdt.sendKeys(pass);
		password_againEdt.sendKeys(pass);
		submitbtn.click();
		switchtoAlertAndAccept(driver);
		switchToTabOnURL(driver, "http://49.249.28.218:8081/AppServer/Hospital_Doctor_Patient_Management_System/");
	}
}