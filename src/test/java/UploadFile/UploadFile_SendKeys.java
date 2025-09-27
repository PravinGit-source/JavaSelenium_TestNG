package UploadFile;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile_SendKeys {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
WebDriver driver =new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.foundit.in/upload");
driver.manage().window().maximize();
driver.findElement(By.xpath("//div[contains(text(),'Upload Resume')]")).click();
Thread.sleep(2000);
//WebElement uploadElement = driver.findElement(By.xpath("//input[@id='file-upload']"));
//uploadElement.sendKeys("D:\\FileUpload\\FileUpload.docx");
  JavascriptExecutor js = (JavascriptExecutor) driver;
  js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@id='file-upload']")));
  Thread.sleep(2000);
  StringSelection filepathselection = new StringSelection ("D:\\FileUpload\\FileUpload.docx");
  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathselection, null);
  Thread.sleep(2000);
  Robot rb = new Robot();
  rb.keyPress(KeyEvent.VK_CONTROL);
  rb.keyPress(KeyEvent.VK_V);
  rb.keyRelease(KeyEvent.VK_V);
  rb.keyRelease(KeyEvent.VK_CONTROL);
 
  Thread.sleep(2000);
  rb.keyPress(KeyEvent.VK_ENTER);
  rb.keyRelease(KeyEvent.VK_ENTER);


	}

} 