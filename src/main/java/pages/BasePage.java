package pages;

import components.HeaderNav;
import components.TopMenu;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
@Slf4j
public abstract class BasePage {

    private final HeaderNav headerNav;
    private final TopMenu topMenu;

    public BasePage (){
        this.headerNav=new HeaderNav(getDriver());
        this.topMenu=new TopMenu(getDriver());
        PageFactory.initElements(getDriver(), this);
    }

    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<WebDriver>();

    public static void setDriverThreadLocal(WebDriver webDriver) {
        DRIVER_THREAD_LOCAL.set(webDriver);
    }

    public static WebDriver getDriver() {
        return DRIVER_THREAD_LOCAL.get();
    }

    public WebElement waitUntilVisible(WebElement element, int time) {
        return new WebDriverWait(getDriver(), time)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToVisibleElement(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", webElement);
        waitUntilVisible(webElement, 10);
    }

    public WebElement waitUntilClickable(WebElement element, int time) {
        return new WebDriverWait(getDriver(), time)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}

