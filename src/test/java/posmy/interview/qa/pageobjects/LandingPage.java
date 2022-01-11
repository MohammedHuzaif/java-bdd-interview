package posmy.interview.qa.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {

    @FindBy(css="[aria-label='Search']")
    private static WebElement searchInputTextBox;

    public static void typeIntoSearchInputTextBox(String searchText){
        shortWait.until(ExpectedConditions.elementToBeClickable(searchInputTextBox));
        searchInputTextBox.clear();
        searchInputTextBox.click();
        searchInputTextBox.sendKeys(searchText);
    }

    public static void pressEnterKey(){
        searchInputTextBox.sendKeys(Keys.ENTER);
    }

    public String getCurrentURL(){
        return this.getDriver().getCurrentUrl();
    }

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.getDriver(), this);
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
