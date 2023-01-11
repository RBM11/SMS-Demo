package com.ssms.authentication.beans;

import com.ssms.userifo.beans.UserInfo;

/**
 * The Class AuthenticateResponse.
 */
public class AuthenticateResponse {

	/** The user info. */
	private UserInfo userInfo;
	
	/** The message. */
	private String message;
	
	/** The secket key. */
	private String secketKey;

	/**
	 * Gets the user info.
	 *
	 * @return the user info
	 */
	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	/**
	 * Sets the user info.
	 *
	 * @param userInfo the new user info
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the secket key.
	 *
	 * @return the secket key
	 */
	public String getSecketKey() {
		return this.secketKey;
	}

	/**
	 * Sets the secket key.
	 *
	 * @param secketKey the new secket key
	 */
	public void setSecketKey(String secketKey) {
		this.secketKey = secketKey;
	}
	
	
	
}
