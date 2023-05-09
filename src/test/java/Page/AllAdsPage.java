package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AllAdsPage extends ReusableMethods {
    WebDriver driver;

    public AllAdsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private final String FAV_ADS_BUTTON = "//a[@class='fav-menu-button']";
    private final String FAV_SEARCH_BUTTON = "//button[@id='favSearchButton']";
    private final String COMPARE_ADS_BUTTON = "//button[@id='compareButton']";
    private final String ARABAM_COM_LOGO =  "//img[@alt='arabam.com']";

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
