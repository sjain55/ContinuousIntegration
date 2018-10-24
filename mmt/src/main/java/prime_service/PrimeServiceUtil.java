package prime_service;

import java.io.FileNotFoundException;

import org.json.JSONArray;
import org.json.JSONObject;

import groovy.json.JsonOutput;
public class PrimeServiceUtil {


	public Object buildPreCancelValidationJson() throws FileNotFoundException {
		JSONObject root = new JSONObject();
		JSONObject booking = new JSONObject();
		JSONObject flights = new JSONObject();
		JSONArray sectorsArray = new JSONArray();
		JSONObject sector = new JSONObject();
		sector.put("departureTime", "");
		sector.put("id", "");
		sector.put("numPaxToBeCancelled", 0);
		sectorsArray.put(sector);
		flights.put("sectors",sectorsArray);
		JSONObject hotels = new JSONObject();
		hotels.put("checkInTime","2018-10-23T12:25:28.050Z");
		JSONObject booker = new JSONObject();
		booker.put("profileType", "PERSONAL");
		booker.put("uuid", "12344");
		booking.put("booker", booker);
		booking.put("bookingId", "testbookingid");
		booking.put("flights", flights);
		booking.put("hotels", hotels);
		booking.put("lob", "FLT");
		root.put("booking",booking);
		root.put("pageType", "DETAILS");
		System.out.println(root.toString());
		System.out.println(JsonOutput.prettyPrint(root.toString()));
		return root;
	}
}
