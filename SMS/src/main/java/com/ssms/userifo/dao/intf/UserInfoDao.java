package com.ssms.userifo.dao.intf;

import java.util.List;

import com.ssms.authentication.beans.LoginInfo;
import com.ssms.userifo.dao.model.UserInfoEntity;

/**
 * The Interface UserInfoDao.
 */
public interface UserInfoDao {

	/**
	 * Validate user info.
	 *
	 * @param loginInfo the login info
	 * @return the user info entity
	 */
	UserInfoEntity validateUserInfo(LoginInfo loginInfo);	
	
	/**
	 * Save user unfo.
	 *
	 * @param userInfo the user info
	 * @return true, if successful
	 */
	boolean saveUserInfo(UserInfoEntity userInfo);
	
	/**
	 * Update user info.
	 *
	 * @param userInfo the user info
	 * @return true, if successful
	 */
	boolean updateUserInfo(UserInfoEntity userInfo);
	
	/**
	 * Gets the user info by user id.
	 *
	 * @param userId the user id
	 * @return the user info by user id
	 */
	UserInfoEntity getUserInfoByUserId(String userId);
	
	/**
	 * Delete user info by user id.
	 *
	 * @param userId the user id
	 * @return true, if successful
	 */
	boolean deleteUserInfoByUserId(String userId);
	
	/**
	 * Gets the all user info.
	 *
	 * @return the all user info
	 */
	List<UserInfoEntity> getAllUserInfo();
	
	
	
}
