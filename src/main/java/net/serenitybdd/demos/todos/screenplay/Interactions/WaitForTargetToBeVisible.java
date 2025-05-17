package net.serenitybdd.demos.todos.screenplay.interactions;

import com.epam.healenium.SelfHealingDriver;  // <- import here

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WaitForTargetToBeVisible implements Interaction {

    private final Target target;
    private final int timeoutInSeconds;

    public WaitForTargetToBeVisible(Target target, int timeoutInSeconds) {
        this.target = target;
        this.timeoutInSeconds = timeoutInSeconds;
    }

    public static WaitForTargetToBeVisible called(Target target, int timeoutInSeconds) {
        return instrumented(WaitForTargetToBeVisible.class, target, timeoutInSeconds);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver rawDriver = BrowseTheWeb.as(actor).getDriver();
    
          // ✅ Print out the actual WebDriver class
    System.out.println("[DEBUG] Using WebDriver implementation: " + rawDriver.getClass().getName());

    
        WebDriver driver = rawDriver;
        if (rawDriver instanceof com.epam.healenium.SelfHealingDriver) {
            driver = (com.epam.healenium.SelfHealingDriver) rawDriver;
        }
    
        String selector = target.getCssOrXPathSelector();
    
        By byLocator = (selector.startsWith("//") || selector.startsWith("(//"))
            ? By.xpath(selector)
            : By.cssSelector(selector);
    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }
}    