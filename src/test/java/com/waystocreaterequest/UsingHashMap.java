package com.waystocreaterequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

/*
 * Different ways to create post request body 
 * 1.POST request creation using HashMap
 * 2.POST request creation using org.json
 * 3.POST request creation using POJO class
 * 4.POST request creation using external JSON file
 */


//1.POST request creation using HashMap
public class UsingHashMap 
{
	@Test(priority=1)
	public void creatPostHashMap()
	{
		HashMap data=new HashMap();
		
		data.put("name", "scott");
		data.put("location", "America");
		data.put("phone","+25657679");
	
		String courserArry[]= {"C++","R"};
		
		data.put("courses", courserArry);
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(data.toString()).
		when()
			.post("http://localhost:3000/students").
			
		then()
			.statusCode(201)
			.body("name", equalTo("scott"))
			.body("location", equalTo("America"))
			.body("phone",equalTo("+25657679"))
			.body("courses[0]",equalTo("C++"))
			.body("courses[1]",equalTo("R"))
			.header("Content-Type","appictaion/json")
			.log().all();
			
			
	}
	
	//@Test(priority=2)
	public void deletRecord()
	{
		given().
		
		when().
			delete("http://localhost:3000/students/4").
		
		then().
			statusCode(204);
	}
}
