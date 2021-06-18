package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(id = "s-refinements")
    private WebElement filtersPanel;

    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    private List<WebElement> searchResultProductList;

    @FindBy(xpath = "//div[@class='a-section aok-relative s-image-square-aspect']")
    private List<WebElement> resultProductItemsList;

    @FindBy(xpath = "//a[@aria-label='Mail']")
    private WebElement mailPageFromGiftCartSection;

    @FindBy(xpath = "//a[@class='a-link-normal a-text-normal']")
    private List<WebElement> itemFromGiftCardsPage;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void FiltersPanelIsVisible() {
        filtersPanel.isDisplayed();
    }

    public List<WebElement> getSearchResultsList() {
        return searchResultProductList;
    }

    public void clickToProductItem(int numberItem) {
        resultProductItemsList.get(numberItem).click();
    }

    public void clickToMailPageFromGiftCartSection() {
        mailPageFromGiftCartSection.click();
    }

    public void clickToItemFromGiftCardsPage(int num) {
        itemFromGiftCardsPage.get(num).click();
    }
}
