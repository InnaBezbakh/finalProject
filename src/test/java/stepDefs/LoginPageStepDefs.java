package stepDefs;

import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageStepDefs {

    LoginPage loginPage = new LoginPage();

    @When("from the Login page I go to Registration page")
    public void from_the_login_page_i_go_to_registration_page() {
        loginPage.clickCreateAccountLink();
    }
}
