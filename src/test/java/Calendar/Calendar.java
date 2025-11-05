package Calendar;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.spicejet.com/");

        Thread.sleep(5000); // Wait for homepage to load fully

        // ---- SOURCE ----
        WebElement srcInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//input[@type='text'])[1]") // First input = Source
        ));
        srcInput.click();
        Thread.sleep(500);

        WebElement srcOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(text(),'Mumbai')]")
        ));
        srcOption.click();
        System.out.println("✅ Source selected: Mumbai");

        // ---- DESTINATION ----
        WebElement destInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//input[@type='text'])[2]") // Second input = Destination
        ));
        destInput.click();
        Thread.sleep(500);

        WebElement destOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(text(),'Delhi')]")
        ));
        destOption.click();
        System.out.println("✅ Destination selected: Delhi");

        // ---- SELECT TOMORROW'S DATE ----
        LocalDate date = LocalDate.now().plusDays(0);
        String SelectedDate = String.valueOf(date.getDayOfMonth());

        // Click on departure date input
        WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']")
        ));
        dateInput.click();
        Thread.sleep(1000);

        boolean dateSelected = false;
        int attempts = 0;

        while (!dateSelected && attempts < 2) { // try up to 2 times
            List<WebElement> allDates = driver.findElements(
                    By.xpath("//div[contains(@data-testid,'undefined-calendar-day-')]//div[contains(@class,'r-homxoj')]")
            );

            for (WebElement d : allDates) {
                if (d.getText().trim().equals(SelectedDate)) {
                    d.click();
                    dateSelected = true;
                    System.out.println("✅ Selected Date: " + SelectedDate);
                    break;
                }
            }

            if (!dateSelected) {
                // Sometimes the calendar needs another click to render next month
                dateInput.click();
                Thread.sleep(500);
                attempts++;
            }
        }

        if (!dateSelected) {
            System.out.println("❌ Tomorrow's date not found in calendar");
        }

        Thread.sleep(2000);
        
//        System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).isEnabled()
//        );
//        driver.findElement(By.xpath("//div[text()='round trip']")).click();
//        System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).isEnabled()
//        );
        
System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style"));
//driver.findElement(By.xpath("//div[text()='round trip']")).click();       
System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style"));
String style = driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']"))
.getDomAttribute("style");
if(style.contains("rgb(238, 238, 238)")) 
{
System.out.println("Dropdown is disabled");
Assert.assertTrue(true);

} 
else 
{
System.out.println("Dropdown is enabled");
Assert.assertTrue(false);

}
driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
Thread.sleep(1000);
for (int i = 0; i < 4; i++) 
{
    WebElement plusButton = driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']"));
    plusButton.click();
    Thread.sleep(500); // small wait to allow UI to update after each click
}
driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//div[text()='Senior Citizen']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//div[text()='Senior Citizen Discount']/ancestor::div[1]/following-sibling::div//*[local-name()='svg' and @data-testid='svg-img']")).click();
Thread.sleep(5000);	
driver.findElement(By.xpath("//div[@data-focusable='true' and .//div[text()='Continue']]")).click();
Thread.sleep(2000);
driver.quit();

	}
}
