package loyalty_webservice;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mmt.utils.GeneralUtils;
import org.mmt.utils.RestAssuredUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VoucherTests {
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
	public void getUserActivationStatus(String uuid,String uuidValue) throws IOException {
		String baseUrl = gutil.getProperty("getUserActivationStatus");
		System.out.println(baseUrl);
		Response res = RestAssuredUtils.getRequestWithParameters(baseUrl,"application/json",uuid,uuidValue);
		System.out.println(res.getTime());
		System.out.println(res.getStatusCode());
	}










}
