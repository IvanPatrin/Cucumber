package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import web.helpers.JavaScriptHelper;
import web.listener.Selenium4Listener;
import web.matchers.StartPageMatcher;
import web.drivers.WebDriverFactory;
import web.helpers.NavigationHelper;
import web.helpers.ScreenshotHelper;
import web.helpers.WindowHelper;
import web.pages.ElectricStovesPage;
import web.pages.StartPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.pages.StovesPage;

import java.util.List;

public class StartPageSteps {

    private static Logger logger = LogManager.getLogger(StartPageSteps.class);

    Selenium4Listener listener = new Selenium4Listener();
    WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(WebDriverFactory.getCurrentDriver());
    StartPage startPage = new StartPage(eventFiringWebDriver);
    private List<String> actualListAppliances;
    private int actualCountMakeCooking;


    // Шаг: Открыта страница "DNS"
    @Дано("Открыта страница \"DNS\"")
    public void openStartPage() {
        // Открытие сайта DNS
        startPage.openPage();
        logger.info("Открыта страница DNS - " + "https://www.dns-shop.ru/");
        ScreenshotHelper.makeScreenshot();

        // Нажатие кнопки всё верно для дальнейшего тестирования
        startPage.getOkayButton().click();
        ScreenshotHelper.makeScreenshot();
    }

    // Шаг: Выведен заголовк страницы
    @Когда("Выведен заголовк страницы")
    public void getStartPageTitle(){
        // Вывод в логи заголовка страницы
        logger.info("Заголовок - " + startPage.getPageTitle());
    }

    // Шаг: Выведен текущий URL
    @И("Выведен текущий URL")
    public void getStartPageURL(){
        // Вывод в логи текущего URL
        logger.info("Текущий URL - " + startPage.getCurrentURL());
    }

    // Шаг: Выведен размер окна
    @И("Выведен размер окна")
    public void getStartPageSize(){
        // Вывод в логи размера окна браузера
        WindowHelper.getWindowWidth();
        WindowHelper.getWindowHeight();
    }

    // Шаг: Выполнен переход на страницу Бытовая техника
    @И("Выполнен переход на страницу \"Бытовая техника\"")
    public void goToAppliancesPage() {
        // Переход по ссылке Бытовая техника;
        JavaScriptHelper.scrollTo(0, 0);
        startPage.getAppliancesLink().click();
        ScreenshotHelper.makeScreenshot();
    }

    // Шаг: Перемещение курсора на Бытавую технику
    @Когда("Перемещение курсора на \"Бытовая техника\"")
    public void focusOnAppliancesLink() {
        // Переходим по ссылке Бытовая техника
        startPage.getAppliancesLink().focusOnLink();
        ScreenshotHelper.makeScreenshot();

        // Получение ссылок для проверки
        actualListAppliances = startPage.getListLinksAppliances();
    }

    // Шаг: Перемещение курсор на Приготовление пищи
    @И("Перемещение курсор на \"Приготовление пищи\"")
    public void focusOnCookingLink() {
        // Переходим по ссылке Бытовая техника
        startPage.getAppliancesLink().scrollToLink();
        startPage.getAppliancesLink().focusOnLink();
        startPage.getCookingLink().focusOnLink();
        ScreenshotHelper.makeScreenshot();

        // Получение размера листа в подменю 'Приготовление пищи'
        startPage.getAppliancesLink().focusOnLink();
        startPage.getCookingLink().focusOnLink();
        actualCountMakeCooking = startPage.getSizeListCooking();
    }

    // Шаг: Выполнен переход на страницу Плиты и печи
    @Когда("Выполнен переход на страницу \"Плиты и печи\"")
    public void goStovesPage() {
        // Перемещаем курсор на плиты и кликаем
        startPage.getAppliancesLink().focusOnLink();
        startPage.getStovesLink().focusOnLink();
        startPage.getStovesLink().click();
        ScreenshotHelper.makeScreenshot();
    }

    // Шаг: Проверка на отображение ссылок (Встраиваемая техника, Техника для кухни, Техника для дома)
    @Тогда("Проверка: Отображение ссылок (Встраиваемая техника, Техника для кухни, Техника для дома)")
    public void checkListLinksAppliances(List<String> expectedListAppliance) {
        StartPageMatcher startPageMatcher = new StartPageMatcher(startPage);
        startPageMatcher.checkListLinksAppliances(expectedListAppliance, actualListAppliances);
    }

    // Шаг: Проверка: колиечства ссылок в подменю 'Приготовление пищи' больше <n>
    @Тогда("Проверка: колиечства ссылок в подменю \"Приготовление пищи\" больше 5")
    public void checkSizeListCooking(int expectedCountMakeCooking) {
        StartPageMatcher startPageMatcher = new StartPageMatcher(startPage);
        startPageMatcher.checkSizeListCooking(expectedCountMakeCooking, actualCountMakeCooking);
    }

    // Шаг: Выполнен переход по ссылке Электрические плиты
    @И("Выполнен переход по ссылке \"Электрические плиты\"")
    public void goElectricStovePage() {
        StovesPage stovesPage = new StovesPage(WebDriverFactory.getCurrentDriver());
        // Переходим по ссылке Плиты электрические
        stovesPage.getLinkElectricStove().scrollToLink();
        stovesPage.getLinkElectricStove().click();
        ScreenshotHelper.makeScreenshot();
    }

    // Шаг: Выполнен переход по ссылке Ноутбуки
    @И("Выполнен переход по ссылке \"Ноутбуки\"")
    public void goLaptopsPage() {
        NavigationHelper.refresh();
        // Перемещение курсора на ПК, ноутбуки, периферия
        startPage.getComputerLink().focusOnLink();

        // Скриншот всей страницы
        ScreenshotHelper.makeScreenshot();

        // Переход по ссылке Ноутбуки
        startPage.getLaptopsLink().click();

        // Скриншот всей страницы
        ScreenshotHelper.makeScreenshot();
    }
}