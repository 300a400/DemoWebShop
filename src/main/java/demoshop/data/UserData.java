package demoshop.data;

public class UserData {
    static int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
    public static final String EMAIL = "qa55ks@test.com";
    public static final String EMAIL_REG = "exampletest0" + i + "@test.com";
    public static final String PASSWORD = "aBc123456!";
    public static final String CONFIRMPASSWORD = "aBc123456!";
    public static final String NAME_REG = "Elvis";
    public static final String LASTNAME_REG = "Presley";
}
