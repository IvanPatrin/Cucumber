package web.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.pages.ElectricStovesPage;

public class ElectricStovesPageMatcher {
    ElectricStovesPage page;
    private Logger logger = LogManager.getLogger(ElectricStovesPageMatcher.class);

    public ElectricStovesPageMatcher(ElectricStovesPage page) {
        this.page = page;
    }

    public void checkStoveCount(int expected, int actual){
        Assertions.assertTrue(actual > expected,"Количество товара в разделе 'Плиты электрические' меньше или равно 100.");
        logger.info("Количество товара 'Плиты электрические' больше 100!");
    }
}