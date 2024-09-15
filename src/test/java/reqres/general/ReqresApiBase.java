package reqres.general;

import org.junit.jupiter.api.BeforeEach;
import util.IConfigBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ReqresApiBase implements IConfigBase {

    protected RequestSpecification requestSpecification;

    @BeforeEach
    public void configure() {
        RestAssured.baseURI = "https://reqres.in";
        requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
    }



}
