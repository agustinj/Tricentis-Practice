package testBase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsuranceDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionsPageObjects;
import reusableComponents.PropertiesOperations;

public class TestBase extends ObjectsRepo {
    public void launchBrowserAndNavigate() throws Exception {
        //read prop file and get browser and url
        String browser = PropertiesOperations.getPropertyValueByKey("browser");
        String url = PropertiesOperations.getPropertyValueByKey("url");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        ///It will get executed before each test method within current class
        @BeforeMethod
        public void setupMethod() throws Exception {
            launchBrowserAndNavigate();
            homepage = new HomePageObjects();
            vehData = new EnterVehicleDataPageObjects();
            insData = new EnterInsuranceDataPageObjects();
            prodData = new EnterProductDataPageObjects();
            priceOptions = new SelectPriceOptionsPageObjects();
        }

        @AfterMethod
        public void cleanUp() {
            driver.quit();
        }

    }
}
