package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Last24HourPage extends ReusableMethods {
    WebDriver driver;

    public Last24HourPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private final By CLEAR_BUTTON = By.xpath("//button[normalize-space()='Seçimleri Temizle']");
    private final By RENT_A_CAR_BUTTON = By.xpath("//a[@class='tabpanel tabpanel-slim active']");
    private final By YEAR_BUTTON = By.xpath("//a[@class='color-red4-on-hover tdu-on-hover sorting-item']//span[contains(text(),'Yıl')]");

    public boolean isClearButtonDisplayed(){

        return isDisplayed(CLEAR_BUTTON);
    }

    public boolean isRentACarButtonDisplayed(){

        return isDisplayed(RENT_A_CAR_BUTTON);
    }

    public boolean isYearButtonDisplayed(){

        return isDisplayed(YEAR_BUTTON);
    }
}
