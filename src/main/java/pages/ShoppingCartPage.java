package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {
    @FindBy(id = "huc-v2-confirm-text-container")
    private WebElement addedToCartText;

    @FindBy(id = "nav-cart-count")
    private WebElement countItemsOnCartIcon;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String countItemsOnCartIconIsVisible() {
        return countItemsOnCartIcon.getText();
    }

    public boolean addedToCartTextIsVisible() {
        return addedToCartText.isDisplayed();
    }
}
