package reqres.actions;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import reqres.general.ReqresApiBase;

public class UserTest extends ReqresApiBase {

     /**
     * 1. Consultar los usuarios de la página 2
     */
    @Test
    public void usersPage() {
        Response response = UserRequest.getUsers(requestSpecification,"2");
        UserQuestions.validateStatusCode(response, 200);
        UserQuestions.validateJsonSchema(response, "reqres/UsersJsonSchema.json");
    }

     /**
     * 2. Consultar los datos del usuario 12
     */
    @Test
    public void userEspecifique() {
        Response response = UserRequest.getUser(requestSpecification,"12");
        UserQuestions.validateStatusCode(response, 200);
        UserQuestions.validateJsonSchema(response, "reqres/UserJsonSchema.json");
    }

     /**
     * 3. Consultar los datos de un usuario inexistente
     */
    @Test
    public void userInexistente() {
        Response response = UserRequest.getUser(requestSpecification,"23");
        UserQuestions.validateStatusCode(response, 404);
        UserQuestions.validateJsonSchema(response, "reqres/UserNotFound.json");
    }

     /**
     * 4. Crear un usuario
     */
    @Test
    public void createUser() {
        String payload = UserModel.userPayload("morpheus", "leader");
        Response response = UserRequest.createUser(requestSpecification, payload);
        UserQuestions.validateStatusCode(response, 201);
        UserQuestions.validateJsonSchema(response, "reqres/UserCreatedJsonSchema.json");
    }

     /**
     * 5. Consumir el servicio "Delayed Response"
     */
    @Test
    public void consumeService() {
        Response response = UserRequest.getUserDelayed(requestSpecification,"3");
        UserQuestions.validateStatusCode(response, 200);
        UserQuestions.validateJsonSchema(response, "reqres/UserDelayedJsonSchema.json");
    }


}
