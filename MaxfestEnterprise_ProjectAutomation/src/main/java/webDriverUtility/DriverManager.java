package webDriverUtility;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PropertyUtility.PropertyRead;

public class DriverManager
{
	public WebDriver driver;
	public DriverManager() throws IOException 
	{		
		PropertyRead prop = new PropertyRead();
		Properties propValues=  prop.readPropertiesFile( "Web.properties") ;
		String  Browser = propValues.getProperty("Browser");
		String Url = propValues.getProperty("Url");
	    System.out.println("Browser: "+ propValues.getProperty("Browser"));
	    System.out.println("Url: "+ propValues.getProperty("Url"));

		switch (Browser) 
		{
			case "Chrome":
				driver = new ChromeDriver();
				break;

			case "Edge":
				driver = new EdgeDriver();
				break;
			
			case "FireFox":
				driver = new FirefoxDriver();
				break;

			default:
				break;
		}
		driver.get(Url);
		driver.manage().window().maximize();
	/*public DriverManager(String url) // Constructor used to get url
	{		
		driver = new ChromeDriver();
		driver.get(url);
	}
	public static void launchBrowser(String url) // implemented as method for getting url in webdriver.
	{
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get(url);
	} */
	}
}
