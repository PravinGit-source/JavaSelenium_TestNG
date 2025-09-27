package Static_Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("autosuggest")).sendKeys("in");
		Thread.sleep(3000);
		List<WebElement> AllList = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for (WebElement option : AllList) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				Thread.sleep(3000);
				break;
			}

		}
		driver.close();
	}

}
