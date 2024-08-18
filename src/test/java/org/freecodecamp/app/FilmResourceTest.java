package org.freecodecamp.app;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;



import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
public class FilmResourceTest {
	
	@Test
	public void test() {
		RestAssured.given()
			.when().get("/film/5")
			.then()
			.statusCode(200)
			.body(Matchers.containsString("AFRICAN EGG"));

	}

}
