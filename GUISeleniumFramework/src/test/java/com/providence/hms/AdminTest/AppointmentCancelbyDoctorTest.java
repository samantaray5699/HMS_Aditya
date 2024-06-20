package com.providence.hms.AdminTest;
/*
 * @author Aditya
 * Test Class for AppointmentCancelbyDoctorTest// Admin Module
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
import com.comcast.crm.objectrepositoryutility.AdminAppoiuntmentHistoryPage;
import com.comcast.crm.objectrepositoryutility.AdminDashboardPage;
import com.comcast.crm.objectrepositoryutility.DoctorDashboardPage;
import com.comcast.crm.objectrepositoryutility.DoctorLoginPage;
import com.comcast.crm.objectrepositoryutility.PatientBookAppointmentPage;
import com.comcast.crm.objectrepositoryutility.PatientDashboardPage;
import com.comcast.crm.objectrepositoryutility.PatientLoginPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AppointmentCancelbyDoctorTest extends BaseClass_Aditya {

	@Test
	public void verifyAppointmentCancelByDoctor() throws Throwable
	{
		/*Logging out as admin*/
		configAM();
		String email=eLib.getDataFromExcel("Admin", 11, 2);
		String pass=eLib.getDataFromExcel("Admin", 11, 3);
		
		String docspeac=eLib.getDataFromExcel("Admin", 11, 4);
		String docname=eLib.getDataFromExcel("Admin", 11, 5);
		String date = jLib.getSystemDateYYYYDDMM();
		String docusername= eLib.getDataFromExcel("Admin", 11, 7);
		String docpass= eLib.getDataFromExcel("Admin", 11,8);
		String patientname=eLib.getDataFromExcel("Admin", 11, 10);
		/*Logging in as a patient*/
		PatientLoginPage pl= new PatientLoginPage(driver);
		pl.patientLogin(email, pass);
		PatientDashboardPage pdp= new PatientDashboardPage(driver);
		String header1 = pdp.getUserDashboardHeader().getText();
		assertEquals(header1,"USER | DASHBOARD");
		Reporter.log("USER | DASHBOARD is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "USER | DASHBOARD is displayed");
		/*Booking an appoinmrnt*/
		pdp.getBookappoinmentLink().click();
		PatientBookAppointmentPage pba= new PatientBookAppointmentPage(driver);
		String header2 = pba.getBookappointmentHeader().getText();
		assertEquals(header2,"USER | BOOK APPOINTMENT");
		Reporter.log("USER | BOOK APPOINTMENT is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "USER | BOOK APPOINTMENT is displayed");
		pba.bookAppointment(docspeac, docname, date);
		/*Logging out as patient*/
		pdp.patientlogout();
		/*Logging in as Doctor*/
		DoctorLoginPage dlp= new DoctorLoginPage(driver);	
		dlp.docLogin(docusername, docpass);
		DoctorDashboardPage ddp= new DoctorDashboardPage(driver);
		String header3 = ddp.getDoctordashboardHeder().getText();
		assertEquals(header3,"DOCTOR | DASHBOARD");
		Reporter.log("DOCTOR | DASHBOARD is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "DOCTOR | DASHBOARD is displayed");

		/*Navigating to Appointment history link*/
		ddp.getAppointmentHistoryLink().click();
		String expecturl= eLib.getDataFromExcel("Admin", 11,9);//td[text()='Digbijo']/..//a[@tooltip='Remove']
		String acturl = driver.getCurrentUrl();
		assertEquals(expecturl,acturl);
		Reporter.log("Appointment history page is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "Appointment history page is displayed");

		/*Canceling the appointment booked by patient*/
		driver.findElement(By.xpath("//td[text()='"+patientname+"']/..//a[@tooltip='Remove']")).click();
		WebDriverUtility wlib= new WebDriverUtility();
		wlib.switchtoAlertAndAccept(driver);
		/*Logging out as Doctor*/
		ddp.doctorlogout();
		/*Loging in as Admin*/
		configBM();
		/*Naviagting to Appointment History page*/
		AdminDashboardPage adp= new AdminDashboardPage(driver);
		adp.getAppoinmentHistoryLink().click();
		AdminAppoiuntmentHistoryPage aphp= new AdminAppoiuntmentHistoryPage(driver);
		String header4 = aphp.getAppointmenthistoryHeader().getText();
		assertEquals(header4,"PATIENTS | APPOINTMENT HISTORY");
		Reporter.log("PATIENTS | APPOINTMENT HISTORY is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "PATIENTS | APPOINTMENT HISTORY is displayed");

		/*Verifying the ststus as cancelled by doctor*/
	    boolean canceled = driver.findElement(By.xpath("//td[text()='Digbijo']/..//td[text()='srujani']/..//td[contains(text(),'Cancel by Doctor')]")).isDisplayed();
	    assertTrue(canceled);
	    Reporter.log("Appointment canceled by doctor is displayed",true);	
		UtilityClassObject.getTest().log(Status.INFO, "Appointment canceled by doctor is displayed");

	}
}
