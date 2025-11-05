package IFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.get("http://jqueryui.com/droppable/");
driver.manage().window().maximize();
System.out.println(driver.findElements(By.tagName("iframe")).size());
//driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
driver.switchTo().frame(0);
driver.findElement(By.id("draggable")).click();
Actions a = new Actions(driver);
WebElement source = driver.findElement(By.id("draggable"));
WebElement target = driver.findElement(By.id("droppable"));
a.dragAndDrop(source, target).build().perform();
driver.switchTo().defaultContent();
driver.findElement(By.xpath("//a[text()='Autocomplete']")).click();
Thread.sleep(2000);
driver.quit();




	}

}
