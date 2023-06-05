package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    @SuppressWarnings("unused")
	private WebDriver driver;

    // Web Elements
    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    private WebElement searchButton;

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page Methods
    public void enterSearchQuery(String query) {
        searchInput.sendKeys(query);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}