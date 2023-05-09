package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CarDetailPage extends ReusableMethods {
    WebDriver driver;

    public CarDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    private final String DETAIL_PAGE_TITLE_XPATH = "//h1[@class='yellow-underline']";
    private final String ENGINE_OPTIONS_BUTTON = "//a[@data-href='#engine-options']";


    public String getCarDetailTitle() {

        return getTextOfElement(DETAIL_PAGE_TITLE_XPATH);
    }

    public boolean isEngineOptionsButtonClickable() {

        return isClickable(ENGINE_OPTIONS_BUTTON);
    }

}
