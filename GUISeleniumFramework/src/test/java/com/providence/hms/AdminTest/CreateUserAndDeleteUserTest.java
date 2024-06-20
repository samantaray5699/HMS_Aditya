package com.providence.hms.AdminTest;
/**
 * @author aditya
 * Test Class for CreateUserAndDeleteUserTest// Admin Module
 */
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass_Aditya;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.AdminDashboardPage;
import com.comcast.crm.objectrepositoryutility.ManageUsersPage;
import com.comcast.crm.objectrepositoryutility.PatientDashboardPage;
import com.comcast.crm.objectrepositoryutility.PatientLoginPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateUserAndDeleteUserTest extends BaseClass_Aditya{

	@Test
	public void verifyCreateUserAndDeleteUserByAdmin() throws Throwable
	{
		/*Logging out as admin*/
		configAM();

		String name=eLib.getDataFromExcel("Admin", 8, 2)+jLib.getRandomNumber();
		String adress=eLib.getDataFromExcel("Admin", 8, 3);
		String city=eLib.getDataFromExcel("Admin", 8, 4);
		String email=eLib.getDataFromExcel("Admin", 8, 5)+jLib.getRandomNumber();
		String pass=eLib.getDataFromExcel("Admin", 8, 6);
		/*Creating and Logging in as a patient*/
		PatientLoginPage pl= new PatientLoginPage(driver);
		pl.createNewUser(name, adress, city, email, pass);
		pl.patientLogin(email, pass);
		PatientDashboardPage pdp= new PatientDashboardPage(driver);
		String header1 = pdp.getUserDashboardHeader().getText();
		assertEquals(header1,"USER | DASHBOARD");
		Reporter.log("USER | DASHBOARD is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "USER | DASHBOARD is displayed");
		/*Logging out as patient*/
		pdp.patientlogout();
		/*Logging in as Admin*/
		configBM();
		AdminDashboardPage adp= new AdminDashboardPage(driver);
		String header2=adp.getAdminDashboard().getText();
		assertEquals(header2,"ADMIN | DASHBOARD");
		Reporter.log("ADMIN | DASHBOARD is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "ADMIN | DASHBOARD is displayed");
		/*Navigatong to User Session Logs Link*/
		adp.getUserSessionlogsLink().click();
		String usersessionurl = driver.getCurrentUrl();
		String ussersessionacturl = eLib.getDataFromExcel("Admin", 8, 7);
		assertEquals(usersessionurl,ussersessionacturl);
		Reporter.log("User Session logs page displayed",true);
		boolean user = driver.findElement(By.xpath("//td[text()='"+email+"']")).isDisplayed();
		assertTrue(user);
		Reporter.log("User displayed in userssession logs",true);
		UtilityClassObject.getTest().log(Status.INFO, "User displayed in userssession logs");

		/*Navigating to Manage User Link*/
		adp.getUsersdropdown().click();
		adp.getManageuserslnk().click();
		ManageUsersPage mu= new ManageUsersPage(driver);
		String header3=mu.getManageUserPageHeading().getText();
		assertEquals(header3,"ADMIN | MANAGE USERS");
		Reporter.log("ADMIN | MANAGE USERS",true);
		UtilityClassObject.getTest().log(Status.INFO, "ADMIN | MANAGE USERS");
		/*Deleting the User*/
		mu.deleteUser(name);
		String msg= mu.getDatadeleted().getText();
		assertEquals(msg,"data deleted !!");
		Reporter.log("Data deleted !! is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "Data deleted !! is displayed");
		/*Logging out as Admin*/
		configAM();
		/*Logging in as Deleted User and verifying User deleted or not*/
		pl.patientLogin(email, pass);	
		String header4 = pl.getPatientloginheader().getText();
		assertEquals(header4,"HMS | Patient Login");
		Reporter.log("HMS | Patient Login is present means it not loged in as user",true);
		UtilityClassObject.getTest().log(Status.INFO, "HMS | Patient Login is present means it not loged in as user");
		WebDriverUtility wlib1= new WebDriverUtility();
		wlib1.switchToTabOnURL(driver, "/AppServer/Hospital_Doctor_Patient_Management_System/index.php");	
		configBM();
	}
}
