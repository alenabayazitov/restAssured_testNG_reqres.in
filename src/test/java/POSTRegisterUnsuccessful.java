import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import utils.ExcelUtils;

public class POSTRegisterUnsuccessful {


	@Test
	public void testPostRegister() {
		ExcelUtils excel = new ExcelUtils("./data/TestData.xlsx", "DataToRegister");
				
		JSONObject request = new JSONObject();
		request.put("email", excel.getCellData(2, 0));
		request.put("password", excel.getCellData(2, 1));
		
		System.out.println(request);
		
		baseURI = "https://reqres.in/api";
		
		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		  .body(request.toJSONString())
		.when()
		  .post("/register")
		.then()
		  .statusCode(400)
		  .log().all();
	}
}
