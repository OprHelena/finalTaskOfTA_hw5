package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "ap_email")
    private WebElement userEmailField;

    @FindBy(xpath = "//span[@id='continue']//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='a-alert-content']//li")
    private WebElement errorMessageAfterAddedIncorrectPassword;

    @FindBy(xpath = "//div[@class='a-row a-spacing-base']//span")
    private WebElement emailAddressTitleAfterEnteredIsAppears;

    @FindBy(id = "ap_password")
    private WebElement passwordField;

    @FindBy(id = "signInSubmit")
    private WebElement signinButton;

    @FindBy(xpath = "//div[@id='glow-ingress-block']//span[@class='nav-line-1 nav-progressive-content']")
    private WebElement welcomeMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement userEmailFieldIsVisible() {
        return userEmailField;
    }

    public void enterEmailAddressToEmailField(String userEmail) {
        userEmailField.clear();
        userEmailField.sendKeys(userEmail);
    }

    public WebElement continueButtonIsVisible() {
        return continueButton;
    }

    public void clickToContinueButton() {
        continueButton.click();
    }

    public WebElement errorMessageIsAppears() {
        return errorMessageAfterAddedIncorrectPassword;
    }

    public String errorMessageText() {
        return errorMessageAfterAddedIncorrectPassword.getText();
    }

    public boolean emailAddressTitleAfterEnteredIsVisible() {
        return emailAddressTitleAfterEnteredIsAppears.isDisplayed();
    }
public WebElement userPasswordField(){
        return passwordField;
}
    public void enterPasswordInToPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickToSigninButton() {
        signinButton.click();
    }

    public boolean welcomeMessageIsVisible() {
        return welcomeMessage.isDisplayed();
    }

    public String welcomeMessageText() {
        return welcomeMessage.getText();
    }
}