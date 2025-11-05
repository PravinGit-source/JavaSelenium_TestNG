package ScreenShots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.get("http://www.google.com");
File Source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
File Destination = new File("D:\\JAVA PROGRAMMES\\ScreenShots\\google.png");
FileHandler.copy(Source,Destination);
driver.quit();
	}

}
