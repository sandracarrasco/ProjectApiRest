package reqres.actions;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserRequest {

    public static Response getUsers(RequestSpecification requestSpecification, String page) {
        requestSpecification.param("page", page);
        return requestSpecification.get("/api/users");
    }

    public static Response getUser(RequestSpecification requestSpecification, String id) {
        return requestSpecification.get("/api/users/"+id);
    }

    public static Response getUserDelayed(RequestSpecification requestSpecification, String delay){
        requestSpecification.param("delay", delay);
        return requestSpecification.get("/api/users");
    }
    public static Response createUser(RequestSpecification requestSpecification, String payload){
        return requestSpecification.body(payload).post("/api/users");
    }
}
