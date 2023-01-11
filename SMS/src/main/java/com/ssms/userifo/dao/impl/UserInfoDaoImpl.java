package com.ssms.userifo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssms.authentication.beans.LoginInfo;
import com.ssms.userifo.dao.intf.UserInfoDao;
import com.ssms.userifo.dao.model.UserInfoEntity;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public UserInfoEntity validateUserInfo(LoginInfo loginInfo) {
		
		UserInfoEntity userInfo = null;
		try(Session session = this.sessionFactory.openSession()){
			
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<UserInfoEntity>  userInfoQuery= cb.createQuery(UserInfoEntity.class);
			final Root<UserInfoEntity> userInfoRoot = userInfoQuery.from(UserInfoEntity.class);
			
			final List<Predicate> predicateList = new ArrayList<>();
			predicateList.add(cb.equal(userInfoRoot.get("userId"), loginInfo.getUserId()));
			predicateList.add(cb.equal(userInfoRoot.get("password"), loginInfo.getPassword()));
			
			userInfoQuery.where(predicateList.toArray(new Predicate[] {}));			
			userInfo = session.createQuery(userInfoQuery).uniqueResult();
			
		}catch (final HibernateException e) {
			LOGGER.error("Exception in validateUserInfo {}", e.getMessage());
		}
		
		
		return userInfo;
	}

	@Override
	public boolean saveUserInfo(UserInfoEntity userInfo) {
		
		boolean status = false;
		try(Session session = this.sessionFactory.openSession()){
			session.save(userInfo);
			session.flush();
			status = true;
		}catch (final HibernateException e) {
			LOGGER.error("Exception in saveUserInfo {}", e.getMessage());
		}
		return status;
	}

	@Override
	public List<UserInfoEntity> getAllUserInfo() {
		List<UserInfoEntity> userInfoList = new ArrayList<>();
		try(Session session = this.sessionFactory.openSession()){
			
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<UserInfoEntity>  userInfoQuery= cb.createQuery(UserInfoEntity.class);
			final Root<UserInfoEntity> userInfoRoot = userInfoQuery.from(UserInfoEntity.class);
			userInfoQuery.select(userInfoRoot);						
			userInfoList = session.createQuery(userInfoQuery).list();
			
		}catch (final HibernateException e) {
			LOGGER.error("Exception in getAllUserInfo {}", e.getMessage());
		}
		
		return userInfoList;
	}

	@Override
	public boolean updateUserInfo(UserInfoEntity userInfo) {
		boolean status = false;
		try(Session session = this.sessionFactory.openSession()){
			session.update(userInfo);
			session.flush();
			status = true;
		}catch (final HibernateException e) {
			LOGGER.error("Exception in updateUserInfo {}", e.getMessage());
		}
		return status;
	}

	@Override
	public UserInfoEntity getUserInfoByUserId(String userId) {
		UserInfoEntity userInfo = null;
		try(Session session = this.sessionFactory.openSession()){
			
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<UserInfoEntity>  userInfoQuery= cb.createQuery(UserInfoEntity.class);
			final Root<UserInfoEntity> userInfoRoot = userInfoQuery.from(UserInfoEntity.class);
			
			final List<Predicate> predicateList = new ArrayList<>();
			predicateList.add(cb.equal(userInfoRoot.get("userId"), userId));
			
			userInfoQuery.where(predicateList.toArray(new Predicate[] {}));			
			userInfo = session.createQuery(userInfoQuery).uniqueResult();
			
		}catch (final HibernateException e) {
			LOGGER.error("Exception in validateUserInfo {}", e.getMessage());
		}
		
		
		return userInfo;
	}

	@Override
	public boolean deleteUserInfoByUserId(String userId) {
		
		boolean status = false;
		try(Session session = this.sessionFactory.openSession()){
			final UserInfoEntity userInfo = session.get(UserInfoEntity.class, userId);
			if(userInfo != null) {
				session.delete(userInfo);
				status = true;
			}
			
		}catch (final HibernateException e) {
			LOGGER.error("Exception in deleteUserInfoByUserId {}", e.getMessage());
		}
		return status;
	}

}
