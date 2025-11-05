package Scroll;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.get("https://rahulshettyacademy.com/AutomationPractice/");
driver.manage().window().maximize();
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,500)");
Thread.sleep(3000);
js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
List <WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
int sum=0;
for(int i=0; i<values.size();i++)
{
	sum=sum+Integer.parseInt(values.get(i).getText());
}
System.out.println(sum);
System.out.println(driver.findElement(By.cssSelector(".totalAmount")).getText());
String Stringtotal = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
System.out.println(Stringtotal);
int Inttotal = Integer.parseInt(Stringtotal);
System.out.println(Inttotal);
Assert.assertEquals(sum, Inttotal, "The calculated sum does not match the total amount displayed!");
driver.quit();

	}

}
