package Test;

import Pages.AllAdsPage;
import Pages.ZeroKmCarPage;
import Utilities.TestBase;
import org.testng.annotations.Test;

public class ArabamTest extends TestBase {
    ZeroKmCarPage zeroKmCarPage;
    AllAdsPage allAdsPage;
    @Test(priority = 1 , description = "Search a car on the zero km car page")
    public void test01(){
        zeroKmCarPage = new ZeroKmCarPage(driver);
        zeroKmCarPage.navigateToUrl();
        zeroKmCarPage.goToZeroKmCarPage();
        zeroKmCarPage.selectBrand();
        zeroKmCarPage.selectModel();
        zeroKmCarPage.searhCar();
        zeroKmCarPage.verify();
    }
    @Test(priority = 2 , description = "Verify the all ads page")
    public void test02(){
        allAdsPage = new AllAdsPage(driver);
        zeroKmCarPage.navigateToUrl();
        allAdsPage.goToAllAds();
        allAdsPage.verifyClickable();
        allAdsPage.verifyLogoLinkTitle();
    }
}
