package com.httpmethods;

import org.eclipse.jetty.websocket.api.StatusCode;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;		

import static org.hamcrest.Matchers.equalTo;

import static  io.restassured.RestAssured.*;

public class HtttpMethods
{
	//@Test(priority=1)
	public void getUser()
	{
		baseURI = "https://reqres.in/api";
		Response respons=get("https://reqres.in/api/users?page=2");
		int status_code=respons.statusCode();
		
		given()
			.contentType(ContentType.JSON)
			.header("page",2).
		when()
			.get("/users?page=2").
		then()
			.statusCode(200)
			.body("page", equalTo(2)).
			log().all();
		
		
		Assert.assertEquals(status_code,200,"Status code is not coorect");		
	}
	//@Test(priority=2)
	public void createUser()
	{
		JSONObject request=new JSONObject();
		
		request.put("name", "Taanya");
		request.put("jon","QA");
		
		RestAssured.baseURI="https://reqres.in/api/";
	
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString()).

		when()
			.post("users").
			
		then()
			.statusCode(201).log().all();
	}
	
	//@Test(priority=3)
	public void updateUser()
	{
		JSONObject request=new JSONObject();
		
		request.put("name","Taanvi");
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString()).
		when()
			.put("users/2").
		then()
			.statusCode(200).log().all();		
		
	}
	
	@Test(priority=4)
	public void deleteUser()
	{
		baseURI="https://reqres.in/api/";
		
		when()
		.delete("users/2").
		then().
		statusCode(204).log().all();
	}
}
