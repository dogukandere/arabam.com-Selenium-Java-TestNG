package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarDetailPage extends ReusableMethods {

    WebDriver driver;

    public CarDetailPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
    }

    private static final By DETAIL_PAGE_TITLE_XPATH = By.xpath("//h1[@class='yellow-underline']");
    private static final By ENGINE_OPTIONS_BUTTON = By.xpath("//a[@data-href='#engine-options']");

    public String getCarDetailTitle() {

        return getTextOfElement(DETAIL_PAGE_TITLE_XPATH);
    }

    public boolean isEngineOptionsButtonClickable() {

        return isClickable(ENGINE_OPTIONS_BUTTON);
    }
}
