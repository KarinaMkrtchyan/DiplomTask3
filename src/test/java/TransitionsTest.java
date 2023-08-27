import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import model.*;
public class TransitionsTest {
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
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка перехода по клику на «Личный кабинет")
    public void TransitionsToPersonalAccountFromHomePage() {
        loginUser(email, pass, driver);
        PersonalAccountPage objectPersonalAccountPage = new PersonalAccountPage(driver);
        objectPersonalAccountPage.assertVisibleButtonExit();

    }

    @Test
    @DisplayName("Переход из Личного кабинета в Конструктор")
    @Description("Проверка перехода в Конструктор по клику на «Конструктор»")
    public void TransitionsToBuilderOnHomePageFromPersonalAccount() {
        loginUser(email, pass, driver);
        PersonalAccountPage objectPersonalAccountPage = new PersonalAccountPage(driver);
        objectPersonalAccountPage.waitForLoadButtonBuilder();
        objectPersonalAccountPage.clickButtonBuilder();
        HomePage objHomePage1 = new HomePage(driver);
        objHomePage1.assertVisibleButtonPersonalAccount();
    }

    @Test
    @DisplayName("Переход из Личного кабинета в Конструктор")
    @Description("Проверка перехода в Конструктор по клику на логотип Stellar Burgers")
    public void TransitionsToLogoFromPersonalAccount() {
        loginUser(email, pass, driver);
        PersonalAccountPage objectPersonalAccountPage = new PersonalAccountPage(driver);
        objectPersonalAccountPage.waitForLoadButtonBuilder();
        objectPersonalAccountPage.clickLogoBurger();
        HomePage objHomePage1 = new HomePage(driver);
        objHomePage1.assertVisibleButtonPersonalAccount();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверка выход по кнопке «Выйти» в личном кабинете")
    public void ExitFromAccount() {
        loginUser(email, pass, driver);
        PersonalAccountPage objectPersonalAccountPage = new PersonalAccountPage(driver);
        objectPersonalAccountPage.assertVisibleButtonExit();
        objectPersonalAccountPage.clickExit();
        LoginPage objLogPage1 = new LoginPage(driver);
        objLogPage1.waitForLoadButtonLogin();
    }

    @After
    public void teardown() {
        driver.quit();
        String token = SetTestClass.loginUser();
        SetTestClass.deleteUser(token);
    }

    public void loginUser(String email, String pass, WebDriver driver) {
        driver.get(SetWebDriver.getUrlLogin());
        LoginPage objLogPage = new LoginPage(driver);
        objLogPage.waitForLoadButtonLogin();
        objLogPage.login(email, pass);
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadButtonPersonalAccount();
        objHomePage.clickPersonalAccount();
    }
}
