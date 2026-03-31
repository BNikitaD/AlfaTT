package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private static final By SUCCESS_TEXT_XPATH = By.xpath("//android.widget.TextView[contains(@text, 'выполнен')]");

    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isSuccessMessageDisplayed() {
        return isDisplayed(SUCCESS_TEXT_XPATH);
    }

    public String getSuccessMessageText() {
        return getText(SUCCESS_TEXT_XPATH);
    }

    public boolean isSuccessMessageContains(String text) {
        return getSuccessMessageText().contains(text);
    }

}
