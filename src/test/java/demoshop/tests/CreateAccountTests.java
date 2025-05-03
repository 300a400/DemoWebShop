package demoshop.tests;

import demoshop.data.UserData;
import demoshop.models.User;
import demoshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    @BeforeMethod
    public void precondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void newUserRegistrationPositiveTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User().setFirstName(UserData.NAME_REG).setLastName(UserData.LASTNAME_REG).setEmail(UserData.EMAIL_REG).setPassword(UserData.PASSWORD).setConfirmPassword(UserData.CONFIRMPASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isLinkLogOutPresent());
        Assert.assertTrue(app.getUser().isTextRegistrationCompletedPresent());
    }

    @Test(dataProvider = "addNewUserWithCsv", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderWithCsvFileTest(User user) {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isLinkLogOutPresent());
        Assert.assertTrue(app.getUser().isTextRegistrationCompletedPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User().setFirstName(UserData.NAME_REG).setLastName(UserData.LASTNAME_REG).setEmail(UserData.EMAIL_REG).setPassword(UserData.PASSWORD).setConfirmPassword(UserData.CONFIRMPASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isTextEmailExistsPresent());
    }
}