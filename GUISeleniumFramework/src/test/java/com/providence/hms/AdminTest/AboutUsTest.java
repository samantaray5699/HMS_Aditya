package com.providence.hms.AdminTest;
/*
 * @author Aditya
 * Test Class for AboutUs //Admin Module
 */
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass_Aditya;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AboutusPage;
import com.comcast.crm.objectrepositoryutility.AdminDashboardPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AboutUsTest extends BaseClass_Aditya{

	@Test
	public void verifyUpdateAboutUs() throws Throwable
	{
		String data=eLib.getDataFromExcel("Admin", 3, 2)+jLib.getRandomNumber();
		String actrl="http://49.249.28.218:8081/AppServer/Hospital_Doctor_Patient_Management_System/hms/admin/about-us.php";
		/* Navigate to Admin Dashboard page*/
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		String header1=adp.getAdminDashboard().getText();
		assertEquals(header1,"ADMIN | DASHBOARD");
		Reporter.log("ADMIN | DASHBOARD is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "ADMIN | DASHBOARD is displayed");
		/*Navigate to Aboutus page*/ 
		adp.getPagesLink().click();
		adp.getAboutusLink().click();
		AboutusPage ap= new AboutusPage(driver);
		String header2=driver.getCurrentUrl();
		assertEquals(header2,actrl);
		Reporter.log("ADMIN | UPDATE THE ABOUT US CONTENT URL is displayed",true);
		UtilityClassObject.getTest().log(Status.INFO, "ADMIN | UPDATE THE ABOUT US CONTENT URL is displayed");
		/*Updating the about us content*/
		ap.updateAboutus(data);
		configAM();
		/*Navigate to Home page and check about us content*/
		HomePage hp= new HomePage(driver);
		hp.getAboutusLink().click();
		/*Verifying updated about us content in home page*/
		String aboutus = driver.findElement(By.xpath("//div[@class='col-sm-6 abut-yoiu']/p")).getText();
		System.out.println("Abount AS "+aboutus);
		System.out.println(data);
		assertEquals(aboutus,data+".");
		Reporter.log("Updated data is displayed in home page ",true);
		UtilityClassObject.getTest().log(Status.INFO, "Updated data is displayed in home page ");

		configBM();

	}
}
