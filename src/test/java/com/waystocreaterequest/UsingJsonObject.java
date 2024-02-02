package com.waystocreaterequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingJsonObject
{

	//@Test(priority=1)
	public void creatPostHashMap()
	{
		JSONObject data=new JSONObject();
	
		
		data.put("name", "scott");
		data.put("location", "America");
		data.put("phone","+25657679");
	
		String courserArry[]= {"C++","R"};
		
		data.put("courses", courserArry);
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(data.toJSONString()).
		when()
			.post("http://localhost:3000/students").
			
		then()
			.statusCode(201)
//			.body("name", equalTo("scott"))
//			.body("location", equalTo("America"))
//			.body("phone",equalTo("+25657679"))
//			.body("courses[0]",equalTo("C++"))
//			.body("courses[1]",equalTo("R"))
//			.header("Content-Type","appictaion/json")
			.log().all();
			
		
	}

	@Test(priority=2)
	public void deletRecord()
	{
		given().
		
		when().
			delete("http://localhost:3000/students/0458").
		
		then().
			statusCode(204);
	}
}
