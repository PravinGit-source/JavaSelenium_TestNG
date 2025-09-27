package InfiniteScrolling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementCount_Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.get("https://www.booksbykilo.in/new-books");
driver.manage().window().maximize();
//Wait until at least one product h3 is present
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='productsDiv']//h3")));
JavascriptExecutor js = (JavascriptExecutor) driver;


int previouscount=0;
int currentcount=0;
while(true)
{
	List <WebElement> books = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
	currentcount=(books.size());
	if(currentcount==previouscount)
	{
		break;
	}
	previouscount=currentcount;
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	Thread.sleep(2000);
	
}
System.out.println("Total Number of Books are "+currentcount);
driver.quit();

//div[@id='productsDiv']/descendant::div/h3

	}

}
