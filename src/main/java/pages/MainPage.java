package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Getter
@Slf4j
public class MainPage extends BasePage{

    @FindBy(xpath = "//iframe[@id='framelive']")
    private WebElement iframe;

    @FindBy(xpath = "//div[@id='loadingMessage']")
    private WebElement loader;

   @FindBy(xpath = "//footer//div[@class='container']//div[@class='block_newsletter col-lg-8 col-md-12 col-sm-12']")
   private WebElement blockNewsletter;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailFieldForSubscription;

    @FindBy(xpath = "//input[@class='btn btn-primary float-xs-right hidden-xs-down']")
    private WebElement buttonSubscribe;

    @FindBy(xpath = "//p[@class='alert alert-success block_newsletter_alert']")
    private WebElement successSubscriptionMessage;


    public MainPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void openMainPage(){
        log.info("Opening main page of the web site");
        getDriver().get("https://demo.prestashop.com/");
    }

    public void findIframe(){
        log.info("Finding and waiting that iframe is visible by locator{}",iframe);
        getDriver().switchTo().frame(iframe);
    }

    public boolean waitingUntilLoaderisVisible(){
        log.info("Finding and waiting until loader is visible by locator{}",loader);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOf(loader));
            return loader.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException
                | org.openqa.selenium.StaleElementReferenceException
                | org.openqa.selenium.TimeoutException e){
            return false;
        }
    }
    public void fillAlreadyUsedEmail(String email){
        waitUntilVisible(blockNewsletter, 7);
        log.info("Finding creation subscription field for email by locator{}",emailFieldForSubscription);
        emailFieldForSubscription.sendKeys(email);
        log.info("Finding and clicking subscribe button by locator{}",buttonSubscribe);
        buttonSubscribe.click();
    }
    public String getSuccessSubscriptionMessage(){
        log.info("success subscription email appears");
         waitUntilVisible(successSubscriptionMessage, 5);
         return successSubscriptionMessage.getText();
    }
}
