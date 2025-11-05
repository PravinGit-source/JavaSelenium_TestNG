package Broken_Links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Broken_URL {

    public static void main(String[] args) throws MalformedURLException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.xpath("//li[contains(@class,'gf-li')]/a"));
        SoftAssert s = new SoftAssert();

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(link.getText() + " → " + respCode);

            if (respCode > 400) {
                System.out.println("❌ Broken link: " + link.getText() + " (" + respCode + ")");
                s.assertTrue(false, link.getText() + " link is broken. Response Code: " + respCode);
            }
        }

        s.assertAll();  
        driver.quit();
    }
}
