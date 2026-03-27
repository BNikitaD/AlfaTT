package config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverConfig {

    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";
    private static final String APP_PACKAGE = "com.alfabank.qapp";
    private static final String APP_ACTIVITY = "com.alfabank.qapp.presentation.MainActivity";
    private static final String DEVICE_NAME = "emulator-5554";

    private static final Duration IMPLICIT_WAIT = Duration.ofSeconds(10);
    public  static final Duration EXPLICIT_WAIT = Duration.ofSeconds(15);

    public static AndroidDriver createDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(DEVICE_NAME);
        options.setAppPackage(APP_PACKAGE);
        options.setAppActivity(APP_ACTIVITY);
        options.setNoReset(true);
        options.setAutoGrantPermissions(true);

        AndroidDriver driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), options);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);
        return driver;
    }
}
