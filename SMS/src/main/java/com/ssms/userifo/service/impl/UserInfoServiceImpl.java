package com.ssms.userifo.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ssms.common.model.RecordDetails;
import com.ssms.constants.StringContants;
import com.ssms.userifo.beans.UserInfo;
import com.ssms.userifo.dao.intf.UserInfoDao;
import com.ssms.userifo.dao.model.UserInfoEntity;
import com.ssms.userifo.service.intf.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	private UserInfoDao userInfoDao;

	@Override
	public String saveUserDetails(UserInfo userInfo) {
		String message = "Fail to save user data";
		if(userInfo != null && userInfo.getUserId() != null) {
			
			UserInfoEntity userInfoEntity = this.userInfoDao.getUserInfoByUserId(userInfo.getUserId());
			if(userInfoEntity != null) {
				message = "userid already exist";
			}else {
				userInfoEntity = new UserInfoEntity();
				BeanUtils.copyProperties(userInfo, userInfoEntity);
				userInfoEntity.setUuid(UUID.randomUUID().toString());
				final RecordDetails records = userInfoEntity.getRecordInfo();
				records.setCreatedOn(null);
				records.setCreatedOn(new Timestamp(System.currentTimeMillis()));				
				final boolean status = this.userInfoDao.saveUserInfo(userInfoEntity);
				if(status) {
					message = StringContants.SUCCESS;
				}
			}
			
		}
		return message;

	}

	@Override
	public String updateUserDetails(UserInfo userInfo) {
		String message = "Fail to update catetgory data";
		if(userInfo != null && userInfo.getUserId() != null) {
				final UserInfoEntity userInfoEntity = new UserInfoEntity();
				BeanUtils.copyProperties(userInfo, userInfoEntity);
				final RecordDetails records = userInfoEntity.getRecordInfo();
				records.setModifiedBy(null);
				records.setModifiedOn(new Timestamp(System.currentTimeMillis()));
				
				final boolean status = this.userInfoDao.updateUserInfo(userInfoEntity);
				if(status) {
					message = StringContants.SUCCESS;
				}

			
			
		}
		return message;
	}

	@Override
	public String deleteUserByUserId(String userId) {
		String message = "Fail to delete user data";
		if(userId != null) {
			final boolean status = this.userInfoDao.deleteUserInfoByUserId(userId);
			if(status) {
				message = StringContants.SUCCESS;
			}
		}
		return message;
	}

	@Override
	public List<UserInfo> getAllUserData() {
		final List<UserInfo> userInfoList = new ArrayList<>();
		final List<UserInfoEntity> userInfoEntityList = this.userInfoDao.getAllUserInfo();
		for (final UserInfoEntity userInfoEntity : userInfoEntityList) {
			final UserInfo userInfo = new UserInfo();
			BeanUtils.copyProperties(userInfoEntity, userInfo);
			userInfo.setPassword(null);
			userInfoList.add(userInfo);
		}
		return userInfoList;
	}
	
	
	

}
