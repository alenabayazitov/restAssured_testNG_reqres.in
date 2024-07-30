import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class Test02_GET {

	@Test
	void test_02() {
		
		given()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		   .statusCode(200)
		   .body("data[1].id", equalTo(8))
		   .log().all();
		
	}
}
