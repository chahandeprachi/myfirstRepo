package clinicotest.elabassist.testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import clinicotest.elabassist.pageobjects.BaseClass;
import clinicotest.elabassist.pageobjects.LoginPage;
import clinicotest.elabassist.utility.ExcelDataProvider;
import clinicotest.elabassist.utility.Helper;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void testLogin() {
		logger=report.createTest("Login to clinico");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");
		loginPage.loginToApplication(excel.getStringData("data", 0, 0), excel.getStringData("data", 0, 1));
		logger.pass("Test passed");
		
	}

}
