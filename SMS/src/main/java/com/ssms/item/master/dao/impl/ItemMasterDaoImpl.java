package com.ssms.item.master.dao.impl;

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

import com.ssms.item.master.dao.intf.ItemMasterDao;
import com.ssms.item.master.dao.model.ItemMasterEntity;

@Repository
public class ItemMasterDaoImpl  implements ItemMasterDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemMasterDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveItemDetails(ItemMasterEntity itemInfo) {
		boolean status = false;
		try(Session session = this.sessionFactory.openSession()){
			session.save(itemInfo);
			session.flush();
			status = true;
		}catch (final HibernateException e) {
			LOGGER.error("Exception in saveItemDetails {}", e.getMessage());
		}
		return status;
	}

	@Override
	public boolean updateItemDetails(ItemMasterEntity itemInfo) {
		boolean status = false;
		try(Session session = this.sessionFactory.openSession()){
			session.update(itemInfo);
			session.flush();
			status = true;
		}catch (final HibernateException e) {
			LOGGER.error("Exception in updateItemDetails {}", e.getMessage());
		}
		return status;
	}

	@Override
	public ItemMasterEntity getItemDataByItemName(String itemName) {
		ItemMasterEntity itemInfo = null;
		try(Session session = this.sessionFactory.openSession()){
			
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<ItemMasterEntity>  itemInfoQuery= cb.createQuery(ItemMasterEntity.class);
			final Root<ItemMasterEntity> itemInfoRoot = itemInfoQuery.from(ItemMasterEntity.class);
			
			final List<Predicate> predicateList = new ArrayList<>();
			predicateList.add(cb.equal(cb.lower(itemInfoRoot.get("itemId")), itemName));
			
			itemInfoQuery.where(predicateList.toArray(new Predicate[] {}));			
			itemInfo = session.createQuery(itemInfoQuery).uniqueResult();
			
		}catch (final HibernateException e) {
			LOGGER.error("Exception in getItemDataByItemId {}", e.getMessage());
		}
		
		
		return itemInfo;
	}

	@Override
	public boolean deleteItemByItemId(String itemId) {
		boolean status = false;
		try(Session session = this.sessionFactory.openSession()){
			final ItemMasterEntity itemEntity = session.get(ItemMasterEntity.class, itemId);
			if(itemEntity != null) {
				session.delete(itemEntity);
				status = true;
			}
			
		}catch (final HibernateException e) {
			LOGGER.error("Exception in deleteItemByItemId {}", e.getMessage());
		}
		return status;
	}

	@Override
	public List<ItemMasterEntity> getAllItemData() {
		List<ItemMasterEntity> unitInfoList = new ArrayList<>();
		try(Session session = this.sessionFactory.openSession()){
			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<ItemMasterEntity>  itemInfoQuery= cb.createQuery(ItemMasterEntity.class);
			final Root<ItemMasterEntity> itemInfoRoot = itemInfoQuery.from(ItemMasterEntity.class);
			itemInfoQuery.select(itemInfoRoot);						
			unitInfoList = session.createQuery(itemInfoQuery).list();
			
		}catch (final HibernateException e) {
			LOGGER.error("Exception in getAllItemData {}", e.getMessage());
		}
		
		return unitInfoList;
	}

}
