package ProjectTestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtendReport.ExtentTestManager;
import POM.PomCategory;
import POM.PomSearch;
import POM.PomUnit;
import WaitUtility.WaitUtility;
import commonUtility.ConfigFileReader;
import webDriverUtility.BrowserUtility;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Category extends ExtentTestManager {

	public static WebDriver driver;
	PomCategory objCategory;
	PomSearch objSearch;
	ConfigFileReader objConfigReader;
	WaitUtility wait;
	public ExtentTest test1;

	@Test(priority = 5, enabled = true, description = "Verify that user is able to add Category")
	public void addCategory() throws InterruptedException {

		BrowserUtility objutil = new BrowserUtility();
		driver = objutil.baseDriver();
		wait = new WaitUtility(driver);
		//wait.normalWait(14000);

		objCategory = new PomCategory(driver);
		objCategory.clickCategoryMenu();

		objCategory.addCategory();
		//wait.normalWait(1000);
		objCategory.categoryNameSendkeys("DP124");
		objCategory.categoryCodeSendkeys("DP");
		objCategory.saveCategory();
		
		String categorySuccessActual = objCategory.getTextCategoryAdd();
		System.out.println(categorySuccessActual);
		String categorySuccessExpected = "Category added successfully";
		Assert.assertEquals(categorySuccessActual, categorySuccessExpected);
		System.out.println("Passed : Category added");
		test1.log(Status.PASS, " Add Catgeory");
		
		//wait.normalWait(2000);
	}

	@Test(priority = 6, enabled = true, description = "Verify that user is able to search Category")
	public void searchCategory() throws InterruptedException {
		objSearch = new PomSearch(driver);
		objConfigReader = new ConfigFileReader();

		String categoryTableValueExpct = objConfigReader.readConfigFile("categorySearch");

		objSearch.categorySearchInput(categoryTableValueExpct);
		//wait.normalWait(7000);
		String categoryTableValueActl = objSearch.getTextCategoryTable();
		//wait.normalWait(6000);
		System.out.println(categoryTableValueActl);

		Assert.assertEquals(categoryTableValueActl, categoryTableValueExpct);
		System.out.println("Passed : Category found in table");
		test1.log(Status.PASS, " Search Catgeory");
		wait.normalWait(1000);
	}

	@BeforeTest
  public void beforeTest() {
		test1 = extent.createTest("Category test case", "test to validate Add and search category");
  }

	@AfterTest
	public void afterTest() {
	}

}
