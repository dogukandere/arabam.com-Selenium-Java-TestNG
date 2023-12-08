package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;

public class AllAdsPage extends ReusableMethods {

    private static final By FAV_ADS_BUTTON = By.xpath("//a[@class='fav-menu-button']") ;
    private static final By FAV_SEARCH_BUTTON = By.xpath("//button[@id='favSearchButton']");
    private static final By COMPARE_ADS_BUTTON = By.xpath("//button[@id='compareButton']");
    private static final By ARABAM_COM_LOGO = By.xpath("//img[@alt='arabam.com']");

    public boolean isFavAdsButtonDisplayed(){
        return isDisplayed(FAV_ADS_BUTTON);
    }

    public boolean isFavSearchButtonDisplayed(){
        return isDisplayed(FAV_SEARCH_BUTTON);
    }

    public boolean isCompareAdsButtonDisplayed(){
        return isDisplayed(COMPARE_ADS_BUTTON);
    }

    public boolean isArabamLogoDisplayed(){
        return isDisplayed(ARABAM_COM_LOGO);
    }
}
