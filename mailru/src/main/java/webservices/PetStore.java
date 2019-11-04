package webservices;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PetStore {

  public static final int OK_STATUS_CODE = 200;
  MyPet myPet = new MyPet();
  long petId;


  @BeforeTest
  public void initTest() {
    RestAssured.baseURI = "https://petstore.swagger.io/v2";
  }

  @Test(priority = 1)
  public void postPet() {
    myPet.setName("Bob");
    myPet.setPhotoUrls(new String[] {"SuperPhoto"});

    Response post =
        RestAssured.given().when().body(myPet).contentType(ContentType.JSON).post("/pet");
    ResponseBody body = post.getBody();
    myPet = body.as(MyPet.class);
    petId = myPet.getId();

    /*
    String[] parts = bodyString.split(",", 2);
    String[] neededPart = parts[0].split(":", 2);
    petId = neededPart[1];*/

    Assert.assertEquals(post.getStatusCode(), OK_STATUS_CODE);

    Response get = RestAssured.given().when().get("/pet/" + petId);
  }

  @Test(priority = 2)
  public void putPet() {
    myPet.setName("Tom");
    myPet.setPhotoUrls(new String[] {"SuperPhoto"});

    Response put =
        RestAssured.given()
            .when()
            .body("{\"name\":\"super-kate2\",\"photoUrls\":[\"string\"]}")
            .contentType(ContentType.JSON)
            .put("/pet");
    ResponseBody body = put.getBody();
    body.asString();
    Assert.assertEquals(put.getStatusCode(), OK_STATUS_CODE);
    Assert.assertEquals(myPet.getName(), "Tom");
  }

   @Test(priority = 3)
  public void getPet() {
    Response get = RestAssured.given().when().get("/pet/" + petId);
    Assert.assertEquals(get.getStatusCode(), OK_STATUS_CODE);
  }

  @Test(priority = 4)
  public void deletePet() {
    Response delete = RestAssured.given().when().delete("/pet/" + petId);
    Assert.assertEquals(delete.getStatusCode(), OK_STATUS_CODE);
  }
}
