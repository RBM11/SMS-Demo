package com.ssms.category.master.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ssms.common.model.RecordDetails;

/**
 * The Class CategoryMasterEntity.
 */
@Entity
@Table(name = "category_master")
public class CategoryMasterEntity {

	/** The category id. */
	@Id
	@Column(name = "category_id")
	private String categoryId;
	
	/** The category name. */
	@Column(name = "category_name")
	private String categoryName;
	
	/** The description. */
	@Column(name = "description")
	private String description;
	
	/** The record info. */
	private RecordDetails recordInfo;
	
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
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName() {
		return this.categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	
	
	
}
