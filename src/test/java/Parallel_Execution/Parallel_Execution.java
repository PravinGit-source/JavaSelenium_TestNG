package Parallel_Execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Parallel_Execution {

WebDriver driver;
@Test
void mytest1()
{
	driver=new ChromeDriver();
	driver.get("https://www.google.com");
	System.out.println(driver.getTitle());
	driver.quit();
}
@Test
void mytest2()
{
	driver=new ChromeDriver();
	driver.get("https://www.bing.com");
	System.out.println(driver.getTitle());
	driver.quit();
}

}
