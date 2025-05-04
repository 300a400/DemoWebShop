package demoshop.fw;

import demoshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistrationLink() {
        click(By.linkText("Register"));
    }

    public void clickOnLoginLink() {
        click(By.linkText("Log in"));
    }

    public void clickOnSignOutButton() {
        click(By.linkText("Log out"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("FirstName"), user.getFirstName());
        type(By.id("LastName"), user.getLastName());
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("ConfirmPassword"), user.getConfirmPassword());
    }

    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public void clickOnRegistrationButton() {
        click(By.id("register-button"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("input.button-1.login-button"));
    }

    public void register(User user) {
        clickOnRegistrationLink();
        fillRegistrationForm(user);
        clickOnRegistrationButton();
    }

    public void login(User user) {
        clickOnLoginLink();
        fillLoginForm(user);
        clickOnLoginButton();
    }

    public boolean isLinkLogOutPresent() {
        return isElementPresent(By.linkText("Log out"));
    }

    public boolean isTextValidationErrorsPresent() {
        return isElementPresent(By.cssSelector(".field-validation-error"));
    }

    public boolean isEmailAlreadyExistErrorDisplayed() {
        return isElementPresent(By.xpath("//li[contains(.,'The specified email already exists')]"));
    }
}