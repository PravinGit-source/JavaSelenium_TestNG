package Duplicate_Elements;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Duplicate_Elements_ListBox1 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // Find all <option> tags inside the dropdown (colors)
        List<WebElement> options = driver.findElements(By.xpath("//select[@id='colors']/option"));

        Set<String> uniqueOptions = new HashSet<>();
        boolean flag = false;

        for (WebElement option : options) {
            String optionText = option.getText().trim();  // Get visible text
            if (!uniqueOptions.add(optionText)) {
                System.out.println("Duplicate Element Found - " + optionText);
                flag = true;
            }
        }

        if (!flag) {
            System.out.println("No Duplicate Element Found");
        }

        driver.quit();
    }
}