package com.ssms.authentication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssms.authentication.beans.AuthenticateResponse;
import com.ssms.authentication.beans.LoginInfo;
import com.ssms.authentication.service.intf.AuthenticateService;

/**
 * The Class AuthenticationController.
 */
@RestController
public class AuthenticationController {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	
	/** The authenticate service. */
	@Autowired
	private AuthenticateService authenicateService;
	
	/**
	 * Authenticate user.
	 *
	 * @param data the data
	 * @return the response entity
	 */
	@CrossOrigin(origins = "*")
	@PostMapping("authenticateUser")
	public ResponseEntity<AuthenticateResponse> authenticateUser(@RequestBody LoginInfo data){
		AuthenticateResponse responseData = new AuthenticateResponse();
		try {
			responseData =	this.authenicateService.validateUserInfo(data);
		}catch (final Exception e) {
			LOGGER.error("Exception in authenticateUser()",e);
		}
		
		HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
		if("success".equalsIgnoreCase(responseData.getMessage())) {
			httpStatus = HttpStatus.OK;
		}
		
		return new ResponseEntity<>(responseData, httpStatus);
	}
	
}
