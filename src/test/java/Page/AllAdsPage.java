package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AllAds extends ReusableMethods {
    WebDriver driver;

    public AllAds(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Tüm İlanlar')]")
    private WebElement allAdsElement;

    @FindBy(xpath = "//a[@class='fav-menu-button']")
    private WebElement favAdsButton;

    @FindBy(xpath = "//button[@id='favSearchButton']")
    private WebElement favSearchButton;

    @FindBy(xpath = "//button[@id='compareButton']")
    private WebElement compareAdsButton;

    @FindBy(xpath = "//img[@alt='arabam.com']")
    private WebElement logo;

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
    }
}
