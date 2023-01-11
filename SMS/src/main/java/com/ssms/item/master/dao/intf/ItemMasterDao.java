package com.ssms.item.master.dao.intf;

import java.util.List;

import com.ssms.item.master.dao.model.ItemMasterEntity;

/**
 * The Interface ItemMasterDao.
 */
public interface ItemMasterDao {
	
/**
 * Save item details.
 *
 * @param itemInfo the item info
 * @return true, if successful
 */
boolean saveItemDetails(ItemMasterEntity itemInfo);
	
	/**
	 * Update item details.
	 *
	 * @param itemInfo the item info
	 * @return true, if successful
	 */
	boolean updateItemDetails(ItemMasterEntity itemInfo);
	
	/**
	 * Gets the item data by item name.
	 *
	 * @param itemName the item name
	 * @return the item data by item id
	 */
	ItemMasterEntity getItemDataByItemName(String itemName);
	
	/**
	 * Delete item by item id.
	 *
	 * @param itemId the item id
	 * @return true, if successful
	 */
	boolean deleteItemByItemId(String itemId);

	/**
	 * Gets the all item data.
	 *
	 * @return the all item data
	 */
	List<ItemMasterEntity> getAllItemData();

}
