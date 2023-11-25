package in.reqres.tests;

import in.reqres.api.AuthorizationApi;
import in.reqres.config.AuthorizationConfig;
import in.reqres.models.authorization.AuthorizationBodyModel;
import in.reqres.models.authorization.AuthorizationResponseModel;
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
@Story("Авторизация")
public class AuthorizationTest extends TestBase{

    AuthorizationConfig authConfig = ConfigFactory.create(AuthorizationConfig.class);
    String authEmail = authConfig.authEmail();
    String authPassword = authConfig.authPassword();
    String authUndefinedEmail = authConfig.authUndefinedEmail();
    String authUndefinedPassword = authConfig.authUndefinedPassword();

    protected AuthorizationApi authorizationApi = new AuthorizationApi();

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("Authorization")
    @DisplayName("Проверка успешной авторизации с Email и Password")
    void successfulAuthorizationTest() {

        final AuthorizationResponseModel successfulAuthResponse = step("Выполнение успешной авторизации с Email и Password", () -> {
            AuthorizationBodyModel requestData = new AuthorizationBodyModel(authEmail, authPassword);
            return authorizationApi.successAuth(requestData);
        });

        step("Проверка ответа с токеном на запрос об успешной Авторизации", () -> {
            assertThat(successfulAuthResponse.getToken())
                    .as("Значение полученного токена из ответа верное")
                    .isEqualTo("QpwL5tke4Pnpja7X4");
        });
    }

}
