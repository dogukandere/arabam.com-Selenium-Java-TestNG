package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;

public class Last24HoursPage extends ReusableMethods {

    private static final By CLEAR_BUTTON = By.xpath("//button[normalize-space()='Seçimleri Temizle']");
    private static final By RENT_A_CAR_BUTTON = By.xpath("//a[@class='tabpanel tabpanel-slim active']");
    private static final By YEAR_BUTTON = By.xpath("//a[@class='color-red4-on-hover tdu-on-hover sorting-item']//span[contains(text(),'Yıl')]");

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
