package Test;

import Page.ArabamHomePage;
import Page.CarDetailPage;
import Page.AllAdsPage;
import Utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArabamTest extends TestBase {

    private ArabamHomePage arabamHomePage;
    private CarDetailPage carDetailPage;
    private AllAdsPage allAdsPage;

    private static final String mainUrl = "https://www.arabam.com/";

     @BeforeClass
     public void before() {
         arabamHomePage = new ArabamHomePage(driver);
         carDetailPage = new CarDetailPage(driver);
         allAdsPage = new AllAdsPage(driver);

         navigateToUrl(mainUrl);
     }

    @Test(priority = 1 , description = "Search a car on the zero km car page")
    public void checkBmw7SeriesDetailPage(){
        arabamHomePage.clickZeroCarButton()
                .selectBrand("BMWW")
                .selectModel("7 serisi")
                .clickSearchButton();

        Assert.assertEquals(carDetailPage.getCarDetailTitle(),"2022 BMW 7 serisi Fiyat Listesi");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.arabam.com/sifir-km/bmw-7-serisi-fiyat-listesi-yakit-tuketimi");
        Assert.assertEquals(driver.getTitle(), "BMW 7 serisi Fiyat Listesi - Sıfır 2022 BMW 7 serisi Fiyatları");
        Assert.assertTrue(arabamHomePage.isArabamLogoDisplayed());
        Assert.assertTrue(carDetailPage.isEngineOptionsButtonClickable());
    }

    @Test(priority = 2 , description = "Verify the all ads page")
    public void test02(){
        navigateToUrl(mainUrl);
        arabamHomePage.goToAllAds();
        Assert.assertTrue(allAdsPage.isFavAdsButtonDisplayed());
        Assert.assertTrue(allAdsPage.isFavSearchButtonDisplayed());
        Assert.assertTrue(allAdsPage.isCompareAdsButtonDisplayed());
        Assert.assertTrue(allAdsPage.isArabamLogoDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.arabam.com/ikinci-el");
        Assert.assertEquals(driver.getTitle(),"İkinci El Araba Fiyatları, Satılık 2. El Araba Modelleri arabam.com'da!");
    }
}
