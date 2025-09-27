package Static_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Static_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); 
	    driver.manage().window().maximize();
	    WebElement staticdropdown = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
	    Select dropdown = new Select(staticdropdown);
	    dropdown.selectByIndex(2);
	    Thread.sleep(1000);
	    System.out.println(dropdown.getFirstSelectedOption().getText());
	    dropdown.selectByValue("INR");
	    Thread.sleep(1000);
	    System.out.println(dropdown.getFirstSelectedOption().getText());
	    dropdown.selectByVisibleText("USD");
	    Thread.sleep(1000);
	    System.out.println(dropdown.getFirstSelectedOption().getText());
	    driver.quit();

	}

}
