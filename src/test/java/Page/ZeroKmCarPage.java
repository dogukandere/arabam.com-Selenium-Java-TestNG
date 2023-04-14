package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ZeroKmCar extends ReusableMethods {
    WebDriver driver;

    public ZeroKmCar(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//p[contains(text(),'Sıfır km araç özelliklerini ve')]")
    private WebElement zeroKmCarButton;

    @FindBy(xpath = "//select[@class='brands']")
    private WebElement brand;

    @FindBy(xpath = "//select[@class='select-sub-model']")
    private WebElement model;

    @FindBy(xpath = "//button[@id='js-hook-search-by-brand-modelbase']")
    private WebElement search;

    @FindBy(xpath = "//h1[@class='yellow-underline']")
    private WebElement textElement;

    @FindBy(xpath = "//img[@alt='arabam.com']")
    private WebElement logo;

    @FindBy(xpath = "//a[@data-href='#engine-options']")
    private WebElement engineOptions;

    public void navigateToUrl(){
        driver.navigate().to("https://www.arabam.com/");
    }

    public void goToZeroKmCarPage(){
        click(zeroKmCarButton);
        waitFor(2);
    }

    public void selectBrand(){
        dropDownSelectByText(brand,"BMW");
    }

    public void selecetModel(){
        dropDownSelectByText(model,"7 serisi");
    }

    public void searhCar(){
        click(search);
    }

    public void verify(){
        Assert.assertEquals("2022 BMW 7 serisi Fiyat Listesi",textElement.getText());
        Assert.assertEquals("https://www.arabam.com/sifir-km/bmw-7-serisi-fiyat-listesi-yakit-tuketimi",driver.getCurrentUrl());
        Assert.assertEquals("BMW 7 serisi Fiyat Listesi - Sıfır 2022 BMW 7 serisi Fiyatları",driver.getTitle());
        isDisplayed(logo);
        isClickable(engineOptions);
        waitFor(2);
    }
}
