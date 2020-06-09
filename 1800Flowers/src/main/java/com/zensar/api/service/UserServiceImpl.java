package com.zensar.api.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImpl implements UserService {

	// Modified the 4th JSON array item with changing the title and body of the object to "1800Flowers".
	@SuppressWarnings("unchecked")
	public List<Object> getUpdatedUserList(String url, int positionToUpdate) throws Exception {

		JSONArray jsonArr = new JSONArray();
		List<Object> listofActualObj = null;
		listofActualObj = getUserData(url);

		jsonArr.put(listofActualObj.get(positionToUpdate));
		Map<String, String> passedValues = (HashMap<String, String>) jsonArr.get(0);
		JSONObject retObj = new JSONObject();

		try {
			for (Entry<String, String> mapTemp : passedValues.entrySet()) {
				if (mapTemp.getKey().equalsIgnoreCase("title")) {
					passedValues.put("title", "1800Flowers");
					passedValues.put("body", "1800Flowers");
				}
			}
			listofActualObj.set(3, passedValues.toString());
		}

		catch (Exception ex) {
			// Return 500 Error with some custom error message
			// e.printStackTrace();
			retObj.put("message", "FAILED");
			retObj.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return listofActualObj;
	}

	// Count the number of unique userIds in the JSON.
	@SuppressWarnings("unchecked")
	@Override
	public int getUniqueUserIds(String url) throws Exception {

		JSONArray jsonArr = new JSONArray();
		Set<String> uniqueUserIds = new HashSet<String>();
		Map<String, String> passedValues = new HashMap<String, String>();

		List<Object> listofActualObj = null;
		listofActualObj = getUserData(url);
		JSONObject retObj = new JSONObject();

		try {
			if (listofActualObj != null && listofActualObj.size() > 0) {
				for (int i = 0; i < listofActualObj.size(); i++) {
					jsonArr.put(listofActualObj.get(i));
					passedValues = (HashMap<String, String>) jsonArr.get(i);
					for (Entry<String, String> mapTemp : passedValues.entrySet()) {
						if (mapTemp.getKey().equalsIgnoreCase("userId")) {
							uniqueUserIds.add(String.valueOf(mapTemp.getValue()));
						}
					}
				}
			} else {
				// Return 404 error with some custom error message.
				retObj.put("message", "FAILURE");
				retObj.put("statusCode", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			// Return 500 Error with some custom error message
			// ex.printStackTrace();
			retObj.put("message", "FAILED");
			retObj.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return uniqueUserIds.size();
	}

	public List<Object> getUserData(String url) {
		RestTemplate template = new RestTemplate();
		// String url = "http://jsonplaceholder.typicode.com/posts";
		List<Object> listofActualObj = Arrays.asList(template.getForObject(url, Object[].class));
		return listofActualObj;
	}
}
