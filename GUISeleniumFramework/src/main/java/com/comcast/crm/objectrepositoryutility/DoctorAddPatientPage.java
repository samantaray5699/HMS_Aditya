package com.comcast.crm.objectrepositoryutility;
/**
 * @author aditya
 * Contains Web elements and Business method for DoctorAddPatient Page
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorAddPatientPage {

	WebDriver driver;
	public DoctorAddPatientPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//h1[text()='Patient | Add Patient']")
	private WebElement addpatientHeader;
	
	@FindBy(name = "patname")
	private WebElement patientnameEdt;
	@FindBy(name = "patcontact")
	private WebElement patientcontactEdt;
	@FindBy(name = "patemail")
	private WebElement patientemailEdt;
	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement gender;
	
	@FindBy(name = "pataddress")
	private WebElement patientadsressEdt;
	
	@FindBy(name = "patage")
	private WebElement patientageEdt;
	
	@FindBy(name = "medhis")
	private WebElement patientmedhistoryEdt;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	public WebElement getAddpatientHeader() {
		return addpatientHeader;
	}

	public void setAddpatientHeader(WebElement addpatientHeader) {
		this.addpatientHeader = addpatientHeader;
	}
/**
 * @author aditya
 * @param name
 * @param contact
 * @param email
 * @param add
 * @param age
 * @param his
 * Method to add patient as doctor
 */
	public void doctorAddPatient(String name,String contact,String email,String add, String age,String his)
	{
		patientnameEdt.sendKeys(name);
		patientcontactEdt.sendKeys(contact);
		patientemailEdt.sendKeys(email);
		patientadsressEdt.sendKeys(add);
		patientageEdt.sendKeys(age);
		patientmedhistoryEdt.sendKeys(his);
		submitBtn.click();
	}
}
