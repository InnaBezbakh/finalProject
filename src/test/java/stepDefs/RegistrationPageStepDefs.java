package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.RegistrationPage;

public class RegistrationPageStepDefs {
    RegistrationPage registrationPage = new RegistrationPage();

    @When("I fill registration fields with {string}, {string}, {string}, {string}, {string}")
    public void i_fill_registration_fields_with(String firstname, String lastname, String email, String password, String birthdate) {
        registrationPage.clickGenderRadioButton();
        registrationPage.setMyFirstName(firstname);
        registrationPage.setMyLastName(lastname);
        registrationPage.setFieldEmail(email);
        registrationPage.setMyPassword(password);
        registrationPage.setMyBirthDate(birthdate);
        registrationPage.setPrivacyCheckbox();
        registrationPage.setAgreeCheckbox();
        registrationPage.clickSaveButton();
    }

    @Then("I see that {string} appears in the header navigation menu near cart")
    public void i_see_that_appears_in_the_header_navigation_menu_near_cart(String accountName) {
        String actualAccountName = registrationPage.getHeaderNav().getUserAccountName();
        Assertions.assertThat(actualAccountName).isEqualTo(accountName);

    }
}
