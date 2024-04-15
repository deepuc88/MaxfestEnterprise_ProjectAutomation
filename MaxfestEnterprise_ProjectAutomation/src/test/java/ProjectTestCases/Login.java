package ProjectTestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExcelUtility.ReadExcel;
import ExtendReport.ExtentTestManager;
import POM.PomLogin;
import WaitUtility.WaitUtility;
import webDriverUtility.BrowserUtility;
import webDriverUtility.WebDriverActions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login extends ExtentTestManager {

	public static WebDriver driver;
	PomLogin objPM;
	ReadExcel objExcel;
	public ExtentTest test1;
	WaitUtility wait;

	@Test(priority = 1, enabled = true, dataProvider = "data-provider", description = "Verify that user is not able to login with invalid credentials")
	public void invalidLogin(String user, String passwrd) throws IOException, InterruptedException {

		objPM = new PomLogin(driver);
		objPM.usernameSendKeys(user);
		objPM.passwordSendKeys(passwrd);
		objPM.clickLoginBtn();

		String actualMessage = objPM.invalidCredMessageGetText();
		System.out.println(actualMessage);
		String expectedMessage = "These credentials do not match our records.";

		Assert.assertEquals(expectedMessage, actualMessage);
		System.out.println("Passed : Invalid login attempt");
		test1.log(Status.PASS, " Invalid login attempt");

	}

	@Test(priority = 2, enabled = true, description = "Verify that user is able to login with valid credentials")
	public void validLogin() throws IOException, InterruptedException {

		objExcel = new ReadExcel();
		String userName = objExcel.readString(1, 0);
		String password = objExcel.readNumeric(1, 1);

		objPM = new PomLogin(driver);
		objPM.usernameSendKeys(userName);
		objPM.passwordSendKeys(password);
		objPM.clickLoginBtn();

		String currUrlActl = driver.getCurrentUrl();
		String currUrlExpct = "https://qalegend.com/billing/public/home";
		Assert.assertEquals(currUrlActl, currUrlExpct);
		System.out.println("Passed : Login Success");
		test1.log(Status.PASS, "Valid login");

		objPM.closePopup();
	}

	@BeforeTest(alwaysRun = true)
	@Parameters({ "Browser", "Url" })
	public void beforeTest(String Browser, String Url) {

		BrowserUtility objutil = new BrowserUtility();
		objutil.launchBrowser(Browser, Url);
		driver = objutil.baseDriver();
		test1 = extent.createTest("login testcase", "test to validate login");
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {

	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "admin", "123456A" } };
	}

}
