package prime_service;

import java.io.FileNotFoundException;

import org.mmt.utils.GeneralUtils;
import org.mmt.utils.RestAssuredUtils;
import org.testng.annotations.Test;

import groovy.json.JsonBuilder;
import io.restassured.response.Response;

public class PreCancelValidationTests {
	GeneralUtils gutil;
	PrimeServiceUtil psu;
	PreCancelValidationTests(){
		gutil = new GeneralUtils();
		psu = new PrimeServiceUtil();
	}



	@Test
	void oneFltOneHtlCancellation() throws FileNotFoundException {
		String uri = gutil.getProperty("preCancelValidation");
		Object obj = psu.buildPreCancelValidationJson();
		Response response = RestAssuredUtils.postRequest(uri,obj,"application/json");
		System.out.println(response.getStatusCode());
	}



}
