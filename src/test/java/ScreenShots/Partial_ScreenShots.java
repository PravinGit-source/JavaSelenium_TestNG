package ScreenShots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Partial_ScreenShots {

	public static void main(String[] args) throws IOException {
		
		// Launch Chrome browser
		WebDriver driver = new ChromeDriver();
		
		// Open target website
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
		// Locate specific element (example: Amazon logo)
		WebElement logo = driver.findElement(By.xpath("//textarea[contains(@aria-label,'Search')]"));
		logo.sendKeys("Partial ScreenShot");
		
		// Capture partial screenshot of that element
		File src = logo.getScreenshotAs(OutputType.FILE);
		
		// Save screenshot to local folder
		File dest = new File("D:\\\\JAVA PROGRAMMES\\\\ScreenShots\\\\google.png");
		FileHandler.copy(src, dest);
		
		System.out.println("✅ Partial screenshot captured successfully!");
	    System.out.println(logo.getRect().getDimension().getHeight());
	    System.out.println(logo.getRect().getDimension().getWidth());
		// Close browser
		driver.quit();
	}
}
