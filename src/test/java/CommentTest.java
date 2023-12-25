import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import org.example.CommentMethods;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class CommentTest {

    @Test
    @DisplayName("Успешное создание комментария")
    @Description("Запрос возвращает статус код - 201")
    public void createNewCommentAndCheckResponse() {
        RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
        CommentMethods commentMethods= new CommentMethods("Привет!\n Алина была здесь.");
        given()
                .auth().preemptive()
                .basic("U_M0VWA", "пароль")
                .header("Content-type", "application/json")
                .and()
                .body(commentMethods)
                .when()
                .baseUri("https://jira.moscow.alfaintra.net/")
                .post("/rest/api/2/issue/SFAIMP-1219/comment")
                .then()
                .statusCode(201);
    }
}