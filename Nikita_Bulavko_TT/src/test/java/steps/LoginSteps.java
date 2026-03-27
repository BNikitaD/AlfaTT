package steps;

import io.appium.java_client.android.AndroidDriver;
import pages.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps(AndroidDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    public void stepEnterUsername(String username) {
        System.out.println("Вводим логин: " + username);
        loginPage.enterUsername(username);
    }

    public void stepEnterPassword(String password) {
        System.out.println("Вводим пароль: " + password);
        loginPage.enterPassword(password);
    }

    public void stepClickConfirmButton() {
        System.out.println("Нажимаем кнопку входа");
        loginPage.clickConfirmButton();
    }

    public void stepLogin(String username, String password) {
        System.out.println("Вводим логин: " + username);
        System.out.println("Вводим пароль: " + password);
        System.out.println("Нажимаем кнопку входа");
        loginPage.login(username, password);
    }

    public boolean stepIsErrorDisplayed() {
        System.out.println("Ждём сообщение об ошибке");
        return loginPage.isErrorDisplayed();
    }

    public boolean stepIsErrorContains(String text) {
        return loginPage.getErrorText().trim().contains(text);
    }


}
