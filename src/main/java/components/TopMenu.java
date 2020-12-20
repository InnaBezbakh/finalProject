package components;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


@Slf4j
@Getter
public class TopMenu {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @FindBy(xpath="// img[@class='logo img-responsive']")
    WebElement myStoreImg;

    @FindBy(xpath="// ul//li[@id='category-3']")
    WebElement clothesTopMenuItem;

    @FindBy(xpath="//ul//li[@id='category-6']")
    WebElement accessoriesTopMenuItem;

    @FindBy(xpath="//ul//li[@id='category-9']")
    WebElement artTopMenuItem;

    @FindBy(xpath="//a[contains(text(),'Men')]")
    WebElement menSubItem;

    @FindBy(xpath="//a[contains(text(),'Women')]")
    WebElement womenSubItem;

    @FindBy(xpath="//a[contains(text(),'Stationery')]")
    WebElement stationerySubItem;

    @FindBy(xpath="/a[contains(text(),'Home Accessories')]")
    WebElement homeAccessoriesSubItem;

    public TopMenu(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }


}
