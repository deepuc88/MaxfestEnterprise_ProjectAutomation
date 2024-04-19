package ProjectTestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtendReport.ExtentTestManager;
import POM.PomBrand;
import POM.PomSearch;
import WaitUtility.WaitUtility;
import commonUtility.ConfigFileReader;
import webDriverUtility.BrowserUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Brand extends ExtentTestManager {

	public static WebDriver driver;
	PomBrand objBrand;
	PomSearch objSearch;
	WaitUtility wait;
	ConfigFileReader objConfigReader;
	public ExtentTest test1;

	@Test(priority = 3, groups = {"Regression"}, enabled = true, description = "Verify that user is able to add Brand")
	public void addBrand() throws InterruptedException, IOException {
		BrowserUtility objutil = new BrowserUtility();
		driver = objutil.baseDriver();
		wait = new WaitUtility(driver);
		
		objBrand = new PomBrand(driver);
		objBrand.clickProductMenu();
		
		objBrand.clickBrandMenu();
		String brandUiActual = objBrand.getTextBrandUi();
		System.out.println(brandUiActual);
		String brandUiExpected = "Brands Manage your brands";
		Assert.assertEquals(brandUiActual, brandUiExpected);
		System.out.println("Passed : brand ui landed");
		
		objBrand.addBrand();
		
		objBrand.brandNameSendKeys("Deepu_124");
		objBrand.brandDescriptionSendKeys("Test brand");
		objBrand.saveBrand();

		String brandSuccessActual = objBrand.getTextBrandAdd();
		
		String brandSuccessExpected = "Brand added successfully";
		Assert.assertEquals(brandSuccessActual, brandSuccessExpected);
		System.out.println("Passed : brand added");
		test1.log(Status.PASS, " Add Brand");
		
	}

	@Test(priority = 4, groups = {"Regression"}, enabled = true, description = "Verify that user is able to search a Brand")
	public void searchBrand() throws InterruptedException, IOException {

		objSearch = new PomSearch(driver);
		objConfigReader = new ConfigFileReader();
		
		String brandSearch = ConfigFileReader.readConfigFile("brandSearch");
		System.out.println("search value : " + brandSearch);
		objSearch.brandSearchInput(brandSearch);
		
		String brandTableValueActl = objSearch.getTextBrandTable();
		
		System.out.println("brand value from table : "+brandTableValueActl);
		
		
		Assert.assertEquals(brandTableValueActl, brandSearch);
		System.out.println("Passed : Brand found in table");
		test1.log(Status.PASS, " search Brand");
		
	}

	@BeforeTest
	
	public void beforeTest() {
		test1 = extent.createTest("Brand test case", "test to validate Add and search brand");

	}

	@AfterTest
	public void afterTest() {
	}

}
