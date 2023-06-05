package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v109.page.Page;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
    public LoginPage(WebDriver driver) {
        super();
    }

    @FindBy(id = "loginusername")
    WebElement textInputUsername;

    @FindBy(id = "loginpassword")
    WebElement textInputPassword;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement buttonLogin;

    @FindBy(xpath = "(//button[contains(text(),'Close')])[3]")
    WebElement buttonClose;

}

	