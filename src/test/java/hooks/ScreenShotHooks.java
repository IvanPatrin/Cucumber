package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import web.drivers.WebDriverFactory;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

public class ScreenShotHooks {


    // Действия совершаемые перед каждым шагом
    @BeforeStep
    public void takeScreenShotBeforeStep() {
        WebDriver driver = WebDriverFactory.getCurrentDriver();
        // Сделать скриншот видимой области веб страницы
        try {
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\Screenshot-" + Timestamp.from(Instant.now()).getTime() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Действия совершаемые после каждого шага
    @AfterStep
    public void takeScreenShotAfterStep() {
        WebDriver driver = WebDriverFactory.getCurrentDriver();
        // Сделать скриншот видимой области веб страницы
        try {
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\Screenshot-" + Timestamp.from(Instant.now()).getTime() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}