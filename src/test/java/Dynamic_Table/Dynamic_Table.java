package Dynamic_Table;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Table {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.expandtesting.com/dynamic-table");
        driver.manage().window().maximize();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
        System.out.println("Row count: " + rows.size());

        // Step 1: Print all browser names
        for (int r = 0; r < rows.size(); r++) {
            WebElement name = rows.get(r).findElement(By.xpath("./td[1]"));
            System.out.println("Browser: " + name.getText());
        }

        // Step 2: Check Chrome's CPU load
        try {
            String tableCpu = driver.findElement(
                By.xpath("//tr[td[normalize-space()='Chrome']]/td[contains(text(),'%')]")).getText();

            String summaryCpu = driver.findElement(By.id("chrome-cpu")).getText();

            System.out.println("Table CPU: " + tableCpu);
            System.out.println("Summary CPU: " + summaryCpu);

            if (summaryCpu.contains(tableCpu)) {
                System.out.println("✅ CPU Load of Chrome is equal");
            } else {
                System.out.println("❌ CPU Load of Chrome is not equal");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Chrome not found in the table this time.");
        }

        driver.quit();
    }
}