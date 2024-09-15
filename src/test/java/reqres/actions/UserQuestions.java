package reqres.actions;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserQuestions {

    public static void validateStatusCode(Response response, Integer statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    public static void validateJsonSchema(Response response,String schema){
        JsonSchemaValidator jsv =
                JsonSchemaValidator.matchesJsonSchemaInClasspath(schema);

        assertTrue(
                "Validacion del Json Schema para Reqres Questions",
                jsv.matches(response.asString())
        );
    }
}
