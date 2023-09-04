import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import model.HomePage;
public class BuilderTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = SetWebDriver.setupDriver();
        driver.get(SetWebDriver.getUrlHome());
    }

    @Test
    @DisplayName("Переход в раздел Булки")
    @Description("Проверка возможности перехода к разделу Булки в Конструкторе")
    public void TransitionsToBun() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadButtonPersonalAccount();
        objHomePage.assertTransitionsToSauce();
        objHomePage.assertTransitionsToBun();
    }

    @Test
    @DisplayName("Переход в раздел Соусы")
    @Description("Проверка возможности перехода к разделу Соусы в Конструкторе")
    public void TransitionsToSauce() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadButtonPersonalAccount();
        objHomePage.assertTransitionsToSauce();
    }

    @Test
    @DisplayName("Переход в раздел Начинки")
    @Description("Проверка возможности перехода к разделу Начинки в Конструкторе")
    public void TransitionsToFilling() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitForLoadButtonPersonalAccount();
        objHomePage.assertTransitionsToFilling();
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
