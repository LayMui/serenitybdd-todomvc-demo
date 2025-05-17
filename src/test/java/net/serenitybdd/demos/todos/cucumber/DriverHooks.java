import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHooks {

    public static SelfHealingDriver createSelfHealingDriver() {
        ChromeDriver chromeDriver = new ChromeDriver();
        return SelfHealingDriver.create(chromeDriver);
    }
}
