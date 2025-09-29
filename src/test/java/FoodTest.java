


import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FoodTest {

    @Test
    void getFoodTest() {
        RequestSpecification response = given();
        given()
                .baseUri("http://localhost").port(8080)
                .when().get(baseURI + "/api/food")
                .then().statusCode(200)
                .extract().response().body().asString();
        System.out.println(response);
        Assertions.assertNotNull(response);


    }

    @Test
    void getNewFoodTest() {
        given()
                .baseUri("http://localhost").port(8080)
                .when().get(baseURI + "/api/food")
                .then().assertThat().body("name",hasItem("Ананас"));





    }
}
