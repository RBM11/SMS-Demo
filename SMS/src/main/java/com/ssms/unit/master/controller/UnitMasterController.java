package com.ssms.unit.master.controller;

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
import com.ssms.unit.master.beans.UnitInfo;
import com.ssms.unit.master.service.intf.UnitMasterService;

// TODO: Auto-generated Javadoc
/**
 * The Class UnitMasterController.
 */
@RestController
public class UnitMasterController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(UnitMasterController.class);
	
	/** The unit service. */
	@Autowired
	private UnitMasterService unitService;
	
	/**
	 * Save unit data.
	 *
	 * @param unitInfo the unit info
	 * @return the response entity
	 */
	@PostMapping("saveUnitData")
	public ResponseEntity<String> saveUnitData(@RequestBody UnitInfo unitInfo){
		HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
		String responseMessage = null;
		try {
			responseMessage = this.unitService.saveUnitDetails(unitInfo);
			if (StringContants.SUCCESS.equalsIgnoreCase(responseMessage)) {
				httpStatus = HttpStatus.OK;
			}

		} catch (final Exception e) {
			LOGGER.error("Exception in saveCategoryData()", e);
		}
		return new ResponseEntity<>(responseMessage, httpStatus);
	}
	
	
	/**
	 * Update unit data.
	 *
	 * @param unitInfo the unit info
	 * @return the response entity
	 */
	@PutMapping("updateUnitData")
	public ResponseEntity<String> updateUnitData(@RequestBody UnitInfo unitInfo){
		HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
		String responseMessage = null;
		try {
			responseMessage = this.unitService.updateUnitDetails(unitInfo);
			if (StringContants.SUCCESS.equalsIgnoreCase(responseMessage)) {
				httpStatus = HttpStatus.OK;
			}

		} catch (final Exception e) {
			LOGGER.error("Exception in updateUnitData()", e);
		}
		return new ResponseEntity<>(responseMessage, httpStatus);
	}
	
	
	/**
	 * Delete unit data.
	 *
	 * @param unitId the unit id
	 * @return the response entity
	 */
	@DeleteMapping("deleteUnitData")
	public ResponseEntity<String> deleteUnitData(@RequestBody String unitId){
		HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
		String responseMessage = null;
		try {
			responseMessage = this.unitService.deleteUnitByUnitId(unitId);
			if (StringContants.SUCCESS.equalsIgnoreCase(responseMessage)) {
				httpStatus = HttpStatus.OK;
			}

		} catch (final Exception e) {
			LOGGER.error("Exception in deleteUnitData()", e);
		}
		return new ResponseEntity<>(responseMessage, httpStatus);
	}
	
	
	/**
	 * Gets the all unit data.
	 *
	 * @return the all unit data
	 */
	@GetMapping("getAllUnitData")
	public ResponseEntity<List<UnitInfo>> getAllUnitData(){
		List<UnitInfo> unitInfoList = new ArrayList<>();
		try {
			unitInfoList = this.unitService.getAllUnitData();
		} catch (final Exception e) {
			LOGGER.error("Exception in getAllUnitData()", e);
		}		
		return new ResponseEntity<>(unitInfoList, HttpStatus.OK);
	}
}
