package com.ssms.item.master.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssms.constants.StringContants;
import com.ssms.item.master.beans.ItemInfo;
import com.ssms.item.master.service.intf.ItemMasterService;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemMasterController.
 */
@RestController
public class ItemMasterController {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemMasterController.class);
	
	/** The item master service. */
	@Autowired
	private ItemMasterService itemMasterService;
	
	/**
	 * Save item data.
	 *
	 * @param itemInfo the item info
	 * @return the response entity
	 */
	@PostMapping("saveItemData")
	public ResponseEntity<String> saveItemData(@RequestBody ItemInfo itemInfo){
		HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
		String responseMessage = null;
		try {
			responseMessage = this.itemMasterService.saveItemDetails(itemInfo);
			if (StringContants.SUCCESS.equalsIgnoreCase(responseMessage)) {
				httpStatus = HttpStatus.OK;
			}

		} catch (final Exception e) {
			LOGGER.error("Exception in saveCategoryData()", e);
		}
		return new ResponseEntity<>(responseMessage, httpStatus);
	}
	
	
	/**
	 * Update item data.
	 *
	 * @param itemInfo the item info
	 * @return the response entity
	 */
	@PutMapping("updateItemData")
	public ResponseEntity<String> updateItemData(@RequestBody ItemInfo itemInfo){
		HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
		String responseMessage = null;
		try {
			responseMessage = this.itemMasterService.updateItemDetails(itemInfo);
			if (StringContants.SUCCESS.equalsIgnoreCase(responseMessage)) {
				httpStatus = HttpStatus.OK;
			}

		} catch (final Exception e) {
			LOGGER.error("Exception in updateItemData()", e);
		}
		return new ResponseEntity<>(responseMessage, httpStatus);
	}
	
	
	/**
	 * Delete item data.
	 *
	 * @param itemId the item id
	 * @return the response entity
	 */
	@DeleteMapping("deleteItemData")
	public ResponseEntity<String> deleteItemData(@RequestBody String itemId){
		HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
		String responseMessage = null;
		try {
			responseMessage = this.itemMasterService.deleteItemByItemId(itemId);
			if (StringContants.SUCCESS.equalsIgnoreCase(responseMessage)) {
				httpStatus = HttpStatus.OK;
			}

		} catch (final Exception e) {
			LOGGER.error("Exception in deleteItemData()", e);
		}
		return new ResponseEntity<>(responseMessage, httpStatus);
	}
	
	
	/**
	 * Gets the all item data.
	 *
	 * @return the all item data
	 */
	@GetMapping("getAllItemData")
	public ResponseEntity<List<ItemInfo>> getAllItemData(){
		List<ItemInfo> itemInfoList = new ArrayList<>();
		try {
			itemInfoList = this.itemMasterService.getAllItemData();
		} catch (final Exception e) {
			LOGGER.error("Exception in getAllItemData()", e);
		}		
		return new ResponseEntity<>(itemInfoList, HttpStatus.OK);
	}

}
