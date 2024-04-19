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

	@FindBy(xpath = "//*[@id=\"tour_step5\"]/ul/li[1]/a")
	public WebElement listProduct;

	
	public void productUi() throws InterruptedException {
		wait.normalWait(13000);
		action.click(listProduct);
		wait.normalWait(1000);
	}


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
		
		action.click(productSaveBtn);
	}
	
	public String getTextProductAdd() {
		String text = action.getText(productSaveConfirmation);
		return text;
	}

}
