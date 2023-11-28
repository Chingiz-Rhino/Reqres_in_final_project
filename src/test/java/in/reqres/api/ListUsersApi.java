package in.reqres.api;

import in.reqres.models.lists.ListUsersResponseModel;
import in.reqres.specs.ListSpec;
import io.qameta.allure.Description;

import static io.restassured.RestAssured.given;

public class ListUsersApi {
    @Description("Отправка запроса на получение списка сотрудников")
    public ListUsersResponseModel successfulFetchListUsers() {
        return given()
                .spec(ListSpec.listRequestSpec)
                .when()
                .get("/users?page=2")
                .then()
                .spec(ListSpec.listResponseSpec)
                .extract()
                .as(ListUsersResponseModel.class);
    }
}
