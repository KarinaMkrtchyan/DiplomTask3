package model;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private By name = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private By email = By.xpath(".//label[text()='Email']/following-sibling::input");
    private By password = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private By buttonRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    private By buttonLogin = By.xpath(".//a[text()='Войти']");
    private By fieldError = By.xpath(".//p[contains(@class,'input__error')]");
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String text) {
        driver.findElement(this.name).sendKeys(text);
    }

    public void setEmail(String text) {
        driver.findElement(this.email).sendKeys(text);
    }

    public void setPassword(String text) {
        driver.findElement(this.password).sendKeys(text);
    }

    public void assertTextError() {
        String textError = driver.findElement(fieldError).getText();
        Assert.assertTrue(textError, equals("Некорректный пароль"));
    }

    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }

    public void register(String name, String email, String pass) {
        setName(name);
        setEmail(email);
        setPassword(pass);
        clickButtonRegistration();
    }
}
