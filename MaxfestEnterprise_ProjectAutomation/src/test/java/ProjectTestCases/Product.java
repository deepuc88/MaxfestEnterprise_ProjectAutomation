package ProjectTestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtendReport.ExtentTestManager;
import POM.PomProduct;
import POM.PomSearch;
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

public class Product extends ExtentTestManager {

	public static WebDriver driver;
	PomProduct objProduct;
	WaitUtility wait;
	public ExtentTest test1;
	PomSearch objSearch;
	ConfigFileReader objConfigReader;

	@Test(priority = 9, enabled = true, description = "Verify that user is able to navigate to Product UI")
	public void addProduct() throws InterruptedException {

		BrowserUtility objutil = new BrowserUtility();
		driver = objutil.baseDriver();
		wait = new WaitUtility(driver);

		//wait.normalWait(13000);
		objProduct = new PomProduct(driver);
		// objProduct.Product.click();
		objProduct.productUi();
		//wait.normalWait(1000);
		objProduct.productMenuClick();
		objProduct.addproductName("parker Pen");
		//wait.normalWait(1000);
		objProduct.selectBrand();
		//wait.normalWait(1000);
		objProduct.selectUnit();
		//wait.normalWait(1000);
		objProduct.selectBarcodeType();
		//wait.normalWait(2000);
		objProduct.addselectAlertQty("20");
		//wait.normalWait(1000);
		objProduct.addpurchaseIncTax("4");
		wait.normalWait(1000);
		// prodObj.addpurchaseExcTax("10");
		objProduct.addexpiry("15");
		objProduct.productSaveBtnClick();

		String productSuccessActual = objProduct.getTextProductAdd();
		System.out.println(productSuccessActual);
		String productSuccessExpected = "Product added successfully";
		Assert.assertEquals(productSuccessActual, productSuccessExpected);
		System.out.println("Passed : Product added");
		test1.log(Status.PASS, " Add Product");

		wait.normalWait(1000);

	}
	
	@Test(priority = 10, enabled = true, description = "Verify that user is able to search Product")
	public void searchProduct() throws InterruptedException, IOException {
		objSearch = new PomSearch(driver);
		objConfigReader = new ConfigFileReader();

		String productTableValueExpct = ConfigFileReader.readConfigFile("productSearch");
		
		objSearch.productSearchInput(productTableValueExpct);
		//wait.normalWait(8000);
		String productTableValueActl = objSearch.getTextProductTable();
		//wait.normalWait(6000);
		System.out.println(productTableValueActl);

		Assert.assertEquals(productTableValueActl, productTableValueExpct);
		System.out.println("Passed : product found in table");
		test1.log(Status.PASS, " Search Product");
		wait.normalWait(1000);
	}

  @BeforeTest
  public void beforeTest() {
	  test1 = extent.createTest("Product test case", "test to validate Add and search product");
  }

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
