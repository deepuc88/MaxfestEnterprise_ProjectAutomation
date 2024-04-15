package WaitUtility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	WebDriver driver;

	public WaitUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void implecitWait() {

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public void explicitWait(WebElement[] driver2, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		// wait.until(ExpectedConditions.elementToBeClickable((By) driver2));
		wait.until(ExpectedConditions.visibilityOfAllElements(driver2));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void fluentWait1() {
		// Declare and initialise a fluent wait
		FluentWait wait = new FluentWait(driver)
				// Specify the timout of the wait
				.withTimeout(Duration.ofSeconds(30))
				// Sepcify polling time
				.pollingEvery(Duration.ofSeconds(5))
				// Specify what exceptions to ignore
				.ignoring(NoSuchElementException.class);

		// This is how we specify the condition to wait on.
		// This is what we will explore more in this chapter
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void normalWait(int sleepValue) throws InterruptedException {
		Thread.sleep(sleepValue);
	}

}
