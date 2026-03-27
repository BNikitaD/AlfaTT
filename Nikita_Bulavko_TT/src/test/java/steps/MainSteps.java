package steps;

import io.appium.java_client.android.AndroidDriver;
import pages.MainPage;

/**
 * Слой шагов для главного экрана (после успешного входа).
 */
public class MainSteps {

    private final MainPage mainPage;

    public MainSteps(AndroidDriver driver) {
        this.mainPage = new MainPage(driver);
    }

    public boolean stepIsSuccessMessageDisplayed() {
        System.out.println("Ждём сообщение об успешном входе");
        return mainPage.isSuccessMessageDisplayed();
    }

    public boolean stepIsSuccessMessageContains(String text) {
        System.out.println("Проверяем текст успешного входа: содержит «" + text + "»");
        return mainPage.isSuccessMessageContains(text);
    }
}
