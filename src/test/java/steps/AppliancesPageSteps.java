package steps;


import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import web.drivers.WebDriverFactory;
import web.helpers.ScreenshotHelper;
import web.matchers.AppliancesPageMatcher;
import web.pages.AppliancesPage;

public class AppliancesPageSteps {
    AppliancesPage appliancesPage = new AppliancesPage(WebDriverFactory.getCurrentDriver());
    AppliancesPageMatcher appliancesPageMatcher = new AppliancesPageMatcher(appliancesPage);

    // Шаг: Открыта страница "Бытовая техника"
    @Дано("Открыта страница \"Бытовая техника\"")
    public void openAppliancesPage() {
        ScreenshotHelper.makeScreenshot();
    }

    // Шаг: Проверка отображения текста Бытовая техника
    @Тогда("Проверка: Отображение текста Бытовая техника")
    public void assertPageTitle(String expectedTitle) {
        appliancesPageMatcher.checkPageTitleText(expectedTitle);
    }

    // Шаг: Выполнен переход по ссылке "Техника для кухни"
    @И("Выполнен переход по ссылке \"Техника для кухни\"")
    public void goToKitchenAppliance() {
        appliancesPage.getLinkKitchenAppliances().scrollToLink();
        appliancesPage.getLinkKitchenAppliances().click();
        ScreenshotHelper.makeScreenshot();
    }
}
