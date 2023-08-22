package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZeroKmCarPage extends ReusableMethods {

    WebDriver driver;

    public ZeroKmCarPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
    }

    private static final By BRAND = By.xpath("//select[@class='brands']");
    private static final By MODEL = By.xpath("//select[@class='select-sub-model']");
    private static final By SEARCH_BUTTON = By.xpath("//button[@id='js-hook-search-by-brand-modelbase']");

    public ZeroKmCarPage selectBrand(String brandName){

        dropDownSelectByText(BRAND, brandName);
        return this;
    }

    public ZeroKmCarPage selectModel(String modelName){

        dropDownSelectByText(MODEL,modelName);
        return this;
    }

    public CarDetailPage clickSearchButton(){

        click(SEARCH_BUTTON);
        return new CarDetailPage(driver);
    }
}
