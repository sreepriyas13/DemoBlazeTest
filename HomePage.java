package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    public HomePage() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/sreepriyasreekumar/Desktop/chromedriver 2");

        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10); // Set the timeout value as needed

        // Initialize page elements
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        // Open the website's homepage
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void closeHomePage() {
        // Close the browser and quit the WebDriver instance
        driver.quit();
    }

    public void clickProductCategory(String category) {
        // Find the product category link by its text and click on it
        WebElement categoryLink = driver.findElement(By.linkText(category));
        categoryLink.click();
    }

    public void searchProduct(String productName) {
        // Find the search input field, enter the product name, and submit the search
        WebElement searchInput = driver.findElement(By.id("searchval"));
        searchInput.sendKeys(productName);
        searchInput.submit();
    }
    @FindBy(xpath = "//div[@class='list-group']//a[text()='Phones']")
    private WebElement phones;

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Laptops']")
    private WebElement laptops;

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Monitors']")
    private WebElement monitors;

    @FindBy(id = "tbodyid")
    private WebElement itemList;

    @FindBy(xpath = "//a[@class='hrefch']")
    private List<WebElement> items;

    @FindBy(xpath = "//a[contains(@class,'btn-success')]")
    private WebElement addToCartBtn;

    private WebDriverWait wait;
    @SuppressWarnings("unused")
	private WebDriver driver1;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPhonesCategoryNotEmpty(){
        phones.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='tbodyid']")));
        List<WebElement> availableItems = itemList.findElements(By.xpath("//div[contains(@class,'col')]"));
        return !availableItems.isEmpty();
    }

    public boolean isLaptopsCategoryNotEmpty(){
        laptops.click();
        List<WebElement> availableItems = itemList.findElements(By.xpath("//div[contains(@class,'col')]"));
        return !availableItems.isEmpty();
    }

    public boolean isMonitorsCategoryNotEmpty(){
        monitors.click();
        List<WebElement> availableItems = itemList.findElements(By.xpath("//div[contains(@class,'col')]"));
        return !availableItems.isEmpty();
    }

    public void addingItemToCart(String itemName){
        for (WebElement item : items){
            if (item.getText().equals(itemName)){
                item.click();
                wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
                addToCartBtn.click();
                driver.switchTo().alert().accept();
            }

        }
    }


    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        
        // Example usage:
        homePage.clickProductCategory("Laptops");
        homePage.searchProduct("Macbook Pro");
        
        homePage.closeHomePage();
    }
}







