package in.reqres.api;

import in.reqres.models.authorization.AuthorizationBodyModel;
import in.reqres.models.authorization.AuthorizationErrorModel;
import in.reqres.models.authorization.AuthorizationResponseModel;
import in.reqres.specs.AuthorizationSpec;
import jdk.jfr.Description;

import static io.restassured.RestAssured.given;

public class AuthorizationApi {
    @Description("Отправка запроса на авторизацию")
    public AuthorizationResponseModel successAuth (AuthorizationBodyModel requestData){
        return given()
                .spec(AuthorizationSpec.authorizationRequestSpec)
                .body(requestData)
                .when()
                .post("/login")
                .then()
                .spec(AuthorizationSpec.authorizationResponseSpec)
                .extract()
                .as(AuthorizationResponseModel.class);
    }

    @Description("Отправка негативного завпроса на авторизацию")
    public AuthorizationErrorModel errorAuth(AuthorizationResponseModel requestData){
        return given()
                .spec(AuthorizationSpec.authorizationRequestSpec)
                .body(requestData)
                .when()
                .post("/login")
                .then()
                .spec(AuthorizationSpec.errorAuthorizationResponseSpec)
                .extract()
                .as(AuthorizationErrorModel.class);
    }
}
