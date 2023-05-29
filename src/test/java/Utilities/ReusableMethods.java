package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Driver;
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

    public void click(By xpath){
        WebElement element = driver.findElement(xpath);
        waitUntilElementIsVisible(element,10);
        element.click();
    }

    public boolean isDisplayed(By xpath){
        WebElement element = driver.findElement(xpath);
        waitUntilElementIsVisible(element,10);
        return element.isDisplayed();
    }

    public boolean isClickable(By xpath){
        WebElement element = driver.findElement(xpath);
        return element.isEnabled();
    }

    public void sendKeys(By xpath, String value){
        WebElement element = driver.findElement(xpath);
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

    public void dropDownSelectByText(By xpath,String value){
        WebElement element = driver.findElement(xpath);
        Select VisibleText = new Select (element);
        VisibleText.selectByVisibleText(value);
    }

    protected String getTextOfElement(By xpath) {
        return driver.findElement(xpath).getText();
    }
}
