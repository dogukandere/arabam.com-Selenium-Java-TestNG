package Pages;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ZeroKmCarPage extends ReusableMethods {
    WebDriver driver;

    public ZeroKmCarPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    private final String zeroKmCarButton = "//p[contains(text(),'Sıfır km araç özelliklerini ve')]";
    private final String brand = "//select[@class='brands']";
    private final String model = "//select[@class='select-sub-model']";
    private final String search = "//button[@id='js-hook-search-by-brand-modelbase']";
    private final String textElement = "//h1[@class='yellow-underline']";
    private final String logo = "//img[@alt='arabam.com']";
    private final String engineOptions = "//a[@data-href='#engine-options']";

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

    public void selectModel(){
        dropDownSelectByText(model,"7 serisi");
    }

    public void searhCar(){
        click(search);
    }

    public void verify(){
        textAssert(textElement,"2022 BMW 7 serisi Fiyat Listesi");
        Assert.assertEquals("https://www.arabam.com/sifir-km/bmw-7-serisi-fiyat-listesi-yakit-tuketimi",driver.getCurrentUrl());
        Assert.assertEquals("BMW 7 serisi Fiyat Listesi - Sıfır 2022 BMW 7 serisi Fiyatları",driver.getTitle());
        isDisplayed(logo);
        isClickable(engineOptions);
        waitFor(2);
    }
}
