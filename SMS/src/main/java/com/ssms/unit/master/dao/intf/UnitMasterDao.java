package com.ssms.unit.master.dao.intf;

import java.util.List;

import com.ssms.unit.master.dao.model.UnitMasterEntity;

/**
 * The Interface UnitMasterDao.
 */
public interface UnitMasterDao {

	/**
	 * Save unit details.
	 *
	 * @param unitInfo the unit info
	 * @return true, if successful
	 */
	boolean saveUnitDetails(UnitMasterEntity unitInfo);
	
	/**
	 * Update unit details.
	 *
	 * @param unitInfo the unit info
	 * @return true, if successful
	 */
	boolean updateUnitDetails(UnitMasterEntity unitInfo);

	/**
	 * Gets the unit data by unit name.
	 *
	 * @param unitName the unit name
	 * @return the unit data by unit name
	 */
	UnitMasterEntity getUnitDataByUnitName(String unitName);
	
	/**
	 * Delete unit by unit id.
	 *
	 * @param unitId the unit id
	 * @return true, if successful
	 */
	boolean deleteUnitByUnitId(String unitId);

	/**
	 * Gets the all unit data.
	 *
	 * @return the all unit data
	 */
	List<UnitMasterEntity> getAllUnitData();
}
