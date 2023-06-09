package testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import reusableComponents.CommonMethods;
    public class ObjectsRepo {
        //Initialize main objects
        public static WebDriver driver;
        public static ExtentReports extent;
        public static ExtentTest test;
        public static HomePageObjects homepage;
        //Initialize objects specific for the project
        public static EnterVehicleDataPageObjects vehData;
        public static EnterInsuranceDataPageObjects insData;
        public static EnterProductDataPageObjects prodData;
        public static SelectPriceOptionsPageObjects priceOptions;


        public CommonMethods cm = new CommonMethods();
    }

