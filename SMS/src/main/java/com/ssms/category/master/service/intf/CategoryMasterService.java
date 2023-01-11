package com.ssms.category.master.service.intf;

import java.util.List;

import com.ssms.category.master.beans.CategoryInfo;

/**
 * The Interface CategoryMasterService.
 */
public interface CategoryMasterService {

	/**
	 * Save category details.
	 *
	 * @param categoryInfo the category info
	 * @return the string
	 */
	String saveCategoryDetails(CategoryInfo categoryInfo);
	
	/**
	 * Update category details.
	 *
	 * @param categoryInfo the category info
	 * @return the string
	 */
	String updateCategoryDetails(CategoryInfo categoryInfo);
	
	/**
	 * Delete category by category id.
	 *
	 * @param categoryId the category id
	 * @return the string
	 */
	String deleteCategoryByCategoryId(String categoryId);
	
	/**
	 * Gets the all category data.
	 *
	 * @return the all category data
	 */
	List<CategoryInfo> getAllCategoryData();
}
