package org.mmt.tests;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mmt.utils.GeneralUtils;
import org.mmt.utils.RestAssuredUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VoucherTests {
	RestAssuredUtils ru;
	GeneralUtils gutil; 

	public VoucherTests() {
		gutil = new GeneralUtils();
	}

	@DataProvider
	public Object[][] getVoucherData(){
		return new Object[][] {
			{"userUUID","UF5HN6KJOGH"}
		};
	}


	@Test(dataProvider="getVoucherData")
	public void getBasicUserInfoTest(String uuid,String uuidValue) throws IOException, SQLException {
		String baseUrl = gutil.getProperty("getBasicUserInfo");
		System.out.println(baseUrl);
		Response res = RestAssuredUtils.getRequestWithParameters(baseUrl,"application/json",uuid,uuidValue);
		res.getTime();
		System.out.println(res.getStatusCode());
		ResultSet row = gutil.executeSql("SELECT is_active FROM PRIMESERVICE.user_info where user_uuid='UF5HN6KJOGH'");
		System.out.println("is_active status from DB:"+row.getInt(0));
	
	}










}
