import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples extends DataForTests {

	
	
	
	@Test(dataProvider = "DataForPost")
	public void testPost(String name, String job) {
		
		
		JSONObject request = new JSONObject();
		request.put("name", name);
		request.put("job", job);
		
		System.out.println(request);
		
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
	
	
	
	@Test(dataProvider = "DataForDelete")
	public void testDelete(int userId) {
				
		baseURI = "https://reqres.in/api";
		
		when()
		  .delete("/users/" + userId)
		.then()
		  .statusCode(204)
		  .log().all();
	}
	
	@Parameters({"userId"})
	@Test
	public void testDelete2(int userId) {
				
		baseURI = "https://reqres.in/api";
		System.out.println("Value for userId is: " + userId);
		when()
		  .delete("/users/" + userId)
		.then()
		  .statusCode(204)
		  .log().all();
	}
}
