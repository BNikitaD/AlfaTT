package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.MainSteps;


public class LoginTests extends BaseTest {

    private static final String VALID_USERNAME = "Login";
    private static final String VALID_PASSWORD = "Password";
    private static final String WRONG_USERNAME = "wrongUser";
    private static final String WRONG_PASSWORD = "wrongPass";
    private static final String OVER_MAX_LENGTH  = "a".repeat(51);

    private static final String CONTAINS_ERROR_MSG   = "Введены неверные данные";
    private static final String CONTAINS_SUCCESS_MSG = "выполнен";

    // =========================================================================
    // Тест 1: Успешная авторизация
    // Локаторы: XPath (etUsername), UIAutomator (etPassword, btnConfirm)
    // =========================================================================

    @Test(description = "Успешный вход с корректными логином и паролем")
    public void testSuccessfulLogin() {
        System.out.println("\n=== testSuccessfulLogin: успешная авторизация ===");
        LoginSteps loginSteps = new LoginSteps(driver);
        MainSteps  mainSteps  = new MainSteps(driver);
        loginSteps.stepEnterUsername(VALID_USERNAME);
        loginSteps.stepEnterPassword(VALID_PASSWORD);
        loginSteps.stepClickConfirmButton();
        Assert.assertTrue(mainSteps.stepIsSuccessMessageContains(CONTAINS_SUCCESS_MSG),
                "Текст главного экрана должен содержать: " + CONTAINS_SUCCESS_MSG);
    }

    // =========================================================================
    // Тест 2: Попытка входа с пустым полем логина
    // Локаторы: UIAutomator (etPassword, btnConfirm), XPath (tvError)
    // =========================================================================

    @Test(description = "Вход с пустым полем логина — должна появиться ошибка")
    public void testLoginWithEmptyUsername() {
        System.out.println("\n=== testLoginWithEmptyUsername: пустой логин ===");
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.stepEnterPassword(VALID_PASSWORD);
        loginSteps.stepClickConfirmButton();
        Assert.assertTrue(loginSteps.stepIsErrorDisplayed(),
                "Должно отображаться сообщение об ошибке при пустом поле логина");
    }

    // =========================================================================
    // Тест 3: Попытка входа с пустым полем пароля
    // Локаторы: XPath (etUsername, tvError), UIAutomator (btnConfirm)
    // =========================================================================

    @Test(description = "Вход с пустым полем пароля — должна появиться ошибка")
    public void testLoginWithEmptyPassword() {
        System.out.println("\n=== testLoginWithEmptyPassword: пустой пароль ===");
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.stepEnterUsername(VALID_USERNAME);
        loginSteps.stepClickConfirmButton();
        Assert.assertTrue(loginSteps.stepIsErrorDisplayed(),
                "Должно отображаться сообщение об ошибке при пустом поле пароля");
    }

    // =========================================================================
    // Тест 4: Попытка входа с неверными данными
    // Локаторы: XPath (etUsername), UIAutomator (etPassword, btnConfirm)
    // =========================================================================

    @Test(description = "Вход с неверными данными — должна появиться ошибка")
    public void testLoginWithWrongCredentials() {
        System.out.println("\n=== testLoginWithWrongCredentials: неверные данные ===");
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.stepLogin(WRONG_USERNAME, WRONG_PASSWORD);

        // TODO: баг приложения — tvError появляется, но текст пустой при неверных данных
        Assert.assertTrue(loginSteps.stepIsErrorDisplayed(),
                "Должно отображаться сообщение об ошибке при неверных данных");
    }

    // =========================================================================
    // Тест 5: Логин длиннее допустимого максимума (50 символов)
    // Локаторы: XPath (etUsername, tvTitle, tvError), UIAutomator (etPassword, btnConfirm)
    // =========================================================================

    @Test(description = "Вход с логином > 50 символов — должна появиться ошибка валидации")
    public void testLoginWithUsernameExceedingMaxLength() {
        System.out.println("\n=== testLoginWithUsernameExceedingMaxLength: логин > 50 символов ===");
        LoginSteps loginSteps = new LoginSteps(driver);

        loginSteps.stepEnterUsername(OVER_MAX_LENGTH);
        loginSteps.stepEnterPassword(VALID_PASSWORD);
        loginSteps.stepClickConfirmButton();

        Assert.assertTrue(loginSteps.stepIsErrorDisplayed(),
                "Ошибка должна отображаться при логине длиннее 50 символов");
    }
}
