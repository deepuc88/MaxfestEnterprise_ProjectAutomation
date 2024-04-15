package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import WaitUtility.WaitUtility;
import webDriverUtility.WebDriverActions;

public class PomProduct {

	WebDriver driver;
	WaitUtility wait;
	WebDriverActions action;

	public PomProduct(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new WebDriverActions(driver);
	}

	@FindBy(xpath = "//*[@id=\"tour_step5_menu\"]/span[1]")
	public WebElement Product;
//
	@FindBy(xpath = "//*[@id=\"tour_step5\"]/ul/li[1]/a")
	public WebElement listProduct;

//
//	@FindBy(xpath = "//*[@id=\"product_list_tab\"]/a")
//	public WebElement productAdd;
//
//	@FindBy(xpath = "//*[@id=\"name\"]")
//	public WebElement productName;
//
//	@FindBy(xpath = "//*[@id=\"select2-brand_id-container\"]")
//	public WebElement productBrand;
//	
//	@FindBy(xpath = "//*[@id=\"select2-unit_id-container\"]")
//	public WebElement productUnit;
//	
//	@FindBy(xpath = "//*[@id=\"select2-category_id-container\"]")
//	public WebElement productCategory;
//	
//	@FindBy(xpath = "//*[@id=\"select2-barcode_type-container\"]")
//	public WebElement barCode;
//	
//	@FindBy(xpath = "//*[@id=\"alert_quantity\"]")
//	public WebElement allertQty;
//	
//	@FindBy(xpath = "//*[@id=\"expiry_period\"]")
//	public WebElement expiresIn;
//	
//	@FindBy(xpath = "//*[@id=\"select2-tax_type-container\"]")
//	public WebElement sellingPriceTaxType;
//	
//	@FindBy(xpath = "//*[@id=\"select2-type-container\"]")
//	public WebElement productType;
//	
//	@FindBy(xpath = "//*[@id=\"single_dpp\"]")
//	public WebElement excTaxPurchase;
//	
//	@FindBy(xpath = "//*[@id=\"single_dpp_inc_tax\"]")
//	public WebElement incTax;
//	
//	@FindBy(xpath = "//*[@id=\"single_dsp\"]")
//	public WebElement excTaxSelling;
//	
//	@FindBy(xpath = "//*[@id=\"product_add_form\"]/div[4]/div/div/div/button[4]")
//	public WebElement saveProduct;
//	
	public void productUi() throws InterruptedException {
		wait.normalWait(13000);
		action.click(listProduct);
		wait.normalWait(1000);
	}
//	public void addProduct() {
//		action.click(productAdd);
//		
//	}
//	
//	public void productNameSendkeys(String expectedValue) {
//		action.sendkeys(productName, expectedValue);
//	}
//	
//	public void productBrandSendkeys(String expectedValue) {
//		//Select objbrand = new Select(productBrand);
//		action.sendkeys(productBrand, expectedValue);
//	}
//	
//	public void productUnitSendkeys(String expectedValue) {
//		action.sendkeys(productUnit, expectedValue);
//	}
//	
//	public void productCategorySendkeys(String expectedValue) {
//		action.sendkeys(productCategory, expectedValue);
//	}
//	
//	public void productBarcodeSendkeys(String expectedValue) {
//		action.sendkeys(barCode, expectedValue);
//	}
//	
//	public void allertQtySendkeys(String expectedValue) {
//		action.sendkeys(allertQty, expectedValue);
//	}
//	
//	public void productExpiresInSendkeys(String expectedValue) {
//		action.sendkeys(expiresIn, expectedValue);
//	}
//	
//	public void sellingPriceTaxType() {
//		Select obj = new Select(sellingPriceTaxType);
//		action.DropdownselectByIndex(sellingPriceTaxType, 0);
//		
//	}
//	
//	public void productType() {
//		Select ob = new Select(productType);
//		action.DropdownselectByIndex(productType, 0);
//	}
//	
//	public void excTaxSellingSendkeys(String expectedValue) {
//		action.sendkeys(excTaxSelling, expectedValue);
//	}
//	
//	public void incTaxSellingSendkeys(String expectedValue) {
//		action.sendkeys(incTax, expectedValue);
//	}
//	
//	public void excTaxPurchaseSendkeys(String expectedValue) {
//		action.sendkeys(excTaxPurchase, expectedValue);
//	}
//	
//	public void saveProduct() {
//		action.click(saveProduct);
//	}

	@FindBy(xpath = "//*[@id=\"tour_step5\"]/ul/li[2]/a")
	public WebElement addproducts;

	@FindBy(xpath = "//input[@id='name']")
	public WebElement productName;

	@FindBy(xpath = "//select[@name='brand_id']")
	public WebElement selectBrand;

	@FindBy(xpath = "//select[@name='unit_id']")
	public WebElement selectUnit;

	@FindBy(xpath = "//select[@name='barcode_type']")
	public WebElement selectBarcodeType;

	@FindBy(xpath = "//input[@id='alert_quantity']")
	public WebElement selectAlertQty;

	@FindBy(xpath = "//span[@id='select2-tax_type-container']")
	public WebElement sellingPriceTaxType;

	@FindBy(xpath = "//span[@id='select2-type-container']")
	public WebElement productType;

	@FindBy(xpath = "//input[@id='single_dpp']")
	public WebElement purchaseExcTax;

	@FindBy(xpath = "//input[@id='single_dpp_inc_tax']")
	public WebElement purchaseIncTax;

	@FindBy(xpath = "//input[@id='single_dsp']")
	public WebElement sellingExcTax;

	@FindBy(xpath = "//button[@class='btn btn-primary submit_product_form']")
	public WebElement productSaveBtn;

	@FindBy(xpath = "//div[@class='form-control file-caption  kv-fileinput-caption']")
	public WebElement productImage;

	@FindBy(xpath = "//input[@id='upload_image']")
	public WebElement productImageBrowse;

	@FindBy(xpath = "//input[@id='expiry_period']")
	public WebElement expiry;

	@FindBy(xpath = "//div[@class='toast-message']")
	public WebElement saveToastMsg;
	
	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
	public WebElement productSaveConfirmation;

	public void productMenuClick() {
		// System.out.println("productMenuClick" + driver);
		action.click(addproducts);
	}

	public void addproductName(String value) throws InterruptedException {
		action.sendkeys(productName, value);
		wait.normalWait(1000);
	}

	public void selectBrand() throws InterruptedException {
		action.DropdownselectByvalue(selectBrand, "3");
		wait.normalWait(1000);

	}

	public void selectUnit() throws InterruptedException {
		action.DropdownselectByvalue(selectUnit, "1");
		wait.normalWait(1000);

	}

	public void selectBarcodeType() throws InterruptedException {
		action.DropdownselectByvalue(selectBarcodeType, "C39");
		wait.normalWait(2000);

	}

	public void addselectAlertQty(String value) throws InterruptedException {
		action.sendkeys(selectAlertQty, value);
		wait.normalWait(1000);
	}

	public void addpurchaseExcTax(String value) {
		action.sendkeys(purchaseExcTax, value);
	}

	public void addpurchaseIncTax(String value) throws InterruptedException {
		action.sendkeys(purchaseIncTax, value);
		wait.normalWait(1000);
	}

	public void addexpiry(String value) {
		action.sendkeys(expiry, value);
	}

	public void productSaveBtnClick() {
		// System.out.println("productMenuClick" + driver);
		action.click(productSaveBtn);
	}
	
	public String getTextProductAdd() {
		String text = action.getText(productSaveConfirmation);
		return text;
	}

}
