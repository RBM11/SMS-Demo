package com.ssms.authentication.service.intf;

import com.ssms.authentication.beans.AuthenticateResponse;
import com.ssms.authentication.beans.LoginInfo;

/**
 * The Interface AuthenicateService.
 */
public interface AuthenticateService {

	/**
	 * Validate user info.
	 *
	 * @param loginInfo the login info
	 * @return the authenticate response
	 */
	AuthenticateResponse validateUserInfo(LoginInfo loginInfo);
	
}
