package com.ssms.unit.master.service.intf;

import java.util.List;

import com.ssms.unit.master.beans.UnitInfo;

/**
 * The Interface UnitMasterService.
 */
public interface UnitMasterService {
	
	/**
	 * Save unit details.
	 *
	 * @param unitInfo the unit info
	 * @return the string
	 */
	String saveUnitDetails(UnitInfo unitInfo);
	
	/**
	 * Update unit details.
	 *
	 * @param unitInfo the unit info
	 * @return the string
	 */
	String updateUnitDetails(UnitInfo unitInfo);
	
	/**
	 * Delete unit by unit id.
	 *
	 * @param unitId the unit id
	 * @return the string
	 */
	String deleteUnitByUnitId(String unitId);

	/**
	 * Gets the all unit data.
	 *
	 * @return the all unit data
	 */
	List<UnitInfo> getAllUnitData();

}
