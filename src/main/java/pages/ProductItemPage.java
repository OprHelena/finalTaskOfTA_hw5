package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductItemPage extends BasePage {
    @FindBy(id = "dropdown_selected_size_name")
    private WebElement sizeSelectButton;

    @FindBy(xpath = "//li[contains(@id,'size_name_')]")
    private List<WebElement> sizesProductItem;

    @FindBy(xpath = "//div[@id='variation_size_name']//span[@class='a-dropdown-prompt']")
    private WebElement sizeItem;

    @FindBy(id = "buy-now-button")
    private WebElement buyNowButton;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='imageBlock']")
    private WebElement imagesOfItemSelectedFromGiftCards;

    @FindBy(xpath = "//tr[@id='priceblock_ourprice_row']")
    private WebElement priceOfSelectedItem;

    public ProductItemPage(WebDriver driver) {
        super(driver);
    }

    public void clickToSizeSelectButton() {
        sizeSelectButton.click();
    }

    public void clickToSizeProductItem(int sizeItem) {
        sizesProductItem.get(sizeItem).click();
    }

    public boolean buyNowButtonIsVisible() {
        return buyNowButton.isDisplayed();
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void clickToAddToCartButton() {
        addToCartButton.click();
    }

    public boolean imagesOfItemSelectedFromGiftCardsIsVisible() {
        return imagesOfItemSelectedFromGiftCards.isDisplayed();
    }

    public boolean priceOfSelectedItemIsVisible() {
        return priceOfSelectedItem.isDisplayed();
    }
public void clickToByButton(){
        buyNowButton.click();
}
}
