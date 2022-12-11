package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import web.helpers.NavigationHelper;
import web.helpers.ScreenshotHelper;
import web.listener.Selenium4Listener;
import web.pages.LaptopsPage;
import io.cucumber.java.ru.И;

public class LaptopsPageSteps {

    // Переменная в которую положим название первого элемента после сортировки для дальнейшей проверки
    public static String expectedNameTitle;



    Selenium4Listener listener = new Selenium4Listener();
    WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(WebDriverFactory.getCurrentDriver());

    // Ссылка на объект класса LaptopPage
    LaptopsPage laptopsPage = new LaptopsPage(WebDriverFactory.getCurrentDriver());

    // Шаг: Скрыть блок страницы header
    @И("Скрыть блок страницы header")
    public void hideHeader() {
        laptopsPage.getHeader().hide();
        // Скриншот всей страницы
        ScreenshotHelper.makeScreenshot();
    }

    // Шаг: Выбор производителя
    @И("Выбор производителя {string}")
    public void choseManufacturerCheckbox(String manufacturer) {
        JavaScriptHelper.scrollBy(0,600);
        laptopsPage.getManufacturerCheckbox(manufacturer).setChecked(true);
    }

    // Шаг: Выбор объёма оперативной памяти
    @И("Выбор объёма оперативной памяти {string}")
    public void choseRam(String ram) {
        JavaScriptHelper.scrollBy(0, 600);
        laptopsPage.getRamChecklist().show();
        JavaScriptHelper.scrollBy(0, 600);
        laptopsPage.getRamCheckbox(ram).setChecked(true);
    }
    // Шаг: Нажатие на кнопку Применить
    @И("Нажатие на кнопку \"Применить\"")
    public void clickButtonApplay() {
        JavaScriptHelper.scrollBy(0, 600);
        laptopsPage.getApplyButton().click();

        // Скриншот всей страницы
        ScreenshotHelper.makeScreenshot();
    }

    // Шаг: Применение сортировки
    @И("Применение сортировки {string}")
    public void sort(String sort) {
        laptopsPage.getSortSelectButton().click();
        laptopsPage.getSortRadioButton(sort).setSelected(true);

        // Скриншот всей страницы
        ScreenshotHelper.makeScreenshot();
    }

    // Шаг: Выполнен переход на страницу первого ноубука в списке
    @И("Выполнен переход на страницу первого продукта в списке")
    public void goFirstLink() {
        // Сохранение названия ноутбука в переменную для дальнейшей проверки
        expectedNameTitle = laptopsPage.getFirstLaptopLink().getText();
        expectedNameTitle = expectedNameTitle.substring(0, expectedNameTitle.indexOf("["));

        // Нажатие на ссылку первого продукта в списке
        laptopsPage.getFirstLaptopLink().openInNewWindow();

        // Скриншот всей страницы
        ScreenshotHelper.makeScreenshot();
    }
}