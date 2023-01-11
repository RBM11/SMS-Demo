package com.ssms.unit.master.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssms.common.model.RecordDetails;
import com.ssms.constants.StringContants;
import com.ssms.unit.master.beans.UnitInfo;
import com.ssms.unit.master.dao.intf.UnitMasterDao;
import com.ssms.unit.master.dao.model.UnitMasterEntity;
import com.ssms.unit.master.service.intf.UnitMasterService;

/**
 * The Class UnitMasterServiceImpl.
 */
@Service
public class UnitMasterServiceImpl implements UnitMasterService{

	/** The unit master dao. */
	@Autowired
	private UnitMasterDao unitMasterDao;

	/**
	 * Save unit details.
	 *
	 * @param unitInfo the unit info
	 * @return the string
	 */
	@Override
	public String saveUnitDetails(UnitInfo unitInfo) {
		String message = "Fail to save unit data";
		if(unitInfo != null) {
			
			UnitMasterEntity unitEntity = this.unitMasterDao.getUnitDataByUnitName(unitInfo.getUnitName());
			if(unitEntity != null && !unitInfo.getUnitId().equalsIgnoreCase(unitEntity.getUnitId())) {
				message = "unit already exist";
			}else {
				unitEntity = new UnitMasterEntity();
				BeanUtils.copyProperties(unitInfo, unitEntity);
				unitEntity.setUnitId(UUID.randomUUID().toString());
				final RecordDetails records = unitEntity.getRecordInfo();
				records.setModifiedBy(null);
				records.setModifiedOn(new Timestamp(System.currentTimeMillis()));
				
				final boolean status = this.unitMasterDao.saveUnitDetails(unitEntity);
				if(status) {
					message = StringContants.SUCCESS;
				}

			}
			
		}
		return message;
	}

	/**
	 * Update unit details.
	 *
	 * @param unitInfo the unit info
	 * @return the string
	 */
	@Override
	public String updateUnitDetails(UnitInfo unitInfo) {
		String message = "Fail to update unit data";
		if(unitInfo != null && unitInfo.getUnitId() != null) {
			
			UnitMasterEntity unitEntity = this.unitMasterDao.getUnitDataByUnitName(unitInfo.getUnitName());
			if(unitEntity != null && !unitInfo.getUnitId().equalsIgnoreCase(unitEntity.getUnitId())) {
				message = "unit already exist";
			}else {
				unitEntity = new UnitMasterEntity();
				BeanUtils.copyProperties(unitInfo, unitEntity);
				final RecordDetails records = unitEntity.getRecordInfo();
				records.setModifiedBy(null);
				records.setModifiedOn(new Timestamp(System.currentTimeMillis()));				
				final boolean status = this.unitMasterDao.updateUnitDetails(unitEntity);
				if(status) {
					message = StringContants.SUCCESS;
				}
			}
		}
		return message;
	}

	/**
	 * Delete unit by unit id.
	 *
	 * @param unitId the unit id
	 * @return the string
	 */
	@Override
	public String deleteUnitByUnitId(String unitId) {
		String message = "Fail to delete unit data";
		if(unitId != null) {
			final boolean status = this.unitMasterDao.deleteUnitByUnitId(unitId);
			if(status) {
				message = StringContants.SUCCESS;
			}

		}
		return message;
	}

	/**
	 * Gets the all unit data.
	 *
	 * @return the all unit data
	 */
	@Override
	public List<UnitInfo> getAllUnitData() {
		final List<UnitInfo> unitInfoList = new ArrayList<>();
		final List<UnitMasterEntity> unitEntityList = this.unitMasterDao.getAllUnitData();
		for (final UnitMasterEntity unitMasterEntity : unitEntityList) {
			final UnitInfo unitInfo = new UnitInfo();
			BeanUtils.copyProperties(unitMasterEntity, unitInfo);
			unitInfoList.add(unitInfo);
		}
		return unitInfoList;
	}
	


}
