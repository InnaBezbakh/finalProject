package pages;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.RandomEmails;

@Getter
@Slf4j
public class RegistrationPage extends BasePage {

    @FindBy(xpath="//label[@class='radio-inline'][2]")
    WebElement genderRadioButton;

    @FindBy(xpath="//input[@name='firstname']")
    WebElement fieldName;

    @FindBy(xpath="//input[@name='lastname']")
    WebElement fieldLastname;

    @FindBy(xpath="//div[@class='col-md-6']//input[@name='email']")
    WebElement fieldEmail;

    @FindBy(xpath="//div[@class='input-group js-parent-focus']//input[@name='password']")
    WebElement fieldPassword;

    @FindBy(xpath="//div[@class='col-md-6']//input[@name='birthday']")
    WebElement fieldDateOfBirth;

    @FindBy(xpath="//input[@name='customer_privacy']")
    WebElement privacyCheckbox;

    @FindBy(xpath="//input[@name='psgdpr']")
    WebElement agreeCheckbox;

    @FindBy(xpath="//button[@class='btn btn-primary form-control-submit float-xs-right']")
    WebElement saveButton;

    public RegistrationPage (){
        PageFactory.initElements(getDriver(),this);
    }

    public void clickGenderRadioButton(){
        log.info("click on the gender radio button (mr's) by locator{}",genderRadioButton);
        waitUntilVisible(genderRadioButton, 10);
        genderRadioButton.click();
    }
    public void setMyFirstName(String myFirstName){
        log.info("Setting firstname in field firstname by locator{}", fieldName);
        waitUntilVisible(fieldName, 5).sendKeys(myFirstName);
    }
    public void setMyLastName(String myLastName){
        log.info("Setting lastname in field lastname by locator {}", fieldLastname);
        waitUntilVisible(fieldLastname, 5).sendKeys(myLastName);
    }
    public void setFieldEmail(String myEmail){
        log.info("Setting user's email in field email by locator{}", fieldEmail);
        waitUntilVisible(fieldEmail, 5).sendKeys(RandomEmails.generateEmail());
    }

    public void setMyPassword(String password){
        log.info("Setting user's password in field password by locator{}", fieldPassword);
        waitUntilVisible(fieldPassword, 5).sendKeys(password);
    }
    public void setMyBirthDate(String birthdate){
        log.info("Setting user's birthdate in field birthdate by locator{}", fieldDateOfBirth);
        waitUntilVisible(fieldDateOfBirth,5).sendKeys(birthdate);
    }
    public void setPrivacyCheckbox(){
        log.info("Select checkbox customer data privacy by locator{}", privacyCheckbox);
        privacyCheckbox.click();
    }
    public void setAgreeCheckbox(){
        log.info("Select  agree checkbox  by locator{}", agreeCheckbox);
        agreeCheckbox.click();
    }
    public void clickSaveButton(){
        log.info("Click Save button (for submitting registration) by locator{}", saveButton);
        waitUntilClickable(saveButton,7);
        saveButton.click();
        saveButton.click(); ///((sorry, i know that is not correct decision to duplicate the same step, but i try tu use (add actions//actions.doubleClick(saveButton);), and it didn't help
    }

}
