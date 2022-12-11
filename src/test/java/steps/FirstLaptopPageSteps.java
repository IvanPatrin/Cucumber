package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import web.listener.Selenium4Listener;
import web.matchers.FirstLaptopPageMatcher;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import web.helpers.ScreenshotHelper;
import web.pages.FirstLaptopPage;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import static steps.LaptopsPageSteps.expectedNameTitle;

public class FirstLaptopPageSteps {

    Selenium4Listener listener = new Selenium4Listener();
    WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(WebDriverFactory.getCurrentDriver());

    FirstLaptopPage firstLaptopPage = new FirstLaptopPage(eventFiringWebDriver);
    FirstLaptopPageMatcher firstLaptopPageMatcher = new FirstLaptopPageMatcher(firstLaptopPage);

    // Шаг: Открытие страницы первого ноубука
    @И("Открытие страницы первого ноубука")
    public void onFirstLaptopPage() {
        JavaScriptHelper.scrollBy(0, 600);
        firstLaptopPage.getCharacteristicsButton().click();
    }

    // Шаг: Проверка: соответствие названия ноубука и названия первого ноутбука на предыдущей странице
    @Тогда("Проверка: соответствие названия ноубука и названия первого ноутбука на предыдущей странице")
    public void checkPageLaptopTitle() {
        // Проверка заголовка открытой по ссылке первого элемента страницы
        firstLaptopPageMatcher.checkPageLaptopTitle(expectedNameTitle);
    }

    // Шаг: Проверка: что в характеристиках заголовок содержит {string}
    @Тогда("Проверка: что в характеристиках заголовок содержит {string}")
    public void checkNameFromTextBlock(String company){
        firstLaptopPageMatcher.checkLaptopCharacteristicsTitle(company, firstLaptopPage.getCharacteristicsTitle());
    }

    // Шаг: Проверка: что в блоке Характеристики значение Объем оперативной памяти равно '<память>'
    @Тогда("Проверка: что в характеристиках объем оперативной памяти равен {string}")
    public void checkRamFromTextBlock(String ram) {
        // Проверка, что в блоке Характеристики значение Объем оперативной памяти равно 32 ГБ
        firstLaptopPageMatcher.checkRamText(ram, firstLaptopPage.getLaptopRamText());
    }
}
