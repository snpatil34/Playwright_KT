package StepDefinitions;


import Pages.SearchEngine;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchEngineStepDefinition {
    @Given("User navigate to Playwright URL")
    public void user_navigate_to_playwright_url() {
        SearchEngine.launchApp();
    }

    @When("user select Java from dropdown and able to see expected page")
    public void user_select_from_dropdown_and_able_to_see_expected_page() {
        SearchEngine.dropdownClick();
    }

    @And("browser should close")
    public void browser_should_close() {

    }

    @And("click on the search box and enter {string} in the search box")
    public void clickOnTheSearchBoxAndEnterInTheSearchBox(String arg0) {
        SearchEngine.clickOnSearch(arg0);
    }

    @Then("entered topic page should open with {string}")
    public void enteredTopicPageShouldOpenWith(String header) {
        SearchEngine.displayExpectedTopic(header);
    }
}
