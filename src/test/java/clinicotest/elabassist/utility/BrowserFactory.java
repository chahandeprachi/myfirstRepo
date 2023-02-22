package clinicotest.elabassist.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver startBrowser(WebDriver driver, String browserName, String appUrl) {
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if (browserName.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		else if (browserName.equals("msedge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			System.out.println("we do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;

	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();

	}

}
