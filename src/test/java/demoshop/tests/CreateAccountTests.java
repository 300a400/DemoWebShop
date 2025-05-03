package demoshop.tests;

import demoshop.data.UserData;
import demoshop.models.User;
import demoshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void newUserRegistrationPositiveTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User().setFirstName(UserData.NAME_REG).setLastName(UserData.LASTNAME_REG).setEmail(UserData.EMAIL_REG).setPassword(UserData.PASSWORD).setConfirmPassword(UserData.CONFIRMPASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isLinkLogOutPresent());
        Assert.assertTrue(app.getUser().isTextRegistrationCompletedPresent());
    }

    @Test(dataProvider = "addNewUser", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderTest(String name, String lastName,
                                                                String email, String password) {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User().setFirstName(name).setLastName(lastName).setEmail(email).setPassword(password).setConfirmPassword(password));
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
}