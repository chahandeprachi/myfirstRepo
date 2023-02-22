package clinicotest.elabassist.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
		
		
	}

	@FindBy(xpath = "//input[@id='txtUserName']")
	WebElement username;

	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement password;

	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement loginBtn;

	public void loginToApplication(String uname, String pwd) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
	}

}
