package web.pages;

import org.openqa.selenium.support.CacheLookup;
import web.elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AppliancesPage extends BasePage{
    private Logger logger = LogManager.getLogger(AppliancesPage.class);


    public AppliancesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "subcategory__page-title")
    private WebElement  textAppliances;
    @FindBy(xpath = "//span[text() = 'Техника для кухни']")
    private WebElement linkKitchenAppliances;

    public String getTextAppliances() {
        return textAppliances.getText();
    }

    public Link getLinkKitchenAppliances() {
        return new Link(linkKitchenAppliances);
    }

}