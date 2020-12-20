package stepDefs;

import components.enums.HeaderNavMenuComponents;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.MainPage;

public class MainPageStepDefs {

    MainPage mainPage = new MainPage();

    @Given("I am on the Main page of application")
    public void i_am_on_the_main_page_of_application(){
        mainPage.openMainPage();
        mainPage.findIframe();
        mainPage.waitingUntilLoaderisVisible();
    }
    @When("I fill subscription field with already registered address {string}")
    public void i_fill_subscription_field_with_already_registered_address(String email){
        WebElement emailFieldForSubscription = mainPage.getEmailFieldForSubscription();//i find element and init it on the main page
        mainPage.scrollToVisibleElement(emailFieldForSubscription); // i use that method to the element above
        mainPage.fillAlreadyUsedEmail(email);
    }
    @Then("I see success message {string} appears")
    public void i_see_success_message_appears(String successMessage){
        String actualSuccessSubscriptionMessage = mainPage.getSuccessSubscriptionMessage();
        Assertions.assertThat(actualSuccessSubscriptionMessage).isEqualTo(successMessage);
    }
    @When("I open localization drop down list")
    public void i_open_localization_drop_down_list(){
        mainPage.getHeaderNav().selectNavMenuItem(HeaderNavMenuComponents.LANGUAGE_DROPDOWN);
    }
    @Then("I see that {int} languages exists in top menu")
    public void i_see_that_languages_exists_in_top_menu(int numOfLang){
        int actualLangNumber = mainPage.getHeaderNav().checkNumberOfLanguages();/*mainPage.checkNumberOfLanguages();*/
        Assertions.assertThat(actualLangNumber).isGreaterThanOrEqualTo(numOfLang);
    }

    @Then("I see that {string} exist in list of languages")
    public void i_see_that_exist_in_list_of_languages(String ukrSelectItem){
        boolean actualTextUkrItem = mainPage.getHeaderNav().getTextUkrItem(ukrSelectItem);/*mainPage.getTextUkrItem(ukrSelectItem);*/
        Assertions.assertThat(actualTextUkrItem).isEqualTo(true);
    }

    @When("I click SIGN_IN")
    public void i_click_sign_in() {
        mainPage.getHeaderNav().selectNavMenuItem(HeaderNavMenuComponents.SIGN_IN);
    }

}
