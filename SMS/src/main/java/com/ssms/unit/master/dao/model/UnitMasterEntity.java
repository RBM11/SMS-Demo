package com.ssms.unit.master.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ssms.common.model.RecordDetails;

/**
 * The Class UnitMasterEntity.
 */
@Entity
@Table(name = "unit_master")
public class UnitMasterEntity {

	/** The unit id. */
	@Id
	@Column(name = "unit_id")
	private String unitId;
	
	/** The unit name. */
	@Column(name = "unit_name")
	private String unitName;
	
	/** The description. */
	@Column(name = "description")
	private String description;
	
	/** The record info. */
	private RecordDetails recordInfo;

	/**
	 * Gets the unit id.
	 *
	 * @return the unit id
	 */
	public String getUnitId() {
		return this.unitId;
	}

	/**
	 * Sets the unit id.
	 *
	 * @param unitId the new unit id
	 */
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	/**
	 * Gets the unit name.
	 *
	 * @return the unit name
	 */
	public String getUnitName() {
		return this.unitName;
	}

	/**
	 * Sets the unit name.
	 *
	 * @param unitName the new unit name
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
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
