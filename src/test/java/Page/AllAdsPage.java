package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllAdsPage extends ReusableMethods {

    WebDriver driver;

    public AllAdsPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
    }

    private static final By FAV_ADS_BUTTON = By.xpath("//a[@class='fav-menu-button']") ;
    private static final By FAV_SEARCH_BUTTON = By.xpath("//button[@id='favSearchButton']");
    private static final By COMPARE_ADS_BUTTON = By.xpath("//button[@id='compareButton']");
    private static final By ARABAM_COM_LOGO = By.xpath("//img[@alt='arabam.com']");

    public boolean isFavAdsButtonDisplayed(){

        return isClickable(FAV_ADS_BUTTON);
    }

    public boolean isFavSearchButtonDisplayed(){

        return isClickable(FAV_SEARCH_BUTTON);
    }

    public boolean isCompareAdsButtonDisplayed(){

        return isClickable(COMPARE_ADS_BUTTON);
    }

    public boolean isArabamLogoDisplayed(){

        return isDisplayed(ARABAM_COM_LOGO);
    }
}
