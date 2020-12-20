package pages;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
@Getter
public class LoginPage extends BasePage {

    @FindBy(xpath="//a[contains(text(),'No account?')]")
    WebElement createAccountLink;

   public LoginPage(){
        PageFactory.initElements(getDriver(),this);
   }
   public void clickCreateAccountLink(){
       waitUntilVisible(createAccountLink,7);
       log.info("clicking creation account link by locator{}",createAccountLink);
       createAccountLink.click();
   }


}
