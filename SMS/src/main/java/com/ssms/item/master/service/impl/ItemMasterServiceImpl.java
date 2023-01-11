package com.ssms.item.master.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssms.common.model.RecordDetails;
import com.ssms.constants.StringContants;
import com.ssms.item.master.beans.ItemInfo;
import com.ssms.item.master.dao.intf.ItemMasterDao;
import com.ssms.item.master.dao.model.ItemMasterEntity;
import com.ssms.item.master.service.intf.ItemMasterService;

/**
 * The Class ItemMasterServiceImpl.
 */
@Service
public class ItemMasterServiceImpl implements ItemMasterService {

	/** The item master dao. */
	@Autowired
	private ItemMasterDao itemMasterDao;
	
	/**
	 * Save item details.
	 *
	 * @param itemInfo the item info
	 * @return the string
	 */
	@Override
	public String saveItemDetails(ItemInfo itemInfo) {
		String message = "Fail to save item data";
		if(itemInfo != null) {
			
			ItemMasterEntity itemEntity = this.itemMasterDao.getItemDataByItemName(itemInfo.getItemName());
			if(itemEntity != null) {
				message = "item already exist";
			}else {
				itemEntity = new ItemMasterEntity();
				BeanUtils.copyProperties(itemInfo, itemEntity);
				itemEntity.setItemId(UUID.randomUUID().toString());
				final RecordDetails records = itemEntity.getRecordInfo();
				records.setCreatedBy(null);
				records.setCreatedOn(new Timestamp(System.currentTimeMillis()));				
				final boolean status = this.itemMasterDao.saveItemDetails(itemEntity);
				if(status) {
					message = StringContants.SUCCESS;
				}
			}
		}
		return message;
	}

	/**
	 * Update item details.
	 *
	 * @param itemInfo the item info
	 * @return the string
	 */
	@Override
	public String updateItemDetails(ItemInfo itemInfo) {
		String message = "Fail to update item data";
		if(itemInfo != null && itemInfo.getCategoryId() != null) {
			
			ItemMasterEntity itemEntity = this.itemMasterDao.getItemDataByItemName(itemInfo.getItemName());
			if(itemEntity != null && !itemInfo.getItemId().equalsIgnoreCase(itemEntity.getItemId())) {
				message = "item already exist";
			}else {
				itemEntity = new ItemMasterEntity();
				BeanUtils.copyProperties(itemInfo, itemEntity);
				final RecordDetails records = itemEntity.getRecordInfo();
				records.setModifiedBy(null);
				records.setModifiedOn(new Timestamp(System.currentTimeMillis()));
				final boolean status = this.itemMasterDao.updateItemDetails(itemEntity);
				if(status) {
					message = StringContants.SUCCESS;
				}

			}
			
		}
		return message;
	}

	/**
	 * Delete item by item id.
	 *
	 * @param itemId the item id
	 * @return the string
	 */
	@Override
	public String deleteItemByItemId(String itemId) {
		String message = "Fail to delete item data";
		if(itemId != null) {
			final boolean status = this.itemMasterDao.deleteItemByItemId(itemId);
			if(status) {
				message = StringContants.SUCCESS;
			}
		}
		return message;
	}

	/**
	 * Gets the all item data.
	 *
	 * @return the all item data
	 */
	@Override
	public List<ItemInfo> getAllItemData() {
		final List<ItemInfo> itemInfoList = new ArrayList<>();
		final List<ItemMasterEntity> itemEntityList = this.itemMasterDao.getAllItemData();
		for (final ItemMasterEntity itemMasterEntity : itemEntityList) {
			final ItemInfo itemInfo = new ItemInfo();
			BeanUtils.copyProperties(itemMasterEntity, itemInfo);
			itemInfoList.add(itemInfo);
		}
		return itemInfoList;
	}

}
