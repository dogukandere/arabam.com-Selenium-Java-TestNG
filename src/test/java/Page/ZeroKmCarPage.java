package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ZeroKmCarPage extends ReusableMethods {
    WebDriver driver;

    public ZeroKmCarPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private final String BRAND = "//select[@class='brands']";
    private final String MODEL = "//select[@class='select-sub-model']";
    private final String SEARCH_BUTTON = "//button[@id='js-hook-search-by-brand-modelbase']";


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
