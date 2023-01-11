package com.ssms.category.master.dao.impl;

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

import com.ssms.category.master.dao.intf.CategoryMasterDao;
import com.ssms.category.master.dao.model.CategoryMasterEntity;

/**
 * The Class CategoryMasterDaoImpl.
 */
@Repository
public class CategoryMasterDaoImpl implements CategoryMasterDao {


	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryMasterDaoImpl.class);
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Save category details.
	 *
	 * @param categoryInfo the category info
	 * @return true, if successful
	 */
	@Override
	public boolean saveCategoryDetails(CategoryMasterEntity categoryInfo) {
		boolean status = false;
		try(Session session = this.sessionFactory.openSession()){
			session.save(categoryInfo);
			session.flush();
			status = true;
		}catch (final HibernateException e) {
			LOGGER.error("Exception in saveCategoryDetails {}", e.getMessage());
		}
		return status;
	}

	/**
	 * Update category details.
	 *
	 * @param categoryInfo the category info
	 * @return true, if successful
	 */
	@Override
	public boolean updateCategoryDetails(CategoryMasterEntity categoryInfo) {
		boolean status = false;
		try(Session session = this.sessionFactory.openSession()){
			session.update(categoryInfo);
			session.flush();
			status = true;
		}catch (final HibernateException e) {
			LOGGER.error("Exception in updateCategoryDetails {}", e.getMessage());
		}
		return status;
	}

	/**
	 * Delete category by category id.
	 *
	 * @param categoryId the category id
	 * @return true, if successful
	 */
	@Override
	public boolean deleteCategoryByCategoryId(String categoryId) {
		boolean status = false;
		try(Session session = this.sessionFactory.openSession()){
			final CategoryMasterEntity categoryEntity = session.get(CategoryMasterEntity.class, categoryId);
			if(categoryEntity != null) {
				session.delete(categoryEntity);
				status = true;
			}
			
		}catch (final HibernateException e) {
			LOGGER.error("Exception in deleteCategoryByCategoryName {}", e.getMessage());
		}
		return status;
	}

	/**
	 * Gets the all category data.
	 *
	 * @return the all category data
	 */
	@Override
	public List<CategoryMasterEntity> getAllCategoryData() {
		List<CategoryMasterEntity> categoryInfoList = new ArrayList<>();
		try(Session session = this.sessionFactory.openSession()){
			
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<CategoryMasterEntity>  categoryInfoQuery= cb.createQuery(CategoryMasterEntity.class);
			final Root<CategoryMasterEntity> categoryInfoRoot = categoryInfoQuery.from(CategoryMasterEntity.class);
			categoryInfoQuery.select(categoryInfoRoot);						
			categoryInfoList = session.createQuery(categoryInfoQuery).list();
			
		}catch (final HibernateException e) {
			LOGGER.error("Exception in getAllCategoryData {}", e.getMessage());
		}
		
		return categoryInfoList;
	}

	@Override
	public CategoryMasterEntity getCategoryDataByCategoryName(String categoryName) {
		CategoryMasterEntity unitInfo = null;
		try(Session session = this.sessionFactory.openSession()){
			
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<CategoryMasterEntity>  categoryInfoQuery= cb.createQuery(CategoryMasterEntity.class);
			final Root<CategoryMasterEntity> categoryInfoRoot = categoryInfoQuery.from(CategoryMasterEntity.class);
			
			final List<Predicate> predicateList = new ArrayList<>();
			predicateList.add(cb.equal(cb.lower(categoryInfoRoot.get("categoryId")), categoryName.toLowerCase()));
			
			categoryInfoQuery.where(predicateList.toArray(new Predicate[] {}));			
			unitInfo = session.createQuery(categoryInfoQuery).uniqueResult();
			
		}catch (final HibernateException e) {
			LOGGER.error("Exception in getCategoryDataByCategoryId {}", e.getMessage());
		}
		
		
		return unitInfo;
	}

}
