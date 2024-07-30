import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GETandPOSTexamples {

	@Test
	public void testGet() {

		baseURI = "https://reqres.in/api";

		given()
		  .get("/users?page=2")
		.then()
		  .statusCode(200)
		  .body("data[0].first_name", equalTo("Michael"))
		  .body("data.first_name", hasItems("George", "Rachel"));

	}
	
	@Test
	public void testPost() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "Alena");
		map.put("job", "leader");
		
		JSONObject request = new JSONObject(map);
		
		System.out.println(request.toJSONString());
		
		JSONObject request1 = new JSONObject();
		request1.put("name", "Peter");
		request1.put("job", "Teacher");
		
		System.out.println(request1);
		
		baseURI = "https://reqres.in/api";
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		  .body(request.toJSONString())
		.when()
		  .post("/users")
		.then()
		  .statusCode(201)
		  .log().all();
	}
	
}
