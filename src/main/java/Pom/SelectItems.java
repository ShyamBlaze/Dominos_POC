package Pom;

import Base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectItems extends BaseClass {
    WebDriver driver;

    public SelectItems(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-label='Add button']")
    private WebElement noThanks;

    @FindBy(xpath = "//div[@class='mn-hdr hide']//span[text()='VEG PIZZA']")
    private WebElement vegPizza;

    @FindBy(xpath = "//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Veg Pizza']//span[text()='Farmhouse']//parent::div//parent::div//button")
    private WebElement farmhouseAddCartBtn;
    @FindBy(xpath = "//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Veg Pizza']//span[text()='Farmhouse']//parent::div//parent::div//div[@data-label='increase']")
    private WebElement farmHouseIncBtn;
    @FindBy(xpath = "//span[text()='Farmhouse']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//span//span")
    private WebElement farmhouseTotalPrice;

    @FindBy(xpath = "//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Veg Pizza']//span[text()='Margherita']//parent::div//parent::div//button")
    private WebElement margeritaAddCartBtn;
    @FindBy(xpath = "//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Veg Pizza']//span[text()='Margherita']//parent::div//parent::div//div[@data-label='increase']")
    private WebElement margheritaIncBtn;
    @FindBy(xpath = "//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Veg Pizza']//span[text()='Margherita']//parent::div//parent::div//div[@data-label='decrease']")
    private WebElement margheritaDecBtn;
    @FindBy(xpath = "//span[text()='Margherita']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//span//span")
    private WebElement margheritaTotalPrice;

    @FindBy(xpath = "//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Veg Pizza']//span[text()='Peppy Paneer']//parent::div//parent::div//button")
    private WebElement peppPaneerAddCartBtn;
    @FindBy(xpath = "//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Veg Pizza']//span[text()='Peppy Paneer']//parent::div//parent::div//div[@data-label='increase']")
    private WebElement pepPaneerIncBtn;
    @FindBy(xpath = "//span[text()='Peppy Paneer']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//span//span")
    private WebElement peppPaneerTotalPrice;

    @FindBy(xpath = "//div[@class='mn-hdr hide']//span[text()='BEVERAGES']")
    private WebElement beverages;
    @FindBy(xpath = "//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Beverages']//span[text()='Pepsi 475ml']//parent::div//parent::div//button")
    private WebElement pepsiAddCartBtn;
    @FindBy (xpath = "//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Beverages']//span[text()='Pepsi 475ml']//parent::div//parent::div//div[@data-label='increase']")
    private WebElement pepsiIncBtn;
    @FindBy (xpath = "//div[@class='sc-bYSBpT gRzrIn']//div[@data-label='Beverages']//span[text()='Pepsi 475ml']//parent::div//parent::div//div[@data-label='decrease']")
    private WebElement pepsiDecBtn;
    @FindBy(xpath = "//span[text()='Pepsi 475ml']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//span//span")
    private WebElement pepsiTotalPrice;
    @FindBy(xpath = "//span[text()='Pepsi 475ml']//ancestor::div[@class='crt-cntnt']//div[@class='crt-cnt-qty-prc']//div//div//span")
    private WebElement pepsiQtyNo;

    @FindBy(xpath = "//span[@class='rupee sb-ttl']")
    private WebElement subTotalPrice;

    public void addMargherita() throws InterruptedException {

        vegPizza.click();
        Thread.sleep(5000);
        margeritaAddCartBtn.click();
        noThanks.click();
        margheritaIncBtn.click();
    }
    public void addPeppyPaneer(){
        peppPaneerAddCartBtn.click();
        pepPaneerIncBtn.click();
    }
    public void addFarmHouse(){
        farmhouseAddCartBtn.click();
        farmHouseIncBtn.click();
    }
    public boolean totalOfpizza(){
        String sub= subTotalPrice.getText();
        String marg = margheritaTotalPrice.getText();
        String farm = farmhouseTotalPrice.getText();
        String peppPan = peppPaneerTotalPrice.getText();

        double margPrice = Double.parseDouble(marg);
        double farmPrice = Double.parseDouble(farm);
        double PeppPanPrice = Double.parseDouble(peppPan);
        double totalPrizzPrice = margPrice+farmPrice+PeppPanPrice;
        double subPrice = Double.parseDouble(sub);
        boolean equals;
        if(totalPrizzPrice==subPrice) {
            equals = true;
        }else {
            equals = false;
        }

        return equals;
    }
    public void addPepsi(){

        beverages.click();
        pepsiAddCartBtn.click();
        String pepsiQuantity = pepsiQtyNo.getText();

        int pepQty = Integer.parseInt(pepsiQuantity);
        int i=0;
        int targetQuantity = 12;

        while (pepQty < targetQuantity) {
            pepsiIncBtn.click();
            i++;
            pepsiQuantity = pepsiQtyNo.getText();
            pepQty = Integer.parseInt(pepsiQuantity);
        }
    }
    public boolean allProcutPrice(){
        String sub= subTotalPrice.getText();
        String marg = margheritaTotalPrice.getText();
        String farm = farmhouseTotalPrice.getText();
        String peppPan = peppPaneerTotalPrice.getText();
        String peps = pepsiTotalPrice.getText();

        double margPrice = Double.parseDouble(marg);
        double farmPrice = Double.parseDouble(farm);
        double PeppPanPrice = Double.parseDouble(peppPan);
        double pepsPrice = Double.parseDouble(peps);
        double totalPrizzPrice = margPrice+farmPrice+PeppPanPrice+pepsPrice;
        double subPrice = Double.parseDouble(sub);
        boolean equals;

        if(totalPrizzPrice==subPrice){
            equals = true;
        }else {
            equals = false;
        }
        return equals;

    }
    public void remMargPizza(){
        vegPizza.click();
        margheritaDecBtn.click();
    }
    public void remPepsi(){
        beverages.click();
        String pepsiQuantity = pepsiQtyNo.getText();

        int pepQty = Integer.parseInt(pepsiQuantity);
        int i=0;
        int targetQuantity = 6;

        while (pepQty > targetQuantity) {
            pepsiDecBtn.click();
            i++;
            pepsiQuantity = pepsiQtyNo.getText();
            pepQty = Integer.parseInt(pepsiQuantity);
        }

    }

}
