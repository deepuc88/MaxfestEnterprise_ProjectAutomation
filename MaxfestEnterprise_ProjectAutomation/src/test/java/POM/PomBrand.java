package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import webDriverUtility.WebDriverActions;

public class PomBrand {

	WebDriver driver;
	WaitUtility wait;
	WebDriverActions action;

	public PomBrand(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new WebDriverActions(driver);
	}

	@FindBy(xpath = "//*[@id=\"tour_step5_menu\"]/span[1]")
	public WebElement product;

	@FindBy(xpath = "//*[@id=\"tour_step5\"]/ul/li[10]/a/span")	
	public WebElement brand;
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	public WebElement addBrandBtn;

	@FindBy(xpath = "//*[@id=\"name\"]")
	public WebElement brandName;

	@FindBy(xpath = "//*[@id=\"description\"]")
	public WebElement brandDescription;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement brandSaveBtn;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[1]")
	public WebElement brandUiHeader;
	
	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
	public WebElement brandSaveConfirmation;
	
	public void clickProductMenu() throws InterruptedException {
		wait.normalWait(8000);
		action.click(product);
	}
	
	public void clickBrandMenu() throws InterruptedException {
		//wait.explicitWait(driver, 20);
		wait.normalWait(1000);
		action.click(brand);
	}
	
	public void addBrand() throws InterruptedException {
		//wait.explicitWait(driver, 20);
		action.click(addBrandBtn);
		wait.normalWait(1000);
	}

	public void brandNameSendKeys(String expectedValue) throws IOException {

		action.sendkeys(brandName, expectedValue);

	}

	public void brandDescriptionSendKeys(String expectedValue) throws IOException {

		action.sendkeys(brandDescription, expectedValue);

	}

	public void saveBrand() throws InterruptedException {

		action.click(brandSaveBtn);
		wait.normalWait(1000);

	}
	
	public String getTextBrandUi() {
		String text = action.getText(brandUiHeader);
		return text;
	}
	
	public String getTextBrandAdd() {
		String text = action.getText(brandSaveConfirmation);
		return text;
	}

}
