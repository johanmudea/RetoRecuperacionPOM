package co.com.sofka.stepdefinition.admin;

import co.com.sofka.model.jobtitle.JobTitleModel;
import co.com.sofka.model.login.LoginModel;
import co.com.sofka.page.jobtitle.JobTitlePage;
import co.com.sofka.page.login.LoginPage;
import co.com.sofka.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class AdminStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(AdminStepDefinition.class);
    private LoginModel loginModel;
    private LoginPage loginPage;

    private JobTitleModel jobTitleModel;
    private JobTitlePage jobTitlePage;

    @Given("i am in the website")
    public void iAmInTheWebsite() {

        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            loginModel = new LoginModel();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }
    @When("i navigate and add a job title")
    public void iNavigateAndAddAJobTitle() {

        try{

            loginPage = new LoginPage(driver, loginModel);
            loginPage.fillLogin();
            loginPage.check();
            loginPage.setJob();

            jobTitlePage = new JobTitlePage(driver,jobTitleModel);
            jobTitlePage.fillJobTitleForm();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }
    @Then("show a confirmation message")
    public void showAConfirmationMessage() {

        Assertions.assertEquals("Successfully Saved", jobTitlePage.response(driver));
        quiteDriver();

    }

}
