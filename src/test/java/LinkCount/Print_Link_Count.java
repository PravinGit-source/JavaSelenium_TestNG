package LinkCount;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Print_Link_Count {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.get("http://qaclickacademy.com/practice.php");
driver.manage().window().maximize();
// Footer first column (Discount Coupons) links only
List<WebElement> couponLinks = driver.findElements(
    By.xpath("//h3[normalize-space()='Discount Coupons']/ancestor::ul[1]/li[position()>1]/a")
);

System.out.println("Total Discount Coupon links: " + couponLinks.size());

// Open each link in new tab
for (WebElement link : couponLinks) {
    String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
    link.sendKeys(clickOnLinkTab);
    Thread.sleep(2000);  // short wait
}
//window handle
Set<String> allwindowID= driver.getWindowHandles();
Iterator<String> itr = allwindowID.iterator();
String ParentWindowID = itr.next();
while(itr.hasNext())
{
	driver.switchTo().window(itr.next());
	System.out.println(driver.getTitle());
	driver.close(); // close that tab
}
driver.switchTo().window(ParentWindowID);
System.out.println(driver.getTitle());
driver.quit();
//System.out.println(driver.findElements(By.tagName("a")).size());
//WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
//System.out.println(footerdriver.findElements(By.tagName("a")).size());
//WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
//System.out.println(columndriver.findElements(By.tagName("a")).size());
//for(int i=1; i<columndriver.findElements(By.tagName("a")).size();i++)
//{
//	String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
//	columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
//	Thread.sleep(5000);
//}


	}

}
