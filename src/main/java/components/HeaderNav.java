package components;

import components.enums.HeaderNavMenuComponents;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


@Slf4j
@Getter
public class HeaderNav {

    private static WebDriver driver;
    private static WebDriverWait wait;


    @FindBy(xpath="//a[@title='Log in to your customer account']")
    private WebElement loginNavButton;

    @FindBy(xpath = "//button[@class='hidden-sm-down btn-unstyle']")
    private WebElement langDropDown;

    @FindBy(xpath = "//ul[@class='dropdown-menu hidden-sm-down']//li")
    private List<WebElement> languagesList;

    @FindBy(xpath = "//ul[@class='dropdown-menu hidden-sm-down']//li//a[text()='Українська']")
    private WebElement ukrLangItem;

    @FindBy(xpath="//a[@class='account']//span[@class='hidden-sm-down']")
    WebElement accountName;


    public HeaderNav(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 6);
        PageFactory.initElements(driver, this);
    }

    public  HeaderNav selectNavMenuItem(HeaderNavMenuComponents headerMenuItem){
        switch(headerMenuItem){
            case LANGUAGE_DROPDOWN:
                log.info("select and click on localization drop down item by locator{}",langDropDown);
                langDropDown.click();
                break;
            case SIGN_IN:
                log.info("select and click SIGN_IN navigation menu item by locator{}",loginNavButton);
                loginNavButton.click();
                break;
        }
        return this;
    }

    public int checkNumberOfLanguages(){
        log.info("count the number of languages");
        return languagesList.size();
    }

    public boolean getTextUkrItem(String language){
        log.info("check whether ukr item exists in the languages list");
        for(int i = 0; i <languagesList.size(); i++){
            if(languagesList.get(i).getText().equals(language)){
                return true;
            }
        }
        return false;
    }

    public String getUserAccountName(){
        log.info("check whether user account name appears in the nav menu and get its text by locator{}",accountName);
        return accountName.getText();
    }

}
