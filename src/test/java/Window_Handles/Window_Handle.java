package Window_Handles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_Handle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']")).click();
		Set<String> allwindowId=driver.getWindowHandles();
		int count = allwindowId.size();
		System.out.println(count);
		Iterator <String> itr = allwindowId.iterator();
		String ParentWindow = itr.next();
		String ChildWindow = itr.next();
//		String ParentWindow = driver.getWindowHandle();
//		for(String ChildWindow:allwindowId)	
		driver.switchTo().window(ChildWindow);
		System.out.println("ParentWindowID = "+ParentWindow+" "+"ChildWindowID = "+ChildWindow);
		String Text = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		System.out.println(Text);
		String splittedtext=Text.split("at")[1].trim().split(" ")[0].split("@")[1];
		System.out.println(splittedtext);
		driver.switchTo().window(ParentWindow);
		driver.findElement(By.id("username")).sendKeys(splittedtext);
	
		
	}

}
