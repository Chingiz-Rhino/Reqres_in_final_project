package in.reqres.tests;

import in.reqres.api.ListUsersApi;
import in.reqres.models.lists.ListUsersResponseModel;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.assertj.core.api.Assertions.assertThat;

public class ListUsersTest extends TestBase{

    protected ListUsersApi listUsersApi = new ListUsersApi();

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("ListPersons")
    @DisplayName("Проверка успешного получения списка сотрудников")
    void successfulFetchListUsersTest() {

        final ListUsersResponseModel successfulFetchListUsersResponse = step("Отправка запроса на получение списка Сотрудников", () -> listUsersApi.successfulFetchListUsers());

        step("Проверка ответа на запрос о получении списка сотрудников", () -> {
            assertThat(successfulFetchListUsersResponse.getPage())
                    .as("Значение полученного Page из ответа верное")
                    .isEqualTo(2);

            assertThat(successfulFetchListUsersResponse.getPerPage())
                    .as("Значение полученной PerPage из ответа верное")
                    .isEqualTo(6);

            assertThat(successfulFetchListUsersResponse.getTotal())
                    .as("Значение полученного Total из ответа верное")
                    .isEqualTo(12);

            assertThat(successfulFetchListUsersResponse.getTotalPages())
                    .as("Значение полученного TotalPages из ответа верное")
                    .isEqualTo(2);

            assertThat(successfulFetchListUsersResponse.getData().get(0).getId())
                    .as("Значение полученного Id из первого объекта в ответе верное")
                    .isEqualTo(7);

            assertThat(successfulFetchListUsersResponse.getData().get(0).getEmail())
                    .as("Значение полученного Email из первого объекта в ответе верное")
                    .isEqualTo("michael.lawson@reqres.in");

            assertThat(successfulFetchListUsersResponse.getData().get(0).getFirstName())
                    .as("Значение полученного FirstName из первого объекта в ответе верное")
                    .isEqualTo("Michael");

            assertThat(successfulFetchListUsersResponse.getData().get(0).getLastName())
                    .as("Значение полученного LastName из первого объекта в ответе верное")
                    .isEqualTo("Lawson");

            assertThat(successfulFetchListUsersResponse.getData().get(0).getAvatar())
                    .as("Значение полученного Avatar из первого объекта в ответе верное")
                    .isEqualTo("https://reqres.in/img/faces/7-image.jpg");

            assertThat(successfulFetchListUsersResponse.getData().get(1).getId())
                    .as("Значение полученного Id из второго объекта в ответе верное")
                    .isEqualTo(8);

            assertThat(successfulFetchListUsersResponse.getData().get(1).getEmail())
                    .as("Значение полученного Email из второго объекта в ответе верное")
                    .isEqualTo("lindsay.ferguson@reqres.in");

            assertThat(successfulFetchListUsersResponse.getData().get(1).getFirstName())
                    .as("Значение полученного FirstName из второго объекта в ответе верное")
                    .isEqualTo("Lindsay");

            assertThat(successfulFetchListUsersResponse.getData().get(1).getLastName())
                    .as("Значение полученного LastName из второго объекта в ответе верное")
                    .isEqualTo("Ferguson");

            assertThat(successfulFetchListUsersResponse.getData().get(1).getAvatar())
                    .as("Значение полученного Avatar из второго объекта в ответе верное")
                    .isEqualTo("https://reqres.in/img/faces/8-image.jpg");

            assertThat(successfulFetchListUsersResponse.getData().get(2).getId())
                    .as("Значение полученного Id из третьего объекта в ответе верное")
                    .isEqualTo(9);

            assertThat(successfulFetchListUsersResponse.getData().get(2).getEmail())
                    .as("Значение полученного Email из третьего объекта в ответе верное")
                    .isEqualTo("tobias.funke@reqres.in");

            assertThat(successfulFetchListUsersResponse.getData().get(2).getFirstName())
                    .as("Значение полученного FirstName из третьего объекта в ответе верное")
                    .isEqualTo("Tobias");

            assertThat(successfulFetchListUsersResponse.getData().get(2).getLastName())
                    .as("Значение полученного LastName из третьего объекта в ответе верное")
                    .isEqualTo("Funke");

            assertThat(successfulFetchListUsersResponse.getData().get(2).getAvatar())
                    .as("Значение полученного Avatar из третьего объекта в ответе верное")
                    .isEqualTo("https://reqres.in/img/faces/9-image.jpg");

            assertThat(successfulFetchListUsersResponse.getData().get(3).getId())
                    .as("Значение полученного Id из четвертого объекта в ответе верное")
                    .isEqualTo(10);

            assertThat(successfulFetchListUsersResponse.getData().get(3).getEmail())
                    .as("Значение полученного Email из четвертого объекта в ответе верное")
                    .isEqualTo("byron.fields@reqres.in");

            assertThat(successfulFetchListUsersResponse.getData().get(3).getFirstName())
                    .as("Значение полученного FirstName из четвертого объекта в ответе верное")
                    .isEqualTo("Byron");

            assertThat(successfulFetchListUsersResponse.getData().get(3).getLastName())
                    .as("Значение полученного LastName из четвертого объекта в ответе верное")
                    .isEqualTo("Fields");

            assertThat(successfulFetchListUsersResponse.getData().get(3).getAvatar())
                    .as("Значение полученного Avatar из четвертого объекта в ответе верное")
                    .isEqualTo("https://reqres.in/img/faces/10-image.jpg");

            assertThat(successfulFetchListUsersResponse.getData().get(4).getId())
                    .as("Значение полученного Id из пятого объекта в ответе верное")
                    .isEqualTo(11);

            assertThat(successfulFetchListUsersResponse.getData().get(4).getEmail())
                    .as("Значение полученного Email из пятого объекта в ответе верное")
                    .isEqualTo("george.edwards@reqres.in");

            assertThat(successfulFetchListUsersResponse.getData().get(4).getFirstName())
                    .as("Значение полученного FirstName из пятого объекта в ответе верное")
                    .isEqualTo("George");

            assertThat(successfulFetchListUsersResponse.getData().get(4).getLastName())
                    .as("Значение полученного LastName из пятого объекта в ответе верное")
                    .isEqualTo("Edwards");

            assertThat(successfulFetchListUsersResponse.getData().get(4).getAvatar())
                    .as("Значение полученного Avatar из пятого объекта в ответе верное")
                    .isEqualTo("https://reqres.in/img/faces/11-image.jpg");

            assertThat(successfulFetchListUsersResponse.getData().get(5).getId())
                    .as("Значение полученного Id из шестого объекта в ответе верное")
                    .isEqualTo(12);

            assertThat(successfulFetchListUsersResponse.getData().get(5).getEmail())
                    .as("Значение полученного Email из шестого объекта в ответе верное")
                    .isEqualTo("rachel.howell@reqres.in");

            assertThat(successfulFetchListUsersResponse.getData().get(5).getFirstName())
                    .as("Значение полученного FirstName из шестого объекта в ответе верное")
                    .isEqualTo("Rachel");

            assertThat(successfulFetchListUsersResponse.getData().get(5).getLastName())
                    .as("Значение полученного LastName из шестого объекта в ответе верное")
                    .isEqualTo("Howell");

            assertThat(successfulFetchListUsersResponse.getData().get(5).getAvatar())
                    .as("Значение полученного Avatar из шестого объекта в ответе верное")
                    .isEqualTo("https://reqres.in/img/faces/12-image.jpg");

            assertThat(successfulFetchListUsersResponse.getSupport().getUrl())
                    .as("Значение полученного Url в ответе верное")
                    .isEqualTo("https://reqres.in/#support-heading");

            assertThat(successfulFetchListUsersResponse.getSupport().getText())
                    .as("Значение полученного Text в ответе верное")
                    .isEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!");
        });
    }
}
