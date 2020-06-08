package com.zensar.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.api.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	// This method will modify the 4th JSON array item with changing the title and body of the object to "1800Flowers".
	@RequestMapping(value = "/getUpdatedUserList", method = RequestMethod.GET)
	public ResponseEntity<String> getUpdatedUserList(@RequestParam("url") String url,
			@RequestParam("positionToUpdate") String positionToUpdate, HttpServletRequest request) {

		List<Object> updatedUserList = null;
		JSONObject retObj = new JSONObject();
		try {
			updatedUserList = service.getUpdatedUserList(url, Integer.parseInt(positionToUpdate));
			if (updatedUserList != null) {
				ObjectMapper jsonMapper = new ObjectMapper();
				retObj.put("message", "SUCCESS");
				retObj.put("upadtedUserList", jsonMapper.writeValueAsString(updatedUserList));
			} else {
				retObj.put("message", "FAILURE");
				return new ResponseEntity<String>(String.valueOf(retObj), HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			retObj.put("message", "FAILURE");
			return new ResponseEntity<String>(String.valueOf(retObj), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(String.valueOf(retObj), HttpStatus.OK);
	}
	
	// This method will count the number of unique userIds in the JSON
	@RequestMapping(value = "/getUniqueUserIds", method = RequestMethod.GET)
	public ResponseEntity<String> getUniqueUserIds(@RequestParam("url") String url, HttpServletRequest request) {
		JSONObject retObj = new JSONObject();
		try {
			int uniqueUserIDs = service.getUniqueUserIds(url);
			if (uniqueUserIDs > 0) {
				retObj.put("message", "SUCCESS");
				retObj.put("uniqueUserIDCount", uniqueUserIDs);
			} else {
				retObj.put("message", "FAILURE");
				return new ResponseEntity<String>(String.valueOf(retObj), HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			retObj.put("message", "FAILURE");
			return new ResponseEntity<String>(String.valueOf(retObj), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(String.valueOf(retObj), HttpStatus.OK);
	}
}