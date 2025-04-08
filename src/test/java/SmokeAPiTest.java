import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SmokeAPiTest {
    private static  final  String BASE_URL ="https://petstore.swagger.io/v2/";
    @Test
    void  createUserTest() {
        String jsonBody = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"Hehe\",\n" +
                "  \"firstName\": \"Chelsa\",\n" +
                "  \"lastName\": \"string\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"phone\": \"string\",\n" +
                "  \"userStatus\": 0\n" +
                "}";




        Response response= (Response) given().
                    header("application/json","accept:")
                    .baseUri(BASE_URL)
                .when()
                    .body(jsonBody)
                    .post("user")
                .andReturn();
        int actualCode=response.getStatusCode();

        Assertions.assertEquals(201, actualCode);

    }
}
