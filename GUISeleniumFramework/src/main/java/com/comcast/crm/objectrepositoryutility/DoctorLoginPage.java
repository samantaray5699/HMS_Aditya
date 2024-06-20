package com.comcast.crm.objectrepositoryutility;
/**
 * @author aditya
 * Contains Web elements and Business method for DoctorLogin Page
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class DoctorLoginPage extends WebDriverUtility {

	WebDriver driver;
	public DoctorLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "username")
	private WebElement usernameEdt;
	
	@FindBy(name = "password")
	private WebElement passwordEdt;
	
	@FindBy(name = "submit")
	private WebElement loginbtn;
	/**
	 * @author aditya
	 * @param username
	 * @param pass
	 * Merhod for login as doctor
	 */
	public void docLogin(String username, String pass)
	{
		HomePage hp= new HomePage(driver);
		hp.getDocclickherebtn().click();
		switchToTabOnTitle(driver, "doctor");
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(pass);
		loginbtn.click();
		
	}
}
