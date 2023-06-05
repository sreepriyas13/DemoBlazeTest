package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CartPage {
    @SuppressWarnings("unused")
	private WebDriver driver;

    // Web Elements
    @FindBy(xpath = "//a[contains(text(), 'Proceed to Checkout')]")
    private WebElement checkoutButton;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page Methods
    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}

// Create additional page classes for other web pages as needed.
