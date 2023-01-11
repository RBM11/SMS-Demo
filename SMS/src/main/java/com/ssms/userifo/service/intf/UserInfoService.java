package com.ssms.userifo.service.intf;

import java.util.List;

import com.ssms.userifo.beans.UserInfo;

/**
 * The Interface UserInfoService.
 */
public interface UserInfoService {

	
	/**
	 * Save user details.
	 *
	 * @param userInfo the user info
	 * @return the string
	 */
	String saveUserDetails(UserInfo userInfo);
	
	/**
	 * Update user details.
	 *
	 * @param userInfo the user info
	 * @return the string
	 */
	String updateUserDetails(UserInfo userInfo);
	
	/**
	 * Delete user by user id.
	 *
	 * @param userId the user id
	 * @return the string
	 */
	String deleteUserByUserId(String userId);
	
	/**
	 * Gets the all user data.
	 *
	 * @return the all user data
	 */
	List<UserInfo> getAllUserData();
}
