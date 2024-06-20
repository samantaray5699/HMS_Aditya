package com.providence.hms.AdminTest;
/**
 * @author aditya
 * Test Class for DeleteUserTest// Admin Module
 */

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass_Aditya;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.AdminDashboardPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ManageUsersPage;
import com.comcast.crm.objectrepositoryutility.PatientLoginPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class DeleteUserTest extends BaseClass_Aditya {

	@Test
	public void verifyAdminIsAbleTodeleteUser() throws Throwable
	{
		String name=eLib.getDataFromExcel("Admin", 1, 2)+jLib.getRandomNumber();
		String adress=eLib.getDataFromExcel("Admin", 1, 3);
		String city=eLib.getDataFromExcel("Admin", 1, 4);
		String email=eLib.getDataFromExcel("Admin", 1, 5)+jLib.getRandomNumber();;
		String pass=eLib.getDataFromExcel("Admin", 1, 6);	
        /*Logging out as Admin*/
		configAM();
		/*Creating new User*/
		PatientLoginPage pl= new PatientLoginPage(driver);
		pl.createNewUser(name, adress, city, email, pass);
		/*Logging in as Admin*/
		configBM();
		AdminDashboardPage adp= new AdminDashboardPage(driver);
		String header1=adp.getAdminDashboard().getText();
		assertEquals(header1,"ADMIN | DASHBOARD");
		Reporter.log("ADMIN | DASHBOARD is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "ADMIN | DASHBOARD is displayed");
		/*Navigating to manageusers page*/
		adp.getUsersdropdown().click();
		adp.getManageuserslnk().click();
		ManageUsersPage mu= new ManageUsersPage(driver);
		String header2=mu.getManageUserPageHeading().getText();
		assertEquals(header2,"ADMIN | MANAGE USERS");
		Reporter.log("ADMIN | MANAGE USERS",true);
		UtilityClassObject.getTest().log(Status.INFO, "ADMIN | DASHBOARD is displayed");
		/*Deleting User*/
		mu.deleteUser(name);
		String msg= mu.getDatadeleted().getText();
		assertEquals(msg,"data deleted !!");
		Reporter.log("data deleted !! is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "data deleted !! is displayed");
		configAM();
		/*Logging in as deleted user*/
		pl.patientLogin(email, pass);
		String header3 = pl.getPatientloginheader().getText();
		assertEquals(header3,"HMS | Patient Login");
		Reporter.log("HMS | Patient Login means it not loged in as user",true);
		UtilityClassObject.getTest().log(Status.INFO, "HMS | Patient Login means it not loged in as user");
		WebDriverUtility wlib1= new WebDriverUtility();
		wlib1.switchToTabOnURL(driver, "/AppServer/Hospital_Doctor_Patient_Management_System/index.php");	
		configBM();








	}
}
