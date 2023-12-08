package Test;

import Page.ArabamHomePage;
import Page.CarDetailPage;
import Page.AllAdsPage;
import Page.Last24HoursPage;
import Utilities.DriverFactory;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Utilities.DriverFactory.driver;

public class ArabamTest {

    private static ArabamHomePage arabamHomePage;
    private static CarDetailPage carDetailPage;
    private static AllAdsPage allAdsPage;
    private static Last24HoursPage last24HoursPage;

    private static final String mainUrl = "https://www.arabam.com/";

     @BeforeTest
     public void before() {
         DriverFactory.getDriver();

         arabamHomePage = new ArabamHomePage();
         carDetailPage = new CarDetailPage();
         allAdsPage = new AllAdsPage();
         last24HoursPage = new Last24HoursPage();
     }

    @Test(priority = 1 , description = "Search a car on the zero km car page")
    public void checkBmw7SeriesDetailPage(){
        driver.navigate().to(mainUrl);
        arabamHomePage.clickZeroKmCarButton()
                .selectBrand("BMW")
                .selectModel("7 serisi")
                .clickSearchButton();

        assertEquals(carDetailPage.getCarDetailTitle(),"2022 BMW 7 serisi Fiyat Listesi");
        assertEquals(driver.getCurrentUrl(), "https://www.arabam.com/sifir-km/bmw-7-serisi-fiyat-listesi-yakit-tuketimi");
        assertEquals(driver.getTitle(), "BMW 7 serisi Fiyat Listesi - Sıfır 2022 BMW 7 serisi Fiyatları");
        assertTrue(arabamHomePage.isArabamLogoDisplayed());
        assertTrue(carDetailPage.isEngineOptionsButtonClickable());
    }

    @Test(priority = 2 , description = "Verify the all ads page")
    public void test02(){
        driver.navigate().to(mainUrl);
        arabamHomePage.goToAllAds();
        assertTrue(allAdsPage.isFavAdsButtonDisplayed());
        assertTrue(allAdsPage.isFavSearchButtonDisplayed());
        assertTrue(allAdsPage.isCompareAdsButtonDisplayed());
        assertTrue(allAdsPage.isArabamLogoDisplayed());
        assertEquals(driver.getCurrentUrl(),"https://www.arabam.com/ikinci-el");
        assertEquals(driver.getTitle(),"İkinci El Araba Fiyatları, Satılık 2. El Araba Modelleri arabam.com'da!");
    }

    @Test(priority = 3 , description = "Verify the last 24 hour page")
    public void test03(){
         driver.navigate().to(mainUrl);
         arabamHomePage.goToLast24HourPage();
         assertEquals(driver.getCurrentUrl(),"https://www.arabam.com/ikinci-el?days=1");
         assertTrue(last24HoursPage.isClearButtonDisplayed());
         assertTrue(last24HoursPage.isRentACarButtonDisplayed());
         assertTrue(last24HoursPage.isYearButtonDisplayed());
    }
}
