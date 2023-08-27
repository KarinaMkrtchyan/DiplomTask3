package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPassPage {
    private By buttonLogin = By.xpath(".//a[text()='Войти']");
    private WebDriver driver;

    public RecoverPassPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }
}
