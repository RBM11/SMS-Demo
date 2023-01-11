package com.ssms.item.master.service.intf;

import java.util.List;

import com.ssms.item.master.beans.ItemInfo;

// TODO: Auto-generated Javadoc
/**
 * The Interface ItemMasterService.
 */
public interface ItemMasterService {

	/**
	 * Save item details.
	 *
	 * @param itemInfo the item info
	 * @return the string
	 */
	String saveItemDetails(ItemInfo itemInfo);
	
	/**
	 * Update item details.
	 *
	 * @param itemInfo the item info
	 * @return the string
	 */
	String updateItemDetails(ItemInfo itemInfo);
	
	/**
	 * Delete item by item id.
	 *
	 * @param itemId the item id
	 * @return the string
	 */
	String deleteItemByItemId(String itemId);
	
	/**
	 * Gets the all item data.
	 *
	 * @return the all item data
	 */
	List<ItemInfo> getAllItemData();
}
