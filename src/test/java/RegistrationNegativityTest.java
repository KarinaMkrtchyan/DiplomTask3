import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import model.RegistrationPage;
public class RegistrationNegativityTest {
    static Faker faker = new Faker();
    private WebDriver driver;
    private final String name = SetTestClass.name;
    private final String email = SetTestClass.email;
    private final String pass = faker.internet().password(1, 5);

    @Before
    public void setup() {
        driver = SetWebDriver.setupDriver();
        driver.get(SetWebDriver.getUrlRegistration());
    }

    @Test(expected = AssertionError.class)
    @DisplayName("Регистрация пользователя с некорректными данными")
    @Description("Проверка невозможности регистрации пользователя с паролем меньше 6 символов")
    public void RegistrationUserWithIncorrectParams() throws AssertionError {
        RegistrationPage objRegPage = new RegistrationPage(driver);
        objRegPage.register(name, email, pass);
        objRegPage.assertTextError();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
