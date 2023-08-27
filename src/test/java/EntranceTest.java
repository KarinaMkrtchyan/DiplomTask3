import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import model.*;
public class EntranceTest {
    private WebDriver driver;
    private final String email = SetTestClass.email;
    private final String pass = SetTestClass.password;
    private String token;

    @Before
    public void setup() {
        driver = SetWebDriver.setupDriver();
        token = SetTestClass.createUser();
    }

    @Test
    @DisplayName("Вход в систему с корректными данными")
    @Description("Вход через кнопку в форме регистрации")
    public void LoginUserWithCorrectParamsOnRegistrationPage() {
        driver.get(SetWebDriver.getUrlRegistration());
        RegistrationPage objRegPage = new RegistrationPage(driver);
        objRegPage.clickButtonLogin();
        loginUser(email, pass, driver);
    }

    @Test
    @DisplayName("Вход в систему с корректными данными")
    @Description("Вход через кнопку в форме восстановления пароля")
    public void LoginUserWithCorrectParamsOnRecoverPassPage() {
        driver.get(SetWebDriver.getUrlRecoverPass());
        RecoverPassPage objRecoverPassPage = new RecoverPassPage(driver);
        objRecoverPassPage.clickButtonLogin();
        loginUser(email, pass, driver);
    }

    @Test
    @DisplayName("Вход в систему с корректными данными")
    @Description("Вход через кнопку «Личный кабинет»")
    public void LoginUserWithCorrectParamsOnHomePagePersonalAccount() {
        driver.get(SetWebDriver.getUrlHome());
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickPersonalAccount();
        loginUser(email, pass, driver);
    }

    @Test
    @DisplayName("Вход в систему с корректными данными")
    @Description("Вход по кнопке «Войти в аккаунт» на главной")
    public void LoginUserWithCorrectParamsOnHomePageButtonEntrance() {
        driver.get(SetWebDriver.getUrlHome());
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickButtonEntrance();
        loginUser(email, pass, driver);
    }

    @After
    public void teardown() {
        driver.quit();
        String token = SetTestClass.loginUser();
        SetTestClass.deleteUser(token);
    }

    public void loginUser(String email, String pass, WebDriver driver) {
        LoginPage objLogPage = new LoginPage(driver);
        objLogPage.waitForLoadButtonLogin();
        objLogPage.login(email, pass);
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadButtonPersonalAccount();
        objHomePage.clickPersonalAccount();
        PersonalAccountPage objectPersonalAccountPage = new PersonalAccountPage(driver);
        objectPersonalAccountPage.assertVisibleButtonExit();
    }
}
