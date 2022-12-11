package web.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.pages.KitchenAppliancesPage;

public class KitchenAppliancesPageMatcher {
    KitchenAppliancesPage page;
    private Logger logger = LogManager.getLogger(KitchenAppliancesPageMatcher.class);

    public KitchenAppliancesPageMatcher(KitchenAppliancesPage page) {
        this.page = page;
    }

    public void checkTextKitchenAppliances(String expected, String actual) {
        Assertions.assertEquals(expected,actual, "Текст техника для кухни не отображается");
        logger.info("Текст 'Техника для кухни' отображен!");
    }

    public void checkTextMakeKitchen(String expected, String actual) {
        Assertions.assertEquals(expected, actual, "Текст Собрать свою кухню не отображается");
        logger.info("Ссылка 'Собрать свою кухню' отображена!");
    }

    public void checkSizeKitchenAppliances(int expected, int actual){
        Assertions.assertTrue(actual>expected, "Количество категорий меньше 5");
        logger.info("Количество категорий больше 5");
    }

}
