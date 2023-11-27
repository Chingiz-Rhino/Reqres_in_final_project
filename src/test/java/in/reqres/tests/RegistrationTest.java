package in.reqres.tests;

import in.reqres.api.RegistrationApi;
import in.reqres.config.RegistrationConfig;
import in.reqres.models.registration.RegistrationBodyModel;
import in.reqres.models.registration.RegistrationErrorModel;
import in.reqres.models.registration.RegistrationResponseModel;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.assertj.core.api.Assertions.assertThat;


@Owner("Аскаров Ченгиз")
@Epic(value = "Тестирование API приложения Reqres.in")
@Feature(value = "Базовая функциональность приложения Reqres.in")
@Story("Регистрация")
public class RegistrationTest extends TestBase{

    RegistrationConfig registrationConfig = ConfigFactory.create(RegistrationConfig.class);
    String regEmail = registrationConfig.regEmail();
    String regPassword = registrationConfig.regPassword();
    String regUndefinedEmail = registrationConfig.regUndefinedEmail();
    String regUndefinedPassword = registrationConfig.regUndefinedPassword();

    protected RegistrationApi registrationApi = new RegistrationApi();

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Registration")
    @DisplayName("Проверка успешной регистрации с Email и Password")
    void successfulRegistrationTest() {

        final RegistrationResponseModel successfulRegistrationResponse = step("Выполнение успешной регистрации с Email и Password", () -> {
            RegistrationBodyModel requestData = new RegistrationBodyModel(regEmail, regPassword);
            return registrationApi.successRegistration(requestData);
        });

        step("Проверка ответа с токеном на запрос об успешной Регистрации", () -> {
            assertThat(successfulRegistrationResponse.getId())
                    .as("Значение полученного ID из ответа верное")
                    .isEqualTo(4);

            assertThat(successfulRegistrationResponse.getToken())
                    .as("Значение полученного токена из ответа верное")
                    .isEqualTo("QpwL5tke4Pnpja7X4");
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Registration")
    @DisplayName("Проверка неуспешной регистрации без Email")
    void registrationWithOutEmailTest() {

        final RegistrationErrorModel errorRegWithoutEmailResponse = step("Выполнение неуспешной регистрации без Email", () -> {
            RegistrationBodyModel requestData = new RegistrationBodyModel(null, regPassword);
            return registrationApi.errorRegistration(requestData);
        });

        step("Проверка ответа с ошибкой Регистрации", () -> {
            assertThat(errorRegWithoutEmailResponse.getError())
                    .as("Верный текст с ошибкой в ответе")
                    .isEqualTo("Missing email or username");
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Registration")
    @DisplayName("Проверка неуспешной регистрации без Password")
    void registrationWithOutPasswordTest() {

        final RegistrationErrorModel errorRegWithoutPasswordResponse = step("Выполнение неуспешной регистрации без Password", () -> {
            RegistrationBodyModel requestData = new RegistrationBodyModel(regEmail, null);
            return registrationApi.errorRegistration(requestData);
        });

        step("Проверка ответа с ошибкой Регистрации", () -> {
            assertThat(errorRegWithoutPasswordResponse.getError())
                    .as("Верный текст с ошибкой в ответе")
                    .isEqualTo("Missing password");
        });
    }

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Registration")
    @DisplayName("Проверка неуспешной регистрации с данными неизвестного пользователя")
    void undefinedUserRegistrationTest() {

        final RegistrationErrorModel errorRegWithUndefinedData = step("Выполнение неуспешной регистрации с данными неизвестного пользователя", () -> {
            RegistrationBodyModel requestData = new RegistrationBodyModel(regUndefinedEmail, regUndefinedPassword);
            return registrationApi.errorRegistration(requestData);
        });

        step("Проверка ответа с ошибкой Регистрации", () -> {
            assertThat(errorRegWithUndefinedData.getError())
                    .as("Верный текст с ошибкой в ответе")
                    .isEqualTo("Note: Only defined users succeed registration");
        });
    }
}
