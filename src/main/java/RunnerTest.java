import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features"},

        //plugin = {"pretty", "html:target/site/cucumber-pretty"},

        glue = {"stepdefinition"},

        tags = {"@hotel_search"}

        //dryRun = false,
        //strict = false,

        //snippets = SnippetType.CAMELCASE
        //name = "^Успешное|Успешная.*"
)

public class RunnerTest {}