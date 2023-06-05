package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @SuppressWarnings("unused")
	private WebDriver driver;

    // Web Elements
    @FindBy(linkText = "Sign up")
    private WebElement signUpLink;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page Methods
    public void clickSignUpLink() {
        signUpLink.click();
    }
}



