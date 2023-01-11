package com.ssms.item.master.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ssms.common.model.RecordDetails;

/**
 * The Class ItemMasterEntity.
 */
@Entity
@Table(name = "item_master")
public class ItemMasterEntity {

	/** The item id. */
	@Id
	@Column(name = "item_id")
	private String itemId;
	
	/** The category id. */
	@Column(name = "category_id")
	private String categoryId;
	
	/** The item name. */
	@Column(name = "item_name")
	private String itemName;
	
	/** The description. */
	@Column(name = "description")
	private String description;
	
	
	/** The record info. */
	private RecordDetails recordInfo;
	
	

	/**
	 * Gets the record info.
	 *
	 * @return the record info
	 */
	public RecordDetails getRecordInfo() {
		return this.recordInfo;
	}

	/**
	 * Sets the record info.
	 *
	 * @param recordInfo the new record info
	 */
	public void setRecordInfo(RecordDetails recordInfo) {
		this.recordInfo = recordInfo;
	}

	/**
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public String getItemId() {
		return this.itemId;
	}

	/**
	 * Sets the item id.
	 *
	 * @param itemId the new item id
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public String getCategoryId() {
		return this.categoryId;
	}

	/**
	 * Sets the category id.
	 *
	 * @param categoryId the new category id
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItemName() {
		return this.itemName;
	}

	/**
	 * Sets the item name.
	 *
	 * @param itemName the new item name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
