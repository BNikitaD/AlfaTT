package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class LoginPage extends BasePage {

    private static final By USERNAME_FIELD_XPATH = By.xpath("//*[@resource-id='com.alfabank.qapp:id/etUsername']");

    private static final By ERROR_TEXT_XPATH = By.xpath("//*[@resource-id='com.alfabank.qapp:id/tvError']");
    private static final By PASSWORD_FIELD_CSS = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.alfabank.qapp:id/etPassword\")");
    private static final By CONFIRM_BUTTON_CSS = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.alfabank.qapp:id/btnConfirm\")");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        clearAndType(USERNAME_FIELD_XPATH, username);
    }

    public void enterPassword(String password) {
        clearAndType(PASSWORD_FIELD_CSS, password);
    }

    public void clickConfirmButton() {
        click(CONFIRM_BUTTON_CSS);
    }
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickConfirmButton();
    }

    public String getErrorText() {
        waitForNonEmptyText(ERROR_TEXT_XPATH);
        return getText(ERROR_TEXT_XPATH);
    }

    public boolean isErrorDisplayed() {
        return waitForNonEmptyText(ERROR_TEXT_XPATH);
    }
}
