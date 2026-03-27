package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Page Object для главного экрана после успешной авторизации.
 *
 * Примечание: единственный TextView на fragment_main.xml не имеет
 * resource-id в layout — поэтому используем XPath по тексту.
 */
public class MainPage extends BasePage {

    /** XPath-локатор: ищет TextView, чей текст содержит «выполнен» */
    private static final By SUCCESS_TEXT_XPATH = By.xpath("//android.widget.TextView[contains(@text, 'выполнен')]");

    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    /** true — если сообщение об успешном входе отображается. */
    public boolean isSuccessMessageDisplayed() {
        return isDisplayed(SUCCESS_TEXT_XPATH);
    }

    public String getSuccessMessageText() {
        return getText(SUCCESS_TEXT_XPATH);
    }

    /** true — если текст успешного входа содержит ожидаемую подстроку. */
    public boolean isSuccessMessageContains(String text) {
        return getSuccessMessageText().contains(text);
    }

}
