import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import model.HomePage;
import model.LoginPage;
import model.PersonalAccountPage;
import model.RegistrationPage;
public class RegistrationTest {
    private WebDriver driver;

    private final String name = SetTestClass.name;
    private final String email = SetTestClass.email;
    private final String pass = SetTestClass.password;

    @Before
    public void setup() {
        driver = SetWebDriver.setupDriver();
        driver.get(SetWebDriver.getUrlRegistration());
    }

    @Test
    @DisplayName("Регистрация пользователя с корректными данными")
    @Description("Проверка успешной регистрации пользователя с корректными данными")
    public void RegistrationUserWithCorrectParams() {

        RegistrationPage objRegPage = new RegistrationPage(driver);
        objRegPage.register(name, email, pass);
        LoginPage objLogPage = new LoginPage(driver);
        objLogPage.waitForLoadButtonLogin();
        objLogPage.login(email, pass);
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadButtonPersonalAccount();
        objHomePage.clickPersonalAccount();
        PersonalAccountPage objectPersonalAccountPage = new PersonalAccountPage(driver);
        objectPersonalAccountPage.assertVisibleButtonExit();
    }

    @After
    public void teardown() {
        driver.quit();
        String token = SetTestClass.loginUser();
        SetTestClass.deleteUser(token);
    }
}
