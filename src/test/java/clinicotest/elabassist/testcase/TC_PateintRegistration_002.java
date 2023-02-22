package clinicotest.elabassist.testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import clinicotest.elabassist.pageobjects.BaseClass;
import clinicotest.elabassist.pageobjects.LoginPage;
import clinicotest.elabassist.pageobjects.PatientRegistration;

public class TC_PateintRegistration_002 extends BaseClass {
	@Test
	public void testPateintRegistration() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToApplication(excel.getStringData("data", 0, 0), excel.getStringData("data", 0, 1));

		logger=report.createTest("patient registration");
		PatientRegistration patientRegistration= PageFactory.initElements(driver, PatientRegistration.class);
		logger.info("start pateint registration test");
		patientRegistration.registerPatient();
		logger.pass("passed test");
	}

}
