package com.waystocreaterequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class UsingPOJODemo
{
	@Test
	public void creatJSONfromPOJO() throws JsonProcessingException
	{
		UsingPOJO up=new UsingPOJO();
		
		up.setName("Taanya");
		up.setLoaction("Jermany");
		up.setPhoneNum(089877989876.0);
		String[] courseArrya= {"C++","PHP"};
		up.setCourses(courseArrya);
		
		//convert class object to pojo object
		ObjectMapper objectMapper=new ObjectMapper();
		
		String omJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(up);
		System.out.println(omJson);
		
		//create requestSpecification
		RequestSpecification reqSpec=RestAssured.given();
		
		reqSpec.contentType(ContentType.JSON);
		reqSpec.accept(ContentType.JSON);
		
		reqSpec.baseUri("http://localhost:3000/students");
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(),201 ,"Check for the Status");
		
		System.out.println("*****************************************************************************************************");
	
//		//convert pojo to json
//		UsingPOJO up2=objectMapper.readValue(omJson, UsingPOJO.class);
//		
//		System.out.println("name :"+up2.getName());
//		System.out.println("Location :"+up2.getLoction());
//		System.out.println("phoneNumber:"+up2.getPhoneNumber());
//		System.out.println("course[0] : "+up2.getCourses());
		
		ResponseBody responseBody=response.getBody();
		
		JsonPath jsonPathView =responseBody.jsonPath();
		
		
		
	}
}
