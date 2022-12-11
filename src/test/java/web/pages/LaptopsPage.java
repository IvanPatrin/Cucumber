package web.pages;

import web.elements.*;
import web.helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LaptopsPage extends BasePage {

    @FindBy(xpath ="//header")
    WebElement header;
    @FindBy(xpath = "//span[text() = 'Производитель']//parent::a/following-sibling::div/descendant::label[@class = 'ui-checkbox ui-checkbox_list']")
    List<WebElement> manufacturerCheckbox;
    @FindBy(xpath = "//span[text() = 'Объем оперативной памяти (ГБ)']")
    WebElement ramChecklist;
    @FindBy(xpath = "//span[@class=\"ui-collapse__link-text\" and text()=\"Объем оперативной памяти (ГБ)\"]/../../div//label/span[1]")
    List<WebElement> ramCheckbox;
    @FindBy(xpath = "//button[text() = 'Применить']")
    WebElement applyButton;
    @FindBy(xpath = "//span[text()='Сортировка:']")
    WebElement sortSelectButton;
    @FindBy(xpath = "//div[@class = 'top-filter__radio-list ui-radio top-filter__popover'][1]//span")
    List<WebElement> sortRadioButton;
    @FindBy(xpath = "//a[@class = 'catalog-product__name ui-link ui-link_black'][1]")
    WebElement firstLaptopLink;

    public LaptopsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Block getHeader() {
        return new Block(header);
    }

    public CheckBox getManufacturerCheckbox(String company) {
        for (WebElement webElement : manufacturerCheckbox) {
            if (webElement.getText().contains(company)) {
                return new CheckBox(webElement);
            }
        }
        return null;
    }

    public Accordeon getRamChecklist() {
        return new Accordeon(ramChecklist);
    }

    public CheckBox getRamCheckbox(String ram) {
        for (WebElement webElement : ramCheckbox) {
            if(webElement.getText().contains(ram)) {
                return new CheckBox(webElement);
            }
        }
        return null;
    }

    public Button getApplyButton() {
        return new Button(applyButton);
    }

    public Button getSortSelectButton() {
        return new Button(sortSelectButton);
    }

    public RadioButton getSortRadioButton(String sort) {
        for (WebElement webElement : sortRadioButton) {
            if(webElement.getText().contains(sort)) {
                return new RadioButton(webElement);
            }
        }
        return null;
    }

    public Link getFirstLaptopLink() {
        WaitHelper.visibilityOfElement(firstLaptopLink);
        return new Link(firstLaptopLink);
    }
}
