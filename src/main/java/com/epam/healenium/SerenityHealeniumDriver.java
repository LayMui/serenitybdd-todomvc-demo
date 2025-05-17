package com.epam.healenium;

import com.epam.healenium.SelfHealingDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SerenityHealeniumDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        WebDriver delegate = new ChromeDriver();
        return SelfHealingDriver.create(delegate);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
