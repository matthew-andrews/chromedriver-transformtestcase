package ws.mattandre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting up the test case...");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://mattandre.ws/test/1.html";
		
		// Launch Chrome and direct it to the base URL
		System.out.println("Loading " + baseUrl);
		driver.get(baseUrl);
		
		// Take a moment to reflect
		Thread.sleep(2000);

		// Check our traditionally positioned element can be found and is displayed
		WebElement controlEl = driver.findElement(By.cssSelector("#control"));
		if (controlEl.isDisplayed()) {
			System.out.println("#control has been found, and it's displayed.  Carry on.");
		} else {
			System.out.println("Something has gone very wrong.  Can't find #window.");
		}
		
		// Test offsetting via negative margins
		WebElement marginEl = driver.findElement(By.id("margin")); 
		if (marginEl.isDisplayed()) {
			System.out.println("#margin has been found, and it's displayed.");
		} else {
			System.out.println("#margin cannot be found.");
		}
		
		// Test the same applies to a _CSS3_ positioned element
		WebElement testEl = driver.findElement(By.id("test")); 
		if (testEl.isDisplayed()) {
			System.out.println("#test has been found, and it's displayed.");
		} else {
			System.out.println("#test cannot be found.  This is a bug in either Chrome or ChromeDriver.");
		}

		// Good bye
		driver.close();		
		System.exit(0);
	}

}
