package com.comcast.crm.objectrepositoryutility;
/**
 *@author aditya
 * Contains Web elements and  for ManageUsers Page
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUsersPage {

	WebDriver driver;
	public ManageUsersPage(WebDriver driver) {            
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[text()='Admin | Manage Users']")//p[contains(text(),'data deleted !!')]
	private WebElement manageUserPageHeading;
	@FindBy(xpath = "//p[contains(text(),'data deleted !!')]")
	private WebElement datadeleted;
	
	
	
	public WebElement getManageUserPageHeading() {
		return manageUserPageHeading;
	}



	public WebElement getDatadeleted() {
		return datadeleted;
	}



	/**
	 * @author aditya
	 * @param user
	 * @throws InterruptedException
	 * Method to delete User for admin
	 */
	public void deleteUser(String user) throws InterruptedException
	{
		driver.findElement(By.xpath("//td[text()='"+user+"']/..//a[@tooltip='Remove']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}
	
	
}
