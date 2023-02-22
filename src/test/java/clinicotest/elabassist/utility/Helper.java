package clinicotest.elabassist.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/clinoco_" + getCurrentTime() + ".png";
		try {
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot Captured");
		} catch (IOException e) {
			System.out.println("unable to capture screenshot " + e.getMessage());
		}
		return screenshotPath;

	}

	public static String getCurrentTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

	public static WebElement selectFromDropdownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		return element;

	}

	public static WebElement selectFromDropdownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		return element;

	}

	public static WebElement selectFromDropdownByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
		return element;

	}

}
