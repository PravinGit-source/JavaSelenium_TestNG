package Selenium4_Locators;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiple_Windows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.get("https://www.rahulshettyacademy.com/angularpractice/");
driver.manage().window().maximize();
driver.switchTo().newWindow(WindowType.TAB);
//driver.switchTo().newWindow(WindowType.WINDOW);
Set<String> allwindowID = driver.getWindowHandles();
Iterator <String>itr = allwindowID.iterator();
String ParentWindowID = itr.next();
String ChildWindowID = itr.next();
driver.switchTo().window(ChildWindowID);
driver.get("https://rahulshettyacademy.com/");
String CourseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
driver.switchTo().window(ParentWindowID);
driver.findElement(By.xpath("//input[@name='name']")).sendKeys(CourseName);
driver.quit();

	}

}
