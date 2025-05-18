package com.epam.healenium;

import com.epam.healenium.SelfHealingDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SerenityHealeniumDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
       
        System.out.println("Initializing Healenium WebDriver...");
        ChromeOptions options = new ChromeOptions();
        // Configure options as needed

        WebDriver delegate = new ChromeDriver(options);
        return SelfHealingDriver.create(delegate);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
