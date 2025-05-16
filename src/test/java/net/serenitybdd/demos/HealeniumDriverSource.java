package net.serenitybdd.demos;

import com.epam.healenium.SelfHealingDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class HealeniumDriverSource implements DriverSource {

    @Override
    public WebDriver newDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setAcceptInsecureCerts(true);

            // Add any additional capabilities if needed
            WebDriver remoteWebDriver = new RemoteWebDriver(
                new URL("http://localhost:8085/wd/hub"), // Healenium proxy usually runs on port 8085
                capabilities
            );

            // Wrap with Healenium
            return SelfHealingDriver.create(remoteWebDriver);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create SelfHealingDriver", e);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
