package web.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import web.pages.AppliancesPage;

public class AppliancesPageMatcher {
    AppliancesPage page;
    private Logger logger = LogManager.getLogger(AppliancesPageMatcher.class);

    public AppliancesPageMatcher(AppliancesPage page) {
        this.page = page;
    }

    public void checkPageTitleText (String expected) {
        page=new AppliancesPage(WebDriverFactory.getCurrentDriver());
        Assertions.assertEquals(expected, page.getTextAppliances(), "Текст Бытовая техника не отображается");
        logger.info("Текст- 'Бытовая техника' отображен!");
    }
}