package hooks;

import web.drivers.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverHooks {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(DriverHooks.class);

    // Чтение передаваемого параметра browser (-Dbrowser)
    String env = System.getProperty("browser", "chrome");

    // Чтение передаваемого параметра pageLoadStrategy (-Dloadstrategy)
    String loadStrategy = System.getProperty("loadstrategy", "normal");

    @Before
    public void startDriverBeforeScenario() {
        driver = WebDriverFactory.getDriver(env.toLowerCase(), loadStrategy.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @After
    public void stopDriverAfterScenario() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
