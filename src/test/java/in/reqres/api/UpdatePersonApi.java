package in.reqres.api;

import in.reqres.models.person.UpdatePersonBodyModel;
import in.reqres.models.person.UpdatePersonResponseModel;
import in.reqres.specs.UpdatePersonSpec;
import io.qameta.allure.Description;

import static io.restassured.RestAssured.given;

public class UpdatePersonApi {
    @Description("Отправка запроса на обновление сотрудника через метод PUT")
    public UpdatePersonResponseModel successUpdatePersonPut(UpdatePersonBodyModel requestData) {
        return given()
                .spec(UpdatePersonSpec.updatePersonRequestSpec)
                .body(requestData)
                .when()
                .put("/users/2")
                .then()
                .spec(UpdatePersonSpec.updatePersonResponseSpec)
                .extract()
                .as(UpdatePersonResponseModel.class);
    }

    @Description("Отправка запроса на обновление сотрудника через метод PATCH")
    public UpdatePersonResponseModel successUpdatePersonPatch(UpdatePersonBodyModel requestData) {
        return given()
                .spec(UpdatePersonSpec.updatePersonRequestSpec)
                .body(requestData)
                .when()
                .patch("/users/2")
                .then()
                .spec(UpdatePersonSpec.updatePersonResponseSpec)
                .extract()
                .as(UpdatePersonResponseModel.class);
    }
}
