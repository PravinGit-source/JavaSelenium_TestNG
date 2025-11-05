package Sorting;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Search {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        String searchItem = "Rice"; // 🔍 You can change this value

        // 1️⃣ Locate and type in the search box
        WebElement searchBox = driver.findElement(By.id("search-field"));
        searchBox.clear();
        searchBox.sendKeys(searchItem);

        Thread.sleep(1000); // wait for table results to update

        // 2️⃣ Capture all visible product names (first column)
        List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));

        // 3️⃣ Use Streams + Lambda to check if item is present
        boolean isPresent = items.stream()
                .map(s -> s.getText()) // Lambda expression to get text
                .anyMatch(text -> text.equalsIgnoreCase(searchItem));

        // 4️⃣ Print result
        if (isPresent) {
            System.out.println("✅ '" + searchItem + "' is present in the filtered table.");
        } else {
            System.out.println("❌ '" + searchItem + "' not found in the filtered table.");
        }

        driver.quit();
    }
}
