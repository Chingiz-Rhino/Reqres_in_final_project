package in.reqres.tests;

import in.reqres.api.CreatePersonApi;
import in.reqres.models.person.CreatePersonBodyModel;
import in.reqres.models.person.CreatePersonResponseModel;
import io.qameta.allure.*;
import in.reqres.config.PersonConfig;
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
@Story("CRUD Операции с сотрудником")

public class PersonTest extends TestBase{
    PersonConfig personConfig = ConfigFactory.create(PersonConfig.class);
    String createName = personConfig.createName();
    String createJob = personConfig.createJob();
    String updateName = personConfig.updateName();
    String updateJob = personConfig.updateJob();
    String oneMoreUpdateName = personConfig.oneMoreUpdateName();
    String oneMoreUpdateJob = personConfig.oneMoreUpdateJob();

    protected CreatePersonApi createPersonApi = new CreatePersonApi();
//    protected DeletePersonApi deletePersonApi = new DeletePersonApi();
//    protected UpdatePersonApi updatePersonApi = new UpdatePersonApi();

    @Severity(NORMAL)
    @Test
    @Tag("Smoke")
    @Tag("CreatePerson")
    @DisplayName("Проверка успешного создания сотрудника с Name и Job")
    void successfulCreatePersonTest() {

        final CreatePersonResponseModel successfulCreatePersonResponse = step("Выполнение успешного создания сотрудника с Name и Job", () -> {
            CreatePersonBodyModel requestData = new CreatePersonBodyModel(createName, createJob);
            return createPersonApi.successCreatePerson(requestData);
        });

        step("Проверка ответа на запрос об успешном создании сотрудника с Name и Job", () -> {
            assertThat(successfulCreatePersonResponse.getName())
                    .as("Значение полученного Name из ответа верное")
                    .isEqualTo("morpheus");

            assertThat(successfulCreatePersonResponse.getJob())
                    .as("Значение полученной Job из ответа верное")
                    .isEqualTo("leader");

            assertThat(successfulCreatePersonResponse.getId())
                    .as("Значение полученного ID из ответа не пустое")
                    .isNotNull();

            assertThat(successfulCreatePersonResponse.getCreatedAt())
                    .as("Значение полученного CreatedAt из ответа не пустое")
                    .isNotNull();
        });
    }



}


