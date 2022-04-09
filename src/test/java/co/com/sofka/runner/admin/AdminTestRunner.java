package co.com.sofka.runner.admin;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/Admin.feature"},
        glue = "co.com.sofka.stepdefinition.admin"

)


public class AdminTestRunner {
}
