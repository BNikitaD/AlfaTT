package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


// * 1. XPath-локаторы — стандартные XPath-выражения, обращающиеся к
// *    Android UI-элементам по resource-id, классу или тексту.
// *
// * 2. UIAutomator-локаторы (CSS-эквивалент для Android) — API UIAutomator2
// *    через AppiumBy.androidUIAutomator. В нативных Android-приложениях CSS
// *    не применяется (это web-концепция); UIAutomator's UiSelector выполняет
// *    аналогичную роль: выборка по resource-id, тексту, className — как в CSS.
// *    Дополнительно поддерживаются регулярные выражения через textMatches().
// *
// * UI-элементы (из fragment_login.xml):
// *   etUsername   — поле ввода логина
// *   etPassword   — поле ввода пароля
// *   btnConfirm   — кнопка «Вход»
// *   tvError      — текст ошибки («Введены неверные данные»)
// *   tvTitle      — заголовок экрана («Вход в Alfa-Test»)
// */
public class LoginPage extends BasePage {

    private static final By USERNAME_FIELD_XPATH = By.xpath("//*[@resource-id='com.alfabank.qapp:id/etUsername']");

    private static final By ERROR_TEXT_XPATH = By.xpath("//*[@resource-id='com.alfabank.qapp:id/tvError']");

    // UIAutomator-локаторы (CSS-эквивалент для Android)

    /** Поле пароля — UIAutomator selector по resource-id (аналог CSS #id) */
    private static final By PASSWORD_FIELD_CSS = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.alfabank.qapp:id/etPassword\")");

    /** Кнопка подтверждения — UIAutomator selector по resource-id */
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

    /** true — если поле ошибки содержит непустой текст. */
    public boolean isErrorDisplayed() {
        return waitForNonEmptyText(ERROR_TEXT_XPATH);
    }

    /** true — если текст ошибки содержит ожидаемую подстроку. */
    public boolean isErrorTextContains(String text) {
        return getErrorText().trim().contains(text);
    }

}
