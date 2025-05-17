package net.serenitybdd.demos.todos.screenplay.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import com.epam.healenium.SelfHealingDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class WaitForElementToBeVisible implements Task {

    private By locator;
    private int timeoutInSeconds;

    public WaitForElementToBeVisible(By locator, int timeoutInSeconds) {
        this.locator = locator;
        this.timeoutInSeconds = timeoutInSeconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Get the Serenity-managed WebDriver (which should be SelfHealingDriver)
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        // Create SelfHealingDriverWait wrapping the driver
        SelfHealingDriverWait wait = new SelfHealingDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        // Wait until element is visible
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Optional: You can do something with the element if needed here
    }

    public static WaitForElementToBeVisible called(By locator, int timeoutInSeconds) {
        return new WaitForElementToBeVisible(locator, timeoutInSeconds);
    }
}
