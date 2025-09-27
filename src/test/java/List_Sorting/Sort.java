package List_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='colors']")));
		//Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
		
		ArrayList <String> originalList = new ArrayList<>();
		ArrayList <String>TempList = new ArrayList<>();
		List<WebElement> options= dropdown.getOptions();
		for(WebElement option:options)
		{
			originalList.add(option.getText());
			TempList.add(option.getText());
			
		}
		System.out.println("Before Sorting------------------");
		System.out.println("Original List "+originalList);
		System.out.println("Temp List "+TempList);
		Collections.sort(TempList);
		System.out.println("After Sorting------------------");
		System.out.println("Original List "+originalList);
		System.out.println("Temp List "+TempList);
		
		
		if (originalList.equals(TempList))
		{
			System.out.println("Dropdown is sorted");
		}
		else
		{System.out.println("Dropdown is not sorted");
			
		}
		
	}

}
