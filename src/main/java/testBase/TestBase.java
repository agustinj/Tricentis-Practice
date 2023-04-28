package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.*;
import reusableComponents.PropertiesOperations;

import static testBase.ObjectsRepo.ObjectsRepo.driver;

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

        @BeforeMethod   /// it will get execute before each test method within current class
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
