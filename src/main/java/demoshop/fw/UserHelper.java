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

    public void fillRegistrationForm(User user) {
        type(By.id("FirstName"), user.getFirstName());
        type(By.id("LastName"),  user.getLastName());
        type(By.id("Email"),     user.getEmail());
        type(By.id("Password"),  user.getPassword());
        type(By.id("ConfirmPassword"), user.getConfirmPassword());
    }

    public void clickOnRegistrationButton() {
        click(By.id("register-button"));
    }

    public void register(User user) {
        clickOnRegistrationLink();
        fillRegistrationForm(user);
        clickOnRegistrationButton();
    }

    public void clickOnLoginLink() {
        click(By.linkText("Log in"));
    }

    public void fillLoginForm(User user) {
        type(By.id("Email"),    user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("input.button-1.login-button"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.linkText("Log in"));
    }

    public boolean isTextValidationErrorsPresent() {
        return driver.findElement(By.cssSelector("div.validation-summary-errors")).isDisplayed();
    }

    public boolean isLinkLogOutPresent() {
        return isElementPresent(By.linkText("Log out"));
    }

    public void clickOnSignOutButton() {
        click(By.linkText("Log out"));
    }
}
