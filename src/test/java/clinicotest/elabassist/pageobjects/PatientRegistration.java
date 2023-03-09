package clinicotest.elabassist.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PatientRegistration {
	WebDriver driver;
	
	public PatientRegistration(WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='form1']//div[3]//header//a[@href='#']")
	WebElement menu;
	
	@FindBy(xpath="//i[@class='fa fa-registered']")
	WebElement patientRegistration;
	
	@FindBy(id="textCollectionCenterPoint")
	WebElement collectionCenter;
	
	@FindBy(id="txtDoctorName1")
	WebElement docName;
	
	@FindBy(id="drpTitle")
	WebElement patientInitial;
	
	@FindBy(id="txtPatientName")
	WebElement patientName;
	
	@FindBy(id="txtAge")
	WebElement patientAge;
	
	@FindBy(id="drpAgeType")
	WebElement clickYr;
	
	@FindBy(xpath="//label[contains(text(),'Male')]//parent::td//input[@id='rdbGender_0']")
	WebElement gender;
	
	public void registerPatient() {
		menu.click();
		patientRegistration.click();
		collectionCenter.sendKeys("Mulund");
		docName.sendKeys("Bhal");
		Select s=new Select(patientInitial);
		s.selectByIndex(1);
		patientName.sendKeys("Shubham");
		patientAge.sendKeys("67");
		System.out.println(patientAge.getText());
		Select s1= new Select(clickYr);
		s1.getFirstSelectedOption().click();
		gender.click();
	}
	}
	
	
	
