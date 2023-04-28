package testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionsPageObjects;
import reusableComponents.CommonMethods;

public class ObjectsRepo {
    public class ObjectsRepo {
        //Initialize main objects
        public static WebDriver driver;
        public static ExtentReports extent;
        public static ExtentTest test;
        public static HomePageObjects homepage;
        //Initialize objects specific for the project
        public static EnterVehicalDataPageObjects vehData;
        public static EnterInsurantDataPageObjects insData;
        public static EnterProductDataPageObjects prodData;
        public static SelectPriceOptionsPageObjects priceOptions;

        
        public CommonMethods cm = new CommonMethods();
    }
}
