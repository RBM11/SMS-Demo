package com.ssms.userifo.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ssms.common.model.RecordDetails;

/**
 * The Class UserInfoEntity.
 */
@Table(name = "user_details")
@Entity
public class UserInfoEntity {

	/** The uuid. */
	@Id
	@Column(name = "uuid" )
	private String uuid;
	
	/** The first name. */
	@Column(name = "first_name" )
	private String firstName;
	
	/** The last name. */
	@Column(name = "last_name" )
	private String lastName;
	
	/** The gender. */
	@Column(name = "gender" )
	private String gender;
	
	/** The mobile number. */
	@Column(name = "mobile_no" )
	private String mobileNumber;
	
	/** The user id. */
	@Column(name = "user_id" )
	private String userId;
	
	/** The password. */
	@Column(name = "password" )
	private String password;
	
	/** The record info. */
	private RecordDetails recordInfo;

	/**
	 * Gets the uuid.
	 *
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Sets the uuid.
	 *
	 * @param uuid the new uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the mobile number.
	 *
	 * @return the mobile number
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Sets the mobile number.
	 *
	 * @param mobileNumber the new mobile number
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the record info.
	 *
	 * @return the record info
	 */
	public RecordDetails getRecordInfo() {
		return recordInfo;
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
