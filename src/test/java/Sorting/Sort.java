package Sorting;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sort {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
driver.manage().window().maximize();
// Step 1: Click to sort on UI first
driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
Thread.sleep(2000);

// Step 2: Capture the visible sorted list from UI
List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
//List<String> uiList = elements.stream().map(WebElement::getText).collect(Collectors.toList());
List<String> uiList = elements.stream().map(s->s.getText()).collect(Collectors.toList());
//Use WebElement::getText when you only need to call a single method.
//Use s -> s.getText() if you plan to extend or modify the mapping logic later (e.g. .map(s -> s.getText().trim().toUpperCase())).
System.out.println("UI List after click: " + uiList);

// Step 3: Create a sorted copy using Java's sort
List<String> sortedList = uiList.stream().sorted().collect(Collectors.toList());
System.out.println("Expected Sorted List: " + sortedList);

// Step 4: Compare both
if (uiList.equals(sortedList)) {
    System.out.println("✅ UI sorting is correct on current page!");
} else {
    System.out.println("❌ UI sorting is incorrect on current page!");
}
Assert.assertTrue(uiList.equals(sortedList));
System.out.println("-------------------------------------------------------------------------------");
String itemName = "Wheat";  // ✅ You can change this dynamically

// Get all item name elements from first column
List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));

// Use stream to find the price for the given item name
List<String> prices = items.stream()
        .filter(item -> item.getText().equalsIgnoreCase(itemName))
        .map(item -> item.findElement(By.xpath("following-sibling::td[1]")).getText())
        .collect(Collectors.toList());
if (!prices.isEmpty()) {
    System.out.println("Price of " + itemName + ": " + prices.get(0));
} else {
    System.out.println(itemName + " not found in the list.");
}
driver.quit();
	}

}
