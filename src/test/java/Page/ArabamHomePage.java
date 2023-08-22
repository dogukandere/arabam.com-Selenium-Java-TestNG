package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArabamHomePage extends ReusableMethods {

    WebDriver driver;

    public ArabamHomePage(WebDriver driver) {

        super(driver);
        this.driver = driver;
    }

    private static final By ZERO_KM_CAR_BUTTON = By.xpath("//p[contains(text(),'Sıfır km araç özelliklerini ve')]");
    private static final By ARABAM_COM_LOGO = By.xpath("//img[@alt='arabam.com']");
    private static final By ALL_ADDS_ELEMENT = By.xpath("//span[contains(text(),'Tüm İlanlar')]");
    private static final By LAST_24_HOURS_BUTTON = By.xpath("//span[normalize-space()='Son 24 Saat']");

    public ZeroKmCarPage clickZeroKmCarButton(){

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

    public Last24HoursPage goToLast24HourPage(){

        click(LAST_24_HOURS_BUTTON);
        return new Last24HoursPage(driver);
    }
}
