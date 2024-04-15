package ProjectTestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtendReport.ExtentTestManager;
import POM.PomBrand;
import POM.PomSearch;
import POM.PomUnit;
import WaitUtility.WaitUtility;
import commonUtility.ConfigFileReader;
import webDriverUtility.BrowserUtility;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Unit extends ExtentTestManager {

	public static WebDriver driver;
	PomUnit objUnit;
	PomSearch objSearch;
	WaitUtility wait;
	ConfigFileReader objConfigReader;
	public ExtentTest test1;

	@Test(priority = 7, enabled = true, description = "Verify that user is able to add Unit")
	public void addUnit() throws InterruptedException, IOException {
		BrowserUtility objutil = new BrowserUtility();
		driver = objutil.baseDriver();
		wait = new WaitUtility(driver);
		//wait.normalWait(13000);

		objUnit = new PomUnit(driver);
		//objUnit.product();
		objUnit.clickUnitMenu();

		objUnit.addUnit();
		//wait.normalWait(2000);
		objUnit.unitNameSendKeys("gram_Deepu");
		objUnit.unitShortNameSendKeys("gm");
		objUnit.allowDecimal("1");
		objUnit.unitSave();
		
		String unitSuccessActual = objUnit.getTextUnitAdd();
		System.out.println(unitSuccessActual);
		String unitSuccessExpected = "Unit added successfully";
		Assert.assertEquals(unitSuccessActual, unitSuccessExpected);
		System.out.println("Passed : unit added");
		test1.log(Status.PASS, " Add Unit");
		//wait.normalWait(1000);

	}

	@Test(priority = 8, enabled = true, description = "Verify that user is able to search Unit")
	public void searchUnit() throws InterruptedException, IOException {
		objSearch = new PomSearch(driver);
		objConfigReader = new ConfigFileReader();

		String unitTableValueExpct = ConfigFileReader.readConfigFile("unitSearch");
		
		objSearch.unitSearchInput(unitTableValueExpct);
		//wait.normalWait(8000);
		String unitTableValueActl = objSearch.getTextUnitTable();
		//wait.normalWait(6000);
		System.out.println(unitTableValueActl);

		Assert.assertEquals(unitTableValueActl, unitTableValueExpct);
		System.out.println("Passed : Unit found in table");
		test1.log(Status.PASS, " Search Brand");
		wait.normalWait(1000);
	}

	@BeforeTest
	public void beforeTest() {
		test1 = extent.createTest("Unit test case", "test to validate Add and search unit");
	}

	@AfterTest
	public void afterTest() {
	}

}
