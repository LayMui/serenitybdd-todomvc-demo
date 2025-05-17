
package net.serenitybdd.demos.todos.cucumber;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HealeniumTest {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--disable-web-security");
        options.addArguments("--user-data-dir=/tmp/chrome-profile");

        WebDriver originalDriver = new ChromeDriver(options);
        WebDriver driver = SelfHealingDriver.create(originalDriver);

        driver.get("http://localhost:9300/");

        try {
            WebElement element = driver.findElement(By.cssSelector(".new-todo"));  // Intentionally incorrect
            element.sendKeys("Test");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

