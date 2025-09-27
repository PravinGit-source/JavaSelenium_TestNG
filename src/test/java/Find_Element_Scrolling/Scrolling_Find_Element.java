package Find_Element_Scrolling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scrolling_Find_Element {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booksbykilo.in/new-books");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		//Wait until at least one product h3 is present
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='productsDiv']//h3")));
//		JavascriptExecutor js = (JavascriptExecutor) driver;


boolean found = false;
		while(!found)
		{
			List <WebElement> books = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
for (WebElement book:books)
{
	if(book.getText().equals("Shakespeare"))
	{
		System.out.println("Book Found -"+book.getText());
		found=true;
		break;
	}
}
a.sendKeys(Keys.END).perform();
			//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(2000);
			
		}
		driver.quit();
	}

}
