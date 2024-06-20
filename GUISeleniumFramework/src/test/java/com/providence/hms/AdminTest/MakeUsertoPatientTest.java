package com.providence.hms.AdminTest;
/**
 * @author aditya
 * Test Class for MakeUsertoPatientTest// Admin Module
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
import com.comcast.crm.objectrepositoryutility.AdminDashboardPage;
import com.comcast.crm.objectrepositoryutility.DoctorAddPatientPage;
import com.comcast.crm.objectrepositoryutility.DoctorDashboardPage;
import com.comcast.crm.objectrepositoryutility.DoctorLoginPage;
import com.comcast.crm.objectrepositoryutility.PatientBookAppointmentPage;
import com.comcast.crm.objectrepositoryutility.PatientDashboardPage;
import com.comcast.crm.objectrepositoryutility.PatientLoginPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class MakeUsertoPatientTest extends BaseClass_Aditya {

	@Test
	public void makeUserToPatient() throws Throwable
	{ 
		/*Logging out as Admin*/
		configAM();
		String name=eLib.getDataFromExcel("Admin", 1, 2)+jLib.getRandomNumber();
		String adress=eLib.getDataFromExcel("Admin", 1, 3);
		String city=eLib.getDataFromExcel("Admin", 1, 4);
		String email=eLib.getDataFromExcel("Admin", 1, 5)+jLib.getRandomNumber();;
		String pass=eLib.getDataFromExcel("Admin", 1, 6);
		String contact=eLib.getDataFromExcel("Admin", 5, 7);
		String age=eLib.getDataFromExcel("Admin", 5, 8);
		String history=eLib.getDataFromExcel("Admin", 5, 9);
		
        /*Creating and logging in as user*/
		PatientLoginPage pl= new PatientLoginPage(driver);
		pl.createNewUser(name, adress, city, email, pass);
		pl.patientLogin(email, pass);
		PatientDashboardPage pdp= new PatientDashboardPage(driver);
		String header1 = pdp.getUserDashboardHeader().getText();
		assertEquals(header1,"USER | DASHBOARD");
		Reporter.log("USER | DASHBOARD is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "USER | DASHBOARD is displayed");
		/*Navigating to Booking Appointment page*/
		pdp.getBookappoinmentLink().click();
		PatientBookAppointmentPage pba= new PatientBookAppointmentPage(driver);
		String header2 = pba.getBookappointmentHeader().getText();
		assertEquals(header2,"USER | BOOK APPOINTMENT");
		Reporter.log("USER | BOOK APPOINTMENT is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "ADMIN |BOOK APPOINTMENT is displayed");
		/*Booking an Appointment with doc details*/
		String docspeac=eLib.getDataFromExcel("Admin", 5, 2);
		String docname=eLib.getDataFromExcel("Admin", 5, 3);
		String date = jLib.getSystemDateYYYYDDMM();
		String docusername= eLib.getDataFromExcel("Admin", 5, 5);
		String docpass= eLib.getDataFromExcel("Admin", 5, 6);
		pba.bookAppointment(docspeac, docname, date);
		/*Logging out as patient*/
		pdp.patientlogout();
		/*Logging in as Admin*/
		configBM();
		/*Navigating to  Manage user page */
		AdminDashboardPage adp= new AdminDashboardPage(driver);
		adp.getUsersdropdown().click();
		adp.getManageuserslnk().click();
		/*Verifying created user detail*/
		boolean status = driver.findElement(By.xpath("//td[text()='"+name+"']")).isDisplayed();
		assertTrue(status);
		Reporter.log("User displayed in manage users page",true);
		UtilityClassObject.getTest().log(Status.INFO, "User displayed in manage users page ");
		/*Logging out as Admin*/
		adp.logout();
		/*Logging in as Doctor*/
		DoctorLoginPage dlp= new DoctorLoginPage(driver);	
		dlp.docLogin(docusername, docpass);
		DoctorDashboardPage ddp= new DoctorDashboardPage(driver);
		String header3 = ddp.getDoctordashboardHeder().getText();
		assertEquals(header3,"DOCTOR | DASHBOARD");
		Reporter.log("DOCTOR | DASHBOARD is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "DOCTOR | DASHBOARD is displayed");
		/*Navigating to Add patient page*/
		ddp.getPatientsdropdown().click();
		ddp.getAddpatientLink().click();
		DoctorAddPatientPage dap= new DoctorAddPatientPage(driver);
		String header4 = dap.getAddpatientHeader().getText();
		assertEquals(header4,"PATIENT | ADD PATIENT");
		Reporter.log("PATIENT | ADD PATIENT is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "PATIENT | ADD PATIENT is displayed");
		/*Adding same user to patient*/
        dap.doctorAddPatient(name, contact, email, adress, age, history);
        ddp.doctorlogout();
		/*Logging in as Admin*/
        configBM();
		/*Navigating to  Manage patient page */
        adp.getPatientDropdown().click();
        adp.getManagepatientlnk().click();
        String patientpageurl=driver.getCurrentUrl();
        String acturl1=eLib.getDataFromExcel("Admin", 5, 10);
        assertEquals(patientpageurl,acturl1);
		Reporter.log("View patient page displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "View patient page displayed");
        /*verifying user converted to patient or not*/
		boolean patientname = driver.findElement(By.xpath("//td[text()='"+name+"']")).isDisplayed();
		assertTrue(patientname);
		Reporter.log("Patient displayed in manage patirent page",true);
		UtilityClassObject.getTest().log(Status.INFO, "Patient displayed in manage patirent page");

	}
}
