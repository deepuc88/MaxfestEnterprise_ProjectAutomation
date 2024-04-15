package webDriverUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

import WaitUtility.WaitUtility;

public class BrowserUtility {
	private static WebDriver driver;

	public void launchBrowser(String Browser, String url) {
		// String Browser = "Chrome";
		// String url = "https://selenium.qabible.in/index.php";

		switch (Browser) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}

		driver.manage().window().maximize();
		driver.get(url);
		WaitUtility objWait = new WaitUtility(driver); // parameterized constructor from WaitUtility class
		objWait.implecitWait();
	}

	public void closeBrowser() {
		driver.close();
	}

	public WebDriver baseDriver() {

		return this.driver;
	}

	public void screenShot(String page) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver); // interface

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(
				"C:\\Deepu\\Selenium_Work\\SeleniumSample\\src\\main\\resources\\ScreenShot\\test" + page + ".jpg");

		// Copy file at destination

		Files.copy(SrcFile, DestFile);
	}
}

/*
 * public static void launchBrowser(String Browser, String Url) { WebDriver
 * driver = null; switch (Browser) { case "Chrome": driver = new ChromeDriver();
 * break;
 * 
 * case "FireFox": driver = new FirefoxDriver(); break;
 * 
 * default: break; }
 * 
 * driver.manage().window().maximize(); driver.get(Url);
 * //"https://selenium.qabible.in/index.php" driver.close(); }
 */
