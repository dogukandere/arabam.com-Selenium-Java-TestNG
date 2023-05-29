package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v108.page.Page;
import org.openqa.selenium.support.PageFactory;

public class ArabamHomePage extends ReusableMethods {
    WebDriver driver;

    public ArabamHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private final By ZERO_KM_CAR_BUTTON = By.xpath("//p[contains(text(),'Sıfır km araç özelliklerini ve')]");
    private final By ARABAM_COM_LOGO = By.xpath("//img[@alt='arabam.com']");
    private final By ALL_ADDS_ELEMENT = By.xpath("//span[contains(text(),'Tüm İlanlar')]");
    private final By LAST_24_HOUR_BUTTON = By.xpath("//span[normalize-space()='Son 24 Saat']");

    public ZeroKmCarPage clickZeroCarButton(){

        click(ZERO_KM_CAR_BUTTON);
        return new ZeroKmCarPage(driver);
    }

    public boolean isArabamLogoDisplayed() {

        return isDisplayed(ARABAM_COM_LOGO);
    }

    public AllAdsPage goToAllAds(){

        click(ALL_ADDS_ELEMENT);
        return new AllAdsPage(driver);
    }

    public Last24HourPage goToLast24HourPage(){

        click(LAST_24_HOUR_BUTTON);
        return new Last24HourPage(driver);
    }
}
