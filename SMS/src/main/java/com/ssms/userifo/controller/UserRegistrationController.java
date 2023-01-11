package com.ssms.userifo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssms.constants.StringContants;
import com.ssms.userifo.beans.UserInfo;
import com.ssms.userifo.service.intf.UserInfoService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRegistrationController.
 */
@RestController
public class UserRegistrationController {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);
	
	
	/** The user service. */
	private UserInfoService userService;
	
	/**
	 * Save resistration data.
	 *
	 * @param userInfo the user info
	 * @return the response entity
	 */
	@PostMapping("saveResistrationData")
	public ResponseEntity<String> saveResistrationData(@RequestBody UserInfo userInfo){
		
		HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
		String responseMessage = null;
		try {
			responseMessage = this.userService.saveUserDetails(userInfo);
			if (StringContants.SUCCESS.equalsIgnoreCase(responseMessage)) {
				httpStatus = HttpStatus.OK;
			}

		} catch (final Exception e) {
			LOGGER.error("Exception in saveResistrationData()", e);
		}
		return new ResponseEntity<>(responseMessage, httpStatus);
	}
	
	
	/**
	 * Update user data.
	 *
	 * @param userInfo the user info
	 * @return the response entity
	 */
	@PutMapping("updateUserDetails")
	public ResponseEntity<String> updateUserData(@RequestBody UserInfo userInfo){
		HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
		String responseMessage = null;
		try {
			responseMessage = this.userService.updateUserDetails(userInfo);
			if (StringContants.SUCCESS.equalsIgnoreCase(responseMessage)) {
				httpStatus = HttpStatus.OK;
			}

		} catch (final Exception e) {
			LOGGER.error("Exception in updateUserData()", e);
		}
		return new ResponseEntity<>(responseMessage, httpStatus);
	}
	
	
	/**
	 * Delete user data.
	 *
	 * @param userId the user id
	 * @return the response entity
	 */
	@DeleteMapping("deleteUserData")
	public ResponseEntity<String> deleteUserData(@RequestBody String userId){
		HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
		String responseMessage = null;
		try {
			responseMessage = this.userService.deleteUserByUserId(userId);
			if (StringContants.SUCCESS.equalsIgnoreCase(responseMessage)) {
				httpStatus = HttpStatus.OK;
			}

		} catch (final Exception e) {
			LOGGER.error("Exception in deleteUserData()", e);
		}
		return new ResponseEntity<>(responseMessage, httpStatus);
	}
	
	
	/**
	 * Gets the all user data.
	 *
	 * @return the all user data
	 */
	@GetMapping("getAllUserData")
	public ResponseEntity<List<UserInfo>> getAllUserData(){
		List<UserInfo> userInfoList = new ArrayList<>();
		try {
			userInfoList = this.userService.getAllUserData();
		} catch (final Exception e) {
			LOGGER.error("Exception in getAllUserData()", e);
		}		
		return new ResponseEntity<>(userInfoList, HttpStatus.OK);
	}

}
