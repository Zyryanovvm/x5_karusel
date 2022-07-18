package karusel.api.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import karusel.api.models.lombok.FirstKeyLombok;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static karusel.api.helpers.ReqresUri.*;
import static karusel.api.helpers.Spec.requestSpec;
import static karusel.api.helpers.Spec.responseSpec;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@Story("Тестирование API (пример)")
@Owner("allure8")
@Feature("Тестирование web, mobile, api приложений Карусель")
@Tag("api")
@Tag("allTests")
public class ReqresTests extends TestBase {

    public String expectedText = "To keep ReqRes free, contributions towards server costs are appreciated!";
    String supportMessage = "To keep ReqRes free, contributions towards server costs are appreciated!";

    String bodyCreateUser = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

    String bodyRegisterUser = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }";

    String bodyBadRegisterUser = "{ \"email\": \"sydney@fife\" }";

    @Test
    @AllureId("11312")
    @DisplayName("HTTP-запрос GET на получение пользователя с id = 5")
    void getUser() {
        step("Отправить HTTP-запрос");
        FirstKeyLombok responseBody = given()
                .spec(requestSpec)
                .when()
                .get("/api/users/5")
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(FirstKeyLombok.class);

        step("Проверить что id возвращаемого тела равно 5", () -> {
            assertEquals(5, responseBody.getDataLombok().getIdLombok());
            assertEquals(expectedText, responseBody.getSupportLombok().getTextLombok());
        });

    }


    static Stream<Arguments> searchUsers() {
        return Stream.of(
                Arguments.of("2", "Janet", "Weaver"),
                Arguments.of("5", "Charles", "Morris"),
                Arguments.of("10", "Byron", "Fields"));
    }

    @MethodSource("searchUsers")
    @ParameterizedTest()
    @AllureId("11313")
    @DisplayName("HTTP-запрос GET на получения пользователей с id = [2, 5, 10]")
    void getSingleUsers(Integer users, String firstName, String lastName) {
        step("Отправить HTTP-запрос");
        FirstKeyLombok responseBody = given()
                .spec(requestSpec)
                .when()
                .get(singleUsersUri + users)
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(FirstKeyLombok.class);
        step("Проверить наличие id", () ->
                assertEquals(users, responseBody.getDataLombok().getIdLombok()));
        step("Проверить Имя", () ->
                assertEquals(firstName, responseBody.getDataLombok().getFirstNameLombok()));
        step("Проверить Фамилии", () ->
                assertEquals(lastName, responseBody.getDataLombok().getLastNameLombok()));
        step("Проверка message", () ->
                assertEquals(supportMessage, responseBody.getSupportLombok().getTextLombok()));
        step("Проверка присутствия Avatar", () ->
                assertNotEquals(null, responseBody.getDataLombok().getAvatarLombok()));
    }

    @Test
    @AllureId("11314")
    @DisplayName("HTTP-запрос POST на создание нового пользователя")
    void createUser() {
        step("Отправить HTTP-запрос и проверить что id в responseBody не равен нулю");
        given()
                .body(bodyCreateUser)
                .contentType(JSON)
                .when()
                .post(createUsersUri)
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }

    @Test
    @AllureId("11315")
    @DisplayName("HTTP-запрос GET на получение пользователя с конкретными условиями")
    void getUserForId() {
        step("Отправить HTTP-запрос. И проверить что возвращается список с id от 1 до 6 и " +
                "что в списке есть пользователь, почта которого заканчивается на ...@reqres.in", () ->
                given()
                        .spec(requestSpec)
                        .when()
                        .get(createUsersUri)
                        .then()
                        .spec(responseSpec)
                        .log().body()
                        .body("data.findAll{it.id =~/1/}.id.flatten()",
                                hasItem(1))
                        .body("data.findAll{it.id =~/6/}.id.flatten()",
                                hasItem(6))
                        .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                                hasItem("tracey.ramos@reqres.in")));
    }

    @ValueSource(ints = {
            7,
            11,
            13
    })
    @ParameterizedTest()
    @AllureId("11316")
    @DisplayName("HTTP-запрос DELETE на удаление пользователей с id =[7, 11, 13]")
    void deleteUser(Integer user) {
        step("Отправить HTTP-запрос на удаление пользователя и " +
                "проверить что возвращаемый статус код равен 204", () ->
                delete(singleUsersUri + user)
                        .then()
                        .statusCode(204));
    }

    @Test
    @AllureId("11317")
    @DisplayName("HTTP-запрос POST на регистрацию нового пользователя. Позитивный")
    void registerNewUsers() {
        step("Отправить HTTP-запрос и проверить что возвращаемый статус-код 200 и " +
                "что у пользователя с заданным id появился token авторизации", () ->
                given()
                        .body(bodyRegisterUser)
                        .contentType(JSON)
                        .when()
                        .post(registerUsersUri)
                        .then()
                        .log().body()
                        .statusCode(200)
                        .body("id", is(4))
                        .body("token", is("QpwL5tke4Pnpja7X4")));
    }


    @Test
    @AllureId("11318")
    @DisplayName("HTTP-запрос POST на регистрацию нового пользователя. Негативный")
    void badRegisterNewUsers() {
        step("Отправить HTTP-запрос с некорректным requestBody и " +
                "проверить что возвращается статус код 400 с оишбкой", () ->
                given()
                        .body(bodyBadRegisterUser)
                        .contentType(JSON)
                        .when()
                        .post(registerUsersUri)
                        .then()
                        .log().body()
                        .statusCode(400)
                        .body("error", is("Missing password")));
    }

}
