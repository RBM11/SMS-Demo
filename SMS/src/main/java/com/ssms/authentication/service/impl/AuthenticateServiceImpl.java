package com.ssms.authentication.service.impl;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssms.authentication.beans.AuthenticateResponse;
import com.ssms.authentication.beans.LoginInfo;
import com.ssms.authentication.service.intf.AuthenticateService;
import com.ssms.userifo.beans.UserInfo;
import com.ssms.userifo.dao.intf.UserInfoDao;
import com.ssms.userifo.dao.model.UserInfoEntity;

/**
 * The Class AuthenicateServiceImpl.
 */
@Service
public class AuthenticateServiceImpl implements AuthenticateService {

	/** The user info dao. */
	@Autowired
	private UserInfoDao userInfoDao;

	/**
	 * Validate user info.
	 *
	 * @param loginInfo the login info
	 * @return the authenticate response
	 */
	@Override
	public AuthenticateResponse validateUserInfo(LoginInfo loginInfo) {
		final AuthenticateResponse response = new AuthenticateResponse();
		response.setMessage("FailToAuthenticate");
		if(loginInfo != null) {
			final UserInfoEntity userInfoEntity = this.userInfoDao.validateUserInfo(loginInfo);
			if(userInfoEntity != null) {
				final UserInfo userInfo = new UserInfo();
				BeanUtils.copyProperties(userInfoEntity, userInfo);
				response.setMessage("success");
				response.setUserInfo(userInfo);
				response.setSecketKey(this.generateJwtToken());
			}
			
		}
		return response;
	}
	
	/**
	 * Generate jwt token.
	 *
	 * @return the string
	 */
	private String generateJwtToken() {
		return UUID.randomUUID().toString();
	}
	
	
}
