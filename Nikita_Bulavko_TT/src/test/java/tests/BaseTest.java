package tests;

import config.DriverConfig;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public abstract class BaseTest {

    private static final String APP_PACKAGE = "com.alfabank.qapp";

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverConfig.createDriver();
        driver.terminateApp(APP_PACKAGE);
        driver.activateApp(APP_PACKAGE);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
