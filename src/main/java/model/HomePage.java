package model;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private By buttonPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private By tabSauce = By.xpath(".//div[contains(@class, 'tab_tab__1SPyG ')][2]");
    private By tabBun = By.xpath(".//div[contains(@class, 'tab_tab__1SPyG ')][1]");
    private By tabFilling = By.xpath(".//div[contains(@class, 'tab_tab__1SPyG ')][3]");
    private By buttonEntrance = By.xpath(".//button[text()='Войти в аккаунт']");
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }

    public void clickButtonEntrance() {
        driver.findElement(buttonEntrance).click();
    }

    public void assertVisibleButtonPersonalAccount() {
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(buttonPersonalAccount));
        driver.findElement(buttonPersonalAccount).isDisplayed();
    }

    public void assertTransitionsToSauce() {
        clickTabSauce();
        String text = driver.findElement(tabSauce).getAttribute("class");
        Assert.assertTrue(text.contains("tab_tab_type_current__2BEPc"));
    }

    public void assertTransitionsToBun() {
        clickTabBun();
        String text = driver.findElement(tabBun).getAttribute("class");
        Assert.assertTrue(text.contains("tab_tab_type_current__2BEPc"));
    }

    public void assertTransitionsToFilling() {
        clickTabFilling();
        String text = driver.findElement(tabFilling).getAttribute("class");
        Assert.assertTrue(text.contains("tab_tab_type_current__2BEPc"));
    }

    public void clickTabSauce() {

        driver.findElement(tabSauce).click();
    }

    public void clickTabBun() {
        driver.findElement(tabBun).click();
    }

    public void clickTabFilling() {
        driver.findElement(tabFilling).click();
    }

    public void waitForLoadButtonPersonalAccount() {
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(buttonPersonalAccount));
    }
}
