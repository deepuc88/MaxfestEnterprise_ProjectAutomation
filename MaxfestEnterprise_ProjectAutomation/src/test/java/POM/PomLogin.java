package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import webDriverUtility.WebDriverActions;

public class PomLogin {

	WebDriver driver;
	WaitUtility wait;
	WebDriverActions action;

	public PomLogin(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new WebDriverActions(driver);
	}

	@FindBy(xpath = "//*[@id='username']")
	public WebElement username;
	@FindBy(xpath = "//*[@id='password']")
	public WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginbtn;
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/form/div[1]/div/span/strong")
	public WebElement invalidCredMessage;
	@FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
	public WebElement endTourBtn;

	public void usernameSendKeys(String expectedValue) throws IOException {

		action.sendkeys(username, expectedValue);

	}

	public void passwordSendKeys(String expectedValue) throws IOException {

		action.sendkeys(password, expectedValue);

	}

	public String invalidCredMessageGetText() {
		String text = action.getText(invalidCredMessage);
		return text;
	}

	public void clickLoginBtn() {

		action.click(loginbtn);

	}

	public void closePopup() throws InterruptedException {
		action.click(endTourBtn);

	}

}