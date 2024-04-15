package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import webDriverUtility.WebDriverActions;

public class PomSearch {

	WebDriver driver;
	WaitUtility wait;
	WebDriverActions action;

	public PomSearch(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new WebDriverActions(driver);
	}

	@FindBy(xpath = "//*[@id=\"brands_table_filter\"]/label/input")
	public WebElement brandSearch;

	@FindBy(xpath = "//*[@id=\"brands_table_wrapper\"]/div[1]/div/div[2]/div/a/span/i")
	public WebElement actionBtn;
	
	@FindBy(xpath = "//table[@id='brands_table']//tbody//tr[1]//td[1]")
	public WebElement brandTableValue;

	public void brandSearchInput(String brand) throws InterruptedException {
		action.sendkeys(brandSearch, brand);
		wait.normalWait(5000);
		//action.click(actionBtn);
	}
	
	public String getTextBrandTable() {
		String text = brandTableValue.getText();
		return text;
	}
	
	@FindBy(xpath = "//*[@id=\"unit_table_filter\"]/label/input")
	public WebElement unitSearch;

	@FindBy(xpath = "//*[@id=\"unit_table_wrapper\"]/div[1]/div/div[2]/div/a/span/text()")
	public WebElement unitActionBtn;
	
	@FindBy(xpath = "//table[@id=\"unit_table\"]/tbody/tr[1]/td[1]")
	public WebElement unitTableValue;
	
	public void unitSearchInput(String unit) throws InterruptedException {
		action.sendkeys(unitSearch, unit);
		wait.normalWait(9000);
		wait.normalWait(6000);
		
	}
	
	public String getTextUnitTable() {
		String text = unitTableValue.getText();
		return text;
	}
	
	
	@FindBy(xpath = "//*[@id=\"category_table_filter\"]/label/input")
	public WebElement categorySearch;
	
	@FindBy(xpath = "//table[@id=\"category_table\"]/tbody/tr[1]/td[1]")
	public WebElement categoryTableValue;
	
	public void categorySearchInput(String category) throws InterruptedException {
		action.sendkeys(categorySearch, category);
		wait.normalWait(8000);
		wait.normalWait(7000);
		
	}
	
	public String getTextCategoryTable() throws InterruptedException {
		
		String text = categoryTableValue.getText();
		return text;
	}
	
	@FindBy(xpath = "//*[@id=\"product_table_filter\"]/label/input")
	public WebElement productSearch;
	
	@FindBy(xpath = "//table[@id=\"product_table\"]/tbody/tr/td[3]")
	public WebElement productTableValue;
	
	public void productSearchInput(String product) throws InterruptedException {
		action.sendkeys(productSearch, product);
		wait.normalWait(8000);
		wait.normalWait(6000);
	}
	
	public String getTextProductTable() {
		String text = productTableValue.getText();
		return text;
	}

}
