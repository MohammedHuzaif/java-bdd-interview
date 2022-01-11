package posmy.interview.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends BasePage {

    @FindBy(css="#kp-wp-tab-overview > div.TzHB6b.cLjAic.LMRCfc > div > div.JNkvid.gsrt.wp-ms > div > div")
    private static WebElement topSectionTextBlock;

    @FindBy(css="...")
    private static WebElement commonQuestionsSectionTextBlock;

    @FindBy(css="a[href=\"https://covid-19.moh.gov.my/\"]")
    private static WebElement mohLink;

    public static String getTopSectionText(){
        shortWait.until(ExpectedConditions.elementToBeClickable(topSectionTextBlock));
        return topSectionTextBlock.getText();
    }

    public static String getCommonQuestionsSection(){
        shortWait.until(ExpectedConditions.elementToBeClickable(commonQuestionsSectionTextBlock));
        return commonQuestionsSectionTextBlock.getText();
    }

    public static void clickOnMOHLink(){
        shortWait.until(ExpectedConditions.elementToBeClickable(mohLink));
        mohLink.click();
    }

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.getDriver(), this);
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
