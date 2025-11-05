package Sorting;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        String itemName = "Carrot";  // ✅ You can change this dynamically
        boolean itemFound = false;
        String price = null;

        // Keep clicking "Next" until item is found or no more pages
        while (true) {

            // Step 1: Capture all items on the current page
            List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));

            // Step 2: Use stream to find price for the given item name
            List<String> prices = items.stream()
                    .filter(s -> s.getText().equalsIgnoreCase(itemName))
                    .map(s -> s.findElement(By.xpath("following-sibling::td[1]")).getText())
                    .collect(Collectors.toList());
//🔹 Let’s look at what each step returns
//Step	Operation	Input Type	Output Type
//items.stream()	creates a stream	List<WebElement>	Stream<WebElement>
//.filter(...)	filters based on a condition	Stream<WebElement>	Stream<WebElement>
//.map(...)	transforms each element	Stream<WebElement>	Stream<String>
//.collect(...)	gathers results	Stream<String>	List<String>
            if (!prices.isEmpty()) {
                price = prices.get(0);
                itemFound = true;
                break;  // Stop once found
            }

            // Step 3: Locate "Next" button and check if it's disabled
            WebElement nextBtn = driver.findElement(By.xpath("//a[@aria-label='Next']"));
            String disabled = nextBtn.getAttribute("aria-disabled");

            if (disabled != null && disabled.equals("true")) {
                break;  // Stop if last page reached
            }

            // Step 4: Go to next page
            nextBtn.click();
            Thread.sleep(1000);  // small wait for page data to refresh
        }

        // Step 5: Print the result
        if (itemFound) {
            System.out.println("✅ Price of " + itemName + ": " + price);
        } else {
            System.out.println("❌ " + itemName + " not found across pages.");
        }

        driver.quit();
    }
}
