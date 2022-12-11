package steps;

import web.matchers.KitchenAppliancesPageMatcher;
import web.drivers.WebDriverFactory;
import web.pages.KitchenAppliancesPage;
import io.cucumber.java.ru.Тогда;

public class KitchenAppliancesPageSteps {

    KitchenAppliancesPage kitchenAppliancesPage = new KitchenAppliancesPage(WebDriverFactory.getCurrentDriver());
    KitchenAppliancesPageMatcher kitchenAppliancesPageMatcher = new KitchenAppliancesPageMatcher(kitchenAppliancesPage);

    // Шаг: Проверка отображения текста Техника для кухни
    @Тогда("Проверка: Отображение текста Техника для кухни")
    public void checkTextKitchenAppliancesPage(String expectedTitle) {
        kitchenAppliancesPage.getElementsKitchenAppliances();
        String actualTitle = kitchenAppliancesPage.getTextKitchenAppliances();
        kitchenAppliancesPageMatcher.checkTextKitchenAppliances(expectedTitle, actualTitle);
    }

    // Шаг: Проверка отображения текста Собрать свою кухню
    @Тогда("Проверка: Отображение ссылки Собрать свою кухню")
    public void checkLinkMakeKitchen(String expectedLink) {
        String actualLink = kitchenAppliancesPage.getTextMakeKitchen();
        kitchenAppliancesPageMatcher.checkTextMakeKitchen(expectedLink, actualLink);
    }

    // Шаг: Проверка, что количества категорий Техника для кухни больше чем 5
    @Тогда("Проверка: количества категорий Техника для кухни больше чем 5")
    public void checkCountKitchenAppliancesCategory(int expectedSize) {
        int actualSize = kitchenAppliancesPage.getSizeKitchenAppliances();
        kitchenAppliancesPageMatcher.checkSizeKitchenAppliances(expectedSize, actualSize);
    }
}
