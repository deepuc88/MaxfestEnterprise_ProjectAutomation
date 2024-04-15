package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import WaitUtility.WaitUtility;
import webDriverUtility.WebDriverActions;

public class PomUnit {

	WebDriver driver;
	WaitUtility wait;
	WebDriverActions action;

	public PomUnit(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new WebDriverActions(driver);
	}

	@FindBy(xpath = "//*[@id=\"tour_step5_menu\"]/span[1]")
	public WebElement product;

	@FindBy(xpath = "//*[@id=\"tour_step5\"]/ul/li[8]/a/span")
	public WebElement unit;

	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	public WebElement addUnitBtn;

	@FindBy(xpath = "//*[@id='actual_name']")
	public WebElement unitName;
	@FindBy(xpath = "//*[@id='short_name']")
	public WebElement unitShortName;
	@FindBy(xpath = "//*[@id='allow_decimal']")
	public WebElement allowDecimal;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElement unitSaveBtn;
	
	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
	public WebElement unitSaveConfirmation;
	
	public void product() {
		action.click(product);
	}

	public void clickUnitMenu() throws InterruptedException {
		wait.normalWait(13000);

		action.click(unit);
	}

	public void addUnit() throws InterruptedException {
		// wait.explicitWait(driver, 20);
		action.click(addUnitBtn);
		wait.normalWait(2000);
	}

	public void unitNameSendKeys(String expectedValue) throws IOException {

		action.sendkeys(unitName, expectedValue);

	}

	public void unitShortNameSendKeys(String expectedValue) throws IOException {

		action.sendkeys(unitShortName, expectedValue);

	}

	public void allowDecimal(String expectedValue) throws IOException {

		Select objsel = new Select(allowDecimal);

		action.DropdownselectByIndex(allowDecimal, 1);

	}

	public void unitSave() {

		action.click(unitSaveBtn);

	}
	
	public String getTextUnitAdd() {
		String text = action.getText(unitSaveConfirmation);
		return text;
	}

}
