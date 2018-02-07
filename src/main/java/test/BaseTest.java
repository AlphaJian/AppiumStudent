package test;

import utils.ConfigUtility;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.net.URL;

public class BaseTest {
    public ConfigUtility configUtil = ConfigUtility.getInstance();

    protected AppiumDriver driver;

    @BeforeSuite
    public void setUp() throws Exception {
        System.out.println("====");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String localApp = "";

        if (configUtil.isIOSPlatform()) {
            capabilities.setCapability("appium-version", "1.6.5");
            capabilities.setCapability("platformVersion", "10.2");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "iPhone 7");
            capabilities.setCapability("automationName","XCUITest");
            capabilities.setCapability("noReset",true);
            localApp = "/alo7-student.app";
        } else {
            capabilities.setCapability("appium-version", "1.6.5");
            capabilities.setCapability("platformVersion", "6.0");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Nexus 6");
            capabilities.setCapability("appActivity", "com.alo7.android.student.activity.SplashActivity");
            capabilities.setCapability("appPackage", "com.alo7.android.student");
            localApp = "/alo7-student.apk";
        }

//        capabilities.setCapability("fullReset",true);

        // Set job name on Sauce Labs
        String userDir = System.getProperty("user.dir");
        String appPath = userDir + localApp;
        appPath = "/Users/ken.zhang/Documents/UITest/AppiumStudent/alo7-student.app";
        capabilities.setCapability("app", appPath);
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
