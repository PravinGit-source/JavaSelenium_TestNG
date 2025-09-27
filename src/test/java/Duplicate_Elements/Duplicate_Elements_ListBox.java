package Duplicate_Elements;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Duplicate_Elements_ListBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.get("https://testautomationpractice.blogspot.com/");
driver.manage().window().maximize();
WebElement listboxElement = driver.findElement(By.xpath("//select[@id='colors']"));
//WebElement listboxElement = driver.findElement(By.xpath("//select[@id='animals']"));

//List<WebElement> al= new ArrayList();
Select listbox = new Select(listboxElement);
Set <String> uniqueoptions = new HashSet<>();
boolean flag =false;
for (WebElement option:listbox.getOptions())
{
	String optiontext = option.getText();
	if (!uniqueoptions.add(optiontext))
	{
		System.out.println("Duplicate Element Found - "+optiontext);
		flag=true;
	}
}
if(flag==false)
{
	System.out.println("No Duplicate Element Found");
}
driver.quit();
	}

}
