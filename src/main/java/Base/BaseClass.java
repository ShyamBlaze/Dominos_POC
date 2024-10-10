package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;

    public static void initializeTheBrowser(String browser){

        if (browser.equalsIgnoreCase("chrome")){
driver = new ChromeDriver();

    } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            
        }else{
            throw new IllegalArgumentException("Brower not found");
        }

    }
    public static void openApplication(String url){driver.get(url);}
    public static void windowMax(){driver.manage().window().maximize();}
    public static void implicitWait(){driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));}
    public static void quitTheBrowser(){driver.quit();}
    }
