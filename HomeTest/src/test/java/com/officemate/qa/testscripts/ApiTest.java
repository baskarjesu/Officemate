package com.officemate.qa.testscripts;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.officemate.qa.util.ReadTestData;

import io.restassured.response.Response;

public class ApiTest {

	@DataProvider
	public Object[][] getResponseCode() {
		Object data[][]=ReadTestData.getTestData("ResponseCode");
		return data;
	}	

	@Test(dataProvider="getResponseCode")
	static void testResponseCode(String searchQuery, String responseCode) {

		String url = "https://www.officemate.co.th/api/search/suggest?searchQuery="+searchQuery+"&categoryId=all_categories";
		Response res = given().header("Accept-Encoding", "gzip,deflate,br").header("Connection", "keep-alive")
				.header("content-type", "application/json;charset=utf-8").header("x-store-code", "en").get(url);
		int resCode = res.getStatusCode();
		System.out.println("resCode:"+resCode+"*");
		System.out.println("responseCode:"+responseCode+"*");
		int i=Integer.parseInt(responseCode);
		assertEquals(resCode, i);
	}

	@DataProvider
	public Object[][] getSearchQueryAPIProductAvailablity() {
		Object data[][]=ReadTestData.getTestData("SearchQueryAPIProductAvailabity");
		return data;
	}

	@Test(dataProvider="getSearchQueryAPIProductAvailablity")
	static void testProductAvailablity(String searchItem, String itemCount) {

		String url = "https://www.officemate.co.th/api/search/suggest?searchQuery="+searchItem+"&categoryId=all_categories";

		Response res = given().header("Accept-Encoding", "gzip,deflate,br").header("Connection", "keep-alive")
				.header("content-type", "application/json;charset=utf-8").header("x-store-code", "en").get(url);
		int j=Integer.parseInt(itemCount);
		res.then().body("suggestions.categories.count[0]", equalTo(j));

	}
}