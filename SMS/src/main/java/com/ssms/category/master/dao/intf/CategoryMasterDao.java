package com.ssms.category.master.dao.intf;

import java.util.List;

import com.ssms.category.master.dao.model.CategoryMasterEntity;

/**
 * The Interface CategoryMasterDao.
 */
public interface CategoryMasterDao {

	/**
	 * Save category details.
	 *
	 * @param categoryInfo the category info
	 * @return true, if successful
	 */
	boolean saveCategoryDetails(CategoryMasterEntity categoryInfo);
	
	/**
	 * Update category details.
	 *
	 * @param categoryInfo the category info
	 * @return true, if successful
	 */
	boolean updateCategoryDetails(CategoryMasterEntity categoryInfo);
	
	/**
	 * Delete category by category id.
	 *
	 * @param categoryId the category id
	 * @return true, if successful
	 */
	boolean deleteCategoryByCategoryId(String categoryId);

	/**
	 * Gets the all category data.
	 *
	 * @return the all category data
	 */
	List<CategoryMasterEntity> getAllCategoryData();
	
	/**
	 * Gets the category data by category name.
	 *
	 * @param categoryName the category name
	 * @return the category data by category name
	 */
	CategoryMasterEntity getCategoryDataByCategoryName(String categoryName);
}
