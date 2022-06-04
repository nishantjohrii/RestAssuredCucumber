package restAPI;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefs {
	
	Response response;
	RequestSpecification request;
	
	@Given("The base URI is {string}")
	public void the_base_URI_is(String URI) {
		
		request = RestAssured.given().baseUri(URI);
	   
	}

	@When("perform the GET operation")
	public void perform_the_GET_operation() {
		
		response = request.get();
	  
	}

	@Then("Response code should be {int}")
	public void response_code_should_be(int ResponseCode) {
		
		Assert.assertEquals(response.statusCode(), 200);
	    
	}


}
