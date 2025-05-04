package demoshop.tests;

import demoshop.data.UserData;
import demoshop.models.User;
import demoshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLinkLogOutPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void newUserRegistrationPositiveTest() {
        User user = new User()
                .setFirstName(UserData.NAME_REG)
                .setLastName(UserData.LASTNAME_REG)
                .setEmail(UserData.EMAIL_REG)
                .setPassword(UserData.PASSWORD)
                .setConfirmPassword(UserData.CONFIRMPASSWORD);

        app.getUser().register(user);
        Assert.assertTrue(app.getUser().isLinkLogOutPresent());
    }

    @Test(dataProvider = "addNewUser", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderTest(String firstName,
                                                                String lastName,
                                                                String email,
                                                                String password) {
        User user = new User()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(password);
        app.getUser().register(user);
        Assert.assertTrue(app.getUser().isLinkLogOutPresent());
    }

    @Test(dataProvider = "addNewUserWithCsv", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderWithCsvFileTest(User user) {
        app.getUser().register(user);
        Assert.assertTrue(app.getUser().isLinkLogOutPresent());
    }
}