package com.ssms.transaction.dao.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class TransactionEntity.
 */
@Entity
@Table(name = "transaction_info")
public class TransactionEntity {

	/** The transaction id. */
	@Id
	@Column(name = "transaction_id" )
	private String transactionId;
	
	
	/** The item id. */
	@Column(name = "item_id" )
	private String itemId;
	
	/** The quantity. */
	@Column(name = "quantity" )
	private int  quantity;
	
	/** The unit id. */
	@Column(name = "unit_id" )
	private String unitId;
	
	/** The created by. */
	@Column(name = "created_by" )
	private String createdBy;
	
	/** The created on. */
	@Column(name = "created_on" )
	private Timestamp createdOn;

	/**
	 * Gets the transaction id.
	 *
	 * @return the transaction id
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * Sets the transaction id.
	 *
	 * @param transactionId the new transaction id
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public String getItemId() {
		return itemId;
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
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the unit id.
	 *
	 * @return the unit id
	 */
	public String getUnitId() {
		return unitId;
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
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created on.
	 *
	 * @return the created on
	 */
	public Timestamp getCreatedOn() {
		return createdOn;
	}

	/**
	 * Sets the created on.
	 *
	 * @param createdOn the new created on
	 */
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	
	

}
