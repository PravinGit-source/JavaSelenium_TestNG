package Static_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Dropdown_Loop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); 
	    driver.manage().window().maximize();
	    System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
	    Assert.assertFalse(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
	    driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
	    System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
	    Assert.assertTrue(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
	    System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	    driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
	    Thread.sleep(2000);
	    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	    int i=1;
	    while(i<5)
	    {
	    	driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
	    	i++;
	    }
	    
//	    for(int i=1; i<5; i++)
//	    {
//	    	driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
//	    }
	    Assert.assertEquals((driver.findElement(By.id("divpaxinfo")).getText()), "5 Adult");
	    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	    driver.quit();
	}

}
