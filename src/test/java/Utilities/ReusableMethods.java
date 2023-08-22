package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ReusableMethods {

    WebDriver driver;
    WebDriverWait wait;

    public ReusableMethods(WebDriverWait wait) {
        this.wait = wait;
    }

    public ReusableMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilElementIsVisible(WebElement element , int time){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementIsClickable(WebElement element , int time){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(By by){

        WebElement element = driver.findElement(by);
        waitUntilElementIsVisible(element,10);
        element.click();
    }

    public boolean isDisplayed(By by){

        WebElement element = driver.findElement(by);
        waitUntilElementIsVisible(element,10);
        return element.isDisplayed();
    }

    public boolean isClickable(By by){

        WebElement element = driver.findElement(by);
        waitUntilElementIsVisible(element,10);
        return element.isEnabled();
    }

    public void sendKeys(By by, String value){

        WebElement element = driver.findElement(by);
        waitUntilElementIsVisible(element,10);
        element.sendKeys(value);
    }

    public ReusableMethods waitFor(int sec) {

        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void dropDownSelectByText(By by,String value){

        WebElement element = driver.findElement(by);
        Select VisibleText = new Select (element);
        VisibleText.selectByVisibleText(value);
    }

    protected String getTextOfElement(By by) {

        return driver.findElement(by).getText();
    }
}
