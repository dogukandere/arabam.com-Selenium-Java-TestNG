package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static Utilities.DriverFactory.driver;

public class ReusableMethods {

    public void click(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }

    public boolean isDisplayed(By by){
        WebElement element = driver.findElement(by);
        return element.isDisplayed();
    }

    public boolean isClickable(By by){
        WebElement element = driver.findElement(by);
        return element.isEnabled();
    }

    public void sendKeys(By by, String value){
        WebElement element = driver.findElement(by);
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
