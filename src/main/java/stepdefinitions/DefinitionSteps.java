package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionSteps {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductItemPage productItemPage;
    ShoppingCartPage shoppingCartPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(20);
    }

    @When("User clicks to 'Sign In' button")
    public void userClickToSignInButton() {
        homePage.clickToSignInButton();
    }

    @And("User enters {string} email address in 'Email or username' field")
    public void enterUserEmailInEmailOrUsernameField(final String userEmail) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitVisibilityOfElement(15, loginPage.userEmailFieldIsVisible());
        loginPage.enterEmailAddressToEmailField(userEmail);
    }

    @And("User clicks to 'Continue' button")
    public void userClickToContinueButton() {
        loginPage.waitVisibilityOfElement(15, loginPage.continueButtonIsVisible());
        loginPage.clickToContinueButton();
    }

    @Then("User checks that error massage appears")
    public void userChecksThatErrorMassageAppears() {
        loginPage.waitVisibilityOfElement(15, loginPage.errorMessageIsAppears());
        assertEquals(loginPage.errorMessageText(), "We cannot find an account with that email address");
    }

    @Then("User checks that error massage {string} appears")
    public void userChecksThatErrorMassageAppears(final String massage) {
        loginPage.waitVisibilityOfElement(15, loginPage.errorMessageIsAppears());
        assertEquals(loginPage.errorMessageText(), massage);
    }

    @And("User checks that search field visibility")
    public void userChecksThatSearchFieldVisibility() {
        homePage.checkSearchFieldIsVisible();
    }

    @When("User enters the search word {string} in to search field")
    public void inputTheSearchWordInToSearchField(final String enteredKeyword) {
        homePage.inputTheSearchWordInToSearchField(enteredKeyword);
    }

    @And("User clicks to search icon")
    public void clickToSearchIcon() {
        homePage.clickToSearchIcon();
    }

    @And("User checks that filter menu is visible")
    public void filterMenuIsVisible() {
        productsPage = pageFactoryManager.getProductsPage();
        productsPage.waitForPageLoadComplete(15);
        productsPage.FiltersPanelIsVisible();
    }

    @Then("User checks that search result contains search word {string}")
    public void searchResultContainsSearchWord(final String keyword) {
//        productsPage.waitForPageLoadComplete(20);
        for (WebElement webElement : productsPage.getSearchResultsList()) {
            assertTrue(webElement.getText().contains(keyword));
        }
    }

    @And("User clicks to size select button")
    public void clickToSizeSelectButton() {
        productItemPage = pageFactoryManager.getProductItemPage();
        productItemPage.clickToSizeSelectButton();
    }

    @When("User clicks to needed product item {int} on page")
    public void clickToNeededProductItemNumber(final int numberItem) {
        productsPage.waitForPageLoadComplete(15);
        productsPage.clickToProductItem(numberItem);
    }

    @And("User clicks to size {int} in size list")
    public void clickToSizeValue(final int size) {
        productItemPage.clickToSizeProductItem(size);
    }

    @Then("User check that 'Buy Now' button is visible")
    public void buyNowButtonIsVisible() {
        assertTrue(productItemPage.buyNowButtonIsVisible());
    }

    @And("User clicks to 'Add To Cart' button")
    public void clickToAddToCartButton() {
        productItemPage.waitVisibilityOfElement(15, productItemPage.getAddToCartButton());
        productItemPage.clickToAddToCartButton();

    }

    @Then("User checks that 'Add To Cart' text is visible")
    public void checkAddToCartTextIsVisible() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        assertTrue(shoppingCartPage.addedToCartTextIsVisible());
    }

    @And("User checks that emailAddress is visible")
    public void userChecksThatEmailAddressUserEmailIsVisible() {
        assertTrue(loginPage.emailAddressTitleAfterEnteredIsVisible());
    }

    @And("User enters invalid password {string} in password field")
    public void entersInvalidPasswordInPasswordField(final String password) {
        loginPage.enterPasswordInToPasswordField(password);
    }

    @And("User clicks to 'Sign in' button on the login Page")
    public void clicksToSignInButtonOnTheLoginPage() {
        loginPage.clickToSigninButton();
    }

    @Then("User checks the number of purchased items {string} above the cart icon")
    public void checkTheNumberOfPurchasedItemsCount(final String count) {
        shoppingCartPage.waitForPageLoadComplete(15);
        assertEquals(homePage.getCountItemsAboveCartIcon(), count);
    }

    @And("User clicks to the 'All' button on the header menu")
    public void userClicksToTheAllButtonOnTheHeaderMenu() {
        homePage.clickToAllButtonOnHeaderMenu();
    }

    @And("User checks that the header dropdown menu is visible")
    public void headerDropdownMenuIsVisible() {
        homePage.waitVisibilityOfElement(15, homePage.getDropDownHeaderMenu());
        assertTrue(homePage.dropDownHeaderMenuIsVisible());
    }

    @And("User clicks to the arrow below 'See All' text from 'Shop By Department' catalog")
    public void clicksToTheArrowBelowSeeAllText() {
        homePage.clickToSeeAllButton();
    }

    @When("User clicks to catalog item {int}")
    public void clickToCatalogItem(final int catalogItem) {
        homePage.waitVisibilityOfElement(15, homePage.itemFromCatalogListIsVisible(catalogItem));
        homePage.clickToItemFromCatalogList(catalogItem);
    }

    @Then("User checks that catalog menu is visible")
    public void catalogMenuIsVisible() {
        assertTrue(homePage.catalogMenuIsAppears());
    }

    @And("User clicks to 'Gift Cards' button on header menu")
    public void clickToGiftCardsButtonOnHeaderMenu() {
        homePage.clickToGiftCardsButtonOnHeaderMenu();
    }

    @And("User clicks to 'Mail' section on the gift cards page")
    public void clickToMailSectionOnTheGiftCardsPage() {
        productsPage = pageFactoryManager.getProductsPage();
        productsPage.clickToMailPageFromGiftCartSection();
    }

    @When("User clicks to selected gift card {int} from the product items page")
    public void clickToSelectedGiftCardFromTheProductItemsPage(int number) {
        productsPage.waitForPageLoadComplete(15);
        productsPage.clickToItemFromGiftCardsPage(number);
    }

    @And("User checks that the images of selected item is visible")
    public void imagesOfSelectedItemIsVisible() {
        productItemPage = pageFactoryManager.getProductItemPage();
        assertTrue(productItemPage.imagesOfItemSelectedFromGiftCardsIsVisible());
    }

    @Then("User checks that the price of selected item is visible")
    public void priceOfSelectedItemIsVisible() {
        assertTrue(productItemPage.priceOfSelectedItemIsVisible());
    }

    @And("User checks that welcome message is visible")
    public void welcomePageIsVisible() {
        loginPage.waitForPageLoadComplete(15);
        assertTrue(loginPage.welcomeMessageIsVisible());
    }

    @And("User enters valid password {string} in password field")
    public void enterValidPasswordPasswordInPasswordField(final String password) {
        loginPage.waitVisibilityOfElement(15, loginPage.userPasswordField());
        loginPage.enterPasswordInToPasswordField(password);
    }

    @Then("User checks welcome message {string} with user lastname appears")
    public void welcomeMessageWithUserLastNameAppears(final String welcomeMessage) {
        loginPage.waitForPageLoadComplete(20);
        assertTrue(loginPage.welcomeMessageText().contains(welcomeMessage));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}






