package Pom;

import Base.BaseClass;
import io.cucumber.java.eo.Do;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseClass {
    WebDriver driver;


    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='chkot-ftr-prc']//span[@class='rupee sb-ttl']")
    private WebElement checkSubTotalPrice;

    @FindBy(xpath = "//button[@data-label='miniCartCheckout']")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//div[@class='txt--wrpr']//span[contains(@class,'sc-kPVwWT dXwbwr')]//span[@class='rupee']")
    private WebElement placeSubTotalPrice;

    private Double sub;

    public void subPrice(){
        String checksubPrice = checkSubTotalPrice.getText();
        this.sub = Double.parseDouble(checksubPrice);
    }

    public void clickCheckOut(){
        checkoutBtn.click();
    }
    public boolean verifyAmount(){
        String placeSubPrice = placeSubTotalPrice.getText();
        Double placePrice = Double.parseDouble(placeSubPrice);
        boolean priceEquals;
        if (sub==placePrice){
            priceEquals = false;
        }
        else {
            priceEquals = true;
        }
        return priceEquals;

    }

}
