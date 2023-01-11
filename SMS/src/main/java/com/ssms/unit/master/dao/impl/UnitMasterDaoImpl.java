package com.ssms.unit.master.dao.impl;

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

import com.ssms.unit.master.dao.intf.UnitMasterDao;
import com.ssms.unit.master.dao.model.UnitMasterEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class UnitMasterDaoImpl.
 */
@Repository
public class UnitMasterDaoImpl  implements UnitMasterDao{


	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(UnitMasterDaoImpl.class);
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Save unit details.
	 *
	 * @param unitInfo the unit info
	 * @return true, if successful
	 */
	@Override
	public boolean saveUnitDetails(UnitMasterEntity unitInfo) {
		boolean status = false;
		try(Session session = this.sessionFactory.openSession()){
			session.save(unitInfo);
			session.flush();
			status = true;
		}catch (final HibernateException e) {
			LOGGER.error("Exception in saveUnitDetails {}", e.getMessage());
		}
		return status;
	}

	/**
	 * Update unit details.
	 *
	 * @param unitInfo the unit info
	 * @return true, if successful
	 */
	@Override
	public boolean updateUnitDetails(UnitMasterEntity unitInfo) {
		boolean status = false;
		try(Session session = this.sessionFactory.openSession()){
			session.update(unitInfo);
			session.flush();
			status = true;
		}catch (final HibernateException e) {
			LOGGER.error("Exception in updateUnitDetails {}", e.getMessage());
		}
		return status;
	}

	/**
	 * Gets the unit data by unit name.
	 *
	 * @param unitName the unit name
	 * @return the unit data by unit name
	 */
	@Override
	public UnitMasterEntity getUnitDataByUnitName(String unitName) {
		UnitMasterEntity unitInfo = null;
		try(Session session = this.sessionFactory.openSession()){
			
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<UnitMasterEntity>  unitInfoQuery= cb.createQuery(UnitMasterEntity.class);
			final Root<UnitMasterEntity> unitInfoRoot = unitInfoQuery.from(UnitMasterEntity.class);
			
			final List<Predicate> predicateList = new ArrayList<>();
			predicateList.add(cb.equal(cb.lower(unitInfoRoot.get("unitName")), unitName));
			
			unitInfoQuery.where(predicateList.toArray(new Predicate[] {}));			
			unitInfo = session.createQuery(unitInfoQuery).uniqueResult();
			
		}catch (final HibernateException e) {
			LOGGER.error("Exception in getUnitDataByUnitId {}", e.getMessage());
		}
		
		
		return unitInfo;
	}

	/**
	 * Delete unit by unit id.
	 *
	 * @param unitId the unit id
	 * @return true, if successful
	 */
	@Override
	public boolean deleteUnitByUnitId(String unitId) {
		boolean status = false;
		try(Session session = this.sessionFactory.openSession()){
			final UnitMasterEntity unitEntity = session.get(UnitMasterEntity.class, unitId);
			if(unitEntity != null) {
				session.delete(unitEntity);
				status = true;
			}
			
		}catch (final HibernateException e) {
			LOGGER.error("Exception in deleteUnitByUnitId {}", e.getMessage());
		}
		return status;
	}

	/**
	 * Gets the all unit data.
	 *
	 * @return the all unit data
	 */
	@Override
	public List<UnitMasterEntity> getAllUnitData() {
		List<UnitMasterEntity> unitInfoList = new ArrayList<>();
		try(Session session = this.sessionFactory.openSession()){
			
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<UnitMasterEntity>  unitInfoQuery= cb.createQuery(UnitMasterEntity.class);
			final Root<UnitMasterEntity> unitInfoRoot = unitInfoQuery.from(UnitMasterEntity.class);
			unitInfoQuery.select(unitInfoRoot);						
			unitInfoList = session.createQuery(unitInfoQuery).list();
			
		}catch (final HibernateException e) {
			LOGGER.error("Exception in getAllUnitData {}", e.getMessage());
		}
		
		return unitInfoList;
	}

}
