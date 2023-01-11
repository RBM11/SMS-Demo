package com.ssms.category.master.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssms.category.master.beans.CategoryInfo;
import com.ssms.category.master.dao.intf.CategoryMasterDao;
import com.ssms.category.master.dao.model.CategoryMasterEntity;
import com.ssms.category.master.service.intf.CategoryMasterService;
import com.ssms.common.model.RecordDetails;
import com.ssms.constants.StringContants;

/**
 * The Class CategoryMasterServiceImpl.
 */
@Service
public class CategoryMasterServiceImpl implements CategoryMasterService {

	/** The category master dao. */
	@Autowired
	private CategoryMasterDao categoryMasterDao;
	
	/**
	 * Save category details.
	 *
	 * @param categoryInfo the category info
	 * @return the string
	 */
	@Override
	public String saveCategoryDetails(CategoryInfo categoryInfo) {
		String message = "Fail to save catetgory data";
		if(categoryInfo != null) {
			
			CategoryMasterEntity categoryEntity = this.categoryMasterDao.getCategoryDataByCategoryName(categoryInfo.getCategoryName());
			if(categoryEntity != null) {
				message = "catetgory already exist";
			}else {
				categoryEntity = new CategoryMasterEntity();
				BeanUtils.copyProperties(categoryInfo, categoryEntity);
				categoryEntity.setCategoryId(UUID.randomUUID().toString());
				final RecordDetails records = new RecordDetails();
				records.setCreatedBy(null);
				records.setCreatedOn(new Timestamp(System.currentTimeMillis()));
				
				final boolean status = this.categoryMasterDao.saveCategoryDetails(categoryEntity);
				if(status) {
					message = StringContants.SUCCESS;
				}
			}
		}
		return message;
	}

	/**
	 * Update category details.
	 *
	 * @param categoryInfo the category info
	 * @return the string
	 */
	@Override
	public String updateCategoryDetails(CategoryInfo categoryInfo) {
		String message = "Fail to update catetgory data";
		if(categoryInfo != null && categoryInfo.getCategoryId() != null) {
			
			CategoryMasterEntity categoryEntity = this.categoryMasterDao.getCategoryDataByCategoryName(categoryInfo.getCategoryName());
			if(categoryEntity != null && !categoryInfo.getCategoryId().equalsIgnoreCase(categoryEntity.getCategoryId())) {
				message = "catetgory already exist";
			}else {
				categoryEntity = new CategoryMasterEntity();
				BeanUtils.copyProperties(categoryInfo, categoryEntity);
				final RecordDetails records = categoryEntity.getRecordInfo();
				records.setModifiedBy(null);
				records.setModifiedOn(new Timestamp(System.currentTimeMillis()));
				
				final boolean status = this.categoryMasterDao.updateCategoryDetails(categoryEntity);
				if(status) {
					message = StringContants.SUCCESS;
				}

			}
			
		}
		return message;

	}

	/**
	 * Delete category by category id.
	 *
	 * @param categoryId the category id
	 * @return the string
	 */
	@Override
	public String deleteCategoryByCategoryId(String categoryId) {
		String message = "Fail to delete catetgory data";
		if(categoryId != null) {
			final boolean status = this.categoryMasterDao.deleteCategoryByCategoryId(categoryId);
			if(status) {
				message = StringContants.SUCCESS;
			}

		}
		return message;
	}

	/**
	 * Gets the all category data.
	 *
	 * @return the all category data
	 */
	@Override
	public List<CategoryInfo> getAllCategoryData() {
		final List<CategoryInfo> categoryInfoList = new ArrayList<>();
		final List<CategoryMasterEntity> categoryEntityList = this.categoryMasterDao.getAllCategoryData();
		for (final CategoryMasterEntity categoryMasterEntity : categoryEntityList) {
			final CategoryInfo categoryInfo = new CategoryInfo();
			BeanUtils.copyProperties(categoryMasterEntity, categoryInfo);
			categoryInfoList.add(categoryInfo);
		}
		return categoryInfoList;
	}

}
