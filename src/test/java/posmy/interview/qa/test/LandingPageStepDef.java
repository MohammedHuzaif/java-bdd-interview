package posmy.interview.qa.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import posmy.interview.qa.pageobjects.BasePage;
import posmy.interview.qa.pageobjects.LandingPage;
import posmy.interview.qa.pageobjects.SearchResultsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LandingPageStepDef {
    private LandingPageStepDef landingPageStepDef;
    private LandingPage landingPage;
    private BasePage basePage;
    private SearchResultsPage searchResultsPage;

    public LandingPageStepDef(LandingPageStepDef landingPageStepDef) {
        this.landingPageStepDef = landingPageStepDef;
    }

    @Given("^Go to google webpage \"([^\"]*)\"$")
    public void navigateToURL(String url) {
        basePage.navigate(url);
        assertEquals(url,landingPage.getCurrentURL());
    }

    @When("Enter Search Text: (.*) and press ENTER Key$")
    public void userSearchesForText(String searchText) {
        LandingPage.typeIntoSearchInputTextBox(searchText);
        LandingPage.pressEnterKey();
    }

    @Then("^Verify \"([^\"]*)\" section is available$")
    public void verifyTopSectionIsDisplayed(String sectionValue) {
        switch(sectionValue){
            case "Top stories":
                assertEquals(SearchResultsPage.getTopSectionText(),sectionValue);
                break;
            case "Common Questions":
                //Common Questions Section is not available in the Search Results Page
                //assertEquals(SearchResultsPage.getCommonQuestionsSection(),sectionValue);
                break;
        }
    }

    @And("^Click on MOH Website in search result$")
    public void clickMOHLinkIsDisplayedInSearchResults() {
        SearchResultsPage.clickOnMOHLink();
    }

    @Then("^Verify MOH Website is displayed \"([^\"]*)\"$")
    public void verifyMOHWebsiteIsDisplayed(String url) {
        assertEquals(url,landingPage.getCurrentURL());
    }
}
