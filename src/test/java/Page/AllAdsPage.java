package Pages;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AllAdsPage extends ReusableMethods {
    WebDriver driver;

    public AllAdsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private final String allAdsElement =  "//span[contains(text(),'Tüm İlanlar')]";
    private final String favAdsButton = "//a[@class='fav-menu-button']";
    private final String favSearchButton = "//button[@id='favSearchButton']";
    private final String compareAdsButton = "//button[@id='compareButton']";
    private final String logo =  "//img[@alt='arabam.com']";

    public void goToAllAds(){
        click(allAdsElement);
    }
    public void verifyClickable(){
        isClickable(favAdsButton);
        isClickable(favSearchButton);
        isClickable(compareAdsButton);
    }

    public void verifyLogoLinkTitle(){
        isDisplayed(logo);
        Assert.assertEquals("https://www.arabam.com/ikinci-el",driver.getCurrentUrl());
        Assert.assertEquals("İkinci El Araba Fiyatları, Satılık 2. El Araba Modelleri arabam.com'da!",driver.getTitle());
        waitFor(3);
    }
}
