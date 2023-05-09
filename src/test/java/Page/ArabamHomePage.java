package Page;

import Page.ZeroKmCarPage;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ArabamHomePage extends ReusableMethods {
    WebDriver driver;

    public ArabamHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    private final String ZERO_KM_CAR_BUTTON = "//p[contains(text(),'Sıfır km araç özelliklerini ve')]";
    private final String ARABAM_COM_LOGO = "//img[@alt='arabam.com']";

    public ZeroKmCarPage clickZeroCarButton(){

        click(ZERO_KM_CAR_BUTTON);

        return new Page.ZeroKmCarPage(driver);
    }

    public boolean isArabamLogoDisplayed() {

        return isDisplayed(ARABAM_COM_LOGO);
    }
}
