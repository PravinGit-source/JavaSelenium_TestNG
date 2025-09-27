package Ajax_Calls;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajax_Calls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.get("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");
driver.manage().window().maximize();
driver.findElement(By.xpath("//button[text()='Load AJAX Content']")).click();
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
WebElement w = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='AJAX Content Loaded']")));
System.out.println(w.getText());
driver.quit();
	}

}
