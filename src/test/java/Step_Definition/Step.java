package Step_Definition;

import Base.BaseClass;
import Pom.CartPage;
import Pom.Pincode;
import Pom.SelectItems;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Step extends BaseClass {

    SelectItems selectItems;
    CartPage cartPage;
    Pincode pincode;


    @Given("Launch {string} browser and URL {string}")
    public void launchBrowserAndURL(String browser, String url) {
        BaseClass.initializeTheBrowser(browser);
        BaseClass.windowMax();
        BaseClass.openApplication(url);
        BaseClass.implicitWait();
        selectItems = new SelectItems(driver);
        cartPage = new CartPage(driver);
        pincode = new Pincode(driver);
    }
    @When("User clicks on order online now button")
    public void userClicksOnOrderOnlineNowButton() throws InterruptedException {
        pincode.clickOrderOnBtn();

    }
    @When("User enters pincode {string}")
    public void userEntersPincode(String pCode) throws InterruptedException {
        pincode.clickAddField();

        pincode.addPincode(pCode);

    }
    @When("User selects the first suggestion area")
    public void userSelectsTheFirstSuggestionArea() throws InterruptedException {

        pincode.clickOnFirstArea();
    }
    @Then("User should navigate to the product page")
    public void userShouldNavigateToTheProductPage() {

        String url =driver.getCurrentUrl();
        System.out.println(url);
    }

    @When("User adds two quantities of Margherita Pizza")
    public void userAddsTwoQuantitiesOfMargheritaPizza() throws InterruptedException {
        selectItems.addMargherita();
    }

    @And("User adds two quantities of Peppy Paneer Pizza")
    public void userAddsTwoQuantitiesOfPeppyPaneerPizza() {
        selectItems.addPeppyPaneer();
    }

    @And("User adds two quantities of Farmhouse Pizza")
    public void userAddsTwoQuantitiesOfFarmhousePizza() {
        selectItems.addFarmHouse();

    }

    @And("User verifies subtotal value and sum of all pizza value are same")
    public void userVerifiesSubtotalValueAndSumOfAllPizzaValueAreSame() {
        Assert.assertTrue(selectItems.totalOfpizza());
    }

    @And("User adds tweleve quantities of pepsi")
    public void userAddsTweleveQuantitiesOfPepsi() {
        selectItems.addPepsi();

    }

    @And("User verifies subtotal value and sum of all product value are same")
    public void userVerifiesSubtotalValueAndSumOfAllProductValueAreSame() throws InterruptedException {
        selectItems.allProcutPrice();
        Thread.sleep(2000);
        Assert.assertTrue(selectItems.allProcutPrice());
    }

    @And("User removes one quantity of Margherita Pizza")
    public void userRemovesOneQuantityOfMargheritaPizza() {
        selectItems.remMargPizza();
    }

    @And("User removes six quanties of pepsi")
    public void userRemovesSixQuantiesOfPepsi() {
        selectItems.remPepsi();
    }

    @When("User clicks on checkout")
    public void userClicksOnCheckout() {
        cartPage.subPrice();
        cartPage.clickCheckOut();
    }

    @And("User verifies the checkout subtotal and place order subtotal are same")
    public void userVerifiesTheCheckoutSubtotalAndPlaceOrderSubtotalAreSame() {
        Assert.assertTrue(cartPage.verifyAmount());
    }

    @Then("Quit browser")
    public void quitBrowser() {
        BaseClass.quitTheBrowser();
    }
}
