package data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {

        return new Object[][]{
                {"student", "wrongpass"},
                {"wronguser", "Password123"},
                {"wronguser", "wrongpass"}
        };
    }
}
