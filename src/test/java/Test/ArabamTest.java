package Test;

import Page.ArabamHomePage;
import Page.CarDetailPage;
import Pages.AllAdsPage;
import Utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArabamTest extends TestBase {

   private AllAdsPage allAdsPage;
    private ArabamHomePage homePage;
    private CarDetailPage carDetailPage;


     private static final String mainUrl = "https://www.arabam.com/";


     @BeforeClass
     public void before() {

         homePage = new ArabamHomePage(driver);
         carDetailPage = new CarDetailPage(driver);

         navigateToUrl(mainUrl);
     }


    @Test(priority = 1 , description = "Search a car on the zero km car page")
    public void checkBmw7SeriesDetailPage(){

        homePage.clickZeroCarButton()
                .selectBrand("BMW")
                .selectModel("7 serisi")
                .clickSearchButton();

        Assert.assertEquals(carDetailPage.getCarDetailTitle(),"2022 BMW 7 serisi Fiyat Listesi");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.arabam.com/sifir-km/bmw-7-serisi-fiyat-listesi-yakit-tuketimi");
        Assert.assertEquals(driver.getTitle(), "BMW 7 serisi Fiyat Listesi - Sıfır 2022 BMW 7 serisi Fiyatları");
        Assert.assertTrue(homePage.isArabamLogoDisplayed());
        Assert.assertTrue(carDetailPage.isEngineOptionsButtonClickable());
    }


    @Test(priority = 2 , description = "Verify the all ads page")
    public void test02(){
        allAdsPage = new AllAdsPage(driver);
        allAdsPage.goToAllAds();
        allAdsPage.verifyClickable();
        allAdsPage.verifyLogoLinkTitle();
    }
}
