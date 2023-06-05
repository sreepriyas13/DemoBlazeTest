package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    @SuppressWarnings("unused")
	private WebDriver driver;

    // Web Elements
    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "address")
    private WebElement addressInput;

    @FindBy(id = "checkoutButton")
    private WebElement checkoutButton;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page Methods
    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
