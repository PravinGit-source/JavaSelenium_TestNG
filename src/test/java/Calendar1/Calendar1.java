package Calendar1;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers"); // 🔹 Replace with actual webpage URL
        driver.manage().window().maximize();

        selectTodayDate(driver);
Thread.sleep(2000);
        driver.quit();
    }

    public static void selectTodayDate(WebDriver driver) throws InterruptedException {
        // Get today’s date
        LocalDate date = LocalDate.now().plusDays(150);
        int day = date.getDayOfMonth();
        String month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int year = date.getYear();
        String targetMonthYear = month + " " + year;

        // Open calendar widget
        driver.findElement(By.cssSelector(".react-date-picker__calendar-button")).click();
        Thread.sleep(1000);

        // Navigate to correct month and year
        while (true) {
            String currentMonthYear = driver.findElement(
                    By.cssSelector(".react-calendar__navigation__label__labelText--from"))
                    .getText();

            if (currentMonthYear.equalsIgnoreCase(targetMonthYear)) {
                break;
            } else {
                driver.findElement(By.cssSelector(".react-calendar__navigation__next-button")).click();
            }
            Thread.sleep(300);
        }

        // Select today’s date
        String fullLabel = day + " " + month + " " + year;
        driver.findElement(By.xpath("//abbr[@aria-label='" + fullLabel + "']")).click();

        System.out.println("✅ Selected today’s date: " + fullLabel);
    }
}
