package demoshop.fw;

import demoshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isTextRegistrationCompletedPresent() {
        return isElementPresent(By.xpath("//div[contains(text(),'Your registration completed')]"));
    }

    public boolean isLinkLogOutPresent() {
        return isElementPresent(By.xpath("//a[@class='ico-logout']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.name("FirstName"), user.getFirstName());
        type(By.name("LastName"), user.getLastName());
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getConfirmPassword());
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isTextEmailExistsPresent() {
        return isElementPresent(By.xpath("//li[text() = 'The specified email already exists']"));
    }

    public void clickOnRegistrationButton() {
        click(By.name("register-button"));
    }

    public void fillLoginForm(User user) {
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("input.login-button"));
    }

    public boolean isEmailExists() {
        return isErrorDisplayed();
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isTextValidationErrorsPresent() {
        return isElementPresent(By.cssSelector("div.validation-summary-errors"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void clickOnSignOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }
}