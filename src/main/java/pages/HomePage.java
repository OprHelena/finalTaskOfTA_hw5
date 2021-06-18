package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement signInButton;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchIcon;

    @FindBy(xpath = "//span[contains(@class,'nav-cart-count nav-cart')]")
    private WebElement countItemsAboveCartIcon;

    @FindBy(xpath = "//div[@class='nav-left']//a[@id='nav-hamburger-menu']")
    private WebElement allButtonOnHeader;

    @FindBy(xpath = "//a[@data-csa-c-slot-id='nav_cs_2']")
    private WebElement giftCardsbuttonOnHeaderMenu;

    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible']")
    private WebElement dropDownHeaderMenu;

    @FindBy(xpath = "//a[@class='hmenu-item hmenu-compressed-btn']")
    private List<WebElement> seeAllButton;

    @FindBy(xpath = "//a[@class='hmenu-item']")
    private List<WebElement> listOfItemsFromCatalog;

    @FindBy(id = "hmenu-content")
    private WebElement catalogMenu;

    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible hmenu-translateX']//a[contains(@href,'nav_em_')]")
    //a[@class='hmenu-item']
    private List<WebElement> categoryItem;

    @FindBy(xpath = "//span[@class='s-back-arrow aok-inline-block']/following-sibling::span")
    private WebElement nameOfCategoryTitleOnSelectionMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickToSignInButton() {
        signInButton.click();
    }

    public void checkSearchFieldIsVisible() {
        searchField.isDisplayed();
    }

    public void inputTheSearchWordInToSearchField(String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void clickToSearchIcon() {
        searchIcon.click();
    }

    public String getCountItemsAboveCartIcon() {
        return countItemsAboveCartIcon.getText();
    }

    public void clickToAllButtonOnHeaderMenu() {
        allButtonOnHeader.click();
    }

    public WebElement getDropDownHeaderMenu() {
        return dropDownHeaderMenu;
    }

    public boolean dropDownHeaderMenuIsVisible() {
        return dropDownHeaderMenu.isDisplayed();
    }

    public void clickToSeeAllButton() {
        seeAllButton.get(0).click();
    }

    public WebElement itemFromCatalogListIsVisible(int numberItems) {
        return listOfItemsFromCatalog.get(numberItems);
    }

    public void clickToItemFromCatalogList(int numberItems) {
        listOfItemsFromCatalog.get(numberItems).click();
    }

    public boolean catalogMenuIsAppears() {
        return catalogMenu.isDisplayed();
    }

    public WebElement catalogMenuIsVisible() {
        return catalogMenu;
    }

    public WebElement categoryItemIsVisible(int numberOfCategoryItem) {
        return categoryItem.get(numberOfCategoryItem);
    }

    public void clicksToCategoryItem(int numberOfCategoryItem) {
        categoryItem.get(numberOfCategoryItem).click();
    }

    public String getNameOfCategoryTitleOnSelectionMenu() {
        return nameOfCategoryTitleOnSelectionMenu.getText();
    }

    public void clickToGiftCardsButtonOnHeaderMenu() {
        giftCardsbuttonOnHeaderMenu.click();
    }

}

