package org.mmt.utils;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class RestAssuredUtils {

	public static Response postRequest(String uri,Object obj,String contentType) {
		Response response=null;
		try {
			response = given().body(obj).post(uri);
		}catch(RuntimeException r) {
			r.getStackTrace();
		}
		return response;
	}

	public static  Response getRequestWithParameters(String uri,String contentType,String parm,String paramVlue) {
		Response response=null;
		try {
			response = given().param(parm, paramVlue).get(uri);
		}
			catch(Exception e) {
				e.getStackTrace();
			}
		return response;
	}

}
