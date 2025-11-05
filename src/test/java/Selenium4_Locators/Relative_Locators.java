package Selenium4_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// ✅ Import static relative locator
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Relative_Locators {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();

        WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));



        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

        WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));

        driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

        WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();



        WebElement rdb = driver.findElement(By.id("inlineRadio1"));



        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
        driver.quit();

    }
}
