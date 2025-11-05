package AddToCart;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        driver.manage().window().maximize();
        
        List<String> al = new ArrayList<>();
        al.add("Cucumber");
        al.add("Brocolli");
        al.add("Beetroot");
        al.add("Potato");
        
        addItems(driver, al); // ✅ calling the separate method
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[@type='button' and contains(text(),'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.cartTable")));       
        driver.findElement(By.xpath("//input[@class='promoCode' and @placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn' and contains(text(),'Apply')]")).click();
WebElement promoMessage = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
        System.out.println(promoMessage.getText());
        
        
        
	}
	
	
	public static void addItems(WebDriver driver, List<String> itemsList)
	{
		int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        
        for (int i = 0; i < products.size(); i++)
        {
        	String name[] = products.get(i).getText().split("-");
        	String formattedName = name[0].trim();
        	
        	if (itemsList.contains(formattedName))
        	{
        		j++;
        		driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
        		if (j == itemsList.size())
        			break;
        	}
        }
	}

}