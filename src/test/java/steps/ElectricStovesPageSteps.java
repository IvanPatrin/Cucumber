package steps;

import web.matchers.ElectricStovesPageMatcher;
import web.drivers.WebDriverFactory;
import web.pages.ElectricStovesPage;
import io.cucumber.java.ru.Тогда;

public class ElectricStovesPageSteps {

    // Шаг: Проверка, что количество категорий больше 100
    @Тогда("Проверка, что количество электрических плит больше 100")
    public void checkElectricStoveCount(int expectedCountStoves) {
        ElectricStovesPage electricStovesPage = new ElectricStovesPage(WebDriverFactory.getCurrentDriver());
        ElectricStovesPageMatcher electricStovesPageMatcher = new ElectricStovesPageMatcher(electricStovesPage);
        int actualCountStoves = electricStovesPage.getStoveCount();
        electricStovesPageMatcher.checkStoveCount(expectedCountStoves, actualCountStoves);
    }
}
