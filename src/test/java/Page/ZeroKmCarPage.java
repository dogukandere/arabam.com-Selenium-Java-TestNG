package Page;

import Page.CarDetailPage;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ZeroKmCarPage extends ReusableMethods {
    WebDriver driver;

    public ZeroKmCarPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private final String brand = "//select[@class='brands']";
    private final String model = "//select[@class='select-sub-model']";
    private final String search = "//button[@id='js-hook-search-by-brand-modelbase']";


    public ZeroKmCarPage selectBrand(String brandName){
        dropDownSelectByText(brand, brandName);

        return this;
    }

    public ZeroKmCarPage selectModel(String modelName){
        dropDownSelectByText(model,modelName);

        return this;
    }

    public CarDetailPage clickSearchButton(){

        click(search);

        return new CarDetailPage(driver);
    }
}
